package com.alibaba.fastjson2.writer;

import com.alibaba.fastjson2.JSONB;
import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.util.Fnv;
import java.lang.reflect.Type;
import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
class ObjectWriterImplBoolValueArray extends ObjectWriterPrimitiveImpl {
    private final Function<Object, boolean[]> function;
    static final ObjectWriterImplBoolValueArray INSTANCE = new ObjectWriterImplBoolValueArray(null);
    static final byte[] JSONB_TYPE_NAME_BYTES = JSONB.toBytes("[Z");
    static final long JSONB_TYPE_HASH = Fnv.hashCode64("[Z");

    public ObjectWriterImplBoolValueArray(Function<Object, boolean[]> function) {
        this.function = function;
    }

    @Override // com.alibaba.fastjson2.writer.ObjectWriter
    public void write(JSONWriter jSONWriter, Object obj, Object obj2, Type type, long j) {
        Function<Object, boolean[]> function = this.function;
        jSONWriter.writeBool((function == null || obj == null) ? (boolean[]) obj : function.apply(obj));
    }

    @Override // com.alibaba.fastjson2.writer.ObjectWriter
    public void writeJSONB(JSONWriter jSONWriter, Object obj, Object obj2, Type type, long j) {
        if (jSONWriter.isWriteTypeInfo(obj, type, j)) {
            jSONWriter.writeTypeName(JSONB_TYPE_NAME_BYTES, JSONB_TYPE_HASH);
        }
        Function<Object, boolean[]> function = this.function;
        jSONWriter.writeBool((function == null || obj == null) ? (boolean[]) obj : function.apply(obj));
    }
}
