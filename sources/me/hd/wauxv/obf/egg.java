package me.hd.wauxv.obf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class egg implements bgx {
    public static final egg b;
    private static final dfx descriptor;

    static {
        egg eggVar = new egg();
        b = eggVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.v51Proto" /*
                                                                                                               * cnb.z(-
                                                                                                               * 315521182464810L)
                                                                                                               */,
                eggVar, 14);
        bjs.y(-314632124234538L, cucVar, false, 1);
        bjs.y(-314537634954026L, cucVar, false, 2);
        bjs.y(-314507570182954L, cucVar, false, 3);
        bjs.y(-314477505411882L, cucVar, false, 4);
        bjs.y(-315001491421994L, cucVar, false, 6);
        bjs.y(-314915592076074L, cucVar, false, 7);
        bjs.y(-314937066912554L, cucVar, false, 8);
        bjs.y(-314846872599338L, cucVar, false, 9);
        bjs.y(-314829692730154L, cucVar, false, 10);
        bjs.y(-314743793384234L, cucVar, false, 11);
        bjs.y(-316371585989418L, cucVar, false, 12);
        bjs.y(-316307161479978L, cucVar, false, 14);
        bjs.y(-316277096708906L, cucVar, false, 15);
        bjs.y(-316204082264874L, cucVar, false, 16);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        Integer num;
        Boolean bool;
        Integer num2;
        Long l;
        Integer num3;
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        IHasGetValue[] bttVarArr = egi.a;
        acmVarP.getClass();
        Integer num4 = null;
        Boolean bool2 = null;
        Integer num5 = null;
        eft eftVar = null;
        List list = null;
        Integer num6 = null;
        Long l2 = null;
        Integer num7 = null;
        Integer num8 = null;
        List list2 = null;
        Integer num9 = null;
        Long l3 = null;
        Integer num10 = null;
        String str = null;
        int i = 0;
        boolean z = true;
        while (z) {
            Long l4 = l2;
            int iF = acmVarP.f(dfxVar);
            switch (iF) {
                case -1:
                    bool = bool2;
                    num2 = num7;
                    l = l4;
                    num3 = num5;
                    z = false;
                    l2 = l;
                    num5 = num3;
                    num7 = num2;
                    bool2 = bool;
                    break;
                case 0:
                    bool = bool2;
                    num2 = num7;
                    l = l4;
                    num3 = num5;
                    str = (String) acmVarP.i(dfxVar, 0, dnh.b, str);
                    i |= 1;
                    l2 = l;
                    num5 = num3;
                    num7 = num2;
                    bool2 = bool;
                    break;
                case 1:
                    bool = bool2;
                    num2 = num7;
                    l2 = (Long) acmVarP.i(dfxVar, 1, bya.b, l4);
                    i |= 2;
                    num7 = num2;
                    bool2 = bool;
                    break;
                case 2:
                    bool = bool2;
                    num7 = (Integer) acmVarP.i(dfxVar, 2, bqj.b, num7);
                    i |= 4;
                    l2 = l4;
                    bool2 = bool;
                    break;
                case 3:
                    num = num7;
                    num8 = (Integer) acmVarP.i(dfxVar, 3, bqj.b, num8);
                    i |= 8;
                    l2 = l4;
                    num7 = num;
                    break;
                case 4:
                    num = num7;
                    list2 = (List) acmVarP.i(dfxVar, 4, (btd) bttVarArr[4].getValue(), list2);
                    i |= 16;
                    l2 = l4;
                    num7 = num;
                    break;
                case 5:
                    num = num7;
                    num9 = (Integer) acmVarP.i(dfxVar, 5, bqj.b, num9);
                    i |= 32;
                    l2 = l4;
                    num7 = num;
                    break;
                case 6:
                    num = num7;
                    l3 = (Long) acmVarP.i(dfxVar, 6, bya.b, l3);
                    i |= 64;
                    l2 = l4;
                    num7 = num;
                    break;
                case 7:
                    num = num7;
                    num10 = (Integer) acmVarP.i(dfxVar, 7, bqj.b, num10);
                    i |= 128;
                    l2 = l4;
                    num7 = num;
                    break;
                case 8:
                    num = num7;
                    num4 = (Integer) acmVarP.i(dfxVar, 8, bqj.b, num4);
                    i |= 256;
                    l2 = l4;
                    num7 = num;
                    break;
                case 9:
                    num = num7;
                    list = (List) acmVarP.i(dfxVar, 9, (btd) bttVarArr[9].getValue(), list);
                    i |= 512;
                    l2 = l4;
                    num7 = num;
                    break;
                case 10:
                    num = num7;
                    num6 = (Integer) acmVarP.i(dfxVar, 10, bqj.b, num6);
                    i |= 1024;
                    l2 = l4;
                    num7 = num;
                    break;
                case 11:
                    num = num7;
                    eftVar = (eft) acmVarP.i(dfxVar, 11, efr.b, eftVar);
                    i |= 2048;
                    l2 = l4;
                    num7 = num;
                    break;
                case 12:
                    num = num7;
                    num5 = (Integer) acmVarP.i(dfxVar, 12, bqj.b, num5);
                    i |= 4096;
                    l2 = l4;
                    num7 = num;
                    break;
                case 13:
                    num = num7;
                    bool2 = (Boolean) acmVarP.i(dfxVar, 13, pv.b, bool2);
                    i |= 8192;
                    l2 = l4;
                    num7 = num;
                    break;
                default:
                    throw new bsd(iF);
            }
        }
        Boolean bool3 = bool2;
        Integer num11 = num7;
        String str2 = str;
        acmVarP._bp(dfxVar);
        return new egi(i, str2, l2, num11, num8, list2, num9, l3, num10, num4, list, num6, eftVar, num5, bool3);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        egi egiVar = (egi) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        IHasGetValue[] bttVarArr = egi.a;
        acnVarO.m(dfxVar, 0, dnh.b, egiVar.b);
        bya byaVar = bya.b;
        acnVarO.m(dfxVar, 1, byaVar, egiVar.c);
        bqj bqjVar = bqj.b;
        acnVarO.m(dfxVar, 2, bqjVar, egiVar.d);
        acnVarO.m(dfxVar, 3, bqjVar, egiVar.e);
        acnVarO.m(dfxVar, 4, (btd) bttVarArr[4].getValue(), egiVar.f);
        acnVarO.m(dfxVar, 5, bqjVar, egiVar.g);
        acnVarO.m(dfxVar, 6, byaVar, egiVar.h);
        acnVarO.m(dfxVar, 7, bqjVar, egiVar.i);
        acnVarO.m(dfxVar, 8, bqjVar, egiVar.j);
        acnVarO.m(dfxVar, 9, (btd) bttVarArr[9].getValue(), egiVar.k);
        acnVarO.m(dfxVar, 10, bqjVar, egiVar.l);
        acnVarO.m(dfxVar, 11, efr.b, egiVar.m);
        acnVarO.m(dfxVar, 12, bqjVar, egiVar.n);
        acnVarO.m(dfxVar, 13, pv.b, egiVar.o);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        IHasGetValue[] bttVarArr = egi.a;
        btd btdVarT = aye.t(dnh.b);
        bya byaVar = bya.b;
        btd btdVarT2 = aye.t(byaVar);
        bqj bqjVar = bqj.b;
        return new btd[] { btdVarT, btdVarT2, aye.t(bqjVar), aye.t(bqjVar), aye.t((btd) bttVarArr[4].getValue()),
                aye.t(bqjVar), aye.t(byaVar), aye.t(bqjVar), aye.t(bqjVar), aye.t((btd) bttVarArr[9].getValue()),
                aye.t(bqjVar), aye.t(efr.b), aye.t(bqjVar), aye.t(pv.b) };
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
