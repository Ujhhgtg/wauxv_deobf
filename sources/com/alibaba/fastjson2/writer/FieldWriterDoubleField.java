package com.alibaba.fastjson2.writer;

import com.alibaba.fastjson2.JSONException;
import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.util.JDKUtils;
import java.lang.reflect.Field;
import java.text.DecimalFormat;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
class FieldWriterDoubleField<T> extends FieldWriter<T> {
    public FieldWriterDoubleField(String str, int i, long j, String str2, String str3, Field field) {
        super(str, i, j, str2, null, str3, Double.class, Double.class, field, null);
    }

    @Override // com.alibaba.fastjson2.writer.FieldWriter
    public Object getFieldValue(Object obj) {
        if (obj == null) {
            throw new JSONException("field.get error, " + this.fieldName);
        }
        try {
            return (this.fieldOffset == -1 || this.fieldClass.isPrimitive()) ? this.field.get(obj) : JDKUtils.UNSAFE.getObject(obj, this.fieldOffset);
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
        Double d = (Double) getFieldValue(t);
        if (d == null) {
            return writeFloatNull(jSONWriter);
        }
        writeFieldName(jSONWriter);
        double dDoubleValue = d.doubleValue();
        DecimalFormat decimalFormat = this.decimalFormat;
        if (decimalFormat != null) {
            jSONWriter.writeDouble(dDoubleValue, decimalFormat);
            return true;
        }
        jSONWriter.writeDouble(dDoubleValue);
        return true;
    }

    @Override // com.alibaba.fastjson2.writer.FieldWriter
    public void writeValue(JSONWriter jSONWriter, T t) {
        Double d = (Double) getFieldValue(t);
        if (d == null) {
            jSONWriter.writeNumberNull();
            return;
        }
        double dDoubleValue = d.doubleValue();
        DecimalFormat decimalFormat = this.decimalFormat;
        if (decimalFormat != null) {
            jSONWriter.writeDouble(dDoubleValue, decimalFormat);
        } else {
            jSONWriter.writeDouble(dDoubleValue);
        }
    }
}
