package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dso {
    public static final dsn Companion = new dsn();
    public final String a;
    public final String b;
    public final String c;
    public final String d;

    public /* synthetic */ dso(String str, String str2, String str3, int i, String str4) {
        if (15 != (i & 15)) {
            bht.ah(i, 15, dsm.b.getDescriptor());
            throw null;
        }
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dso)) {
            return false;
        }
        dso dsoVar = (dso) obj;
        return nullSafeIsEqual(this.a, dsoVar.a) && nullSafeIsEqual(this.b, dsoVar.b)
                && nullSafeIsEqual(this.c, dsoVar.c) && nullSafeIsEqual(this.d, dsoVar.d);
    }

    public final int hashCode() {
        String str = this.a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.b;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.c;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.d;
        return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AppMsgProto(appid=" /* "AppMsgProto(appid=" /* "AppMsgProto(appid=" /* cnb.z(-147248658774826L)  */);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.a, -147184234265386L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.b, -147115514788650L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.c, -146488449563434L);
        return concat(sb, this.d, ')');
    }
}
