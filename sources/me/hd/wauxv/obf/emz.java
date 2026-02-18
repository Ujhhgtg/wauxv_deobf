package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class emz implements Comparable {
    public final long a;

    public /* synthetic */ emz(long j) {
        this.a = j;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        long j = ((emz) obj).a;
        long j2 = this.a ^ Long.MIN_VALUE;
        long j3 = j ^ Long.MIN_VALUE;
        if (j2 < j3) {
            return -1;
        }
        return j2 == j3 ? 0 : 1;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof emz) {
            return this.a == ((emz) obj).a;
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.a);
    }

    public final String toString() {
        return bhv.aj(10, this.a);
    }
}
