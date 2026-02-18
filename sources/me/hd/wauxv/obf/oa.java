package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class oa extends oc {
    public final String a;
    public final String b;
    public final ctx c;
    public final aeh d;

    public oa(String str, String str2, ctx ctxVar, aeh aehVar) {
        this.a = str;
        this.b = str2;
        this.c = ctxVar;
        this.d = aehVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof oa)) {
            return false;
        }
        oa oaVar = (oa) obj;
        return bzo.f(this.a, oaVar.a) && bzo.f(this.b, oaVar.b) && this.c.equals(oaVar.c) && this.d.equals(oaVar.d);
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        String str = this.b;
        return this.d.hashCode() + ((this.c.hashCode() + ((iHashCode + (str == null ? 0 : str.hashCode())) * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PluginSwitch(title=" /* cnb.z(-388359532837674L) */);
        yg.u(sb, this.a, -388239273753386L);
        yg.u(sb, this.b, -388204914015018L);
        sb.append(this.c);
        sb.append(", onClick=" /* cnb.z(-388179144211242L) */);
        sb.append(this.d);
        sb.append(')');
        return sb.toString();
    }
}
