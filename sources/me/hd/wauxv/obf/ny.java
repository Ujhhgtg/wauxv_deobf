package me.hd.wauxv.obf;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ny extends oc {
    public final String a;
    public final String b;
    public final View.OnClickListener c;

    public ny(String str, String str2, View.OnClickListener onClickListener) {
        this.a = str;
        this.b = str2;
        this.c = onClickListener;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ny)) {
            return false;
        }
        ny nyVar = (ny) obj;
        return bzo.f(this.a, nyVar.a) && bzo.f(this.b, nyVar.b) && bzo.f(this.c, nyVar.c);
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        String str = this.b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        View.OnClickListener onClickListener = this.c;
        return iHashCode2 + (onClickListener != null ? onClickListener.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Content(title=" /* cnb.z(-389115447081770L) */);
        yg.u(sb, this.a, -389033842703146L);
        yg.u(sb, this.b, -388999482964778L);
        sb.append(this.c);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ ny(String str, String str2, View.OnClickListener onClickListener, int i) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : onClickListener);
    }
}
