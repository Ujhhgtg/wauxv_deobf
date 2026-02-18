package com.alibaba.fastjson2.writer;

import com.alibaba.fastjson2.JSONWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.function.ToDoubleFunction;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
final class FieldWriterDoubleValueFunc extends FieldWriter {
    final ToDoubleFunction function;

    /* JADX WARN: Illegal instructions before constructor call */
    public FieldWriterDoubleValueFunc(String str, int i, long j, String str2, String str3, Field field, Method method, ToDoubleFunction toDoubleFunction) {
        Class cls = Double.TYPE;
        super(str, i, j, str2, null, str3, cls, cls, field, method);
        this.function = toDoubleFunction;
    }

    @Override // com.alibaba.fastjson2.writer.FieldWriter
    public Object getFieldValue(Object obj) {
        return Double.valueOf(this.function.applyAsDouble(obj));
    }

    @Override // com.alibaba.fastjson2.writer.FieldWriter
    public boolean write(JSONWriter jSONWriter, Object obj) {
        try {
            double dApplyAsDouble = this.function.applyAsDouble(obj);
            writeFieldName(jSONWriter);
            DecimalFormat decimalFormat = this.decimalFormat;
            if (decimalFormat != null) {
                jSONWriter.writeDouble(dApplyAsDouble, decimalFormat);
                return true;
            }
            jSONWriter.writeDouble(dApplyAsDouble);
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
        double dApplyAsDouble = this.function.applyAsDouble(obj);
        DecimalFormat decimalFormat = this.decimalFormat;
        if (decimalFormat != null) {
            jSONWriter.writeDouble(dApplyAsDouble, decimalFormat);
        } else {
            jSONWriter.writeDouble(dApplyAsDouble);
        }
    }
}
