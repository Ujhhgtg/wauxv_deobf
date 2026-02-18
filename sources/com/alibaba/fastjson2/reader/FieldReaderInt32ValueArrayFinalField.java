package com.alibaba.fastjson2.reader;

import com.alibaba.fastjson2.JSONException;
import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.schema.JSONSchema;
import java.lang.reflect.Field;
import me.hd.wauxv.obf.yg;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
final class FieldReaderInt32ValueArrayFinalField<T> extends FieldReaderObjectField<T> {
    public FieldReaderInt32ValueArrayFinalField(String str, Class cls, int i, long j, String str2, int[] iArr, JSONSchema jSONSchema, Field field) {
        super(str, cls, cls, i, j, str2, null, iArr, jSONSchema, field);
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public boolean isReadOnly() {
        return true;
    }

    @Override // com.alibaba.fastjson2.reader.FieldReaderObject, com.alibaba.fastjson2.reader.FieldReader
    public void readFieldValue(JSONReader jSONReader, T t) {
        if (jSONReader.readIfNull()) {
            return;
        }
        try {
            int[] iArr = (int[]) this.field.get(t);
            if (jSONReader.nextIfArrayStart()) {
                int i = 0;
                while (!jSONReader.nextIfArrayEnd()) {
                    int int32Value = jSONReader.readInt32Value();
                    if (iArr != null && i < iArr.length) {
                        iArr[i] = int32Value;
                    }
                    i++;
                }
            }
        } catch (Exception e) {
            throw new JSONException(yg.p(new StringBuilder("set "), this.fieldName, " error", jSONReader), e);
        }
    }
}
