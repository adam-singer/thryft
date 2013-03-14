from spark import GenericParser
from thryft.compiler.ast import Ast
from thryft.compiler.parser_exception import ParserException
from thryft.compiler.token import Token


# Helper functions
class Parser(GenericParser):
    def __init__(self):
        GenericParser.__init__(self, start='document')

    def error(self, token):
        raise ParserException(token)

    @staticmethod
    def __flatten_args(args):
        flattened_args = []
        for arg in args:
            if isinstance(arg, tuple):
                flattened_args.extend(arg)
            else:
                flattened_args.append(arg)
        return tuple(flattened_args)

    def p_bool_literal(self, args):
        '''
        bool_literal ::= KEYWORD_FALSE
        bool_literal ::= KEYWORD_TRUE
        '''
        return args[0].text.lower() == 'true'

    def p_comments(self, args):
        '''
        comments ::= COMMENT comments
        comments ::=
        '''
        return self.__flatten_args(args)

    def p_compound_type_field(self, args):
        '''
        compound_type_field ::= comments field list_separator_optional
        '''
        return args[1]

    def p_compound_type_fields(self, args):
        '''
        compound_type_fields ::= compound_type_field compound_type_fields
        compound_type_fields ::=
        '''
        return self.__flatten_args(args)

    def p_const(self, args):
        '''
        const ::= comments KEYWORD_CONST type identifier EQUALS literal semicolon_optional
        '''
        return Ast.ConstNode(name=args[3], type_=args[2], value=args[5])

    def p_document(self, args):
        '''
        document ::= headers definitions EOF
        document ::= comments EOF
        '''
        if len(args) == 2:
            return ''.join(arg.text for arg in args[0])
        else:
            return Ast.DocumentNode(definitions=args[1], headers=args[0])

    def p_definition(self, args):
        '''
        definition ::= const
        definition ::= enum
        definition ::= exception_type
        definition ::= service
        definition ::= struct_type
        definition ::= typedef
        '''
        return args[0]

    def p_definitions(self, args):
        '''
        definitions ::= definition definitions
        definitions ::= definition
        definitions ::=
        '''
        return self.__flatten_args(args)

    def p_enum(self, args):
        '''
        enum ::= comments KEYWORD_ENUM identifier LEFT_BRACE enumerators RIGHT_BRACE
        '''
        return Ast.EnumTypeNode(enumerators=args[4], name=args[2])

    def p_enumerator(self, args):
        '''
        enumerator ::= comments identifier enumerator_value list_separator_optional
        '''
        value = None
        if len(args) >= 3:
            value = args[2]
        return Ast.EnumeratorNode(name=args[1], value=value)

    def p_enumerators(self, args):
        '''
        enumerators ::= enumerator enumerators
        enumerators ::=
        '''
        return self.__flatten_args(args)

    def p_enumerator_value(self, args):
        '''
        enumerator_value ::= EQUALS literal
        enumerator_value ::=
        '''
        if len(args) > 0:
            return args[1]

    def p_exception_type(self, args):
        '''
        exception_type ::= comments KEYWORD_EXCEPTION identifier LEFT_BRACE compound_type_fields RIGHT_BRACE
        '''
        return Ast.ExceptionTypeNode(name=args[2], fields=args[4])

    def p_field(self, args):
        '''
        field ::= field_id field_required type identifier field_value
        '''
        assert len(args) == 5
        return Ast.FieldNode(id_=args[0], name=args[3], required=args[1], type_=args[2], value=args[4])

    def p_field_id(self, args):
        '''
        field_id ::=
        field_id ::= int_literal COLON
        '''
        if len(args) > 0:
            return args[0]

    def p_field_required(self, args):
        '''
        field_required ::=
        field_required ::= KEYWORD_REQUIRED
        field_required ::= KEYWORD_OPTIONAL
        '''
        if len(args) == 1:
            return args[0].text == 'optional'
        else:
            return True

    def p_field_value(self, args):
        '''
        field_value ::=
        field_value ::= EQUALS literal
        '''
        if len(args) > 0:
            return args[1]

    def p_float_literal(self, args):
        '''
        float_literal ::= DIGITS PERIOD DIGITS
        float_literal ::= DIGITS PERIOD DIGITS ALPHAS DIGITS
        '''
        return float(''.join(arg.text for arg in args))

    def p_function(self, args):
        '''
        function ::= comments function_oneway type identifier LEFT_PARENTHESIS function_parameters RIGHT_PARENTHESIS function_throws list_separator_optional
        '''
        return Ast.FunctionNode(name=args[3], oneway=args[1], parameters=args[5], return_type_name=args[2], throws=args[7])

    def p_function_oneway(self, args):
        '''
        function_oneway ::= KEYWORD_ONEWAY
        function_oneway ::=
        '''
        return len(args) > 0

    def p_function_parameters(self, args):
        '''
        function_parameters ::= field
        function_parameters ::= field COMMA function_parameters
        function_parameters ::=
        '''
        function_parameters = []
        for arg in args:
            if isinstance(arg, tuple):
                function_parameters.extend(arg)
            elif isinstance(arg, Ast.FieldNode):
                function_parameters.append(arg)
        return tuple(function_parameters)

    def p_function_throws(self, args):
        '''
        function_throws ::=
        function_throws ::= KEYWORD_THROWS LEFT_PARENTHESIS function_throws_body RIGHT_PARENTHESIS
        '''
        if len(args) > 0:
            return args[2]
        else:
            return tuple()

    def p_function_throws_body(self, args):
        '''
        function_throws_body ::= field
        function_throws_body ::= field COMMA function_throws_body
        '''
        return self.__flatten_args(args[i] for i in xrange(0, len(args), 2))

    def p_functions(self, args):
        '''
        functions ::= function functions
        functions ::=
        '''
        return self.__flatten_args(args)

    def p_header(self, args):
        '''
        header ::= include
        header ::= namespace
        '''
        return args[0]

    def p_headers(self, args):
        '''
        headers ::= headers header
        headers ::= header
        headers ::=
        '''
        return self.__flatten_args(args)

    def p_identifier(self, args):
        '''
        identifier ::= ALPHAS identifier_body
        '''
        return Ast.IdentifierNode(''.join(str(arg) for arg in args))

    def p_identifier_body(self, args):
        '''
        identifier_body ::= ALPHAS identifier_body
        identifier_body ::= DIGITS identifier_body
        identifier_body ::= UNDERSCORE identifier_body
        identifier_body ::=
        '''
        return ''.join(str(arg) for arg in args)

    def p_include(self, args):
        '''
        include ::= comments KEYWORD_INCLUDE QUOTED_STRING
        '''
        return Ast.IncludeNode(path=args[2].text[1:-1])

    def p_int_literal(self, args):
        '''
        int_literal ::= DIGITS
        '''
        return int(args[0].text)

    def p_list_literal(self, args):
        '''
        list_literal ::= LEFT_SQUARE_BRACKET list_literal_body RIGHT_SQUARE_BRACKET
        '''
        return args[1]

    def p_list_literal_body(self, args):
        '''
        list_literal_body ::= literal
        list_literal_body ::= literal COMMA list_literal_body
        '''
        assert len(args) >= 1
        if len(args) == 1:
            return args[0]
        else:
            return self.__flatten_args(args[i] for i in xrange(0, len(args), 2))

    def p_list_separator(self, args):
        '''
        list_separator ::= COMMA
        list_separator ::= SEMICOLON
        '''
        pass

    def p_list_type(self, args):
        '''
        list_type ::= KEYWORD_LIST LEFT_ANGLE_BRACKET type RIGHT_ANGLE_BRACKET
        '''
        return Ast.ListTypeNode(element_type=args[2])

    def p_list_separator_optional(self, args):
        '''
        list_separator_optional ::= list_separator
        list_separator_optional ::=
        '''
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
        return args[0]

    def p_map_literal(self, args):
        '''
        map_literal ::= LEFT_BRACE map_literal_items RIGHT_BRACE
        '''
        return args[1]

    def p_map_literal_item(self, args):
        '''
        map_literal_item ::= literal COLON literal
        '''
        return (args[0], args[2])

    def p_map_literal_items(self, args):
        '''
        map_literal_items ::= map_literal_item
        map_literal_items ::= map_literal_item COMMA map_literal_items
        '''
        if len(args) == 1:
            return args[0]
        else:
            return dict(args[i] for i in xrange(0, len(args), 2))

    def p_map_type(self, args):
        '''
        map_type ::= KEYWORD_MAP LEFT_ANGLE_BRACKET type COMMA type RIGHT_ANGLE_BRACKET
        '''
        return Ast.MapTypeNode(key_type=args[2], value_type=args[4])

    def p_namespace(self, args):
        '''
        namespace ::= comments KEYWORD_NAMESPACE namespace_scope namespace_name
        '''
        return Ast.NamespaceNode(name=args[3], scope=args[2])

    def p_namespace_name(self, args):
        '''
        namespace_name ::= identifier PERIOD namespace_name
        namespace_name ::= identifier
        '''
        return ''.join(self.__flatten_args(args))

    def p_namespace_scope(self, args):
        '''
        namespace_scope ::= ASTERISK
        namespace_scope ::= identifier
        '''
        return str(args[0])

    def p_semicolon_optional(self, args):
        '''
        semicolon_optional ::= SEMICOLON
        semicolon_optional ::=
        '''
        pass

    def p_service(self, args):
        '''
        service ::= comments KEYWORD_SERVICE identifier LEFT_BRACE functions RIGHT_BRACE
        '''
        return Ast.ServiceNode(name=args[2], functions=args[4])

    def p_set_type(self, args):
        '''
        set_type ::= KEYWORD_SET LEFT_ANGLE_BRACKET type RIGHT_ANGLE_BRACKET
        '''
        return Ast.SetTypeNode(element_type=args[2])

    def p_string_literal(self, args):
        '''
        string_literal ::= QUOTED_STRING
        '''
        return args[0].text[1:-1]

    def p_struct_type(self, args):
        '''
        struct_type ::= comments KEYWORD_STRUCT identifier LEFT_BRACE compound_type_fields RIGHT_BRACE
        '''
        return Ast.StructTypeNode(name=args[2], fields=args[4])

    def p_type(self, args):
        '''
        type ::= list_type
        type ::= map_type
        type ::= set_type
        type ::= identifier
        type ::= identifier PERIOD identifier
        '''
        return args[0]

    def p_typedef(self, args):
        '''
        typedef ::= comments KEYWORD_TYPEDEF type identifier
        '''
        return Ast.TypedefNode(name=args[3], type_=args[2])

    def typestring(self, token):
        return token.type