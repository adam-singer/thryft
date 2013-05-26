/*******************************************************************************
 * Copyright (c) 2013, Minor Gordon
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in
 *       the documentation and/or other materials provided with the
 *       distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND
 * CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES,
 * INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL  DAMAGES (INCLUDING,
 * BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY
 * OF SUCH DAMAGE.
 ******************************************************************************/

package org.thryft.store;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Set;

import org.h2.jdbcx.JdbcConnectionPool;
import org.thryft.TBase;
import org.thryft.protocol.JsonProtocol;

import com.google.common.base.CaseFormat;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

public final class JdbcStore<ModelT extends TBase<?>> extends
        AbstractStore<ModelT> {
    public final static class Configuration {
        public Configuration() {
            this(PASSWORD_DEFAULT, URL_DEFAULT, USER_DEFAULT);
        }

        public Configuration(final File filePath) {
            this(filePath, PASSWORD_DEFAULT, USER_DEFAULT);
        }

        public Configuration(final File filePath, final String password,
                final String user) {
            this(password, "jdbc:h2:" + filePath.toString()
                    + ";TRACE_LEVEL_FILE=0;TRACE_LEVEL_SYSTEM_OUT=0",
                    USER_DEFAULT);
        }

        public Configuration(final Properties properties) {
            user = properties.getProperty(this.getClass().getCanonicalName()
                    + ".password");
            if (user == null) {
                user = PASSWORD_DEFAULT;
            }

            url = properties.getProperty(this.getClass().getCanonicalName()
                    + ".url");
            if (url == null) {
                url = URL_DEFAULT;
            }

            user = properties.getProperty(this.getClass().getCanonicalName()
                    + ".user");
            if (user == null) {
                user = USER_DEFAULT;
            }
        }

        public Configuration(final String password, final String url,
                final String user) {
            this.password = checkNotNull(password);
            this.url = checkNotNull(url);
            this.user = checkNotNull(user);
        }

        public String getPassword() {
            return password;
        }

        public String getUrl() {
            return url;
        }

        public String getUser() {
            return user;
        }

        public final static String PASSWORD_DEFAULT = "";
        public final static String URL_DEFAULT = "jdbc:h2:yogento;TRACE_LEVEL_FILE=0;TRACE_LEVEL_SYSTEM_OUT=0";
        public final static String USER_DEFAULT = "yogento";

        private String password;
        private String user;
        private String url;
    }

    public JdbcStore(final Configuration configuration,
            final Class<ModelT> modelClass) {
        super(modelClass);
        checkNotNull(configuration);

        connectionPool = JdbcConnectionPool.create(configuration.getUrl(),
                configuration.getUser(), configuration.getPassword());

        tableName = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE,
                modelClass.getSimpleName());
        final String createTableSql = "CREATE TABLE IF NOT EXISTS "
                + tableName
                + " (id int NOT NULL AUTO_INCREMENT, "
                + tableName
                + "_id VARCHAR(255) NOT NULL, "
                + tableName
                + "_json TEXT NOT NULL, userId VARCHAR(255) NOT NULL, PRIMARY KEY (id));";
        deleteModelByIdSql = "DELETE FROM " + tableName + " WHERE " + tableName
                + "_id = ? AND userId = ?";
        deleteModelsSql = "DELETE FROM " + tableName + " WHERE userId = ?";
        getModelByIdSql = "SELECT * FROM " + tableName + " WHERE " + tableName
                + "_id = ? AND userId = ?";
        getModelCountSql = "SELECT COUNT(*) FROM " + tableName
                + " WHERE userId = ?";
        getModelIdsSql = "SELECT " + tableName + "_id FROM " + tableName
                + " WHERE userId = ?";
        getModelsSql = "SELECT * FROM " + tableName + " WHERE userId = ?";
        getUsernameSql = "SELECT userId FROM " + tableName;
        headModelByIdSql = "SELECT " + tableName + "_id FROM " + tableName
                + " WHERE " + tableName + "_id = ? AND userId = ?";
        putModelSql = "INSERT INTO " + tableName + " VALUES (NULL, ?, ?, ?)";

        try {
            final Connection connection = connectionPool.getConnection();
            try {
                final Statement statement = connection.createStatement();
                try {
                    statement.execute(createTableSql);
                } finally {
                    statement.close();
                }
            } finally {
                connection.close();
            }
        } catch (final SQLException e) {
            logger.error("exception creating table: ", e);
        }
    }

    public void dispose() {
        connectionPool.dispose();
    }

    @Override
    protected boolean _deleteModelById(final String modelId, final String userId) {
        try {
            final Connection connection = connectionPool.getConnection();
            final boolean existed = __headModelById(connection, modelId, userId);
            try {
                __deleteModelById(connection, modelId, userId);
                return existed;
            } finally {
                connection.close();
            }
        } catch (final SQLException e) {
            logger.error("exception deleting model " + modelId + ": ", e);
            return false;
        }
    }

    @Override
    protected void _deleteModels(final String userId) {
        try {
            final Connection connection = connectionPool.getConnection();
            try {
                final PreparedStatement statement = connection
                        .prepareStatement(deleteModelsSql);
                try {
                    statement.setString(1, userId);
                    statement.execute();
                } finally {
                    statement.close();
                }
            } finally {
                connection.close();
            }
        } catch (final SQLException e) {
            logger.error("error deleting models: ", e);
        }
    }

    @Override
    protected ModelT _getModelById(final String modelId, final String userId)
            throws ModelIoException, NoSuchModelException {
        try {
            final Connection connection = connectionPool.getConnection();
            try {
                final PreparedStatement statement = connection
                        .prepareStatement(getModelByIdSql);
                try {
                    statement.setString(1, modelId);
                    statement.setString(2, userId);
                    final ResultSet resultSet = statement.executeQuery();
                    try {
                        if (resultSet.next()) {
                            return __getModel(resultSet);
                        } else {
                            throw new NoSuchModelException(modelId);
                        }
                    } finally {
                        resultSet.close();
                    }
                } finally {
                    statement.close();
                }
            } finally {
                connection.close();
            }
        } catch (final SQLException e) {
            logger.error("exception getting model " + modelId + ": ", e);
            throw new NoSuchModelException(modelId);
        }
    }

    @Override
    protected int _getModelCount(final String userId) {
        try {
            final Connection connection = connectionPool.getConnection();
            try {
                final PreparedStatement statement = connection
                        .prepareStatement(getModelCountSql);
                try {
                    statement.setString(1, userId);
                    final ResultSet resultSet = statement.executeQuery();
                    try {
                        if (resultSet.next()) {
                            return resultSet.getInt(1);
                        } else {
                            return 0;
                        }
                    } finally {
                        resultSet.close();
                    }
                } finally {
                    statement.close();
                }
            } finally {
                connection.close();
            }
        } catch (final SQLException e) {
            logger.error("exception getting model count: ", e);
            return 0;
        }
    }

    @Override
    protected ImmutableSet<String> _getModelIds(final String userId) {
        try {
            final Connection connection = connectionPool.getConnection();
            try {
                final PreparedStatement statement = connection
                        .prepareStatement(getModelIdsSql);
                try {
                    statement.setString(1, userId);
                    final ResultSet resultSet = statement.executeQuery();
                    try {
                        final ImmutableSet.Builder<String> modelIds = ImmutableSet
                                .builder();
                        while (resultSet.next()) {
                            modelIds.add(resultSet.getString(1));
                        }
                        return modelIds.build();
                    } finally {
                        resultSet.close();
                    }
                } finally {
                    statement.close();
                }
            } finally {
                connection.close();
            }
        } catch (final SQLException e) {
            logger.error("exception getting model ids: ", e);
            return ImmutableSet.of();
        }
    }

    @Override
    protected ImmutableMap<String, ModelT> _getModels(final String userId)
            throws ModelIoException {
        try {
            final Connection connection = connectionPool.getConnection();
            try {
                final PreparedStatement statement = connection
                        .prepareStatement(getModelsSql);
                try {
                    statement.setString(1, userId);
                    final ResultSet resultSet = statement.executeQuery();
                    try {
                        final ImmutableMap.Builder<String, ModelT> models = ImmutableMap
                                .builder();
                        while (resultSet.next()) {
                            models.put(__getModelId(resultSet),
                                    __getModel(resultSet));
                        }
                        return models.build();
                    } finally {
                        resultSet.close();
                    }
                } finally {
                    statement.close();
                }
            } finally {
                connection.close();
            }
        } catch (final SQLException e) {
            logger.error("exception getting models: ", e);
            return ImmutableMap.of();
        }
    }

    @Override
    protected ImmutableMap<String, ModelT> _getModelsByIds(
            final ImmutableSet<String> modelIds, final String userId)
            throws ModelIoException, NoSuchModelException {
        final StringBuilder getModelsByIdsSqlBuilder = new StringBuilder();
        getModelsByIdsSqlBuilder.append("SELECT * FROM ");
        getModelsByIdsSqlBuilder.append(tableName);
        getModelsByIdsSqlBuilder.append(" WHERE userId = ? AND ");
        getModelsByIdsSqlBuilder.append(tableName);
        getModelsByIdsSqlBuilder.append("_id IN (");
        for (int modelI = 0; modelI < modelIds.size(); modelI++) {
            if (modelI > 0) {
                getModelsByIdsSqlBuilder.append(", ?");
            } else {
                getModelsByIdsSqlBuilder.append("?");
            }
        }
        getModelsByIdsSqlBuilder.append(")");
        final String getModelsByIdsSql = getModelsByIdsSqlBuilder.toString();

        try {
            final Connection connection = connectionPool.getConnection();
            try {
                final PreparedStatement statement = connection
                        .prepareStatement(getModelsByIdsSql);
                try {
                    statement.setString(1, userId);
                    int parameterIndex = 2;
                    for (final String modelId : modelIds) {
                        statement.setString(parameterIndex, modelId);
                        parameterIndex++;
                    }

                    final ResultSet resultSet = statement.executeQuery();
                    try {
                        final ImmutableMap.Builder<String, ModelT> modelsBuilder = ImmutableMap
                                .builder();
                        while (resultSet.next()) {
                            modelsBuilder.put(__getModelId(resultSet),
                                    __getModel(resultSet));
                        }
                        final ImmutableMap<String, ModelT> models = modelsBuilder
                                .build();

                        if (models.keySet().equals(modelIds)) {
                            return models;
                        } else {
                            final Set<String> missingModelIds = Sets
                                    .newHashSet(modelIds);
                            missingModelIds.removeAll(models.keySet());
                            final String missingModelId = missingModelIds
                                    .iterator().next();
                            throw new NoSuchModelException(missingModelId);
                        }
                    } finally {
                        resultSet.close();
                    }
                } finally {
                    statement.close();
                }
            } finally {
                connection.close();
            }
        } catch (final SQLException e) {
            throw new ModelIoException(e);
        }
    }

    @Override
    protected ImmutableSet<String> _getUserIds() {
        try {
            final Connection connection = connectionPool.getConnection();
            try {
                final Statement statement = connection.createStatement();
                try {
                    final ResultSet resultSet = statement
                            .executeQuery(getUsernameSql);
                    try {
                        final ImmutableSet.Builder<String> userIds = ImmutableSet
                                .builder();
                        while (resultSet.next()) {
                            userIds.add(resultSet.getString(1));
                        }
                        return userIds.build();
                    } finally {
                        resultSet.close();
                    }
                } finally {
                    statement.close();
                }
            } finally {
                connection.close();
            }
        } catch (final SQLException e) {
            logger.error("exception getting userIds: ", e);
            return ImmutableSet.of();
        }
    }

    @Override
    protected boolean _headModelById(final String modelId, final String userId) {
        try {
            final Connection connection = connectionPool.getConnection();
            try {
                return __headModelById(connection, modelId, userId);
            } finally {
                connection.close();
            }
        } catch (final SQLException e) {
            logger.error("exception heading model by id: ", e);
            return false;
        }
    }

    @Override
    protected void _putModel(final ModelT model, final String modelId,
            final String userId) throws ModelIoException {
        try {
            final Connection connection = connectionPool.getConnection();
            try {
                connection.setAutoCommit(false);
                final PreparedStatement statement = connection
                        .prepareStatement(putModelSql);
                try {
                    __putModel(connection, model, modelId, statement, userId);
                } finally {
                    statement.close();
                }
                connection.commit();
            } finally {
                connection.close();
            }
        } catch (final SQLException e) {
            throw new ModelIoException(e);
        }
    }

    @Override
    protected void _putModels(final ImmutableMap<String, ModelT> models,
            final String userId) throws ModelIoException {
        try {
            final Connection connection = connectionPool.getConnection();
            try {
                connection.setAutoCommit(false);
                final PreparedStatement statement = connection
                        .prepareStatement(putModelSql);
                try {
                    for (final ImmutableMap.Entry<String, ModelT> model : models
                            .entrySet()) {
                        __putModel(connection, model.getValue(),
                                model.getKey(), statement, userId);
                    }
                } finally {
                    statement.close();
                }
                connection.commit();
            } finally {
                connection.close();
            }
        } catch (final SQLException e) {
            throw new ModelIoException(e);
        }
    }

    private void __deleteModelById(final Connection connection,
            final String modelId, final String userId) throws SQLException {
        final PreparedStatement statement = connection
                .prepareStatement(deleteModelByIdSql);
        try {
            statement.setString(1, modelId);
            statement.setString(2, userId);
            statement.execute();
        } finally {
            statement.close();
        }
    }

    private ModelT __getModel(final ResultSet resultSet)
            throws ModelIoException {
        try {
            return _getModel(new JsonProtocol(new StringReader(
                    resultSet.getString(tableName + "_json"))));
        } catch (final IOException e) {
            throw new ModelIoException(e.getMessage());
        } catch (final SQLException e) {
            throw new ModelIoException(e.getMessage());
        }
    }

    private String __getModelId(final ResultSet resultSet) throws SQLException {
        return resultSet.getString(tableName + "_id");
    }

    private boolean __headModelById(final Connection connection,
            final String modelId, final String userId) {
        try {
            final PreparedStatement statement = connection
                    .prepareStatement(headModelByIdSql);
            try {
                statement.setString(1, modelId);
                statement.setString(2, userId);
                final ResultSet resultSet = statement.executeQuery();
                try {
                    return resultSet.next();
                } finally {
                    resultSet.close();
                }
            } finally {
                statement.close();
            }
        } catch (final SQLException e) {
            logger.error("error heading model: ", e);
            return false;
        }
    }

    private void __putModel(final Connection connection, final ModelT model,
            final String modelId, final PreparedStatement statement,
            final String userId) throws ModelIoException {
        try {
            __deleteModelById(connection, modelId, userId);
            final StringWriter stringWriter = new StringWriter();
            final JsonProtocol oprot = new JsonProtocol(stringWriter);
            model.write(oprot);
            oprot.flush();
            final String json = stringWriter.toString();
            statement.setString(1, modelId);
            statement.setString(2, json);
            statement.setString(3, userId);
            statement.execute();
        } catch (final IOException e) {
            throw new ModelIoException(e, modelId);
        } catch (final SQLException e) {
            throw new ModelIoException(e, modelId);
        }
    }

    private final JdbcConnectionPool connectionPool;

    private final String deleteModelByIdSql;

    private final String deleteModelsSql;

    private final String getModelByIdSql;

    private final String getModelCountSql;

    private final String getModelIdsSql;

    private final String getModelsSql;

    private final String getUsernameSql;

    private final String headModelByIdSql;

    private final String putModelSql;

    private final String tableName;
}
