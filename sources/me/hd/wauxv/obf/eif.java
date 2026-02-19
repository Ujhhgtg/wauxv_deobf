package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class eif implements bgx {
    public static final eif b;
    private static final dfx descriptor;

    static {
        eif eifVar = new eif();
        b = eifVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.x12Proto" /* "me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.x12Proto" /* "me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.x12Proto" /* "me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.x12Proto" /* cnb.z(-333267987331882L)   */, eifVar, 9);
        bjs.y(-333478440729386L, cucVar, false, 1);
        bjs.y(-333452670925610L, cucVar, false, 2);
        bjs.y(-330652352248618L, cucVar, false, 3);
        bjs.y(-330613697542954L, cucVar, false, 4);
        bjs.y(-330639467346730L, cucVar, false, 5);
        bjs.y(-330609402575658L, cucVar, false, 6);
        bjs.y(-330480553556778L, cucVar, false, 7);
        bjs.y(-330459078720298L, cucVar, false, 8);
        bjs.y(-330931525122858L, cucVar, false, 9);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        acmVarP.getClass();
        Integer num = null;
        String str = null;
        String str2 = null;
        Float f = null;
        Float f2 = null;
        Integer num2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        int i = 0;
        boolean z = true;
        while (z) {
            int iF = acmVarP.f(dfxVar);
            switch (iF) {
                case -1:
                    z = false;
                    break;
                case 0:
                    num = (Integer) acmVarP.i(dfxVar, 0, bqj.b, num);
                    i |= 1;
                    break;
                case 1:
                    str = (String) acmVarP.i(dfxVar, 1, dnh.b, str);
                    i |= 2;
                    break;
                case 2:
                    str2 = (String) acmVarP.i(dfxVar, 2, dnh.b, str2);
                    i |= 4;
                    break;
                case 3:
                    f = (Float) acmVarP.i(dfxVar, 3, bbm.b, f);
                    i |= 8;
                    break;
                case 4:
                    f2 = (Float) acmVarP.i(dfxVar, 4, bbm.b, f2);
                    i |= 16;
                    break;
                case 5:
                    num2 = (Integer) acmVarP.i(dfxVar, 5, bqj.b, num2);
                    i |= 32;
                    break;
                case 6:
                    str3 = (String) acmVarP.i(dfxVar, 6, dnh.b, str3);
                    i |= 64;
                    break;
                case 7:
                    str4 = (String) acmVarP.i(dfxVar, 7, dnh.b, str4);
                    i |= 128;
                    break;
                case 8:
                    str5 = (String) acmVarP.i(dfxVar, 8, dnh.b, str5);
                    i |= 256;
                    break;
                default:
                    throw new bsd(iF);
            }
        }
        acmVarP._bp(dfxVar);
        return new eih(i, num, str, str2, f, f2, num2, str3, str4, str5);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        eih eihVar = (eih) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        bqj bqjVar = bqj.b;
        acnVarO.m(dfxVar, 0, bqjVar, eihVar.a);
        dnh dnhVar = dnh.b;
        acnVarO.m(dfxVar, 1, dnhVar, eihVar.b);
        acnVarO.m(dfxVar, 2, dnhVar, eihVar.c);
        bbm bbmVar = bbm.b;
        acnVarO.m(dfxVar, 3, bbmVar, eihVar.d);
        acnVarO.m(dfxVar, 4, bbmVar, eihVar.e);
        acnVarO.m(dfxVar, 5, bqjVar, eihVar.f);
        acnVarO.m(dfxVar, 6, dnhVar, eihVar.g);
        acnVarO.m(dfxVar, 7, dnhVar, eihVar.h);
        acnVarO.m(dfxVar, 8, dnhVar, eihVar.i);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        bqj bqjVar = bqj.b;
        btd btdVarT = aye.t(bqjVar);
        dnh dnhVar = dnh.b;
        btd btdVarT2 = aye.t(dnhVar);
        btd btdVarT3 = aye.t(dnhVar);
        bbm bbmVar = bbm.b;
        return new btd[]{btdVarT, btdVarT2, btdVarT3, aye.t(bbmVar), aye.t(bbmVar), aye.t(bqjVar), aye.t(dnhVar), aye.t(dnhVar), aye.t(dnhVar)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
