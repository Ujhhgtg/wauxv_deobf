package com.alibaba.fastjson2.writer;

import com.alibaba.fastjson2.JSONException;
import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.util.JDKUtils;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
final class FieldWriterMillisField<T> extends FieldWriterDate<T> {
    /* JADX WARN: Illegal instructions before constructor call */
    public FieldWriterMillisField(String str, int i, long j, String str2, String str3, Field field) {
        Class cls = Long.TYPE;
        super(str, i, j, str2, str3, cls, cls, field, null);
    }

    public long getFieldLong(T t) {
        if (t == null) {
            throw new JSONException("field.get error, " + this.fieldName);
        }
        try {
            long j = this.fieldOffset;
            return j != -1 ? JDKUtils.UNSAFE.getLong(t, j) : this.field.getLong(t);
        } catch (IllegalAccessException e) {
            e = e;
            throw new JSONException("field.get error, " + this.fieldName, e);
        } catch (IllegalArgumentException e2) {
            e = e2;
            throw new JSONException("field.get error, " + this.fieldName, e);
        }
    }

    @Override // com.alibaba.fastjson2.writer.FieldWriter
    public Object getFieldValue(T t) {
        return Long.valueOf(getFieldLong(t));
    }

    @Override // com.alibaba.fastjson2.writer.FieldWriter
    public boolean write(JSONWriter jSONWriter, T t) {
        writeDate(jSONWriter, getFieldLong(t));
        return true;
    }

    @Override // com.alibaba.fastjson2.writer.FieldWriter
    public void writeValue(JSONWriter jSONWriter, T t) {
        writeDate(jSONWriter, false, getFieldLong(t));
    }
}
