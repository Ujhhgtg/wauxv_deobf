package me.hd.wauxv.obf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class edx implements bgx {
    public static final edx b;
    private static final dfx descriptor;

    static {
        edx edxVar = new edx();
        b = edxVar;
        cuc cucVar = new cuc(cnb.z(-274607324003114L), edxVar, 10);
        bjs.y(-274268021586730L, cucVar, false, 1);
        bjs.y(-274229366881066L, cucVar, false, 2);
        bjs.y(-274207892044586L, cucVar, false, 3);
        bjs.y(-274169237338922L, cucVar, false, 4);
        bjs.y(-274139172567850L, cucVar, false, 5);
        bjs.y(-274152057469738L, cucVar, false, 6);
        bjs.y(-274070453091114L, cucVar, false, 7);
        bjs.y(-280091997240106L, cucVar, false, 8);
        bjs.y(-280014687828778L, cucVar, false, 9);
        bjs.y(-279976033123114L, cucVar, false, 10);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        btt[] bttVarArr;
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        btt[] bttVarArr2 = edz.a;
        acmVarP.getClass();
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        Integer num = null;
        List list = null;
        String str8 = null;
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
                    str3 = (String) acmVarP.i(dfxVar, 0, dnh.b, str3);
                    i |= 1;
                    break;
                case 1:
                    bttVarArr = bttVarArr2;
                    str4 = (String) acmVarP.i(dfxVar, 1, dnh.b, str4);
                    i |= 2;
                    break;
                case 2:
                    bttVarArr = bttVarArr2;
                    str5 = (String) acmVarP.i(dfxVar, 2, dnh.b, str5);
                    i |= 4;
                    break;
                case 3:
                    bttVarArr = bttVarArr2;
                    str6 = (String) acmVarP.i(dfxVar, 3, dnh.b, str6);
                    i |= 8;
                    break;
                case 4:
                    bttVarArr = bttVarArr2;
                    str7 = (String) acmVarP.i(dfxVar, 4, dnh.b, str7);
                    i |= 16;
                    break;
                case 5:
                    bttVarArr = bttVarArr2;
                    num = (Integer) acmVarP.i(dfxVar, 5, bqj.b, num);
                    i |= 32;
                    break;
                case 6:
                    bttVarArr = bttVarArr2;
                    list = (List) acmVarP.i(dfxVar, 6, (btd) bttVarArr[6].getValue(), list);
                    i |= 64;
                    break;
                case 7:
                    bttVarArr = bttVarArr2;
                    str8 = (String) acmVarP.i(dfxVar, 7, dnh.b, str8);
                    i |= 128;
                    break;
                case 8:
                    bttVarArr = bttVarArr2;
                    str = (String) acmVarP.i(dfxVar, 8, dnh.b, str);
                    i |= 256;
                    break;
                case 9:
                    bttVarArr = bttVarArr2;
                    str2 = (String) acmVarP.i(dfxVar, 9, dnh.b, str2);
                    i |= 512;
                    break;
                default:
                    throw new bsd(iF);
            }
            bttVarArr2 = bttVarArr;
        }
        acmVarP._bp(dfxVar);
        return new edz(i, str3, str4, str5, str6, str7, num, list, str8, str, str2);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        edz edzVar = (edz) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        btt[] bttVarArr = edz.a;
        dnh dnhVar = dnh.b;
        acnVarO.m(dfxVar, 0, dnhVar, edzVar.b);
        acnVarO.m(dfxVar, 1, dnhVar, edzVar.c);
        acnVarO.m(dfxVar, 2, dnhVar, edzVar.d);
        acnVarO.m(dfxVar, 3, dnhVar, edzVar.e);
        acnVarO.m(dfxVar, 4, dnhVar, edzVar.f);
        acnVarO.m(dfxVar, 5, bqj.b, edzVar.g);
        acnVarO.m(dfxVar, 6, (btd) bttVarArr[6].getValue(), edzVar.h);
        acnVarO.m(dfxVar, 7, dnhVar, edzVar.i);
        acnVarO.m(dfxVar, 8, dnhVar, edzVar.j);
        acnVarO.m(dfxVar, 9, dnhVar, edzVar.k);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        btt[] bttVarArr = edz.a;
        dnh dnhVar = dnh.b;
        return new btd[]{aye.t(dnhVar), aye.t(dnhVar), aye.t(dnhVar), aye.t(dnhVar), aye.t(dnhVar), aye.t(bqj.b), aye.t((btd) bttVarArr[6].getValue()), aye.t(dnhVar), aye.t(dnhVar), aye.t(dnhVar)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
