package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class apk extends cvl {
    public static final apk j = new apk(apl.b);

    @Override // me.hd.wauxv.obf.s
    public final int e(Object obj) {
        double[] dArr = (double[]) obj;
        bzo.q(dArr, "<this>");
        return dArr.length;
    }

    @Override // me.hd.wauxv.obf.aax, me.hd.wauxv.obf.s
    public final void g(acm acmVar, int i, Object obj) {
        apj apjVar = (apj) obj;
        bzo.q(apjVar, "builder");
        double d_bq = acmVar._bq(this.o, i);
        apjVar.d(apjVar.e() + 1);
        double[] dArr = apjVar.a;
        int i2 = apjVar.b;
        apjVar.b = i2 + 1;
        dArr[i2] = d_bq;
    }

    @Override // me.hd.wauxv.obf.s
    public final Object h(Object obj) {
        double[] dArr = (double[]) obj;
        bzo.q(dArr, "<this>");
        apj apjVar = new apj();
        apjVar.a = dArr;
        apjVar.b = dArr.length;
        apjVar.d(10);
        return apjVar;
    }

    @Override // me.hd.wauxv.obf.cvl
    public final Object k() {
        return new double[0];
    }

    @Override // me.hd.wauxv.obf.cvl
    public final void m(acn acnVar, Object obj, int i) {
        double[] dArr = (double[]) obj;
        bzo.q(acnVar, "encoder");
        bzo.q(dArr, "content");
        for (int i2 = 0; i2 < i; i2++) {
            acnVar.j(this.o, i2, dArr[i2]);
        }
    }
}
