package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class dvg implements bgx {
    public static final dvg b;
    private static final dfx descriptor;

    static {
        dvg dvgVar = new dvg();
        b = dvgVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.ah4Proto" /* "me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.ah4Proto" /* "me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.ah4Proto" /* "me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.ah4Proto" /* cnb.z(-141115445476138L)   */, dvgVar, 4);
        bjs.y(-142408230632234L, cucVar, false, 1);
        bjs.y(-142867792132906L, cucVar, false, 2);
        bjs.y(-142790482721578L, cucVar, false, 3);
        bjs.y(-142760417950506L, cucVar, false, 4);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        acmVarP.getClass();
        int i = 0;
        Integer num = null;
        Integer num2 = null;
        Long l = null;
        Long l2 = null;
        boolean z = true;
        while (z) {
            int iF = acmVarP.f(dfxVar);
            if (iF == -1) {
                z = false;
            } else if (iF == 0) {
                num = (Integer) acmVarP.i(dfxVar, 0, bqj.b, num);
                i |= 1;
            } else if (iF == 1) {
                num2 = (Integer) acmVarP.i(dfxVar, 1, bqj.b, num2);
                i |= 2;
            } else if (iF == 2) {
                l = (Long) acmVarP.i(dfxVar, 2, bya.b, l);
                i |= 4;
            } else {
                if (iF != 3) {
                    throw new bsd(iF);
                }
                l2 = (Long) acmVarP.i(dfxVar, 3, bya.b, l2);
                i |= 8;
            }
        }
        acmVarP._bp(dfxVar);
        return new dvi(i, num, num2, l, l2);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        dvi dviVar = (dvi) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        bqj bqjVar = bqj.b;
        acnVarO.m(dfxVar, 0, bqjVar, dviVar.a);
        acnVarO.m(dfxVar, 1, bqjVar, dviVar.b);
        bya byaVar = bya.b;
        acnVarO.m(dfxVar, 2, byaVar, dviVar.c);
        acnVarO.m(dfxVar, 3, byaVar, dviVar.d);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        bqj bqjVar = bqj.b;
        btd btdVarT = aye.t(bqjVar);
        btd btdVarT2 = aye.t(bqjVar);
        bya byaVar = bya.b;
        return new btd[]{btdVarT, btdVarT2, aye.t(byaVar), aye.t(byaVar)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
