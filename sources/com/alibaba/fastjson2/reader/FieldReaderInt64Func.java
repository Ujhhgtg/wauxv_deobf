package com.alibaba.fastjson2.reader;

import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.schema.JSONSchema;
import com.alibaba.fastjson2.util.TypeUtils;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.function.BiConsumer;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
final class FieldReaderInt64Func<T, V> extends FieldReader<T> {
    final BiConsumer<T, V> function;

    public FieldReaderInt64Func(String str, Class<V> cls, int i, long j, String str2, Locale locale, Object obj, JSONSchema jSONSchema, Method method, BiConsumer<T, V> biConsumer) {
        super(str, cls, cls, i, j, str2, locale, obj, jSONSchema, method, null);
        this.function = biConsumer;
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public void accept(T t, Object obj) {
        Long l = TypeUtils.toLong(obj);
        JSONSchema jSONSchema = this.schema;
        if (jSONSchema != null) {
            jSONSchema.assertValidate(l);
        }
        this.function.accept(t, l);
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public BiConsumer getFunction() {
        return this.function;
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public void readFieldValue(JSONReader jSONReader, T t) throws Exception {
        Long int64;
        try {
            int64 = jSONReader.readInt64();
        } catch (Exception e) {
            if ((jSONReader.features(this.features) & JSONReader.Feature.NullOnError.mask) == 0) {
                throw e;
            }
            int64 = null;
        }
        JSONSchema jSONSchema = this.schema;
        if (jSONSchema != null) {
            jSONSchema.assertValidate(int64);
        }
        this.function.accept(t, int64);
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public Object readFieldValue(JSONReader jSONReader) {
        return jSONReader.readInt64();
    }
}
