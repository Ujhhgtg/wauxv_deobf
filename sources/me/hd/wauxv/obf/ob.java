package me.hd.wauxv.obf;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ob extends oc {
    public final String a;
    public final String b;
    public final doo c;
    public final View.OnClickListener d;

    public ob(String str, String str2, doo dooVar, bq bqVar) {
        this.a = str;
        this.b = str2;
        this.c = dooVar;
        this.d = bqVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ob)) {
            return false;
        }
        ob obVar = (ob) obj;
        return bzo.f(this.a, obVar.a) && bzo.f(this.b, obVar.b) && this.c.equals(obVar.c) && bzo.f(this.d, obVar.d);
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        String str = this.b;
        int iHashCode2 = (this.c.hashCode() + ((iHashCode + (str == null ? 0 : str.hashCode())) * 31)) * 31;
        View.OnClickListener onClickListener = this.d;
        return iHashCode2 + (onClickListener != null ? onClickListener.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(cnb.z(-388149079440170L));
        yg.u(sb, this.a, -388621525842730L);
        yg.u(sb, this.b, -388587166104362L);
        sb.append(this.c);
        sb.append(cnb.z(-388552806365994L));
        sb.append(this.d);
        sb.append(')');
        return sb.toString();
    }
}
