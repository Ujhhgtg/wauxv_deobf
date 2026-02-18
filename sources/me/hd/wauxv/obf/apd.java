package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class apd implements bgx {
    public static final apd b;
    private static final dfx descriptor;

    static {
        apd apdVar = new apd();
        b = apdVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.proto.DisturbTimeSpan" /* cnb.z(-335209312549674L) */, apdVar, 2);
        cucVar.x("BeginTime" /* cnb.z(-334376088894250L) */, false);
        cucVar.y(new aoz(1, 1));
        cucVar.x("EndTime" /* cnb.z(-334350319090474L) */, false);
        cucVar.y(new aoz(2, 1));
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        acmVarP.getClass();
        boolean z = true;
        int i = 0;
        Integer num = null;
        Integer num2 = null;
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
                num2 = (Integer) acmVarP.i(dfxVar, 1, bqj.b, num2);
                i |= 2;
            }
        }
        acmVarP._bp(dfxVar);
        if (3 != (i & 3)) {
            bht.ah(i, 3, descriptor);
            throw null;
        }
        apf apfVar = new apf();
        apfVar.a = num;
        apfVar.b = num2;
        return apfVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        apf apfVar = (apf) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        bqj bqjVar = bqj.b;
        acnVarO.m(dfxVar, 0, bqjVar, apfVar.a);
        acnVarO.m(dfxVar, 1, bqjVar, apfVar.b);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        bqj bqjVar = bqj.b;
        return new btd[]{aye.t(bqjVar), aye.t(bqjVar)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
