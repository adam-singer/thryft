package org.thryft.protocol.test;

@SuppressWarnings({"serial"})
public class ProtocolTestStruct implements org.thryft.Base<ProtocolTestStruct> {
    public static class Builder {
        public Builder() {
        }

        public Builder(final ProtocolTestStruct other) {
            this.binaryField = other.getBinaryField();
            this.boolField = other.getBoolField();
            this.dateTimeField = other.getDateTimeField();
            this.decimalField = other.getDecimalField();
            this.emailAddressField = other.getEmailAddressField();
            this.enumField = other.getEnumField();
            this.i8Field = other.getI8Field();
            this.i16Field = other.getI16Field();
            this.i32Field = other.getI32Field();
            this.i64Field = other.getI64Field();
            this.listStringField = other.getListStringField();
            this.mapStringStringField = other.getMapStringStringField();
            this.requiredI32Field = other.getRequiredI32Field();
            this.requiredStringField = other.getRequiredStringField();
            this.setStringField = other.getSetStringField();
            this.stringField = other.getStringField();
            this.structField = other.getStructField();
            this.u32Field = other.getU32Field();
            this.u64Field = other.getU64Field();
            this.urlField = other.getUrlField();
        }

        protected ProtocolTestStruct _build(final com.google.common.base.Optional<byte[]> binaryField, final com.google.common.base.Optional<Boolean> boolField, final com.google.common.base.Optional<org.joda.time.DateTime> dateTimeField, final com.google.common.base.Optional<java.math.BigDecimal> decimalField, final com.google.common.base.Optional<org.thryft.native_.EmailAddress> emailAddressField, final com.google.common.base.Optional<org.thryft.protocol.test.ProtocolTestEnum> enumField, final com.google.common.base.Optional<Byte> i8Field, final com.google.common.base.Optional<Short> i16Field, final com.google.common.base.Optional<Integer> i32Field, final com.google.common.base.Optional<Long> i64Field, final com.google.common.base.Optional<com.google.common.collect.ImmutableList<String>> listStringField, final com.google.common.base.Optional<com.google.common.collect.ImmutableMap<String, String>> mapStringStringField, final int requiredI32Field, final String requiredStringField, final com.google.common.base.Optional<com.google.common.collect.ImmutableSet<String>> setStringField, final com.google.common.base.Optional<String> stringField, final com.google.common.base.Optional<org.thryft.protocol.test.NestedProtocolTestStruct> structField, final com.google.common.base.Optional<com.google.common.primitives.UnsignedInteger> u32Field, final com.google.common.base.Optional<com.google.common.primitives.UnsignedLong> u64Field, final com.google.common.base.Optional<org.thryft.native_.Url> urlField) {
            return new ProtocolTestStruct(binaryField, boolField, dateTimeField, decimalField, emailAddressField, enumField, i8Field, i16Field, i32Field, i64Field, listStringField, mapStringStringField, requiredI32Field, requiredStringField, setStringField, stringField, structField, u32Field, u64Field, urlField);
        }

        public ProtocolTestStruct build() {
            return _build(binaryField, boolField, dateTimeField, decimalField, emailAddressField, enumField, i8Field, i16Field, i32Field, i64Field, listStringField, mapStringStringField, requiredI32Field, requiredStringField, setStringField, stringField, structField, u32Field, u64Field, urlField);
        }

        public Builder setBinaryField(final com.google.common.base.Optional<byte[]> binaryField) {
            this.binaryField = binaryField;
            return this;
        }

        public Builder setBinaryField(final byte[] binaryField) {
            this.binaryField = com.google.common.base.Optional.fromNullable(binaryField);
            return this;
        }

        public Builder setBoolField(final com.google.common.base.Optional<Boolean> boolField) {
            this.boolField = boolField;
            return this;
        }

        public Builder setBoolField(final boolean boolField) {
            this.boolField = com.google.common.base.Optional.fromNullable(boolField);
            return this;
        }

        public Builder setDateTimeField(final com.google.common.base.Optional<org.joda.time.DateTime> dateTimeField) {
            this.dateTimeField = dateTimeField;
            return this;
        }

        public Builder setDateTimeField(final org.joda.time.DateTime dateTimeField) {
            this.dateTimeField = com.google.common.base.Optional.fromNullable(dateTimeField);
            return this;
        }

        public Builder setDecimalField(final com.google.common.base.Optional<java.math.BigDecimal> decimalField) {
            this.decimalField = decimalField;
            return this;
        }

        public Builder setDecimalField(final java.math.BigDecimal decimalField) {
            this.decimalField = com.google.common.base.Optional.fromNullable(decimalField);
            return this;
        }

        public Builder setEmailAddressField(final com.google.common.base.Optional<org.thryft.native_.EmailAddress> emailAddressField) {
            this.emailAddressField = emailAddressField;
            return this;
        }

        public Builder setEmailAddressField(final org.thryft.native_.EmailAddress emailAddressField) {
            this.emailAddressField = com.google.common.base.Optional.fromNullable(emailAddressField);
            return this;
        }

        public Builder setEnumField(final com.google.common.base.Optional<org.thryft.protocol.test.ProtocolTestEnum> enumField) {
            this.enumField = enumField;
            return this;
        }

        public Builder setEnumField(final org.thryft.protocol.test.ProtocolTestEnum enumField) {
            this.enumField = com.google.common.base.Optional.fromNullable(enumField);
            return this;
        }

        public Builder setI16Field(final com.google.common.base.Optional<Short> i16Field) {
            this.i16Field = i16Field;
            return this;
        }

        public Builder setI16Field(final short i16Field) {
            this.i16Field = com.google.common.base.Optional.fromNullable(i16Field);
            return this;
        }

        public Builder setI32Field(final com.google.common.base.Optional<Integer> i32Field) {
            this.i32Field = i32Field;
            return this;
        }

        public Builder setI32Field(final int i32Field) {
            this.i32Field = com.google.common.base.Optional.fromNullable(i32Field);
            return this;
        }

        public Builder setI64Field(final com.google.common.base.Optional<Long> i64Field) {
            this.i64Field = i64Field;
            return this;
        }

        public Builder setI64Field(final long i64Field) {
            this.i64Field = com.google.common.base.Optional.fromNullable(i64Field);
            return this;
        }

        public Builder setI8Field(final com.google.common.base.Optional<Byte> i8Field) {
            this.i8Field = i8Field;
            return this;
        }

        public Builder setI8Field(final byte i8Field) {
            this.i8Field = com.google.common.base.Optional.fromNullable(i8Field);
            return this;
        }

        public Builder setListStringField(final com.google.common.base.Optional<com.google.common.collect.ImmutableList<String>> listStringField) {
            this.listStringField = listStringField;
            return this;
        }

        public Builder setListStringField(final com.google.common.collect.ImmutableList<String> listStringField) {
            this.listStringField = com.google.common.base.Optional.fromNullable(listStringField);
            return this;
        }

        public Builder setMapStringStringField(final com.google.common.base.Optional<com.google.common.collect.ImmutableMap<String, String>> mapStringStringField) {
            this.mapStringStringField = mapStringStringField;
            return this;
        }

        public Builder setMapStringStringField(final com.google.common.collect.ImmutableMap<String, String> mapStringStringField) {
            this.mapStringStringField = com.google.common.base.Optional.fromNullable(mapStringStringField);
            return this;
        }

        public Builder setRequiredI32Field(final int requiredI32Field) {
            this.requiredI32Field = requiredI32Field;
            return this;
        }

        public Builder setRequiredStringField(final String requiredStringField) {
            this.requiredStringField = requiredStringField;
            return this;
        }

        public Builder setSetStringField(final com.google.common.base.Optional<com.google.common.collect.ImmutableSet<String>> setStringField) {
            this.setStringField = setStringField;
            return this;
        }

        public Builder setSetStringField(final com.google.common.collect.ImmutableSet<String> setStringField) {
            this.setStringField = com.google.common.base.Optional.fromNullable(setStringField);
            return this;
        }

        public Builder setStringField(final com.google.common.base.Optional<String> stringField) {
            this.stringField = stringField;
            return this;
        }

        public Builder setStringField(final String stringField) {
            this.stringField = com.google.common.base.Optional.fromNullable(stringField);
            return this;
        }

        public Builder setStructField(final com.google.common.base.Optional<org.thryft.protocol.test.NestedProtocolTestStruct> structField) {
            this.structField = structField;
            return this;
        }

        public Builder setStructField(final org.thryft.protocol.test.NestedProtocolTestStruct structField) {
            this.structField = com.google.common.base.Optional.fromNullable(structField);
            return this;
        }

        public Builder setU32Field(final com.google.common.base.Optional<com.google.common.primitives.UnsignedInteger> u32Field) {
            this.u32Field = u32Field;
            return this;
        }

        public Builder setU32Field(final com.google.common.primitives.UnsignedInteger u32Field) {
            this.u32Field = com.google.common.base.Optional.fromNullable(u32Field);
            return this;
        }

        public Builder setU64Field(final com.google.common.base.Optional<com.google.common.primitives.UnsignedLong> u64Field) {
            this.u64Field = u64Field;
            return this;
        }

        public Builder setU64Field(final com.google.common.primitives.UnsignedLong u64Field) {
            this.u64Field = com.google.common.base.Optional.fromNullable(u64Field);
            return this;
        }

        public Builder setUrlField(final com.google.common.base.Optional<org.thryft.native_.Url> urlField) {
            this.urlField = urlField;
            return this;
        }

        public Builder setUrlField(final org.thryft.native_.Url urlField) {
            this.urlField = com.google.common.base.Optional.fromNullable(urlField);
            return this;
        }

