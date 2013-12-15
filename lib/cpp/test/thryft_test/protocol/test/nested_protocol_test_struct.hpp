#ifndef _THRYFT_TEST_PROTOCOL_TEST_NESTED_PROTOCOL_TEST_STRUCT_HPP_
#define _THRYFT_TEST_PROTOCOL_TEST_NESTED_PROTOCOL_TEST_STRUCT_HPP_

#include <string>
#include <cstdint>

#include <thryft.hpp>

#include "thryft_test/protocol/test/protocol_test_enum.hpp"

namespace thryft_test {
namespace protocol {
namespace test {
class NestedProtocolTestStruct : public ::thryft::Struct {
public:
  NestedProtocolTestStruct()
    : required_i32_field_(static_cast<int32_t>(0)) {
  }

  NestedProtocolTestStruct(::thryft::protocol::Protocol& iprot) {
    read(iprot);
  }

  NestedProtocolTestStruct(::thryft::protocol::Protocol& iprot, ::thryft::protocol::Protocol::Type::Enum as_type) {
    read(iprot, as_type);
  }

  NestedProtocolTestStruct(const int32_t& required_i32_field, const ::std::string& required_string_field)
    : required_i32_field_(required_i32_field), required_string_field_(required_string_field) {
  }

  NestedProtocolTestStruct(const ::thryft::Optional< ::std::string >& binary_field, const ::thryft::Optional< bool >& bool_field, const ::thryft::Optional< int8_t >& byte_field, const ::thryft::Optional< int64_t >& date_time_field, const ::thryft::Optional< ::std::string >& decimal_field, const ::thryft::Optional< ::std::string >& email_address_field, const ::thryft::Optional< ::thryft_test::protocol::test::ProtocolTestEnum::Enum >& enum_field, const ::thryft::Optional< int16_t >& i16_field, const ::thryft::Optional< int32_t >& i32_field, const ::thryft::Optional< int64_t >& i64_field, const ::thryft::Optional< ::thryft::List< ::std::string, ::thryft::protocol::Protocol::Type::STRING > >& list_string_field, const ::thryft::Optional< ::thryft::Map< ::std::string, ::thryft::protocol::Protocol::Type::STRING, ::std::string, ::thryft::protocol::Protocol::Type::STRING > >& map_string_string_field, const int32_t& required_i32_field, const ::std::string& required_string_field, const ::thryft::Optional< ::thryft::Set< ::std::string, ::thryft::protocol::Protocol::Type::STRING > >& set_string_field, const ::thryft::Optional< ::std::string >& string_field, const ::thryft::Optional< ::std::string >& url_field)
    : binary_field_(binary_field), bool_field_(bool_field), byte_field_(byte_field), date_time_field_(date_time_field), decimal_field_(decimal_field), email_address_field_(email_address_field), enum_field_(enum_field), i16_field_(i16_field), i32_field_(i32_field), i64_field_(i64_field), list_string_field_(list_string_field), map_string_string_field_(map_string_string_field), required_i32_field_(required_i32_field), required_string_field_(required_string_field), set_string_field_(set_string_field), string_field_(string_field), url_field_(url_field) {
  }

  virtual ~NestedProtocolTestStruct() {
  }

  const ::thryft::Optional< ::std::string >& binary_field() const {
    return binary_field_;
  }

  const ::thryft::Optional< bool >& bool_field() const {
    return bool_field_;
  }

  const ::thryft::Optional< int8_t >& byte_field() const {
    return byte_field_;
  }

  const ::thryft::Optional< int64_t >& date_time_field() const {
    return date_time_field_;
  }

  const ::thryft::Optional< ::std::string >& decimal_field() const {
    return decimal_field_;
  }

  const ::thryft::Optional< ::std::string >& email_address_field() const {
    return email_address_field_;
  }

  const ::thryft::Optional< ::thryft_test::protocol::test::ProtocolTestEnum::Enum >& enum_field() const {
    return enum_field_;
  }

  const ::thryft::Optional< int16_t >& i16_field() const {
    return i16_field_;
  }

  const ::thryft::Optional< int32_t >& i32_field() const {
    return i32_field_;
  }

  const ::thryft::Optional< int64_t >& i64_field() const {
    return i64_field_;
  }

