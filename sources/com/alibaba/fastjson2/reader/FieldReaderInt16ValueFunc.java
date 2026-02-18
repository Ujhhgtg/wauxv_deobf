package com.alibaba.fastjson2.reader;

import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.function.ObjShortConsumer;
import com.alibaba.fastjson2.schema.JSONSchema;
import com.alibaba.fastjson2.util.TypeUtils;
import java.lang.reflect.Method;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
final class FieldReaderInt16ValueFunc<T> extends FieldReader<T> {
    final ObjShortConsumer<T> function;

    /* JADX WARN: Illegal instructions before constructor call */
    public FieldReaderInt16ValueFunc(String str, int i, long j, String str2, Locale locale, Short sh, JSONSchema jSONSchema, Method method, ObjShortConsumer<T> objShortConsumer) {
        Class cls = Short.TYPE;
        super(str, cls, cls, i, j, str2, locale, sh, jSONSchema, method, null);
        this.function = objShortConsumer;
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public void accept(T t, short s) {
        JSONSchema jSONSchema = this.schema;
        if (jSONSchema != null) {
            jSONSchema.assertValidate(s);
        }
        this.function.accept(t, s);
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public void readFieldValue(JSONReader jSONReader, T t) {
        short int32Value = (short) jSONReader.readInt32Value();
        JSONSchema jSONSchema = this.schema;
        if (jSONSchema != null) {
            jSONSchema.assertValidate(int32Value);
        }
        this.function.accept(t, int32Value);
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public void accept(T t, Object obj) {
        short shortValue = TypeUtils.toShortValue(obj);
        JSONSchema jSONSchema = this.schema;
        if (jSONSchema != null) {
            jSONSchema.assertValidate(shortValue);
        }
        this.function.accept(t, shortValue);
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public Object readFieldValue(JSONReader jSONReader) {
        return Short.valueOf((short) jSONReader.readInt32Value());
    }
}
