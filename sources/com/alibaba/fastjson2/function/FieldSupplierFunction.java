package com.alibaba.fastjson2.function;

import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class FieldSupplierFunction<T> implements Function<T, Object> {
    public final int fieldIndex;
    public final FieldSupplier<T> supplier;

    public FieldSupplierFunction(FieldSupplier<T> fieldSupplier, int i) {
        this.supplier = fieldSupplier;
        this.fieldIndex = i;
    }

    @Override // java.util.function.Function
    public Object apply(T t) {
        return this.supplier.get(t, this.fieldIndex);
    }
}
