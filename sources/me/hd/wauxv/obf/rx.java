package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class rx extends cvl {
    public static final rx j = new rx(si.b);

    @Override // me.hd.wauxv.obf.s
    public final int e(Object obj) {
        byte[] bArr = (byte[]) obj;
        bzo.q(bArr, "<this>");
        return bArr.length;
    }

    @Override // me.hd.wauxv.obf.aax, me.hd.wauxv.obf.s
    public final void g(acm acmVar, int i, Object obj) {
        rt rtVar = (rt) obj;
        bzo.q(rtVar, "builder");
        byte bK = acmVar.k(this.o, i);
        rtVar.d(rtVar.e() + 1);
        byte[] bArr = rtVar.a;
        int i2 = rtVar.b;
        rtVar.b = i2 + 1;
        bArr[i2] = bK;
    }

    @Override // me.hd.wauxv.obf.s
    public final Object h(Object obj) {
        byte[] bArr = (byte[]) obj;
        bzo.q(bArr, "<this>");
        rt rtVar = new rt();
        rtVar.a = bArr;
        rtVar.b = bArr.length;
        rtVar.d(10);
        return rtVar;
    }

    @Override // me.hd.wauxv.obf.cvl
    public final Object k() {
        return new byte[0];
    }

    @Override // me.hd.wauxv.obf.cvl
    public final void m(acn acnVar, Object obj, int i) {
        byte[] bArr = (byte[]) obj;
        bzo.q(acnVar, "encoder");
        bzo.q(bArr, "content");
        for (int i2 = 0; i2 < i; i2++) {
            acnVar.n(this.o, i2, bArr[i2]);
        }
    }
}
