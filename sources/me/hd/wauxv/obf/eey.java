package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class eey implements bgx {
    public static final eey b;
    private static final dfx descriptor;

    static {
        eey eeyVar = new eey();
        b = eeyVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.t10Proto" /* "me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.t10Proto" /* "me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.t10Proto" /* cnb.z(-295970491333418L)  */, eeyVar, 11);
        bjs.y(-296180944730922L, cucVar, false, 1);
        bjs.y(-296120815188778L, cucVar, false, 2);
        bjs.y(-296129405123370L, cucVar, false, 3);
        bjs.y(-296137995057962L, cucVar, false, 4);
        bjs.y(-296146584992554L, cucVar, false, 5);
        bjs.y(-296086455450410L, cucVar, false, 6);
        bjs.y(-296095045385002L, cucVar, false, 7);
        bjs.y(-296103635319594L, cucVar, false, 8);
        bjs.y(-296112225254186L, cucVar, false, 9);
        bjs.y(-296052095712042L, cucVar, false, 10);
        bjs.y(-296060685646634L, cucVar, false, 11);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        boolean z;
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        acmVarP.getClass();
        Integer num = null;
        Integer num2 = null;
        String str = null;
        Integer num3 = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        Integer num4 = null;
        String str6 = null;
        String str7 = null;
        int i = 0;
        boolean z2 = true;
        while (z2) {
            int iF = acmVarP.f(dfxVar);
            switch (iF) {
                case -1:
                    z2 = false;
                    continue;
                case 0:
                    z = z2;
                    str = (String) acmVarP.i(dfxVar, 0, dnh.b, str);
                    i |= 1;
                    break;
                case 1:
                    z = z2;
                    num3 = (Integer) acmVarP.i(dfxVar, 1, bqj.b, num3);
                    i |= 2;
                    break;
                case 2:
                    z = z2;
                    str2 = (String) acmVarP.i(dfxVar, 2, dnh.b, str2);
                    i |= 4;
                    break;
                case 3:
                    z = z2;
                    str3 = (String) acmVarP.i(dfxVar, 3, dnh.b, str3);
                    i |= 8;
                    break;
                case 4:
                    z = z2;
                    str4 = (String) acmVarP.i(dfxVar, 4, dnh.b, str4);
                    i |= 16;
                    break;
                case 5:
                    z = z2;
                    str5 = (String) acmVarP.i(dfxVar, 5, dnh.b, str5);
                    i |= 32;
                    break;
                case 6:
                    z = z2;
                    num4 = (Integer) acmVarP.i(dfxVar, 6, bqj.b, num4);
                    i |= 64;
                    break;
                case 7:
                    z = z2;
                    str6 = (String) acmVarP.i(dfxVar, 7, dnh.b, str6);
                    i |= 128;
                    break;
                case 8:
                    z = z2;
                    str7 = (String) acmVarP.i(dfxVar, 8, dnh.b, str7);
                    i |= 256;
                    break;
                case 9:
                    z = z2;
                    num = (Integer) acmVarP.i(dfxVar, 9, bqj.b, num);
                    i |= 512;
                    break;
                case 10:
                    z = z2;
                    num2 = (Integer) acmVarP.i(dfxVar, 10, bqj.b, num2);
                    i |= 1024;
                    break;
                default:
                    throw new bsd(iF);
            }
            z2 = z;
        }
        acmVarP._bp(dfxVar);
        return new efa(i, str, num3, str2, str3, str4, str5, num4, str6, str7, num, num2);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        efa efaVar = (efa) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        dnh dnhVar = dnh.b;
        acnVarO.m(dfxVar, 0, dnhVar, efaVar.a);
        bqj bqjVar = bqj.b;
        acnVarO.m(dfxVar, 1, bqjVar, efaVar.b);
        acnVarO.m(dfxVar, 2, dnhVar, efaVar.c);
        acnVarO.m(dfxVar, 3, dnhVar, efaVar.d);
        acnVarO.m(dfxVar, 4, dnhVar, efaVar.e);
        acnVarO.m(dfxVar, 5, dnhVar, efaVar.f);
        acnVarO.m(dfxVar, 6, bqjVar, efaVar.g);
        acnVarO.m(dfxVar, 7, dnhVar, efaVar.h);
        acnVarO.m(dfxVar, 8, dnhVar, efaVar.i);
        acnVarO.m(dfxVar, 9, bqjVar, efaVar.j);
        acnVarO.m(dfxVar, 10, bqjVar, efaVar.k);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        dnh dnhVar = dnh.b;
        btd btdVarT = aye.t(dnhVar);
        bqj bqjVar = bqj.b;
        return new btd[]{btdVarT, aye.t(bqjVar), aye.t(dnhVar), aye.t(dnhVar), aye.t(dnhVar), aye.t(dnhVar), aye.t(bqjVar), aye.t(dnhVar), aye.t(dnhVar), aye.t(bqjVar), aye.t(bqjVar)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
