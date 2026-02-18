package me.hd.wauxv.obf;

import java.util.List;
import java.util.ListIterator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dcz implements ListIterator, IEmpty {
    public final ListIterator a;
    public final /* synthetic */ bzv b;

    public dcz(bzv bzvVar, int i) {
        this.b = bzvVar;
        List list = (List) bzvVar.c;
        if (i >= 0 && i <= bzvVar.a()) {
            this.a = list.listIterator(bzvVar.a() - i);
            return;
        }
        StringBuilder sbR = yg.r(i, "Position index ", " must be in range [");
        sbR.append(new bqi(0, bzvVar.a(), 1));
        sbR.append("].");
        throw new IndexOutOfBoundsException(sbR.toString());
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.a.hasPrevious();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.a.hasNext();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        return this.a.previous();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return aba.af(this.b) - this.a.previousIndex();
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        return this.a.next();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return aba.af(this.b) - this.a.nextIndex();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
