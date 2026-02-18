package com.alibaba.fastjson2.writer;

import com.alibaba.fastjson2.JSONB;
import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.util.Fnv;
import java.lang.reflect.Type;
import java.text.DecimalFormat;
import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
final class ObjectWriterImplDoubleValueArray extends ObjectWriterPrimitiveImpl {
    final DecimalFormat format;
    private final Function<Object, double[]> function;
    static final ObjectWriterImplDoubleValueArray INSTANCE = new ObjectWriterImplDoubleValueArray(null);
    static final byte[] JSONB_TYPE_NAME_BYTES = JSONB.toBytes("[D");
    static final long JSONB_TYPE_HASH = Fnv.hashCode64("[D");

    public ObjectWriterImplDoubleValueArray(DecimalFormat decimalFormat) {
        this.format = decimalFormat;
        this.function = null;
    }

    @Override // com.alibaba.fastjson2.writer.ObjectWriter
    public void write(JSONWriter jSONWriter, Object obj, Object obj2, Type type, long j) {
        Function<Object, double[]> function = this.function;
        double[] dArrApply = (function == null || obj == null) ? (double[]) obj : function.apply(obj);
        DecimalFormat decimalFormat = this.format;
        if (decimalFormat == null) {
            jSONWriter.writeDouble(dArrApply);
        } else {
            jSONWriter.writeDouble(dArrApply, decimalFormat);
        }
    }

    @Override // com.alibaba.fastjson2.writer.ObjectWriter
    public void writeJSONB(JSONWriter jSONWriter, Object obj, Object obj2, Type type, long j) {
        if (jSONWriter.isWriteTypeInfo(obj, type)) {
            jSONWriter.writeTypeName(JSONB_TYPE_NAME_BYTES, JSONB_TYPE_HASH);
        }
        Function<Object, double[]> function = this.function;
        jSONWriter.writeDouble((function == null || obj == null) ? (double[]) obj : function.apply(obj));
    }

    public ObjectWriterImplDoubleValueArray(Function<Object, double[]> function, DecimalFormat decimalFormat) {
        this.function = function;
        this.format = decimalFormat;
    }
}
