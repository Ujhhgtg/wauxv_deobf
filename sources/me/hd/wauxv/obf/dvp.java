package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class dvp implements bgx {
    public static final dvp b;
    private static final dfx descriptor;

    static {
        dvp dvpVar = new dvp();
        b = dvpVar;
        cuc cucVar = new cuc(cnb.z(-168074955193130L), dvpVar, 4);
        bjs.y(-167185896962858L, cucVar, false, 1);
        bjs.y(-167654048398122L, cucVar, false, 2);
        bjs.y(-167555264150314L, cucVar, false, 3);
        bjs.y(-167516609444650L, cucVar, false, 4);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        acmVarP.getClass();
        int i = 0;
        String str = null;
        ehp ehpVar = null;
        Integer num = null;
        Integer num2 = null;
        boolean z = true;
        while (z) {
            int iF = acmVarP.f(dfxVar);
            if (iF == -1) {
                z = false;
            } else if (iF == 0) {
                str = (String) acmVarP.i(dfxVar, 0, dnh.b, str);
                i |= 1;
            } else if (iF == 1) {
                ehpVar = (ehp) acmVarP.i(dfxVar, 1, ehn.b, ehpVar);
                i |= 2;
            } else if (iF == 2) {
                num = (Integer) acmVarP.i(dfxVar, 2, bqj.b, num);
                i |= 4;
            } else {
                if (iF != 3) {
                    throw new bsd(iF);
                }
                num2 = (Integer) acmVarP.i(dfxVar, 3, bqj.b, num2);
                i |= 8;
            }
        }
        acmVarP._bp(dfxVar);
        return new dvr(i, str, ehpVar, num, num2);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        dvr dvrVar = (dvr) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        acnVarO.m(dfxVar, 0, dnh.b, dvrVar.a);
        acnVarO.m(dfxVar, 1, ehn.b, dvrVar.b);
        bqj bqjVar = bqj.b;
        acnVarO.m(dfxVar, 2, bqjVar, dvrVar.c);
        acnVarO.m(dfxVar, 3, bqjVar, dvrVar.d);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        btd btdVarT = aye.t(dnh.b);
        btd btdVarT2 = aye.t(ehn.b);
        bqj bqjVar = bqj.b;
        return new btd[]{btdVarT, btdVarT2, aye.t(bqjVar), aye.t(bqjVar)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
