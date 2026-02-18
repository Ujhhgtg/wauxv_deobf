package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class dww implements bgx {
    public static final dww b;
    private static final dfx descriptor;

    static {
        dww dwwVar = new dww();
        b = dwwVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.ec5Proto" /* cnb.z(-187896229264170L) */, dwwVar, 18);
        bjs.y(-186989991164714L, cucVar, false, 1);
        bjs.y(-186929861622570L, cucVar, false, 2);
        bjs.y(-187402308025130L, cucVar, false, 3);
        bjs.y(-187355063384874L, cucVar, false, 4);
        bjs.y(-187286343908138L, cucVar, false, 5);
        bjs.y(-187226214365994L, cucVar, false, 6);
        bjs.y(-188742337821482L, cucVar, false, 7);
        bjs.y(-188673618344746L, cucVar, false, 8);
        bjs.y(-188613488802602L, cucVar, false, 9);
        bjs.y(-188574834096938L, cucVar, false, 10);
        bjs.y(-188600603900714L, cucVar, false, 11);
        bjs.y(-189055870434090L, cucVar, false, 12);
        bjs.y(-189012920761130L, cucVar, false, 13);
        bjs.y(-188957086186282L, cucVar, false, 14);
        bjs.y(-188871186840362L, cucVar, false, 15);
        bjs.y(-188166812203818L, cucVar, false, 16);
        bjs.y(-188149632334634L, cucVar, false, 17);
        bjs.y(-188549064293162L, cucVar, false, 18);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        String str;
        int i;
        dwj dwjVar;
        String str2;
        dwj dwjVar2;
        Integer num;
        dwj dwjVar3;
        String str3;
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        acmVarP.getClass();
        String str4 = null;
        dwj dwjVar4 = null;
        Integer num2 = null;
        String str5 = null;
        String str6 = null;
        dwj dwjVar5 = null;
        dwj dwjVar6 = null;
        dwj dwjVar7 = null;
        dwj dwjVar8 = null;
        Float f = null;
        String str7 = null;
        Boolean bool = null;
        Boolean bool2 = null;
        String str8 = null;
        dwj dwjVar9 = null;
        dwj dwjVar10 = null;
        dwj dwjVar11 = null;
        dwj dwjVar12 = null;
        int i2 = 0;
        boolean z = true;
        while (z) {
            Float f2 = f;
            int iF = acmVarP.f(dfxVar);
            switch (iF) {
                case -1:
                    dwjVar = dwjVar4;
                    str2 = str7;
                    dwjVar2 = dwjVar10;
                    num = num2;
                    z = false;
                    num2 = num;
                    f = f2;
                    str7 = str2;
                    dwjVar4 = dwjVar;
                    dwjVar10 = dwjVar2;
                    break;
                case 0:
                    dwjVar = dwjVar4;
                    str2 = str7;
                    dwjVar2 = dwjVar10;
                    num = num2;
                    str8 = (String) acmVarP.i(dfxVar, 0, dnh.b, str8);
                    i2 |= 1;
                    num2 = num;
                    f = f2;
                    str7 = str2;
                    dwjVar4 = dwjVar;
                    dwjVar10 = dwjVar2;
                    break;
                case 1:
                    dwjVar3 = dwjVar4;
                    str3 = str7;
                    dwjVar9 = (dwj) acmVarP.i(dfxVar, 1, dwh.b, dwjVar9);
                    i2 |= 2;
                    dwjVar10 = dwjVar10;
                    f = f2;
                    str7 = str3;
                    dwjVar4 = dwjVar3;
                    break;
                case 2:
                    dwjVar3 = dwjVar4;
                    str3 = str7;
                    dwjVar10 = (dwj) acmVarP.i(dfxVar, 2, dwh.b, dwjVar10);
                    i2 |= 4;
                    f = f2;
                    str7 = str3;
                    dwjVar4 = dwjVar3;
                    break;
                case 3:
                    dwjVar3 = dwjVar4;
                    str3 = str7;
                    dwjVar11 = (dwj) acmVarP.i(dfxVar, 3, dwh.b, dwjVar11);
                    i2 |= 8;
                    f = f2;
                    str7 = str3;
                    dwjVar4 = dwjVar3;
                    break;
                case 4:
                    dwjVar3 = dwjVar4;
                    str3 = str7;
                    dwjVar12 = (dwj) acmVarP.i(dfxVar, 4, dwh.b, dwjVar12);
                    i2 |= 16;
                    f = f2;
                    str7 = str3;
                    dwjVar4 = dwjVar3;
                    break;
                case 5:
                    dwjVar3 = dwjVar4;
                    str3 = str7;
                    f = (Float) acmVarP.i(dfxVar, 5, bbm.b, f2);
                    i2 |= 32;
                    str7 = str3;
                    dwjVar4 = dwjVar3;
                    break;
                case 6:
                    dwjVar3 = dwjVar4;
                    str7 = (String) acmVarP.i(dfxVar, 6, dnh.b, str7);
                    i2 |= 64;
                    f = f2;
                    dwjVar4 = dwjVar3;
                    break;
                case 7:
                    str = str7;
                    bool = (Boolean) acmVarP.i(dfxVar, 7, pv.b, bool);
                    i2 |= 128;
                    f = f2;
                    str7 = str;
                    break;
                case 8:
                    str = str7;
                    bool2 = (Boolean) acmVarP.i(dfxVar, 8, pv.b, bool2);
                    i2 |= 256;
                    f = f2;
                    str7 = str;
                    break;
                case 9:
                    str = str7;
                    str4 = (String) acmVarP.i(dfxVar, 9, dnh.b, str4);
                    i2 |= 512;
                    f = f2;
                    str7 = str;
                    break;
                case 10:
                    str = str7;
                    str5 = (String) acmVarP.i(dfxVar, 10, dnh.b, str5);
                    i2 |= 1024;
                    f = f2;
                    str7 = str;
                    break;
                case 11:
                    str = str7;
                    str6 = (String) acmVarP.i(dfxVar, 11, dnh.b, str6);
                    i2 |= 2048;
                    f = f2;
                    str7 = str;
                    break;
                case 12:
                    str = str7;
                    num2 = (Integer) acmVarP.i(dfxVar, 12, bqj.b, num2);
                    i2 |= 4096;
                    f = f2;
                    str7 = str;
                    break;
                case 13:
                    str = str7;
                    dwjVar4 = (dwj) acmVarP.i(dfxVar, 13, dwh.b, dwjVar4);
                    i2 |= 8192;
                    f = f2;
                    str7 = str;
                    break;
                case 14:
                    str = str7;
                    dwjVar5 = (dwj) acmVarP.i(dfxVar, 14, dwh.b, dwjVar5);
                    i2 |= 16384;
                    f = f2;
                    str7 = str;
                    break;
                case 15:
                    str = str7;
                    dwjVar6 = (dwj) acmVarP.i(dfxVar, 15, dwh.b, dwjVar6);
                    i = 32768;
                    i2 |= i;
                    f = f2;
                    str7 = str;
                    break;
                case 16:
                    str = str7;
                    dwjVar7 = (dwj) acmVarP.i(dfxVar, 16, dwh.b, dwjVar7);
                    i = 65536;
                    i2 |= i;
                    f = f2;
                    str7 = str;
                    break;
                case 17:
                    str = str7;
                    dwjVar8 = (dwj) acmVarP.i(dfxVar, 17, dwh.b, dwjVar8);
                    i = 131072;
                    i2 |= i;
                    f = f2;
                    str7 = str;
                    break;
                default:
                    throw new bsd(iF);
            }
        }
        dwj dwjVar13 = dwjVar4;
        String str9 = str7;
        acmVarP._bp(dfxVar);
        return new dwy(i2, str8, dwjVar9, dwjVar10, dwjVar11, dwjVar12, f, str9, bool, bool2, str4, str5, str6, num2, dwjVar13, dwjVar5, dwjVar6, dwjVar7, dwjVar8);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        dwy dwyVar = (dwy) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        dnh dnhVar = dnh.b;
        acnVarO.m(dfxVar, 0, dnhVar, dwyVar.a);
        dwh dwhVar = dwh.b;
        acnVarO.m(dfxVar, 1, dwhVar, dwyVar.b);
        acnVarO.m(dfxVar, 2, dwhVar, dwyVar.c);
        acnVarO.m(dfxVar, 3, dwhVar, dwyVar.d);
        acnVarO.m(dfxVar, 4, dwhVar, dwyVar.e);
        acnVarO.m(dfxVar, 5, bbm.b, dwyVar.f);
        acnVarO.m(dfxVar, 6, dnhVar, dwyVar.g);
        pv pvVar = pv.b;
        acnVarO.m(dfxVar, 7, pvVar, dwyVar.h);
        acnVarO.m(dfxVar, 8, pvVar, dwyVar.i);
        acnVarO.m(dfxVar, 9, dnhVar, dwyVar.j);
        acnVarO.m(dfxVar, 10, dnhVar, dwyVar.k);
        acnVarO.m(dfxVar, 11, dnhVar, dwyVar.l);
        acnVarO.m(dfxVar, 12, bqj.b, dwyVar.m);
        acnVarO.m(dfxVar, 13, dwhVar, dwyVar.n);
        acnVarO.m(dfxVar, 14, dwhVar, dwyVar.o);
        acnVarO.m(dfxVar, 15, dwhVar, dwyVar.p);
        acnVarO.m(dfxVar, 16, dwhVar, dwyVar.q);
        acnVarO.m(dfxVar, 17, dwhVar, dwyVar.r);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        dnh dnhVar = dnh.b;
        btd btdVarT = aye.t(dnhVar);
        dwh dwhVar = dwh.b;
        btd btdVarT2 = aye.t(dwhVar);
        btd btdVarT3 = aye.t(dwhVar);
        btd btdVarT4 = aye.t(dwhVar);
        btd btdVarT5 = aye.t(dwhVar);
        btd btdVarT6 = aye.t(bbm.b);
        btd btdVarT7 = aye.t(dnhVar);
        pv pvVar = pv.b;
        return new btd[]{btdVarT, btdVarT2, btdVarT3, btdVarT4, btdVarT5, btdVarT6, btdVarT7, aye.t(pvVar), aye.t(pvVar), aye.t(dnhVar), aye.t(dnhVar), aye.t(dnhVar), aye.t(bqj.b), aye.t(dwhVar), aye.t(dwhVar), aye.t(dwhVar), aye.t(dwhVar), aye.t(dwhVar)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
