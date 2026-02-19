package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class apa implements bgx {
    public static final apa b;
    private static final dfx descriptor;

    static {
        apa apaVar = new apa();
        b = apaVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.proto.DisturbSetting" /* "me.hd.wauxv.hook.micromsg.core.protobuf.proto.DisturbSetting" /* "me.hd.wauxv.hook.micromsg.core.protobuf.proto.DisturbSetting" /* "me.hd.wauxv.hook.micromsg.core.protobuf.proto.DisturbSetting" /* cnb.z(-338443422923562L)   */, apaVar, 4);
        cucVar.x("NightSetting" /* "NightSetting" /* "NightSetting" /* "NightSetting" /* cnb.z(-337597314366250L)   */, false);
        cucVar.y(new aoz(1, 0));
        cucVar.x("NightTime" /* "NightTime" /* "NightTime" /* "NightTime" /* cnb.z(-338074055736106L)   */, false);
        cucVar.y(new aoz(2, 0));
        cucVar.x("AllDaySetting" /* "AllDaySetting" /* "AllDaySetting" /* "AllDaySetting" /* cnb.z(-338048285932330L)   */, false);
        cucVar.y(new aoz(3, 0));
        cucVar.x("AllDayTime" /* "AllDayTime" /* "AllDayTime" /* "AllDayTime" /* cnb.z(-337970976521002L)   */, false);
        cucVar.y(new aoz(4, 0));
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        acmVarP.getClass();
        boolean z = true;
        int i = 0;
        Integer num = null;
        apf apfVar = null;
        String str = null;
        apf apfVar2 = null;
        while (z) {
            int iF = acmVarP.f(dfxVar);
            if (iF == -1) {
                z = false;
            } else if (iF == 0) {
                num = (Integer) acmVarP.i(dfxVar, 0, bqj.b, num);
                i |= 1;
            } else if (iF == 1) {
                apfVar = (apf) acmVarP.i(dfxVar, 1, apd.b, apfVar);
                i |= 2;
            } else if (iF == 2) {
                str = (String) acmVarP.i(dfxVar, 2, dnh.b, str);
                i |= 4;
            } else {
                if (iF != 3) {
                    throw new bsd(iF);
                }
                apfVar2 = (apf) acmVarP.i(dfxVar, 3, apd.b, apfVar2);
                i |= 8;
            }
        }
        acmVarP._bp(dfxVar);
        if (15 != (i & 15)) {
            ResourcesCompat.ah(i, 15, descriptor);
            throw null;
        }
        apc apcVar = new apc();
        apcVar.a = num;
        apcVar.b = apfVar;
        apcVar.c = str;
        apcVar.d = apfVar2;
        return apcVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        apc apcVar = (apc) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        acnVarO.m(dfxVar, 0, bqj.b, apcVar.a);
        apd apdVar = apd.b;
        acnVarO.m(dfxVar, 1, apdVar, apcVar.b);
        acnVarO.m(dfxVar, 2, dnh.b, apcVar.c);
        acnVarO.m(dfxVar, 3, apdVar, apcVar.d);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        btd btdVarT = aye.t(bqj.b);
        apd apdVar = apd.b;
        return new btd[]{btdVarT, aye.t(apdVar), aye.t(dnh.b), aye.t(apdVar)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
