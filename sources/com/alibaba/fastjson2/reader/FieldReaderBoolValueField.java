package com.alibaba.fastjson2.reader;

import com.alibaba.fastjson2.JSONException;
import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.schema.JSONSchema;
import com.alibaba.fastjson2.util.JDKUtils;
import com.alibaba.fastjson2.util.TypeUtils;
import java.lang.reflect.Field;
import me.hd.wauxv.obf.yg;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
final class FieldReaderBoolValueField<T> extends FieldReaderObjectField<T> {
    /* JADX WARN: Illegal instructions before constructor call */
    public FieldReaderBoolValueField(String str, int i, long j, String str2, Boolean bool, JSONSchema jSONSchema, Field field) {
        Class cls = Boolean.TYPE;
        super(str, cls, cls, i, j, str2, null, bool, jSONSchema, field);
    }

    @Override // com.alibaba.fastjson2.reader.FieldReaderObjectField, com.alibaba.fastjson2.reader.FieldReaderObject, com.alibaba.fastjson2.reader.FieldReader
    public void accept(T t, int i) {
        accept(t, TypeUtils.toBooleanValue(Integer.valueOf(i)));
    }

    @Override // com.alibaba.fastjson2.reader.FieldReaderObject, com.alibaba.fastjson2.reader.FieldReader
    public void readFieldValue(JSONReader jSONReader, T t) {
        boolean boolValue = jSONReader.readBoolValue();
        JSONSchema jSONSchema = this.schema;
        if (jSONSchema != null) {
            jSONSchema.assertValidate(Boolean.valueOf(boolValue));
        }
        try {
            this.field.setBoolean(t, boolValue);
        } catch (Exception e) {
            throw new JSONException(yg.p(new StringBuilder("set "), this.fieldName, " error", jSONReader), e);
        }
    }

    @Override // com.alibaba.fastjson2.reader.FieldReaderObjectField, com.alibaba.fastjson2.reader.FieldReaderObject, com.alibaba.fastjson2.reader.FieldReader
    public void accept(T t, Object obj) {
        if (obj == null) {
            if ((this.features & JSONReader.Feature.IgnoreSetNullValue.mask) != 0) {
                return;
            }
            accept((Object) t, false);
        } else {
            if (obj instanceof Boolean) {
                accept(t, ((Boolean) obj).booleanValue());
                return;
            }
            throw new JSONException("set " + this.fieldName + " error, type not support " + obj.getClass());
        }
    }

    @Override // com.alibaba.fastjson2.reader.FieldReaderObjectField, com.alibaba.fastjson2.reader.FieldReaderObject, com.alibaba.fastjson2.reader.FieldReader
    public void accept(T t, boolean z) {
        JSONSchema jSONSchema = this.schema;
        if (jSONSchema != null) {
            jSONSchema.assertValidate(Boolean.valueOf(z));
        }
        long j = this.fieldOffset;
        if (j != -1) {
            JDKUtils.UNSAFE.putBoolean(t, j, z);
            return;
        }
        try {
            this.field.setBoolean(t, z);
        } catch (Exception e) {
            throw new JSONException(yg.o(new StringBuilder("set "), this.fieldName, " error"), e);
        }
    }

    @Override // com.alibaba.fastjson2.reader.FieldReaderObject, com.alibaba.fastjson2.reader.FieldReader
    public Object readFieldValue(JSONReader jSONReader) {
        return jSONReader.readBool();
    }
}
