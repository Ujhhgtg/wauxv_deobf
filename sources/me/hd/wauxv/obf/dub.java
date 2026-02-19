package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dub {
    public static final dua Companion = new dua();
    public final String a;
    public final Integer b;

    public /* synthetic */ dub(int i, Integer num, String str) {
        if (3 != (i & 3)) {
            bht.ah(i, 3, dtz.b.getDescriptor());
            throw null;
        }
        this.a = str;
        this.b = num;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dub)) {
            return false;
        }
        dub dubVar = (dub) obj;
        return nullSafeIsEqual(this.a, dubVar.a) && nullSafeIsEqual(this.b, dubVar.b);
    }

    public final int hashCode() {
        String str = this.a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.b;
        return iHashCode + (num != null ? num.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ScanCodeInfoProto(codeContent=" /* "ScanCodeInfoProto(codeContent=" /* "ScanCodeInfoProto(codeContent=" /* "ScanCodeInfoProto(codeContent=" /* cnb.z(-265549237975850L)   */);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.a, -265948669934378L);
        return concat(sb, this.b, ')');
    }
}
