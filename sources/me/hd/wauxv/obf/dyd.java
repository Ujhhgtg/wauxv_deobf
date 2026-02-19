package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class dyd implements bgx {
    public static final dyd b;
    private static final dfx descriptor;

    static {
        dyd dydVar = new dyd();
        b = dydVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.gm1Proto" /* "me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.gm1Proto" /* "me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.gm1Proto" /* cnb.z(-202318729444138L)  */, dydVar, 3);
        bjs.y(-204229989890858L, cucVar, false, 1);
        bjs.y(-204161270414122L, cucVar, false, 2);
        bjs.y(-204041011329834L, cucVar, false, 3);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        acmVarP.getClass();
        Integer num = null;
        boolean z = true;
        int i = 0;
        String str = null;
        dxh dxhVar = null;
        while (z) {
            int iF = acmVarP.f(dfxVar);
            if (iF == -1) {
                z = false;
            } else if (iF == 0) {
                num = (Integer) acmVarP.i(dfxVar, 0, bqj.b, num);
                i |= 1;
            } else if (iF == 1) {
                str = (String) acmVarP.i(dfxVar, 1, dnh.b, str);
                i |= 2;
            } else {
                if (iF != 2) {
                    throw new bsd(iF);
                }
                dxhVar = (dxh) acmVarP.i(dfxVar, 2, dxf.b, dxhVar);
                i |= 4;
            }
        }
        acmVarP._bp(dfxVar);
        return new dyf(i, num, str, dxhVar);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        dyf dyfVar = (dyf) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        acnVarO.m(dfxVar, 0, bqj.b, dyfVar.a);
        acnVarO.m(dfxVar, 1, dnh.b, dyfVar.b);
        acnVarO.m(dfxVar, 2, dxf.b, dyfVar.c);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        return new btd[]{aye.t(bqj.b), aye.t(dnh.b), aye.t(dxf.b)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
