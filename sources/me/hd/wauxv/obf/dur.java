package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class dur implements bgx {
    public static final dur b;
    private static final dfx descriptor;

    static {
        dur durVar = new dur();
        b = durVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.WeappInfoProto" /* "me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.WeappInfoProto" /* "me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.WeappInfoProto" /* "me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.WeappInfoProto" /* cnb.z(-304616260500266L)   */, durVar, 9);
        bjs.y(-328474803829546L, cucVar, false, 1);
        bjs.y(-328388904483626L, cucVar, false, 2);
        bjs.y(-328367429647146L, cucVar, false, 3);
        bjs.y(-328333069908778L, cucVar, false, 4);
        bjs.y(-328307300105002L, cucVar, false, 5);
        bjs.y(-328229990693674L, cucVar, false, 6);
        bjs.y(-328732501867306L, cucVar, false, 7);
        bjs.y(-328676667292458L, cucVar, false, 8);
        bjs.y(-328642307554090L, cucVar, false, 9);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        acmVarP.getClass();
        String str = null;
        String str2 = null;
        Integer num = null;
        Integer num2 = null;
        String str3 = null;
        Integer num3 = null;
        String str4 = null;
        Integer num4 = null;
        String str5 = null;
        int i = 0;
        boolean z = true;
        while (z) {
            int iF = acmVarP.f(dfxVar);
            switch (iF) {
                case -1:
                    z = false;
                    break;
                case 0:
                    str = (String) acmVarP.i(dfxVar, 0, dnh.b, str);
                    i |= 1;
                    break;
                case 1:
                    str2 = (String) acmVarP.i(dfxVar, 1, dnh.b, str2);
                    i |= 2;
                    break;
                case 2:
                    num = (Integer) acmVarP.i(dfxVar, 2, bqj.b, num);
                    i |= 4;
                    break;
                case 3:
                    num2 = (Integer) acmVarP.i(dfxVar, 3, bqj.b, num2);
                    i |= 8;
                    break;
                case 4:
                    str3 = (String) acmVarP.i(dfxVar, 4, dnh.b, str3);
                    i |= 16;
                    break;
                case 5:
                    num3 = (Integer) acmVarP.i(dfxVar, 5, bqj.b, num3);
                    i |= 32;
                    break;
                case 6:
                    str4 = (String) acmVarP.i(dfxVar, 6, dnh.b, str4);
                    i |= 64;
                    break;
                case 7:
                    num4 = (Integer) acmVarP.i(dfxVar, 7, bqj.b, num4);
                    i |= 128;
                    break;
                case 8:
                    str5 = (String) acmVarP.i(dfxVar, 8, dnh.b, str5);
                    i |= 256;
                    break;
                default:
                    throw new bsd(iF);
            }
        }
        acmVarP._bp(dfxVar);
        return new dut(i, str, str2, num, num2, str3, num3, str4, num4, str5);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        dut dutVar = (dut) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        dnh dnhVar = dnh.b;
        acnVarO.m(dfxVar, 0, dnhVar, dutVar.a);
        acnVarO.m(dfxVar, 1, dnhVar, dutVar.b);
        bqj bqjVar = bqj.b;
        acnVarO.m(dfxVar, 2, bqjVar, dutVar.c);
        acnVarO.m(dfxVar, 3, bqjVar, dutVar.d);
        acnVarO.m(dfxVar, 4, dnhVar, dutVar.e);
        acnVarO.m(dfxVar, 5, bqjVar, dutVar.f);
        acnVarO.m(dfxVar, 6, dnhVar, dutVar.g);
        acnVarO.m(dfxVar, 7, bqjVar, dutVar.h);
        acnVarO.m(dfxVar, 8, dnhVar, dutVar.i);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        dnh dnhVar = dnh.b;
        btd btdVarT = aye.t(dnhVar);
        btd btdVarT2 = aye.t(dnhVar);
        bqj bqjVar = bqj.b;
        return new btd[]{btdVarT, btdVarT2, aye.t(bqjVar), aye.t(bqjVar), aye.t(dnhVar), aye.t(bqjVar), aye.t(dnhVar), aye.t(bqjVar), aye.t(dnhVar)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
