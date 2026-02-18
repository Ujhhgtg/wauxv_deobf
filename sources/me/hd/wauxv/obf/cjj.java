package me.hd.wauxv.obf;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cjj implements Iterator, IEmpty {
    public int a = -1;
    public boolean b;
    public final /* synthetic */ xe c;

    public cjj(xe xeVar) {
        this.c = xeVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a + 1 < ((dlo) this.c.e).i();
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.b = true;
        dlo dloVar = (dlo) this.c.e;
        int i = this.a + 1;
        this.a = i;
        return (cjg) dloVar.j(i);
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.b) {
            throw new IllegalStateException("You must call next() before you can remove an element");
        }
        dlo dloVar = (dlo) this.c.e;
        ((cjg) dloVar.j(this.a)).h = null;
        int i = this.a;
        Object[] objArr = dloVar.c;
        Object obj = objArr[i];
        Object obj2 = bht.p;
        if (obj != obj2) {
            objArr[i] = obj2;
            dloVar.a = true;
        }
        this.a = i - 1;
        this.b = false;
    }
}
