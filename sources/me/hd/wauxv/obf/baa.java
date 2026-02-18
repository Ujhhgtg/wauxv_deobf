package me.hd.wauxv.obf;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class baa implements Iterator, IEmpty {
    public final /* synthetic */ int a;
    public int b;
    public Object c;
    public Object d;
    public final /* synthetic */ dft e;

    public baa(alu aluVar) {
        this.a = 0;
        this.e = aluVar;
        ArrayDeque arrayDeque = new ArrayDeque();
        this.d = arrayDeque;
        File file = (File) aluVar.b;
        if (file.isDirectory()) {
            arrayDeque.push(h(file));
        } else if (file.isFile()) {
            arrayDeque.push(new azy(file));
        } else {
            this.b = 2;
        }
    }

    public void f() {
        bae baeVar = (bae) this.e;
        Iterator it = (Iterator) this.c;
        while (it.hasNext()) {
            Object next = it.next();
            if (((Boolean) baeVar.c.invoke(next)).booleanValue() == baeVar.b) {
                this.d = next;
                this.b = 1;
                return;
            }
        }
        this.b = 0;
    }

    public void g() {
        Iterator it = (Iterator) this.c;
        if (it.hasNext()) {
            Object next = it.next();
            if (((Boolean) ((dpu) this.e).c.invoke(next)).booleanValue()) {
                this.b = 1;
                this.d = next;
                return;
            }
        }
        this.b = 0;
    }

    public azw h(File file) {
        int iOrdinal = ((bac) ((alu) this.e).c).ordinal();
        if (iOrdinal == 0) {
            return new azz(file);
        }
        if (iOrdinal == 1) {
            return new azx(file);
        }
        throw new QueryDidNotReturnUniqueResultRuntimeException();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.a) {
            case 0:
                int i = this.b;
                if (i == 0) {
                    return i();
                }
                if (i == 1) {
                    return true;
                }
                if (i == 2) {
                    return false;
                }
                throw new IllegalArgumentException("hasNext called when the iterator is in the FAILED state.");
            case 1:
                if (this.b == -1) {
                    f();
                }
                return this.b == 1;
            default:
                if (this.b == -1) {
                    g();
                }
                return this.b == 1;
        }
    }

    public boolean i() {
        File file;
        this.b = 3;
        ArrayDeque arrayDeque = (ArrayDeque) this.d;
        while (true) {
            bab babVar = (bab) arrayDeque.peek();
            if (babVar == null) {
                file = null;
                break;
            }
            File fileE = babVar.e();
            if (fileE == null) {
                arrayDeque.pop();
            } else {
                if (fileE.equals(babVar.f) || !fileE.isDirectory() || arrayDeque.size() >= Integer.MAX_VALUE) {
                    file = fileE;
                    break;
                }
                arrayDeque.push(h(fileE));
            }
        }
        if (file != null) {
            this.c = file;
            this.b = 1;
        } else {
            this.b = 2;
        }
        return this.b == 1;
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.a) {
            case 0:
                int i = this.b;
                if (i == 1) {
                    this.b = 0;
                    return (File) this.c;
                }
                if (i == 2 || !i()) {
                    throw new NoSuchElementException();
                }
                this.b = 0;
                return (File) this.c;
            case 1:
                if (this.b == -1) {
                    f();
                }
                if (this.b == 0) {
                    throw new NoSuchElementException();
                }
                Object obj = this.d;
                this.d = null;
                this.b = -1;
                return obj;
            default:
                if (this.b == -1) {
                    g();
                }
                if (this.b == 0) {
                    throw new NoSuchElementException();
                }
                Object obj2 = this.d;
                this.d = null;
                this.b = -1;
                return obj2;
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.a) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case 1:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public baa(bae baeVar) {
        this.a = 1;
        this.e = baeVar;
        this.c = baeVar.a.iterator();
        this.b = -1;
    }

    public baa(dpu dpuVar) {
        this.a = 2;
        this.e = dpuVar;
        this.c = dpuVar.b.iterator();
        this.b = -1;
    }
}
