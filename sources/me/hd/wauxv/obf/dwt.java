package me.hd.wauxv.obf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class dwt implements bgx {
    public static final dwt b;
    private static final dfx descriptor;

    static {
        dwt dwtVar = new dwt();
        b = dwtVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.df1Proto" /*
                                                                                                               * cnb.z(-
                                                                                                               * 166537356901162L)
                                                                                                               */,
                dwtVar, 17);
        bjs.y(-163449275415338L, cucVar, false, 1);
        bjs.y(-163363376069418L, cucVar, false, 2);
        bjs.y(-163324721363754L, cucVar, false, 3);
        bjs.y(-163797167766314L, cucVar, false, 4);
        bjs.y(-163745628158762L, cucVar, false, 5);
        bjs.y(-163715563387690L, cucVar, false, 6);
        bjs.y(-163651138878250L, cucVar, false, 7);
        bjs.y(-162972534045482L, cucVar, false, 8);
        bjs.y(-162955354176298L, cucVar, false, 9);
        bjs.y(-162869454830378L, cucVar, false, 10);
        bjs.y(-162787850451754L, cucVar, false, 11);
        bjs.y(-163225937115946L, cucVar, false, 12);
        bjs.y(-163191577377578L, cucVar, false, 13);
        bjs.y(-163165807573802L, cucVar, false, 14);
        bjs.y(-163092793129770L, cucVar, false, 15);
        bjs.y(-164626096454442L, cucVar, false, 16);
        bjs.y(-164574556846890L, cucVar, false, 17);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dyr dyrVar;
        int i;
        List list;
        dyr dyrVar2;
        dyu dyuVar;
        dxb dxbVar;
        List list2;
        dyr dyrVar3;
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        IHasGetValue[] bttVarArr = dwv.a;
        acmVarP.getClass();
        egi egiVar = null;
        List list3 = null;
        dxb dxbVar2 = null;
        edh edhVar = null;
        Boolean bool = null;
        dzs dzsVar = null;
        edt edtVar = null;
        ehj ehjVar = null;
        dwd dwdVar = null;
        Integer num = null;
        dyr dyrVar4 = null;
        List list4 = null;
        dxk dxkVar = null;
        String str = null;
        Integer num2 = null;
        dyu dyuVar2 = null;
        dyu dyuVar3 = null;
        int i2 = 0;
        boolean z = true;
        while (z) {
            Integer num3 = num;
            int iF = acmVarP.f(dfxVar);
            switch (iF) {
                case -1:
                    list = list3;
                    dyrVar2 = dyrVar4;
                    dyuVar = dyuVar2;
                    dxbVar = dxbVar2;
                    z = false;
                    dxbVar2 = dxbVar;
                    num = num3;
                    dyrVar4 = dyrVar2;
                    list3 = list;
                    dyuVar2 = dyuVar;
                    break;
                case 0:
                    list = list3;
                    dyrVar2 = dyrVar4;
                    dyuVar = dyuVar2;
                    dxbVar = dxbVar2;
                    str = (String) acmVarP.i(dfxVar, 0, dnh.b, str);
                    i2 |= 1;
                    dxbVar2 = dxbVar;
                    num = num3;
                    dyrVar4 = dyrVar2;
                    list3 = list;
                    dyuVar2 = dyuVar;
                    break;
                case 1:
                    list2 = list3;
                    dyrVar3 = dyrVar4;
                    num2 = (Integer) acmVarP.i(dfxVar, 1, bqj.b, num2);
                    i2 |= 2;
                    dyuVar2 = dyuVar2;
                    num = num3;
                    dyrVar4 = dyrVar3;
                    list3 = list2;
                    break;
                case 2:
                    list2 = list3;
                    dyrVar3 = dyrVar4;
                    dyuVar2 = (dyu) acmVarP.i(dfxVar, 2, dys.b, dyuVar2);
                    i2 |= 4;
                    num = num3;
                    dyrVar4 = dyrVar3;
                    list3 = list2;
                    break;
                case 3:
                    list2 = list3;
                    dyrVar3 = dyrVar4;
                    dyuVar3 = (dyu) acmVarP.i(dfxVar, 3, dys.b, dyuVar3);
                    i2 |= 8;
                    num = num3;
                    dyrVar4 = dyrVar3;
                    list3 = list2;
                    break;
                case 4:
                    list2 = list3;
                    dyrVar3 = dyrVar4;
                    num = (Integer) acmVarP.i(dfxVar, 4, bqj.b, num3);
                    i2 |= 16;
                    dyrVar4 = dyrVar3;
                    list3 = list2;
                    break;
                case 5:
                    list2 = list3;
                    dyrVar4 = (dyr) acmVarP.i(dfxVar, 5, dyp.b, dyrVar4);
                    i2 |= 32;
                    num = num3;
                    list3 = list2;
                    break;
                case 6:
                    dyrVar = dyrVar4;
                    list4 = (List) acmVarP.i(dfxVar, 6, (btd) bttVarArr[6].getValue(), list4);
                    i2 |= 64;
                    num = num3;
                    dyrVar4 = dyrVar;
                    break;
                case 7:
                    dyrVar = dyrVar4;
                    dxkVar = (dxk) acmVarP.i(dfxVar, 7, dxi.b, dxkVar);
                    i2 |= 128;
                    num = num3;
                    dyrVar4 = dyrVar;
                    break;
                case 8:
                    dyrVar = dyrVar4;
                    egiVar = (egi) acmVarP.i(dfxVar, 8, egg.b, egiVar);
                    i2 |= 256;
                    num = num3;
                    dyrVar4 = dyrVar;
                    break;
                case 9:
                    dyrVar = dyrVar4;
                    bool = (Boolean) acmVarP.i(dfxVar, 9, pv.b, bool);
                    i2 |= 512;
                    num = num3;
                    dyrVar4 = dyrVar;
                    break;
                case 10:
                    dyrVar = dyrVar4;
                    dzsVar = (dzs) acmVarP.i(dfxVar, 10, dzq.b, dzsVar);
                    i2 |= 1024;
                    num = num3;
                    dyrVar4 = dyrVar;
                    break;
                case 11:
                    dyrVar = dyrVar4;
                    edhVar = (edh) acmVarP.i(dfxVar, 11, edf.b, edhVar);
                    i2 |= 2048;
                    num = num3;
                    dyrVar4 = dyrVar;
                    break;
                case 12:
                    dyrVar = dyrVar4;
                    dxbVar2 = (dxb) acmVarP.i(dfxVar, 12, dwz.b, dxbVar2);
                    i2 |= 4096;
                    num = num3;
                    dyrVar4 = dyrVar;
                    break;
                case 13:
                    dyrVar = dyrVar4;
                    list3 = (List) acmVarP.i(dfxVar, 13, (btd) bttVarArr[13].getValue(), list3);
                    i2 |= 8192;
                    num = num3;
                    dyrVar4 = dyrVar;
                    break;
                case 14:
                    dyrVar = dyrVar4;
                    edtVar = (edt) acmVarP.i(dfxVar, 14, edr.b, edtVar);
                    i2 |= 16384;
                    num = num3;
                    dyrVar4 = dyrVar;
                    break;
                case 15:
                    dyrVar = dyrVar4;
                    ehjVar = (ehj) acmVarP.i(dfxVar, 15, ehh.b, ehjVar);
                    i = 32768;
                    i2 |= i;
                    num = num3;
                    dyrVar4 = dyrVar;
                    break;
                case 16:
                    dyrVar = dyrVar4;
                    dwdVar = (dwd) acmVarP.i(dfxVar, 16, dwb.b, dwdVar);
                    i = 65536;
                    i2 |= i;
                    num = num3;
                    dyrVar4 = dyrVar;
                    break;
                default:
                    throw new bsd(iF);
            }
        }
        List list5 = list3;
        dyr dyrVar5 = dyrVar4;
        acmVarP._bp(dfxVar);
        return new dwv(i2, str, num2, dyuVar2, dyuVar3, num, dyrVar5, list4, dxkVar, egiVar, bool, dzsVar, edhVar,
                dxbVar2, list5, edtVar, ehjVar, dwdVar);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        dwv dwvVar = (dwv) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        IHasGetValue[] bttVarArr = dwv.a;
        acnVarO.m(dfxVar, 0, dnh.b, dwvVar.b);
        bqj bqjVar = bqj.b;
        acnVarO.m(dfxVar, 1, bqjVar, dwvVar.c);
        dys dysVar = dys.b;
        acnVarO.m(dfxVar, 2, dysVar, dwvVar.d);
        acnVarO.m(dfxVar, 3, dysVar, dwvVar.e);
        acnVarO.m(dfxVar, 4, bqjVar, dwvVar.f);
        acnVarO.m(dfxVar, 5, dyp.b, dwvVar.g);
        acnVarO.m(dfxVar, 6, (btd) bttVarArr[6].getValue(), dwvVar.h);
        acnVarO.m(dfxVar, 7, dxi.b, dwvVar.i);
        acnVarO.m(dfxVar, 8, egg.b, dwvVar.j);
        acnVarO.m(dfxVar, 9, pv.b, dwvVar.k);
        acnVarO.m(dfxVar, 10, dzq.b, dwvVar.l);
        acnVarO.m(dfxVar, 11, edf.b, dwvVar.m);
        acnVarO.m(dfxVar, 12, dwz.b, dwvVar.n);
        acnVarO.m(dfxVar, 13, (btd) bttVarArr[13].getValue(), dwvVar.o);
        acnVarO.m(dfxVar, 14, edr.b, dwvVar.p);
        acnVarO.m(dfxVar, 15, ehh.b, dwvVar.q);
        acnVarO.m(dfxVar, 16, dwb.b, dwvVar.r);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        IHasGetValue[] bttVarArr = dwv.a;
        btd btdVarT = aye.t(dnh.b);
        bqj bqjVar = bqj.b;
        btd btdVarT2 = aye.t(bqjVar);
        dys dysVar = dys.b;
        return new btd[] { btdVarT, btdVarT2, aye.t(dysVar), aye.t(dysVar), aye.t(bqjVar), aye.t(dyp.b),
                aye.t((btd) bttVarArr[6].getValue()), aye.t(dxi.b), aye.t(egg.b), aye.t(pv.b), aye.t(dzq.b),
                aye.t(edf.b), aye.t(dwz.b), aye.t((btd) bttVarArr[13].getValue()), aye.t(edr.b), aye.t(ehh.b),
                aye.t(dwb.b) };
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
