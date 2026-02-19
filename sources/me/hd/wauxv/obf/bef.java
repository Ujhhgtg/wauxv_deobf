package me.hd.wauxv.obf;

import android.os.Bundle;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bef implements bec {
    public final /* synthetic */ int a;
    public final String b;
    public final /* synthetic */ beg c;

    public /* synthetic */ bef(beg begVar, String str, int i) {
        this.a = i;
        this.c = begVar;
        this.b = str;
    }

    /* JADX WARN: Found duplicated region for block: B:37:0x00ba  */
    @Override // me.hd.wauxv.obf.bec
    public final boolean v(ArrayList arrayList, ArrayList arrayList2) throws Throwable {
        int i;
        Iterator it;
        int i2;
        switch (this.a) {
            case 0:
                beg begVar = this.c;
                mw mwVar = (mw) begVar.l.remove(this.b);
                boolean z = false;
                if (mwVar != null) {
                    HashMap map = new HashMap();
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        mu muVar = (mu) it2.next();
                        if (muVar.u) {
                            Iterator it3 = muVar.a.iterator();
                            while (it3.hasNext()) {
                                SomeFragmentManager someFragmentManagerVar = ((bfe) it3.next()).b;
                                if (someFragmentManagerVar != null) {
                                    map.put(someFragmentManagerVar.aw, someFragmentManagerVar);
                                }
                            }
                        }
                    }
                    ArrayList<String> arrayList3 = mwVar.a;
                    HashMap map2 = new HashMap(arrayList3.size());
                    for (String str : arrayList3) {
                        SomeFragmentManager someFragmentManagerVar2 = (SomeFragmentManager) map.get(str);
                        if (someFragmentManagerVar2 != null) {
                            map2.put(someFragmentManagerVar2.aw, someFragmentManagerVar2);
                        } else {
                            Bundle bundleAs = begVar.c.as(str, null);
                            if (bundleAs != null) {
                                ClassLoader classLoader = begVar.w.e.getClassLoader();
                                SomeFragmentManager someFragmentManagerVarP = ((bey) bundleAs.getParcelable("state")).p(begVar.ce());
                                someFragmentManagerVarP.at = bundleAs;
                                if (bundleAs.getBundle("savedInstanceState") == null) {
                                    someFragmentManagerVarP.at.putBundle("savedInstanceState", new Bundle());
                                }
                                Bundle bundle = bundleAs.getBundle("arguments");
                                if (bundle != null) {
                                    bundle.setClassLoader(classLoader);
                                }
                                someFragmentManagerVarP.df(bundle);
                                map2.put(someFragmentManagerVarP.aw, someFragmentManagerVarP);
                            }
                        }
                    }
                    ArrayList arrayList4 = new ArrayList();
                    for (mv mvVar : mwVar.b) {
                        ArrayList arrayList5 = mvVar.b;
                        mu muVar2 = new mu(begVar);
                        mvVar.o(muVar2);
                        for (int i3 = 0; i3 < arrayList5.size(); i3++) {
                            String str2 = (String) arrayList5.get(i3);
                            if (str2 != null) {
                                SomeFragmentManager someFragmentManagerVar3 = (SomeFragmentManager) map2.get(str2);
                                if (someFragmentManagerVar3 == null) {
                                    throw new IllegalStateException("Restoring FragmentTransaction " + mvVar.f + " failed due to missing saved state for Fragment (" + str2 + ")");
                                }
                                ((bfe) muVar2.a.get(i3)).b = someFragmentManagerVar3;
                            }
                        }
                        arrayList4.add(muVar2);
                    }
                    Iterator it4 = arrayList4.iterator();
                    while (it4.hasNext()) {
                        ((mu) it4.next()).v(arrayList, arrayList2);
                        z = true;
                    }
                }
                return z;
            default:
                beg begVar2 = this.c;
                String str3 = this.b;
                int iBz = begVar2.bz(str3, -1, true);
                if (iBz < 0) {
                    return false;
                }
                int i4 = iBz;
                while (true) {
                    Throwable th = null;
                    if (i4 >= begVar2.d.size()) {
                        HashSet hashSet = new HashSet();
                        int i5 = iBz;
                        while (i5 < begVar2.d.size()) {
                            mu muVar3 = (mu) begVar2.d.get(i5);
                            HashSet hashSet2 = new HashSet();
                            HashSet hashSet3 = new HashSet();
                            Iterator it5 = muVar3.a.iterator();
                            while (it5.hasNext()) {
                                bfe bfeVar = (bfe) it5.next();
                                Throwable th2 = th;
                                SomeFragmentManager someFragmentManagerVar4 = bfeVar.b;
                                if (someFragmentManagerVar4 == null) {
                                    th = th2;
                                } else {
                                    if (bfeVar.c) {
                                        i = i5;
                                        int i6 = bfeVar.a;
                                        it = it5;
                                        if (i6 == 1 || i6 == 2 || i6 == 8) {
                                        }
                                        i2 = bfeVar.a;
                                        if (i2 != 1 || i2 == 2) {
                                            hashSet3.add(someFragmentManagerVar4);
                                        }
                                        th = th2;
                                        i5 = i;
                                        it5 = it;
                                    } else {
                                        i = i5;
                                        it = it5;
                                    }
                                    hashSet.add(someFragmentManagerVar4);
                                    hashSet2.add(someFragmentManagerVar4);
                                    i2 = bfeVar.a;
                                    if (i2 != 1) {
                                        hashSet3.add(someFragmentManagerVar4);
                                    } else {
                                        hashSet3.add(someFragmentManagerVar4);
                                    }
                                    th = th2;
                                    i5 = i;
                                    it5 = it;
                                }
                            }
                            int i7 = i5;
                            Throwable th3 = th;
                            hashSet2.removeAll(hashSet3);
                            if (!hashSet2.isEmpty()) {
                                StringBuilder sbZ = StaticHelpers6.concatAndToSb("saveBackStack(\"", str3, "\") must be self contained and not reference fragments from non-saved FragmentTransactions. Found reference to fragment");
                                sbZ.append(hashSet2.size() == 1 ? " " + hashSet2.iterator().next() : "s " + hashSet2);
                                sbZ.append(" in ");
                                sbZ.append(muVar3);
                                sbZ.append(" that were previously added to the FragmentManager through a separate FragmentTransaction.");
                                begVar2.cy(new IllegalArgumentException(sbZ.toString()));
                                throw th3;
                            }
                            i5 = i7 + 1;
                            th = th3;
                        }
                        Throwable th4 = th;
                        ArrayDeque arrayDeque = new ArrayDeque(hashSet);
                        while (!arrayDeque.isEmpty()) {
                            SomeFragmentManager someFragmentManagerVar5 = (SomeFragmentManager) arrayDeque.removeFirst();
                            if (someFragmentManagerVar5.bv) {
                                StringBuilder sbZ2 = StaticHelpers6.concatAndToSb("saveBackStack(\"", str3, "\") must not contain retained fragments. Found ");
                                sbZ2.append(hashSet.contains(someFragmentManagerVar5) ? "direct reference to retained " : "retained child ");
                                sbZ2.append("fragment ");
                                sbZ2.append(someFragmentManagerVar5);
                                begVar2.cy(new IllegalArgumentException(sbZ2.toString()));
                                throw th4;
                            }
                            for (SomeFragmentManager someFragmentManagerVar6 : someFragmentManagerVar5.bo.c.ad()) {
                                if (someFragmentManagerVar6 != null) {
                                    arrayDeque.addLast(someFragmentManagerVar6);
                                }
                            }
                        }
                        ArrayList arrayList6 = new ArrayList();
                        Iterator it6 = hashSet.iterator();
                        while (it6.hasNext()) {
                            arrayList6.add(((SomeFragmentManager) it6.next()).aw);
                        }
                        ArrayList arrayList7 = new ArrayList(begVar2.d.size() - iBz);
                        for (int i8 = iBz; i8 < begVar2.d.size(); i8++) {
                            arrayList7.add(th4);
                        }
                        mw mwVar2 = new mw(arrayList6, arrayList7);
                        for (int size = begVar2.d.size() - 1; size >= iBz; size--) {
                            mu muVar4 = (mu) begVar2.d.remove(size);
                            mu muVar5 = new mu(muVar4);
                            muVar5.y();
                            arrayList7.set(size - iBz, new mv(muVar5));
                            muVar4.u = true;
                            arrayList.add(muVar4);
                            arrayList2.add(Boolean.TRUE);
                        }
                        begVar2.l.put(str3, mwVar2);
                        return true;
                    }
                    mu muVar6 = (mu) begVar2.d.get(i4);
                    if (!muVar6.p) {
                        begVar2.cy(new IllegalArgumentException("saveBackStack(\"" + str3 + "\") included FragmentTransactions must use setReorderingAllowed(true) to ensure that the back stack can be restored as an atomic operation. Found " + muVar6 + " that did not use setReorderingAllowed(true)."));
                        throw null;
                    }
                    i4++;
                }
                break;
        }
    }
}