  const ::thryft::Optional< ::thryft::List< ::std::string, ::thryft::protocol::Protocol::Type::STRING > >& list_string_field() const {
    return list_string_field_;
  }

  const ::thryft::Optional< ::thryft::Map< ::std::string, ::thryft::protocol::Protocol::Type::STRING, ::std::string, ::thryft::protocol::Protocol::Type::STRING > >& map_string_string_field() const {
    return map_string_string_field_;
  }

  const int32_t& required_i32_field() const {
    return required_i32_field_;
  }

  const ::std::string& required_string_field() const {
    return required_string_field_;
  }

  const ::thryft::Optional< ::thryft::Set< ::std::string, ::thryft::protocol::Protocol::Type::STRING > >& set_string_field() const {
    return set_string_field_;
  }

  const ::thryft::Optional< ::std::string >& string_field() const {
    return string_field_;
  }

  const ::thryft::Optional< ::std::string >& url_field() const {
    return url_field_;
  }

  NestedProtocolTestStruct& set_binary_field(const ::thryft::Optional< ::std::string >& binary_field) {
    this->binary_field_ = binary_field;
    return *this;
  }

  NestedProtocolTestStruct& set_bool_field(const ::thryft::Optional< bool >& bool_field) {
    this->bool_field_ = bool_field;
    return *this;
  }

  NestedProtocolTestStruct& set_byte_field(const ::thryft::Optional< int8_t >& byte_field) {
    this->byte_field_ = byte_field;
    return *this;
  }

  NestedProtocolTestStruct& set_date_time_field(const ::thryft::Optional< int64_t >& date_time_field) {
    this->date_time_field_ = date_time_field;
    return *this;
  }

  NestedProtocolTestStruct& set_decimal_field(const ::thryft::Optional< ::std::string >& decimal_field) {
    this->decimal_field_ = decimal_field;
    return *this;
  }

  NestedProtocolTestStruct& set_email_address_field(const ::thryft::Optional< ::std::string >& email_address_field) {
    this->email_address_field_ = email_address_field;
    return *this;
  }

  NestedProtocolTestStruct& set_enum_field(const ::thryft::Optional< ::thryft_test::protocol::test::ProtocolTestEnum::Enum >& enum_field) {
    this->enum_field_ = enum_field;
    return *this;
  }

  NestedProtocolTestStruct& set_i16_field(const ::thryft::Optional< int16_t >& i16_field) {
    this->i16_field_ = i16_field;
    return *this;
  }

  NestedProtocolTestStruct& set_i32_field(const ::thryft::Optional< int32_t >& i32_field) {
    this->i32_field_ = i32_field;
    return *this;
  }

  NestedProtocolTestStruct& set_i64_field(const ::thryft::Optional< int64_t >& i64_field) {
    this->i64_field_ = i64_field;
    return *this;
  }

  NestedProtocolTestStruct& set_list_string_field(const ::thryft::Optional< ::thryft::List< ::std::string, ::thryft::protocol::Protocol::Type::STRING > >& list_string_field) {
    this->list_string_field_ = list_string_field;
    return *this;
  }

  NestedProtocolTestStruct& set_map_string_string_field(const ::thryft::Optional< ::thryft::Map< ::std::string, ::thryft::protocol::Protocol::Type::STRING, ::std::string, ::thryft::protocol::Protocol::Type::STRING > >& map_string_string_field) {
    this->map_string_string_field_ = map_string_string_field;
    return *this;
  }

  NestedProtocolTestStruct& set_required_i32_field(const int32_t& required_i32_field) {
    this->required_i32_field_ = required_i32_field;
    return *this;
  }

  NestedProtocolTestStruct& set_required_string_field(const ::std::string& required_string_field) {
    this->required_string_field_ = required_string_field;
    return *this;
  }

  NestedProtocolTestStruct& set_set_string_field(const ::thryft::Optional< ::thryft::Set< ::std::string, ::thryft::protocol::Protocol::Type::STRING > >& set_string_field) {
    this->set_string_field_ = set_string_field;
    return *this;
  }

  NestedProtocolTestStruct& set_string_field(const ::thryft::Optional< ::std::string >& string_field) {
    this->string_field_ = string_field;
    return *this;
  }

  NestedProtocolTestStruct& set_url_field(const ::thryft::Optional< ::std::string >& url_field) {
    this->url_field_ = url_field;
    return *this;
  }

