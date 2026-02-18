package me.hd.wauxv.obf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class abf extends abe {
    public static void an(Collection collection, Iterable iterable) {
        throwIfVar1IsNull(collection, "<this>");
        throwIfVar1IsNull(iterable, "elements");
        if (iterable instanceof Collection) {
            collection.addAll((Collection) iterable);
            return;
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            collection.add(it.next());
        }
    }

    public static void ao(Collection collection, Object[] objArr) {
        throwIfVar1IsNull(collection, "<this>");
        throwIfVar1IsNull(objArr, "elements");
        collection.addAll(la.a(objArr));
    }

    public static void ap(ArrayList arrayList, IHasInvokeMethod bgfVar) {
        int iAf;
        throwIfVar1IsNull(arrayList, "<this>");
        int iAf2 = aba.af(arrayList);
        int i = 0;
        if (iAf2 >= 0) {
            int i2 = 0;
            while (true) {
                Object obj = arrayList.get(i);
                if (!((Boolean) bgfVar.invoke(obj)).booleanValue()) {
                    if (i2 != i) {
                        arrayList.set(i2, obj);
                    }
                    i2++;
                }
                if (i == iAf2) {
                    break;
                } else {
                    i++;
                }
            }
            i = i2;
        }
        if (i >= arrayList.size() || i > (iAf = aba.af(arrayList))) {
            return;
        }
        while (true) {
            arrayList.remove(iAf);
            if (iAf == i) {
                return;
            } else {
                iAf--;
            }
        }
    }

    public static Object aq(ArrayList arrayList) {
        if (arrayList.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return arrayList.remove(0);
    }

    public static Object ar(List list) {
        throwIfVar1IsNull(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.remove(aba.af(list));
    }
}
