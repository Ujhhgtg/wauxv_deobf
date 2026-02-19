package me.hd.wauxv.obf;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.text.Layout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.tabs.TabLayout;
import java.util.WeakHashMap;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dpn extends LinearLayout {
    public static final /* synthetic */ int a = 0;
    public dpl b;
    public TextView c;
    public ImageView d;
    public View e;
    public mx f;
    public View g;
    public TextView h;
    public ImageView i;
    public Drawable j;
    public int k;
    public final /* synthetic */ TabLayout l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dpn(TabLayout tabLayout, Context context) {
        super(context);
        this.l = tabLayout;
        this.k = 2;
        q(context);
        int i = tabLayout.f;
        int i2 = tabLayout.g;
        int i3 = tabLayout.h;
        int i4 = tabLayout.i;
        WeakHashMap weakHashMap = ViewCompat.a;
        setPaddingRelative(i, i2, i3, i4);
        setGravity(17);
        setOrientation(!tabLayout.ae ? 1 : 0);
        setClickable(true);
        eqs.a(this, PointerIcon.getSystemIcon(getContext(), 1002));
    }

    private mx getBadge() {
        return this.f;
    }

    private mx getOrCreateBadge() {
        if (this.f == null) {
            this.f = new mx(getContext(), null);
        }
        n();
        mx mxVar = this.f;
        if (mxVar != null) {
            return mxVar;
        }
        throw new IllegalStateException("Unable to create badge");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.j;
        if ((drawable == null || !drawable.isStateful()) ? false : this.j.setState(drawableState)) {
            invalidate();
            this.l.invalidate();
        }
    }

    public int getContentHeight() {
        View[] viewArr = {this.c, this.d, this.g};
        int iMax = 0;
        int iMin = 0;
        boolean z = false;
        for (int i = 0; i < 3; i++) {
            View view = viewArr[i];
            if (view != null && view.getVisibility() == 0) {
                iMin = z ? Math.min(iMin, view.getTop()) : view.getTop();
                iMax = z ? Math.max(iMax, view.getBottom()) : view.getBottom();
                z = true;
            }
        }
        return iMax - iMin;
    }

    public int getContentWidth() {
        View[] viewArr = {this.c, this.d, this.g};
        int iMax = 0;
        int iMin = 0;
        boolean z = false;
        for (int i = 0; i < 3; i++) {
            View view = viewArr[i];
            if (view != null && view.getVisibility() == 0) {
                iMin = z ? Math.min(iMin, view.getLeft()) : view.getLeft();
                iMax = z ? Math.max(iMax, view.getRight()) : view.getRight();
                z = true;
            }
        }
        return iMax - iMin;
    }

    public dpl getTab() {
        return this.b;
    }

    public final void m() {
        if (this.f != null) {
            setClipChildren(true);
            setClipToPadding(true);
            ViewGroup viewGroup = (ViewGroup) getParent();
            if (viewGroup != null) {
                viewGroup.setClipChildren(true);
                viewGroup.setClipToPadding(true);
            }
            View view = this.e;
            if (view != null) {
                mx mxVar = this.f;
                if (mxVar != null) {
                    if (mxVar.q() != null) {
                        mxVar.q().setForeground(null);
                    } else {
                        view.getOverlay().remove(mxVar);
                    }
                }
                this.e = null;
            }
        }
    }

    public final void n() {
        dpl dplVar;
        if (this.f != null) {
            if (this.g != null) {
                m();
                return;
            }
            ImageView imageView = this.d;
            if (imageView != null && (dplVar = this.b) != null && dplVar.a != null) {
                if (this.e == imageView) {
                    o(imageView);
                    return;
                }
                m();
                ImageView imageView2 = this.d;
                if (this.f == null || imageView2 == null) {
                    return;
                }
                setClipChildren(false);
                setClipToPadding(false);
                ViewGroup viewGroup = (ViewGroup) getParent();
                if (viewGroup != null) {
                    viewGroup.setClipChildren(false);
                    viewGroup.setClipToPadding(false);
                }
                mx mxVar = this.f;
                Rect rect = new Rect();
                imageView2.getDrawingRect(rect);
                mxVar.setBounds(rect);
                mxVar.v(imageView2, null);
                if (mxVar.q() != null) {
                    mxVar.q().setForeground(mxVar);
                } else {
                    imageView2.getOverlay().add(mxVar);
                }
                this.e = imageView2;
                return;
            }
            TextView textView = this.c;
            if (textView == null || this.b == null) {
                m();
                return;
            }
            if (this.e == textView) {
                o(textView);
                return;
            }
            m();
            TextView textView2 = this.c;
            if (this.f == null || textView2 == null) {
                return;
            }
            setClipChildren(false);
            setClipToPadding(false);
            ViewGroup viewGroup2 = (ViewGroup) getParent();
            if (viewGroup2 != null) {
                viewGroup2.setClipChildren(false);
                viewGroup2.setClipToPadding(false);
            }
            mx mxVar2 = this.f;
            Rect rect2 = new Rect();
            textView2.getDrawingRect(rect2);
            mxVar2.setBounds(rect2);
            mxVar2.v(textView2, null);
            if (mxVar2.q() != null) {
                mxVar2.q().setForeground(mxVar2);
            } else {
                textView2.getOverlay().add(mxVar2);
            }
            this.e = textView2;
        }
    }

    public final void o(View view) {
        mx mxVar = this.f;
        if (mxVar == null || view != this.e) {
            return;
        }
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        mxVar.setBounds(rect);
        mxVar.v(view, null);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        mx mxVar = this.f;
        if (mxVar != null && mxVar.isVisible()) {
            accessibilityNodeInfo.setContentDescription(this.f.p());
        }
        accessibilityNodeInfo.setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo) bc.g(0, 1, this.b.c, 1, isSelected()).e);
        if (isSelected()) {
            accessibilityNodeInfo.setClickable(false);
            accessibilityNodeInfo.removeAction((AccessibilityNodeInfo.AccessibilityAction) ax.a.l);
        }
        accessibilityNodeInfo.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", getResources().getString(R.string.item_view_role_description));
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        TabLayout tabLayout = this.l;
        int tabMaxWidth = tabLayout.getTabMaxWidth();
        if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
            i = View.MeasureSpec.makeMeasureSpec(tabLayout.v, Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
        if (this.c != null) {
            float f = tabLayout.s;
            int i3 = this.k;
            ImageView imageView = this.d;
            if (imageView == null || imageView.getVisibility() != 0) {
                TextView textView = this.c;
                if (textView != null && textView.getLineCount() > 1) {
                    f = tabLayout.t;
                }
            } else {
                i3 = 1;
            }
            float textSize = this.c.getTextSize();
            int lineCount = this.c.getLineCount();
            int maxLines = this.c.getMaxLines();
            if (f != textSize || (maxLines >= 0 && i3 != maxLines)) {
                if (tabLayout.ad == 1 && f > textSize && lineCount == 1) {
                    Layout layout = this.c.getLayout();
                    if (layout == null) {
                        return;
                    }
                    if ((f / layout.getPaint().getTextSize()) * layout.getLineWidth(0) > (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()) {
                        return;
                    }
                }
                this.c.setTextSize(0, f);
                this.c.setMaxLines(i3);
                super.onMeasure(i, i2);
            }
        }
    }

    /* JADX WARN: Found duplicated region for block: B:13:0x0020  */
    public final void p() {
        boolean z;
        r();
        dpl dplVar = this.b;
        if (dplVar != null) {
            TabLayout tabLayout = dplVar.e;
            if (tabLayout == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            int selectedTabPosition = tabLayout.getSelectedTabPosition();
            z = selectedTabPosition != -1 && selectedTabPosition == dplVar.c;
        }
        setSelected(z);
    }

    @Override // android.view.View
    public final boolean performClick() {
        boolean zPerformClick = super.performClick();
        if (this.b == null) {
            return zPerformClick;
        }
        if (!zPerformClick) {
            playSoundEffect(0);
        }
        dpl dplVar = this.b;
        TabLayout tabLayout = dplVar.e;
        if (tabLayout == null) {
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }
        tabLayout.ay(dplVar, true);
        return true;
    }

    public final void q(Context context) {
        GradientDrawable gradientDrawable;
        TabLayout tabLayout = this.l;
        int i = tabLayout.u;
        if (i != 0) {
            Drawable drawableY = cmz.y(context, i);
            this.j = drawableY;
            if (drawableY != null && drawableY.isStateful()) {
                this.j.setState(getDrawableState());
            }
        } else {
            this.j = null;
        }
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(0);
        Drawable rippleDrawable = gradientDrawable2;
        if (tabLayout.o != null) {
            GradientDrawable gradientDrawable3 = new GradientDrawable();
            gradientDrawable3.setCornerRadius(1.0E-5f);
            gradientDrawable3.setColor(-1);
            ColorStateList colorStateListG = ddb.g(tabLayout.o);
            boolean z = tabLayout.ai;
            if (z) {
                gradientDrawable = gradientDrawable2;
                gradientDrawable = null;
            }
            rippleDrawable = new RippleDrawable(colorStateListG, gradientDrawable, z ? null : gradientDrawable3);
        }
        WeakHashMap weakHashMap = ViewCompat.a;
        setBackground(rippleDrawable);
        tabLayout.invalidate();
    }

    public final void r() {
        int i;
        ViewParent parent;
        dpl dplVar = this.b;
        View view = dplVar != null ? dplVar.d : null;
        if (view != null) {
            ViewParent parent2 = view.getParent();
            if (parent2 != this) {
                if (parent2 != null) {
                    ((ViewGroup) parent2).removeView(view);
                }
                View view2 = this.g;
                if (view2 != null && (parent = view2.getParent()) != null) {
                    ((ViewGroup) parent).removeView(this.g);
                }
                addView(view);
            }
            this.g = view;
            TextView textView = this.c;
            if (textView != null) {
                textView.setVisibility(8);
            }
            ImageView imageView = this.d;
            if (imageView != null) {
                imageView.setVisibility(8);
                this.d.setImageDrawable(null);
            }
            TextView textView2 = (TextView) view.findViewById(android.R.id.text1);
            this.h = textView2;
            if (textView2 != null) {
                this.k = textView2.getMaxLines();
            }
            this.i = (ImageView) view.findViewById(android.R.id.icon);
        } else {
            View view3 = this.g;
            if (view3 != null) {
                removeView(view3);
                this.g = null;
            }
            this.h = null;
            this.i = null;
        }
        if (this.g == null) {
            if (this.d == null) {
                ImageView imageView2 = (ImageView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_icon, (ViewGroup) this, false);
                this.d = imageView2;
                addView(imageView2, 0);
            }
            if (this.c == null) {
                TextView textView3 = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_text, (ViewGroup) this, false);
                this.c = textView3;
                addView(textView3);
                this.k = this.c.getMaxLines();
            }
            TextView textView4 = this.c;
            TabLayout tabLayout = this.l;
            textView4.setTextAppearance(tabLayout.j);
            if (!isSelected() || (i = tabLayout.l) == -1) {
                this.c.setTextAppearance(tabLayout.k);
            } else {
                this.c.setTextAppearance(i);
            }
            ColorStateList colorStateList = tabLayout.m;
            if (colorStateList != null) {
                this.c.setTextColor(colorStateList);
            }
            s(this.c, this.d, true);
            n();
            ImageView imageView3 = this.d;
            if (imageView3 != null) {
                imageView3.addOnLayoutChangeListener(new dpm(this, imageView3));
            }
            TextView textView5 = this.c;
            if (textView5 != null) {
                textView5.addOnLayoutChangeListener(new dpm(this, textView5));
            }
        } else {
            TextView textView6 = this.h;
            if (textView6 != null || this.i != null) {
                s(textView6, this.i, false);
            }
        }
        if (dplVar == null || TextUtils.isEmpty(null)) {
            return;
        }
        setContentDescription(null);
    }

    public final void s(TextView textView, ImageView imageView, boolean z) {
        boolean z2;
        Drawable drawable;
        dpl dplVar = this.b;
        Drawable drawableMutate = (dplVar == null || (drawable = dplVar.a) == null) ? null : drawable.mutate();
        TabLayout tabLayout = this.l;
        if (drawableMutate != null) {
            drawableMutate.setTintList(tabLayout.n);
            PorterDuff.Mode mode = tabLayout.r;
            if (mode != null) {
                drawableMutate.setTintMode(mode);
            }
        }
        dpl dplVar2 = this.b;
        CharSequence charSequence = dplVar2 != null ? dplVar2.b : null;
        if (imageView != null) {
            if (drawableMutate != null) {
                imageView.setImageDrawable(drawableMutate);
                imageView.setVisibility(0);
                setVisibility(0);
            } else {
                imageView.setVisibility(8);
                imageView.setImageDrawable(null);
            }
        }
        boolean zIsEmpty = TextUtils.isEmpty(charSequence);
        if (textView != null) {
            if (zIsEmpty) {
                z2 = false;
            } else {
                this.b.getClass();
                z2 = true;
            }
            textView.setText(!zIsEmpty ? charSequence : null);
            textView.setVisibility(z2 ? 0 : 8);
            if (!zIsEmpty) {
                setVisibility(0);
            }
        } else {
            z2 = false;
        }
        if (z && imageView != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
            int iAg = (z2 && imageView.getVisibility() == 0) ? (int) ewz.ag(getContext(), 8) : 0;
            if (tabLayout.ae) {
                if (iAg != marginLayoutParams.getMarginEnd()) {
                    marginLayoutParams.setMarginEnd(iAg);
                    marginLayoutParams.bottomMargin = 0;
                    imageView.setLayoutParams(marginLayoutParams);
                    imageView.requestLayout();
                }
            } else if (iAg != marginLayoutParams.bottomMargin) {
                marginLayoutParams.bottomMargin = iAg;
                marginLayoutParams.setMarginEnd(0);
                imageView.setLayoutParams(marginLayoutParams);
                imageView.requestLayout();
            }
        }
        eku.a(this, zIsEmpty ? null : charSequence);
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        isSelected();
        super.setSelected(z);
        TextView textView = this.c;
        if (textView != null) {
            textView.setSelected(z);
        }
        ImageView imageView = this.d;
        if (imageView != null) {
            imageView.setSelected(z);
        }
        View view = this.g;
        if (view != null) {
            view.setSelected(z);
        }
    }

    public void setTab(dpl dplVar) {
        if (dplVar != this.b) {
            this.b = dplVar;
            p();
        }
    }
}
