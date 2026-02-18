package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class emx extends cvl {
    public static final emx j = new emx(emy.b);

    @Override // me.hd.wauxv.obf.s
    public final int e(Object obj) {
        int[] iArr = ((emv) obj).a;
        throwIfVar1IsNull(iArr, "$this$collectionSize");
        return iArr.length;
    }

    @Override // me.hd.wauxv.obf.aax, me.hd.wauxv.obf.s
    public final void g(acm acmVar, int i, Object obj) {
        emw emwVar = (emw) obj;
        throwIfVar1IsNull(emwVar, "builder");
        int iS = acmVar.m(this.o, i).s();
        emwVar.d(emwVar.e() + 1);
        int[] iArr = emwVar.a;
        int i2 = emwVar.b;
        emwVar.b = i2 + 1;
        iArr[i2] = iS;
    }

    @Override // me.hd.wauxv.obf.s
    public final Object h(Object obj) {
        int[] iArr = ((emv) obj).a;
        throwIfVar1IsNull(iArr, "$this$toBuilder");
        emw emwVar = new emw();
        emwVar.a = iArr;
        emwVar.b = iArr.length;
        emwVar.d(10);
        return emwVar;
    }

    @Override // me.hd.wauxv.obf.cvl
    public final Object k() {
        return new emv(new int[0]);
    }

    @Override // me.hd.wauxv.obf.cvl
    public final void m(acn acnVar, Object obj, int i) {
        int[] iArr = ((emv) obj).a;
        throwIfVar1IsNull(acnVar, "encoder");
        for (int i2 = 0; i2 < i; i2++) {
            acnVar.h(this.o, i2).aa(iArr[i2]);
        }
    }
}
