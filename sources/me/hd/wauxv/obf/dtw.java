package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class dtw implements bgx {
    public static final dtw b;
    private static final dfx descriptor;

    static {
        dtw dtwVar = new dtw();
        b = dtwVar;
        cuc cucVar = new cuc(cnb.z(-273288769043242L), dtwVar, 11);
        bjs.y(-272897927019306L, cucVar, false, 1);
        bjs.y(-272824912575274L, cucVar, false, 2);
        bjs.y(-272794847804202L, cucVar, false, 3);
        bjs.y(-272764783033130L, cucVar, false, 4);
        bjs.y(-272721833360170L, cucVar, false, 5);
        bjs.y(-272743308196650L, cucVar, false, 6);
        bjs.y(-272708948458282L, cucVar, false, 7);
        bjs.y(-273168509958954L, cucVar, false, 8);
        bjs.y(-273185689828138L, cucVar, false, 9);
        bjs.y(-273147035122474L, cucVar, false, 10);
        bjs.y(-273104085449514L, cucVar, false, 11);
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
        Integer num3 = null;
        String str2 = null;
        Integer num4 = null;
        Integer num5 = null;
        Integer num6 = null;
        Integer num7 = null;
        String str3 = null;
        Integer num8 = null;
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
                    num3 = (Integer) acmVarP.i(dfxVar, 1, bqj.b, num3);
                    i |= 2;
                    break;
                case 2:
                    z = z2;
                    str2 = (String) acmVarP.i(dfxVar, 2, dnh.b, str2);
                    i |= 4;
                    break;
                case 3:
                    z = z2;
                    num4 = (Integer) acmVarP.i(dfxVar, 3, bqj.b, num4);
                    i |= 8;
                    break;
                case 4:
                    z = z2;
                    num5 = (Integer) acmVarP.i(dfxVar, 4, bqj.b, num5);
                    i |= 16;
                    break;
                case 5:
                    z = z2;
                    num6 = (Integer) acmVarP.i(dfxVar, 5, bqj.b, num6);
                    i |= 32;
                    break;
                case 6:
                    z = z2;
                    num7 = (Integer) acmVarP.i(dfxVar, 6, bqj.b, num7);
                    i |= 64;
                    break;
                case 7:
                    z = z2;
                    str3 = (String) acmVarP.i(dfxVar, 7, dnh.b, str3);
                    i |= 128;
                    break;
                case 8:
                    z = z2;
                    num8 = (Integer) acmVarP.i(dfxVar, 8, bqj.b, num8);
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
        return new dty(i, num2, num3, str2, num4, num5, num6, num7, str3, num8, str, num);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        dty dtyVar = (dty) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        bqj bqjVar = bqj.b;
        acnVarO.m(dfxVar, 0, bqjVar, dtyVar.a);
        acnVarO.m(dfxVar, 1, bqjVar, dtyVar.b);
        dnh dnhVar = dnh.b;
        acnVarO.m(dfxVar, 2, dnhVar, dtyVar.c);
        acnVarO.m(dfxVar, 3, bqjVar, dtyVar.d);
        acnVarO.m(dfxVar, 4, bqjVar, dtyVar.e);
        acnVarO.m(dfxVar, 5, bqjVar, dtyVar.f);
        acnVarO.m(dfxVar, 6, bqjVar, dtyVar.g);
        acnVarO.m(dfxVar, 7, dnhVar, dtyVar.h);
        acnVarO.m(dfxVar, 8, bqjVar, dtyVar.i);
        acnVarO.m(dfxVar, 9, dnhVar, dtyVar.j);
        acnVarO.m(dfxVar, 10, bqjVar, dtyVar.k);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        bqj bqjVar = bqj.b;
        btd btdVarT = aye.t(bqjVar);
        btd btdVarT2 = aye.t(bqjVar);
        dnh dnhVar = dnh.b;
        return new btd[]{btdVarT, btdVarT2, aye.t(dnhVar), aye.t(bqjVar), aye.t(bqjVar), aye.t(bqjVar), aye.t(bqjVar), aye.t(dnhVar), aye.t(bqjVar), aye.t(dnhVar), aye.t(bqjVar)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
