package com.alibaba.fastjson2.reader;

import com.alibaba.fastjson2.JSONException;
import com.alibaba.fastjson2.schema.JSONSchema;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicReference;
import me.hd.wauxv.obf.yg;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
final class FieldReaderAtomicReferenceField<T> extends FieldReaderAtomicReference<T> {
    final boolean readOnly;

    public FieldReaderAtomicReferenceField(String str, Type type, Class cls, int i, String str2, JSONSchema jSONSchema, Field field) {
        super(str, type, cls, i, 0L, str2, jSONSchema, null, field);
        this.readOnly = Modifier.isFinal(field.getModifiers());
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public void accept(T t, Object obj) {
        if (obj == null) {
            return;
        }
        try {
            if (this.readOnly) {
                ((AtomicReference) this.field.get(t)).set(obj);
            } else {
                this.field.set(t, new AtomicReference(obj));
            }
        } catch (Exception e) {
            throw new JSONException(yg.o(new StringBuilder("set "), this.fieldName, " error"), e);
        }
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public boolean isReadOnly() {
        return true;
    }
}
