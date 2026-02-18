package me.hd.wauxv.obf;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class coe implements dle {
    public static final but a = new but(new cbk(21));
    public int b;
    public long c;

    @Override // me.hd.wauxv.obf.dle
    public final long d() {
        return this.c;
    }

    @Override // me.hd.wauxv.obf.dle
    public final Object e(int i) {
        return null;
    }

    public final boolean equals(Object obj) {
        if (obj != null && coe.class == obj.getClass()) {
            coe coeVar = (coe) obj;
            if (this.b == coeVar.b && this.c == coeVar.c) {
                return true;
            }
        }
        return false;
    }

    @Override // me.hd.wauxv.obf.dle
    public final void f(long j) {
        this.c = j;
    }

    @Override // me.hd.wauxv.obf.dle
    public final arp g() {
        return null;
    }

    @Override // me.hd.wauxv.obf.dle
    public final void h(int i) {
        this.b = i;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.b), Long.valueOf(this.c), null);
    }

    @Override // me.hd.wauxv.obf.dle
    public final int i() {
        return this.b;
    }

    public final String toString() {
        return "NoExtSpanImpl{column=" + this.b + ", style=" + this.c + ", extra=null}";
    }
}
