package me.hd.wauxv.obf;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cbz implements dog {
    public final int a;
    public int aa;
    public View ab;
    public cca ac;
    public MenuItem.OnActionExpandListener ad;
    public final int b;
    public final int c;
    public final int d;
    public CharSequence e;
    public CharSequence f;
    public Intent g;
    public char h;
    public char j;
    public Drawable l;
    public final cbw n;
    public dnw o;
    public MenuItem.OnMenuItemClickListener p;
    public CharSequence s;
    public CharSequence t;
    public int i = 4096;
    public int k = 4096;
    public int m = 0;
    public ColorStateList u = null;
    public PorterDuff.Mode v = null;
    public boolean w = false;
    public boolean x = false;
    public boolean y = false;
    public int z = 16;
    public boolean ae = false;

    public cbz(cbw cbwVar, int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        this.n = cbwVar;
        this.a = i2;
        this.b = i;
        this.c = i3;
        this.d = i4;
        this.e = charSequence;
        this.aa = i5;
    }

    public static void af(int i, int i2, String str, StringBuilder sb) {
        if ((i & i2) == i2) {
            sb.append(str);
        }
    }

    public final Drawable ag(Drawable drawable) {
        if (drawable != null && this.y && (this.w || this.x)) {
            drawable = drawable.mutate();
            if (this.w) {
                drawable.setTintList(this.u);
            }
            if (this.x) {
                drawable.setTintMode(this.v);
            }
            this.y = false;
        }
        return drawable;
    }

    public final boolean ah() {
        cca ccaVar;
        if ((this.aa & 8) != 0) {
            if (this.ab == null && (ccaVar = this.ac) != null) {
                this.ab = ccaVar.b.onCreateActionView(this);
            }
            if (this.ab != null) {
                return true;
            }
        }
        return false;
    }

    public final void ai(boolean z) {
        this.z = (z ? 4 : 0) | (this.z & (-5));
    }

    public final void aj(boolean z) {
        if (z) {
            this.z |= 32;
        } else {
            this.z &= -33;
        }
    }

    @Override // android.view.MenuItem
    public final boolean collapseActionView() {
        if ((this.aa & 8) == 0) {
            return false;
        }
        if (this.ab == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.ad;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.n.ac(this);
        }
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean expandActionView() {
        if (!ah()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.ad;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.n.ae(this);
        }
        return false;
    }

    @Override // android.view.MenuItem
    public final ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // android.view.MenuItem
    public final View getActionView() {
        View view = this.ab;
        if (view != null) {
            return view;
        }
        cca ccaVar = this.ac;
        if (ccaVar == null) {
            return null;
        }
        View viewOnCreateActionView = ccaVar.b.onCreateActionView(this);
        this.ab = viewOnCreateActionView;
        return viewOnCreateActionView;
    }

    @Override // me.hd.wauxv.obf.dog, android.view.MenuItem
    public final int getAlphabeticModifiers() {
        return this.k;
    }

    @Override // android.view.MenuItem
    public final char getAlphabeticShortcut() {
        return this.j;
    }

    @Override // me.hd.wauxv.obf.dog, android.view.MenuItem
    public final CharSequence getContentDescription() {
        return this.s;
    }

    @Override // android.view.MenuItem
    public final int getGroupId() {
        return this.b;
    }

    @Override // android.view.MenuItem
    public final Drawable getIcon() {
        Drawable drawable = this.l;
        if (drawable != null) {
            return ag(drawable);
        }
        int i = this.m;
        if (i == 0) {
            return null;
        }
        Drawable drawableY = cmz.y(this.n.b, i);
        this.m = 0;
        this.l = drawableY;
        return ag(drawableY);
    }

    @Override // me.hd.wauxv.obf.dog, android.view.MenuItem
    public final ColorStateList getIconTintList() {
        return this.u;
    }

    @Override // me.hd.wauxv.obf.dog, android.view.MenuItem
    public final PorterDuff.Mode getIconTintMode() {
        return this.v;
    }

    @Override // android.view.MenuItem
    public final Intent getIntent() {
        return this.g;
    }

    @Override // android.view.MenuItem
    public final int getItemId() {
        return this.a;
    }

    @Override // android.view.MenuItem
    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // me.hd.wauxv.obf.dog, android.view.MenuItem
    public final int getNumericModifiers() {
        return this.i;
    }

    @Override // android.view.MenuItem
    public final char getNumericShortcut() {
        return this.h;
    }

    @Override // android.view.MenuItem
    public final int getOrder() {
        return this.c;
    }

    @Override // android.view.MenuItem
    public final SubMenu getSubMenu() {
        return this.o;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitle() {
        return this.e;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f;
        return charSequence != null ? charSequence : this.e;
    }

    @Override // me.hd.wauxv.obf.dog, android.view.MenuItem
    public final CharSequence getTooltipText() {
        return this.t;
    }

    @Override // android.view.MenuItem
    public final boolean hasSubMenu() {
        return this.o != null;
    }

    @Override // android.view.MenuItem
    public final boolean isActionViewExpanded() {
        return this.ae;
    }

    @Override // android.view.MenuItem
    public final boolean isCheckable() {
        return (this.z & 1) == 1;
    }

    @Override // android.view.MenuItem
    public final boolean isChecked() {
        return (this.z & 2) == 2;
    }

    @Override // android.view.MenuItem
    public final boolean isEnabled() {
        return (this.z & 16) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isVisible() {
        cca ccaVar = this.ac;
        return (ccaVar == null || !ccaVar.b.overridesItemVisibility()) ? (this.z & 8) == 0 : (this.z & 8) == 0 && this.ac.b.isVisible();
    }

    @Override // me.hd.wauxv.obf.dog
    public final cca q() {
        return this.ac;
    }

    @Override // me.hd.wauxv.obf.dog
    public final dog r(cca ccaVar) {
        this.ab = null;
        this.ac = ccaVar;
        this.n.ao(true);
        cca ccaVar2 = this.ac;
        if (ccaVar2 != null) {
            ccaVar2.a = new bmu(this);
            ccaVar2.b.setVisibilityListener(ccaVar2);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(View view) {
        int i;
        this.ab = view;
        this.ac = null;
        if (view != null && view.getId() == -1 && (i = this.a) > 0) {
            view.setId(i);
        }
        cbw cbwVar = this.n;
        cbwVar.l = true;
        cbwVar.ao(true);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c) {
        if (this.j == c) {
            return this;
        }
        this.j = Character.toLowerCase(c);
        this.n.ao(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setCheckable(boolean z) {
        int i = this.z;
        int i2 = (z ? 1 : 0) | (i & (-2));
        this.z = i2;
        if (i != i2) {
            this.n.ao(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setChecked(boolean z) {
        int i = this.z;
        int i2 = i & 4;
        cbw cbwVar = this.n;
        if (i2 == 0) {
            int i3 = (i & (-3)) | (z ? 2 : 0);
            this.z = i3;
            if (i != i3) {
                cbwVar.ao(false);
            }
            return this;
        }
        ArrayList arrayList = cbwVar.g;
        int size = arrayList.size();
        cbwVar.av();
        for (int i4 = 0; i4 < size; i4++) {
            cbz cbzVar = (cbz) arrayList.get(i4);
            if (cbzVar.b == this.b && (cbzVar.z & 4) != 0 && cbzVar.isCheckable()) {
                boolean z2 = cbzVar == this;
                int i5 = cbzVar.z;
                int i6 = (z2 ? 2 : 0) | (i5 & (-3));
                cbzVar.z = i6;
                if (i5 != i6) {
                    cbzVar.n.ao(false);
                }
            }
        }
        cbwVar.au();
        return this;
    }

    @Override // android.view.MenuItem
    public final /* bridge */ /* synthetic */ MenuItem setContentDescription(CharSequence charSequence) {
        setContentDescription(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setEnabled(boolean z) {
        if (z) {
            this.z |= 16;
        } else {
            this.z &= -17;
        }
        this.n.ao(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(Drawable drawable) {
        this.m = 0;
        this.l = drawable;
        this.y = true;
        this.n.ao(false);
        return this;
    }

    @Override // me.hd.wauxv.obf.dog, android.view.MenuItem
    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.u = colorStateList;
        this.w = true;
        this.y = true;
        this.n.ao(false);
        return this;
    }

    @Override // me.hd.wauxv.obf.dog, android.view.MenuItem
    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.v = mode;
        this.x = true;
        this.y = true;
        this.n.ao(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIntent(Intent intent) {
        this.g = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c) {
        if (this.h == c) {
            return this;
        }
        this.h = c;
        this.n.ao(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.ad = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.p = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setShortcut(char c, char c2) {
        this.h = c;
        this.j = Character.toLowerCase(c2);
        this.n.ao(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final void setShowAsAction(int i) {
        int i2 = i & 3;
        if (i2 != 0 && i2 != 1 && i2 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.aa = i;
        cbw cbwVar = this.n;
        cbwVar.l = true;
        cbwVar.ao(true);
    }

    @Override // android.view.MenuItem
    public final MenuItem setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(CharSequence charSequence) {
        this.e = charSequence;
        this.n.ao(false);
        dnw dnwVar = this.o;
        if (dnwVar != null) {
            dnwVar.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f = charSequence;
        this.n.ao(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final /* bridge */ /* synthetic */ MenuItem setTooltipText(CharSequence charSequence) {
        setTooltipText(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setVisible(boolean z) {
        int i = this.z;
        int i2 = (z ? 0 : 8) | (i & (-9));
        this.z = i2;
        if (i != i2) {
            cbw cbwVar = this.n;
            cbwVar.i = true;
            cbwVar.ao(true);
        }
        return this;
    }

    public final String toString() {
        CharSequence charSequence = this.e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    @Override // me.hd.wauxv.obf.dog, android.view.MenuItem
    public final dog setContentDescription(CharSequence charSequence) {
        this.s = charSequence;
        this.n.ao(false);
        return this;
    }

    @Override // me.hd.wauxv.obf.dog, android.view.MenuItem
    public final dog setTooltipText(CharSequence charSequence) {
        this.t = charSequence;
        this.n.ao(false);
        return this;
    }

    @Override // me.hd.wauxv.obf.dog, android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c, int i) {
        if (this.j == c && this.k == i) {
            return this;
        }
        this.j = Character.toLowerCase(c);
        this.k = KeyEvent.normalizeMetaState(i);
        this.n.ao(false);
        return this;
    }

    @Override // me.hd.wauxv.obf.dog, android.view.MenuItem
    public final MenuItem setNumericShortcut(char c, int i) {
        if (this.h == c && this.i == i) {
            return this;
        }
        this.h = c;
        this.i = KeyEvent.normalizeMetaState(i);
        this.n.ao(false);
        return this;
    }

    @Override // me.hd.wauxv.obf.dog, android.view.MenuItem
    public final MenuItem setShortcut(char c, char c2, int i, int i2) {
        this.h = c;
        this.i = KeyEvent.normalizeMetaState(i);
        this.j = Character.toLowerCase(c2);
        this.k = KeyEvent.normalizeMetaState(i2);
        this.n.ao(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(int i) {
        this.l = null;
        this.m = i;
        this.y = true;
        this.n.ao(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(int i) {
        setTitle(this.n.b.getString(i));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(int i) {
        int i2;
        cbw cbwVar = this.n;
        Context context = cbwVar.b;
        View viewInflate = LayoutInflater.from(context).inflate(i, (ViewGroup) new LinearLayout(context), false);
        this.ab = viewInflate;
        this.ac = null;
        if (viewInflate != null && viewInflate.getId() == -1 && (i2 = this.a) > 0) {
            viewInflate.setId(i2);
        }
        cbwVar.l = true;
        cbwVar.ao(true);
        return this;
    }
}
