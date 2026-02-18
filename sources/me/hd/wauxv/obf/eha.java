package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class eha {
    public static final egz Companion = new egz();
    public final Integer a;
    public final Integer b;
    public final Integer c;
    public final Integer d;

    public /* synthetic */ eha(int i, Integer num, Integer num2, Integer num3, Integer num4) {
        if (15 != (i & 15)) {
            bht.ah(i, 15, egy.b.getDescriptor());
            throw null;
        }
        this.a = num;
        this.b = num2;
        this.c = num3;
        this.d = num4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof eha)) {
            return false;
        }
        eha ehaVar = (eha) obj;
        return bzo.f(this.a, ehaVar.a) && bzo.f(this.b, ehaVar.b) && bzo.f(this.c, ehaVar.c) && bzo.f(this.d, ehaVar.d);
    }

    public final int hashCode() {
        Integer num = this.a;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.b;
        int iHashCode2 = (iHashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.c;
        int iHashCode3 = (iHashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.d;
        return iHashCode3 + (num4 != null ? num4.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("vq5Proto(d=" /* cnb.z(-299445119875882L) */);
        bjs.w(sb, this.a, -299359220529962L);
        bjs.w(sb, this.b, -299372105431850L);
        bjs.w(sb, this.c, -300982718167850L);
        return bjs.p(sb, this.d, ')');
    }
}
