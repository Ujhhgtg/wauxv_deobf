package me.hd.wauxv.obf;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class aaz extends abf {
    public static lb a(Iterable iterable) {
        bzo.q(iterable, "<this>");
        return new lb(iterable, 1);
    }

    public static long[] aa(List list) {
        bzo.q(list, "<this>");
        long[] jArr = new long[list.size()];
        Iterator it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            jArr[i] = ((Number) it.next()).longValue();
            i++;
        }
        return jArr;
    }

    public static ArrayList ab(Collection collection) {
        bzo.q(collection, "<this>");
        return new ArrayList(collection);
    }

    public static final List ac(Iterable iterable) {
        bzo.q(iterable, "<this>");
        if (iterable instanceof Collection) {
            return ab((Collection) iterable);
        }
        ArrayList arrayList = new ArrayList();
        x(iterable, arrayList);
        return arrayList;
    }

    public static Set ad(Iterable iterable) {
        bzo.q(iterable, "<this>");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size != 0) {
                if (size != 1) {
                    LinkedHashSet linkedHashSet = new LinkedHashSet(bzo.ah(collection.size()));
                    x(iterable, linkedHashSet);
                    return linkedHashSet;
                }
                Set setSingleton = Collections.singleton(iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next());
                bzo.p(setSingleton, "singleton(...)");
                return setSingleton;
            }
        } else {
            LinkedHashSet linkedHashSet2 = new LinkedHashSet();
            x(iterable, linkedHashSet2);
            int size2 = linkedHashSet2.size();
            if (size2 != 0) {
                if (size2 != 1) {
                    return linkedHashSet2;
                }
                Set setSingleton2 = Collections.singleton(linkedHashSet2.iterator().next());
                bzo.p(setSingleton2, "singleton(...)");
                return setSingleton2;
            }
        }
        return avh.a;
    }

    public static ArrayList ae(List list, List list2) {
        Iterator it = list.iterator();
        Iterator it2 = list2.iterator();
        ArrayList arrayList = new ArrayList(Math.min(abb.ak(list, 10), abb.ak(list2, 10)));
        while (it.hasNext() && it2.hasNext()) {
            arrayList.add(new csm(it.next(), it2.next()));
        }
        return arrayList;
    }

    public static boolean b(Iterable iterable, Object obj) {
        int iIndexOf;
        bzo.q(iterable, "<this>");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).contains(obj);
        }
        if (iterable instanceof List) {
            iIndexOf = ((List) iterable).indexOf(obj);
        } else {
            int i = 0;
            for (Object obj2 : iterable) {
                if (i < 0) {
                    aba.aj();
                    throw null;
                }
                if (bzo.f(obj, obj2)) {
                    iIndexOf = i;
                } else {
                    i++;
                }
            }
            iIndexOf = -1;
        }
        return iIndexOf >= 0;
    }

    public static Object d(Iterable iterable) {
        bzo.q(iterable, "<this>");
        if (iterable instanceof List) {
            return e((List) iterable);
        }
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static Object e(List list) {
        bzo.q(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(0);
    }

    public static Object f(Collection collection) {
        bzo.q(collection, "<this>");
        if (collection instanceof List) {
            List list = (List) collection;
            if (list.isEmpty()) {
                return null;
            }
            return list.get(0);
        }
        Iterator it = collection.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    public static Object g(List list) {
        bzo.q(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static Object h(int i, List list) {
        bzo.q(list, "<this>");
        if (i < 0 || i >= list.size()) {
            return null;
        }
        return list.get(i);
    }

    public static final void i(Iterable iterable, StringBuilder sb, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, bgf bgfVar) {
        bzo.q(iterable, "<this>");
        sb.append(charSequence2);
        int i = 0;
        for (Object obj : iterable) {
            i++;
            if (i > 1) {
                sb.append(charSequence);
            }
            aye.k(sb, obj, bgfVar);
        }
        sb.append(charSequence3);
    }

    public static String k(Iterable iterable, String str, String str2, String str3, bgf bgfVar, int i) {
        if ((i & 1) != 0) {
            str = ", ";
        }
        String str4 = str;
        String str5 = (i & 2) != 0 ? "" : str2;
        String str6 = (i & 4) != 0 ? "" : str3;
        if ((i & 32) != 0) {
            bgfVar = null;
        }
        bzo.q(iterable, "<this>");
        bzo.q(str5, "prefix");
        StringBuilder sb = new StringBuilder();
        i(iterable, sb, str4, str5, str6, "...", bgfVar);
        return sb.toString();
    }

    public static Object l(List list) {
        bzo.q(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(aba.af(list));
    }

    public static Object m(List list) {
        bzo.q(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    public static Comparable n(ArrayList arrayList) {
        Iterator it = arrayList.iterator();
        if (!it.hasNext()) {
            return null;
        }
        Comparable comparable = (Comparable) it.next();
        while (it.hasNext()) {
            Comparable comparable2 = (Comparable) it.next();
            if (comparable.compareTo(comparable2) < 0) {
                comparable = comparable2;
            }
        }
        return comparable;
    }

    public static ArrayList o(Collection collection, Iterable iterable) {
        bzo.q(collection, "<this>");
        bzo.q(iterable, "elements");
        if (!(iterable instanceof Collection)) {
            ArrayList arrayList = new ArrayList(collection);
            abf.an(arrayList, iterable);
            return arrayList;
        }
        Collection collection2 = (Collection) iterable;
        ArrayList arrayList2 = new ArrayList(collection2.size() + collection.size());
        arrayList2.addAll(collection);
        arrayList2.addAll(collection2);
        return arrayList2;
    }

    public static ArrayList p(Collection collection, Object obj) {
        bzo.q(collection, "<this>");
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(obj);
        return arrayList;
    }

    public static Object q(List list) {
        ae aeVar = cyj.f;
        if (list.isEmpty()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        return list.get(cyj.f.c(list.size()));
    }

    public static List r(Iterable iterable) {
        bzo.q(iterable, "<this>");
        if ((iterable instanceof Collection) && ((Collection) iterable).size() <= 1) {
            return z(iterable);
        }
        List listAc = ac(iterable);
        Collections.reverse(listAc);
        return listAc;
    }

    public static Object s(List list) {
        bzo.q(list, "<this>");
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    public static List t(Iterable iterable, Comparator comparator) {
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return z(iterable);
        }
        Object[] array = collection.toArray(new Object[0]);
        bzo.q(array, "<this>");
        if (array.length > 1) {
            Arrays.sort(array, comparator);
        }
        return la.a(array);
    }

    public static List u(int i, List list) {
        bzo.q(list, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(yg.f(i, "Requested element count ", " is less than zero.").toString());
        }
        if (i == 0) {
            return avd.a;
        }
        if (i >= list.size()) {
            return z(list);
        }
        if (i == 1) {
            return dqc.bf(d(list));
        }
        ArrayList arrayList = new ArrayList(i);
        Iterator it = list.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            arrayList.add(it.next());
            i2++;
            if (i2 == i) {
                break;
            }
        }
        return aba.ai(arrayList);
    }

    public static boolean[] v(List list) {
        bzo.q(list, "<this>");
        boolean[] zArr = new boolean[list.size()];
        Iterator it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            zArr[i] = ((Boolean) it.next()).booleanValue();
            i++;
        }
        return zArr;
    }

    public static byte[] w(ArrayList arrayList) {
        byte[] bArr = new byte[arrayList.size()];
        Iterator it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            bArr[i] = ((Number) it.next()).byteValue();
            i++;
        }
        return bArr;
    }

    public static void x(Iterable iterable, AbstractCollection abstractCollection) {
        bzo.q(iterable, "<this>");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            abstractCollection.add(it.next());
        }
    }

    public static int[] y(List list) {
        bzo.q(list, "<this>");
        int[] iArr = new int[list.size()];
        Iterator it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            iArr[i] = ((Number) it.next()).intValue();
            i++;
        }
        return iArr;
    }

    public static List z(Iterable iterable) {
        bzo.q(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return aba.ai(ac(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return avd.a;
        }
        if (size != 1) {
            return ab(collection);
        }
        return dqc.bf(iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next());
    }
}
