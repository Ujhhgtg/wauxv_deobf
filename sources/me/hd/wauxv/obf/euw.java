package me.hd.wauxv.obf;

import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.PathInterpolator;
import java.util.List;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class euw extends euz {
    public static final PathInterpolator a = new PathInterpolator(0.0f, 1.1f, 0.0f, 1.0f);
    public static final ayf _cg = new ayf();
    public static final DecelerateInterpolator _ch = new DecelerateInterpolator(1.5f);
    public static final AccelerateInterpolator _ci = new AccelerateInterpolator(1.5f);

    public static void _cj(View view, eva evaVar) {
        ua uaVarJ = j(view);
        if (uaVarJ != null) {
            uaVarJ._bs();
            if (uaVarJ.b == 0) {
                return;
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                _cj(viewGroup.getChildAt(i), evaVar);
            }
        }
    }

    public static void f(View view, eva evaVar, evr evrVar, boolean z) {
        ua uaVarJ = j(view);
        if (uaVarJ != null) {
            uaVarJ.c = evrVar;
            if (!z) {
                uaVarJ._bt();
                z = uaVarJ.b == 0;
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                f(viewGroup.getChildAt(i), evaVar, evrVar, z);
            }
        }
    }

    public static void g(View view, evr evrVar, List list) {
        ua uaVarJ = j(view);
        if (uaVarJ != null) {
            evrVar = uaVarJ._bu(evrVar, list);
            if (uaVarJ.b == 0) {
                return;
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                g(viewGroup.getChildAt(i), evrVar, list);
            }
        }
    }

    public static void h(View view, eva evaVar, but butVar) {
        ua uaVarJ = j(view);
        if (uaVarJ != null) {
            uaVarJ._bv(butVar);
            if (uaVarJ.b == 0) {
                return;
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                h(viewGroup.getChildAt(i), evaVar, butVar);
            }
        }
    }

    public static WindowInsets i(View view, WindowInsets windowInsets) {
        return view.getTag(R.id.tag_on_apply_window_listener) != null ? windowInsets : view.onApplyWindowInsets(windowInsets);
    }

    public static ua j(View view) {
        Object tag = view.getTag(R.id.tag_window_insets_animation_callback);
        if (tag instanceof euv) {
            return ((euv) tag).a;
        }
        return null;
    }
}
