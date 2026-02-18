package com.alibaba.fastjson2.reader;

import com.alibaba.fastjson2.schema.JSONSchema;
import com.alibaba.fastjson2.util.JDKUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
final class FieldReaderListField<T> extends FieldReaderList<T, Object> {
    public FieldReaderListField(String str, Type type, Class cls, Type type2, Class cls2, int i, long j, String str2, Locale locale, Collection collection, JSONSchema jSONSchema, Field field) {
        super(str, type, cls, type2, cls2, i, j, str2, locale, collection, jSONSchema, null, field, null);
    }

    @Override // com.alibaba.fastjson2.reader.FieldReaderObject, com.alibaba.fastjson2.reader.FieldReader
    public void accept(Object obj, Object obj2) {
        JSONSchema jSONSchema = this.schema;
        if (jSONSchema != null) {
            jSONSchema.assertValidate(obj2);
        }
        JDKUtils.UNSAFE.putObject(obj, this.fieldOffset, obj2);
    }
}
