package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class csd implements KClassContainer {
    public final Class b;

    public csd(Class cls) {
        this.b = cls;
    }

    @Override // me.hd.wauxv.obf.yq
    public final Class getJClass() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof csd) {
            return nullSafeIsEqual(this.b, ((csd) obj).b);
        }
        return false;
    }

    public final int hashCode() {
        return this.b.hashCode();
    }

    public final String toString() {
        return this.b.toString() + " (Kotlin reflection is not available)";
    }
}
