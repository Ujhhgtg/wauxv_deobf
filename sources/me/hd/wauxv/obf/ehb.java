package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ehb implements bgx {
    public static final ehb b;
    private static final dfx descriptor;

    static {
        ehb ehbVar = new ehb();
        b = ehbVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.w10Proto" /* "me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.w10Proto" /* "me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.w10Proto" /* "me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.w10Proto" /* cnb.z(-300926883593002L)   */, ehbVar, 6);
        bjs.y(-301137336990506L, cucVar, false, 1);
        bjs.y(-301154516859690L, cucVar, false, 2);
        bjs.y(-301098682284842L, cucVar, false, 3);
        bjs.y(-301124452088618L, cucVar, false, 4);
        bjs.y(-301017077906218L, cucVar, false, 5);
        bjs.y(-300441552288554L, cucVar, false, 6);
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
        Float f = null;
        Boolean bool = null;
        dwj dwjVar = null;
        Boolean bool2 = null;
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
                    f = (Float) acmVarP.i(dfxVar, 2, bbm.b, f);
                    i |= 4;
                    break;
                case 3:
                    bool = (Boolean) acmVarP.i(dfxVar, 3, pv.b, bool);
                    i |= 8;
                    break;
                case 4:
                    dwjVar = (dwj) acmVarP.i(dfxVar, 4, dwh.b, dwjVar);
                    i |= 16;
                    break;
                case 5:
                    bool2 = (Boolean) acmVarP.i(dfxVar, 5, pv.b, bool2);
                    i |= 32;
                    break;
                default:
                    throw new bsd(iF);
            }
        }
        acmVarP._bp(dfxVar);
        return new ehd(i, str, str2, f, bool, dwjVar, bool2);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        ehd ehdVar = (ehd) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        dnh dnhVar = dnh.b;
        acnVarO.m(dfxVar, 0, dnhVar, ehdVar.a);
        acnVarO.m(dfxVar, 1, dnhVar, ehdVar.b);
        acnVarO.m(dfxVar, 2, bbm.b, ehdVar.c);
        pv pvVar = pv.b;
        acnVarO.m(dfxVar, 3, pvVar, ehdVar.d);
        acnVarO.m(dfxVar, 4, dwh.b, ehdVar.e);
        acnVarO.m(dfxVar, 5, pvVar, ehdVar.f);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        dnh dnhVar = dnh.b;
        btd btdVarT = aye.t(dnhVar);
        btd btdVarT2 = aye.t(dnhVar);
        btd btdVarT3 = aye.t(bbm.b);
        pv pvVar = pv.b;
        return new btd[]{btdVarT, btdVarT2, btdVarT3, aye.t(pvVar), aye.t(dwh.b), aye.t(pvVar)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
