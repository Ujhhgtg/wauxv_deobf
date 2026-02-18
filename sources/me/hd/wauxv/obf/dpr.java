package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dpr implements Comparable {
    public final short a;
    public int b = 0;
    public int c = -1;
    public int d = 0;

    public dpr(int i) {
        this.a = (short) i;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        int i = this.c;
        int i2 = ((dpr) obj).c;
        if (i != i2) {
            return i < i2 ? -1 : 1;
        }
        return 0;
    }

    public final boolean e() {
        return this.b > 0;
    }

    public final String toString() {
        return String.format("Section[type=%#x,off=%#x,size=%#x]", Short.valueOf(this.a), Integer.valueOf(this.c), Integer.valueOf(this.b));
    }
}
