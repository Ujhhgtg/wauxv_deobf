package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class edf implements bgx {
    public static final edf b;
    private static final dfx descriptor;

    static {
        edf edfVar = new edf();
        b = edfVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.pk3Proto" /* cnb.z(-252999343536938L) */, edfVar, 9);
        bjs.y(-253261336541994L, cucVar, false, 1);
        bjs.y(-254751690193706L, cucVar, false, 2);
        bjs.y(-254695855618858L, cucVar, false, 3);
        bjs.y(-254597071371050L, cucVar, false, 4);
        bjs.y(-255039453002538L, cucVar, false, 5);
        bjs.y(-254889129147178L, cucVar, false, 6);
        bjs.y(-254214819281706L, cucVar, false, 7);
        bjs.y(-253995775949610L, cucVar, false, 8);
        bjs.y(-254420977711914L, cucVar, false, 9);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        acmVarP.getClass();
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        int i = 0;
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
                    str3 = (String) acmVarP.i(dfxVar, 2, dnh.b, str3);
                    i |= 4;
                    break;
                case 3:
                    str4 = (String) acmVarP.i(dfxVar, 3, dnh.b, str4);
                    i |= 8;
                    break;
                case 4:
                    str5 = (String) acmVarP.i(dfxVar, 4, dnh.b, str5);
                    i |= 16;
                    break;
                case 5:
                    str6 = (String) acmVarP.i(dfxVar, 5, dnh.b, str6);
                    i |= 32;
                    break;
                case 6:
                    str7 = (String) acmVarP.i(dfxVar, 6, dnh.b, str7);
                    i |= 64;
                    break;
                case 7:
                    str8 = (String) acmVarP.i(dfxVar, 7, dnh.b, str8);
                    i |= 128;
                    break;
                case 8:
                    str9 = (String) acmVarP.i(dfxVar, 8, dnh.b, str9);
                    i |= 256;
                    break;
                default:
                    throw new bsd(iF);
            }
        }
        acmVarP._bp(dfxVar);
        return new edh(i, str, str2, str3, str4, str5, str6, str7, str8, str9);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        edh edhVar = (edh) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        dnh dnhVar = dnh.b;
        acnVarO.m(dfxVar, 0, dnhVar, edhVar.a);
        acnVarO.m(dfxVar, 1, dnhVar, edhVar.b);
        acnVarO.m(dfxVar, 2, dnhVar, edhVar.c);
        acnVarO.m(dfxVar, 3, dnhVar, edhVar.d);
        acnVarO.m(dfxVar, 4, dnhVar, edhVar.e);
        acnVarO.m(dfxVar, 5, dnhVar, edhVar.f);
        acnVarO.m(dfxVar, 6, dnhVar, edhVar.g);
        acnVarO.m(dfxVar, 7, dnhVar, edhVar.h);
        acnVarO.m(dfxVar, 8, dnhVar, edhVar.i);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        dnh dnhVar = dnh.b;
        return new btd[]{aye.t(dnhVar), aye.t(dnhVar), aye.t(dnhVar), aye.t(dnhVar), aye.t(dnhVar), aye.t(dnhVar), aye.t(dnhVar), aye.t(dnhVar), aye.t(dnhVar)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
