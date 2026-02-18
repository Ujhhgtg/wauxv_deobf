package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class dsd implements bgx {
    public static final dsd b;
    private static final dfx descriptor;

    static {
        dsd dsdVar = new dsd();
        b = dsdVar;
        cuc cucVar = new cuc(cnb.z(-147514946747178L), dsdVar, 7);
        bjs.y(-147725400144682L, cucVar, false, 1);
        bjs.y(-147746874981162L, cucVar, false, 2);
        bjs.y(-147712515242794L, cucVar, false, 3);
        bjs.y(-147678155504426L, cucVar, false, 4);
        bjs.y(-149228638698282L, cucVar, false, 5);
        bjs.y(-149194278959914L, cucVar, false, 6);
        bjs.y(-149168509156138L, cucVar, false, 7);
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
        String str4 = null;
        String str5 = null;
        Integer num = null;
        Integer num2 = null;
        boolean z = true;
        while (z) {
            int iF = acmVarP.f(dfxVar);
            switch (iF) {
                case -1:
                    z = false;
                    break;
                case 0:
                    str = (String) acmVarP.i(dfxVar, 0, dnh.b, str);
                    i |= 1;
                    break;
                case 1:
                    str2 = (String) acmVarP.i(dfxVar, 1, dnh.b, str2);
                    i |= 2;
                    break;
                case 2:
                    str3 = (String) acmVarP.i(dfxVar, 2, dnh.b, str3);
                    i |= 4;
                    break;
                case 3:
                    str4 = (String) acmVarP.i(dfxVar, 3, dnh.b, str4);
                    i |= 8;
                    break;
                case 4:
                    str5 = (String) acmVarP.i(dfxVar, 4, dnh.b, str5);
                    i |= 16;
                    break;
                case 5:
                    num = (Integer) acmVarP.i(dfxVar, 5, bqj.b, num);
                    i |= 32;
                    break;
                case 6:
                    num2 = (Integer) acmVarP.i(dfxVar, 6, bqj.b, num2);
                    i |= 64;
                    break;
                default:
                    throw new bsd(iF);
            }
        }
        acmVarP._bp(dfxVar);
        return new dsf(i, str, str2, str3, str4, str5, num, num2);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        dsf dsfVar = (dsf) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        dnh dnhVar = dnh.b;
        acnVarO.m(dfxVar, 0, dnhVar, dsfVar.a);
        acnVarO.m(dfxVar, 1, dnhVar, dsfVar.b);
        acnVarO.m(dfxVar, 2, dnhVar, dsfVar.c);
        acnVarO.m(dfxVar, 3, dnhVar, dsfVar.d);
        acnVarO.m(dfxVar, 4, dnhVar, dsfVar.e);
        bqj bqjVar = bqj.b;
        acnVarO.m(dfxVar, 5, bqjVar, dsfVar.f);
        acnVarO.m(dfxVar, 6, bqjVar, dsfVar.g);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        dnh dnhVar = dnh.b;
        btd btdVarT = aye.t(dnhVar);
        btd btdVarT2 = aye.t(dnhVar);
        btd btdVarT3 = aye.t(dnhVar);
        btd btdVarT4 = aye.t(dnhVar);
        btd btdVarT5 = aye.t(dnhVar);
        bqj bqjVar = bqj.b;
        return new btd[]{btdVarT, btdVarT2, btdVarT3, btdVarT4, btdVarT5, aye.t(bqjVar), aye.t(bqjVar)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
