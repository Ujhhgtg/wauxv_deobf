package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class eau implements bgx {
    public static final eau b;
    private static final dfx descriptor;

    static {
        eau eauVar = new eau();
        b = eauVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.mg5Proto" /* cnb.z(-229213814651690L) */, eauVar, 3);
        bjs.y(-230506599807786L, cucVar, false, 1);
        bjs.y(-230467945102122L, cucVar, false, 2);
        bjs.y(-230446470265642L, cucVar, false, 3);
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
        Integer num = null;
        Long l = null;
        while (z) {
            int iF = acmVarP.f(dfxVar);
            if (iF == -1) {
                z = false;
            } else if (iF == 0) {
                str = (String) acmVarP.i(dfxVar, 0, dnh.b, str);
                i |= 1;
            } else if (iF == 1) {
                num = (Integer) acmVarP.i(dfxVar, 1, bqj.b, num);
                i |= 2;
            } else {
                if (iF != 2) {
                    throw new bsd(iF);
                }
                l = (Long) acmVarP.i(dfxVar, 2, bya.b, l);
                i |= 4;
            }
        }
        acmVarP._bp(dfxVar);
        return new eaw(i, str, num, l);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        eaw eawVar = (eaw) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        acnVarO.m(dfxVar, 0, dnh.b, eawVar.a);
        acnVarO.m(dfxVar, 1, bqj.b, eawVar.b);
        acnVarO.m(dfxVar, 2, bya.b, eawVar.c);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        return new btd[]{aye.t(dnh.b), aye.t(bqj.b), aye.t(bya.b)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
