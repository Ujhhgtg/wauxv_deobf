package me.hd.wauxv.obf;

import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class km extends ad {
    public static final Object[] c = new Object[0];
    public int d;
    public Object[] e;
    public int f;

    public km() {
        this.e = c;
    }

    @Override // me.hd.wauxv.obf.ad
    public final int a() {
        return this.f;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int length;
        int i2 = this.f;
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(dkz.p(i, "index: ", ", size: ", i2));
        }
        if (i == i2) {
            addLast(obj);
            return;
        }
        if (i == 0) {
            addFirst(obj);
            return;
        }
        n();
        h(this.f + 1);
        int iM = m(this.d + i);
        int i3 = this.f;
        if (i < ((i3 + 1) >> 1)) {
            if (iM == 0) {
                Object[] objArr = this.e;
                throwIfVar1IsNull(objArr, "<this>");
                iM = objArr.length;
            }
            int i4 = iM - 1;
            int i5 = this.d;
            if (i5 == 0) {
                Object[] objArr2 = this.e;
                throwIfVar1IsNull(objArr2, "<this>");
                length = objArr2.length - 1;
            } else {
                length = i5 - 1;
            }
            int i6 = this.d;
            if (i4 >= i6) {
                Object[] objArr3 = this.e;
                objArr3[length] = objArr3[i6];
                SomeStaticHelpers._aj(i6, i6 + 1, objArr3, i4 + 1, objArr3);
            } else {
                Object[] objArr4 = this.e;
                SomeStaticHelpers._aj(i6 - 1, i6, objArr4, objArr4.length, objArr4);
                Object[] objArr5 = this.e;
                objArr5[objArr5.length - 1] = objArr5[0];
                SomeStaticHelpers._aj(0, 1, objArr5, i4 + 1, objArr5);
            }
            this.e[i4] = obj;
            this.d = length;
        } else {
            int iM2 = m(i3 + this.d);
            if (iM < iM2) {
                Object[] objArr6 = this.e;
                SomeStaticHelpers._aj(iM + 1, iM, objArr6, iM2, objArr6);
            } else {
                Object[] objArr7 = this.e;
                SomeStaticHelpers._aj(1, 0, objArr7, iM2, objArr7);
                Object[] objArr8 = this.e;
                objArr8[0] = objArr8[objArr8.length - 1];
                SomeStaticHelpers._aj(iM + 1, iM, objArr8, objArr8.length - 1, objArr8);
            }
            this.e[iM] = obj;
        }
        this.f++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        throwIfVar1IsNull(collection, "elements");
        int i2 = this.f;
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(dkz.p(i, "index: ", ", size: ", i2));
        }
        if (collection.isEmpty()) {
            return false;
        }
        if (i == this.f) {
            return addAll(collection);
        }
        n();
        h(collection.size() + this.f);
        int iM = m(this.f + this.d);
        int iM2 = m(this.d + i);
        int size = collection.size();
        if (i >= ((this.f + 1) >> 1)) {
            int i3 = iM2 + size;
            if (iM2 < iM) {
                int i4 = size + iM;
                Object[] objArr = this.e;
                if (i4 <= objArr.length) {
                    SomeStaticHelpers._aj(i3, iM2, objArr, iM, objArr);
                } else if (i3 >= objArr.length) {
                    SomeStaticHelpers._aj(i3 - objArr.length, iM2, objArr, iM, objArr);
                } else {
                    int length = iM - (i4 - objArr.length);
                    SomeStaticHelpers._aj(0, length, objArr, iM, objArr);
                    Object[] objArr2 = this.e;
                    SomeStaticHelpers._aj(i3, iM2, objArr2, length, objArr2);
                }
            } else {
                Object[] objArr3 = this.e;
                SomeStaticHelpers._aj(size, 0, objArr3, iM, objArr3);
                Object[] objArr4 = this.e;
                if (i3 >= objArr4.length) {
                    SomeStaticHelpers._aj(i3 - objArr4.length, iM2, objArr4, objArr4.length, objArr4);
                } else {
                    SomeStaticHelpers._aj(0, objArr4.length - size, objArr4, objArr4.length, objArr4);
                    Object[] objArr5 = this.e;
                    SomeStaticHelpers._aj(i3, iM2, objArr5, objArr5.length - size, objArr5);
                }
            }
            g(iM2, collection);
            return true;
        }
        int i5 = this.d;
        int length2 = i5 - size;
        if (iM2 < i5) {
            Object[] objArr6 = this.e;
            SomeStaticHelpers._aj(length2, i5, objArr6, objArr6.length, objArr6);
            if (size >= iM2) {
                Object[] objArr7 = this.e;
                SomeStaticHelpers._aj(objArr7.length - size, 0, objArr7, iM2, objArr7);
            } else {
                Object[] objArr8 = this.e;
                SomeStaticHelpers._aj(objArr8.length - size, 0, objArr8, size, objArr8);
                Object[] objArr9 = this.e;
                SomeStaticHelpers._aj(0, size, objArr9, iM2, objArr9);
            }
        } else if (length2 >= 0) {
            Object[] objArr10 = this.e;
            SomeStaticHelpers._aj(length2, i5, objArr10, iM2, objArr10);
        } else {
            Object[] objArr11 = this.e;
            length2 += objArr11.length;
            int i6 = iM2 - i5;
            int length3 = objArr11.length - length2;
            if (length3 >= i6) {
                SomeStaticHelpers._aj(length2, i5, objArr11, iM2, objArr11);
            } else {
                SomeStaticHelpers._aj(length2, i5, objArr11, i5 + length3, objArr11);
                Object[] objArr12 = this.e;
                SomeStaticHelpers._aj(0, this.d + length3, objArr12, iM2, objArr12);
            }
        }
        this.d = length2;
        g(k(iM2 - size), collection);
        return true;
    }

    public final void addFirst(Object obj) {
        n();
        h(this.f + 1);
        int length = this.d;
        if (length == 0) {
            Object[] objArr = this.e;
            throwIfVar1IsNull(objArr, "<this>");
            length = objArr.length;
        }
        int i = length - 1;
        this.d = i;
        this.e[i] = obj;
        this.f++;
    }

    public final void addLast(Object obj) {
        n();
        h(a() + 1);
        this.e[m(a() + this.d)] = obj;
        this.f = a() + 1;
    }

    @Override // me.hd.wauxv.obf.ad
    public final Object b(int i) {
        int i2 = this.f;
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException(dkz.p(i, "index: ", ", size: ", i2));
        }
        if (i == OtherStaticHelpers.af(this)) {
            return removeLast();
        }
        if (i == 0) {
            return removeFirst();
        }
        n();
        int iM = m(this.d + i);
        Object[] objArr = this.e;
        Object obj = objArr[iM];
        if (i < (this.f >> 1)) {
            int i3 = this.d;
            if (iM >= i3) {
                SomeStaticHelpers._aj(i3 + 1, i3, objArr, iM, objArr);
            } else {
                SomeStaticHelpers._aj(1, 0, objArr, iM, objArr);
                Object[] objArr2 = this.e;
                objArr2[0] = objArr2[objArr2.length - 1];
                int i4 = this.d;
                SomeStaticHelpers._aj(i4 + 1, i4, objArr2, objArr2.length - 1, objArr2);
            }
            Object[] objArr3 = this.e;
            int i5 = this.d;
            objArr3[i5] = null;
            this.d = i(i5);
        } else {
            int iM2 = m(OtherStaticHelpers.af(this) + this.d);
            if (iM <= iM2) {
                Object[] objArr4 = this.e;
                SomeStaticHelpers._aj(iM, iM + 1, objArr4, iM2 + 1, objArr4);
            } else {
                Object[] objArr5 = this.e;
                SomeStaticHelpers._aj(iM, iM + 1, objArr5, objArr5.length, objArr5);
                Object[] objArr6 = this.e;
                objArr6[objArr6.length - 1] = objArr6[0];
                SomeStaticHelpers._aj(0, 1, objArr6, iM2 + 1, objArr6);
            }
            this.e[iM2] = null;
        }
        this.f--;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection,
              // java.util.List
    public final void clear() {
        if (!isEmpty()) {
            n();
            l(this.d, m(a() + this.d));
        }
        this.d = 0;
        this.f = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final Object first() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        return this.e[this.d];
    }

    public final void g(int i, Collection collection) {
        Iterator it = collection.iterator();
        int length = this.e.length;
        while (i < length && it.hasNext()) {
            this.e[i] = it.next();
            i++;
        }
        int i2 = this.d;
        for (int i3 = 0; i3 < i2 && it.hasNext(); i3++) {
            this.e[i3] = it.next();
        }
        this.f = collection.size() + this.f;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        int iA = a();
        if (i < 0 || i >= iA) {
            throw new IndexOutOfBoundsException(dkz.p(i, "index: ", ", size: ", iA));
        }
        return this.e[m(this.d + i)];
    }

    public final void h(int i) {
        if (i < 0) {
            throw new IllegalStateException("Deque is too big.");
        }
        Object[] objArr = this.e;
        if (i <= objArr.length) {
            return;
        }
        if (objArr == c) {
            if (i < 10) {
                i = 10;
            }
            this.e = new Object[i];
            return;
        }
        int length = objArr.length;
        int i2 = length + (length >> 1);
        if (i2 - i < 0) {
            i2 = i;
        }
        if (i2 - 2147483639 > 0) {
            i2 = i > 2147483639 ? Integer.MAX_VALUE : 2147483639;
        }
        Object[] objArr2 = new Object[i2];
        SomeStaticHelpers._aj(0, this.d, objArr, objArr.length, objArr2);
        Object[] objArr3 = this.e;
        int length2 = objArr3.length;
        int i3 = this.d;
        SomeStaticHelpers._aj(length2 - i3, 0, objArr3, i3, objArr2);
        this.d = 0;
        this.e = objArr2;
    }

    public final int i(int i) {
        throwIfVar1IsNull(this.e, "<this>");
        if (i == r0.length - 1) {
            return 0;
        }
        return i + 1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        int i;
        int iM = m(a() + this.d);
        int length = this.d;
        if (length < iM) {
            while (length < iM) {
                if (nullSafeIsEqual(obj, this.e[length])) {
                    i = this.d;
                } else {
                    length++;
                }
            }
            return -1;
        }
        if (length < iM) {
            return -1;
        }
        int length2 = this.e.length;
        while (length < length2) {
            if (nullSafeIsEqual(obj, this.e[length])) {
                i = this.d;
            } else {
                length++;
            }
        }
        for (int i2 = 0; i2 < iM; i2++) {
            if (nullSafeIsEqual(obj, this.e[i2])) {
                length = i2 + this.e.length;
                i = this.d;
            }
        }
        return -1;
        return length - i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return a() == 0;
    }

    public final Object j() {
        if (isEmpty()) {
            return null;
        }
        return this.e[m(OtherStaticHelpers.af(this) + this.d)];
    }

    public final int k(int i) {
        return i < 0 ? i + this.e.length : i;
    }

    public final void l(int i, int i2) {
        if (i < i2) {
            SomeStaticHelpers.l(this.e, i, i2);
            return;
        }
        Object[] objArr = this.e;
        SomeStaticHelpers.l(objArr, i, objArr.length);
        SomeStaticHelpers.l(this.e, 0, i2);
    }

    public final Object last() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        return this.e[m(OtherStaticHelpers.af(this) + this.d)];
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        int length;
        int i;
        int iM = m(this.f + this.d);
        int i2 = this.d;
        if (i2 < iM) {
            length = iM - 1;
            if (i2 <= length) {
                while (!nullSafeIsEqual(obj, this.e[length])) {
                    if (length != i2) {
                        length--;
                    }
                }
                i = this.d;
                return length - i;
            }
            return -1;
        }
        if (i2 > iM) {
            for (int i3 = iM - 1; -1 < i3; i3--) {
                if (nullSafeIsEqual(obj, this.e[i3])) {
                    length = i3 + this.e.length;
                    i = this.d;
                    return length - i;
                }
            }
            Object[] objArr = this.e;
            throwIfVar1IsNull(objArr, "<this>");
            length = objArr.length - 1;
            int i4 = this.d;
            if (i4 <= length) {
                while (!nullSafeIsEqual(obj, this.e[length])) {
                    if (length != i4) {
                        length--;
                    }
                }
                i = this.d;
                return length - i;
            }
        }
        return -1;
    }

    public final int m(int i) {
        Object[] objArr = this.e;
        return i >= objArr.length ? i - objArr.length : i;
    }

    public final void n() {
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf == -1) {
            return false;
        }
        b(iIndexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection collection) {
        int iM;
        throwIfVar1IsNull(collection, "elements");
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty() && this.e.length != 0) {
            int iM2 = m(this.f + this.d);
            int i = this.d;
            if (i < iM2) {
                iM = i;
                while (i < iM2) {
                    Object obj = this.e[i];
                    if (collection.contains(obj)) {
                        z = true;
                    } else {
                        this.e[iM] = obj;
                        iM++;
                    }
                    i++;
                }
                SomeStaticHelpers.l(this.e, iM, iM2);
            } else {
                int length = this.e.length;
                boolean z2 = false;
                int i2 = i;
                while (i < length) {
                    Object[] objArr = this.e;
                    Object obj2 = objArr[i];
                    objArr[i] = null;
                    if (collection.contains(obj2)) {
                        z2 = true;
                    } else {
                        this.e[i2] = obj2;
                        i2++;
                    }
                    i++;
                }
                iM = m(i2);
                for (int i3 = 0; i3 < iM2; i3++) {
                    Object[] objArr2 = this.e;
                    Object obj3 = objArr2[i3];
                    objArr2[i3] = null;
                    if (collection.contains(obj3)) {
                        z2 = true;
                    } else {
                        this.e[iM] = obj3;
                        iM = i(iM);
                    }
                }
                z = z2;
            }
            if (z) {
                n();
                this.f = k(iM - this.d);
            }
        }
        return z;
    }

    public final Object removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        n();
        Object[] objArr = this.e;
        int i = this.d;
        Object obj = objArr[i];
        objArr[i] = null;
        this.d = i(i);
        this.f = a() - 1;
        return obj;
    }

    public final Object removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        n();
        int iM = m(OtherStaticHelpers.af(this) + this.d);
        Object[] objArr = this.e;
        Object obj = objArr[iM];
        objArr[iM] = null;
        this.f = a() - 1;
        return obj;
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i2) {
        cnh.l(i, i2, this.f);
        int i3 = i2 - i;
        if (i3 == 0) {
            return;
        }
        if (i3 == this.f) {
            clear();
            return;
        }
        if (i3 == 1) {
            b(i);
            return;
        }
        n();
        if (i < this.f - i2) {
            int iM = m(this.d + (i - 1));
            int iM2 = m(this.d + (i2 - 1));
            while (i > 0) {
                int i4 = iM + 1;
                int iMin = Math.min(i, Math.min(i4, iM2 + 1));
                Object[] objArr = this.e;
                int i5 = iM2 - iMin;
                int i6 = iM - iMin;
                SomeStaticHelpers._aj(i5 + 1, i6 + 1, objArr, i4, objArr);
                iM = k(i6);
                iM2 = k(i5);
                i -= iMin;
            }
            int iM3 = m(this.d + i3);
            l(this.d, iM3);
            this.d = iM3;
        } else {
            int iM4 = m(this.d + i2);
            int iM5 = m(this.d + i);
            int i7 = this.f;
            while (true) {
                i7 -= i2;
                if (i7 <= 0) {
                    break;
                }
                Object[] objArr2 = this.e;
                i2 = Math.min(i7, Math.min(objArr2.length - iM4, objArr2.length - iM5));
                Object[] objArr3 = this.e;
                int i8 = iM4 + i2;
                SomeStaticHelpers._aj(iM5, iM4, objArr3, i8, objArr3);
                iM4 = m(i8);
                iM5 = m(iM5 + i2);
            }
            int iM6 = m(this.f + this.d);
            l(k(iM6 - i3), iM6);
        }
        this.f -= i3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection collection) {
        int iM;
        throwIfVar1IsNull(collection, "elements");
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty() && this.e.length != 0) {
            int iM2 = m(this.f + this.d);
            int i = this.d;
            if (i < iM2) {
                iM = i;
                while (i < iM2) {
                    Object obj = this.e[i];
                    if (collection.contains(obj)) {
                        this.e[iM] = obj;
                        iM++;
                    } else {
                        z = true;
                    }
                    i++;
                }
                SomeStaticHelpers.l(this.e, iM, iM2);
            } else {
                int length = this.e.length;
                boolean z2 = false;
                int i2 = i;
                while (i < length) {
                    Object[] objArr = this.e;
                    Object obj2 = objArr[i];
                    objArr[i] = null;
                    if (collection.contains(obj2)) {
                        this.e[i2] = obj2;
                        i2++;
                    } else {
                        z2 = true;
                    }
                    i++;
                }
                iM = m(i2);
                for (int i3 = 0; i3 < iM2; i3++) {
                    Object[] objArr2 = this.e;
                    Object obj3 = objArr2[i3];
                    objArr2[i3] = null;
                    if (collection.contains(obj3)) {
                        this.e[iM] = obj3;
                        iM = i(iM);
                    } else {
                        z2 = true;
                    }
                }
                z = z2;
            }
            if (z) {
                n();
                this.f = k(iM - this.d);
            }
        }
        return z;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        int iA = a();
        if (i < 0 || i >= iA) {
            throw new IndexOutOfBoundsException(dkz.p(i, "index: ", ", size: ", iA));
        }
        int iM = m(this.d + i);
        Object[] objArr = this.e;
        Object obj2 = objArr[iM];
        objArr[iM] = obj;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        return toArray(new Object[a()]);
    }

    public km(int i) {
        Object[] objArr;
        if (i == 0) {
            objArr = c;
        } else if (i > 0) {
            objArr = new Object[i];
        } else {
            throw new IllegalArgumentException(concatVar2Var1(i, "Illegal Capacity: "));
        }
        this.e = objArr;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] objArr) {
        throwIfVar1IsNull(objArr, "array");
        int length = objArr.length;
        int i = this.f;
        if (length < i) {
            Object objNewInstance = Array.newInstance(objArr.getClass().getComponentType(), i);
            throwIfVar1IsNull(objNewInstance,
                    "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
            objArr = (Object[]) objNewInstance;
        }
        int iM = m(this.f + this.d);
        int i2 = this.d;
        if (i2 < iM) {
            SomeStaticHelpers._am(i2, iM, this.e, 2, objArr);
        } else if (!isEmpty()) {
            Object[] objArr2 = this.e;
            SomeStaticHelpers._aj(0, this.d, objArr2, objArr2.length, objArr);
            Object[] objArr3 = this.e;
            SomeStaticHelpers._aj(objArr3.length - this.d, 0, objArr3, iM, objArr);
        }
        int i3 = this.f;
        if (i3 < objArr.length) {
            objArr[i3] = null;
        }
        return objArr;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection,
              // java.util.List
    public final boolean add(Object obj) {
        addLast(obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        throwIfVar1IsNull(collection, "elements");
        if (collection.isEmpty()) {
            return false;
        }
        n();
        h(collection.size() + a());
        g(m(a() + this.d), collection);
        return true;
    }
}
