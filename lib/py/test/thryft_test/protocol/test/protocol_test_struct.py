from __future__ import absolute_import; import decimal
from datetime import datetime
from itertools import ifilterfalse
from time import mktime
import __builtin__
import thryft_test.protocol.test.nested_protocol_test_struct
import thryft_test.protocol.test.protocol_test_enum


class ProtocolTestStruct(object):
    class Builder:
        def __init__(
            self,
            binary_field=None,
            bool_field=None,
            date_time_field=None,
            decimal_field=None,
            email_address_field=None,
            enum_field=None,
            i8_field=None,
            i16_field=None,
            i32_field=None,
            i64_field=None,
            string_list_field=None,
            string_string_map_field=None,
            required_i32_field=None,
            required_string_field=None,
            string_set_field=None,
            string_field=None,
            struct_field=None,
            u32_field=None,
            u64_field=None,
            url_field=None
        ):
            self.__binary_field = binary_field
            self.__bool_field = bool_field
            self.__date_time_field = date_time_field
            self.__decimal_field = decimal_field
            self.__email_address_field = email_address_field
            self.__enum_field = enum_field
            self.__i8_field = i8_field
            self.__i16_field = i16_field
            self.__i32_field = i32_field
            self.__i64_field = i64_field
            self.__string_list_field = string_list_field
            self.__string_string_map_field = string_string_map_field
            self.__required_i32_field = required_i32_field
            self.__required_string_field = required_string_field
            self.__string_set_field = string_set_field
            self.__string_field = string_field
            self.__struct_field = struct_field
            self.__u32_field = u32_field
            self.__u64_field = u64_field
            self.__url_field = url_field

        def build(self):
            return ProtocolTestStruct(binary_field=self.__binary_field, bool_field=self.__bool_field, date_time_field=self.__date_time_field, decimal_field=self.__decimal_field, email_address_field=self.__email_address_field, enum_field=self.__enum_field, i8_field=self.__i8_field, i16_field=self.__i16_field, i32_field=self.__i32_field, i64_field=self.__i64_field, string_list_field=self.__string_list_field, string_string_map_field=self.__string_string_map_field, required_i32_field=self.__required_i32_field, required_string_field=self.__required_string_field, string_set_field=self.__string_set_field, string_field=self.__string_field, struct_field=self.__struct_field, u32_field=self.__u32_field, u64_field=self.__u64_field, url_field=self.__url_field)

        def set_binary_field(self, binary_field):
            self.__binary_field = binary_field
            return self

        def set_bool_field(self, bool_field):
            self.__bool_field = bool_field
            return self

        def set_date_time_field(self, date_time_field):
            self.__date_time_field = date_time_field
            return self

        def set_decimal_field(self, decimal_field):
            self.__decimal_field = decimal_field
            return self

        def set_email_address_field(self, email_address_field):
            self.__email_address_field = email_address_field
            return self

        def set_enum_field(self, enum_field):
            self.__enum_field = enum_field
            return self

        def set_i16_field(self, i16_field):
            self.__i16_field = i16_field
            return self

        def set_i32_field(self, i32_field):
            self.__i32_field = i32_field
            return self

        def set_i64_field(self, i64_field):
            self.__i64_field = i64_field
            return self

        def set_i8_field(self, i8_field):
            self.__i8_field = i8_field
            return self

        def set_required_i32_field(self, required_i32_field):
            self.__required_i32_field = required_i32_field
            return self

        def set_required_string_field(self, required_string_field):
            self.__required_string_field = required_string_field
            return self

        def set_string_field(self, string_field):
            self.__string_field = string_field
            return self

        def set_string_list_field(self, string_list_field):
            self.__string_list_field = string_list_field
            return self

        def set_string_set_field(self, string_set_field):
            self.__string_set_field = string_set_field
            return self

        def set_string_string_map_field(self, string_string_map_field):
            self.__string_string_map_field = string_string_map_field
            return self

        def set_struct_field(self, struct_field):
            self.__struct_field = struct_field
            return self

        def set_u32_field(self, u32_field):
            self.__u32_field = u32_field
            return self

        def set_u64_field(self, u64_field):
            self.__u64_field = u64_field
            return self

        def set_url_field(self, url_field):
            self.__url_field = url_field
            return self

        def update(self, protocol_test_struct):
            if isinstance(protocol_test_struct, ProtocolTestStruct):
                self.set_binary_field(protocol_test_struct.binary_field)
                self.set_bool_field(protocol_test_struct.bool_field)
                self.set_date_time_field(protocol_test_struct.date_time_field)
                self.set_decimal_field(protocol_test_struct.decimal_field)
                self.set_email_address_field(protocol_test_struct.email_address_field)
                self.set_enum_field(protocol_test_struct.enum_field)
                self.set_i8_field(protocol_test_struct.i8_field)
                self.set_i16_field(protocol_test_struct.i16_field)
                self.set_i32_field(protocol_test_struct.i32_field)
                self.set_i64_field(protocol_test_struct.i64_field)
                self.set_string_list_field(protocol_test_struct.string_list_field)
                self.set_string_string_map_field(protocol_test_struct.string_string_map_field)
                self.set_required_i32_field(protocol_test_struct.required_i32_field)
                self.set_required_string_field(protocol_test_struct.required_string_field)
                self.set_string_set_field(protocol_test_struct.string_set_field)
                self.set_string_field(protocol_test_struct.string_field)
                self.set_struct_field(protocol_test_struct.struct_field)
                self.set_u32_field(protocol_test_struct.u32_field)
                self.set_u64_field(protocol_test_struct.u64_field)
                self.set_url_field(protocol_test_struct.url_field)
            elif isinstance(protocol_test_struct, dict):
                for key, value in protocol_test_struct.iteritems():
                    getattr(self, 'set_' + key)(value)
            else:
                raise TypeError(protocol_test_struct)
            return self

    def __init__(
        self,
        required_i32_field,
        required_string_field,
        binary_field=None,
        bool_field=None,
        date_time_field=None,
        decimal_field=None,
        email_address_field=None,
        enum_field=None,
        i8_field=None,
        i16_field=None,
        i32_field=None,
        i64_field=None,
        string_list_field=None,
        string_string_map_field=None,
        string_set_field=None,
        string_field=None,
        struct_field=None,
        u32_field=None,
        u64_field=None,
        url_field=None
    ):
        if binary_field is not None:
            if not isinstance(binary_field, basestring):
                raise TypeError(getattr(__builtin__, 'type')(binary_field))
        self.__binary_field = binary_field

        if bool_field is not None:
            if not isinstance(bool_field, bool):
                raise TypeError(getattr(__builtin__, 'type')(bool_field))
        self.__bool_field = bool_field

        if date_time_field is not None:
            if not isinstance(date_time_field, datetime):
                raise TypeError(getattr(__builtin__, 'type')(date_time_field))
        self.__date_time_field = date_time_field

        if decimal_field is not None:
            if not isinstance(decimal_field, decimal.Decimal):
                raise TypeError(getattr(__builtin__, 'type')(decimal_field))
        self.__decimal_field = decimal_field

        if email_address_field is not None:
            if not isinstance(email_address_field, str):
                raise TypeError(getattr(__builtin__, 'type')(email_address_field))
        self.__email_address_field = email_address_field

        if enum_field is not None:
            if not isinstance(enum_field, thryft_test.protocol.test.protocol_test_enum.ProtocolTestEnum):
                raise TypeError(getattr(__builtin__, 'type')(enum_field))
        self.__enum_field = enum_field

        if i8_field is not None:
            if not isinstance(i8_field, int):
                raise TypeError(getattr(__builtin__, 'type')(i8_field))
        self.__i8_field = i8_field

        if i16_field is not None:
            if not isinstance(i16_field, int):
                raise TypeError(getattr(__builtin__, 'type')(i16_field))
        self.__i16_field = i16_field

        if i32_field is not None:
            if not isinstance(i32_field, int):
                raise TypeError(getattr(__builtin__, 'type')(i32_field))
        self.__i32_field = i32_field

        if i64_field is not None:
            if not isinstance(i64_field, (int, long)):
                raise TypeError(getattr(__builtin__, 'type')(i64_field))
        self.__i64_field = i64_field

        if string_list_field is not None:
            if not (isinstance(string_list_field, tuple) and len(list(ifilterfalse(lambda _: isinstance(_, basestring), string_list_field))) == 0):
                raise TypeError(getattr(__builtin__, 'type')(string_list_field))
        self.__string_list_field = string_list_field

        if string_string_map_field is not None:
            if not (isinstance(string_string_map_field, dict) and len(list(ifilterfalse(lambda __item: isinstance(__item[0], basestring) and isinstance(__item[1], basestring), string_string_map_field.iteritems()))) == 0):
                raise TypeError(getattr(__builtin__, 'type')(string_string_map_field))
        self.__string_string_map_field = string_string_map_field.copy() if string_string_map_field is not None else None

        if required_i32_field is None:
            raise ValueError('required_i32_field is required')
        if not isinstance(required_i32_field, int):
            raise TypeError(getattr(__builtin__, 'type')(required_i32_field))
        self.__required_i32_field = required_i32_field

        if required_string_field is None:
            raise ValueError('required_string_field is required')
        if not isinstance(required_string_field, basestring):
            raise TypeError(getattr(__builtin__, 'type')(required_string_field))
        self.__required_string_field = required_string_field

        if string_set_field is not None:
            if not (isinstance(string_set_field, frozenset) and len(list(ifilterfalse(lambda _: isinstance(_, basestring), string_set_field))) == 0):
                raise TypeError(getattr(__builtin__, 'type')(string_set_field))
        self.__string_set_field = string_set_field

        if string_field is not None:
            if not isinstance(string_field, basestring):
                raise TypeError(getattr(__builtin__, 'type')(string_field))
        self.__string_field = string_field

        if struct_field is not None:
            if not isinstance(struct_field, thryft_test.protocol.test.nested_protocol_test_struct.NestedProtocolTestStruct):
                raise TypeError(getattr(__builtin__, 'type')(struct_field))
        self.__struct_field = struct_field

        if u32_field is not None:
            if not isinstance(u32_field, int) and u32_field >= 0:
                raise TypeError(getattr(__builtin__, 'type')(u32_field))
        self.__u32_field = u32_field

        if u64_field is not None:
            if not isinstance(u64_field, long) and u64_field >= 0:
                raise TypeError(getattr(__builtin__, 'type')(u64_field))
        self.__u64_field = u64_field

        if url_field is not None:
            if not isinstance(url_field, str):
                raise TypeError(getattr(__builtin__, 'type')(url_field))
        self.__url_field = url_field

    def __eq__(self, other):
        if self.binary_field != other.binary_field:
            return False
        if self.bool_field != other.bool_field:
            return False
        if self.date_time_field != other.date_time_field:
            return False
        if self.decimal_field != other.decimal_field:
            return False
        if self.email_address_field != other.email_address_field:
            return False
        if self.enum_field != other.enum_field:
            return False
        if self.i8_field != other.i8_field:
            return False
        if self.i16_field != other.i16_field:
            return False
        if self.i32_field != other.i32_field:
            return False
        if self.i64_field != other.i64_field:
            return False
        if self.string_list_field != other.string_list_field:
            return False
        if self.string_string_map_field != other.string_string_map_field:
            return False
        if self.required_i32_field != other.required_i32_field:
            return False
        if self.required_string_field != other.required_string_field:
            return False
        if self.string_set_field != other.string_set_field:
            return False
        if self.string_field != other.string_field:
            return False
        if self.struct_field != other.struct_field:
            return False
        if self.u32_field != other.u32_field:
            return False
        if self.u64_field != other.u64_field:
            return False
        if self.url_field != other.url_field:
            return False
        return True

    def __hash__(self):
        return hash((self.binary_field,self.bool_field,self.date_time_field,self.decimal_field,self.email_address_field,self.enum_field,self.i8_field,self.i16_field,self.i32_field,self.i64_field,self.string_list_field,self.string_string_map_field,self.required_i32_field,self.required_string_field,self.string_set_field,self.string_field,self.struct_field,self.u32_field,self.u64_field,self.url_field,))

    def __ne__(self, other):
        return not self.__eq__(other)

    def __repr__(self):
        field_reprs = []
        if self.binary_field is not None:
            field_reprs.append('binary_field=' + "'" + self.binary_field.encode('ascii', 'replace') + "'")
        if self.bool_field is not None:
            field_reprs.append('bool_field=' + repr(self.bool_field))
        if self.date_time_field is not None:
            field_reprs.append('date_time_field=' + repr(self.date_time_field))
        if self.decimal_field is not None:
            field_reprs.append('decimal_field=' + repr(self.decimal_field))
        if self.email_address_field is not None:
            field_reprs.append('email_address_field=' + repr(self.email_address_field))
        if self.enum_field is not None:
            field_reprs.append('enum_field=' + repr(self.enum_field))
        if self.i8_field is not None:
            field_reprs.append('i8_field=' + repr(self.i8_field))
        if self.i16_field is not None:
            field_reprs.append('i16_field=' + repr(self.i16_field))
        if self.i32_field is not None:
            field_reprs.append('i32_field=' + repr(self.i32_field))
        if self.i64_field is not None:
            field_reprs.append('i64_field=' + repr(self.i64_field))
        if self.string_list_field is not None:
            field_reprs.append('string_list_field=' + repr(self.string_list_field))
        if self.string_string_map_field is not None:
            field_reprs.append('string_string_map_field=' + repr(self.string_string_map_field))
        field_reprs.append('required_i32_field=' + repr(self.required_i32_field))
        field_reprs.append('required_string_field=' + "'" + self.required_string_field.encode('ascii', 'replace') + "'")
        if self.string_set_field is not None:
            field_reprs.append('string_set_field=' + repr(self.string_set_field))
        if self.string_field is not None:
            field_reprs.append('string_field=' + "'" + self.string_field.encode('ascii', 'replace') + "'")
        if self.struct_field is not None:
            field_reprs.append('struct_field=' + repr(self.struct_field))
        if self.u32_field is not None:
            field_reprs.append('u32_field=' + repr(self.u32_field))
        if self.u64_field is not None:
            field_reprs.append('u64_field=' + repr(self.u64_field))
        if self.url_field is not None:
            field_reprs.append('url_field=' + repr(self.url_field))
        return 'ProtocolTestStruct(' + ', '.join(field_reprs) + ')'

    def __str__(self):
        field_reprs = []
        if self.binary_field is not None:
            field_reprs.append('binary_field=' + "'" + self.binary_field.encode('ascii', 'replace') + "'")
        if self.bool_field is not None:
            field_reprs.append('bool_field=' + repr(self.bool_field))
        if self.date_time_field is not None:
            field_reprs.append('date_time_field=' + repr(self.date_time_field))
        if self.decimal_field is not None:
            field_reprs.append('decimal_field=' + repr(self.decimal_field))
        if self.email_address_field is not None:
            field_reprs.append('email_address_field=' + repr(self.email_address_field))
        if self.enum_field is not None:
            field_reprs.append('enum_field=' + repr(self.enum_field))
        if self.i8_field is not None:
            field_reprs.append('i8_field=' + repr(self.i8_field))
        if self.i16_field is not None:
            field_reprs.append('i16_field=' + repr(self.i16_field))
        if self.i32_field is not None:
            field_reprs.append('i32_field=' + repr(self.i32_field))
        if self.i64_field is not None:
            field_reprs.append('i64_field=' + repr(self.i64_field))
        if self.string_list_field is not None:
            field_reprs.append('string_list_field=' + repr(self.string_list_field))
        if self.string_string_map_field is not None:
            field_reprs.append('string_string_map_field=' + repr(self.string_string_map_field))
        field_reprs.append('required_i32_field=' + repr(self.required_i32_field))
        field_reprs.append('required_string_field=' + "'" + self.required_string_field.encode('ascii', 'replace') + "'")
        if self.string_set_field is not None:
            field_reprs.append('string_set_field=' + repr(self.string_set_field))
        if self.string_field is not None:
            field_reprs.append('string_field=' + "'" + self.string_field.encode('ascii', 'replace') + "'")
        if self.struct_field is not None:
            field_reprs.append('struct_field=' + repr(self.struct_field))
        if self.u32_field is not None:
            field_reprs.append('u32_field=' + repr(self.u32_field))
        if self.u64_field is not None:
            field_reprs.append('u64_field=' + repr(self.u64_field))
        if self.url_field is not None:
            field_reprs.append('url_field=' + repr(self.url_field))
        return 'ProtocolTestStruct(' + ', '.join(field_reprs) + ')'

    def as_dict(self):
        return {'binary_field': self.binary_field, 'bool_field': self.bool_field, 'date_time_field': self.date_time_field, 'decimal_field': self.decimal_field, 'email_address_field': self.email_address_field, 'enum_field': self.enum_field, 'i8_field': self.i8_field, 'i16_field': self.i16_field, 'i32_field': self.i32_field, 'i64_field': self.i64_field, 'string_list_field': self.string_list_field, 'string_string_map_field': self.string_string_map_field, 'required_i32_field': self.required_i32_field, 'required_string_field': self.required_string_field, 'string_set_field': self.string_set_field, 'string_field': self.string_field, 'struct_field': self.struct_field, 'u32_field': self.u32_field, 'u64_field': self.u64_field, 'url_field': self.url_field}

    @property
    def binary_field(self):
        return self.__binary_field

    @property
    def bool_field(self):
        return self.__bool_field

    @property
    def date_time_field(self):
        return self.__date_time_field

    @property
    def decimal_field(self):
        return self.__decimal_field

    @property
    def email_address_field(self):
        return self.__email_address_field

    @property
    def enum_field(self):
        return self.__enum_field

    @property
    def i16_field(self):
        return self.__i16_field

    @property
    def i32_field(self):
        return self.__i32_field

    @property
    def i64_field(self):
        return self.__i64_field

    @property
    def i8_field(self):
        return self.__i8_field

    @classmethod
    def read(cls, iprot):
        init_kwds = {}

        iprot.readStructBegin()
        while True:
            ifield_name, ifield_type, _ifield_id = iprot.readFieldBegin()
            if ifield_type == 0: # STOP
                break
            elif ifield_name == 'binary_field':
                try:
                    init_kwds['binary_field'] = iprot.readBinary()
                except (TypeError, ValueError,):
                    pass
            elif ifield_name == 'bool_field':
                try:
                    init_kwds['bool_field'] = iprot.readBool()
                except (TypeError, ValueError,):
                    pass
            elif ifield_name == 'date_time_field':
                try:
                    init_kwds['date_time_field'] = iprot.readDateTime()
                except (TypeError,):
                    pass
            elif ifield_name == 'decimal_field':
                try:
                    init_kwds['decimal_field'] = iprot.readDecimal()
                except (decimal.InvalidOperation, TypeError,):
                    pass
            elif ifield_name == 'email_address_field':
                init_kwds['email_address_field'] = iprot.readString()
            elif ifield_name == 'enum_field':
                try:
                    init_kwds['enum_field'] = thryft_test.protocol.test.protocol_test_enum.ProtocolTestEnum.value_of(iprot.readString().strip().upper())
                except (TypeError,):
                    pass
            elif ifield_name == 'i8_field':
                try:
                    init_kwds['i8_field'] = iprot.readByte()
                except (TypeError, ValueError,):
                    pass
            elif ifield_name == 'i16_field':
                try:
                    init_kwds['i16_field'] = iprot.readI16()
                except (TypeError, ValueError,):
                    pass
            elif ifield_name == 'i32_field':
                try:
                    init_kwds['i32_field'] = iprot.readI32()
                except (TypeError, ValueError,):
                    pass
            elif ifield_name == 'i64_field':
                try:
                    init_kwds['i64_field'] = iprot.readI64()
                except (TypeError, ValueError,):
                    pass
            elif ifield_name == 'string_list_field':
                init_kwds['string_list_field'] = tuple([iprot.readString() for _ in xrange(iprot.readListBegin()[1])] + (iprot.readListEnd() is None and []))
            elif ifield_name == 'string_string_map_field':
                init_kwds['string_string_map_field'] = dict([(iprot.readString(), iprot.readString()) for _ in xrange(iprot.readMapBegin()[2])] + (iprot.readMapEnd() is None and []))
            elif ifield_name == 'required_i32_field':
                init_kwds['required_i32_field'] = iprot.readI32()
            elif ifield_name == 'required_string_field':
                init_kwds['required_string_field'] = iprot.readString()
            elif ifield_name == 'string_set_field':
                init_kwds['string_set_field'] = frozenset([iprot.readString() for _ in xrange(iprot.readSetBegin()[1])] + (iprot.readSetEnd() is None and []))
            elif ifield_name == 'string_field':
                try:
                    init_kwds['string_field'] = iprot.readString()
                except (TypeError, ValueError,):
                    pass
            elif ifield_name == 'struct_field':
                init_kwds['struct_field'] = thryft_test.protocol.test.nested_protocol_test_struct.NestedProtocolTestStruct.read(iprot)
            elif ifield_name == 'u32_field':
                try:
                    init_kwds['u32_field'] = iprot.readU32()
                except (TypeError,):
                    pass
            elif ifield_name == 'u64_field':
                try:
                    init_kwds['u64_field'] = iprot.readU64()
                except (TypeError,):
                    pass
            elif ifield_name == 'url_field':
                init_kwds['url_field'] = iprot.readString()
            iprot.readFieldEnd()
        iprot.readStructEnd()

        return cls(**init_kwds)

    def replace(self, binary_field=None, bool_field=None, date_time_field=None, decimal_field=None, email_address_field=None, enum_field=None, i8_field=None, i16_field=None, i32_field=None, i64_field=None, string_list_field=None, string_string_map_field=None, required_i32_field=None, required_string_field=None, string_set_field=None, string_field=None, struct_field=None, u32_field=None, u64_field=None, url_field=None):
        if binary_field is None:
            binary_field = self.binary_field
        if bool_field is None:
            bool_field = self.bool_field
        if date_time_field is None:
            date_time_field = self.date_time_field
        if decimal_field is None:
            decimal_field = self.decimal_field
        if email_address_field is None:
            email_address_field = self.email_address_field
        if enum_field is None:
            enum_field = self.enum_field
        if i8_field is None:
            i8_field = self.i8_field
        if i16_field is None:
            i16_field = self.i16_field
        if i32_field is None:
            i32_field = self.i32_field
        if i64_field is None:
            i64_field = self.i64_field
        if string_list_field is None:
            string_list_field = self.string_list_field
        if string_string_map_field is None:
            string_string_map_field = self.string_string_map_field
        if required_i32_field is None:
            required_i32_field = self.required_i32_field
        if required_string_field is None:
            required_string_field = self.required_string_field
        if string_set_field is None:
            string_set_field = self.string_set_field
        if string_field is None:
            string_field = self.string_field
        if struct_field is None:
            struct_field = self.struct_field
        if u32_field is None:
            u32_field = self.u32_field
        if u64_field is None:
            u64_field = self.u64_field
        if url_field is None:
            url_field = self.url_field
        return self.__class__(binary_field=binary_field, bool_field=bool_field, date_time_field=date_time_field, decimal_field=decimal_field, email_address_field=email_address_field, enum_field=enum_field, i8_field=i8_field, i16_field=i16_field, i32_field=i32_field, i64_field=i64_field, string_list_field=string_list_field, string_string_map_field=string_string_map_field, required_i32_field=required_i32_field, required_string_field=required_string_field, string_set_field=string_set_field, string_field=string_field, struct_field=struct_field, u32_field=u32_field, u64_field=u64_field, url_field=url_field)

    @property
    def required_i32_field(self):
        return self.__required_i32_field

    @property
    def required_string_field(self):
        return self.__required_string_field

    @property
    def string_field(self):
        return self.__string_field

    @property
    def string_list_field(self):
        return self.__string_list_field

    @property
    def string_set_field(self):
        return self.__string_set_field

    @property
    def string_string_map_field(self):
        return self.__string_string_map_field.copy() if self.__string_string_map_field is not None else None

    @property
    def struct_field(self):
        return self.__struct_field

    @property
    def u32_field(self):
        return self.__u32_field

    @property
    def u64_field(self):
        return self.__u64_field

    @property
    def url_field(self):
        return self.__url_field

    def write(self, oprot):
        oprot.writeStructBegin('ProtocolTestStruct')

        if self.binary_field is not None:
            oprot.writeFieldBegin('binary_field', 11, -1)
            oprot.writeBinary(self.binary_field)
            oprot.writeFieldEnd()

        if self.bool_field is not None:
            oprot.writeFieldBegin('bool_field', 2, -1)
            oprot.writeBool(self.bool_field)
            oprot.writeFieldEnd()

        if self.date_time_field is not None:
            oprot.writeFieldBegin('date_time_field', 10, -1)
            oprot.writeDateTime(self.date_time_field)
            oprot.writeFieldEnd()

        if self.decimal_field is not None:
            oprot.writeFieldBegin('decimal_field', 11, -1)
            oprot.writeDecimal(self.decimal_field)
            oprot.writeFieldEnd()

        if self.email_address_field is not None:
            oprot.writeFieldBegin('email_address_field', 11, -1)
            oprot.writeEmailAddress(self.email_address_field)
            oprot.writeFieldEnd()

        if self.enum_field is not None:
            oprot.writeFieldBegin('enum_field', 11, -1)
            oprot.writeString([attr for attr in dir(thryft_test.protocol.test.protocol_test_enum.ProtocolTestEnum) if getattr(thryft_test.protocol.test.protocol_test_enum.ProtocolTestEnum, attr) == self.enum_field][0])
            oprot.writeFieldEnd()

        if self.i8_field is not None:
            oprot.writeFieldBegin('i8_field', 3, -1)
            oprot.writeByte(self.i8_field)
            oprot.writeFieldEnd()

        if self.i16_field is not None:
            oprot.writeFieldBegin('i16_field', 6, -1)
            oprot.writeI16(self.i16_field)
            oprot.writeFieldEnd()

        if self.i32_field is not None:
            oprot.writeFieldBegin('i32_field', 8, -1)
            oprot.writeI32(self.i32_field)
            oprot.writeFieldEnd()

        if self.i64_field is not None:
            oprot.writeFieldBegin('i64_field', 10, -1)
            oprot.writeI64(self.i64_field)
            oprot.writeFieldEnd()

        if self.string_list_field is not None:
            oprot.writeFieldBegin('string_list_field', 15, -1)
            oprot.writeListBegin(11, len(self.string_list_field))
            for _0 in self.string_list_field:
                oprot.writeString(_0)
            oprot.writeListEnd()
            oprot.writeFieldEnd()

        if self.string_string_map_field is not None:
            oprot.writeFieldBegin('string_string_map_field', 13, -1)
            oprot.writeMapBegin(11, len(self.string_string_map_field), 11)
            for __key0, __value0 in self.string_string_map_field.iteritems():
                oprot.writeString(__key0)
                oprot.writeString(__value0)
            oprot.writeMapEnd()
            oprot.writeFieldEnd()

        oprot.writeFieldBegin('required_i32_field', 8, -1)
        oprot.writeI32(self.required_i32_field)
        oprot.writeFieldEnd()

        oprot.writeFieldBegin('required_string_field', 11, -1)
        oprot.writeString(self.required_string_field)
        oprot.writeFieldEnd()

        if self.string_set_field is not None:
            oprot.writeFieldBegin('string_set_field', 14, -1)
            oprot.writeSetBegin(11, len(self.string_set_field))
            for _0 in self.string_set_field:
                oprot.writeString(_0)
            oprot.writeSetEnd()
            oprot.writeFieldEnd()

        if self.string_field is not None:
            oprot.writeFieldBegin('string_field', 11, -1)
            oprot.writeString(self.string_field)
            oprot.writeFieldEnd()

        if self.struct_field is not None:
            oprot.writeFieldBegin('struct_field', 12, -1)
            self.struct_field.write(oprot)
            oprot.writeFieldEnd()

        if self.u32_field is not None:
            oprot.writeFieldBegin('u32_field', 8, -1)
            oprot.writeU32(self.u32_field)
            oprot.writeFieldEnd()

        if self.u64_field is not None:
            oprot.writeFieldBegin('u64_field', 10, -1)
            oprot.writeU64(self.u64_field)
            oprot.writeFieldEnd()

        if self.url_field is not None:
            oprot.writeFieldBegin('url_field', 11, -1)
            oprot.writeUrl(self.url_field)
            oprot.writeFieldEnd()

        oprot.writeFieldStop()

        oprot.writeStructEnd()

        return self
