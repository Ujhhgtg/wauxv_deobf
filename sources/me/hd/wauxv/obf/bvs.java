package me.hd.wauxv.obf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bvs implements dfx {
    public final dfx a;
    public final dfx c;

    public bvs(dfx dfxVar, dfx dfxVar2) {
        throwIfVar1IsNull(dfxVar, "keyDesc");
        throwIfVar1IsNull(dfxVar2, "valueDesc");
        this.a = dfxVar;
        this.c = dfxVar2;
    }

    @Override // me.hd.wauxv.obf.dfx
    public final String b() {
        return "kotlin.collections.LinkedHashMap";
    }

    @Override // me.hd.wauxv.obf.dfx
    public final boolean d() {
        return false;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof bvs)) {
            return false;
        }
        bvs bvsVar = (bvs) obj;
        return nullSafeIsEqual(this.a, bvsVar.a) && nullSafeIsEqual(this.c, bvsVar.c);
    }

    @Override // me.hd.wauxv.obf.dfx
    public final boolean f() {
        return false;
    }

    @Override // me.hd.wauxv.obf.dfx
    public final int g(String str) {
        throwIfVar1IsNull(str, "name");
        Integer numBf = dnq.bf(str);
        if (numBf != null) {
            return numBf.intValue();
        }
        throw new IllegalArgumentException(str.concat(" is not a valid map index"));
    }

    @Override // me.hd.wauxv.obf.dfx
    public final List getAnnotations() {
        return avd.a;
    }

    @Override // me.hd.wauxv.obf.dfx
    public final emc h() {
        return dnt.c;
    }

    public final int hashCode() {
        return this.c.hashCode() + ((this.a.hashCode() + 710441009) * 31);
    }

    @Override // me.hd.wauxv.obf.dfx
    public final int i() {
        return 2;
    }

    @Override // me.hd.wauxv.obf.dfx
    public final String j(int i) {
        return String.valueOf(i);
    }

    @Override // me.hd.wauxv.obf.dfx
    public final List k(int i) {
        if (i >= 0) {
            return avd.a;
        }
        throw new IllegalArgumentException(
                yg.f(i, "Illegal index ", ", kotlin.collections.LinkedHashMap expects only non-negative indices")
                        .toString());
    }

    @Override // me.hd.wauxv.obf.dfx
    public final dfx l(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(
                    yg.f(i, "Illegal index ", ", kotlin.collections.LinkedHashMap expects only non-negative indices")
                            .toString());
        }
        int i2 = i % 2;
        if (i2 == 0) {
            return this.a;
        }
        if (i2 == 1) {
            return this.c;
        }
        throw new IllegalStateException("Unreached");
    }

    @Override // me.hd.wauxv.obf.dfx
    public final boolean m(int i) {
        if (i >= 0) {
            return false;
        }
        throw new IllegalArgumentException(
                yg.f(i, "Illegal index ", ", kotlin.collections.LinkedHashMap expects only non-negative indices")
                        .toString());
    }

    public final String toString() {
        return "kotlin.collections.LinkedHashMap(" + this.a + ", " + this.c + ')';
    }
}
