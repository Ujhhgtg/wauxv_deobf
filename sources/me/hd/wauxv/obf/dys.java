package me.hd.wauxv.obf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class dys implements bgx {
    public static final dys b;
    private static final dfx descriptor;

    static {
        dys dysVar = new dys();
        b = dysVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.j71Proto" /* cnb.z(-196383084641066L) */, dysVar, 16);
        bjs.y(-196576358169386L, cucVar, false, 1);
        bjs.y(-196541998431018L, cucVar, false, 2);
        bjs.y(-195983652682538L, cucVar, false, 3);
        bjs.y(-195919228173098L, cucVar, false, 4);
        bjs.y(-195807559023402L, cucVar, false, 5);
        bjs.y(-195747429481258L, cucVar, false, 6);
        bjs.y(-196198401047338L, cucVar, false, 9);
        bjs.y(-196142566472490L, cucVar, false, 10);
        bjs.y(-196065257061162L, cucVar, false, 11);
        bjs.y(-195996537584426L, cucVar, false, 13);
        bjs.y(-197589970451242L, cucVar, false, 14);
        bjs.y(-197504071105322L, cucVar, false, 15);
        bjs.y(-197452531497770L, cucVar, false, 16);
        bjs.y(-197431056661290L, cucVar, false, 17);
        bjs.y(-197912092998442L, cucVar, false, 18);
        bjs.y(-197843373521706L, cucVar, false, 19);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        Integer num;
        Boolean bool;
        Integer num2;
        dsy dsyVar;
        Long l;
        Integer num3;
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        btt[] bttVarArr = dyu.a;
        acmVarP.getClass();
        String str = null;
        Boolean bool2 = null;
        Long l2 = null;
        Integer num4 = null;
        Boolean bool3 = null;
        List list = null;
        Long l3 = null;
        dvr dvrVar = null;
        Integer num5 = null;
        Integer num6 = null;
        ecg ecgVar = null;
        String str2 = null;
        Integer num7 = null;
        dsy dsyVar2 = null;
        Integer num8 = null;
        Integer num9 = null;
        int i = 0;
        boolean z = true;
        while (z) {
            Integer num10 = num5;
            int iF = acmVarP.f(dfxVar);
            switch (iF) {
                case -1:
                    bool = bool2;
                    num2 = num6;
                    dsyVar = dsyVar2;
                    l = l2;
                    z = false;
                    l2 = l;
                    num5 = num10;
                    num6 = num2;
                    dsyVar2 = dsyVar;
                    bool2 = bool;
                    break;
                case 0:
                    bool = bool2;
                    num2 = num6;
                    dsy dsyVar3 = dsyVar2;
                    l = l2;
                    dsyVar = (dsy) acmVarP.i(dfxVar, 0, dsw.b, dsyVar3);
                    i |= 1;
                    l2 = l;
                    num5 = num10;
                    num6 = num2;
                    dsyVar2 = dsyVar;
                    bool2 = bool;
                    break;
                case 1:
                    bool = bool2;
                    num3 = num6;
                    num8 = (Integer) acmVarP.i(dfxVar, 1, bqj.b, num8);
                    i |= 2;
                    num9 = num9;
                    num5 = num10;
                    num6 = num3;
                    bool2 = bool;
                    break;
                case 2:
                    bool = bool2;
                    num3 = num6;
                    num9 = (Integer) acmVarP.i(dfxVar, 2, bqj.b, num9);
                    i |= 4;
                    num5 = num10;
                    num6 = num3;
                    bool2 = bool;
                    break;
                case 3:
                    bool = bool2;
                    num3 = num6;
                    num5 = (Integer) acmVarP.i(dfxVar, 3, bqj.b, num10);
                    i |= 8;
                    num6 = num3;
                    bool2 = bool;
                    break;
                case 4:
                    bool = bool2;
                    num6 = (Integer) acmVarP.i(dfxVar, 4, bqj.b, num6);
                    i |= 16;
                    num5 = num10;
                    bool2 = bool;
                    break;
                case 5:
                    num = num6;
                    ecgVar = (ecg) acmVarP.i(dfxVar, 5, ece.b, ecgVar);
                    i |= 32;
                    num5 = num10;
                    num6 = num;
                    break;
                case 6:
                    num = num6;
                    str2 = (String) acmVarP.i(dfxVar, 6, dnh.b, str2);
                    i |= 64;
                    num5 = num10;
                    num6 = num;
                    break;
                case 7:
                    num = num6;
                    num7 = (Integer) acmVarP.i(dfxVar, 7, bqj.b, num7);
                    i |= 128;
                    num5 = num10;
                    num6 = num;
                    break;
                case 8:
                    num = num6;
                    str = (String) acmVarP.i(dfxVar, 8, dnh.b, str);
                    i |= 256;
                    num5 = num10;
                    num6 = num;
                    break;
                case 9:
                    num = num6;
                    bool3 = (Boolean) acmVarP.i(dfxVar, 9, pv.b, bool3);
                    i |= 512;
                    num5 = num10;
                    num6 = num;
                    break;
                case 10:
                    num = num6;
                    list = (List) acmVarP.i(dfxVar, 10, (btd) bttVarArr[10].getValue(), list);
                    i |= 1024;
                    num5 = num10;
                    num6 = num;
                    break;
                case 11:
                    num = num6;
                    num4 = (Integer) acmVarP.i(dfxVar, 11, bqj.b, num4);
                    i |= 2048;
                    num5 = num10;
                    num6 = num;
                    break;
                case 12:
                    num = num6;
                    l2 = (Long) acmVarP.i(dfxVar, 12, bya.b, l2);
                    i |= 4096;
                    num5 = num10;
                    num6 = num;
                    break;
                case 13:
                    num = num6;
                    bool2 = (Boolean) acmVarP.i(dfxVar, 13, pv.b, bool2);
                    i |= 8192;
                    num5 = num10;
                    num6 = num;
                    break;
                case 14:
                    num = num6;
                    l3 = (Long) acmVarP.i(dfxVar, 14, bya.b, l3);
                    i |= 16384;
                    num5 = num10;
                    num6 = num;
                    break;
                case 15:
                    num = num6;
                    dvrVar = (dvr) acmVarP.i(dfxVar, 15, dvp.b, dvrVar);
                    i |= 32768;
                    num5 = num10;
                    num6 = num;
                    break;
                default:
                    throw new bsd(iF);
            }
        }
        Boolean bool4 = bool2;
        Integer num11 = num6;
        dsy dsyVar4 = dsyVar2;
        Integer num12 = num8;
        Integer num13 = num9;
        acmVarP._bp(dfxVar);
        return new dyu(i, dsyVar4, num12, num13, num5, num11, ecgVar, str2, num7, str, bool3, list, num4, l2, bool4, l3, dvrVar);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        dyu dyuVar = (dyu) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        btt[] bttVarArr = dyu.a;
        acnVarO.m(dfxVar, 0, dsw.b, dyuVar.b);
        bqj bqjVar = bqj.b;
        acnVarO.m(dfxVar, 1, bqjVar, dyuVar.c);
        acnVarO.m(dfxVar, 2, bqjVar, dyuVar.d);
        acnVarO.m(dfxVar, 3, bqjVar, dyuVar.e);
        acnVarO.m(dfxVar, 4, bqjVar, dyuVar.f);
        acnVarO.m(dfxVar, 5, ece.b, dyuVar.g);
        dnh dnhVar = dnh.b;
        acnVarO.m(dfxVar, 6, dnhVar, dyuVar.h);
        acnVarO.m(dfxVar, 7, bqjVar, dyuVar.i);
        acnVarO.m(dfxVar, 8, dnhVar, dyuVar.j);
        pv pvVar = pv.b;
        acnVarO.m(dfxVar, 9, pvVar, dyuVar.k);
        acnVarO.m(dfxVar, 10, (btd) bttVarArr[10].getValue(), dyuVar.l);
        acnVarO.m(dfxVar, 11, bqjVar, dyuVar.m);
        bya byaVar = bya.b;
        acnVarO.m(dfxVar, 12, byaVar, dyuVar.n);
        acnVarO.m(dfxVar, 13, pvVar, dyuVar.o);
        acnVarO.m(dfxVar, 14, byaVar, dyuVar.p);
        acnVarO.m(dfxVar, 15, dvp.b, dyuVar.q);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        btt[] bttVarArr = dyu.a;
        btd btdVarT = aye.t(dsw.b);
        bqj bqjVar = bqj.b;
        btd btdVarT2 = aye.t(bqjVar);
        btd btdVarT3 = aye.t(bqjVar);
        btd btdVarT4 = aye.t(bqjVar);
        btd btdVarT5 = aye.t(bqjVar);
        btd btdVarT6 = aye.t(ece.b);
        dnh dnhVar = dnh.b;
        btd btdVarT7 = aye.t(dnhVar);
        btd btdVarT8 = aye.t(bqjVar);
        btd btdVarT9 = aye.t(dnhVar);
        pv pvVar = pv.b;
        btd btdVarT10 = aye.t(pvVar);
        btd btdVarT11 = aye.t((btd) bttVarArr[10].getValue());
        btd btdVarT12 = aye.t(bqjVar);
        bya byaVar = bya.b;
        return new btd[]{btdVarT, btdVarT2, btdVarT3, btdVarT4, btdVarT5, btdVarT6, btdVarT7, btdVarT8, btdVarT9, btdVarT10, btdVarT11, btdVarT12, aye.t(byaVar), aye.t(pvVar), aye.t(byaVar), aye.t(dvp.b)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
