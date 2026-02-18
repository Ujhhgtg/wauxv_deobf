package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bbl extends cvl {
    public static final bbl j = new bbl(bbm.b);

    @Override // me.hd.wauxv.obf.s
    public final int e(Object obj) {
        float[] fArr = (float[]) obj;
        throwIfVar1IsNull(fArr, "<this>");
        return fArr.length;
    }

    @Override // me.hd.wauxv.obf.aax, me.hd.wauxv.obf.s
    public final void g(acm acmVar, int i, Object obj) {
        bbk bbkVar = (bbk) obj;
        throwIfVar1IsNull(bbkVar, "builder");
        float fO = acmVar.o(this.o, i);
        bbkVar.d(bbkVar.e() + 1);
        float[] fArr = bbkVar.a;
        int i2 = bbkVar.b;
        bbkVar.b = i2 + 1;
        fArr[i2] = fO;
    }

    @Override // me.hd.wauxv.obf.s
    public final Object h(Object obj) {
        float[] fArr = (float[]) obj;
        throwIfVar1IsNull(fArr, "<this>");
        bbk bbkVar = new bbk();
        bbkVar.a = fArr;
        bbkVar.b = fArr.length;
        bbkVar.d(10);
        return bbkVar;
    }

    @Override // me.hd.wauxv.obf.cvl
    public final Object k() {
        return new float[0];
    }

    @Override // me.hd.wauxv.obf.cvl
    public final void m(acn acnVar, Object obj, int i) {
        float[] fArr = (float[]) obj;
        throwIfVar1IsNull(acnVar, "encoder");
        throwIfVar1IsNull(fArr, "content");
        for (int i2 = 0; i2 < i; i2++) {
            acnVar.e(this.o, i2, fArr[i2]);
        }
    }
}
