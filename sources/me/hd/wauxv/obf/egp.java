package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class egp implements bgx {
    public static final egp b;
    private static final dfx descriptor;

    static {
        egp egpVar = new egp();
        b = egpVar;
        cuc cucVar = new cuc(cnb.z(-313974994238250L), egpVar, 3);
        bjs.y(-313635691821866L, cucVar, false, 1);
        bjs.y(-313566972345130L, cucVar, false, 2);
        bjs.y(-313481072999210L, cucVar, false, 3);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        acmVarP.getClass();
        String str = null;
        boolean z = true;
        int i = 0;
        String str2 = null;
        Integer num = null;
        while (z) {
            int iF = acmVarP.f(dfxVar);
            if (iF == -1) {
                z = false;
            } else if (iF == 0) {
                str = (String) acmVarP.i(dfxVar, 0, dnh.b, str);
                i |= 1;
            } else if (iF == 1) {
                str2 = (String) acmVarP.i(dfxVar, 1, dnh.b, str2);
                i |= 2;
            } else {
                if (iF != 2) {
                    throw new bsd(iF);
                }
                num = (Integer) acmVarP.i(dfxVar, 2, bqj.b, num);
                i |= 4;
            }
        }
        acmVarP._bp(dfxVar);
        return new egr(i, num, str, str2);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        egr egrVar = (egr) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        dnh dnhVar = dnh.b;
        acnVarO.m(dfxVar, 0, dnhVar, egrVar.a);
        acnVarO.m(dfxVar, 1, dnhVar, egrVar.b);
        acnVarO.m(dfxVar, 2, bqj.b, egrVar.c);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        dnh dnhVar = dnh.b;
        return new btd[]{aye.t(dnhVar), aye.t(dnhVar), aye.t(bqj.b)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
