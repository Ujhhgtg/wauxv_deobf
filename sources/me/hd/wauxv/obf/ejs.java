package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ejs implements bgx {
    public static final ejs b;
    private static final dfx descriptor;

    static {
        ejs ejsVar = new ejs();
        b = ejsVar;
        cuc cucVar = new cuc(cnb.z(-350250288020266L), ejsVar, 12);
        bjs.y(-349910985603882L, cucVar, false, 1);
        bjs.y(-349880920832810L, cucVar, false, 2);
        bjs.y(-349816496323370L, cucVar, false, 3);
        bjs.y(-349730596977450L, cucVar, false, 4);
        bjs.y(-349709122140970L, cucVar, false, 5);
        bjs.y(-350185863510826L, cucVar, false, 6);
        bjs.y(-350112849066794L, cucVar, false, 7);
        bjs.y(-350048424557354L, cucVar, false, 8);
        bjs.y(-350022654753578L, cucVar, false, 9);
        bjs.y(-349928165473066L, cucVar, false, 10);
        bjs.y(-351547368143658L, cucVar, false, 11);
        bjs.y(-351525893307178L, cucVar, false, 12);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        String str;
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        acmVarP.getClass();
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        Boolean bool = null;
        Boolean bool2 = null;
        String str10 = null;
        String str11 = null;
        int i = 0;
        boolean z = true;
        while (z) {
            int iF = acmVarP.f(dfxVar);
            switch (iF) {
                case -1:
                    z = false;
                    i = i;
                    continue;
                case 0:
                    str5 = (String) acmVarP.i(dfxVar, 0, dnh.b, str5);
                    i |= 1;
                    continue;
                case 1:
                    str = str5;
                    str6 = (String) acmVarP.i(dfxVar, 1, dnh.b, str6);
                    i |= 2;
                    break;
                case 2:
                    str = str5;
                    str7 = (String) acmVarP.i(dfxVar, 2, dnh.b, str7);
                    i |= 4;
                    break;
                case 3:
                    str = str5;
                    str8 = (String) acmVarP.i(dfxVar, 3, dnh.b, str8);
                    i |= 8;
                    break;
                case 4:
                    str = str5;
                    str9 = (String) acmVarP.i(dfxVar, 4, dnh.b, str9);
                    i |= 16;
                    break;
                case 5:
                    str = str5;
                    bool = (Boolean) acmVarP.i(dfxVar, 5, pv.b, bool);
                    i |= 32;
                    break;
                case 6:
                    str = str5;
                    bool2 = (Boolean) acmVarP.i(dfxVar, 6, pv.b, bool2);
                    i |= 64;
                    break;
                case 7:
                    str = str5;
                    str10 = (String) acmVarP.i(dfxVar, 7, dnh.b, str10);
                    i |= 128;
                    break;
                case 8:
                    str = str5;
                    str11 = (String) acmVarP.i(dfxVar, 8, dnh.b, str11);
                    i |= 256;
                    break;
                case 9:
                    str = str5;
                    str2 = (String) acmVarP.i(dfxVar, 9, dnh.b, str2);
                    i |= 512;
                    break;
                case 10:
                    str = str5;
                    str3 = (String) acmVarP.i(dfxVar, 10, dnh.b, str3);
                    i |= 1024;
                    break;
                case 11:
                    str = str5;
                    str4 = (String) acmVarP.i(dfxVar, 11, dnh.b, str4);
                    i |= 2048;
                    break;
                default:
                    throw new bsd(iF);
            }
            str5 = str;
        }
        acmVarP._bp(dfxVar);
        return new eju(i, str5, str6, str7, str8, str9, bool, bool2, str10, str11, str2, str3, str4);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        eju ejuVar = (eju) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        dnh dnhVar = dnh.b;
        acnVarO.m(dfxVar, 0, dnhVar, ejuVar.a);
        acnVarO.m(dfxVar, 1, dnhVar, ejuVar.b);
        acnVarO.m(dfxVar, 2, dnhVar, ejuVar.c);
        acnVarO.m(dfxVar, 3, dnhVar, ejuVar.d);
        acnVarO.m(dfxVar, 4, dnhVar, ejuVar.e);
        pv pvVar = pv.b;
        acnVarO.m(dfxVar, 5, pvVar, ejuVar.f);
        acnVarO.m(dfxVar, 6, pvVar, ejuVar.g);
        acnVarO.m(dfxVar, 7, dnhVar, ejuVar.h);
        acnVarO.m(dfxVar, 8, dnhVar, ejuVar.i);
        acnVarO.m(dfxVar, 9, dnhVar, ejuVar.j);
        acnVarO.m(dfxVar, 10, dnhVar, ejuVar.k);
        acnVarO.m(dfxVar, 11, dnhVar, ejuVar.l);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        dnh dnhVar = dnh.b;
        btd btdVarT = aye.t(dnhVar);
        btd btdVarT2 = aye.t(dnhVar);
        btd btdVarT3 = aye.t(dnhVar);
        btd btdVarT4 = aye.t(dnhVar);
        btd btdVarT5 = aye.t(dnhVar);
        pv pvVar = pv.b;
        return new btd[]{btdVarT, btdVarT2, btdVarT3, btdVarT4, btdVarT5, aye.t(pvVar), aye.t(pvVar), aye.t(dnhVar), aye.t(dnhVar), aye.t(dnhVar), aye.t(dnhVar), aye.t(dnhVar)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
