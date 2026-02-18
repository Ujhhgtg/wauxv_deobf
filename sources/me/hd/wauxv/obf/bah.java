package me.hd.wauxv.obf;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bah extends dqc {
    public List a;
    public List b;
    public cdj d;

    @Override // me.hd.wauxv.obf.dqc
    public final int c(bbb bbbVar) {
        int iT;
        int iV;
        throwIfVar1IsNull(bbbVar, "fbb");
        List list = this.a;
        if (list != null) {
            ArrayList arrayList = new ArrayList(abb.ak(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(Integer.valueOf(bbbVar.s((String) it.next())));
            }
            iT = bbbVar.t(aaz.y(arrayList));
        } else {
            iT = 0;
        }
        List<yu> list2 = this.b;
        if (list2 != null) {
            ArrayList arrayList2 = new ArrayList(abb.ak(list2, 10));
            for (yu yuVar : list2) {
                int i = yuVar.b;
                if (i < 0) {
                    throw new IllegalStateException("not has id");
                }
                arrayList2.add(Long.valueOf(nd.d(yuVar.c, i)));
            }
            long[] jArrAa = aaz.aa(arrayList2);
            bbbVar.ac(8, jArrAa.length, 8);
            for (int length = jArrAa.length - 1; -1 < length; length--) {
                long j = jArrAa[length];
                bbbVar.y(8, 0);
                ByteBuffer byteBuffer = bbbVar.a;
                int i2 = bbbVar.b - 8;
                bbbVar.b = i2;
                byteBuffer.putLong(i2, j);
            }
            iV = bbbVar.v();
        } else {
            iV = 0;
        }
        cdj cdjVar = this.d;
        int iC = cdjVar != null ? cdjVar.c(bbbVar) : 0;
        bbbVar.ab(7);
        bbbVar.q(6, iC);
        bbbVar.q(4, 0);
        bbbVar.q(3, iV);
        bbbVar.q(1, 0);
        bbbVar.q(0, iT);
        int iU = bbbVar.u();
        bbbVar.w(iU);
        return iU;
    }
}
