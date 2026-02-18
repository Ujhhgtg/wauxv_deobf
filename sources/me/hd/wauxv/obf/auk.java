package me.hd.wauxv.obf;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class auk {
    public int a = 1;
    public final cdd b;
    public cdd c;
    public cdd d;
    public int e;
    public int f;

    public auk(cdd cddVar) {
        this.b = cddVar;
        this.c = cddVar;
    }

    public final void g() {
        this.a = 1;
        this.c = this.b;
        this.f = 0;
    }

    public final boolean h() {
        cdb cdbVarF = this.c.b.f();
        int iF = cdbVarF.f(6);
        return !(iF == 0 || ((ByteBuffer) cdbVarF.e).get(iF + cdbVarF.b) == 0) || this.e == 65039;
    }
}
