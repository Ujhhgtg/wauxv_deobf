package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ejp implements bgx {
    public static final ejp b;
    private static final dfx descriptor;

    static {
        ejp ejpVar = new ejp();
        b = ejpVar;
        cuc cucVar = new cuc(cnb.z(-345061967526698L), ejpVar, 4);
        bjs.y(-344172909296426L, cucVar, false, 1);
        bjs.y(-344636765764394L, cucVar, false, 2);
        bjs.y(-344606700993322L, cucVar, false, 3);
        bjs.y(-344589521124138L, cucVar, false, 4);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        acmVarP.getClass();
        int i = 0;
        Integer num = null;
        Long l = null;
        Long l2 = null;
        String str = null;
        boolean z = true;
        while (z) {
            int iF = acmVarP.f(dfxVar);
            if (iF == -1) {
                z = false;
            } else if (iF == 0) {
                num = (Integer) acmVarP.i(dfxVar, 0, bqj.b, num);
                i |= 1;
            } else if (iF == 1) {
                l = (Long) acmVarP.i(dfxVar, 1, bya.b, l);
                i |= 2;
            } else if (iF == 2) {
                l2 = (Long) acmVarP.i(dfxVar, 2, bya.b, l2);
                i |= 4;
            } else {
                if (iF != 3) {
                    throw new bsd(iF);
                }
                str = (String) acmVarP.i(dfxVar, 3, dnh.b, str);
                i |= 8;
            }
        }
        acmVarP._bp(dfxVar);
        return new ejr(i, num, l, l2, str);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        ejr ejrVar = (ejr) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        acnVarO.m(dfxVar, 0, bqj.b, ejrVar.a);
        bya byaVar = bya.b;
        acnVarO.m(dfxVar, 1, byaVar, ejrVar.b);
        acnVarO.m(dfxVar, 2, byaVar, ejrVar.c);
        acnVarO.m(dfxVar, 3, dnh.b, ejrVar.d);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        btd btdVarT = aye.t(bqj.b);
        bya byaVar = bya.b;
        return new btd[]{btdVarT, aye.t(byaVar), aye.t(byaVar), aye.t(dnh.b)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
