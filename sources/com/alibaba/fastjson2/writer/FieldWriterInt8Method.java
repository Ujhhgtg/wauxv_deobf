package com.alibaba.fastjson2.writer;

import com.alibaba.fastjson2.JSONException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
final class FieldWriterInt8Method extends FieldWriterInt8 {
    public FieldWriterInt8Method(String str, int i, long j, String str2, String str3, Field field, Method method, Class cls) {
        super(str, i, j, str2, str3, cls, field, method);
    }

    @Override // com.alibaba.fastjson2.writer.FieldWriter
    public Object getFieldValue(Object obj) {
        try {
            return this.method.invoke(obj, null);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            throw new JSONException("invoke getter method error, " + this.fieldName, e);
        }
    }
}
