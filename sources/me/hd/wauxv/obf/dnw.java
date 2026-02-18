package me.hd.wauxv.obf;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dnw extends cbw implements SubMenu {
    public final cbw aw;
    public final cbz ax;

    public dnw(Context context, cbw cbwVar, cbz cbzVar) {
        super(context);
        this.aw = cbwVar;
        this.ax = cbzVar;
    }

    @Override // me.hd.wauxv.obf.cbw
    public final boolean ac(cbz cbzVar) {
        return this.aw.ac(cbzVar);
    }

    @Override // me.hd.wauxv.obf.cbw
    public final boolean ad(cbw cbwVar, MenuItem menuItem) {
        return super.ad(cbwVar, menuItem) || this.aw.ad(cbwVar, menuItem);
    }

    @Override // me.hd.wauxv.obf.cbw
    public final boolean ae(cbz cbzVar) {
        return this.aw.ae(cbzVar);
    }

    @Override // me.hd.wauxv.obf.cbw
    public final String ai() {
        cbz cbzVar = this.ax;
        int i = cbzVar != null ? cbzVar.a : 0;
        if (i == 0) {
            return null;
        }
        return concatVar2Var1(i, "android:menu:actionviewstates:");
    }

    @Override // me.hd.wauxv.obf.cbw
    public final cbw aj() {
        return this.aw.aj();
    }

    @Override // me.hd.wauxv.obf.cbw
    public final boolean al() {
        return this.aw.al();
    }

    @Override // me.hd.wauxv.obf.cbw
    public final boolean am() {
        return this.aw.am();
    }

    @Override // me.hd.wauxv.obf.cbw
    public final boolean an() {
        return this.aw.an();
    }

    @Override // android.view.SubMenu
    public final MenuItem getItem() {
        return this.ax;
    }

    @Override // me.hd.wauxv.obf.cbw, android.view.Menu
    public final void setGroupDividerEnabled(boolean z) {
        this.aw.setGroupDividerEnabled(z);
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(Drawable drawable) {
        at(0, null, 0, drawable, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(CharSequence charSequence) {
        at(0, charSequence, 0, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderView(View view) {
        at(0, null, 0, null, view);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(Drawable drawable) {
        this.ax.setIcon(drawable);
        return this;
    }

    @Override // me.hd.wauxv.obf.cbw, android.view.Menu
    public final void setQwertyMode(boolean z) {
        this.aw.setQwertyMode(z);
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(int i) {
        at(0, null, i, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(int i) {
        at(i, null, 0, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(int i) {
        this.ax.setIcon(i);
        return this;
    }
}
