package com.alibaba.fastjson2.reader;

import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.schema.JSONSchema;
import com.alibaba.fastjson2.util.TypeUtils;
import java.lang.reflect.Method;
import java.util.function.ObjLongConsumer;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
final class FieldReaderInt64ValueFunc<T> extends FieldReader<T> {
    final ObjLongConsumer<T> function;

    /* JADX WARN: Illegal instructions before constructor call */
    public FieldReaderInt64ValueFunc(String str, int i, Long l, JSONSchema jSONSchema, Method method, ObjLongConsumer<T> objLongConsumer) {
        Class cls = Long.TYPE;
        super(str, cls, cls, i, 0L, null, null, l, jSONSchema, method, null);
        this.function = objLongConsumer;
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public void accept(T t, long j) {
        JSONSchema jSONSchema = this.schema;
        if (jSONSchema != null) {
            jSONSchema.assertValidate(j);
        }
        this.function.accept(t, j);
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public void readFieldValue(JSONReader jSONReader, T t) {
        long int64Value = jSONReader.readInt64Value();
        JSONSchema jSONSchema = this.schema;
        if (jSONSchema != null) {
            jSONSchema.assertValidate(int64Value);
        }
        this.function.accept(t, int64Value);
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public void accept(T t, Object obj) {
        long longValue = TypeUtils.toLongValue(obj);
        JSONSchema jSONSchema = this.schema;
        if (jSONSchema != null) {
            jSONSchema.assertValidate(longValue);
        }
        this.function.accept(t, longValue);
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public Object readFieldValue(JSONReader jSONReader) {
        return Long.valueOf(jSONReader.readInt64Value());
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public void accept(T t, int i) {
        JSONSchema jSONSchema = this.schema;
        if (jSONSchema != null) {
            jSONSchema.assertValidate(i);
        }
        this.function.accept(t, i);
    }
}
