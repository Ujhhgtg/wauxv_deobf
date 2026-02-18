package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class efu implements bgx {
    public static final efu b;
    private static final dfx descriptor;

    static {
        efu efuVar = new efu();
        b = efuVar;
        cuc cucVar = new cuc(cnb.z(-289437846076202L), efuVar, 6);
        bjs.y(-289631119604522L, cucVar, false, 1);
        bjs.y(-289562400127786L, cucVar, false, 2);
        bjs.y(-289545220258602L, cucVar, false, 3);
        bjs.y(-289455025945386L, cucVar, false, 4);
        bjs.y(-286676182104874L, cucVar, false, 5);
        bjs.y(-286603167660842L, cucVar, false, 6);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        acmVarP.getClass();
        int i = 0;
        Boolean bool = null;
        String str = null;
        Long l = null;
        Long l2 = null;
        Boolean bool2 = null;
        Integer num = null;
        boolean z = true;
        while (z) {
            int iF = acmVarP.f(dfxVar);
            switch (iF) {
                case -1:
                    z = false;
                    break;
                case 0:
                    bool = (Boolean) acmVarP.i(dfxVar, 0, pv.b, bool);
                    i |= 1;
                    break;
                case 1:
                    str = (String) acmVarP.i(dfxVar, 1, dnh.b, str);
                    i |= 2;
                    break;
                case 2:
                    l = (Long) acmVarP.i(dfxVar, 2, bya.b, l);
                    i |= 4;
                    break;
                case 3:
                    l2 = (Long) acmVarP.i(dfxVar, 3, bya.b, l2);
                    i |= 8;
                    break;
                case 4:
                    bool2 = (Boolean) acmVarP.i(dfxVar, 4, pv.b, bool2);
                    i |= 16;
                    break;
                case 5:
                    num = (Integer) acmVarP.i(dfxVar, 5, bqj.b, num);
                    i |= 32;
                    break;
                default:
                    throw new bsd(iF);
            }
        }
        acmVarP._bp(dfxVar);
        return new efw(i, bool, str, l, l2, bool2, num);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        efw efwVar = (efw) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        pv pvVar = pv.b;
        acnVarO.m(dfxVar, 0, pvVar, efwVar.a);
        acnVarO.m(dfxVar, 1, dnh.b, efwVar.b);
        bya byaVar = bya.b;
        acnVarO.m(dfxVar, 2, byaVar, efwVar.c);
        acnVarO.m(dfxVar, 3, byaVar, efwVar.d);
        acnVarO.m(dfxVar, 4, pvVar, efwVar.e);
        acnVarO.m(dfxVar, 5, bqj.b, efwVar.f);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        pv pvVar = pv.b;
        btd btdVarT = aye.t(pvVar);
        btd btdVarT2 = aye.t(dnh.b);
        bya byaVar = bya.b;
        return new btd[]{btdVarT, btdVarT2, aye.t(byaVar), aye.t(byaVar), aye.t(pvVar), aye.t(bqj.b)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
