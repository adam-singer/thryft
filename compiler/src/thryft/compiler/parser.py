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

from spark import GenericParser
from thryft.compiler.ast import Ast
from thryft.compiler.parse_exception import ParseException
from thryft.compiler.token import Token
from yutil import class_qname
import json
import logging
import os.path
import sys


class Parser(GenericParser):
    __annotation_parsers = {}

    def __init__(self):
        GenericParser.__init__(self, start='document')
        self.__logger = logging.getLogger(class_qname(self))

    def __dispatch(self, p_method, args):
        ret = p_method(args)

        if isinstance(ret, Ast.Node):
            ast_node = ret
            if ast_node.doc is not None and len(ast_node.doc.tags) > 0:
                for tag_name, tag_value in ast_node.doc.tags.iteritems():
                    try:
                        annotation_parser = self.__class__.__annotation_parsers[ast_node.__class__][tag_name]
                    except KeyError:
                        logging.warn("unknown annotation @%s at %s" % (tag_name, repr(ast_node.doc.start_token)))
                        continue

                    try:
                        annotation_parser(
                            ast_node=ast_node,
                            name=tag_name,
                            start_token=ast_node.doc.start_token,
                            stop_token=ast_node.doc.stop_token,
                            value=tag_value,
                        )
                    except ValueError, e:
                        raise ParseException("error parsing annotation @%s: %s" % (tag_name, str(e)), token=ast_node.doc.start_token)

        self.__logger.debug("%s(%s) -> %s", p_method.im_func.func_name, repr(args), repr(ret))

        return ret

    def error(self, token):
        raise ParseException('grammar exception', token=token)

    @staticmethod
    def __flatten_args(args):
        flattened_args = []
        for arg in args:
            if isinstance(arg, (list, tuple)):
                flattened_args.extend(arg)
            else:
                flattened_args.append(arg)
        return tuple(flattened_args)

    @staticmethod
    def __join_arg_texts(args):
        return ''.join(str(arg) for arg in args)

    @staticmethod
    def __p(args, doc=True, start_token=True, stop_token=True):
        out_doc_node = None
        if doc:
            comments = args[0]
            if len(comments) > 0:
                out_doc_lines = []
                for comment in comments:
                    assert isinstance(comment, Token) and comment.type == Token.Type.COMMENT
                    if comment.text.startswith('/*') and comment.text.endswith('*/'):
                        doc_lines = comment.text[2:-2].splitlines(True)
                        if len(doc_lines) > 2:
                            javadoc_lines = []
                            for doc_line in doc_lines[1:-1]:
                                doc_line = doc_line.lstrip()
                                if doc_line.startswith('*'):
                                    doc_line = doc_line.lstrip('*').lstrip()
                                    if len(doc_line.rstrip()) > 1:
                                        javadoc_lines.append(doc_line)
                                elif len(doc_line) == 0:
                                    pass
                                else:
                                    javadoc_lines = []
                                    break
                            if len(javadoc_lines) > 0:
                                out_doc_lines.extend(javadoc_lines)
                            else:
                                out_doc_lines.extend(doc_lines)
                        else:
                            out_doc_lines.extend(doc_lines)
                    elif comment.text.startswith('//'):
                        doc_line = comment.text[2:].lstrip()
                        if len(doc_line) > 0:
                            out_doc_lines.append(doc_line)
                    elif comment.text.startswith('#'):
                        doc_line = comment.text[1:].lstrip()
                        if len(doc_line) > 0:
                            out_doc_lines.append(doc_line)
                    else:
                        raise NotImplementedError

                if len(out_doc_lines) > 0:
                    out_doc_text = []
                    out_doc_tags = {}
                    for doc_line in out_doc_lines:
                        if doc_line.startswith('@') and len(doc_line) > 1:
                            doc_line_split = doc_line.split(None, 1)
                            tag = doc_line_split[0][1:].lower()
                            if len(doc_line_split) == 2:
                                out_doc_tags[tag] = doc_line_split[1].rstrip()
                                if len(out_doc_tags[tag]) == 0:
                                    out_doc_tags[tag] = None
                            else:
                                out_doc_tags[tag] = None
                        else:
                            out_doc_text.append(doc_line)
                    out_doc_node = \
                        Ast.DocNode(
                            start_token=comments[0],
                            stop_token=comments[-1],
                            tags=out_doc_tags,
                            text=''.join(out_doc_text)
                        )

        out_start_token = None
        if start_token:
            if doc:
                comments = args[0]
                if len(comments) > 0:
                    out_start_token = comments[0]
            if out_start_token is None:
                for arg in args:
                    if isinstance(arg, Token):
                        out_start_token = arg
                        break

        out_stop_token = None
        if stop_token:
            for arg in reversed(args):
                if isinstance(arg, Token):
                    out_stop_token = arg
                    break
            if out_stop_token is None:
                out_stop_token = out_start_token

        return out_doc_node, out_start_token, out_stop_token

    def parse(self, tokens):
        discard_token_types = (Token.Type.EOL, Token.Type.WS)
        tokens = [token for token in tokens
                  if token.type not in discard_token_types]
        return GenericParser.parse(self, tokens)

    def p_base_type(self, args):
        '''
        base_type ::= KEYWORD_BINARY
        base_type ::= KEYWORD_BOOL
        base_type ::= KEYWORD_BYTE
        base_type ::= KEYWORD_DOUBLE
        base_type ::= KEYWORD_FLOAT
        base_type ::= KEYWORD_I16
        base_type ::= KEYWORD_I32
        base_type ::= KEYWORD_I64
        base_type ::= KEYWORD_STRING
        '''
        return self.__dispatch(self.__p_base_type, args)

    def __p_base_type(self, args):
        return Ast.BaseTypeNode(name=args[0].text, start_token=args[0], stop_token=args[0])

    def p_bool_literal(self, args):
        '''
        bool_literal ::= KEYWORD_FALSE
        bool_literal ::= KEYWORD_TRUE
        '''
        return self.__dispatch(self.__p_bool_literal, args)

    def __p_bool_literal(self, args):
        return Ast.BoolLiteralNode(start_token=args[0], stop_token=args[0], value=args[0].text.lower() == 'true')

    def p_comments(self, args):
        '''
        comments ::= COMMENT comments
        comments ::=
        '''
        return self.__dispatch(self.__p_comments, args)

    def __p_comments(self, args):
        return self.__flatten_args(args)

    def p_compound_type_field(self, args):
        '''
        compound_type_field ::= comments field list_separator_optional
        '''
        return self.__dispatch(self.__p_compound_type_field, args)

    def __p_compound_type_field(self, args):
        doc_node, start_token, stop_token = self.__p(args)
        field = args[1]
        return \
            Ast.FieldNode(
                doc=doc_node,
                id_=field.id,
                name=field.name,
                required=field.required,
                start_token=start_token,
                stop_token=stop_token,
                type_=field.type,
                value=field.value
            )

    def p_compound_type_fields(self, args):
        '''
        compound_type_fields ::= compound_type_field compound_type_fields
        compound_type_fields ::=
        '''
        return self.__dispatch(self.__p_compound_type_fields, args)

    def __p_compound_type_fields(self, args):
        return self.__flatten_args(args)

    def p_const(self, args):
        '''
        const ::= comments KEYWORD_CONST type identifier EQUALS literal semicolon_optional
        '''
        return self.__dispatch(self.__p_const, args)

    def __p_const(self, args):
        doc_node, start_token, stop_token = self.__p(args)
        name = args[3].text
        type_ = args[2]
        value = args[5]
        if value is not None:
            if isinstance(type_, Ast.BaseTypeNode):
                if type_.name == 'bool':
                    if not isinstance(value, Ast.BoolLiteralNode):
                        raise ParseException("expected bool literal for const '%s'" % name, token=value.start_token)
                elif type_.name in 'double':
                    if not isinstance(value, Ast.IntLiteralNode) and not isinstance(value, Ast.FloatLiteralNode):
                        raise ParseException("expected int or float literal for const '%s'" % name, token=value.start_token)
                elif type_.name in ('byte', 'i16', 'i32', 'i64'):
                    if not isinstance(value, Ast.IntLiteralNode):
                        raise ParseException("expected int literal for const '%s'" % name, token=value.start_token)
                elif type_.name == 'string':
                    if not isinstance(value, Ast.StringLiteralNode):
                        raise ParseException("expected string literal for const '%s'" % name, token=value.start_token)
                else:
                    raise NotImplementedError(type_.name)
            elif isinstance(type_, Ast.MapTypeNode):
                if not isinstance(value, Ast.MapLiteralNode):
                    raise ParseException("expected map literal for const '%s'" % name, token=value.start_token)
            elif isinstance(type_, Ast.ListTypeNode) or isinstance(type_, Ast.SetTypeNode):
                if not isinstance(value, Ast.ListLiteralNode):
                    raise ParseException("expected list literal for const '%s'" % name, token=value.start_token)
            else:
                raise NotImplementedError(type_.name)
        return \
            Ast.ConstNode(
                doc=doc_node,
                name=name,
                start_token=start_token,
                stop_token=stop_token,
                type_=type_,
                value=value
            )

    def p_document(self, args):
        '''
        document ::= headers definitions EOF
        document ::= comments EOF
        '''
        return self.__dispatch(self.__p_document, args)

    def __p_document(self, args):
        if len(args) == 2:
            return \
                Ast.DocumentNode(
                    definitions=tuple(),
                    headers=tuple(),
                    path=args[1].input_filename
                )
        else:
            return \
                Ast.DocumentNode(
                    definitions=args[1],
                    headers=args[0],
                    path=args[2].input_filename
                )

    def p_definition(self, args):
        '''
        definition ::= const
        definition ::= enum
        definition ::= exception_type
        definition ::= service
        definition ::= struct_type
        definition ::= typedef
        '''
        return self.__dispatch(self.__p_definition, args)

    def __p_definition(self, args):
        return args[0]

    def p_definitions(self, args):
        '''
        definitions ::= definition definitions
        definitions ::= definition
        definitions ::=
        '''
        return self.__dispatch(self.__p_definitions, args)

    def __p_definitions(self, args):
        return self.__flatten_args(args)

    def p_enum(self, args):
        '''
        enum ::= comments KEYWORD_ENUM identifier LEFT_BRACE enumerators RIGHT_BRACE
        '''
        return self.__dispatch(self.__p_enum, args)

    def __p_enum(self, args):
        doc_node, start_token, stop_token = self.__p(args)
        return \
            Ast.EnumTypeNode(
                doc=doc_node,
                enumerators=args[4],
                name=args[2].text,
                start_token=start_token,
                stop_token=stop_token
            )

    def p_enumerator(self, args):
        '''
        enumerator ::= comments identifier enumerator_value list_separator_optional
        '''
        return self.__dispatch(self.__p_enumerator, args)

    def __p_enumerator(self, args):
        doc_node, start_token, stop_token = self.__p(args)
        return Ast.EnumeratorNode(doc=doc_node, name=args[1].text, start_token=start_token, stop_token=stop_token, value=args[2])

    def p_enumerators(self, args):
        '''
        enumerators ::= enumerator enumerators
        enumerators ::=
        '''
        return self.__dispatch(self.__p_enumerators, args)

    def __p_enumerators(self, args):
        return self.__flatten_args(args)

    def p_enumerator_value(self, args):
        '''
        enumerator_value ::= EQUALS int_literal
        enumerator_value ::=
        '''
        return self.__dispatch(self.__p_enumerator_value, args)

    def __p_enumerator_value(self, args):
        if len(args) > 0:
            return args[1]

    def p_exception_type(self, args):
        '''
        exception_type ::= comments KEYWORD_EXCEPTION identifier LEFT_BRACE compound_type_fields RIGHT_BRACE
        '''
        return self.__dispatch(self.__p_exception_type, args)

    def __p_exception_type(self, args):
        doc_node, start_token, stop_token = self.__p(args)
        return \
            Ast.ExceptionTypeNode(
                doc=doc_node,
                name=args[2].text,
                fields=args[4],
                start_token=start_token,
                stop_token=stop_token
            )

    def p_field(self, args):
        '''
        field ::= field_id field_required type identifier field_value
        '''
        return self.__dispatch(self.__p_field, args)

    def __p_field(self, args):
        _, start_token, stop_token = self.__p(args, doc=False)
        id_ = value = None
        if args[0] is not None:
            id_ = args[0].value
        if args[-1] is not None:
            value = args[-1].value
        return \
            Ast.FieldNode(
                id_=id_,
                name=args[3].text,
                required=args[1],
                start_token=start_token,
                stop_token=stop_token,
                type_=args[2],
                value=value
            )

    def p_field_id(self, args):
        '''
        field_id ::=
        field_id ::= int_literal COLON
        '''
        return self.__dispatch(self.__p_field_id, args)

    def __p_field_id(self, args):
        if len(args) > 0:
            return args[0]

    def p_field_required(self, args):
        '''
        field_required ::=
        field_required ::= KEYWORD_REQUIRED
        field_required ::= KEYWORD_OPTIONAL
        '''
        return self.__dispatch(self.__p_field_required, args)

    def __p_field_required(self, args):
        if len(args) == 1:
            return args[0].text == 'required'
        else:
            return True

    def p_field_value(self, args):
        '''
        field_value ::=
        field_value ::= EQUALS literal
        '''
        return self.__dispatch(self.__p_field_value, args)

    def __p_field_value(self, args):
        if len(args) > 0:
            return args[1]

    def p_float_literal(self, args):
        '''
        float_literal ::= FLOAT_LITERAL
        '''
        return self.__dispatch(self.__p_float_literal, args)

    def __p_float_literal(self, args):
        return Ast.FloatLiteralNode(start_token=args[0], stop_token=args[0], value=float(args[0].text))

    def p_function(self, args):
        '''
        function ::= comments function_oneway function_return_type identifier LEFT_PARENTHESIS function_parameters RIGHT_PARENTHESIS function_throws list_separator_optional
        '''
        return self.__dispatch(self.__p_function, args)

    def __p_function(self, args):
        doc_node, start_token, stop_token = self.__p(args)
        function_name = args[3].text
        parameters = args[5]
        if args[2] is not None:
            return_field = \
                Ast.FieldNode(
                    id_=None,
                    name='return_value',
                    required=True,
                    type_=args[2],
                    value=None
                )
        else:
            return_field = None
        throws = args[7]

        return \
            Ast.FunctionNode(
                doc=doc_node,
                name=function_name,
                oneway=args[1],
                parameters=parameters,
                return_field=return_field,
                start_token=start_token,
                stop_token=stop_token,
                throws=throws
            )

    def p_function_oneway(self, args):
        '''
        function_oneway ::= KEYWORD_ONEWAY
        function_oneway ::=
        '''
        return self.__dispatch(self.__p_function_oneway, args)

    def __p_function_oneway(self, args):
        return len(args) > 0

    def p_function_parameters(self, args):
        '''
        function_parameters ::= field
        function_parameters ::= field COMMA function_parameters
        function_parameters ::=
        '''
        return self.__dispatch(self.__p_function_parameters, args)

    def __p_function_parameters(self, args):
        function_parameters = []
        for arg in args:
            if isinstance(arg, tuple):
                function_parameters.extend(arg)
            elif isinstance(arg, Ast.FieldNode):
                function_parameters.append(arg)
        return tuple(function_parameters)

    def p_function_return_type(self, args):
        '''
        function_return_type ::= KEYWORD_VOID
        function_return_type ::= type
        '''
        return self.__dispatch(self.__p_function_return_type, args)

    def __p_function_return_type(self, args):
        if isinstance(args[0], Token):
            return None  # void
        else:
            return args[0]

    def p_function_throws(self, args):
        '''
        function_throws ::=
        function_throws ::= KEYWORD_THROWS LEFT_PARENTHESIS function_throws_body RIGHT_PARENTHESIS
        '''
        return self.__dispatch(self.__p_function_throws, args)

    def __p_function_throws(self, args):
        if len(args) > 0:
            return args[2]
        else:
            return tuple()

    def p_function_throws_body(self, args):
        '''
        function_throws_body ::= field
        function_throws_body ::= field COMMA function_throws_body
        '''
        return self.__dispatch(self.__p_function_throws_body, args)

    def __p_function_throws_body(self, args):
        return self.__flatten_args(args[i] for i in xrange(0, len(args), 2))

    def p_functions(self, args):
        '''
        functions ::= function functions
        functions ::=
        '''
        return self.__dispatch(self.__p_functions, args)

    def __p_functions(self, args):
        return self.__flatten_args(args)

    def p_header(self, args):
        '''
        header ::= include
        header ::= namespace
        '''
        return self.__dispatch(self.__p_header, args)

    def __p_header(self, args):
        return args[0]

    def p_headers(self, args):
        '''
        headers ::= headers header
        headers ::= header
        headers ::=
        '''
        return self.__dispatch(self.__p_headers, args)

    def __p_headers(self, args):
        return self.__flatten_args(args)

    def p_identifier(self, args):
        '''
        identifier ::= IDENTIFIER
        identifier ::= KEYWORD_INCLUDE
        identifier ::= KEYWORD_LIST
        '''
        return self.__dispatch(self.__p_identifier, args)

    def __p_identifier(self, args):
        return Ast.IdentifierNode(start_token=args[0], stop_token=args[-1], text=args[0].text)

    def p_include(self, args):
        '''
        include ::= comments KEYWORD_INCLUDE QUOTED_STRING
        '''
        return self.__dispatch(self.__p_include, args)

    def __p_include(self, args):
        doc_node, start_token, stop_token = self.__p(args)
        return \
            Ast.IncludeNode(
                doc=doc_node,
                path=args[2].text[1:-1],
                start_token=start_token,
                stop_token=stop_token
            )

    def p_int_literal(self, args):
        '''
        int_literal ::= INT_LITERAL
        '''
        return self.__dispatch(self.__p_int_literal, args)

    def __p_int_literal(self, args):
        return Ast.IntLiteralNode(start_token=args[0], stop_token=args[0], value=int(args[0].text))

    def p_list_literal(self, args):
        '''
        list_literal ::= LEFT_SQUARE_BRACKET list_literal_body RIGHT_SQUARE_BRACKET
        '''
        return self.__dispatch(self.__p_list_literal, args)

    def __p_list_literal(self, args):
        return Ast.ListLiteralNode(start_token=args[0], stop_token=args[-1], value=args[1])

    def p_list_literal_body(self, args):
        '''
        list_literal_body ::= literal
        list_literal_body ::= literal COMMA list_literal_body
        '''
        return self.__dispatch(self.__p_list_literal_body, args)

    def __p_list_literal_body(self, args):
        if len(args) == 1:
            return args[0]
        else:
            return self.__flatten_args(args[i] for i in xrange(0, len(args), 2))

    def p_list_separator(self, args):
        '''
        list_separator ::= COMMA
        list_separator ::= SEMICOLON
        '''
        return self.__dispatch(self.__p_list_separator, args)

    def __p_list_separator(self, args):
        pass

    def p_list_type(self, args):
        '''
        list_type ::= KEYWORD_LIST LEFT_ANGLE_BRACKET type RIGHT_ANGLE_BRACKET
        '''
        return self.__dispatch(self.__p_list_type, args)

    def __p_list_type(self, args):
        return Ast.ListTypeNode(element_type=args[2], start_token=args[0], stop_token=args[-1])

    def p_list_separator_optional(self, args):
        '''
        list_separator_optional ::= list_separator
        list_separator_optional ::=
        '''
        return self.__dispatch(self.__p_list_separator_optional, args)

    def __p_list_separator_optional(self, args):
        pass

    def p_literal(self, args):
        '''
        literal ::= bool_literal
        literal ::= float_literal
        literal ::= int_literal
        literal ::= list_literal
        literal ::= map_literal
        literal ::= string_literal
        '''
        return self.__dispatch(self.__p_literal, args)

    def __p_literal(self, args):
        return args[0]

    def p_map_literal(self, args):
        '''
        map_literal ::= LEFT_BRACE map_literal_items RIGHT_BRACE
        '''
        return self.__dispatch(self.__p_map_literal, args)

    def __p_map_literal(self, args):
        return Ast.MapLiteralNode(start_token=args[0], stop_token=args[-1], value=args[1])

    def p_map_literal_item(self, args):
        '''
        map_literal_item ::= literal COLON literal
        '''
        return self.__dispatch(self.__p_map_literal_item, args)

    def __p_map_literal_item(self, args):
        return (args[0], args[2])

    def p_map_literal_items(self, args):
        '''
        map_literal_items ::= map_literal_item
        map_literal_items ::= map_literal_item COMMA map_literal_items
        '''
        return self.__dispatch(self.__p_map_literal_items, args)

    def __p_map_literal_items(self, args):
        if len(args) == 1:
            return args[0]
        else:
            return dict(args[i] for i in xrange(0, len(args), 2))

    def p_map_type(self, args):
        '''
        map_type ::= KEYWORD_MAP LEFT_ANGLE_BRACKET type COMMA type RIGHT_ANGLE_BRACKET
        '''
        return self.__dispatch(self.__p_map_type, args)

    def __p_map_type(self, args):
        return Ast.MapTypeNode(key_type=args[2], start_token=args[0], stop_token=args[-1], value_type=args[4])

    def p_namespace(self, args):
        '''
        namespace ::= comments KEYWORD_NAMESPACE namespace_scope namespace_name
        '''
        return self.__dispatch(self.__p_namespace, args)

    def __p_namespace(self, args):
        doc_node, start_token, stop_token = self.__p(args)
        return \
            Ast.NamespaceNode(
                doc=doc_node,
                name=args[3],
                scope=args[2],
                start_token=start_token,
                stop_token=stop_token
            )

    def p_namespace_name(self, args):
        '''
        namespace_name ::= identifier PERIOD namespace_name
        namespace_name ::= identifier
        '''
        return self.__dispatch(self.__p_namespace_name, args)

    def __p_namespace_name(self, args):
        return self.__join_arg_texts(self.__flatten_args(args))

    def p_namespace_scope(self, args):
        '''
        namespace_scope ::= ASTERISK
        namespace_scope ::= identifier
        '''
        return self.__dispatch(self.__p_namespace_scope, args)

    def __p_namespace_scope(self, args):
        return str(args[0])

    def p_semicolon_optional(self, args):
        '''
        semicolon_optional ::= SEMICOLON
        semicolon_optional ::=
        '''
        return self.__dispatch(self.__p_semicolon_optional, args)

    def __p_semicolon_optional(self, args):
        if len(args) > 0:
            return args[0]

    def p_service(self, args):
        '''
        service ::= comments KEYWORD_SERVICE identifier LEFT_BRACE functions RIGHT_BRACE
        '''
        return self.__dispatch(self.__p_service, args)

    def __p_service(self, args):
        doc_node, start_token, stop_token = self.__p(args)
        return \
            Ast.ServiceNode(
                doc=doc_node,
                name=args[2].text,
                functions=args[4],
                start_token=start_token,
                stop_token=stop_token
            )

    def p_set_type(self, args):
        '''
        set_type ::= KEYWORD_SET LEFT_ANGLE_BRACKET type RIGHT_ANGLE_BRACKET
        '''
        return self.__dispatch(self.__p_set_type, args)

    def __p_set_type(self, args):
        return Ast.SetTypeNode(element_type=args[2], start_token=args[0], stop_token=args[-1])

    def p_string_literal(self, args):
        '''
        string_literal ::= QUOTED_STRING
        '''
        return self.__dispatch(self.__p_string_literal, args)

    def __p_string_literal(self, args):
        return Ast.StringLiteralNode(start_token=args[0], stop_token=args[0], value=args[0].text[1:-1])

    def p_struct_type(self, args):
        '''
        struct_type ::= comments KEYWORD_STRUCT identifier LEFT_BRACE compound_type_fields RIGHT_BRACE
        '''
        return self.__dispatch(self.__p_struct_type, args)

    def __p_struct_type(self, args):
        doc_node, start_token, stop_token = self.__p(args)
        return \
            Ast.StructTypeNode(
                doc=doc_node,
                name=args[2].text,
                fields=args[4],
                start_token=start_token,
                stop_token=stop_token
            )

    def p_type(self, args):
        '''
        type ::= base_type
        type ::= list_type
        type ::= map_type
        type ::= set_type
        type ::= type_qname
        '''
        return self.__dispatch(self.__p_type, args)

    def __p_type(self, args):
        return args[0]

    def p_type_qname(self, args):
        '''
        type_qname ::= identifier PERIOD identifier
        type_qname ::= identifier
        '''
        return self.__dispatch(self.__p_type_qname, args)

    def __p_type_qname(self, args):
        if len(args) == 1:
            return Ast.TypeNode(name=args[0].text, start_token=args[0].start_token, stop_token=args[0].start_token)
        else:
            return Ast.TypeNode(name=args[2].text, qname=self.__join_arg_texts(args), start_token=args[0].start_token, stop_token=args[-1].stop_token)

    def p_typedef(self, args):
        '''
        typedef ::= comments KEYWORD_TYPEDEF type identifier
        '''
        return self.__dispatch(self.__p_typedef, args)

    def __p_typedef(self, args):
        doc_node, start_token, stop_token = self.__p(args)
        return \
            Ast.TypedefNode(
                doc=doc_node,
                name=args[3].text,
                start_token=start_token,
                stop_token=stop_token,
                type_=args[2]
            )

    @classmethod
    def register_annotation(cls, ast_node_type, name, value_parser=None):
        assert issubclass(ast_node_type, Ast.Node)
        if value_parser is None:
            value_parser = lambda value: value

        try:
            cls.__annotation_parsers[ast_node_type][name] = value_parser
        except KeyError:
            cls.__annotation_parsers[ast_node_type] = {name: value_parser}

    def typestring(self, token):
        return token.type


