package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dvc {
    public static final dvb Companion = new dvb();
    public final String a;
    public final Integer b;
    public final Integer c;
    public final Integer d;

    public /* synthetic */ dvc(int i, String str, Integer num, Integer num2, Integer num3) {
        if (15 != (i & 15)) {
            ResourcesCompat.ah(i, 15, dva.b.getDescriptor());
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
        if (!(obj instanceof dvc)) {
            return false;
        }
        dvc dvcVar = (dvc) obj;
        return nullSafeIsEqual(this.a, dvcVar.a) && nullSafeIsEqual(this.b, dvcVar.b)
                && nullSafeIsEqual(this.c, dvcVar.c) && nullSafeIsEqual(this.d, dvcVar.d);
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
        sb.append("a23Proto(gift_id=" /* "a23Proto(gift_id=" /* "a23Proto(gift_id=" /* "a23Proto(gift_id=" /* cnb.z(-143889994349354L)   */);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.a, -143829864807210L);
        bjs.w(sb, this.b, -143194209647402L);
        bjs.w(sb, this.c, -143172734810922L);
        return concat(sb, this.d, ')');
    }
}
