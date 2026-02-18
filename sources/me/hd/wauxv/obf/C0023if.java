package me.hd.wauxv.obf;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Log;

/* JADX INFO: renamed from: me.hd.wauxv.obf.if, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class C0023if {
    public static final PorterDuff.Mode a = PorterDuff.Mode.SRC_IN;
    public static C0023if b;
    public dcp c;

    public static synchronized C0023if d() {
        try {
            if (b == null) {
                f();
            }
        } catch (Throwable th) {
            throw th;
        }
        return b;
    }

    public static synchronized PorterDuffColorFilter e(int i, PorterDuff.Mode mode) {
        return dcp.j(i, mode);
    }

    public static synchronized void f() {
        if (b == null) {
            C0023if c0023if = new C0023if();
            b = c0023if;
            c0023if.c = dcp.i();
            dcp dcpVar = b.c;
            ie ieVar = new ie();
            synchronized (dcpVar) {
                dcpVar.h = ieVar;
            }
        }
    }

    public static void g(Drawable drawable, eke ekeVar, int[] iArr) {
        PorterDuff.Mode mode = dcp.a;
        int[] state = drawable.getState();
        if (drawable.mutate() != drawable) {
            Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
            return;
        }
        if ((drawable instanceof LayerDrawable) && drawable.isStateful()) {
            drawable.setState(new int[0]);
            drawable.setState(state);
        }
        boolean z = ekeVar.d;
        if (!z && !ekeVar.c) {
            drawable.clearColorFilter();
            return;
        }
        PorterDuffColorFilter porterDuffColorFilterJ = null;
        ColorStateList colorStateList = z ? ekeVar.a : null;
        PorterDuff.Mode mode2 = ekeVar.c ? ekeVar.b : dcp.a;
        if (colorStateList != null && mode2 != null) {
            porterDuffColorFilterJ = dcp.j(colorStateList.getColorForState(iArr, 0), mode2);
        }
        drawable.setColorFilter(porterDuffColorFilterJ);
    }

    public final synchronized Drawable h(Context context, int i) {
        return this.c.l(context, i);
    }
}
