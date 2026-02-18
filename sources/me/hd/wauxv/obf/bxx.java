package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bxx extends cvl {
    public static final bxx j = new bxx(bya.b);

    @Override // me.hd.wauxv.obf.s
    public final int e(Object obj) {
        long[] jArr = (long[]) obj;
        throwIfVar1IsNull(jArr, "<this>");
        return jArr.length;
    }

    @Override // me.hd.wauxv.obf.aax, me.hd.wauxv.obf.s
    public final void g(acm acmVar, int i, Object obj) {
        bxw bxwVar = (bxw) obj;
        throwIfVar1IsNull(bxwVar, "builder");
        long jE = acmVar.e(this.o, i);
        bxwVar.d(bxwVar.e() + 1);
        long[] jArr = bxwVar.a;
        int i2 = bxwVar.b;
        bxwVar.b = i2 + 1;
        jArr[i2] = jE;
    }

    @Override // me.hd.wauxv.obf.s
    public final Object h(Object obj) {
        long[] jArr = (long[]) obj;
        throwIfVar1IsNull(jArr, "<this>");
        bxw bxwVar = new bxw();
        bxwVar.a = jArr;
        bxwVar.b = jArr.length;
        bxwVar.d(10);
        return bxwVar;
    }

    @Override // me.hd.wauxv.obf.cvl
    public final Object k() {
        return new long[0];
    }

    @Override // me.hd.wauxv.obf.cvl
    public final void m(acn acnVar, Object obj, int i) {
        long[] jArr = (long[]) obj;
        throwIfVar1IsNull(acnVar, "encoder");
        throwIfVar1IsNull(jArr, "content");
        for (int i2 = 0; i2 < i; i2++) {
            acnVar.i(this.o, i2, jArr[i2]);
        }
    }
}
