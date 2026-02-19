package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class dxr implements bgx {
    public static final dxr b;
    private static final dfx descriptor;

    static {
        dxr dxrVar = new dxr();
        b = dxrVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.fw3Proto" /* "me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.fw3Proto" /* "me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.fw3Proto" /* cnb.z(-183863254973226L)  */, dxrVar, 6);
        bjs.y(-184073708370730L, cucVar, false, 1);
        bjs.y(-184043643599658L, cucVar, false, 2);
        bjs.y(-184026463730474L, cucVar, false, 3);
        bjs.y(-183987809024810L, cucVar, false, 4);
        bjs.y(-183949154319146L, cucVar, false, 5);
        bjs.y(-181131655772970L, cucVar, false, 6);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        acmVarP.getClass();
        int i = 0;
        Integer num = null;
        dvl dvlVar = null;
        ejx ejxVar = null;
        eer eerVar = null;
        Integer num2 = null;
        Integer num3 = null;
        boolean z = true;
        while (z) {
            int iF = acmVarP.f(dfxVar);
            switch (iF) {
                case -1:
                    z = false;
                    break;
                case 0:
                    num = (Integer) acmVarP.i(dfxVar, 0, bqj.b, num);
                    i |= 1;
                    break;
                case 1:
                    dvlVar = (dvl) acmVarP.i(dfxVar, 1, dvj.b, dvlVar);
                    i |= 2;
                    break;
                case 2:
                    ejxVar = (ejx) acmVarP.i(dfxVar, 2, ejv.b, ejxVar);
                    i |= 4;
                    break;
                case 3:
                    eerVar = (eer) acmVarP.i(dfxVar, 3, eep.b, eerVar);
                    i |= 8;
                    break;
                case 4:
                    num2 = (Integer) acmVarP.i(dfxVar, 4, bqj.b, num2);
                    i |= 16;
                    break;
                case 5:
                    num3 = (Integer) acmVarP.i(dfxVar, 5, bqj.b, num3);
                    i |= 32;
                    break;
                default:
                    throw new bsd(iF);
            }
        }
        acmVarP._bp(dfxVar);
        return new dxt(i, num, dvlVar, ejxVar, eerVar, num2, num3);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        dxt dxtVar = (dxt) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        bqj bqjVar = bqj.b;
        acnVarO.m(dfxVar, 0, bqjVar, dxtVar.a);
        acnVarO.m(dfxVar, 1, dvj.b, dxtVar.b);
        acnVarO.m(dfxVar, 2, ejv.b, dxtVar.c);
        acnVarO.m(dfxVar, 3, eep.b, dxtVar.d);
        acnVarO.m(dfxVar, 4, bqjVar, dxtVar.e);
        acnVarO.m(dfxVar, 5, bqjVar, dxtVar.f);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        bqj bqjVar = bqj.b;
        return new btd[]{aye.t(bqjVar), aye.t(dvj.b), aye.t(ejv.b), aye.t(eep.b), aye.t(bqjVar), aye.t(bqjVar)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
