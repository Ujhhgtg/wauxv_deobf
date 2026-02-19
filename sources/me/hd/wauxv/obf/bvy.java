package me.hd.wauxv.obf;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bvy extends ad implements RandomAccess, Serializable {
    public Object[] c;
    public final int d;
    public int e;
    public final bvy f;
    public final bvz g;

    public bvy(Object[] objArr, int i, int i2, bvy bvyVar, bvz bvzVar) {
        throwIfVar1IsNull(objArr, "backing");
        throwIfVar1IsNull(bvzVar, "root");
        this.c = objArr;
        this.d = i;
        this.e = i2;
        this.f = bvyVar;
        this.g = bvzVar;
        ((AbstractList) this).modCount = ((AbstractList) bvzVar).modCount;
    }

    @Override // me.hd.wauxv.obf.ad
    public final int a() {
        k();
        return this.e;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection,
              // java.util.List
    public final boolean add(Object obj) {
        l();
        k();
        j(this.d + this.e, obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        throwIfVar1IsNull(collection, "elements");
        l();
        k();
        int size = collection.size();
        i(this.d + this.e, collection, size);
        return size > 0;
    }

    @Override // me.hd.wauxv.obf.ad
    public final Object b(int i) {
        l();
        k();
        int i2 = this.e;
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException(StaticHelpers6.p(i, "index: ", ", size: ", i2));
        }
        return m(this.d + i);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection,
              // java.util.List
    public final void clear() {
        l();
        k();
        n(this.d, this.e);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        k();
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            Object[] objArr = this.c;
            int i = this.e;
            if (i == list.size()) {
                for (int i2 = 0; i2 < i; i2++) {
                    if (nullSafeIsEqual(objArr[this.d + i2], list.get(i2))) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        k();
        int i2 = this.e;
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException(StaticHelpers6.p(i, "index: ", ", size: ", i2));
        }
        return this.c[this.d + i];
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        k();
        Object[] objArr = this.c;
        int i = this.e;
        int iHashCode = 1;
        for (int i2 = 0; i2 < i; i2++) {
            Object obj = objArr[this.d + i2];
            iHashCode = (iHashCode * 31) + (obj != null ? obj.hashCode() : 0);
        }
        return iHashCode;
    }

    public final void i(int i, Collection collection, int i2) {
        ((AbstractList) this).modCount++;
        bvz bvzVar = this.g;
        bvy bvyVar = this.f;
        if (bvyVar != null) {
            bvyVar.i(i, collection, i2);
        } else {
            bvz bvzVar2 = bvz.c;
            bvzVar.h(i, collection, i2);
        }
        this.c = bvzVar.d;
        this.e += i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        k();
        for (int i = 0; i < this.e; i++) {
            if (nullSafeIsEqual(this.c[this.d + i], obj)) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        k();
        return this.e == 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection,
              // java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return listIterator(0);
    }

    public final void j(int i, Object obj) {
        ((AbstractList) this).modCount++;
        bvz bvzVar = this.g;
        bvy bvyVar = this.f;
        if (bvyVar != null) {
            bvyVar.j(i, obj);
        } else {
            bvz bvzVar2 = bvz.c;
            bvzVar.i(i, obj);
        }
        this.c = bvzVar.d;
        this.e++;
    }

    public final void k() {
        if (((AbstractList) this.g).modCount != ((AbstractList) this).modCount) {
            throw new ConcurrentModificationException();
        }
    }

    public final void l() {
        if (this.g.f) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        k();
        for (int i = this.e - 1; i >= 0; i--) {
            if (nullSafeIsEqual(this.c[this.d + i], obj)) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator() {
        return listIterator(0);
    }

    public final Object m(int i) {
        Object objL;
        ((AbstractList) this).modCount++;
        bvy bvyVar = this.f;
        if (bvyVar != null) {
            objL = bvyVar.m(i);
        } else {
            bvz bvzVar = bvz.c;
            objL = this.g.l(i);
        }
        this.e--;
        return objL;
    }

    public final void n(int i, int i2) {
        if (i2 > 0) {
            ((AbstractList) this).modCount++;
        }
        bvy bvyVar = this.f;
        if (bvyVar != null) {
            bvyVar.n(i, i2);
        } else {
            bvz bvzVar = bvz.c;
            this.g.m(i, i2);
        }
        this.e -= i2;
    }

    public final int o(int i, int i2, Collection collection, boolean z) {
        int iN;
        bvy bvyVar = this.f;
        if (bvyVar != null) {
            iN = bvyVar.o(i, i2, collection, z);
        } else {
            bvz bvzVar = bvz.c;
            iN = this.g.n(i, i2, collection, z);
        }
        if (iN > 0) {
            ((AbstractList) this).modCount++;
        }
        this.e -= iN;
        return iN;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        l();
        k();
        int iIndexOf = indexOf(obj);
        if (iIndexOf >= 0) {
            b(iIndexOf);
        }
        return iIndexOf >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection collection) {
        throwIfVar1IsNull(collection, "elements");
        l();
        k();
        return o(this.d, this.e, collection, false) > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection collection) {
        throwIfVar1IsNull(collection, "elements");
        l();
        k();
        return o(this.d, this.e, collection, true) > 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        l();
        k();
        int i2 = this.e;
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException(StaticHelpers6.p(i, "index: ", ", size: ", i2));
        }
        Object[] objArr = this.c;
        int i3 = this.d;
        Object obj2 = objArr[i3 + i];
        objArr[i3 + i] = obj;
        return obj2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final List subList(int i, int i2) {
        cnh.l(i, i2, this.e);
        return new bvy(this.c, this.d + i, i2 - i, this, this.g);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] objArr) {
        throwIfVar1IsNull(objArr, "array");
        k();
        int length = objArr.length;
        int i = this.e;
        int i2 = this.d;
        if (length < i) {
            Object[] objArrCopyOfRange = Arrays.copyOfRange(this.c, i2, i + i2, objArr.getClass());
            throwIfVar1IsNull(objArrCopyOfRange, "copyOfRange(...)");
            return objArrCopyOfRange;
        }
        SomeStaticHelpers._aj(0, i2, this.c, i + i2, objArr);
        int i3 = this.e;
        if (i3 < objArr.length) {
            objArr[i3] = null;
        }
        return objArr;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        k();
        return FastKV.n(this.c, this.d, this.e, this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        k();
        int i2 = this.e;
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(StaticHelpers6.p(i, "index: ", ", size: ", i2));
        }
        return new bvx(this, i);
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        l();
        k();
        int i2 = this.e;
        if (i >= 0 && i <= i2) {
            j(this.d + i, obj);
            return;
        }
        throw new IndexOutOfBoundsException(StaticHelpers6.p(i, "index: ", ", size: ", i2));
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        throwIfVar1IsNull(collection, "elements");
        l();
        k();
        int i2 = this.e;
        if (i >= 0 && i <= i2) {
            int size = collection.size();
            i(this.d + i, collection, size);
            return size > 0;
        }
        throw new IndexOutOfBoundsException(StaticHelpers6.p(i, "index: ", ", size: ", i2));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        k();
        Object[] objArr = this.c;
        int i = this.e;
        int i2 = this.d;
        return SomeStaticHelpers.k(objArr, i2, i + i2);
    }
}
