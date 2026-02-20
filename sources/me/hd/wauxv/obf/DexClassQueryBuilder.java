package me.hd.wauxv.obf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class DexClassQueryBuilder extends dqc {
    public List strings;
    public DexMethodGroupMatcher methodGroupMatcher;

    @Override // me.hd.wauxv.obf.dqc
    public final int c(bbb bbbVar) {
        int iT;
        throwIfVar1IsNull(bbbVar, "fbb");
        List list = this.strings;
        if (list != null) {
            ArrayList arrayList = new ArrayList(StaticHelpers4.ak(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(Integer.valueOf(bbbVar.s((String) it.next())));
            }
            iT = bbbVar.t(StaticHelpers5.y(arrayList));
        } else {
            iT = 0;
        }
        DexMethodGroupMatcher zbVar = this.methodGroupMatcher;
        int iC = zbVar != null ? zbVar.c(bbbVar) : 0;
        bbbVar.ab(6);
        bbbVar.q(5, iC);
        bbbVar.q(3, 0);
        bbbVar.q(1, 0);
        bbbVar.q(0, iT);
        int iU = bbbVar.u();
        bbbVar.w(iU);
        return iU;
    }
}
