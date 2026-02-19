package com.google.android.material.radiobutton;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import me.hd.wauxv.obf.FastKV;
import me.hd.wauxv.obf.cmz;
import me.hd.wauxv.obf.cna;
import me.hd.wauxv.obf.cnb;
import me.hd.wauxv.obf.cxs;
import me.hd.wauxv.obf.ip;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class MaterialRadioButton extends ip {
    public static final int[][] a = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};
    public ColorStateList b;
    public boolean c;

    public MaterialRadioButton(Context context, AttributeSet attributeSet) {
        super(cmz.aq(context, attributeSet, me.hd.wauxv.R.attr.radioButtonStyle, me.hd.wauxv.R.style.Widget_MaterialComponents_CompoundButton_RadioButton), attributeSet, 0);
        Context context2 = getContext();
        TypedArray typedArrayAn = FastKV.an(context2, attributeSet, cxs.x, me.hd.wauxv.R.attr.radioButtonStyle, me.hd.wauxv.R.style.Widget_MaterialComponents_CompoundButton_RadioButton, new int[0]);
        if (typedArrayAn.hasValue(0)) {
            setButtonTintList(cnb.v(context2, typedArrayAn, 0));
        }
        this.c = typedArrayAn.getBoolean(1, false);
        typedArrayAn.recycle();
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.b == null) {
            int iV = cna.v(this, me.hd.wauxv.R.attr.colorControlActivated);
            int iV2 = cna.v(this, me.hd.wauxv.R.attr.colorOnSurface);
            int iV3 = cna.v(this, me.hd.wauxv.R.attr.colorSurface);
            this.b = new ColorStateList(a, new int[]{cna.ad(iV3, 1.0f, iV), cna.ad(iV3, 0.54f, iV2), cna.ad(iV3, 0.38f, iV2), cna.ad(iV3, 0.38f, iV2)});
        }
        return this.b;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.c && getButtonTintList() == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z) {
        this.c = z;
        if (z) {
            setButtonTintList(getMaterialThemeColorsTintList());
        } else {
            setButtonTintList(null);
        }
    }
}
