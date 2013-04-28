if (typeof thryft_test === "undefined") {
    thryft_test = new Object();
}
if (typeof thryft_test.protocol === "undefined") {
    thryft_test.protocol = new Object();
}
if (typeof thryft_test.protocol.test === "undefined") {
    thryft_test.protocol.test = new Object();
}

thryft_test.protocol.test.ProtocolTestStruct = Backbone.Model.extend(
    {
        /** @type string */
        binaryField:undefined,
        /** @type boolean */
        boolField:undefined,
        /** @type number */
        byteField:undefined,
        /** @type Date */
        dateTimeField:undefined,
        /** @type string */
        decimalField:undefined,
        /** @type string */
        emailAddressField:undefined,
        /** @type thryft_test.protocol.test.ProtocolTestEnum */
        enumField:undefined,
        /** @type number */
        i16Field:undefined,
        /** @type number */
        i32Field:undefined,
        /** @type number */
        i64Field:undefined,
        /** @type Array.<string> */
        listStringField:undefined,
        /** @type Object.<string, string> */
        mapStringStringField:undefined,
        /** @type Array.<string> */
        setStringField:undefined,
        /** @type string */
        stringField:undefined,
        /** @type thryft_test.protocol.test.ProtocolTestStruct */
        structField:undefined,
        /** @type string */
        urlField:undefined,

        schema: {
            "byteField": {
                "type": "Number"
            },
            "i16Field": {
                "type": "Number"
            },
            "binaryField": {
                "type": "Text"
            },
            "mapStringStringField": {
                "type": "Object",
                "subSchema": {
                    "type": "Text"
                }
            },
            "stringField": {
                "type": "Text"
            },
            "emailAddressField": {
                "type": "Text",
                "validators": [
                    "email"
                ]
            },
            "boolField": {
                "type": "Checkboxes",
                "options": [
                    ""
                ]
            },
            "dateTimeField": {
                "type": "DateTime"
            },
            "urlField": {
                "type": "Text",
                "validators": [
                    "url"
                ]
            },
            "i32Field": {
                "type": "Number"
            },
            "i64Field": {
                "type": "Number"
            },
            "setStringField": {
                "type": "List",
                "itemType": "Text"
            },
            "enumField": {
                "type": "Select",
                "options": [
                    "ENUMERATOR1",
                    "ENUMERATOR2"
                ]
            },
            "structField": {
                "model": thryft_test.protocol.test.ProtocolTestStruct,
                "type": "NestedModel"
            },
            "listStringField": {
                "type": "List",
                "itemType": "Text"
            },
            "decimalField": {
                "type": "Number"
            }
        },

        validation: {
            binaryField: {
                "fn": function(value, attr, computedState) {
                    if (typeof value !== "string") {
                        return "expected thryft_test.protocol.test.ProtocolTestStruct.binaryField to be a string";
                    }
                },
                "required": false
            },

            boolField: {
                "fn": function(value, attr, computedState) {
                    if (typeof value !== "boolean") {
                        return "expected thryft_test.protocol.test.ProtocolTestStruct.boolField to be a boolean";
                    }
                },
                "required": false
            },

            byteField: {
                "fn": function(value, attr, computedState) {
                    if (typeof value !== "number") {
                        return "expected thryft_test.protocol.test.ProtocolTestStruct.byteField to be a number";
                    }
                },
                "required": false
            },

            dateTimeField: {
                "fn": function(value, attr, computedState) {
                    if (!(value instanceof Date)) {
                        return "expected thryft_test.protocol.test.ProtocolTestStruct.dateTimeField to be a Date";
                    }
                },
                "required": false
            },

            decimalField: {
                "fn": function(value, attr, computedState) {
                    if (typeof value !== "string") {
                        return "expected thryft_test.protocol.test.ProtocolTestStruct.decimalField to be a string";
                    }
                },
                "pattern": "number", "required": false
            },

            emailAddressField: {
                "fn": function(value, attr, computedState) {
                    if (typeof value !== "string") {
                        return "expected thryft_test.protocol.test.ProtocolTestStruct.emailAddressField to be a string";
                    }
                },
                "pattern": "email", "required": false
            },

            enumField: {
                "fn": function(value, attr, computedState) {
                    if (typeof value !== "number") {
                        return "expected thryft_test.protocol.test.ProtocolTestStruct.enumField to be a number";
                    }
                    if (value !== 1 && value !== 2) {
                        return "thryft_test.protocol.test.ProtocolTestStruct.enumField is not a valid enumerator of thryft_test.protocol.test.ProtocolTestEnum";
                    }
                },
                "required": false
            },

            i16Field: {
                "fn": function(value, attr, computedState) {
                    if (typeof value !== "number") {
                        return "expected thryft_test.protocol.test.ProtocolTestStruct.i16Field to be a number";
                    }
                },
                "required": false
            },

            i32Field: {
                "fn": function(value, attr, computedState) {
                    if (typeof value !== "number") {
                        return "expected thryft_test.protocol.test.ProtocolTestStruct.i32Field to be a number";
                    }
                },
                "required": false
            },

            i64Field: {
                "fn": function(value, attr, computedState) {
                    if (typeof value !== "number") {
                        return "expected thryft_test.protocol.test.ProtocolTestStruct.i64Field to be a number";
                    }
                },
                "required": false
            },

            listStringField: {
                "fn": function(value, attr, computedState) {
                    if (!Array.isArray(value)) {
                        return "expected thryft_test.protocol.test.ProtocolTestStruct.listStringField to be an Array";
                    }
                    for (var __i0 = 0; __i0 < value.length; __i0++) {
                        if (typeof value[__i0] !== "string") {
                            return "expected thryft_test.protocol.test.ProtocolTestStruct.listStringField[i] to be a string";
                        }
                    }
                },
                "required": false
            },

            mapStringStringField: {
                "fn": function(value, attr, computedState) {
                    if (typeof value !== "object") {
                        return "expected thryft_test.protocol.test.ProtocolTestStruct.mapStringStringField to be an object";
                    }
                    for (var __key0 in value) {
                        var __value0 = value[__key0];
                        if (typeof __key0 !== "string") {
                            return "expected thryft_test.protocol.test.ProtocolTestStruct.mapStringStringField key to be a string";
                        }
                        if (typeof __value0 !== "string") {
                            return "expected thryft_test.protocol.test.ProtocolTestStruct.mapStringStringField value to be a string";
                        }
                    }
                },
                "required": false
            },

            setStringField: {
                "fn": function(value, attr, computedState) {
                    if (!Array.isArray(value)) {
                        return "expected thryft_test.protocol.test.ProtocolTestStruct.setStringField to be an Array";
                    }
                    for (var __i0 = 0; __i0 < value.length; __i0++) {
                        if (typeof value[__i0] !== "string") {
                            return "expected thryft_test.protocol.test.ProtocolTestStruct.setStringField[i] to be a string";
                        }
                    }
                },
                "required": false
            },

            stringField: {
                "fn": function(value, attr, computedState) {
                    if (typeof value !== "string") {
                        return "expected thryft_test.protocol.test.ProtocolTestStruct.stringField to be a string";
                    }
                },
                "required": false
            },

            structField: {
                "fn": function(value, attr, computedState) {
                    if (!(value instanceof thryft_test.protocol.test.ProtocolTestStruct)) {
                        return "expected thryft_test.protocol.test.ProtocolTestStruct.structField to be a thryft_test.protocol.test.ProtocolTestStruct";
                    }
                    if (!value.isValid(true)) {
                        return value.validationError;
                    }
                },
                "required": false
            },

            urlField: {
                "fn": function(value, attr, computedState) {
                    if (typeof value !== "string") {
                        return "expected thryft_test.protocol.test.ProtocolTestStruct.urlField to be a string";
                    }
                },
                "pattern": "url", "required": false
            }
        },

        write: function(oprot) {
            oprot.writeStructBegin("ProtocolTestStruct");
            if (this.has("binaryField")) {
                oprot.writeFieldBegin("binary_field");
                oprot.writeBinary(this.get("binaryField"));
                oprot.writeFieldEnd();
            }
            if (this.has("boolField")) {
                oprot.writeFieldBegin("bool_field");
                oprot.writeBool(this.get("boolField"));
                oprot.writeFieldEnd();
            }
            if (this.has("byteField")) {
                oprot.writeFieldBegin("byte_field");
                oprot.writeByte(this.get("byteField"));
                oprot.writeFieldEnd();
            }
            if (this.has("dateTimeField")) {
                oprot.writeFieldBegin("date_time_field");
                oprot.writeDateTime(this.get("dateTimeField"));
                oprot.writeFieldEnd();
            }
            if (this.has("decimalField")) {
                oprot.writeFieldBegin("decimal_field");
                oprot.writeDecimal(this.get("decimalField"));
                oprot.writeFieldEnd();
            }
            if (this.has("emailAddressField")) {
                oprot.writeFieldBegin("email_address_field");
                oprot.writeEmailAddress(this.get("emailAddressField"));
                oprot.writeFieldEnd();
            }
            if (this.has("enumField")) {
                oprot.writeFieldBegin("enum_field");
                oprot.writeString(function(enumerator_value) { for (var enumerator_name in thryft_test.protocol.test.ProtocolTestEnum) { if (thryft_test.protocol.test.ProtocolTestEnum[enumerator_name] == enumerator_value) { return enumerator_name; } } }(this.get("enumField")));
                oprot.writeFieldEnd();
            }
            if (this.has("i16Field")) {
                oprot.writeFieldBegin("i16_field");
                oprot.writeI16(this.get("i16Field"));
                oprot.writeFieldEnd();
            }
            if (this.has("i32Field")) {
                oprot.writeFieldBegin("i32_field");
                oprot.writeI32(this.get("i32Field"));
                oprot.writeFieldEnd();
            }
            if (this.has("i64Field")) {
                oprot.writeFieldBegin("i64_field");
                oprot.writeI64(this.get("i64Field"));
                oprot.writeFieldEnd();
            }
            if (this.has("listStringField")) {
                oprot.writeFieldBegin("list_string_field");
                var __sequence0 = this.get("listStringField");
                oprot.writeListBegin(11, __sequence0.length);
                for (var __i0 = 0; __i0 < __sequence0.length; __i0++) {
                    oprot.writeString(__sequence0[__i0]);
                }
                oprot.writeListEnd();
                oprot.writeFieldEnd();
            }
            if (this.has("mapStringStringField")) {
                oprot.writeFieldBegin("map_string_string_field");
                var __map0 = this.get("mapStringStringField");
                var __mapSize0 = 0;
                for (var __key0 in __map0) {
                    __mapSize0++;
                }
                oprot.writeMapBegin(11, 11, __mapSize0);
                for (var __key0 in __map0) {
                    oprot.writeString(__key0);
                    oprot.writeString(__map0[__key0]);
                }
                oprot.writeMapEnd();
                oprot.writeFieldEnd();
            }
            if (this.has("setStringField")) {
                oprot.writeFieldBegin("set_string_field");
                var __sequence0 = this.get("setStringField");
                oprot.writeSetBegin(11, __sequence0.length);
                for (var __i0 = 0; __i0 < __sequence0.length; __i0++) {
                    oprot.writeString(__sequence0[__i0]);
                }
                oprot.writeSetEnd();
                oprot.writeFieldEnd();
            }
            if (this.has("stringField")) {
                oprot.writeFieldBegin("string_field");
                oprot.writeString(this.get("stringField"));
                oprot.writeFieldEnd();
            }
            if (this.has("structField")) {
                oprot.writeFieldBegin("struct_field");
                this.get("structField").write(oprot);
                oprot.writeFieldEnd();
            }
            if (this.has("urlField")) {
                oprot.writeFieldBegin("url_field");
                oprot.writeUrl(this.get("urlField"));
                oprot.writeFieldEnd();
            }
            oprot.writeStructEnd();
            return oprot;
        }
    },
    {
        read: function(iprot) {
            var fields = {};
            iprot.readStructBegin();
            while (true) {
                var field = iprot.readFieldBegin();
                if (field.fname.length == 0) {
                    break;
                } else         if (field.fname == "binary_field") {
                    fields["binaryField"] = iprot.readBinary();
                } else if (field.fname == "bool_field") {
                    fields["boolField"] = iprot.readBool();
                } else if (field.fname == "byte_field") {
                    fields["byteField"] = iprot.readByte();
                } else if (field.fname == "date_time_field") {
                    fields["dateTimeField"] = iprot.readDateTime();
                } else if (field.fname == "decimal_field") {
                    fields["decimalField"] = iprot.readDecimal();
                } else if (field.fname == "email_address_field") {
                    fields["emailAddressField"] = iprot.readEmailAddress();
                } else if (field.fname == "enum_field") {
                    fields["enumField"] = thryft_test.protocol.test.ProtocolTestEnum[iprot.readString()];
                } else if (field.fname == "i16_field") {
                    fields["i16Field"] = iprot.readI16();
                } else if (field.fname == "i32_field") {
                    fields["i32Field"] = iprot.readI32();
                } else if (field.fname == "i64_field") {
                    fields["i64Field"] = iprot.readI64();
                } else if (field.fname == "list_string_field") {
                    fields["listStringField"] = function(iprot) { var sequenceBegin = iprot.readListBegin(); var sequence = new Array(); for (var i = 0; i < sequenceBegin.size; i++) { sequence.push(iprot.readString()); } iprot.readListEnd(); return sequence; }(iprot);
                } else if (field.fname == "map_string_string_field") {
                    fields["mapStringStringField"] = function(iprot) { var map = {}; var mapBegin = iprot.readMapBegin(); for (var i = 0; i < mapBegin.size; i++) { var key = iprot.readString(); var value = iprot.readString(); map[key] = value; } iprot.readMapEnd(); return map; }(iprot);
                } else if (field.fname == "set_string_field") {
                    fields["setStringField"] = function(iprot) { var sequenceBegin = iprot.readSetBegin(); var sequence = new Array(); for (var i = 0; i < sequenceBegin.size; i++) { sequence.push(iprot.readString()); } iprot.readSetEnd(); return sequence; }(iprot);
                } else if (field.fname == "string_field") {
                    fields["stringField"] = iprot.readString();
                } else if (field.fname == "struct_field") {
                    fields["structField"] = thryft_test.protocol.test.ProtocolTestStruct.read(iprot);
                } else if (field.fname == "url_field") {
                    fields["urlField"] = iprot.readUrl();
                }
                iprot.readFieldEnd();
            }
            iprot.readStructEnd();
            return new thryft_test.protocol.test.ProtocolTestStruct(fields);
        }
    }
);