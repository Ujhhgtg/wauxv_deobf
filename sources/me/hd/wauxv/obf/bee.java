package me.hd.wauxv.obf;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bee implements bec {
    public final /* synthetic */ beg a;

    public bee(beg begVar) {
        this.a = begVar;
    }

    @Override // me.hd.wauxv.obf.bec
    public final boolean v(ArrayList arrayList, ArrayList arrayList2) {
        ArrayList arrayList3;
        ArrayList arrayList4;
        boolean zCn;
        beg begVar = this.a;
        ArrayList<bes> arrayList5 = begVar.n;
        if (beg.ar(2)) {
            Log.v("FragmentManager", "FragmentManager has the following pending actions inside of prepareBackStackState: " + begVar.a);
        }
        if (begVar.d.isEmpty()) {
            Log.i("FragmentManager", "Ignoring call to start back stack pop because the back stack is empty.");
            zCn = false;
            arrayList3 = arrayList;
            arrayList4 = arrayList2;
        } else {
            mu muVar = (mu) dkz.l(1, begVar.d);
            begVar.h = muVar;
            Iterator it = muVar.a.iterator();
            while (it.hasNext()) {
                bdj bdjVar = ((bfe) it.next()).b;
                if (bdjVar != null) {
                    bdjVar.be = true;
                }
            }
            arrayList3 = arrayList;
            arrayList4 = arrayList2;
            zCn = begVar.cn(arrayList3, arrayList4, null, -1, 0);
        }
        if (!arrayList5.isEmpty() && arrayList3.size() > 0) {
            boolean zBooleanValue = ((Boolean) arrayList4.get(arrayList3.size() - 1)).booleanValue();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator it2 = arrayList3.iterator();
            while (it2.hasNext()) {
                linkedHashSet.addAll(beg.aq((mu) it2.next()));
            }
            for (bes besVar : arrayList5) {
                Iterator it3 = linkedHashSet.iterator();
                while (it3.hasNext()) {
                    besVar.d((bdj) it3.next(), zBooleanValue);
                }
            }
        }
        return zCn;
    }
}
