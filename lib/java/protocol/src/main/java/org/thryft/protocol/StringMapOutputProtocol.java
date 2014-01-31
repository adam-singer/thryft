/*******************************************************************************
 * Copyright (c) 2013, Minor Gordon
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in
 *       the documentation and/or other materials provided with the
 *       distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND
 * CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES,
 * INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL  DAMAGES (INCLUDING,
 * BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY
 * OF SUCH DAMAGE.
 ******************************************************************************/

package org.thryft.protocol;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;
import static org.thryft.Preconditions.checkNotEmpty;

import java.io.IOException;
import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

public class StringMapOutputProtocol extends StackedOutputProtocol {
    protected abstract class AbstractOutputProtocol extends
            org.thryft.protocol.AbstractOutputProtocol {
        protected AbstractOutputProtocol(final String myKey) {
            this.myKey = myKey;
        }

        @Override
        public final void writeBool(final boolean b) throws IOException {
            writeString(Boolean.toString(b));
        }

        @Override
        public final void writeByte(final byte b) throws IOException {
            writeString(Byte.toString(b));
        }

        @Override
        public final void writeDouble(final double dub) throws IOException {
            writeString(Double.toString(dub));
        }

        @Override
        public final void writeI16(final short i16) throws IOException {
            writeString(Short.toString(i16));
        }

        @Override
        public final void writeI32(final int i32) throws IOException {
            writeString(Integer.toString(i32));
        }

        @Override
        public final void writeI64(final long i64) throws IOException {
            writeString(Long.toString(i64));
        }

        @Override
        public void writeListEnd() throws IOException {
        }

        @Override
        public void writeMapEnd() throws IOException {
        }

        @Override
        public void writeStructEnd() throws IOException {
        }

        protected void _writeListBegin(final String childKey)
                throws IOException {
            output.put(__joinKeys(myKey, childKey), "");
            _getProtocolStack().push(
                    new ListOutputProtocol(__joinKeys(myKey, childKey)));
        }

        protected void _writeMapBegin(final String childKey) throws IOException {
            output.put(__joinKeys(myKey, childKey), "");
            _getProtocolStack().push(
                    new MapOutputProtocol(__joinKeys(myKey, childKey)));
        }

        protected void _writeString(final String childKey, final String value) {
            checkNotNull(childKey);
            checkNotNull(value);
            output.put(__joinKeys(myKey, childKey), value);
        }

        protected void _writeStructBegin(final String childKey)
                throws IOException {
            output.put(__joinKeys(myKey, childKey), "");
            _getProtocolStack().push(
                    new StructOutputProtocol(__joinKeys(myKey, childKey)));
        }

        private final String myKey;
    }

    private final class ListOutputProtocol extends AbstractOutputProtocol {
        public ListOutputProtocol(final String myKey) {
            super(myKey);
        }

        @Override
        public void writeListBegin(final ListBegin list) throws IOException {
            _writeListBegin(Integer.toString(nextChildKey++));
        }

        @Override
        public void writeMapBegin(final MapBegin map) throws IOException {
            _writeMapBegin(Integer.toString(nextChildKey++));
        }

        @Override
        public void writeString(final String value) throws IOException {
            _writeString(Integer.toString(nextChildKey++), value);
        }

        @Override
        public void writeStructBegin(final StructBegin struct)
                throws IOException {
            _writeStructBegin(Integer.toString(nextChildKey++));
        }

        private int nextChildKey;
    }

    private final class MapOutputProtocol extends AbstractOutputProtocol {
        public MapOutputProtocol(final String myKey) {
            super(myKey);
        }

        @Override
        public void writeListBegin(final ListBegin list) throws IOException {
            checkState(nextChildKey != null);
            _writeListBegin(nextChildKey);
        }

        @Override
        public void writeMapBegin(final MapBegin map) throws IOException {
            checkState(nextChildKey != null);
            _writeMapBegin(nextChildKey);
        }

        @Override
        public void writeString(final String value) throws IOException {
            if (nextChildKey == null) {
                nextChildKey = value;
            } else {
                _writeString(nextChildKey, value);
                nextChildKey = null;
            }
        }

        @Override
        public void writeStructBegin(final StructBegin struct)
                throws IOException {
            checkState(nextChildKey != null);
            _writeStructBegin(nextChildKey);
        }

        private String nextChildKey = null;
    }

    private final class RootOutputProtocol extends AbstractOutputProtocol {
        public RootOutputProtocol() {
            super("");
        }

        @Override
        public void writeListBegin(final ListBegin list) throws IOException {
            _getProtocolStack().push(new ListOutputProtocol(""));
        }

        @Override
        public void writeMapBegin(final MapBegin map) throws IOException {
            _getProtocolStack().push(new MapOutputProtocol(""));
        }

        @Override
        public void writeString(final String value) throws IOException {
            throw new IllegalStateException();
        }

        @Override
        public void writeStructBegin(final StructBegin struct)
                throws IOException {
            _getProtocolStack().push(new StructOutputProtocol(""));
        }
    }

    private final class StructOutputProtocol extends AbstractOutputProtocol {
        public StructOutputProtocol(final String myKey) {
            super(myKey);
        }

        @Override
        public void writeFieldBegin(final FieldBegin field) throws IOException {
            nextChildKey = field.name;
        }

        @Override
        public void writeFieldEnd() throws IOException {
        }

        @Override
        public void writeFieldStop() throws IOException {
        }

        @Override
        public void writeListBegin(final ListBegin list) throws IOException {
            checkState(nextChildKey != null);
            _writeListBegin(nextChildKey);
        }

        @Override
        public void writeMapBegin(final MapBegin map) throws IOException {
            checkState(nextChildKey != null);
            _writeMapBegin(nextChildKey);
        }

        @Override
        public void writeString(final String value) throws IOException {
            checkState(nextChildKey != null);
            _writeString(nextChildKey, value);
        }

        @Override
        public void writeStructBegin(final StructBegin struct)
                throws IOException {
            checkState(nextChildKey != null);
            _writeStructBegin(nextChildKey);
        }

        private String nextChildKey = null;
    }

    private final static String __joinKeys(final String parentKey,
            final String childKey) {
        checkNotEmpty(childKey);
        if (parentKey.isEmpty()) {
            return childKey;
        } else {
            return parentKey + "." + childKey;
        }
    }

    public StringMapOutputProtocol() {
        _getProtocolStack().push(new RootOutputProtocol());
    }

    public final ImmutableMap<String, String> toStringMap() {
        return ImmutableMap.copyOf(output);
    }

    private final Map<String, String> output = Maps.newHashMap();
}
