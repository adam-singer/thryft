package org.thryft.protocol.test;

@SuppressWarnings({"serial"})
public class ProtocolTestStruct implements org.thryft.TBase<ProtocolTestStruct> {
    public static class Builder {
        public Builder() {
        }

        public Builder(final ProtocolTestStruct other) {
            this.binaryField = other.getBinaryField();
            this.boolField = other.isBoolField();
            this.byteField = other.getByteField();
            this.dateTimeField = other.getDateTimeField();
            this.decimalField = other.getDecimalField();
            this.emailAddressField = other.getEmailAddressField();
            this.enumField = other.getEnumField();
            this.i16Field = other.getI16Field();
            this.i32Field = other.getI32Field();
            this.i64Field = other.getI64Field();
            this.listStringField = other.getListStringField();
            this.mapStringStringField = other.getMapStringStringField();
            this.setStringField = other.getSetStringField();
            this.stringField = other.getStringField();
            this.structField = other.getStructField();
            this.urlField = other.getUrlField();
        }

        protected ProtocolTestStruct _build(final byte[] binaryField, final Boolean boolField, final Byte byteField, final org.joda.time.DateTime dateTimeField, final java.math.BigDecimal decimalField, final org.thryft.native_.EmailAddress emailAddressField, final org.thryft.protocol.test.ProtocolTestEnum enumField, final Short i16Field, final Integer i32Field, final Long i64Field, final com.google.common.collect.ImmutableList<String> listStringField, final com.google.common.collect.ImmutableMap<String, String> mapStringStringField, final com.google.common.collect.ImmutableSet<String> setStringField, final String stringField, final org.thryft.protocol.test.ProtocolTestStruct structField, final org.thryft.native_.Url urlField) {
            return new ProtocolTestStruct(binaryField, boolField, byteField, dateTimeField, decimalField, emailAddressField, enumField, i16Field, i32Field, i64Field, listStringField, mapStringStringField, setStringField, stringField, structField, urlField);
        }

        public ProtocolTestStruct build() {
            return _build(binaryField, boolField, byteField, dateTimeField, decimalField, emailAddressField, enumField, i16Field, i32Field, i64Field, listStringField, mapStringStringField, setStringField, stringField, structField, urlField);
        }

        public Builder setBinaryField(final byte[] binaryField) {
            this.binaryField = binaryField;
            return this;
        }

        public Builder setBoolField(final Boolean boolField) {
            this.boolField = boolField;
            return this;
        }

        public Builder setByteField(final Byte byteField) {
            this.byteField = byteField;
            return this;
        }

        public Builder setDateTimeField(final org.joda.time.DateTime dateTimeField) {
            this.dateTimeField = dateTimeField;
            return this;
        }

        public Builder setDecimalField(final java.math.BigDecimal decimalField) {
            this.decimalField = decimalField;
            return this;
        }

        public Builder setEmailAddressField(final org.thryft.native_.EmailAddress emailAddressField) {
            this.emailAddressField = emailAddressField;
            return this;
        }

        public Builder setEnumField(final org.thryft.protocol.test.ProtocolTestEnum enumField) {
            this.enumField = enumField;
            return this;
        }

        public Builder setI16Field(final Short i16Field) {
            this.i16Field = i16Field;
            return this;
        }

        public Builder setI32Field(final Integer i32Field) {
            this.i32Field = i32Field;
            return this;
        }

        public Builder setI64Field(final Long i64Field) {
            this.i64Field = i64Field;
            return this;
        }

        public Builder setListStringField(final com.google.common.collect.ImmutableList<String> listStringField) {
            this.listStringField = listStringField;
            return this;
        }

        public Builder setMapStringStringField(final com.google.common.collect.ImmutableMap<String, String> mapStringStringField) {
            this.mapStringStringField = mapStringStringField;
            return this;
        }

        public Builder setSetStringField(final com.google.common.collect.ImmutableSet<String> setStringField) {
            this.setStringField = setStringField;
            return this;
        }

        public Builder setStringField(final String stringField) {
            this.stringField = stringField;
            return this;
        }

        public Builder setStructField(final org.thryft.protocol.test.ProtocolTestStruct structField) {
            this.structField = structField;
            return this;
        }

        public Builder setUrlField(final org.thryft.native_.Url urlField) {
            this.urlField = urlField;
            return this;
        }

        private byte[] binaryField;
        private Boolean boolField;
        private Byte byteField;
        private org.joda.time.DateTime dateTimeField;
        private java.math.BigDecimal decimalField;
        private org.thryft.native_.EmailAddress emailAddressField;
        private org.thryft.protocol.test.ProtocolTestEnum enumField;
        private Short i16Field;
        private Integer i32Field;
        private Long i64Field;
        private com.google.common.collect.ImmutableList<String> listStringField;
        private com.google.common.collect.ImmutableMap<String, String> mapStringStringField;
        private com.google.common.collect.ImmutableSet<String> setStringField;
        private String stringField;
        private org.thryft.protocol.test.ProtocolTestStruct structField;
        private org.thryft.native_.Url urlField;
    }

