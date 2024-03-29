#------------------------------------------------------------------------------
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
#------------------------------------------------------------------------------

import thryft.protocol._abstract_output_protocol
from thryft.protocol._stacked_output_protocol import _StackedOutputProtocol


class BuiltinsOutputProtocol(_StackedOutputProtocol):
    class _OutputProtocol(thryft.protocol._abstract_output_protocol._AbstractOutputProtocol):
        def __init__(self, output_protocol_stack):
            thryft.protocol._output_protocol._OutputProtocol.__init__(self)
            self.__output_protocol_stack = output_protocol_stack

        def write_bool(self, value):
            self._write_value(value)

        def write_field_stop(self):
            pass

        def write_i32(self, value):
            self._write_value(value)

        def write_i64(self, value):
            self._write_value(value)

        def write_list_begin(self, *args, **kwds):
            list_ = []
            self._write_value(list_)
            self.__output_protocol_stack.append(BuiltinsOutputProtocol._ListOutputProtocol(list_, self.__output_protocol_stack))

        def write_list_end(self):
            pass

        def write_map_begin(self, *args, **kwds):
            map_ = {}
            self._write_value(map_)
            self.__output_protocol_stack.append(BuiltinsOutputProtocol._MapOutputProtocol(map_, self.__output_protocol_stack))

        def write_map_end(self):
            pass

        def write_null(self):
            self._write_value(None)

        def write_string(self, value):
            self._write_value(value)

        def write_struct_begin(self, *args, **kwds):
            struct = {}
            self._write_value(struct)
            self.__output_protocol_stack.append(BuiltinsOutputProtocol._StructOutputProtocol(struct, self.__output_protocol_stack))

        def write_struct_end(self):
            pass

        def _write_value(self, value):
            raise NotImplementedError

    class _ListOutputProtocol(_OutputProtocol):
        def __init__(self, list_, output_protocol_stack):
            if not isinstance(list_, (list, tuple)):
                raise TypeError(type(list_))
            BuiltinsOutputProtocol._OutputProtocol.__init__(self, output_protocol_stack)
            self.__list = list_

        def _write_value(self, value):
            self.__list.append(value)

    class _MapOutputProtocol(_OutputProtocol):
        def __init__(self, dict_, output_protocol_stack):
            if not isinstance(dict_, dict):
                raise TypeError(type(dict_))
            BuiltinsOutputProtocol._OutputProtocol.__init__(self, output_protocol_stack)
            self.__dict = dict_
            self.__next_key = None

        def _write_value(self, value):
            if self.__next_key is None:
                self.__next_key = value
            else:
                self.__dict[self.__next_key] = value
                self.__next_key = None

    class _RootOutputProtocol(_OutputProtocol):
        def __init__(self, *args, **kwds):
            BuiltinsOutputProtocol._OutputProtocol.__init__(self, *args, **kwds)
            self.__value = None

        @property
        def value(self):
            return self.__value

        def _write_value(self, value):
            self.__value = value

    class _StructOutputProtocol(_MapOutputProtocol):
        def __init__(self, dict_, output_protocol_stack):
            if not isinstance(dict_, dict):
                raise TypeError(type(dict_))
            BuiltinsOutputProtocol._OutputProtocol.__init__(self, output_protocol_stack)
            self.__dict = dict_
            self.__next_field_name = None

        def write_field_begin(self, name, *args, **kwds):
            self.__next_field_name = name

        def write_field_end(self):
            self.__next_field_name = None

        def _write_value(self, value):
            self.__dict[self.__next_field_name] = value

    def __init__(self):
        _StackedOutputProtocol.__init__(self)
        self._output_protocol_stack.append(BuiltinsOutputProtocol._RootOutputProtocol(self._output_protocol_stack))

    @property
    def value(self):
        return self._output_protocol_stack[0].value
