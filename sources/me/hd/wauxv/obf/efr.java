package me.hd.wauxv.obf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class efr implements bgx {
    public static final efr b;
    private static final dfx descriptor;

    static {
        efr efrVar = new efr();
        b = efrVar;
        cuc cucVar = new cuc(cnb.z(-288544492878634L), efrVar, 2);
        bjs.y(-289837278034730L, cucVar, false, 1);
        bjs.y(-290241004960554L, cucVar, false, 2);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        btt[] bttVarArr = eft.a;
        acmVarP.getClass();
        Integer num = null;
        boolean z = true;
        int i = 0;
        List list = null;
        while (z) {
            int iF = acmVarP.f(dfxVar);
            if (iF == -1) {
                z = false;
            } else if (iF == 0) {
                num = (Integer) acmVarP.i(dfxVar, 0, bqj.b, num);
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
        return new eft(i, num, list);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        eft eftVar = (eft) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        btt[] bttVarArr = eft.a;
        acnVarO.m(dfxVar, 0, bqj.b, eftVar.b);
        acnVarO.m(dfxVar, 1, (btd) bttVarArr[1].getValue(), eftVar.c);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        return new btd[]{aye.t(bqj.b), aye.t((btd) eft.a[1].getValue())};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
