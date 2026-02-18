package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class efh implements bgx {
    public static final efh b;
    private static final dfx descriptor;

    static {
        efh efhVar = new efh();
        b = efhVar;
        cuc cucVar = new cuc(cnb.z(-282531538664234L), efhVar, 1);
        bjs.y(-281625300564778L, cucVar, false, 1);
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
        while (z) {
            int iF = acmVarP.f(dfxVar);
            if (iF == -1) {
                z = false;
            } else {
                if (iF != 0) {
                    throw new bsd(iF);
                }
                dsyVar = (dsy) acmVarP.i(dfxVar, 0, dsw.b, dsyVar);
                i = 1;
            }
        }
        acmVarP._bp(dfxVar);
        return new efj(i, dsyVar);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        acnVarO.m(dfxVar, 0, dsw.b, ((efj) obj).a);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        return new btd[]{aye.t(dsw.b)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
