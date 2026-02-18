package me.hd.wauxv.obf;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dpx implements bun {
    public final Set a = Collections.newSetFromMap(new WeakHashMap());

    @Override // me.hd.wauxv.obf.bun
    public final void j() {
        Iterator it = eot.h(this.a).iterator();
        while (it.hasNext()) {
            ((dpw) it.next()).j();
        }
    }

    @Override // me.hd.wauxv.obf.bun
    public final void m() {
        Iterator it = eot.h(this.a).iterator();
        while (it.hasNext()) {
            ((dpw) it.next()).m();
        }
    }

    @Override // me.hd.wauxv.obf.bun
    public final void q() {
        Iterator it = eot.h(this.a).iterator();
        while (it.hasNext()) {
            ((dpw) it.next()).q();
        }
    }
}
