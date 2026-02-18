package me.hd.wauxv.obf;

import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ayg extends dee {
    public final HashMap a = new HashMap();

    @Override // me.hd.wauxv.obf.dee
    public final deb b(Object obj) {
        return (deb) this.a.get(obj);
    }

    @Override // me.hd.wauxv.obf.dee
    public final Object c(Object obj) {
        Object objC = super.c(obj);
        this.a.remove(obj);
        return objC;
    }
}
