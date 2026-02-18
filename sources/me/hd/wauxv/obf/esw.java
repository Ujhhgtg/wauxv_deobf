package me.hd.wauxv.obf;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.constraintlayout.widget.ConstraintLayout;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class esw extends add {
    public boolean d;
    public boolean t;

    public abstract void c(bbp bbpVar, int i, int i2);

    @Override // me.hd.wauxv.obf.add, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.d || this.t) {
            ViewParent parent = getParent();
            if (parent instanceof ConstraintLayout) {
                ConstraintLayout constraintLayout = (ConstraintLayout) parent;
                int visibility = getVisibility();
                float elevation = getElevation();
                for (int i = 0; i < this.f; i++) {
                    View view = (View) constraintLayout.b.get(this.e[i]);
                    if (view != null) {
                        if (this.d) {
                            view.setVisibility(visibility);
                        }
                        if (this.t && elevation > 0.0f) {
                            view.setTranslationZ(view.getTranslationZ() + elevation);
                        }
                    }
                }
            }
        }
    }

    @Override // me.hd.wauxv.obf.add
    public final void p(ConstraintLayout constraintLayout) {
        o(constraintLayout);
    }

    @Override // me.hd.wauxv.obf.add
    public void r(AttributeSet attributeSet) {
        super.r(attributeSet);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, cxx.b);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == 6) {
                    this.d = true;
                } else if (index == 22) {
                    this.t = true;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof ConstraintLayout)) {
            return;
        }
        o((ConstraintLayout) parent);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof ConstraintLayout)) {
            return;
        }
        o((ConstraintLayout) parent);
    }
}
