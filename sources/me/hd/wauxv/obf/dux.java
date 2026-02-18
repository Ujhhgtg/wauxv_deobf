package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class dux implements bgx {
    public static final dux b;
    private static final dfx descriptor;

    static {
        dux duxVar = new dux();
        b = duxVar;
        cuc cucVar = new cuc(cnb.z(-153935922854698L), duxVar, 8);
        bjs.y(-155795643693866L, cucVar, false, 1);
        bjs.y(-155782758791978L, cucVar, false, 2);
        bjs.y(-155714039315242L, cucVar, false, 3);
        bjs.y(-155679679576874L, cucVar, false, 4);
        bjs.y(-155615255067434L, cucVar, false, 5);
        bjs.y(-156130651142954L, cucVar, false, 6);
        bjs.y(-156096291404586L, cucVar, false, 7);
        bjs.y(-156018981993258L, cucVar, false, 8);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        acmVarP.getClass();
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        boolean z = true;
        while (z) {
            int iF = acmVarP.f(dfxVar);
            switch (iF) {
                case -1:
                    z = false;
                    break;
                case 0:
                    str = (String) acmVarP.i(dfxVar, 0, dnh.b, str);
                    i |= 1;
                    break;
                case 1:
                    str2 = (String) acmVarP.i(dfxVar, 1, dnh.b, str2);
                    i |= 2;
                    break;
                case 2:
                    str3 = (String) acmVarP.i(dfxVar, 2, dnh.b, str3);
                    i |= 4;
                    break;
                case 3:
                    str4 = (String) acmVarP.i(dfxVar, 3, dnh.b, str4);
                    i |= 8;
                    break;
                case 4:
                    str5 = (String) acmVarP.i(dfxVar, 4, dnh.b, str5);
                    i |= 16;
                    break;
                case 5:
                    str6 = (String) acmVarP.i(dfxVar, 5, dnh.b, str6);
                    i |= 32;
                    break;
                case 6:
                    str7 = (String) acmVarP.i(dfxVar, 6, dnh.b, str7);
                    i |= 64;
                    break;
                case 7:
                    str8 = (String) acmVarP.i(dfxVar, 7, dnh.b, str8);
                    i |= 128;
                    break;
                default:
                    throw new bsd(iF);
            }
        }
        acmVarP._bp(dfxVar);
        return new duz(i, str, str2, str3, str4, str5, str6, str7, str8);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        duz duzVar = (duz) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        dnh dnhVar = dnh.b;
        acnVarO.m(dfxVar, 0, dnhVar, duzVar.a);
        acnVarO.m(dfxVar, 1, dnhVar, duzVar.b);
        acnVarO.m(dfxVar, 2, dnhVar, duzVar.c);
        acnVarO.m(dfxVar, 3, dnhVar, duzVar.d);
        acnVarO.m(dfxVar, 4, dnhVar, duzVar.e);
        acnVarO.m(dfxVar, 5, dnhVar, duzVar.f);
        acnVarO.m(dfxVar, 6, dnhVar, duzVar.g);
        acnVarO.m(dfxVar, 7, dnhVar, duzVar.h);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        dnh dnhVar = dnh.b;
        return new btd[]{aye.t(dnhVar), aye.t(dnhVar), aye.t(dnhVar), aye.t(dnhVar), aye.t(dnhVar), aye.t(dnhVar), aye.t(dnhVar), aye.t(dnhVar)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
