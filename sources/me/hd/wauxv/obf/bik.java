package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class bik implements bgx {
    public static final bik b;
    private static final dfx descriptor;

    static {
        bik bikVar = new bik();
        b = bikVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.proto.GmailInfo" /* cnb.z(-336046831172394L) */, bikVar, 3);
        cucVar.x("GmailAcct" /* cnb.z(-336356068817706L) */, false);
        cucVar.y(new aoz(1, 3));
        cucVar.x("GmailSwitch" /* cnb.z(-336330299013930L) */, false);
        cucVar.y(new aoz(2, 3));
        cucVar.x("GmailErrCode" /* cnb.z(-336313119144746L) */, false);
        cucVar.y(new aoz(3, 3));
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        acmVarP.getClass();
        boolean z = true;
        int i = 0;
        String str = null;
        Integer num = null;
        Integer num2 = null;
        while (z) {
            int iF = acmVarP.f(dfxVar);
            if (iF == -1) {
                z = false;
            } else if (iF == 0) {
                str = (String) acmVarP.i(dfxVar, 0, dnh.b, str);
                i |= 1;
            } else if (iF == 1) {
                num = (Integer) acmVarP.i(dfxVar, 1, bqj.b, num);
                i |= 2;
            } else {
                if (iF != 2) {
                    throw new bsd(iF);
                }
                num2 = (Integer) acmVarP.i(dfxVar, 2, bqj.b, num2);
                i |= 4;
            }
        }
        acmVarP._bp(dfxVar);
        if (7 != (i & 7)) {
            bht.ah(i, 7, descriptor);
            throw null;
        }
        bim bimVar = new bim();
        bimVar.a = str;
        bimVar.b = num;
        bimVar.c = num2;
        return bimVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        bim bimVar = (bim) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        acnVarO.m(dfxVar, 0, dnh.b, bimVar.a);
        bqj bqjVar = bqj.b;
        acnVarO.m(dfxVar, 1, bqjVar, bimVar.b);
        acnVarO.m(dfxVar, 2, bqjVar, bimVar.c);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        btd btdVarT = aye.t(dnh.b);
        bqj bqjVar = bqj.b;
        return new btd[]{btdVarT, aye.t(bqjVar), aye.t(bqjVar)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
