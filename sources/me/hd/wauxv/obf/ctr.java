package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ctr extends din {
    public ctq a;

    public ctr(ctq ctqVar, int i) {
        super(0);
        this.c = i;
        this.d = i;
        this.a = ctqVar;
    }

    @Override // me.hd.wauxv.obf.din
    public final din b() {
        ctq ctqVar = this.a;
        int i = this.c;
        int i2 = this.d;
        ctr ctrVar = new ctr(0);
        ctrVar.c = i;
        ctrVar.d = i2;
        ctrVar.a = ctqVar;
        return ctrVar;
    }

    public final Object clone() {
        ctq ctqVar = this.a;
        int i = this.c;
        int i2 = this.d;
        ctr ctrVar = new ctr(0);
        ctrVar.c = i;
        ctrVar.d = i2;
        ctrVar.a = ctqVar;
        return ctrVar;
    }
}
