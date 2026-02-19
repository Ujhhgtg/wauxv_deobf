package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class eej implements bgx {
    public static final eej b;
    private static final dfx descriptor;

    static {
        eej eejVar = new eej();
        b = eejVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.sf0Proto" /* "me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.sf0Proto" /* "me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.sf0Proto" /* "me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.sf0Proto" /* cnb.z(-265892835359530L)   */, eejVar, 4);
        bjs.y(-264986597260074L, cucVar, false, 1);
        bjs.y(-265480518499114L, cucVar, false, 2);
        bjs.y(-265420388956970L, cucVar, false, 3);
        bjs.y(-265364554382122L, cucVar, false, 4);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        acmVarP.getClass();
        int i = 0;
        Long l = null;
        Long l2 = null;
        Integer num = null;
        Boolean bool = null;
        boolean z = true;
        while (z) {
            int iF = acmVarP.f(dfxVar);
            if (iF == -1) {
                z = false;
            } else if (iF == 0) {
                l = (Long) acmVarP.i(dfxVar, 0, bya.b, l);
                i |= 1;
            } else if (iF == 1) {
                l2 = (Long) acmVarP.i(dfxVar, 1, bya.b, l2);
                i |= 2;
            } else if (iF == 2) {
                num = (Integer) acmVarP.i(dfxVar, 2, bqj.b, num);
                i |= 4;
            } else {
                if (iF != 3) {
                    throw new bsd(iF);
                }
                bool = (Boolean) acmVarP.i(dfxVar, 3, pv.b, bool);
                i |= 8;
            }
        }
        acmVarP._bp(dfxVar);
        return new eel(i, l, l2, num, bool);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        eel eelVar = (eel) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        bya byaVar = bya.b;
        acnVarO.m(dfxVar, 0, byaVar, eelVar.a);
        acnVarO.m(dfxVar, 1, byaVar, eelVar.b);
        acnVarO.m(dfxVar, 2, bqj.b, eelVar.c);
        acnVarO.m(dfxVar, 3, pv.b, eelVar.d);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        bya byaVar = bya.b;
        return new btd[]{aye.t(byaVar), aye.t(byaVar), aye.t(bqj.b), aye.t(pv.b)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
