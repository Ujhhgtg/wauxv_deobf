package me.hd.wauxv.obf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ehh implements bgx {
    public static final ehh b;
    private static final dfx descriptor;

    static {
        ehh ehhVar = new ehh();
        b = ehhVar;
        cuc cucVar = new cuc(cnb.z(-306523225979690L), ehhVar, 2);
        bjs.y(-306166743694122L, cucVar, false, 1);
        bjs.y(-306098024217386L, cucVar, false, 2);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        btt[] bttVarArr = ehj.a;
        acmVarP.getClass();
        List list = null;
        boolean z = true;
        int i = 0;
        Integer num = null;
        while (z) {
            int iF = acmVarP.f(dfxVar);
            if (iF == -1) {
                z = false;
            } else if (iF == 0) {
                list = (List) acmVarP.i(dfxVar, 0, (btd) bttVarArr[0].getValue(), list);
                i |= 1;
            } else {
                if (iF != 1) {
                    throw new bsd(iF);
                }
                num = (Integer) acmVarP.i(dfxVar, 1, bqj.b, num);
                i |= 2;
            }
        }
        acmVarP._bp(dfxVar);
        return new ehj(i, num, list);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        ehj ehjVar = (ehj) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        acnVarO.m(dfxVar, 0, (btd) ehj.a[0].getValue(), ehjVar.b);
        acnVarO.m(dfxVar, 1, bqj.b, ehjVar.c);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        return new btd[]{aye.t((btd) ehj.a[0].getValue()), aye.t(bqj.b)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
