package com.alibaba.fastjson2.writer;

import com.alibaba.fastjson2.JSONWriter;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
final class ObjectWriterImplAtomicBoolean extends ObjectWriterPrimitiveImpl {
    static final ObjectWriterImplAtomicBoolean INSTANCE = new ObjectWriterImplAtomicBoolean();

    @Override // com.alibaba.fastjson2.writer.ObjectWriter
    public void write(JSONWriter jSONWriter, Object obj, Object obj2, Type type, long j) {
        if (obj == null) {
            jSONWriter.writeBooleanNull();
        } else {
            jSONWriter.writeBool(((AtomicBoolean) obj).get());
        }
    }
}
