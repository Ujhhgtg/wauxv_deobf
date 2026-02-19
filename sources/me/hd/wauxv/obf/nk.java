package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class nk implements bgx {
    public static final nk b;
    private static final dfx descriptor;

    static {
        nk nkVar = new nk();
        b = nkVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.BaseResponse" /* "me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.BaseResponse" /* "me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.BaseResponse" /* cnb.z(-126774549674794L)  */, nkVar, 2);
        cucVar.x("ret" /* "ret" /* "ret" /* cnb.z(-123755187665706L)  */, false);
        cucVar.y(new aoz(1, 7));
        cucVar.x("errMsg" /* "errMsg" /* "errMsg" /* cnb.z(-123703648058154L)  */, false);
        cucVar.y(new aoz(2, 7));
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        acmVarP.getClass();
        ddv ddvVar = null;
        boolean z = true;
        int i = 0;
        int iG = 0;
        while (z) {
            int iF = acmVarP.f(dfxVar);
            if (iF == -1) {
                z = false;
            } else if (iF == 0) {
                iG = acmVarP.g(dfxVar, 0);
                i |= 1;
            } else {
                if (iF != 1) {
                    throw new bsd(iF);
                }
                ddvVar = (ddv) acmVarP.h(dfxVar, 1, ddt.b, ddvVar);
                i |= 2;
            }
        }
        acmVarP._bp(dfxVar);
        return new nm(i, iG, ddvVar);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        nm nmVar = (nm) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        acnVarO.k(0, nmVar.a, dfxVar);
        acnVarO._ca(dfxVar, 1, ddt.b, nmVar.b);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        return new btd[]{bqj.b, ddt.b};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
