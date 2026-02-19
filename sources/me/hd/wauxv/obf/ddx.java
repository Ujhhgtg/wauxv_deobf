package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ddx implements bgx {
    public static final ddx b;
    private static final dfx descriptor;

    static {
        ddx ddxVar = new ddx();
        b = ddxVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.proto.SKBuiltinString_t" /* "me.hd.wauxv.hook.micromsg.core.protobuf.proto.SKBuiltinString_t" /* "me.hd.wauxv.hook.micromsg.core.protobuf.proto.SKBuiltinString_t" /* "me.hd.wauxv.hook.micromsg.core.protobuf.proto.SKBuiltinString_t" /* cnb.z(-363951233694506L)   */, ddxVar, 1);
        cucVar.x("String" /* "String" /* "String" /* "String" /* cnb.z(-364226111601450L)   */, false);
        cucVar.y(new ddw());
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
        if (1 != i) {
            bht.ah(i, 1, descriptor);
            throw null;
        }
        ddz ddzVar = new ddz();
        ddzVar.a = str;
        return ddzVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        acnVarO.m(dfxVar, 0, dnh.b, ((ddz) obj).a);
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
