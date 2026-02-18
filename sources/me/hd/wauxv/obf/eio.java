package me.hd.wauxv.obf;

import net.bytebuddy.jar.asm.Opcodes;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class eio implements bgx {
    public static final eio b;
    private static final dfx descriptor;

    static {
        eio eioVar = new eio();
        b = eioVar;
        cuc cucVar = new cuc(cnb.z(-320018013223722L), eioVar, 21);
        bjs.y(-317462507682602L, cucVar, false, 1);
        bjs.y(-317449622780714L, cucVar, false, 2);
        bjs.y(-317355133500202L, cucVar, false, 3);
        bjs.y(-317325068729130L, cucVar, false, 4);
        bjs.y(-317213399579434L, cucVar, false, 5);
        bjs.y(-317750270491434L, cucVar, false, 6);
        bjs.y(-317724500687658L, cucVar, false, 7);
        bjs.y(-317630011407146L, cucVar, false, 8);
        bjs.y(-317599946636074L, cucVar, false, 9);
        bjs.y(-317574176832298L, cucVar, false, 10);
        bjs.y(-317509752322858L, cucVar, false, 11);
        bjs.y(-316882687097642L, cucVar, false, 12);
        bjs.y(-316899866966826L, cucVar, false, 13);
        bjs.y(-316771017947946L, cucVar, false, 21);
        bjs.y(-316758133046058L, cucVar, false, 22);
        bjs.y(-316667938732842L, cucVar, false, 23);
        bjs.y(-317191924742954L, cucVar, false, 25);
        bjs.y(-317114615331626L, cucVar, false, 26);
        bjs.y(-317071665658666L, cucVar, false, 27);
        bjs.y(-316972881410858L, cucVar, false, 28);
        bjs.y(-316959996508970L, cucVar, false, 29);
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
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        acmVarP.getClass();
        String str6 = null;
        String str7 = null;
        String str8 = null;
        Integer num = null;
        String str9 = null;
        String str10 = null;
        String str11 = null;
        String str12 = null;
        String str13 = null;
        Integer num2 = null;
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
        int i2 = 0;
        boolean z = true;
        while (z) {
            Long l2 = l;
            int iF = acmVarP.f(dfxVar);
            switch (iF) {
                case -1:
                    str2 = str7;
                    str3 = str18;
                    z = false;
                    str8 = str8;
                    l = l2;
                    str7 = str2;
                    str18 = str3;
                    break;
                case 0:
                    str2 = str7;
                    str3 = str18;
                    str16 = (String) acmVarP.i(dfxVar, 0, dnh.b, str16);
                    i2 |= 1;
                    str8 = str8;
                    l = l2;
                    str6 = str6;
                    str7 = str2;
                    str18 = str3;
                    break;
                case 1:
                    str4 = str7;
                    str5 = str6;
                    str17 = (String) acmVarP.i(dfxVar, 1, dnh.b, str17);
                    i2 |= 2;
                    str18 = str18;
                    l = l2;
                    str6 = str5;
                    str7 = str4;
                    break;
                case 2:
                    str4 = str7;
                    str5 = str6;
                    str18 = (String) acmVarP.i(dfxVar, 2, dnh.b, str18);
                    i2 |= 4;
                    l = l2;
                    str6 = str5;
                    str7 = str4;
                    break;
                case 3:
                    str4 = str7;
                    str5 = str6;
                    str19 = (String) acmVarP.i(dfxVar, 3, dnh.b, str19);
                    i2 |= 8;
                    l = l2;
                    str6 = str5;
                    str7 = str4;
                    break;
                case 4:
                    str4 = str7;
                    str5 = str6;
                    str20 = (String) acmVarP.i(dfxVar, 4, dnh.b, str20);
                    i2 |= 16;
                    l = l2;
                    str6 = str5;
                    str7 = str4;
                    break;
                case 5:
                    str4 = str7;
                    str5 = str6;
                    str21 = (String) acmVarP.i(dfxVar, 5, dnh.b, str21);
                    i2 |= 32;
                    l = l2;
                    str6 = str5;
                    str7 = str4;
                    break;
                case 6:
                    str4 = str7;
                    str5 = str6;
                    str22 = (String) acmVarP.i(dfxVar, 6, dnh.b, str22);
                    i2 |= 64;
                    l = l2;
                    str6 = str5;
                    str7 = str4;
                    break;
                case 7:
                    str4 = str7;
                    str5 = str6;
                    str23 = (String) acmVarP.i(dfxVar, 7, dnh.b, str23);
                    i2 |= 128;
                    l = l2;
                    str6 = str5;
                    str7 = str4;
                    break;
                case 8:
                    str4 = str7;
                    str5 = str6;
                    l = (Long) acmVarP.i(dfxVar, 8, bya.b, l2);
                    i2 |= 256;
                    str6 = str5;
                    str7 = str4;
                    break;
                case 9:
                    str4 = str7;
                    str6 = (String) acmVarP.i(dfxVar, 9, dnh.b, str6);
                    i2 |= 512;
                    l = l2;
                    str7 = str4;
                    break;
                case 10:
                    str = str6;
                    num = (Integer) acmVarP.i(dfxVar, 10, bqj.b, num);
                    i2 |= 1024;
                    l = l2;
                    str6 = str;
                    break;
                case 11:
                    str = str6;
                    str9 = (String) acmVarP.i(dfxVar, 11, dnh.b, str9);
                    i2 |= 2048;
                    l = l2;
                    str6 = str;
                    break;
                case 12:
                    str = str6;
                    str8 = (String) acmVarP.i(dfxVar, 12, dnh.b, str8);
                    i2 |= 4096;
                    l = l2;
                    str6 = str;
                    break;
                case 13:
                    str = str6;
                    str7 = (String) acmVarP.i(dfxVar, 13, dnh.b, str7);
                    i2 |= 8192;
                    l = l2;
                    str6 = str;
                    break;
                case 14:
                    str = str6;
                    str10 = (String) acmVarP.i(dfxVar, 14, dnh.b, str10);
                    i2 |= 16384;
                    l = l2;
                    str6 = str;
                    break;
                case 15:
                    str = str6;
                    str11 = (String) acmVarP.i(dfxVar, 15, dnh.b, str11);
                    i = 32768;
                    i2 |= i;
                    l = l2;
                    str6 = str;
                    break;
                case 16:
                    str = str6;
                    str12 = (String) acmVarP.i(dfxVar, 16, dnh.b, str12);
                    i = 65536;
                    i2 |= i;
                    l = l2;
                    str6 = str;
                    break;
                case 17:
                    str = str6;
                    str13 = (String) acmVarP.i(dfxVar, 17, dnh.b, str13);
                    i = 131072;
                    i2 |= i;
                    l = l2;
                    str6 = str;
                    break;
                case 18:
                    str = str6;
                    num2 = (Integer) acmVarP.i(dfxVar, 18, bqj.b, num2);
                    i = 262144;
                    i2 |= i;
                    l = l2;
                    str6 = str;
                    break;
                case 19:
                    str = str6;
                    str14 = (String) acmVarP.i(dfxVar, 19, dnh.b, str14);
                    i = Opcodes.ASM8;
                    i2 |= i;
                    l = l2;
                    str6 = str;
                    break;
                case 20:
                    str = str6;
                    str15 = (String) acmVarP.i(dfxVar, 20, dnh.b, str15);
                    i = 1048576;
                    i2 |= i;
                    l = l2;
                    str6 = str;
                    break;
                default:
                    throw new bsd(iF);
            }
        }
        String str24 = str7;
        Long l3 = l;
        String str25 = str16;
        String str26 = str17;
        String str27 = str18;
        acmVarP._bp(dfxVar);
        String str28 = str9;
        return new eiq(i2, str25, str26, str27, str19, str20, str21, str22, str23, l3, str6, num, str28, str8, str24, str10, str11, str12, str13, num2, str14, str15);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        eiq eiqVar = (eiq) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        dnh dnhVar = dnh.b;
        acnVarO.m(dfxVar, 0, dnhVar, eiqVar.a);
        acnVarO.m(dfxVar, 1, dnhVar, eiqVar.b);
        acnVarO.m(dfxVar, 2, dnhVar, eiqVar.c);
        acnVarO.m(dfxVar, 3, dnhVar, eiqVar.d);
        acnVarO.m(dfxVar, 4, dnhVar, eiqVar.e);
        acnVarO.m(dfxVar, 5, dnhVar, eiqVar.f);
        acnVarO.m(dfxVar, 6, dnhVar, eiqVar.g);
        acnVarO.m(dfxVar, 7, dnhVar, eiqVar.h);
        acnVarO.m(dfxVar, 8, bya.b, eiqVar.i);
        acnVarO.m(dfxVar, 9, dnhVar, eiqVar.j);
        bqj bqjVar = bqj.b;
        acnVarO.m(dfxVar, 10, bqjVar, eiqVar.k);
        acnVarO.m(dfxVar, 11, dnhVar, eiqVar.l);
        acnVarO.m(dfxVar, 12, dnhVar, eiqVar.m);
        acnVarO.m(dfxVar, 13, dnhVar, eiqVar.n);
        acnVarO.m(dfxVar, 14, dnhVar, eiqVar.o);
        acnVarO.m(dfxVar, 15, dnhVar, eiqVar.p);
        acnVarO.m(dfxVar, 16, dnhVar, eiqVar.q);
        acnVarO.m(dfxVar, 17, dnhVar, eiqVar.r);
        acnVarO.m(dfxVar, 18, bqjVar, eiqVar.s);
        acnVarO.m(dfxVar, 19, dnhVar, eiqVar.t);
        acnVarO.m(dfxVar, 20, dnhVar, eiqVar.u);
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
        btd btdVarT9 = aye.t(bya.b);
        btd btdVarT10 = aye.t(dnhVar);
        bqj bqjVar = bqj.b;
        return new btd[]{btdVarT, btdVarT2, btdVarT3, btdVarT4, btdVarT5, btdVarT6, btdVarT7, btdVarT8, btdVarT9, btdVarT10, aye.t(bqjVar), aye.t(dnhVar), aye.t(dnhVar), aye.t(dnhVar), aye.t(dnhVar), aye.t(dnhVar), aye.t(dnhVar), aye.t(dnhVar), aye.t(bqjVar), aye.t(dnhVar), aye.t(dnhVar)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
