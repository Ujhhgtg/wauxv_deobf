package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ub extends cvl {
    public static final ub j = new ub(ui.b);

    @Override // me.hd.wauxv.obf.s
    public final int e(Object obj) {
        char[] cArr = (char[]) obj;
        throwIfVar1IsNull(cArr, "<this>");
        return cArr.length;
    }

    @Override // me.hd.wauxv.obf.aax, me.hd.wauxv.obf.s
    public final void g(acm acmVar, int i, Object obj) {
        ty tyVar = (ty) obj;
        throwIfVar1IsNull(tyVar, "builder");
        char cJ = acmVar.j(this.o, i);
        tyVar.d(tyVar.e() + 1);
        char[] cArr = tyVar.a;
        int i2 = tyVar.b;
        tyVar.b = i2 + 1;
        cArr[i2] = cJ;
    }

    @Override // me.hd.wauxv.obf.s
    public final Object h(Object obj) {
        char[] cArr = (char[]) obj;
        throwIfVar1IsNull(cArr, "<this>");
        ty tyVar = new ty();
        tyVar.a = cArr;
        tyVar.b = cArr.length;
        tyVar.d(10);
        return tyVar;
    }

    @Override // me.hd.wauxv.obf.cvl
    public final Object k() {
        return new char[0];
    }

    @Override // me.hd.wauxv.obf.cvl
    public final void m(acn acnVar, Object obj, int i) {
        char[] cArr = (char[]) obj;
        throwIfVar1IsNull(acnVar, "encoder");
        throwIfVar1IsNull(cArr, "content");
        for (int i2 = 0; i2 < i; i2++) {
            acnVar.d(this.o, i2, cArr[i2]);
        }
    }
}
