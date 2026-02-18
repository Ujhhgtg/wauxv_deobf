package me.hd.wauxv.obf;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class kt implements Collection {
    public final /* synthetic */ ku a;

    public kt(ku kuVar) {
        this.a = kuVar;
    }

    @Override // java.util.Collection
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final void clear() {
        this.a.clear();
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        return this.a.m(obj) >= 0;
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new kq(this.a, 1);
    }

    @Override // java.util.Collection
    public final boolean remove(Object obj) {
        ku kuVar = this.a;
        int iM = kuVar.m(obj);
        if (iM < 0) {
            return false;
        }
        kuVar.h(iM);
        return true;
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection collection) {
        ku kuVar = this.a;
        int i = kuVar.l;
        int i2 = 0;
        boolean z = false;
        while (i2 < i) {
            if (collection.contains(kuVar.s(i2))) {
                kuVar.h(i2);
                i2--;
                i--;
                z = true;
            }
            i2++;
        }
        return z;
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection collection) {
        ku kuVar = this.a;
        int i = kuVar.l;
        int i2 = 0;
        boolean z = false;
        while (i2 < i) {
            if (!collection.contains(kuVar.s(i2))) {
                kuVar.h(i2);
                i2--;
                i--;
                z = true;
            }
            i2++;
        }
        return z;
    }

    @Override // java.util.Collection
    public final int size() {
        return this.a.l;
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        ku kuVar = this.a;
        int i = kuVar.l;
        Object[] objArr = new Object[i];
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = kuVar.s(i2);
        }
        return objArr;
    }

    @Override // java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        ku kuVar = this.a;
        int i = kuVar.l;
        if (objArr.length < i) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i);
        }
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = kuVar.s(i2);
        }
        if (objArr.length > i) {
            objArr[i] = null;
        }
        return objArr;
    }
}
