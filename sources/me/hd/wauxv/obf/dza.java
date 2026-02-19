package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dza {
    public static final dyz Companion = new dyz();
    public final dyu a;
    public final String b;
    public final String c;

    public /* synthetic */ dza(int i, dyu dyuVar, String str, String str2) {
        if (7 != (i & 7)) {
            bht.ah(i, 7, dyy.b.getDescriptor());
            throw null;
        }
        this.a = dyuVar;
        this.b = str;
        this.c = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dza)) {
            return false;
        }
        dza dzaVar = (dza) obj;
        return nullSafeIsEqual(this.a, dzaVar.a) && nullSafeIsEqual(this.b, dzaVar.b)
                && nullSafeIsEqual(this.c, dzaVar.c);
    }

    public final int hashCode() {
        dyu dyuVar = this.a;
        int iHashCode = (dyuVar == null ? 0 : dyuVar.hashCode()) * 31;
        String str = this.b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.c;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("k23Proto(mic_contact=" /* "k23Proto(mic_contact=" /* "k23Proto(mic_contact=" /* "k23Proto(mic_contact=" /* cnb.z(-195025874975530L)   */);
        sb.append(this.a);
        sb.append(", sdk_user_id=" /* ", sdk_user_id=" /* ", sdk_user_id=" /* ", sdk_user_id=" /* cnb.z(-194914205825834L)   */);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.b, -200879915399978L);
        return concat(sb, this.c, ')');
    }
}
