package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class egu {
    public static final egt Companion = new egt();
    public final String a;
    public final Integer b;
    public final Integer c;
    public final Integer d;

    public /* synthetic */ egu(int i, String str, Integer num, Integer num2, Integer num3) {
        if (15 != (i & 15)) {
            ResourcesCompat.ah(i, 15, egs.b.getDescriptor());
            throw null;
        }
        this.a = str;
        this.b = num;
        this.c = num2;
        this.d = num3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof egu)) {
            return false;
        }
        egu eguVar = (egu) obj;
        return nullSafeIsEqual(this.a, eguVar.a) && nullSafeIsEqual(this.b, eguVar.b)
                && nullSafeIsEqual(this.c, eguVar.c) && nullSafeIsEqual(this.d, eguVar.d);
    }

    public final int hashCode() {
        String str = this.a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.b;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.c;
        int iHashCode3 = (iHashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.d;
        return iHashCode3 + (num3 != null ? num3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("vo1Proto(stream_url=" /* "vo1Proto(stream_url=" /* "vo1Proto(stream_url=" /* "vo1Proto(stream_url=" /* cnb.z(-302842439007018L)   */);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.a, -302735064824618L);
        bjs.w(sb, this.b, -302657755413290L);
        bjs.w(sb, this.c, -299827371965226L);
        return concat(sb, this.d, ')');
    }
}
