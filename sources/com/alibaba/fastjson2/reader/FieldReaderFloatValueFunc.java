package com.alibaba.fastjson2.reader;

import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.function.ObjFloatConsumer;
import com.alibaba.fastjson2.schema.JSONSchema;
import com.alibaba.fastjson2.util.TypeUtils;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
final class FieldReaderFloatValueFunc<T> extends FieldReader<T> {
    final ObjFloatConsumer<T> function;

    /* JADX WARN: Illegal instructions before constructor call */
    public FieldReaderFloatValueFunc(String str, int i, Float f, JSONSchema jSONSchema, Method method, ObjFloatConsumer<T> objFloatConsumer) {
        Class cls = Float.TYPE;
        super(str, cls, cls, i, 0L, null, null, f, jSONSchema, method, null);
        this.function = objFloatConsumer;
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public void accept(T t, float f) {
        JSONSchema jSONSchema = this.schema;
        if (jSONSchema != null) {
            jSONSchema.assertValidate(f);
        }
        this.function.accept(t, f);
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public void readFieldValue(JSONReader jSONReader, T t) {
        float floatValue = jSONReader.readFloatValue();
        JSONSchema jSONSchema = this.schema;
        if (jSONSchema != null) {
            jSONSchema.assertValidate(floatValue);
        }
        this.function.accept(t, floatValue);
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public void accept(T t, Object obj) {
        float floatValue = TypeUtils.toFloatValue(obj);
        JSONSchema jSONSchema = this.schema;
        if (jSONSchema != null) {
            jSONSchema.assertValidate(floatValue);
        }
        this.function.accept(t, floatValue);
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public Object readFieldValue(JSONReader jSONReader) {
        return Float.valueOf(jSONReader.readFloatValue());
    }
}
