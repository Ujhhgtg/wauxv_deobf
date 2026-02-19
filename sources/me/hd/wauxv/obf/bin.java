package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class bin implements bgx {
    public static final bin b;
    private static final dfx descriptor;

    static {
        bin binVar = new bin();
        b = binVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.proto.GmailList" /* "me.hd.wauxv.hook.micromsg.core.protobuf.proto.GmailList" /* "me.hd.wauxv.hook.micromsg.core.protobuf.proto.GmailList" /* cnb.z(-335746183461674L)  */, binVar, 2);
        cucVar.x("Count" /* "Count" /* "Count" /* cnb.z(-341552979245866L)  */, false);
        cucVar.y(new aoz(1, 4));
        cucVar.x("List" /* "List" /* "List" /* cnb.z(-341510029572906L)  */, false);
        cucVar.y(new aoz(2, 4));
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        acmVarP.getClass();
        boolean z = true;
        int i = 0;
        Integer num = null;
        bim bimVar = null;
        while (z) {
            int iF = acmVarP.f(dfxVar);
            if (iF == -1) {
                z = false;
            } else if (iF == 0) {
                num = (Integer) acmVarP.i(dfxVar, 0, bqj.b, num);
                i |= 1;
            } else {
                if (iF != 1) {
                    throw new bsd(iF);
                }
                bimVar = (bim) acmVarP.i(dfxVar, 1, bik.b, bimVar);
                i |= 2;
            }
        }
        acmVarP._bp(dfxVar);
        if (3 != (i & 3)) {
            bht.ah(i, 3, descriptor);
            throw null;
        }
        bip bipVar = new bip();
        bipVar.a = num;
        bipVar.b = bimVar;
        return bipVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        bip bipVar = (bip) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        acnVarO.m(dfxVar, 0, bqj.b, bipVar.a);
        acnVarO.m(dfxVar, 1, bik.b, bipVar.b);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        return new btd[]{aye.t(bqj.b), aye.t(bik.b)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
