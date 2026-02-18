package me.hd.wauxv.obf;

import android.R;
import android.graphics.Insets;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class apy {
    public static final int[] a = {R.attr.state_checked};
    public static final int[] b = new int[0];
    public static final Rect c = new Rect();

    public static void d(Drawable drawable) {
        String name = drawable.getClass().getName();
        int i = Build.VERSION.SDK_INT;
        if (i < 29 || i >= 31 || !"android.graphics.drawable.ColorStateListDrawable".equals(name)) {
            return;
        }
        int[] state = drawable.getState();
        if (state == null || state.length == 0) {
            drawable.setState(a);
        } else {
            drawable.setState(b);
        }
        drawable.setState(state);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Rect e(Drawable drawable) {
        Object obj;
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            Insets insetsA = apv.a(drawable);
            return new Rect(insetsA.left, insetsA.top, insetsA.right, insetsA.bottom);
        }
        if (drawable instanceof ewc) {
            obj = drawable;
            ((ewd) ((ewc) drawable)).getClass();
            obj = null;
        }
        if (i >= 29) {
            boolean z = apu.a;
        } else if (apu.a) {
            try {
                Object objInvoke = apu.b.invoke(obj, null);
                if (objInvoke != null) {
                    return new Rect(apu.c.getInt(objInvoke), apu.d.getInt(objInvoke), apu.e.getInt(objInvoke), apu.f.getInt(objInvoke));
                }
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
        return c;
    }

    public static PorterDuff.Mode f(int i, PorterDuff.Mode mode) {
        if (i == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }
}
