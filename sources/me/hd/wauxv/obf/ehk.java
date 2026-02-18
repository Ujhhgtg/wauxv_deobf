package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ehk implements bgx {
    public static final ehk b;
    private static final dfx descriptor;

    static {
        ehk ehkVar = new ehk();
        b = ehkVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.w52Proto" /* cnb.z(-307399399308074L) */, ehkVar, 4);
        bjs.y(-307592672836394L, cucVar, false, 1);
        bjs.y(-307008557284138L, cucVar, false, 2);
        bjs.y(-306982787480362L, cucVar, false, 3);
        bjs.y(-306905478069034L, cucVar, false, 4);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        acmVarP.getClass();
        int i = 0;
        dsy dsyVar = null;
        dyi dyiVar = null;
        String str = null;
        String str2 = null;
        boolean z = true;
        while (z) {
            int iF = acmVarP.f(dfxVar);
            if (iF == -1) {
                z = false;
            } else if (iF == 0) {
                dsyVar = (dsy) acmVarP.i(dfxVar, 0, dsw.b, dsyVar);
                i |= 1;
            } else if (iF == 1) {
                dyiVar = (dyi) acmVarP.i(dfxVar, 1, dyg.b, dyiVar);
                i |= 2;
            } else if (iF == 2) {
                str = (String) acmVarP.i(dfxVar, 2, dnh.b, str);
                i |= 4;
            } else {
                if (iF != 3) {
                    throw new bsd(iF);
                }
                str2 = (String) acmVarP.i(dfxVar, 3, dnh.b, str2);
                i |= 8;
            }
        }
        acmVarP._bp(dfxVar);
        return new ehm(i, dsyVar, dyiVar, str, str2);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        ehm ehmVar = (ehm) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        acnVarO.m(dfxVar, 0, dsw.b, ehmVar.a);
        acnVarO.m(dfxVar, 1, dyg.b, ehmVar.b);
        dnh dnhVar = dnh.b;
        acnVarO.m(dfxVar, 2, dnhVar, ehmVar.c);
        acnVarO.m(dfxVar, 3, dnhVar, ehmVar.d);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        btd btdVarT = aye.t(dsw.b);
        btd btdVarT2 = aye.t(dyg.b);
        dnh dnhVar = dnh.b;
        return new btd[]{btdVarT, btdVarT2, aye.t(dnhVar), aye.t(dnhVar)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
