package me.hd.wauxv.obf;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class aco extends erz {
    public final /* synthetic */ int a;
    public final Object b;

    public aco() {
        this.a = 0;
        this.b = new ArrayList(3);
    }

    @Override // me.hd.wauxv.obf.erz
    public final void c(int i) {
        switch (this.a) {
            case 0:
                try {
                    Iterator it = ((ArrayList) this.b).iterator();
                    while (it.hasNext()) {
                        ((erz) it.next()).c(i);
                    }
                    return;
                } catch (ConcurrentModificationException e) {
                    throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", e);
                }
            default:
                ((bfa) this.b).h(false);
                return;
        }
    }

    @Override // me.hd.wauxv.obf.erz
    public void d(int i, float f, int i2) {
        switch (this.a) {
            case 0:
                try {
                    Iterator it = ((ArrayList) this.b).iterator();
                    while (it.hasNext()) {
                        ((erz) it.next()).d(i, f, i2);
                    }
                    return;
                } catch (ConcurrentModificationException e) {
                    throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", e);
                }
            default:
                return;
        }
    }

    @Override // me.hd.wauxv.obf.erz
    public final void e(int i) {
        switch (this.a) {
            case 0:
                try {
                    Iterator it = ((ArrayList) this.b).iterator();
                    while (it.hasNext()) {
                        ((erz) it.next()).e(i);
                    }
                    return;
                } catch (ConcurrentModificationException e) {
                    throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", e);
                }
            default:
                ((bfa) this.b).h(false);
                return;
        }
    }

    public aco(bfa bfaVar) {
        this.a = 1;
        this.b = bfaVar;
    }
}
