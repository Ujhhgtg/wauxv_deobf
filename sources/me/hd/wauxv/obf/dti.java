package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class dti implements bgx {
    public static final dti b;
    private static final dfx descriptor;

    static {
        dti dtiVar = new dti();
        b = dtiVar;
        cuc cucVar = new cuc(cnb.z(-181234734988074L), dtiVar, 6);
        bjs.y(-180826713094954L, cucVar, false, 1);
        bjs.y(-180800943291178L, cucVar, false, 2);
        bjs.y(-180715043945258L, cucVar, false, 3);
        bjs.y(-180680684206890L, cucVar, false, 4);
        bjs.y(-180642029501226L, cucVar, false, 5);
        bjs.y(-182226872433450L, cucVar, false, 6);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        acmVarP.getClass();
        int i = 0;
        Integer num = null;
        Integer num2 = null;
        Integer num3 = null;
        String str = null;
        String str2 = null;
        String str3 = null;
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
                    num = (Integer) acmVarP.i(dfxVar, 2, bqj.b, num);
                    i |= 4;
                    break;
                case 3:
                    num2 = (Integer) acmVarP.i(dfxVar, 3, bqj.b, num2);
                    i |= 8;
                    break;
                case 4:
                    str3 = (String) acmVarP.i(dfxVar, 4, dnh.b, str3);
                    i |= 16;
                    break;
                case 5:
                    num3 = (Integer) acmVarP.i(dfxVar, 5, bqj.b, num3);
                    i |= 32;
                    break;
                default:
                    throw new bsd(iF);
            }
        }
        acmVarP._bp(dfxVar);
        return new dtk(i, num, num2, num3, str, str2, str3);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        dtk dtkVar = (dtk) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        dnh dnhVar = dnh.b;
        acnVarO.m(dfxVar, 0, dnhVar, dtkVar.a);
        acnVarO.m(dfxVar, 1, dnhVar, dtkVar.b);
        bqj bqjVar = bqj.b;
        acnVarO.m(dfxVar, 2, bqjVar, dtkVar.c);
        acnVarO.m(dfxVar, 3, bqjVar, dtkVar.d);
        acnVarO.m(dfxVar, 4, dnhVar, dtkVar.e);
        acnVarO.m(dfxVar, 5, bqjVar, dtkVar.f);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        dnh dnhVar = dnh.b;
        btd btdVarT = aye.t(dnhVar);
        btd btdVarT2 = aye.t(dnhVar);
        bqj bqjVar = bqj.b;
        return new btd[]{btdVarT, btdVarT2, aye.t(bqjVar), aye.t(bqjVar), aye.t(dnhVar), aye.t(bqjVar)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
