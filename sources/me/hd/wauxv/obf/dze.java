package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class dze implements bgx {
    public static final dze b;
    private static final dfx descriptor;

    static {
        dze dzeVar = new dze();
        b = dzeVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.kb3Proto" /* "me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.kb3Proto" /* "me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.kb3Proto" /* cnb.z(-200235670305578L)  */, dzeVar, 9);
        bjs.y(-200446123703082L, cucVar, false, 1);
        bjs.y(-200454713637674L, cucVar, false, 2);
        bjs.y(-200394584095530L, cucVar, false, 3);
        bjs.y(-200403174030122L, cucVar, false, 4);
        bjs.y(-200411763964714L, cucVar, false, 8);
        bjs.y(-200420353899306L, cucVar, false, 9);
        bjs.y(-202009491798826L, cucVar, false, 10);
        bjs.y(-202018081733418L, cucVar, false, 11);
        bjs.y(-202026671668010L, cucVar, false, 12);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        acmVarP.getClass();
        Integer num = null;
        String str = null;
        Integer num2 = null;
        Integer num3 = null;
        String str2 = null;
        Long l = null;
        Long l2 = null;
        Long l3 = null;
        String str3 = null;
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
                    num2 = (Integer) acmVarP.i(dfxVar, 2, bqj.b, num2);
                    i |= 4;
                    break;
                case 3:
                    num3 = (Integer) acmVarP.i(dfxVar, 3, bqj.b, num3);
                    i |= 8;
                    break;
                case 4:
                    str2 = (String) acmVarP.i(dfxVar, 4, dnh.b, str2);
                    i |= 16;
                    break;
                case 5:
                    l = (Long) acmVarP.i(dfxVar, 5, bya.b, l);
                    i |= 32;
                    break;
                case 6:
                    l2 = (Long) acmVarP.i(dfxVar, 6, bya.b, l2);
                    i |= 64;
                    break;
                case 7:
                    l3 = (Long) acmVarP.i(dfxVar, 7, bya.b, l3);
                    i |= 128;
                    break;
                case 8:
                    str3 = (String) acmVarP.i(dfxVar, 8, dnh.b, str3);
                    i |= 256;
                    break;
                default:
                    throw new bsd(iF);
            }
        }
        acmVarP._bp(dfxVar);
        return new dzg(i, num, str, num2, num3, str2, l, l2, l3, str3);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        dzg dzgVar = (dzg) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        bqj bqjVar = bqj.b;
        acnVarO.m(dfxVar, 0, bqjVar, dzgVar.a);
        dnh dnhVar = dnh.b;
        acnVarO.m(dfxVar, 1, dnhVar, dzgVar.b);
        acnVarO.m(dfxVar, 2, bqjVar, dzgVar.c);
        acnVarO.m(dfxVar, 3, bqjVar, dzgVar.d);
        acnVarO.m(dfxVar, 4, dnhVar, dzgVar.e);
        bya byaVar = bya.b;
        acnVarO.m(dfxVar, 5, byaVar, dzgVar.f);
        acnVarO.m(dfxVar, 6, byaVar, dzgVar.g);
        acnVarO.m(dfxVar, 7, byaVar, dzgVar.h);
        acnVarO.m(dfxVar, 8, dnhVar, dzgVar.i);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        bqj bqjVar = bqj.b;
        btd btdVarT = aye.t(bqjVar);
        dnh dnhVar = dnh.b;
        btd btdVarT2 = aye.t(dnhVar);
        btd btdVarT3 = aye.t(bqjVar);
        btd btdVarT4 = aye.t(bqjVar);
        btd btdVarT5 = aye.t(dnhVar);
        bya byaVar = bya.b;
        return new btd[]{btdVarT, btdVarT2, btdVarT3, btdVarT4, btdVarT5, aye.t(byaVar), aye.t(byaVar), aye.t(byaVar), aye.t(dnhVar)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
