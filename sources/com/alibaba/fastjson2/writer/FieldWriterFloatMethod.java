package com.alibaba.fastjson2.writer;

import com.alibaba.fastjson2.JSONException;
import com.alibaba.fastjson2.JSONWriter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.text.DecimalFormat;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
class FieldWriterFloatMethod<T> extends FieldWriter<T> {
    public FieldWriterFloatMethod(String str, int i, long j, String str2, String str3, Type type, Class cls, Field field, Method method) {
        super(str, i, j, str2, null, str3, type, cls, field, method);
    }

    @Override // com.alibaba.fastjson2.writer.FieldWriter
    public Object getFieldValue(Object obj) {
        try {
            return this.method.invoke(obj, null);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            throw new JSONException("invoke getter method error, " + this.fieldName, e);
        }
    }

    @Override // com.alibaba.fastjson2.writer.FieldWriter
    public boolean write(JSONWriter jSONWriter, T t) {
        try {
            Float f = (Float) getFieldValue(t);
            if (f == null) {
                return writeFloatNull(jSONWriter);
            }
            writeFieldName(jSONWriter);
            float fFloatValue = f.floatValue();
            DecimalFormat decimalFormat = this.decimalFormat;
            if (decimalFormat != null) {
                jSONWriter.writeFloat(fFloatValue, decimalFormat);
                return true;
            }
            if ((this.features & JSONWriter.Feature.WriteNonStringValueAsString.mask) != 0) {
                jSONWriter.writeString(fFloatValue);
                return true;
            }
            jSONWriter.writeFloat(fFloatValue);
            return true;
        } catch (RuntimeException e) {
            if (jSONWriter.isIgnoreErrorGetter()) {
                return false;
            }
            throw e;
        }
    }

    @Override // com.alibaba.fastjson2.writer.FieldWriter
    public void writeValue(JSONWriter jSONWriter, T t) {
        Float f = (Float) getFieldValue(t);
        if (f == null) {
            jSONWriter.writeNumberNull();
            return;
        }
        float fFloatValue = f.floatValue();
        DecimalFormat decimalFormat = this.decimalFormat;
        if (decimalFormat != null) {
            jSONWriter.writeFloat(fFloatValue, decimalFormat);
        } else {
            jSONWriter.writeFloat(fFloatValue);
        }
    }
}
