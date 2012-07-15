from thryft.target.container_types.list_type import ListType
from thryft.target.field import Field
from thryft.targets.py.container_types.py_list_type import PyListType
from thryft.targets.py.py_construct import PyConstruct
from yutil import quote


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

    def py_from_json_object(self, json_object_variable_name):
        name = self.name
        py_name = self.py_name()
        if isinstance(self.type, PyListType):
            from_json_object = self.type.py_from_json_object(py_name + '_item')
            return """init_kwds['%(py_name)s'] = tuple([%(from_json_object)s for %(py_name)s_item in %(json_object_variable_name)s.get('%(name)s', [])])""" % locals()
        elif self.required:
            return "init_kwds['%(py_name)s'] = " % locals() + \
                        self.type.py_from_json_object("%(json_object_variable_name)s['%(name)s']" % locals())
        else:
            from_json_object = self.type.py_from_json_object(py_name)
            return """\
%(py_name)s = %(json_object_variable_name)s.get('%(name)s')
if %(py_name)s is not None:
    init_kwds['%(py_name)s'] = %(from_json_object)s""" % locals()

    def py_imports(self):
        if hasattr(self.type, 'py_imports'):
            return self.type.py_imports()
        return []

    def py_initializer(self):
        lhs = 'self.__' + self.py_name()
        rhs = self.py_name()
        if isinstance(self.type, ListType):
            rhs = "%(rhs)s is not None and tuple(%(rhs)s) or None" % locals()
        return "%(lhs)s = %(rhs)s" % locals()

    def py_parameter(self):
        if not self.required:
            if self.value is not None:
                return self.py_name() + '=' + str(self.py_value())
            else:
                return self.py_name() + '=None'
        else:
            return self.py_name()

    def py_value(self):
        if self.value is None:
            return None
        if isinstance(self.value, str):
            return quote(self.value)
        else:
            return self.value

    def __repr__(self):
        return self.py_parameter()
