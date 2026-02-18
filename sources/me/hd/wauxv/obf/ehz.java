package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ehz implements bgx {
    public static final ehz b;
    private static final dfx descriptor;

    static {
        ehz ehzVar = new ehz();
        b = ehzVar;
        cuc cucVar = new cuc(cnb.z(-332305914657578L), ehzVar, 1);
        bjs.y(-332516368055082L, cucVar, false, 1);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        acmVarP.getClass();
        Boolean bool = null;
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
                bool = (Boolean) acmVarP.i(dfxVar, 0, pv.b, bool);
                i = 1;
            }
        }
        acmVarP._bp(dfxVar);
        return new eib(bool, i);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        acnVarO.m(dfxVar, 0, pv.b, ((eib) obj).a);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        return new btd[]{aye.t(pv.b)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
