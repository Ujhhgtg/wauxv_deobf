package com.google.android.material.chip;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Locale;
import java.util.WeakHashMap;
import me.hd.wauxv.obf.ResourcesCompat;
import me.hd.wauxv.obf.FastKV;
import me.hd.wauxv.obf.car;
import me.hd.wauxv.obf.cfe;
import me.hd.wauxv.obf.cmz;
import me.hd.wauxv.obf.cnb;
import me.hd.wauxv.obf.KotlinHelpers2;
import me.hd.wauxv.obf.cxc;
import me.hd.wauxv.obf.cxs;
import me.hd.wauxv.obf.ddb;
import me.hd.wauxv.obf.dgm;
import me.hd.wauxv.obf.dgx;
import me.hd.wauxv.obf.dqh;
import me.hd.wauxv.obf.dqi;
import me.hd.wauxv.obf.dqk;
import me.hd.wauxv.obf.eqq;
import me.hd.wauxv.obf.ViewCompat;
import me.hd.wauxv.obf.ewc;
import me.hd.wauxv.obf.ewz;
import me.hd.wauxv.obf.hf;
import me.hd.wauxv.obf.ot;
import me.hd.wauxv.obf.yj;
import me.hd.wauxv.obf.yk;
import me.hd.wauxv.obf.yl;
import me.hd.wauxv.obf.ym;
import me.hd.wauxv.obf.yn;
import me.hd.wauxv.obf.yo;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class Chip extends hf implements yn, dgx, Checkable {
    public static final Rect a = new Rect();
    public static final int[] b = {R.attr.state_selected};
    public static final int[] c = {R.attr.state_checkable};
    public yo d;
    public InsetDrawable e;
    public RippleDrawable f;
    public View.OnClickListener g;
    public CompoundButton.OnCheckedChangeListener h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public int n;
    public int o;
    public CharSequence p;
    public final ym q;
    public boolean r;
    public final Rect s;
    public final RectF t;
    public final yk u;

    public Chip(Context context, AttributeSet attributeSet) {
        int resourceId;
        int resourceId2;
        int resourceId3;
        super(cmz.aq(context, attributeSet, me.hd.wauxv.R.attr.chipStyle, me.hd.wauxv.R.style.Widget_MaterialComponents_Chip_Action), attributeSet, me.hd.wauxv.R.attr.chipStyle);
        this.s = new Rect();
        this.t = new RectF();
        this.u = new yk(this, 0);
        Context context2 = getContext();
        if (attributeSet != null) {
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "background") != null) {
                Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableLeft") != null) {
                throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableStart") != null) {
                throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableEnd") != null) {
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableRight") != null) {
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            }
            if (!attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "singleLine", true) || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "lines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minLines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLines", 1) != 1) {
                throw new UnsupportedOperationException("Chip does not support multi-line text");
            }
            if (attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 8388627) != 8388627) {
                Log.w("Chip", "Chip text must be vertically center and start aligned");
            }
        }
        yo yoVar = new yo(context2, attributeSet);
        Context context3 = yoVar.ak;
        int[] iArr = cxs.h;
        TypedArray typedArrayAn = FastKV.an(context3, attributeSet, iArr, me.hd.wauxv.R.attr.chipStyle, me.hd.wauxv.R.style.Widget_MaterialComponents_Chip_Action, new int[0]);
        yoVar.bk = typedArrayAn.hasValue(37);
        Context context4 = yoVar.ak;
        ColorStateList colorStateListV = cnb.v(context4, typedArrayAn, 24);
        if (yoVar._bd != colorStateListV) {
            yoVar._bd = colorStateListV;
            yoVar.onStateChange(yoVar.getState());
        }
        ColorStateList colorStateListV2 = cnb.v(context4, typedArrayAn, 11);
        if (yoVar.d != colorStateListV2) {
            yoVar.d = colorStateListV2;
            yoVar.onStateChange(yoVar.getState());
        }
        float dimension = typedArrayAn.getDimension(19, 0.0f);
        if (yoVar.e != dimension) {
            yoVar.e = dimension;
            yoVar.invalidateSelf();
            yoVar.bt();
        }
        if (typedArrayAn.hasValue(12)) {
            yoVar.bz(typedArrayAn.getDimension(12, 0.0f));
        }
        yoVar.ce(cnb.v(context4, typedArrayAn, 22));
        yoVar.cf(typedArrayAn.getDimension(23, 0.0f));
        yoVar.co(cnb.v(context4, typedArrayAn, 36));
        String text = typedArrayAn.getText(5);
        text = text == null ? "" : text;
        boolean zEquals = TextUtils.equals(yoVar.j, text);
        dqk dqkVar = yoVar.aq;
        if (!zEquals) {
            yoVar.j = text;
            dqkVar.e = true;
            yoVar.invalidateSelf();
            yoVar.bt();
        }
        dqh dqhVar = (!typedArrayAn.hasValue(0) || (resourceId3 = typedArrayAn.getResourceId(0, 0)) == 0) ? null : new dqh(context4, resourceId3);
        dqhVar.k = typedArrayAn.getDimension(1, dqhVar.k);
        dqkVar.j(dqhVar, context4);
        int i = typedArrayAn.getInt(3, 0);
        if (i == 1) {
            yoVar.bh = TextUtils.TruncateAt.START;
        } else if (i == 2) {
            yoVar.bh = TextUtils.TruncateAt.MIDDLE;
        } else if (i == 3) {
            yoVar.bh = TextUtils.TruncateAt.END;
        }
        yoVar.cd(typedArrayAn.getBoolean(18, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") == null) {
            yoVar.cd(typedArrayAn.getBoolean(15, false));
        }
        yoVar.ca(cnb.x(context4, typedArrayAn, 14));
        if (typedArrayAn.hasValue(17)) {
            yoVar.cc(cnb.v(context4, typedArrayAn, 17));
        }
        yoVar.cb(typedArrayAn.getDimension(16, -1.0f));
        yoVar.cl(typedArrayAn.getBoolean(31, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") == null) {
            yoVar.cl(typedArrayAn.getBoolean(26, false));
        }
        yoVar.cg(cnb.x(context4, typedArrayAn, 25));
        yoVar.ck(cnb.v(context4, typedArrayAn, 30));
        yoVar.ci(typedArrayAn.getDimension(28, 0.0f));
        yoVar.bv(typedArrayAn.getBoolean(6, false));
        yoVar.by(typedArrayAn.getBoolean(10, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") == null) {
            yoVar.by(typedArrayAn.getBoolean(8, false));
        }
        yoVar.bw(cnb.x(context4, typedArrayAn, 7));
        if (typedArrayAn.hasValue(9)) {
            yoVar.bx(cnb.v(context4, typedArrayAn, 9));
        }
        yoVar.aa = (!typedArrayAn.hasValue(39) || (resourceId2 = typedArrayAn.getResourceId(39, 0)) == 0) ? null : cfe.c(context4, resourceId2);
        yoVar.ab = (!typedArrayAn.hasValue(33) || (resourceId = typedArrayAn.getResourceId(33, 0)) == 0) ? null : cfe.c(context4, resourceId);
        float dimension2 = typedArrayAn.getDimension(21, 0.0f);
        if (yoVar.ac != dimension2) {
            yoVar.ac = dimension2;
            yoVar.invalidateSelf();
            yoVar.bt();
        }
        yoVar.cn(typedArrayAn.getDimension(35, 0.0f));
        yoVar.cm(typedArrayAn.getDimension(34, 0.0f));
        float dimension3 = typedArrayAn.getDimension(41, 0.0f);
        if (yoVar.af != dimension3) {
            yoVar.af = dimension3;
            yoVar.invalidateSelf();
            yoVar.bt();
        }
        float dimension4 = typedArrayAn.getDimension(40, 0.0f);
        if (yoVar.ag != dimension4) {
            yoVar.ag = dimension4;
            yoVar.invalidateSelf();
            yoVar.bt();
        }
        yoVar.cj(typedArrayAn.getDimension(29, 0.0f));
        yoVar.ch(typedArrayAn.getDimension(27, 0.0f));
        float dimension5 = typedArrayAn.getDimension(13, 0.0f);
        if (yoVar.aj != dimension5) {
            yoVar.aj = dimension5;
            yoVar.invalidateSelf();
            yoVar.bt();
        }
        yoVar.bj = typedArrayAn.getDimensionPixelSize(4, Integer.MAX_VALUE);
        typedArrayAn.recycle();
        FastKV.p(context2, attributeSet, me.hd.wauxv.R.attr.chipStyle, me.hd.wauxv.R.style.Widget_MaterialComponents_Chip_Action);
        FastKV.q(context2, attributeSet, iArr, me.hd.wauxv.R.attr.chipStyle, me.hd.wauxv.R.style.Widget_MaterialComponents_Chip_Action, new int[0]);
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr, me.hd.wauxv.R.attr.chipStyle, me.hd.wauxv.R.style.Widget_MaterialComponents_Chip_Action);
        this.m = typedArrayObtainStyledAttributes.getBoolean(32, false);
        this.o = (int) Math.ceil(typedArrayObtainStyledAttributes.getDimension(20, (float) Math.ceil(ewz.ag(getContext(), 48))));
        typedArrayObtainStyledAttributes.recycle();
        setChipDrawable(yoVar);
        yoVar.dy(eqq.e(this));
        FastKV.p(context2, attributeSet, me.hd.wauxv.R.attr.chipStyle, me.hd.wauxv.R.style.Widget_MaterialComponents_Chip_Action);
        FastKV.q(context2, attributeSet, iArr, me.hd.wauxv.R.attr.chipStyle, me.hd.wauxv.R.style.Widget_MaterialComponents_Chip_Action, new int[0]);
        TypedArray typedArrayObtainStyledAttributes2 = context2.obtainStyledAttributes(attributeSet, iArr, me.hd.wauxv.R.attr.chipStyle, me.hd.wauxv.R.style.Widget_MaterialComponents_Chip_Action);
        boolean zHasValue = typedArrayObtainStyledAttributes2.hasValue(37);
        typedArrayObtainStyledAttributes2.recycle();
        this.q = new ym(this, this);
        z();
        if (!zHasValue) {
            setOutlineProvider(new yl(this, 0));
        }
        setChecked(this.i);
        setText(yoVar.j);
        setEllipsize(yoVar.bh);
        ac();
        if (!this.d.bi) {
            setLines(1);
            setHorizontallyScrolling(true);
        }
        setGravity(8388627);
        ab();
        if (this.m) {
            setMinHeight(this.o);
        }
        this.n = getLayoutDirection();
        super.setOnCheckedChangeListener(new yj(this, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RectF getCloseIconTouchBounds() {
        RectF rectF = this.t;
        rectF.setEmpty();
        if (y() && this.g != null) {
            yo yoVar = this.d;
            Rect bounds = yoVar.getBounds();
            rectF.setEmpty();
            if (yoVar.cr()) {
                float f = yoVar.aj + yoVar.ai + yoVar.u + yoVar.ah + yoVar.ag;
                if (yoVar.getLayoutDirection() == 0) {
                    float f2 = bounds.right;
                    rectF.right = f2;
                    rectF.left = f2 - f;
                } else {
                    float f3 = bounds.left;
                    rectF.left = f3;
                    rectF.right = f3 + f;
                }
                rectF.top = bounds.top;
                rectF.bottom = bounds.bottom;
            }
        }
        return rectF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        int i = (int) closeIconTouchBounds.left;
        int i2 = (int) closeIconTouchBounds.top;
        int i3 = (int) closeIconTouchBounds.right;
        int i4 = (int) closeIconTouchBounds.bottom;
        Rect rect = this.s;
        rect.set(i, i2, i3, i4);
        return rect;
    }

    private dqh getTextAppearance() {
        yo yoVar = this.d;
        if (yoVar != null) {
            return yoVar.aq.g;
        }
        return null;
    }

    private void setCloseIconHovered(boolean z) {
        if (this.k != z) {
            this.k = z;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z) {
        if (this.j != z) {
            this.j = z;
            refreshDrawableState();
        }
    }

    public final void aa() {
        this.f = new RippleDrawable(ddb.i(this.d.i), getBackgroundDrawable(), null);
        this.d.getClass();
        RippleDrawable rippleDrawable = this.f;
        WeakHashMap weakHashMap = ViewCompat.a;
        setBackground(rippleDrawable);
        ab();
    }

    public final void ab() {
        yo yoVar;
        if (TextUtils.isEmpty(getText()) || (yoVar = this.d) == null) {
            return;
        }
        int iBr = (int) (yoVar.br() + yoVar.aj + yoVar.ag);
        yo yoVar2 = this.d;
        int iBq = (int) (yoVar2.bq() + yoVar2.ac + yoVar2.af);
        if (this.e != null) {
            Rect rect = new Rect();
            this.e.getPadding(rect);
            iBq += rect.left;
            iBr += rect.right;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        WeakHashMap weakHashMap = ViewCompat.a;
        setPaddingRelative(iBq, paddingTop, iBr, paddingBottom);
    }

    public final void ac() {
        TextPaint paint = getPaint();
        yo yoVar = this.d;
        if (yoVar != null) {
            paint.drawableState = yoVar.getState();
        }
        dqh textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.s(getContext(), paint, this.u);
        }
    }

    @Override // android.view.View
    public final boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return !this.r ? super.dispatchHoverEvent(motionEvent) : this.q.aj(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    /* JADX WARN: Found duplicated region for block: B:31:0x0057  */
    /* JADX WARN: Found duplicated region for block: B:37:0x0067  */
    @Override // android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int i;
        if (!this.r) {
            return super.dispatchKeyEvent(keyEvent);
        }
        ym ymVar = this.q;
        ymVar.getClass();
        boolean zAl = false;
        int i2 = 0;
        zAl = false;
        zAl = false;
        zAl = false;
        zAl = false;
        zAl = false;
        if (keyEvent.getAction() != 1) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 61) {
                int i3 = 66;
                if (keyCode != 66) {
                    switch (keyCode) {
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                            if (keyEvent.hasNoModifiers()) {
                                if (keyCode == 19) {
                                    i3 = 33;
                                } else if (keyCode == 21) {
                                    i3 = 17;
                                } else if (keyCode != 22) {
                                    i3 = 130;
                                }
                                int repeatCount = keyEvent.getRepeatCount() + 1;
                                boolean z = false;
                                while (i2 < repeatCount && ymVar.al(i3, null)) {
                                    i2++;
                                    z = true;
                                }
                                zAl = z;
                            }
                            break;
                        case 23:
                            if (keyEvent.hasNoModifiers() && keyEvent.getRepeatCount() == 0) {
                                i = ymVar.ae;
                                if (i != Integer.MIN_VALUE) {
                                    ymVar.q(i, 16, null);
                                }
                                zAl = true;
                            }
                            break;
                    }
                } else if (keyEvent.hasNoModifiers()) {
                    i = ymVar.ae;
                    if (i != Integer.MIN_VALUE) {
                        ymVar.q(i, 16, null);
                    }
                    zAl = true;
                }
            } else if (keyEvent.hasNoModifiers()) {
                zAl = ymVar.al(2, null);
            } else if (keyEvent.hasModifiers(1)) {
                zAl = ymVar.al(1, null);
            }
        }
        if (!zAl || ymVar.ae == Integer.MIN_VALUE) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean, int] */
    @Override // me.hd.wauxv.obf.hf, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        int i;
        int i2;
        super.drawableStateChanged();
        yo yoVar = this.d;
        boolean zBu = false;
        if (yoVar != null && yo.bm(yoVar.r)) {
            yo yoVar2 = this.d;
            ?? IsEnabled = isEnabled();
            if (this.l) {
                i = IsEnabled;
                i = IsEnabled + 1;
            }
            i = IsEnabled;
            int i3 = i;
            if (this.k) {
                i3 = i + 1;
            }
            int i4 = i3;
            if (this.j) {
                i4 = i3 + 1;
            }
            int i5 = i4;
            if (isChecked()) {
                i5 = i4 + 1;
            }
            int[] iArr = new int[i5];
            if (isEnabled()) {
                iArr[0] = 16842910;
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (this.l) {
                iArr[i2] = 16842908;
                i2++;
            }
            if (this.k) {
                iArr[i2] = 16843623;
                i2++;
            }
            if (this.j) {
                iArr[i2] = 16842919;
                i2++;
            }
            if (isChecked()) {
                iArr[i2] = 16842913;
            }
            if (!Arrays.equals(yoVar2.be, iArr)) {
                yoVar2.be = iArr;
                if (yoVar2.cr()) {
                    zBu = yoVar2.bu(yoVar2.getState(), iArr);
                }
            }
        }
        if (zBu) {
            invalidate();
        }
    }

    @Override // android.widget.CheckBox, android.widget.CompoundButton, android.widget.Button, android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        if (!TextUtils.isEmpty(this.p)) {
            return this.p;
        }
        yo yoVar = this.d;
        if (yoVar == null || !yoVar.w) {
            return isClickable() ? "android.widget.Button" : "android.view.View";
        }
        getParent();
        return "android.widget.Button";
    }

    public Drawable getBackgroundDrawable() {
        InsetDrawable insetDrawable = this.e;
        return insetDrawable == null ? this.d : insetDrawable;
    }

    public Drawable getCheckedIcon() {
        yo yoVar = this.d;
        if (yoVar != null) {
            return yoVar.y;
        }
        return null;
    }

    public ColorStateList getCheckedIconTint() {
        yo yoVar = this.d;
        if (yoVar != null) {
            return yoVar.z;
        }
        return null;
    }

    public ColorStateList getChipBackgroundColor() {
        yo yoVar = this.d;
        if (yoVar != null) {
            return yoVar.d;
        }
        return null;
    }

    public float getChipCornerRadius() {
        yo yoVar = this.d;
        if (yoVar != null) {
            return Math.max(0.0f, yoVar.bs());
        }
        return 0.0f;
    }

    public Drawable getChipDrawable() {
        return this.d;
    }

    public float getChipEndPadding() {
        yo yoVar = this.d;
        if (yoVar != null) {
            return yoVar.aj;
        }
        return 0.0f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Drawable getChipIcon() {
        Drawable drawable;
        yo yoVar = this.d;
        if (yoVar == null || (drawable = yoVar.l) == 0) {
            return null;
        }
        if (!(drawable instanceof ewc)) {
            return drawable;
        }
        return null;
    }

    public float getChipIconSize() {
        yo yoVar = this.d;
        if (yoVar != null) {
            return yoVar.o;
        }
        return 0.0f;
    }

    public ColorStateList getChipIconTint() {
        yo yoVar = this.d;
        if (yoVar != null) {
            return yoVar.m;
        }
        return null;
    }

    public float getChipMinHeight() {
        yo yoVar = this.d;
        if (yoVar != null) {
            return yoVar.e;
        }
        return 0.0f;
    }

    public float getChipStartPadding() {
        yo yoVar = this.d;
        if (yoVar != null) {
            return yoVar.ac;
        }
        return 0.0f;
    }

    public ColorStateList getChipStrokeColor() {
        yo yoVar = this.d;
        if (yoVar != null) {
            return yoVar.g;
        }
        return null;
    }

    public float getChipStrokeWidth() {
        yo yoVar = this.d;
        if (yoVar != null) {
            return yoVar.h;
        }
        return 0.0f;
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Drawable getCloseIcon() {
        Drawable drawable;
        yo yoVar = this.d;
        if (yoVar == null || (drawable = yoVar.r) == 0) {
            return null;
        }
        if (!(drawable instanceof ewc)) {
            return drawable;
        }
        return null;
    }

    public CharSequence getCloseIconContentDescription() {
        yo yoVar = this.d;
        if (yoVar != null) {
            return yoVar.v;
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        yo yoVar = this.d;
        if (yoVar != null) {
            return yoVar.ai;
        }
        return 0.0f;
    }

    public float getCloseIconSize() {
        yo yoVar = this.d;
        if (yoVar != null) {
            return yoVar.u;
        }
        return 0.0f;
    }

    public float getCloseIconStartPadding() {
        yo yoVar = this.d;
        if (yoVar != null) {
            return yoVar.ah;
        }
        return 0.0f;
    }

    public ColorStateList getCloseIconTint() {
        yo yoVar = this.d;
        if (yoVar != null) {
            return yoVar.t;
        }
        return null;
    }

    @Override // android.widget.TextView
    public TextUtils.TruncateAt getEllipsize() {
        yo yoVar = this.d;
        if (yoVar != null) {
            return yoVar.bh;
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public final void getFocusedRect(Rect rect) {
        if (this.r) {
            ym ymVar = this.q;
            if (ymVar.ae == 1 || ymVar.ad == 1) {
                rect.set(getCloseIconTouchBoundsInt());
                return;
            }
        }
        super.getFocusedRect(rect);
    }

    public cfe getHideMotionSpec() {
        yo yoVar = this.d;
        if (yoVar != null) {
            return yoVar.ab;
        }
        return null;
    }

    public float getIconEndPadding() {
        yo yoVar = this.d;
        if (yoVar != null) {
            return yoVar.ae;
        }
        return 0.0f;
    }

    public float getIconStartPadding() {
        yo yoVar = this.d;
        if (yoVar != null) {
            return yoVar.ad;
        }
        return 0.0f;
    }

    public ColorStateList getRippleColor() {
        yo yoVar = this.d;
        if (yoVar != null) {
            return yoVar.i;
        }
        return null;
    }

    public dgm getShapeAppearanceModel() {
        return this.d.ct.b;
    }

    public cfe getShowMotionSpec() {
        yo yoVar = this.d;
        if (yoVar != null) {
            return yoVar.aa;
        }
        return null;
    }

    public float getTextEndPadding() {
        yo yoVar = this.d;
        if (yoVar != null) {
            return yoVar.ag;
        }
        return 0.0f;
    }

    public float getTextStartPadding() {
        yo yoVar = this.d;
        if (yoVar != null) {
            return yoVar.af;
        }
        return 0.0f;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        KotlinHelpers2.bi(this, this.d);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 2);
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, b);
        }
        yo yoVar = this.d;
        if (yoVar != null && yoVar.w) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, c);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (this.r) {
            ym ymVar = this.q;
            int i2 = ymVar.ae;
            if (i2 != Integer.MIN_VALUE) {
                ymVar.ag(i2);
            }
            if (z) {
                ymVar.al(i, rect);
            }
        }
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 7) {
            setCloseIconHovered(getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()));
        } else if (actionMasked == 10) {
            setCloseIconHovered(false);
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getAccessibilityClassName());
        yo yoVar = this.d;
        accessibilityNodeInfo.setCheckable(yoVar != null && yoVar.w);
        accessibilityNodeInfo.setClickable(isClickable());
        getParent();
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    public final PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i) {
        return (getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) && isEnabled()) ? PointerIcon.getSystemIcon(getContext(), 1002) : super.onResolvePointerIcon(motionEvent, i);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        if (this.n != i) {
            this.n = i;
            ab();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        int actionMasked = motionEvent.getActionMasked();
        boolean zContains = getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY());
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                    }
                } else if (this.j) {
                    if (!zContains) {
                        setCloseIconPressed(false);
                    }
                    z = true;
                }
                z = false;
            } else {
                if (this.j) {
                    playSoundEffect(0);
                    View.OnClickListener onClickListener = this.g;
                    if (onClickListener != null) {
                        onClickListener.onClick(this);
                    }
                    if (this.r) {
                        this.q.ao(1, 1);
                    }
                    z = true;
                }
                setCloseIconPressed(false);
            }
            z = false;
            setCloseIconPressed(false);
        } else if (zContains) {
            setCloseIconPressed(true);
            z = true;
        } else {
            z = false;
        }
        return z || super.onTouchEvent(motionEvent);
    }

    public void setAccessibilityClassName(CharSequence charSequence) {
        this.p = charSequence;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f) {
            super.setBackground(drawable);
        } else {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        Log.w("Chip", "Do not set the background color; Chip manages its own background drawable.");
    }

    @Override // me.hd.wauxv.obf.hf, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f) {
            super.setBackgroundDrawable(drawable);
        } else {
            Log.w("Chip", "Do not set the background drawable; Chip manages its own background drawable.");
        }
    }

    @Override // me.hd.wauxv.obf.hf, android.view.View
    public void setBackgroundResource(int i) {
        Log.w("Chip", "Do not set the background resource; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        Log.w("Chip", "Do not set the background tint list; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        Log.w("Chip", "Do not set the background tint mode; Chip manages its own background drawable.");
    }

    public void setCheckable(boolean z) {
        yo yoVar = this.d;
        if (yoVar != null) {
            yoVar.bv(z);
        }
    }

    public void setCheckableResource(int i) {
        yo yoVar = this.d;
        if (yoVar != null) {
            yoVar.bv(yoVar.ak.getResources().getBoolean(i));
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        yo yoVar = this.d;
        if (yoVar == null) {
            this.i = z;
        } else if (yoVar.w) {
            super.setChecked(z);
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        yo yoVar = this.d;
        if (yoVar != null) {
            yoVar.bw(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z) {
        setCheckedIconVisible(z);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(int i) {
        setCheckedIconVisible(i);
    }

    public void setCheckedIconResource(int i) {
        yo yoVar = this.d;
        if (yoVar != null) {
            yoVar.bw(cmz.y(yoVar.ak, i));
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        yo yoVar = this.d;
        if (yoVar != null) {
            yoVar.bx(colorStateList);
        }
    }

    public void setCheckedIconTintResource(int i) {
        yo yoVar = this.d;
        if (yoVar != null) {
            yoVar.bx(ResourcesCompat.v(yoVar.ak, i));
        }
    }

    public void setCheckedIconVisible(int i) {
        yo yoVar = this.d;
        if (yoVar != null) {
            yoVar.by(yoVar.ak.getResources().getBoolean(i));
        }
    }

    public void setChipBackgroundColor(ColorStateList colorStateList) {
        yo yoVar = this.d;
        if (yoVar == null || yoVar.d == colorStateList) {
            return;
        }
        yoVar.d = colorStateList;
        yoVar.onStateChange(yoVar.getState());
    }

    public void setChipBackgroundColorResource(int i) {
        ColorStateList colorStateListV;
        yo yoVar = this.d;
        if (yoVar == null || yoVar.d == (colorStateListV = ResourcesCompat.v(yoVar.ak, i))) {
            return;
        }
        yoVar.d = colorStateListV;
        yoVar.onStateChange(yoVar.getState());
    }

    @Deprecated
    public void setChipCornerRadius(float f) {
        yo yoVar = this.d;
        if (yoVar != null) {
            yoVar.bz(f);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(int i) {
        yo yoVar = this.d;
        if (yoVar != null) {
            yoVar.bz(yoVar.ak.getResources().getDimension(i));
        }
    }

    public void setChipDrawable(yo yoVar) {
        yo yoVar2 = this.d;
        if (yoVar2 != yoVar) {
            if (yoVar2 != null) {
                yoVar2.bg = new WeakReference(null);
            }
            this.d = yoVar;
            yoVar.bi = false;
            yoVar.bg = new WeakReference(this);
            x(this.o);
        }
    }

    public void setChipEndPadding(float f) {
        yo yoVar = this.d;
        if (yoVar == null || yoVar.aj == f) {
            return;
        }
        yoVar.aj = f;
        yoVar.invalidateSelf();
        yoVar.bt();
    }

    public void setChipEndPaddingResource(int i) {
        yo yoVar = this.d;
        if (yoVar != null) {
            float dimension = yoVar.ak.getResources().getDimension(i);
            if (yoVar.aj != dimension) {
                yoVar.aj = dimension;
                yoVar.invalidateSelf();
                yoVar.bt();
            }
        }
    }

    public void setChipIcon(Drawable drawable) {
        yo yoVar = this.d;
        if (yoVar != null) {
            yoVar.ca(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z) {
        setChipIconVisible(z);
    }

    @Deprecated
    public void setChipIconEnabledResource(int i) {
        setChipIconVisible(i);
    }

    public void setChipIconResource(int i) {
        yo yoVar = this.d;
        if (yoVar != null) {
            yoVar.ca(cmz.y(yoVar.ak, i));
        }
    }

    public void setChipIconSize(float f) {
        yo yoVar = this.d;
        if (yoVar != null) {
            yoVar.cb(f);
        }
    }

    public void setChipIconSizeResource(int i) {
        yo yoVar = this.d;
        if (yoVar != null) {
            yoVar.cb(yoVar.ak.getResources().getDimension(i));
        }
    }

    public void setChipIconTint(ColorStateList colorStateList) {
        yo yoVar = this.d;
        if (yoVar != null) {
            yoVar.cc(colorStateList);
        }
    }

    public void setChipIconTintResource(int i) {
        yo yoVar = this.d;
        if (yoVar != null) {
            yoVar.cc(ResourcesCompat.v(yoVar.ak, i));
        }
    }

    public void setChipIconVisible(int i) {
        yo yoVar = this.d;
        if (yoVar != null) {
            yoVar.cd(yoVar.ak.getResources().getBoolean(i));
        }
    }

    public void setChipMinHeight(float f) {
        yo yoVar = this.d;
        if (yoVar == null || yoVar.e == f) {
            return;
        }
        yoVar.e = f;
        yoVar.invalidateSelf();
        yoVar.bt();
    }

    public void setChipMinHeightResource(int i) {
        yo yoVar = this.d;
        if (yoVar != null) {
            float dimension = yoVar.ak.getResources().getDimension(i);
            if (yoVar.e != dimension) {
                yoVar.e = dimension;
                yoVar.invalidateSelf();
                yoVar.bt();
            }
        }
    }

    public void setChipStartPadding(float f) {
        yo yoVar = this.d;
        if (yoVar == null || yoVar.ac == f) {
            return;
        }
        yoVar.ac = f;
        yoVar.invalidateSelf();
        yoVar.bt();
    }

    public void setChipStartPaddingResource(int i) {
        yo yoVar = this.d;
        if (yoVar != null) {
            float dimension = yoVar.ak.getResources().getDimension(i);
            if (yoVar.ac != dimension) {
                yoVar.ac = dimension;
                yoVar.invalidateSelf();
                yoVar.bt();
            }
        }
    }

    public void setChipStrokeColor(ColorStateList colorStateList) {
        yo yoVar = this.d;
        if (yoVar != null) {
            yoVar.ce(colorStateList);
        }
    }

    public void setChipStrokeColorResource(int i) {
        yo yoVar = this.d;
        if (yoVar != null) {
            yoVar.ce(ResourcesCompat.v(yoVar.ak, i));
        }
    }

    public void setChipStrokeWidth(float f) {
        yo yoVar = this.d;
        if (yoVar != null) {
            yoVar.cf(f);
        }
    }

    public void setChipStrokeWidthResource(int i) {
        yo yoVar = this.d;
        if (yoVar != null) {
            yoVar.cf(yoVar.ak.getResources().getDimension(i));
        }
    }

    @Deprecated
    public void setChipText(CharSequence charSequence) {
        setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(int i) {
        setText(getResources().getString(i));
    }

    public void setCloseIcon(Drawable drawable) {
        yo yoVar = this.d;
        if (yoVar != null) {
            yoVar.cg(drawable);
        }
        z();
    }

    public void setCloseIconContentDescription(CharSequence charSequence) {
        yo yoVar = this.d;
        if (yoVar == null || yoVar.v == charSequence) {
            return;
        }
        String str = ot.a;
        ot otVar = TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1 ? ot.d : ot.c;
        otVar.getClass();
        cxc cxcVar = dqi.a;
        yoVar.v = otVar.h(charSequence);
        yoVar.invalidateSelf();
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z) {
        setCloseIconVisible(z);
    }

    @Deprecated
    public void setCloseIconEnabledResource(int i) {
        setCloseIconVisible(i);
    }

    public void setCloseIconEndPadding(float f) {
        yo yoVar = this.d;
        if (yoVar != null) {
            yoVar.ch(f);
        }
    }

    public void setCloseIconEndPaddingResource(int i) {
        yo yoVar = this.d;
        if (yoVar != null) {
            yoVar.ch(yoVar.ak.getResources().getDimension(i));
        }
    }

    public void setCloseIconResource(int i) {
        yo yoVar = this.d;
        if (yoVar != null) {
            yoVar.cg(cmz.y(yoVar.ak, i));
        }
        z();
    }

    public void setCloseIconSize(float f) {
        yo yoVar = this.d;
        if (yoVar != null) {
            yoVar.ci(f);
        }
    }

    public void setCloseIconSizeResource(int i) {
        yo yoVar = this.d;
        if (yoVar != null) {
            yoVar.ci(yoVar.ak.getResources().getDimension(i));
        }
    }

    public void setCloseIconStartPadding(float f) {
        yo yoVar = this.d;
        if (yoVar != null) {
            yoVar.cj(f);
        }
    }

    public void setCloseIconStartPaddingResource(int i) {
        yo yoVar = this.d;
        if (yoVar != null) {
            yoVar.cj(yoVar.ak.getResources().getDimension(i));
        }
    }

    public void setCloseIconTint(ColorStateList colorStateList) {
        yo yoVar = this.d;
        if (yoVar != null) {
            yoVar.ck(colorStateList);
        }
    }

    public void setCloseIconTintResource(int i) {
        yo yoVar = this.d;
        if (yoVar != null) {
            yoVar.ck(ResourcesCompat.v(yoVar.ak, i));
        }
    }

    public void setCloseIconVisible(int i) {
        setCloseIconVisible(getResources().getBoolean(i));
    }

    @Override // me.hd.wauxv.obf.hf, android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    @Override // me.hd.wauxv.obf.hf, android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        if (i != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i3 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(i, i2, i3, i4);
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        if (i != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i3 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesWithIntrinsicBounds(i, i2, i3, i4);
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        yo yoVar = this.d;
        if (yoVar != null) {
            yoVar.dy(f);
        }
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.d == null) {
            return;
        }
        if (truncateAt == TextUtils.TruncateAt.MARQUEE) {
            throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
        }
        super.setEllipsize(truncateAt);
        yo yoVar = this.d;
        if (yoVar != null) {
            yoVar.bh = truncateAt;
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z) {
        this.m = z;
        x(this.o);
    }

    @Override // android.widget.TextView
    public void setGravity(int i) {
        if (i != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        } else {
            super.setGravity(i);
        }
    }

    public void setHideMotionSpec(cfe cfeVar) {
        yo yoVar = this.d;
        if (yoVar != null) {
            yoVar.ab = cfeVar;
        }
    }

    public void setHideMotionSpecResource(int i) {
        yo yoVar = this.d;
        if (yoVar != null) {
            yoVar.ab = cfe.c(yoVar.ak, i);
        }
    }

    public void setIconEndPadding(float f) {
        yo yoVar = this.d;
        if (yoVar != null) {
            yoVar.cm(f);
        }
    }

    public void setIconEndPaddingResource(int i) {
        yo yoVar = this.d;
        if (yoVar != null) {
            yoVar.cm(yoVar.ak.getResources().getDimension(i));
        }
    }

    public void setIconStartPadding(float f) {
        yo yoVar = this.d;
        if (yoVar != null) {
            yoVar.cn(f);
        }
    }

    public void setIconStartPaddingResource(int i) {
        yo yoVar = this.d;
        if (yoVar != null) {
            yoVar.cn(yoVar.ak.getResources().getDimension(i));
        }
    }

    public void setInternalOnCheckedChangeListener(car carVar) {
    }

    @Override // android.view.View
    public void setLayoutDirection(int i) {
        if (this.d == null) {
            return;
        }
        super.setLayoutDirection(i);
    }

    @Override // android.widget.TextView
    public void setLines(int i) {
        if (i > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setLines(i);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        if (i > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMaxLines(i);
    }

    @Override // android.widget.TextView
    public void setMaxWidth(int i) {
        super.setMaxWidth(i);
        yo yoVar = this.d;
        if (yoVar != null) {
            yoVar.bj = i;
        }
    }

    @Override // android.widget.TextView
    public void setMinLines(int i) {
        if (i > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMinLines(i);
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.h = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.g = onClickListener;
        z();
    }

    public void setRippleColor(ColorStateList colorStateList) {
        yo yoVar = this.d;
        if (yoVar != null) {
            yoVar.co(colorStateList);
        }
        this.d.getClass();
        aa();
    }

    public void setRippleColorResource(int i) {
        yo yoVar = this.d;
        if (yoVar != null) {
            yoVar.co(ResourcesCompat.v(yoVar.ak, i));
            this.d.getClass();
            aa();
        }
    }

    @Override // me.hd.wauxv.obf.dgx
    public void setShapeAppearanceModel(dgm dgmVar) {
        this.d.setShapeAppearanceModel(dgmVar);
    }

    public void setShowMotionSpec(cfe cfeVar) {
        yo yoVar = this.d;
        if (yoVar != null) {
            yoVar.aa = cfeVar;
        }
    }

    public void setShowMotionSpecResource(int i) {
        yo yoVar = this.d;
        if (yoVar != null) {
            yoVar.aa = cfe.c(yoVar.ak, i);
        }
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean z) {
        if (!z) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setSingleLine(z);
    }

    @Override // android.widget.TextView
    public final void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        yo yoVar = this.d;
        if (yoVar == null) {
            return;
        }
        if (charSequence == null) {
            charSequence = "";
        }
        super.setText(yoVar.bi ? null : charSequence, bufferType);
        yo yoVar2 = this.d;
        if (yoVar2 == null || TextUtils.equals(yoVar2.j, charSequence)) {
            return;
        }
        yoVar2.j = charSequence;
        yoVar2.aq.e = true;
        yoVar2.invalidateSelf();
        yoVar2.bt();
    }

    public void setTextAppearance(dqh dqhVar) {
        yo yoVar = this.d;
        if (yoVar != null) {
            yoVar.aq.j(dqhVar, yoVar.ak);
        }
        ac();
    }

    public void setTextAppearanceResource(int i) {
        setTextAppearance(getContext(), i);
    }

    public void setTextEndPadding(float f) {
        yo yoVar = this.d;
        if (yoVar == null || yoVar.ag == f) {
            return;
        }
        yoVar.ag = f;
        yoVar.invalidateSelf();
        yoVar.bt();
    }

    public void setTextEndPaddingResource(int i) {
        yo yoVar = this.d;
        if (yoVar != null) {
            float dimension = yoVar.ak.getResources().getDimension(i);
            if (yoVar.ag != dimension) {
                yoVar.ag = dimension;
                yoVar.invalidateSelf();
                yoVar.bt();
            }
        }
    }

    @Override // android.widget.TextView
    public final void setTextSize(int i, float f) {
        super.setTextSize(i, f);
        yo yoVar = this.d;
        if (yoVar != null) {
            float fApplyDimension = TypedValue.applyDimension(i, f, getResources().getDisplayMetrics());
            dqk dqkVar = yoVar.aq;
            dqh dqhVar = dqkVar.g;
            if (dqhVar != null) {
                dqhVar.k = fApplyDimension;
                dqkVar.a.setTextSize(fApplyDimension);
                yoVar.n();
            }
        }
        ac();
    }

    public void setTextStartPadding(float f) {
        yo yoVar = this.d;
        if (yoVar == null || yoVar.af == f) {
            return;
        }
        yoVar.af = f;
        yoVar.invalidateSelf();
        yoVar.bt();
    }

    public void setTextStartPaddingResource(int i) {
        yo yoVar = this.d;
        if (yoVar != null) {
            float dimension = yoVar.ak.getResources().getDimension(i);
            if (yoVar.af != dimension) {
                yoVar.af = dimension;
                yoVar.invalidateSelf();
                yoVar.bt();
            }
        }
    }

    public final void x(int i) {
        this.o = i;
        if (!this.m) {
            InsetDrawable insetDrawable = this.e;
            if (insetDrawable == null) {
                int[] iArr = ddb.a;
                aa();
                return;
            } else {
                if (insetDrawable != null) {
                    this.e = null;
                    setMinWidth(0);
                    setMinHeight((int) getChipMinHeight());
                    int[] iArr2 = ddb.a;
                    aa();
                    return;
                }
                return;
            }
        }
        int iMax = Math.max(0, i - ((int) this.d.e));
        int iMax2 = Math.max(0, i - this.d.getIntrinsicWidth());
        if (iMax2 <= 0 && iMax <= 0) {
            InsetDrawable insetDrawable2 = this.e;
            if (insetDrawable2 == null) {
                int[] iArr3 = ddb.a;
                aa();
                return;
            } else {
                if (insetDrawable2 != null) {
                    this.e = null;
                    setMinWidth(0);
                    setMinHeight((int) getChipMinHeight());
                    int[] iArr4 = ddb.a;
                    aa();
                    return;
                }
                return;
            }
        }
        int i2 = iMax2 > 0 ? iMax2 / 2 : 0;
        int i3 = iMax > 0 ? iMax / 2 : 0;
        if (this.e != null) {
            Rect rect = new Rect();
            this.e.getPadding(rect);
            if (rect.top == i3 && rect.bottom == i3 && rect.left == i2 && rect.right == i2) {
                int[] iArr5 = ddb.a;
                aa();
                return;
            }
        }
        if (getMinHeight() != i) {
            setMinHeight(i);
        }
        if (getMinWidth() != i) {
            setMinWidth(i);
        }
        this.e = new InsetDrawable((Drawable) this.d, i2, i3, i2, i3);
        int[] iArr6 = ddb.a;
        aa();
    }

    public final boolean y() {
        yo yoVar = this.d;
        if (yoVar == null) {
            return false;
        }
        Object obj = yoVar.r;
        if (obj == null) {
            obj = null;
        } else if (obj instanceof ewc) {
            obj = null;
        }
        return obj != null;
    }

    public final void z() {
        yo yoVar;
        if (!y() || (yoVar = this.d) == null || !yoVar.q || this.g == null) {
            ViewCompat.setAccessibilityDelegate(this, null);
            this.r = false;
        } else {
            ViewCompat.setAccessibilityDelegate(this, this.q);
            this.r = true;
        }
    }

    public void setCloseIconVisible(boolean z) {
        yo yoVar = this.d;
        if (yoVar != null) {
            yoVar.cl(z);
        }
        z();
    }

    public void setCheckedIconVisible(boolean z) {
        yo yoVar = this.d;
        if (yoVar != null) {
            yoVar.by(z);
        }
    }

    public void setChipIconVisible(boolean z) {
        yo yoVar = this.d;
        if (yoVar != null) {
            yoVar.cd(z);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        yo yoVar = this.d;
        if (yoVar != null) {
            Context context2 = yoVar.ak;
            yoVar.aq.j(new dqh(context2, i), context2);
        }
        ac();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i) {
        super.setTextAppearance(i);
        yo yoVar = this.d;
        if (yoVar != null) {
            Context context = yoVar.ak;
            yoVar.aq.j(new dqh(context, i), context);
        }
        ac();
    }
}
