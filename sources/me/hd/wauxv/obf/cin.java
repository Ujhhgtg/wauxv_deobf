package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cin {
    public final cjv a;
    public final boolean b;
    public final boolean c;
    public final Object d;

    public cin(cjv cjvVar, boolean z, Object obj, boolean z2) {
        if (!cjvVar.aa && z) {
            throw new IllegalArgumentException(cjvVar.g().concat(" does not allow nullable values").toString());
        }
        if (!z && z2 && obj == null) {
            throw new IllegalArgumentException(("Argument with type " + cjvVar.g() + " has null value but is not nullable.").toString());
        }
        this.a = cjvVar;
        this.b = z;
        this.d = obj;
        this.c = z2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && cin.class == obj.getClass()) {
            cin cinVar = (cin) obj;
            Object obj2 = cinVar.d;
            if (this.b != cinVar.b || this.c != cinVar.c || !bzo.f(this.a, cinVar.a)) {
                return false;
            }
            Object obj3 = this.d;
            if (obj3 != null) {
                return bzo.f(obj3, obj2);
            }
            if (obj2 == null) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = ((((this.a.hashCode() * 31) + (this.b ? 1 : 0)) * 31) + (this.c ? 1 : 0)) * 31;
        Object obj = this.d;
        return iHashCode + (obj != null ? obj.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(dal.b(cin.class).d());
        sb.append(" Type: " + this.a);
        sb.append(" Nullable: " + this.b);
        if (this.c) {
            sb.append(" DefaultValue: " + this.d);
        }
        String string = sb.toString();
        bzo.p(string, "toString(...)");
        return string;
    }
}
