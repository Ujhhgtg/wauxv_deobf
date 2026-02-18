package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ebm implements bgx {
    public static final ebm b;
    private static final dfx descriptor;

    static {
        ebm ebmVar = new ebm();
        b = ebmVar;
        cuc cucVar = new cuc(cnb.z(-257380210178858L), ebmVar, 3);
        bjs.y(-257573483707178L, cucVar, false, 1);
        bjs.y(-257582073641770L, cucVar, false, 2);
        bjs.y(-257590663576362L, cucVar, false, 3);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        acmVarP.getClass();
        Boolean bool = null;
        boolean z = true;
        int i = 0;
        duh duhVar = null;
        Integer num = null;
        while (z) {
            int iF = acmVarP.f(dfxVar);
            if (iF == -1) {
                z = false;
            } else if (iF == 0) {
                bool = (Boolean) acmVarP.i(dfxVar, 0, pv.b, bool);
                i |= 1;
            } else if (iF == 1) {
                duhVar = (duh) acmVarP.i(dfxVar, 1, duf.b, duhVar);
                i |= 2;
            } else {
                if (iF != 2) {
                    throw new bsd(iF);
                }
                num = (Integer) acmVarP.i(dfxVar, 2, bqj.b, num);
                i |= 4;
            }
        }
        acmVarP._bp(dfxVar);
        return new ebo(i, bool, duhVar, num);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        ebo eboVar = (ebo) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        acnVarO.m(dfxVar, 0, pv.b, eboVar.a);
        acnVarO.m(dfxVar, 1, duf.b, eboVar.b);
        acnVarO.m(dfxVar, 2, bqj.b, eboVar.c);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        return new btd[]{aye.t(pv.b), aye.t(duf.b), aye.t(bqj.b)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
