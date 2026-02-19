package me.hd.wauxv.obf;

import android.content.Context;
import android.view.SubMenu;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cjz extends cbw {
    public final Class aw;
    public final int ax;

    public cjz(Context context, Class cls, int i) {
        super(context);
        this.aw = cls;
        this.ax = i;
    }

    @Override // me.hd.wauxv.obf.cbw, android.view.Menu
    public final SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        throw new UnsupportedOperationException(this.aw.getSimpleName().concat(" does not support submenus"));
    }

    @Override // me.hd.wauxv.obf.cbw
    public final cbz z(int i, int i2, int i3, CharSequence charSequence) {
        int size = this.g.size() + 1;
        int i4 = this.ax;
        if (size <= i4) {
            av();
            cbz cbzVarZ = super.z(i, i2, i3, charSequence);
            cbzVarZ.ai(true);
            au();
            return cbzVarZ;
        }
        String simpleName = this.aw.getSimpleName();
        StringBuilder sb = new StringBuilder("Maximum number of items supported by ");
        sb.append(simpleName);
        sb.append(" is ");
        sb.append(i4);
        sb.append(". Limit can be checked with ");
        throw new IllegalArgumentException(yg.concatToVar1(sb, simpleName, "#getMaxItemCount()"));
    }
}