        private com.google.common.base.Optional<byte[]> binaryField = com.google.common.base.Optional.absent();
        private com.google.common.base.Optional<Boolean> boolField = com.google.common.base.Optional.absent();
        private com.google.common.base.Optional<org.joda.time.DateTime> dateTimeField = com.google.common.base.Optional.absent();
        private com.google.common.base.Optional<java.math.BigDecimal> decimalField = com.google.common.base.Optional.absent();
        private com.google.common.base.Optional<org.thryft.native_.EmailAddress> emailAddressField = com.google.common.base.Optional.absent();
        private com.google.common.base.Optional<org.thryft.protocol.test.ProtocolTestEnum> enumField = com.google.common.base.Optional.absent();
        private com.google.common.base.Optional<Byte> i8Field = com.google.common.base.Optional.absent();
        private com.google.common.base.Optional<Short> i16Field = com.google.common.base.Optional.absent();
        private com.google.common.base.Optional<Integer> i32Field = com.google.common.base.Optional.absent();
        private com.google.common.base.Optional<Long> i64Field = com.google.common.base.Optional.absent();
        private com.google.common.base.Optional<com.google.common.collect.ImmutableList<String>> listStringField = com.google.common.base.Optional.absent();
        private com.google.common.base.Optional<com.google.common.collect.ImmutableMap<String, String>> mapStringStringField = com.google.common.base.Optional.absent();
        private Integer requiredI32Field;
        private String requiredStringField;
        private com.google.common.base.Optional<com.google.common.collect.ImmutableSet<String>> setStringField = com.google.common.base.Optional.absent();
        private com.google.common.base.Optional<String> stringField = com.google.common.base.Optional.absent();
        private com.google.common.base.Optional<org.thryft.protocol.test.NestedProtocolTestStruct> structField = com.google.common.base.Optional.absent();
        private com.google.common.base.Optional<com.google.common.primitives.UnsignedInteger> u32Field = com.google.common.base.Optional.absent();
        private com.google.common.base.Optional<com.google.common.primitives.UnsignedLong> u64Field = com.google.common.base.Optional.absent();
        private com.google.common.base.Optional<org.thryft.native_.Url> urlField = com.google.common.base.Optional.absent();
    }

    public ProtocolTestStruct(final ProtocolTestStruct other) {
        this(other.getBinaryField(), other.getBoolField(), other.getDateTimeField(), other.getDecimalField(), other.getEmailAddressField(), other.getEnumField(), other.getI8Field(), other.getI16Field(), other.getI32Field(), other.getI64Field(), other.getListStringField(), other.getMapStringStringField(), other.getRequiredI32Field(), other.getRequiredStringField(), other.getSetStringField(), other.getStringField(), other.getStructField(), other.getU32Field(), other.getU64Field(), other.getUrlField());
    }

    public ProtocolTestStruct(final org.thryft.protocol.InputProtocol iprot) throws java.io.IOException {
        this(iprot, org.thryft.protocol.Type.STRUCT);
    }

    public ProtocolTestStruct(final org.thryft.protocol.InputProtocol iprot, final byte readAsTType) throws java.io.IOException {
        com.google.common.base.Optional<byte[]> binaryField = com.google.common.base.Optional.absent();
        com.google.common.base.Optional<Boolean> boolField = com.google.common.base.Optional.absent();
        com.google.common.base.Optional<org.joda.time.DateTime> dateTimeField = com.google.common.base.Optional.absent();
        com.google.common.base.Optional<java.math.BigDecimal> decimalField = com.google.common.base.Optional.absent();
        com.google.common.base.Optional<org.thryft.native_.EmailAddress> emailAddressField = com.google.common.base.Optional.absent();
        com.google.common.base.Optional<org.thryft.protocol.test.ProtocolTestEnum> enumField = com.google.common.base.Optional.absent();
        com.google.common.base.Optional<Byte> i8Field = com.google.common.base.Optional.absent();
        com.google.common.base.Optional<Short> i16Field = com.google.common.base.Optional.absent();
        com.google.common.base.Optional<Integer> i32Field = com.google.common.base.Optional.absent();
        com.google.common.base.Optional<Long> i64Field = com.google.common.base.Optional.absent();
        com.google.common.base.Optional<com.google.common.collect.ImmutableList<String>> listStringField = com.google.common.base.Optional.absent();
        com.google.common.base.Optional<com.google.common.collect.ImmutableMap<String, String>> mapStringStringField = com.google.common.base.Optional.absent();
        int requiredI32Field = 0;
        String requiredStringField = null;
        com.google.common.base.Optional<com.google.common.collect.ImmutableSet<String>> setStringField = com.google.common.base.Optional.absent();
        com.google.common.base.Optional<String> stringField = com.google.common.base.Optional.absent();
        com.google.common.base.Optional<org.thryft.protocol.test.NestedProtocolTestStruct> structField = com.google.common.base.Optional.absent();
        com.google.common.base.Optional<com.google.common.primitives.UnsignedInteger> u32Field = com.google.common.base.Optional.absent();
        com.google.common.base.Optional<com.google.common.primitives.UnsignedLong> u64Field = com.google.common.base.Optional.absent();
        com.google.common.base.Optional<org.thryft.native_.Url> urlField = com.google.common.base.Optional.absent();

        switch (readAsTType) {
            case org.thryft.protocol.Type.LIST:
                final org.thryft.protocol.ListBegin __list = iprot.readListBegin();
                binaryField = com.google.common.base.Optional.of(iprot.readBinary());
                boolField = com.google.common.base.Optional.of(iprot.readBool());
                try {
                    dateTimeField = com.google.common.base.Optional.of(iprot.readDateTime());
                } catch (IllegalArgumentException e) {
                }
                try {
                    decimalField = com.google.common.base.Optional.of(iprot.readDecimal());
                } catch (NumberFormatException e) {
                }
                emailAddressField = com.google.common.base.Optional.of(iprot.readEmailAddress());
                try {
                    enumField = com.google.common.base.Optional.of(iprot.readEnum(org.thryft.protocol.test.ProtocolTestEnum.class));
                } catch (IllegalArgumentException e) {
                }
                try {
                    i8Field = com.google.common.base.Optional.of(iprot.readByte());
                } catch (NumberFormatException e) {
                }
                try {
                    i16Field = com.google.common.base.Optional.of(iprot.readI16());
                } catch (NumberFormatException e) {
                }
                try {
                    i32Field = com.google.common.base.Optional.of(iprot.readI32());
                } catch (NumberFormatException e) {
                }
                try {
                    i64Field = com.google.common.base.Optional.of(iprot.readI64());
                } catch (NumberFormatException e) {
                }
                listStringField = com.google.common.base.Optional.of((new com.google.common.base.Function<org.thryft.protocol.InputProtocol, com.google.common.collect.ImmutableList<String>>() {
                    @Override
                    public com.google.common.collect.ImmutableList<String> apply(final org.thryft.protocol.InputProtocol iprot) {
                        try {
                            final org.thryft.protocol.ListBegin sequenceBegin = iprot.readListBegin();
                            final com.google.common.collect.ImmutableList.Builder<String> sequence = com.google.common.collect.ImmutableList.builder();
                            for (int elementI = 0; elementI < sequenceBegin.size; elementI++) {
                                sequence.add(iprot.readString());
                            }
                            iprot.readListEnd();
                            return sequence.build();
                        } catch (final java.io.IOException e) {
                            return com.google.common.collect.ImmutableList.of();
                        }
                    }
                }).apply(iprot));
                mapStringStringField = com.google.common.base.Optional.of((new com.google.common.base.Function<org.thryft.protocol.InputProtocol, com.google.common.collect.ImmutableMap<String, String>>() {
                    @Override
                    public com.google.common.collect.ImmutableMap<String, String> apply(org.thryft.protocol.InputProtocol iprot) {
                        try {
                            final org.thryft.protocol.MapBegin mapBegin = iprot.readMapBegin();
                            final com.google.common.collect.ImmutableMap.Builder<String, String> map = com.google.common.collect.ImmutableMap.builder();
                            for (int entryI = 0; entryI < mapBegin.size; entryI++) {
                                map.put(iprot.readString(), iprot.readString());
                            }
                            iprot.readMapEnd();
                            return map.build();
                        } catch (final java.io.IOException e) {
                            return com.google.common.collect.ImmutableMap.of();
                        }
                    }
                }).apply(iprot));
                requiredI32Field = iprot.readI32();
                requiredStringField = iprot.readString();
                if (__list.size > 14) {
                    setStringField = com.google.common.base.Optional.of((new com.google.common.base.Function<org.thryft.protocol.InputProtocol, com.google.common.collect.ImmutableSet<String>>() {
                        @Override
                        public com.google.common.collect.ImmutableSet<String> apply(final org.thryft.protocol.InputProtocol iprot) {
                            try {
                                final org.thryft.protocol.SetBegin sequenceBegin = iprot.readSetBegin();
                                final com.google.common.collect.ImmutableSet.Builder<String> sequence = com.google.common.collect.ImmutableSet.builder();
                                for (int elementI = 0; elementI < sequenceBegin.size; elementI++) {
                                    sequence.add(iprot.readString());
                                }
                                iprot.readSetEnd();
                                return sequence.build();
                            } catch (final java.io.IOException e) {
                                return com.google.common.collect.ImmutableSet.of();
                            }
                        }
                    }).apply(iprot));
                }
                if (__list.size > 15) {
                    stringField = com.google.common.base.Optional.of(iprot.readString());
                }
                if (__list.size > 16) {
                    structField = com.google.common.base.Optional.of(new org.thryft.protocol.test.NestedProtocolTestStruct(iprot));
                }
                if (__list.size > 17) {
                    try {
                        u32Field = com.google.common.base.Optional.of(iprot.readU32());
                    } catch (NumberFormatException e) {
                    }
                }
                if (__list.size > 18) {
                    try {
                        u64Field = com.google.common.base.Optional.of(iprot.readU64());
                    } catch (NumberFormatException e) {
                    }
                }
                if (__list.size > 19) {
                    try {
                        urlField = com.google.common.base.Optional.of(iprot.readUrl());
                    } catch (java.net.MalformedURLException e) {
                    }
                }
                iprot.readListEnd();
                break;

            case org.thryft.protocol.Type.STRUCT:
            default:
                iprot.readStructBegin();
                while (true) {
                    final org.thryft.protocol.FieldBegin ifield = iprot.readFieldBegin();
                    if (ifield.type == org.thryft.protocol.Type.STOP) {
                        break;
                    } else if (ifield.name.equals("binary_field")) {
                        binaryField = com.google.common.base.Optional.of(iprot.readBinary());
                    } else if (ifield.name.equals("bool_field")) {
                        boolField = com.google.common.base.Optional.of(iprot.readBool());
                    } else if (ifield.name.equals("date_time_field")) {
                        try {
                            dateTimeField = com.google.common.base.Optional.of(iprot.readDateTime());
                        } catch (IllegalArgumentException e) {
                        }
                    } else if (ifield.name.equals("decimal_field")) {
                        try {
                            decimalField = com.google.common.base.Optional.of(iprot.readDecimal());
                        } catch (NumberFormatException e) {
                        }
                    } else if (ifield.name.equals("email_address_field")) {
                        emailAddressField = com.google.common.base.Optional.of(iprot.readEmailAddress());
                    } else if (ifield.name.equals("enum_field")) {
                        try {
                            enumField = com.google.common.base.Optional.of(iprot.readEnum(org.thryft.protocol.test.ProtocolTestEnum.class));
                        } catch (IllegalArgumentException e) {
                        }
                    } else if (ifield.name.equals("i8_field")) {
                        try {
                            i8Field = com.google.common.base.Optional.of(iprot.readByte());
                        } catch (NumberFormatException e) {
                        }
                    } else if (ifield.name.equals("i16_field")) {
                        try {
                            i16Field = com.google.common.base.Optional.of(iprot.readI16());
                        } catch (NumberFormatException e) {
                        }
                    } else if (ifield.name.equals("i32_field")) {
                        try {
                            i32Field = com.google.common.base.Optional.of(iprot.readI32());
                        } catch (NumberFormatException e) {
                        }
                    } else if (ifield.name.equals("i64_field")) {
                        try {
                            i64Field = com.google.common.base.Optional.of(iprot.readI64());
                        } catch (NumberFormatException e) {
                        }
                    } else if (ifield.name.equals("list_string_field")) {
                        listStringField = com.google.common.base.Optional.of((new com.google.common.base.Function<org.thryft.protocol.InputProtocol, com.google.common.collect.ImmutableList<String>>() {
                            @Override
                            public com.google.common.collect.ImmutableList<String> apply(final org.thryft.protocol.InputProtocol iprot) {
                                try {
                                    final org.thryft.protocol.ListBegin sequenceBegin = iprot.readListBegin();
                                    final com.google.common.collect.ImmutableList.Builder<String> sequence = com.google.common.collect.ImmutableList.builder();
                                    for (int elementI = 0; elementI < sequenceBegin.size; elementI++) {
                                        sequence.add(iprot.readString());
                                    }
                                    iprot.readListEnd();
                                    return sequence.build();
                                } catch (final java.io.IOException e) {
                                    return com.google.common.collect.ImmutableList.of();
                                }
                            }
                        }).apply(iprot));
                    } else if (ifield.name.equals("map_string_string_field")) {
                        mapStringStringField = com.google.common.base.Optional.of((new com.google.common.base.Function<org.thryft.protocol.InputProtocol, com.google.common.collect.ImmutableMap<String, String>>() {
                            @Override
                            public com.google.common.collect.ImmutableMap<String, String> apply(org.thryft.protocol.InputProtocol iprot) {
                                try {
                                    final org.thryft.protocol.MapBegin mapBegin = iprot.readMapBegin();
                                    final com.google.common.collect.ImmutableMap.Builder<String, String> map = com.google.common.collect.ImmutableMap.builder();
                                    for (int entryI = 0; entryI < mapBegin.size; entryI++) {
                                        map.put(iprot.readString(), iprot.readString());
                                    }
                                    iprot.readMapEnd();
                                    return map.build();
                                } catch (final java.io.IOException e) {
                                    return com.google.common.collect.ImmutableMap.of();
                                }
                            }
                        }).apply(iprot));
                    } else if (ifield.name.equals("required_i32_field")) {
                        requiredI32Field = iprot.readI32();
                    } else if (ifield.name.equals("required_string_field")) {
                        requiredStringField = iprot.readString();
                    } else if (ifield.name.equals("set_string_field")) {
                        setStringField = com.google.common.base.Optional.of((new com.google.common.base.Function<org.thryft.protocol.InputProtocol, com.google.common.collect.ImmutableSet<String>>() {
                            @Override
                            public com.google.common.collect.ImmutableSet<String> apply(final org.thryft.protocol.InputProtocol iprot) {
                                try {
                                    final org.thryft.protocol.SetBegin sequenceBegin = iprot.readSetBegin();
                                    final com.google.common.collect.ImmutableSet.Builder<String> sequence = com.google.common.collect.ImmutableSet.builder();
                                    for (int elementI = 0; elementI < sequenceBegin.size; elementI++) {
                                        sequence.add(iprot.readString());
                                    }
                                    iprot.readSetEnd();
                                    return sequence.build();
                                } catch (final java.io.IOException e) {
                                    return com.google.common.collect.ImmutableSet.of();
                                }
                            }
                        }).apply(iprot));
                    } else if (ifield.name.equals("string_field")) {
                        stringField = com.google.common.base.Optional.of(iprot.readString());
                    } else if (ifield.name.equals("struct_field")) {
                        structField = com.google.common.base.Optional.of(new org.thryft.protocol.test.NestedProtocolTestStruct(iprot));
                    } else if (ifield.name.equals("u32_field")) {
                        try {
                            u32Field = com.google.common.base.Optional.of(iprot.readU32());
                        } catch (NumberFormatException e) {
                        }
                    } else if (ifield.name.equals("u64_field")) {
                        try {
                            u64Field = com.google.common.base.Optional.of(iprot.readU64());
                        } catch (NumberFormatException e) {
                        }
                    } else if (ifield.name.equals("url_field")) {
                        try {
                            urlField = com.google.common.base.Optional.of(iprot.readUrl());
                        } catch (java.net.MalformedURLException e) {
                        }
                    }
                    iprot.readFieldEnd();
                }
                iprot.readStructEnd();
                break;
        }

        this.binaryField = binaryField;
        this.boolField = boolField;
        this.dateTimeField = dateTimeField;
        this.decimalField = decimalField;
        this.emailAddressField = emailAddressField;
        this.enumField = enumField;
        this.i8Field = i8Field;
        this.i16Field = i16Field;
        this.i32Field = i32Field;
        this.i64Field = i64Field;
        this.listStringField = listStringField;
        this.mapStringStringField = mapStringStringField;
        this.requiredI32Field = requiredI32Field;
        this.requiredStringField = org.thryft.Preconditions.checkNotEmpty(com.google.common.base.Preconditions.checkNotNull(requiredStringField, "org.thryft.protocol.test.ProtocolTestStruct: missing requiredStringField"), "org.thryft.protocol.test.ProtocolTestStruct: requiredStringField is empty");
        this.setStringField = setStringField;
        this.stringField = org.thryft.Preconditions.checkNotEmpty(stringField, String.class, "org.thryft.protocol.test.ProtocolTestStruct: stringField is empty");
        this.structField = structField;
        this.u32Field = u32Field;
        this.u64Field = u64Field;
        this.urlField = urlField;
    }

