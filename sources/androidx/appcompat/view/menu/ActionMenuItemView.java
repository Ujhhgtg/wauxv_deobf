package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import me.hd.wauxv.obf.cbv;
import me.hd.wauxv.obf.cbw;
import me.hd.wauxv.obf.cbz;
import me.hd.wauxv.obf.ccn;
import me.hd.wauxv.obf.co;
import me.hd.wauxv.obf.cp;
import me.hd.wauxv.obf.cx;
import me.hd.wauxv.obf.cyf;
import me.hd.wauxv.obf.eku;
import me.hd.wauxv.obf.jp;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class ActionMenuItemView extends jp implements ccn, View.OnClickListener, cx {
    public cbz a;
    public CharSequence b;
    public Drawable c;
    public cbv d;
    public co e;
    public cp f;
    public boolean g;
    public boolean h;
    public final int i;
    public int j;
    public final int k;

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Resources resources = context.getResources();
        this.g = o();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, cyf.c, 0, 0);
        this.i = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.k = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.j = -1;
        setSaveEnabled(false);
    }

    @Override // android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        return Button.class.getName();
    }

    @Override // me.hd.wauxv.obf.ccn
    public cbz getItemData() {
        return this.a;
    }

    @Override // me.hd.wauxv.obf.cx
    public final boolean l() {
        return !TextUtils.isEmpty(getText());
    }

    @Override // me.hd.wauxv.obf.cx
    public final boolean m() {
        return !TextUtils.isEmpty(getText()) && this.a.getIcon() == null;
    }

    @Override // me.hd.wauxv.obf.ccn
    public final void n(cbz cbzVar) {
        this.a = cbzVar;
        setIcon(cbzVar.getIcon());
        setTitle(cbzVar.getTitleCondensed());
        setId(cbzVar.a);
        setVisibility(cbzVar.isVisible() ? 0 : 8);
        setEnabled(cbzVar.isEnabled());
        if (cbzVar.hasSubMenu() && this.e == null) {
            this.e = new co(this);
        }
    }

    public final boolean o() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        int i2 = configuration.screenHeightDp;
        if (i < 480) {
            return (i >= 640 && i2 >= 480) || configuration.orientation == 2;
        }
        return true;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        cbv cbvVar = this.d;
        if (cbvVar != null) {
            cbvVar.c(this.a);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.g = o();
        p();
    }

    @Override // me.hd.wauxv.obf.jp, android.widget.TextView, android.view.View
    public final void onMeasure(int i, int i2) {
        int i3;
        boolean zIsEmpty = TextUtils.isEmpty(getText());
        if (!zIsEmpty && (i3 = this.j) >= 0) {
            super.setPadding(i3, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        int i4 = this.i;
        int iMin = mode == Integer.MIN_VALUE ? Math.min(size, i4) : i4;
        if (mode != 1073741824 && i4 > 0 && measuredWidth < iMin) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(iMin, 1073741824), i2);
        }
        if (!zIsEmpty || this.c == null) {
            return;
        }
        super.setPadding((getMeasuredWidth() - this.c.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        co coVar;
        if (this.a.hasSubMenu() && (coVar = this.e) != null && coVar.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void p() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.b);
        if (this.c != null && ((this.a.aa & 4) != 4 || (!this.g && !this.h))) {
            z = false;
        }
        boolean z3 = z2 & z;
        setText(z3 ? this.b : null);
        CharSequence charSequence = this.a.s;
        if (TextUtils.isEmpty(charSequence)) {
            setContentDescription(z3 ? null : this.a.e);
        } else {
            setContentDescription(charSequence);
        }
        CharSequence charSequence2 = this.a.t;
        if (TextUtils.isEmpty(charSequence2)) {
            eku.a(this, z3 ? null : this.a.e);
        } else {
            eku.a(this, charSequence2);
        }
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public void setExpandedFormat(boolean z) {
        if (this.h != z) {
            this.h = z;
            cbz cbzVar = this.a;
            if (cbzVar != null) {
                cbw cbwVar = cbzVar.n;
                cbwVar.l = true;
                cbwVar.ao(true);
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.c = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i = this.k;
            if (intrinsicWidth > i) {
                intrinsicHeight = (int) (intrinsicHeight * (i / intrinsicWidth));
                intrinsicWidth = i;
            }
            if (intrinsicHeight > i) {
                intrinsicWidth = (int) (intrinsicWidth * (i / intrinsicHeight));
            } else {
                i = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i);
        }
        setCompoundDrawables(drawable, null, null, null);
        p();
    }

    public void setItemInvoker(cbv cbvVar) {
        this.d = cbvVar;
    }

    @Override // android.widget.TextView, android.view.View
    public final void setPadding(int i, int i2, int i3, int i4) {
        this.j = i;
        super.setPadding(i, i2, i3, i4);
    }

    public void setPopupCallback(cp cpVar) {
        this.f = cpVar;
    }

    public void setTitle(CharSequence charSequence) {
        this.b = charSequence;
        p();
    }
}
