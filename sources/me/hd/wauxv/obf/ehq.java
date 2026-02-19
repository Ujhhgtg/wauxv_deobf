package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ehq implements bgx {
    public static final ehq b;
    private static final dfx descriptor;

    static {
        ehq ehqVar = new ehq();
        b = ehqVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.wa3Proto" /* "me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.wa3Proto" /* "me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.wa3Proto" /* cnb.z(-303611238153002L)  */, ehqVar, 3);
        bjs.y(-303873231158058L, cucVar, false, 1);
        bjs.y(-303800216714026L, cucVar, false, 2);
        bjs.y(-305385059646250L, cucVar, false, 3);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        acmVarP.getClass();
        Integer num = null;
        boolean z = true;
        int i = 0;
        String str = null;
        String str2 = null;
        while (z) {
            int iF = acmVarP.f(dfxVar);
            if (iF == -1) {
                z = false;
            } else if (iF == 0) {
                num = (Integer) acmVarP.i(dfxVar, 0, bqj.b, num);
                i |= 1;
            } else if (iF == 1) {
                str = (String) acmVarP.i(dfxVar, 1, dnh.b, str);
                i |= 2;
            } else {
                if (iF != 2) {
                    throw new bsd(iF);
                }
                str2 = (String) acmVarP.i(dfxVar, 2, dnh.b, str2);
                i |= 4;
            }
        }
        acmVarP._bp(dfxVar);
        return new ehs(i, num, str, str2);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        ehs ehsVar = (ehs) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        acnVarO.m(dfxVar, 0, bqj.b, ehsVar.a);
        dnh dnhVar = dnh.b;
        acnVarO.m(dfxVar, 1, dnhVar, ehsVar.b);
        acnVarO.m(dfxVar, 2, dnhVar, ehsVar.c);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        btd btdVarT = aye.t(bqj.b);
        dnh dnhVar = dnh.b;
        return new btd[]{btdVarT, aye.t(dnhVar), aye.t(dnhVar)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
