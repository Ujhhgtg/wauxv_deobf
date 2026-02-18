package me.hd.wauxv.obf;

import java.util.AbstractList;
import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bvx implements ListIterator, IEmpty {
    public int b;
    public int d;
    public final ad e;
    public final /* synthetic */ int a = 0;
    public int c = -1;

    public bvx(bvz bvzVar, int i) {
        this.e = bvzVar;
        this.b = i;
        this.d = ((AbstractList) bvzVar).modCount;
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        switch (this.a) {
            case 0:
                f();
                bvy bvyVar = (bvy) this.e;
                int i = this.b;
                this.b = i + 1;
                bvyVar.add(i, obj);
                this.c = -1;
                this.d = ((AbstractList) bvyVar).modCount;
                break;
            default:
                g();
                bvz bvzVar = (bvz) this.e;
                int i2 = this.b;
                this.b = i2 + 1;
                bvzVar.add(i2, obj);
                this.c = -1;
                this.d = ((AbstractList) bvzVar).modCount;
                break;
        }
    }

    public void f() {
        if (((AbstractList) ((bvy) this.e).g).modCount != this.d) {
            throw new ConcurrentModificationException();
        }
    }

    public void g() {
        if (((AbstractList) ((bvz) this.e)).modCount != this.d) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        switch (this.a) {
            case 0:
                return this.b < ((bvy) this.e).e;
            default:
                return this.b < ((bvz) this.e).e;
        }
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        switch (this.a) {
            case 0:
                return this.b > 0;
            default:
                return this.b > 0;
        }
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        switch (this.a) {
            case 0:
                f();
                int i = this.b;
                bvy bvyVar = (bvy) this.e;
                if (i >= bvyVar.e) {
                    throw new NoSuchElementException();
                }
                this.b = i + 1;
                this.c = i;
                return bvyVar.c[bvyVar.d + i];
            default:
                g();
                int i2 = this.b;
                bvz bvzVar = (bvz) this.e;
                if (i2 >= bvzVar.e) {
                    throw new NoSuchElementException();
                }
                this.b = i2 + 1;
                this.c = i2;
                return bvzVar.d[i2];
        }
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        switch (this.a) {
            case 0:
                break;
        }
        return this.b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        switch (this.a) {
            case 0:
                f();
                int i = this.b;
                if (i <= 0) {
                    throw new NoSuchElementException();
                }
                int i2 = i - 1;
                this.b = i2;
                this.c = i2;
                bvy bvyVar = (bvy) this.e;
                return bvyVar.c[bvyVar.d + i2];
            default:
                g();
                int i3 = this.b;
                if (i3 <= 0) {
                    throw new NoSuchElementException();
                }
                int i4 = i3 - 1;
                this.b = i4;
                this.c = i4;
                return ((bvz) this.e).d[i4];
        }
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        int i;
        switch (this.a) {
            case 0:
                i = this.b;
                break;
            default:
                i = this.b;
                break;
        }
        return i - 1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        switch (this.a) {
            case 0:
                bvy bvyVar = (bvy) this.e;
                f();
                int i = this.c;
                if (i == -1) {
                    throw new IllegalStateException(
                            "Call next() or previous() before removing element from the iterator.");
                }
                bvyVar.b(i);
                this.b = this.c;
                this.c = -1;
                this.d = ((AbstractList) bvyVar).modCount;
                return;
            default:
                bvz bvzVar = (bvz) this.e;
                g();
                int i2 = this.c;
                if (i2 == -1) {
                    throw new IllegalStateException(
                            "Call next() or previous() before removing element from the iterator.");
                }
                bvzVar.b(i2);
                this.b = this.c;
                this.c = -1;
                this.d = ((AbstractList) bvzVar).modCount;
                return;
        }
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        switch (this.a) {
            case 0:
                f();
                int i = this.c;
                if (i == -1) {
                    throw new IllegalStateException(
                            "Call next() or previous() before replacing element from the iterator.");
                }
                ((bvy) this.e).set(i, obj);
                return;
            default:
                g();
                int i2 = this.c;
                if (i2 == -1) {
                    throw new IllegalStateException(
                            "Call next() or previous() before replacing element from the iterator.");
                }
                ((bvz) this.e).set(i2, obj);
                return;
        }
    }

    public bvx(bvy bvyVar, int i) {
        this.e = bvyVar;
        this.b = i;
        this.d = ((AbstractList) bvyVar).modCount;
    }
}
