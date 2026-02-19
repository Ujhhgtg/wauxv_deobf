package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dhk {
    public final String a;
    public final String b;

    public dhk(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dhk)) {
            return false;
        }
        dhk dhkVar = (dhk) obj;
        return nullSafeIsEqual(this.a, dhkVar.a) && nullSafeIsEqual(this.b, dhkVar.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HideConfig(title=" /* "HideConfig(title=" /* "HideConfig(title=" /* cnb.z(-459531435899690L)  */);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.a, -459471306357546L);
        return concat(sb, this.b, ')');
    }
}
