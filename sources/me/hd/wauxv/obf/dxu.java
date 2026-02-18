package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class dxu implements bgx {
    public static final dxu b;
    private static final dfx descriptor;

    static {
        dxu dxuVar = new dxu();
        b = dxuVar;
        cuc cucVar = new cuc(cnb.z(-181664231717674L), dxuVar, 2);
        bjs.y(-181874685115178L, cucVar, false, 1);
        bjs.y(-181840325376810L, cucVar, false, 2);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        acmVarP.getClass();
        Integer num = null;
        boolean z = true;
        int i = 0;
        String str = null;
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
                str = (String) acmVarP.i(dfxVar, 1, dnh.b, str);
                i |= 2;
            }
        }
        acmVarP._bp(dfxVar);
        return new dxw(i, num, str);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        dxw dxwVar = (dxw) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        acnVarO.m(dfxVar, 0, bqj.b, dxwVar.a);
        acnVarO.m(dfxVar, 1, dnh.b, dxwVar.b);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        return new btd[]{aye.t(bqj.b), aye.t(dnh.b)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
