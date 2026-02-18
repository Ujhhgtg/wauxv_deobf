package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class dsm implements bgx {
    public static final dsm b;
    private static final dfx descriptor;

    static {
        dsm dsmVar = new dsm();
        b = dsmVar;
        cuc cucVar = new cuc(cnb.z(-145607981267754L), dsmVar, 4);
        bjs.y(-146922241260330L, cucVar, false, 1);
        bjs.y(-146879291587370L, cucVar, false, 2);
        bjs.y(-146789097274154L, cucVar, false, 3);
        bjs.y(-147325968186154L, cucVar, false, 4);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        acmVarP.getClass();
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        boolean z = true;
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
            } else if (iF == 2) {
                str3 = (String) acmVarP.i(dfxVar, 2, dnh.b, str3);
                i |= 4;
            } else {
                if (iF != 3) {
                    throw new bsd(iF);
                }
                str4 = (String) acmVarP.i(dfxVar, 3, dnh.b, str4);
                i |= 8;
            }
        }
        acmVarP._bp(dfxVar);
        return new dso(str, str2, str3, i, str4);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        dso dsoVar = (dso) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        dnh dnhVar = dnh.b;
        acnVarO.m(dfxVar, 0, dnhVar, dsoVar.a);
        acnVarO.m(dfxVar, 1, dnhVar, dsoVar.b);
        acnVarO.m(dfxVar, 2, dnhVar, dsoVar.c);
        acnVarO.m(dfxVar, 3, dnhVar, dsoVar.d);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        dnh dnhVar = dnh.b;
        return new btd[]{aye.t(dnhVar), aye.t(dnhVar), aye.t(dnhVar), aye.t(dnhVar)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
