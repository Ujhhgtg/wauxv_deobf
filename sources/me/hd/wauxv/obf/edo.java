package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class edo implements bgx {
    public static final edo b;
    private static final dfx descriptor;

    static {
        edo edoVar = new edo();
        b = edoVar;
        cuc cucVar = new cuc(cnb.z(-275517857069866L), edoVar, 2);
        bjs.y(-275728310467370L, cucVar, false, 1);
        bjs.y(-275152784849706L, cucVar, false, 2);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        acmVarP.getClass();
        Integer num = null;
        boolean z = true;
        int i = 0;
        Integer num2 = null;
        while (z) {
            int iF = acmVarP.f(dfxVar);
            if (iF == -1) {
                z = false;
            } else if (iF == 0) {
                num = (Integer) acmVarP.i(dfxVar, 0, bqj.b, num);
                i |= 1;
            } else {
                if (iF != 1) {
                    throw new bsd(iF);
                }
                num2 = (Integer) acmVarP.i(dfxVar, 1, bqj.b, num2);
                i |= 2;
            }
        }
        acmVarP._bp(dfxVar);
        return new edq(i, num, num2);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        edq edqVar = (edq) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        bqj bqjVar = bqj.b;
        acnVarO.m(dfxVar, 0, bqjVar, edqVar.a);
        acnVarO.m(dfxVar, 1, bqjVar, edqVar.b);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        bqj bqjVar = bqj.b;
        return new btd[]{aye.t(bqjVar), aye.t(bqjVar)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
