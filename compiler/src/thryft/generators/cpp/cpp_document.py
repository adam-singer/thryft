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

from thryft.generator.document import Document
from thryft.generators.cpp._cpp_compound_type import _CppCompoundType
from thryft.generators.cpp._cpp_named_construct import _CppNamedConstruct
import os.path
from yutil import deduplist, lpad, rpad


class CppDocument(Document, _CppNamedConstruct):
    def cpp_includes_use(self):
        namespace = self.cpp_namespace()
        include = []
        if namespace is not None:
            include.extend(namespace.split('.'))
        include.append(self.cpp_name() + '.hpp')
        return ('"' + '/'.join(include) + '"',)

    def cpp_includes_definition(self):
        includes = []
        for definition in self.definitions:
            includes.extend(definition.cpp_includes_definition())
        normalized_includes = []
        for include in includes:
            normalized_include = include.strip()
            if not normalized_include.startswith('#include '):
                normalized_include = '#include ' + normalized_include
            normalized_includes.append(normalized_include)
        normalized_includes = deduplist(normalized_includes)

        std_includes = []
        lib_includes = []
        other_includes = []
        for include in normalized_includes:
            if include.endswith('.hpp>') or include.endswith('.h>'):
                lib_includes.append(include)
            elif include.endswith('"'):
                other_includes.append(include)
            elif include.endswith('>'):
                std_includes.append(include)
            else:
                raise NotImplementedError
        includes = std_includes
        if len(lib_includes) > 0:
            if len(includes) > 0:
                includes.append('')
            includes.extend(lib_includes)
        if len(other_includes) > 0:
            if len(includes) > 0:
                includes.append('')
            includes.extend(other_includes)
        return includes

    def cpp_name(self):
        return self.name

    def cpp_namespace(self):
        return self.namespace_by_scope('cpp').name

    def __repr__(self):
        definitions = []
        definitions.append(
            "\n\n".join(repr(definition)
                         for definition in self.definitions)
        )
        definitions = "\n\n".join(definitions)
        if len(definitions) == 0:
            return definitions

        guard = []
        namespace = self.cpp_namespace()
        if namespace is not None:
            namespace_split = namespace.split('.')
            guard.extend(s.upper() for s in namespace_split)
            namespaces_prefix = "\n".join("namespace %s {" % s for s in namespace_split) + "\n"
            namespaces_suffix = "\n" + "\n".join('}' for _ in namespace_split)

        global_operators = []
        for definition in self.definitions:
            if isinstance(definition, _CppCompoundType):
                global_operators.extend(definition.cpp_global_operators())
        global_operators = lpad("\n\n", "\n\n".join(global_operators))

        guard.append(self.cpp_name().upper())
        guard = '_' + '_'.join(guard) + '_HPP_'

        includes = rpad("\n".join(self.cpp_includes_definition()), "\n\n")

        repr_ = """\
#ifndef %(guard)s
#define %(guard)s

%(includes)s%(namespaces_prefix)s%(definitions)s%(namespaces_suffix)s%(global_operators)s

#endif  // %(guard)s
""" % locals()

        return repr_

    def _save_to_dir(self, out_dir_path):
        try:
            out_dir_path = os.path.join(out_dir_path, self.namespace_by_scope('cpp').name.replace('.', os.path.sep))
        except KeyError:
            pass
        return self._save_to_file(os.path.join(out_dir_path, self.name + '.hpp'))
