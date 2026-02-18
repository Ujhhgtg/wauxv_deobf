package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class cnt implements bgx {
    public static final cnt b;
    private static final dfx descriptor;

    static {
        cnt cntVar = new cnt();
        b = cntVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.NewSendMsgProto.MicroMsgResponseNew" /* cnb.z(-131649337555754L) */, cntVar, 8);
        cucVar.x("ret" /* cnb.z(-131812546313002L) */, false);
        cucVar.y(new aoz(1, 6));
        cucVar.x("toUserName" /* cnb.z(-131829726182186L) */, false);
        cucVar.y(new aoz(2, 6));
        cucVar.x("msgId" /* cnb.z(-131799661411114L) */, false);
        cucVar.y(new aoz(3, 6));
        cucVar.x("clientMsgId" /* cnb.z(-131756711738154L) */, false);
        cucVar.y(new aoz(4, 6));
        cucVar.x("createTime" /* cnb.z(-131670812392234L) */, false);
        cucVar.y(new aoz(5, 6));
        cucVar.x("serverTime" /* cnb.z(-131108171676458L) */, false);
        cucVar.y(new aoz(6, 6));
        cucVar.x("type" /* cnb.z(-131078106905386L) */, false);
        cucVar.y(new aoz(7, 6));
        cucVar.x("svrId" /* cnb.z(-131039452199722L) */, false);
        cucVar.y(new aoz(8, 6));
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        acmVarP.getClass();
        int i = 0;
        int iG = 0;
        int iG2 = 0;
        int iG3 = 0;
        int iG4 = 0;
        int iG5 = 0;
        int iG6 = 0;
        ddv ddvVar = null;
        Long l = null;
        boolean z = true;
        while (z) {
            int iF = acmVarP.f(dfxVar);
            switch (iF) {
                case -1:
                    z = false;
                    break;
                case 0:
                    iG = acmVarP.g(dfxVar, 0);
                    i |= 1;
                    break;
                case 1:
                    ddvVar = (ddv) acmVarP.h(dfxVar, 1, ddt.b, ddvVar);
                    i |= 2;
                    break;
                case 2:
                    iG2 = acmVarP.g(dfxVar, 2);
                    i |= 4;
                    break;
                case 3:
                    iG3 = acmVarP.g(dfxVar, 3);
                    i |= 8;
                    break;
                case 4:
                    iG4 = acmVarP.g(dfxVar, 4);
                    i |= 16;
                    break;
                case 5:
                    iG5 = acmVarP.g(dfxVar, 5);
                    i |= 32;
                    break;
                case 6:
                    iG6 = acmVarP.g(dfxVar, 6);
                    i |= 64;
                    break;
                case 7:
                    l = (Long) acmVarP.i(dfxVar, 7, bya.b, l);
                    i |= 128;
                    break;
                default:
                    throw new bsd(iF);
            }
        }
        acmVarP._bp(dfxVar);
        return new cnv(i, iG, ddvVar, iG2, iG3, iG4, iG5, iG6, l);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        cnv cnvVar = (cnv) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        acnVarO.k(0, cnvVar.a, dfxVar);
        acnVarO._ca(dfxVar, 1, ddt.b, cnvVar.b);
        acnVarO.k(2, cnvVar.c, dfxVar);
        acnVarO.k(3, cnvVar.d, dfxVar);
        acnVarO.k(4, cnvVar.e, dfxVar);
        acnVarO.k(5, cnvVar.f, dfxVar);
        acnVarO.k(6, cnvVar.g, dfxVar);
        acnVarO.m(dfxVar, 7, bya.b, cnvVar.h);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        btd btdVarT = aye.t(bya.b);
        bqj bqjVar = bqj.b;
        return new btd[]{bqjVar, ddt.b, bqjVar, bqjVar, bqjVar, bqjVar, bqjVar, btdVarT};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
