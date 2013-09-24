#ifndef _THRYFT_PROTOCOL_PROTOCOL_HPP_
#define _THRYFT_PROTOCOL_PROTOCOL_HPP_

#include <cstdint>
#include <string>

namespace thryft {
namespace protocol {
class Protocol {
public:
  virtual ~Protocol() {
  }

public:
  virtual std::string ReadBinary() = 0;
  virtual bool ReadBool() = 0;
  virtual int8_t ReadByte() = 0;
  virtual double ReadDouble() = 0;
  virtual int16_t ReadI16() = 0;
  virtual int32_t ReadI32() = 0;
  virtual int64_t ReadI64() = 0;
  virtual void ReadFieldBegin(std::string& out_name, std::string& out_type, int16_t& out_id) = 0;
  virtual void ReadFieldEnd() = 0;
  virtual void ReadListBegin(uint16_t& out_element_type, uint32_t& out_size) = 0;
  virtual void ReadListEnd() = 0;
  virtual void ReadMapBegin(uint16_t& out_key_type, uint16_t& out_value_type, uint32_t& out_size) = 0;
  virtual void ReadMapEnd() = 0;
  virtual void ReadSetBegin(uint16_t& out_element_type, uint32_t& out_size) = 0;
  virtual void ReadSetEnd() = 0;
  virtual std::string ReadString() = 0;
  virtual void ReadStructBegin(std::string& out_name) = 0;
  virtual void ReadStructEnd() = 0;

  virtual void WriteBinary(const void* value, size_t value_len) = 0;
  virtual void WriteBool(bool value) = 0;
  virtual void WriteByte(int8_t value) = 0;
  virtual void WriteDouble(double value) = 0;
  virtual void WriteI16(int16_t value) = 0;
  virtual void WriteI32(int32_t value) = 0;
  virtual void WriteI64(int64_t value) = 0;
  virtual void WriteFieldBegin(const char* name, uint16_t type, int16_t id) = 0;
  virtual void WriteFieldEnd() = 0;
  virtual void WriteFieldStop() = 0;
  virtual void WriteListBegin(uint16_t element_type, uint32_t size) = 0;
  virtual void WriteListEnd() = 0;
  virtual void WriteMapBegin(uint16_t key_type, uint16_t value_type, uint32_t size) = 0;
  virtual void WriteMapEnd() = 0;
  virtual void WriteSetBegin(uint16_t element_type, uint32_t size) = 0;
  virtual void WriteSetEnd() = 0;
  virtual void WriteString(const std::string& value) = 0;
  virtual void WriteString(const char* value, size_t value_len) = 0;
  virtual void WriteStructBegin(const char* name) = 0;
  virtual void WriteStructEnd() = 0;
};
}
}

#endif  // _THRYFT_PROTOCOL_PROTOCOL_HPP_
