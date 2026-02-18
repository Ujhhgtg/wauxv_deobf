package me.hd.wauxv.obf;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class byi {
    public final LinkedHashMap a = new LinkedHashMap(100, 0.75f, true);
    public final long b;
    public long c;

    public byi(long j) {
        this.b = j;
    }

    public final synchronized Object d(Object obj) {
        byh byhVar;
        byhVar = (byh) this.a.get(obj);
        return byhVar != null ? byhVar.a : null;
    }

    public int e(Object obj) {
        return 1;
    }

    public void f(Object obj, Object obj2) {
    }

    public final synchronized Object g(Object obj, Object obj2) {
        int iE = e(obj2);
        long j = iE;
        if (j >= this.b) {
            f(obj, obj2);
            return null;
        }
        if (obj2 != null) {
            this.c += j;
        }
        byh byhVar = (byh) this.a.put(obj, obj2 == null ? null : new byh(obj2, iE));
        if (byhVar != null) {
            this.c -= (long) byhVar.b;
            if (!byhVar.a.equals(obj2)) {
                f(obj, byhVar.a);
            }
        }
        h(this.b);
        return byhVar != null ? byhVar.a : null;
    }

    public final synchronized void h(long j) {
        while (this.c > j) {
            Iterator it = this.a.entrySet().iterator();
            Map.Entry entry = (Map.Entry) it.next();
            byh byhVar = (byh) entry.getValue();
            this.c -= (long) byhVar.b;
            Object key = entry.getKey();
            it.remove();
            f(key, byhVar.a);
        }
    }
}
