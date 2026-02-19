package me.hd.wauxv.obf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class cnr implements bgx {
    public static final cnr b;
    private static final dfx descriptor;

    static {
        cnr cnrVar = new cnr();
        b = cnrVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.NewSendMsgProto" /*
                                                                                                  * cnb.z(-
                                                                                                  * 130657200110378L)
                                                                                                  */, cnrVar, 3);
        cucVar.x("baseResponse" /* "baseResponse" /* "baseResponse" /* cnb.z(-129841156324138L)  */, false);
        cucVar.y(new aoz(1, 6));
        cucVar.x("count" /* "count" /* "count" /* cnb.z(-129768141880106L)  */, false);
        cucVar.y(new aoz(2, 6));
        cucVar.x("list" /* "list" /* "list" /* cnb.z(-130274948021034L)  */, false);
        cucVar.y(new aoz(3, 6));
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        IHasGetValue[] bttVarArr = cnw.a;
        acmVarP.getClass();
        nm nmVar = null;
        boolean z = true;
        int i = 0;
        int iG = 0;
        List list = null;
        while (z) {
            int iF = acmVarP.f(dfxVar);
            if (iF == -1) {
                z = false;
            } else if (iF == 0) {
                nmVar = (nm) acmVarP.h(dfxVar, 0, nk.b, nmVar);
                i |= 1;
            } else if (iF == 1) {
                iG = acmVarP.g(dfxVar, 1);
                i |= 2;
            } else {
                if (iF != 2) {
                    throw new bsd(iF);
                }
                list = (List) acmVarP.h(dfxVar, 2, (btd) bttVarArr[2].getValue(), list);
                i |= 4;
            }
        }
        acmVarP._bp(dfxVar);
        return new cnw(i, nmVar, iG, list);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        cnw cnwVar = (cnw) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        IHasGetValue[] bttVarArr = cnw.a;
        acnVarO._ca(dfxVar, 0, nk.b, cnwVar.b);
        acnVarO.k(1, cnwVar.c, dfxVar);
        acnVarO._ca(dfxVar, 2, (btd) bttVarArr[2].getValue(), cnwVar.d);
        acnVarO.a(dfxVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        return new btd[] { nk.b, bqj.b, cnw.a[2].getValue() };
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
