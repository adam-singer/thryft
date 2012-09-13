from thryft.generator.container_types.map_type import MapType
from thryft.generators.py.py_container_type import PyContainerType
from yutil import indent


class PyMapType(MapType, PyContainerType):
    def py_check(self, value):
        key_check = self.key_type.py_check('__key')
        value_check = self.value_type.py_check('__value')
        return "(isinstance(%(value)s, dict) and len(list(ifilterfalse(lambda __key, __value: %(key_check)s and %(value_check)s, %(value)s.iteritems()))) == 0)" % locals()

    def py_defensive_copy(self, value):
        return "%(value)s.copy()"

    def py_imports(self, caller_stack=None):
        if caller_stack is None:
            caller_stack = []
        elif self in caller_stack:
            return []
        caller_stack.append(self)

        imports = list(self.key_type.py_imports(caller_stack=caller_stack))
        imports.extend(self.value_type.py_imports(caller_stack=caller_stack))

        assert caller_stack[-1] is self
        caller_stack.pop(-1)

        return imports + ['from itertools import ifilterfalse']

    def py_read_protocol(self):
        key_read_protocol = self.key_type.py_read_protocol()
        value_read_protocol = self.value_type.py_read_protocol()
        return """dict([(%(key_read_protocol)s, %(value_read_protocol)s) for _ in xrange(iprot.readMapBegin()[1])] + (iprot.readMapEnd() is None and []))""" % locals()

    def py_write_protocol(self, value, depth=0):
        key_ttype_id = self.key_type.thrift_ttype_id()
        key_write_protocol = \
            indent(' ' * 4,
                self.key_type.py_write_protocol(
                    "__key%(depth)u" % locals(),
                    depth=depth + 1
                )
            )
        value_ttype_id = self.value_type.thrift_ttype_id()
        value_write_protocol = \
            indent(' ' * 4,
                self.value_type.py_write_protocol(
                    "__value%(depth)u" % locals(),
                    depth=depth + 1
                )
            )
        return """\
oprot.writeMapBegin(%(key_ttype_id)u, len(%(value)s), %(value_ttype_id)u)
for __key%(depth)u, __value%(depth)u in %(value)s.iteritems():
%(key_write_protocol)s
%(value_write_protocol)s
oprot.writeMapEnd()""" % locals()
