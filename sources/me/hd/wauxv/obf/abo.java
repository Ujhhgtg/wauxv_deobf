package me.hd.wauxv.obf;

import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class abo implements Comparator {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ abo(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.a) {
            case 0:
                for (IHasInvokeMethod bgfVar : (IHasInvokeMethod[]) this.b) {
                    int iJ = ajn.j((Comparable) bgfVar.invoke(obj), (Comparable) bgfVar.invoke(obj2));
                    if (iJ != 0) {
                        return iJ;
                    }
                }
                return 0;
            default:
                return ((Number) ((dfq) this.b).g(obj, obj2)).intValue();
        }
    }
}
