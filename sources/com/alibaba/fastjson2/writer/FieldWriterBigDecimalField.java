package com.alibaba.fastjson2.writer;

import com.alibaba.fastjson2.JSONWriter;
import java.lang.reflect.Field;
import java.math.BigDecimal;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
final class FieldWriterBigDecimalField<T> extends FieldWriter<T> {
    public FieldWriterBigDecimalField(String str, int i, long j, String str2, String str3, Field field) {
        super(str, i, j, str2, null, str3, BigDecimal.class, BigDecimal.class, field, null);
    }

    @Override // com.alibaba.fastjson2.writer.FieldWriter
    public boolean write(JSONWriter jSONWriter, T t) {
        BigDecimal bigDecimal = (BigDecimal) getFieldValue(t);
        if (bigDecimal == null) {
            return writeFloatNull(jSONWriter);
        }
        writeFieldName(jSONWriter);
        jSONWriter.writeDecimal(bigDecimal, this.features, this.decimalFormat);
        return true;
    }

    @Override // com.alibaba.fastjson2.writer.FieldWriter
    public void writeValue(JSONWriter jSONWriter, T t) {
        jSONWriter.writeDecimal((BigDecimal) getFieldValue(t), this.features, this.decimalFormat);
    }
}
