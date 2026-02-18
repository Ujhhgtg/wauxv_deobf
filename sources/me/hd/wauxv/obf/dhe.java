package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dhe extends cvl {
    public static final dhe j = new dhe(dhf.b);

    @Override // me.hd.wauxv.obf.s
    public final int e(Object obj) {
        short[] sArr = (short[]) obj;
        throwIfVar1IsNull(sArr, "<this>");
        return sArr.length;
    }

    @Override // me.hd.wauxv.obf.aax, me.hd.wauxv.obf.s
    public final void g(acm acmVar, int i, Object obj) {
        dhd dhdVar = (dhd) obj;
        throwIfVar1IsNull(dhdVar, "builder");
        short sN = acmVar.n(this.o, i);
        dhdVar.d(dhdVar.e() + 1);
        short[] sArr = dhdVar.a;
        int i2 = dhdVar.b;
        dhdVar.b = i2 + 1;
        sArr[i2] = sN;
    }

    @Override // me.hd.wauxv.obf.s
    public final Object h(Object obj) {
        short[] sArr = (short[]) obj;
        throwIfVar1IsNull(sArr, "<this>");
        dhd dhdVar = new dhd();
        dhdVar.a = sArr;
        dhdVar.b = sArr.length;
        dhdVar.d(10);
        return dhdVar;
    }

    @Override // me.hd.wauxv.obf.cvl
    public final Object k() {
        return new short[0];
    }

    @Override // me.hd.wauxv.obf.cvl
    public final void m(acn acnVar, Object obj, int i) {
        short[] sArr = (short[]) obj;
        throwIfVar1IsNull(acnVar, "encoder");
        throwIfVar1IsNull(sArr, "content");
        for (int i2 = 0; i2 < i; i2++) {
            acnVar.g(this.o, i2, sArr[i2]);
        }
    }
}
