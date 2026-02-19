package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class dui implements bgx {
    public static final dui b;
    private static final dfx descriptor;

    static {
        dui duiVar = new dui();
        b = duiVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.StreamvideoProto" /* "me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.StreamvideoProto" /* "me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.StreamvideoProto" /* cnb.z(-297881751780138L)  */, duiVar, 8);
        bjs.y(-296941153942314L, cucVar, false, 1);
        bjs.y(-296876729432874L, cucVar, false, 2);
        bjs.y(-297370650671914L, cucVar, false, 3);
        bjs.y(-297254686554922L, cucVar, false, 4);
        bjs.y(-297194557012778L, cucVar, false, 5);
        bjs.y(-298770810010410L, cucVar, false, 6);
        bjs.y(-298719270402858L, cucVar, false, 7);
        bjs.y(-298599011318570L, cucVar, false, 8);
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
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
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
                    num = (Integer) acmVarP.i(dfxVar, 1, bqj.b, num);
                    i |= 2;
                    break;
                case 2:
                    str2 = (String) acmVarP.i(dfxVar, 2, dnh.b, str2);
                    i |= 4;
                    break;
                case 3:
                    str3 = (String) acmVarP.i(dfxVar, 3, dnh.b, str3);
                    i |= 8;
                    break;
                case 4:
                    str4 = (String) acmVarP.i(dfxVar, 4, dnh.b, str4);
                    i |= 16;
                    break;
                case 5:
                    str5 = (String) acmVarP.i(dfxVar, 5, dnh.b, str5);
                    i |= 32;
                    break;
                case 6:
                    str6 = (String) acmVarP.i(dfxVar, 6, dnh.b, str6);
                    i |= 64;
                    break;
                case 7:
                    str7 = (String) acmVarP.i(dfxVar, 7, dnh.b, str7);
                    i |= 128;
                    break;
                default:
                    throw new bsd(iF);
            }
        }
        acmVarP._bp(dfxVar);
        return new duk(i, str, num, str2, str3, str4, str5, str6, str7);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        duk dukVar = (duk) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        dnh dnhVar = dnh.b;
        acnVarO.m(dfxVar, 0, dnhVar, dukVar.a);
        acnVarO.m(dfxVar, 1, bqj.b, dukVar.b);
        acnVarO.m(dfxVar, 2, dnhVar, dukVar.c);
        acnVarO.m(dfxVar, 3, dnhVar, dukVar.d);
        acnVarO.m(dfxVar, 4, dnhVar, dukVar.e);
        acnVarO.m(dfxVar, 5, dnhVar, dukVar.f);
        acnVarO.m(dfxVar, 6, dnhVar, dukVar.g);
        acnVarO.m(dfxVar, 7, dnhVar, dukVar.h);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        dnh dnhVar = dnh.b;
        return new btd[]{aye.t(dnhVar), aye.t(bqj.b), aye.t(dnhVar), aye.t(dnhVar), aye.t(dnhVar), aye.t(dnhVar), aye.t(dnhVar), aye.t(dnhVar)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
