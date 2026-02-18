package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class eiw {
    public static final eiv Companion = new eiv();
    public final Integer a;
    public final Integer b;
    public final String c;

    public /* synthetic */ eiw(int i, Integer num, Integer num2, String str) {
        if (7 != (i & 7)) {
            bht.ah(i, 7, eiu.b.getDescriptor());
            throw null;
        }
        this.a = num;
        this.b = num2;
        this.c = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof eiw)) {
            return false;
        }
        eiw eiwVar = (eiw) obj;
        return bzo.f(this.a, eiwVar.a) && bzo.f(this.b, eiwVar.b) && bzo.f(this.c, eiwVar.c);
    }

    public final int hashCode() {
        Integer num = this.a;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.b;
        int iHashCode2 = (iHashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str = this.c;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("y4Proto(d=" /* cnb.z(-325365247507242L) */);
        bjs.w(sb, this.a, -325352362605354L);
        bjs.w(sb, this.b, -325296528030506L);
        return bjs.q(sb, this.c, ')');
    }
}
