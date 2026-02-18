package com.alibaba.fastjson2.writer;

import com.alibaba.fastjson2.JSONWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
final class FieldWriterBigDecimalFunc<T> extends FieldWriter<T> {
    final Function<T, BigDecimal> function;

    public FieldWriterBigDecimalFunc(String str, int i, long j, String str2, String str3, Field field, Method method, Function<T, BigDecimal> function) {
        super(str, i, j, str2, null, str3, BigDecimal.class, BigDecimal.class, null, method);
        this.function = function;
    }

    @Override // com.alibaba.fastjson2.writer.FieldWriter
    public Object getFieldValue(T t) {
        return this.function.apply(t);
    }

    @Override // com.alibaba.fastjson2.writer.FieldWriter
    public Function getFunction() {
        return this.function;
    }

    @Override // com.alibaba.fastjson2.writer.FieldWriter
    public boolean write(JSONWriter jSONWriter, T t) {
        try {
            BigDecimal bigDecimalApply = this.function.apply(t);
            if (bigDecimalApply == null) {
                return writeFloatNull(jSONWriter);
            }
            writeFieldName(jSONWriter);
            jSONWriter.writeDecimal(bigDecimalApply, this.features, this.decimalFormat);
            return true;
        } catch (RuntimeException e) {
            if (jSONWriter.isIgnoreErrorGetter()) {
                return false;
            }
            throw e;
        }
    }

    @Override // com.alibaba.fastjson2.writer.FieldWriter
    public void writeValue(JSONWriter jSONWriter, T t) {
        jSONWriter.writeDecimal(this.function.apply(t), this.features, this.decimalFormat);
    }
}
