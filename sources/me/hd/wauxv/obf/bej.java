package me.hd.wauxv.obf;

import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bej extends erk {
    public static final bei a = new bei(0);
    public final boolean e;
    public final HashMap b = new HashMap();
    public final HashMap c = new HashMap();
    public final HashMap d = new HashMap();
    public boolean f = false;
    public boolean g = false;

    public bej(boolean z) {
        this.e = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && bej.class == obj.getClass()) {
            bej bejVar = (bej) obj;
            if (this.b.equals(bejVar.b) && this.c.equals(bejVar.c) && this.d.equals(bejVar.d)) {
                return true;
            }
        }
        return false;
    }

    @Override // me.hd.wauxv.obf.erk
    public final void h() {
        if (beg.ar(3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.f = true;
    }

    public final int hashCode() {
        return this.d.hashCode() + ((this.c.hashCode() + (this.b.hashCode() * 31)) * 31);
    }

    public final void i(String str, boolean z) {
        if (beg.ar(3)) {
            Log.d("FragmentManager", "Clearing non-config state for saved state of Fragment " + str);
        }
        k(str, z);
    }

    public final void j(SomeFragmentManager someFragmentManagerVar, boolean z) {
        if (beg.ar(3)) {
            Log.d("FragmentManager", "Clearing non-config state for " + someFragmentManagerVar);
        }
        k(someFragmentManagerVar.aw, z);
    }

    public final void k(String str, boolean z) {
        HashMap map = this.c;
        bej bejVar = (bej) map.get(str);
        if (bejVar != null) {
            if (z) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(bejVar.c.keySet());
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    bejVar.i((String) it.next(), true);
                }
            }
            bejVar.h();
            map.remove(str);
        }
        HashMap map2 = this.d;
        erq erqVar = (erq) map2.get(str);
        if (erqVar != null) {
            erqVar.b();
            map2.remove(str);
        }
    }

    public final void l(SomeFragmentManager someFragmentManagerVar) {
        if (this.g) {
            if (beg.ar(2)) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
            }
        } else {
            if (this.b.remove(someFragmentManagerVar.aw) == null || !beg.ar(2)) {
                return;
            }
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + someFragmentManagerVar);
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator it = this.b.values().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator it2 = this.c.keySet().iterator();
        while (it2.hasNext()) {
            sb.append((String) it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator it3 = this.d.keySet().iterator();
        while (it3.hasNext()) {
            sb.append((String) it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
