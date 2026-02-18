package me.hd.wauxv.obf;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class emv implements Collection, bsw {
    public final int[] a;

    @Override // java.util.Collection
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX WARN: Found duplicated region for block: B:13:0x001b A[RETURN] */
    /* JADX WARN: Found duplicated region for block: B:15:0x001d A[RETURN] */
    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        if (!(obj instanceof emu)) {
            return false;
        }
        int i = ((emu) obj).a;
        int[] iArr = this.a;
        int length = iArr.length;
        int i2 = 0;
        while (i2 < length) {
            if (i == iArr[i2]) {
                return i2 >= 0;
            }
            i2++;
        }
        i2 = -1;
        if (i2 >= 0) {
        }
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection collection) {
        bzo.q(collection, "elements");
        if (!collection.isEmpty()) {
            for (Object obj : collection) {
                if (obj instanceof emu) {
                    int i = ((emu) obj).a;
                    int[] iArr = this.a;
                    int length = iArr.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            i2 = -1;
                            break;
                        }
                        if (i == iArr[i2]) {
                            break;
                        }
                        i2++;
                    }
                    if (i2 >= 0) {
                    }
                }
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection
    public final boolean equals(Object obj) {
        if (obj instanceof emv) {
            return bzo.f(this.a, ((emv) obj).a);
        }
        return false;
    }

    @Override // java.util.Collection
    public final int hashCode() {
        return Arrays.hashCode(this.a);
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        return this.a.length == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new z(this.a, 5);
    }

    @Override // java.util.Collection
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final int size() {
        return this.a.length;
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        return bmy.ah(this);
    }

    public final String toString() {
        return "UIntArray(storage=" + Arrays.toString(this.a) + ')';
    }

    @Override // java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        bzo.q(objArr, "array");
        return bmy.ai(this, objArr);
    }
}
