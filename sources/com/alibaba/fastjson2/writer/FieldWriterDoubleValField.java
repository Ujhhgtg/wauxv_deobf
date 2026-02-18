package com.alibaba.fastjson2.writer;

import com.alibaba.fastjson2.JSONException;
import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.util.JDKUtils;
import java.lang.reflect.Field;
import java.text.DecimalFormat;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
final class FieldWriterDoubleValField<T> extends FieldWriter<T> {
    /* JADX WARN: Illegal instructions before constructor call */
    public FieldWriterDoubleValField(String str, int i, String str2, String str3, Field field) {
        Class cls = Double.TYPE;
        super(str, i, 0L, str2, null, str3, cls, cls, field, null);
    }

    @Override // com.alibaba.fastjson2.writer.FieldWriter
    public Object getFieldValue(Object obj) {
        return Double.valueOf(getFieldValueDouble(obj));
    }

    public double getFieldValueDouble(Object obj) {
        if (obj == null) {
            throw new JSONException("field.get error, " + this.fieldName);
        }
        try {
            long j = this.fieldOffset;
            return j != -1 ? JDKUtils.UNSAFE.getDouble(obj, j) : this.field.getDouble(obj);
        } catch (IllegalAccessException e) {
            e = e;
            throw new JSONException("field.get error, " + this.fieldName, e);
        } catch (IllegalArgumentException e2) {
            e = e2;
            throw new JSONException("field.get error, " + this.fieldName, e);
        }
    }

    @Override // com.alibaba.fastjson2.writer.FieldWriter
    public boolean write(JSONWriter jSONWriter, T t) {
        writeDouble(jSONWriter, getFieldValueDouble(t));
        return true;
    }

    @Override // com.alibaba.fastjson2.writer.FieldWriter
    public void writeValue(JSONWriter jSONWriter, T t) {
        double fieldValueDouble = getFieldValueDouble(t);
        DecimalFormat decimalFormat = this.decimalFormat;
        if (decimalFormat != null) {
            jSONWriter.writeDouble(fieldValueDouble, decimalFormat);
        } else {
            jSONWriter.writeDouble(fieldValueDouble);
        }
    }
}
