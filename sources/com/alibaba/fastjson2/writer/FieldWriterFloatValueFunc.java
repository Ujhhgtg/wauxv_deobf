package com.alibaba.fastjson2.writer;

import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.function.ToFloatFunction;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.DecimalFormat;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
final class FieldWriterFloatValueFunc extends FieldWriter {
    final ToFloatFunction function;

    /* JADX WARN: Illegal instructions before constructor call */
    public FieldWriterFloatValueFunc(String str, int i, long j, String str2, String str3, Field field, Method method, ToFloatFunction toFloatFunction) {
        Class cls = Float.TYPE;
        super(str, i, j, str2, null, str3, cls, cls, field, method);
        this.function = toFloatFunction;
    }

    @Override // com.alibaba.fastjson2.writer.FieldWriter
    public Object getFieldValue(Object obj) {
        return Float.valueOf(this.function.applyAsFloat(obj));
    }

    @Override // com.alibaba.fastjson2.writer.FieldWriter
    public boolean write(JSONWriter jSONWriter, Object obj) {
        try {
            float fApplyAsFloat = this.function.applyAsFloat(obj);
            writeFieldName(jSONWriter);
            DecimalFormat decimalFormat = this.decimalFormat;
            if (decimalFormat != null) {
                jSONWriter.writeFloat(fApplyAsFloat, decimalFormat);
                return true;
            }
            jSONWriter.writeFloat(fApplyAsFloat);
            return true;
        } catch (RuntimeException e) {
            if (jSONWriter.isIgnoreErrorGetter()) {
                return false;
            }
            throw e;
        }
    }

    @Override // com.alibaba.fastjson2.writer.FieldWriter
    public void writeValue(JSONWriter jSONWriter, Object obj) {
        float fApplyAsFloat = this.function.applyAsFloat(obj);
        DecimalFormat decimalFormat = this.decimalFormat;
        if (decimalFormat != null) {
            jSONWriter.writeDouble(fApplyAsFloat, decimalFormat);
        } else {
            jSONWriter.writeDouble(fApplyAsFloat);
        }
    }
}
