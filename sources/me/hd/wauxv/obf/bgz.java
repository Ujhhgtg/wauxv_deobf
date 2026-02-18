package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bgz implements Cloneable {
    public cbm a;

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final bgz clone() {
        try {
            return (bgz) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public final boolean c(Object obj) {
        if (obj instanceof bgz) {
            return eot.e(this.a, ((bgz) obj).a);
        }
        return false;
    }

    public final int d() {
        cbm cbmVar = this.a;
        if (cbmVar != null) {
            return cbmVar.hashCode();
        }
        return 0;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof bgz) && c(obj);
    }

    public final int hashCode() {
        return d();
    }
}
