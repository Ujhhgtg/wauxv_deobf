package me.hd.wauxv.obf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class efb implements bgx {
    public static final efb b;
    private static final dfx descriptor;

    static {
        efb efbVar = new efb();
        b = efbVar;
        cuc cucVar = new cuc(cnb.z(-284240935648042L), efbVar, 11);
        bjs.y(-283884453362474L, cucVar, false, 1);
        bjs.y(-283824323820330L, cucVar, false, 2);
        bjs.y(-283747014409002L, cucVar, false, 3);
        bjs.y(-283699769768746L, cucVar, false, 4);
        bjs.y(-284180806105898L, cucVar, false, 5);
        bjs.y(-284120676563754L, cucVar, false, 6);
        bjs.y(-283987532577578L, cucVar, false, 7);
        bjs.y(-285568080542506L, cucVar, false, 8);
        bjs.y(-285507951000362L, cucVar, false, 9);
        bjs.y(-285469296294698L, cucVar, false, 10);
        bjs.y(-285495066098474L, cucVar, false, 11);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        btt[] bttVarArr;
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        btt[] bttVarArr2 = efd.a;
        acmVarP.getClass();
        dwj dwjVar = null;
        String str = null;
        Boolean bool = null;
        List list = null;
        egf egfVar = null;
        List list2 = null;
        dwj dwjVar2 = null;
        dwj dwjVar3 = null;
        dwj dwjVar4 = null;
        dwj dwjVar5 = null;
        String str2 = null;
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
                    list = (List) acmVarP.i(dfxVar, 0, (btd) bttVarArr[0].getValue(), list);
                    i |= 1;
                    break;
                case 1:
                    bttVarArr = bttVarArr2;
                    egfVar = (egf) acmVarP.i(dfxVar, 1, egd.b, egfVar);
                    i |= 2;
                    break;
                case 2:
                    bttVarArr = bttVarArr2;
                    list2 = (List) acmVarP.i(dfxVar, 2, (btd) bttVarArr[2].getValue(), list2);
                    i |= 4;
                    break;
                case 3:
                    bttVarArr = bttVarArr2;
                    dwjVar2 = (dwj) acmVarP.i(dfxVar, 3, dwh.b, dwjVar2);
                    i |= 8;
                    break;
                case 4:
                    bttVarArr = bttVarArr2;
                    dwjVar3 = (dwj) acmVarP.i(dfxVar, 4, dwh.b, dwjVar3);
                    i |= 16;
                    break;
                case 5:
                    bttVarArr = bttVarArr2;
                    dwjVar4 = (dwj) acmVarP.i(dfxVar, 5, dwh.b, dwjVar4);
                    i |= 32;
                    break;
                case 6:
                    bttVarArr = bttVarArr2;
                    dwjVar5 = (dwj) acmVarP.i(dfxVar, 6, dwh.b, dwjVar5);
                    i |= 64;
                    break;
                case 7:
                    bttVarArr = bttVarArr2;
                    str2 = (String) acmVarP.i(dfxVar, 7, dnh.b, str2);
                    i |= 128;
                    break;
                case 8:
                    bttVarArr = bttVarArr2;
                    dwjVar = (dwj) acmVarP.i(dfxVar, 8, dwh.b, dwjVar);
                    i |= 256;
                    break;
                case 9:
                    bttVarArr = bttVarArr2;
                    str = (String) acmVarP.i(dfxVar, 9, dnh.b, str);
                    i |= 512;
                    break;
                case 10:
                    bttVarArr = bttVarArr2;
                    bool = (Boolean) acmVarP.i(dfxVar, 10, pv.b, bool);
                    i |= 1024;
                    break;
                default:
                    throw new bsd(iF);
            }
            bttVarArr2 = bttVarArr;
        }
        acmVarP._bp(dfxVar);
        return new efd(i, list, egfVar, list2, dwjVar2, dwjVar3, dwjVar4, dwjVar5, str2, dwjVar, str, bool);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        efd efdVar = (efd) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        btt[] bttVarArr = efd.a;
        acnVarO.m(dfxVar, 0, (btd) bttVarArr[0].getValue(), efdVar.b);
        acnVarO.m(dfxVar, 1, egd.b, efdVar.c);
        acnVarO.m(dfxVar, 2, (btd) bttVarArr[2].getValue(), efdVar.d);
        dwh dwhVar = dwh.b;
        acnVarO.m(dfxVar, 3, dwhVar, efdVar.e);
        acnVarO.m(dfxVar, 4, dwhVar, efdVar.f);
        acnVarO.m(dfxVar, 5, dwhVar, efdVar.g);
        acnVarO.m(dfxVar, 6, dwhVar, efdVar.h);
        dnh dnhVar = dnh.b;
        acnVarO.m(dfxVar, 7, dnhVar, efdVar.i);
        acnVarO.m(dfxVar, 8, dwhVar, efdVar.j);
        acnVarO.m(dfxVar, 9, dnhVar, efdVar.k);
        acnVarO.m(dfxVar, 10, pv.b, efdVar.l);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        btt[] bttVarArr = efd.a;
        btd btdVarT = aye.t((btd) bttVarArr[0].getValue());
        btd btdVarT2 = aye.t(egd.b);
        btd btdVarT3 = aye.t((btd) bttVarArr[2].getValue());
        dwh dwhVar = dwh.b;
        btd btdVarT4 = aye.t(dwhVar);
        btd btdVarT5 = aye.t(dwhVar);
        btd btdVarT6 = aye.t(dwhVar);
        btd btdVarT7 = aye.t(dwhVar);
        dnh dnhVar = dnh.b;
        return new btd[]{btdVarT, btdVarT2, btdVarT3, btdVarT4, btdVarT5, btdVarT6, btdVarT7, aye.t(dnhVar), aye.t(dwhVar), aye.t(dnhVar), aye.t(pv.b)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
