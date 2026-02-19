package com.alibaba.fastjson2.reader;

import com.alibaba.fastjson2.JSONException;
import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.schema.JSONSchema;
import com.alibaba.fastjson2.util.TypeUtils;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Locale;
import me.hd.wauxv.obf.yg;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
final class FieldReaderBigDecimalMethod<T> extends FieldReaderObject<T> {
    public FieldReaderBigDecimalMethod(String str, Type type, Class cls, int i, long j, String str2, Locale locale, BigDecimal bigDecimal, JSONSchema jSONSchema, Method method) {
        super(str, type, cls, i, j, str2, locale, bigDecimal, jSONSchema, method, null, null);
    }

    @Override // com.alibaba.fastjson2.reader.FieldReaderObject, com.alibaba.fastjson2.reader.FieldReader
    public void accept(T t, Object obj) {
        BigDecimal bigDecimal = TypeUtils.toBigDecimal(obj);
        JSONSchema jSONSchema = this.schema;
        if (jSONSchema != null) {
            jSONSchema.assertValidate(bigDecimal);
        }
        try {
            this.method.invoke(t, bigDecimal);
        } catch (Exception e) {
            throw new JSONException(yg.concatToVar1(new StringBuilder("set "), this.fieldName, " error"), e);
        }
    }

    @Override // com.alibaba.fastjson2.reader.FieldReaderObject, com.alibaba.fastjson2.reader.FieldReader
    public void readFieldValue(JSONReader jSONReader, T t) {
        BigDecimal bigDecimal = jSONReader.readBigDecimal();
        JSONSchema jSONSchema = this.schema;
        if (jSONSchema != null) {
            jSONSchema.assertValidate(bigDecimal);
        }
        try {
            this.method.invoke(t, bigDecimal);
        } catch (Exception e) {
            throw new JSONException(yg.p(new StringBuilder("set "), this.fieldName, " error", jSONReader), e);
        }
    }

    @Override // com.alibaba.fastjson2.reader.FieldReaderObject, com.alibaba.fastjson2.reader.FieldReader
    public void accept(T t, int i) {
        JSONSchema jSONSchema = this.schema;
        if (jSONSchema != null) {
            jSONSchema.assertValidate(i);
        }
        try {
            this.method.invoke(t, BigDecimal.valueOf(i));
        } catch (Exception e) {
            throw new JSONException(yg.concatToVar1(new StringBuilder("set "), this.fieldName, " error"), e);
        }
    }

    @Override // com.alibaba.fastjson2.reader.FieldReaderObject, com.alibaba.fastjson2.reader.FieldReader
    public void accept(T t, long j) {
        JSONSchema jSONSchema = this.schema;
        if (jSONSchema != null) {
            jSONSchema.assertValidate(j);
        }
        try {
            this.method.invoke(t, BigDecimal.valueOf(j));
        } catch (Exception e) {
            throw new JSONException(yg.concatToVar1(new StringBuilder("set "), this.fieldName, " error"), e);
        }
    }
}
