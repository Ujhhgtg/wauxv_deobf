package me.hd.wauxv.obf;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.ListAdapter;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class jb extends bwn implements jd {
    public CharSequence a;
    public iy b;
    public final Rect c;
    public int d;
    public final /* synthetic */ je q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jb(je jeVar, Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.spinnerStyle, 0);
        this.q = jeVar;
        this.c = new Rect();
        this.ak = jeVar;
        this.au = true;
        this.av.setFocusable(true);
        this.al = new iz(this, 0);
    }

    @Override // me.hd.wauxv.obf.jd
    public final CharSequence h() {
        return this.a;
    }

    @Override // me.hd.wauxv.obf.jd
    public final void j(CharSequence charSequence) {
        this.a = charSequence;
    }

    @Override // me.hd.wauxv.obf.jd
    public final void m(int i) {
        this.d = i;
    }

    @Override // me.hd.wauxv.obf.jd
    public final void n(int i, int i2) {
        ViewTreeObserver viewTreeObserver;
        in inVar = this.av;
        boolean zIsShowing = inVar.isShowing();
        r();
        inVar.setInputMethodMode(2);
        ag();
        aqe aqeVar = this.w;
        aqeVar.setChoiceMode(1);
        aqeVar.setTextDirection(i);
        aqeVar.setTextAlignment(i2);
        je jeVar = this.q;
        int selectedItemPosition = jeVar.getSelectedItemPosition();
        aqe aqeVar2 = this.w;
        if (inVar.isShowing() && aqeVar2 != null) {
            aqeVar2.setListSelectionHidden(false);
            aqeVar2.setSelection(selectedItemPosition);
            if (aqeVar2.getChoiceMode() != 0) {
                aqeVar2.setItemChecked(selectedItemPosition, true);
            }
        }
        if (zIsShowing || (viewTreeObserver = jeVar.getViewTreeObserver()) == null) {
            return;
        }
        iv ivVar = new iv(this, 1);
        viewTreeObserver.addOnGlobalLayoutListener(ivVar);
        inVar.setOnDismissListener(new ja(this, ivVar));
    }

    @Override // me.hd.wauxv.obf.bwn, me.hd.wauxv.obf.jd
    public final void p(ListAdapter listAdapter) {
        super.p(listAdapter);
        this.b = (iy) listAdapter;
    }

    public final void r() {
        int i;
        je jeVar = this.q;
        Rect rect = jeVar.i;
        in inVar = this.av;
        Drawable background = inVar.getBackground();
        if (background != null) {
            background.getPadding(rect);
            i = jeVar.getLayoutDirection() == 1 ? rect.right : -rect.left;
        } else {
            i = 0;
            rect.right = 0;
            rect.left = 0;
        }
        int paddingLeft = jeVar.getPaddingLeft();
        int paddingRight = jeVar.getPaddingRight();
        int width = jeVar.getWidth();
        int i2 = jeVar.h;
        if (i2 == -2) {
            int iJ = jeVar.j(this.b, inVar.getBackground());
            int i3 = (jeVar.getContext().getResources().getDisplayMetrics().widthPixels - rect.left) - rect.right;
            if (iJ > i3) {
                iJ = i3;
            }
            ax(Math.max(iJ, (width - paddingLeft) - paddingRight));
        } else if (i2 == -1) {
            ax((width - paddingLeft) - paddingRight);
        } else {
            ax(i2);
        }
        this.z = jeVar.getLayoutDirection() == 1 ? (((width - paddingRight) - this.y) - this.d) + i : paddingLeft + this.d + i;
    }
}
