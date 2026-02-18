package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class egs implements bgx {
    public static final egs b;
    private static final dfx descriptor;

    static {
        egs egsVar = new egs();
        b = egsVar;
        cuc cucVar = new cuc(cnb.z(-303349245147946L), egsVar, 4);
        bjs.y(-302460186917674L, cucVar, false, 1);
        bjs.y(-302430122146602L, cucVar, false, 2);
        bjs.y(-302898273581866L, cucVar, false, 3);
        bjs.y(-302881093712682L, cucVar, false, 4);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        acmVarP.getClass();
        int i = 0;
        String str = null;
        Integer num = null;
        Integer num2 = null;
        Integer num3 = null;
        boolean z = true;
        while (z) {
            int iF = acmVarP.f(dfxVar);
            if (iF == -1) {
                z = false;
            } else if (iF == 0) {
                str = (String) acmVarP.i(dfxVar, 0, dnh.b, str);
                i |= 1;
            } else if (iF == 1) {
                num = (Integer) acmVarP.i(dfxVar, 1, bqj.b, num);
                i |= 2;
            } else if (iF == 2) {
                num2 = (Integer) acmVarP.i(dfxVar, 2, bqj.b, num2);
                i |= 4;
            } else {
                if (iF != 3) {
                    throw new bsd(iF);
                }
                num3 = (Integer) acmVarP.i(dfxVar, 3, bqj.b, num3);
                i |= 8;
            }
        }
        acmVarP._bp(dfxVar);
        return new egu(i, str, num, num2, num3);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        egu eguVar = (egu) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        acnVarO.m(dfxVar, 0, dnh.b, eguVar.a);
        bqj bqjVar = bqj.b;
        acnVarO.m(dfxVar, 1, bqjVar, eguVar.b);
        acnVarO.m(dfxVar, 2, bqjVar, eguVar.c);
        acnVarO.m(dfxVar, 3, bqjVar, eguVar.d);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        btd btdVarT = aye.t(dnh.b);
        bqj bqjVar = bqj.b;
        return new btd[]{btdVarT, aye.t(bqjVar), aye.t(bqjVar), aye.t(bqjVar)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