  void read(::thryft::protocol::Protocol& iprot) {
    read(iprot, ::thryft::protocol::Protocol::Type::STRUCT);
  }

  void read(::thryft::protocol::Protocol& iprot, ::thryft::protocol::Protocol::Type::Enum as_type) {
    switch (as_type) {
      case ::thryft::protocol::Protocol::Type::LIST: {
        ::thryft::protocol::Protocol::Type::Enum list_element_type;
        uint32_t list_size;
        iprot.read_list_begin(list_element_type, list_size);
        binary_field_ = iprot.read_string();
        bool_field_ = iprot.read_bool();
        byte_field_ = iprot.read_byte();
        date_time_field_ = iprot.read_i64();
        decimal_field_ = iprot.read_string();
        email_address_field_ = iprot.read_string();
        enum_field_ = ::thryft_test::protocol::test::ProtocolTestEnum::read(iprot);
        i16_field_ = iprot.read_i16();
        i32_field_ = iprot.read_i32();
        i64_field_ = iprot.read_i64();
        list_string_field_.set(::thryft::List< ::std::string, ::thryft::protocol::Protocol::Type::STRING >())->read(iprot);
        map_string_string_field_.set(::thryft::Map< ::std::string, ::thryft::protocol::Protocol::Type::STRING, ::std::string, ::thryft::protocol::Protocol::Type::STRING >())->read(iprot);
        required_i32_field_ = iprot.read_i32();
        iprot.read_string(required_string_field_);
        if (list_size > 14) {
          set_string_field_.set(::thryft::Set< ::std::string, ::thryft::protocol::Protocol::Type::STRING >())->read(iprot);
        }
        if (list_size > 15) {
          string_field_ = iprot.read_string();
        }
        if (list_size > 16) {
          url_field_ = iprot.read_string();
        }
        iprot.read_list_end();
        break;
      }

      case ::thryft::protocol::Protocol::Type::STRUCT:
      default: {
        iprot.read_struct_begin();
        int16_t ifield_id;
        ::std::string ifield_name;
        ::thryft::protocol::Protocol::Type::Enum ifield_type;
        for (;;) {
          iprot.read_field_begin(ifield_name, ifield_type, ifield_id);
          if (ifield_type == ::thryft::protocol::Protocol::Type::STOP) {
            break;
          } else if (ifield_name == "binary_field") {
            binary_field_ = iprot.read_string();
          } else if (ifield_name == "bool_field") {
            bool_field_ = iprot.read_bool();
          } else if (ifield_name == "byte_field") {
            byte_field_ = iprot.read_byte();
          } else if (ifield_name == "date_time_field") {
            date_time_field_ = iprot.read_i64();
          } else if (ifield_name == "decimal_field") {
            decimal_field_ = iprot.read_string();
          } else if (ifield_name == "email_address_field") {
            email_address_field_ = iprot.read_string();
          } else if (ifield_name == "enum_field") {
            enum_field_ = ::thryft_test::protocol::test::ProtocolTestEnum::read(iprot);
          } else if (ifield_name == "i16_field") {
            i16_field_ = iprot.read_i16();
          } else if (ifield_name == "i32_field") {
            i32_field_ = iprot.read_i32();
          } else if (ifield_name == "i64_field") {
            i64_field_ = iprot.read_i64();
          } else if (ifield_name == "list_string_field") {
            list_string_field_.set(::thryft::List< ::std::string, ::thryft::protocol::Protocol::Type::STRING >())->read(iprot);
          } else if (ifield_name == "map_string_string_field") {
            map_string_string_field_.set(::thryft::Map< ::std::string, ::thryft::protocol::Protocol::Type::STRING, ::std::string, ::thryft::protocol::Protocol::Type::STRING >())->read(iprot);
          } else if (ifield_name == "required_i32_field") {
            required_i32_field_ = iprot.read_i32();
          } else if (ifield_name == "required_string_field") {
            iprot.read_string(required_string_field_);
          } else if (ifield_name == "set_string_field") {
            set_string_field_.set(::thryft::Set< ::std::string, ::thryft::protocol::Protocol::Type::STRING >())->read(iprot);
          } else if (ifield_name == "string_field") {
            string_field_ = iprot.read_string();
          } else if (ifield_name == "url_field") {
            url_field_ = iprot.read_string();
          }
          iprot.read_field_end();
        }
        iprot.read_struct_end();
        break;
      }
    }
  }

