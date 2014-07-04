from thryft.generator.struct_type import StructType
from thryft.generators.sql._sql_compound_type import _SqlCompoundType
from yutil import decamelize, lpad


class SqlStructType(StructType, _SqlCompoundType):
    def sql_create_table(self):
        column_definitions = []
        for field in self.fields:
            column_definition = field.sql_column_definition()
            if column_definition is not None:
                column_definitions.append(column_definition)
        column_definitions = lpad(",\n    ", ",\n    ".join(column_definitions))
        name = decamelize(self.name)
        return """\
CREATE TABLE IF NOT EXISTS %(name)s(
    id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL%(column_definitions)s
)""" % locals()

    def sql_name(self):
        return None