package me.hd.wauxv.obf;

import android.content.res.ColorStateList;
import android.graphics.drawable.Animatable2;
import android.graphics.drawable.Drawable;
import com.google.android.material.checkbox.MaterialCheckBox;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ew extends Animatable2.AnimationCallback {
    public final /* synthetic */ cap a;

    public ew(cap capVar) {
        this.a = capVar;
    }

    @Override // android.graphics.drawable.Animatable2.AnimationCallback
    public final void onAnimationEnd(Drawable drawable) {
        ColorStateList colorStateList = this.a.b.o;
        if (colorStateList != null) {
            drawable.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Animatable2.AnimationCallback
    public final void onAnimationStart(Drawable drawable) {
        MaterialCheckBox materialCheckBox = this.a.b;
        ColorStateList colorStateList = materialCheckBox.o;
        if (colorStateList != null) {
            drawable.setTint(colorStateList.getColorForState(materialCheckBox.s, colorStateList.getDefaultColor()));
        }
    }
}
