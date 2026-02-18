package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class dvv implements bgx {
    public static final dvv b;
    private static final dfx descriptor;

    static {
        dvv dvvVar = new dvv();
        b = dvvVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.bf1Proto" /* cnb.z(-174697794763562L) */, dvvVar, 5);
        bjs.y(-173808736533290L, cucVar, false, 1);
        bjs.y(-173791556664106L, cucVar, false, 2);
        bjs.y(-173752901958442L, cucVar, false, 3);
        bjs.y(-174233938295594L, cucVar, false, 4);
        bjs.y(-174148038949674L, cucVar, false, 5);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        acmVarP.getClass();
        int i = 0;
        dyu dyuVar = null;
        Integer num = null;
        String str = null;
        String str2 = null;
        Long l = null;
        boolean z = true;
        while (z) {
            int iF = acmVarP.f(dfxVar);
            if (iF == -1) {
                z = false;
            } else if (iF == 0) {
                dyuVar = (dyu) acmVarP.i(dfxVar, 0, dys.b, dyuVar);
                i |= 1;
            } else if (iF == 1) {
                num = (Integer) acmVarP.i(dfxVar, 1, bqj.b, num);
                i |= 2;
            } else if (iF == 2) {
                str = (String) acmVarP.i(dfxVar, 2, dnh.b, str);
                i |= 4;
            } else if (iF == 3) {
                str2 = (String) acmVarP.i(dfxVar, 3, dnh.b, str2);
                i |= 8;
            } else {
                if (iF != 4) {
                    throw new bsd(iF);
                }
                l = (Long) acmVarP.i(dfxVar, 4, bya.b, l);
                i |= 16;
            }
        }
        acmVarP._bp(dfxVar);
        return new dvx(i, dyuVar, num, str, str2, l);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        dvx dvxVar = (dvx) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        acnVarO.m(dfxVar, 0, dys.b, dvxVar.a);
        acnVarO.m(dfxVar, 1, bqj.b, dvxVar.b);
        dnh dnhVar = dnh.b;
        acnVarO.m(dfxVar, 2, dnhVar, dvxVar.c);
        acnVarO.m(dfxVar, 3, dnhVar, dvxVar.d);
        acnVarO.m(dfxVar, 4, bya.b, dvxVar.e);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        btd btdVarT = aye.t(dys.b);
        btd btdVarT2 = aye.t(bqj.b);
        dnh dnhVar = dnh.b;
        return new btd[]{btdVarT, btdVarT2, aye.t(dnhVar), aye.t(dnhVar), aye.t(bya.b)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
