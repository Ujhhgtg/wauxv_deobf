package me.hd.wauxv.obf;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bqg extends bqe {
    public final int a;
    public final int b;
    public boolean c;
    public int d;

    public bqg(int i, int i2, int i3) {
        this.a = i3;
        this.b = i2;
        boolean z = false;
        if (i3 <= 0 ? i >= i2 : i <= i2) {
            z = true;
        }
        this.c = z;
        this.d = z ? i : i2;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.c;
    }

    @Override // me.hd.wauxv.obf.bqe
    public final int nextInt() {
        int i = this.d;
        if (i != this.b) {
            this.d = this.a + i;
            return i;
        }
        if (!this.c) {
            throw new NoSuchElementException();
        }
        this.c = false;
        return i;
    }
}
