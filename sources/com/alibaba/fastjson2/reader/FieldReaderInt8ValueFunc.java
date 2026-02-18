package com.alibaba.fastjson2.reader;

import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.function.ObjByteConsumer;
import com.alibaba.fastjson2.schema.JSONSchema;
import com.alibaba.fastjson2.util.TypeUtils;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
final class FieldReaderInt8ValueFunc<T> extends FieldReader<T> {
    final ObjByteConsumer<T> function;

    /* JADX WARN: Illegal instructions before constructor call */
    public FieldReaderInt8ValueFunc(String str, int i, JSONSchema jSONSchema, Method method, ObjByteConsumer<T> objByteConsumer) {
        Class cls = Byte.TYPE;
        super(str, cls, cls, i, 0L, null, null, null, jSONSchema, method, null);
        this.function = objByteConsumer;
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public void accept(T t, byte b) {
        JSONSchema jSONSchema = this.schema;
        if (jSONSchema != null) {
            jSONSchema.assertValidate(b);
        }
        this.function.accept(t, b);
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public void readFieldValue(JSONReader jSONReader, T t) {
        byte int32Value = (byte) jSONReader.readInt32Value();
        JSONSchema jSONSchema = this.schema;
        if (jSONSchema != null) {
            jSONSchema.assertValidate(int32Value);
        }
        this.function.accept(t, int32Value);
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public void accept(T t, Object obj) {
        byte byteValue = TypeUtils.toByteValue(obj);
        JSONSchema jSONSchema = this.schema;
        if (jSONSchema != null) {
            jSONSchema.assertValidate(byteValue);
        }
        this.function.accept(t, byteValue);
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public Object readFieldValue(JSONReader jSONReader) {
        return Byte.valueOf((byte) jSONReader.readInt32Value());
    }
}
