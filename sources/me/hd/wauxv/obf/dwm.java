package me.hd.wauxv.obf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dwm {
    public static final dwl Companion = new dwl();
    public static final IHasGetValue[] a = { ewz.am(btx.a, new dtr(4)), null, null };
    public final List b;
    public final String c;
    public final String d;

    public /* synthetic */ dwm(int i, List list, String str, String str2) {
        if (7 != (i & 7)) {
            ResourcesCompat.ah(i, 7, dwk.b.getDescriptor());
            throw null;
        }
        this.b = list;
        this.c = str;
        this.d = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dwm)) {
            return false;
        }
        dwm dwmVar = (dwm) obj;
        return nullSafeIsEqual(this.b, dwmVar.b) && nullSafeIsEqual(this.c, dwmVar.c)
                && nullSafeIsEqual(this.d, dwmVar.d);
    }

    public final int hashCode() {
        List list = this.b;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        String str = this.c;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.d;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("cy1Proto(post_guide_topic_tags=" /* "cy1Proto(post_guide_topic_tags=" /* "cy1Proto(post_guide_topic_tags=" /* cnb.z(-160313949289258L)  */);
        yg.v(sb, this.b, -159626754521898L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.c, -159506495437610L);
        return concat(sb, this.d, ')');
    }
}
