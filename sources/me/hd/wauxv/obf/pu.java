package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class pu extends cvl {
    public static final pu j = new pu(pv.b);

    @Override // me.hd.wauxv.obf.s
    public final int e(Object obj) {
        boolean[] zArr = (boolean[]) obj;
        bzo.q(zArr, "<this>");
        return zArr.length;
    }

    @Override // me.hd.wauxv.obf.aax, me.hd.wauxv.obf.s
    public final void g(acm acmVar, int i, Object obj) {
        pt ptVar = (pt) obj;
        bzo.q(ptVar, "builder");
        boolean zL = acmVar.l(this.o, i);
        ptVar.d(ptVar.e() + 1);
        boolean[] zArr = ptVar.a;
        int i2 = ptVar.b;
        ptVar.b = i2 + 1;
        zArr[i2] = zL;
    }

    @Override // me.hd.wauxv.obf.s
    public final Object h(Object obj) {
        boolean[] zArr = (boolean[]) obj;
        bzo.q(zArr, "<this>");
        pt ptVar = new pt();
        ptVar.a = zArr;
        ptVar.b = zArr.length;
        ptVar.d(10);
        return ptVar;
    }

    @Override // me.hd.wauxv.obf.cvl
    public final Object k() {
        return new boolean[0];
    }

    @Override // me.hd.wauxv.obf.cvl
    public final void m(acn acnVar, Object obj, int i) {
        boolean[] zArr = (boolean[]) obj;
        bzo.q(acnVar, "encoder");
        bzo.q(zArr, "content");
        for (int i2 = 0; i2 < i; i2++) {
            acnVar._bz(this.o, i2, zArr[i2]);
        }
    }
}
