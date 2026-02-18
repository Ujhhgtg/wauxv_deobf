package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class enc extends cvl {
    public static final enc j = new enc(end.b);

    @Override // me.hd.wauxv.obf.s
    public final int e(Object obj) {
        long[] jArr = ((ena) obj).a;
        bzo.q(jArr, "$this$collectionSize");
        return jArr.length;
    }

    @Override // me.hd.wauxv.obf.aax, me.hd.wauxv.obf.s
    public final void g(acm acmVar, int i, Object obj) {
        enb enbVar = (enb) obj;
        bzo.q(enbVar, "builder");
        long jW = acmVar.m(this.o, i).w();
        enbVar.d(enbVar.e() + 1);
        long[] jArr = enbVar.a;
        int i2 = enbVar.b;
        enbVar.b = i2 + 1;
        jArr[i2] = jW;
    }

    @Override // me.hd.wauxv.obf.s
    public final Object h(Object obj) {
        long[] jArr = ((ena) obj).a;
        bzo.q(jArr, "$this$toBuilder");
        enb enbVar = new enb();
        enbVar.a = jArr;
        enbVar.b = jArr.length;
        enbVar.d(10);
        return enbVar;
    }

    @Override // me.hd.wauxv.obf.cvl
    public final Object k() {
        return new ena(new long[0]);
    }

    @Override // me.hd.wauxv.obf.cvl
    public final void m(acn acnVar, Object obj, int i) {
        long[] jArr = ((ena) obj).a;
        bzo.q(acnVar, "encoder");
        for (int i2 = 0; i2 < i; i2++) {
            acnVar.h(this.o, i2).ab(jArr[i2]);
        }
    }
}
