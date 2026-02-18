package com.alibaba.fastjson2.reader;

import com.alibaba.fastjson2.JSONException;
import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.function.ObjCharConsumer;
import com.alibaba.fastjson2.schema.JSONSchema;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
final class FieldReaderCharValueFunc<T> extends FieldReader<T> {
    final ObjCharConsumer<T> function;

    /* JADX WARN: Illegal instructions before constructor call */
    public FieldReaderCharValueFunc(String str, int i, String str2, Character ch, JSONSchema jSONSchema, Method method, ObjCharConsumer<T> objCharConsumer) {
        Class cls = Character.TYPE;
        super(str, cls, cls, i, 0L, str2, null, ch, jSONSchema, method, null);
        this.function = objCharConsumer;
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public void accept(T t, char c) {
        this.function.accept(t, c);
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public void accept(T t, Object obj) {
        char cCharValue;
        if (obj instanceof String) {
            cCharValue = ((String) obj).charAt(0);
        } else {
            if (!(obj instanceof Character)) {
                throw new JSONException("cast to char error");
            }
            cCharValue = ((Character) obj).charValue();
        }
        accept((Object) t, cCharValue);
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public void readFieldValue(JSONReader jSONReader, T t) {
        char charValue = jSONReader.readCharValue();
        if (charValue == 0 && jSONReader.wasNull()) {
            return;
        }
        this.function.accept(t, charValue);
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public String readFieldValue(JSONReader jSONReader) {
        return jSONReader.readString();
    }
}
