package com.alibaba.fastjson2.writer;

import com.alibaba.fastjson2.JSONB;
import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.util.Fnv;
import java.lang.reflect.Type;
import java.text.DecimalFormat;
import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
final class ObjectWriterImplFloatValueArray extends ObjectWriterPrimitiveImpl {
    private final DecimalFormat format;
    private final Function<Object, float[]> function;
    static final ObjectWriterImplFloatValueArray INSTANCE = new ObjectWriterImplFloatValueArray(null, null);
    static final byte[] JSONB_TYPE_NAME_BYTES = JSONB.toBytes("[F");
    static final long JSONB_TYPE_HASH = Fnv.hashCode64("[F");

    public ObjectWriterImplFloatValueArray(DecimalFormat decimalFormat) {
        this.format = decimalFormat;
        this.function = null;
    }

    @Override // com.alibaba.fastjson2.writer.ObjectWriter
    public void write(JSONWriter jSONWriter, Object obj, Object obj2, Type type, long j) {
        Function<Object, float[]> function = this.function;
        float[] fArrApply = (function == null || obj == null) ? (float[]) obj : function.apply(obj);
        DecimalFormat decimalFormat = this.format;
        if (decimalFormat == null) {
            jSONWriter.writeFloat(fArrApply);
        } else {
            jSONWriter.writeFloat(fArrApply, decimalFormat);
        }
    }

    @Override // com.alibaba.fastjson2.writer.ObjectWriter
    public void writeJSONB(JSONWriter jSONWriter, Object obj, Object obj2, Type type, long j) {
        if (jSONWriter.isWriteTypeInfo(obj, type)) {
            jSONWriter.writeTypeName(JSONB_TYPE_NAME_BYTES, JSONB_TYPE_HASH);
        }
        Function<Object, float[]> function = this.function;
        jSONWriter.writeFloat((function == null || obj == null) ? (float[]) obj : function.apply(obj));
    }

    public ObjectWriterImplFloatValueArray(Function<Object, float[]> function, DecimalFormat decimalFormat) {
        this.function = function;
        this.format = decimalFormat;
    }
}
