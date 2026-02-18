package com.alibaba.fastjson2.reader;

import com.alibaba.fastjson2.JSONReader;
import java.lang.reflect.Type;
import java.math.BigInteger;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
final class ObjectReaderImplBigInteger extends ObjectReaderPrimitive<BigInteger> {
    static final ObjectReaderImplBigInteger INSTANCE = new ObjectReaderImplBigInteger();

    public ObjectReaderImplBigInteger() {
        super(BigInteger.class);
    }

    @Override // com.alibaba.fastjson2.reader.ObjectReaderPrimitive, com.alibaba.fastjson2.reader.ObjectReader
    public BigInteger readJSONBObject(JSONReader jSONReader, Type type, Object obj, long j) {
        return jSONReader.readBigInteger();
    }

    @Override // com.alibaba.fastjson2.reader.ObjectReader
    public BigInteger readObject(JSONReader jSONReader, Type type, Object obj, long j) {
        return jSONReader.readBigInteger();
    }
}
