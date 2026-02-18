package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ebj implements bgx {
    public static final ebj b;
    private static final dfx descriptor;

    static {
        ebj ebjVar = new ebj();
        b = ebjVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.n84Proto" /* cnb.z(-234810157038378L) */, ebjVar, 9);
        bjs.y(-234470854621994L, cucVar, false, 1);
        bjs.y(-234402135145258L, cucVar, false, 2);
        bjs.y(-234324825733930L, cucVar, false, 3);
        bjs.y(-234200271682346L, cucVar, false, 4);
        bjs.y(-234732847627050L, cucVar, false, 5);
        bjs.y(-234664128150314L, cucVar, false, 6);
        bjs.y(-234543869066026L, cucVar, false, 7);
        bjs.y(-234539574098730L, cucVar, false, 8);
        bjs.y(-234496624425770L, cucVar, false, 11);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        acmVarP.getClass();
        String str = null;
        Long l = null;
        Integer num = null;
        Boolean bool = null;
        eak eakVar = null;
        Long l2 = null;
        Boolean bool2 = null;
        Long l3 = null;
        Long l4 = null;
        int i = 0;
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
                    l = (Long) acmVarP.i(dfxVar, 1, bya.b, l);
                    i |= 2;
                    break;
                case 2:
                    num = (Integer) acmVarP.i(dfxVar, 2, bqj.b, num);
                    i |= 4;
                    break;
                case 3:
                    bool = (Boolean) acmVarP.i(dfxVar, 3, pv.b, bool);
                    i |= 8;
                    break;
                case 4:
                    eakVar = (eak) acmVarP.i(dfxVar, 4, eai.b, eakVar);
                    i |= 16;
                    break;
                case 5:
                    l2 = (Long) acmVarP.i(dfxVar, 5, bya.b, l2);
                    i |= 32;
                    break;
                case 6:
                    bool2 = (Boolean) acmVarP.i(dfxVar, 6, pv.b, bool2);
                    i |= 64;
                    break;
                case 7:
                    l3 = (Long) acmVarP.i(dfxVar, 7, bya.b, l3);
                    i |= 128;
                    break;
                case 8:
                    l4 = (Long) acmVarP.i(dfxVar, 8, bya.b, l4);
                    i |= 256;
                    break;
                default:
                    throw new bsd(iF);
            }
        }
        acmVarP._bp(dfxVar);
        return new ebl(i, str, l, num, bool, eakVar, l2, bool2, l3, l4);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        ebl eblVar = (ebl) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        acnVarO.m(dfxVar, 0, dnh.b, eblVar.a);
        bya byaVar = bya.b;
        acnVarO.m(dfxVar, 1, byaVar, eblVar.b);
        acnVarO.m(dfxVar, 2, bqj.b, eblVar.c);
        pv pvVar = pv.b;
        acnVarO.m(dfxVar, 3, pvVar, eblVar.d);
        acnVarO.m(dfxVar, 4, eai.b, eblVar.e);
        acnVarO.m(dfxVar, 5, byaVar, eblVar.f);
        acnVarO.m(dfxVar, 6, pvVar, eblVar.g);
        acnVarO.m(dfxVar, 7, byaVar, eblVar.h);
        acnVarO.m(dfxVar, 8, byaVar, eblVar.i);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        btd btdVarT = aye.t(dnh.b);
        bya byaVar = bya.b;
        btd btdVarT2 = aye.t(byaVar);
        btd btdVarT3 = aye.t(bqj.b);
        pv pvVar = pv.b;
        return new btd[]{btdVarT, btdVarT2, btdVarT3, aye.t(pvVar), aye.t(eai.b), aye.t(byaVar), aye.t(pvVar), aye.t(byaVar), aye.t(byaVar)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
