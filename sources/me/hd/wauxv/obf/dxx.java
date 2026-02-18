package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class dxx implements bgx {
    public static final dxx b;
    private static final dfx descriptor;

    static {
        dxx dxxVar = new dxx();
        b = dxxVar;
        cuc cucVar = new cuc(cnb.z(-205303731714858L), dxxVar, 8);
        bjs.y(-205514185112362L, cucVar, false, 1);
        bjs.y(-205497005243178L, cucVar, false, 2);
        bjs.y(-205406810929962L, cucVar, false, 3);
        bjs.y(-205355271322410L, cucVar, false, 4);
        bjs.y(-204728206097194L, cucVar, false, 5);
        bjs.y(-204620831914794L, cucVar, false, 6);
        bjs.y(-204573587274538L, cucVar, false, 8);
        bjs.y(-205058918578986L, cucVar, false, 9);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        acmVarP.getClass();
        int i = 0;
        Integer num = null;
        Boolean bool = null;
        Integer num2 = null;
        Long l = null;
        Integer num3 = null;
        Integer num4 = null;
        String str = null;
        Integer num5 = null;
        boolean z = true;
        while (z) {
            int iF = acmVarP.f(dfxVar);
            switch (iF) {
                case -1:
                    z = false;
                    break;
                case 0:
                    num = (Integer) acmVarP.i(dfxVar, 0, bqj.b, num);
                    i |= 1;
                    break;
                case 1:
                    bool = (Boolean) acmVarP.i(dfxVar, 1, pv.b, bool);
                    i |= 2;
                    break;
                case 2:
                    num2 = (Integer) acmVarP.i(dfxVar, 2, bqj.b, num2);
                    i |= 4;
                    break;
                case 3:
                    l = (Long) acmVarP.i(dfxVar, 3, bya.b, l);
                    i |= 8;
                    break;
                case 4:
                    num3 = (Integer) acmVarP.i(dfxVar, 4, bqj.b, num3);
                    i |= 16;
                    break;
                case 5:
                    num4 = (Integer) acmVarP.i(dfxVar, 5, bqj.b, num4);
                    i |= 32;
                    break;
                case 6:
                    str = (String) acmVarP.i(dfxVar, 6, dnh.b, str);
                    i |= 64;
                    break;
                case 7:
                    num5 = (Integer) acmVarP.i(dfxVar, 7, bqj.b, num5);
                    i |= 128;
                    break;
                default:
                    throw new bsd(iF);
            }
        }
        acmVarP._bp(dfxVar);
        return new dxz(i, num, bool, num2, l, num3, num4, str, num5);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        dxz dxzVar = (dxz) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        bqj bqjVar = bqj.b;
        acnVarO.m(dfxVar, 0, bqjVar, dxzVar.a);
        acnVarO.m(dfxVar, 1, pv.b, dxzVar.b);
        acnVarO.m(dfxVar, 2, bqjVar, dxzVar.c);
        acnVarO.m(dfxVar, 3, bya.b, dxzVar.d);
        acnVarO.m(dfxVar, 4, bqjVar, dxzVar.e);
        acnVarO.m(dfxVar, 5, bqjVar, dxzVar.f);
        acnVarO.m(dfxVar, 6, dnh.b, dxzVar.g);
        acnVarO.m(dfxVar, 7, bqjVar, dxzVar.h);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        bqj bqjVar = bqj.b;
        return new btd[]{aye.t(bqjVar), aye.t(pv.b), aye.t(bqjVar), aye.t(bya.b), aye.t(bqjVar), aye.t(bqjVar), aye.t(dnh.b), aye.t(bqjVar)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
