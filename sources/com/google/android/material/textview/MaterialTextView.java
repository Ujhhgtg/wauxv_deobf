package com.google.android.material.textview;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import me.hd.wauxv.obf.cmz;
import me.hd.wauxv.obf.cxs;
import me.hd.wauxv.obf.jp;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class MaterialTextView extends jp {
    public MaterialTextView(Context context, AttributeSet attributeSet) {
        super(cmz.aq(context, attributeSet, R.attr.textViewStyle, 0), attributeSet, R.attr.textViewStyle);
        Context context2 = getContext();
        if (cmz.am(context2, me.hd.wauxv.R.attr.textAppearanceLineHeightEnabled, true)) {
            Resources.Theme theme = context2.getTheme();
            int[] iArr = cxs.ab;
            TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, iArr, R.attr.textViewStyle, 0);
            int iA = a(context2, typedArrayObtainStyledAttributes, 1, 2);
            typedArrayObtainStyledAttributes.recycle();
            if (iA != -1) {
                return;
            }
            TypedArray typedArrayObtainStyledAttributes2 = theme.obtainStyledAttributes(attributeSet, iArr, R.attr.textViewStyle, 0);
            int resourceId = typedArrayObtainStyledAttributes2.getResourceId(0, -1);
            typedArrayObtainStyledAttributes2.recycle();
            if (resourceId != -1) {
                TypedArray typedArrayObtainStyledAttributes3 = theme.obtainStyledAttributes(resourceId, cxs.aa);
                int iA2 = a(getContext(), typedArrayObtainStyledAttributes3, 1, 2);
                typedArrayObtainStyledAttributes3.recycle();
                if (iA2 >= 0) {
                    setLineHeight(iA2);
                }
            }
        }
    }

    public static int a(Context context, TypedArray typedArray, int... iArr) {
        int dimensionPixelSize = -1;
        for (int i = 0; i < iArr.length && dimensionPixelSize < 0; i++) {
            int i2 = iArr[i];
            TypedValue typedValue = new TypedValue();
            if (typedArray.getValue(i2, typedValue) && typedValue.type == 2) {
                TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{typedValue.data});
                int dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, -1);
                typedArrayObtainStyledAttributes.recycle();
                dimensionPixelSize = dimensionPixelSize2;
            } else {
                dimensionPixelSize = typedArray.getDimensionPixelSize(i2, -1);
            }
        }
        return dimensionPixelSize;
    }

    @Override // me.hd.wauxv.obf.jp, android.widget.TextView
    public final void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (cmz.am(context, me.hd.wauxv.R.attr.textAppearanceLineHeightEnabled, true)) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(i, cxs.aa);
            int iA = a(getContext(), typedArrayObtainStyledAttributes, 1, 2);
            typedArrayObtainStyledAttributes.recycle();
            if (iA >= 0) {
                setLineHeight(iA);
            }
        }
    }
}
