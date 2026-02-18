package com.alibaba.fastjson2.reader;

import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.schema.JSONSchema;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class FieldReaderAtomicReference<T> extends FieldReader<T> {
    final Type referenceType;

    /* JADX WARN: Found duplicated region for block: B:7:0x0028  */
    public FieldReaderAtomicReference(String str, Type type, Class cls, int i, long j, String str2, JSONSchema jSONSchema, Method method, Field field) {
        Type type2;
        super(str, type, cls, i, j, str2, null, null, jSONSchema, method, field);
        if (type instanceof ParameterizedType) {
            Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
            type2 = actualTypeArguments.length == 1 ? actualTypeArguments[0] : null;
        }
        this.referenceType = type2;
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public void readFieldValue(JSONReader jSONReader, T t) {
        if (jSONReader.nextIfNull()) {
            return;
        }
        accept(t, jSONReader.read(this.referenceType));
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public Object readFieldValue(JSONReader jSONReader) {
        return jSONReader.read(this.referenceType);
    }
}
