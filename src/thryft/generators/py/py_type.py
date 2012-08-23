from thryft.generators.py.py_construct import PyConstruct
from yutil import class_qname


class PyType(PyConstruct):
    def py_check(self, value):
        raise NotImplementedError(class_qname(self) + '.py_check')

    def py_read_protocol(self):
        raise NotImplementedError(class_qname(self) + '.py_read_protocol')

    def py_read_protocol_throws(self):
        return []

    def py_write_protocol(self, value, depth=0):
        raise NotImplementedError(class_qname(self) + '.py_write_protocol')