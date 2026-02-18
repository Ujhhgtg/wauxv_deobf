package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bgt {
    public static final bgt a = new bgt(true);
    public final boolean b;

    public bgt(boolean z) {
        this.b = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof bgt) && this.b == ((bgt) obj).b;
    }

    public final int hashCode() {
        return Boolean.hashCode(true) + (Boolean.hashCode(this.b) * 31);
    }

    public final String toString() {
        return "FuzzyScoreOptions(firstMatchCanBeWeak=" + this.b + ", boostFullMatch=true)";
    }
}
