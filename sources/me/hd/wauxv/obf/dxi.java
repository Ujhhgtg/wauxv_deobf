package me.hd.wauxv.obf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class dxi implements bgx {
    public static final dxi b;
    private static final dfx descriptor;

    static {
        dxi dxiVar = new dxi();
        b = dxiVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.ff1Proto" /*
                                                                                                               * cnb.z(-
                                                                                                               * 190202626702122L)
                                                                                                               */,
                dxiVar, 7);
        bjs.y(-189313568471850L, cucVar, false, 1);
        bjs.y(-189227669125930L, cucVar, false, 2);
        bjs.y(-189193309387562L, cucVar, false, 3);
        bjs.y(-189124589910826L, cucVar, false, 4);
        bjs.y(-189657165855530L, cucVar, false, 5);
        bjs.y(-189609921215274L, cucVar, false, 6);
        bjs.y(-189549791673130L, cucVar, false, 7);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        IHasGetValue[] bttVarArr = dxk.a;
        acmVarP.getClass();
        int i = 0;
        String str = null;
        Long l = null;
        String str2 = null;
        dyu dyuVar = null;
        Integer num = null;
        List list = null;
        Integer num2 = null;
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
                    l = (Long) acmVarP.i(dfxVar, 1, bya.b, l);
                    i |= 2;
                    break;
                case 2:
                    str2 = (String) acmVarP.i(dfxVar, 2, dnh.b, str2);
                    i |= 4;
                    break;
                case 3:
                    dyuVar = (dyu) acmVarP.i(dfxVar, 3, dys.b, dyuVar);
                    i |= 8;
                    break;
                case 4:
                    num = (Integer) acmVarP.i(dfxVar, 4, bqj.b, num);
                    i |= 16;
                    break;
                case 5:
                    list = (List) acmVarP.i(dfxVar, 5, (btd) bttVarArr[5].getValue(), list);
                    i |= 32;
                    break;
                case 6:
                    num2 = (Integer) acmVarP.i(dfxVar, 6, bqj.b, num2);
                    i |= 64;
                    break;
                default:
                    throw new bsd(iF);
            }
        }
        acmVarP._bp(dfxVar);
        return new dxk(i, str, l, str2, dyuVar, num, list, num2);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        dxk dxkVar = (dxk) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        IHasGetValue[] bttVarArr = dxk.a;
        dnh dnhVar = dnh.b;
        acnVarO.m(dfxVar, 0, dnhVar, dxkVar.b);
        acnVarO.m(dfxVar, 1, bya.b, dxkVar.c);
        acnVarO.m(dfxVar, 2, dnhVar, dxkVar.d);
        acnVarO.m(dfxVar, 3, dys.b, dxkVar.e);
        bqj bqjVar = bqj.b;
        acnVarO.m(dfxVar, 4, bqjVar, dxkVar.f);
        acnVarO.m(dfxVar, 5, (btd) bttVarArr[5].getValue(), dxkVar.g);
        acnVarO.m(dfxVar, 6, bqjVar, dxkVar.h);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        IHasGetValue[] bttVarArr = dxk.a;
        dnh dnhVar = dnh.b;
        btd btdVarT = aye.t(dnhVar);
        btd btdVarT2 = aye.t(bya.b);
        btd btdVarT3 = aye.t(dnhVar);
        btd btdVarT4 = aye.t(dys.b);
        bqj bqjVar = bqj.b;
        return new btd[] { btdVarT, btdVarT2, btdVarT3, btdVarT4, aye.t(bqjVar), aye.t((btd) bttVarArr[5].getValue()),
                aye.t(bqjVar) };
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
