package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class anu implements bnh {
    public final long[] a;
    public final int b;

    public anu(long[] jArr, int i) {
        this.a = jArr;
        this.b = i;
    }

    @Override // me.hd.wauxv.obf.bnh
    public final int c() {
        return this.a.length;
    }

    @Override // me.hd.wauxv.obf.bnh
    public final int d(int i) {
        return (int) (this.a[i] >> 32);
    }

    @Override // me.hd.wauxv.obf.bnh
    public final int e(int i) {
        return i == this.a.length + (-1) ? this.b : d(i + 1);
    }

    @Override // me.hd.wauxv.obf.bnh
    public final boolean f(int i) {
        return (((int) (this.a[i] & 4294967295L)) & 1) == 1;
    }
}
