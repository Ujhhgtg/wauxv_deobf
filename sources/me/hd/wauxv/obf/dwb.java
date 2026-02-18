package me.hd.wauxv.obf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class dwb implements bgx {
    public static final dwb b;
    private static final dfx descriptor;

    static {
        dwb dwbVar = new dwb();
        b = dwbVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.cf1Proto" /*
                                                                                                               * cnb.z(-
                                                                                                               * 174994147506986L)
                                                                                                               */,
                dwbVar, 1);
        bjs.y(-175187421035306L, cucVar, false, 1);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        IHasGetValue[] bttVarArr = dwd.a;
        acmVarP.getClass();
        List list = null;
        boolean z = true;
        int i = 0;
        while (z) {
            int iF = acmVarP.f(dfxVar);
            if (iF == -1) {
                z = false;
            } else {
                if (iF != 0) {
                    throw new bsd(iF);
                }
                list = (List) acmVarP.i(dfxVar, 0, (btd) bttVarArr[0].getValue(), list);
                i = 1;
            }
        }
        acmVarP._bp(dfxVar);
        return new dwd(i, list);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        acnVarO.m(dfxVar, 0, (btd) dwd.a[0].getValue(), ((dwd) obj).b);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        return new btd[] { aye.t((btd) dwd.a[0].getValue()) };
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
