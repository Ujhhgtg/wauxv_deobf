package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ug extends ue {
    public static final /* synthetic */ int c = 0;

    static {
        new ug();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ug)) {
            return false;
        }
        char c2 = this.a;
        return (bzo.r(1, c2) > 0 && bzo.r(1, ((ug) obj).a) > 0) || c2 == ((ug) obj).a;
    }

    public final int hashCode() {
        char c2 = this.a;
        if (bzo.r(1, c2) > 0) {
            return -1;
        }
        return 31 + c2;
    }

    public final String toString() {
        return "\u0001.." + this.a;
    }
}
