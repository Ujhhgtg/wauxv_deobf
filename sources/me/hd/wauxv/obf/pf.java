package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class pf {
    public int a;
    public int b;
    public boolean c;

    public pf(int i, int i2, boolean z) {
        this.a = i;
        this.b = i2;
        this.c = z;
    }

    public static pf d(int i) {
        return new pf(i, -1, false);
    }

    public boolean e() {
        boolean z = this.c || (this.a >= 0 && this.b >= 0);
        this.c = false;
        return z;
    }
}
