package me.hd.wauxv.obf;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bae implements dft {
    public final dft a;
    public final boolean b;
    public final bgf c;

    public bae(dft dftVar, boolean z, bgf bgfVar) {
        this.a = dftVar;
        this.b = z;
        this.c = bgfVar;
    }

    @Override // me.hd.wauxv.obf.dft
    public final Iterator iterator() {
        return new baa(this);
    }
}
