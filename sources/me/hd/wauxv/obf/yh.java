package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class yh {
    public long a = 0;
    public yh b;

    public final void c(int i) {
        if (i < 64) {
            this.a &= ~(1 << i);
            return;
        }
        yh yhVar = this.b;
        if (yhVar != null) {
            yhVar.c(i - 64);
        }
    }

    public final int d(int i) {
        yh yhVar = this.b;
        if (yhVar == null) {
            return i >= 64 ? Long.bitCount(this.a) : Long.bitCount(this.a & ((1 << i) - 1));
        }
        if (i < 64) {
            return Long.bitCount(this.a & ((1 << i) - 1));
        }
        return Long.bitCount(this.a) + yhVar.d(i - 64);
    }

    public final void e() {
        if (this.b == null) {
            this.b = new yh();
        }
    }

    public final boolean f(int i) {
        if (i < 64) {
            return (this.a & (1 << i)) != 0;
        }
        e();
        return this.b.f(i - 64);
    }

    public final void g(int i, boolean z) {
        if (i >= 64) {
            e();
            this.b.g(i - 64, z);
            return;
        }
        long j = this.a;
        boolean z2 = (Long.MIN_VALUE & j) != 0;
        long j2 = (1 << i) - 1;
        this.a = ((j & (~j2)) << 1) | (j & j2);
        if (z) {
            j(i);
        } else {
            c(i);
        }
        if (z2 || this.b != null) {
            e();
            this.b.g(0, z2);
        }
    }

    public final boolean h(int i) {
        if (i >= 64) {
            e();
            return this.b.h(i - 64);
        }
        long j = 1 << i;
        long j2 = this.a;
        boolean z = (j2 & j) != 0;
        long j3 = j2 & (~j);
        this.a = j3;
        long j4 = j - 1;
        this.a = (j3 & j4) | Long.rotateRight((~j4) & j3, 1);
        yh yhVar = this.b;
        if (yhVar != null) {
            if (yhVar.f(0)) {
                j(63);
            }
            this.b.h(0);
        }
        return z;
    }

    public final void i() {
        this.a = 0L;
        yh yhVar = this.b;
        if (yhVar != null) {
            yhVar.i();
        }
    }

    public final void j(int i) {
        if (i < 64) {
            this.a |= 1 << i;
        } else {
            e();
            this.b.j(i - 64);
        }
    }

    public final String toString() {
        if (this.b == null) {
            return Long.toBinaryString(this.a);
        }
        return this.b.toString() + "xx" + Long.toBinaryString(this.a);
    }
}
