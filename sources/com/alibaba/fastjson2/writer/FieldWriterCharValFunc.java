package com.alibaba.fastjson2.writer;

import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.function.ToCharFunction;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
final class FieldWriterCharValFunc extends FieldWriter {
    final ToCharFunction function;

    /* JADX WARN: Illegal instructions before constructor call */
    public FieldWriterCharValFunc(String str, int i, long j, String str2, String str3, Field field, Method method, ToCharFunction toCharFunction) {
        Class cls = Character.TYPE;
        super(str, i, j, str2, null, str3, cls, cls, field, method);
        this.function = toCharFunction;
    }

    @Override // com.alibaba.fastjson2.writer.FieldWriter
    public Object getFieldValue(Object obj) {
        return Character.valueOf(this.function.applyAsChar(obj));
    }

    @Override // com.alibaba.fastjson2.writer.FieldWriter
    public boolean write(JSONWriter jSONWriter, Object obj) {
        char cApplyAsChar = this.function.applyAsChar(obj);
        writeFieldName(jSONWriter);
        jSONWriter.writeChar(cApplyAsChar);
        return true;
    }

    @Override // com.alibaba.fastjson2.writer.FieldWriter
    public void writeValue(JSONWriter jSONWriter, Object obj) {
        jSONWriter.writeChar(this.function.applyAsChar(obj));
    }
}
