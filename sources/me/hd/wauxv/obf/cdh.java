package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cdh implements Comparable {
    public final amk a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;

    public cdh(amk amkVar, int i, int i2, int i3, int i4) {
        this.a = amkVar;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        cdh cdhVar = (cdh) obj;
        int i = cdhVar.b;
        int i2 = this.b;
        if (i2 == i) {
            return FastKV.t(this.d, cdhVar.d);
        }
        if (i2 == 0 || i == 0) {
            throw null;
        }
        return i2 - i;
    }

    public final String toString() {
        int i = this.d;
        int i2 = this.b;
        amk amkVar = this.a;
        if (amkVar == null) {
            return bjs.aa(i2) + " " + i;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(bjs.aa(i2));
        sb.append(" ");
        int iAe = StaticHelpers6.ae(i2);
        sb.append((iAe == 0 || iAe == 1 || iAe == 2 || iAe == 3) ? (Comparable) amkVar.i.get(i) : (Comparable) amkVar.j.get(i));
        return sb.toString();
    }
}
