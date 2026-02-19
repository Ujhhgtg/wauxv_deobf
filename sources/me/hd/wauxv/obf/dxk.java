package me.hd.wauxv.obf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dxk {
    public static final dxj Companion = new dxj();
    public static final IHasGetValue[] a = { null, null, null, null, null, StaticAndroidHelpers.am(btx.a, new dtr(8)), null };
    public final String b;
    public final Long c;
    public final String d;
    public final dyu e;
    public final Integer f;
    public final List g;
    public final Integer h;

    public /* synthetic */ dxk(int i, String str, Long l, String str2, dyu dyuVar, Integer num, List list,
            Integer num2) {
        if (127 != (i & 127)) {
            ResourcesCompat.ah(i, 127, dxi.b.getDescriptor());
            throw null;
        }
        this.b = str;
        this.c = l;
        this.d = str2;
        this.e = dyuVar;
        this.f = num;
        this.g = list;
        this.h = num2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dxk)) {
            return false;
        }
        dxk dxkVar = (dxk) obj;
        return nullSafeIsEqual(this.b, dxkVar.b) && nullSafeIsEqual(this.c, dxkVar.c)
                && nullSafeIsEqual(this.d, dxkVar.d) && nullSafeIsEqual(this.e, dxkVar.e)
                && nullSafeIsEqual(this.f, dxkVar.f) && nullSafeIsEqual(this.g, dxkVar.g)
                && nullSafeIsEqual(this.h, dxkVar.h);
    }

    public final int hashCode() {
        String str = this.b;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Long l = this.c;
        int iHashCode2 = (iHashCode + (l == null ? 0 : l.hashCode())) * 31;
        String str2 = this.d;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        dyu dyuVar = this.e;
        int iHashCode4 = (iHashCode3 + (dyuVar == null ? 0 : dyuVar.hashCode())) * 31;
        Integer num = this.f;
        int iHashCode5 = (iHashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        List list = this.g;
        int iHashCode6 = (iHashCode5 + (list == null ? 0 : list.hashCode())) * 31;
        Integer num2 = this.h;
        return iHashCode6 + (num2 != null ? num2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ff1Proto(live_mic_id=" /* "ff1Proto(live_mic_id=" /* "ff1Proto(live_mic_id=" /* "ff1Proto(live_mic_id=" /* cnb.z(-189481072196394L)   */);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.b, -191018670488362L);
        StaticHelpers6.ad(sb, this.c, -191005785586474L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.d, -190872641600298L);
        sb.append(this.e);
        sb.append(", status=" /* ", status=" /* ", status=" /* ", status=" /* cnb.z(-190808217090858L)   */);
        bjs.w(sb, this.f, -190782447287082L);
        yg.v(sb, this.g, -191276368526122L);
        return concat(sb, this.h, ')');
    }
}
