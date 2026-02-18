package com.alibaba.fastjson2.writer;

import com.alibaba.fastjson2.JSONWriter;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
final class FieldWriterStringField<T> extends FieldWriter<T> {
    public FieldWriterStringField(String str, int i, long j, String str2, String str3, Field field) {
        super(str, i, j, str2, null, str3, String.class, String.class, field, null);
    }

    @Override // com.alibaba.fastjson2.writer.FieldWriter
    public boolean write(JSONWriter jSONWriter, T t) {
        String strTrim = (String) getFieldValue(t);
        long features = this.features | jSONWriter.getFeatures();
        if (strTrim == null) {
            long j = JSONWriter.Feature.WriteNulls.mask;
            JSONWriter.Feature feature = JSONWriter.Feature.NullAsDefaultValue;
            long j2 = j | feature.mask;
            JSONWriter.Feature feature2 = JSONWriter.Feature.WriteNullStringAsEmpty;
            if (((j2 | feature2.mask) & features) == 0 || (JSONWriter.Feature.NotWriteDefaultValue.mask & features) != 0) {
                return false;
            }
            writeFieldName(jSONWriter);
            if ((features & (feature.mask | feature2.mask)) != 0) {
                jSONWriter.writeString("");
            } else {
                jSONWriter.writeNull();
            }
            return true;
        }
        if (this.trim) {
            strTrim = strTrim.trim();
        }
        if (strTrim.isEmpty() && (features & JSONWriter.Feature.IgnoreEmpty.mask) != 0) {
            return false;
        }
        writeFieldName(jSONWriter);
        if (this.symbol && jSONWriter.jsonb) {
            jSONWriter.writeSymbol(strTrim);
        } else if (this.raw) {
            jSONWriter.writeRaw(strTrim);
        } else {
            jSONWriter.writeString(strTrim);
        }
        return true;
    }

    @Override // com.alibaba.fastjson2.writer.FieldWriter
    public void writeValue(JSONWriter jSONWriter, T t) {
        String strTrim = (String) getFieldValue(t);
        if (strTrim == null) {
            jSONWriter.writeNull();
            return;
        }
        if (this.trim) {
            strTrim = strTrim.trim();
        }
        if (this.raw) {
            jSONWriter.writeRaw(strTrim);
        } else {
            jSONWriter.writeString(strTrim);
        }
    }
}
