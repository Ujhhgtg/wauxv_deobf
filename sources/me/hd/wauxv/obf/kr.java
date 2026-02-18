package me.hd.wauxv.obf;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class kr implements Set {
    public final /* synthetic */ ku a;

    public kr(ku kuVar) {
        this.a = kuVar;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Set, java.util.Collection
    public final void clear() {
        this.a.clear();
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean contains(Object obj) {
        return this.a.containsKey(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean containsAll(Collection collection) {
        return this.a.d(collection);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean equals(Object obj) {
        ku kuVar = this.a;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        try {
            return kuVar.l == set.size() && kuVar.d(set);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final int hashCode() {
        ku kuVar = this.a;
        int iHashCode = 0;
        for (int i = kuVar.l - 1; i >= 0; i--) {
            Object objR = kuVar.r(i);
            iHashCode += objR == null ? 0 : objR.hashCode();
        }
        return iHashCode;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new kq(this.a, 0);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean remove(Object obj) {
        ku kuVar = this.a;
        int iP = kuVar.p(obj);
        if (iP < 0) {
            return false;
        }
        kuVar.h(iP);
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean removeAll(Collection collection) {
        return this.a.e(collection);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean retainAll(Collection collection) {
        ku kuVar = this.a;
        int i = kuVar.l;
        for (int i2 = i - 1; i2 >= 0; i2--) {
            if (!collection.contains(kuVar.r(i2))) {
                kuVar.h(i2);
            }
        }
        return i != kuVar.l;
    }

    @Override // java.util.Set, java.util.Collection
    public final int size() {
        return this.a.l;
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray() {
        ku kuVar = this.a;
        int i = kuVar.l;
        Object[] objArr = new Object[i];
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = kuVar.r(i2);
        }
        return objArr;
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        ku kuVar = this.a;
        int i = kuVar.l;
        if (objArr.length < i) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i);
        }
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = kuVar.r(i2);
        }
        if (objArr.length > i) {
            objArr[i] = null;
        }
        return objArr;
    }
}