    public ProtocolTestStruct(final int requiredI32Field, final String requiredStringField) {
        this.binaryField = com.google.common.base.Optional.absent();
        this.boolField = com.google.common.base.Optional.absent();
        this.dateTimeField = com.google.common.base.Optional.absent();
        this.decimalField = com.google.common.base.Optional.absent();
        this.emailAddressField = com.google.common.base.Optional.absent();
        this.enumField = com.google.common.base.Optional.absent();
        this.i8Field = com.google.common.base.Optional.absent();
        this.i16Field = com.google.common.base.Optional.absent();
        this.i32Field = com.google.common.base.Optional.absent();
        this.i64Field = com.google.common.base.Optional.absent();
        this.listStringField = com.google.common.base.Optional.absent();
        this.mapStringStringField = com.google.common.base.Optional.absent();
        this.requiredI32Field = requiredI32Field;
        this.requiredStringField = org.thryft.Preconditions.checkNotEmpty(com.google.common.base.Preconditions.checkNotNull(requiredStringField, "org.thryft.protocol.test.ProtocolTestStruct: missing requiredStringField"), "org.thryft.protocol.test.ProtocolTestStruct: requiredStringField is empty");
        this.setStringField = com.google.common.base.Optional.absent();
        this.stringField = com.google.common.base.Optional.absent();
        this.structField = com.google.common.base.Optional.absent();
        this.u32Field = com.google.common.base.Optional.absent();
        this.u64Field = com.google.common.base.Optional.absent();
        this.urlField = com.google.common.base.Optional.absent();
    }

