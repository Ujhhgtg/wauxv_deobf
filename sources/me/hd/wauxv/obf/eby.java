package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class eby implements bgx {
    public static final eby b;
    private static final dfx descriptor;

    static {
        eby ebyVar = new eby();
        b = ebyVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.nr5Proto" /* cnb.z(-256370892864298L) */, ebyVar, 13);
        bjs.y(-256581346261802L, cucVar, false, 1);
        bjs.y(-256589936196394L, cucVar, false, 2);
        bjs.y(-256598526130986L, cucVar, false, 3);
        bjs.y(-256538396588842L, cucVar, false, 4);
        bjs.y(-256546986523434L, cucVar, false, 5);
        bjs.y(-256555576458026L, cucVar, false, 6);
        bjs.y(-256564166392618L, cucVar, false, 7);
        bjs.y(-256504036850474L, cucVar, false, 8);
        bjs.y(-256512626785066L, cucVar, false, 9);
        bjs.y(-256521216719658L, cucVar, false, 10);
        bjs.y(-256529806654250L, cucVar, false, 11);
        bjs.y(-256469677112106L, cucVar, false, 12);
        bjs.y(-256478267046698L, cucVar, false, 13);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        Integer num;
        String str;
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        acmVarP.getClass();
        Integer num2 = null;
        String str2 = null;
        eha ehaVar = null;
        ejl ejlVar = null;
        String str3 = null;
        Integer num3 = null;
        Integer num4 = null;
        efa efaVar = null;
        edk edkVar = null;
        eiw eiwVar = null;
        efg efgVar = null;
        Integer num5 = null;
        Integer num6 = null;
        int i = 0;
        boolean z = true;
        while (z) {
            String str4 = str3;
            int iF = acmVarP.f(dfxVar);
            switch (iF) {
                case -1:
                    str = str2;
                    str3 = str4;
                    z = false;
                    i = i;
                    str2 = str;
                    break;
                case 0:
                    str = str2;
                    str3 = (String) acmVarP.i(dfxVar, 0, dnh.b, str4);
                    i |= 1;
                    str2 = str;
                    break;
                case 1:
                    num3 = (Integer) acmVarP.i(dfxVar, 1, bqj.b, num3);
                    i |= 2;
                    str3 = str4;
                    break;
                case 2:
                    num = num3;
                    num4 = (Integer) acmVarP.i(dfxVar, 2, bqj.b, num4);
                    i |= 4;
                    str3 = str4;
                    num3 = num;
                    break;
                case 3:
                    num = num3;
                    efaVar = (efa) acmVarP.i(dfxVar, 3, eey.b, efaVar);
                    i |= 8;
                    str3 = str4;
                    num3 = num;
                    break;
                case 4:
                    num = num3;
                    edkVar = (edk) acmVarP.i(dfxVar, 4, edi.b, edkVar);
                    i |= 16;
                    str3 = str4;
                    num3 = num;
                    break;
                case 5:
                    num = num3;
                    eiwVar = (eiw) acmVarP.i(dfxVar, 5, eiu.b, eiwVar);
                    i |= 32;
                    str3 = str4;
                    num3 = num;
                    break;
                case 6:
                    num = num3;
                    efgVar = (efg) acmVarP.i(dfxVar, 6, efe.b, efgVar);
                    i |= 64;
                    str3 = str4;
                    num3 = num;
                    break;
                case 7:
                    num = num3;
                    num5 = (Integer) acmVarP.i(dfxVar, 7, bqj.b, num5);
                    i |= 128;
                    str3 = str4;
                    num3 = num;
                    break;
                case 8:
                    num = num3;
                    num6 = (Integer) acmVarP.i(dfxVar, 8, bqj.b, num6);
                    i |= 256;
                    str3 = str4;
                    num3 = num;
                    break;
                case 9:
                    num = num3;
                    num2 = (Integer) acmVarP.i(dfxVar, 9, bqj.b, num2);
                    i |= 512;
                    str3 = str4;
                    num3 = num;
                    break;
                case 10:
                    num = num3;
                    ehaVar = (eha) acmVarP.i(dfxVar, 10, egy.b, ehaVar);
                    i |= 1024;
                    str3 = str4;
                    num3 = num;
                    break;
                case 11:
                    num = num3;
                    ejlVar = (ejl) acmVarP.i(dfxVar, 11, ejj.b, ejlVar);
                    i |= 2048;
                    str3 = str4;
                    num3 = num;
                    break;
                case 12:
                    num = num3;
                    str2 = (String) acmVarP.i(dfxVar, 12, dnh.b, str2);
                    i |= 4096;
                    str3 = str4;
                    num3 = num;
                    break;
                default:
                    throw new bsd(iF);
            }
        }
        acmVarP._bp(dfxVar);
        return new eca(i, str3, num3, num4, efaVar, edkVar, eiwVar, efgVar, num5, num6, num2, ehaVar, ejlVar, str2);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        eca ecaVar = (eca) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        dnh dnhVar = dnh.b;
        acnVarO.m(dfxVar, 0, dnhVar, ecaVar.a);
        bqj bqjVar = bqj.b;
        acnVarO.m(dfxVar, 1, bqjVar, ecaVar.b);
        acnVarO.m(dfxVar, 2, bqjVar, ecaVar.c);
        acnVarO.m(dfxVar, 3, eey.b, ecaVar.d);
        acnVarO.m(dfxVar, 4, edi.b, ecaVar.e);
        acnVarO.m(dfxVar, 5, eiu.b, ecaVar.f);
        acnVarO.m(dfxVar, 6, efe.b, ecaVar.g);
        acnVarO.m(dfxVar, 7, bqjVar, ecaVar.h);
        acnVarO.m(dfxVar, 8, bqjVar, ecaVar.i);
        acnVarO.m(dfxVar, 9, bqjVar, ecaVar.j);
        acnVarO.m(dfxVar, 10, egy.b, ecaVar.k);
        acnVarO.m(dfxVar, 11, ejj.b, ecaVar.l);
        acnVarO.m(dfxVar, 12, dnhVar, ecaVar.m);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        dnh dnhVar = dnh.b;
        btd btdVarT = aye.t(dnhVar);
        bqj bqjVar = bqj.b;
        return new btd[]{btdVarT, aye.t(bqjVar), aye.t(bqjVar), aye.t(eey.b), aye.t(edi.b), aye.t(eiu.b), aye.t(efe.b), aye.t(bqjVar), aye.t(bqjVar), aye.t(bqjVar), aye.t(egy.b), aye.t(ejj.b), aye.t(dnhVar)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
