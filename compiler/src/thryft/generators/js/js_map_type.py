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

from thryft.generator.map_type import MapType
from thryft.generators.js._js_container_type import _JsContainerType
from yutil import indent


class JsMapType(MapType, _JsContainerType):
    def js_read_protocol(self):
        key_read_protocol = self.key_type.js_read_protocol()
        value_read_protocol = self.value_type.js_read_protocol()
        return """function(iprot) { var map = {}; var mapBegin = iprot.readMapBegin(); for (var i = 0; i < mapBegin.size; i++) { var key = %(key_read_protocol)s; var value = %(value_read_protocol)s; map[key] = value; } iprot.readMapEnd(); return map; }(iprot)""" % locals()

    def js_write_protocol(self, value, depth=0):
        key_ttype_id = self.key_type.thrift_ttype_id()
        key_write_protocol = \
            indent(' ' * 4,
                self.key_type.js_write_protocol(
                    "__key%(depth)u" % locals(),
                    depth=depth + 1
                )
            )
        value_ttype_id = self.value_type.thrift_ttype_id()
        value_write_protocol = \
            indent(' ' * 4,
                self.value_type.js_write_protocol(
                    "__map%(depth)u[__key%(depth)u]" % locals(),
                    depth=depth + 1
                )
            )
        return """\
var __map%(depth)u = %(value)s;
var __mapSize%(depth)u = 0;
for (var __key%(depth)u in __map%(depth)u) {
    __mapSize%(depth)u++;
}
oprot.writeMapBegin(%(key_ttype_id)u, %(value_ttype_id)u, __mapSize%(depth)u);
for (var __key%(depth)u in __map%(depth)u) {
%(key_write_protocol)s
%(value_write_protocol)s
}
oprot.writeMapEnd();""" % locals()