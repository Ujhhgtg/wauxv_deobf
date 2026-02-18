package com.android.dx.rop.cst;

import com.android.dx.util.ToHuman;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Constant implements ToHuman, Comparable<Constant> {
    public abstract int compareTo0(Constant constant);

    public abstract boolean isCategory2();

    public abstract String typeName();

    @Override // java.lang.Comparable
    public final int compareTo(Constant constant) {
        Class<?> cls = getClass();
        Class<?> cls2 = constant.getClass();
        return cls != cls2 ? cls.getName().compareTo(cls2.getName()) : compareTo0(constant);
    }
}
