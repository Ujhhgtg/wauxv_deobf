package me.hd.wauxv.obf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cnw {
    public static final cns Companion = new cns();
    public static final IHasGetValue[] a = { null, null, ewz.am(btx.a, new Function1$VarIsInt$2(12)) };
    public final nm b;
    public final int c;
    public final List d;

    public /* synthetic */ cnw(int i, nm nmVar, int i2, List list) {
        if (7 != (i & 7)) {
            ResourcesCompat.ah(i, 7, cnr.b.getDescriptor());
            throw null;
        }
        this.b = nmVar;
        this.c = i2;
        this.d = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof cnw)) {
            return false;
        }
        cnw cnwVar = (cnw) obj;
        return nullSafeIsEqual(this.b, cnwVar.b) && this.c == cnwVar.c && nullSafeIsEqual(this.d, cnwVar.d);
    }

    public final int hashCode() {
        return this.d.hashCode() + dts.a(this.c, this.b.hashCode() * 31, 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("NewSendMsgProto(baseResponse=" /* "NewSendMsgProto(baseResponse=" /* "NewSendMsgProto(baseResponse=" /* cnb.z(-128367982541610L)  */);
        sb.append(this.b);
        sb.append(", count=" /* ", count=" /* ", count=" /* cnb.z(-128221953653546L)  */);
        StaticHelpers6.ac(sb, this.c, -128183298947882L);
        sb.append(this.d);
        sb.append(')');
        return sb.toString();
    }
}
