package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class dvs implements bgx {
    public static final dvs b;
    private static final dfx descriptor;

    static {
        dvs dvsVar = new dvs();
        b = dvsVar;
        cuc cucVar = new cuc(cnb.z(-169260366166826L), dvsVar, 4);
        bjs.y(-168371307936554L, cucVar, false, 1);
        bjs.y(-168319768329002L, cucVar, false, 2);
        bjs.y(-168749265058602L, cucVar, false, 3);
        bjs.y(-168646185843498L, cucVar, false, 4);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        acmVarP.getClass();
        int i = 0;
        Integer num = null;
        Integer num2 = null;
        Integer num3 = null;
        Integer num4 = null;
        boolean z = true;
        while (z) {
            int iF = acmVarP.f(dfxVar);
            if (iF == -1) {
                z = false;
            } else if (iF == 0) {
                num = (Integer) acmVarP.i(dfxVar, 0, bqj.b, num);
                i |= 1;
            } else if (iF == 1) {
                num2 = (Integer) acmVarP.i(dfxVar, 1, bqj.b, num2);
                i |= 2;
            } else if (iF == 2) {
                num3 = (Integer) acmVarP.i(dfxVar, 2, bqj.b, num3);
                i |= 4;
            } else {
                if (iF != 3) {
                    throw new bsd(iF);
                }
                num4 = (Integer) acmVarP.i(dfxVar, 3, bqj.b, num4);
                i |= 8;
            }
        }
        acmVarP._bp(dfxVar);
        return new dvu(i, num, num2, num3, num4);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        dvu dvuVar = (dvu) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        bqj bqjVar = bqj.b;
        acnVarO.m(dfxVar, 0, bqjVar, dvuVar.a);
        acnVarO.m(dfxVar, 1, bqjVar, dvuVar.b);
        acnVarO.m(dfxVar, 2, bqjVar, dvuVar.c);
        acnVarO.m(dfxVar, 3, bqjVar, dvuVar.d);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        bqj bqjVar = bqj.b;
        return new btd[]{aye.t(bqjVar), aye.t(bqjVar), aye.t(bqjVar), aye.t(bqjVar)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
