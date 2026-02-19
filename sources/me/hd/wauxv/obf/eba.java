package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class eba implements bgx {
    public static final eba b;
    private static final dfx descriptor;

    static {
        eba ebaVar = new eba();
        b = ebaVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.mk1Proto" /* "me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.mk1Proto" /* "me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.mk1Proto" /* cnb.z(-229832289942314L)  */, ebaVar, 14);
        bjs.y(-236072877423402L, cucVar, false, 1);
        bjs.y(-235961208273706L, cucVar, false, 2);
        bjs.y(-235939733437226L, cucVar, false, 3);
        bjs.y(-235862424025898L, cucVar, false, 4);
        bjs.y(-236356345264938L, cucVar, false, 5);
        bjs.y(-236244676115242L, cucVar, false, 6);
        bjs.y(-235553186380586L, cucVar, false, 7);
        bjs.y(-235402862525226L, cucVar, false, 8);
        bjs.y(-235347027950378L, cucVar, false, 9);
        bjs.y(-235845244156714L, cucVar, false, 10);
        bjs.y(-235733575007018L, cucVar, false, 11);
        bjs.y(-235647675661098L, cucVar, false, 12);
        bjs.y(-235639085726506L, cucVar, false, 15);
        bjs.y(-237163799116586L, cucVar, false, 17);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        Integer num;
        Long l;
        Integer num2;
        Long l2;
        Long l3;
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        acmVarP.getClass();
        String str = null;
        Long l4 = null;
        Long l5 = null;
        String str2 = null;
        String str3 = null;
        Long l6 = null;
        Integer num3 = null;
        Integer num4 = null;
        String str4 = null;
        ebu ebuVar = null;
        ecp ecpVar = null;
        ehs ehsVar = null;
        ehs ehsVar2 = null;
        Integer num5 = null;
        int i = 0;
        boolean z = true;
        while (z) {
            Long l7 = l6;
            int iF = acmVarP.f(dfxVar);
            switch (iF) {
                case -1:
                    l = l4;
                    num2 = num3;
                    l2 = l7;
                    l3 = l5;
                    z = false;
                    l6 = l2;
                    l5 = l3;
                    num3 = num2;
                    l4 = l;
                    break;
                case 0:
                    l = l4;
                    num2 = num3;
                    l2 = l7;
                    l3 = l5;
                    num5 = (Integer) acmVarP.i(dfxVar, 0, bqj.b, num5);
                    i |= 1;
                    l6 = l2;
                    l5 = l3;
                    num3 = num2;
                    l4 = l;
                    break;
                case 1:
                    l = l4;
                    num2 = num3;
                    l6 = (Long) acmVarP.i(dfxVar, 1, bya.b, l7);
                    i |= 2;
                    num3 = num2;
                    l4 = l;
                    break;
                case 2:
                    l = l4;
                    num3 = (Integer) acmVarP.i(dfxVar, 2, bqj.b, num3);
                    i |= 4;
                    l6 = l7;
                    l4 = l;
                    break;
                case 3:
                    num = num3;
                    num4 = (Integer) acmVarP.i(dfxVar, 3, bqj.b, num4);
                    i |= 8;
                    l6 = l7;
                    num3 = num;
                    break;
                case 4:
                    num = num3;
                    str4 = (String) acmVarP.i(dfxVar, 4, dnh.b, str4);
                    i |= 16;
                    l6 = l7;
                    num3 = num;
                    break;
                case 5:
                    num = num3;
                    ebuVar = (ebu) acmVarP.i(dfxVar, 5, ebs.b, ebuVar);
                    i |= 32;
                    l6 = l7;
                    num3 = num;
                    break;
                case 6:
                    num = num3;
                    ecpVar = (ecp) acmVarP.i(dfxVar, 6, ecn.b, ecpVar);
                    i |= 64;
                    l6 = l7;
                    num3 = num;
                    break;
                case 7:
                    num = num3;
                    ehsVar = (ehs) acmVarP.i(dfxVar, 7, ehq.b, ehsVar);
                    i |= 128;
                    l6 = l7;
                    num3 = num;
                    break;
                case 8:
                    num = num3;
                    ehsVar2 = (ehs) acmVarP.i(dfxVar, 8, ehq.b, ehsVar2);
                    i |= 256;
                    l6 = l7;
                    num3 = num;
                    break;
                case 9:
                    num = num3;
                    str = (String) acmVarP.i(dfxVar, 9, dnh.b, str);
                    i |= 512;
                    l6 = l7;
                    num3 = num;
                    break;
                case 10:
                    num = num3;
                    str2 = (String) acmVarP.i(dfxVar, 10, dnh.b, str2);
                    i |= 1024;
                    l6 = l7;
                    num3 = num;
                    break;
                case 11:
                    num = num3;
                    str3 = (String) acmVarP.i(dfxVar, 11, dnh.b, str3);
                    i |= 2048;
                    l6 = l7;
                    num3 = num;
                    break;
                case 12:
                    num = num3;
                    l5 = (Long) acmVarP.i(dfxVar, 12, bya.b, l5);
                    i |= 4096;
                    l6 = l7;
                    num3 = num;
                    break;
                case 13:
                    num = num3;
                    l4 = (Long) acmVarP.i(dfxVar, 13, bya.b, l4);
                    i |= 8192;
                    l6 = l7;
                    num3 = num;
                    break;
                default:
                    throw new bsd(iF);
            }
        }
        Long l8 = l4;
        Integer num6 = num3;
        Integer num7 = num5;
        acmVarP._bp(dfxVar);
        return new ebc(i, num7, l6, num6, num4, str4, ebuVar, ecpVar, ehsVar, ehsVar2, str, str2, str3, l5, l8);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        ebc ebcVar = (ebc) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        bqj bqjVar = bqj.b;
        acnVarO.m(dfxVar, 0, bqjVar, ebcVar.a);
        bya byaVar = bya.b;
        acnVarO.m(dfxVar, 1, byaVar, ebcVar.b);
        acnVarO.m(dfxVar, 2, bqjVar, ebcVar.c);
        acnVarO.m(dfxVar, 3, bqjVar, ebcVar.d);
        dnh dnhVar = dnh.b;
        acnVarO.m(dfxVar, 4, dnhVar, ebcVar.e);
        acnVarO.m(dfxVar, 5, ebs.b, ebcVar.f);
        acnVarO.m(dfxVar, 6, ecn.b, ebcVar.g);
        ehq ehqVar = ehq.b;
        acnVarO.m(dfxVar, 7, ehqVar, ebcVar.h);
        acnVarO.m(dfxVar, 8, ehqVar, ebcVar.i);
        acnVarO.m(dfxVar, 9, dnhVar, ebcVar.j);
        acnVarO.m(dfxVar, 10, dnhVar, ebcVar.k);
        acnVarO.m(dfxVar, 11, dnhVar, ebcVar.l);
        acnVarO.m(dfxVar, 12, byaVar, ebcVar.m);
        acnVarO.m(dfxVar, 13, byaVar, ebcVar.n);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        bqj bqjVar = bqj.b;
        btd btdVarT = aye.t(bqjVar);
        bya byaVar = bya.b;
        btd btdVarT2 = aye.t(byaVar);
        btd btdVarT3 = aye.t(bqjVar);
        btd btdVarT4 = aye.t(bqjVar);
        dnh dnhVar = dnh.b;
        btd btdVarT5 = aye.t(dnhVar);
        btd btdVarT6 = aye.t(ebs.b);
        btd btdVarT7 = aye.t(ecn.b);
        ehq ehqVar = ehq.b;
        return new btd[]{btdVarT, btdVarT2, btdVarT3, btdVarT4, btdVarT5, btdVarT6, btdVarT7, aye.t(ehqVar), aye.t(ehqVar), aye.t(dnhVar), aye.t(dnhVar), aye.t(dnhVar), aye.t(byaVar), aye.t(byaVar)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
