package me.hd.wauxv.obf;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class ku extends dhq implements Map {
    public kp a;
    public kr b;
    public kt c;

    public ku(ku kuVar) {
        super(0);
        g(kuVar);
    }

    public final boolean d(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!super.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final boolean e(Collection collection) {
        int i = this.l;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            super.remove(it.next());
        }
        return i != this.l;
    }

    @Override // java.util.Map
    public final Set entrySet() {
        kp kpVar = this.a;
        if (kpVar != null) {
            return kpVar;
        }
        kp kpVar2 = new kp(this);
        this.a = kpVar2;
        return kpVar2;
    }

    @Override // java.util.Map
    public final Set keySet() {
        kr krVar = this.b;
        if (krVar != null) {
            return krVar;
        }
        kr krVar2 = new kr(this);
        this.b = krVar2;
        return krVar2;
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        n(map.size() + this.l);
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public final Collection values() {
        kt ktVar = this.c;
        if (ktVar != null) {
            return ktVar;
        }
        kt ktVar2 = new kt(this);
        this.c = ktVar2;
        return ktVar2;
    }
}
