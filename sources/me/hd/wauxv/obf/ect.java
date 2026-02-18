package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ect implements bgx {
    public static final ect b;
    private static final dfx descriptor;

    static {
        ect ectVar = new ect();
        b = ectVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.or5Proto" /* cnb.z(-249537599896362L) */, ectVar, 5);
        bjs.y(-248631361796906L, cucVar, false, 1);
        bjs.y(-248571232254762L, cucVar, false, 2);
        bjs.y(-248545462450986L, cucVar, false, 3);
        bjs.y(-249030793755434L, cucVar, false, 4);
        bjs.y(-248884764867370L, cucVar, false, 5);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        acmVarP.getClass();
        int i = 0;
        dvu dvuVar = null;
        Integer num = null;
        String str = null;
        Integer num2 = null;
        Integer num3 = null;
        boolean z = true;
        while (z) {
            int iF = acmVarP.f(dfxVar);
            if (iF == -1) {
                z = false;
            } else if (iF == 0) {
                dvuVar = (dvu) acmVarP.i(dfxVar, 0, dvs.b, dvuVar);
                i |= 1;
            } else if (iF == 1) {
                num = (Integer) acmVarP.i(dfxVar, 1, bqj.b, num);
                i |= 2;
            } else if (iF == 2) {
                str = (String) acmVarP.i(dfxVar, 2, dnh.b, str);
                i |= 4;
            } else if (iF == 3) {
                num2 = (Integer) acmVarP.i(dfxVar, 3, bqj.b, num2);
                i |= 8;
            } else {
                if (iF != 4) {
                    throw new bsd(iF);
                }
                num3 = (Integer) acmVarP.i(dfxVar, 4, bqj.b, num3);
                i |= 16;
            }
        }
        acmVarP._bp(dfxVar);
        return new ecv(i, dvuVar, num, str, num2, num3);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        ecv ecvVar = (ecv) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        acnVarO.m(dfxVar, 0, dvs.b, ecvVar.a);
        bqj bqjVar = bqj.b;
        acnVarO.m(dfxVar, 1, bqjVar, ecvVar.b);
        acnVarO.m(dfxVar, 2, dnh.b, ecvVar.c);
        acnVarO.m(dfxVar, 3, bqjVar, ecvVar.d);
        acnVarO.m(dfxVar, 4, bqjVar, ecvVar.e);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        btd btdVarT = aye.t(dvs.b);
        bqj bqjVar = bqj.b;
        return new btd[]{btdVarT, aye.t(bqjVar), aye.t(dnh.b), aye.t(bqjVar), aye.t(bqjVar)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
