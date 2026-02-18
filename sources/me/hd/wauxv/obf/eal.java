package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class eal implements bgx {
    public static final eal b;
    private static final dfx descriptor;

    static {
        eal ealVar = new eal();
        b = ealVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.m81Proto" /* cnb.z(-214812789308202L) */, ealVar, 5);
        bjs.y(-211724707822378L, cucVar, false, 1);
        bjs.y(-211686053116714L, cucVar, false, 2);
        bjs.y(-212128434748202L, cucVar, false, 3);
        bjs.y(-212038240434986L, cucVar, false, 4);
        bjs.y(-212029650500394L, cucVar, false, 5);
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
        Integer num4 = null;
        dxn dxnVar = null;
        boolean z = true;
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
            } else if (iF == 2) {
                num3 = (Integer) acmVarP.i(dfxVar, 2, bqj.b, num3);
                i |= 4;
            } else if (iF == 3) {
                num4 = (Integer) acmVarP.i(dfxVar, 3, bqj.b, num4);
                i |= 8;
            } else {
                if (iF != 4) {
                    throw new bsd(iF);
                }
                dxnVar = (dxn) acmVarP.i(dfxVar, 4, dxl.b, dxnVar);
                i |= 16;
            }
        }
        acmVarP._bp(dfxVar);
        return new ean(i, num, num2, num3, num4, dxnVar);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        ean eanVar = (ean) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        bqj bqjVar = bqj.b;
        acnVarO.m(dfxVar, 0, bqjVar, eanVar.a);
        acnVarO.m(dfxVar, 1, bqjVar, eanVar.b);
        acnVarO.m(dfxVar, 2, bqjVar, eanVar.c);
        acnVarO.m(dfxVar, 3, bqjVar, eanVar.d);
        acnVarO.m(dfxVar, 4, dxl.b, eanVar.e);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        bqj bqjVar = bqj.b;
        return new btd[]{aye.t(bqjVar), aye.t(bqjVar), aye.t(bqjVar), aye.t(bqjVar), aye.t(dxl.b)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
