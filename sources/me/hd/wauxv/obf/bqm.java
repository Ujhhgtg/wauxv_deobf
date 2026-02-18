package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bqm extends din {
    public final String a;

    public bqm(String str, int i) {
        super(i);
        this.a = str;
    }

    @Override // me.hd.wauxv.obf.din
    public final din b() {
        int i = this.c;
        bqm bqmVar = new bqm(this.a, i);
        int i2 = this.d;
        bqmVar.c = i;
        bqmVar.d = i2;
        return bqmVar;
    }

    public final Object clone() {
        int i = this.c;
        bqm bqmVar = new bqm(this.a, i);
        int i2 = this.d;
        bqmVar.c = i;
        bqmVar.d = i2;
        return bqmVar;
    }
}
