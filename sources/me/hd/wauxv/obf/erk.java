package me.hd.wauxv.obf;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class erk {
    public final erl m = new erl();

    public void h() {
    }

    public final void n() {
        erl erlVar = this.m;
        if (erlVar != null && !erlVar.d) {
            erlVar.d = true;
            synchronized (erlVar.a) {
                try {
                    Iterator it = erlVar.b.values().iterator();
                    while (it.hasNext()) {
                        erl.e((AutoCloseable) it.next());
                    }
                    Iterator it2 = erlVar.c.iterator();
                    while (it2.hasNext()) {
                        erl.e((AutoCloseable) it2.next());
                    }
                    erlVar.c.clear();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        h();
    }
}
