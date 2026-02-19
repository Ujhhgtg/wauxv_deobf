package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ecm {
    public static final ecl Companion = new ecl();
    public final eie a;
    public final Integer b;
    public final String c;

    public /* synthetic */ ecm(int i, eie eieVar, Integer num, String str) {
        if (7 != (i & 7)) {
            bht.ah(i, 7, eck.b.getDescriptor());
            throw null;
        }
        this.a = eieVar;
        this.b = num;
        this.c = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ecm)) {
            return false;
        }
        ecm ecmVar = (ecm) obj;
        return nullSafeIsEqual(this.a, ecmVar.a) && nullSafeIsEqual(this.b, ecmVar.b)
                && nullSafeIsEqual(this.c, ecmVar.c);
    }

    public final int hashCode() {
        eie eieVar = this.a;
        int iHashCode = (eieVar == null ? 0 : eieVar.hashCode()) * 31;
        Integer num = this.b;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.c;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("o61Proto(cdnTransInfo=" /* "o61Proto(cdnTransInfo=" /* "o61Proto(cdnTransInfo=" /* "o61Proto(cdnTransInfo=" /* cnb.z(-261176961268522L)   */);
        sb.append(this.a);
        sb.append(", bitRate=" /* ", bitRate=" /* ", bitRate=" /* ", bitRate=" /* cnb.z(-261679472442154L)   */);
        bjs.w(sb, this.b, -261597868063530L);
        return concat(sb, this.c, ')');
    }
}
