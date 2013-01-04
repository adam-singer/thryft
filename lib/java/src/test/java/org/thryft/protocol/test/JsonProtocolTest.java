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

package org.thryft.protocol.test;

import static org.junit.Assert.assertEquals;

import java.io.StringReader;
import java.io.StringWriter;

import org.apache.thrift.TBase;
import org.apache.thrift.protocol.TProtocol;
import org.thryft.protocol.JsonProtocol;
import org.thryft.protocol.Protocol;

public class JsonProtocolTest extends ProtocolTest {
    @Override
    protected void _test(final TBase<?, ?> expected) throws Exception {
        final StringWriter writer = new StringWriter();
        final Protocol oprot = new JsonProtocol(writer);
        expected.write(oprot);
        oprot.flush();

        final String ostring = writer.toString();

        final StringReader reader = new StringReader(ostring);
        final Protocol iprot = new JsonProtocol(reader);
        final TBase<?, ?> actual = expected.getClass()
                .getConstructor(TProtocol.class).newInstance(iprot);
        assertEquals(expected, actual);
    }
}
