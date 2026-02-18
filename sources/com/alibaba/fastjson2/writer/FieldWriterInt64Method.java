package com.alibaba.fastjson2.writer;

import com.alibaba.fastjson2.JSONException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
final class FieldWriterInt64Method<T> extends FieldWriterInt64<T> {
    public FieldWriterInt64Method(String str, int i, long j, String str2, String str3, Field field, Method method, Class cls) {
        super(str, i, j, str2, str3, cls, field, method);
    }

    @Override // com.alibaba.fastjson2.writer.FieldWriter
    public Object getFieldValue(T t) {
        try {
            return this.method.invoke(t, null);
        } catch (IllegalAccessException e) {
            e = e;
            throw new JSONException("invoke getter method error, " + this.fieldName, e);
        } catch (IllegalArgumentException e2) {
            e = e2;
            throw new JSONException("invoke getter method error, " + this.fieldName, e);
        } catch (InvocationTargetException e3) {
            e = e3;
            Throwable cause = e.getCause();
            String str = "invoke getter method error, " + this.fieldName;
            if (cause != null) {
                e = cause;
            }
            throw new JSONException(str, e);
        }
    }
}
