package com.google.android.material.materialswitch;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.SwitchCompat;
import me.hd.wauxv.R;
import me.hd.wauxv.obf.abi;
import me.hd.wauxv.obf.FastKV;
import me.hd.wauxv.obf.cmz;
import me.hd.wauxv.obf.cxs;
import me.hd.wauxv.obf.StaticAndroidHelpers;
import me.hd.wauxv.obf.FactoryPools;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class MaterialSwitch extends SwitchCompat {
    public static final int[] ax = {R.attr.state_with_icon};
    public Drawable ay;
    public Drawable az;
    public int ba;
    public Drawable bb;
    public Drawable bc;
    public ColorStateList bd;
    public ColorStateList be;
    public PorterDuff.Mode bf;
    public ColorStateList bg;
    public ColorStateList bh;
    public PorterDuff.Mode bi;
    public int[] bj;
    public int[] bk;

    public MaterialSwitch(Context context, AttributeSet attributeSet) {
        super(cmz.aq(context, attributeSet, R.attr.materialSwitchStyle, R.style.Widget_Material3_CompoundButton_MaterialSwitch), attributeSet, R.attr.materialSwitchStyle);
        this.ba = -1;
        Context context2 = getContext();
        this.ay = super.getThumbDrawable();
        this.bd = super.getThumbTintList();
        super.setThumbTintList(null);
        this.bb = super.getTrackDrawable();
        this.bg = super.getTrackTintList();
        super.setTrackTintList(null);
        FactoryPools factoryPoolsVarAo = FastKV.ao(context2, attributeSet, cxs.z, R.attr.materialSwitchStyle, R.style.Widget_Material3_CompoundButton_MaterialSwitch, new int[0]);
        this.az = factoryPoolsVarAo.s(0);
        TypedArray typedArray = (TypedArray) factoryPoolsVarAo.e;
        this.ba = typedArray.getDimensionPixelSize(1, -1);
        this.be = factoryPoolsVarAo.r(2);
        int i = typedArray.getInt(3, -1);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        this.bf = StaticAndroidHelpers.ap(i, mode);
        this.bc = factoryPoolsVarAo.s(4);
        this.bh = factoryPoolsVarAo.r(5);
        this.bi = StaticAndroidHelpers.ap(typedArray.getInt(6, -1), mode);
        factoryPoolsVarAo.ae();
        setEnforceSwitchWidth(false);
        bm();
        bn();
    }

    public static void bl(Drawable drawable, ColorStateList colorStateList, int[] iArr, int[] iArr2, float f) {
        if (drawable == null || colorStateList == null) {
            return;
        }
        drawable.setTint(abi.c(colorStateList.getColorForState(iArr, 0), f, colorStateList.getColorForState(iArr2, 0)));
    }

    public final void bm() {
        this.ay = cmz.r(this.ay, this.bd, getThumbTintMode());
        this.az = cmz.r(this.az, this.be, this.bf);
        bo();
        Drawable drawable = this.ay;
        Drawable drawable2 = this.az;
        int i = this.ba;
        super.setThumbDrawable(cmz.q(drawable, drawable2, i, i));
        refreshDrawableState();
    }

    public final void bn() {
        this.bb = cmz.r(this.bb, this.bg, getTrackTintMode());
        this.bc = cmz.r(this.bc, this.bh, this.bi);
        bo();
        Drawable layerDrawable = this.bb;
        if (layerDrawable != null && this.bc != null) {
            layerDrawable = new LayerDrawable(new Drawable[]{this.bb, this.bc});
        } else if (layerDrawable == null) {
            layerDrawable = this.bc;
        }
        if (layerDrawable != null) {
            setSwitchMinWidth(layerDrawable.getIntrinsicWidth());
        }
        super.setTrackDrawable(layerDrawable);
    }

    public final void bo() {
        if (this.bd == null && this.be == null && this.bg == null && this.bh == null) {
            return;
        }
        float thumbPosition = getThumbPosition();
        ColorStateList colorStateList = this.bd;
        if (colorStateList != null) {
            bl(this.ay, colorStateList, this.bj, this.bk, thumbPosition);
        }
        ColorStateList colorStateList2 = this.be;
        if (colorStateList2 != null) {
            bl(this.az, colorStateList2, this.bj, this.bk, thumbPosition);
        }
        ColorStateList colorStateList3 = this.bg;
        if (colorStateList3 != null) {
            bl(this.bb, colorStateList3, this.bj, this.bk, thumbPosition);
        }
        ColorStateList colorStateList4 = this.bh;
        if (colorStateList4 != null) {
            bl(this.bc, colorStateList4, this.bj, this.bk, thumbPosition);
        }
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public Drawable getThumbDrawable() {
        return this.ay;
    }

    public Drawable getThumbIconDrawable() {
        return this.az;
    }

    public int getThumbIconSize() {
        return this.ba;
    }

    public ColorStateList getThumbIconTintList() {
        return this.be;
    }

    public PorterDuff.Mode getThumbIconTintMode() {
        return this.bf;
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public ColorStateList getThumbTintList() {
        return this.bd;
    }

    public Drawable getTrackDecorationDrawable() {
        return this.bc;
    }

    public ColorStateList getTrackDecorationTintList() {
        return this.bh;
    }

    public PorterDuff.Mode getTrackDecorationTintMode() {
        return this.bi;
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public Drawable getTrackDrawable() {
        return this.bb;
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public ColorStateList getTrackTintList() {
        return this.bg;
    }

    @Override // android.view.View
    public final void invalidate() {
        bo();
        super.invalidate();
    }

    @Override // androidx.appcompat.widget.SwitchCompat, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (this.az != null) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, ax);
        }
        int[] iArr = new int[iArrOnCreateDrawableState.length];
        int i2 = 0;
        for (int i3 : iArrOnCreateDrawableState) {
            if (i3 != 16842912) {
                iArr[i2] = i3;
                i2++;
            }
        }
        this.bj = iArr;
        this.bk = cmz.w(iArrOnCreateDrawableState);
        return iArrOnCreateDrawableState;
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setThumbDrawable(Drawable drawable) {
        this.ay = drawable;
        bm();
    }

    public void setThumbIconDrawable(Drawable drawable) {
        this.az = drawable;
        bm();
    }

    public void setThumbIconResource(int i) {
        setThumbIconDrawable(cmz.y(getContext(), i));
    }

    public void setThumbIconSize(int i) {
        if (this.ba != i) {
            this.ba = i;
            bm();
        }
    }

    public void setThumbIconTintList(ColorStateList colorStateList) {
        this.be = colorStateList;
        bm();
    }

    public void setThumbIconTintMode(PorterDuff.Mode mode) {
        this.bf = mode;
        bm();
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setThumbTintList(ColorStateList colorStateList) {
        this.bd = colorStateList;
        bm();
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setThumbTintMode(PorterDuff.Mode mode) {
        super.setThumbTintMode(mode);
        bm();
    }

    public void setTrackDecorationDrawable(Drawable drawable) {
        this.bc = drawable;
        bn();
    }

    public void setTrackDecorationResource(int i) {
        setTrackDecorationDrawable(cmz.y(getContext(), i));
    }

    public void setTrackDecorationTintList(ColorStateList colorStateList) {
        this.bh = colorStateList;
        bn();
    }

    public void setTrackDecorationTintMode(PorterDuff.Mode mode) {
        this.bi = mode;
        bn();
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setTrackDrawable(Drawable drawable) {
        this.bb = drawable;
        bn();
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setTrackTintList(ColorStateList colorStateList) {
        this.bg = colorStateList;
        bn();
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setTrackTintMode(PorterDuff.Mode mode) {
        super.setTrackTintMode(mode);
        bn();
    }
}
