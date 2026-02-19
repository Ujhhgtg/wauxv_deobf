package me.hd.wauxv.obf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dvl {
    public static final dvk Companion = new dvk();
    public static final IHasGetValue[] a = { null, null, null, null, null, null, ewz.am(btx.a, new dtr(1)), null,
            null };
    public final Integer b;
    public final dwm c;
    public final eji d;
    public final dyl e;
    public final String f;
    public final String g;
    public final List h;
    public final efm i;
    public final Boolean j;

    public /* synthetic */ dvl(int i, Integer num, dwm dwmVar, eji ejiVar, dyl dylVar, String str, String str2,
            List list, efm efmVar, Boolean bool) {
        if (511 != (i & 511)) {
            ResourcesCompat.ah(i, 511, dvj.b.getDescriptor());
            throw null;
        }
        this.b = num;
        this.c = dwmVar;
        this.d = ejiVar;
        this.e = dylVar;
        this.f = str;
        this.g = str2;
        this.h = list;
        this.i = efmVar;
        this.j = bool;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dvl)) {
            return false;
        }
        dvl dvlVar = (dvl) obj;
        return nullSafeIsEqual(this.b, dvlVar.b) && nullSafeIsEqual(this.c, dvlVar.c)
                && nullSafeIsEqual(this.d, dvlVar.d) && nullSafeIsEqual(this.e, dvlVar.e)
                && nullSafeIsEqual(this.f, dvlVar.f) && nullSafeIsEqual(this.g, dvlVar.g)
                && nullSafeIsEqual(this.h, dvlVar.h) && nullSafeIsEqual(this.i, dvlVar.i)
                && nullSafeIsEqual(this.j, dvlVar.j);
    }

    public final int hashCode() {
        Integer num = this.b;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        dwm dwmVar = this.c;
        int iHashCode2 = (iHashCode + (dwmVar == null ? 0 : dwmVar.hashCode())) * 31;
        eji ejiVar = this.d;
        int iHashCode3 = (iHashCode2 + (ejiVar == null ? 0 : ejiVar.hashCode())) * 31;
        dyl dylVar = this.e;
        int iHashCode4 = (iHashCode3 + (dylVar == null ? 0 : dylVar.hashCode())) * 31;
        String str = this.f;
        int iHashCode5 = (iHashCode4 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.g;
        int iHashCode6 = (iHashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
        List list = this.h;
        int iHashCode7 = (iHashCode6 + (list == null ? 0 : list.hashCode())) * 31;
        efm efmVar = this.i;
        int iHashCode8 = (iHashCode7 + (efmVar == null ? 0 : efmVar.hashCode())) * 31;
        Boolean bool = this.j;
        return iHashCode8 + (bool != null ? bool.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("au1Proto(newlife_type=" /* "au1Proto(newlife_type=" /* "au1Proto(newlife_type=" /* cnb.z(-169496589368106L)  */);
        bjs.w(sb, this.b, -169380625251114L);
        sb.append(this.c);
        sb.append(", topic_info=" /* ", topic_info=" /* ", topic_info=" /* cnb.z(-169814416948010L)  */);
        sb.append(this.d);
        sb.append(", biz_picture_desc=" /* ", biz_picture_desc=" /* ", biz_picture_desc=" /* cnb.z(-169805827013418L)  */);
        sb.append(this.e);
        sb.append(", secretly_push_chatroom_wording=" /* ", secretly_push_chatroom_wording=" /* ", secretly_push_chatroom_wording=" /* cnb.z(-169685567929130L)  */);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.f, -171205986351914L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.g, -171064252431146L);
        yg.v(sb, this.h, -171502339095338L);
        sb.append(this.i);
        sb.append(", is_need_display_comment_egg=" /* ", is_need_display_comment_egg=" /* ", is_need_display_comment_egg=" /* cnb.z(-171412144782122L)  */);
        sb.append(this.j);
        sb.append(')');
        return sb.toString();
    }
}
