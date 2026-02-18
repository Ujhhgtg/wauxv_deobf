package com.alibaba.fastjson2.reader;

import com.alibaba.fastjson2.JSONException;
import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.schema.JSONSchema;
import com.alibaba.fastjson2.util.TypeUtils;
import java.lang.reflect.Method;
import java.util.Locale;
import me.hd.wauxv.obf.yg;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
final class FieldReaderFloatMethod<T> extends FieldReaderObject<T> {
    public FieldReaderFloatMethod(String str, int i, long j, String str2, Locale locale, Float f, JSONSchema jSONSchema, Method method) {
        super(str, Float.class, Float.class, i, j, str2, locale, f, jSONSchema, method, null, null);
    }

    @Override // com.alibaba.fastjson2.reader.FieldReaderObject, com.alibaba.fastjson2.reader.FieldReader
    public void accept(T t, Object obj) {
        Float f = TypeUtils.toFloat(obj);
        JSONSchema jSONSchema = this.schema;
        if (jSONSchema != null) {
            jSONSchema.assertValidate(f);
        }
        try {
            this.method.invoke(t, f);
        } catch (Exception e) {
            throw new JSONException(yg.o(new StringBuilder("set "), this.fieldName, " error"), e);
        }
    }

    @Override // com.alibaba.fastjson2.reader.FieldReaderObject, com.alibaba.fastjson2.reader.FieldReader
    public void readFieldValue(JSONReader jSONReader, T t) {
        Float f = jSONReader.readFloat();
        JSONSchema jSONSchema = this.schema;
        if (jSONSchema != null) {
            jSONSchema.assertValidate(f);
        }
        try {
            this.method.invoke(t, f);
        } catch (Exception e) {
            throw new JSONException(yg.p(new StringBuilder("set "), this.fieldName, " error", jSONReader), e);
        }
    }
}
