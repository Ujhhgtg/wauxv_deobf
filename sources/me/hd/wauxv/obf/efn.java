package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class efn implements bgx {
    public static final efn b;
    private static final dfx descriptor;

    static {
        efn efnVar = new efn();
        b = efnVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.u40Proto" /* "me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.u40Proto" /* "me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.u40Proto" /* cnb.z(-283059819641642L)  */, efnVar, 7);
        bjs.y(-288767831178026L, cucVar, false, 1);
        bjs.y(-288785011047210L, cucVar, false, 2);
        bjs.y(-288759241243434L, cucVar, false, 3);
        bjs.y(-288724881505066L, cucVar, false, 4);
        bjs.y(-288630392224554L, cucVar, false, 5);
        bjs.y(-289128608430890L, cucVar, false, 6);
        bjs.y(-289038414117674L, cucVar, false, 7);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        acmVarP.getClass();
        int i = 0;
        String str = null;
        dwj dwjVar = null;
        dwj dwjVar2 = null;
        dwj dwjVar3 = null;
        dwj dwjVar4 = null;
        dwj dwjVar5 = null;
        dwj dwjVar6 = null;
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
                    dwjVar = (dwj) acmVarP.i(dfxVar, 1, dwh.b, dwjVar);
                    i |= 2;
                    break;
                case 2:
                    dwjVar2 = (dwj) acmVarP.i(dfxVar, 2, dwh.b, dwjVar2);
                    i |= 4;
                    break;
                case 3:
                    dwjVar3 = (dwj) acmVarP.i(dfxVar, 3, dwh.b, dwjVar3);
                    i |= 8;
                    break;
                case 4:
                    dwjVar4 = (dwj) acmVarP.i(dfxVar, 4, dwh.b, dwjVar4);
                    i |= 16;
                    break;
                case 5:
                    dwjVar5 = (dwj) acmVarP.i(dfxVar, 5, dwh.b, dwjVar5);
                    i |= 32;
                    break;
                case 6:
                    dwjVar6 = (dwj) acmVarP.i(dfxVar, 6, dwh.b, dwjVar6);
                    i |= 64;
                    break;
                default:
                    throw new bsd(iF);
            }
        }
        acmVarP._bp(dfxVar);
        return new efp(i, str, dwjVar, dwjVar2, dwjVar3, dwjVar4, dwjVar5, dwjVar6);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        efp efpVar = (efp) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        acnVarO.m(dfxVar, 0, dnh.b, efpVar.a);
        dwh dwhVar = dwh.b;
        acnVarO.m(dfxVar, 1, dwhVar, efpVar.b);
        acnVarO.m(dfxVar, 2, dwhVar, efpVar.c);
        acnVarO.m(dfxVar, 3, dwhVar, efpVar.d);
        acnVarO.m(dfxVar, 4, dwhVar, efpVar.e);
        acnVarO.m(dfxVar, 5, dwhVar, efpVar.f);
        acnVarO.m(dfxVar, 6, dwhVar, efpVar.g);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        btd btdVarT = aye.t(dnh.b);
        dwh dwhVar = dwh.b;
        return new btd[]{btdVarT, aye.t(dwhVar), aye.t(dwhVar), aye.t(dwhVar), aye.t(dwhVar), aye.t(dwhVar), aye.t(dwhVar)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
