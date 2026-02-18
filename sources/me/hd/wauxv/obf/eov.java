package me.hd.wauxv.obf;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class eov implements Comparable, Serializable {
    public static final eov a = new eov(0, 0);
    public final long b;
    public final long c;

    public eov(long j, long j2) {
        this.b = j;
        this.c = j2;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        eov eovVar = (eov) obj;
        bzo.q(eovVar, "other");
        long j = eovVar.b;
        long j2 = this.b;
        return j2 != j ? Long.compareUnsigned(j2, j) : Long.compareUnsigned(this.c, eovVar.c);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof eov)) {
            return false;
        }
        eov eovVar = (eov) obj;
        return this.b == eovVar.b && this.c == eovVar.c;
    }

    public final int hashCode() {
        return Long.hashCode(this.b ^ this.c);
    }

    public final String toString() {
        byte[] bArr = new byte[36];
        cna.s(this.b, 0, 0, bArr, 4);
        bArr[8] = 45;
        cna.s(this.b, 9, 4, bArr, 6);
        bArr[13] = 45;
        cna.s(this.b, 14, 6, bArr, 8);
        bArr[18] = 45;
        cna.s(this.c, 19, 0, bArr, 2);
        bArr[23] = 45;
        cna.s(this.c, 24, 2, bArr, 8);
        return new String(bArr, uj.a);
    }
}
