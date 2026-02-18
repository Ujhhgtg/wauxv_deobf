package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class egy implements bgx {
    public static final egy b;
    private static final dfx descriptor;

    static {
        egy egyVar = new egy();
        b = egyVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.vq5Proto" /* cnb.z(-299269026216746L) */, egyVar, 4);
        bjs.y(-299479479614250L, cucVar, false, 1);
        bjs.y(-299419350072106L, cucVar, false, 2);
        bjs.y(-299427940006698L, cucVar, false, 3);
        bjs.y(-299436529941290L, cucVar, false, 4);
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
            } else {
                if (iF != 3) {
                    throw new bsd(iF);
                }
                num4 = (Integer) acmVarP.i(dfxVar, 3, bqj.b, num4);
                i |= 8;
            }
        }
        acmVarP._bp(dfxVar);
        return new eha(i, num, num2, num3, num4);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        eha ehaVar = (eha) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        bqj bqjVar = bqj.b;
        acnVarO.m(dfxVar, 0, bqjVar, ehaVar.a);
        acnVarO.m(dfxVar, 1, bqjVar, ehaVar.b);
        acnVarO.m(dfxVar, 2, bqjVar, ehaVar.c);
        acnVarO.m(dfxVar, 3, bqjVar, ehaVar.d);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        bqj bqjVar = bqj.b;
        return new btd[]{aye.t(bqjVar), aye.t(bqjVar), aye.t(bqjVar), aye.t(bqjVar)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
