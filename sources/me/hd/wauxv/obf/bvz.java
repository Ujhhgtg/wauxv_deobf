package me.hd.wauxv.obf;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bvz extends ad implements RandomAccess, Serializable {
    public static final bvz c;
    public Object[] d;
    public int e;
    public boolean f;

    static {
        bvz bvzVar = new bvz(0);
        bvzVar.f = true;
        c = bvzVar;
    }

    public bvz(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("capacity must be non-negative.");
        }
        this.d = new Object[i];
    }

    @Override // me.hd.wauxv.obf.ad
    public final int a() {
        return this.e;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection,
              // java.util.List
    public final boolean add(Object obj) {
        j();
        int i = this.e;
        ((AbstractList) this).modCount++;
        k(i, 1);
        this.d[i] = obj;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        throwIfVar1IsNull(collection, "elements");
        j();
        int size = collection.size();
        h(this.e, collection, size);
        return size > 0;
    }

    @Override // me.hd.wauxv.obf.ad
    public final Object b(int i) {
        j();
        int i2 = this.e;
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException(StaticHelpers6.p(i, "index: ", ", size: ", i2));
        }
        return l(i);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection,
              // java.util.List
    public final void clear() {
        j();
        m(0, this.e);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            Object[] objArr = this.d;
            int i = this.e;
            if (i == list.size()) {
                for (int i2 = 0; i2 < i; i2++) {
                    if (nullSafeIsEqual(objArr[i2], list.get(i2))) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        int i2 = this.e;
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException(StaticHelpers6.p(i, "index: ", ", size: ", i2));
        }
        return this.d[i];
    }

    public final void h(int i, Collection collection, int i2) {
        ((AbstractList) this).modCount++;
        k(i, i2);
        Iterator it = collection.iterator();
        for (int i3 = 0; i3 < i2; i3++) {
            this.d[i + i3] = it.next();
        }
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        Object[] objArr = this.d;
        int i = this.e;
        int iHashCode = 1;
        for (int i2 = 0; i2 < i; i2++) {
            Object obj = objArr[i2];
            iHashCode = (iHashCode * 31) + (obj != null ? obj.hashCode() : 0);
        }
        return iHashCode;
    }

    public final void i(int i, Object obj) {
        ((AbstractList) this).modCount++;
        k(i, 1);
        this.d[i] = obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        for (int i = 0; i < this.e; i++) {
            if (nullSafeIsEqual(this.d[i], obj)) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return this.e == 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection,
              // java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return listIterator(0);
    }

    public final void j() {
        if (this.f) {
            throw new UnsupportedOperationException();
        }
    }

    public final void k(int i, int i2) {
        int i3 = this.e + i2;
        if (i3 < 0) {
            throw new OutOfMemoryError();
        }
        Object[] objArr = this.d;
        if (i3 > objArr.length) {
            int length = objArr.length;
            int i4 = length + (length >> 1);
            if (i4 - i3 < 0) {
                i4 = i3;
            }
            if (i4 - 2147483639 > 0) {
                i4 = i3 > 2147483639 ? Integer.MAX_VALUE : 2147483639;
            }
            Object[] objArrCopyOf = Arrays.copyOf(objArr, i4);
            throwIfVar1IsNull(objArrCopyOf, "copyOf(...)");
            this.d = objArrCopyOf;
        }
        Object[] objArr2 = this.d;
        SomeStaticHelpers._aj(i + i2, i, objArr2, this.e, objArr2);
        this.e += i2;
    }

    public final Object l(int i) {
        ((AbstractList) this).modCount++;
        Object[] objArr = this.d;
        Object obj = objArr[i];
        SomeStaticHelpers._aj(i, i + 1, objArr, this.e, objArr);
        Object[] objArr2 = this.d;
        int i2 = this.e - 1;
        throwIfVar1IsNull(objArr2, "<this>");
        objArr2[i2] = null;
        this.e--;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        for (int i = this.e - 1; i >= 0; i--) {
            if (nullSafeIsEqual(this.d[i], obj)) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator() {
        return listIterator(0);
    }

    public final void m(int i, int i2) {
        if (i2 > 0) {
            ((AbstractList) this).modCount++;
        }
        Object[] objArr = this.d;
        SomeStaticHelpers._aj(i, i + i2, objArr, this.e, objArr);
        Object[] objArr2 = this.d;
        int i3 = this.e;
        FastKV.az(objArr2, i3 - i2, i3);
        this.e -= i2;
    }

    public final int n(int i, int i2, Collection collection, boolean z) {
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2) {
            int i5 = i + i3;
            if (collection.contains(this.d[i5]) == z) {
                Object[] objArr = this.d;
                i3++;
                objArr[i4 + i] = objArr[i5];
                i4++;
            } else {
                i3++;
            }
        }
        int i6 = i2 - i4;
        Object[] objArr2 = this.d;
        SomeStaticHelpers._aj(i + i4, i2 + i, objArr2, this.e, objArr2);
        Object[] objArr3 = this.d;
        int i7 = this.e;
        FastKV.az(objArr3, i7 - i6, i7);
        if (i6 > 0) {
            ((AbstractList) this).modCount++;
        }
        this.e -= i6;
        return i6;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        j();
        int iIndexOf = indexOf(obj);
        if (iIndexOf >= 0) {
            b(iIndexOf);
        }
        return iIndexOf >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection collection) {
        throwIfVar1IsNull(collection, "elements");
        j();
        return n(0, this.e, collection, false) > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection collection) {
        throwIfVar1IsNull(collection, "elements");
        j();
        return n(0, this.e, collection, true) > 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        j();
        int i2 = this.e;
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException(StaticHelpers6.p(i, "index: ", ", size: ", i2));
        }
        Object[] objArr = this.d;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        return obj2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final List subList(int i, int i2) {
        cnh.l(i, i2, this.e);
        return new bvy(this.d, i, i2 - i, null, this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] objArr) {
        throwIfVar1IsNull(objArr, "array");
        int length = objArr.length;
        int i = this.e;
        if (length < i) {
            Object[] objArrCopyOfRange = Arrays.copyOfRange(this.d, 0, i, objArr.getClass());
            throwIfVar1IsNull(objArrCopyOfRange, "copyOfRange(...)");
            return objArrCopyOfRange;
        }
        SomeStaticHelpers._aj(0, 0, this.d, i, objArr);
        int i2 = this.e;
        if (i2 < objArr.length) {
            objArr[i2] = null;
        }
        return objArr;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return FastKV.n(this.d, 0, this.e, this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        int i2 = this.e;
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(StaticHelpers6.p(i, "index: ", ", size: ", i2));
        }
        return new bvx(this, i);
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        throwIfVar1IsNull(collection, "elements");
        j();
        int i2 = this.e;
        if (i >= 0 && i <= i2) {
            int size = collection.size();
            h(i, collection, size);
            return size > 0;
        }
        throw new IndexOutOfBoundsException(StaticHelpers6.p(i, "index: ", ", size: ", i2));
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        j();
        int i2 = this.e;
        if (i >= 0 && i <= i2) {
            ((AbstractList) this).modCount++;
            k(i, 1);
            this.d[i] = obj;
            return;
        }
        throw new IndexOutOfBoundsException(StaticHelpers6.p(i, "index: ", ", size: ", i2));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        return SomeStaticHelpers.k(this.d, 0, this.e);
    }
}
