package me.hd.wauxv.obf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class dzn implements bgx {
    public static final dzn b;
    private static final dfx descriptor;

    static {
        dzn dznVar = new dzn();
        b = dznVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.ko1Proto" /*
                                                                                                               * cnb.z(-
                                                                                                               * 198930000247594L)
                                                                                                               */,
                dznVar, 11);
        bjs.y(-198040942017322L, cucVar, false, 1);
        bjs.y(-197993697377066L, cucVar, false, 2);
        bjs.y(-197972222540586L, cucVar, false, 3);
        bjs.y(-198448963910442L, cucVar, false, 4);
        bjs.y(-198393129335594L, cucVar, false, 5);
        bjs.y(-198324409858858L, cucVar, false, 6);
        bjs.y(-198225625611050L, cucVar, false, 7);
        bjs.y(-198221330643754L, cucVar, false, 8);
        bjs.y(-199776108804906L, cucVar, false, 9);
        bjs.y(-199750339001130L, cucVar, false, 10);
        bjs.y(-199711684295466L, cucVar, false, 11);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        IHasGetValue[] bttVarArr;
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        IHasGetValue[] bttVarArr2 = dzp.a;
        acmVarP.getClass();
        Long l = null;
        String str = null;
        String str2 = null;
        Integer num = null;
        String str3 = null;
        Boolean bool = null;
        Boolean bool2 = null;
        Boolean bool3 = null;
        Boolean bool4 = null;
        List list = null;
        Integer num2 = null;
        int i = 0;
        boolean z = true;
        while (z) {
            int iF = acmVarP.f(dfxVar);
            switch (iF) {
                case -1:
                    z = false;
                    continue;
                case 0:
                    bttVarArr = bttVarArr2;
                    num = (Integer) acmVarP.i(dfxVar, 0, bqj.b, num);
                    i |= 1;
                    break;
                case 1:
                    bttVarArr = bttVarArr2;
                    str3 = (String) acmVarP.i(dfxVar, 1, dnh.b, str3);
                    i |= 2;
                    break;
                case 2:
                    bttVarArr = bttVarArr2;
                    bool = (Boolean) acmVarP.i(dfxVar, 2, pv.b, bool);
                    i |= 4;
                    break;
                case 3:
                    bttVarArr = bttVarArr2;
                    bool2 = (Boolean) acmVarP.i(dfxVar, 3, pv.b, bool2);
                    i |= 8;
                    break;
                case 4:
                    bttVarArr = bttVarArr2;
                    bool3 = (Boolean) acmVarP.i(dfxVar, 4, pv.b, bool3);
                    i |= 16;
                    break;
                case 5:
                    bttVarArr = bttVarArr2;
                    bool4 = (Boolean) acmVarP.i(dfxVar, 5, pv.b, bool4);
                    i |= 32;
                    break;
                case 6:
                    bttVarArr = bttVarArr2;
                    list = (List) acmVarP.i(dfxVar, 6, (btd) bttVarArr[6].getValue(), list);
                    i |= 64;
                    break;
                case 7:
                    bttVarArr = bttVarArr2;
                    num2 = (Integer) acmVarP.i(dfxVar, 7, bqj.b, num2);
                    i |= 128;
                    break;
                case 8:
                    bttVarArr = bttVarArr2;
                    l = (Long) acmVarP.i(dfxVar, 8, bya.b, l);
                    i |= 256;
                    break;
                case 9:
                    bttVarArr = bttVarArr2;
                    str = (String) acmVarP.i(dfxVar, 9, dnh.b, str);
                    i |= 512;
                    break;
                case 10:
                    bttVarArr = bttVarArr2;
                    str2 = (String) acmVarP.i(dfxVar, 10, dnh.b, str2);
                    i |= 1024;
                    break;
                default:
                    throw new bsd(iF);
            }
            bttVarArr2 = bttVarArr;
        }
        acmVarP._bp(dfxVar);
        return new dzp(i, num, str3, bool, bool2, bool3, bool4, list, num2, l, str, str2);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        dzp dzpVar = (dzp) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        IHasGetValue[] bttVarArr = dzp.a;
        bqj bqjVar = bqj.b;
        acnVarO.m(dfxVar, 0, bqjVar, dzpVar.b);
        dnh dnhVar = dnh.b;
        acnVarO.m(dfxVar, 1, dnhVar, dzpVar.c);
        pv pvVar = pv.b;
        acnVarO.m(dfxVar, 2, pvVar, dzpVar.d);
        acnVarO.m(dfxVar, 3, pvVar, dzpVar.e);
        acnVarO.m(dfxVar, 4, pvVar, dzpVar.f);
        acnVarO.m(dfxVar, 5, pvVar, dzpVar.g);
        acnVarO.m(dfxVar, 6, (btd) bttVarArr[6].getValue(), dzpVar.h);
        acnVarO.m(dfxVar, 7, bqjVar, dzpVar.i);
        acnVarO.m(dfxVar, 8, bya.b, dzpVar.j);
        acnVarO.m(dfxVar, 9, dnhVar, dzpVar.k);
        acnVarO.m(dfxVar, 10, dnhVar, dzpVar.l);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        IHasGetValue[] bttVarArr = dzp.a;
        bqj bqjVar = bqj.b;
        btd btdVarT = aye.t(bqjVar);
        dnh dnhVar = dnh.b;
        btd btdVarT2 = aye.t(dnhVar);
        pv pvVar = pv.b;
        return new btd[] { btdVarT, btdVarT2, aye.t(pvVar), aye.t(pvVar), aye.t(pvVar), aye.t(pvVar),
                aye.t((btd) bttVarArr[6].getValue()), aye.t(bqjVar), aye.t(bya.b), aye.t(dnhVar), aye.t(dnhVar) };
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
