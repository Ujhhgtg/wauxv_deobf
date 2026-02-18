package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class aew extends aet {
    public float h;

    public aew(int i, float f) {
        this.b = i;
        this.h = f;
    }

    @Override // me.hd.wauxv.obf.aet
    public final byte a() {
        return (byte) 3;
    }

    @Override // me.hd.wauxv.obf.aet
    public final boolean c() {
        return this.h != 0.0f;
    }

    @Override // me.hd.wauxv.obf.aet
    public final float d() {
        return this.h;
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
