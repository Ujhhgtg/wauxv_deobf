package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bqd extends cvl {
    public static final bqd j = new bqd(bqj.b);

    @Override // me.hd.wauxv.obf.s
    public final int e(Object obj) {
        int[] iArr = (int[]) obj;
        throwIfVar1IsNull(iArr, "<this>");
        return iArr.length;
    }

    @Override // me.hd.wauxv.obf.aax, me.hd.wauxv.obf.s
    public final void g(acm acmVar, int i, Object obj) {
        bqc bqcVar = (bqc) obj;
        throwIfVar1IsNull(bqcVar, "builder");
        int iG = acmVar.g(this.o, i);
        bqcVar.d(bqcVar.e() + 1);
        int[] iArr = bqcVar.a;
        int i2 = bqcVar.b;
        bqcVar.b = i2 + 1;
        iArr[i2] = iG;
    }

    @Override // me.hd.wauxv.obf.s
    public final Object h(Object obj) {
        int[] iArr = (int[]) obj;
        throwIfVar1IsNull(iArr, "<this>");
        bqc bqcVar = new bqc();
        bqcVar.a = iArr;
        bqcVar.b = iArr.length;
        bqcVar.d(10);
        return bqcVar;
    }

    @Override // me.hd.wauxv.obf.cvl
    public final Object k() {
        return new int[0];
    }

    @Override // me.hd.wauxv.obf.cvl
    public final void m(acn acnVar, Object obj, int i) {
        int[] iArr = (int[]) obj;
        throwIfVar1IsNull(acnVar, "encoder");
        throwIfVar1IsNull(iArr, "content");
        for (int i2 = 0; i2 < i; i2++) {
            acnVar.k(i2, iArr[i2], this.o);
        }
    }
}
