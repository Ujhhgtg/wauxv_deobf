package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class aeu extends aet {
    public boolean h;

    public aeu(int i, boolean z) {
        this.b = i;
        this.h = z;
    }

    @Override // me.hd.wauxv.obf.aet
    public final byte a() {
        return (byte) 1;
    }

    @Override // me.hd.wauxv.obf.aet
    public final boolean c() {
        return this.h;
    }

    @Override // me.hd.wauxv.obf.aet
    public final float d() {
        return this.h ? 1.0f : 0.0f;
    }

    @Override // me.hd.wauxv.obf.aet
    public final int e() {
        return this.h ? 1 : 0;
    }

    @Override // me.hd.wauxv.obf.aet
    public final long f() {
        return this.h ? 1L : 0L;
    }

    @Override // me.hd.wauxv.obf.aet
    public final String g() {
        return this.h ? "true" : "false";
    }
}