    public ProtocolTestStruct() {
        binaryField = null;
        boolField = null;
        byteField = null;
        dateTimeField = null;
        decimalField = null;
        emailAddressField = null;
        enumField = null;
        i16Field = null;
        i32Field = null;
        i64Field = null;
        listStringField = null;
        mapStringStringField = null;
        setStringField = null;
        stringField = null;
        structField = null;
        urlField = null;
    }

    public ProtocolTestStruct(final ProtocolTestStruct other) {
        this(other.getBinaryField(), other.isBoolField(), other.getByteField(), other.getDateTimeField(), other.getDecimalField(), other.getEmailAddressField(), other.getEnumField(), other.getI16Field(), other.getI32Field(), other.getI64Field(), other.getListStringField(), other.getMapStringStringField(), other.getSetStringField(), other.getStringField(), other.getStructField(), other.getUrlField());
    }

    public ProtocolTestStruct(final org.thryft.protocol.TProtocol iprot) throws java.io.IOException {
        this(iprot, org.thryft.protocol.TType.STRUCT);
    }

    public ProtocolTestStruct(final org.thryft.protocol.TProtocol iprot, final byte readAsTType) throws java.io.IOException {
        byte[] binaryField = null;
        Boolean boolField = null;
        Byte byteField = null;
        org.joda.time.DateTime dateTimeField = null;
        java.math.BigDecimal decimalField = null;
        org.thryft.native_.EmailAddress emailAddressField = null;
        org.thryft.protocol.test.ProtocolTestEnum enumField = null;
        Short i16Field = null;
        Integer i32Field = null;
        Long i64Field = null;
        com.google.common.collect.ImmutableList<String> listStringField = null;
        com.google.common.collect.ImmutableMap<String, String> mapStringStringField = null;
        com.google.common.collect.ImmutableSet<String> setStringField = null;
        String stringField = null;
        org.thryft.protocol.test.ProtocolTestStruct structField = null;
        org.thryft.native_.Url urlField = null;

        switch (readAsTType) {
            case org.thryft.protocol.TType.LIST:
                final org.thryft.protocol.TList __list = iprot.readListBegin();
                if (__list.size > 0) {
                    binaryField = iprot.readBinary();
                }
                if (__list.size > 1) {
                    boolField = iprot.readBool();
                }
                if (__list.size > 2) {
                    try {
                        byteField = iprot.readByte();
                    } catch (NumberFormatException e) {
                    }
                }
                if (__list.size > 3) {
                    try {
                        dateTimeField = iprot.readDateTime();
                    } catch (IllegalArgumentException e) {
                    }
                }
                if (__list.size > 4) {
                    try {
                        decimalField = iprot.readDecimal();
                    } catch (NumberFormatException e) {
                    }
                }
                if (__list.size > 5) {
                    emailAddressField = iprot.readEmailAddress();
                }
                if (__list.size > 6) {
                    try {
                        enumField = iprot.readEnum(org.thryft.protocol.test.ProtocolTestEnum.class);
                    } catch (IllegalArgumentException e) {
                    }
                }
                if (__list.size > 7) {
                    try {
                        i16Field = iprot.readI16();
                    } catch (NumberFormatException e) {
                    }
                }
                if (__list.size > 8) {
                    try {
                        i32Field = iprot.readI32();
                    } catch (NumberFormatException e) {
                    }
                }
                if (__list.size > 9) {
                    try {
                        i64Field = iprot.readI64();
                    } catch (NumberFormatException e) {
                    }
                }
                if (__list.size > 10) {
                    listStringField = (new com.google.common.base.Function<org.thryft.protocol.TProtocol, com.google.common.collect.ImmutableList<String>>() {
                        @Override
                        public com.google.common.collect.ImmutableList<String> apply(final org.thryft.protocol.TProtocol iprot) {
                            try {
                                final org.thryft.protocol.TList sequenceBegin = iprot.readListBegin();
                                final java.util.List<String> sequence = new java.util.ArrayList<String>();
                                for (int elementI = 0; elementI < sequenceBegin.size; elementI++) {
                                    sequence.add(iprot.readString());
                                }
                                iprot.readListEnd();
                                return com.google.common.collect.ImmutableList.copyOf(sequence);
                            } catch (final java.io.IOException e) {
                                return com.google.common.collect.ImmutableList.of();
                            }
                        }
                    }).apply(iprot);
                }
                if (__list.size > 11) {
                    mapStringStringField = (new com.google.common.base.Function<org.thryft.protocol.TProtocol, com.google.common.collect.ImmutableMap<String, String>>() {
                        @Override
                        public com.google.common.collect.ImmutableMap<String, String> apply(org.thryft.protocol.TProtocol iprot) {
                            try {
                                org.thryft.protocol.TMap mapBegin = iprot.readMapBegin();
                                java.util.Map<String, String> map = new java.util.HashMap<String, String>();
                                for (int entryI = 0; entryI < mapBegin.size; entryI++) {
                                    map.put(iprot.readString(), iprot.readString());
                                }
                                iprot.readMapEnd();
                                return com.google.common.collect.ImmutableMap.copyOf(map);
                            } catch (final java.io.IOException e) {
                                return com.google.common.collect.ImmutableMap.of();
                            }
                        }
                    }).apply(iprot);
                }
                if (__list.size > 12) {
                    setStringField = (new com.google.common.base.Function<org.thryft.protocol.TProtocol, com.google.common.collect.ImmutableSet<String>>() {
                        @Override
                        public com.google.common.collect.ImmutableSet<String> apply(final org.thryft.protocol.TProtocol iprot) {
                            try {
                                final org.thryft.protocol.TSet sequenceBegin = iprot.readSetBegin();
                                final java.util.Set<String> sequence = new java.util.LinkedHashSet<String>();
                                for (int elementI = 0; elementI < sequenceBegin.size; elementI++) {
                                    sequence.add(iprot.readString());
                                }
                                iprot.readSetEnd();
                                return com.google.common.collect.ImmutableSet.copyOf(sequence);
                            } catch (final java.io.IOException e) {
                                return com.google.common.collect.ImmutableSet.of();
                            }
                        }
                    }).apply(iprot);
                }
                if (__list.size > 13) {
                    stringField = iprot.readString();
                }
                if (__list.size > 14) {
                    structField = new org.thryft.protocol.test.ProtocolTestStruct(iprot);
                }
                if (__list.size > 15) {
                    try {
                        urlField = iprot.readUrl();
                    } catch (java.net.MalformedURLException e) {
                    }
                }
                iprot.readListEnd();
                break;

            case org.thryft.protocol.TType.STRUCT:
            default:
                iprot.readStructBegin();
                while (true) {
                    final org.thryft.protocol.TField ifield = iprot.readFieldBegin();
                    if (ifield.type == org.thryft.protocol.TType.STOP) {
                        break;
                    } else if (ifield.name.equals("binary_field")) {
                        binaryField = iprot.readBinary();
                    } else if (ifield.name.equals("bool_field")) {
                        boolField = iprot.readBool();
                    } else if (ifield.name.equals("byte_field")) {
                        try {
                            byteField = iprot.readByte();
                        } catch (NumberFormatException e) {
                        }
                    } else if (ifield.name.equals("date_time_field")) {
                        try {
                            dateTimeField = iprot.readDateTime();
                        } catch (IllegalArgumentException e) {
                        }
                    } else if (ifield.name.equals("decimal_field")) {
                        try {
                            decimalField = iprot.readDecimal();
                        } catch (NumberFormatException e) {
                        }
                    } else if (ifield.name.equals("email_address_field")) {
                        emailAddressField = iprot.readEmailAddress();
                    } else if (ifield.name.equals("enum_field")) {
                        try {
                            enumField = iprot.readEnum(org.thryft.protocol.test.ProtocolTestEnum.class);
                        } catch (IllegalArgumentException e) {
                        }
                    } else if (ifield.name.equals("i16_field")) {
                        try {
                            i16Field = iprot.readI16();
                        } catch (NumberFormatException e) {
                        }
                    } else if (ifield.name.equals("i32_field")) {
                        try {
                            i32Field = iprot.readI32();
                        } catch (NumberFormatException e) {
                        }
                    } else if (ifield.name.equals("i64_field")) {
                        try {
                            i64Field = iprot.readI64();
                        } catch (NumberFormatException e) {
                        }
                    } else if (ifield.name.equals("list_string_field")) {
                        listStringField = (new com.google.common.base.Function<org.thryft.protocol.TProtocol, com.google.common.collect.ImmutableList<String>>() {
                            @Override
                            public com.google.common.collect.ImmutableList<String> apply(final org.thryft.protocol.TProtocol iprot) {
                                try {
                                    final org.thryft.protocol.TList sequenceBegin = iprot.readListBegin();
                                    final java.util.List<String> sequence = new java.util.ArrayList<String>();
                                    for (int elementI = 0; elementI < sequenceBegin.size; elementI++) {
                                        sequence.add(iprot.readString());
                                    }
                                    iprot.readListEnd();
                                    return com.google.common.collect.ImmutableList.copyOf(sequence);
                                } catch (final java.io.IOException e) {
                                    return com.google.common.collect.ImmutableList.of();
                                }
                            }
                        }).apply(iprot);
                    } else if (ifield.name.equals("map_string_string_field")) {
                        mapStringStringField = (new com.google.common.base.Function<org.thryft.protocol.TProtocol, com.google.common.collect.ImmutableMap<String, String>>() {
                            @Override
                            public com.google.common.collect.ImmutableMap<String, String> apply(org.thryft.protocol.TProtocol iprot) {
                                try {
                                    org.thryft.protocol.TMap mapBegin = iprot.readMapBegin();
                                    java.util.Map<String, String> map = new java.util.HashMap<String, String>();
                                    for (int entryI = 0; entryI < mapBegin.size; entryI++) {
                                        map.put(iprot.readString(), iprot.readString());
                                    }
                                    iprot.readMapEnd();
                                    return com.google.common.collect.ImmutableMap.copyOf(map);
                                } catch (final java.io.IOException e) {
                                    return com.google.common.collect.ImmutableMap.of();
                                }
                            }
                        }).apply(iprot);
                    } else if (ifield.name.equals("set_string_field")) {
                        setStringField = (new com.google.common.base.Function<org.thryft.protocol.TProtocol, com.google.common.collect.ImmutableSet<String>>() {
                            @Override
                            public com.google.common.collect.ImmutableSet<String> apply(final org.thryft.protocol.TProtocol iprot) {
                                try {
                                    final org.thryft.protocol.TSet sequenceBegin = iprot.readSetBegin();
                                    final java.util.Set<String> sequence = new java.util.LinkedHashSet<String>();
                                    for (int elementI = 0; elementI < sequenceBegin.size; elementI++) {
                                        sequence.add(iprot.readString());
                                    }
                                    iprot.readSetEnd();
                                    return com.google.common.collect.ImmutableSet.copyOf(sequence);
                                } catch (final java.io.IOException e) {
                                    return com.google.common.collect.ImmutableSet.of();
                                }
                            }
                        }).apply(iprot);
                    } else if (ifield.name.equals("string_field")) {
                        stringField = iprot.readString();
                    } else if (ifield.name.equals("struct_field")) {
                        structField = new org.thryft.protocol.test.ProtocolTestStruct(iprot);
                    } else if (ifield.name.equals("url_field")) {
                        try {
                            urlField = iprot.readUrl();
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
        this.byteField = byteField;
        this.dateTimeField = dateTimeField;
        this.decimalField = decimalField;
        this.emailAddressField = emailAddressField;
        this.enumField = enumField;
        this.i16Field = i16Field;
        this.i32Field = i32Field;
        this.i64Field = i64Field;
        this.listStringField = listStringField;
        this.mapStringStringField = mapStringStringField;
        this.setStringField = setStringField;
        this.stringField = stringField;
        this.structField = structField;
        this.urlField = urlField;
    }

    public ProtocolTestStruct(final byte[] binaryField, final Boolean boolField, final Byte byteField, final org.joda.time.DateTime dateTimeField, final java.math.BigDecimal decimalField, final org.thryft.native_.EmailAddress emailAddressField, final org.thryft.protocol.test.ProtocolTestEnum enumField, final Short i16Field, final Integer i32Field, final Long i64Field, final com.google.common.collect.ImmutableList<String> listStringField, final com.google.common.collect.ImmutableMap<String, String> mapStringStringField, final com.google.common.collect.ImmutableSet<String> setStringField, final String stringField, final org.thryft.protocol.test.ProtocolTestStruct structField, final org.thryft.native_.Url urlField) {
        this.binaryField = binaryField;
        this.boolField = boolField;
        this.byteField = byteField;
        this.dateTimeField = dateTimeField;
        this.decimalField = decimalField;
        this.emailAddressField = emailAddressField;
        this.enumField = enumField;
        this.i16Field = i16Field;
        this.i32Field = i32Field;
        this.i64Field = i64Field;
        this.listStringField = listStringField;
        this.mapStringStringField = mapStringStringField;
        this.setStringField = setStringField;
        this.stringField = stringField;
        this.structField = structField;
        this.urlField = urlField;
    }

    @Override
    public int compareTo(final ProtocolTestStruct other) {
        throw new UnsupportedOperationException();
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
            ((getBinaryField() == null && other.getBinaryField() == null) ||
            (getBinaryField() != null && other.getBinaryField() != null &&
            getBinaryField().equals(other.getBinaryField()))) &&
            ((isBoolField() == null && other.isBoolField() == null) ||
            (isBoolField() != null && other.isBoolField() != null &&
            isBoolField().equals(other.isBoolField()))) &&
            ((getByteField() == null && other.getByteField() == null) ||
            (getByteField() != null && other.getByteField() != null &&
            getByteField().equals(other.getByteField()))) &&
            ((getDateTimeField() == null && other.getDateTimeField() == null) ||
            (getDateTimeField() != null && other.getDateTimeField() != null &&
            getDateTimeField().equals(other.getDateTimeField()))) &&
            ((getDecimalField() == null && other.getDecimalField() == null) ||
            (getDecimalField() != null && other.getDecimalField() != null &&
            getDecimalField().equals(other.getDecimalField()))) &&
            ((getEmailAddressField() == null && other.getEmailAddressField() == null) ||
            (getEmailAddressField() != null && other.getEmailAddressField() != null &&
            getEmailAddressField().equals(other.getEmailAddressField()))) &&
            ((getEnumField() == null && other.getEnumField() == null) ||
            (getEnumField() != null && other.getEnumField() != null &&
            getEnumField().equals(other.getEnumField()))) &&
            ((getI16Field() == null && other.getI16Field() == null) ||
            (getI16Field() != null && other.getI16Field() != null &&
            getI16Field().equals(other.getI16Field()))) &&
            ((getI32Field() == null && other.getI32Field() == null) ||
            (getI32Field() != null && other.getI32Field() != null &&
            getI32Field().equals(other.getI32Field()))) &&
            ((getI64Field() == null && other.getI64Field() == null) ||
            (getI64Field() != null && other.getI64Field() != null &&
            getI64Field().equals(other.getI64Field()))) &&
            ((getListStringField() == null && other.getListStringField() == null) ||
            (getListStringField() != null && other.getListStringField() != null &&
            getListStringField().equals(other.getListStringField()))) &&
            ((getMapStringStringField() == null && other.getMapStringStringField() == null) ||
            (getMapStringStringField() != null && other.getMapStringStringField() != null &&
            getMapStringStringField().equals(other.getMapStringStringField()))) &&
            ((getSetStringField() == null && other.getSetStringField() == null) ||
            (getSetStringField() != null && other.getSetStringField() != null &&
            getSetStringField().equals(other.getSetStringField()))) &&
            ((getStringField() == null && other.getStringField() == null) ||
            (getStringField() != null && other.getStringField() != null &&
            getStringField().equals(other.getStringField()))) &&
            ((getStructField() == null && other.getStructField() == null) ||
            (getStructField() != null && other.getStructField() != null &&
            getStructField().equals(other.getStructField()))) &&
            ((getUrlField() == null && other.getUrlField() == null) ||
            (getUrlField() != null && other.getUrlField() != null &&
            getUrlField().equals(other.getUrlField())));
    }

    public Object get(final String fieldName) {
        if (fieldName.equals("binary_field")) {
            return getBinaryField();
        } else if (fieldName.equals("bool_field")) {
            return isBoolField();
        } else if (fieldName.equals("byte_field")) {
            return getByteField();
        } else if (fieldName.equals("date_time_field")) {
            return getDateTimeField();
        } else if (fieldName.equals("decimal_field")) {
            return getDecimalField();
        } else if (fieldName.equals("email_address_field")) {
            return getEmailAddressField();
        } else if (fieldName.equals("enum_field")) {
            return getEnumField();
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
        } else if (fieldName.equals("set_string_field")) {
            return getSetStringField();
        } else if (fieldName.equals("string_field")) {
            return getStringField();
        } else if (fieldName.equals("struct_field")) {
            return getStructField();
        } else if (fieldName.equals("url_field")) {
            return getUrlField();
        }
        return null;
    }

    public final byte[] getBinaryField() {
        return binaryField;
    }

    public final Byte getByteField() {
        return byteField;
    }

    public final org.joda.time.DateTime getDateTimeField() {
        return dateTimeField;
    }

    public final java.math.BigDecimal getDecimalField() {
        return decimalField;
    }

    public final org.thryft.native_.EmailAddress getEmailAddressField() {
        return emailAddressField;
    }

    public final org.thryft.protocol.test.ProtocolTestEnum getEnumField() {
        return enumField;
    }

    public final Short getI16Field() {
        return i16Field;
    }

    public final Integer getI32Field() {
        return i32Field;
    }

    public final Long getI64Field() {
        return i64Field;
    }

    public final com.google.common.collect.ImmutableList<String> getListStringField() {
        return listStringField;
    }

    public final com.google.common.collect.ImmutableMap<String, String> getMapStringStringField() {
        return mapStringStringField;
    }

    public final com.google.common.collect.ImmutableSet<String> getSetStringField() {
        return setStringField;
    }

    public final String getStringField() {
        return stringField;
    }

    public final org.thryft.protocol.test.ProtocolTestStruct getStructField() {
        return structField;
    }

    public final org.thryft.native_.Url getUrlField() {
        return urlField;
    }

    @Override
    public int hashCode() {
        int hashCode = 17;
        if (getBinaryField() != null) {
            hashCode = 31 * hashCode + java.util.Arrays.hashCode(getBinaryField());
        }
        if (isBoolField() != null) {
            hashCode = 31 * hashCode + (isBoolField() ? 1 : 0);
        }
        if (getByteField() != null) {
            hashCode = 31 * hashCode + ((byte)getByteField());
        }
        if (getDateTimeField() != null) {
            hashCode = 31 * hashCode + getDateTimeField().hashCode();
        }
        if (getDecimalField() != null) {
            hashCode = 31 * hashCode + getDecimalField().hashCode();
        }
        if (getEmailAddressField() != null) {
            hashCode = 31 * hashCode + getEmailAddressField().hashCode();
        }
        if (getEnumField() != null) {
            hashCode = 31 * hashCode + getEnumField().ordinal();
        }
        if (getI16Field() != null) {
            hashCode = 31 * hashCode + ((int)getI16Field());
        }
        if (getI32Field() != null) {
            hashCode = 31 * hashCode + ((int)getI32Field());
        }
        if (getI64Field() != null) {
            hashCode = 31 * hashCode + ((int)(getI64Field() ^ (getI64Field() >>> 32)));
        }
        if (getListStringField() != null) {
            hashCode = 31 * hashCode + getListStringField().hashCode();
        }
        if (getMapStringStringField() != null) {
            hashCode = 31 * hashCode + getMapStringStringField().hashCode();
        }
        if (getSetStringField() != null) {
            hashCode = 31 * hashCode + getSetStringField().hashCode();
        }
        if (getStringField() != null) {
            hashCode = 31 * hashCode + getStringField().hashCode();
        }
        if (getStructField() != null) {
            hashCode = 31 * hashCode + getStructField().hashCode();
        }
        if (getUrlField() != null) {
            hashCode = 31 * hashCode + getUrlField().hashCode();
        }
        return hashCode;
    }

    public final Boolean isBoolField() {
        return boolField;
    }

    @Override
    public String toString() {
        final com.google.common.base.Objects.ToStringHelper helper = com.google.common.base.Objects.toStringHelper(this);
        if (getBinaryField() != null) {
            helper.add("binary_field", getBinaryField());
        }
        if (isBoolField() != null) {
            helper.add("bool_field", isBoolField());
        }
        if (getByteField() != null) {
            helper.add("byte_field", getByteField());
        }
        if (getDateTimeField() != null) {
            helper.add("date_time_field", getDateTimeField());
        }
        if (getDecimalField() != null) {
            helper.add("decimal_field", getDecimalField());
        }
        if (getEmailAddressField() != null) {
            helper.add("email_address_field", getEmailAddressField());
        }
        if (getEnumField() != null) {
            helper.add("enum_field", getEnumField());
        }
        if (getI16Field() != null) {
            helper.add("i16_field", getI16Field());
        }
        if (getI32Field() != null) {
            helper.add("i32_field", getI32Field());
        }
        if (getI64Field() != null) {
            helper.add("i64_field", getI64Field());
        }
        if (getListStringField() != null) {
            helper.add("list_string_field", getListStringField());
        }
        if (getMapStringStringField() != null) {
            helper.add("map_string_string_field", getMapStringStringField());
        }
        if (getSetStringField() != null) {
            helper.add("set_string_field", getSetStringField());
        }
        if (getStringField() != null) {
            helper.add("string_field", getStringField());
        }
        if (getStructField() != null) {
            helper.add("struct_field", getStructField());
        }
        if (getUrlField() != null) {
            helper.add("url_field", getUrlField());
        }
        return helper.toString();
    }

    @Override
    public void write(final org.thryft.protocol.TProtocol oprot) throws java.io.IOException {
        write(oprot, org.thryft.protocol.TType.STRUCT);
    }

    public void write(final org.thryft.protocol.TProtocol oprot, final byte writeAsTType) throws java.io.IOException {
        switch (writeAsTType) {
            case org.thryft.protocol.TType.VOID:
            case org.thryft.protocol.TType.LIST:
                oprot.writeListBegin(new org.thryft.protocol.TList(org.thryft.protocol.TType.VOID, 16));

                if (getBinaryField() != null) {
                    oprot.writeBinary(getBinaryField());
                } else {
                    ((org.thryft.protocol.TProtocol)oprot).writeNull();
                }

                if (isBoolField() != null) {
                    oprot.writeBool(isBoolField());
                } else {
                    ((org.thryft.protocol.TProtocol)oprot).writeNull();
                }

                if (getByteField() != null) {
                    oprot.writeByte(getByteField());
                } else {
                    ((org.thryft.protocol.TProtocol)oprot).writeNull();
                }

                if (getDateTimeField() != null) {
                    oprot.writeDateTime(getDateTimeField());
                } else {
                    ((org.thryft.protocol.TProtocol)oprot).writeNull();
                }

                if (getDecimalField() != null) {
                    oprot.writeDecimal(getDecimalField());
                } else {
                    ((org.thryft.protocol.TProtocol)oprot).writeNull();
                }

                if (getEmailAddressField() != null) {
                    oprot.writeEmailAddress(getEmailAddressField());
                } else {
                    ((org.thryft.protocol.TProtocol)oprot).writeNull();
                }

                if (getEnumField() != null) {
                    oprot.writeEnum(getEnumField());
                } else {
                    ((org.thryft.protocol.TProtocol)oprot).writeNull();
                }

                if (getI16Field() != null) {
                    oprot.writeI16(getI16Field());
                } else {
                    ((org.thryft.protocol.TProtocol)oprot).writeNull();
                }

                if (getI32Field() != null) {
                    oprot.writeI32(getI32Field());
                } else {
                    ((org.thryft.protocol.TProtocol)oprot).writeNull();
                }

                if (getI64Field() != null) {
                    oprot.writeI64(getI64Field());
                } else {
                    ((org.thryft.protocol.TProtocol)oprot).writeNull();
                }

                if (getListStringField() != null) {
                    oprot.writeListBegin(new org.thryft.protocol.TList(org.thryft.protocol.TType.STRING, getListStringField().size()));
                    for (final String _iter0 : getListStringField()) {
                        oprot.writeString(_iter0);
                    }
                    oprot.writeListEnd();
                } else {
                    ((org.thryft.protocol.TProtocol)oprot).writeNull();
                }

                if (getMapStringStringField() != null) {
                    oprot.writeMapBegin(new org.thryft.protocol.TMap(org.thryft.protocol.TType.STRING, org.thryft.protocol.TType.STRING, getMapStringStringField().size()));
                    for (com.google.common.collect.ImmutableMap.Entry<String, String> _iter0 : getMapStringStringField().entrySet()) {
                        oprot.writeString(_iter0.getKey());
                        oprot.writeString(_iter0.getValue());
                    }
                    oprot.writeMapEnd();
                } else {
                    ((org.thryft.protocol.TProtocol)oprot).writeNull();
                }

                if (getSetStringField() != null) {
                    oprot.writeSetBegin(new org.thryft.protocol.TSet(org.thryft.protocol.TType.STRING, getSetStringField().size()));
                    for (final String _iter0 : getSetStringField()) {
                        oprot.writeString(_iter0);
                    }
                    oprot.writeSetEnd();
                } else {
                    ((org.thryft.protocol.TProtocol)oprot).writeNull();
                }

                if (getStringField() != null) {
                    oprot.writeString(getStringField());
                } else {
                    ((org.thryft.protocol.TProtocol)oprot).writeNull();
                }

                if (getStructField() != null) {
                    getStructField().write(oprot);
                } else {
                    ((org.thryft.protocol.TProtocol)oprot).writeNull();
                }

                if (getUrlField() != null) {
                    oprot.writeUrl(getUrlField());
                } else {
                    ((org.thryft.protocol.TProtocol)oprot).writeNull();
                }

                oprot.writeListEnd();
                break;

            case org.thryft.protocol.TType.STRUCT:
            default:
                oprot.writeStructBegin(new org.thryft.protocol.TStruct("ProtocolTestStruct"));

                if (getBinaryField() != null) {
                    oprot.writeFieldBegin(new org.thryft.protocol.TField("binary_field", org.thryft.protocol.TType.STRING, (short)-1));
                    oprot.writeBinary(getBinaryField());
                    oprot.writeFieldEnd();
                }

                if (isBoolField() != null) {
                    oprot.writeFieldBegin(new org.thryft.protocol.TField("bool_field", org.thryft.protocol.TType.BOOL, (short)-1));
                    oprot.writeBool(isBoolField());
                    oprot.writeFieldEnd();
                }

                if (getByteField() != null) {
                    oprot.writeFieldBegin(new org.thryft.protocol.TField("byte_field", org.thryft.protocol.TType.BYTE, (short)-1));
                    oprot.writeByte(getByteField());
                    oprot.writeFieldEnd();
                }

                if (getDateTimeField() != null) {
                    oprot.writeFieldBegin(new org.thryft.protocol.TField("date_time_field", org.thryft.protocol.TType.STRUCT, (short)-1));
                    oprot.writeDateTime(getDateTimeField());
                    oprot.writeFieldEnd();
                }

                if (getDecimalField() != null) {
                    oprot.writeFieldBegin(new org.thryft.protocol.TField("decimal_field", org.thryft.protocol.TType.STRUCT, (short)-1));
                    oprot.writeDecimal(getDecimalField());
                    oprot.writeFieldEnd();
                }

                if (getEmailAddressField() != null) {
                    oprot.writeFieldBegin(new org.thryft.protocol.TField("email_address_field", org.thryft.protocol.TType.STRUCT, (short)-1));
                    oprot.writeEmailAddress(getEmailAddressField());
                    oprot.writeFieldEnd();
                }

                if (getEnumField() != null) {
                    oprot.writeFieldBegin(new org.thryft.protocol.TField("enum_field", org.thryft.protocol.TType.STRING, (short)-1));
                    oprot.writeEnum(getEnumField());
                    oprot.writeFieldEnd();
                }

                if (getI16Field() != null) {
                    oprot.writeFieldBegin(new org.thryft.protocol.TField("i16_field", org.thryft.protocol.TType.I16, (short)-1));
                    oprot.writeI16(getI16Field());
                    oprot.writeFieldEnd();
                }

                if (getI32Field() != null) {
                    oprot.writeFieldBegin(new org.thryft.protocol.TField("i32_field", org.thryft.protocol.TType.I32, (short)-1));
                    oprot.writeI32(getI32Field());
                    oprot.writeFieldEnd();
                }

                if (getI64Field() != null) {
                    oprot.writeFieldBegin(new org.thryft.protocol.TField("i64_field", org.thryft.protocol.TType.I64, (short)-1));
                    oprot.writeI64(getI64Field());
                    oprot.writeFieldEnd();
                }

                if (getListStringField() != null) {
                    oprot.writeFieldBegin(new org.thryft.protocol.TField("list_string_field", org.thryft.protocol.TType.LIST, (short)-1));
                    oprot.writeListBegin(new org.thryft.protocol.TList(org.thryft.protocol.TType.STRING, getListStringField().size()));
                    for (final String _iter0 : getListStringField()) {
                        oprot.writeString(_iter0);
                    }
                    oprot.writeListEnd();
                    oprot.writeFieldEnd();
                }

                if (getMapStringStringField() != null) {
                    oprot.writeFieldBegin(new org.thryft.protocol.TField("map_string_string_field", org.thryft.protocol.TType.MAP, (short)-1));
                    oprot.writeMapBegin(new org.thryft.protocol.TMap(org.thryft.protocol.TType.STRING, org.thryft.protocol.TType.STRING, getMapStringStringField().size()));
                    for (com.google.common.collect.ImmutableMap.Entry<String, String> _iter0 : getMapStringStringField().entrySet()) {
                        oprot.writeString(_iter0.getKey());
                        oprot.writeString(_iter0.getValue());
                    }
                    oprot.writeMapEnd();
                    oprot.writeFieldEnd();
                }

                if (getSetStringField() != null) {
                    oprot.writeFieldBegin(new org.thryft.protocol.TField("set_string_field", org.thryft.protocol.TType.SET, (short)-1));
                    oprot.writeSetBegin(new org.thryft.protocol.TSet(org.thryft.protocol.TType.STRING, getSetStringField().size()));
                    for (final String _iter0 : getSetStringField()) {
                        oprot.writeString(_iter0);
                    }
                    oprot.writeSetEnd();
                    oprot.writeFieldEnd();
                }

                if (getStringField() != null) {
                    oprot.writeFieldBegin(new org.thryft.protocol.TField("string_field", org.thryft.protocol.TType.STRING, (short)-1));
                    oprot.writeString(getStringField());
                    oprot.writeFieldEnd();
                }

                if (getStructField() != null) {
                    oprot.writeFieldBegin(new org.thryft.protocol.TField("struct_field", org.thryft.protocol.TType.STRUCT, (short)-1));
                    getStructField().write(oprot);
                    oprot.writeFieldEnd();
                }

                if (getUrlField() != null) {
                    oprot.writeFieldBegin(new org.thryft.protocol.TField("url_field", org.thryft.protocol.TType.STRUCT, (short)-1));
                    oprot.writeUrl(getUrlField());
                    oprot.writeFieldEnd();
                }

                oprot.writeFieldStop();

                oprot.writeStructEnd();
                break;
        }
    }

    private final byte[] binaryField;

    private final Boolean boolField;

    private final Byte byteField;

    private final org.joda.time.DateTime dateTimeField;

    private final java.math.BigDecimal decimalField;

    private final org.thryft.native_.EmailAddress emailAddressField;

    private final org.thryft.protocol.test.ProtocolTestEnum enumField;

    private final Short i16Field;

    private final Integer i32Field;

    private final Long i64Field;

    private final com.google.common.collect.ImmutableList<String> listStringField;

    private final com.google.common.collect.ImmutableMap<String, String> mapStringStringField;

    private final com.google.common.collect.ImmutableSet<String> setStringField;

    private final String stringField;

    private final org.thryft.protocol.test.ProtocolTestStruct structField;

    private final org.thryft.native_.Url urlField;
}