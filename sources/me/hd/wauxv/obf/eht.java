package me.hd.wauxv.obf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class eht implements bgx {
    public static final eht b;
    private static final dfx descriptor;

    static {
        eht ehtVar = new eht();
        b = ehtVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.wc1Proto" /*
                                                                                                               * cnb.z(-
                                                                                                               * 305608397945642L)
                                                                                                               */,
                ehtVar, 1);
        bjs.y(-304719339715370L, cucVar, false, 1);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        IHasGetValue[] bttVarArr = ehv.a;
        acmVarP.getClass();
        List list = null;
        boolean z = true;
        int i = 0;
        while (z) {
            int iF = acmVarP.f(dfxVar);
            if (iF == -1) {
                z = false;
            } else {
                if (iF != 0) {
                    throw new bsd(iF);
                }
                list = (List) acmVarP.i(dfxVar, 0, (btd) bttVarArr[0].getValue(), list);
                i = 1;
            }
        }
        acmVarP._bp(dfxVar);
        return new ehv(i, list);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        acnVarO.m(dfxVar, 0, (btd) ehv.a[0].getValue(), ((ehv) obj).b);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        return new btd[] { aye.t((btd) ehv.a[0].getValue()) };
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
