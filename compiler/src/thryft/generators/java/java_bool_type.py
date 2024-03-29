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

from thryft.generator.bool_type import BoolType
from thryft.generators.java._java_base_type import _JavaBaseType


class JavaBoolType(BoolType, _JavaBaseType):
    def java_default_value(self):
        return 'false'

    def java_compare_to(self, this_value, other_value):
        return "((Boolean)%(this_value)s).compareTo(%(other_value)s)" % locals()

    def java_faker(self, **kwds):
        return 'org.thryft.Faker.randomBool()'

    def java_from_string(self, value):
        return """(%(value)s.equals("1") || %(value)s.equalsIgnoreCase("true"))""" % locals()

    def java_hash_code(self, value):
        return "(%(value)s ? 1 : 0)" % locals()

    def java_literal(self, value):
        return value and 'true' or 'false'

    def java_name(self, boxed=False):
        return boxed and 'Boolean' or 'boolean'

    def java_to_string(self, value):
        return "Boolean.toString(%(value)s)" % locals()
