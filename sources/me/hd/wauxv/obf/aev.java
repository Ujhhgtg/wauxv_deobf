package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class aev extends aet {
    public double h;

    public aev(int i, double d) {
        this.b = i;
        this.h = d;
    }

    @Override // me.hd.wauxv.obf.aet
    public final byte a() {
        return (byte) 5;
    }

    @Override // me.hd.wauxv.obf.aet
    public final boolean c() {
        return this.h != 0.0d;
    }

    @Override // me.hd.wauxv.obf.aet
    public final float d() {
        return (float) this.h;
    }

    @Override // me.hd.wauxv.obf.aet
    public final int e() {
        return (int) this.h;
    }

    @Override // me.hd.wauxv.obf.aet
    public final long f() {
        return (long) this.h;
    }

    @Override // me.hd.wauxv.obf.aet
    public final String g() {
        return String.valueOf(this.h);
    }
}
