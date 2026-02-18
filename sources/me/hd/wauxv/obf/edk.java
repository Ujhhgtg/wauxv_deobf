package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class edk {
    public static final edj Companion = new edj();
    public final String a;
    public final Integer b;

    public /* synthetic */ edk(int i, Integer num, String str) {
        if (3 != (i & 3)) {
            bht.ah(i, 3, edi.b.getDescriptor());
            throw null;
        }
        this.a = str;
        this.b = num;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof edk)) {
            return false;
        }
        edk edkVar = (edk) obj;
        return bzo.f(this.a, edkVar.a) && bzo.f(this.b, edkVar.b);
    }

    public final int hashCode() {
        String str = this.a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.b;
        return iHashCode + (num != null ? num.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("poProto(d=" /* cnb.z(-252015796026154L) */);
        yg.u(sb, this.a, -251934191647530L);
        return bjs.p(sb, this.b, ')');
    }
}
