package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class dyv implements bgx {
    public static final dyv b;
    private static final dfx descriptor;

    static {
        dyv dyvVar = new dyv();
        b = dyvVar;
        cuc cucVar = new cuc(cnb.z(-193694435113770L), dyvVar, 4);
        bjs.y(-193956428118826L, cucVar, false, 1);
        bjs.y(-193922068380458L, cucVar, false, 2);
        bjs.y(-193857643871018L, cucVar, false, 3);
        bjs.y(-195403832097578L, cucVar, false, 4);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        acmVarP.getClass();
        int i = 0;
        dsy dsyVar = null;
        eca ecaVar = null;
        String str = null;
        String str2 = null;
        boolean z = true;
        while (z) {
            int iF = acmVarP.f(dfxVar);
            if (iF == -1) {
                z = false;
            } else if (iF == 0) {
                dsyVar = (dsy) acmVarP.i(dfxVar, 0, dsw.b, dsyVar);
                i |= 1;
            } else if (iF == 1) {
                ecaVar = (eca) acmVarP.i(dfxVar, 1, eby.b, ecaVar);
                i |= 2;
            } else if (iF == 2) {
                str = (String) acmVarP.i(dfxVar, 2, dnh.b, str);
                i |= 4;
            } else {
                if (iF != 3) {
                    throw new bsd(iF);
                }
                str2 = (String) acmVarP.i(dfxVar, 3, dnh.b, str2);
                i |= 8;
            }
        }
        acmVarP._bp(dfxVar);
        return new dyx(i, dsyVar, ecaVar, str, str2);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        dyx dyxVar = (dyx) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        acnVarO.m(dfxVar, 0, dsw.b, dyxVar.a);
        acnVarO.m(dfxVar, 1, eby.b, dyxVar.b);
        dnh dnhVar = dnh.b;
        acnVarO.m(dfxVar, 2, dnhVar, dyxVar.c);
        acnVarO.m(dfxVar, 3, dnhVar, dyxVar.d);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        btd btdVarT = aye.t(dsw.b);
        btd btdVarT2 = aye.t(eby.b);
        dnh dnhVar = dnh.b;
        return new btd[]{btdVarT, btdVarT2, aye.t(dnhVar), aye.t(dnhVar)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
