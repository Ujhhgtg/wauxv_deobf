package me.hd.wauxv.obf;

import net.bytebuddy.description.method.MethodDescription;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class bgr extends sw implements bgq, IEmpty6, IEmpty4 {
    public final int m;
    public final int n;

    public bgr(int i, Class cls, String str, String str2, int i2) {
        this(i, sv.a, cls, str, str2, i2, 0);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof bgr) {
            bgr bgrVar = (bgr) obj;
            return this.f.equals(bgrVar.f) && this.h.equals(bgrVar.h) && this.n == bgrVar.n && this.m == bgrVar.m
                    && nullSafeIsEqual(this.d, bgrVar.d) && l().equals(bgrVar.l());
        }
        if (obj instanceof bgr) {
            return obj.equals(j());
        }
        return false;
    }

    @Override // me.hd.wauxv.obf.bgq
    public final int getArity() {
        return this.m;
    }

    public final int hashCode() {
        l();
        return this.h.hashCode() + bjs.e(this.f, l().hashCode() * 31, 31);
    }

    @Override // me.hd.wauxv.obf.sw
    public final IEmpty6 k() {
        dal.a.getClass();
        return this;
    }

    public final String toString() {
        IEmpty6 bsuVarJ = j();
        if (bsuVarJ != this) {
            return bsuVarJ.toString();
        }
        String str = this.f;
        return MethodDescription.CONSTRUCTOR_INTERNAL_NAME.equals(str)
                ? "constructor (Kotlin reflection is not available)"
                : concat("function ", str, " (Kotlin reflection is not available)");
    }

    public bgr(int i, Object obj, Class cls, String str, String str2, int i2, int i3) {
        super(obj, cls, str, str2, (i2 & 1) == 1);
        this.m = i;
        this.n = 0;
    }
}
