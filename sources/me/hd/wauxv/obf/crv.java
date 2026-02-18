package me.hd.wauxv.obf;

import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class crv extends ac implements RandomAccess {
    public final sj[] b;
    public final int[] c;

    public crv(sj[] sjVarArr, int[] iArr) {
        this.b = sjVarArr;
        this.c = iArr;
    }

    @Override // me.hd.wauxv.obf.r
    public final int a() {
        return this.b.length;
    }

    @Override // me.hd.wauxv.obf.r, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof sj) {
            return super.contains((sj) obj);
        }
        return false;
    }

    @Override // java.util.List
    public final Object get(int i) {
        return this.b[i];
    }

    @Override // me.hd.wauxv.obf.ac, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof sj) {
            return super.indexOf((sj) obj);
        }
        return -1;
    }

    @Override // me.hd.wauxv.obf.ac, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof sj) {
            return super.lastIndexOf((sj) obj);
        }
        return -1;
    }
}
