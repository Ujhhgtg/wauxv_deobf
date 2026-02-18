package com.alibaba.fastjson2.reader;

import com.alibaba.fastjson2.JSONException;
import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.schema.JSONSchema;
import com.alibaba.fastjson2.util.TypeUtils;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.Locale;
import java.util.function.BiConsumer;
import me.hd.wauxv.obf.yg;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
final class FieldReaderBigIntegerFunc<T, V> extends FieldReader<T> {
    final BiConsumer<T, V> function;

    public FieldReaderBigIntegerFunc(String str, Class<V> cls, int i, long j, String str2, Locale locale, Object obj, JSONSchema jSONSchema, Method method, BiConsumer<T, V> biConsumer) {
        super(str, cls, cls, i, j, str2, locale, obj, jSONSchema, method, null);
        this.function = biConsumer;
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public void accept(T t, Object obj) {
        BigInteger bigInteger = TypeUtils.toBigInteger(obj);
        JSONSchema jSONSchema = this.schema;
        if (jSONSchema != null) {
            jSONSchema.assertValidate(bigInteger);
        }
        try {
            this.function.accept(t, bigInteger);
        } catch (Exception e) {
            throw new JSONException(yg.o(new StringBuilder("set "), super.toString(), " error"), e);
        }
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public BiConsumer getFunction() {
        return this.function;
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public void readFieldValue(JSONReader jSONReader, T t) throws Exception {
        BigInteger bigInteger;
        try {
            bigInteger = jSONReader.readBigInteger();
        } catch (Exception e) {
            if ((jSONReader.features(this.features) & JSONReader.Feature.NullOnError.mask) == 0) {
                throw e;
            }
            bigInteger = null;
        }
        JSONSchema jSONSchema = this.schema;
        if (jSONSchema != null) {
            jSONSchema.assertValidate(bigInteger);
        }
        this.function.accept(t, bigInteger);
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public Object readFieldValue(JSONReader jSONReader) {
        return jSONReader.readBigInteger();
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public void accept(T t, int i) {
        JSONSchema jSONSchema = this.schema;
        if (jSONSchema != null) {
            jSONSchema.assertValidate(i);
        }
        try {
            this.function.accept(t, BigInteger.valueOf(i));
        } catch (Exception e) {
            throw new JSONException(yg.o(new StringBuilder("set "), super.toString(), " error"), e);
        }
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public void accept(T t, long j) {
        JSONSchema jSONSchema = this.schema;
        if (jSONSchema != null) {
            jSONSchema.assertValidate(j);
        }
        try {
            this.function.accept(t, BigInteger.valueOf(j));
        } catch (Exception e) {
            throw new JSONException(yg.o(new StringBuilder("set "), super.toString(), " error"), e);
        }
    }
}
