package me.hd.wauxv.obf;

import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ab extends ac implements RandomAccess {
    public final ac b;
    public final int c;
    public final int d;

    public ab(ac acVar, int i, int i2) {
        this.b = acVar;
        this.c = i;
        cnh.l(i, i2, acVar.a());
        this.d = i2 - i;
    }

    @Override // me.hd.wauxv.obf.r
    public final int a() {
        return this.d;
    }

    @Override // java.util.List
    public final Object get(int i) {
        int i2 = this.d;
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException(dkz.p(i, "index: ", ", size: ", i2));
        }
        return this.b.get(this.c + i);
    }

    @Override // me.hd.wauxv.obf.ac, java.util.List
    public final List subList(int i, int i2) {
        cnh.l(i, i2, this.d);
        int i3 = this.c;
        return new ab(this.b, i + i3, i3 + i2);
    }
}
