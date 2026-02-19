package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class eeu {
    public static final eet Companion = new eet();
    public final String a;
    public final String b;
    public final String c;

    public /* synthetic */ eeu(int i, String str, String str2, String str3) {
        if (7 != (i & 7)) {
            ResourcesCompat.ah(i, 7, ees.b.getDescriptor());
            throw null;
        }
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof eeu)) {
            return false;
        }
        eeu eeuVar = (eeu) obj;
        return nullSafeIsEqual(this.a, eeuVar.a) && nullSafeIsEqual(this.b, eeuVar.b)
                && nullSafeIsEqual(this.c, eeuVar.c);
    }

    public final int hashCode() {
        String str = this.a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.b;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.c;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("suProto(chatroom_username=" /* "suProto(chatroom_username=" /* "suProto(chatroom_username=" /* cnb.z(-295528109701930L)  */);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.a, -294810850163498L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.b, -294755015588650L);
        return concat(sb, this.c, ')');
    }
}
