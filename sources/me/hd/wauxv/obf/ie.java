package me.hd.wauxv.obf;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ie {
    public final int[] a = {R.drawable.abc_textfield_search_default_mtrl_alpha, R.drawable.abc_textfield_default_mtrl_alpha, R.drawable.abc_ab_share_pack_mtrl_alpha};
    public final int[] b = {R.drawable.abc_ic_commit_search_api_mtrl_alpha, R.drawable.abc_seekbar_tick_mark_material, R.drawable.abc_ic_menu_share_mtrl_alpha, R.drawable.abc_ic_menu_copy_mtrl_am_alpha, R.drawable.abc_ic_menu_cut_mtrl_alpha, R.drawable.abc_ic_menu_selectall_mtrl_alpha, R.drawable.abc_ic_menu_paste_mtrl_am_alpha};
    public final int[] c = {R.drawable.abc_textfield_activated_mtrl_alpha, R.drawable.abc_textfield_search_activated_mtrl_alpha, R.drawable.abc_cab_background_top_mtrl_alpha, R.drawable.abc_text_cursor_material, R.drawable.abc_text_select_handle_left_mtrl, R.drawable.abc_text_select_handle_middle_mtrl, R.drawable.abc_text_select_handle_right_mtrl};
    public final int[] d = {R.drawable.abc_popup_background_mtrl_mult, R.drawable.abc_cab_background_internal_bg, R.drawable.abc_menu_hardkey_panel_mtrl_mult};
    public final int[] e = {R.drawable.abc_tab_indicator_material, R.drawable.abc_textfield_search_material};
    public final int[] f = {R.drawable.abc_btn_check_material, R.drawable.abc_btn_radio_material, R.drawable.abc_btn_check_material_anim, R.drawable.abc_btn_radio_material_anim};

    public static boolean g(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public static ColorStateList h(Context context, int i) {
        int iJ = drm.j(context, R.attr.colorControlHighlight);
        int i2 = drm.i(context, R.attr.colorButtonNormal);
        int[] iArr = drm.b;
        int[] iArr2 = drm.d;
        int iD = abi.d(iJ, i);
        return new ColorStateList(new int[][]{iArr, iArr2, drm.c, drm.f}, new int[]{i2, iD, abi.d(iJ, i), i});
    }

    public static LayerDrawable i(dcp dcpVar, Context context, int i) {
        BitmapDrawable bitmapDrawable;
        BitmapDrawable bitmapDrawable2;
        BitmapDrawable bitmapDrawable3;
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(i);
        Drawable drawableL = dcpVar.l(context, R.drawable.abc_star_black_48dp);
        Drawable drawableL2 = dcpVar.l(context, R.drawable.abc_star_half_black_48dp);
        if ((drawableL instanceof BitmapDrawable) && drawableL.getIntrinsicWidth() == dimensionPixelSize && drawableL.getIntrinsicHeight() == dimensionPixelSize) {
            bitmapDrawable = (BitmapDrawable) drawableL;
            bitmapDrawable2 = new BitmapDrawable(bitmapDrawable.getBitmap());
        } else {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawableL.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            drawableL.draw(canvas);
            bitmapDrawable = new BitmapDrawable(bitmapCreateBitmap);
            bitmapDrawable2 = new BitmapDrawable(bitmapCreateBitmap);
        }
        bitmapDrawable2.setTileModeX(Shader.TileMode.REPEAT);
        if ((drawableL2 instanceof BitmapDrawable) && drawableL2.getIntrinsicWidth() == dimensionPixelSize && drawableL2.getIntrinsicHeight() == dimensionPixelSize) {
            bitmapDrawable3 = (BitmapDrawable) drawableL2;
        } else {
            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(bitmapCreateBitmap2);
            drawableL2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            drawableL2.draw(canvas2);
            bitmapDrawable3 = new BitmapDrawable(bitmapCreateBitmap2);
        }
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable, bitmapDrawable3, bitmapDrawable2});
        layerDrawable.setId(0, android.R.id.background);
        layerDrawable.setId(1, android.R.id.secondaryProgress);
        layerDrawable.setId(2, android.R.id.progress);
        return layerDrawable;
    }

    public static void j(Drawable drawable, int i, PorterDuff.Mode mode) {
        Drawable drawableMutate = drawable.mutate();
        if (mode == null) {
            mode = C0023if.a;
        }
        drawableMutate.setColorFilter(C0023if.e(i, mode));
    }

    public final ColorStateList k(Context context, int i) {
        if (i == R.drawable.abc_edit_text_material) {
            return ResourcesCompat.v(context, R.color.abc_tint_edittext);
        }
        if (i == R.drawable.abc_switch_track_mtrl_alpha) {
            return ResourcesCompat.v(context, R.color.abc_tint_switch_track);
        }
        if (i != R.drawable.abc_switch_thumb_material) {
            if (i == R.drawable.abc_btn_default_mtrl_shape) {
                return h(context, drm.j(context, R.attr.colorButtonNormal));
            }
            if (i == R.drawable.abc_btn_borderless_material) {
                return h(context, 0);
            }
            if (i == R.drawable.abc_btn_colored_material) {
                return h(context, drm.j(context, R.attr.colorAccent));
            }
            if (i == R.drawable.abc_spinner_mtrl_am_alpha || i == R.drawable.abc_spinner_textfield_background_material) {
                return ResourcesCompat.v(context, R.color.abc_tint_spinner);
            }
            if (g(this.b, i)) {
                return drm.k(context, R.attr.colorControlNormal);
            }
            if (g(this.e, i)) {
                return ResourcesCompat.v(context, R.color.abc_tint_default);
            }
            if (g(this.f, i)) {
                return ResourcesCompat.v(context, R.color.abc_tint_btn_checkable);
            }
            if (i == R.drawable.abc_seekbar_thumb_material) {
                return ResourcesCompat.v(context, R.color.abc_tint_seek_thumb);
            }
            return null;
        }
        int[][] iArr = new int[3][];
        int[] iArr2 = new int[3];
        ColorStateList colorStateListK = drm.k(context, R.attr.colorSwitchThumbNormal);
        if (colorStateListK == null || !colorStateListK.isStateful()) {
            iArr[0] = drm.b;
            iArr2[0] = drm.i(context, R.attr.colorSwitchThumbNormal);
            iArr[1] = drm.e;
            iArr2[1] = drm.j(context, R.attr.colorControlActivated);
            iArr[2] = drm.f;
            iArr2[2] = drm.j(context, R.attr.colorSwitchThumbNormal);
        } else {
            int[] iArr3 = drm.b;
            iArr[0] = iArr3;
            iArr2[0] = colorStateListK.getColorForState(iArr3, 0);
            iArr[1] = drm.e;
            iArr2[1] = drm.j(context, R.attr.colorControlActivated);
            iArr[2] = drm.f;
            iArr2[2] = colorStateListK.getDefaultColor();
        }
        return new ColorStateList(iArr, iArr2);
    }
}
