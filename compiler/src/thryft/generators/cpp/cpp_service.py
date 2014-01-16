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

from thryft.generator.service import Service
from thryft.generators.cpp._cpp_named_construct import _CppNamedConstruct
from yutil import indent, lpad


class CppService(Service, _CppNamedConstruct):
    def cpp_includes_definition(self):
        includes = []
        for function in self.functions:
            includes.extend(function.cpp_includes_definition())
        return includes

    def cpp_extends(self):
        return self.extends

    def cpp_name(self, boxed=False):
        return self.name

    def cpp_qname(self, boxed=False):
        return _CppNamedConstruct.cpp_qname(self, name=self.name)

    def __repr__(self):
        extends = self.cpp_extends()
        if extends is None:
            extends = ''
        else:
            extends = ' : public ' + extends

        name = self.cpp_name()

        sections = []

        if len(self.functions) > 0:
            message_types = []
            read_requests = []
            handle_request_declarations = []
            request_forward_declarations = []
            for function in self.functions:
                request_type = function.cpp_request_type()
                read_requests.append(request_type.cpp_read_if())
                request_forward_declarations.append(request_type.cpp_forward_declaration())
                handle_request_declarations.append(request_type.cpp_handle_declaration())
                message_types.append(repr(request_type))

                response_type = function.cpp_response_type()
                message_types.append(repr(response_type))
            message_types = "\n\n".join(message_types)
            read_requests = indent(' ' * 2, ' else '.join(read_requests))
            request_forward_declarations = "\n".join(request_forward_declarations)
            handle_request_declarations = indent(' ' * 2, "\n".join(handle_request_declarations))

            sections.append("public:\n" + indent(' ' * 2, """\
template <class RequestT> class RequestHandler;

class Message : public ::thryft::Struct {
};

template <class MessageT = Message>
class Request : public MessageT {
public:
  virtual void accept(RequestHandler< Request<MessageT> >& handler) const = 0;
};

%(request_forward_declarations)s

template < class RequestT = Request<Message> >
class RequestHandler {
public:
%(handle_request_declarations)s
};

template <class MessageT = Message>
class Response : public MessageT {
};

%(message_types)s

template < class RequestT = Request<Message> >
static RequestT* read_request(const char* function_name, ::thryft::protocol::InputProtocol& iprot, ::thryft::protocol::Type::Enum as_type) {
  if (function_name == NULL) {
    return NULL;
  }

%(read_requests)s

  return NULL;
}
""" % locals()))

        sections.append(
                indent(' ' * 2,
                    "\n\n".join(function.cpp_pure_virtual_declaration()
                                for function in self.functions)))

        sections = lpad("\n\n", "\n\n".join(sections))

        return """\
class %(name)s%(extends)s {
public:
  virtual ~%(name)s() {
  }%(sections)s
};""" % locals()
