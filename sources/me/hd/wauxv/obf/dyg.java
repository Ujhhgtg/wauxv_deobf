package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class dyg implements bgx {
    public static final dyg b;
    private static final dfx descriptor;

    static {
        dyg dygVar = new dyg();
        b = dygVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.gt1Proto" /* cnb.z(-204247169760042L) */, dygVar, 18);
        bjs.y(-203907867343658L, cucVar, false, 1);
        bjs.y(-203864917670698L, cucVar, false, 2);
        bjs.y(-203856327736106L, cucVar, false, 3);
        bjs.y(-203800493161258L, cucVar, false, 4);
        bjs.y(-203770428390186L, cucVar, false, 5);
        bjs.y(-203744658586410L, cucVar, false, 6);
        bjs.y(-209731842997034L, cucVar, false, 7);
        bjs.y(-209645943651114L, cucVar, false, 8);
        bjs.y(-209598699010858L, cucVar, false, 9);
        bjs.y(-209590109076266L, cucVar, false, 10);
        bjs.y(-209517094632234L, cucVar, false, 15);
        bjs.y(-209478439926570L, cucVar, false, 16);
        bjs.y(-210006720903978L, cucVar, false, 17);
        bjs.y(-209972361165610L, cucVar, false, 18);
        bjs.y(-209886461819690L, cucVar, false, 19);
        bjs.y(-209869281950506L, cucVar, false, 20);
        bjs.y(-209787677571882L, cucVar, false, 21);
        bjs.y(-209152022412074L, cucVar, false, 22);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        String str;
        int i;
        Integer num;
        String str2;
        String str3;
        String str4;
        Integer num2;
        String str5;
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        acmVarP.getClass();
        Integer num3 = null;
        Integer num4 = null;
        String str6 = null;
        String str7 = null;
        Integer num5 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        dyx dyxVar = null;
        String str11 = null;
        String str12 = null;
        String str13 = null;
        String str14 = null;
        String str15 = null;
        String str16 = null;
        String str17 = null;
        String str18 = null;
        String str19 = null;
        int i2 = 0;
        boolean z = true;
        while (z) {
            String str20 = str11;
            int iF = acmVarP.f(dfxVar);
            switch (iF) {
                case -1:
                    num = num4;
                    str2 = str12;
                    str3 = str17;
                    str4 = str6;
                    z = false;
                    str6 = str4;
                    str11 = str20;
                    str12 = str2;
                    num4 = num;
                    str17 = str3;
                    break;
                case 0:
                    num = num4;
                    str2 = str12;
                    str3 = str17;
                    str4 = str6;
                    str15 = (String) acmVarP.i(dfxVar, 0, dnh.b, str15);
                    i2 |= 1;
                    str6 = str4;
                    str11 = str20;
                    str12 = str2;
                    num4 = num;
                    str17 = str3;
                    break;
                case 1:
                    num2 = num4;
                    str5 = str12;
                    str16 = (String) acmVarP.i(dfxVar, 1, dnh.b, str16);
                    i2 |= 2;
                    str17 = str17;
                    str11 = str20;
                    str12 = str5;
                    num4 = num2;
                    break;
                case 2:
                    num2 = num4;
                    str5 = str12;
                    str17 = (String) acmVarP.i(dfxVar, 2, dnh.b, str17);
                    i2 |= 4;
                    str11 = str20;
                    str12 = str5;
                    num4 = num2;
                    break;
                case 3:
                    num2 = num4;
                    str5 = str12;
                    str18 = (String) acmVarP.i(dfxVar, 3, dnh.b, str18);
                    i2 |= 8;
                    str11 = str20;
                    str12 = str5;
                    num4 = num2;
                    break;
                case 4:
                    num2 = num4;
                    str5 = str12;
                    str19 = (String) acmVarP.i(dfxVar, 4, dnh.b, str19);
                    i2 |= 16;
                    str11 = str20;
                    str12 = str5;
                    num4 = num2;
                    break;
                case 5:
                    num2 = num4;
                    str5 = str12;
                    str11 = (String) acmVarP.i(dfxVar, 5, dnh.b, str20);
                    i2 |= 32;
                    str12 = str5;
                    num4 = num2;
                    break;
                case 6:
                    num2 = num4;
                    str12 = (String) acmVarP.i(dfxVar, 6, dnh.b, str12);
                    i2 |= 64;
                    str11 = str20;
                    num4 = num2;
                    break;
                case 7:
                    str = str12;
                    str13 = (String) acmVarP.i(dfxVar, 7, dnh.b, str13);
                    i2 |= 128;
                    str11 = str20;
                    str12 = str;
                    break;
                case 8:
                    str = str12;
                    str14 = (String) acmVarP.i(dfxVar, 8, dnh.b, str14);
                    i2 |= 256;
                    str11 = str20;
                    str12 = str;
                    break;
                case 9:
                    str = str12;
                    num3 = (Integer) acmVarP.i(dfxVar, 9, bqj.b, num3);
                    i2 |= 512;
                    str11 = str20;
                    str12 = str;
                    break;
                case 10:
                    str = str12;
                    str7 = (String) acmVarP.i(dfxVar, 10, dnh.b, str7);
                    i2 |= 1024;
                    str11 = str20;
                    str12 = str;
                    break;
                case 11:
                    str = str12;
                    num5 = (Integer) acmVarP.i(dfxVar, 11, bqj.b, num5);
                    i2 |= 2048;
                    str11 = str20;
                    str12 = str;
                    break;
                case 12:
                    str = str12;
                    str6 = (String) acmVarP.i(dfxVar, 12, dnh.b, str6);
                    i2 |= 4096;
                    str11 = str20;
                    str12 = str;
                    break;
                case 13:
                    str = str12;
                    num4 = (Integer) acmVarP.i(dfxVar, 13, bqj.b, num4);
                    i2 |= 8192;
                    str11 = str20;
                    str12 = str;
                    break;
                case 14:
                    str = str12;
                    str8 = (String) acmVarP.i(dfxVar, 14, dnh.b, str8);
                    i2 |= 16384;
                    str11 = str20;
                    str12 = str;
                    break;
                case 15:
                    str = str12;
                    str9 = (String) acmVarP.i(dfxVar, 15, dnh.b, str9);
                    i = 32768;
                    i2 |= i;
                    str11 = str20;
                    str12 = str;
                    break;
                case 16:
                    str = str12;
                    str10 = (String) acmVarP.i(dfxVar, 16, dnh.b, str10);
                    i = 65536;
                    i2 |= i;
                    str11 = str20;
                    str12 = str;
                    break;
                case 17:
                    str = str12;
                    dyxVar = (dyx) acmVarP.i(dfxVar, 17, dyv.b, dyxVar);
                    i = 131072;
                    i2 |= i;
                    str11 = str20;
                    str12 = str;
                    break;
                default:
                    throw new bsd(iF);
            }
        }
        Integer num6 = num4;
        String str21 = str12;
        acmVarP._bp(dfxVar);
        return new dyi(i2, str15, str16, str17, str18, str19, str11, str21, str13, str14, num3, str7, num5, str6, num6, str8, str9, str10, dyxVar);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        dyi dyiVar = (dyi) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        dnh dnhVar = dnh.b;
        acnVarO.m(dfxVar, 0, dnhVar, dyiVar.a);
        acnVarO.m(dfxVar, 1, dnhVar, dyiVar.b);
        acnVarO.m(dfxVar, 2, dnhVar, dyiVar.c);
        acnVarO.m(dfxVar, 3, dnhVar, dyiVar.d);
        acnVarO.m(dfxVar, 4, dnhVar, dyiVar.e);
        acnVarO.m(dfxVar, 5, dnhVar, dyiVar.f);
        acnVarO.m(dfxVar, 6, dnhVar, dyiVar.g);
        acnVarO.m(dfxVar, 7, dnhVar, dyiVar.h);
        acnVarO.m(dfxVar, 8, dnhVar, dyiVar.i);
        bqj bqjVar = bqj.b;
        acnVarO.m(dfxVar, 9, bqjVar, dyiVar.j);
        acnVarO.m(dfxVar, 10, dnhVar, dyiVar.k);
        acnVarO.m(dfxVar, 11, bqjVar, dyiVar.l);
        acnVarO.m(dfxVar, 12, dnhVar, dyiVar.m);
        acnVarO.m(dfxVar, 13, bqjVar, dyiVar.n);
        acnVarO.m(dfxVar, 14, dnhVar, dyiVar.o);
        acnVarO.m(dfxVar, 15, dnhVar, dyiVar.p);
        acnVarO.m(dfxVar, 16, dnhVar, dyiVar.q);
        acnVarO.m(dfxVar, 17, dyv.b, dyiVar.r);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        dnh dnhVar = dnh.b;
        btd btdVarT = aye.t(dnhVar);
        btd btdVarT2 = aye.t(dnhVar);
        btd btdVarT3 = aye.t(dnhVar);
        btd btdVarT4 = aye.t(dnhVar);
        btd btdVarT5 = aye.t(dnhVar);
        btd btdVarT6 = aye.t(dnhVar);
        btd btdVarT7 = aye.t(dnhVar);
        btd btdVarT8 = aye.t(dnhVar);
        btd btdVarT9 = aye.t(dnhVar);
        bqj bqjVar = bqj.b;
        return new btd[]{btdVarT, btdVarT2, btdVarT3, btdVarT4, btdVarT5, btdVarT6, btdVarT7, btdVarT8, btdVarT9, aye.t(bqjVar), aye.t(dnhVar), aye.t(bqjVar), aye.t(dnhVar), aye.t(bqjVar), aye.t(dnhVar), aye.t(dnhVar), aye.t(dnhVar), aye.t(dyv.b)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
