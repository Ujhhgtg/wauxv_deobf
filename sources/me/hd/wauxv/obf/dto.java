package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class dto implements bgx {
    public static final dto b;
    private static final dfx descriptor;

    static {
        dto dtoVar = new dto();
        b = dtoVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.LocationProto" /* "me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.LocationProto" /* "me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.LocationProto" /* "me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.LocationProto" /* cnb.z(-222062694103850L)   */, dtoVar, 15);
        bjs.y(-221117801298730L, cucVar, false, 1);
        bjs.y(-221092031494954L, cucVar, false, 2);
        bjs.y(-221070556658474L, cucVar, false, 3);
        bjs.y(-221014722083626L, cucVar, false, 4);
        bjs.y(-221530118159146L, cucVar, false, 5);
        bjs.y(-221517233257258L, cucVar, false, 6);
        bjs.y(-221439923845930L, cucVar, false, 7);
        bjs.y(-221371204369194L, cucVar, false, 8);
        bjs.y(-221379794303786L, cucVar, false, 9);
        bjs.y(-221341139598122L, cucVar, false, 10);
        bjs.y(-227272489433898L, cucVar, false, 11);
        bjs.y(-227285374335786L, cucVar, false, 12);
        bjs.y(-227195180022570L, cucVar, false, 14);
        bjs.y(-227203769957162L, cucVar, false, 15);
        bjs.y(-227122165578538L, cucVar, false, 16);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        String str;
        String str2;
        Float f;
        Integer num;
        String str3;
        String str4;
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        acmVarP.getClass();
        Integer num2 = null;
        String str5 = null;
        Integer num3 = null;
        Integer num4 = null;
        Float f2 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        Integer num5 = null;
        String str11 = null;
        Integer num6 = null;
        Float f3 = null;
        Float f4 = null;
        int i = 0;
        boolean z = true;
        while (z) {
            String str12 = str7;
            int iF = acmVarP.f(dfxVar);
            switch (iF) {
                case -1:
                    str = str5;
                    str2 = str8;
                    f = f4;
                    num = num3;
                    z = false;
                    num3 = num;
                    str7 = str12;
                    str5 = str;
                    f4 = f;
                    str8 = str2;
                    break;
                case 0:
                    str = str5;
                    str2 = str8;
                    f = f4;
                    num = num3;
                    f3 = (Float) acmVarP.i(dfxVar, 0, bbm.b, f3);
                    i |= 1;
                    num3 = num;
                    str7 = str12;
                    str5 = str;
                    f4 = f;
                    str8 = str2;
                    break;
                case 1:
                    str3 = str5;
                    str4 = str8;
                    f4 = (Float) acmVarP.i(dfxVar, 1, bbm.b, f4);
                    i |= 2;
                    str7 = str12;
                    str8 = str4;
                    str5 = str3;
                    break;
                case 2:
                    str3 = str5;
                    str4 = str8;
                    str7 = (String) acmVarP.i(dfxVar, 2, dnh.b, str12);
                    i |= 4;
                    str8 = str4;
                    str5 = str3;
                    break;
                case 3:
                    str3 = str5;
                    str8 = (String) acmVarP.i(dfxVar, 3, dnh.b, str8);
                    i |= 8;
                    str7 = str12;
                    str5 = str3;
                    break;
                case 4:
                    str2 = str8;
                    str9 = (String) acmVarP.i(dfxVar, 4, dnh.b, str9);
                    i |= 16;
                    str7 = str12;
                    str8 = str2;
                    break;
                case 5:
                    str2 = str8;
                    str10 = (String) acmVarP.i(dfxVar, 5, dnh.b, str10);
                    i |= 32;
                    str7 = str12;
                    str8 = str2;
                    break;
                case 6:
                    str2 = str8;
                    num5 = (Integer) acmVarP.i(dfxVar, 6, bqj.b, num5);
                    i |= 64;
                    str7 = str12;
                    str8 = str2;
                    break;
                case 7:
                    str2 = str8;
                    str11 = (String) acmVarP.i(dfxVar, 7, dnh.b, str11);
                    i |= 128;
                    str7 = str12;
                    str8 = str2;
                    break;
                case 8:
                    str2 = str8;
                    num6 = (Integer) acmVarP.i(dfxVar, 8, bqj.b, num6);
                    i |= 256;
                    str7 = str12;
                    str8 = str2;
                    break;
                case 9:
                    str2 = str8;
                    num2 = (Integer) acmVarP.i(dfxVar, 9, bqj.b, num2);
                    i |= 512;
                    str7 = str12;
                    str8 = str2;
                    break;
                case 10:
                    str2 = str8;
                    num4 = (Integer) acmVarP.i(dfxVar, 10, bqj.b, num4);
                    i |= 1024;
                    str7 = str12;
                    str8 = str2;
                    break;
                case 11:
                    str2 = str8;
                    f2 = (Float) acmVarP.i(dfxVar, 11, bbm.b, f2);
                    i |= 2048;
                    str7 = str12;
                    str8 = str2;
                    break;
                case 12:
                    str2 = str8;
                    num3 = (Integer) acmVarP.i(dfxVar, 12, bqj.b, num3);
                    i |= 4096;
                    str7 = str12;
                    str8 = str2;
                    break;
                case 13:
                    str2 = str8;
                    str5 = (String) acmVarP.i(dfxVar, 13, dnh.b, str5);
                    i |= 8192;
                    str7 = str12;
                    str8 = str2;
                    break;
                case 14:
                    str2 = str8;
                    str6 = (String) acmVarP.i(dfxVar, 14, dnh.b, str6);
                    i |= 16384;
                    str7 = str12;
                    str8 = str2;
                    break;
                default:
                    throw new bsd(iF);
            }
        }
        String str13 = str5;
        String str14 = str8;
        acmVarP._bp(dfxVar);
        return new dtq(i, f3, f4, str7, str14, str9, str10, num5, str11, num6, num2, num4, f2, num3, str13, str6);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        dtq dtqVar = (dtq) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        bbm bbmVar = bbm.b;
        acnVarO.m(dfxVar, 0, bbmVar, dtqVar.a);
        acnVarO.m(dfxVar, 1, bbmVar, dtqVar.b);
        dnh dnhVar = dnh.b;
        acnVarO.m(dfxVar, 2, dnhVar, dtqVar.c);
        acnVarO.m(dfxVar, 3, dnhVar, dtqVar.d);
        acnVarO.m(dfxVar, 4, dnhVar, dtqVar.e);
        acnVarO.m(dfxVar, 5, dnhVar, dtqVar.f);
        bqj bqjVar = bqj.b;
        acnVarO.m(dfxVar, 6, bqjVar, dtqVar.g);
        acnVarO.m(dfxVar, 7, dnhVar, dtqVar.h);
        acnVarO.m(dfxVar, 8, bqjVar, dtqVar.i);
        acnVarO.m(dfxVar, 9, bqjVar, dtqVar.j);
        acnVarO.m(dfxVar, 10, bqjVar, dtqVar.k);
        acnVarO.m(dfxVar, 11, bbmVar, dtqVar.l);
        acnVarO.m(dfxVar, 12, bqjVar, dtqVar.m);
        acnVarO.m(dfxVar, 13, dnhVar, dtqVar.n);
        acnVarO.m(dfxVar, 14, dnhVar, dtqVar.o);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        bbm bbmVar = bbm.b;
        btd btdVarT = aye.t(bbmVar);
        btd btdVarT2 = aye.t(bbmVar);
        dnh dnhVar = dnh.b;
        btd btdVarT3 = aye.t(dnhVar);
        btd btdVarT4 = aye.t(dnhVar);
        btd btdVarT5 = aye.t(dnhVar);
        btd btdVarT6 = aye.t(dnhVar);
        bqj bqjVar = bqj.b;
        return new btd[]{btdVarT, btdVarT2, btdVarT3, btdVarT4, btdVarT5, btdVarT6, aye.t(bqjVar), aye.t(dnhVar), aye.t(bqjVar), aye.t(bqjVar), aye.t(bqjVar), aye.t(bbmVar), aye.t(bqjVar), aye.t(dnhVar), aye.t(dnhVar)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
