package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class dva implements bgx {
    public static final dva b;
    private static final dfx descriptor;

    static {
        dva dvaVar = new dva();
        b = dvaVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.a23Proto" /* cnb.z(-155387621800746L) */, dvaVar, 4);
        bjs.y(-143503447292714L, cucVar, false, 1);
        bjs.y(-144018843368234L, cucVar, false, 2);
        bjs.y(-143980188662570L, cucVar, false, 3);
        bjs.y(-143954418858794L, cucVar, false, 4);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        acmVarP.getClass();
        int i = 0;
        String str = null;
        Integer num = null;
        Integer num2 = null;
        Integer num3 = null;
        boolean z = true;
        while (z) {
            int iF = acmVarP.f(dfxVar);
            if (iF == -1) {
                z = false;
            } else if (iF == 0) {
                str = (String) acmVarP.i(dfxVar, 0, dnh.b, str);
                i |= 1;
            } else if (iF == 1) {
                num = (Integer) acmVarP.i(dfxVar, 1, bqj.b, num);
                i |= 2;
            } else if (iF == 2) {
                num2 = (Integer) acmVarP.i(dfxVar, 2, bqj.b, num2);
                i |= 4;
            } else {
                if (iF != 3) {
                    throw new bsd(iF);
                }
                num3 = (Integer) acmVarP.i(dfxVar, 3, bqj.b, num3);
                i |= 8;
            }
        }
        acmVarP._bp(dfxVar);
        return new dvc(i, str, num, num2, num3);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        dvc dvcVar = (dvc) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        acnVarO.m(dfxVar, 0, dnh.b, dvcVar.a);
        bqj bqjVar = bqj.b;
        acnVarO.m(dfxVar, 1, bqjVar, dvcVar.b);
        acnVarO.m(dfxVar, 2, bqjVar, dvcVar.c);
        acnVarO.m(dfxVar, 3, bqjVar, dvcVar.d);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        btd btdVarT = aye.t(dnh.b);
        bqj bqjVar = bqj.b;
        return new btd[]{btdVarT, aye.t(bqjVar), aye.t(bqjVar), aye.t(bqjVar)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
