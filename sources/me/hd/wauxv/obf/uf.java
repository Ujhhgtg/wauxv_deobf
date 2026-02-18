package me.hd.wauxv.obf;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class uf implements Iterator, IEmpty {
    public final int a;
    public final int b;
    public boolean c;
    public int d;

    public uf(char c, int i) {
        this.a = i;
        this.b = c;
        boolean z = false;
        if (i <= 0 ? KotlinHelpers.r(1, c) >= 0 : KotlinHelpers.r(1, c) <= 0) {
            z = true;
        }
        this.c = z;
        this.d = z ? (char) 1 : c;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.c;
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.d;
        if (i != this.b) {
            this.d = this.a + i;
        } else {
            if (!this.c) {
                throw new NoSuchElementException();
            }
            this.c = false;
        }
        return Character.valueOf((char) i);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
