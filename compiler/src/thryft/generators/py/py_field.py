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

from thryft.generator.field import Field
from thryft.generators.py._py_named_construct import _PyNamedConstruct
from yutil import quote, indent


class PyField(Field, _PyNamedConstruct):
    def py_check(self):
        name = self.py_name()

        type_check = self.type.py_check(name)
        type_check = """\
if not %(type_check)s:
    raise TypeError(getattr(__builtin__, 'type')(%(name)s))""" % locals()

        if self.required:
            return """\
if %(name)s is None:
    raise ValueError('%(name)s is required')
%(type_check)s""" % locals()
        else:
            type_check = indent(' ' * 4, type_check)
            return """\
if %(name)s is not None:
%(type_check)s""" % locals()

    def py_getter(self):
        name = self.py_name()
        defensive_copy = self.type.py_defensive_copy('self.__' + name)
        return """\
@property
def %(name)s(self):
    return %(defensive_copy)s
""" % locals()

    def py_getter_call(self):
        return self.py_getter_name()

    def py_getter_name(self):
        return self.py_name()

    def _py_imports_use(self, caller_stack):
        return self.type.py_imports_use(caller_stack=caller_stack) + ['import __builtin__']

    def py_initializer(self):
        check = self.py_check()
        name = self.py_name()
        defensive_copy = self.type.py_defensive_copy(name)
        return """\
%(check)s
self.__%(name)s = %(defensive_copy)s
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
            read_protocol_throws = self.type.py_read_protocol_throws()
            if len(read_protocol_throws) > 0:
                read_protocol_throws = ', '.join(read_protocol_throws)
                read_protocol = indent(' ' * 4, read_protocol)
                read_protocol = """\
try:
%(read_protocol)s
except (%(read_protocol_throws)s,):
    pass
""" % locals()
        read_protocol = indent(' ' * 4, read_protocol)
        return """\
if ifield_name == '%(name)s':
%(read_protocol)s
""" % locals()

    def py_setter(self, return_type_name='void'):
        setter_name = self.py_setter_name()
        name = self.py_name()
        return """\
def %(setter_name)s(self, %(name)s):
    self.__%(name)s = %(name)s
    return self
""" % locals()

    def py_setter_name(self):
        return 'set_' + self.py_name()

    def py_write_protocol(self, depth=0):
        id_ = self.id
        if id_ is None:
            id_ = -1
        name = self.name
        getter_call = self.py_getter_call()
        ttype_id = self.type.thrift_ttype_id()
        write_protocol = \
            self.type.py_write_protocol(
                'self.' + getter_call,
                depth=depth
            )
        write_protocol = """\
oprot.write_field_begin('%(name)s', %(ttype_id)u, %(id_)d)
%(write_protocol)s
oprot.write_field_end()
""" % locals()
        if not self.required:
            write_protocol = indent(' ' * 4, write_protocol)
            write_protocol = """\
if self.%(getter_call)s is not None:
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
