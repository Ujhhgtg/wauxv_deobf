package me.hd.wauxv.obf;

import net.bytebuddy.jar.asm.Opcodes;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class eao implements bgx {
    public static final eao b;
    private static final dfx descriptor;

    static {
        eao eaoVar = new eao();
        b = eaoVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.mb3Proto" /* "me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.mb3Proto" /* "me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.mb3Proto" /* "me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.mb3Proto" /* cnb.z(-211544319195946L)   */, eaoVar, 21);
        bjs.y(-212837104352042L, cucVar, false, 1);
        bjs.y(-212845694286634L, cucVar, false, 2);
        bjs.y(-212854284221226L, cucVar, false, 3);
        bjs.y(-212794154679082L, cucVar, false, 4);
        bjs.y(-212802744613674L, cucVar, false, 5);
        bjs.y(-212811334548266L, cucVar, false, 6);
        bjs.y(-212819924482858L, cucVar, false, 7);
        bjs.y(-212759794940714L, cucVar, false, 8);
        bjs.y(-212768384875306L, cucVar, false, 9);
        bjs.y(-212776974809898L, cucVar, false, 10);
        bjs.y(-212785564744490L, cucVar, false, 11);
        bjs.y(-213275191016234L, cucVar, false, 12);
        bjs.y(-213283780950826L, cucVar, false, 13);
        bjs.y(-213292370885418L, cucVar, false, 14);
        bjs.y(-213300960820010L, cucVar, false, 15);
        bjs.y(-213240831277866L, cucVar, false, 16);
        bjs.y(-213249421212458L, cucVar, false, 23);
        bjs.y(-213258011147050L, cucVar, false, 24);
        bjs.y(-213266601081642L, cucVar, false, 25);
        bjs.y(-213206471539498L, cucVar, false, 26);
        bjs.y(-213215061474090L, cucVar, false, 27);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        Integer num;
        int i;
        Integer num2;
        Integer num3;
        Integer num4;
        Integer num5;
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        acmVarP.getClass();
        Integer num6 = null;
        Integer num7 = null;
        Integer num8 = null;
        Integer num9 = null;
        Integer num10 = null;
        Integer num11 = null;
        Integer num12 = null;
        ebf ebfVar = null;
        ebf ebfVar2 = null;
        ebf ebfVar3 = null;
        Integer num13 = null;
        ebf ebfVar4 = null;
        Integer num14 = null;
        Integer num15 = null;
        Integer num16 = null;
        Integer num17 = null;
        Integer num18 = null;
        Integer num19 = null;
        Integer num20 = null;
        Integer num21 = null;
        Integer num22 = null;
        int i2 = 0;
        boolean z = true;
        while (z) {
            Integer num23 = num14;
            int iF = acmVarP.f(dfxVar);
            switch (iF) {
                case -1:
                    num2 = num7;
                    num3 = num17;
                    z = false;
                    num8 = num8;
                    num14 = num23;
                    num7 = num2;
                    num17 = num3;
                    break;
                case 0:
                    num2 = num7;
                    num3 = num17;
                    num15 = (Integer) acmVarP.i(dfxVar, 0, bqj.b, num15);
                    i2 |= 1;
                    num8 = num8;
                    num14 = num23;
                    num6 = num6;
                    num7 = num2;
                    num17 = num3;
                    break;
                case 1:
                    num4 = num7;
                    num5 = num6;
                    num16 = (Integer) acmVarP.i(dfxVar, 1, bqj.b, num16);
                    i2 |= 2;
                    num17 = num17;
                    num14 = num23;
                    num6 = num5;
                    num7 = num4;
                    break;
                case 2:
                    num4 = num7;
                    num5 = num6;
                    num17 = (Integer) acmVarP.i(dfxVar, 2, bqj.b, num17);
                    i2 |= 4;
                    num14 = num23;
                    num6 = num5;
                    num7 = num4;
                    break;
                case 3:
                    num4 = num7;
                    num5 = num6;
                    num18 = (Integer) acmVarP.i(dfxVar, 3, bqj.b, num18);
                    i2 |= 8;
                    num14 = num23;
                    num6 = num5;
                    num7 = num4;
                    break;
                case 4:
                    num4 = num7;
                    num5 = num6;
                    num19 = (Integer) acmVarP.i(dfxVar, 4, bqj.b, num19);
                    i2 |= 16;
                    num14 = num23;
                    num6 = num5;
                    num7 = num4;
                    break;
                case 5:
                    num4 = num7;
                    num5 = num6;
                    num20 = (Integer) acmVarP.i(dfxVar, 5, bqj.b, num20);
                    i2 |= 32;
                    num14 = num23;
                    num6 = num5;
                    num7 = num4;
                    break;
                case 6:
                    num4 = num7;
                    num5 = num6;
                    num21 = (Integer) acmVarP.i(dfxVar, 6, bqj.b, num21);
                    i2 |= 64;
                    num14 = num23;
                    num6 = num5;
                    num7 = num4;
                    break;
                case 7:
                    num4 = num7;
                    num5 = num6;
                    num22 = (Integer) acmVarP.i(dfxVar, 7, bqj.b, num22);
                    i2 |= 128;
                    num14 = num23;
                    num6 = num5;
                    num7 = num4;
                    break;
                case 8:
                    num4 = num7;
                    num5 = num6;
                    num14 = (Integer) acmVarP.i(dfxVar, 8, bqj.b, num23);
                    i2 |= 256;
                    num6 = num5;
                    num7 = num4;
                    break;
                case 9:
                    num4 = num7;
                    num6 = (Integer) acmVarP.i(dfxVar, 9, bqj.b, num6);
                    i2 |= 512;
                    num14 = num23;
                    num7 = num4;
                    break;
                case 10:
                    num = num6;
                    num9 = (Integer) acmVarP.i(dfxVar, 10, bqj.b, num9);
                    i2 |= 1024;
                    num14 = num23;
                    num6 = num;
                    break;
                case 11:
                    num = num6;
                    num10 = (Integer) acmVarP.i(dfxVar, 11, bqj.b, num10);
                    i2 |= 2048;
                    num14 = num23;
                    num6 = num;
                    break;
                case 12:
                    num = num6;
                    num8 = (Integer) acmVarP.i(dfxVar, 12, bqj.b, num8);
                    i2 |= 4096;
                    num14 = num23;
                    num6 = num;
                    break;
                case 13:
                    num = num6;
                    num7 = (Integer) acmVarP.i(dfxVar, 13, bqj.b, num7);
                    i2 |= 8192;
                    num14 = num23;
                    num6 = num;
                    break;
                case 14:
                    num = num6;
                    num11 = (Integer) acmVarP.i(dfxVar, 14, bqj.b, num11);
                    i2 |= 16384;
                    num14 = num23;
                    num6 = num;
                    break;
                case 15:
                    num = num6;
                    num12 = (Integer) acmVarP.i(dfxVar, 15, bqj.b, num12);
                    i = 32768;
                    i2 |= i;
                    num14 = num23;
                    num6 = num;
                    break;
                case 16:
                    num = num6;
                    ebfVar = (ebf) acmVarP.i(dfxVar, 16, ebd.b, ebfVar);
                    i = 65536;
                    i2 |= i;
                    num14 = num23;
                    num6 = num;
                    break;
                case 17:
                    num = num6;
                    ebfVar2 = (ebf) acmVarP.i(dfxVar, 17, ebd.b, ebfVar2);
                    i = 131072;
                    i2 |= i;
                    num14 = num23;
                    num6 = num;
                    break;
                case 18:
                    num = num6;
                    ebfVar3 = (ebf) acmVarP.i(dfxVar, 18, ebd.b, ebfVar3);
                    i = 262144;
                    i2 |= i;
                    num14 = num23;
                    num6 = num;
                    break;
                case 19:
                    num = num6;
                    num13 = (Integer) acmVarP.i(dfxVar, 19, bqj.b, num13);
                    i = Opcodes.ASM8;
                    i2 |= i;
                    num14 = num23;
                    num6 = num;
                    break;
                case 20:
                    num = num6;
                    ebfVar4 = (ebf) acmVarP.i(dfxVar, 20, ebd.b, ebfVar4);
                    i = 1048576;
                    i2 |= i;
                    num14 = num23;
                    num6 = num;
                    break;
                default:
                    throw new bsd(iF);
            }
        }
        Integer num24 = num7;
        Integer num25 = num14;
        Integer num26 = num15;
        Integer num27 = num16;
        Integer num28 = num17;
        acmVarP._bp(dfxVar);
        Integer num29 = num10;
        return new eaq(i2, num26, num27, num28, num18, num19, num20, num21, num22, num25, num6, num9, num29, num8, num24, num11, num12, ebfVar, ebfVar2, ebfVar3, num13, ebfVar4);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        eaq eaqVar = (eaq) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        bqj bqjVar = bqj.b;
        acnVarO.m(dfxVar, 0, bqjVar, eaqVar.a);
        acnVarO.m(dfxVar, 1, bqjVar, eaqVar.b);
        acnVarO.m(dfxVar, 2, bqjVar, eaqVar.c);
        acnVarO.m(dfxVar, 3, bqjVar, eaqVar.d);
        acnVarO.m(dfxVar, 4, bqjVar, eaqVar.e);
        acnVarO.m(dfxVar, 5, bqjVar, eaqVar.f);
        acnVarO.m(dfxVar, 6, bqjVar, eaqVar.g);
        acnVarO.m(dfxVar, 7, bqjVar, eaqVar.h);
        acnVarO.m(dfxVar, 8, bqjVar, eaqVar.i);
        acnVarO.m(dfxVar, 9, bqjVar, eaqVar.j);
        acnVarO.m(dfxVar, 10, bqjVar, eaqVar.k);
        acnVarO.m(dfxVar, 11, bqjVar, eaqVar.l);
        acnVarO.m(dfxVar, 12, bqjVar, eaqVar.m);
        acnVarO.m(dfxVar, 13, bqjVar, eaqVar.n);
        acnVarO.m(dfxVar, 14, bqjVar, eaqVar.o);
        acnVarO.m(dfxVar, 15, bqjVar, eaqVar.p);
        ebd ebdVar = ebd.b;
        acnVarO.m(dfxVar, 16, ebdVar, eaqVar.q);
        acnVarO.m(dfxVar, 17, ebdVar, eaqVar.r);
        acnVarO.m(dfxVar, 18, ebdVar, eaqVar.s);
        acnVarO.m(dfxVar, 19, bqjVar, eaqVar.t);
        acnVarO.m(dfxVar, 20, ebdVar, eaqVar.u);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        bqj bqjVar = bqj.b;
        btd btdVarT = aye.t(bqjVar);
        btd btdVarT2 = aye.t(bqjVar);
        btd btdVarT3 = aye.t(bqjVar);
        btd btdVarT4 = aye.t(bqjVar);
        btd btdVarT5 = aye.t(bqjVar);
        btd btdVarT6 = aye.t(bqjVar);
        btd btdVarT7 = aye.t(bqjVar);
        btd btdVarT8 = aye.t(bqjVar);
        btd btdVarT9 = aye.t(bqjVar);
        btd btdVarT10 = aye.t(bqjVar);
        btd btdVarT11 = aye.t(bqjVar);
        btd btdVarT12 = aye.t(bqjVar);
        btd btdVarT13 = aye.t(bqjVar);
        btd btdVarT14 = aye.t(bqjVar);
        btd btdVarT15 = aye.t(bqjVar);
        btd btdVarT16 = aye.t(bqjVar);
        ebd ebdVar = ebd.b;
        return new btd[]{btdVarT, btdVarT2, btdVarT3, btdVarT4, btdVarT5, btdVarT6, btdVarT7, btdVarT8, btdVarT9, btdVarT10, btdVarT11, btdVarT12, btdVarT13, btdVarT14, btdVarT15, btdVarT16, aye.t(ebdVar), aye.t(ebdVar), aye.t(ebdVar), aye.t(bqjVar), aye.t(ebdVar)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
