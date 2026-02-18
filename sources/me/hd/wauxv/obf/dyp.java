package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class dyp implements bgx {
    public static final dyp b;
    private static final dfx descriptor;

    static {
        dyp dypVar = new dyp();
        b = dypVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.il1Proto" /* cnb.z(-208722525682474L) */, dypVar, 3);
        bjs.y(-207833467452202L, cucVar, false, 1);
        bjs.y(-208262964181802L, cucVar, false, 2);
        bjs.y(-208232899410730L, cucVar, false, 3);
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
        Integer num2 = null;
        Long l = null;
        while (z) {
            int iF = acmVarP.f(dfxVar);
            if (iF == -1) {
                z = false;
            } else if (iF == 0) {
                num = (Integer) acmVarP.i(dfxVar, 0, bqj.b, num);
                i |= 1;
            } else if (iF == 1) {
                num2 = (Integer) acmVarP.i(dfxVar, 1, bqj.b, num2);
                i |= 2;
            } else {
                if (iF != 2) {
                    throw new bsd(iF);
                }
                l = (Long) acmVarP.i(dfxVar, 2, bya.b, l);
                i |= 4;
            }
        }
        acmVarP._bp(dfxVar);
        return new dyr(i, num, num2, l);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        dyr dyrVar = (dyr) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        bqj bqjVar = bqj.b;
        acnVarO.m(dfxVar, 0, bqjVar, dyrVar.a);
        acnVarO.m(dfxVar, 1, bqjVar, dyrVar.b);
        acnVarO.m(dfxVar, 2, bya.b, dyrVar.c);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        bqj bqjVar = bqj.b;
        return new btd[]{aye.t(bqjVar), aye.t(bqjVar), aye.t(bya.b)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
