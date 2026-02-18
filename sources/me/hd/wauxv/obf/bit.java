package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class bit implements bgx {
    public static final bit b;
    private static final dfx descriptor;

    static {
        bit bitVar = new bit();
        b = bitVar;
        cuc cucVar = new cuc("wx.demo.hook.ui.group.factory.GroupConstFactory.GroupItem" /* cnb.z(-592868695604010L) */, bitVar, 5);
        cucVar.x("title" /* cnb.z(-593186523183914L) */, false);
        cucVar.x("order" /* cnb.z(-593143573510954L) */, false);
        cucVar.x("icon" /* cnb.z(-593100623837994L) */, false);
        cucVar.x("enable" /* cnb.z(-593113508739882L) */, false);
        cucVar.x("idList" /* cnb.z(-593083443968810L) */, false);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        btt[] bttVarArr = biv.a;
        acmVarP.getClass();
        int i = 0;
        int iG = 0;
        boolean zL = false;
        String strD = null;
        String strD2 = null;
        String[] strArr = null;
        boolean z = true;
        while (z) {
            int iF = acmVarP.f(dfxVar);
            if (iF == -1) {
                z = false;
            } else if (iF == 0) {
                strD = acmVarP.d(dfxVar, 0);
                i |= 1;
            } else if (iF == 1) {
                iG = acmVarP.g(dfxVar, 1);
                i |= 2;
            } else if (iF == 2) {
                strD2 = acmVarP.d(dfxVar, 2);
                i |= 4;
            } else if (iF == 3) {
                zL = acmVarP.l(dfxVar, 3);
                i |= 8;
            } else {
                if (iF != 4) {
                    throw new bsd(iF);
                }
                strArr = (String[]) acmVarP.h(dfxVar, 4, (btd) bttVarArr[4].getValue(), strArr);
                i |= 16;
            }
        }
        acmVarP._bp(dfxVar);
        return new biv(i, strD, iG, strD2, zL, strArr);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        biv bivVar = (biv) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        btt[] bttVarArr = biv.a;
        acnVarO.l(dfxVar, 0, bivVar.b);
        acnVarO.k(1, bivVar.c, dfxVar);
        acnVarO.l(dfxVar, 2, bivVar.d);
        acnVarO._bz(dfxVar, 3, bivVar.e);
        acnVarO._ca(dfxVar, 4, (btd) bttVarArr[4].getValue(), bivVar.f);
        acnVarO.a(dfxVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        btt[] bttVarArr = biv.a;
        dnh dnhVar = dnh.b;
        return new btd[]{dnhVar, bqj.b, dnhVar, pv.b, bttVarArr[4].getValue()};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
