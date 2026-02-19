package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class due {
    public static final dud Companion = new dud();
    public final Float a;
    public final Float b;
    public final Float c;

    public /* synthetic */ due(int i, Float f, Float f2, Float f3) {
        if (7 != (i & 7)) {
            bht.ah(i, 7, duc.b.getDescriptor());
            throw null;
        }
        this.a = f;
        this.b = f2;
        this.c = f3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof due)) {
            return false;
        }
        due dueVar = (due) obj;
        return nullSafeIsEqual(this.a, dueVar.a) && nullSafeIsEqual(this.b, dueVar.b)
                && nullSafeIsEqual(this.c, dueVar.c);
    }

    public final int hashCode() {
        Float f = this.a;
        int iHashCode = (f == null ? 0 : f.hashCode()) * 31;
        Float f2 = this.b;
        int iHashCode2 = (iHashCode + (f2 == null ? 0 : f2.hashCode())) * 31;
        Float f3 = this.c;
        return iHashCode2 + (f3 != null ? f3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SizeProto(width=" /* "SizeProto(width=" /* "SizeProto(width=" /* cnb.z(-270613004417834L)  */);
        bjs.v(sb, this.a, -270488450366250L);
        bjs.v(sb, this.b, -271012436376362L);
        sb.append(this.c);
        sb.append(')');
        return sb.toString();
    }
}
