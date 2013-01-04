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
package org.thryft.protocol;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TList;
import org.apache.thrift.protocol.TStruct;
import org.apache.thrift.protocol.TType;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import au.com.bytecode.opencsv.CSVReader;

import com.google.common.collect.Lists;

public class CsvProtocol extends StackedProtocol {
    protected class FileReaderProtocol extends ReaderProtocol {
        protected class RowReaderProtocol extends ReaderProtocol {
            protected class SequenceColumnReaderProtocol extends ReaderProtocol {
                public SequenceColumnReaderProtocol(final String[] elements) {
                    this.elements = elements;
                    currentElementI = 0;
                }

                @Override
                public TList readListBegin() throws TException {
                    throw new IllegalStateException();
                }

                @Override
                public String readString() throws TException {
                    return elements[currentElementI++];
                }

                private int currentElementI;
                private final String[] elements;
            }

            public RowReaderProtocol(final String[] columnNames,
                    final String[] columnValues) {
                this.columnNames = columnNames;
                this.columnValues = columnValues;
                currentColumnI = 0;
            }

            @Override
            public TField readFieldBegin() throws TException {
                if (currentColumnI < columnValues.length) {
                    return _readFieldBegin();
                } else {
                    return new TField();
                }
            }

            @Override
            public void readFieldEnd() {
                currentColumnI++;
            }

            @Override
            public TList readListBegin() throws TException {
                return _readListBegin(readString());
            }

            @Override
            public String readString() {
                return _getCurrentColumnValue();
            }

            @Override
            public TStruct readStructBegin() {
                // Assume a struct will read inline
                _getProtocolStack().push(this);
                return new TStruct();
            }

            protected Protocol _createSequenceColumn(final String[] elements) {
                return new SequenceColumnReaderProtocol(elements);
            }

            protected String _getCurrentColumnName() {
                return columnNames[currentColumnI];
            }

            protected String _getCurrentColumnValue() {
                return columnValues[currentColumnI];
            }

            protected TField _readFieldBegin() throws TException {
                return new TField(_getCurrentColumnName(), TType.STRING,
                        (short) 0);
            }

            protected TList _readListBegin(final String list) throws TException {
                final CSVReader listReader = new CSVReader(new StringReader(
                        list));
                String[] listElements;
                try {
                    listElements = listReader.readNext();
                    if (listElements == null) {
                        listElements = new String[0];
                    }
                } catch (final IOException e) {
                    listElements = new String[0];
                } finally {
                    try {
                        listReader.close();
                    } catch (final IOException e) {
                        throw new TException(e);
                    }
                }
                _getProtocolStack().push(_createSequenceColumn(new String[0]));
                return new TList(TType.STRING, 0);
            }

            protected String _readString(final String columnName) {
                for (int columnI = 0; columnI < columnNames.length; columnI++) {
                    if (columnNames[columnI].equals(columnName)) {
                        return columnValues[columnI];
                    }
                }

                return null;
            }

            private int currentColumnI;
            private final String[] columnNames;
            private final String[] columnValues;
        }

        public FileReaderProtocol(final List<String[]> rows) {
            this.rows = new Stack<Protocol>();
            Collections.reverse(rows);
            final String[] columnNames = rows.remove(rows.size() - 1);
            for (final String[] row : rows) {
                this.rows.push(_createRowReaderProtocol(columnNames, row));
            }
        }

        @Override
        public TList readListBegin() throws TException {
            return new TList(TType.STRUCT, rows.size());
        }

        @Override
        public String readString() throws TException {
            throw new IllegalStateException();
        }

        @Override
        public TStruct readStructBegin() throws TException {
            _getProtocolStack().push(rows.pop());
            return new TStruct();
        }

        protected Protocol _createRowReaderProtocol(final String[] columnNames,
                final String[] columnValues) {
            return new RowReaderProtocol(columnNames, columnValues);
        }

        private final Stack<Protocol> rows;
    }

    protected class ReaderProtocol extends Protocol {
        @Override
        public boolean readBool() throws TException {
            return readString().equals("1");
        }

        @Override
        public byte readByte() throws TException {
            return Byte.parseByte(readString());
        }

        @Override
        public double readDouble() throws TException {
            return Double.parseDouble(readString());
        }

        @Override
        public short readI16() throws TException {
            return Short.parseShort(readString());
        }

        @Override
        public int readI32() throws TException {
            return Integer.parseInt(readString());
        }

        @Override
        public long readI64() throws TException {
            final String value = readString();
            try {
                return Long.parseLong(value);
            } catch (final NumberFormatException e) {
                return dateTimeFormatter.parseMillis(value);
            }
        }
    }

    public CsvProtocol(final Reader reader) {
        final CSVReader csvReader = new CSVReader(reader);
        List<String[]> rows;
        try {
            try {
                rows = csvReader.readAll();
            } catch (final IOException e) {
                rows = Lists.newArrayList();
            }
        } finally {
            try {
                csvReader.close();
            } catch (final IOException e) {
            }
        }

        _getProtocolStack().add(_createFileReaderProtocol(rows));
    }

    protected Protocol _createFileReaderProtocol(final List<String[]> rows) {
        return new FileReaderProtocol(rows);
    }

    private final static DateTimeFormatter dateTimeFormatter = DateTimeFormat
            .forPattern("yyyy-MM-dd HH:mm:ss");
}
