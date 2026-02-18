package com.alibaba.fastjson2.writer;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
final class FieldWriterBooleanFunc extends FieldWriterBoolean {
    final Function function;

    public FieldWriterBooleanFunc(String str, int i, long j, String str2, String str3, Field field, Method method, Function function) {
        super(str, i, j, str2, str3, Boolean.class, Boolean.class, field, method);
        this.function = function;
    }

    @Override // com.alibaba.fastjson2.writer.FieldWriter
    public Object getFieldValue(Object obj) {
        return this.function.apply(obj);
    }

    @Override // com.alibaba.fastjson2.writer.FieldWriter
    public Function getFunction() {
        return this.function;
    }
}
