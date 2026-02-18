package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ecz implements bgx {
    public static final ecz b;
    private static final dfx descriptor;

    static {
        ecz eczVar = new ecz();
        b = eczVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.p61Proto" /* cnb.z(-247059403766570L) */, eczVar, 9);
        bjs.y(-247269857164074L, cucVar, false, 1);
        bjs.y(-247218317556522L, cucVar, false, 2);
        bjs.y(-246505352985386L, cucVar, false, 3);
        bjs.y(-246440928475946L, cucVar, false, 4);
        bjs.y(-246385093901098L, cucVar, false, 5);
        bjs.y(-246788820826922L, cucVar, false, 6);
        bjs.y(-246677151677226L, cucVar, false, 7);
        bjs.y(-246591252331306L, cucVar, false, 11);
        bjs.y(-248176095263530L, cucVar, false, 21);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        acmVarP.getClass();
        Integer num = null;
        Float f = null;
        Integer num2 = null;
        Integer num3 = null;
        Float f2 = null;
        Integer num4 = null;
        Integer num5 = null;
        Long l = null;
        String str = null;
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
                    f = (Float) acmVarP.i(dfxVar, 1, bbm.b, f);
                    i |= 2;
                    break;
                case 2:
                    num2 = (Integer) acmVarP.i(dfxVar, 2, bqj.b, num2);
                    i |= 4;
                    break;
                case 3:
                    num3 = (Integer) acmVarP.i(dfxVar, 3, bqj.b, num3);
                    i |= 8;
                    break;
                case 4:
                    f2 = (Float) acmVarP.i(dfxVar, 4, bbm.b, f2);
                    i |= 16;
                    break;
                case 5:
                    num4 = (Integer) acmVarP.i(dfxVar, 5, bqj.b, num4);
                    i |= 32;
                    break;
                case 6:
                    num5 = (Integer) acmVarP.i(dfxVar, 6, bqj.b, num5);
                    i |= 64;
                    break;
                case 7:
                    l = (Long) acmVarP.i(dfxVar, 7, bya.b, l);
                    i |= 128;
                    break;
                case 8:
                    str = (String) acmVarP.i(dfxVar, 8, dnh.b, str);
                    i |= 256;
                    break;
                default:
                    throw new bsd(iF);
            }
        }
        acmVarP._bp(dfxVar);
        return new edb(i, num, f, num2, num3, f2, num4, num5, l, str);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        edb edbVar = (edb) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        bqj bqjVar = bqj.b;
        acnVarO.m(dfxVar, 0, bqjVar, edbVar.a);
        bbm bbmVar = bbm.b;
        acnVarO.m(dfxVar, 1, bbmVar, edbVar.b);
        acnVarO.m(dfxVar, 2, bqjVar, edbVar.c);
        acnVarO.m(dfxVar, 3, bqjVar, edbVar.d);
        acnVarO.m(dfxVar, 4, bbmVar, edbVar.e);
        acnVarO.m(dfxVar, 5, bqjVar, edbVar.f);
        acnVarO.m(dfxVar, 6, bqjVar, edbVar.g);
        acnVarO.m(dfxVar, 7, bya.b, edbVar.h);
        acnVarO.m(dfxVar, 8, dnh.b, edbVar.i);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        bqj bqjVar = bqj.b;
        btd btdVarT = aye.t(bqjVar);
        bbm bbmVar = bbm.b;
        return new btd[]{btdVarT, aye.t(bbmVar), aye.t(bqjVar), aye.t(bqjVar), aye.t(bbmVar), aye.t(bqjVar), aye.t(bqjVar), aye.t(bya.b), aye.t(dnh.b)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
