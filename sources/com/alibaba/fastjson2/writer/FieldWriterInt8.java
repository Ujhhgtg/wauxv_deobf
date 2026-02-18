package com.alibaba.fastjson2.writer;

import com.alibaba.fastjson2.JSONWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
abstract class FieldWriterInt8<T> extends FieldWriter<T> {
    public FieldWriterInt8(String str, int i, long j, String str2, String str3, Class cls, Field field, Method method) {
        super(str, i, j, str2, null, str3, cls, cls, field, method);
    }

    @Override // com.alibaba.fastjson2.writer.FieldWriter
    public boolean write(JSONWriter jSONWriter, T t) {
        try {
            Byte b = (Byte) getFieldValue(t);
            if (b == null) {
                return writeIntNull(jSONWriter);
            }
            writeInt8(jSONWriter, b.byteValue());
            return true;
        } catch (RuntimeException e) {
            if (jSONWriter.isIgnoreErrorGetter()) {
                return false;
            }
            throw e;
        }
    }

    public final void writeInt8(JSONWriter jSONWriter, byte b) {
        if ((this.features & JSONWriter.Feature.WriteNonStringValueAsString.mask) != 0) {
            writeFieldName(jSONWriter);
            jSONWriter.writeString(Byte.toString(b));
        } else {
            writeFieldName(jSONWriter);
            jSONWriter.writeInt8(b);
        }
    }

    @Override // com.alibaba.fastjson2.writer.FieldWriter
    public void writeValue(JSONWriter jSONWriter, T t) {
        Byte b = (Byte) getFieldValue(t);
        if (b == null) {
            jSONWriter.writeNumberNull();
        } else {
            jSONWriter.writeInt32(b.byteValue());
        }
    }
}
