package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ene implements Comparable {
    public final short a;

    public /* synthetic */ ene(short s) {
        this.a = s;
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Object obj) {
        return bzo.r(this.a & 65535, ((ene) obj).a & 65535);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ene) {
            return this.a == ((ene) obj).a;
        }
        return false;
    }

    public final int hashCode() {
        return Short.hashCode(this.a);
    }

    public final String toString() {
        return String.valueOf(this.a & 65535);
    }
}
