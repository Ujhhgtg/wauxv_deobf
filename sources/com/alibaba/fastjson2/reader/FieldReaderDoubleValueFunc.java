package com.alibaba.fastjson2.reader;

import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.schema.JSONSchema;
import com.alibaba.fastjson2.util.TypeUtils;
import java.lang.reflect.Method;
import java.util.function.ObjDoubleConsumer;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
final class FieldReaderDoubleValueFunc<T> extends FieldReader<T> {
    final ObjDoubleConsumer<T> function;

    /* JADX WARN: Illegal instructions before constructor call */
    public FieldReaderDoubleValueFunc(String str, int i, Double d, JSONSchema jSONSchema, Method method, ObjDoubleConsumer<T> objDoubleConsumer) {
        Class cls = Double.TYPE;
        super(str, cls, cls, i, 0L, null, null, d, jSONSchema, method, null);
        this.function = objDoubleConsumer;
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public void accept(T t, double d) {
        JSONSchema jSONSchema = this.schema;
        if (jSONSchema != null) {
            jSONSchema.assertValidate(d);
        }
        this.function.accept(t, d);
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public void readFieldValue(JSONReader jSONReader, T t) {
        double doubleValue = jSONReader.readDoubleValue();
        JSONSchema jSONSchema = this.schema;
        if (jSONSchema != null) {
            jSONSchema.assertValidate(doubleValue);
        }
        this.function.accept(t, doubleValue);
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public void accept(T t, Object obj) {
        double doubleValue = TypeUtils.toDoubleValue(obj);
        JSONSchema jSONSchema = this.schema;
        if (jSONSchema != null) {
            jSONSchema.assertValidate(doubleValue);
        }
        this.function.accept(t, doubleValue);
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public Object readFieldValue(JSONReader jSONReader) {
        return Double.valueOf(jSONReader.readDoubleValue());
    }
}
