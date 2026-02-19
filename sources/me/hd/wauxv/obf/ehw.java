package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ehw implements bgx {
    public static final ehw b;
    private static final dfx descriptor;

    static {
        ehw ehwVar = new ehw();
        b = ehwVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.wq0Proto" /* "me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.wq0Proto" /* "me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.wq0Proto" /* "me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.wq0Proto" /* cnb.z(-326765406845738L)   */, ehwVar, 4);
        bjs.y(-326975860243242L, cucVar, false, 1);
        bjs.y(-326962975341354L, cucVar, false, 2);
        bjs.y(-326838421289770L, cucVar, false, 3);
        bjs.y(-332877145307946L, cucVar, false, 4);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        acmVarP.getClass();
        int i = 0;
        Long l = null;
        Integer num = null;
        String str = null;
        String str2 = null;
        boolean z = true;
        while (z) {
            int iF = acmVarP.f(dfxVar);
            if (iF == -1) {
                z = false;
            } else if (iF == 0) {
                l = (Long) acmVarP.i(dfxVar, 0, bya.b, l);
                i |= 1;
            } else if (iF == 1) {
                num = (Integer) acmVarP.i(dfxVar, 1, bqj.b, num);
                i |= 2;
            } else if (iF == 2) {
                str = (String) acmVarP.i(dfxVar, 2, dnh.b, str);
                i |= 4;
            } else {
                if (iF != 3) {
                    throw new bsd(iF);
                }
                str2 = (String) acmVarP.i(dfxVar, 3, dnh.b, str2);
                i |= 8;
            }
        }
        acmVarP._bp(dfxVar);
        return new ehy(i, l, num, str, str2);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        ehy ehyVar = (ehy) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        acnVarO.m(dfxVar, 0, bya.b, ehyVar.a);
        acnVarO.m(dfxVar, 1, bqj.b, ehyVar.b);
        dnh dnhVar = dnh.b;
        acnVarO.m(dfxVar, 2, dnhVar, ehyVar.c);
        acnVarO.m(dfxVar, 3, dnhVar, ehyVar.d);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        btd btdVarT = aye.t(bya.b);
        btd btdVarT2 = aye.t(bqj.b);
        dnh dnhVar = dnh.b;
        return new btd[]{btdVarT, btdVarT2, aye.t(dnhVar), aye.t(dnhVar)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
