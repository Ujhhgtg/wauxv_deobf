package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class eev implements bgx {
    public static final eev b;
    private static final dfx descriptor;

    static {
        eev eevVar = new eev();
        b = eevVar;
        cuc cucVar = new cuc(cnb.z(-294699181013802L), eevVar, 6);
        bjs.y(-296558901852970L, cucVar, false, 1);
        bjs.y(-296515952180010L, cucVar, false, 2);
        bjs.y(-296460117605162L, cucVar, false, 3);
        bjs.y(-296485887408938L, cucVar, false, 4);
        bjs.y(-296399988063018L, cucVar, false, 5);
        bjs.y(-296382808193834L, cucVar, false, 6);
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
        String str5 = null;
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
                    str3 = (String) acmVarP.i(dfxVar, 2, dnh.b, str3);
                    i |= 4;
                    break;
                case 3:
                    str4 = (String) acmVarP.i(dfxVar, 3, dnh.b, str4);
                    i |= 8;
                    break;
                case 4:
                    str5 = (String) acmVarP.i(dfxVar, 4, dnh.b, str5);
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
        return new eex(i, str, str2, str3, str4, str5, num);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        eex eexVar = (eex) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        dnh dnhVar = dnh.b;
        acnVarO.m(dfxVar, 0, dnhVar, eexVar.a);
        acnVarO.m(dfxVar, 1, dnhVar, eexVar.b);
        acnVarO.m(dfxVar, 2, dnhVar, eexVar.c);
        acnVarO.m(dfxVar, 3, dnhVar, eexVar.d);
        acnVarO.m(dfxVar, 4, dnhVar, eexVar.e);
        acnVarO.m(dfxVar, 5, bqj.b, eexVar.f);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        dnh dnhVar = dnh.b;
        return new btd[]{aye.t(dnhVar), aye.t(dnhVar), aye.t(dnhVar), aye.t(dnhVar), aye.t(dnhVar), aye.t(bqj.b)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
