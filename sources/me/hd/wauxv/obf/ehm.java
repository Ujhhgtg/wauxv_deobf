package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ehm {
    public static final ehl Companion = new ehl();
    public final dsy a;
    public final dyi b;
    public final String c;
    public final String d;

    public /* synthetic */ ehm(int i, dsy dsyVar, dyi dyiVar, String str, String str2) {
        if (15 != (i & 15)) {
            bht.ah(i, 15, ehk.b.getDescriptor());
            throw null;
        }
        this.a = dsyVar;
        this.b = dyiVar;
        this.c = str;
        this.d = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ehm)) {
            return false;
        }
        ehm ehmVar = (ehm) obj;
        return nullSafeIsEqual(this.a, ehmVar.a) && nullSafeIsEqual(this.b, ehmVar.b)
                && nullSafeIsEqual(this.c, ehmVar.c) && nullSafeIsEqual(this.d, ehmVar.d);
    }

    public final int hashCode() {
        dsy dsyVar = this.a;
        int iHashCode = (dsyVar == null ? 0 : dsyVar.hashCode()) * 31;
        dyi dyiVar = this.b;
        int iHashCode2 = (iHashCode + (dyiVar == null ? 0 : dyiVar.hashCode())) * 31;
        String str = this.c;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.d;
        return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("w52Proto(contact=" /* cnb.z(-306871118330666L) */);
        sb.append(this.a);
        sb.append(", musicInfo=" /* cnb.z(-306810988788522L) */);
        sb.append(this.b);
        sb.append(", audioTrackUrl=" /* cnb.z(-307287730158378L) */);
        yg.u(sb, this.c, -307214715714346L);
        return concat(sb, this.d, ')');
    }
}
