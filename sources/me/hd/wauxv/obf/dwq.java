package me.hd.wauxv.obf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class dwq implements bgx {
    public static final dwq b;
    private static final dfx descriptor;

    static {
        dwq dwqVar = new dwq();
        b = dwqVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.dc5Proto" /*
                                                                                                               * cnb.z(-
                                                                                                               * 165154377431850L)
                                                                                                               */,
                dwqVar, 6);
        bjs.y(-165364830829354L, cucVar, false, 1);
        bjs.y(-165253161679658L, cucVar, false, 2);
        bjs.y(-166833709644586L, cucVar, false, 3);
        bjs.y(-166760695200554L, cucVar, false, 4);
        bjs.y(-166743515331370L, cucVar, false, 5);
        bjs.y(-166636141148970L, cucVar, false, 6);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        IHasGetValue[] bttVarArr = dws.a;
        acmVarP.getClass();
        int i = 0;
        List list = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        Boolean bool = null;
        String str4 = null;
        boolean z = true;
        while (z) {
            int iF = acmVarP.f(dfxVar);
            switch (iF) {
                case -1:
                    z = false;
                    break;
                case 0:
                    list = (List) acmVarP.i(dfxVar, 0, (btd) bttVarArr[0].getValue(), list);
                    i |= 1;
                    break;
                case 1:
                    str = (String) acmVarP.i(dfxVar, 1, dnh.b, str);
                    i |= 2;
                    break;
                case 2:
                    str2 = (String) acmVarP.i(dfxVar, 2, dnh.b, str2);
                    i |= 4;
                    break;
                case 3:
                    str3 = (String) acmVarP.i(dfxVar, 3, dnh.b, str3);
                    i |= 8;
                    break;
                case 4:
                    bool = (Boolean) acmVarP.i(dfxVar, 4, pv.b, bool);
                    i |= 16;
                    break;
                case 5:
                    str4 = (String) acmVarP.i(dfxVar, 5, dnh.b, str4);
                    i |= 32;
                    break;
                default:
                    throw new bsd(iF);
            }
        }
        acmVarP._bp(dfxVar);
        return new dws(i, list, str, str2, str3, bool, str4);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        dws dwsVar = (dws) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        acnVarO.m(dfxVar, 0, (btd) dws.a[0].getValue(), dwsVar.b);
        dnh dnhVar = dnh.b;
        acnVarO.m(dfxVar, 1, dnhVar, dwsVar.c);
        acnVarO.m(dfxVar, 2, dnhVar, dwsVar.d);
        acnVarO.m(dfxVar, 3, dnhVar, dwsVar.e);
        acnVarO.m(dfxVar, 4, pv.b, dwsVar.f);
        acnVarO.m(dfxVar, 5, dnhVar, dwsVar.g);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        btd btdVarT = aye.t((btd) dws.a[0].getValue());
        dnh dnhVar = dnh.b;
        return new btd[] { btdVarT, aye.t(dnhVar), aye.t(dnhVar), aye.t(dnhVar), aye.t(pv.b), aye.t(dnhVar) };
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
