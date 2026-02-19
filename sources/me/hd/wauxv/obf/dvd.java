package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class dvd implements bgx {
    public static final dvd b;
    private static final dfx descriptor;

    static {
        dvd dvdVar = new dvd();
        b = dvdVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.ab3Proto" /* "me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.ab3Proto" /* "me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.ab3Proto" /* cnb.z(-143043885792042L)  */, dvdVar, 3);
        bjs.y(-143254339189546L, cucVar, false, 1);
        bjs.y(-143267224091434L, cucVar, false, 2);
        bjs.y(-144809117350698L, cucVar, false, 3);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        acmVarP.getClass();
        eei eeiVar = null;
        boolean z = true;
        int i = 0;
        Long l = null;
        Long l2 = null;
        while (z) {
            int iF = acmVarP.f(dfxVar);
            if (iF == -1) {
                z = false;
            } else if (iF == 0) {
                eeiVar = (eei) acmVarP.i(dfxVar, 0, eeg.b, eeiVar);
                i |= 1;
            } else if (iF == 1) {
                l = (Long) acmVarP.i(dfxVar, 1, bya.b, l);
                i |= 2;
            } else {
                if (iF != 2) {
                    throw new bsd(iF);
                }
                l2 = (Long) acmVarP.i(dfxVar, 2, bya.b, l2);
                i |= 4;
            }
        }
        acmVarP._bp(dfxVar);
        return new dvf(i, eeiVar, l, l2);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        dvf dvfVar = (dvf) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        acnVarO.m(dfxVar, 0, eeg.b, dvfVar.a);
        bya byaVar = bya.b;
        acnVarO.m(dfxVar, 1, byaVar, dvfVar.b);
        acnVarO.m(dfxVar, 2, byaVar, dvfVar.c);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        btd btdVarT = aye.t(eeg.b);
        bya byaVar = bya.b;
        return new btd[]{btdVarT, aye.t(byaVar), aye.t(byaVar)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
