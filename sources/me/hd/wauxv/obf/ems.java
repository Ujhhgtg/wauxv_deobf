package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ems extends cvl {
    public static final ems j = new ems(emt.b);

    @Override // me.hd.wauxv.obf.s
    public final int e(Object obj) {
        byte[] bArr = ((emq) obj).a;
        throwIfVar1IsNull(bArr, "$this$collectionSize");
        return bArr.length;
    }

    @Override // me.hd.wauxv.obf.aax, me.hd.wauxv.obf.s
    public final void g(acm acmVar, int i, Object obj) {
        emr emrVar = (emr) obj;
        throwIfVar1IsNull(emrVar, "builder");
        byte bY = acmVar.m(this.o, i).y();
        emrVar.d(emrVar.e() + 1);
        byte[] bArr = emrVar.a;
        int i2 = emrVar.b;
        emrVar.b = i2 + 1;
        bArr[i2] = bY;
    }

    @Override // me.hd.wauxv.obf.s
    public final Object h(Object obj) {
        byte[] bArr = ((emq) obj).a;
        throwIfVar1IsNull(bArr, "$this$toBuilder");
        emr emrVar = new emr();
        emrVar.a = bArr;
        emrVar.b = bArr.length;
        emrVar.d(10);
        return emrVar;
    }

    @Override // me.hd.wauxv.obf.cvl
    public final Object k() {
        return new emq(new byte[0]);
    }

    @Override // me.hd.wauxv.obf.cvl
    public final void m(acn acnVar, Object obj, int i) {
        byte[] bArr = ((emq) obj).a;
        throwIfVar1IsNull(acnVar, "encoder");
        for (int i2 = 0; i2 < i; i2++) {
            acnVar.h(this.o, i2).u(bArr[i2]);
        }
    }
}
