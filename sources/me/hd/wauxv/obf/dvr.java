package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dvr {
    public static final dvq Companion = new dvq();
    public final String a;
    public final ehp b;
    public final Integer c;
    public final Integer d;

    public /* synthetic */ dvr(int i, String str, ehp ehpVar, Integer num, Integer num2) {
        if (15 != (i & 15)) {
            bht.ah(i, 15, dvp.b.getDescriptor());
            throw null;
        }
        this.a = str;
        this.b = ehpVar;
        this.c = num;
        this.d = num2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dvr)) {
            return false;
        }
        dvr dvrVar = (dvr) obj;
        return nullSafeIsEqual(this.a, dvrVar.a) && nullSafeIsEqual(this.b, dvrVar.b)
                && nullSafeIsEqual(this.c, dvrVar.c) && nullSafeIsEqual(this.d, dvrVar.d);
    }

    public final int hashCode() {
        String str = this.a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        ehp ehpVar = this.b;
        int iHashCode2 = (iHashCode + (ehpVar == null ? 0 : ehpVar.hashCode())) * 31;
        Integer num = this.c;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.d;
        return iHashCode3 + (num2 != null ? num2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("bb3Proto(voice_live_img=" /* "bb3Proto(voice_live_img=" /* "bb3Proto(voice_live_img=" /* cnb.z(-167456479902506L)  */);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.a, -169015553030954L);
        sb.append(this.b);
        sb.append(", img_type=" /* ", img_type=" /* ", img_type=" /* cnb.z(-168852344273706L)  */);
        bjs.w(sb, this.c, -168835164404522L);
        return concat(sb, this.d, ')');
    }
}
