package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import java.util.WeakHashMap;
import me.hd.wauxv.obf.bcq;
import me.hd.wauxv.obf.bvf;
import me.hd.wauxv.obf.cbz;
import me.hd.wauxv.obf.ccn;
import me.hd.wauxv.obf.dcu;
import me.hd.wauxv.obf.eku;
import me.hd.wauxv.obf.eqz;
import me.hd.wauxv.obf.yb;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class NavigationMenuItemView extends bcq implements ccn {
    public static final int[] a = {R.attr.state_checked};
    public int b;
    public boolean c;
    public boolean d;
    public final boolean e;
    public final CheckedTextView f;
    public FrameLayout g;
    public cbz h;
    public ColorStateList i;
    public boolean j;
    public Drawable k;
    public final yb l;

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = true;
        yb ybVar = new yb(this, 3);
        this.l = ybVar;
        setOrientation(0);
        LayoutInflater.from(context).inflate(me.hd.wauxv.R.layout.design_navigation_menu_item, (ViewGroup) this, true);
        setIconSize(context.getResources().getDimensionPixelSize(me.hd.wauxv.R.dimen.design_navigation_icon_size));
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(me.hd.wauxv.R.id.design_menu_item_text);
        this.f = checkedTextView;
        checkedTextView.setDuplicateParentStateEnabled(true);
        eqz.s(checkedTextView, ybVar);
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.g == null) {
                this.g = (FrameLayout) ((ViewStub) findViewById(me.hd.wauxv.R.id.design_menu_item_action_area_stub)).inflate();
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.g.removeAllViews();
            this.g.addView(view);
        }
    }

    @Override // me.hd.wauxv.obf.ccn
    public cbz getItemData() {
        return this.h;
    }

    @Override // me.hd.wauxv.obf.ccn
    public final void n(cbz cbzVar) {
        StateListDrawable stateListDrawable;
        this.h = cbzVar;
        int i = cbzVar.a;
        if (i > 0) {
            setId(i);
        }
        setVisibility(cbzVar.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(me.hd.wauxv.R.attr.colorControlHighlight, typedValue, true)) {
                stateListDrawable = new StateListDrawable();
                stateListDrawable.addState(a, new ColorDrawable(typedValue.data));
                stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
            } else {
                stateListDrawable = null;
            }
            WeakHashMap weakHashMap = eqz.a;
            setBackground(stateListDrawable);
        }
        setCheckable(cbzVar.isCheckable());
        setChecked(cbzVar.isChecked());
        setEnabled(cbzVar.isEnabled());
        setTitle(cbzVar.e);
        setIcon(cbzVar.getIcon());
        setActionView(cbzVar.getActionView());
        setContentDescription(cbzVar.s);
        eku.a(this, cbzVar.t);
        cbz cbzVar2 = this.h;
        CharSequence charSequence = cbzVar2.e;
        CheckedTextView checkedTextView = this.f;
        if (charSequence == null && cbzVar2.getIcon() == null && this.h.getActionView() != null) {
            checkedTextView.setVisibility(8);
            FrameLayout frameLayout = this.g;
            if (frameLayout != null) {
                bvf bvfVar = (bvf) frameLayout.getLayoutParams();
                ((LinearLayout.LayoutParams) bvfVar).width = -1;
                this.g.setLayoutParams(bvfVar);
                return;
            }
            return;
        }
        checkedTextView.setVisibility(0);
        FrameLayout frameLayout2 = this.g;
        if (frameLayout2 != null) {
            bvf bvfVar2 = (bvf) frameLayout2.getLayoutParams();
            ((LinearLayout.LayoutParams) bvfVar2).width = -2;
            this.g.setLayoutParams(bvfVar2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 1);
        cbz cbzVar = this.h;
        if (cbzVar != null && cbzVar.isCheckable() && this.h.isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, a);
        }
        return iArrOnCreateDrawableState;
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
        if (this.d != z) {
            this.d = z;
            this.l.n(this.f, 2048);
        }
    }

    public void setChecked(boolean z) {
        refreshDrawableState();
        CheckedTextView checkedTextView = this.f;
        checkedTextView.setChecked(z);
        checkedTextView.setTypeface(checkedTextView.getTypeface(), (z && this.e) ? 1 : 0);
    }

    public void setHorizontalPadding(int i) {
        setPadding(i, getPaddingTop(), i, getPaddingBottom());
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            if (this.j) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = drawable.mutate();
                drawable.setTintList(this.i);
            }
            int i = this.b;
            drawable.setBounds(0, 0, i, i);
        } else if (this.c) {
            if (this.k == null) {
                Resources resources = getResources();
                Resources.Theme theme = getContext().getTheme();
                ThreadLocal threadLocal = dcu.a;
                Drawable drawable2 = resources.getDrawable(me.hd.wauxv.R.drawable.navigation_empty_icon, theme);
                this.k = drawable2;
                if (drawable2 != null) {
                    int i2 = this.b;
                    drawable2.setBounds(0, 0, i2, i2);
                }
            }
            drawable = this.k;
        }
        this.f.setCompoundDrawablesRelative(drawable, null, null, null);
    }

    public void setIconPadding(int i) {
        this.f.setCompoundDrawablePadding(i);
    }

    public void setIconSize(int i) {
        this.b = i;
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.i = colorStateList;
        this.j = colorStateList != null;
        cbz cbzVar = this.h;
        if (cbzVar != null) {
            setIcon(cbzVar.getIcon());
        }
    }

    public void setMaxLines(int i) {
        this.f.setMaxLines(i);
    }

    public void setNeedsEmptyIcon(boolean z) {
        this.c = z;
    }

    public void setTextAppearance(int i) {
        this.f.setTextAppearance(i);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.f.setTextColor(colorStateList);
    }

    public void setTitle(CharSequence charSequence) {
        this.f.setText(charSequence);
    }
}
