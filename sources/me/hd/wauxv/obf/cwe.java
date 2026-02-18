package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cwe implements Comparable {
    public final amk a;
    public final int b;
    public final int c;
    public final int d;

    public cwe(amk amkVar, int i, int i2, int i3) {
        this.a = amkVar;
        this.b = i;
        this.c = i2;
        this.d = i3;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        cwe cweVar = (cwe) obj;
        int i = cweVar.c;
        int i2 = this.c;
        return i2 != i ? bhu.t(i2, i) : bhu.t(this.d, cweVar.d);
    }

    public final String toString() {
        int i = this.d;
        int i2 = this.c;
        int i3 = this.b;
        amk amkVar = this.a;
        if (amkVar == null) {
            return i3 + " " + i2 + " " + i;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(amkVar.e.c(i3));
        sb.append(": ");
        sb.append((String) amkVar.g.get(i2));
        sb.append(" ");
        sb.append(i == 0 ? emd.a : amkVar.n(i).h());
        return sb.toString();
    }
}
