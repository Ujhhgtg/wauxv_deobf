package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class dvm implements bgx {
    public static final dvm b;
    private static final dfx descriptor;

    static {
        dvm dvmVar = new dvm();
        b = dvmVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.b22Proto" /* "me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.b22Proto" /* "me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.b22Proto" /* cnb.z(-171261820926762L)  */, dvmVar, 8);
        bjs.y(-170922518510378L, cucVar, false, 1);
        bjs.y(-170879568837418L, cucVar, false, 2);
        bjs.y(-170853799033642L, cucVar, false, 3);
        bjs.y(-170819439295274L, cucVar, false, 4);
        bjs.y(-170832324197162L, cucVar, false, 5);
        bjs.y(-170742129883946L, cucVar, false, 6);
        bjs.y(-170712065112874L, cucVar, false, 7);
        bjs.y(-167920336370474L, cucVar, false, 8);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        acmVarP.getClass();
        int i = 0;
        String str = null;
        Integer num = null;
        String str2 = null;
        String str3 = null;
        ehg ehgVar = null;
        String str4 = null;
        dzy dzyVar = null;
        String str5 = null;
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
                    num = (Integer) acmVarP.i(dfxVar, 1, bqj.b, num);
                    i |= 2;
                    break;
                case 2:
                    str2 = (String) acmVarP.i(dfxVar, 2, dnh.b, str2);
                    i |= 4;
                    break;
                case 3:
                    str3 = (String) acmVarP.i(dfxVar, 3, dnh.b, str3);
                    i |= 8;
                    break;
                case 4:
                    ehgVar = (ehg) acmVarP.i(dfxVar, 4, ehe.b, ehgVar);
                    i |= 16;
                    break;
                case 5:
                    str4 = (String) acmVarP.i(dfxVar, 5, dnh.b, str4);
                    i |= 32;
                    break;
                case 6:
                    dzyVar = (dzy) acmVarP.i(dfxVar, 6, dzw.b, dzyVar);
                    i |= 64;
                    break;
                case 7:
                    str5 = (String) acmVarP.i(dfxVar, 7, dnh.b, str5);
                    i |= 128;
                    break;
                default:
                    throw new bsd(iF);
            }
        }
        acmVarP._bp(dfxVar);
        return new dvo(i, str, num, str2, str3, ehgVar, str4, dzyVar, str5);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        dvo dvoVar = (dvo) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        dnh dnhVar = dnh.b;
        acnVarO.m(dfxVar, 0, dnhVar, dvoVar.a);
        acnVarO.m(dfxVar, 1, bqj.b, dvoVar.b);
        acnVarO.m(dfxVar, 2, dnhVar, dvoVar.c);
        acnVarO.m(dfxVar, 3, dnhVar, dvoVar.d);
        acnVarO.m(dfxVar, 4, ehe.b, dvoVar.e);
        acnVarO.m(dfxVar, 5, dnhVar, dvoVar.f);
        acnVarO.m(dfxVar, 6, dzw.b, dvoVar.g);
        acnVarO.m(dfxVar, 7, dnhVar, dvoVar.h);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        dnh dnhVar = dnh.b;
        return new btd[]{aye.t(dnhVar), aye.t(bqj.b), aye.t(dnhVar), aye.t(dnhVar), aye.t(ehe.b), aye.t(dnhVar), aye.t(dzw.b), aye.t(dnhVar)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
