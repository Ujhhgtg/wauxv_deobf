package me.hd.wauxv.obf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class zn {
    public final String a;
    public final List b;

    public zn(String str, List list) {
        this.a = str;
        this.b = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zn)) {
            return false;
        }
        zn znVar = (zn) obj;
        return nullSafeIsEqual(this.a, znVar.a) && nullSafeIsEqual(this.b, znVar.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CleanData(name=" /* "CleanData(name=" /* "CleanData(name=" /* cnb.z(-11909944310570L)  */);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.a, -11841224833834L);
        sb.append(this.b);
        sb.append(')');
        return sb.toString();
    }
}
