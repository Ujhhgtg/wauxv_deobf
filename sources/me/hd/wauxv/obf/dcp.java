package me.hd.wauxv.obf;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.TypedValue;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dcp {
    public static dcp b;
    public WeakHashMap d;
    public final WeakHashMap e = new WeakHashMap(0);
    public TypedValue f;
    public boolean g;
    public ie h;
    public static final PorterDuff.Mode a = PorterDuff.Mode.SRC_IN;
    public static final dco c = new dco(6);

    public static synchronized dcp i() {
        try {
            if (b == null) {
                b = new dcp();
            }
        } catch (Throwable th) {
            throw th;
        }
        return b;
    }

    public static synchronized PorterDuffColorFilter j(int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter;
        dco dcoVar = c;
        dcoVar.getClass();
        int i2 = (31 + i) * 31;
        porterDuffColorFilter = (PorterDuffColorFilter) dcoVar.o(Integer.valueOf(mode.hashCode() + i2));
        if (porterDuffColorFilter == null) {
            porterDuffColorFilter = new PorterDuffColorFilter(i, mode);
        }
        return porterDuffColorFilter;
    }

    public final Drawable k(Context context, int i) {
        Drawable drawableNewDrawable;
        WeakReference weakReference;
        if (this.f == null) {
            this.f = new TypedValue();
        }
        TypedValue typedValue = this.f;
        context.getResources().getValue(i, typedValue, true);
        long j = (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
        synchronized (this) {
            byc bycVar = (byc) this.e.get(context);
            drawableNewDrawable = null;
            if (bycVar != null && (weakReference = (WeakReference) bycVar.f(j)) != null) {
                Drawable.ConstantState constantState = (Drawable.ConstantState) weakReference.get();
                if (constantState != null) {
                    drawableNewDrawable = constantState.newDrawable(context.getResources());
                } else {
                    bycVar.j(j);
                }
            }
        }
        if (drawableNewDrawable != null) {
            return drawableNewDrawable;
        }
        LayerDrawable layerDrawableI = null;
        if (this.h != null) {
            if (i == R.drawable.abc_cab_background_top_material) {
                layerDrawableI = new LayerDrawable(new Drawable[]{l(context, R.drawable.abc_cab_background_internal_bg), l(context, R.drawable.abc_cab_background_top_mtrl_alpha)});
            } else if (i == R.drawable.abc_ratingbar_material) {
                layerDrawableI = ie.i(this, context, R.dimen.abc_star_big);
            } else if (i == R.drawable.abc_ratingbar_indicator_material) {
                layerDrawableI = ie.i(this, context, R.dimen.abc_star_medium);
            } else if (i == R.drawable.abc_ratingbar_small_material) {
                layerDrawableI = ie.i(this, context, R.dimen.abc_star_small);
            }
        }
        if (layerDrawableI == null) {
            return layerDrawableI;
        }
        layerDrawableI.setChangingConfigurations(typedValue.changingConfigurations);
        synchronized (this) {
            try {
                Drawable.ConstantState constantState2 = layerDrawableI.getConstantState();
                if (constantState2 != null) {
                    byc bycVar2 = (byc) this.e.get(context);
                    if (bycVar2 == null) {
                        bycVar2 = new byc();
                        this.e.put(context, bycVar2);
                    }
                    bycVar2.i(new WeakReference(constantState2), j);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return layerDrawableI;
    }

    public final synchronized Drawable l(Context context, int i) {
        return m(context, i, false);
    }

    public final synchronized Drawable m(Context context, int i, boolean z) {
        Drawable drawableK;
        try {
            if (!this.g) {
                this.g = true;
                Drawable drawableL = l(context, R.drawable.abc_vector_test);
                if (drawableL == null || (!(drawableL instanceof epl) && !"android.graphics.drawable.VectorDrawable".equals(drawableL.getClass().getName()))) {
                    this.g = false;
                    throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
                }
            }
            drawableK = k(context, i);
            if (drawableK == null) {
                drawableK = context.getDrawable(i);
            }
            if (drawableK != null) {
                drawableK = o(context, i, z, drawableK);
            }
            if (drawableK != null) {
                apy.d(drawableK);
            }
        } catch (Throwable th) {
            throw th;
        }
        return drawableK;
    }

    public final synchronized ColorStateList n(Context context, int i) {
        ColorStateList colorStateList;
        dlo dloVar;
        WeakHashMap weakHashMap = this.d;
        ColorStateList colorStateListK = null;
        colorStateList = (weakHashMap == null || (dloVar = (dlo) weakHashMap.get(context)) == null) ? null : (ColorStateList) dloVar.f(i);
        if (colorStateList == null) {
            ie ieVar = this.h;
            if (ieVar != null) {
                colorStateListK = ieVar.k(context, i);
            }
            if (colorStateListK != null) {
                if (this.d == null) {
                    this.d = new WeakHashMap();
                }
                dlo dloVar2 = (dlo) this.d.get(context);
                if (dloVar2 == null) {
                    dloVar2 = new dlo(0);
                    this.d.put(context, dloVar2);
                }
                dloVar2.e(i, colorStateListK);
            }
            colorStateList = colorStateListK;
        }
        return colorStateList;
    }

    /* JADX WARN: Found duplicated region for block: B:49:0x00e5  */
    /* JADX WARN: Found duplicated region for block: B:51:0x00f6  */
    public final Drawable o(Context context, int i, boolean z, Drawable drawable) {
        int i2;
        boolean z2;
        int iRound;
        Drawable drawableMutate;
        ColorStateList colorStateListN = n(context, i);
        PorterDuff.Mode mode = null;
        if (colorStateListN != null) {
            Drawable drawableMutate2 = drawable.mutate();
            drawableMutate2.setTintList(colorStateListN);
            if (this.h != null && i == R.drawable.abc_switch_thumb_material) {
                mode = PorterDuff.Mode.MULTIPLY;
            }
            if (mode != null) {
                drawableMutate2.setTintMode(mode);
            }
            return drawableMutate2;
        }
        if (this.h != null) {
            if (i == R.drawable.abc_seekbar_track_material) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                Drawable drawableFindDrawableByLayerId = layerDrawable.findDrawableByLayerId(android.R.id.background);
                int iJ = drm.j(context, R.attr.colorControlNormal);
                PorterDuff.Mode mode2 = C0023if.a;
                ie.j(drawableFindDrawableByLayerId, iJ, mode2);
                ie.j(layerDrawable.findDrawableByLayerId(android.R.id.secondaryProgress), drm.j(context, R.attr.colorControlNormal), mode2);
                ie.j(layerDrawable.findDrawableByLayerId(android.R.id.progress), drm.j(context, R.attr.colorControlActivated), mode2);
                return drawable;
            }
            if (i == R.drawable.abc_ratingbar_material || i == R.drawable.abc_ratingbar_indicator_material || i == R.drawable.abc_ratingbar_small_material) {
                LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
                Drawable drawableFindDrawableByLayerId2 = layerDrawable2.findDrawableByLayerId(android.R.id.background);
                int i3 = drm.i(context, R.attr.colorControlNormal);
                PorterDuff.Mode mode3 = C0023if.a;
                ie.j(drawableFindDrawableByLayerId2, i3, mode3);
                ie.j(layerDrawable2.findDrawableByLayerId(android.R.id.secondaryProgress), drm.j(context, R.attr.colorControlActivated), mode3);
                ie.j(layerDrawable2.findDrawableByLayerId(android.R.id.progress), drm.j(context, R.attr.colorControlActivated), mode3);
                return drawable;
            }
        }
        ie ieVar = this.h;
        boolean z3 = false;
        if (ieVar != null) {
            PorterDuff.Mode mode4 = C0023if.a;
            if (ie.g(ieVar.a, i)) {
                i2 = R.attr.colorControlNormal;
            } else if (ie.g(ieVar.c, i)) {
                i2 = R.attr.colorControlActivated;
            } else {
                if (ie.g(ieVar.d, i)) {
                    mode4 = PorterDuff.Mode.MULTIPLY;
                } else {
                    if (i == R.drawable.abc_list_divider_mtrl_alpha) {
                        iRound = Math.round(40.8f);
                        i2 = 16842800;
                        z2 = true;
                    } else {
                        if (i != R.drawable.abc_dialog_material_background) {
                            i2 = 0;
                            z2 = false;
                        }
                        iRound = -1;
                    }
                    if (z2) {
                        drawableMutate = drawable.mutate();
                        drawableMutate.setColorFilter(C0023if.e(drm.j(context, i2), mode4));
                        if (iRound != -1) {
                            drawableMutate.setAlpha(iRound);
                        }
                        z3 = true;
                    }
                }
                i2 = 16842801;
            }
            z2 = true;
            iRound = -1;
            if (z2) {
                drawableMutate = drawable.mutate();
                drawableMutate.setColorFilter(C0023if.e(drm.j(context, i2), mode4));
                if (iRound != -1) {
                    drawableMutate.setAlpha(iRound);
                }
                z3 = true;
            }
        }
        if (z3 || !z) {
            return drawable;
        }
        return null;
    }
}
