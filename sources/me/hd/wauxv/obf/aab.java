package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class aab implements aac {
    public final float a;
    public final float b;

    public aab(float f, float f2) {
        this.a = f;
        this.b = f2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof aab)) {
            return false;
        }
        float f = this.a;
        float f2 = this.b;
        if (f > f2) {
            aab aabVar = (aab) obj;
            if (aabVar.a > aabVar.b) {
                return true;
            }
        }
        aab aabVar2 = (aab) obj;
        return f == aabVar2.a && f2 == aabVar2.b;
    }

    public final int hashCode() {
        float f = this.a;
        float f2 = this.b;
        if (f > f2) {
            return -1;
        }
        return Float.hashCode(f2) + (Float.hashCode(f) * 31);
    }

    public final String toString() {
        return this.a + ".." + this.b;
    }
}
