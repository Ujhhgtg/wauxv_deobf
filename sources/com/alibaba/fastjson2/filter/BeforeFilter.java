package com.alibaba.fastjson2.filter;

import com.alibaba.fastjson2.JSONWriter;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class BeforeFilter implements Filter {
    private static final ThreadLocal<JSONWriter> serializerLocal = new ThreadLocal<>();

    public void writeBefore(JSONWriter jSONWriter, Object obj) {
        ThreadLocal<JSONWriter> threadLocal = serializerLocal;
        JSONWriter jSONWriter2 = threadLocal.get();
        threadLocal.set(jSONWriter);
        writeBefore(obj);
        threadLocal.set(jSONWriter2);
    }

    public abstract void writeBefore(Object obj);

    public final void writeKeyValue(String str, Object obj) {
        JSONWriter jSONWriter = serializerLocal.get();
        boolean zContainsReference = jSONWriter.containsReference(obj);
        jSONWriter.writeName(str);
        jSONWriter.writeColon();
        jSONWriter.writeAny(obj);
        if (zContainsReference) {
            return;
        }
        jSONWriter.removeReference(obj);
    }
}
