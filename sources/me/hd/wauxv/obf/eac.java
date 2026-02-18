package me.hd.wauxv.obf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class eac implements bgx {
    public static final eac b;
    private static final dfx descriptor;

    static {
        eac eacVar = new eac();
        b = eacVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.ls3Proto" /* cnb.z(-226782863162154L) */, eacVar, 3);
        bjs.y(-228694123608874L, cucVar, false, 1);
        bjs.y(-228651173935914L, cucVar, false, 2);
        bjs.y(-228608224262954L, cucVar, false, 3);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        btt[] bttVarArr = eae.a;
        acmVarP.getClass();
        Integer num = null;
        boolean z = true;
        int i = 0;
        List list = null;
        String str = null;
        while (z) {
            int iF = acmVarP.f(dfxVar);
            if (iF == -1) {
                z = false;
            } else if (iF == 0) {
                num = (Integer) acmVarP.i(dfxVar, 0, bqj.b, num);
                i |= 1;
            } else if (iF == 1) {
                list = (List) acmVarP.i(dfxVar, 1, (btd) bttVarArr[1].getValue(), list);
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
        return new eae(i, num, list, str);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        eae eaeVar = (eae) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        btt[] bttVarArr = eae.a;
        acnVarO.m(dfxVar, 0, bqj.b, eaeVar.b);
        acnVarO.m(dfxVar, 1, (btd) bttVarArr[1].getValue(), eaeVar.c);
        acnVarO.m(dfxVar, 2, dnh.b, eaeVar.d);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        return new btd[]{aye.t(bqj.b), aye.t((btd) eae.a[1].getValue()), aye.t(dnh.b)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
