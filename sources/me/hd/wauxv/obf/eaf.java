package me.hd.wauxv.obf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class eaf implements bgx {
    public static final eaf b;
    private static final dfx descriptor;

    static {
        eaf eafVar = new eaf();
        b = eafVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.lt1Proto" /* cnb.z(-227757820738346L) */, eafVar, 16);
        bjs.y(-227968274135850L, cucVar, false, 1);
        bjs.y(-227886669757226L, cucVar, false, 2);
        bjs.y(-225082056112938L, cucVar, false, 3);
        bjs.y(-225047696374570L, cucVar, false, 4);
        bjs.y(-225017631603498L, cucVar, false, 5);
        bjs.y(-224936027224874L, cucVar, false, 6);
        bjs.y(-224905962453802L, cucVar, false, 7);
        bjs.y(-224884487617322L, cucVar, false, 8);
        bjs.y(-225356934019882L, cucVar, false, 9);
        bjs.y(-225292509510442L, cucVar, false, 10);
        bjs.y(-225202315197226L, cucVar, false, 13);
        bjs.y(-225150775589674L, cucVar, false, 14);
        bjs.y(-224519415397162L, cucVar, false, 15);
        bjs.y(-224407746247466L, cucVar, false, 16);
        bjs.y(-224343321738026L, cucVar, false, 17);
        bjs.y(-224832948009770L, cucVar, false, 18);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        Integer num;
        Integer num2;
        Integer num3;
        Long l;
        Integer num4;
        Integer num5;
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        btt[] bttVarArr = eah.a;
        acmVarP.getClass();
        Integer num6 = null;
        Integer num7 = null;
        Integer num8 = null;
        Long l2 = null;
        Integer num9 = null;
        String str = null;
        Integer num10 = null;
        String str2 = null;
        dyi dyiVar = null;
        Integer num11 = null;
        Integer num12 = null;
        ebi ebiVar = null;
        String str3 = null;
        Long l3 = null;
        String str4 = null;
        List list = null;
        int i = 0;
        boolean z = true;
        while (z) {
            dyi dyiVar2 = dyiVar;
            int iF = acmVarP.f(dfxVar);
            switch (iF) {
                case -1:
                    num2 = num7;
                    num3 = num11;
                    l = l3;
                    num4 = num8;
                    z = false;
                    num8 = num4;
                    dyiVar = dyiVar2;
                    num11 = num3;
                    l3 = l;
                    num7 = num2;
                    break;
                case 0:
                    num2 = num7;
                    num3 = num11;
                    Long l4 = l3;
                    num4 = num8;
                    l = (Long) acmVarP.i(dfxVar, 0, bya.b, l4);
                    i |= 1;
                    num8 = num4;
                    dyiVar = dyiVar2;
                    num11 = num3;
                    l3 = l;
                    num7 = num2;
                    break;
                case 1:
                    num2 = num7;
                    num5 = num11;
                    str4 = (String) acmVarP.i(dfxVar, 1, dnh.b, str4);
                    i |= 2;
                    list = list;
                    dyiVar = dyiVar2;
                    num11 = num5;
                    num7 = num2;
                    break;
                case 2:
                    num2 = num7;
                    num5 = num11;
                    list = (List) acmVarP.i(dfxVar, 2, (btd) bttVarArr[2].getValue(), list);
                    i |= 4;
                    dyiVar = dyiVar2;
                    num11 = num5;
                    num7 = num2;
                    break;
                case 3:
                    num2 = num7;
                    num5 = num11;
                    dyiVar = (dyi) acmVarP.i(dfxVar, 3, dyg.b, dyiVar2);
                    i |= 8;
                    num11 = num5;
                    num7 = num2;
                    break;
                case 4:
                    num2 = num7;
                    num11 = (Integer) acmVarP.i(dfxVar, 4, bqj.b, num11);
                    i |= 16;
                    dyiVar = dyiVar2;
                    num7 = num2;
                    break;
                case 5:
                    num = num11;
                    num12 = (Integer) acmVarP.i(dfxVar, 5, bqj.b, num12);
                    i |= 32;
                    dyiVar = dyiVar2;
                    num11 = num;
                    break;
                case 6:
                    num = num11;
                    ebiVar = (ebi) acmVarP.i(dfxVar, 6, ebg.b, ebiVar);
                    i |= 64;
                    dyiVar = dyiVar2;
                    num11 = num;
                    break;
                case 7:
                    num = num11;
                    str3 = (String) acmVarP.i(dfxVar, 7, dnh.b, str3);
                    i |= 128;
                    dyiVar = dyiVar2;
                    num11 = num;
                    break;
                case 8:
                    num = num11;
                    num6 = (Integer) acmVarP.i(dfxVar, 8, bqj.b, num6);
                    i |= 256;
                    dyiVar = dyiVar2;
                    num11 = num;
                    break;
                case 9:
                    num = num11;
                    num9 = (Integer) acmVarP.i(dfxVar, 9, bqj.b, num9);
                    i |= 512;
                    dyiVar = dyiVar2;
                    num11 = num;
                    break;
                case 10:
                    num = num11;
                    str = (String) acmVarP.i(dfxVar, 10, dnh.b, str);
                    i |= 1024;
                    dyiVar = dyiVar2;
                    num11 = num;
                    break;
                case 11:
                    num = num11;
                    l2 = (Long) acmVarP.i(dfxVar, 11, bya.b, l2);
                    i |= 2048;
                    dyiVar = dyiVar2;
                    num11 = num;
                    break;
                case 12:
                    num = num11;
                    num8 = (Integer) acmVarP.i(dfxVar, 12, bqj.b, num8);
                    i |= 4096;
                    dyiVar = dyiVar2;
                    num11 = num;
                    break;
                case 13:
                    num = num11;
                    num7 = (Integer) acmVarP.i(dfxVar, 13, bqj.b, num7);
                    i |= 8192;
                    dyiVar = dyiVar2;
                    num11 = num;
                    break;
                case 14:
                    num = num11;
                    num10 = (Integer) acmVarP.i(dfxVar, 14, bqj.b, num10);
                    i |= 16384;
                    dyiVar = dyiVar2;
                    num11 = num;
                    break;
                case 15:
                    num = num11;
                    str2 = (String) acmVarP.i(dfxVar, 15, dnh.b, str2);
                    i |= 32768;
                    dyiVar = dyiVar2;
                    num11 = num;
                    break;
                default:
                    throw new bsd(iF);
            }
        }
        Integer num13 = num7;
        Integer num14 = num11;
        Long l5 = l3;
        String str5 = str4;
        List list2 = list;
        acmVarP._bp(dfxVar);
        return new eah(i, l5, str5, list2, dyiVar, num14, num12, ebiVar, str3, num6, num9, str, l2, num8, num13, num10, str2);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        eah eahVar = (eah) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        btt[] bttVarArr = eah.a;
        bya byaVar = bya.b;
        acnVarO.m(dfxVar, 0, byaVar, eahVar.b);
        dnh dnhVar = dnh.b;
        acnVarO.m(dfxVar, 1, dnhVar, eahVar.c);
        acnVarO.m(dfxVar, 2, (btd) bttVarArr[2].getValue(), eahVar.d);
        acnVarO.m(dfxVar, 3, dyg.b, eahVar.e);
        bqj bqjVar = bqj.b;
        acnVarO.m(dfxVar, 4, bqjVar, eahVar.f);
        acnVarO.m(dfxVar, 5, bqjVar, eahVar.g);
        acnVarO.m(dfxVar, 6, ebg.b, eahVar.h);
        acnVarO.m(dfxVar, 7, dnhVar, eahVar.i);
        acnVarO.m(dfxVar, 8, bqjVar, eahVar.j);
        acnVarO.m(dfxVar, 9, bqjVar, eahVar.k);
        acnVarO.m(dfxVar, 10, dnhVar, eahVar.l);
        acnVarO.m(dfxVar, 11, byaVar, eahVar.m);
        acnVarO.m(dfxVar, 12, bqjVar, eahVar.n);
        acnVarO.m(dfxVar, 13, bqjVar, eahVar.o);
        acnVarO.m(dfxVar, 14, bqjVar, eahVar.p);
        acnVarO.m(dfxVar, 15, dnhVar, eahVar.q);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        btt[] bttVarArr = eah.a;
        bya byaVar = bya.b;
        btd btdVarT = aye.t(byaVar);
        dnh dnhVar = dnh.b;
        btd btdVarT2 = aye.t(dnhVar);
        btd btdVarT3 = aye.t((btd) bttVarArr[2].getValue());
        btd btdVarT4 = aye.t(dyg.b);
        bqj bqjVar = bqj.b;
        return new btd[]{btdVarT, btdVarT2, btdVarT3, btdVarT4, aye.t(bqjVar), aye.t(bqjVar), aye.t(ebg.b), aye.t(dnhVar), aye.t(bqjVar), aye.t(bqjVar), aye.t(dnhVar), aye.t(byaVar), aye.t(bqjVar), aye.t(bqjVar), aye.t(bqjVar), aye.t(dnhVar)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
