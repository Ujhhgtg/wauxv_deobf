package com.alibaba.fastjson2.writer;

import com.alibaba.fastjson2.JSONException;
import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.util.JDKUtils;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
final class FieldWriterInt8ValField<T> extends FieldWriterInt8<T> {
    public FieldWriterInt8ValField(String str, int i, long j, String str2, String str3, Field field) {
        super(str, i, j, str2, str3, Byte.TYPE, field, null);
    }

    @Override // com.alibaba.fastjson2.writer.FieldWriter
    public Object getFieldValue(T t) {
        return Byte.valueOf(getFieldValueByte(t));
    }

    public byte getFieldValueByte(T t) {
        if (t == null) {
            throw new JSONException("field.get error, " + this.fieldName);
        }
        try {
            long j = this.fieldOffset;
            return j != -1 ? JDKUtils.UNSAFE.getByte(t, j) : this.field.getByte(t);
        } catch (IllegalAccessException e) {
            e = e;
            throw new JSONException("field.get error, " + this.fieldName, e);
        } catch (IllegalArgumentException e2) {
            e = e2;
            throw new JSONException("field.get error, " + this.fieldName, e);
        }
    }

    @Override // com.alibaba.fastjson2.writer.FieldWriterInt8, com.alibaba.fastjson2.writer.FieldWriter
    public boolean write(JSONWriter jSONWriter, T t) {
        writeInt8(jSONWriter, getFieldValueByte(t));
        return true;
    }

    @Override // com.alibaba.fastjson2.writer.FieldWriterInt8, com.alibaba.fastjson2.writer.FieldWriter
    public void writeValue(JSONWriter jSONWriter, T t) {
        jSONWriter.writeInt32(getFieldValueByte(t));
    }
}
