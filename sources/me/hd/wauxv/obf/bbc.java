package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class bbc implements bgx {
    public static final bbc b;
    private static final dfx descriptor;

    static {
        bbc bbcVar = new bbc();
        b = bbcVar;
        cuc cucVar = new cuc(cnb.z(-552916909816618L), bbcVar, 6);
        cucVar.x(cnb.z(-552100866030378L), false);
        cucVar.x(cnb.z(-552113750932266L), false);
        cucVar.x(cnb.z(-552070801259306L), false);
        cucVar.x(cnb.z(-552032146553642L), false);
        cucVar.x(cnb.z(-552045031455530L), false);
        cucVar.x(cnb.z(-552014966684458L), false);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        acmVarP.getClass();
        int i = 0;
        int iG = 0;
        boolean zL = false;
        String strD = null;
        String strD2 = null;
        String strD3 = null;
        String strD4 = null;
        boolean z = true;
        while (z) {
            int iF = acmVarP.f(dfxVar);
            switch (iF) {
                case -1:
                    z = false;
                    break;
                case 0:
                    strD = acmVarP.d(dfxVar, 0);
                    i |= 1;
                    break;
                case 1:
                    iG = acmVarP.g(dfxVar, 1);
                    i |= 2;
                    break;
                case 2:
                    strD2 = acmVarP.d(dfxVar, 2);
                    i |= 4;
                    break;
                case 3:
                    strD3 = acmVarP.d(dfxVar, 3);
                    i |= 8;
                    break;
                case 4:
                    strD4 = acmVarP.d(dfxVar, 4);
                    i |= 16;
                    break;
                case 5:
                    zL = acmVarP.l(dfxVar, 5);
                    i |= 32;
                    break;
                default:
                    throw new bsd(iF);
            }
        }
        acmVarP._bp(dfxVar);
        return new bbe(i, strD, iG, strD2, strD3, strD4, zL);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        bbe bbeVar = (bbe) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        acnVarO.l(dfxVar, 0, bbeVar.a);
        acnVarO.k(1, bbeVar.b, dfxVar);
        acnVarO.l(dfxVar, 2, bbeVar.c);
        acnVarO.l(dfxVar, 3, bbeVar.d);
        acnVarO.l(dfxVar, 4, bbeVar.e);
        acnVarO._bz(dfxVar, 5, bbeVar.f);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        dnh dnhVar = dnh.b;
        return new btd[]{dnhVar, bqj.b, dnhVar, dnhVar, dnhVar, pv.b};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
