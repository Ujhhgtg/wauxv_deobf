package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ebs implements bgx {
    public static final ebs b;
    private static final dfx descriptor;

    static {
        ebs ebsVar = new ebs();
        b = ebsVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.nk1Proto" /* "me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.nk1Proto" /* "me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.nk1Proto" /* cnb.z(-258548441283370L)  */, ebsVar, 6);
        bjs.y(-258741714811690L, cucVar, false, 1);
        bjs.y(-258677290302250L, cucVar, false, 2);
        bjs.y(-255782482344746L, cucVar, false, 3);
        bjs.y(-255713762868010L, cucVar, false, 4);
        bjs.y(-256164734434090L, cucVar, false, 5);
        bjs.y(-256053065284394L, cucVar, false, 6);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        acmVarP.getClass();
        int i = 0;
        eie eieVar = null;
        Integer num = null;
        Integer num2 = null;
        Long l = null;
        String str = null;
        Integer num3 = null;
        boolean z = true;
        while (z) {
            int iF = acmVarP.f(dfxVar);
            switch (iF) {
                case -1:
                    z = false;
                    break;
                case 0:
                    eieVar = (eie) acmVarP.i(dfxVar, 0, eic.b, eieVar);
                    i |= 1;
                    break;
                case 1:
                    num = (Integer) acmVarP.i(dfxVar, 1, bqj.b, num);
                    i |= 2;
                    break;
                case 2:
                    num2 = (Integer) acmVarP.i(dfxVar, 2, bqj.b, num2);
                    i |= 4;
                    break;
                case 3:
                    l = (Long) acmVarP.i(dfxVar, 3, bya.b, l);
                    i |= 8;
                    break;
                case 4:
                    str = (String) acmVarP.i(dfxVar, 4, dnh.b, str);
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
        return new ebu(i, eieVar, num, num2, l, str, num3);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        ebu ebuVar = (ebu) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        acnVarO.m(dfxVar, 0, eic.b, ebuVar.a);
        bqj bqjVar = bqj.b;
        acnVarO.m(dfxVar, 1, bqjVar, ebuVar.b);
        acnVarO.m(dfxVar, 2, bqjVar, ebuVar.c);
        acnVarO.m(dfxVar, 3, bya.b, ebuVar.d);
        acnVarO.m(dfxVar, 4, dnh.b, ebuVar.e);
        acnVarO.m(dfxVar, 5, bqjVar, ebuVar.f);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        btd btdVarT = aye.t(eic.b);
        bqj bqjVar = bqj.b;
        return new btd[]{btdVarT, aye.t(bqjVar), aye.t(bqjVar), aye.t(bya.b), aye.t(dnh.b), aye.t(bqjVar)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
