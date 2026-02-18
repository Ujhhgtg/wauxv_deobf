package com.alibaba.fastjson2.reader;

import com.alibaba.fastjson2.JSONException;
import com.alibaba.fastjson2.schema.JSONSchema;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicReference;
import me.hd.wauxv.obf.yg;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
final class FieldReaderAtomicReferenceMethodReadOnly<T> extends FieldReaderAtomicReference<T> {
    public FieldReaderAtomicReferenceMethodReadOnly(String str, Type type, Class cls, int i, JSONSchema jSONSchema, Method method) {
        super(str, type, cls, i, 0L, null, jSONSchema, method, null);
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public void accept(T t, Object obj) {
        if (obj == null) {
            return;
        }
        try {
            ((AtomicReference) this.method.invoke(t, null)).set(obj);
        } catch (Exception e) {
            throw new JSONException(yg.o(new StringBuilder("set "), this.fieldName, " error"), e);
        }
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public boolean isReadOnly() {
        return true;
    }
}
