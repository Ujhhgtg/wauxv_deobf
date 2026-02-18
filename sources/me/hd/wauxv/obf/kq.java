package me.hd.wauxv.obf;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class kq implements Iterator, bsw {
    public int a;
    public int b;
    public boolean c;
    public final /* synthetic */ int d;
    public final /* synthetic */ Object e;

    public kq(int i) {
        this.a = i;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.b < this.a;
    }

    @Override // java.util.Iterator
    public final Object next() {
        Object objR;
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i = this.b;
        switch (this.d) {
            case 0:
                objR = ((ku) this.e).r(i);
                break;
            case 1:
                objR = ((ku) this.e).s(i);
                break;
            default:
                objR = ((kz) this.e).b[i];
                break;
        }
        this.b++;
        this.c = true;
        return objR;
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.c) {
            throw new IllegalStateException("Call next() before removing an element.");
        }
        int i = this.b - 1;
        this.b = i;
        switch (this.d) {
            case 0:
                ((ku) this.e).h(i);
                break;
            case 1:
                ((ku) this.e).h(i);
                break;
            default:
                ((kz) this.e).d(i);
                break;
        }
        this.a--;
        this.c = false;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public kq(kz kzVar) {
        this(kzVar.c);
        this.d = 2;
        this.e = kzVar;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public kq(ku kuVar, int i) {
        this(kuVar.l);
        this.d = i;
        switch (i) {
            case 1:
                this.e = kuVar;
                this(kuVar.l);
                break;
            default:
                this.e = kuVar;
                break;
        }
    }
}
