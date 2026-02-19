package me.hd.wauxv.obf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class fi extends dqc {
    public List a;

    @Override // me.hd.wauxv.obf.dqc
    public final int c(bbb bbbVar) {
        int iT;
        throwIfVar1IsNull(bbbVar, "fbb");
        List list = this.a;
        if (list != null) {
            ArrayList arrayList = new ArrayList(StaticHelpers4.ak(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(Integer.valueOf(((fh) it.next()).c(bbbVar)));
            }
            iT = bbbVar.t(StaticHelpers5.y(arrayList));
        } else {
            iT = 0;
        }
        bbbVar.ab(3);
        bbbVar.q(2, 0);
        bbbVar.q(0, iT);
        bbbVar.o((byte) 0, 1);
        int iU = bbbVar.u();
        bbbVar.w(iU);
        return iU;
    }
}
