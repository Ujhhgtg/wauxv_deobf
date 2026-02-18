package me.hd.wauxv.obf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class dwe implements bgx {
    public static final dwe b;
    private static final dfx descriptor;

    static {
        dwe dweVar = new dwe();
        b = dweVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.cp1Proto" /*
                                                                                                               * cnb.z(-
                                                                                                               * 161078453467946L)
                                                                                                               */,
                dweVar, 10);
        bjs.y(-162371238624042L, cucVar, false, 1);
        bjs.y(-162289634245418L, cucVar, false, 2);
        bjs.y(-162281044310826L, cucVar, false, 3);
        bjs.y(-162701951105834L, cucVar, false, 4);
        bjs.y(-162676181302058L, cucVar, false, 5);
        bjs.y(-162646116530986L, cucVar, false, 6);
        bjs.y(-162560217185066L, cucVar, false, 7);
        bjs.y(-162487202741034L, cucVar, false, 8);
        bjs.y(-161847252613930L, cucVar, false, 9);
        bjs.y(-161778533137194L, cucVar, false, 10);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        IHasGetValue[] bttVarArr;
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        IHasGetValue[] bttVarArr2 = dwg.a;
        acmVarP.getClass();
        Integer num = null;
        List list = null;
        String str = null;
        Long l = null;
        Long l2 = null;
        String str2 = null;
        String str3 = null;
        Long l3 = null;
        Boolean bool = null;
        Boolean bool2 = null;
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
                    str = (String) acmVarP.i(dfxVar, 0, dnh.b, str);
                    i |= 1;
                    break;
                case 1:
                    bttVarArr = bttVarArr2;
                    l = (Long) acmVarP.i(dfxVar, 1, bya.b, l);
                    i |= 2;
                    break;
                case 2:
                    bttVarArr = bttVarArr2;
                    l2 = (Long) acmVarP.i(dfxVar, 2, bya.b, l2);
                    i |= 4;
                    break;
                case 3:
                    bttVarArr = bttVarArr2;
                    str2 = (String) acmVarP.i(dfxVar, 3, dnh.b, str2);
                    i |= 8;
                    break;
                case 4:
                    bttVarArr = bttVarArr2;
                    str3 = (String) acmVarP.i(dfxVar, 4, dnh.b, str3);
                    i |= 16;
                    break;
                case 5:
                    bttVarArr = bttVarArr2;
                    l3 = (Long) acmVarP.i(dfxVar, 5, bya.b, l3);
                    i |= 32;
                    break;
                case 6:
                    bttVarArr = bttVarArr2;
                    bool = (Boolean) acmVarP.i(dfxVar, 6, pv.b, bool);
                    i |= 64;
                    break;
                case 7:
                    bttVarArr = bttVarArr2;
                    bool2 = (Boolean) acmVarP.i(dfxVar, 7, pv.b, bool2);
                    i |= 128;
                    break;
                case 8:
                    bttVarArr = bttVarArr2;
                    num = (Integer) acmVarP.i(dfxVar, 8, bqj.b, num);
                    i |= 256;
                    break;
                case 9:
                    bttVarArr = bttVarArr2;
                    list = (List) acmVarP.i(dfxVar, 9, (btd) bttVarArr2[9].getValue(), list);
                    i |= 512;
                    break;
                default:
                    throw new bsd(iF);
            }
            bttVarArr2 = bttVarArr;
        }
        acmVarP._bp(dfxVar);
        return new dwg(i, str, l, l2, str2, str3, l3, bool, bool2, num, list);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        dwg dwgVar = (dwg) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        IHasGetValue[] bttVarArr = dwg.a;
        dnh dnhVar = dnh.b;
        acnVarO.m(dfxVar, 0, dnhVar, dwgVar.b);
        bya byaVar = bya.b;
        acnVarO.m(dfxVar, 1, byaVar, dwgVar.c);
        acnVarO.m(dfxVar, 2, byaVar, dwgVar.d);
        acnVarO.m(dfxVar, 3, dnhVar, dwgVar.e);
        acnVarO.m(dfxVar, 4, dnhVar, dwgVar.f);
        acnVarO.m(dfxVar, 5, byaVar, dwgVar.g);
        pv pvVar = pv.b;
        acnVarO.m(dfxVar, 6, pvVar, dwgVar.h);
        acnVarO.m(dfxVar, 7, pvVar, dwgVar.i);
        acnVarO.m(dfxVar, 8, bqj.b, dwgVar.j);
        acnVarO.m(dfxVar, 9, (btd) bttVarArr[9].getValue(), dwgVar.k);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        IHasGetValue[] bttVarArr = dwg.a;
        dnh dnhVar = dnh.b;
        btd btdVarT = aye.t(dnhVar);
        bya byaVar = bya.b;
        btd btdVarT2 = aye.t(byaVar);
        btd btdVarT3 = aye.t(byaVar);
        btd btdVarT4 = aye.t(dnhVar);
        btd btdVarT5 = aye.t(dnhVar);
        btd btdVarT6 = aye.t(byaVar);
        pv pvVar = pv.b;
        return new btd[] { btdVarT, btdVarT2, btdVarT3, btdVarT4, btdVarT5, btdVarT6, aye.t(pvVar), aye.t(pvVar),
                aye.t(bqj.b), aye.t((btd) bttVarArr[9].getValue()) };
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
