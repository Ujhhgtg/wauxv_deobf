package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ece implements bgx {
    public static final ece b;
    private static final dfx descriptor;

    static {
        ece eceVar = new ece();
        b = eceVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.o51Proto" /* "me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.o51Proto" /* "me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.o51Proto" /* "me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.o51Proto" /* cnb.z(-263457588902698L)   */, eceVar, 6);
        bjs.y(-263668042300202L, cucVar, false, 1);
        bjs.y(-263637977529130L, cucVar, false, 2);
        bjs.y(-263010912303914L, cucVar, false, 3);
        bjs.y(-262925012957994L, cucVar, false, 4);
        bjs.y(-262869178383146L, cucVar, false, 5);
        bjs.y(-262839113612074L, cucVar, false, 6);
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
        Integer num3 = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        boolean z = true;
        while (z) {
            int iF = acmVarP.f(dfxVar);
            switch (iF) {
                case -1:
                    z = false;
                    break;
                case 0:
                    num = (Integer) acmVarP.i(dfxVar, 0, bqj.b, num);
                    i |= 1;
                    break;
                case 1:
                    str = (String) acmVarP.i(dfxVar, 1, dnh.b, str);
                    i |= 2;
                    break;
                case 2:
                    num2 = (Integer) acmVarP.i(dfxVar, 2, bqj.b, num2);
                    i |= 4;
                    break;
                case 3:
                    str2 = (String) acmVarP.i(dfxVar, 3, dnh.b, str2);
                    i |= 8;
                    break;
                case 4:
                    str3 = (String) acmVarP.i(dfxVar, 4, dnh.b, str3);
                    i |= 16;
                    break;
                case 5:
                    num3 = (Integer) acmVarP.i(dfxVar, 5, bqj.b, num3);
                    i |= 32;
                    break;
                default:
                    throw new bsd(iF);
            }
        }
        acmVarP._bp(dfxVar);
        return new ecg(i, num, num2, num3, str, str2, str3);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        ecg ecgVar = (ecg) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        bqj bqjVar = bqj.b;
        acnVarO.m(dfxVar, 0, bqjVar, ecgVar.a);
        dnh dnhVar = dnh.b;
        acnVarO.m(dfxVar, 1, dnhVar, ecgVar.b);
        acnVarO.m(dfxVar, 2, bqjVar, ecgVar.c);
        acnVarO.m(dfxVar, 3, dnhVar, ecgVar.d);
        acnVarO.m(dfxVar, 4, dnhVar, ecgVar.e);
        acnVarO.m(dfxVar, 5, bqjVar, ecgVar.f);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        bqj bqjVar = bqj.b;
        btd btdVarT = aye.t(bqjVar);
        dnh dnhVar = dnh.b;
        return new btd[]{btdVarT, aye.t(dnhVar), aye.t(bqjVar), aye.t(dnhVar), aye.t(dnhVar), aye.t(bqjVar)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
