from decimal import Decimal
from thryft.protocol.protocol import Protocol


class BuiltinsProtocol(Protocol):
    def __init__(self, root_builtin_object=None):
        object.__init__(self)
        if root_builtin_object is not None:
            if isinstance(root_builtin_object, dict):
                root_builtin_object = root_builtin_object.copy()
            elif isinstance(root_builtin_object, (list, tuple)):
                root_builtin_object = list(root_builtin_object)
                root_builtin_object.reverse()
            else:
                raise TypeError(type(root_builtin_object))
            self._scope_stack = [[root_builtin_object]]
        else:
            self._scope_stack = []
        self.__field_name_stack = []

    def readFieldBegin(self):
        if len(self._scope_stack[-1]) == 0:
            return None, 0, None # STOP

        return self._scope_stack[-1].keys()[0], None, None

    def readBool(self):
        return self.__readValue(bool)

    def readI16(self):
        return self.readI32()

    def readI32(self):
        return int(self.__readValue((Decimal, int)))

    def readI64(self):
        return long(self.__readValue((Decimal, int, long)))

    def readFieldEnd(self):
        self._scope_stack[-1].pop(self._scope_stack[-1].keys()[0])

    def readListBegin(self):
        list_ = self.__readValue(list)
        self._scope_stack.append(list(reversed(list_)))
        return None, len(list_)

    def readListEnd(self):
        self._scope_stack.pop(-1)

    def readMapBegin(self):
        map_ = self.__readValue(dict)
        self._scope_stack.append(map_)
        return None, None, len(map_)

    def readMapEnd(self):
        self._scope_stack.pop(-1)

    def readSetBegin(self):
        return self.readListBegin()

    def readSetEnd(self):
        return self.readListEnd()

    def readString(self):
        return self.__readValue((Decimal, float, str, unicode))

    def readStructBegin(self):
        struct = self.__readValue(dict)
        self._scope_stack.append(struct)

    def readStructEnd(self):
        self._scope_stack.pop(-1)

    def __readValue(self, type_):
        scope = self._scope_stack[-1]
        if isinstance(scope, list):
            value = scope.pop(-1)
        else:
            value = scope.values()[0]
        if not isinstance(value, type_):
            raise TypeError("expected %s, got %s" % (type_, type(value)))
        return value

    def writeBool(self, value):
        self.__writeValue(value)

    def writeFieldBegin(self, name, *args, **kwds):
        self.__field_name_stack.append(name)

    def writeFieldEnd(self):
        self.__field_name_stack.pop(-1)

    def writeFieldStop(self):
        pass

    def writeI32(self, value):
        self.__writeValue(value)

    def writeI64(self, value):
        self.__writeValue(value)

    def writeListBegin(self, *args, **kwds):
        list_ = []
        if len(self._scope_stack) > 0:
            self.__writeValue(list_)
        self._scope_stack.append(list_)

    def writeListEnd(self):
        if len(self._scope_stack) > 1:
            self._scope_stack.pop(-1)

    def writeSetBegin(self, *args, **kwds):
        self.writeListBegin()

    def writeSetEnd(self):
        self.writeListEnd()

    def writeString(self, value):
        self.__writeValue(value)

    def writeStructBegin(self, name):
        struct = {}
        if len(self._scope_stack) > 0:
            self.__writeValue(struct)
        self._scope_stack.append(struct)

    def writeStructEnd(self):
        if len(self._scope_stack) > 1:
            self._scope_stack.pop(-1)

    def __writeValue(self, value):
        scope = self._scope_stack[-1]
        if isinstance(scope, list):
            scope.append(value)
        else:
            field_name = self.__field_name_stack[-1]
            scope[field_name] = value