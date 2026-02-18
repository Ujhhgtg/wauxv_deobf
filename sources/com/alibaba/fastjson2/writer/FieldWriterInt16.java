package com.alibaba.fastjson2.writer;

import com.alibaba.fastjson2.JSONWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
abstract class FieldWriterInt16<T> extends FieldWriter<T> {
    public FieldWriterInt16(String str, int i, long j, String str2, String str3, Class cls, Field field, Method method) {
        super(str, i, j, str2, null, str3, cls, cls, field, method);
    }

    @Override // com.alibaba.fastjson2.writer.FieldWriter
    public ObjectWriter getObjectWriter(JSONWriter jSONWriter, Class cls) {
        return cls == this.fieldClass ? ObjectWriterImplInt16.INSTANCE : jSONWriter.getObjectWriter(cls);
    }

    @Override // com.alibaba.fastjson2.writer.FieldWriter
    public boolean write(JSONWriter jSONWriter, T t) {
        try {
            Short sh = (Short) getFieldValue(t);
            if (sh == null) {
                return writeIntNull(jSONWriter);
            }
            writeInt16(jSONWriter, sh.shortValue());
            return true;
        } catch (RuntimeException e) {
            if (jSONWriter.isIgnoreErrorGetter()) {
                return false;
            }
            throw e;
        }
    }

    public final void writeInt16(JSONWriter jSONWriter, short s) {
        if ((jSONWriter.getFeatures(this.features) & JSONWriter.Feature.WriteNonStringValueAsString.mask) != 0) {
            writeFieldName(jSONWriter);
            jSONWriter.writeString(Short.toString(s));
        } else {
            writeFieldName(jSONWriter);
            jSONWriter.writeInt16(s);
        }
    }

    @Override // com.alibaba.fastjson2.writer.FieldWriter
    public void writeValue(JSONWriter jSONWriter, T t) {
        Short sh = (Short) getFieldValue(t);
        if (sh == null) {
            jSONWriter.writeNumberNull();
        } else {
            jSONWriter.writeInt32(sh.shortValue());
        }
    }
}
