package me.hd.wauxv.obf;

import java.util.List;
import net.bytebuddy.jar.asm.Opcodes;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class dsq implements bgx {
    public static final dsq b;
    private static final dfx descriptor;

    static {
        dsq dsqVar = new dsq();
        b = dsqVar;
        cuc cucVar = new cuc(cnb.z(-172215303666474L), dsqVar, 21);
        bjs.y(-172447231900458L, cucVar, false, 1);
        bjs.y(-172361332554538L, cucVar, false, 2);
        bjs.y(-171738562296618L, cucVar, false, 3);
        bjs.y(-171764332100394L, cucVar, false, 4);
        bjs.y(-171665547852586L, cucVar, false, 5);
        bjs.y(-171639778048810L, cucVar, false, 6);
        bjs.y(-171571058572074L, cucVar, false, 7);
        bjs.y(-171553878702890L, cucVar, false, 8);
        bjs.y(-172017735170858L, cucVar, false, 9);
        bjs.y(-172004850268970L, cucVar, false, 10);
        bjs.y(-171931835824938L, cucVar, false, 11);
        bjs.y(-171858821380906L, cucVar, false, 12);
        bjs.y(-173417894509354L, cucVar, false, 13);
        bjs.y(-173362059934506L, cucVar, false, 14);
        bjs.y(-173293340457770L, cucVar, false, 15);
        bjs.y(-173263275686698L, cucVar, false, 16);
        bjs.y(-173177376340778L, cucVar, false, 17);
        bjs.y(-173714247252778L, cucVar, false, 18);
        bjs.y(-173675592547114L, cucVar, false, 19);
        bjs.y(-173589693201194L, cucVar, false, 20);
        bjs.y(-173520973724458L, cucVar, false, 21);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dvo dvoVar;
        int i;
        edz edzVar;
        dvo dvoVar2;
        String str;
        duh duhVar;
        edz edzVar2;
        dvo dvoVar3;
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        btt[] bttVarArr = dss.a;
        acmVarP.getClass();
        dtb dtbVar = null;
        edz edzVar3 = null;
        duh duhVar2 = null;
        egc egcVar = null;
        dvo dvoVar4 = null;
        dzj dzjVar = null;
        Integer num = null;
        dvo dvoVar5 = null;
        eiq eiqVar = null;
        duz duzVar = null;
        ebo eboVar = null;
        dvo dvoVar6 = null;
        eaz eazVar = null;
        String str2 = null;
        Integer num2 = null;
        String str3 = null;
        String str4 = null;
        List list = null;
        Integer num3 = null;
        String str5 = null;
        dty dtyVar = null;
        int i2 = 0;
        boolean z = true;
        while (z) {
            dtb dtbVar2 = dtbVar;
            int iF = acmVarP.f(dfxVar);
            switch (iF) {
                case -1:
                    edzVar = edzVar3;
                    dvoVar2 = dvoVar4;
                    str = str3;
                    duhVar = duhVar2;
                    z = false;
                    duhVar2 = duhVar;
                    dtbVar = dtbVar2;
                    dvoVar4 = dvoVar2;
                    edzVar3 = edzVar;
                    str3 = str;
                    break;
                case 0:
                    edzVar = edzVar3;
                    dvoVar2 = dvoVar4;
                    str = str3;
                    duhVar = duhVar2;
                    str2 = (String) acmVarP.i(dfxVar, 0, dnh.b, str2);
                    i2 |= 1;
                    duhVar2 = duhVar;
                    dtbVar = dtbVar2;
                    dvoVar4 = dvoVar2;
                    edzVar3 = edzVar;
                    str3 = str;
                    break;
                case 1:
                    edzVar2 = edzVar3;
                    dvoVar3 = dvoVar4;
                    num2 = (Integer) acmVarP.i(dfxVar, 1, bqj.b, num2);
                    i2 |= 2;
                    str3 = str3;
                    dtbVar = dtbVar2;
                    dvoVar4 = dvoVar3;
                    edzVar3 = edzVar2;
                    break;
                case 2:
                    edzVar2 = edzVar3;
                    dvoVar3 = dvoVar4;
                    str3 = (String) acmVarP.i(dfxVar, 2, dnh.b, str3);
                    i2 |= 4;
                    dtbVar = dtbVar2;
                    dvoVar4 = dvoVar3;
                    edzVar3 = edzVar2;
                    break;
                case 3:
                    edzVar2 = edzVar3;
                    dvoVar3 = dvoVar4;
                    str4 = (String) acmVarP.i(dfxVar, 3, dnh.b, str4);
                    i2 |= 8;
                    dtbVar = dtbVar2;
                    dvoVar4 = dvoVar3;
                    edzVar3 = edzVar2;
                    break;
                case 4:
                    edzVar2 = edzVar3;
                    dvoVar3 = dvoVar4;
                    list = (List) acmVarP.i(dfxVar, 4, (btd) bttVarArr[4].getValue(), list);
                    i2 |= 16;
                    dtbVar = dtbVar2;
                    dvoVar4 = dvoVar3;
                    edzVar3 = edzVar2;
                    break;
                case 5:
                    edzVar2 = edzVar3;
                    dvoVar3 = dvoVar4;
                    num3 = (Integer) acmVarP.i(dfxVar, 5, bqj.b, num3);
                    i2 |= 32;
                    dtbVar = dtbVar2;
                    dvoVar4 = dvoVar3;
                    edzVar3 = edzVar2;
                    break;
                case 6:
                    edzVar2 = edzVar3;
                    dvoVar3 = dvoVar4;
                    str5 = (String) acmVarP.i(dfxVar, 6, dnh.b, str5);
                    i2 |= 64;
                    dtbVar = dtbVar2;
                    dvoVar4 = dvoVar3;
                    edzVar3 = edzVar2;
                    break;
                case 7:
                    edzVar2 = edzVar3;
                    dvoVar3 = dvoVar4;
                    dtyVar = (dty) acmVarP.i(dfxVar, 7, dtw.b, dtyVar);
                    i2 |= 128;
                    dtbVar = dtbVar2;
                    dvoVar4 = dvoVar3;
                    edzVar3 = edzVar2;
                    break;
                case 8:
                    edzVar2 = edzVar3;
                    dvoVar3 = dvoVar4;
                    dtbVar = (dtb) acmVarP.i(dfxVar, 8, dsz.b, dtbVar2);
                    i2 |= 256;
                    dvoVar4 = dvoVar3;
                    edzVar3 = edzVar2;
                    break;
                case 9:
                    edzVar2 = edzVar3;
                    dvoVar4 = (dvo) acmVarP.i(dfxVar, 9, dvm.b, dvoVar4);
                    i2 |= 512;
                    dtbVar = dtbVar2;
                    edzVar3 = edzVar2;
                    break;
                case 10:
                    dvoVar = dvoVar4;
                    dzjVar = (dzj) acmVarP.i(dfxVar, 10, dzh.b, dzjVar);
                    i2 |= 1024;
                    dtbVar = dtbVar2;
                    dvoVar4 = dvoVar;
                    break;
                case 11:
                    dvoVar = dvoVar4;
                    egcVar = (egc) acmVarP.i(dfxVar, 11, ega.b, egcVar);
                    i2 |= 2048;
                    dtbVar = dtbVar2;
                    dvoVar4 = dvoVar;
                    break;
                case 12:
                    dvoVar = dvoVar4;
                    duhVar2 = (duh) acmVarP.i(dfxVar, 12, duf.b, duhVar2);
                    i2 |= 4096;
                    dtbVar = dtbVar2;
                    dvoVar4 = dvoVar;
                    break;
                case 13:
                    dvoVar = dvoVar4;
                    edzVar3 = (edz) acmVarP.i(dfxVar, 13, edx.b, edzVar3);
                    i2 |= 8192;
                    dtbVar = dtbVar2;
                    dvoVar4 = dvoVar;
                    break;
                case 14:
                    dvoVar = dvoVar4;
                    num = (Integer) acmVarP.i(dfxVar, 14, bqj.b, num);
                    i2 |= 16384;
                    dtbVar = dtbVar2;
                    dvoVar4 = dvoVar;
                    break;
                case 15:
                    dvoVar = dvoVar4;
                    dvoVar5 = (dvo) acmVarP.i(dfxVar, 15, dvm.b, dvoVar5);
                    i = 32768;
                    i2 |= i;
                    dtbVar = dtbVar2;
                    dvoVar4 = dvoVar;
                    break;
                case 16:
                    dvoVar = dvoVar4;
                    eiqVar = (eiq) acmVarP.i(dfxVar, 16, eio.b, eiqVar);
                    i = 65536;
                    i2 |= i;
                    dtbVar = dtbVar2;
                    dvoVar4 = dvoVar;
                    break;
                case 17:
                    dvoVar = dvoVar4;
                    duzVar = (duz) acmVarP.i(dfxVar, 17, dux.b, duzVar);
                    i = 131072;
                    i2 |= i;
                    dtbVar = dtbVar2;
                    dvoVar4 = dvoVar;
                    break;
                case 18:
                    dvoVar = dvoVar4;
                    eboVar = (ebo) acmVarP.i(dfxVar, 18, ebm.b, eboVar);
                    i = 262144;
                    i2 |= i;
                    dtbVar = dtbVar2;
                    dvoVar4 = dvoVar;
                    break;
                case 19:
                    dvoVar = dvoVar4;
                    dvoVar6 = (dvo) acmVarP.i(dfxVar, 19, dvm.b, dvoVar6);
                    i = Opcodes.ASM8;
                    i2 |= i;
                    dtbVar = dtbVar2;
                    dvoVar4 = dvoVar;
                    break;
                case 20:
                    dvoVar = dvoVar4;
                    eazVar = (eaz) acmVarP.i(dfxVar, 20, eax.b, eazVar);
                    i = 1048576;
                    i2 |= i;
                    dtbVar = dtbVar2;
                    dvoVar4 = dvoVar;
                    break;
                default:
                    throw new bsd(iF);
            }
        }
        edz edzVar4 = edzVar3;
        dvo dvoVar7 = dvoVar4;
        String str6 = str2;
        Integer num4 = num2;
        String str7 = str3;
        acmVarP._bp(dfxVar);
        dzj dzjVar2 = dzjVar;
        return new dss(i2, str6, num4, str7, str4, list, num3, str5, dtyVar, dtbVar, dvoVar7, dzjVar2, egcVar, duhVar2, edzVar4, num, dvoVar5, eiqVar, duzVar, eboVar, dvoVar6, eazVar);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        dss dssVar = (dss) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        btt[] bttVarArr = dss.a;
        dnh dnhVar = dnh.b;
        acnVarO.m(dfxVar, 0, dnhVar, dssVar.b);
        bqj bqjVar = bqj.b;
        acnVarO.m(dfxVar, 1, bqjVar, dssVar.c);
        acnVarO.m(dfxVar, 2, dnhVar, dssVar.d);
        acnVarO.m(dfxVar, 3, dnhVar, dssVar.e);
        acnVarO.m(dfxVar, 4, (btd) bttVarArr[4].getValue(), dssVar.f);
        acnVarO.m(dfxVar, 5, bqjVar, dssVar.g);
        acnVarO.m(dfxVar, 6, dnhVar, dssVar.h);
        acnVarO.m(dfxVar, 7, dtw.b, dssVar.i);
        acnVarO.m(dfxVar, 8, dsz.b, dssVar.j);
        dvm dvmVar = dvm.b;
        acnVarO.m(dfxVar, 9, dvmVar, dssVar.k);
        acnVarO.m(dfxVar, 10, dzh.b, dssVar.l);
        acnVarO.m(dfxVar, 11, ega.b, dssVar.m);
        acnVarO.m(dfxVar, 12, duf.b, dssVar.n);
        acnVarO.m(dfxVar, 13, edx.b, dssVar.o);
        acnVarO.m(dfxVar, 14, bqjVar, dssVar.p);
        acnVarO.m(dfxVar, 15, dvmVar, dssVar.q);
        acnVarO.m(dfxVar, 16, eio.b, dssVar.r);
        acnVarO.m(dfxVar, 17, dux.b, dssVar.s);
        acnVarO.m(dfxVar, 18, ebm.b, dssVar.t);
        acnVarO.m(dfxVar, 19, dvmVar, dssVar.u);
        acnVarO.m(dfxVar, 20, eax.b, dssVar.v);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        btt[] bttVarArr = dss.a;
        dnh dnhVar = dnh.b;
        btd btdVarT = aye.t(dnhVar);
        bqj bqjVar = bqj.b;
        btd btdVarT2 = aye.t(bqjVar);
        btd btdVarT3 = aye.t(dnhVar);
        btd btdVarT4 = aye.t(dnhVar);
        btd btdVarT5 = aye.t((btd) bttVarArr[4].getValue());
        btd btdVarT6 = aye.t(bqjVar);
        btd btdVarT7 = aye.t(dnhVar);
        btd btdVarT8 = aye.t(dtw.b);
        btd btdVarT9 = aye.t(dsz.b);
        dvm dvmVar = dvm.b;
        return new btd[]{btdVarT, btdVarT2, btdVarT3, btdVarT4, btdVarT5, btdVarT6, btdVarT7, btdVarT8, btdVarT9, aye.t(dvmVar), aye.t(dzh.b), aye.t(ega.b), aye.t(duf.b), aye.t(edx.b), aye.t(bqjVar), aye.t(dvmVar), aye.t(eio.b), aye.t(dux.b), aye.t(ebm.b), aye.t(dvmVar), aye.t(eax.b)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
