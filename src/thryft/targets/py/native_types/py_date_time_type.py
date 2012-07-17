from thryft.target.native_types.date_time_type import DateTimeType
from thryft.targets.py.py_native_type import PyNativeType


class PyDateTimeType(DateTimeType, PyNativeType):
    def py_check(self, value):
        return "isinstance(%(value)s, datetime)" % locals()

    def py_imports(self):
        return ['from calendar import timegm', 'from datetime import datetime']

    def py_name(self):
        return 'datetime'

    def py_read_protocol(self):
        return "datetime.fromtimestamp(iprot.readI64() / 1000)"

    def py_write_protocol(self, value, depth=0):
        return "oprot.writeI64(timegm(datetime.timetuple()))"