def __parse_faker_annotation(ast_node, name, value, **kwds):
    if value is None:
        raise ValueError("@%(name)s requires a value" % locals())

    lib_py_src_thryft_dir_path = \
        os.path.abspath(os.path.join(
            os.path.dirname(__file__),
            '..', '..', '..', '..',
            'lib', 'py', 'src', 'thryft'
        ))
    if not lib_py_src_thryft_dir_path in sys.path:
        sys.path.append(lib_py_src_thryft_dir_path)
    from faker import Faker  # @UnresolvedImport
    try:
        eval('Faker.' + value, {}, {'Faker': Faker})
    except AttributeError:
        try:
            eval(value)
        except:
            raise ValueError("invalid @%(name)s value '%(value)s" % locals())
        value_copy = value
        value = lambda: eval(value_copy)
    ast_node.annotations.append(Ast.AnnotationNode(name=name, value=value, **kwds))
Parser.register_annotation(Ast.FieldNode, 'faker', __parse_faker_annotation)


def __parse_native_annotation(ast_node, name, value, **kwds):
    if value is not None:
        raise ValueError("@%(name)s does not take a value" % locals())
    ast_node.annotations.append(Ast.AnnotationNode(name=name, **kwds))
Parser.register_annotation(Ast.StructTypeNode, 'native', __parse_native_annotation)
Parser.register_annotation(Ast.TypedefNode, 'native', __parse_native_annotation)


