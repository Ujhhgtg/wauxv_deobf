package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class emu implements Comparable {
    public final int a;

    public /* synthetic */ emu(int i) {
        this.a = i;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return bzo.r(this.a ^ Integer.MIN_VALUE, ((emu) obj).a ^ Integer.MIN_VALUE);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof emu) {
            return this.a == ((emu) obj).a;
        }
        return false;
    }

    public final int hashCode() {
        return Integer.hashCode(this.a);
    }

    public final String toString() {
        return String.valueOf(((long) this.a) & 4294967295L);
    }
}
