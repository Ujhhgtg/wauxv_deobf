package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class eck implements bgx {
    public static final eck b;
    private static final dfx descriptor;

    static {
        eck eckVar = new eck();
        b = eckVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.o61Proto" /* cnb.z(-259514808924970L) */, eckVar, 3);
        bjs.y(-261374529764138L, cucVar, false, 1);
        bjs.y(-261284335450922L, cucVar, false, 2);
        bjs.y(-261249975712554L, cucVar, false, 3);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        acmVarP.getClass();
        eie eieVar = null;
        boolean z = true;
        int i = 0;
        Integer num = null;
        String str = null;
        while (z) {
            int iF = acmVarP.f(dfxVar);
            if (iF == -1) {
                z = false;
            } else if (iF == 0) {
                eieVar = (eie) acmVarP.i(dfxVar, 0, eic.b, eieVar);
                i |= 1;
            } else if (iF == 1) {
                num = (Integer) acmVarP.i(dfxVar, 1, bqj.b, num);
                i |= 2;
            } else {
                if (iF != 2) {
                    throw new bsd(iF);
                }
                str = (String) acmVarP.i(dfxVar, 2, dnh.b, str);
                i |= 4;
            }
        }
        acmVarP._bp(dfxVar);
        return new ecm(i, eieVar, num, str);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        ecm ecmVar = (ecm) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        acnVarO.m(dfxVar, 0, eic.b, ecmVar.a);
        acnVarO.m(dfxVar, 1, bqj.b, ecmVar.b);
        acnVarO.m(dfxVar, 2, dnh.b, ecmVar.c);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        return new btd[]{aye.t(eic.b), aye.t(bqj.b), aye.t(dnh.b)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
