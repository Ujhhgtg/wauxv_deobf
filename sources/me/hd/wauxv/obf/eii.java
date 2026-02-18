package me.hd.wauxv.obf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class eii implements bgx {
    public static final eii b;
    private static final dfx descriptor;

    static {
        eii eiiVar = new eii();
        b = eiiVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.x93Proto" /*
                                                                                                               * cnb.z(-
                                                                                                               * 330343114603306L)
                                                                                                               */,
                eiiVar, 13);
        bjs.y(-331704619236138L, cucVar, false, 1);
        bjs.y(-331635899759402L, cucVar, false, 2);
        bjs.y(-331558590348074L, cucVar, false, 3);
        bjs.y(-331532820544298L, cucVar, false, 4);
        bjs.y(-332009561914154L, cucVar, false, 5);
        bjs.y(-331932252502826L, cucVar, false, 6);
        bjs.y(-331897892764458L, cucVar, false, 7);
        bjs.y(-331846353156906L, cucVar, false, 8);
        bjs.y(-331214992964394L, cucVar, false, 9);
        bjs.y(-331184928193322L, cucVar, false, 10);
        bjs.y(-331077554010922L, cucVar, false, 11);
        bjs.y(-330970179828522L, cucVar, false, 12);
        bjs.y(-331416856427306L, cucVar, false, 13);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        Integer num;
        List list;
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        IHasGetValue[] bttVarArr = eik.a;
        acmVarP.getClass();
        Boolean bool = null;
        List list2 = null;
        List list3 = null;
        List list4 = null;
        String str = null;
        Integer num2 = null;
        Integer num3 = null;
        List list5 = null;
        String str2 = null;
        Integer num4 = null;
        String str3 = null;
        String str4 = null;
        List list6 = null;
        int i = 0;
        boolean z = true;
        while (z) {
            Integer num5 = num2;
            int iF = acmVarP.f(dfxVar);
            switch (iF) {
                case -1:
                    list = list2;
                    num2 = num5;
                    z = false;
                    i = i;
                    list2 = list;
                    break;
                case 0:
                    list = list2;
                    num2 = (Integer) acmVarP.i(dfxVar, 0, bqj.b, num5);
                    i |= 1;
                    list2 = list;
                    break;
                case 1:
                    num3 = (Integer) acmVarP.i(dfxVar, 1, bqj.b, num3);
                    i |= 2;
                    num2 = num5;
                    break;
                case 2:
                    num = num3;
                    list5 = (List) acmVarP.i(dfxVar, 2, (btd) bttVarArr[2].getValue(), list5);
                    i |= 4;
                    num2 = num5;
                    num3 = num;
                    break;
                case 3:
                    num = num3;
                    str2 = (String) acmVarP.i(dfxVar, 3, dnh.b, str2);
                    i |= 8;
                    num2 = num5;
                    num3 = num;
                    break;
                case 4:
                    num = num3;
                    num4 = (Integer) acmVarP.i(dfxVar, 4, bqj.b, num4);
                    i |= 16;
                    num2 = num5;
                    num3 = num;
                    break;
                case 5:
                    num = num3;
                    str3 = (String) acmVarP.i(dfxVar, 5, dnh.b, str3);
                    i |= 32;
                    num2 = num5;
                    num3 = num;
                    break;
                case 6:
                    num = num3;
                    str4 = (String) acmVarP.i(dfxVar, 6, dnh.b, str4);
                    i |= 64;
                    num2 = num5;
                    num3 = num;
                    break;
                case 7:
                    num = num3;
                    list6 = (List) acmVarP.i(dfxVar, 7, (btd) bttVarArr[7].getValue(), list6);
                    i |= 128;
                    num2 = num5;
                    num3 = num;
                    break;
                case 8:
                    num = num3;
                    bool = (Boolean) acmVarP.i(dfxVar, 8, pv.b, bool);
                    i |= 256;
                    num2 = num5;
                    num3 = num;
                    break;
                case 9:
                    num = num3;
                    list4 = (List) acmVarP.i(dfxVar, 9, (btd) bttVarArr[9].getValue(), list4);
                    i |= 512;
                    num2 = num5;
                    num3 = num;
                    break;
                case 10:
                    num = num3;
                    str = (String) acmVarP.i(dfxVar, 10, dnh.b, str);
                    i |= 1024;
                    num2 = num5;
                    num3 = num;
                    break;
                case 11:
                    num = num3;
                    list3 = (List) acmVarP.i(dfxVar, 11, (btd) bttVarArr[11].getValue(), list3);
                    i |= 2048;
                    num2 = num5;
                    num3 = num;
                    break;
                case 12:
                    num = num3;
                    list2 = (List) acmVarP.i(dfxVar, 12, (btd) bttVarArr[12].getValue(), list2);
                    i |= 4096;
                    num2 = num5;
                    num3 = num;
                    break;
                default:
                    throw new bsd(iF);
            }
        }
        acmVarP._bp(dfxVar);
        return new eik(i, num2, num3, list5, str2, num4, str3, str4, list6, bool, list4, str, list3, list2);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        eik eikVar = (eik) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        IHasGetValue[] bttVarArr = eik.a;
        bqj bqjVar = bqj.b;
        acnVarO.m(dfxVar, 0, bqjVar, eikVar.b);
        acnVarO.m(dfxVar, 1, bqjVar, eikVar.c);
        acnVarO.m(dfxVar, 2, (btd) bttVarArr[2].getValue(), eikVar.d);
        dnh dnhVar = dnh.b;
        acnVarO.m(dfxVar, 3, dnhVar, eikVar.e);
        acnVarO.m(dfxVar, 4, bqjVar, eikVar.f);
        acnVarO.m(dfxVar, 5, dnhVar, eikVar.g);
        acnVarO.m(dfxVar, 6, dnhVar, eikVar.h);
        acnVarO.m(dfxVar, 7, (btd) bttVarArr[7].getValue(), eikVar.i);
        acnVarO.m(dfxVar, 8, pv.b, eikVar.j);
        acnVarO.m(dfxVar, 9, (btd) bttVarArr[9].getValue(), eikVar.k);
        acnVarO.m(dfxVar, 10, dnhVar, eikVar.l);
        acnVarO.m(dfxVar, 11, (btd) bttVarArr[11].getValue(), eikVar.m);
        acnVarO.m(dfxVar, 12, (btd) bttVarArr[12].getValue(), eikVar.n);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        IHasGetValue[] bttVarArr = eik.a;
        bqj bqjVar = bqj.b;
        btd btdVarT = aye.t(bqjVar);
        btd btdVarT2 = aye.t(bqjVar);
        btd btdVarT3 = aye.t((btd) bttVarArr[2].getValue());
        dnh dnhVar = dnh.b;
        return new btd[] { btdVarT, btdVarT2, btdVarT3, aye.t(dnhVar), aye.t(bqjVar), aye.t(dnhVar), aye.t(dnhVar),
                aye.t((btd) bttVarArr[7].getValue()), aye.t(pv.b), aye.t((btd) bttVarArr[9].getValue()), aye.t(dnhVar),
                aye.t((btd) bttVarArr[11].getValue()), aye.t((btd) bttVarArr[12].getValue()) };
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