def __parse_param_annotation(ast_node, name, value, **kwds):
    parameter, value = __split_param_annotation(ast_node=ast_node, name=name, value=value)
    parameter.doc = Ast.DocNode(text=value, **kwds)
Parser.register_annotation(Ast.FunctionNode, 'param', __parse_param_annotation)


def __parse_requires_annotation(ast_node, name, value, **kwds):
    if value is not None:
        raise ValueError("@%(name)s does not take a value" % locals())
    ast_node.annotations.append(Ast.AnnotationNode(name=name, **kwds))
for __requires_x in ('authentication', 'guest', 'user'):
    Parser.register_annotation(Ast.FunctionNode, 'requires_' + __requires_x, __parse_requires_annotation)

def __parse_requires_set_annotation(ast_node, name, value, **kwds):
    if value is None or len(value) == 0:
        raise ValueError("@%(name)s requires a value" % locals())
    if ',' in value:
        values = value.split(',')
    else:
        values = value.split()
    values = frozenset(value.strip() for value in values)
    ast_node.annotations.append(Ast.AnnotationNode(name=name, value=values, **kwds))
for __requires_x in ('permissions', 'roles'):
    Parser.register_annotation(Ast.FunctionNode, 'requires_' + __requires_x, __parse_requires_set_annotation)


