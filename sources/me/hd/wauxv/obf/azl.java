package me.hd.wauxv.obf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class azl extends dqc {
    public List a;
    public final UsingStringsTypeEnum b = UsingStringsTypeEnum.Contains;
    public bqh d;

    @Override // me.hd.wauxv.obf.dqc
    public final int c(bbb bbbVar) {
        int iT;
        throwIfVar1IsNull(bbbVar, "fbb");
        List list = this.a;
        if (list != null) {
            ArrayList arrayList = new ArrayList(StaticHelpers4.ak(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(Integer.valueOf(((azi) it.next()).c(bbbVar)));
            }
            iT = bbbVar.t(StaticHelpers5.y(arrayList));
        } else {
            iT = 0;
        }
        byte b = this.b.d;
        bqh bqhVar = this.d;
        int iC = bqhVar != null ? bqhVar.c(bbbVar) : 0;
        bbbVar.ab(3);
        bbbVar.q(2, iC);
        bbbVar.q(0, iT);
        bbbVar.o(b, 1);
        int iU = bbbVar.u();
        bbbVar.w(iU);
        return iU;
    }

    public final void e(azi aziVar) {
        List arrayList = this.a;
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        this.a = arrayList;
        arrayList.add(aziVar);
    }

    public final void f(Class cls) {
        throwIfVar1IsNull(cls, "clazz");
        azi aziVar = new azi();
        DexMethodGroupMatcher zbVar = new DexMethodGroupMatcher();
        zbVar.j(ams.e(cls), dne.Equals);
        aziVar.b = zbVar;
        e(aziVar);
    }
}