    public ProtocolTestStruct(final com.google.common.base.Optional<byte[]> binaryField, final com.google.common.base.Optional<Boolean> boolField, final com.google.common.base.Optional<org.joda.time.DateTime> dateTimeField, final com.google.common.base.Optional<java.math.BigDecimal> decimalField, final com.google.common.base.Optional<org.thryft.native_.EmailAddress> emailAddressField, final com.google.common.base.Optional<org.thryft.protocol.test.ProtocolTestEnum> enumField, final com.google.common.base.Optional<Byte> i8Field, final com.google.common.base.Optional<Short> i16Field, final com.google.common.base.Optional<Integer> i32Field, final com.google.common.base.Optional<Long> i64Field, final com.google.common.base.Optional<com.google.common.collect.ImmutableList<String>> listStringField, final com.google.common.base.Optional<com.google.common.collect.ImmutableMap<String, String>> mapStringStringField, final int requiredI32Field, final String requiredStringField, final com.google.common.base.Optional<com.google.common.collect.ImmutableSet<String>> setStringField, final com.google.common.base.Optional<String> stringField, final com.google.common.base.Optional<org.thryft.protocol.test.NestedProtocolTestStruct> structField, final com.google.common.base.Optional<com.google.common.primitives.UnsignedInteger> u32Field, final com.google.common.base.Optional<com.google.common.primitives.UnsignedLong> u64Field, final com.google.common.base.Optional<org.thryft.native_.Url> urlField) {
        this.binaryField = com.google.common.base.Preconditions.checkNotNull(binaryField, "org.thryft.protocol.test.ProtocolTestStruct: missing binaryField");
        this.boolField = boolField;
        this.dateTimeField = com.google.common.base.Preconditions.checkNotNull(dateTimeField, "org.thryft.protocol.test.ProtocolTestStruct: missing dateTimeField");
        this.decimalField = com.google.common.base.Preconditions.checkNotNull(decimalField, "org.thryft.protocol.test.ProtocolTestStruct: missing decimalField");
        this.emailAddressField = com.google.common.base.Preconditions.checkNotNull(emailAddressField, "org.thryft.protocol.test.ProtocolTestStruct: missing emailAddressField");
        this.enumField = com.google.common.base.Preconditions.checkNotNull(enumField, "org.thryft.protocol.test.ProtocolTestStruct: missing enumField");
        this.i8Field = i8Field;
        this.i16Field = i16Field;
        this.i32Field = i32Field;
        this.i64Field = i64Field;
        this.listStringField = com.google.common.base.Preconditions.checkNotNull(listStringField, "org.thryft.protocol.test.ProtocolTestStruct: missing listStringField");
        this.mapStringStringField = com.google.common.base.Preconditions.checkNotNull(mapStringStringField, "org.thryft.protocol.test.ProtocolTestStruct: missing mapStringStringField");
        this.requiredI32Field = requiredI32Field;
        this.requiredStringField = org.thryft.Preconditions.checkNotEmpty(com.google.common.base.Preconditions.checkNotNull(requiredStringField, "org.thryft.protocol.test.ProtocolTestStruct: missing requiredStringField"), "org.thryft.protocol.test.ProtocolTestStruct: requiredStringField is empty");
        this.setStringField = com.google.common.base.Preconditions.checkNotNull(setStringField, "org.thryft.protocol.test.ProtocolTestStruct: missing setStringField");
        this.stringField = org.thryft.Preconditions.checkNotEmpty(com.google.common.base.Preconditions.checkNotNull(stringField, "org.thryft.protocol.test.ProtocolTestStruct: missing stringField"), String.class, "org.thryft.protocol.test.ProtocolTestStruct: stringField is empty");
        this.structField = com.google.common.base.Preconditions.checkNotNull(structField, "org.thryft.protocol.test.ProtocolTestStruct: missing structField");
        this.u32Field = com.google.common.base.Preconditions.checkNotNull(u32Field, "org.thryft.protocol.test.ProtocolTestStruct: missing u32Field");
        this.u64Field = com.google.common.base.Preconditions.checkNotNull(u64Field, "org.thryft.protocol.test.ProtocolTestStruct: missing u64Field");
        this.urlField = com.google.common.base.Preconditions.checkNotNull(urlField, "org.thryft.protocol.test.ProtocolTestStruct: missing urlField");
    }

