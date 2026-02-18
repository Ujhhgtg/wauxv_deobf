package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class eir implements bgx {
    public static final eir b;
    private static final dfx descriptor;

    static {
        eir eirVar = new eir();
        b = eirVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.xq5Proto" /* cnb.z(-324308685552426L) */, eirVar, 2);
        bjs.y(-323419627322154L, cucVar, false, 1);
        bjs.y(-323269303466794L, cucVar, false, 2);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        acmVarP.getClass();
        Long l = null;
        boolean z = true;
        int i = 0;
        Long l2 = null;
        while (z) {
            int iF = acmVarP.f(dfxVar);
            if (iF == -1) {
                z = false;
            } else if (iF == 0) {
                l = (Long) acmVarP.i(dfxVar, 0, bya.b, l);
                i |= 1;
            } else {
                if (iF != 1) {
                    throw new bsd(iF);
                }
                l2 = (Long) acmVarP.i(dfxVar, 1, bya.b, l2);
                i |= 2;
            }
        }
        acmVarP._bp(dfxVar);
        return new eit(i, l, l2);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        eit eitVar = (eit) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        bya byaVar = bya.b;
        acnVarO.m(dfxVar, 0, byaVar, eitVar.a);
        acnVarO.m(dfxVar, 1, byaVar, eitVar.b);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        bya byaVar = bya.b;
        return new btd[]{aye.t(byaVar), aye.t(byaVar)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
