package com.alibaba.fastjson2.reader;

import com.alibaba.fastjson2.JSONException;
import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.schema.JSONSchema;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Locale;
import me.hd.wauxv.obf.yg;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
final class FieldReaderStringMethod<T> extends FieldReaderObject<T> {
    final boolean trim;
    final boolean upper;

    public FieldReaderStringMethod(String str, Type type, Class cls, int i, long j, String str2, Locale locale, String str3, JSONSchema jSONSchema, Method method) {
        super(str, type, cls, i, j, str2, locale, str3, jSONSchema, method, null, null);
        this.trim = "trim".equals(str2) || (j & JSONReader.Feature.TrimString.mask) != 0;
        this.upper = "upper".equals(str2);
    }

    @Override // com.alibaba.fastjson2.reader.FieldReaderObject, com.alibaba.fastjson2.reader.FieldReader
    public void accept(T t, Object obj) {
        String string = ((obj instanceof String) || obj == null) ? (String) obj : obj.toString();
        if (string != null) {
            if (this.trim) {
                string = string.trim();
            }
            if (this.upper) {
                string = string.toUpperCase();
            }
        }
        JSONSchema jSONSchema = this.schema;
        if (jSONSchema != null) {
            jSONSchema.assertValidate(string);
        }
        try {
            this.method.invoke(t, string);
        } catch (Exception e) {
            throw new JSONException(yg.o(new StringBuilder("set "), this.fieldName, " error"), e);
        }
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public boolean supportAcceptType(Class cls) {
        return true;
    }

    @Override // com.alibaba.fastjson2.reader.FieldReaderObject, com.alibaba.fastjson2.reader.FieldReader
    public void readFieldValue(JSONReader jSONReader, T t) {
        String string = jSONReader.readString();
        if (string != null) {
            if (this.trim) {
                string = string.trim();
            }
            if (this.upper) {
                string = string.toUpperCase();
            }
        }
        JSONSchema jSONSchema = this.schema;
        if (jSONSchema != null) {
            jSONSchema.assertValidate(string);
        }
        try {
            this.method.invoke(t, string);
        } catch (Exception e) {
            throw new JSONException(yg.p(new StringBuilder("set "), this.fieldName, " error", jSONReader), e);
        }
    }

    @Override // com.alibaba.fastjson2.reader.FieldReaderObject, com.alibaba.fastjson2.reader.FieldReader
    public String readFieldValue(JSONReader jSONReader) {
        String string = jSONReader.readString();
        return (!this.trim || string == null) ? string : string.trim();
    }
}
