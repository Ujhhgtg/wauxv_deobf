package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class edu implements bgx {
    public static final edu b;
    private static final dfx descriptor;

    static {
        edu eduVar = new edu();
        b = eduVar;
        cuc cucVar = new cuc(cnb.z(-276922311375658L), eduVar, 6);
        bjs.y(-276016073276202L, cucVar, false, 1);
        bjs.y(-276033253145386L, cucVar, false, 2);
        bjs.y(-276011778308906L, cucVar, false, 3);
        bjs.y(-276518584449834L, cucVar, false, 4);
        bjs.y(-276471339809578L, cucVar, false, 5);
        bjs.y(-276449864973098L, cucVar, false, 6);
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
        Float f = null;
        Float f2 = null;
        String str3 = null;
        Integer num = null;
        boolean z = true;
        while (z) {
            int iF = acmVarP.f(dfxVar);
            switch (iF) {
                case -1:
                    z = false;
                    break;
                case 0:
                    str = (String) acmVarP.i(dfxVar, 0, dnh.b, str);
                    i |= 1;
                    break;
                case 1:
                    str2 = (String) acmVarP.i(dfxVar, 1, dnh.b, str2);
                    i |= 2;
                    break;
                case 2:
                    f = (Float) acmVarP.i(dfxVar, 2, bbm.b, f);
                    i |= 4;
                    break;
                case 3:
                    f2 = (Float) acmVarP.i(dfxVar, 3, bbm.b, f2);
                    i |= 8;
                    break;
                case 4:
                    str3 = (String) acmVarP.i(dfxVar, 4, dnh.b, str3);
                    i |= 16;
                    break;
                case 5:
                    num = (Integer) acmVarP.i(dfxVar, 5, bqj.b, num);
                    i |= 32;
                    break;
                default:
                    throw new bsd(iF);
            }
        }
        acmVarP._bp(dfxVar);
        return new edw(i, str, str2, f, f2, str3, num);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        edw edwVar = (edw) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        dnh dnhVar = dnh.b;
        acnVarO.m(dfxVar, 0, dnhVar, edwVar.a);
        acnVarO.m(dfxVar, 1, dnhVar, edwVar.b);
        bbm bbmVar = bbm.b;
        acnVarO.m(dfxVar, 2, bbmVar, edwVar.c);
        acnVarO.m(dfxVar, 3, bbmVar, edwVar.d);
        acnVarO.m(dfxVar, 4, dnhVar, edwVar.e);
        acnVarO.m(dfxVar, 5, bqj.b, edwVar.f);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        dnh dnhVar = dnh.b;
        btd btdVarT = aye.t(dnhVar);
        btd btdVarT2 = aye.t(dnhVar);
        bbm bbmVar = bbm.b;
        return new btd[]{btdVarT, btdVarT2, aye.t(bbmVar), aye.t(bbmVar), aye.t(dnhVar), aye.t(bqj.b)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
