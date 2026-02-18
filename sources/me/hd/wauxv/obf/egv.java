package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class egv implements bgx {
    public static final egv b;
    private static final dfx descriptor;

    static {
        egv egvVar = new egv();
        b = egvVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.vq0Proto" /* cnb.z(-299810192096042L) */, egvVar, 2);
        bjs.y(-300020645493546L, cucVar, false, 1);
        bjs.y(-299990580722474L, cucVar, false, 2);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        acmVarP.getClass();
        dyi dyiVar = null;
        boolean z = true;
        int i = 0;
        dsy dsyVar = null;
        while (z) {
            int iF = acmVarP.f(dfxVar);
            if (iF == -1) {
                z = false;
            } else if (iF == 0) {
                dyiVar = (dyi) acmVarP.i(dfxVar, 0, dyg.b, dyiVar);
                i |= 1;
            } else {
                if (iF != 1) {
                    throw new bsd(iF);
                }
                dsyVar = (dsy) acmVarP.i(dfxVar, 1, dsw.b, dsyVar);
                i |= 2;
            }
        }
        acmVarP._bp(dfxVar);
        return new egx(i, dyiVar, dsyVar);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        egx egxVar = (egx) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        acnVarO.m(dfxVar, 0, dyg.b, egxVar.a);
        acnVarO.m(dfxVar, 1, dsw.b, egxVar.b);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        return new btd[]{aye.t(dyg.b), aye.t(dsw.b)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
