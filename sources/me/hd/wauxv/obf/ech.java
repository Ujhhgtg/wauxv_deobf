package me.hd.wauxv.obf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ech implements bgx {
    public static final ech b;
    private static final dfx descriptor;

    static {
        ech echVar = new ech();
        b = echVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.o5Proto" /* cnb.z(-260107514411818L) */, echVar, 2);
        bjs.y(-260373802384170L, cucVar, false, 1);
        bjs.y(-260330852711210L, cucVar, false, 2);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        btt[] bttVarArr = ecj.a;
        acmVarP.getClass();
        dwa dwaVar = null;
        boolean z = true;
        int i = 0;
        List list = null;
        while (z) {
            int iF = acmVarP.f(dfxVar);
            if (iF == -1) {
                z = false;
            } else if (iF == 0) {
                dwaVar = (dwa) acmVarP.i(dfxVar, 0, dvy.b, dwaVar);
                i |= 1;
            } else {
                if (iF != 1) {
                    throw new bsd(iF);
                }
                list = (List) acmVarP.i(dfxVar, 1, (btd) bttVarArr[1].getValue(), list);
                i |= 2;
            }
        }
        acmVarP._bp(dfxVar);
        return new ecj(i, dwaVar, list);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        ecj ecjVar = (ecj) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        btt[] bttVarArr = ecj.a;
        acnVarO.m(dfxVar, 0, dvy.b, ecjVar.b);
        acnVarO.m(dfxVar, 1, (btd) bttVarArr[1].getValue(), ecjVar.c);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        return new btd[]{aye.t(dvy.b), aye.t((btd) ecj.a[1].getValue())};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
