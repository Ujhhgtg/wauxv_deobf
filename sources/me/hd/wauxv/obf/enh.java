package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class enh extends cvl {
    public static final enh j = new enh(eni.b);

    @Override // me.hd.wauxv.obf.s
    public final int e(Object obj) {
        short[] sArr = ((enf) obj).a;
        throwIfVar1IsNull(sArr, "$this$collectionSize");
        return sArr.length;
    }

    @Override // me.hd.wauxv.obf.aax, me.hd.wauxv.obf.s
    public final void g(acm acmVar, int i, Object obj) {
        eng engVar = (eng) obj;
        throwIfVar1IsNull(engVar, "builder");
        short sZ = acmVar.m(this.o, i).z();
        engVar.d(engVar.e() + 1);
        short[] sArr = engVar.a;
        int i2 = engVar.b;
        engVar.b = i2 + 1;
        sArr[i2] = sZ;
    }

    @Override // me.hd.wauxv.obf.s
    public final Object h(Object obj) {
        short[] sArr = ((enf) obj).a;
        throwIfVar1IsNull(sArr, "$this$toBuilder");
        eng engVar = new eng();
        engVar.a = sArr;
        engVar.b = sArr.length;
        engVar.d(10);
        return engVar;
    }

    @Override // me.hd.wauxv.obf.cvl
    public final Object k() {
        return new enf(new short[0]);
    }

    @Override // me.hd.wauxv.obf.cvl
    public final void m(acn acnVar, Object obj, int i) {
        short[] sArr = ((enf) obj).a;
        throwIfVar1IsNull(acnVar, "encoder");
        for (int i2 = 0; i2 < i; i2++) {
            acnVar.h(this.o, i2).t(sArr[i2]);
        }
    }
}
