package me.hd.wauxv.obf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class eed implements bgx {
    public static final eed b;
    private static final dfx descriptor;

    static {
        eed eedVar = new eed();
        b = eedVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.s40Proto" /* cnb.z(-281410552199978L) */, eedVar, 5);
        bjs.y(-280521493969706L, cucVar, false, 1);
        bjs.y(-280508609067818L, cucVar, false, 2);
        bjs.y(-280401234885418L, cucVar, false, 3);
        bjs.y(-280826436647722L, cucVar, false, 4);
        bjs.y(-280843616516906L, cucVar, false, 5);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        btt[] bttVarArr = eef.a;
        acmVarP.getClass();
        int i = 0;
        String str = null;
        List list = null;
        String str2 = null;
        Integer num = null;
        String str3 = null;
        boolean z = true;
        while (z) {
            int iF = acmVarP.f(dfxVar);
            if (iF == -1) {
                z = false;
            } else if (iF == 0) {
                str = (String) acmVarP.i(dfxVar, 0, dnh.b, str);
                i |= 1;
            } else if (iF == 1) {
                list = (List) acmVarP.i(dfxVar, 1, (btd) bttVarArr[1].getValue(), list);
                i |= 2;
            } else if (iF == 2) {
                str2 = (String) acmVarP.i(dfxVar, 2, dnh.b, str2);
                i |= 4;
            } else if (iF == 3) {
                num = (Integer) acmVarP.i(dfxVar, 3, bqj.b, num);
                i |= 8;
            } else {
                if (iF != 4) {
                    throw new bsd(iF);
                }
                str3 = (String) acmVarP.i(dfxVar, 4, dnh.b, str3);
                i |= 16;
            }
        }
        acmVarP._bp(dfxVar);
        return new eef(i, str, list, str2, num, str3);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        eef eefVar = (eef) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        btt[] bttVarArr = eef.a;
        dnh dnhVar = dnh.b;
        acnVarO.m(dfxVar, 0, dnhVar, eefVar.b);
        acnVarO.m(dfxVar, 1, (btd) bttVarArr[1].getValue(), eefVar.c);
        acnVarO.m(dfxVar, 2, dnhVar, eefVar.d);
        acnVarO.m(dfxVar, 3, bqj.b, eefVar.e);
        acnVarO.m(dfxVar, 4, dnhVar, eefVar.f);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        btt[] bttVarArr = eef.a;
        dnh dnhVar = dnh.b;
        return new btd[]{aye.t(dnhVar), aye.t((btd) bttVarArr[1].getValue()), aye.t(dnhVar), aye.t(bqj.b), aye.t(dnhVar)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
