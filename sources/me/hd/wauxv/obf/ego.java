package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ego {
    public static final egn Companion = new egn();
    public final Integer a;
    public final Integer b;
    public final String c;

    public /* synthetic */ ego(int i, Integer num, Integer num2, String str) {
        if (7 != (i & 7)) {
            ResourcesCompat.ah(i, 7, egm.b.getDescriptor());
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
        if (!(obj instanceof ego)) {
            return false;
        }
        ego egoVar = (ego) obj;
        return nullSafeIsEqual(this.a, egoVar.a) && nullSafeIsEqual(this.b, egoVar.b)
                && nullSafeIsEqual(this.c, egoVar.c);
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
        sb.append("vd1Proto(show_type=" /* "vd1Proto(show_type=" /* "vd1Proto(show_type=" /* cnb.z(-312549065095978L)  */);
        bjs.w(sb, this.a, -314146792930090L);
        bjs.w(sb, this.b, -314048008682282L);
        return concat(sb, this.c, ')');
    }
}
