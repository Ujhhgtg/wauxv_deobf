package com.alibaba.fastjson2.reader;

import com.alibaba.fastjson2.JSONException;
import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.schema.JSONSchema;
import com.alibaba.fastjson2.util.TypeUtils;
import java.lang.reflect.Field;
import me.hd.wauxv.obf.yg;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
final class FieldReaderInt8Field<T> extends FieldReaderObjectField<T> {
    public FieldReaderInt8Field(String str, Class cls, int i, long j, String str2, Byte b, JSONSchema jSONSchema, Field field) {
        super(str, cls, cls, i, j, str2, null, b, jSONSchema, field);
    }

    @Override // com.alibaba.fastjson2.reader.FieldReaderObjectField, com.alibaba.fastjson2.reader.FieldReaderObject, com.alibaba.fastjson2.reader.FieldReader
    public void accept(T t, short s) {
        accept(t, Byte.valueOf((byte) s));
    }

    @Override // com.alibaba.fastjson2.reader.FieldReaderObject, com.alibaba.fastjson2.reader.FieldReader
    public void readFieldValue(JSONReader jSONReader, T t) {
        Integer int32 = jSONReader.readInt32();
        JSONSchema jSONSchema = this.schema;
        if (jSONSchema != null) {
            jSONSchema.assertValidate(int32);
        }
        try {
            this.field.set(t, int32 == null ? null : Byte.valueOf(int32.byteValue()));
        } catch (Exception e) {
            throw new JSONException(yg.p(new StringBuilder("set "), this.fieldName, " error", jSONReader), e);
        }
    }

    @Override // com.alibaba.fastjson2.reader.FieldReaderObjectField, com.alibaba.fastjson2.reader.FieldReaderObject, com.alibaba.fastjson2.reader.FieldReader
    public void accept(T t, float f) {
        accept(t, Byte.valueOf((byte) f));
    }

    @Override // com.alibaba.fastjson2.reader.FieldReaderObjectField, com.alibaba.fastjson2.reader.FieldReaderObject, com.alibaba.fastjson2.reader.FieldReader
    public void accept(T t, double d) {
        accept(t, Byte.valueOf((byte) d));
    }

    @Override // com.alibaba.fastjson2.reader.FieldReaderObjectField, com.alibaba.fastjson2.reader.FieldReaderObject, com.alibaba.fastjson2.reader.FieldReader
    public void accept(T t, int i) {
        accept(t, Byte.valueOf((byte) i));
    }

    @Override // com.alibaba.fastjson2.reader.FieldReaderObjectField, com.alibaba.fastjson2.reader.FieldReaderObject, com.alibaba.fastjson2.reader.FieldReader
    public void accept(T t, long j) {
        accept(t, Byte.valueOf((byte) j));
    }

    @Override // com.alibaba.fastjson2.reader.FieldReaderObjectField, com.alibaba.fastjson2.reader.FieldReaderObject, com.alibaba.fastjson2.reader.FieldReader
    public void accept(T t, Object obj) {
        Byte b = TypeUtils.toByte(obj);
        JSONSchema jSONSchema = this.schema;
        if (jSONSchema != null) {
            jSONSchema.assertValidate(b);
        }
        try {
            this.field.set(t, b);
        } catch (Exception e) {
            throw new JSONException(yg.o(new StringBuilder("set "), this.fieldName, " error"), e);
        }
    }

    @Override // com.alibaba.fastjson2.reader.FieldReaderObject, com.alibaba.fastjson2.reader.FieldReader
    public Object readFieldValue(JSONReader jSONReader) {
        return Byte.valueOf((byte) jSONReader.readInt32Value());
    }
}
