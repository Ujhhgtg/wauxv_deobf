package com.alibaba.fastjson2.reader;

import com.alibaba.fastjson2.JSONException;
import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.schema.JSONSchema;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
final class FieldReaderCharValueField<T> extends FieldReaderObjectField<T> {
    /* JADX WARN: Illegal instructions before constructor call */
    public FieldReaderCharValueField(String str, int i, long j, String str2, Character ch, JSONSchema jSONSchema, Field field) {
        Class cls = Character.TYPE;
        super(str, cls, cls, i, j, str2, null, ch, jSONSchema, field);
    }

    @Override // com.alibaba.fastjson2.reader.FieldReaderObjectField, com.alibaba.fastjson2.reader.FieldReaderObject, com.alibaba.fastjson2.reader.FieldReader
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

    @Override // com.alibaba.fastjson2.reader.FieldReaderObject, com.alibaba.fastjson2.reader.FieldReader
    public void readFieldValue(JSONReader jSONReader, T t) {
        char charValue = jSONReader.readCharValue();
        if (charValue == 0 && jSONReader.wasNull()) {
            return;
        }
        accept((Object) t, charValue);
    }

    @Override // com.alibaba.fastjson2.reader.FieldReaderObject, com.alibaba.fastjson2.reader.FieldReader
    public Object readFieldValue(JSONReader jSONReader) {
        String string = jSONReader.readString();
        char cCharAt = 0;
        if (string != null && !string.isEmpty()) {
            cCharAt = string.charAt(0);
        }
        return Character.valueOf(cCharAt);
    }
}
