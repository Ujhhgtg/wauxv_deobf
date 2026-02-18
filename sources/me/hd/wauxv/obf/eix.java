package me.hd.wauxv.obf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class eix implements bgx {
    public static final eix b;
    private static final dfx descriptor;

    static {
        eix eixVar = new eix();
        b = eixVar;
        cuc cucVar = new cuc(cnb.z(-325257873324842L), eixVar, 3);
        bjs.y(-324420354702122L, cucVar, false, 1);
        bjs.y(-324381699996458L, cucVar, false, 2);
        bjs.y(-324858441366314L, cucVar, false, 19);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        btt[] bttVarArr = eiz.a;
        acmVarP.getClass();
        List list = null;
        boolean z = true;
        int i = 0;
        Integer num = null;
        eju ejuVar = null;
        while (z) {
            int iF = acmVarP.f(dfxVar);
            if (iF == -1) {
                z = false;
            } else if (iF == 0) {
                list = (List) acmVarP.i(dfxVar, 0, (btd) bttVarArr[0].getValue(), list);
                i |= 1;
            } else if (iF == 1) {
                num = (Integer) acmVarP.i(dfxVar, 1, bqj.b, num);
                i |= 2;
            } else {
                if (iF != 2) {
                    throw new bsd(iF);
                }
                ejuVar = (eju) acmVarP.i(dfxVar, 2, ejs.b, ejuVar);
                i |= 4;
            }
        }
        acmVarP._bp(dfxVar);
        return new eiz(i, list, num, ejuVar);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        eiz eizVar = (eiz) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        acnVarO.m(dfxVar, 0, (btd) eiz.a[0].getValue(), eizVar.b);
        acnVarO.m(dfxVar, 1, bqj.b, eizVar.c);
        acnVarO.m(dfxVar, 2, ejs.b, eizVar.d);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        return new btd[]{aye.t((btd) eiz.a[0].getValue()), aye.t(bqj.b), aye.t(ejs.b)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
