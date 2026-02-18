package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ehe implements bgx {
    public static final ehe b;
    private static final dfx descriptor;

    static {
        ehe eheVar = new ehe();
        b = eheVar;
        cuc cucVar = new cuc(cnb.z(-300600466078506L), eheVar, 3);
        bjs.y(-306308477614890L, cucVar, false, 1);
        bjs.y(-306231168203562L, cucVar, false, 2);
        bjs.y(-306755154213674L, cucVar, false, 3);
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
        Float f = null;
        Float f2 = null;
        while (z) {
            int iF = acmVarP.f(dfxVar);
            if (iF == -1) {
                z = false;
            } else if (iF == 0) {
                str = (String) acmVarP.i(dfxVar, 0, dnh.b, str);
                i |= 1;
            } else if (iF == 1) {
                f = (Float) acmVarP.i(dfxVar, 1, bbm.b, f);
                i |= 2;
            } else {
                if (iF != 2) {
                    throw new bsd(iF);
                }
                f2 = (Float) acmVarP.i(dfxVar, 2, bbm.b, f2);
                i |= 4;
            }
        }
        acmVarP._bp(dfxVar);
        return new ehg(i, str, f, f2);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        ehg ehgVar = (ehg) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        acnVarO.m(dfxVar, 0, dnh.b, ehgVar.a);
        bbm bbmVar = bbm.b;
        acnVarO.m(dfxVar, 1, bbmVar, ehgVar.b);
        acnVarO.m(dfxVar, 2, bbmVar, ehgVar.c);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        btd btdVarT = aye.t(dnh.b);
        bbm bbmVar = bbm.b;
        return new btd[]{btdVarT, aye.t(bbmVar), aye.t(bbmVar)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
