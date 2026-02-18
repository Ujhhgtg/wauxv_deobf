package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ctt extends din {
    public String a;

    public ctt(String str, int i, int i2) {
        super(0);
        this.c = i;
        this.d = i2;
        this.a = str;
    }

    @Override // me.hd.wauxv.obf.din
    public final din b() {
        return new ctt(this.a, this.c, this.d);
    }

    public final Object clone() {
        return new ctt(this.a, this.c, this.d);
    }
}
