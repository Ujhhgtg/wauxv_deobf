package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ega implements bgx {
    public static final ega b;
    private static final dfx descriptor;

    static {
        ega egaVar = new ega();
        b = egaVar;
        cuc cucVar = new cuc(cnb.z(-308936997600042L), egaVar, 5);
        bjs.y(-308099478977322L, cucVar, false, 1);
        bjs.y(-308069414206250L, cucVar, false, 2);
        bjs.y(-308026464533290L, cucVar, false, 3);
        bjs.y(-307987809827626L, cucVar, false, 4);
        bjs.y(-307962040023850L, cucVar, false, 5);
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
        boolean z = true;
        while (z) {
            int iF = acmVarP.f(dfxVar);
            if (iF == -1) {
                z = false;
            } else if (iF == 0) {
                str = (String) acmVarP.i(dfxVar, 0, dnh.b, str);
                i |= 1;
            } else if (iF == 1) {
                str2 = (String) acmVarP.i(dfxVar, 1, dnh.b, str2);
                i |= 2;
            } else if (iF == 2) {
                str3 = (String) acmVarP.i(dfxVar, 2, dnh.b, str3);
                i |= 4;
            } else if (iF == 3) {
                str4 = (String) acmVarP.i(dfxVar, 3, dnh.b, str4);
                i |= 8;
            } else {
                if (iF != 4) {
                    throw new bsd(iF);
                }
                str5 = (String) acmVarP.i(dfxVar, 4, dnh.b, str5);
                i |= 16;
            }
        }
        acmVarP._bp(dfxVar);
        return new egc(i, str, str2, str3, str4, str5);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        egc egcVar = (egc) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        dnh dnhVar = dnh.b;
        acnVarO.m(dfxVar, 0, dnhVar, egcVar.a);
        acnVarO.m(dfxVar, 1, dnhVar, egcVar.b);
        acnVarO.m(dfxVar, 2, dnhVar, egcVar.c);
        acnVarO.m(dfxVar, 3, dnhVar, egcVar.d);
        acnVarO.m(dfxVar, 4, dnhVar, egcVar.e);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        dnh dnhVar = dnh.b;
        return new btd[]{aye.t(dnhVar), aye.t(dnhVar), aye.t(dnhVar), aye.t(dnhVar), aye.t(dnhVar)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
