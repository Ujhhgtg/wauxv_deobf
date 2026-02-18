package me.hd.wauxv.obf;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import android.widget.TextView;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class hh {
    public ColorStateList a = null;
    public PorterDuff.Mode b = null;
    public boolean c = false;
    public boolean d = false;
    public boolean e;
    public final TextView f;

    public /* synthetic */ hh(TextView textView) {
        this.f = textView;
    }

    public void g() {
        CompoundButton compoundButton = (CompoundButton) this.f;
        Drawable buttonDrawable = compoundButton.getButtonDrawable();
        if (buttonDrawable != null) {
            if (this.c || this.d) {
                Drawable drawableMutate = buttonDrawable.mutate();
                if (this.c) {
                    drawableMutate.setTintList(this.a);
                }
                if (this.d) {
                    drawableMutate.setTintMode(this.b);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(compoundButton.getDrawableState());
                }
                compoundButton.setButtonDrawable(drawableMutate);
            }
        }
    }

    public void h() {
        hg hgVar = (hg) this.f;
        Drawable checkMarkDrawable = hgVar.getCheckMarkDrawable();
        if (checkMarkDrawable != null) {
            if (this.c || this.d) {
                Drawable drawableMutate = checkMarkDrawable.mutate();
                if (this.c) {
                    drawableMutate.setTintList(this.a);
                }
                if (this.d) {
                    drawableMutate.setTintMode(this.b);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(hgVar.getDrawableState());
                }
                hgVar.setCheckMarkDrawable(drawableMutate);
            }
        }
    }

    public void i(AttributeSet attributeSet, int i) {
        int resourceId;
        int resourceId2;
        CompoundButton compoundButton = (CompoundButton) this.f;
        Context context = compoundButton.getContext();
        int[] iArr = cyf.m;
        jx jxVarK = jx.k(context, attributeSet, iArr, i);
        TypedArray typedArray = (TypedArray) jxVarK.e;
        eqz.r(compoundButton, compoundButton.getContext(), iArr, attributeSet, (TypedArray) jxVarK.e, i, 0);
        try {
            if (typedArray.hasValue(1) && (resourceId2 = typedArray.getResourceId(1, 0)) != 0) {
                try {
                    compoundButton.setButtonDrawable(cmz.y(compoundButton.getContext(), resourceId2));
                } catch (Resources.NotFoundException unused) {
                    if (typedArray.hasValue(0)) {
                        compoundButton.setButtonDrawable(cmz.y(compoundButton.getContext(), resourceId));
                    }
                }
            } else if (typedArray.hasValue(0) && (resourceId = typedArray.getResourceId(0, 0)) != 0) {
                compoundButton.setButtonDrawable(cmz.y(compoundButton.getContext(), resourceId));
            }
            if (typedArray.hasValue(2)) {
                compoundButton.setButtonTintList(jxVarK.r(2));
            }
            if (typedArray.hasValue(3)) {
                compoundButton.setButtonTintMode(apy.f(typedArray.getInt(3, -1), null));
            }
        } finally {
            jxVarK.ae();
        }
    }
}
