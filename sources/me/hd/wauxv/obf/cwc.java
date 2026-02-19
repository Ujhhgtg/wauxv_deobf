package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class cwc extends sw implements btc {
    public final boolean b;

    public cwc(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, (i & 1) == 1);
        this.b = false;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof cwc) {
            cwc cwcVar = (cwc) obj;
            return l().equals(cwcVar.l()) && this.f.equals(cwcVar.f) && this.h.equals(cwcVar.h)
                    && nullSafeIsEqual(this.d, cwcVar.d);
        }
        if (obj instanceof btc) {
            return obj.equals(j());
        }
        return false;
    }

    public final btc g() {
        if (this.b) {
            throw new UnsupportedOperationException(
                    "Kotlin reflection is not yet supported for synthetic Java properties. Please follow/upvote https://youtrack.jetbrains.com/issue/KT-55980");
        }
        bsu bsuVarJ = j();
        if (bsuVarJ != this) {
            return (btc) bsuVarJ;
        }
        throw new aht();
    }

    public final int hashCode() {
        return this.h.hashCode() + bjs.e(this.f, l().hashCode() * 31, 31);
    }

    @Override // me.hd.wauxv.obf.sw
    public final bsu j() {
        return this.b ? this : super.j();
    }

    public final String toString() {
        bsu bsuVarJ = j();
        return bsuVarJ != this ? bsuVarJ.toString()
                : yg.concatToVar1(new StringBuilder("property "), this.f, " (Kotlin reflection is not available)");
    }
}
