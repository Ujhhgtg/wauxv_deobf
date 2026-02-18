package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ecw implements bgx {
    public static final ecw b;
    private static final dfx descriptor;

    static {
        ecw ecwVar = new ecw();
        b = ecwVar;
        cuc cucVar = new cuc(cnb.z(-250521147407146L), ecwVar, 2);
        bjs.y(-249632089176874L, cucVar, false, 1);
        bjs.y(-250138895317802L, cucVar, false, 2);
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
        String str = null;
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
                str = (String) acmVarP.i(dfxVar, 1, dnh.b, str);
                i |= 2;
            }
        }
        acmVarP._bp(dfxVar);
        return new ecy(i, bool, str);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        ecy ecyVar = (ecy) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        acnVarO.m(dfxVar, 0, pv.b, ecyVar.a);
        acnVarO.m(dfxVar, 1, dnh.b, ecyVar.b);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        return new btd[]{aye.t(pv.b), aye.t(dnh.b)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
