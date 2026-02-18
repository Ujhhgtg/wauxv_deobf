package com.alibaba.fastjson2.reader;

import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.schema.JSONSchema;
import com.alibaba.fastjson2.util.JDKUtils;
import com.alibaba.fastjson2.util.TypeUtils;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
class FieldReaderInt64ValueField<T> extends FieldReaderObjectField<T> {
    public FieldReaderInt64ValueField(String str, Class cls, int i, long j, String str2, Long l, JSONSchema jSONSchema, Field field) {
        super(str, cls, cls, i, j, str2, null, l, jSONSchema, field);
    }

    @Override // com.alibaba.fastjson2.reader.FieldReaderObjectField, com.alibaba.fastjson2.reader.FieldReaderObject, com.alibaba.fastjson2.reader.FieldReader
    public void accept(T t, float f) {
        accept(t, Long.valueOf((long) f));
    }

    @Override // com.alibaba.fastjson2.reader.FieldReaderObject, com.alibaba.fastjson2.reader.FieldReader
    public void readFieldValue(JSONReader jSONReader, T t) {
        long int64Value = jSONReader.readInt64Value();
        JSONSchema jSONSchema = this.schema;
        if (jSONSchema != null) {
            jSONSchema.assertValidate(int64Value);
        }
        JDKUtils.UNSAFE.putLong(t, this.fieldOffset, int64Value);
    }

    @Override // com.alibaba.fastjson2.reader.FieldReaderObject, com.alibaba.fastjson2.reader.FieldReader
    public void readFieldValueJSONB(JSONReader jSONReader, T t) {
        readFieldValue(jSONReader, t);
    }

    @Override // com.alibaba.fastjson2.reader.FieldReaderObjectField, com.alibaba.fastjson2.reader.FieldReaderObject, com.alibaba.fastjson2.reader.FieldReader
    public void accept(T t, double d) {
        accept(t, Long.valueOf((long) d));
    }

    @Override // com.alibaba.fastjson2.reader.FieldReaderObjectField, com.alibaba.fastjson2.reader.FieldReaderObject, com.alibaba.fastjson2.reader.FieldReader
    public void accept(T t, Object obj) {
        long longValue = TypeUtils.toLongValue(obj);
        JSONSchema jSONSchema = this.schema;
        if (jSONSchema != null) {
            jSONSchema.assertValidate(longValue);
        }
        JDKUtils.UNSAFE.putLong(t, this.fieldOffset, longValue);
    }
}
