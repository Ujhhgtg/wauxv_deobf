package me.hd.wauxv.obf;

import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bum implements bui, buo {
    public final HashSet a = new HashSet();
    public final bur b;

    public bum(bur burVar) {
        this.b = burVar;
        burVar.j(this);
    }

    @Override // me.hd.wauxv.obf.bui
    public final void al(bun bunVar) {
        this.a.add(bunVar);
        buh buhVar = this.b.c;
        if (buhVar == buh.a) {
            bunVar.j();
        } else if (buhVar.compareTo(buh.d) >= 0) {
            bunVar.q();
        } else {
            bunVar.m();
        }
    }

    @Override // me.hd.wauxv.obf.bui
    public final void an(bun bunVar) {
        this.a.remove(bunVar);
    }

    @cqy(bug.ON_DESTROY)
    public void onDestroy(bup bupVar) {
        Iterator it = eot.h(this.a).iterator();
        while (it.hasNext()) {
            ((bun) it.next()).j();
        }
        bupVar.ap().o(this);
    }

    @cqy(bug.ON_START)
    public void onStart(bup bupVar) {
        Iterator it = eot.h(this.a).iterator();
        while (it.hasNext()) {
            ((bun) it.next()).q();
        }
    }

    @cqy(bug.ON_STOP)
    public void onStop(bup bupVar) {
        Iterator it = eot.h(this.a).iterator();
        while (it.hasNext()) {
            ((bun) it.next()).m();
        }
    }
}
