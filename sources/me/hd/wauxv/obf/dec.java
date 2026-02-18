package me.hd.wauxv.obf;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dec extends ded implements Iterator {
    public deb a;
    public boolean b = true;
    public final /* synthetic */ dee c;

    public dec(dee deeVar) {
        this.c = deeVar;
    }

    @Override // me.hd.wauxv.obf.ded
    public final void d(deb debVar) {
        deb debVar2 = this.a;
        if (debVar == debVar2) {
            deb debVar3 = debVar2.d;
            this.a = debVar3;
            this.b = debVar3 == null;
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.b) {
            return this.c.d != null;
        }
        deb debVar = this.a;
        return (debVar == null || debVar.c == null) ? false : true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.b) {
            this.b = false;
            this.a = this.c.d;
        } else {
            deb debVar = this.a;
            this.a = debVar != null ? debVar.c : null;
        }
        return this.a;
    }
}
