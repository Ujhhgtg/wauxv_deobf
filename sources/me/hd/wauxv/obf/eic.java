package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class eic implements bgx {
    public static final eic b;
    private static final dfx descriptor;

    static {
        eic eicVar = new eic();
        b = eicVar;
        cuc cucVar = new cuc(cnb.z(-333959477066538L), eicVar, 11);
        bjs.y(-334157045562154L, cucVar, false, 1);
        bjs.y(-334165635496746L, cucVar, false, 2);
        bjs.y(-334174225431338L, cucVar, false, 3);
        bjs.y(-334182815365930L, cucVar, false, 4);
        bjs.y(-334122685823786L, cucVar, false, 5);
        bjs.y(-334131275758378L, cucVar, false, 6);
        bjs.y(-334139865692970L, cucVar, false, 7);
        bjs.y(-334148455627562L, cucVar, false, 8);
        bjs.y(-334088326085418L, cucVar, false, 10);
        bjs.y(-334096916020010L, cucVar, false, 11);
        bjs.y(-334105505954602L, cucVar, false, 12);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        boolean z;
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        acmVarP.getClass();
        String str = null;
        Integer num = null;
        Integer num2 = null;
        String str2 = null;
        Integer num3 = null;
        String str3 = null;
        Integer num4 = null;
        Integer num5 = null;
        Integer num6 = null;
        String str4 = null;
        Integer num7 = null;
        int i = 0;
        boolean z2 = true;
        while (z2) {
            int iF = acmVarP.f(dfxVar);
            switch (iF) {
                case -1:
                    z2 = false;
                    continue;
                case 0:
                    z = z2;
                    num2 = (Integer) acmVarP.i(dfxVar, 0, bqj.b, num2);
                    i |= 1;
                    break;
                case 1:
                    z = z2;
                    str2 = (String) acmVarP.i(dfxVar, 1, dnh.b, str2);
                    i |= 2;
                    break;
                case 2:
                    z = z2;
                    num3 = (Integer) acmVarP.i(dfxVar, 2, bqj.b, num3);
                    i |= 4;
                    break;
                case 3:
                    z = z2;
                    str3 = (String) acmVarP.i(dfxVar, 3, dnh.b, str3);
                    i |= 8;
                    break;
                case 4:
                    z = z2;
                    num4 = (Integer) acmVarP.i(dfxVar, 4, bqj.b, num4);
                    i |= 16;
                    break;
                case 5:
                    z = z2;
                    num5 = (Integer) acmVarP.i(dfxVar, 5, bqj.b, num5);
                    i |= 32;
                    break;
                case 6:
                    z = z2;
                    num6 = (Integer) acmVarP.i(dfxVar, 6, bqj.b, num6);
                    i |= 64;
                    break;
                case 7:
                    z = z2;
                    str4 = (String) acmVarP.i(dfxVar, 7, dnh.b, str4);
                    i |= 128;
                    break;
                case 8:
                    z = z2;
                    num7 = (Integer) acmVarP.i(dfxVar, 8, bqj.b, num7);
                    i |= 256;
                    break;
                case 9:
                    z = z2;
                    str = (String) acmVarP.i(dfxVar, 9, dnh.b, str);
                    i |= 512;
                    break;
                case 10:
                    z = z2;
                    num = (Integer) acmVarP.i(dfxVar, 10, bqj.b, num);
                    i |= 1024;
                    break;
                default:
                    throw new bsd(iF);
            }
            z2 = z;
        }
        acmVarP._bp(dfxVar);
        return new eie(i, num2, str2, num3, str3, num4, num5, num6, str4, num7, str, num);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        eie eieVar = (eie) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        bqj bqjVar = bqj.b;
        acnVarO.m(dfxVar, 0, bqjVar, eieVar.a);
        dnh dnhVar = dnh.b;
        acnVarO.m(dfxVar, 1, dnhVar, eieVar.b);
        acnVarO.m(dfxVar, 2, bqjVar, eieVar.c);
        acnVarO.m(dfxVar, 3, dnhVar, eieVar.d);
        acnVarO.m(dfxVar, 4, bqjVar, eieVar.e);
        acnVarO.m(dfxVar, 5, bqjVar, eieVar.f);
        acnVarO.m(dfxVar, 6, bqjVar, eieVar.g);
        acnVarO.m(dfxVar, 7, dnhVar, eieVar.h);
        acnVarO.m(dfxVar, 8, bqjVar, eieVar.i);
        acnVarO.m(dfxVar, 9, dnhVar, eieVar.j);
        acnVarO.m(dfxVar, 10, bqjVar, eieVar.k);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        bqj bqjVar = bqj.b;
        btd btdVarT = aye.t(bqjVar);
        dnh dnhVar = dnh.b;
        return new btd[]{btdVarT, aye.t(dnhVar), aye.t(bqjVar), aye.t(dnhVar), aye.t(bqjVar), aye.t(bqjVar), aye.t(bqjVar), aye.t(dnhVar), aye.t(bqjVar), aye.t(dnhVar), aye.t(bqjVar)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
