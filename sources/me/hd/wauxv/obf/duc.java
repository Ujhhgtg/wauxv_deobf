package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class duc implements bgx {
    public static final duc b;
    private static final dfx descriptor;

    static {
        duc ducVar = new duc();
        b = ducVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.SizeProto" /* "me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.SizeProto" /* "me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.SizeProto" /* cnb.z(-271553602255658L)  */, ducVar, 3);
        bjs.y(-270660249058090L, cucVar, false, 1);
        bjs.y(-270686018861866L, cucVar, false, 2);
        bjs.y(-270638774221610L, cucVar, false, 3);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        acmVarP.getClass();
        Float f = null;
        boolean z = true;
        int i = 0;
        Float f2 = null;
        Float f3 = null;
        while (z) {
            int iF = acmVarP.f(dfxVar);
            if (iF == -1) {
                z = false;
            } else if (iF == 0) {
                f = (Float) acmVarP.i(dfxVar, 0, bbm.b, f);
                i |= 1;
            } else if (iF == 1) {
                f2 = (Float) acmVarP.i(dfxVar, 1, bbm.b, f2);
                i |= 2;
            } else {
                if (iF != 2) {
                    throw new bsd(iF);
                }
                f3 = (Float) acmVarP.i(dfxVar, 2, bbm.b, f3);
                i |= 4;
            }
        }
        acmVarP._bp(dfxVar);
        return new due(i, f, f2, f3);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        due dueVar = (due) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        bbm bbmVar = bbm.b;
        acnVarO.m(dfxVar, 0, bbmVar, dueVar.a);
        acnVarO.m(dfxVar, 1, bbmVar, dueVar.b);
        acnVarO.m(dfxVar, 2, bbmVar, dueVar.c);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        bbm bbmVar = bbm.b;
        return new btd[]{aye.t(bbmVar), aye.t(bbmVar), aye.t(bbmVar)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
