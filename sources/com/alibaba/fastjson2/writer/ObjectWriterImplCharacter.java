package com.alibaba.fastjson2.writer;

import com.alibaba.fastjson2.JSONWriter;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
final class ObjectWriterImplCharacter extends ObjectWriterPrimitiveImpl {
    static final ObjectWriterImplCharacter INSTANCE = new ObjectWriterImplCharacter();

    @Override // com.alibaba.fastjson2.writer.ObjectWriter
    public void write(JSONWriter jSONWriter, Object obj, Object obj2, Type type, long j) {
        if (obj == null) {
            jSONWriter.writeNumberNull();
        } else {
            jSONWriter.writeChar(((Character) obj).charValue());
        }
    }

    @Override // com.alibaba.fastjson2.writer.ObjectWriter
    public void writeJSONB(JSONWriter jSONWriter, Object obj, Object obj2, Type type, long j) {
        if (obj == null) {
            jSONWriter.writeNumberNull();
        } else {
            jSONWriter.writeChar(((Character) obj).charValue());
        }
    }
}
