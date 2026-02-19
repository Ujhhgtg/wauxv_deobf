package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class dxf implements bgx {
    public static final dxf b;
    private static final dfx descriptor;

    static {
        dxf dxfVar = new dxf();
        b = dxfVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.f93Proto" /* "me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.f93Proto" /* "me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.f93Proto" /* cnb.z(-191770289765162L)  */, dxfVar, 11);
        bjs.y(-193131794397994L, cucVar, false, 1);
        bjs.y(-193101729626922L, cucVar, false, 2);
        bjs.y(-193045895052074L, cucVar, false, 3);
        bjs.y(-193002945379114L, cucVar, false, 4);
        bjs.y(-192985765509930L, cucVar, false, 5);
        bjs.y(-193471096814378L, cucVar, false, 6);
        bjs.y(-193385197468458L, cucVar, false, 7);
        bjs.y(-193359427664682L, cucVar, false, 8);
        bjs.y(-193277823286058L, cucVar, false, 9);
        bjs.y(-192629283224362L, cucVar, false, 11);
        bjs.y(-192607808387882L, cucVar, false, 12);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        boolean z;
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        acmVarP.getClass();
        String str = null;
        Integer num = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        Integer num2 = null;
        Float f = null;
        Integer num3 = null;
        Boolean bool = null;
        Boolean bool2 = null;
        int i = 0;
        boolean z2 = true;
        while (z2) {
            int iF = acmVarP.f(dfxVar);
            switch (iF) {
                case -1:
                    z2 = false;
                    continue;
                case 0:
                    z = z2;
                    str2 = (String) acmVarP.i(dfxVar, 0, dnh.b, str2);
                    i |= 1;
                    break;
                case 1:
                    z = z2;
                    str3 = (String) acmVarP.i(dfxVar, 1, dnh.b, str3);
                    i |= 2;
                    break;
                case 2:
                    z = z2;
                    str4 = (String) acmVarP.i(dfxVar, 2, dnh.b, str4);
                    i |= 4;
                    break;
                case 3:
                    z = z2;
                    str5 = (String) acmVarP.i(dfxVar, 3, dnh.b, str5);
                    i |= 8;
                    break;
                case 4:
                    z = z2;
                    num2 = (Integer) acmVarP.i(dfxVar, 4, bqj.b, num2);
                    i |= 16;
                    break;
                case 5:
                    z = z2;
                    f = (Float) acmVarP.i(dfxVar, 5, bbm.b, f);
                    i |= 32;
                    break;
                case 6:
                    z = z2;
                    num3 = (Integer) acmVarP.i(dfxVar, 6, bqj.b, num3);
                    i |= 64;
                    break;
                case 7:
                    z = z2;
                    bool = (Boolean) acmVarP.i(dfxVar, 7, pv.b, bool);
                    i |= 128;
                    break;
                case 8:
                    z = z2;
                    bool2 = (Boolean) acmVarP.i(dfxVar, 8, pv.b, bool2);
                    i |= 256;
                    break;
                case 9:
                    z = z2;
                    str = (String) acmVarP.i(dfxVar, 9, dnh.b, str);
                    i |= 512;
                    break;
                case 10:
                    z = z2;
                    num = (Integer) acmVarP.i(dfxVar, 10, bqj.b, num);
                    i |= 1024;
                    break;
                default:
                    throw new bsd(iF);
            }
            z2 = z;
        }
        acmVarP._bp(dfxVar);
        return new dxh(i, str2, str3, str4, str5, num2, f, num3, bool, bool2, str, num);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        dxh dxhVar = (dxh) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        dnh dnhVar = dnh.b;
        acnVarO.m(dfxVar, 0, dnhVar, dxhVar.a);
        acnVarO.m(dfxVar, 1, dnhVar, dxhVar.b);
        acnVarO.m(dfxVar, 2, dnhVar, dxhVar.c);
        acnVarO.m(dfxVar, 3, dnhVar, dxhVar.d);
        bqj bqjVar = bqj.b;
        acnVarO.m(dfxVar, 4, bqjVar, dxhVar.e);
        acnVarO.m(dfxVar, 5, bbm.b, dxhVar.f);
        acnVarO.m(dfxVar, 6, bqjVar, dxhVar.g);
        pv pvVar = pv.b;
        acnVarO.m(dfxVar, 7, pvVar, dxhVar.h);
        acnVarO.m(dfxVar, 8, pvVar, dxhVar.i);
        acnVarO.m(dfxVar, 9, dnhVar, dxhVar.j);
        acnVarO.m(dfxVar, 10, bqjVar, dxhVar.k);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        dnh dnhVar = dnh.b;
        btd btdVarT = aye.t(dnhVar);
        btd btdVarT2 = aye.t(dnhVar);
        btd btdVarT3 = aye.t(dnhVar);
        btd btdVarT4 = aye.t(dnhVar);
        bqj bqjVar = bqj.b;
        btd btdVarT5 = aye.t(bqjVar);
        btd btdVarT6 = aye.t(bbm.b);
        btd btdVarT7 = aye.t(bqjVar);
        pv pvVar = pv.b;
        return new btd[]{btdVarT, btdVarT2, btdVarT3, btdVarT4, btdVarT5, btdVarT6, btdVarT7, aye.t(pvVar), aye.t(pvVar), aye.t(dnhVar), aye.t(bqjVar)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
