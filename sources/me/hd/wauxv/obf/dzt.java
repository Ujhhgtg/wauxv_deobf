package me.hd.wauxv.obf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class dzt implements bgx {
    public static final dzt b;
    private static final dfx descriptor;

    static {
        dzt dztVar = new dzt();
        b = dztVar;
        cuc cucVar = new cuc(cnb.z(-223196565469994L), dztVar, 4);
        bjs.y(-222307507239722L, cucVar, false, 1);
        bjs.y(-222273147501354L, cucVar, false, 2);
        bjs.y(-222195838090026L, cucVar, false, 3);
        bjs.y(-222148593449770L, cucVar, false, 4);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        btt[] bttVarArr = dzv.a;
        acmVarP.getClass();
        int i = 0;
        List list = null;
        Long l = null;
        Integer num = null;
        Long l2 = null;
        boolean z = true;
        while (z) {
            int iF = acmVarP.f(dfxVar);
            if (iF == -1) {
                z = false;
            } else if (iF == 0) {
                list = (List) acmVarP.i(dfxVar, 0, (btd) bttVarArr[0].getValue(), list);
                i |= 1;
            } else if (iF == 1) {
                l = (Long) acmVarP.i(dfxVar, 1, bya.b, l);
                i |= 2;
            } else if (iF == 2) {
                num = (Integer) acmVarP.i(dfxVar, 2, bqj.b, num);
                i |= 4;
            } else {
                if (iF != 3) {
                    throw new bsd(iF);
                }
                l2 = (Long) acmVarP.i(dfxVar, 3, bya.b, l2);
                i |= 8;
            }
        }
        acmVarP._bp(dfxVar);
        return new dzv(i, list, l, num, l2);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        dzv dzvVar = (dzv) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        acnVarO.m(dfxVar, 0, (btd) dzv.a[0].getValue(), dzvVar.b);
        bya byaVar = bya.b;
        acnVarO.m(dfxVar, 1, byaVar, dzvVar.c);
        acnVarO.m(dfxVar, 2, bqj.b, dzvVar.d);
        acnVarO.m(dfxVar, 3, byaVar, dzvVar.e);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        btd btdVarT = aye.t((btd) dzv.a[0].getValue());
        bya byaVar = bya.b;
        return new btd[]{btdVarT, aye.t(byaVar), aye.t(bqj.b), aye.t(byaVar)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
