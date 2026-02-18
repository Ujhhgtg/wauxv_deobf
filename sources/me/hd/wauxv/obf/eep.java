package me.hd.wauxv.obf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class eep implements bgx {
    public static final eep b;
    private static final dfx descriptor;

    static {
        eep eepVar = new eep();
        b = eepVar;
        cuc cucVar = new cuc(cnb.z(-271768350620458L), eepVar, 17);
        bjs.y(-271961624148778L, cucVar, false, 1);
        bjs.y(-271935854345002L, cucVar, false, 2);
        bjs.y(-271914379508522L, cucVar, false, 3);
        bjs.y(-271858544933674L, cucVar, false, 4);
        bjs.y(-269075406125866L, cucVar, false, 5);
        bjs.y(-269062521223978L, cucVar, false, 6);
        bjs.y(-268985211812650L, cucVar, false, 7);
        bjs.y(-268916492335914L, cucVar, false, 8);
        bjs.y(-268877837630250L, cucVar, false, 9);
        bjs.y(-268847772859178L, cucVar, false, 10);
        bjs.y(-269363168934698L, cucVar, false, 11);
        bjs.y(-269315924294442L, cucVar, false, 12);
        bjs.y(-269303039392554L, cucVar, false, 13);
        bjs.y(-269277269588778L, cucVar, false, 14);
        bjs.y(-269191370242858L, cucVar, false, 15);
        bjs.y(-269204255144746L, cucVar, false, 16);
        bjs.y(-269122650766122L, cucVar, false, 17);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        String str;
        int i;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        btt[] bttVarArr = eer.a;
        acmVarP.getClass();
        String str8 = null;
        String str9 = null;
        String str10 = null;
        String str11 = null;
        String str12 = null;
        Integer num = null;
        Long l = null;
        List list = null;
        Integer num2 = null;
        String str13 = null;
        String str14 = null;
        Integer num3 = null;
        String str15 = null;
        Float f = null;
        Float f2 = null;
        String str16 = null;
        String str17 = null;
        int i2 = 0;
        boolean z = true;
        while (z) {
            String str18 = str13;
            int iF = acmVarP.f(dfxVar);
            switch (iF) {
                case -1:
                    str2 = str9;
                    str3 = str14;
                    str4 = str16;
                    str5 = str10;
                    z = false;
                    str10 = str5;
                    str13 = str18;
                    str14 = str3;
                    str9 = str2;
                    str16 = str4;
                    break;
                case 0:
                    str2 = str9;
                    str3 = str14;
                    str4 = str16;
                    str5 = str10;
                    f = (Float) acmVarP.i(dfxVar, 0, bbm.b, f);
                    i2 |= 1;
                    str10 = str5;
                    str13 = str18;
                    str14 = str3;
                    str9 = str2;
                    str16 = str4;
                    break;
                case 1:
                    str6 = str9;
                    str7 = str14;
                    f2 = (Float) acmVarP.i(dfxVar, 1, bbm.b, f2);
                    i2 |= 2;
                    str16 = str16;
                    str13 = str18;
                    str14 = str7;
                    str9 = str6;
                    break;
                case 2:
                    str6 = str9;
                    str7 = str14;
                    str16 = (String) acmVarP.i(dfxVar, 2, dnh.b, str16);
                    i2 |= 4;
                    str13 = str18;
                    str14 = str7;
                    str9 = str6;
                    break;
                case 3:
                    str6 = str9;
                    str7 = str14;
                    str17 = (String) acmVarP.i(dfxVar, 3, dnh.b, str17);
                    i2 |= 8;
                    str13 = str18;
                    str14 = str7;
                    str9 = str6;
                    break;
                case 4:
                    str6 = str9;
                    str7 = str14;
                    str13 = (String) acmVarP.i(dfxVar, 4, dnh.b, str18);
                    i2 |= 16;
                    str14 = str7;
                    str9 = str6;
                    break;
                case 5:
                    str6 = str9;
                    str14 = (String) acmVarP.i(dfxVar, 5, dnh.b, str14);
                    i2 |= 32;
                    str13 = str18;
                    str9 = str6;
                    break;
                case 6:
                    str = str14;
                    num3 = (Integer) acmVarP.i(dfxVar, 6, bqj.b, num3);
                    i2 |= 64;
                    str13 = str18;
                    str14 = str;
                    break;
                case 7:
                    str = str14;
                    str15 = (String) acmVarP.i(dfxVar, 7, dnh.b, str15);
                    i2 |= 128;
                    str13 = str18;
                    str14 = str;
                    break;
                case 8:
                    str = str14;
                    str8 = (String) acmVarP.i(dfxVar, 8, dnh.b, str8);
                    i2 |= 256;
                    str13 = str18;
                    str14 = str;
                    break;
                case 9:
                    str = str14;
                    str12 = (String) acmVarP.i(dfxVar, 9, dnh.b, str12);
                    i2 |= 512;
                    str13 = str18;
                    str14 = str;
                    break;
                case 10:
                    str = str14;
                    num = (Integer) acmVarP.i(dfxVar, 10, bqj.b, num);
                    i2 |= 1024;
                    str13 = str18;
                    str14 = str;
                    break;
                case 11:
                    str = str14;
                    str11 = (String) acmVarP.i(dfxVar, 11, dnh.b, str11);
                    i2 |= 2048;
                    str13 = str18;
                    str14 = str;
                    break;
                case 12:
                    str = str14;
                    str10 = (String) acmVarP.i(dfxVar, 12, dnh.b, str10);
                    i2 |= 4096;
                    str13 = str18;
                    str14 = str;
                    break;
                case 13:
                    str = str14;
                    str9 = (String) acmVarP.i(dfxVar, 13, dnh.b, str9);
                    i2 |= 8192;
                    str13 = str18;
                    str14 = str;
                    break;
                case 14:
                    str = str14;
                    l = (Long) acmVarP.i(dfxVar, 14, bya.b, l);
                    i2 |= 16384;
                    str13 = str18;
                    str14 = str;
                    break;
                case 15:
                    str = str14;
                    list = (List) acmVarP.i(dfxVar, 15, (btd) bttVarArr[15].getValue(), list);
                    i = 32768;
                    i2 |= i;
                    str13 = str18;
                    str14 = str;
                    break;
                case 16:
                    str = str14;
                    num2 = (Integer) acmVarP.i(dfxVar, 16, bqj.b, num2);
                    i = 65536;
                    i2 |= i;
                    str13 = str18;
                    str14 = str;
                    break;
                default:
                    throw new bsd(iF);
            }
        }
        String str19 = str9;
        String str20 = str14;
        acmVarP._bp(dfxVar);
        return new eer(i2, f, f2, str16, str17, str13, str20, num3, str15, str8, str12, num, str11, str10, str19, l, list, num2);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        eer eerVar = (eer) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        btt[] bttVarArr = eer.a;
        bbm bbmVar = bbm.b;
        acnVarO.m(dfxVar, 0, bbmVar, eerVar.b);
        acnVarO.m(dfxVar, 1, bbmVar, eerVar.c);
        dnh dnhVar = dnh.b;
        acnVarO.m(dfxVar, 2, dnhVar, eerVar.d);
        acnVarO.m(dfxVar, 3, dnhVar, eerVar.e);
        acnVarO.m(dfxVar, 4, dnhVar, eerVar.f);
        acnVarO.m(dfxVar, 5, dnhVar, eerVar.g);
        bqj bqjVar = bqj.b;
        acnVarO.m(dfxVar, 6, bqjVar, eerVar.h);
        acnVarO.m(dfxVar, 7, dnhVar, eerVar.i);
        acnVarO.m(dfxVar, 8, dnhVar, eerVar.j);
        acnVarO.m(dfxVar, 9, dnhVar, eerVar.k);
        acnVarO.m(dfxVar, 10, bqjVar, eerVar.l);
        acnVarO.m(dfxVar, 11, dnhVar, eerVar.m);
        acnVarO.m(dfxVar, 12, dnhVar, eerVar.n);
        acnVarO.m(dfxVar, 13, dnhVar, eerVar.o);
        acnVarO.m(dfxVar, 14, bya.b, eerVar.p);
        acnVarO.m(dfxVar, 15, (btd) bttVarArr[15].getValue(), eerVar.q);
        acnVarO.m(dfxVar, 16, bqjVar, eerVar.r);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        btt[] bttVarArr = eer.a;
        bbm bbmVar = bbm.b;
        btd btdVarT = aye.t(bbmVar);
        btd btdVarT2 = aye.t(bbmVar);
        dnh dnhVar = dnh.b;
        btd btdVarT3 = aye.t(dnhVar);
        btd btdVarT4 = aye.t(dnhVar);
        btd btdVarT5 = aye.t(dnhVar);
        btd btdVarT6 = aye.t(dnhVar);
        bqj bqjVar = bqj.b;
        return new btd[]{btdVarT, btdVarT2, btdVarT3, btdVarT4, btdVarT5, btdVarT6, aye.t(bqjVar), aye.t(dnhVar), aye.t(dnhVar), aye.t(dnhVar), aye.t(bqjVar), aye.t(dnhVar), aye.t(dnhVar), aye.t(dnhVar), aye.t(bya.b), aye.t((btd) bttVarArr[15].getValue()), aye.t(bqjVar)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
