package me.hd.wauxv.obf;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bgy implements Iterator, IEmpty {
    public Object a;
    public int b = -2;
    public final /* synthetic */ alu c;

    public bgy(alu aluVar) {
        this.c = aluVar;
    }

    public final void d() {
        Object objInvoke;
        int i = this.b;
        alu aluVar = this.c;
        if (i == -2) {
            objInvoke = ((bfu) aluVar.b).invoke();
        } else {
            IInvokable bgfVar = (IInvokable) aluVar.c;
            Object obj = this.a;
            throwIfVar1IsNull(obj);
            objInvoke = bgfVar.invoke(obj);
        }
        this.a = objInvoke;
        this.b = objInvoke == null ? 0 : 1;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.b < 0) {
            d();
        }
        return this.b == 1;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.b < 0) {
            d();
        }
        if (this.b == 0) {
            throw new NoSuchElementException();
        }
        Object obj = this.a;
        throwIfVar1IsNull(obj, "null cannot be cast to non-null type T of kotlin.sequences.GeneratorSequence");
        this.b = -1;
        return obj;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
