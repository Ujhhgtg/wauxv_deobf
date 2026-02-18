package me.hd.wauxv.obf;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class it extends DefaultConfig {
    public final is bb;
    public Drawable bc;
    public ColorStateList bd;
    public PorterDuff.Mode be;
    public boolean bf;
    public boolean bg;

    public it(is isVar) {
        super(isVar);
        this.bd = null;
        this.be = null;
        this.bf = false;
        this.bg = false;
        this.bb = isVar;
    }

    @Override // me.hd.wauxv.obf.io
    public final void am(AttributeSet attributeSet, int i) {
        super.am(attributeSet, R.attr.seekBarStyle);
        is isVar = this.bb;
        Context context = isVar.getContext();
        int[] iArr = cyf.g;
        jx jxVarK = jx.k(context, attributeSet, iArr, R.attr.seekBarStyle);
        TypedArray typedArray = (TypedArray) jxVarK.e;
        eqz.r(isVar, isVar.getContext(), iArr, attributeSet, (TypedArray) jxVarK.e, R.attr.seekBarStyle, 0);
        Drawable drawableT = jxVarK.t(0);
        if (drawableT != null) {
            isVar.setThumb(drawableT);
        }
        Drawable drawableS = jxVarK.s(1);
        Drawable drawable = this.bc;
        if (drawable != null) {
            drawable.setCallback(null);
        }
        this.bc = drawableS;
        if (drawableS != null) {
            drawableS.setCallback(isVar);
            drawableS.setLayoutDirection(isVar.getLayoutDirection());
            if (drawableS.isStateful()) {
                drawableS.setState(isVar.getDrawableState());
            }
            bh();
        }
        isVar.invalidate();
        if (typedArray.hasValue(3)) {
            this.be = apy.f(typedArray.getInt(3, -1), this.be);
            this.bg = true;
        }
        if (typedArray.hasValue(2)) {
            this.bd = jxVarK.r(2);
            this.bf = true;
        }
        jxVarK.ae();
        bh();
    }

    public final void bh() {
        Drawable drawable = this.bc;
        if (drawable != null) {
            if (this.bf || this.bg) {
                Drawable drawableMutate = drawable.mutate();
                this.bc = drawableMutate;
                if (this.bf) {
                    drawableMutate.setTintList(this.bd);
                }
                if (this.bg) {
                    this.bc.setTintMode(this.be);
                }
                if (this.bc.isStateful()) {
                    this.bc.setState(this.bb.getDrawableState());
                }
            }
        }
    }

    public final void bi(Canvas canvas) {
        if (this.bc != null) {
            int max = this.bb.getMax();
            if (max > 1) {
                int intrinsicWidth = this.bc.getIntrinsicWidth();
                int intrinsicHeight = this.bc.getIntrinsicHeight();
                int i = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i2 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.bc.setBounds(-i, -i2, i, i2);
                float width = ((r0.getWidth() - r0.getPaddingLeft()) - r0.getPaddingRight()) / max;
                int iSave = canvas.save();
                canvas.translate(r0.getPaddingLeft(), r0.getHeight() / 2);
                for (int i3 = 0; i3 <= max; i3++) {
                    this.bc.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(iSave);
            }
        }
    }
}
