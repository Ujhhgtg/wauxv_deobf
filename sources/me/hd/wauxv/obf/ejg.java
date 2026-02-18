package me.hd.wauxv.obf;

import net.bytebuddy.jar.asm.Opcodes;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ejg implements bgx {
    public static final ejg b;
    private static final dfx descriptor;

    static {
        ejg ejgVar = new ejg();
        b = ejgVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.z52Proto" /* cnb.z(-322874166475562L) */, ejgVar, 24);
        bjs.y(-323084619873066L, cucVar, false, 1);
        bjs.y(-323041670200106L, cucVar, false, 2);
        bjs.y(-323007310461738L, cucVar, false, 3);
        bjs.y(-322431784844074L, cucVar, false, 4);
        bjs.y(-322341590530858L, cucVar, false, 5);
        bjs.y(-322315820727082L, cucVar, false, 6);
        bjs.y(-322234216348458L, cucVar, false, 7);
        bjs.y(-322195561642794L, cucVar, false, 8);
        bjs.y(-322685187914538L, cucVar, false, 9);
        bjs.y(-322659418110762L, cucVar, false, 10);
        bjs.y(-322633648306986L, cucVar, false, 11);
        bjs.y(-322552043928362L, cucVar, false, 12);
        bjs.y(-322530569091882L, cucVar, false, 13);
        bjs.y(-322466144582442L, cucVar, false, 14);
        bjs.y(-345951025756970L, cucVar, false, 15);
        bjs.y(-345925255953194L, cucVar, false, 16);
        bjs.y(-345835061639978L, cucVar, false, 17);
        bjs.y(-345860831443754L, cucVar, false, 18);
        bjs.y(-346328982879018L, cucVar, false, 19);
        bjs.y(-346290328173354L, cucVar, false, 20);
        bjs.y(-346273148304170L, cucVar, false, 21);
        bjs.y(-346195838892842L, cucVar, false, 22);
        bjs.y(-346131414383402L, cucVar, false, 23);
        bjs.y(-345512939092778L, cucVar, false, 24);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        ehm ehmVar;
        int i;
        Integer num;
        String str;
        ehm ehmVar2;
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        acmVarP.getClass();
        dyx dyxVar = null;
        Integer num2 = null;
        ehm ehmVar3 = null;
        Integer num3 = null;
        dxe dxeVar = null;
        Integer num4 = null;
        efz efzVar = null;
        Integer num5 = null;
        String str2 = null;
        eah eahVar = null;
        eiz eizVar = null;
        dyo dyoVar = null;
        ede edeVar = null;
        String str3 = null;
        Long l = null;
        Integer num6 = null;
        String str4 = null;
        Integer num7 = null;
        Integer num8 = null;
        String str5 = null;
        Integer num9 = null;
        Integer num10 = null;
        Integer num11 = null;
        dyi dyiVar = null;
        int i2 = 0;
        boolean z = true;
        while (z) {
            Integer num12 = num3;
            int iF = acmVarP.f(dfxVar);
            switch (iF) {
                case -1:
                    num = num2;
                    str = str3;
                    z = false;
                    dyxVar = dyxVar;
                    num3 = num12;
                    str3 = str;
                    num2 = num;
                    break;
                case 0:
                    num = num2;
                    str = (String) acmVarP.i(dfxVar, 0, dnh.b, str3);
                    i2 |= 1;
                    dyxVar = dyxVar;
                    num3 = num12;
                    ehmVar3 = ehmVar3;
                    str3 = str;
                    num2 = num;
                    break;
                case 1:
                    num = num2;
                    ehmVar2 = ehmVar3;
                    l = (Long) acmVarP.i(dfxVar, 1, bya.b, l);
                    i2 |= 2;
                    num6 = num6;
                    num3 = num12;
                    ehmVar3 = ehmVar2;
                    num2 = num;
                    break;
                case 2:
                    num = num2;
                    ehmVar2 = ehmVar3;
                    num6 = (Integer) acmVarP.i(dfxVar, 2, bqj.b, num6);
                    i2 |= 4;
                    num3 = num12;
                    ehmVar3 = ehmVar2;
                    num2 = num;
                    break;
                case 3:
                    num = num2;
                    ehmVar2 = ehmVar3;
                    str4 = (String) acmVarP.i(dfxVar, 3, dnh.b, str4);
                    i2 |= 8;
                    num3 = num12;
                    ehmVar3 = ehmVar2;
                    num2 = num;
                    break;
                case 4:
                    num = num2;
                    ehmVar2 = ehmVar3;
                    num7 = (Integer) acmVarP.i(dfxVar, 4, bqj.b, num7);
                    i2 |= 16;
                    num3 = num12;
                    ehmVar3 = ehmVar2;
                    num2 = num;
                    break;
                case 5:
                    num = num2;
                    ehmVar2 = ehmVar3;
                    num8 = (Integer) acmVarP.i(dfxVar, 5, bqj.b, num8);
                    i2 |= 32;
                    num3 = num12;
                    ehmVar3 = ehmVar2;
                    num2 = num;
                    break;
                case 6:
                    num = num2;
                    ehmVar2 = ehmVar3;
                    str5 = (String) acmVarP.i(dfxVar, 6, dnh.b, str5);
                    i2 |= 64;
                    num3 = num12;
                    ehmVar3 = ehmVar2;
                    num2 = num;
                    break;
                case 7:
                    num = num2;
                    ehmVar2 = ehmVar3;
                    num9 = (Integer) acmVarP.i(dfxVar, 7, bqj.b, num9);
                    i2 |= 128;
                    num3 = num12;
                    ehmVar3 = ehmVar2;
                    num2 = num;
                    break;
                case 8:
                    num = num2;
                    ehmVar2 = ehmVar3;
                    num10 = (Integer) acmVarP.i(dfxVar, 8, bqj.b, num10);
                    i2 |= 256;
                    num3 = num12;
                    ehmVar3 = ehmVar2;
                    num2 = num;
                    break;
                case 9:
                    num = num2;
                    ehmVar2 = ehmVar3;
                    num11 = (Integer) acmVarP.i(dfxVar, 9, bqj.b, num11);
                    i2 |= 512;
                    num3 = num12;
                    ehmVar3 = ehmVar2;
                    num2 = num;
                    break;
                case 10:
                    num = num2;
                    ehmVar2 = ehmVar3;
                    dyiVar = (dyi) acmVarP.i(dfxVar, 10, dyg.b, dyiVar);
                    i2 |= 1024;
                    num3 = num12;
                    ehmVar3 = ehmVar2;
                    num2 = num;
                    break;
                case 11:
                    num = num2;
                    ehmVar2 = ehmVar3;
                    num3 = (Integer) acmVarP.i(dfxVar, 11, bqj.b, num12);
                    i2 |= 2048;
                    ehmVar3 = ehmVar2;
                    num2 = num;
                    break;
                case 12:
                    num = num2;
                    ehmVar3 = (ehm) acmVarP.i(dfxVar, 12, ehk.b, ehmVar3);
                    i2 |= 4096;
                    num3 = num12;
                    num2 = num;
                    break;
                case 13:
                    ehmVar = ehmVar3;
                    num2 = (Integer) acmVarP.i(dfxVar, 13, bqj.b, num2);
                    i2 |= 8192;
                    num3 = num12;
                    ehmVar3 = ehmVar;
                    break;
                case 14:
                    ehmVar = ehmVar3;
                    dxeVar = (dxe) acmVarP.i(dfxVar, 14, dxc.b, dxeVar);
                    i2 |= 16384;
                    num3 = num12;
                    ehmVar3 = ehmVar;
                    break;
                case 15:
                    ehmVar = ehmVar3;
                    num4 = (Integer) acmVarP.i(dfxVar, 15, bqj.b, num4);
                    i = 32768;
                    i2 |= i;
                    num3 = num12;
                    ehmVar3 = ehmVar;
                    break;
                case 16:
                    ehmVar = ehmVar3;
                    efzVar = (efz) acmVarP.i(dfxVar, 16, efx.b, efzVar);
                    i = 65536;
                    i2 |= i;
                    num3 = num12;
                    ehmVar3 = ehmVar;
                    break;
                case 17:
                    ehmVar = ehmVar3;
                    num5 = (Integer) acmVarP.i(dfxVar, 17, bqj.b, num5);
                    i = 131072;
                    i2 |= i;
                    num3 = num12;
                    ehmVar3 = ehmVar;
                    break;
                case 18:
                    ehmVar = ehmVar3;
                    str2 = (String) acmVarP.i(dfxVar, 18, dnh.b, str2);
                    i = 262144;
                    i2 |= i;
                    num3 = num12;
                    ehmVar3 = ehmVar;
                    break;
                case 19:
                    ehmVar = ehmVar3;
                    eahVar = (eah) acmVarP.i(dfxVar, 19, eaf.b, eahVar);
                    i = Opcodes.ASM8;
                    i2 |= i;
                    num3 = num12;
                    ehmVar3 = ehmVar;
                    break;
                case 20:
                    ehmVar = ehmVar3;
                    eizVar = (eiz) acmVarP.i(dfxVar, 20, eix.b, eizVar);
                    i = 1048576;
                    i2 |= i;
                    num3 = num12;
                    ehmVar3 = ehmVar;
                    break;
                case 21:
                    ehmVar = ehmVar3;
                    dyoVar = (dyo) acmVarP.i(dfxVar, 21, dym.b, dyoVar);
                    i = 2097152;
                    i2 |= i;
                    num3 = num12;
                    ehmVar3 = ehmVar;
                    break;
                case 22:
                    ehmVar = ehmVar3;
                    edeVar = (ede) acmVarP.i(dfxVar, 22, edc.b, edeVar);
                    i = 4194304;
                    i2 |= i;
                    num3 = num12;
                    ehmVar3 = ehmVar;
                    break;
                case 23:
                    ehmVar = ehmVar3;
                    dyxVar = (dyx) acmVarP.i(dfxVar, 23, dyv.b, dyxVar);
                    i = 8388608;
                    i2 |= i;
                    num3 = num12;
                    ehmVar3 = ehmVar;
                    break;
                default:
                    throw new bsd(iF);
            }
        }
        Integer num13 = num2;
        Integer num14 = num3;
        String str6 = str3;
        Long l2 = l;
        Integer num15 = num6;
        acmVarP._bp(dfxVar);
        ede edeVar2 = edeVar;
        dyi dyiVar2 = dyiVar;
        dyo dyoVar2 = dyoVar;
        return new eji(i2, str6, l2, num15, str4, num7, num8, str5, num9, num10, num11, dyiVar2, num14, ehmVar3, num13, dxeVar, num4, efzVar, num5, str2, eahVar, eizVar, dyoVar2, edeVar2, dyxVar);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        eji ejiVar = (eji) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        dnh dnhVar = dnh.b;
        acnVarO.m(dfxVar, 0, dnhVar, ejiVar.a);
        acnVarO.m(dfxVar, 1, bya.b, ejiVar.b);
        bqj bqjVar = bqj.b;
        acnVarO.m(dfxVar, 2, bqjVar, ejiVar.c);
        acnVarO.m(dfxVar, 3, dnhVar, ejiVar.d);
        acnVarO.m(dfxVar, 4, bqjVar, ejiVar.e);
        acnVarO.m(dfxVar, 5, bqjVar, ejiVar.f);
        acnVarO.m(dfxVar, 6, dnhVar, ejiVar.g);
        acnVarO.m(dfxVar, 7, bqjVar, ejiVar.h);
        acnVarO.m(dfxVar, 8, bqjVar, ejiVar.i);
        acnVarO.m(dfxVar, 9, bqjVar, ejiVar.j);
        acnVarO.m(dfxVar, 10, dyg.b, ejiVar.k);
        acnVarO.m(dfxVar, 11, bqjVar, ejiVar.l);
        acnVarO.m(dfxVar, 12, ehk.b, ejiVar.m);
        acnVarO.m(dfxVar, 13, bqjVar, ejiVar.n);
        acnVarO.m(dfxVar, 14, dxc.b, ejiVar.o);
        acnVarO.m(dfxVar, 15, bqjVar, ejiVar.p);
        acnVarO.m(dfxVar, 16, efx.b, ejiVar.q);
        acnVarO.m(dfxVar, 17, bqjVar, ejiVar.r);
        acnVarO.m(dfxVar, 18, dnhVar, ejiVar.s);
        acnVarO.m(dfxVar, 19, eaf.b, ejiVar.t);
        acnVarO.m(dfxVar, 20, eix.b, ejiVar.u);
        acnVarO.m(dfxVar, 21, dym.b, ejiVar.v);
        acnVarO.m(dfxVar, 22, edc.b, ejiVar.w);
        acnVarO.m(dfxVar, 23, dyv.b, ejiVar.x);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        dnh dnhVar = dnh.b;
        btd btdVarT = aye.t(dnhVar);
        btd btdVarT2 = aye.t(bya.b);
        bqj bqjVar = bqj.b;
        return new btd[]{btdVarT, btdVarT2, aye.t(bqjVar), aye.t(dnhVar), aye.t(bqjVar), aye.t(bqjVar), aye.t(dnhVar), aye.t(bqjVar), aye.t(bqjVar), aye.t(bqjVar), aye.t(dyg.b), aye.t(bqjVar), aye.t(ehk.b), aye.t(bqjVar), aye.t(dxc.b), aye.t(bqjVar), aye.t(efx.b), aye.t(bqjVar), aye.t(dnhVar), aye.t(eaf.b), aye.t(eix.b), aye.t(dym.b), aye.t(edc.b), aye.t(dyv.b)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
