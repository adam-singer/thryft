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

from thryft.generators.java._java_base_type import _JavaBaseType


class _JavaNumericType(_JavaBaseType):
    def java_compare_to(self, this_value, other_value):
        boxed_name = self.java_name(boxed=True)
        return "((%(boxed_name)s)%(this_value)s).compareTo(%(other_value)s)" % locals()

    def java_faker(self, validation=None):
        parameters = []
        if validation is not None:
            max_ = validation.get('max')
            min_ = validation.get('min')
            if min_ is not None or max_ is not None:
                if min_ is None:
                    min_ = self.java_min_value()
                if max_ is None:
                    max_ = self.java_max_value()
                parameters.extend((str(min_), str(max_)))
        parameters = ', '.join(parameters)
        return "org.thryft.Faker.random%s(%s)" % (self.name.capitalize(), parameters)

    def java_min_value(self):
        return self.java_name(boxed=True) + '.MIN_VALUE'

    def java_max_value(self):
        return self.java_name(boxed=True) + '.MAX_VALUE'

    def java_read_protocol_throws_unchecked(self):
        return ['NumberFormatException']
