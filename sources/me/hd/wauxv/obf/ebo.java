package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ebo {
    public static final ebn Companion = new ebn();
    public final Boolean a;
    public final duh b;
    public final Integer c;

    public /* synthetic */ ebo(int i, Boolean bool, duh duhVar, Integer num) {
        if (7 != (i & 7)) {
            bht.ah(i, 7, ebm.b.getDescriptor());
            throw null;
        }
        this.a = bool;
        this.b = duhVar;
        this.c = num;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ebo)) {
            return false;
        }
        ebo eboVar = (ebo) obj;
        return bzo.f(this.a, eboVar.a) && bzo.f(this.b, eboVar.b) && bzo.f(this.c, eboVar.c);
    }

    public final int hashCode() {
        Boolean bool = this.a;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        duh duhVar = this.b;
        int iHashCode2 = (iHashCode + (duhVar == null ? 0 : duhVar.hashCode())) * 31;
        Integer num = this.c;
        return iHashCode2 + (num != null ? num.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(cnb.z(-259179801475882L));
        dts.g(sb, this.a, -259162621606698L);
        sb.append(this.b);
        sb.append(cnb.z(-259123966901034L));
        return bjs.p(sb, this.c, ')');
    }
}
