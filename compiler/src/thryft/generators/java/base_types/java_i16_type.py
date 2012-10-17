from thryft.generator.base_types.i16_type import I16Type
from thryft.generators.java.java_base_type import JavaBaseType


class JavaI16Type(I16Type, JavaBaseType):
    def java_default_value(self):
        return '((short)0)'

    def java_hash_code(self, value):
        return "((int)%(value)s)" % locals()

    def java_read_protocol_throws(self):
        return ['NumberFormatException']

    def java_name(self, boxed=False):
        return boxed and 'Short' or 'short'

    def java_to_string(self, value):
        return "Short.toString(%(value)s)" % locals()
