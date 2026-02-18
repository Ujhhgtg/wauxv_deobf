package com.alibaba.fastjson2.reader;

import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.schema.JSONSchema;
import com.alibaba.fastjson2.util.TypeUtils;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.function.BiConsumer;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
final class FieldReaderBoolFunc<T, V> extends FieldReader<T> {
    final BiConsumer<T, V> function;

    public FieldReaderBoolFunc(String str, Class<V> cls, int i, long j, String str2, Locale locale, Object obj, JSONSchema jSONSchema, Method method, BiConsumer<T, V> biConsumer) {
        super(str, cls, cls, i, j, str2, locale, obj, jSONSchema, method, null);
        this.function = biConsumer;
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public void accept(T t, Object obj) {
        Boolean bool = TypeUtils.toBoolean(obj);
        JSONSchema jSONSchema = this.schema;
        if (jSONSchema != null) {
            jSONSchema.validate(bool);
        }
        this.function.accept(t, bool);
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public BiConsumer getFunction() {
        return this.function;
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public void readFieldValue(JSONReader jSONReader, T t) throws Exception {
        Boolean bool;
        try {
            bool = jSONReader.readBool();
        } catch (Exception e) {
            if ((jSONReader.features(this.features) & JSONReader.Feature.NullOnError.mask) == 0) {
                throw e;
            }
            bool = null;
        }
        JSONSchema jSONSchema = this.schema;
        if (jSONSchema != null) {
            jSONSchema.validate(bool);
        }
        this.function.accept(t, bool);
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public Object readFieldValue(JSONReader jSONReader) {
        return jSONReader.readBool();
    }
}
