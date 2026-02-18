package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class dwn implements bgx {
    public static final dwn b;
    private static final dfx descriptor;

    static {
        dwn dwnVar = new dwn();
        b = dwnVar;
        cuc cucVar = new cuc(cnb.z(-159459250797354L), dwnVar, 2);
        bjs.y(-165717018147626L, cucVar, false, 1);
        bjs.y(-165601054030634L, cucVar, false, 2);
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
        Integer num = null;
        while (z) {
            int iF = acmVarP.f(dfxVar);
            if (iF == -1) {
                z = false;
            } else if (iF == 0) {
                bool = (Boolean) acmVarP.i(dfxVar, 0, pv.b, bool);
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
        return new dwp(i, bool, num);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        dwp dwpVar = (dwp) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        acnVarO.m(dfxVar, 0, pv.b, dwpVar.a);
        acnVarO.m(dfxVar, 1, bqj.b, dwpVar.b);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        return new btd[]{aye.t(pv.b), aye.t(bqj.b)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
