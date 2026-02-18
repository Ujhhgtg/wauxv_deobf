package me.hd.wauxv.obf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ejv implements bgx {
    public static final ejv b;
    private static final dfx descriptor;

    static {
        ejv ejvVar = new ejv();
        b = ejvVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.zt1Proto" /* cnb.z(-351083511675690L) */, ejvVar, 7);
        bjs.y(-348545186003754L, cucVar, false, 1);
        bjs.y(-348463581625130L, cucVar, false, 2);
        bjs.y(-348394862148394L, cucVar, false, 4);
        bjs.y(-348334732606250L, cucVar, false, 5);
        bjs.y(-347664717708074L, cucVar, false, 6);
        bjs.y(-347578818362154L, cucVar, false, 7);
        bjs.y(-347454264310570L, cucVar, false, 8);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        btt[] bttVarArr = ejx.a;
        acmVarP.getClass();
        int i = 0;
        String str = null;
        String str2 = null;
        Double d = null;
        Integer num = null;
        List list = null;
        List list2 = null;
        Double d2 = null;
        boolean z = true;
        while (z) {
            int iF = acmVarP.f(dfxVar);
            switch (iF) {
                case -1:
                    z = false;
                    break;
                case 0:
                    str = (String) acmVarP.i(dfxVar, 0, dnh.b, str);
                    i |= 1;
                    break;
                case 1:
                    str2 = (String) acmVarP.i(dfxVar, 1, dnh.b, str2);
                    i |= 2;
                    break;
                case 2:
                    d = (Double) acmVarP.i(dfxVar, 2, apl.b, d);
                    i |= 4;
                    break;
                case 3:
                    num = (Integer) acmVarP.i(dfxVar, 3, bqj.b, num);
                    i |= 8;
                    break;
                case 4:
                    list = (List) acmVarP.i(dfxVar, 4, (btd) bttVarArr[4].getValue(), list);
                    i |= 16;
                    break;
                case 5:
                    list2 = (List) acmVarP.i(dfxVar, 5, (btd) bttVarArr[5].getValue(), list2);
                    i |= 32;
                    break;
                case 6:
                    d2 = (Double) acmVarP.i(dfxVar, 6, apl.b, d2);
                    i |= 64;
                    break;
                default:
                    throw new bsd(iF);
            }
        }
        acmVarP._bp(dfxVar);
        return new ejx(i, str, str2, d, num, list, list2, d2);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        ejx ejxVar = (ejx) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        btt[] bttVarArr = ejx.a;
        dnh dnhVar = dnh.b;
        acnVarO.m(dfxVar, 0, dnhVar, ejxVar.b);
        acnVarO.m(dfxVar, 1, dnhVar, ejxVar.c);
        apl aplVar = apl.b;
        acnVarO.m(dfxVar, 2, aplVar, ejxVar.d);
        acnVarO.m(dfxVar, 3, bqj.b, ejxVar.e);
        acnVarO.m(dfxVar, 4, (btd) bttVarArr[4].getValue(), ejxVar.f);
        acnVarO.m(dfxVar, 5, (btd) bttVarArr[5].getValue(), ejxVar.g);
        acnVarO.m(dfxVar, 6, aplVar, ejxVar.h);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        btt[] bttVarArr = ejx.a;
        dnh dnhVar = dnh.b;
        btd btdVarT = aye.t(dnhVar);
        btd btdVarT2 = aye.t(dnhVar);
        apl aplVar = apl.b;
        return new btd[]{btdVarT, btdVarT2, aye.t(aplVar), aye.t(bqj.b), aye.t((btd) bttVarArr[4].getValue()), aye.t((btd) bttVarArr[5].getValue()), aye.t(aplVar)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
