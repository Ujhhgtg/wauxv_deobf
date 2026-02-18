package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class brz extends bgr implements bgj {
    public final /* synthetic */ int a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ brz(int i, Object obj, Class cls, String str, String str2, int i2, int i3, int i4) {
        super(i, obj, cls, str, str2, i2, i3);
        this.a = i4;
    }

    @Override // me.hd.wauxv.obf.bgj
    public final Object g(Object obj, Object obj2) {
        switch (this.a) {
            case 0:
                dfx dfxVar = (dfx) obj;
                int iIntValue = ((Number) obj2).intValue();
                bzo.q(dfxVar, "p0");
                bsa bsaVar = (bsa) this.d;
                bsaVar.getClass();
                boolean z = !dfxVar.m(iIntValue) && dfxVar.l(iIntValue).f();
                bsaVar.b = z;
                return Boolean.valueOf(z);
            default:
                dfx dfxVar2 = (dfx) obj;
                int iIntValue2 = ((Number) obj2).intValue();
                bzo.q(dfxVar2, "p0");
                cwl cwlVar = (cwl) this.d;
                cwlVar.getClass();
                boolean z2 = false;
                if (!dfxVar2.m(iIntValue2)) {
                    dfx dfxVarL = dfxVar2.l(iIntValue2);
                    emc emcVarH = dfxVarL.h();
                    if (bzo.f(emcVarH, dnt.c) || bzo.f(emcVarH, dnt.b)) {
                        cwlVar.an = false;
                    } else if (dfxVarL.f()) {
                        cwlVar.an = true;
                    }
                    z2 = true;
                }
                return Boolean.valueOf(z2);
        }
    }
}
