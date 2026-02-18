package com.alibaba.fastjson2.reader;

import com.alibaba.fastjson2.JSONException;
import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.schema.JSONSchema;
import com.alibaba.fastjson2.util.TypeUtils;
import java.lang.reflect.Field;
import me.hd.wauxv.obf.yg;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
final class FieldReaderDoubleField<T> extends FieldReaderObjectField<T> {
    public FieldReaderDoubleField(String str, Class cls, int i, long j, String str2, Double d, JSONSchema jSONSchema, Field field) {
        super(str, cls, cls, i, j, str2, null, d, jSONSchema, field);
    }

    @Override // com.alibaba.fastjson2.reader.FieldReaderObjectField, com.alibaba.fastjson2.reader.FieldReaderObject, com.alibaba.fastjson2.reader.FieldReader
    public void accept(T t, Object obj) {
        Double d = TypeUtils.toDouble(obj);
        JSONSchema jSONSchema = this.schema;
        if (jSONSchema != null) {
            jSONSchema.assertValidate(d);
        }
        try {
            this.field.set(t, d);
        } catch (Exception e) {
            throw new JSONException(yg.o(new StringBuilder("set "), this.fieldName, " error"), e);
        }
    }

    @Override // com.alibaba.fastjson2.reader.FieldReaderObject, com.alibaba.fastjson2.reader.FieldReader
    public void readFieldValue(JSONReader jSONReader, T t) {
        Double d = jSONReader.readDouble();
        JSONSchema jSONSchema = this.schema;
        if (jSONSchema != null) {
            jSONSchema.assertValidate(d);
        }
        if (d != null || this.defaultValue == null) {
            try {
                this.field.set(t, d);
            } catch (Exception e) {
                throw new JSONException(yg.p(new StringBuilder("set "), this.fieldName, " error", jSONReader), e);
            }
        }
    }

    @Override // com.alibaba.fastjson2.reader.FieldReaderObject, com.alibaba.fastjson2.reader.FieldReader
    public Object readFieldValue(JSONReader jSONReader) {
        return jSONReader.readDouble();
    }
}
