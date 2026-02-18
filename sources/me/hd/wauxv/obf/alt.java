package me.hd.wauxv.obf;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class alt implements Iterator, bsw {
    public int a = -1;
    public int b;
    public int c;
    public bqi d;
    public final /* synthetic */ alu e;

    public alt(alu aluVar) {
        this.e = aluVar;
        int length = ((CharSequence) aluVar.b).length();
        if (length < 0) {
            throw new IllegalArgumentException(yg.f(length, "Cannot coerce value to an empty range: maximum ", " is less than minimum 0."));
        }
        length = length >= 0 ? 0 : length;
        this.b = length;
        this.c = length;
    }

    public final void f() {
        csm csmVar;
        alu aluVar = this.e;
        CharSequence charSequence = (CharSequence) aluVar.b;
        int i = this.c;
        if (i < 0) {
            this.a = 0;
            this.d = null;
            return;
        }
        if (i <= charSequence.length() && (csmVar = (csm) ((bgj) aluVar.c).g(charSequence, Integer.valueOf(this.c))) != null) {
            int iIntValue = ((Number) csmVar.a).intValue();
            int iIntValue2 = ((Number) csmVar.b).intValue();
            this.d = dqc.bm(this.b, iIntValue);
            int i2 = iIntValue + iIntValue2;
            this.b = i2;
            this.c = i2 + (iIntValue2 == 0 ? 1 : 0);
        } else {
            this.d = new bqi(this.b, dnj.ae(charSequence), 1);
            this.c = -1;
        }
        this.a = 1;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.a == -1) {
            f();
        }
        return this.a == 1;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.a == -1) {
            f();
        }
        if (this.a == 0) {
            throw new NoSuchElementException();
        }
        bqi bqiVar = this.d;
        bzo.o(bqiVar, "null cannot be cast to non-null type kotlin.ranges.IntRange");
        this.d = null;
        this.a = -1;
        return bqiVar;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
