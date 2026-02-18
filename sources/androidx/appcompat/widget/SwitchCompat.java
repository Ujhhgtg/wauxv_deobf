package androidx.appcompat.widget;

import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import java.util.WeakHashMap;
import me.hd.wauxv.obf.apy;
import me.hd.wauxv.obf.atf;
import me.hd.wauxv.obf.aus;
import me.hd.wauxv.obf.bht;
import me.hd.wauxv.obf.cmz;
import me.hd.wauxv.obf.cnb;
import me.hd.wauxv.obf.cyf;
import me.hd.wauxv.obf.drm;
import me.hd.wauxv.obf.em;
import me.hd.wauxv.obf.emc;
import me.hd.wauxv.obf.eqm;
import me.hd.wauxv.obf.eqz;
import me.hd.wauxv.obf.ii;
import me.hd.wauxv.obf.jl;
import me.hd.wauxv.obf.jx;
import me.hd.wauxv.obf.tr;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class SwitchCompat extends CompoundButton {
    public static final tr a = new tr("thumbPos", 5, Float.class);
    public static final int[] b = {R.attr.state_checked};
    public final int aa;
    public float ab;
    public int ac;
    public int ad;
    public int ae;
    public int af;
    public int ag;
    public int ah;
    public int ai;
    public boolean aj;
    public final TextPaint ak;
    public final ColorStateList al;
    public StaticLayout am;
    public StaticLayout an;
    public final em ao;
    public ObjectAnimator ap;
    public ii aq;
    public aus ar;
    public final Rect as;
    public Drawable c;
    public ColorStateList d;
    public PorterDuff.Mode e;
    public boolean f;
    public boolean g;
    public Drawable h;
    public ColorStateList i;
    public PorterDuff.Mode j;
    public boolean k;
    public boolean l;
    public int m;
    public int n;
    public int o;
    public boolean p;
    public CharSequence q;
    public CharSequence r;
    public CharSequence s;
    public CharSequence t;
    public boolean u;
    public int v;
    public final int w;
    public float x;
    public float y;
    public final VelocityTracker z;

    public SwitchCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, me.hd.wauxv.R.attr.switchStyle);
    }

    private ii getEmojiTextViewHelper() {
        if (this.aq == null) {
            this.aq = new ii(this);
        }
        return this.aq;
    }

    private boolean getTargetCheckedState() {
        return this.ab > 0.5f;
    }

    private int getThumbOffset() {
        return (int) (((getLayoutDirection() == 1 ? 1.0f - this.ab : this.ab) * getThumbScrollRange()) + 0.5f);
    }

    private int getThumbScrollRange() {
        Drawable drawable = this.h;
        if (drawable == null) {
            return 0;
        }
        Rect rect = this.as;
        drawable.getPadding(rect);
        Drawable drawable2 = this.c;
        Rect rectE = drawable2 != null ? apy.e(drawable2) : apy.c;
        return ((((this.ac - this.ae) - rect.left) - rect.right) - rectE.left) - rectE.right;
    }

    private void setTextOffInternal(CharSequence charSequence) {
        this.s = charSequence;
        TransformationMethod transformationMethodM = ((emc) getEmojiTextViewHelper().b.v).m(this.ao);
        if (transformationMethodM != null) {
            charSequence = transformationMethodM.getTransformation(charSequence, this);
        }
        this.t = charSequence;
        this.an = null;
        if (this.u) {
            aw();
        }
    }

    private void setTextOnInternal(CharSequence charSequence) {
        this.q = charSequence;
        TransformationMethod transformationMethodM = ((emc) getEmojiTextViewHelper().b.v).m(this.ao);
        if (transformationMethodM != null) {
            charSequence = transformationMethodM.getTransformation(charSequence, this);
        }
        this.r = charSequence;
        this.am = null;
        if (this.u) {
            aw();
        }
    }

    public final void at() {
        Drawable drawable = this.c;
        if (drawable != null) {
            if (this.f || this.g) {
                Drawable drawableMutate = drawable.mutate();
                this.c = drawableMutate;
                if (this.f) {
                    drawableMutate.setTintList(this.d);
                }
                if (this.g) {
                    this.c.setTintMode(this.e);
                }
                if (this.c.isStateful()) {
                    this.c.setState(getDrawableState());
                }
            }
        }
    }

    public final void au() {
        Drawable drawable = this.h;
        if (drawable != null) {
            if (this.k || this.l) {
                Drawable drawableMutate = drawable.mutate();
                this.h = drawableMutate;
                if (this.k) {
                    drawableMutate.setTintList(this.i);
                }
                if (this.l) {
                    this.h.setTintMode(this.j);
                }
                if (this.h.isStateful()) {
                    this.h.setState(getDrawableState());
                }
            }
        }
    }

    public final void av() {
        setTextOnInternal(this.q);
        setTextOffInternal(this.s);
        requestLayout();
    }

    public final void aw() {
        if (this.ar == null && ((emc) this.aq.b.v)._y() && atf.b != null) {
            atf atfVarL = atf.l();
            int iM = atfVarL.m();
            if (iM == 3 || iM == 0) {
                aus ausVar = new aus(this);
                this.ar = ausVar;
                atfVarL.q(ausVar);
            }
        }
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int i;
        int i2;
        int i3 = this.af;
        int i4 = this.ag;
        int i5 = this.ah;
        int i6 = this.ai;
        int thumbOffset = getThumbOffset() + i3;
        Drawable drawable = this.c;
        Rect rectE = drawable != null ? apy.e(drawable) : apy.c;
        Drawable drawable2 = this.h;
        Rect rect = this.as;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            int i7 = rect.left;
            thumbOffset += i7;
            if (rectE != null) {
                int i8 = rectE.left;
                if (i8 > i7) {
                    i3 += i8 - i7;
                }
                int i9 = rectE.top;
                int i10 = rect.top;
                i = i9 > i10 ? (i9 - i10) + i4 : i4;
                int i11 = rectE.right;
                int i12 = rect.right;
                if (i11 > i12) {
                    i5 -= i11 - i12;
                }
                int i13 = rectE.bottom;
                int i14 = rect.bottom;
                if (i13 > i14) {
                    i2 = i6 - (i13 - i14);
                }
                this.h.setBounds(i3, i, i5, i2);
            } else {
                i = i4;
            }
            i2 = i6;
            this.h.setBounds(i3, i, i5, i2);
        }
        Drawable drawable3 = this.c;
        if (drawable3 != null) {
            drawable3.getPadding(rect);
            int i15 = thumbOffset - rect.left;
            int i16 = thumbOffset + this.ae + rect.right;
            this.c.setBounds(i15, i4, i16, i6);
            Drawable background = getBackground();
            if (background != null) {
                background.setHotspotBounds(i15, i4, i16, i6);
            }
        }
        super.draw(canvas);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableHotspotChanged(float f, float f2) {
        super.drawableHotspotChanged(f, f2);
        Drawable drawable = this.c;
        if (drawable != null) {
            drawable.setHotspot(f, f2);
        }
        Drawable drawable2 = this.h;
        if (drawable2 != null) {
            drawable2.setHotspot(f, f2);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.c;
        boolean state = (drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState);
        Drawable drawable2 = this.h;
        if (drawable2 != null && drawable2.isStateful()) {
            state |= drawable2.setState(drawableState);
        }
        if (state) {
            invalidate();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (getLayoutDirection() != 1) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.ac;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.o : compoundPaddingLeft;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (getLayoutDirection() == 1) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.ac;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.o : compoundPaddingRight;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return cnb.ar(super.getCustomSelectionActionModeCallback());
    }

    public boolean getShowText() {
        return this.u;
    }

    public boolean getSplitTrack() {
        return this.p;
    }

    public int getSwitchMinWidth() {
        return this.n;
    }

    public int getSwitchPadding() {
        return this.o;
    }

    public CharSequence getTextOff() {
        return this.s;
    }

    public CharSequence getTextOn() {
        return this.q;
    }

    public Drawable getThumbDrawable() {
        return this.c;
    }

    public final float getThumbPosition() {
        return this.ab;
    }

    public int getThumbTextPadding() {
        return this.m;
    }

    public ColorStateList getThumbTintList() {
        return this.d;
    }

    public PorterDuff.Mode getThumbTintMode() {
        return this.e;
    }

    public Drawable getTrackDrawable() {
        return this.h;
    }

    public ColorStateList getTrackTintList() {
        return this.i;
    }

    public PorterDuff.Mode getTrackTintMode() {
        return this.j;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.c;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.h;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        ObjectAnimator objectAnimator = this.ap;
        if (objectAnimator == null || !objectAnimator.isStarted()) {
            return;
        }
        this.ap.end();
        this.ap = null;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, b);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        int width;
        super.onDraw(canvas);
        Drawable drawable = this.h;
        Rect rect = this.as;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i = this.ag;
        int i2 = this.ai;
        int i3 = i + rect.top;
        int i4 = i2 - rect.bottom;
        Drawable drawable2 = this.c;
        if (drawable != null) {
            if (!this.p || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect rectE = apy.e(drawable2);
                drawable2.copyBounds(rect);
                rect.left += rectE.left;
                rect.right -= rectE.right;
                int iSave = canvas.save();
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(iSave);
            }
        }
        int iSave2 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        StaticLayout staticLayout = getTargetCheckedState() ? this.am : this.an;
        if (staticLayout != null) {
            int[] drawableState = getDrawableState();
            TextPaint textPaint = this.ak;
            ColorStateList colorStateList = this.al;
            if (colorStateList != null) {
                textPaint.setColor(colorStateList.getColorForState(drawableState, 0));
            }
            textPaint.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                width = bounds.left + bounds.right;
            } else {
                width = getWidth();
            }
            canvas.translate((width / 2) - (staticLayout.getWidth() / 2), ((i3 + i4) / 2) - (staticLayout.getHeight() / 2));
            staticLayout.draw(canvas);
        }
        canvas.restoreToCount(iSave2);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.Switch");
        if (Build.VERSION.SDK_INT < 30) {
            CharSequence charSequence = isChecked() ? this.q : this.s;
            if (TextUtils.isEmpty(charSequence)) {
                return;
            }
            CharSequence text = accessibilityNodeInfo.getText();
            if (TextUtils.isEmpty(text)) {
                accessibilityNodeInfo.setText(charSequence);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(text);
            sb.append(' ');
            sb.append(charSequence);
            accessibilityNodeInfo.setText(sb);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int iMax;
        int width;
        int paddingLeft;
        int height;
        int paddingTop;
        super.onLayout(z, i, i2, i3, i4);
        int iMax2 = 0;
        if (this.c != null) {
            Drawable drawable = this.h;
            Rect rect = this.as;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect rectE = apy.e(this.c);
            iMax = Math.max(0, rectE.left - rect.left);
            iMax2 = Math.max(0, rectE.right - rect.right);
        } else {
            iMax = 0;
        }
        if (getLayoutDirection() == 1) {
            paddingLeft = getPaddingLeft() + iMax;
            width = ((this.ac + paddingLeft) - iMax) - iMax2;
        } else {
            width = (getWidth() - getPaddingRight()) - iMax2;
            paddingLeft = (width - this.ac) + iMax + iMax2;
        }
        int gravity = getGravity() & 112;
        if (gravity == 16) {
            int height2 = ((getHeight() + getPaddingTop()) - getPaddingBottom()) / 2;
            int i5 = this.ad;
            int i6 = height2 - (i5 / 2);
            height = i5 + i6;
            paddingTop = i6;
        } else if (gravity != 80) {
            paddingTop = getPaddingTop();
            height = this.ad + paddingTop;
        } else {
            height = getHeight() - getPaddingBottom();
            paddingTop = height - this.ad;
        }
        this.af = paddingLeft;
        this.ag = paddingTop;
        this.ai = height;
        this.ah = width;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int i, int i2) {
        int intrinsicWidth;
        int intrinsicHeight;
        int intrinsicHeight2 = 0;
        if (this.u) {
            StaticLayout staticLayout = this.am;
            TextPaint textPaint = this.ak;
            if (staticLayout == null) {
                CharSequence charSequence = this.r;
                this.am = new StaticLayout(charSequence, textPaint, charSequence != null ? (int) Math.ceil(Layout.getDesiredWidth(charSequence, textPaint)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
            }
            if (this.an == null) {
                CharSequence charSequence2 = this.t;
                this.an = new StaticLayout(charSequence2, textPaint, charSequence2 != null ? (int) Math.ceil(Layout.getDesiredWidth(charSequence2, textPaint)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
            }
        }
        Drawable drawable = this.c;
        Rect rect = this.as;
        if (drawable != null) {
            drawable.getPadding(rect);
            intrinsicWidth = (this.c.getIntrinsicWidth() - rect.left) - rect.right;
            intrinsicHeight = this.c.getIntrinsicHeight();
        } else {
            intrinsicWidth = 0;
            intrinsicHeight = 0;
        }
        this.ae = Math.max(this.u ? (this.m * 2) + Math.max(this.am.getWidth(), this.an.getWidth()) : 0, intrinsicWidth);
        Drawable drawable2 = this.h;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            intrinsicHeight2 = this.h.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int iMax = rect.left;
        int iMax2 = rect.right;
        Drawable drawable3 = this.c;
        if (drawable3 != null) {
            Rect rectE = apy.e(drawable3);
            iMax = Math.max(iMax, rectE.left);
            iMax2 = Math.max(iMax2, rectE.right);
        }
        int iMax3 = this.aj ? Math.max(this.n, (this.ae * 2) + iMax + iMax2) : this.n;
        int iMax4 = Math.max(intrinsicHeight2, intrinsicHeight);
        this.ac = iMax3;
        this.ad = iMax4;
        super.onMeasure(i, i2);
        if (getMeasuredHeight() < iMax4) {
            setMeasuredDimension(getMeasuredWidthAndState(), iMax4);
        }
    }

    @Override // android.view.View
    public final void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence charSequence = isChecked() ? this.q : this.s;
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    /* JADX WARN: Found duplicated region for block: B:40:0x008c  */
    /* JADX WARN: Found duplicated region for block: B:42:0x0091  */
    /* JADX WARN: Found duplicated region for block: B:47:0x00a1  */
    /* JADX WARN: Found duplicated region for block: B:50:0x00a8  */
    /* JADX WARN: Found duplicated region for block: B:52:0x00bc  */
    /* JADX WARN: Found duplicated region for block: B:61:0x00cf  */
    /* JADX WARN: Found duplicated region for block: B:62:0x00d4  */
    /* JADX WARN: Found duplicated region for block: B:64:0x00d7  */
    /* JADX WARN: Found duplicated region for block: B:67:0x00ee  */
    @Override // android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean zIsChecked;
        boolean targetCheckedState;
        VelocityTracker velocityTracker = this.z;
        velocityTracker.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int i = this.w;
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                if (this.v == 2) {
                    this.v = 0;
                    z = motionEvent.getAction() != 1 && isEnabled();
                    zIsChecked = isChecked();
                    if (z) {
                        velocityTracker.computeCurrentVelocity(1000);
                        float xVelocity = velocityTracker.getXVelocity();
                        targetCheckedState = Math.abs(xVelocity) > ((float) this.aa) ? getLayoutDirection() == 1 ? xVelocity > 0.0f : xVelocity < 0.0f : getTargetCheckedState();
                    } else {
                        targetCheckedState = zIsChecked;
                    }
                    if (targetCheckedState != zIsChecked) {
                        playSoundEffect(0);
                    }
                    setChecked(targetCheckedState);
                    MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
                    motionEventObtain.setAction(3);
                    super.onTouchEvent(motionEventObtain);
                    motionEventObtain.recycle();
                    super.onTouchEvent(motionEvent);
                    return true;
                }
                this.v = 0;
                velocityTracker.clear();
            } else if (actionMasked == 2) {
                int i2 = this.v;
                if (i2 == 1) {
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    float f = i;
                    if (Math.abs(x - this.x) > f || Math.abs(y - this.y) > f) {
                        this.v = 2;
                        getParent().requestDisallowInterceptTouchEvent(true);
                        this.x = x;
                        this.y = y;
                        return true;
                    }
                } else if (i2 == 2) {
                    float x2 = motionEvent.getX();
                    int thumbScrollRange = getThumbScrollRange();
                    float f2 = x2 - this.x;
                    float f3 = thumbScrollRange != 0 ? f2 / thumbScrollRange : f2 > 0.0f ? 1.0f : -1.0f;
                    if (getLayoutDirection() == 1) {
                        f3 = -f3;
                    }
                    float f4 = this.ab;
                    float f5 = f3 + f4;
                    float f6 = f5 >= 0.0f ? f5 > 1.0f ? 1.0f : f5 : 0.0f;
                    if (f6 != f4) {
                        this.x = x2;
                        setThumbPosition(f6);
                    }
                    return true;
                }
            } else if (actionMasked == 3) {
                if (this.v == 2) {
                    this.v = 0;
                    if (motionEvent.getAction() != 1) {
                    }
                    zIsChecked = isChecked();
                    if (z) {
                        velocityTracker.computeCurrentVelocity(1000);
                        float xVelocity2 = velocityTracker.getXVelocity();
                        if (Math.abs(xVelocity2) > ((float) this.aa)) {
                        }
                    } else {
                        targetCheckedState = zIsChecked;
                    }
                    if (targetCheckedState != zIsChecked) {
                        playSoundEffect(0);
                    }
                    setChecked(targetCheckedState);
                    MotionEvent motionEventObtain2 = MotionEvent.obtain(motionEvent);
                    motionEventObtain2.setAction(3);
                    super.onTouchEvent(motionEventObtain2);
                    motionEventObtain2.recycle();
                    super.onTouchEvent(motionEvent);
                    return true;
                }
                this.v = 0;
                velocityTracker.clear();
            }
        } else {
            float x3 = motionEvent.getX();
            float y2 = motionEvent.getY();
            if (isEnabled() && this.c != null) {
                int thumbOffset = getThumbOffset();
                Drawable drawable = this.c;
                Rect rect = this.as;
                drawable.getPadding(rect);
                int i3 = this.ag - i;
                int i4 = (this.af + thumbOffset) - i;
                int i5 = this.ae + i4 + rect.left + rect.right + i;
                int i6 = this.ai + i;
                if (x3 > i4 && x3 < i5 && y2 > i3 && y2 < i6) {
                    this.v = 1;
                    this.x = x3;
                    this.y = y2;
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        getEmojiTextViewHelper().e(z);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        super.setChecked(z);
        boolean zIsChecked = isChecked();
        if (zIsChecked) {
            if (Build.VERSION.SDK_INT >= 30) {
                Object string = this.q;
                if (string == null) {
                    string = getResources().getString(me.hd.wauxv.R.string.abc_capital_on);
                }
                Object obj = string;
                WeakHashMap weakHashMap = eqz.a;
                new eqm(me.hd.wauxv.R.id.tag_state_description, CharSequence.class, 64, 30, 2).k(this, obj);
            }
        } else if (Build.VERSION.SDK_INT >= 30) {
            Object string2 = this.s;
            if (string2 == null) {
                string2 = getResources().getString(me.hd.wauxv.R.string.abc_capital_off);
            }
            Object obj2 = string2;
            WeakHashMap weakHashMap2 = eqz.a;
            new eqm(me.hd.wauxv.R.id.tag_state_description, CharSequence.class, 64, 30, 2).k(this, obj2);
        }
        if (getWindowToken() == null || !isLaidOut()) {
            ObjectAnimator objectAnimator = this.ap;
            if (objectAnimator != null) {
                objectAnimator.cancel();
            }
            setThumbPosition(zIsChecked ? 1.0f : 0.0f);
            return;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, a, zIsChecked ? 1.0f : 0.0f);
        this.ap = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(250L);
        this.ap.setAutoCancel(true);
        this.ap.start();
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(cnb.as(callback, this));
    }

    public void setEmojiCompatEnabled(boolean z) {
        getEmojiTextViewHelper().f(z);
        setTextOnInternal(this.q);
        setTextOffInternal(this.s);
        requestLayout();
    }

    public final void setEnforceSwitchWidth(boolean z) {
        this.aj = z;
        invalidate();
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().c(inputFilterArr));
    }

    public void setShowText(boolean z) {
        if (this.u != z) {
            this.u = z;
            requestLayout();
            if (z) {
                aw();
            }
        }
    }

    public void setSplitTrack(boolean z) {
        this.p = z;
        invalidate();
    }

    public void setSwitchMinWidth(int i) {
        this.n = i;
        requestLayout();
    }

    public void setSwitchPadding(int i) {
        this.o = i;
        requestLayout();
    }

    public void setSwitchTypeface(Typeface typeface) {
        TextPaint textPaint = this.ak;
        if ((textPaint.getTypeface() == null || textPaint.getTypeface().equals(typeface)) && (textPaint.getTypeface() != null || typeface == null)) {
            return;
        }
        textPaint.setTypeface(typeface);
        requestLayout();
        invalidate();
    }

    public void setTextOff(CharSequence charSequence) {
        setTextOffInternal(charSequence);
        requestLayout();
        if (isChecked() || Build.VERSION.SDK_INT < 30) {
            return;
        }
        Object string = this.s;
        if (string == null) {
            string = getResources().getString(me.hd.wauxv.R.string.abc_capital_off);
        }
        WeakHashMap weakHashMap = eqz.a;
        new eqm(me.hd.wauxv.R.id.tag_state_description, CharSequence.class, 64, 30, 2).k(this, string);
    }

    public void setTextOn(CharSequence charSequence) {
        setTextOnInternal(charSequence);
        requestLayout();
        if (!isChecked() || Build.VERSION.SDK_INT < 30) {
            return;
        }
        Object string = this.q;
        if (string == null) {
            string = getResources().getString(me.hd.wauxv.R.string.abc_capital_on);
        }
        WeakHashMap weakHashMap = eqz.a;
        new eqm(me.hd.wauxv.R.id.tag_state_description, CharSequence.class, 64, 30, 2).k(this, string);
    }

    public void setThumbDrawable(Drawable drawable) {
        Drawable drawable2 = this.c;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.c = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setThumbPosition(float f) {
        this.ab = f;
        invalidate();
    }

    public void setThumbResource(int i) {
        setThumbDrawable(cmz.y(getContext(), i));
    }

    public void setThumbTextPadding(int i) {
        this.m = i;
        requestLayout();
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        this.d = colorStateList;
        this.f = true;
        at();
    }

    public void setThumbTintMode(PorterDuff.Mode mode) {
        this.e = mode;
        this.g = true;
        at();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.h;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.h = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i) {
        setTrackDrawable(cmz.y(getContext(), i));
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        this.i = colorStateList;
        this.k = true;
        au();
    }

    public void setTrackTintMode(PorterDuff.Mode mode) {
        this.j = mode;
        this.l = true;
        au();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final void toggle() {
        setChecked(!isChecked());
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.c || drawable == this.h;
    }

    public SwitchCompat(Context context, AttributeSet attributeSet, int i) {
        int resourceId;
        super(context, attributeSet, i);
        this.d = null;
        this.e = null;
        this.f = false;
        this.g = false;
        this.i = null;
        this.j = null;
        this.k = false;
        this.l = false;
        this.z = VelocityTracker.obtain();
        this.aj = true;
        this.as = new Rect();
        drm.h(this, getContext());
        TextPaint textPaint = new TextPaint(1);
        this.ak = textPaint;
        textPaint.density = getResources().getDisplayMetrics().density;
        int[] iArr = cyf.v;
        jx jxVarK = jx.k(context, attributeSet, iArr, i);
        TypedArray typedArray = (TypedArray) jxVarK.e;
        eqz.r(this, context, iArr, attributeSet, typedArray, i, 0);
        Drawable drawableS = jxVarK.s(2);
        this.c = drawableS;
        if (drawableS != null) {
            drawableS.setCallback(this);
        }
        Drawable drawableS2 = jxVarK.s(11);
        this.h = drawableS2;
        if (drawableS2 != null) {
            drawableS2.setCallback(this);
        }
        setTextOnInternal(typedArray.getText(0));
        setTextOffInternal(typedArray.getText(1));
        this.u = typedArray.getBoolean(3, true);
        this.m = typedArray.getDimensionPixelSize(8, 0);
        this.n = typedArray.getDimensionPixelSize(5, 0);
        this.o = typedArray.getDimensionPixelSize(6, 0);
        this.p = typedArray.getBoolean(4, false);
        ColorStateList colorStateListR = jxVarK.r(9);
        if (colorStateListR != null) {
            this.d = colorStateListR;
            this.f = true;
        }
        PorterDuff.Mode modeF = apy.f(typedArray.getInt(10, -1), null);
        if (this.e != modeF) {
            this.e = modeF;
            this.g = true;
        }
        if (this.f || this.g) {
            at();
        }
        ColorStateList colorStateListR2 = jxVarK.r(12);
        if (colorStateListR2 != null) {
            this.i = colorStateListR2;
            this.k = true;
        }
        PorterDuff.Mode modeF2 = apy.f(typedArray.getInt(13, -1), null);
        if (this.j != modeF2) {
            this.j = modeF2;
            this.l = true;
        }
        if (this.k || this.l) {
            au();
        }
        int resourceId2 = typedArray.getResourceId(7, 0);
        if (resourceId2 != 0) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(resourceId2, cyf.w);
            ColorStateList colorStateList = (!typedArrayObtainStyledAttributes.hasValue(3) || (resourceId = typedArrayObtainStyledAttributes.getResourceId(3, 0)) == 0 || (colorStateList = bht.v(context, resourceId)) == null) ? typedArrayObtainStyledAttributes.getColorStateList(3) : colorStateList;
            if (colorStateList != null) {
                this.al = colorStateList;
            } else {
                this.al = getTextColors();
            }
            int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
            if (dimensionPixelSize != 0) {
                float f = dimensionPixelSize;
                if (f != textPaint.getTextSize()) {
                    textPaint.setTextSize(f);
                    requestLayout();
                }
            }
            int i2 = typedArrayObtainStyledAttributes.getInt(1, -1);
            int i3 = typedArrayObtainStyledAttributes.getInt(2, -1);
            Typeface typeface = i2 != 1 ? i2 != 2 ? i2 != 3 ? null : Typeface.MONOSPACE : Typeface.SERIF : Typeface.SANS_SERIF;
            if (i3 > 0) {
                Typeface typefaceDefaultFromStyle = typeface == null ? Typeface.defaultFromStyle(i3) : Typeface.create(typeface, i3);
                setSwitchTypeface(typefaceDefaultFromStyle);
                int i4 = (~(typefaceDefaultFromStyle != null ? typefaceDefaultFromStyle.getStyle() : 0)) & i3;
                textPaint.setFakeBoldText((i4 & 1) != 0);
                textPaint.setTextSkewX((2 & i4) != 0 ? -0.25f : 0.0f);
            } else {
                textPaint.setFakeBoldText(false);
                textPaint.setTextSkewX(0.0f);
                setSwitchTypeface(typeface);
            }
            if (typedArrayObtainStyledAttributes.getBoolean(14, false)) {
                Context context2 = getContext();
                em emVar = new em();
                emVar.a = context2.getResources().getConfiguration().locale;
                this.ao = emVar;
            } else {
                this.ao = null;
            }
            setTextOnInternal(this.q);
            setTextOffInternal(this.s);
            typedArrayObtainStyledAttributes.recycle();
        }
        new jl(this).t(attributeSet, i);
        jxVarK.ae();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.w = viewConfiguration.getScaledTouchSlop();
        this.aa = viewConfiguration.getScaledMinimumFlingVelocity();
        getEmojiTextViewHelper().d(attributeSet, i);
        refreshDrawableState();
        setChecked(isChecked());
    }
}
