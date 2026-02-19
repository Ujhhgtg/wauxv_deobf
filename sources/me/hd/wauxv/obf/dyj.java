package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class dyj implements bgx {
    public static final dyj b;
    private static final dfx descriptor;

    static {
        dyj dyjVar = new dyj();
        b = dyjVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.hs3Proto" /* "me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.hs3Proto" /* "me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.hs3Proto" /* "me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.hs3Proto" /* cnb.z(-210165634693930L)   */, dyjVar, 5);
        bjs.y(-210376088091434L, cucVar, false, 1);
        bjs.y(-210307368614698L, cucVar, false, 2);
        bjs.y(-207524229806890L, cucVar, false, 3);
        bjs.y(-207498460003114L, cucVar, false, 4);
        bjs.y(-207408265689898L, cucVar, false, 5);
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
        Integer num4 = null;
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
            } else if (iF == 3) {
                num3 = (Integer) acmVarP.i(dfxVar, 3, bqj.b, num3);
                i |= 8;
            } else {
                if (iF != 4) {
                    throw new bsd(iF);
                }
                num4 = (Integer) acmVarP.i(dfxVar, 4, bqj.b, num4);
                i |= 16;
            }
        }
        acmVarP._bp(dfxVar);
        return new dyl(i, str, num, num2, num3, num4);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        dyl dylVar = (dyl) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        acnVarO.m(dfxVar, 0, dnh.b, dylVar.a);
        bqj bqjVar = bqj.b;
        acnVarO.m(dfxVar, 1, bqjVar, dylVar.b);
        acnVarO.m(dfxVar, 2, bqjVar, dylVar.c);
        acnVarO.m(dfxVar, 3, bqjVar, dylVar.d);
        acnVarO.m(dfxVar, 4, bqjVar, dylVar.e);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        btd btdVarT = aye.t(dnh.b);
        bqj bqjVar = bqj.b;
        return new btd[]{btdVarT, aye.t(bqjVar), aye.t(bqjVar), aye.t(bqjVar), aye.t(bqjVar)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
