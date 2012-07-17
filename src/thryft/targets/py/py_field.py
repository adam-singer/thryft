from thryft.target.container_types.list_type import ListType
from thryft.target.field import Field
from thryft.targets.py.py_construct import PyConstruct
from yutil import quote, indent


class PyField(Field, PyConstruct):
    def py_getter(self):
        name = self.py_name()
        return """\
@property
def %(name)s(self):
    return self.__%(name)s
""" % locals()

    def py_getter_name(self):
        return self.py_name()

    def py_imports(self):
        return self.type.py_imports()

    def py_initializer(self):
        name = self.py_name()
        type_check = self.type.py_check(name)
        rhs = self.py_name()
        return """\
if %(name)s is not None:
    if not %(type_check)s:
        raise TypeError(getattr(__builtins__, 'type')(%(name)s))
self.__%(name)s = %(name)s
""" % locals()

    def py_parameter(self):
        if not self.required:
            if self.value is not None:
                return self.py_name() + '=' + str(self.py_value())
            else:
                return self.py_name() + '=None'
        else:
            return self.py_name()

    def py_read_protocol(self):
        name = self.name
        read_protocol = self.type.py_read_protocol()
        read_protocol = "init_kwds['%(name)s'] = %(read_protocol)s" % locals()
        if not self.required:
            read_protocol = indent(' ' * 4, read_protocol)
            read_protocol = """\
try:
%(read_protocol)s
except (InvalidOperation, ValueError):
    pass
""" % locals()
        read_protocol = indent(' ' * 4, read_protocol)
        return """\
if ifield_name == '%(name)s':
%(read_protocol)s
""" % locals()

    def py_write_protocol(self, depth=0):
        id_ = self.id
        if id_ is None:
            id_ = -1
        name = self.name
        getter_name = self.py_getter_name()
        ttype_id = self.type.thrift_ttype_id()
        write_protocol = \
            self.type.py_write_protocol(
                'self.' + getter_name,
                depth=depth
            )
        write_protocol = """\
oprot.writeFieldBegin('%(name)s', %(ttype_id)u, %(id_)d)
%(write_protocol)s
oprot.writeFieldEnd()
""" % locals()
        if not self.required:
            write_protocol = indent(' ' * 4, write_protocol)
            write_protocol = """\
if self.%(getter_name)s is not None:
%(write_protocol)s
""" % locals()
        return write_protocol

    def py_value(self):
        if self.value is None:
            return None
        if isinstance(self.value, str):
            return quote(self.value)
        else:
            return self.value

    def __repr__(self):
        return self.py_parameter()