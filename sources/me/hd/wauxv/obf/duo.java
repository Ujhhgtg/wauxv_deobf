package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class duo implements bgx {
    public static final duo b;
    private static final dfx descriptor;

    static {
        duo duoVar = new duo();
        b = duoVar;
        cuc cucVar = new cuc(cnb.z(-302168129141546L), duoVar, 5);
        bjs.y(-301785877052202L, cucVar, false, 1);
        bjs.y(-301815941823274L, cucVar, false, 2);
        bjs.y(-301717157575466L, cucVar, false, 3);
        bjs.y(-301682797837098L, cucVar, false, 4);
        bjs.y(-301644143131434L, cucVar, false, 5);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        acmVarP.getClass();
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        Long l = null;
        Long l2 = null;
        boolean z = true;
        while (z) {
            int iF = acmVarP.f(dfxVar);
            if (iF == -1) {
                z = false;
            } else if (iF == 0) {
                str = (String) acmVarP.i(dfxVar, 0, dnh.b, str);
                i |= 1;
            } else if (iF == 1) {
                str2 = (String) acmVarP.i(dfxVar, 1, dnh.b, str2);
                i |= 2;
            } else if (iF == 2) {
                str3 = (String) acmVarP.i(dfxVar, 2, dnh.b, str3);
                i |= 4;
            } else if (iF == 3) {
                l = (Long) acmVarP.i(dfxVar, 3, bya.b, l);
                i |= 8;
            } else {
                if (iF != 4) {
                    throw new bsd(iF);
                }
                l2 = (Long) acmVarP.i(dfxVar, 4, bya.b, l2);
                i |= 16;
            }
        }
        acmVarP._bp(dfxVar);
        return new duq(i, str, str2, str3, l, l2);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        duq duqVar = (duq) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        dnh dnhVar = dnh.b;
        acnVarO.m(dfxVar, 0, dnhVar, duqVar.a);
        acnVarO.m(dfxVar, 1, dnhVar, duqVar.b);
        acnVarO.m(dfxVar, 2, dnhVar, duqVar.c);
        bya byaVar = bya.b;
        acnVarO.m(dfxVar, 3, byaVar, duqVar.d);
        acnVarO.m(dfxVar, 4, byaVar, duqVar.e);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        dnh dnhVar = dnh.b;
        btd btdVarT = aye.t(dnhVar);
        btd btdVarT2 = aye.t(dnhVar);
        btd btdVarT3 = aye.t(dnhVar);
        bya byaVar = bya.b;
        return new btd[]{btdVarT, btdVarT2, btdVarT3, aye.t(byaVar), aye.t(byaVar)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
