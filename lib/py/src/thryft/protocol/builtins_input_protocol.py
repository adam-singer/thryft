#-------------------------------------------------------------------------------
# Copyright (c) 2013, Minor Gordon
# All rights reserved.
#
# Redistribution and use in source and binary forms, with or without
# modification, are permitted provided that the following conditions
# are met:
#
#     * Redistributions of source code must retain the above copyright
#       notice, this list of conditions and the following disclaimer.
#
#     * Redistributions in binary form must reproduce the above copyright
#       notice, this list of conditions and the following disclaimer in
#       the documentation and/or other materials provided with the
#       distribution.
#
# THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND
# CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES,
# INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
# MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
# DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
# CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
# SPECIAL, EXEMPLARY, OR CONSEQUENTIAL  DAMAGES (INCLUDING,
# BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
# SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
# INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
# LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
# (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
# OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY
# OF SUCH DAMAGE.
#-------------------------------------------------------------------------------

from decimal import Decimal
from thryft.protocol._abstract_input_protocol import _AbstractInputProtocol
from thryft.protocol._stacked_input_protocol import _StackedInputProtocol


class BuiltinsInputProtocol(_StackedInputProtocol):
    class _InputProtocol(_AbstractInputProtocol):
        def __init__(self, input_protocol_stack):
            _AbstractInputProtocol.__init__(self)
            self.__input_protocol_stack = input_protocol_stack

        def read_bool(self):
            return self._read_value(bool)

        def read_i32(self):
            return int(self._read_value((Decimal, int, long)))

        def read_i64(self):
            return long(self._read_value((Decimal, int, long)))

        def read_list_begin(self):
            list_ = self._read_value(list)
            self.__input_protocol_stack.append(BuiltinsInputProtocol._ListInputProtocol(list_, self.__input_protocol_stack))
            return None, len(list_)

        def read_map_begin(self):
            map_ = self._read_value(dict)
            self.__input_protocol_stack.append(BuiltinsInputProtocol._MapInputProtocol(map_, self.__input_protocol_stack))
            return None, None, len(map_)

        def read_string(self):
            return self._read_value((Decimal, float, str, unicode))

        def read_struct_begin(self):
            struct = self.__input_protocol_stack[-1]._read_value(dict)
            self.__input_protocol_stack.append(BuiltinsInputProtocol._StructInputProtocol(struct, self.__input_protocol_stack))

        def _read_value(self, expected_type=None):
            value = self._read_value_impl()
            if expected_type is not None and not isinstance(value, expected_type):
                raise TypeError("expected %s, got %s" % (expected_type, type(value)))
            return value

        def _read_value_impl(self):
            raise NotImplementedError

    class _ListInputProtocol(_InputProtocol):
        def __init__(self, list_, input_protocol_stack):
            BuiltinsInputProtocol._InputProtocol.__init__(self, input_protocol_stack)
            if not isinstance(list_, (list, tuple)):
                raise TypeError(type(list_))
            self.__index_stack = list(reversed(xrange(len(list_))))
            self.__list = list_

        def _read_value_impl(self):
            return self.__list[self.__index_stack.pop(-1)]

    class _MapInputProtocol(_InputProtocol):
        def __init__(self, dict_, input_protocol_stack):
            BuiltinsInputProtocol._InputProtocol.__init__(self, input_protocol_stack)
            if not isinstance(dict_, dict):
                raise TypeError(type(dict_))
            self.__dict = dict_
            self.__key_stack = list(reversed(sorted(dict_.keys())))
            self.__next_value_is_key = True

        def _read_value_impl(self):
            if self.__next_value_is_key:
                self.__next_value_is_key = False
                return self.__key_stack[-1]
            else:
                self.__next_value_is_key = True
                return self.__dict[self.__key_stack.pop(-1)]

    class _RootInputProtocol(_InputProtocol):
        def __init__(self, input_protocol_stack, root_builtin_object=None):
            BuiltinsInputProtocol._InputProtocol.__init__(self, input_protocol_stack)
            self.__root_builtin_object = root_builtin_object

        def _read_value_impl(self):
            return self.__root_builtin_object

    class _StructInputProtocol(_InputProtocol):
        def __init__(self, dict_, input_protocol_stack):
            BuiltinsInputProtocol._InputProtocol.__init__(self, input_protocol_stack)
            if not isinstance(dict_, dict):
                raise TypeError(type(dict_))
            self.__dict = dict_
            self.__field_name_stack = list(reversed(sorted(dict_.keys())))

        def read_field_begin(self):
            if len(self.__field_name_stack) == 0:
                return None, 0, None  # STOP
            assert isinstance(self.__field_name_stack[-1], basestring), self.__field_name_stack
            return self.__field_name_stack[-1], None, None

        def read_field_end(self):
            self.__field_name_stack.pop(-1)

        def _read_value_impl(self):
            return self.__dict[self.__field_name_stack[-1]]

    def __init__(self, root_builtin_object=None):
        _StackedInputProtocol.__init__(self)
        self._input_protocol_stack.append(BuiltinsInputProtocol._RootInputProtocol(self._input_protocol_stack, root_builtin_object))
