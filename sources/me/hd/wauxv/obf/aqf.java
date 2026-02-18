package me.hd.wauxv.obf;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class aqf implements Iterator, IEmpty {
    public final /* synthetic */ int a = 1;
    public final Iterator b;
    public int c;

    public aqf(Iterator it) {
        throwIfVar1IsNull(it, "iterator");
        this.b = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        Iterator it;
        switch (this.a) {
            case 0:
                break;
            default:
                return this.b.hasNext();
        }
        while (true) {
            int i = this.c;
            it = this.b;
            if (i > 0 && it.hasNext()) {
                it.next();
                this.c--;
            }
        }
        return it.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        Iterator it;
        switch (this.a) {
            case 0:
                break;
            default:
                int i = this.c;
                this.c = i + 1;
                if (i >= 0) {
                    return new boy(i, this.b.next());
                }
                aba.aj();
                throw null;
        }
        while (true) {
            int i2 = this.c;
            it = this.b;
            if (i2 > 0 && it.hasNext()) {
                it.next();
                this.c--;
            }
        }
        return it.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.a) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public aqf(aqg aqgVar) {
        this.b = aqgVar.a.iterator();
        this.c = aqgVar.b;
    }
}
