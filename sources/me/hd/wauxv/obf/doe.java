package me.hd.wauxv.obf;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.util.Log;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import java.lang.reflect.Constructor;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class doe {
    public final Menu a;
    public CharSequence aa;
    public CharSequence ab;
    public final /* synthetic */ dof ae;
    public boolean h;
    public int i;
    public int j;
    public CharSequence k;
    public CharSequence l;
    public int m;
    public char n;
    public int o;
    public char p;
    public int q;
    public int r;
    public boolean s;
    public boolean t;
    public boolean u;
    public int v;
    public int w;
    public String x;
    public String y;
    public cca z;
    public ColorStateList ac = null;
    public PorterDuff.Mode ad = null;
    public int b = 0;
    public int c = 0;
    public int d = 0;
    public int e = 0;
    public boolean f = true;
    public boolean g = true;

    public doe(dof dofVar, Menu menu) {
        this.ae = dofVar;
        this.a = menu;
    }

    public final Object af(String str, Class[] clsArr, Object[] objArr) {
        try {
            Constructor<?> constructor = Class.forName(str, false, this.ae.e.getClassLoader()).getConstructor(clsArr);
            constructor.setAccessible(true);
            return constructor.newInstance(objArr);
        } catch (Exception e) {
            Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e);
            return null;
        }
    }

    public final void ag(MenuItem menuItem) {
        dof dofVar = this.ae;
        Context context = dofVar.e;
        boolean z = false;
        menuItem.setChecked(this.s).setVisible(this.t).setEnabled(this.u).setCheckable(this.r >= 1).setTitleCondensed(this.l).setIcon(this.m);
        int i = this.v;
        if (i >= 0) {
            menuItem.setShowAsAction(i);
        }
        if (this.y != null) {
            if (context.isRestricted()) {
                throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
            }
            if (dofVar.f == null) {
                dofVar.f = dof.g(context);
            }
            Object obj = dofVar.f;
            String str = this.y;
            dod dodVar = new dod();
            dodVar.c = obj;
            Class<?> cls = obj.getClass();
            try {
                dodVar.d = cls.getMethod(str, dod.a);
                menuItem.setOnMenuItemClickListener(dodVar);
            } catch (Exception e) {
                StringBuilder sbZ = StaticHelpers6.concatAndToSb("Couldn't resolve menu item onClick handler ", str, " in class ");
                sbZ.append(cls.getName());
                InflateException inflateException = new InflateException(sbZ.toString());
                inflateException.initCause(e);
                throw inflateException;
            }
        }
        if (this.r >= 2) {
            if (menuItem instanceof cbz) {
                ((cbz) menuItem).ai(true);
            } else if (menuItem instanceof ccd) {
                ccd ccdVar = (ccd) menuItem;
                dog dogVar = ccdVar.a;
                try {
                    if (ccdVar.b == null) {
                        ccdVar.b = dogVar.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
                    }
                    ccdVar.b.invoke(dogVar, Boolean.TRUE);
                } catch (Exception e2) {
                    Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e2);
                }
            }
        }
        String str2 = this.x;
        if (str2 != null) {
            menuItem.setActionView((View) af(str2, dof.a, dofVar.c));
            z = true;
        }
        int i2 = this.w;
        if (i2 > 0) {
            if (z) {
                Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
            } else {
                menuItem.setActionView(i2);
            }
        }
        cca ccaVar = this.z;
        if (ccaVar != null) {
            if (menuItem instanceof dog) {
                ((dog) menuItem).r(ccaVar);
            } else {
                Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
            }
        }
        CharSequence charSequence = this.aa;
        boolean z2 = menuItem instanceof dog;
        if (z2) {
            ((dog) menuItem).setContentDescription(charSequence);
        } else {
            menuItem.setContentDescription(charSequence);
        }
        CharSequence charSequence2 = this.ab;
        if (z2) {
            ((dog) menuItem).setTooltipText(charSequence2);
        } else {
            menuItem.setTooltipText(charSequence2);
        }
        char c = this.n;
        int i3 = this.o;
        if (z2) {
            ((dog) menuItem).setAlphabeticShortcut(c, i3);
        } else {
            menuItem.setAlphabeticShortcut(c, i3);
        }
        char c2 = this.p;
        int i4 = this.q;
        if (z2) {
            ((dog) menuItem).setNumericShortcut(c2, i4);
        } else {
            menuItem.setNumericShortcut(c2, i4);
        }
        PorterDuff.Mode mode = this.ad;
        if (mode != null) {
            if (z2) {
                ((dog) menuItem).setIconTintMode(mode);
            } else {
                menuItem.setIconTintMode(mode);
            }
        }
        ColorStateList colorStateList = this.ac;
        if (colorStateList != null) {
            if (z2) {
                ((dog) menuItem).setIconTintList(colorStateList);
            } else {
                menuItem.setIconTintList(colorStateList);
            }
        }
    }
}
