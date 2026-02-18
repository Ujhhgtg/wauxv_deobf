package com.alibaba.fastjson2.reader;

import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.schema.JSONSchema;
import com.alibaba.fastjson2.util.TypeUtils;
import java.lang.reflect.Method;
import java.util.function.ObjIntConsumer;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
final class FieldReaderInt32ValueFunc<T> extends FieldReader<T> {
    final ObjIntConsumer<T> function;

    /* JADX WARN: Illegal instructions before constructor call */
    public FieldReaderInt32ValueFunc(String str, int i, Integer num, JSONSchema jSONSchema, Method method, ObjIntConsumer<T> objIntConsumer) {
        Class cls = Integer.TYPE;
        super(str, cls, cls, i, 0L, null, null, num, jSONSchema, method, null);
        this.function = objIntConsumer;
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public void accept(T t, int i) {
        JSONSchema jSONSchema = this.schema;
        if (jSONSchema != null) {
            jSONSchema.assertValidate(i);
        }
        this.function.accept(t, i);
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public void readFieldValue(JSONReader jSONReader, T t) {
        int int32Value = jSONReader.readInt32Value();
        JSONSchema jSONSchema = this.schema;
        if (jSONSchema != null) {
            jSONSchema.assertValidate(int32Value);
        }
        this.function.accept(t, int32Value);
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public void accept(T t, long j) {
        JSONSchema jSONSchema = this.schema;
        if (jSONSchema != null) {
            jSONSchema.assertValidate(j);
        }
        this.function.accept(t, (int) j);
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public Object readFieldValue(JSONReader jSONReader) {
        return Integer.valueOf(jSONReader.readInt32Value());
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public void accept(T t, Object obj) {
        int intValue = TypeUtils.toIntValue(obj);
        JSONSchema jSONSchema = this.schema;
        if (jSONSchema != null) {
            jSONSchema.assertValidate(intValue);
        }
        this.function.accept(t, intValue);
    }
}
