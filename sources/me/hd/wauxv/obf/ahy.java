package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ahy {
    public final aff a;
    public final sq b;
    public ud c;
    public ud d;
    public ud e;
    public ud f;
    public ud g;

    public ahy(aff affVar) {
        this.a = affVar;
        this.b = new sq(affVar);
        ud udVar = new ud();
        udVar.c = 0;
        udVar.b = 0;
        udVar.a = 0;
        this.c = udVar;
        ud udVar2 = new ud();
        udVar2.c = 0;
        udVar2.b = 0;
        udVar2.a = 0;
        this.d = udVar2;
    }

    public final boolean h() {
        return this.c.a != this.d.a;
    }
}
