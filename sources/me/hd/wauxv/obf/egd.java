package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class egd implements bgx {
    public static final egd b;
    private static final dfx descriptor;

    static {
        egd egdVar = new egd();
        b = egdVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.v40Proto" /* "me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.v40Proto" /* "me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.v40Proto" /* cnb.z(-308159608519466L)  */, egdVar, 8);
        bjs.y(-310019329358634L, cucVar, false, 1);
        bjs.y(-309899070274346L, cucVar, false, 2);
        bjs.y(-309886185372458L, cucVar, false, 3);
        bjs.y(-309843235699498L, cucVar, false, 4);
        bjs.y(-309207580539690L, cucVar, false, 5);
        bjs.y(-309168925834026L, cucVar, false, 6);
        bjs.y(-309044371782442L, cucVar, false, 7);
        bjs.y(-309005717076778L, cucVar, false, 8);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        acmVarP.getClass();
        int i = 0;
        Boolean bool = null;
        Integer num = null;
        Float f = null;
        String str = null;
        Boolean bool2 = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
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
                    num = (Integer) acmVarP.i(dfxVar, 1, bqj.b, num);
                    i |= 2;
                    break;
                case 2:
                    f = (Float) acmVarP.i(dfxVar, 2, bbm.b, f);
                    i |= 4;
                    break;
                case 3:
                    str = (String) acmVarP.i(dfxVar, 3, dnh.b, str);
                    i |= 8;
                    break;
                case 4:
                    bool2 = (Boolean) acmVarP.i(dfxVar, 4, pv.b, bool2);
                    i |= 16;
                    break;
                case 5:
                    str2 = (String) acmVarP.i(dfxVar, 5, dnh.b, str2);
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
                default:
                    throw new bsd(iF);
            }
        }
        acmVarP._bp(dfxVar);
        return new egf(i, bool, num, f, str, bool2, str2, str3, str4);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        egf egfVar = (egf) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        pv pvVar = pv.b;
        acnVarO.m(dfxVar, 0, pvVar, egfVar.a);
        acnVarO.m(dfxVar, 1, bqj.b, egfVar.b);
        acnVarO.m(dfxVar, 2, bbm.b, egfVar.c);
        dnh dnhVar = dnh.b;
        acnVarO.m(dfxVar, 3, dnhVar, egfVar.d);
        acnVarO.m(dfxVar, 4, pvVar, egfVar.e);
        acnVarO.m(dfxVar, 5, dnhVar, egfVar.f);
        acnVarO.m(dfxVar, 6, dnhVar, egfVar.g);
        acnVarO.m(dfxVar, 7, dnhVar, egfVar.h);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        pv pvVar = pv.b;
        btd btdVarT = aye.t(pvVar);
        btd btdVarT2 = aye.t(bqj.b);
        btd btdVarT3 = aye.t(bbm.b);
        dnh dnhVar = dnh.b;
        return new btd[]{btdVarT, btdVarT2, btdVarT3, aye.t(dnhVar), aye.t(pvVar), aye.t(dnhVar), aye.t(dnhVar), aye.t(dnhVar)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
