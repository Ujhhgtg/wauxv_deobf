package me.hd.wauxv.obf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ejm implements bgx {
    public static final ejm b;
    private static final dfx descriptor;

    static {
        ejm ejmVar = new ejm();
        b = ejmVar;
        cuc cucVar = new cuc(cnb.z(-343928096160554L), ejmVar, 4);
        bjs.y(-343588793744170L, cucVar, false, 1);
        bjs.y(-343498599430954L, cucVar, false, 2);
        bjs.y(-343447059823402L, cucVar, false, 3);
        bjs.y(-343356865510186L, cucVar, false, 4);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        btt[] bttVarArr = ejo.a;
        acmVarP.getClass();
        int i = 0;
        List list = null;
        eaq eaqVar = null;
        Integer num = null;
        String str = null;
        boolean z = true;
        while (z) {
            int iF = acmVarP.f(dfxVar);
            if (iF == -1) {
                z = false;
            } else if (iF == 0) {
                list = (List) acmVarP.i(dfxVar, 0, (btd) bttVarArr[0].getValue(), list);
                i |= 1;
            } else if (iF == 1) {
                eaqVar = (eaq) acmVarP.i(dfxVar, 1, eao.b, eaqVar);
                i |= 2;
            } else if (iF == 2) {
                num = (Integer) acmVarP.i(dfxVar, 2, bqj.b, num);
                i |= 4;
            } else {
                if (iF != 3) {
                    throw new bsd(iF);
                }
                str = (String) acmVarP.i(dfxVar, 3, dnh.b, str);
                i |= 8;
            }
        }
        acmVarP._bp(dfxVar);
        return new ejo(i, list, eaqVar, num, str);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        ejo ejoVar = (ejo) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        acnVarO.m(dfxVar, 0, (btd) ejo.a[0].getValue(), ejoVar.b);
        acnVarO.m(dfxVar, 1, eao.b, ejoVar.c);
        acnVarO.m(dfxVar, 2, bqj.b, ejoVar.d);
        acnVarO.m(dfxVar, 3, dnh.b, ejoVar.e);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        return new btd[]{aye.t((btd) ejo.a[0].getValue()), aye.t(eao.b), aye.t(bqj.b), aye.t(dnh.b)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
