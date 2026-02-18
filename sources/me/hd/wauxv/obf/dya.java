package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class dya implements bgx {
    public static final dya b;
    private static final dfx descriptor;

    static {
        dya dyaVar = new dya();
        b = dyaVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.gl1Proto" /* cnb.z(-205879257332522L) */, dyaVar, 7);
        bjs.y(-206089710730026L, cucVar, false, 1);
        bjs.y(-206003811384106L, cucVar, false, 2);
        bjs.y(-205939386874666L, cucVar, false, 3);
        bjs.y(-203121888328490L, cucVar, false, 4);
        bjs.y(-203048873884458L, cucVar, false, 5);
        bjs.y(-202980154407722L, cucVar, false, 6);
        bjs.y(-202954384603946L, cucVar, false, 7);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        acmVarP.getClass();
        int i = 0;
        Boolean bool = null;
        Long l = null;
        Long l2 = null;
        String str = null;
        String str2 = null;
        dvf dvfVar = null;
        String str3 = null;
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
                    l = (Long) acmVarP.i(dfxVar, 1, bya.b, l);
                    i |= 2;
                    break;
                case 2:
                    l2 = (Long) acmVarP.i(dfxVar, 2, bya.b, l2);
                    i |= 4;
                    break;
                case 3:
                    str = (String) acmVarP.i(dfxVar, 3, dnh.b, str);
                    i |= 8;
                    break;
                case 4:
                    str2 = (String) acmVarP.i(dfxVar, 4, dnh.b, str2);
                    i |= 16;
                    break;
                case 5:
                    dvfVar = (dvf) acmVarP.i(dfxVar, 5, dvd.b, dvfVar);
                    i |= 32;
                    break;
                case 6:
                    str3 = (String) acmVarP.i(dfxVar, 6, dnh.b, str3);
                    i |= 64;
                    break;
                default:
                    throw new bsd(iF);
            }
        }
        acmVarP._bp(dfxVar);
        return new dyc(i, bool, l, l2, str, str2, dvfVar, str3);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        dyc dycVar = (dyc) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        acnVarO.m(dfxVar, 0, pv.b, dycVar.a);
        bya byaVar = bya.b;
        acnVarO.m(dfxVar, 1, byaVar, dycVar.b);
        acnVarO.m(dfxVar, 2, byaVar, dycVar.c);
        dnh dnhVar = dnh.b;
        acnVarO.m(dfxVar, 3, dnhVar, dycVar.d);
        acnVarO.m(dfxVar, 4, dnhVar, dycVar.e);
        acnVarO.m(dfxVar, 5, dvd.b, dycVar.f);
        acnVarO.m(dfxVar, 6, dnhVar, dycVar.g);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        btd btdVarT = aye.t(pv.b);
        bya byaVar = bya.b;
        btd btdVarT2 = aye.t(byaVar);
        btd btdVarT3 = aye.t(byaVar);
        dnh dnhVar = dnh.b;
        return new btd[]{btdVarT, btdVarT2, btdVarT3, aye.t(dnhVar), aye.t(dnhVar), aye.t(dvd.b), aye.t(dnhVar)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