def __parse_return_annotation(ast_node, name, value, **kwds):
    if value is None:
        raise ValueError("@%(name)s requires a value" % locals())
    if ast_node.return_field is None:
        raise ValueError("@%(name)s returns to a function with a void return" % locals())
    ast_node.return_field.doc = Ast.DocNode(text=value, **kwds)
for __name in ('return', 'returns'):
    Parser.register_annotation(Ast.FunctionNode, __name, __parse_return_annotation)


def __parse_throw_annotation(ast_node, name, value, **kwds):
    if value is None:
        raise ValueError("@%(name)s requires a value" % locals())
    value_split = value.split(None, 1)
    if len(value_split) != 2:
        raise ValueError("@%(name)s requires an exception type name and a description" % locals())
    exception_type_name, value = value_split
    exception_type_name = exception_type_name.rstrip(':')
    try:
        throw = ast_node.throws_by_exception_type_name[exception_type_name]
    except KeyError:
        raise ValueError("'%s' refers to unknown exception type '%s'" % (value, exception_type_name))
    throw.doc = Ast.DocNode(text=value, **kwds)
for __name in ('throw', 'throws'):
    Parser.register_annotation(Ast.FunctionNode, __name, __parse_throw_annotation)


def __parse_validation_annotation(ast_node, name, value, **kwds):
    if isinstance(ast_node, Ast.FunctionNode):
        parameter, value = __split_param_annotation(ast_node=ast_node, name=name, value=value)

    try:
        value = json.loads(value)
    except ValueError, e:
        raise ValueError("@%s contains invalid JSON: '%s', exception: %s" % (name, value, e))
    if not isinstance(value, dict):
        raise ValueError("expected @%s to contain a JSON object, found '%s'" % (name, value))

    for lengthPropertyName in ('maxLength', 'minLength'):
        lengthPropertyValue = value.get(lengthPropertyName)
        if lengthPropertyValue is None:
            continue
        try:
            lengthPropertyValue = int(lengthPropertyValue)
        except ValueError:
            raise ValueError("@%(name)s %(lengthPropertyName)s must be an integer" % locals())
        if lengthPropertyValue < 0:
            raise ValueError("@%(name)s %(lengthPropertyName)s must be >= 0" % locals())

    annotation = Ast.AnnotationNode(name=name, value=value, **kwds)

    if isinstance(ast_node, Ast.FunctionNode):
        parameter.annotations.append(annotation)
    else:
        ast_node.annotations.append(annotation)


def __split_param_annotation(ast_node, name, value):
    assert isinstance(ast_node, Ast.FunctionNode)

    if value is None:
        raise ValueError("@%(name)s requires a value" % locals())
    value_split = value.split(None, 1)
    if len(value_split) != 2:
        raise ValueError("@%(name)s requires a parameter name and description" % locals())
    param_name = value_split[0].rstrip(':')

    if param_name == 'return':
        if ast_node.return_field is not None:
            parameter = ast_node.return_field
        else:
            raise ValueError("unknown parameter '%s'" % param_name)
    else:
        try:
            parameter = ast_node.parameters_by_name[param_name]
        except KeyError:
            raise ValueError("unknown parameter '%s'" % param_name)

    return parameter, value_split[1]


for __ast_node_type in (Ast.FieldNode, Ast.FunctionNode):
    Parser.register_annotation(__ast_node_type, 'validation', __parse_validation_annotation)
