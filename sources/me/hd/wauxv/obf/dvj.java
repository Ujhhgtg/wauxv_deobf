package me.hd.wauxv.obf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class dvj implements bgx {
    public static final dvj b;
    private static final dfx descriptor;

    static {
        dvj dvjVar = new dvj();
        b = dvjVar;
        cuc cucVar = new cuc(cnb.z(-146432614988586L), dvjVar, 9);
        bjs.y(-146625888516906L, cucVar, false, 1);
        bjs.y(-146552874072874L, cucVar, false, 3);
        bjs.y(-170123654593322L, cucVar, false, 4);
        bjs.y(-170093589822250L, cucVar, false, 5);
        bjs.y(-170037755247402L, cucVar, false, 6);
        bjs.y(-169887431392042L, cucVar, false, 7);
        bjs.y(-170291158317866L, cucVar, false, 8);
        bjs.y(-170243913677610L, cucVar, false, 9);
        bjs.y(-169582488714026L, cucVar, false, 10);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        btt[] bttVarArr = dvl.a;
        acmVarP.getClass();
        Boolean bool = null;
        Integer num = null;
        dwm dwmVar = null;
        eji ejiVar = null;
        dyl dylVar = null;
        String str = null;
        String str2 = null;
        List list = null;
        efm efmVar = null;
        boolean z = true;
        int i = 0;
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
                    dwmVar = (dwm) acmVarP.i(dfxVar, 1, dwk.b, dwmVar);
                    i |= 2;
                    break;
                case 2:
                    ejiVar = (eji) acmVarP.i(dfxVar, 2, ejg.b, ejiVar);
                    i |= 4;
                    break;
                case 3:
                    dylVar = (dyl) acmVarP.i(dfxVar, 3, dyj.b, dylVar);
                    i |= 8;
                    break;
                case 4:
                    str = (String) acmVarP.i(dfxVar, 4, dnh.b, str);
                    i |= 16;
                    break;
                case 5:
                    str2 = (String) acmVarP.i(dfxVar, 5, dnh.b, str2);
                    i |= 32;
                    break;
                case 6:
                    list = (List) acmVarP.i(dfxVar, 6, (btd) bttVarArr[6].getValue(), list);
                    i |= 64;
                    break;
                case 7:
                    efmVar = (efm) acmVarP.i(dfxVar, 7, efk.b, efmVar);
                    i |= 128;
                    break;
                case 8:
                    bool = (Boolean) acmVarP.i(dfxVar, 8, pv.b, bool);
                    i |= 256;
                    break;
                default:
                    throw new bsd(iF);
            }
        }
        acmVarP._bp(dfxVar);
        return new dvl(i, num, dwmVar, ejiVar, dylVar, str, str2, list, efmVar, bool);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        dvl dvlVar = (dvl) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        btt[] bttVarArr = dvl.a;
        acnVarO.m(dfxVar, 0, bqj.b, dvlVar.b);
        acnVarO.m(dfxVar, 1, dwk.b, dvlVar.c);
        acnVarO.m(dfxVar, 2, ejg.b, dvlVar.d);
        acnVarO.m(dfxVar, 3, dyj.b, dvlVar.e);
        dnh dnhVar = dnh.b;
        acnVarO.m(dfxVar, 4, dnhVar, dvlVar.f);
        acnVarO.m(dfxVar, 5, dnhVar, dvlVar.g);
        acnVarO.m(dfxVar, 6, (btd) bttVarArr[6].getValue(), dvlVar.h);
        acnVarO.m(dfxVar, 7, efk.b, dvlVar.i);
        acnVarO.m(dfxVar, 8, pv.b, dvlVar.j);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        btt[] bttVarArr = dvl.a;
        btd btdVarT = aye.t(bqj.b);
        btd btdVarT2 = aye.t(dwk.b);
        btd btdVarT3 = aye.t(ejg.b);
        btd btdVarT4 = aye.t(dyj.b);
        dnh dnhVar = dnh.b;
        return new btd[]{btdVarT, btdVarT2, btdVarT3, btdVarT4, aye.t(dnhVar), aye.t(dnhVar), aye.t((btd) bttVarArr[6].getValue()), aye.t(efk.b), aye.t(pv.b)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
