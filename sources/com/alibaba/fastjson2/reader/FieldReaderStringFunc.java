package com.alibaba.fastjson2.reader;

import com.alibaba.fastjson2.JSONException;
import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.schema.JSONSchema;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.function.BiConsumer;
import me.hd.wauxv.obf.yg;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
final class FieldReaderStringFunc<T, V> extends FieldReader<T> {
    final String format;
    final BiConsumer<T, V> function;
    final boolean trim;
    final boolean upper;

    public FieldReaderStringFunc(String str, Class<V> cls, int i, long j, String str2, Locale locale, Object obj, JSONSchema jSONSchema, Method method, BiConsumer<T, V> biConsumer) {
        super(str, cls, cls, i, j, str2, locale, obj, jSONSchema, method, null);
        this.function = biConsumer;
        this.format = str2;
        this.trim = "trim".equals(str2) || (j & JSONReader.Feature.TrimString.mask) != 0;
        this.upper = "upper".equals(str2);
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public void accept(T t, int i) {
        accept(t, Integer.toString(i));
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public BiConsumer getFunction() {
        return this.function;
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public void readFieldValue(JSONReader jSONReader, T t) {
        String string = jSONReader.readString();
        if (string != null) {
            if (this.trim) {
                string = string.trim();
            }
            if (this.upper) {
                string = string.toUpperCase();
            }
        }
        JSONSchema jSONSchema = this.schema;
        if (jSONSchema != null) {
            jSONSchema.assertValidate(string);
        }
        this.function.accept(t, string);
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public boolean supportAcceptType(Class cls) {
        return true;
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public void accept(T t, long j) {
        accept(t, Long.toString(j));
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public void accept(T t, Object obj) {
        String upperCase;
        if (!(obj instanceof String) && obj != null) {
            upperCase = obj.toString();
        } else {
            upperCase = (String) obj;
        }
        if (upperCase != null) {
            if (this.trim) {
                upperCase = upperCase.trim();
            }
            if (this.upper) {
                upperCase = upperCase.toUpperCase();
            }
        }
        JSONSchema jSONSchema = this.schema;
        if (jSONSchema != null) {
            jSONSchema.assertValidate(upperCase);
        }
        try {
            this.function.accept(t, upperCase);
        } catch (Exception e) {
            throw new JSONException(yg.o(new StringBuilder("set "), super.toString(), " error"), e);
        }
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public Object readFieldValue(JSONReader jSONReader) {
        return jSONReader.readString();
    }
}
