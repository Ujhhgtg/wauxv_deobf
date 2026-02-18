package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ecb implements bgx {
    public static final ecb b;
    private static final dfx descriptor;

    static {
        ecb ecbVar = new ecb();
        b = ecbVar;
        cuc cucVar = new cuc(cnb.z(-262774689102634L), ecbVar, 5);
        bjs.y(-261868451003178L, cucVar, false, 1);
        bjs.y(-261834091264810L, cucVar, false, 2);
        bjs.y(-261782551657258L, cucVar, false, 3);
        bjs.y(-261752486886186L, cucVar, false, 4);
        bjs.y(-262216343354154L, cucVar, false, 5);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        acmVarP.getClass();
        int i = 0;
        dsy dsyVar = null;
        Integer num = null;
        String str = null;
        dxq dxqVar = null;
        eex eexVar = null;
        boolean z = true;
        while (z) {
            int iF = acmVarP.f(dfxVar);
            if (iF == -1) {
                z = false;
            } else if (iF == 0) {
                dsyVar = (dsy) acmVarP.i(dfxVar, 0, dsw.b, dsyVar);
                i |= 1;
            } else if (iF == 1) {
                num = (Integer) acmVarP.i(dfxVar, 1, bqj.b, num);
                i |= 2;
            } else if (iF == 2) {
                str = (String) acmVarP.i(dfxVar, 2, dnh.b, str);
                i |= 4;
            } else if (iF == 3) {
                dxqVar = (dxq) acmVarP.i(dfxVar, 3, dxo.b, dxqVar);
                i |= 8;
            } else {
                if (iF != 4) {
                    throw new bsd(iF);
                }
                eexVar = (eex) acmVarP.i(dfxVar, 4, eev.b, eexVar);
                i |= 16;
            }
        }
        acmVarP._bp(dfxVar);
        return new ecd(i, dsyVar, num, str, dxqVar, eexVar);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        ecd ecdVar = (ecd) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        acnVarO.m(dfxVar, 0, dsw.b, ecdVar.a);
        acnVarO.m(dfxVar, 1, bqj.b, ecdVar.b);
        acnVarO.m(dfxVar, 2, dnh.b, ecdVar.c);
        acnVarO.m(dfxVar, 3, dxo.b, ecdVar.d);
        acnVarO.m(dfxVar, 4, eev.b, ecdVar.e);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        return new btd[]{aye.t(dsw.b), aye.t(bqj.b), aye.t(dnh.b), aye.t(dxo.b), aye.t(eev.b)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
