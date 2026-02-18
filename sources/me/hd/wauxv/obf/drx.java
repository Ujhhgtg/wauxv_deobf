package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class drx implements bgx {
    public static final drx b;
    private static final dfx descriptor;

    static {
        drx drxVar = new drx();
        b = drxVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.ActionInfoProto" /* cnb.z(-145006685846314L) */, drxVar, 12);
        bjs.y(-144139102452522L, cucVar, false, 1);
        bjs.y(-144083267877674L, cucVar, false, 2);
        bjs.y(-144100447746858L, cucVar, false, 3);
        bjs.y(-144057498073898L, cucVar, false, 4);
        bjs.y(-144564304214826L, cucVar, false, 5);
        bjs.y(-144491289770794L, cucVar, false, 6);
        bjs.y(-144461224999722L, cucVar, false, 7);
        bjs.y(-144431160228650L, cucVar, false, 8);
        bjs.y(-144353850817322L, cucVar, false, 9);
        bjs.y(-144340965915434L, cucVar, false, 10);
        bjs.y(-141463337827114L, cucVar, false, 11);
        bjs.y(-141407503252266L, cucVar, false, 12);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        Integer num;
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        acmVarP.getClass();
        dsi dsiVar = null;
        dsl dslVar = null;
        dsl dslVar2 = null;
        Integer num2 = null;
        String str = null;
        Integer num3 = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        dso dsoVar = null;
        String str5 = null;
        dsc dscVar = null;
        int i = 0;
        boolean z = true;
        while (z) {
            int iF = acmVarP.f(dfxVar);
            switch (iF) {
                case -1:
                    z = false;
                    i = i;
                    continue;
                case 0:
                    num2 = (Integer) acmVarP.i(dfxVar, 0, bqj.b, num2);
                    i |= 1;
                    continue;
                case 1:
                    num = num2;
                    str = (String) acmVarP.i(dfxVar, 1, dnh.b, str);
                    i |= 2;
                    break;
                case 2:
                    num = num2;
                    num3 = (Integer) acmVarP.i(dfxVar, 2, bqj.b, num3);
                    i |= 4;
                    break;
                case 3:
                    num = num2;
                    str2 = (String) acmVarP.i(dfxVar, 3, dnh.b, str2);
                    i |= 8;
                    break;
                case 4:
                    num = num2;
                    str3 = (String) acmVarP.i(dfxVar, 4, dnh.b, str3);
                    i |= 16;
                    break;
                case 5:
                    num = num2;
                    str4 = (String) acmVarP.i(dfxVar, 5, dnh.b, str4);
                    i |= 32;
                    break;
                case 6:
                    num = num2;
                    dsoVar = (dso) acmVarP.i(dfxVar, 6, dsm.b, dsoVar);
                    i |= 64;
                    break;
                case 7:
                    num = num2;
                    str5 = (String) acmVarP.i(dfxVar, 7, dnh.b, str5);
                    i |= 128;
                    break;
                case 8:
                    num = num2;
                    dscVar = (dsc) acmVarP.i(dfxVar, 8, dsa.b, dscVar);
                    i |= 256;
                    break;
                case 9:
                    num = num2;
                    dsiVar = (dsi) acmVarP.i(dfxVar, 9, dsg.b, dsiVar);
                    i |= 512;
                    break;
                case 10:
                    num = num2;
                    dslVar = (dsl) acmVarP.i(dfxVar, 10, dsj.b, dslVar);
                    i |= 1024;
                    break;
                case 11:
                    num = num2;
                    dslVar2 = (dsl) acmVarP.i(dfxVar, 11, dsj.b, dslVar2);
                    i |= 2048;
                    break;
                default:
                    throw new bsd(iF);
            }
            num2 = num;
        }
        acmVarP._bp(dfxVar);
        return new drz(i, num2, str, num3, str2, str3, str4, dsoVar, str5, dscVar, dsiVar, dslVar, dslVar2);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        drz drzVar = (drz) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        bqj bqjVar = bqj.b;
        acnVarO.m(dfxVar, 0, bqjVar, drzVar.a);
        dnh dnhVar = dnh.b;
        acnVarO.m(dfxVar, 1, dnhVar, drzVar.b);
        acnVarO.m(dfxVar, 2, bqjVar, drzVar.c);
        acnVarO.m(dfxVar, 3, dnhVar, drzVar.d);
        acnVarO.m(dfxVar, 4, dnhVar, drzVar.e);
        acnVarO.m(dfxVar, 5, dnhVar, drzVar.f);
        acnVarO.m(dfxVar, 6, dsm.b, drzVar.g);
        acnVarO.m(dfxVar, 7, dnhVar, drzVar.h);
        acnVarO.m(dfxVar, 8, dsa.b, drzVar.i);
        acnVarO.m(dfxVar, 9, dsg.b, drzVar.j);
        dsj dsjVar = dsj.b;
        acnVarO.m(dfxVar, 10, dsjVar, drzVar.k);
        acnVarO.m(dfxVar, 11, dsjVar, drzVar.l);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        bqj bqjVar = bqj.b;
        btd btdVarT = aye.t(bqjVar);
        dnh dnhVar = dnh.b;
        btd btdVarT2 = aye.t(dnhVar);
        btd btdVarT3 = aye.t(bqjVar);
        btd btdVarT4 = aye.t(dnhVar);
        btd btdVarT5 = aye.t(dnhVar);
        btd btdVarT6 = aye.t(dnhVar);
        btd btdVarT7 = aye.t(dsm.b);
        btd btdVarT8 = aye.t(dnhVar);
        btd btdVarT9 = aye.t(dsa.b);
        btd btdVarT10 = aye.t(dsg.b);
        dsj dsjVar = dsj.b;
        return new btd[]{btdVarT, btdVarT2, btdVarT3, btdVarT4, btdVarT5, btdVarT6, btdVarT7, btdVarT8, btdVarT9, btdVarT10, aye.t(dsjVar), aye.t(dsjVar)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
