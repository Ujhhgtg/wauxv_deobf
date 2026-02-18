package me.hd.wauxv.obf;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dfu implements Iterator, afw, bsw {
    public int a;
    public Object d;
    public Iterator e;
    public afw f;

    @Override // me.hd.wauxv.obf.afw
    public final void _bn(Object obj) throws Throwable {
        bhu.bd(obj);
        this.a = 4;
    }

    @Override // me.hd.wauxv.obf.afw
    public final ahh c() {
        return auz.a;
    }

    public final RuntimeException g() {
        int i = this.a;
        if (i == 4) {
            return new NoSuchElementException();
        }
        if (i == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.a);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        while (true) {
            int i = this.a;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2 || i == 3) {
                        return true;
                    }
                    if (i == 4) {
                        return false;
                    }
                    throw g();
                }
                Iterator it = this.e;
                bzo.n(it);
                if (it.hasNext()) {
                    this.a = 2;
                    return true;
                }
                this.e = null;
            }
            this.a = 5;
            afw afwVar = this.f;
            bzo.n(afwVar);
            this.f = null;
            afwVar._bn(ens.a);
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.a;
        if (i == 0 || i == 1) {
            if (hasNext()) {
                return next();
            }
            throw new NoSuchElementException();
        }
        if (i == 2) {
            this.a = 1;
            Iterator it = this.e;
            bzo.n(it);
            return it.next();
        }
        if (i != 3) {
            throw g();
        }
        this.a = 0;
        Object obj = this.d;
        this.d = null;
        return obj;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
