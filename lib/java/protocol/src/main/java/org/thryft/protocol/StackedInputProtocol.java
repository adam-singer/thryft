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

import java.io.IOException;
import java.util.Stack;

public class StackedInputProtocol extends AbstractInputProtocol {
    @Override
    public byte[] readBinary() throws IOException {
        return protocolStack.peek().readBinary();
    }

    @Override
    public boolean readBool() throws IOException {
        return protocolStack.peek().readBool();
    }

    @Override
    public byte readByte() throws IOException {
        return protocolStack.peek().readByte();
    }

    @Override
    public org.joda.time.DateTime readDate() throws IOException {
        return protocolStack.peek().readDate();
    }

    @Override
    public org.joda.time.DateTime readDateTime() throws IOException {
        return protocolStack.peek().readDateTime();
    }

    @Override
    public java.math.BigDecimal readDecimal() throws IOException {
        return protocolStack.peek().readDecimal();
    }

    @Override
    public double readDouble() throws IOException {
        return protocolStack.peek().readDouble();
    }

    @Override
    public <E extends Enum<E>> E readEnum(final Class<E> enumClass)
            throws IOException {
        return protocolStack.peek().readEnum(enumClass);
    }

    @Override
    public FieldBegin readFieldBegin() throws IOException {
        return protocolStack.peek().readFieldBegin();
    }

    @Override
    public void readFieldEnd() throws IOException {
        protocolStack.peek().readFieldEnd();
    }

    @Override
    public short readI16() throws IOException {
        return protocolStack.peek().readI16();
    }

    @Override
    public int readI32() throws IOException {
        return protocolStack.peek().readI32();
    }

    @Override
    public long readI64() throws IOException {
        return protocolStack.peek().readI64();
    }

    @Override
    public ListBegin readListBegin() throws IOException {
        return protocolStack.peek().readListBegin();
    }

    @Override
    public void readListEnd() throws IOException {
        protocolStack.pop();
    }

    @Override
    public MapBegin readMapBegin() throws IOException {
        return protocolStack.peek().readMapBegin();
    }

    @Override
    public void readMapEnd() throws IOException {
        protocolStack.pop();
    }

    @Override
    public Object readMixed() throws IOException {
        return protocolStack.peek().readMixed();
    }

    @Override
    public SetBegin readSetBegin() throws IOException {
        return protocolStack.peek().readSetBegin();
    }

    @Override
    public void readSetEnd() throws IOException {
        protocolStack.pop();
    }

    @Override
    public String readString() throws IOException {
        return protocolStack.peek().readString();
    }

    @Override
    public StructBegin readStructBegin() throws IOException {
        return protocolStack.peek().readStructBegin();
    }

    @Override
    public void readStructEnd() throws IOException {
        protocolStack.pop();
    }

    protected final Stack<InputProtocol> _getProtocolStack() {
        return protocolStack;
    }

    private final Stack<InputProtocol> protocolStack = new Stack<InputProtocol>();
}
