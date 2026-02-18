package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class azh implements Comparable {
    public final amk a;
    public final int b;
    public final int c;
    public final int d;

    public azh(amk amkVar, int i, int i2, int i3) {
        this.a = amkVar;
        this.b = i;
        this.c = i2;
        this.d = i3;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        azh azhVar = (azh) obj;
        int i = azhVar.b;
        int i2 = this.b;
        if (i2 != i) {
            return bhu.t(i2, i);
        }
        int i3 = azhVar.d;
        int i4 = this.d;
        return i4 != i3 ? bhu.t(i4, i3) : bhu.t(this.c, azhVar.c);
    }

    public final String toString() {
        int i = this.d;
        int i2 = this.c;
        amk amkVar = this.a;
        if (amkVar != null) {
            return ((String) amkVar.g.get(i2)) + "." + ((String) amkVar.e.get(i));
        }
        return this.b + " " + i2 + " " + i;
    }
}
