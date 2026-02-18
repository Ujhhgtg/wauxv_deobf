package me.hd.wauxv.obf;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class dee implements Iterable {
    public deb d;
    public deb e;
    public final WeakHashMap f = new WeakHashMap();
    public int g = 0;

    public deb b(Object obj) {
        deb debVar = this.d;
        while (debVar != null && !debVar.a.equals(obj)) {
            debVar = debVar.c;
        }
        return debVar;
    }

    public Object c(Object obj) {
        deb debVarB = b(obj);
        if (debVarB == null) {
            return null;
        }
        this.g--;
        WeakHashMap weakHashMap = this.f;
        if (!weakHashMap.isEmpty()) {
            Iterator it = weakHashMap.keySet().iterator();
            while (it.hasNext()) {
                ((ded) it.next()).d(debVarB);
            }
        }
        deb debVar = debVarB.d;
        if (debVar != null) {
            debVar.c = debVarB.c;
        } else {
            this.d = debVarB.c;
        }
        deb debVar2 = debVarB.c;
        if (debVar2 != null) {
            debVar2.d = debVar;
        } else {
            this.e = debVar;
        }
        debVarB.c = null;
        debVarB.d = null;
        return debVarB.b;
    }

    public final boolean equals(Object obj) {
        dea deaVar;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof dee)) {
            return false;
        }
        dee deeVar = (dee) obj;
        if (this.g != deeVar.g) {
            return false;
        }
        Iterator it = iterator();
        Iterator it2 = deeVar.iterator();
        while (true) {
            deaVar = (dea) it;
            if (!deaVar.hasNext()) {
                break;
            }
            dea deaVar2 = (dea) it2;
            if (!deaVar2.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) deaVar.next();
            Object next = deaVar2.next();
            if ((entry == null && next != null) || (entry != null && !entry.equals(next))) {
                return false;
            }
        }
        return (deaVar.hasNext() || ((dea) it2).hasNext()) ? false : true;
    }

    public final int hashCode() {
        Iterator it = iterator();
        int iHashCode = 0;
        while (true) {
            dea deaVar = (dea) it;
            if (!deaVar.hasNext()) {
                return iHashCode;
            }
            iHashCode += ((Map.Entry) deaVar.next()).hashCode();
        }
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        dea deaVar = new dea(this.d, this.e, 0);
        this.f.put(deaVar, Boolean.FALSE);
        return deaVar;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[");
        Iterator it = iterator();
        while (true) {
            dea deaVar = (dea) it;
            if (!deaVar.hasNext()) {
                sb.append("]");
                return sb.toString();
            }
            sb.append(((Map.Entry) deaVar.next()).toString());
            if (deaVar.hasNext()) {
                sb.append(", ");
            }
        }
    }
}
