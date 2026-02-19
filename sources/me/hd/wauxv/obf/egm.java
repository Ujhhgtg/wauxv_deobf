package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class egm implements bgx {
    public static final egm b;
    private static final dfx descriptor;

    static {
        egm egmVar = new egm();
        b = egmVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.vd1Proto" /* "me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.vd1Proto" /* "me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.vd1Proto" /* cnb.z(-312510410390314L)  */, egmVar, 3);
        bjs.y(-312772403395370L, cucVar, false, 1);
        bjs.y(-312677914114858L, cucVar, false, 3);
        bjs.y(-312626374507306L, cucVar, false, 4);
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
        Integer num2 = null;
        String str = null;
        while (z) {
            int iF = acmVarP.f(dfxVar);
            if (iF == -1) {
                z = false;
            } else if (iF == 0) {
                num = (Integer) acmVarP.i(dfxVar, 0, bqj.b, num);
                i |= 1;
            } else if (iF == 1) {
                num2 = (Integer) acmVarP.i(dfxVar, 1, bqj.b, num2);
                i |= 2;
            } else {
                if (iF != 2) {
                    throw new bsd(iF);
                }
                str = (String) acmVarP.i(dfxVar, 2, dnh.b, str);
                i |= 4;
            }
        }
        acmVarP._bp(dfxVar);
        return new ego(i, num, num2, str);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        ego egoVar = (ego) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        bqj bqjVar = bqj.b;
        acnVarO.m(dfxVar, 0, bqjVar, egoVar.a);
        acnVarO.m(dfxVar, 1, bqjVar, egoVar.b);
        acnVarO.m(dfxVar, 2, dnh.b, egoVar.c);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        bqj bqjVar = bqj.b;
        return new btd[]{aye.t(bqjVar), aye.t(bqjVar), aye.t(dnh.b)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
