from thryft.generator.native_types.date_type import DateType
from thryft.generators.py.py_native_type import PyNativeType


class PyDateType(DateType, PyNativeType):
    def py_check(self, value):
        return "isinstance(%(value)s, datetime)" % locals()

    def py_imports(self, caller_stack=None):
        return ['from datetime import datetime', 'from time import mktime']

    def py_name(self):
        return 'datetime'

    def py_read_protocol(self):
        return "datetime.fromtimestamp(iprot.readI64() / 1000)"

    def py_read_protocol_throws(self):
        return ['TypeError']

    def py_write_protocol(self, value, depth=0):
        return "oprot.writeI64(long(mktime(%(value)s.timetuple())) * 1000l)" % locals()