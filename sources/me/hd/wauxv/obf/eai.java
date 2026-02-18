package me.hd.wauxv.obf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class eai implements bgx {
    public static final eai b;
    private static final dfx descriptor;

    static {
        eai eaiVar = new eai();
        b = eaiVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.m40Proto" /*
                                                                                                               * cnb.z(-
                                                                                                               * 225764955913002L)
                                                                                                               */,
                eaiVar, 12);
        bjs.y(-213880781404970L, cucVar, false, 1);
        bjs.y(-214400472447786L, cucVar, false, 2);
        bjs.y(-214310278134570L, cucVar, false, 3);
        bjs.y(-214297393232682L, cucVar, false, 4);
        bjs.y(-214147069377322L, cucVar, false, 5);
        bjs.y(-213558658857770L, cucVar, false, 6);
        bjs.y(-213528594086698L, cucVar, false, 7);
        bjs.y(-213477054479146L, cucVar, false, 8);
        bjs.y(-213309550754602L, cucVar, false, 9);
        bjs.y(-213850716633898L, cucVar, false, 10);
        bjs.y(-213781997157162L, cucVar, false, 11);
        bjs.y(-213683212909354L, cucVar, false, 12);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        Long l;
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        IHasGetValue[] bttVarArr = eak.a;
        acmVarP.getClass();
        Integer num = null;
        String str = null;
        Integer num2 = null;
        Integer num3 = null;
        Long l2 = null;
        Long l3 = null;
        Integer num4 = null;
        Integer num5 = null;
        List list = null;
        List list2 = null;
        Boolean bool = null;
        Boolean bool2 = null;
        int i = 0;
        boolean z = true;
        while (z) {
            IHasGetValue[] bttVarArr2 = bttVarArr;
            int iF = acmVarP.f(dfxVar);
            switch (iF) {
                case -1:
                    z = false;
                    bttVarArr = bttVarArr2;
                    i = i;
                    continue;
                case 0:
                    l2 = (Long) acmVarP.i(dfxVar, 0, bya.b, l2);
                    i |= 1;
                    bttVarArr = bttVarArr2;
                    continue;
                case 1:
                    l = l2;
                    l3 = (Long) acmVarP.i(dfxVar, 1, bya.b, l3);
                    i |= 2;
                    break;
                case 2:
                    l = l2;
                    num4 = (Integer) acmVarP.i(dfxVar, 2, bqj.b, num4);
                    i |= 4;
                    break;
                case 3:
                    l = l2;
                    num5 = (Integer) acmVarP.i(dfxVar, 3, bqj.b, num5);
                    i |= 8;
                    break;
                case 4:
                    l = l2;
                    list = (List) acmVarP.i(dfxVar, 4, (btd) bttVarArr2[4].getValue(), list);
                    i |= 16;
                    break;
                case 5:
                    l = l2;
                    list2 = (List) acmVarP.i(dfxVar, 5, (btd) bttVarArr2[5].getValue(), list2);
                    i |= 32;
                    break;
                case 6:
                    l = l2;
                    bool = (Boolean) acmVarP.i(dfxVar, 6, pv.b, bool);
                    i |= 64;
                    break;
                case 7:
                    l = l2;
                    bool2 = (Boolean) acmVarP.i(dfxVar, 7, pv.b, bool2);
                    i |= 128;
                    break;
                case 8:
                    l = l2;
                    num = (Integer) acmVarP.i(dfxVar, 8, bqj.b, num);
                    i |= 256;
                    break;
                case 9:
                    l = l2;
                    num2 = (Integer) acmVarP.i(dfxVar, 9, bqj.b, num2);
                    i |= 512;
                    break;
                case 10:
                    l = l2;
                    num3 = (Integer) acmVarP.i(dfxVar, 10, bqj.b, num3);
                    i |= 1024;
                    break;
                case 11:
                    l = l2;
                    str = (String) acmVarP.i(dfxVar, 11, dnh.b, str);
                    i |= 2048;
                    break;
                default:
                    throw new bsd(iF);
            }
            bttVarArr = bttVarArr2;
            l2 = l;
        }
        acmVarP._bp(dfxVar);
        return new eak(i, l2, l3, num4, num5, list, list2, bool, bool2, num, num2, num3, str);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        eak eakVar = (eak) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        IHasGetValue[] bttVarArr = eak.a;
        bya byaVar = bya.b;
        acnVarO.m(dfxVar, 0, byaVar, eakVar.b);
        acnVarO.m(dfxVar, 1, byaVar, eakVar.c);
        bqj bqjVar = bqj.b;
        acnVarO.m(dfxVar, 2, bqjVar, eakVar.d);
        acnVarO.m(dfxVar, 3, bqjVar, eakVar.e);
        acnVarO.m(dfxVar, 4, (btd) bttVarArr[4].getValue(), eakVar.f);
        acnVarO.m(dfxVar, 5, (btd) bttVarArr[5].getValue(), eakVar.g);
        pv pvVar = pv.b;
        acnVarO.m(dfxVar, 6, pvVar, eakVar.h);
        acnVarO.m(dfxVar, 7, pvVar, eakVar.i);
        acnVarO.m(dfxVar, 8, bqjVar, eakVar.j);
        acnVarO.m(dfxVar, 9, bqjVar, eakVar.k);
        acnVarO.m(dfxVar, 10, bqjVar, eakVar.l);
        acnVarO.m(dfxVar, 11, dnh.b, eakVar.m);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        IHasGetValue[] bttVarArr = eak.a;
        bya byaVar = bya.b;
        btd btdVarT = aye.t(byaVar);
        btd btdVarT2 = aye.t(byaVar);
        bqj bqjVar = bqj.b;
        btd btdVarT3 = aye.t(bqjVar);
        btd btdVarT4 = aye.t(bqjVar);
        btd btdVarT5 = aye.t((btd) bttVarArr[4].getValue());
        btd btdVarT6 = aye.t((btd) bttVarArr[5].getValue());
        pv pvVar = pv.b;
        return new btd[] { btdVarT, btdVarT2, btdVarT3, btdVarT4, btdVarT5, btdVarT6, aye.t(pvVar), aye.t(pvVar),
                aye.t(bqjVar), aye.t(bqjVar), aye.t(bqjVar), aye.t(dnh.b) };
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
