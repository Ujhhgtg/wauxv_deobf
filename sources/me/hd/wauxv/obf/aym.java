package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class aym implements bgx {
    public static final aym b;
    private static final dfx descriptor;

    static {
        aym aymVar = new aym();
        b = aymVar;
        cuc cucVar = new cuc(cnb.z(-123497489627946L), aymVar, 1);
        cucVar.x(cnb.z(-124850404326186L), false);
        cucVar.y(new aoz(2, 2));
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        acmVarP.getClass();
        String strD = null;
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
                strD = acmVarP.d(dfxVar, 0);
                i = 1;
            }
        }
        acmVarP._bp(dfxVar);
        return new ayo(i, strD);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        acnVarO.l(dfxVar, 0, ((ayo) obj).a);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        return new btd[]{dnh.b};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
