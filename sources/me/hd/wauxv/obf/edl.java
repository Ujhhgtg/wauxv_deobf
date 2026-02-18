package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class edl implements bgx {
    public static final edl b;
    private static final dfx descriptor;

    static {
        edl edlVar = new edl();
        b = edlVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.q72Proto" /* cnb.z(-251947076549418L) */, edlVar, 2);
        bjs.y(-252157529946922L, cucVar, false, 1);
        bjs.y(-252123170208554L, cucVar, false, 2);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        acmVarP.getClass();
        dsy dsyVar = null;
        boolean z = true;
        int i = 0;
        Integer num = null;
        while (z) {
            int iF = acmVarP.f(dfxVar);
            if (iF == -1) {
                z = false;
            } else if (iF == 0) {
                dsyVar = (dsy) acmVarP.i(dfxVar, 0, dsw.b, dsyVar);
                i |= 1;
            } else {
                if (iF != 1) {
                    throw new bsd(iF);
                }
                num = (Integer) acmVarP.i(dfxVar, 1, bqj.b, num);
                i |= 2;
            }
        }
        acmVarP._bp(dfxVar);
        return new edn(i, dsyVar, num);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        edn ednVar = (edn) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        acnVarO.m(dfxVar, 0, dsw.b, ednVar.a);
        acnVarO.m(dfxVar, 1, bqj.b, ednVar.b);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        return new btd[]{aye.t(dsw.b), aye.t(bqj.b)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
