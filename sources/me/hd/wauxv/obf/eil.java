package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class eil implements bgx {
    public static final eil b;
    private static final dfx descriptor;

    static {
        eil eilVar = new eil();
        b = eilVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.xo3Proto" /* cnb.z(-319163314731818L) */, eilVar, 3);
        bjs.y(-321023035570986L, cucVar, false, 1);
        bjs.y(-320932841257770L, cucVar, false, 2);
        bjs.y(-320907071453994L, cucVar, false, 3);
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
        dwj dwjVar = null;
        dwj dwjVar2 = null;
        while (z) {
            int iF = acmVarP.f(dfxVar);
            if (iF == -1) {
                z = false;
            } else if (iF == 0) {
                str = (String) acmVarP.i(dfxVar, 0, dnh.b, str);
                i |= 1;
            } else if (iF == 1) {
                dwjVar = (dwj) acmVarP.i(dfxVar, 1, dwh.b, dwjVar);
                i |= 2;
            } else {
                if (iF != 2) {
                    throw new bsd(iF);
                }
                dwjVar2 = (dwj) acmVarP.i(dfxVar, 2, dwh.b, dwjVar2);
                i |= 4;
            }
        }
        acmVarP._bp(dfxVar);
        return new ein(i, str, dwjVar, dwjVar2);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        ein einVar = (ein) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        acnVarO.m(dfxVar, 0, dnh.b, einVar.a);
        dwh dwhVar = dwh.b;
        acnVarO.m(dfxVar, 1, dwhVar, einVar.b);
        acnVarO.m(dfxVar, 2, dwhVar, einVar.c);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        btd btdVarT = aye.t(dnh.b);
        dwh dwhVar = dwh.b;
        return new btd[]{btdVarT, aye.t(dwhVar), aye.t(dwhVar)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