  void write(::thryft::protocol::Protocol& oprot) const {
    write(oprot, ::thryft::protocol::Protocol::Type::STRUCT);
  }

  void write(::thryft::protocol::Protocol& oprot, ::thryft::protocol::Protocol::Type::Enum as_type) const {
    switch (as_type) {
    case ::thryft::protocol::Protocol::Type::VOID:
    case ::thryft::protocol::Protocol::Type::LIST:
      oprot.write_list_begin(::thryft::protocol::Protocol::Type::VOID, 17);

      if (binary_field().present()) {
          oprot.write(binary_field().get());
      } else {
          oprot.write_null();
      }

      if (bool_field().present()) {
          oprot.write(bool_field().get());
      } else {
          oprot.write_null();
      }

      if (byte_field().present()) {
          oprot.write(byte_field().get());
      } else {
          oprot.write_null();
      }

      if (date_time_field().present()) {
          oprot.write(date_time_field().get());
      } else {
          oprot.write_null();
      }

      if (decimal_field().present()) {
          oprot.write(decimal_field().get());
      } else {
          oprot.write_null();
      }

      if (email_address_field().present()) {
          oprot.write(email_address_field().get());
      } else {
          oprot.write_null();
      }

      if (enum_field().present()) {
          ::thryft_test::protocol::test::ProtocolTestEnum::write(oprot, enum_field().get());
      } else {
          oprot.write_null();
      }

      if (i16_field().present()) {
          oprot.write(i16_field().get());
      } else {
          oprot.write_null();
      }

      if (i32_field().present()) {
          oprot.write(i32_field().get());
      } else {
          oprot.write_null();
      }

      if (i64_field().present()) {
          oprot.write(i64_field().get());
      } else {
          oprot.write_null();
      }

      if (list_string_field().present()) {
          oprot.write(list_string_field().get());
      } else {
          oprot.write_null();
      }

      if (map_string_string_field().present()) {
          oprot.write(map_string_string_field().get());
      } else {
          oprot.write_null();
      }

      oprot.write(required_i32_field());

      oprot.write(required_string_field());

      if (set_string_field().present()) {
          oprot.write(set_string_field().get());
      } else {
          oprot.write_null();
      }

      if (string_field().present()) {
          oprot.write(string_field().get());
      } else {
          oprot.write_null();
      }

      if (url_field().present()) {
          oprot.write(url_field().get());
      } else {
          oprot.write_null();
      }

      oprot.write_list_end();
      break;

    case ::thryft::protocol::Protocol::Type::STRUCT:
    default:
      oprot.write_struct_begin();

      if (binary_field().present()) {
          oprot.write_field_begin("binary_field", ::thryft::protocol::Protocol::Type::STRING, static_cast<int16_t>(-1));
          oprot.write(binary_field().get());
          oprot.write_field_end();
      }

      if (bool_field().present()) {
          oprot.write_field_begin("bool_field", ::thryft::protocol::Protocol::Type::BOOL, static_cast<int16_t>(-1));
          oprot.write(bool_field().get());
          oprot.write_field_end();
      }

      if (byte_field().present()) {
          oprot.write_field_begin("byte_field", ::thryft::protocol::Protocol::Type::BYTE, static_cast<int16_t>(-1));
          oprot.write(byte_field().get());
          oprot.write_field_end();
      }

      if (date_time_field().present()) {
          oprot.write_field_begin("date_time_field", ::thryft::protocol::Protocol::Type::I64, static_cast<int16_t>(-1));
          oprot.write(date_time_field().get());
          oprot.write_field_end();
      }

      if (decimal_field().present()) {
          oprot.write_field_begin("decimal_field", ::thryft::protocol::Protocol::Type::STRING, static_cast<int16_t>(-1));
          oprot.write(decimal_field().get());
          oprot.write_field_end();
      }

      if (email_address_field().present()) {
          oprot.write_field_begin("email_address_field", ::thryft::protocol::Protocol::Type::STRING, static_cast<int16_t>(-1));
          oprot.write(email_address_field().get());
          oprot.write_field_end();
      }

      if (enum_field().present()) {
          oprot.write_field_begin("enum_field", ::thryft::protocol::Protocol::Type::STRING, static_cast<int16_t>(-1));
          ::thryft_test::protocol::test::ProtocolTestEnum::write(oprot, enum_field().get());
          oprot.write_field_end();
      }

      if (i16_field().present()) {
          oprot.write_field_begin("i16_field", ::thryft::protocol::Protocol::Type::I16, static_cast<int16_t>(-1));
          oprot.write(i16_field().get());
          oprot.write_field_end();
      }

      if (i32_field().present()) {
          oprot.write_field_begin("i32_field", ::thryft::protocol::Protocol::Type::I32, static_cast<int16_t>(-1));
          oprot.write(i32_field().get());
          oprot.write_field_end();
      }

      if (i64_field().present()) {
          oprot.write_field_begin("i64_field", ::thryft::protocol::Protocol::Type::I64, static_cast<int16_t>(-1));
          oprot.write(i64_field().get());
          oprot.write_field_end();
      }

      if (list_string_field().present()) {
          oprot.write_field_begin("list_string_field", ::thryft::protocol::Protocol::Type::LIST, static_cast<int16_t>(-1));
          oprot.write(list_string_field().get());
          oprot.write_field_end();
      }

      if (map_string_string_field().present()) {
          oprot.write_field_begin("map_string_string_field", ::thryft::protocol::Protocol::Type::MAP, static_cast<int16_t>(-1));
          oprot.write(map_string_string_field().get());
          oprot.write_field_end();
      }

      oprot.write_field_begin("required_i32_field", ::thryft::protocol::Protocol::Type::I32, static_cast<int16_t>(-1));
      oprot.write(required_i32_field());
      oprot.write_field_end();

      oprot.write_field_begin("required_string_field", ::thryft::protocol::Protocol::Type::STRING, static_cast<int16_t>(-1));
      oprot.write(required_string_field());
      oprot.write_field_end();

      if (set_string_field().present()) {
          oprot.write_field_begin("set_string_field", ::thryft::protocol::Protocol::Type::SET, static_cast<int16_t>(-1));
          oprot.write(set_string_field().get());
          oprot.write_field_end();
      }

      if (string_field().present()) {
          oprot.write_field_begin("string_field", ::thryft::protocol::Protocol::Type::STRING, static_cast<int16_t>(-1));
          oprot.write(string_field().get());
          oprot.write_field_end();
      }

      if (url_field().present()) {
          oprot.write_field_begin("url_field", ::thryft::protocol::Protocol::Type::STRING, static_cast<int16_t>(-1));
          oprot.write(url_field().get());
          oprot.write_field_end();
      }

      oprot.write_field_stop();

      oprot.write_struct_end();
      break;
    }
  }

private:
  ::thryft::Optional< ::std::string > binary_field_;
  ::thryft::Optional< bool > bool_field_;
  ::thryft::Optional< int8_t > byte_field_;
  ::thryft::Optional< int64_t > date_time_field_;
  ::thryft::Optional< ::std::string > decimal_field_;
  ::thryft::Optional< ::std::string > email_address_field_;
  ::thryft::Optional< ::thryft_test::protocol::test::ProtocolTestEnum::Enum > enum_field_;
  ::thryft::Optional< int16_t > i16_field_;
  ::thryft::Optional< int32_t > i32_field_;
  ::thryft::Optional< int64_t > i64_field_;
  ::thryft::Optional< ::thryft::List< ::std::string, ::thryft::protocol::Protocol::Type::STRING > > list_string_field_;
  ::thryft::Optional< ::thryft::Map< ::std::string, ::thryft::protocol::Protocol::Type::STRING, ::std::string, ::thryft::protocol::Protocol::Type::STRING > > map_string_string_field_;
  int32_t required_i32_field_;
  ::std::string required_string_field_;
  ::thryft::Optional< ::thryft::Set< ::std::string, ::thryft::protocol::Protocol::Type::STRING > > set_string_field_;
  ::thryft::Optional< ::std::string > string_field_;
  ::thryft::Optional< ::std::string > url_field_;
};
}
}
}

#endif  // _THRYFT_TEST_PROTOCOL_TEST_NESTED_PROTOCOL_TEST_STRUCT_HPP_