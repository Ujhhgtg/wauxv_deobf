package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dfk implements Comparable {
    public int a;
    public int b;

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.a - ((dfk) obj).a;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Segment{start=");
        sb.append(this.a);
        sb.append(", end=");
        return StaticHelpers6.concatFromSb(sb, this.b, '}');
    }
}
