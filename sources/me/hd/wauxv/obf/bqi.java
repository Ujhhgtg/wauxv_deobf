package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bqi extends bqf {
    public static final bqi d = new bqi(1, 0, 1);

    @Override // me.hd.wauxv.obf.bqf
    public final boolean equals(Object obj) {
        if (!(obj instanceof bqi)) {
            return false;
        }
        if (isEmpty() && ((bqi) obj).isEmpty()) {
            return true;
        }
        bqi bqiVar = (bqi) obj;
        return this.a == bqiVar.a && this.b == bqiVar.b;
    }

    @Override // me.hd.wauxv.obf.bqf
    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (this.a * 31) + this.b;
    }

    @Override // me.hd.wauxv.obf.bqf
    public final boolean isEmpty() {
        return this.a > this.b;
    }

    @Override // me.hd.wauxv.obf.bqf
    public final String toString() {
        return this.a + ".." + this.b;
    }
}