    public ProtocolTestStruct(final com.google.common.base.Optional<byte[]> binaryField, final com.google.common.base.Optional<Boolean> boolField, final com.google.common.base.Optional<org.joda.time.DateTime> dateTimeField, final com.google.common.base.Optional<java.math.BigDecimal> decimalField, final com.google.common.base.Optional<org.thryft.native_.EmailAddress> emailAddressField, final com.google.common.base.Optional<org.thryft.protocol.test.ProtocolTestEnum> enumField, final com.google.common.base.Optional<Byte> i8Field, final com.google.common.base.Optional<Short> i16Field, final com.google.common.base.Optional<Integer> i32Field, final com.google.common.base.Optional<Long> i64Field, final com.google.common.base.Optional<com.google.common.collect.ImmutableList<String>> listStringField, final com.google.common.base.Optional<com.google.common.collect.ImmutableMap<String, String>> mapStringStringField, final Integer requiredI32Field, final String requiredStringField, final com.google.common.base.Optional<com.google.common.collect.ImmutableSet<String>> setStringField, final com.google.common.base.Optional<String> stringField, final com.google.common.base.Optional<org.thryft.protocol.test.NestedProtocolTestStruct> structField, final com.google.common.base.Optional<com.google.common.primitives.UnsignedInteger> u32Field, final com.google.common.base.Optional<com.google.common.primitives.UnsignedLong> u64Field, final com.google.common.base.Optional<org.thryft.native_.Url> urlField) {
        this.binaryField = com.google.common.base.Preconditions.checkNotNull(binaryField, "org.thryft.protocol.test.ProtocolTestStruct: missing binaryField");
        this.boolField = boolField;
        this.dateTimeField = com.google.common.base.Preconditions.checkNotNull(dateTimeField, "org.thryft.protocol.test.ProtocolTestStruct: missing dateTimeField");
        this.decimalField = com.google.common.base.Preconditions.checkNotNull(decimalField, "org.thryft.protocol.test.ProtocolTestStruct: missing decimalField");
        this.emailAddressField = com.google.common.base.Preconditions.checkNotNull(emailAddressField, "org.thryft.protocol.test.ProtocolTestStruct: missing emailAddressField");
        this.enumField = com.google.common.base.Preconditions.checkNotNull(enumField, "org.thryft.protocol.test.ProtocolTestStruct: missing enumField");
        this.i8Field = i8Field;
        this.i16Field = i16Field;
        this.i32Field = i32Field;
        this.i64Field = i64Field;
        this.listStringField = com.google.common.base.Preconditions.checkNotNull(listStringField, "org.thryft.protocol.test.ProtocolTestStruct: missing listStringField");
        this.mapStringStringField = com.google.common.base.Preconditions.checkNotNull(mapStringStringField, "org.thryft.protocol.test.ProtocolTestStruct: missing mapStringStringField");
        this.requiredI32Field = requiredI32Field;
        this.requiredStringField = org.thryft.Preconditions.checkNotEmpty(com.google.common.base.Preconditions.checkNotNull(requiredStringField, "org.thryft.protocol.test.ProtocolTestStruct: missing requiredStringField"), "org.thryft.protocol.test.ProtocolTestStruct: requiredStringField is empty");
        this.setStringField = com.google.common.base.Preconditions.checkNotNull(setStringField, "org.thryft.protocol.test.ProtocolTestStruct: missing setStringField");
        this.stringField = org.thryft.Preconditions.checkNotEmpty(com.google.common.base.Preconditions.checkNotNull(stringField, "org.thryft.protocol.test.ProtocolTestStruct: missing stringField"), String.class, "org.thryft.protocol.test.ProtocolTestStruct: stringField is empty");
        this.structField = com.google.common.base.Preconditions.checkNotNull(structField, "org.thryft.protocol.test.ProtocolTestStruct: missing structField");
        this.u32Field = com.google.common.base.Preconditions.checkNotNull(u32Field, "org.thryft.protocol.test.ProtocolTestStruct: missing u32Field");
        this.u64Field = com.google.common.base.Preconditions.checkNotNull(u64Field, "org.thryft.protocol.test.ProtocolTestStruct: missing u64Field");
        this.urlField = com.google.common.base.Preconditions.checkNotNull(urlField, "org.thryft.protocol.test.ProtocolTestStruct: missing urlField");
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public int compareTo(final ProtocolTestStruct other) {
        if (other == null) {
            throw new NullPointerException();
        }

        int result;
        if (this.binaryField.isPresent()) {
            if (other.binaryField.isPresent()) {
                result = org.thryft.Comparators.compare(this.binaryField.get(), other.binaryField.get());
                if (result != 0) {
                    return result;
                }
            } else {
                return 1;
            }
        } else if (other.binaryField.isPresent()) {
            return -1;
        }

        if (this.boolField.isPresent()) {
            if (other.boolField.isPresent()) {
                result = ((Boolean)this.boolField.get()).compareTo(other.boolField.get());
                if (result != 0) {
                    return result;
                }
            } else {
                return 1;
            }
        } else if (other.boolField.isPresent()) {
            return -1;
        }

        if (this.dateTimeField.isPresent()) {
            if (other.dateTimeField.isPresent()) {
                result = this.dateTimeField.get().compareTo(other.dateTimeField.get());
                if (result != 0) {
                    return result;
                }
            } else {
                return 1;
            }
        } else if (other.dateTimeField.isPresent()) {
            return -1;
        }

        if (this.decimalField.isPresent()) {
            if (other.decimalField.isPresent()) {
                result = this.decimalField.get().compareTo(other.decimalField.get());
                if (result != 0) {
                    return result;
                }
            } else {
                return 1;
            }
        } else if (other.decimalField.isPresent()) {
            return -1;
        }

        if (this.emailAddressField.isPresent()) {
            if (other.emailAddressField.isPresent()) {
                result = this.emailAddressField.get().compareTo(other.emailAddressField.get());
                if (result != 0) {
                    return result;
                }
            } else {
                return 1;
            }
        } else if (other.emailAddressField.isPresent()) {
            return -1;
        }

        if (this.enumField.isPresent()) {
            if (other.enumField.isPresent()) {
                result = this.enumField.get().compareTo(other.enumField.get());
                if (result != 0) {
                    return result;
                }
            } else {
                return 1;
            }
        } else if (other.enumField.isPresent()) {
            return -1;
        }

        if (this.i8Field.isPresent()) {
            if (other.i8Field.isPresent()) {
                result = ((Byte)this.i8Field.get()).compareTo(other.i8Field.get());
                if (result != 0) {
                    return result;
                }
            } else {
                return 1;
            }
        } else if (other.i8Field.isPresent()) {
            return -1;
        }

        if (this.i16Field.isPresent()) {
            if (other.i16Field.isPresent()) {
                result = ((Short)this.i16Field.get()).compareTo(other.i16Field.get());
                if (result != 0) {
                    return result;
                }
            } else {
                return 1;
            }
        } else if (other.i16Field.isPresent()) {
            return -1;
        }

        if (this.i32Field.isPresent()) {
            if (other.i32Field.isPresent()) {
                result = ((Integer)this.i32Field.get()).compareTo(other.i32Field.get());
                if (result != 0) {
                    return result;
                }
            } else {
                return 1;
            }
        } else if (other.i32Field.isPresent()) {
            return -1;
        }

        if (this.i64Field.isPresent()) {
            if (other.i64Field.isPresent()) {
                result = ((Long)this.i64Field.get()).compareTo(other.i64Field.get());
                if (result != 0) {
                    return result;
                }
            } else {
                return 1;
            }
        } else if (other.i64Field.isPresent()) {
            return -1;
        }

        if (this.listStringField.isPresent()) {
            if (other.listStringField.isPresent()) {
                result = org.thryft.Comparators.compare(this.listStringField.get(), other.listStringField.get());
                if (result != 0) {
                    return result;
                }
            } else {
                return 1;
            }
        } else if (other.listStringField.isPresent()) {
            return -1;
        }

        if (this.mapStringStringField.isPresent()) {
            if (other.mapStringStringField.isPresent()) {
                result = org.thryft.Comparators.compare(this.mapStringStringField.get(), other.mapStringStringField.get());
                if (result != 0) {
                    return result;
                }
            } else {
                return 1;
            }
        } else if (other.mapStringStringField.isPresent()) {
            return -1;
        }

        result = ((Integer)this.requiredI32Field).compareTo(other.requiredI32Field);
        if (result != 0) {
            return result;
        }

        result = this.requiredStringField.compareTo(other.requiredStringField);
        if (result != 0) {
            return result;
        }

        if (this.setStringField.isPresent()) {
            if (other.setStringField.isPresent()) {
                result = org.thryft.Comparators.compare(this.setStringField.get(), other.setStringField.get());
                if (result != 0) {
                    return result;
                }
            } else {
                return 1;
            }
        } else if (other.setStringField.isPresent()) {
            return -1;
        }

        if (this.stringField.isPresent()) {
            if (other.stringField.isPresent()) {
                result = this.stringField.get().compareTo(other.stringField.get());
                if (result != 0) {
                    return result;
                }
            } else {
                return 1;
            }
        } else if (other.stringField.isPresent()) {
            return -1;
        }

        if (this.structField.isPresent()) {
            if (other.structField.isPresent()) {
                result = this.structField.get().compareTo(other.structField.get());
                if (result != 0) {
                    return result;
                }
            } else {
                return 1;
            }
        } else if (other.structField.isPresent()) {
            return -1;
        }

        if (this.u32Field.isPresent()) {
            if (other.u32Field.isPresent()) {
                result = this.u32Field.get().compareTo(other.u32Field.get());
                if (result != 0) {
                    return result;
                }
            } else {
                return 1;
            }
        } else if (other.u32Field.isPresent()) {
            return -1;
        }

        if (this.u64Field.isPresent()) {
            if (other.u64Field.isPresent()) {
                result = this.u64Field.get().compareTo(other.u64Field.get());
                if (result != 0) {
                    return result;
                }
            } else {
                return 1;
            }
        } else if (other.u64Field.isPresent()) {
            return -1;
        }

        if (this.urlField.isPresent()) {
            if (other.urlField.isPresent()) {
                result = this.urlField.get().compareTo(other.urlField.get());
                if (result != 0) {
                    return result;
                }
            } else {
                return 1;
            }
        } else if (other.urlField.isPresent()) {
            return -1;
        }

        return 0;
    }

    @Override
    public boolean equals(final Object otherObject) {
        if (otherObject == this) {
            return true;
        } else if (!(otherObject instanceof ProtocolTestStruct)) {
            return false;
        }

        final ProtocolTestStruct other = (ProtocolTestStruct)otherObject;
        return
            getBinaryField().equals(other.getBinaryField()) &&
            getBoolField().equals(other.getBoolField()) &&
            getDateTimeField().equals(other.getDateTimeField()) &&
            getDecimalField().equals(other.getDecimalField()) &&
            getEmailAddressField().equals(other.getEmailAddressField()) &&
            getEnumField().equals(other.getEnumField()) &&
            getI8Field().equals(other.getI8Field()) &&
            getI16Field().equals(other.getI16Field()) &&
            getI32Field().equals(other.getI32Field()) &&
            getI64Field().equals(other.getI64Field()) &&
            getListStringField().equals(other.getListStringField()) &&
            getMapStringStringField().equals(other.getMapStringStringField()) &&
            getRequiredI32Field() == other.getRequiredI32Field() &&
            getRequiredStringField().equals(other.getRequiredStringField()) &&
            getSetStringField().equals(other.getSetStringField()) &&
            getStringField().equals(other.getStringField()) &&
            getStructField().equals(other.getStructField()) &&
            getU32Field().equals(other.getU32Field()) &&
            getU64Field().equals(other.getU64Field()) &&
            getUrlField().equals(other.getUrlField());
    }

    public static ProtocolTestStruct fake() {
        return fakeBuilder().build();
    }

    public static Builder fakeBuilder() {
        Builder builder = new Builder();
        builder.setBinaryField(org.thryft.Faker.randomBinary());
        builder.setBoolField(org.thryft.Faker.randomBool());
        builder.setDateTimeField(org.joda.time.DateTime.now());
        builder.setDecimalField(org.thryft.Faker.randomDecimal());
        builder.setEmailAddressField(org.thryft.Faker.Internet.email());
        builder.setEnumField(org.thryft.Faker.randomEnum(com.google.common.collect.ImmutableList.of(org.thryft.protocol.test.ProtocolTestEnum.ENUMERATOR1, org.thryft.protocol.test.ProtocolTestEnum.ENUMERATOR2)));
        builder.setI8Field(org.thryft.Faker.randomByte());
        builder.setI16Field(org.thryft.Faker.randomI16());
        builder.setI32Field(org.thryft.Faker.randomI32());
        builder.setI64Field(org.thryft.Faker.randomI64());
        builder.setListStringField(com.google.common.collect.ImmutableList.of(org.thryft.Faker.Lorem.word()));
        builder.setMapStringStringField(com.google.common.collect.ImmutableMap.of(org.thryft.Faker.Lorem.word(), org.thryft.Faker.Lorem.word()));
        builder.setRequiredI32Field(org.thryft.Faker.randomI32());
        builder.setRequiredStringField(org.thryft.Faker.Name.firstName());
        builder.setSetStringField(com.google.common.collect.ImmutableSet.of(org.thryft.Faker.Lorem.word()));
        builder.setStringField(org.thryft.Faker.Lorem.word());
        builder.setStructField(org.thryft.protocol.test.NestedProtocolTestStruct.fake());
        builder.setU32Field(org.thryft.Faker.randomU32());
        builder.setU64Field(org.thryft.Faker.randomU64());
        builder.setUrlField(org.thryft.Faker.Internet.url());
        return builder;
    }

    public Object get(final String fieldName) {
        if (fieldName.equals("binary_field")) {
            return getBinaryField();
        } else if (fieldName.equals("bool_field")) {
            return getBoolField();
        } else if (fieldName.equals("date_time_field")) {
            return getDateTimeField();
        } else if (fieldName.equals("decimal_field")) {
            return getDecimalField();
        } else if (fieldName.equals("email_address_field")) {
            return getEmailAddressField();
        } else if (fieldName.equals("enum_field")) {
            return getEnumField();
        } else if (fieldName.equals("i8_field")) {
            return getI8Field();
        } else if (fieldName.equals("i16_field")) {
            return getI16Field();
        } else if (fieldName.equals("i32_field")) {
            return getI32Field();
        } else if (fieldName.equals("i64_field")) {
            return getI64Field();
        } else if (fieldName.equals("list_string_field")) {
            return getListStringField();
        } else if (fieldName.equals("map_string_string_field")) {
            return getMapStringStringField();
        } else if (fieldName.equals("required_i32_field")) {
            return getRequiredI32Field();
        } else if (fieldName.equals("required_string_field")) {
            return getRequiredStringField();
        } else if (fieldName.equals("set_string_field")) {
            return getSetStringField();
        } else if (fieldName.equals("string_field")) {
            return getStringField();
        } else if (fieldName.equals("struct_field")) {
            return getStructField();
        } else if (fieldName.equals("u32_field")) {
            return getU32Field();
        } else if (fieldName.equals("u64_field")) {
            return getU64Field();
        } else if (fieldName.equals("url_field")) {
            return getUrlField();
        }
        throw new IllegalArgumentException(fieldName);
    }

    public final com.google.common.base.Optional<byte[]> getBinaryField() {
        return binaryField;
    }

    public final com.google.common.base.Optional<Boolean> getBoolField() {
        return boolField;
    }

    public final com.google.common.base.Optional<org.joda.time.DateTime> getDateTimeField() {
        return dateTimeField;
    }

    public final com.google.common.base.Optional<java.math.BigDecimal> getDecimalField() {
        return decimalField;
    }

    public final com.google.common.base.Optional<org.thryft.native_.EmailAddress> getEmailAddressField() {
        return emailAddressField;
    }

    public final com.google.common.base.Optional<org.thryft.protocol.test.ProtocolTestEnum> getEnumField() {
        return enumField;
    }

    public final com.google.common.base.Optional<Short> getI16Field() {
        return i16Field;
    }

    public final com.google.common.base.Optional<Integer> getI32Field() {
        return i32Field;
    }

    public final com.google.common.base.Optional<Long> getI64Field() {
        return i64Field;
    }

    public final com.google.common.base.Optional<Byte> getI8Field() {
        return i8Field;
    }

    public final com.google.common.base.Optional<com.google.common.collect.ImmutableList<String>> getListStringField() {
        return listStringField;
    }

    public final com.google.common.base.Optional<com.google.common.collect.ImmutableMap<String, String>> getMapStringStringField() {
        return mapStringStringField;
    }

    public final int getRequiredI32Field() {
        return requiredI32Field;
    }

    public final String getRequiredStringField() {
        return requiredStringField;
    }

    public final com.google.common.base.Optional<com.google.common.collect.ImmutableSet<String>> getSetStringField() {
        return setStringField;
    }

    public final com.google.common.base.Optional<String> getStringField() {
        return stringField;
    }

    public final com.google.common.base.Optional<org.thryft.protocol.test.NestedProtocolTestStruct> getStructField() {
        return structField;
    }

    public final com.google.common.base.Optional<com.google.common.primitives.UnsignedInteger> getU32Field() {
        return u32Field;
    }

    public final com.google.common.base.Optional<com.google.common.primitives.UnsignedLong> getU64Field() {
        return u64Field;
    }

    public final com.google.common.base.Optional<org.thryft.native_.Url> getUrlField() {
        return urlField;
    }

    @Override
    public int hashCode() {
        int hashCode = 17;
        if (getBinaryField().isPresent()) {
            hashCode = 31 * hashCode + java.util.Arrays.hashCode(getBinaryField().get());
        }
        if (getBoolField().isPresent()) {
            hashCode = 31 * hashCode + (getBoolField().get() ? 1 : 0);
        }
        if (getDateTimeField().isPresent()) {
            hashCode = 31 * hashCode + getDateTimeField().get().hashCode();
        }
        if (getDecimalField().isPresent()) {
            hashCode = 31 * hashCode + getDecimalField().get().hashCode();
        }
        if (getEmailAddressField().isPresent()) {
            hashCode = 31 * hashCode + getEmailAddressField().get().hashCode();
        }
        if (getEnumField().isPresent()) {
            hashCode = 31 * hashCode + getEnumField().get().ordinal();
        }
        if (getI8Field().isPresent()) {
            hashCode = 31 * hashCode + ((byte)getI8Field().get());
        }
        if (getI16Field().isPresent()) {
            hashCode = 31 * hashCode + ((int)getI16Field().get());
        }
        if (getI32Field().isPresent()) {
            hashCode = 31 * hashCode + ((int)getI32Field().get());
        }
        if (getI64Field().isPresent()) {
            hashCode = 31 * hashCode + ((int)(getI64Field().get() ^ (getI64Field().get() >>> 32)));
        }
        if (getListStringField().isPresent()) {
            hashCode = 31 * hashCode + getListStringField().get().hashCode();
        }
        if (getMapStringStringField().isPresent()) {
            hashCode = 31 * hashCode + getMapStringStringField().get().hashCode();
        }
        hashCode = 31 * hashCode + ((int)getRequiredI32Field());
        hashCode = 31 * hashCode + getRequiredStringField().hashCode();
        if (getSetStringField().isPresent()) {
            hashCode = 31 * hashCode + getSetStringField().get().hashCode();
        }
        if (getStringField().isPresent()) {
            hashCode = 31 * hashCode + getStringField().get().hashCode();
        }
        if (getStructField().isPresent()) {
            hashCode = 31 * hashCode + getStructField().get().hashCode();
        }
        if (getU32Field().isPresent()) {
            hashCode = 31 * hashCode + getU32Field().get().hashCode();
        }
        if (getU64Field().isPresent()) {
            hashCode = 31 * hashCode + getU64Field().get().hashCode();
        }
        if (getUrlField().isPresent()) {
            hashCode = 31 * hashCode + getUrlField().get().hashCode();
        }
        return hashCode;
    }

    public ProtocolTestStruct replaceBinaryField(final com.google.common.base.Optional<byte[]> binaryField) {
        return new ProtocolTestStruct(binaryField, this.boolField, this.dateTimeField, this.decimalField, this.emailAddressField, this.enumField, this.i8Field, this.i16Field, this.i32Field, this.i64Field, this.listStringField, this.mapStringStringField, this.requiredI32Field, this.requiredStringField, this.setStringField, this.stringField, this.structField, this.u32Field, this.u64Field, this.urlField);
    }

    public ProtocolTestStruct replaceBinaryField(final byte[] binaryField) {
        return replaceBinaryField(com.google.common.base.Optional.fromNullable(binaryField));
    }

    public ProtocolTestStruct replaceBoolField(final com.google.common.base.Optional<Boolean> boolField) {
        return new ProtocolTestStruct(this.binaryField, boolField, this.dateTimeField, this.decimalField, this.emailAddressField, this.enumField, this.i8Field, this.i16Field, this.i32Field, this.i64Field, this.listStringField, this.mapStringStringField, this.requiredI32Field, this.requiredStringField, this.setStringField, this.stringField, this.structField, this.u32Field, this.u64Field, this.urlField);
    }

    public ProtocolTestStruct replaceBoolField(final boolean boolField) {
        return replaceBoolField(com.google.common.base.Optional.fromNullable(boolField));
    }

    public ProtocolTestStruct replaceDateTimeField(final com.google.common.base.Optional<org.joda.time.DateTime> dateTimeField) {
        return new ProtocolTestStruct(this.binaryField, this.boolField, dateTimeField, this.decimalField, this.emailAddressField, this.enumField, this.i8Field, this.i16Field, this.i32Field, this.i64Field, this.listStringField, this.mapStringStringField, this.requiredI32Field, this.requiredStringField, this.setStringField, this.stringField, this.structField, this.u32Field, this.u64Field, this.urlField);
    }

    public ProtocolTestStruct replaceDateTimeField(final org.joda.time.DateTime dateTimeField) {
        return replaceDateTimeField(com.google.common.base.Optional.fromNullable(dateTimeField));
    }

    public ProtocolTestStruct replaceDecimalField(final com.google.common.base.Optional<java.math.BigDecimal> decimalField) {
        return new ProtocolTestStruct(this.binaryField, this.boolField, this.dateTimeField, decimalField, this.emailAddressField, this.enumField, this.i8Field, this.i16Field, this.i32Field, this.i64Field, this.listStringField, this.mapStringStringField, this.requiredI32Field, this.requiredStringField, this.setStringField, this.stringField, this.structField, this.u32Field, this.u64Field, this.urlField);
    }

    public ProtocolTestStruct replaceDecimalField(final java.math.BigDecimal decimalField) {
        return replaceDecimalField(com.google.common.base.Optional.fromNullable(decimalField));
    }

    public ProtocolTestStruct replaceEmailAddressField(final com.google.common.base.Optional<org.thryft.native_.EmailAddress> emailAddressField) {
        return new ProtocolTestStruct(this.binaryField, this.boolField, this.dateTimeField, this.decimalField, emailAddressField, this.enumField, this.i8Field, this.i16Field, this.i32Field, this.i64Field, this.listStringField, this.mapStringStringField, this.requiredI32Field, this.requiredStringField, this.setStringField, this.stringField, this.structField, this.u32Field, this.u64Field, this.urlField);
    }

    public ProtocolTestStruct replaceEmailAddressField(final org.thryft.native_.EmailAddress emailAddressField) {
        return replaceEmailAddressField(com.google.common.base.Optional.fromNullable(emailAddressField));
    }

    public ProtocolTestStruct replaceEnumField(final com.google.common.base.Optional<org.thryft.protocol.test.ProtocolTestEnum> enumField) {
        return new ProtocolTestStruct(this.binaryField, this.boolField, this.dateTimeField, this.decimalField, this.emailAddressField, enumField, this.i8Field, this.i16Field, this.i32Field, this.i64Field, this.listStringField, this.mapStringStringField, this.requiredI32Field, this.requiredStringField, this.setStringField, this.stringField, this.structField, this.u32Field, this.u64Field, this.urlField);
    }

    public ProtocolTestStruct replaceEnumField(final org.thryft.protocol.test.ProtocolTestEnum enumField) {
        return replaceEnumField(com.google.common.base.Optional.fromNullable(enumField));
    }

    public ProtocolTestStruct replaceI16Field(final com.google.common.base.Optional<Short> i16Field) {
        return new ProtocolTestStruct(this.binaryField, this.boolField, this.dateTimeField, this.decimalField, this.emailAddressField, this.enumField, this.i8Field, i16Field, this.i32Field, this.i64Field, this.listStringField, this.mapStringStringField, this.requiredI32Field, this.requiredStringField, this.setStringField, this.stringField, this.structField, this.u32Field, this.u64Field, this.urlField);
    }

    public ProtocolTestStruct replaceI16Field(final short i16Field) {
        return replaceI16Field(com.google.common.base.Optional.fromNullable(i16Field));
    }

    public ProtocolTestStruct replaceI32Field(final com.google.common.base.Optional<Integer> i32Field) {
        return new ProtocolTestStruct(this.binaryField, this.boolField, this.dateTimeField, this.decimalField, this.emailAddressField, this.enumField, this.i8Field, this.i16Field, i32Field, this.i64Field, this.listStringField, this.mapStringStringField, this.requiredI32Field, this.requiredStringField, this.setStringField, this.stringField, this.structField, this.u32Field, this.u64Field, this.urlField);
    }

    public ProtocolTestStruct replaceI32Field(final int i32Field) {
        return replaceI32Field(com.google.common.base.Optional.fromNullable(i32Field));
    }

    public ProtocolTestStruct replaceI64Field(final com.google.common.base.Optional<Long> i64Field) {
        return new ProtocolTestStruct(this.binaryField, this.boolField, this.dateTimeField, this.decimalField, this.emailAddressField, this.enumField, this.i8Field, this.i16Field, this.i32Field, i64Field, this.listStringField, this.mapStringStringField, this.requiredI32Field, this.requiredStringField, this.setStringField, this.stringField, this.structField, this.u32Field, this.u64Field, this.urlField);
    }

    public ProtocolTestStruct replaceI64Field(final long i64Field) {
        return replaceI64Field(com.google.common.base.Optional.fromNullable(i64Field));
    }

    public ProtocolTestStruct replaceI8Field(final com.google.common.base.Optional<Byte> i8Field) {
        return new ProtocolTestStruct(this.binaryField, this.boolField, this.dateTimeField, this.decimalField, this.emailAddressField, this.enumField, i8Field, this.i16Field, this.i32Field, this.i64Field, this.listStringField, this.mapStringStringField, this.requiredI32Field, this.requiredStringField, this.setStringField, this.stringField, this.structField, this.u32Field, this.u64Field, this.urlField);
    }

    public ProtocolTestStruct replaceI8Field(final byte i8Field) {
        return replaceI8Field(com.google.common.base.Optional.fromNullable(i8Field));
    }

    public ProtocolTestStruct replaceListStringField(final com.google.common.base.Optional<com.google.common.collect.ImmutableList<String>> listStringField) {
        return new ProtocolTestStruct(this.binaryField, this.boolField, this.dateTimeField, this.decimalField, this.emailAddressField, this.enumField, this.i8Field, this.i16Field, this.i32Field, this.i64Field, listStringField, this.mapStringStringField, this.requiredI32Field, this.requiredStringField, this.setStringField, this.stringField, this.structField, this.u32Field, this.u64Field, this.urlField);
    }

    public ProtocolTestStruct replaceListStringField(final com.google.common.collect.ImmutableList<String> listStringField) {
        return replaceListStringField(com.google.common.base.Optional.fromNullable(listStringField));
    }

    public ProtocolTestStruct replaceMapStringStringField(final com.google.common.base.Optional<com.google.common.collect.ImmutableMap<String, String>> mapStringStringField) {
        return new ProtocolTestStruct(this.binaryField, this.boolField, this.dateTimeField, this.decimalField, this.emailAddressField, this.enumField, this.i8Field, this.i16Field, this.i32Field, this.i64Field, this.listStringField, mapStringStringField, this.requiredI32Field, this.requiredStringField, this.setStringField, this.stringField, this.structField, this.u32Field, this.u64Field, this.urlField);
    }

    public ProtocolTestStruct replaceMapStringStringField(final com.google.common.collect.ImmutableMap<String, String> mapStringStringField) {
        return replaceMapStringStringField(com.google.common.base.Optional.fromNullable(mapStringStringField));
    }

    public ProtocolTestStruct replaceRequiredI32Field(final int requiredI32Field) {
        return new ProtocolTestStruct(this.binaryField, this.boolField, this.dateTimeField, this.decimalField, this.emailAddressField, this.enumField, this.i8Field, this.i16Field, this.i32Field, this.i64Field, this.listStringField, this.mapStringStringField, requiredI32Field, this.requiredStringField, this.setStringField, this.stringField, this.structField, this.u32Field, this.u64Field, this.urlField);
    }

    public ProtocolTestStruct replaceRequiredStringField(final String requiredStringField) {
        return new ProtocolTestStruct(this.binaryField, this.boolField, this.dateTimeField, this.decimalField, this.emailAddressField, this.enumField, this.i8Field, this.i16Field, this.i32Field, this.i64Field, this.listStringField, this.mapStringStringField, this.requiredI32Field, requiredStringField, this.setStringField, this.stringField, this.structField, this.u32Field, this.u64Field, this.urlField);
    }

    public ProtocolTestStruct replaceSetStringField(final com.google.common.base.Optional<com.google.common.collect.ImmutableSet<String>> setStringField) {
        return new ProtocolTestStruct(this.binaryField, this.boolField, this.dateTimeField, this.decimalField, this.emailAddressField, this.enumField, this.i8Field, this.i16Field, this.i32Field, this.i64Field, this.listStringField, this.mapStringStringField, this.requiredI32Field, this.requiredStringField, setStringField, this.stringField, this.structField, this.u32Field, this.u64Field, this.urlField);
    }

    public ProtocolTestStruct replaceSetStringField(final com.google.common.collect.ImmutableSet<String> setStringField) {
        return replaceSetStringField(com.google.common.base.Optional.fromNullable(setStringField));
    }

    public ProtocolTestStruct replaceStringField(final com.google.common.base.Optional<String> stringField) {
        return new ProtocolTestStruct(this.binaryField, this.boolField, this.dateTimeField, this.decimalField, this.emailAddressField, this.enumField, this.i8Field, this.i16Field, this.i32Field, this.i64Field, this.listStringField, this.mapStringStringField, this.requiredI32Field, this.requiredStringField, this.setStringField, stringField, this.structField, this.u32Field, this.u64Field, this.urlField);
    }

    public ProtocolTestStruct replaceStringField(final String stringField) {
        return replaceStringField(com.google.common.base.Optional.fromNullable(stringField));
    }

    public ProtocolTestStruct replaceStructField(final com.google.common.base.Optional<org.thryft.protocol.test.NestedProtocolTestStruct> structField) {
        return new ProtocolTestStruct(this.binaryField, this.boolField, this.dateTimeField, this.decimalField, this.emailAddressField, this.enumField, this.i8Field, this.i16Field, this.i32Field, this.i64Field, this.listStringField, this.mapStringStringField, this.requiredI32Field, this.requiredStringField, this.setStringField, this.stringField, structField, this.u32Field, this.u64Field, this.urlField);
    }

    public ProtocolTestStruct replaceStructField(final org.thryft.protocol.test.NestedProtocolTestStruct structField) {
        return replaceStructField(com.google.common.base.Optional.fromNullable(structField));
    }

    public ProtocolTestStruct replaceU32Field(final com.google.common.base.Optional<com.google.common.primitives.UnsignedInteger> u32Field) {
        return new ProtocolTestStruct(this.binaryField, this.boolField, this.dateTimeField, this.decimalField, this.emailAddressField, this.enumField, this.i8Field, this.i16Field, this.i32Field, this.i64Field, this.listStringField, this.mapStringStringField, this.requiredI32Field, this.requiredStringField, this.setStringField, this.stringField, this.structField, u32Field, this.u64Field, this.urlField);
    }

    public ProtocolTestStruct replaceU32Field(final com.google.common.primitives.UnsignedInteger u32Field) {
        return replaceU32Field(com.google.common.base.Optional.fromNullable(u32Field));
    }

    public ProtocolTestStruct replaceU64Field(final com.google.common.base.Optional<com.google.common.primitives.UnsignedLong> u64Field) {
        return new ProtocolTestStruct(this.binaryField, this.boolField, this.dateTimeField, this.decimalField, this.emailAddressField, this.enumField, this.i8Field, this.i16Field, this.i32Field, this.i64Field, this.listStringField, this.mapStringStringField, this.requiredI32Field, this.requiredStringField, this.setStringField, this.stringField, this.structField, this.u32Field, u64Field, this.urlField);
    }

    public ProtocolTestStruct replaceU64Field(final com.google.common.primitives.UnsignedLong u64Field) {
        return replaceU64Field(com.google.common.base.Optional.fromNullable(u64Field));
    }

    public ProtocolTestStruct replaceUrlField(final com.google.common.base.Optional<org.thryft.native_.Url> urlField) {
        return new ProtocolTestStruct(this.binaryField, this.boolField, this.dateTimeField, this.decimalField, this.emailAddressField, this.enumField, this.i8Field, this.i16Field, this.i32Field, this.i64Field, this.listStringField, this.mapStringStringField, this.requiredI32Field, this.requiredStringField, this.setStringField, this.stringField, this.structField, this.u32Field, this.u64Field, urlField);
    }

    public ProtocolTestStruct replaceUrlField(final org.thryft.native_.Url urlField) {
        return replaceUrlField(com.google.common.base.Optional.fromNullable(urlField));
    }

    @Override
    public String toString() {
        final com.google.common.base.Objects.ToStringHelper helper = com.google.common.base.Objects.toStringHelper(this);
        if (getBinaryField().isPresent()) {
            helper.add("binary_field", getBinaryField());
        }
        if (getBoolField().isPresent()) {
            helper.add("bool_field", getBoolField());
        }
        if (getDateTimeField().isPresent()) {
            helper.add("date_time_field", getDateTimeField());
        }
        if (getDecimalField().isPresent()) {
            helper.add("decimal_field", getDecimalField());
        }
        if (getEmailAddressField().isPresent()) {
            helper.add("email_address_field", getEmailAddressField());
        }
        if (getEnumField().isPresent()) {
            helper.add("enum_field", getEnumField());
        }
        if (getI8Field().isPresent()) {
            helper.add("i8_field", getI8Field());
        }
        if (getI16Field().isPresent()) {
            helper.add("i16_field", getI16Field());
        }
        if (getI32Field().isPresent()) {
            helper.add("i32_field", getI32Field());
        }
        if (getI64Field().isPresent()) {
            helper.add("i64_field", getI64Field());
        }
        if (getListStringField().isPresent()) {
            helper.add("list_string_field", getListStringField());
        }
        if (getMapStringStringField().isPresent()) {
            helper.add("map_string_string_field", getMapStringStringField());
        }
        helper.add("required_i32_field", getRequiredI32Field());
        helper.add("required_string_field", getRequiredStringField());
        if (getSetStringField().isPresent()) {
            helper.add("set_string_field", getSetStringField());
        }
        if (getStringField().isPresent()) {
            helper.add("string_field", getStringField());
        }
        if (getStructField().isPresent()) {
            helper.add("struct_field", getStructField());
        }
        if (getU32Field().isPresent()) {
            helper.add("u32_field", getU32Field());
        }
        if (getU64Field().isPresent()) {
            helper.add("u64_field", getU64Field());
        }
        if (getUrlField().isPresent()) {
            helper.add("url_field", getUrlField());
        }
        return helper.toString();
    }

    @Override
    public void write(final org.thryft.protocol.OutputProtocol oprot) throws java.io.IOException {
        write(oprot, org.thryft.protocol.Type.STRUCT);
    }

    public void write(final org.thryft.protocol.OutputProtocol oprot, final byte writeAsTType) throws java.io.IOException {
        switch (writeAsTType) {
            case org.thryft.protocol.Type.VOID:
            case org.thryft.protocol.Type.LIST:
                oprot.writeListBegin(new org.thryft.protocol.ListBegin(org.thryft.protocol.Type.VOID, 20));

                if (getBinaryField().isPresent()) {
                    oprot.writeBinary(getBinaryField().get());
                } else {
                    oprot.writeNull();
                }

                if (getBoolField().isPresent()) {
                    oprot.writeBool(getBoolField().get());
                } else {
                    oprot.writeNull();
                }

                if (getDateTimeField().isPresent()) {
                    oprot.writeDateTime(getDateTimeField().get());
                } else {
                    oprot.writeNull();
                }

                if (getDecimalField().isPresent()) {
                    oprot.writeDecimal(getDecimalField().get());
                } else {
                    oprot.writeNull();
                }

                if (getEmailAddressField().isPresent()) {
                    oprot.writeEmailAddress(getEmailAddressField().get());
                } else {
                    oprot.writeNull();
                }

                if (getEnumField().isPresent()) {
                    oprot.writeEnum(getEnumField().get());
                } else {
                    oprot.writeNull();
                }

                if (getI8Field().isPresent()) {
                    oprot.writeByte(getI8Field().get());
                } else {
                    oprot.writeNull();
                }

                if (getI16Field().isPresent()) {
                    oprot.writeI16(getI16Field().get());
                } else {
                    oprot.writeNull();
                }

                if (getI32Field().isPresent()) {
                    oprot.writeI32(getI32Field().get());
                } else {
                    oprot.writeNull();
                }

                if (getI64Field().isPresent()) {
                    oprot.writeI64(getI64Field().get());
                } else {
                    oprot.writeNull();
                }

                if (getListStringField().isPresent()) {
                    oprot.writeListBegin(new org.thryft.protocol.ListBegin(org.thryft.protocol.Type.STRING, getListStringField().get().size()));
                    for (final String _iter0 : getListStringField().get()) {
                        oprot.writeString(_iter0);
                    }
                    oprot.writeListEnd();
                } else {
                    oprot.writeNull();
                }

                if (getMapStringStringField().isPresent()) {
                    oprot.writeMapBegin(new org.thryft.protocol.MapBegin(org.thryft.protocol.Type.STRING, org.thryft.protocol.Type.STRING, getMapStringStringField().get().size()));
                    for (com.google.common.collect.ImmutableMap.Entry<String, String> _iter0 : getMapStringStringField().get().entrySet()) {
                        oprot.writeString(_iter0.getKey());
                        oprot.writeString(_iter0.getValue());
                    }
                    oprot.writeMapEnd();
                } else {
                    oprot.writeNull();
                }

                oprot.writeI32(getRequiredI32Field());

                oprot.writeString(getRequiredStringField());

                if (getSetStringField().isPresent()) {
                    oprot.writeSetBegin(new org.thryft.protocol.SetBegin(org.thryft.protocol.Type.STRING, getSetStringField().get().size()));
                    for (final String _iter0 : getSetStringField().get()) {
                        oprot.writeString(_iter0);
                    }
                    oprot.writeSetEnd();
                } else {
                    oprot.writeNull();
                }

                if (getStringField().isPresent()) {
                    oprot.writeString(getStringField().get());
                } else {
                    oprot.writeNull();
                }

                if (getStructField().isPresent()) {
                    getStructField().get().write(oprot);
                } else {
                    oprot.writeNull();
                }

                if (getU32Field().isPresent()) {
                    oprot.writeU32(getU32Field().get());
                } else {
                    oprot.writeNull();
                }

                if (getU64Field().isPresent()) {
                    oprot.writeU64(getU64Field().get());
                } else {
                    oprot.writeNull();
                }

                if (getUrlField().isPresent()) {
                    oprot.writeUrl(getUrlField().get());
                } else {
                    oprot.writeNull();
                }

                oprot.writeListEnd();
                break;

            case org.thryft.protocol.Type.STRUCT:
            default:
                oprot.writeStructBegin(new org.thryft.protocol.StructBegin("ProtocolTestStruct"));

                if (getBinaryField().isPresent()) {
                    oprot.writeFieldBegin(new org.thryft.protocol.FieldBegin("binary_field", org.thryft.protocol.Type.STRING, (short)-1));
                    oprot.writeBinary(getBinaryField().get());
                    oprot.writeFieldEnd();
                }

                if (getBoolField().isPresent()) {
                    oprot.writeFieldBegin(new org.thryft.protocol.FieldBegin("bool_field", org.thryft.protocol.Type.BOOL, (short)-1));
                    oprot.writeBool(getBoolField().get());
                    oprot.writeFieldEnd();
                }

                if (getDateTimeField().isPresent()) {
                    oprot.writeFieldBegin(new org.thryft.protocol.FieldBegin("date_time_field", org.thryft.protocol.Type.I64, (short)-1));
                    oprot.writeDateTime(getDateTimeField().get());
                    oprot.writeFieldEnd();
                }

                if (getDecimalField().isPresent()) {
                    oprot.writeFieldBegin(new org.thryft.protocol.FieldBegin("decimal_field", org.thryft.protocol.Type.STRING, (short)-1));
                    oprot.writeDecimal(getDecimalField().get());
                    oprot.writeFieldEnd();
                }

                if (getEmailAddressField().isPresent()) {
                    oprot.writeFieldBegin(new org.thryft.protocol.FieldBegin("email_address_field", org.thryft.protocol.Type.STRING, (short)-1));
                    oprot.writeEmailAddress(getEmailAddressField().get());
                    oprot.writeFieldEnd();
                }

                if (getEnumField().isPresent()) {
                    oprot.writeFieldBegin(new org.thryft.protocol.FieldBegin("enum_field", org.thryft.protocol.Type.STRING, (short)-1));
                    oprot.writeEnum(getEnumField().get());
                    oprot.writeFieldEnd();
                }

                if (getI8Field().isPresent()) {
                    oprot.writeFieldBegin(new org.thryft.protocol.FieldBegin("i8_field", org.thryft.protocol.Type.BYTE, (short)-1));
                    oprot.writeByte(getI8Field().get());
                    oprot.writeFieldEnd();
                }

                if (getI16Field().isPresent()) {
                    oprot.writeFieldBegin(new org.thryft.protocol.FieldBegin("i16_field", org.thryft.protocol.Type.I16, (short)-1));
                    oprot.writeI16(getI16Field().get());
                    oprot.writeFieldEnd();
                }

                if (getI32Field().isPresent()) {
                    oprot.writeFieldBegin(new org.thryft.protocol.FieldBegin("i32_field", org.thryft.protocol.Type.I32, (short)-1));
                    oprot.writeI32(getI32Field().get());
                    oprot.writeFieldEnd();
                }

                if (getI64Field().isPresent()) {
                    oprot.writeFieldBegin(new org.thryft.protocol.FieldBegin("i64_field", org.thryft.protocol.Type.I64, (short)-1));
                    oprot.writeI64(getI64Field().get());
                    oprot.writeFieldEnd();
                }

                if (getListStringField().isPresent()) {
                    oprot.writeFieldBegin(new org.thryft.protocol.FieldBegin("list_string_field", org.thryft.protocol.Type.LIST, (short)-1));
                    oprot.writeListBegin(new org.thryft.protocol.ListBegin(org.thryft.protocol.Type.STRING, getListStringField().get().size()));
                    for (final String _iter0 : getListStringField().get()) {
                        oprot.writeString(_iter0);
                    }
                    oprot.writeListEnd();
                    oprot.writeFieldEnd();
                }

                if (getMapStringStringField().isPresent()) {
                    oprot.writeFieldBegin(new org.thryft.protocol.FieldBegin("map_string_string_field", org.thryft.protocol.Type.MAP, (short)-1));
                    oprot.writeMapBegin(new org.thryft.protocol.MapBegin(org.thryft.protocol.Type.STRING, org.thryft.protocol.Type.STRING, getMapStringStringField().get().size()));
                    for (com.google.common.collect.ImmutableMap.Entry<String, String> _iter0 : getMapStringStringField().get().entrySet()) {
                        oprot.writeString(_iter0.getKey());
                        oprot.writeString(_iter0.getValue());
                    }
                    oprot.writeMapEnd();
                    oprot.writeFieldEnd();
                }

                oprot.writeFieldBegin(new org.thryft.protocol.FieldBegin("required_i32_field", org.thryft.protocol.Type.I32, (short)-1));
                oprot.writeI32(getRequiredI32Field());
                oprot.writeFieldEnd();

                oprot.writeFieldBegin(new org.thryft.protocol.FieldBegin("required_string_field", org.thryft.protocol.Type.STRING, (short)-1));
                oprot.writeString(getRequiredStringField());
                oprot.writeFieldEnd();

                if (getSetStringField().isPresent()) {
                    oprot.writeFieldBegin(new org.thryft.protocol.FieldBegin("set_string_field", org.thryft.protocol.Type.SET, (short)-1));
                    oprot.writeSetBegin(new org.thryft.protocol.SetBegin(org.thryft.protocol.Type.STRING, getSetStringField().get().size()));
                    for (final String _iter0 : getSetStringField().get()) {
                        oprot.writeString(_iter0);
                    }
                    oprot.writeSetEnd();
                    oprot.writeFieldEnd();
                }

                if (getStringField().isPresent()) {
                    oprot.writeFieldBegin(new org.thryft.protocol.FieldBegin("string_field", org.thryft.protocol.Type.STRING, (short)-1));
                    oprot.writeString(getStringField().get());
                    oprot.writeFieldEnd();
                }

                if (getStructField().isPresent()) {
                    oprot.writeFieldBegin(new org.thryft.protocol.FieldBegin("struct_field", org.thryft.protocol.Type.STRUCT, (short)-1));
                    getStructField().get().write(oprot);
                    oprot.writeFieldEnd();
                }

                if (getU32Field().isPresent()) {
                    oprot.writeFieldBegin(new org.thryft.protocol.FieldBegin("u32_field", org.thryft.protocol.Type.I32, (short)-1));
                    oprot.writeU32(getU32Field().get());
                    oprot.writeFieldEnd();
                }

                if (getU64Field().isPresent()) {
                    oprot.writeFieldBegin(new org.thryft.protocol.FieldBegin("u64_field", org.thryft.protocol.Type.I64, (short)-1));
                    oprot.writeU64(getU64Field().get());
                    oprot.writeFieldEnd();
                }

                if (getUrlField().isPresent()) {
                    oprot.writeFieldBegin(new org.thryft.protocol.FieldBegin("url_field", org.thryft.protocol.Type.STRING, (short)-1));
                    oprot.writeUrl(getUrlField().get());
                    oprot.writeFieldEnd();
                }

                oprot.writeFieldStop();

                oprot.writeStructEnd();
                break;
        }
    }

    private final com.google.common.base.Optional<byte[]> binaryField;

    private final com.google.common.base.Optional<Boolean> boolField;

    private final com.google.common.base.Optional<org.joda.time.DateTime> dateTimeField;

    private final com.google.common.base.Optional<java.math.BigDecimal> decimalField;

    private final com.google.common.base.Optional<org.thryft.native_.EmailAddress> emailAddressField;

    private final com.google.common.base.Optional<org.thryft.protocol.test.ProtocolTestEnum> enumField;

    private final com.google.common.base.Optional<Byte> i8Field;

    private final com.google.common.base.Optional<Short> i16Field;

    private final com.google.common.base.Optional<Integer> i32Field;

    private final com.google.common.base.Optional<Long> i64Field;

    private final com.google.common.base.Optional<com.google.common.collect.ImmutableList<String>> listStringField;

    private final com.google.common.base.Optional<com.google.common.collect.ImmutableMap<String, String>> mapStringStringField;

    private final int requiredI32Field;

    private final String requiredStringField;

    private final com.google.common.base.Optional<com.google.common.collect.ImmutableSet<String>> setStringField;

    private final com.google.common.base.Optional<String> stringField;

    private final com.google.common.base.Optional<org.thryft.protocol.test.NestedProtocolTestStruct> structField;

    private final com.google.common.base.Optional<com.google.common.primitives.UnsignedInteger> u32Field;

    private final com.google.common.base.Optional<com.google.common.primitives.UnsignedLong> u64Field;

    private final com.google.common.base.Optional<org.thryft.native_.Url> urlField;
}
