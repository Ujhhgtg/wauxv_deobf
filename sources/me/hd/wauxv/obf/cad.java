package me.hd.wauxv.obf;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import com.google.android.material.button.MaterialButton;
import java.util.WeakHashMap;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cad {
    public final MaterialButton a;
    public dgm b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public PorterDuff.Mode i;
    public ColorStateList j;
    public ColorStateList k;
    public ColorStateList l;
    public cau m;
    public boolean q;
    public RippleDrawable s;
    public int t;
    public boolean n = false;
    public boolean o = false;
    public boolean p = false;
    public boolean r = true;

    public cad(MaterialButton materialButton, dgm dgmVar) {
        this.a = materialButton;
        this.b = dgmVar;
    }

    public final dgx u() {
        RippleDrawable rippleDrawable = this.s;
        if (rippleDrawable == null || rippleDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        return this.s.getNumberOfLayers() > 2 ? (dgx) this.s.getDrawable(2) : (dgx) this.s.getDrawable(1);
    }

    public final cau v(boolean z) {
        RippleDrawable rippleDrawable = this.s;
        if (rippleDrawable == null || rippleDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        return (cau) ((LayerDrawable) ((InsetDrawable) this.s.getDrawable(0)).getDrawable()).getDrawable(!z ? 1 : 0);
    }

    public final void w(dgm dgmVar) {
        this.b = dgmVar;
        if (v(false) != null) {
            v(false).setShapeAppearanceModel(dgmVar);
        }
        if (v(true) != null) {
            v(true).setShapeAppearanceModel(dgmVar);
        }
        if (u() != null) {
            u().setShapeAppearanceModel(dgmVar);
        }
    }

    public final void x(int i, int i2) {
        WeakHashMap weakHashMap = ViewCompat.a;
        MaterialButton materialButton = this.a;
        int paddingStart = materialButton.getPaddingStart();
        int paddingTop = materialButton.getPaddingTop();
        int paddingEnd = materialButton.getPaddingEnd();
        int paddingBottom = materialButton.getPaddingBottom();
        int i3 = this.e;
        int i4 = this.f;
        this.f = i2;
        this.e = i;
        if (!this.o) {
            y();
        }
        materialButton.setPaddingRelative(paddingStart, (paddingTop + i) - i3, paddingEnd, (paddingBottom + i2) - i4);
    }

    public final void y() {
        cau cauVar = new cau(this.b);
        MaterialButton materialButton = this.a;
        cauVar.dx(materialButton.getContext());
        cauVar.setTintList(this.j);
        PorterDuff.Mode mode = this.i;
        if (mode != null) {
            cauVar.setTintMode(mode);
        }
        float f = this.h;
        ColorStateList colorStateList = this.k;
        cauVar.ct.k = f;
        cauVar.invalidateSelf();
        cauVar.ed(colorStateList);
        cau cauVar2 = new cau(this.b);
        cauVar2.setTint(0);
        float f2 = this.h;
        int iV = this.n ? cna.v(materialButton, R.attr.colorSurface) : 0;
        cauVar2.ct.k = f2;
        cauVar2.invalidateSelf();
        cauVar2.ed(ColorStateList.valueOf(iV));
        cau cauVar3 = new cau(this.b);
        this.m = cauVar3;
        cauVar3.setTint(-1);
        RippleDrawable rippleDrawable = new RippleDrawable(ddb.i(this.l), new InsetDrawable((Drawable) new LayerDrawable(new Drawable[]{cauVar2, cauVar}), this.c, this.e, this.d, this.f), this.m);
        this.s = rippleDrawable;
        materialButton.setInternalBackground(rippleDrawable);
        cau cauVarV = v(false);
        if (cauVarV != null) {
            cauVarV.dy(this.t);
            cauVarV.setState(materialButton.getDrawableState());
        }
    }

    public final void z() {
        cau cauVarV = v(false);
        cau cauVarV2 = v(true);
        if (cauVarV != null) {
            float f = this.h;
            ColorStateList colorStateList = this.k;
            cauVarV.ct.k = f;
            cauVarV.invalidateSelf();
            cauVarV.ed(colorStateList);
            if (cauVarV2 != null) {
                float f2 = this.h;
                int iV = this.n ? cna.v(this.a, R.attr.colorSurface) : 0;
                cauVarV2.ct.k = f2;
                cauVarV2.invalidateSelf();
                cauVarV2.ed(ColorStateList.valueOf(iV));
            }
        }
    }
}
