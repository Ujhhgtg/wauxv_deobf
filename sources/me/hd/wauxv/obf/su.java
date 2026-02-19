package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class su implements Comparable {
    public final amk a;
    public final int b;

    public su(amk amkVar, int i) {
        this.a = amkVar;
        this.b = i;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return FastKV.t(this.b, ((su) obj).b);
    }

    public final String toString() {
        int i = this.b;
        amk amkVar = this.a;
        return amkVar == null ? String.valueOf(i) : ((cwe) amkVar.h.get(i)).toString();
    }
}
