package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class dul implements bgx {
    public static final dul b;
    private static final dfx descriptor;

    static {
        dul dulVar = new dul();
        b = dulVar;
        cuc cucVar = new cuc(cnb.z(-313807490513706L), dulVar, 2);
        bjs.y(-301820236790570L, cucVar, false, 1);
        bjs.y(-301850301561642L, cucVar, false, 2);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        acmVarP.getClass();
        String str = null;
        boolean z = true;
        int i = 0;
        String str2 = null;
        while (z) {
            int iF = acmVarP.f(dfxVar);
            if (iF == -1) {
                z = false;
            } else if (iF == 0) {
                str = (String) acmVarP.i(dfxVar, 0, dnh.b, str);
                i |= 1;
            } else {
                if (iF != 1) {
                    throw new bsd(iF);
                }
                str2 = (String) acmVarP.i(dfxVar, 1, dnh.b, str2);
                i |= 2;
            }
        }
        acmVarP._bp(dfxVar);
        return new dun(i, str, str2);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        dun dunVar = (dun) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        dnh dnhVar = dnh.b;
        acnVarO.m(dfxVar, 0, dnhVar, dunVar.a);
        acnVarO.m(dfxVar, 1, dnhVar, dunVar.b);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        dnh dnhVar = dnh.b;
        return new btd[]{aye.t(dnhVar), aye.t(dnhVar)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
