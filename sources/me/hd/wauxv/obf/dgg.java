package me.hd.wauxv.obf;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class dgg extends emn {
    public static Set _cd(Object... objArr) {
        int length = objArr.length;
        if (length == 0) {
            return avh.a;
        }
        if (length == 1) {
            Set setSingleton = Collections.singleton(objArr[0]);
            bzo.p(setSingleton, "singleton(...)");
            return setSingleton;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(bzo.ah(objArr.length));
        for (Object obj : objArr) {
            linkedHashSet.add(obj);
        }
        return linkedHashSet;
    }

    public static Set a(Set set, Set set2) {
        if (set2.isEmpty()) {
            return aaz.ad(set);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object obj : set) {
            if (!set2.contains(obj)) {
                linkedHashSet.add(obj);
            }
        }
        return linkedHashSet;
    }

    public static LinkedHashSet b(Set set, cio cioVar) {
        bzo.q(set, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet(bzo.ah(set.size() + 1));
        linkedHashSet.addAll(set);
        linkedHashSet.add(cioVar);
        return linkedHashSet;
    }
}
