package me.hd.wauxv.obf;

import net.bytebuddy.jar.asm.Opcodes;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class duu implements bgx {
    public static final duu b;
    private static final dfx descriptor;

    static {
        duu duuVar = new duu();
        b = duuVar;
        cuc cucVar = new cuc(cnb.z(-327942227884842L), duuVar, 20);
        bjs.y(-329776178920234L, cucVar, false, 1);
        bjs.y(-329685984607018L, cucVar, false, 2);
        bjs.y(-329617265130282L, cucVar, false, 3);
        bjs.y(-329024559643434L, cucVar, false, 4);
        bjs.y(-328925775395626L, cucVar, false, 5);
        bjs.y(-328835581082410L, cucVar, false, 6);
        bjs.y(-328762566638378L, cucVar, false, 7);
        bjs.y(-329273667746602L, cucVar, false, 8);
        bjs.y(-329260782844714L, cucVar, false, 9);
        bjs.y(-329235013040938L, cucVar, false, 10);
        bjs.y(-329149113695018L, cucVar, false, 11);
        bjs.y(-329131933825834L, cucVar, false, 12);
        bjs.y(-329050329447210L, cucVar, false, 13);
        bjs.y(-326271485606698L, cucVar, false, 14);
        bjs.y(-326245715802922L, cucVar, false, 15);
        bjs.y(-326207061097258L, cucVar, false, 16);
        bjs.y(-326134046653226L, cucVar, false, 17);
        bjs.y(-326099686914858L, cucVar, false, 18);
        bjs.y(-326073917111082L, cucVar, false, 19);
        bjs.y(-326035262405418L, cucVar, false, 20);
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
        acmVarP.getClass();
        String str8 = null;
        String str9 = null;
        String str10 = null;
        String str11 = null;
        String str12 = null;
        String str13 = null;
        String str14 = null;
        String str15 = null;
        Long l = null;
        String str16 = null;
        String str17 = null;
        String str18 = null;
        String str19 = null;
        String str20 = null;
        String str21 = null;
        String str22 = null;
        String str23 = null;
        Long l2 = null;
        String str24 = null;
        String str25 = null;
        int i2 = 0;
        boolean z = true;
        while (z) {
            String str26 = str18;
            int iF = acmVarP.f(dfxVar);
            switch (iF) {
                case -1:
                    str2 = str9;
                    str3 = str19;
                    str4 = str22;
                    str5 = str10;
                    z = false;
                    str10 = str5;
                    str18 = str26;
                    str19 = str3;
                    str9 = str2;
                    str22 = str4;
                    break;
                case 0:
                    str2 = str9;
                    str3 = str19;
                    str4 = str22;
                    str5 = str10;
                    str20 = (String) acmVarP.i(dfxVar, 0, dnh.b, str20);
                    i2 |= 1;
                    str10 = str5;
                    str18 = str26;
                    str19 = str3;
                    str9 = str2;
                    str22 = str4;
                    break;
                case 1:
                    str6 = str9;
                    str7 = str19;
                    str21 = (String) acmVarP.i(dfxVar, 1, dnh.b, str21);
                    i2 |= 2;
                    str22 = str22;
                    str18 = str26;
                    str19 = str7;
                    str9 = str6;
                    break;
                case 2:
                    str6 = str9;
                    str7 = str19;
                    str22 = (String) acmVarP.i(dfxVar, 2, dnh.b, str22);
                    i2 |= 4;
                    str18 = str26;
                    str19 = str7;
                    str9 = str6;
                    break;
                case 3:
                    str6 = str9;
                    str7 = str19;
                    str23 = (String) acmVarP.i(dfxVar, 3, dnh.b, str23);
                    i2 |= 8;
                    str18 = str26;
                    str19 = str7;
                    str9 = str6;
                    break;
                case 4:
                    str6 = str9;
                    str7 = str19;
                    l2 = (Long) acmVarP.i(dfxVar, 4, bya.b, l2);
                    i2 |= 16;
                    str18 = str26;
                    str19 = str7;
                    str9 = str6;
                    break;
                case 5:
                    str6 = str9;
                    str7 = str19;
                    str24 = (String) acmVarP.i(dfxVar, 5, dnh.b, str24);
                    i2 |= 32;
                    str18 = str26;
                    str19 = str7;
                    str9 = str6;
                    break;
                case 6:
                    str6 = str9;
                    str7 = str19;
                    str25 = (String) acmVarP.i(dfxVar, 6, dnh.b, str25);
                    i2 |= 64;
                    str18 = str26;
                    str19 = str7;
                    str9 = str6;
                    break;
                case 7:
                    str6 = str9;
                    str7 = str19;
                    str18 = (String) acmVarP.i(dfxVar, 7, dnh.b, str26);
                    i2 |= 128;
                    str19 = str7;
                    str9 = str6;
                    break;
                case 8:
                    str6 = str9;
                    str19 = (String) acmVarP.i(dfxVar, 8, dnh.b, str19);
                    i2 |= 256;
                    str18 = str26;
                    str9 = str6;
                    break;
                case 9:
                    str = str19;
                    str8 = (String) acmVarP.i(dfxVar, 9, dnh.b, str8);
                    i2 |= 512;
                    str18 = str26;
                    str19 = str;
                    break;
                case 10:
                    str = str19;
                    str11 = (String) acmVarP.i(dfxVar, 10, dnh.b, str11);
                    i2 |= 1024;
                    str18 = str26;
                    str19 = str;
                    break;
                case 11:
                    str = str19;
                    str12 = (String) acmVarP.i(dfxVar, 11, dnh.b, str12);
                    i2 |= 2048;
                    str18 = str26;
                    str19 = str;
                    break;
                case 12:
                    str = str19;
                    str10 = (String) acmVarP.i(dfxVar, 12, dnh.b, str10);
                    i2 |= 4096;
                    str18 = str26;
                    str19 = str;
                    break;
                case 13:
                    str = str19;
                    str9 = (String) acmVarP.i(dfxVar, 13, dnh.b, str9);
                    i2 |= 8192;
                    str18 = str26;
                    str19 = str;
                    break;
                case 14:
                    str = str19;
                    str13 = (String) acmVarP.i(dfxVar, 14, dnh.b, str13);
                    i2 |= 16384;
                    str18 = str26;
                    str19 = str;
                    break;
                case 15:
                    str = str19;
                    str14 = (String) acmVarP.i(dfxVar, 15, dnh.b, str14);
                    i = 32768;
                    i2 |= i;
                    str18 = str26;
                    str19 = str;
                    break;
                case 16:
                    str = str19;
                    str15 = (String) acmVarP.i(dfxVar, 16, dnh.b, str15);
                    i = 65536;
                    i2 |= i;
                    str18 = str26;
                    str19 = str;
                    break;
                case 17:
                    str = str19;
                    l = (Long) acmVarP.i(dfxVar, 17, bya.b, l);
                    i = 131072;
                    i2 |= i;
                    str18 = str26;
                    str19 = str;
                    break;
                case 18:
                    str = str19;
                    str16 = (String) acmVarP.i(dfxVar, 18, dnh.b, str16);
                    i = 262144;
                    i2 |= i;
                    str18 = str26;
                    str19 = str;
                    break;
                case 19:
                    str = str19;
                    str17 = (String) acmVarP.i(dfxVar, 19, dnh.b, str17);
                    i = Opcodes.ASM8;
                    i2 |= i;
                    str18 = str26;
                    str19 = str;
                    break;
                default:
                    throw new bsd(iF);
            }
        }
        String str27 = str9;
        String str28 = str19;
        String str29 = str20;
        String str30 = str21;
        String str31 = str22;
        acmVarP._bp(dfxVar);
        String str32 = str12;
        return new duw(i2, str29, str30, str31, str23, l2, str24, str25, str18, str28, str8, str11, str32, str10, str27, str13, str14, str15, l, str16, str17);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        duw duwVar = (duw) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        dnh dnhVar = dnh.b;
        acnVarO.m(dfxVar, 0, dnhVar, duwVar.a);
        acnVarO.m(dfxVar, 1, dnhVar, duwVar.b);
        acnVarO.m(dfxVar, 2, dnhVar, duwVar.c);
        acnVarO.m(dfxVar, 3, dnhVar, duwVar.d);
        bya byaVar = bya.b;
        acnVarO.m(dfxVar, 4, byaVar, duwVar.e);
        acnVarO.m(dfxVar, 5, dnhVar, duwVar.f);
        acnVarO.m(dfxVar, 6, dnhVar, duwVar.g);
        acnVarO.m(dfxVar, 7, dnhVar, duwVar.h);
        acnVarO.m(dfxVar, 8, dnhVar, duwVar.i);
        acnVarO.m(dfxVar, 9, dnhVar, duwVar.j);
        acnVarO.m(dfxVar, 10, dnhVar, duwVar.k);
        acnVarO.m(dfxVar, 11, dnhVar, duwVar.l);
        acnVarO.m(dfxVar, 12, dnhVar, duwVar.m);
        acnVarO.m(dfxVar, 13, dnhVar, duwVar.n);
        acnVarO.m(dfxVar, 14, dnhVar, duwVar.o);
        acnVarO.m(dfxVar, 15, dnhVar, duwVar.p);
        acnVarO.m(dfxVar, 16, dnhVar, duwVar.q);
        acnVarO.m(dfxVar, 17, byaVar, duwVar.r);
        acnVarO.m(dfxVar, 18, dnhVar, duwVar.s);
        acnVarO.m(dfxVar, 19, dnhVar, duwVar.t);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        dnh dnhVar = dnh.b;
        btd btdVarT = aye.t(dnhVar);
        btd btdVarT2 = aye.t(dnhVar);
        btd btdVarT3 = aye.t(dnhVar);
        btd btdVarT4 = aye.t(dnhVar);
        bya byaVar = bya.b;
        return new btd[]{btdVarT, btdVarT2, btdVarT3, btdVarT4, aye.t(byaVar), aye.t(dnhVar), aye.t(dnhVar), aye.t(dnhVar), aye.t(dnhVar), aye.t(dnhVar), aye.t(dnhVar), aye.t(dnhVar), aye.t(dnhVar), aye.t(dnhVar), aye.t(dnhVar), aye.t(dnhVar), aye.t(dnhVar), aye.t(byaVar), aye.t(dnhVar), aye.t(dnhVar)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
