package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ddt implements bgx {
    public static final ddt b;
    private static final dfx descriptor;

    static {
        ddt ddtVar = new ddt();
        b = ddtVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.SKBuiltinString" /* cnb.z(-149937308302122L) */, ddtVar, 1);
        cucVar.x("string" /* cnb.z(-151320287771434L) */, true);
        cucVar.y(new aoz(1, 7));
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        acmVarP.getClass();
        String str = null;
        boolean z = true;
        int i = 0;
        while (z) {
            int iF = acmVarP.f(dfxVar);
            if (iF == -1) {
                z = false;
            } else {
                if (iF != 0) {
                    throw new bsd(iF);
                }
                str = (String) acmVarP.i(dfxVar, 0, dnh.b, str);
                i = 1;
            }
        }
        acmVarP._bp(dfxVar);
        return new ddv(i, str);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        ddv ddvVar = (ddv) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        if (acnVarO.f(dfxVar) || ddvVar.a != null) {
            acnVarO.m(dfxVar, 0, dnh.b, ddvVar.a);
        }
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        return new btd[]{aye.t(dnh.b)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
