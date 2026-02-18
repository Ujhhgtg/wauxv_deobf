package me.hd.wauxv.obf;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class cjy extends FrameLayout implements ccn {
    public static final int[] a = {R.attr.state_checked};
    public static final cbm b;
    public static final cjx c;
    public Drawable aa;
    public ValueAnimator ab;
    public cbm ac;
    public float ad;
    public boolean ae;
    public int af;
    public int ag;
    public boolean ah;
    public int ai;
    public mx aj;
    public boolean d;
    public ColorStateList e;
    public Drawable f;
    public int g;
    public int h;
    public int i;
    public float j;
    public float k;
    public float l;
    public int m;
    public boolean o;
    public final FrameLayout p;
    public final View q;
    public final ImageView r;
    public final ViewGroup s;
    public final TextView t;
    public final TextView u;
    public int v;
    public int w;
    public cbz x;
    public ColorStateList y;
    public Drawable z;

    static {
        int i = 6;
        b = new cbm(i);
        c = new cjx(i);
    }

    public cjy(Context context) {
        super(context);
        this.d = false;
        this.v = -1;
        this.w = 0;
        this.ac = b;
        this.ad = 0.0f;
        this.ae = false;
        this.af = 0;
        this.ag = 0;
        this.ah = false;
        this.ai = 0;
        LayoutInflater.from(context).inflate(getItemLayoutResId(), (ViewGroup) this, true);
        this.p = (FrameLayout) findViewById(me.hd.wauxv.R.id.navigation_bar_item_icon_container);
        this.q = findViewById(me.hd.wauxv.R.id.navigation_bar_item_active_indicator_view);
        ImageView imageView = (ImageView) findViewById(me.hd.wauxv.R.id.navigation_bar_item_icon_view);
        this.r = imageView;
        ViewGroup viewGroup = (ViewGroup) findViewById(me.hd.wauxv.R.id.navigation_bar_item_labels_group);
        this.s = viewGroup;
        TextView textView = (TextView) findViewById(me.hd.wauxv.R.id.navigation_bar_item_small_label_view);
        this.t = textView;
        TextView textView2 = (TextView) findViewById(me.hd.wauxv.R.id.navigation_bar_item_large_label_view);
        this.u = textView2;
        setBackgroundResource(getItemBackgroundResId());
        this.g = getResources().getDimensionPixelSize(getItemDefaultMarginResId());
        this.h = viewGroup.getPaddingBottom();
        this.i = getResources().getDimensionPixelSize(me.hd.wauxv.R.dimen.m3_navigation_item_active_indicator_label_padding);
        WeakHashMap weakHashMap = eqz.a;
        textView.setImportantForAccessibility(2);
        textView2.setImportantForAccessibility(2);
        setFocusable(true);
        ao(textView.getTextSize(), textView2.getTextSize());
        if (imageView != null) {
            imageView.addOnLayoutChangeListener(new pw(this, 3));
        }
    }

    /* JADX WARN: Found duplicated region for block: B:7:0x001f  */
    public static void ak(TextView textView, int i) {
        int iRound;
        textView.setTextAppearance(i);
        Context context = textView.getContext();
        if (i != 0) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, cxs.ao);
            TypedValue typedValue = new TypedValue();
            boolean value = typedArrayObtainStyledAttributes.getValue(0, typedValue);
            typedArrayObtainStyledAttributes.recycle();
            iRound = !value ? 0 : typedValue.getComplexUnit() == 2 ? Math.round(TypedValue.complexToFloat(typedValue.data) * context.getResources().getDisplayMetrics().density) : TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics());
        }
        if (iRound != 0) {
            textView.setTextSize(0, iRound);
        }
    }

    public static void al(View view, float f, float f2, int i) {
        view.setScaleX(f);
        view.setScaleY(f2);
        view.setVisibility(i);
    }

    public static void am(View view, int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = i;
        layoutParams.bottomMargin = i;
        layoutParams.gravity = i2;
        view.setLayoutParams(layoutParams);
    }

    public static void an(View view, int i) {
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), i);
    }

    private View getIconOrContainer() {
        FrameLayout frameLayout = this.p;
        return frameLayout != null ? frameLayout : this.r;
    }

    private int getItemVisiblePosition() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        int iIndexOfChild = viewGroup.indexOfChild(this);
        int i = 0;
        for (int i2 = 0; i2 < iIndexOfChild; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if ((childAt instanceof cjy) && childAt.getVisibility() == 0) {
                i++;
            }
        }
        return i;
    }

    private int getSuggestedIconHeight() {
        return getIconOrContainer().getMeasuredHeight() + ((FrameLayout.LayoutParams) getIconOrContainer().getLayoutParams()).topMargin;
    }

    private int getSuggestedIconWidth() {
        mx mxVar = this.aj;
        int minimumWidth = mxVar == null ? 0 : mxVar.getMinimumWidth() - this.aj.e.b.w.intValue();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getIconOrContainer().getLayoutParams();
        return Math.max(minimumWidth, layoutParams.rightMargin) + this.r.getMeasuredWidth() + Math.max(minimumWidth, layoutParams.leftMargin);
    }

    public final void ao(float f, float f2) {
        this.j = f - f2;
        this.k = (f2 * 1.0f) / f;
        this.l = (f * 1.0f) / f2;
    }

    public final void ap() {
        cbz cbzVar = this.x;
        if (cbzVar != null) {
            setChecked(cbzVar.isChecked());
        }
    }

    public final void aq() {
        Drawable rippleDrawable = this.f;
        ColorStateList colorStateList = this.e;
        FrameLayout frameLayout = this.p;
        RippleDrawable rippleDrawable2 = null;
        boolean z = true;
        if (colorStateList != null) {
            Drawable activeIndicatorDrawable = getActiveIndicatorDrawable();
            if (this.ae && getActiveIndicatorDrawable() != null && frameLayout != null && activeIndicatorDrawable != null) {
                rippleDrawable2 = new RippleDrawable(ddb.i(this.e), null, activeIndicatorDrawable);
                z = false;
            } else if (rippleDrawable == null) {
                rippleDrawable = new RippleDrawable(ddb.g(this.e), null, null);
            }
        }
        if (frameLayout != null) {
            frameLayout.setPadding(0, 0, 0, 0);
            frameLayout.setForeground(rippleDrawable2);
        }
        WeakHashMap weakHashMap = eqz.a;
        setBackground(rippleDrawable);
        setDefaultFocusHighlightEnabled(z);
    }

    public final void ar(float f, float f2) {
        View view = this.q;
        if (view != null) {
            cbm cbmVar = this.ac;
            cbmVar.getClass();
            view.setScaleX(ff.f(0.4f, 1.0f, f));
            view.setScaleY(cbmVar.k(f, f2));
            view.setAlpha(ff.g(0.0f, 1.0f, f2 == 0.0f ? 0.8f : 0.0f, f2 == 0.0f ? 1.0f : 0.2f, f));
        }
        this.ad = f;
    }

    public final void as(int i) {
        View view = this.q;
        if (view == null || i <= 0) {
            return;
        }
        int iMin = Math.min(this.af, i - (this.ai * 2));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.height = (this.ah && this.m == 2) ? iMin : this.ag;
        layoutParams.width = iMin;
        view.setLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        FrameLayout frameLayout = this.p;
        if (frameLayout != null && this.ae) {
            frameLayout.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public Drawable getActiveIndicatorDrawable() {
        View view = this.q;
        if (view == null) {
            return null;
        }
        return view.getBackground();
    }

    public mx getBadge() {
        return this.aj;
    }

    public int getItemBackgroundResId() {
        return me.hd.wauxv.R.drawable.mtrl_navigation_bar_item_background;
    }

    @Override // me.hd.wauxv.obf.ccn
    public cbz getItemData() {
        return this.x;
    }

    public int getItemDefaultMarginResId() {
        return me.hd.wauxv.R.dimen.mtrl_navigation_bar_item_default_margin;
    }

    public abstract int getItemLayoutResId();

    public int getItemPosition() {
        return this.v;
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        ViewGroup viewGroup = this.s;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
        return viewGroup.getMeasuredHeight() + getSuggestedIconHeight() + (viewGroup.getVisibility() == 0 ? this.i : 0) + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        ViewGroup viewGroup = this.s;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
        return Math.max(getSuggestedIconWidth(), viewGroup.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin);
    }

    @Override // me.hd.wauxv.obf.ccn
    public final void n(cbz cbzVar) {
        this.x = cbzVar;
        setCheckable(cbzVar.isCheckable());
        setChecked(cbzVar.isChecked());
        setEnabled(cbzVar.isEnabled());
        setIcon(cbzVar.getIcon());
        setTitle(cbzVar.e);
        setId(cbzVar.a);
        if (!TextUtils.isEmpty(cbzVar.s)) {
            setContentDescription(cbzVar.s);
        }
        eku.a(this, !TextUtils.isEmpty(cbzVar.t) ? cbzVar.t : cbzVar.e);
        setVisibility(cbzVar.isVisible() ? 0 : 8);
        this.d = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 1);
        cbz cbzVar = this.x;
        if (cbzVar != null && cbzVar.isCheckable() && this.x.isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, a);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        mx mxVar = this.aj;
        if (mxVar != null && mxVar.isVisible()) {
            cbz cbzVar = this.x;
            CharSequence charSequence = cbzVar.e;
            if (!TextUtils.isEmpty(cbzVar.s)) {
                charSequence = this.x.s;
            }
            accessibilityNodeInfo.setContentDescription(((Object) charSequence) + ", " + ((Object) this.aj.p()));
        }
        accessibilityNodeInfo.setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo) bc.g(0, 1, getItemVisiblePosition(), 1, isSelected()).e);
        if (isSelected()) {
            accessibilityNodeInfo.setClickable(false);
            accessibilityNodeInfo.removeAction((AccessibilityNodeInfo.AccessibilityAction) ax.a.l);
        }
        accessibilityNodeInfo.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", getResources().getString(me.hd.wauxv.R.string.item_view_role_description));
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        post(new np(this, i, 4));
    }

    public void setActiveIndicatorDrawable(Drawable drawable) {
        View view = this.q;
        if (view == null) {
            return;
        }
        view.setBackgroundDrawable(drawable);
        aq();
    }

    public void setActiveIndicatorEnabled(boolean z) {
        this.ae = z;
        aq();
        View view = this.q;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
            requestLayout();
        }
    }

    public void setActiveIndicatorHeight(int i) {
        this.ag = i;
        as(getWidth());
    }

    public void setActiveIndicatorLabelPadding(int i) {
        if (this.i != i) {
            this.i = i;
            ap();
        }
    }

    public void setActiveIndicatorMarginHorizontal(int i) {
        this.ai = i;
        as(getWidth());
    }

    public void setActiveIndicatorResizeable(boolean z) {
        this.ah = z;
    }

    public void setActiveIndicatorWidth(int i) {
        this.af = i;
        as(getWidth());
    }

    public void setBadge(mx mxVar) {
        mx mxVar2 = this.aj;
        if (mxVar2 == mxVar) {
            return;
        }
        ImageView imageView = this.r;
        if (mxVar2 != null && imageView != null) {
            Log.w("NavigationBar", "Multiple badges shouldn't be attached to one item.");
            if (this.aj != null) {
                setClipChildren(true);
                setClipToPadding(true);
                mx mxVar3 = this.aj;
                if (mxVar3 != null) {
                    if (mxVar3.q() != null) {
                        mxVar3.q().setForeground(null);
                    } else {
                        imageView.getOverlay().remove(mxVar3);
                    }
                }
                this.aj = null;
            }
        }
        this.aj = mxVar;
        if (imageView == null || mxVar == null) {
            return;
        }
        setClipChildren(false);
        setClipToPadding(false);
        mx mxVar4 = this.aj;
        Rect rect = new Rect();
        imageView.getDrawingRect(rect);
        mxVar4.setBounds(rect);
        mxVar4.v(imageView, null);
        if (mxVar4.q() != null) {
            mxVar4.q().setForeground(mxVar4);
        } else {
            imageView.getOverlay().add(mxVar4);
        }
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
    }

    /* JADX WARN: Found duplicated region for block: B:17:0x0095  */
    public void setChecked(boolean z) {
        TextView textView = this.u;
        textView.setPivotX(textView.getWidth() / 2);
        textView.setPivotY(textView.getBaseline());
        TextView textView2 = this.t;
        textView2.setPivotX(textView2.getWidth() / 2);
        textView2.setPivotY(textView2.getBaseline());
        float f = z ? 1.0f : 0.0f;
        if (this.ae && this.d) {
            WeakHashMap weakHashMap = eqz.a;
            if (isAttachedToWindow()) {
                ValueAnimator valueAnimator = this.ab;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                    this.ab = null;
                }
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.ad, f);
                this.ab = valueAnimatorOfFloat;
                valueAnimatorOfFloat.addUpdateListener(new cjw(this, f));
                this.ab.setInterpolator(ajn.ae(getContext(), me.hd.wauxv.R.attr.motionEasingEmphasizedInterpolator, ff.b));
                this.ab.setDuration(ajn.ad(getContext(), me.hd.wauxv.R.attr.motionDurationLong2, getResources().getInteger(me.hd.wauxv.R.integer.material_motion_duration_long_1)));
                this.ab.start();
            } else {
                ar(f, f);
            }
        } else {
            ar(f, f);
        }
        int i = this.m;
        ViewGroup viewGroup = this.s;
        if (i != -1) {
            if (i == 0) {
                if (z) {
                    am(getIconOrContainer(), this.g, 49);
                    an(viewGroup, this.h);
                    textView.setVisibility(0);
                } else {
                    am(getIconOrContainer(), this.g, 17);
                    an(viewGroup, 0);
                    textView.setVisibility(4);
                }
                textView2.setVisibility(4);
            } else if (i == 1) {
                an(viewGroup, this.h);
                if (z) {
                    am(getIconOrContainer(), (int) (this.g + this.j), 49);
                    al(textView, 1.0f, 1.0f, 0);
                    float f2 = this.k;
                    al(textView2, f2, f2, 4);
                } else {
                    am(getIconOrContainer(), this.g, 49);
                    float f3 = this.l;
                    al(textView, f3, f3, 4);
                    al(textView2, 1.0f, 1.0f, 0);
                }
            } else if (i == 2) {
                am(getIconOrContainer(), this.g, 17);
                textView.setVisibility(8);
                textView2.setVisibility(8);
            }
        } else if (this.o) {
            if (z) {
                am(getIconOrContainer(), this.g, 49);
                an(viewGroup, this.h);
                textView.setVisibility(0);
            } else {
                am(getIconOrContainer(), this.g, 17);
                an(viewGroup, 0);
                textView.setVisibility(4);
            }
            textView2.setVisibility(4);
        } else {
            an(viewGroup, this.h);
            if (z) {
                am(getIconOrContainer(), (int) (this.g + this.j), 49);
                al(textView, 1.0f, 1.0f, 0);
                float f4 = this.k;
                al(textView2, f4, f4, 4);
            } else {
                am(getIconOrContainer(), this.g, 49);
                float f5 = this.l;
                al(textView, f5, f5, 4);
                al(textView2, 1.0f, 1.0f, 0);
            }
        }
        refreshDrawableState();
        setSelected(z);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.t.setEnabled(z);
        this.u.setEnabled(z);
        this.r.setEnabled(z);
        if (!z) {
            WeakHashMap weakHashMap = eqz.a;
            eqs.a(this, null);
        } else {
            PointerIcon systemIcon = PointerIcon.getSystemIcon(getContext(), 1002);
            WeakHashMap weakHashMap2 = eqz.a;
            eqs.a(this, systemIcon);
        }
    }

    public void setIcon(Drawable drawable) {
        if (drawable == this.z) {
            return;
        }
        this.z = drawable;
        if (drawable != null) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                drawable = constantState.newDrawable();
            }
            drawable = drawable.mutate();
            this.aa = drawable;
            ColorStateList colorStateList = this.y;
            if (colorStateList != null) {
                drawable.setTintList(colorStateList);
            }
        }
        this.r.setImageDrawable(drawable);
    }

    public void setIconSize(int i) {
        ImageView imageView = this.r;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i;
        imageView.setLayoutParams(layoutParams);
    }

    public void setIconTintList(ColorStateList colorStateList) {
        Drawable drawable;
        this.y = colorStateList;
        if (this.x == null || (drawable = this.aa) == null) {
            return;
        }
        drawable.setTintList(colorStateList);
        this.aa.invalidateSelf();
    }

    public void setItemBackground(int i) {
        setItemBackground(i == 0 ? null : getContext().getDrawable(i));
    }

    public void setItemPaddingBottom(int i) {
        if (this.h != i) {
            this.h = i;
            ap();
        }
    }

    public void setItemPaddingTop(int i) {
        if (this.g != i) {
            this.g = i;
            ap();
        }
    }

    public void setItemPosition(int i) {
        this.v = i;
    }

    public void setItemRippleColor(ColorStateList colorStateList) {
        this.e = colorStateList;
        aq();
    }

    public void setLabelVisibilityMode(int i) {
        if (this.m != i) {
            this.m = i;
            if (this.ah && i == 2) {
                this.ac = c;
            } else {
                this.ac = b;
            }
            as(getWidth());
            ap();
        }
    }

    public void setShifting(boolean z) {
        if (this.o != z) {
            this.o = z;
            ap();
        }
    }

    public void setTextAppearanceActive(int i) {
        this.w = i;
        TextView textView = this.u;
        ak(textView, i);
        ao(this.t.getTextSize(), textView.getTextSize());
    }

    public void setTextAppearanceActiveBoldEnabled(boolean z) {
        setTextAppearanceActive(this.w);
        TextView textView = this.u;
        textView.setTypeface(textView.getTypeface(), z ? 1 : 0);
    }

    public void setTextAppearanceInactive(int i) {
        TextView textView = this.t;
        ak(textView, i);
        ao(textView.getTextSize(), this.u.getTextSize());
    }

    public void setTextColor(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.t.setTextColor(colorStateList);
            this.u.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        this.t.setText(charSequence);
        this.u.setText(charSequence);
        cbz cbzVar = this.x;
        if (cbzVar == null || TextUtils.isEmpty(cbzVar.s)) {
            setContentDescription(charSequence);
        }
        cbz cbzVar2 = this.x;
        if (cbzVar2 != null && !TextUtils.isEmpty(cbzVar2.t)) {
            charSequence = this.x.t;
        }
        eku.a(this, charSequence);
    }

    public void setItemBackground(Drawable drawable) {
        if (drawable != null && drawable.getConstantState() != null) {
            drawable = drawable.getConstantState().newDrawable().mutate();
        }
        this.f = drawable;
        aq();
    }
}
