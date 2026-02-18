package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class dym implements bgx {
    public static final dym b;
    private static final dfx descriptor;

    static {
        dym dymVar = new dym();
        b = dymVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.ht1Proto" /* cnb.z(-207567179479850L) */, dymVar, 5);
        bjs.y(-207210697194282L, cucVar, false, 1);
        bjs.y(-207150567652138L, cucVar, false, 3);
        bjs.y(-207116207913770L, cucVar, false, 4);
        bjs.y(-207021718633258L, cucVar, false, 5);
        bjs.y(-208602266598186L, cucVar, false, 6);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        acmVarP.getClass();
        int i = 0;
        Integer num = null;
        dsy dsyVar = null;
        Integer num2 = null;
        String str = null;
        String str2 = null;
        boolean z = true;
        while (z) {
            int iF = acmVarP.f(dfxVar);
            if (iF == -1) {
                z = false;
            } else if (iF == 0) {
                num = (Integer) acmVarP.i(dfxVar, 0, bqj.b, num);
                i |= 1;
            } else if (iF == 1) {
                dsyVar = (dsy) acmVarP.i(dfxVar, 1, dsw.b, dsyVar);
                i |= 2;
            } else if (iF == 2) {
                num2 = (Integer) acmVarP.i(dfxVar, 2, bqj.b, num2);
                i |= 4;
            } else if (iF == 3) {
                str = (String) acmVarP.i(dfxVar, 3, dnh.b, str);
                i |= 8;
            } else {
                if (iF != 4) {
                    throw new bsd(iF);
                }
                str2 = (String) acmVarP.i(dfxVar, 4, dnh.b, str2);
                i |= 16;
            }
        }
        acmVarP._bp(dfxVar);
        return new dyo(i, num, dsyVar, num2, str, str2);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        dyo dyoVar = (dyo) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        bqj bqjVar = bqj.b;
        acnVarO.m(dfxVar, 0, bqjVar, dyoVar.a);
        acnVarO.m(dfxVar, 1, dsw.b, dyoVar.b);
        acnVarO.m(dfxVar, 2, bqjVar, dyoVar.c);
        dnh dnhVar = dnh.b;
        acnVarO.m(dfxVar, 3, dnhVar, dyoVar.d);
        acnVarO.m(dfxVar, 4, dnhVar, dyoVar.e);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        bqj bqjVar = bqj.b;
        btd btdVarT = aye.t(bqjVar);
        btd btdVarT2 = aye.t(dsw.b);
        btd btdVarT3 = aye.t(bqjVar);
        dnh dnhVar = dnh.b;
        return new btd[]{btdVarT, btdVarT2, btdVarT3, aye.t(dnhVar), aye.t(dnhVar)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
