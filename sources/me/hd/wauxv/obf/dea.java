package me.hd.wauxv.obf;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dea extends ded implements Iterator {
    public deb a;
    public deb b;
    public final /* synthetic */ int c;

    public dea(deb debVar, deb debVar2, int i) {
        this.c = i;
        this.a = debVar2;
        this.b = debVar;
    }

    @Override // me.hd.wauxv.obf.ded
    public final void d(deb debVar) {
        deb debVar2;
        deb debVarE = null;
        if (this.a == debVar && debVar == this.b) {
            this.b = null;
            this.a = null;
        }
        deb debVar3 = this.a;
        if (debVar3 == debVar) {
            switch (this.c) {
                case 0:
                    debVar2 = debVar3.d;
                    break;
                default:
                    debVar2 = debVar3.c;
                    break;
            }
            this.a = debVar2;
        }
        deb debVar4 = this.b;
        if (debVar4 == debVar) {
            deb debVar5 = this.a;
            if (debVar4 != debVar5 && debVar5 != null) {
                debVarE = e(debVar4);
            }
            this.b = debVarE;
        }
    }

    public final deb e(deb debVar) {
        switch (this.c) {
            case 0:
                return debVar.c;
            default:
                return debVar.d;
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.b != null;
    }

    @Override // java.util.Iterator
    public final Object next() {
        deb debVar = this.b;
        deb debVar2 = this.a;
        this.b = (debVar == debVar2 || debVar2 == null) ? null : e(debVar);
        return debVar;
    }
}
