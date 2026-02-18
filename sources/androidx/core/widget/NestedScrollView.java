package androidx.core.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import com.android.dx.io.Opcodes;
import com.umeng.analytics.pro.q;
import java.util.ArrayList;
import java.util.WeakHashMap;
import me.hd.wauxv.obf.ann;
import me.hd.wauxv.obf.ard;
import me.hd.wauxv.obf.bmu;
import me.hd.wauxv.obf.cah;
import me.hd.wauxv.obf.cjn;
import me.hd.wauxv.obf.cko;
import me.hd.wauxv.obf.ckp;
import me.hd.wauxv.obf.ckq;
import me.hd.wauxv.obf.ckr;
import me.hd.wauxv.obf.cks;
import me.hd.wauxv.obf.cku;
import me.hd.wauxv.obf.cnd;
import me.hd.wauxv.obf.dfg;
import me.hd.wauxv.obf.eqq;
import me.hd.wauxv.obf.eqz;
import me.hd.wauxv.obf.ewz;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class NestedScrollView extends FrameLayout implements cku, ckr {
    public static final float a = (float) (Math.log(0.78d) / Math.log(0.9d));
    public static final cah b = new cah(3);
    public static final int[] c = {R.attr.fillViewport};
    public ckq aa;
    public final cjn ab;
    public final cks ac;
    public float ad;
    public final ann ae;
    public final float d;
    public long e;
    public final Rect f;
    public final OverScroller g;
    public final EdgeEffect h;
    public final EdgeEffect i;
    public dfg j;
    public int k;
    public boolean l;
    public boolean m;
    public View n;
    public boolean o;
    public VelocityTracker p;
    public boolean q;
    public boolean r;
    public final int s;
    public final int t;
    public final int u;
    public int v;
    public final int[] w;
    public final int[] x;
    public int y;
    public int z;

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, me.hd.wauxv.R.attr.nestedScrollViewStyle);
        this.f = new Rect();
        this.l = true;
        this.m = false;
        this.n = null;
        this.o = false;
        this.r = true;
        this.v = -1;
        this.w = new int[2];
        this.x = new int[2];
        this.ae = new ann(getContext(), new bmu(this));
        int i = Build.VERSION.SDK_INT;
        this.h = i >= 31 ? ard.a(context, attributeSet) : new EdgeEffect(context);
        this.i = i >= 31 ? ard.a(context, attributeSet) : new EdgeEffect(context);
        this.d = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        this.g = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.s = viewConfiguration.getScaledTouchSlop();
        this.t = viewConfiguration.getScaledMinimumFlingVelocity();
        this.u = viewConfiguration.getScaledMaximumFlingVelocity();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c, me.hd.wauxv.R.attr.nestedScrollViewStyle, 0);
        setFillViewport(typedArrayObtainStyledAttributes.getBoolean(0, false));
        typedArrayObtainStyledAttributes.recycle();
        this.ab = new cjn();
        this.ac = new cks(this);
        setNestedScrollingEnabled(true);
        eqz.s(this, b);
    }

    public static boolean af(View view, NestedScrollView nestedScrollView) {
        if (view == nestedScrollView) {
            return true;
        }
        Object parent = view.getParent();
        return (parent instanceof ViewGroup) && af((View) parent, nestedScrollView);
    }

    private dfg getScrollFeedbackProvider() {
        if (this.j == null) {
            this.j = new dfg(this);
        }
        return this.j;
    }

    @Override // android.view.ViewGroup
    public final void addView(View view) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view);
    }

    @Override // me.hd.wauxv.obf.cku
    public final void ag(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        as(iArr, i4, i5);
    }

    @Override // me.hd.wauxv.obf.ckt
    public final void ah(View view, int i, int i2, int i3, int i4, int i5) {
        as(null, i4, i5);
    }

    @Override // me.hd.wauxv.obf.ckt
    public final boolean ai(View view, View view2, int i, int i2) {
        return (i & 2) != 0;
    }

    @Override // me.hd.wauxv.obf.ckt
    public final void aj(View view, View view2, int i, int i2) {
        cjn cjnVar = this.ab;
        if (i2 == 1) {
            cjnVar.b = i;
        } else {
            cjnVar.a = i;
        }
        this.ac.l(2, i2);
    }

    @Override // me.hd.wauxv.obf.ckt
    public final void ak(View view, int i) {
        cjn cjnVar = this.ab;
        if (i == 1) {
            cjnVar.b = 0;
        } else {
            cjnVar.a = 0;
        }
        bb(i);
    }

    @Override // me.hd.wauxv.obf.ckt
    public final void al(View view, int i, int i2, int[] iArr, int i3) {
        this.ac.h(iArr, i, i2, i3, null);
    }

    public final boolean am(int i) {
        View viewFindFocus = findFocus();
        if (viewFindFocus == this) {
            viewFindFocus = null;
        }
        View view = viewFindFocus;
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i);
        int maxScrollAmount = getMaxScrollAmount();
        if (viewFindNextFocus == null || !ar(viewFindNextFocus, maxScrollAmount, getHeight())) {
            if (i == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                maxScrollAmount = Math.min((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getHeight() + getScrollY()) - getPaddingBottom()), maxScrollAmount);
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            ax(maxScrollAmount, -1, null, 0, 1, true);
        } else {
            Rect rect = this.f;
            viewFindNextFocus.getDrawingRect(rect);
            offsetDescendantRectToMyCoords(viewFindNextFocus, rect);
            ax(an(rect), -1, null, 0, 1, true);
            viewFindNextFocus.requestFocus(i);
        }
        if (view != null && view.isFocused() && !ar(view, 0, getHeight())) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        return true;
    }

    public final int an(Rect rect) {
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int i2 = rect.bottom < (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin ? i - verticalFadingEdgeLength : i;
        int i3 = rect.bottom;
        if (i3 > i2 && rect.top > scrollY) {
            return Math.min(rect.height() > height ? rect.top - scrollY : rect.bottom - i2, (childAt.getBottom() + layoutParams.bottomMargin) - i);
        }
        if (rect.top >= scrollY || i3 >= i2) {
            return 0;
        }
        return Math.max(rect.height() > height ? 0 - (i2 - rect.bottom) : 0 - (scrollY - rect.top), -getScrollY());
    }

    /* JADX WARN: Found duplicated region for block: B:48:0x0098  */
    /* JADX WARN: Found duplicated region for block: B:54:0x00ab  */
    public final boolean ao(KeyEvent keyEvent) {
        View viewFindFocus;
        View viewFindNextFocus;
        this.f.setEmpty();
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            if (childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin > (getHeight() - getPaddingTop()) - getPaddingBottom()) {
                if (keyEvent.getAction() == 0) {
                    int keyCode = keyEvent.getKeyCode();
                    if (keyCode == 19) {
                        return keyEvent.isAltPressed() ? aq(33) : am(33);
                    }
                    if (keyCode == 20) {
                        return keyEvent.isAltPressed() ? aq(130) : am(130);
                    }
                    if (keyCode == 62) {
                        av(keyEvent.isShiftPressed() ? 33 : 130);
                        return false;
                    }
                    if (keyCode == 92) {
                        return aq(33);
                    }
                    if (keyCode == 93) {
                        return aq(130);
                    }
                    if (keyCode == 122) {
                        av(33);
                        return false;
                    }
                    if (keyCode == 123) {
                        av(130);
                        return false;
                    }
                }
            } else if (isFocused() && keyEvent.getKeyCode() != 4) {
                viewFindFocus = findFocus();
                if (viewFindFocus == this) {
                    viewFindFocus = null;
                }
                viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, 130);
                if (viewFindNextFocus == null && viewFindNextFocus != this && viewFindNextFocus.requestFocus(130)) {
                    return true;
                }
            }
        } else if (isFocused()) {
            viewFindFocus = findFocus();
            if (viewFindFocus == this) {
                viewFindFocus = null;
            }
            viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, 130);
            if (viewFindNextFocus == null) {
            }
        }
        return false;
    }

    public final void ap(int i) {
        if (getChildCount() > 0) {
            this.g.fling(getScrollX(), getScrollY(), 0, i, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            this.ac.l(2, 1);
            this.z = getScrollY();
            postInvalidateOnAnimation();
            if (Build.VERSION.SDK_INT >= 35) {
                cko.a(this, Math.abs(this.g.getCurrVelocity()));
            }
        }
    }

    public final boolean aq(int i) {
        int childCount;
        boolean z = i == 130;
        int height = getHeight();
        Rect rect = this.f;
        rect.top = 0;
        rect.bottom = height;
        if (z && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            int paddingBottom = getPaddingBottom() + childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
            rect.bottom = paddingBottom;
            rect.top = paddingBottom - height;
        }
        return aw(i, rect.top, rect.bottom);
    }

    public final boolean ar(View view, int i, int i2) {
        Rect rect = this.f;
        view.getDrawingRect(rect);
        offsetDescendantRectToMyCoords(view, rect);
        return rect.bottom + i >= getScrollY() && rect.top - i <= getScrollY() + i2;
    }

    public final void as(int[] iArr, int i, int i2) {
        int scrollY = getScrollY();
        scrollBy(0, i);
        int scrollY2 = getScrollY() - scrollY;
        if (iArr != null) {
            iArr[1] = iArr[1] + scrollY2;
        }
        this.ac.i(0, scrollY2, 0, i - scrollY2, null, i2, iArr);
    }

    public final void at(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.v) {
            int i = actionIndex == 0 ? 1 : 0;
            this.k = (int) motionEvent.getY(i);
            this.v = motionEvent.getPointerId(i);
            VelocityTracker velocityTracker = this.p;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    public final boolean au(int i, int i2, int i3, int i4) {
        int i5;
        boolean z;
        int i6;
        boolean z2;
        getOverScrollMode();
        super.computeHorizontalScrollRange();
        super.computeHorizontalScrollExtent();
        computeVerticalScrollRange();
        super.computeVerticalScrollExtent();
        int i7 = i3 + i;
        if (i2 <= 0 && i2 >= 0) {
            i5 = i2;
            z = false;
        } else {
            i5 = 0;
            z = true;
        }
        if (i7 <= i4) {
            if (i7 < 0) {
                i6 = 0;
            } else {
                i6 = i7;
                z2 = false;
            }
            if (z2 && !this.ac.k(1)) {
                this.g.springBack(i5, i6, 0, 0, 0, getScrollRange());
            }
            super.scrollTo(i5, i6);
            return !z || z2;
        }
        i6 = i4;
        z2 = true;
        if (z2) {
            this.g.springBack(i5, i6, 0, 0, 0, getScrollRange());
        }
        super.scrollTo(i5, i6);
        if (z) {
        }
    }

    public final void av(int i) {
        boolean z = i == 130;
        int height = getHeight();
        Rect rect = this.f;
        if (z) {
            rect.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                int paddingBottom = getPaddingBottom() + childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
                if (rect.top + height > paddingBottom) {
                    rect.top = paddingBottom - height;
                }
            }
        } else {
            int scrollY = getScrollY() - height;
            rect.top = scrollY;
            if (scrollY < 0) {
                rect.top = 0;
            }
        }
        int i2 = rect.top;
        int i3 = height + i2;
        rect.bottom = i3;
        aw(i, i2, i3);
    }

    /* JADX WARN: Found duplicated region for block: B:32:0x0068  */
    public final boolean aw(int i, int i2, int i3) {
        boolean z;
        int height = getHeight();
        int scrollY = getScrollY();
        int i4 = height + scrollY;
        boolean z2 = i == 33;
        ArrayList<View> focusables = getFocusables(2);
        int size = focusables.size();
        View view = null;
        boolean z3 = false;
        for (int i5 = 0; i5 < size; i5++) {
            View view2 = focusables.get(i5);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (i2 < bottom && top < i3) {
                boolean z4 = i2 < top && bottom < i3;
                if (view == null) {
                    view = view2;
                    z3 = z4;
                } else {
                    boolean z5 = (z2 && top < view.getTop()) || (!z2 && bottom > view.getBottom());
                    if (z3) {
                        if (z4 && z5) {
                            view = view2;
                        }
                    } else if (z4) {
                        view = view2;
                        z3 = true;
                    } else if (z5) {
                        view = view2;
                    }
                }
            }
        }
        View view3 = view == null ? this : view;
        if (i2 < scrollY || i3 > i4) {
            ax(z2 ? i2 - scrollY : i3 - i4, -1, null, 0, 1, true);
            z = true;
        } else {
            z = false;
        }
        if (view3 != findFocus()) {
            view3.requestFocus(i);
        }
        return z;
    }

    /* JADX WARN: Found duplicated region for block: B:52:0x0118  */
    /* JADX WARN: Found duplicated region for block: B:59:0x0129  */
    public final int ax(int i, int i2, MotionEvent motionEvent, int i3, int i4, boolean z) {
        int i5;
        int i6;
        boolean z2;
        boolean z3;
        VelocityTracker velocityTracker;
        cks cksVar = this.ac;
        if (i4 == 1) {
            cksVar.l(2, i4);
        }
        boolean zH = this.ac.h(this.x, 0, i, i4, this.w);
        int[] iArr = this.w;
        int[] iArr2 = this.x;
        if (zH) {
            i5 = i - iArr2[1];
            i6 = iArr[1];
        } else {
            i5 = i;
            i6 = 0;
        }
        int scrollY = getScrollY();
        int scrollRange = getScrollRange();
        int overScrollMode = getOverScrollMode();
        boolean z4 = (overScrollMode == 0 || (overScrollMode == 1 && getScrollRange() > 0)) && !z;
        boolean z5 = au(i5, 0, scrollY, scrollRange) && !cksVar.k(i4);
        int scrollY2 = getScrollY() - scrollY;
        if (motionEvent != null && scrollY2 != 0) {
            getScrollFeedbackProvider().a.onScrollProgress(motionEvent.getDeviceId(), motionEvent.getSource(), i2, scrollY2);
        }
        iArr2[1] = 0;
        this.ac.i(0, scrollY2, 0, i5 - scrollY2, this.w, i4, iArr2);
        int i7 = i6 + iArr[1];
        int i8 = i5 - iArr2[1];
        int i9 = scrollY + i8;
        EdgeEffect edgeEffect = this.i;
        EdgeEffect edgeEffect2 = this.h;
        if (i9 >= 0) {
            if (i9 > scrollRange && z4) {
                cnd.bb(edgeEffect, i8 / getHeight(), 1.0f - (i3 / getWidth()));
                if (motionEvent != null) {
                    z2 = false;
                    getScrollFeedbackProvider().a.onScrollLimit(motionEvent.getDeviceId(), motionEvent.getSource(), i2, false);
                } else {
                    z2 = false;
                }
                if (!edgeEffect2.isFinished()) {
                    edgeEffect2.onRelease();
                }
            }
            if (edgeEffect2.isFinished() || !edgeEffect.isFinished()) {
                postInvalidateOnAnimation();
                z3 = z2;
            } else {
                z3 = z5;
            }
            if (z3 && i4 == 0 && (velocityTracker = this.p) != null) {
                velocityTracker.clear();
            }
            if (i4 == 1) {
                bb(i4);
                edgeEffect2.onRelease();
                edgeEffect.onRelease();
            }
            return i7;
        }
        if (z4) {
            cnd.bb(edgeEffect2, (-i8) / getHeight(), i3 / getWidth());
            if (motionEvent != null) {
                getScrollFeedbackProvider().a.onScrollLimit(motionEvent.getDeviceId(), motionEvent.getSource(), i2, true);
            }
            if (!edgeEffect.isFinished()) {
                edgeEffect.onRelease();
            }
        }
        z2 = false;
        if (edgeEffect2.isFinished()) {
            postInvalidateOnAnimation();
            z3 = z2;
        } else {
            postInvalidateOnAnimation();
            z3 = z2;
        }
        if (z3) {
            velocityTracker.clear();
        }
        if (i4 == 1) {
            bb(i4);
            edgeEffect2.onRelease();
            edgeEffect.onRelease();
        }
        return i7;
    }

    public final boolean ay(EdgeEffect edgeEffect, int i) {
        if (i > 0) {
            return true;
        }
        float fAt = cnd.at(edgeEffect) * getHeight();
        float fAbs = Math.abs(-i) * 0.35f;
        float f = this.d * 0.015f;
        double dLog = Math.log(fAbs / f);
        double d = a;
        return ((float) (Math.exp((d / (d - 1.0d)) * dLog) * ((double) f))) < fAt;
    }

    public final void az(int i, int i2, boolean z) {
        if (getChildCount() == 0) {
            return;
        }
        if (AnimationUtils.currentAnimationTimeMillis() - this.e > 250) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int height = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            int iMax = Math.max(0, Math.min(i2 + scrollY, Math.max(0, height - height2))) - scrollY;
            this.g.startScroll(getScrollX(), scrollY, 0, iMax, Opcodes.INVOKE_POLYMORPHIC);
            if (z) {
                this.ac.l(2, 1);
            } else {
                bb(1);
            }
            this.z = getScrollY();
            postInvalidateOnAnimation();
        } else {
            if (!this.g.isFinished()) {
                this.g.abortAnimation();
                bb(1);
            }
            scrollBy(i, i2);
        }
        this.e = AnimationUtils.currentAnimationTimeMillis();
    }

    public final boolean ba(MotionEvent motionEvent) {
        boolean z;
        EdgeEffect edgeEffect = this.h;
        if (cnd.at(edgeEffect) != 0.0f) {
            cnd.bb(edgeEffect, 0.0f, motionEvent.getX() / getWidth());
            z = true;
        } else {
            z = false;
        }
        EdgeEffect edgeEffect2 = this.i;
        if (cnd.at(edgeEffect2) == 0.0f) {
            return z;
        }
        cnd.bb(edgeEffect2, 0.0f, 1.0f - (motionEvent.getX() / getWidth()));
        return true;
    }

    public final void bb(int i) {
        this.ac.m(i);
    }

    @Override // android.view.View
    public final int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override // android.view.View
    public final int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override // android.view.View
    public final int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    /* JADX WARN: Found duplicated region for block: B:22:0x0087  */
    /* JADX WARN: Found duplicated region for block: B:24:0x0096  */
    /* JADX WARN: Found duplicated region for block: B:26:0x00bc  */
    /* JADX WARN: Found duplicated region for block: B:30:0x00c6 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:31:0x00c8  */
    /* JADX WARN: Found duplicated region for block: B:33:0x00ce  */
    /* JADX WARN: Found duplicated region for block: B:34:0x00d9  */
    /* JADX WARN: Found duplicated region for block: B:36:0x00df  */
    /* JADX WARN: Found duplicated region for block: B:40:0x00f9  */
    /* JADX WARN: Found duplicated region for block: B:42:0x00fd  */
    @Override // android.view.View
    public final void computeScroll() {
        int iRound;
        int[] iArr;
        int i;
        int scrollRange;
        int overScrollMode;
        if (this.g.isFinished()) {
            return;
        }
        this.g.computeScrollOffset();
        int currY = this.g.getCurrY();
        int i2 = currY - this.z;
        int height = getHeight();
        EdgeEffect edgeEffect = this.h;
        EdgeEffect edgeEffect2 = this.i;
        if (i2 <= 0 || cnd.at(edgeEffect) == 0.0f) {
            if (i2 < 0 && cnd.at(edgeEffect2) != 0.0f) {
                float f = height;
                iRound = Math.round(cnd.bb(edgeEffect2, (i2 * 4.0f) / f, 0.5f) * (f / 4.0f));
                if (iRound != i2) {
                    edgeEffect2.finish();
                }
            }
            int i3 = i2;
            this.z = currY;
            iArr = this.x;
            iArr[1] = 0;
            this.ac.h(iArr, 0, i3, 1, null);
            i = i3 - iArr[1];
            scrollRange = getScrollRange();
            if (Build.VERSION.SDK_INT >= 35) {
                cko.a(this, Math.abs(this.g.getCurrVelocity()));
            }
            if (i != 0) {
                int scrollY = getScrollY();
                au(i, getScrollX(), scrollY, scrollRange);
                int scrollY2 = getScrollY() - scrollY;
                int i4 = i - scrollY2;
                iArr[1] = 0;
                this.ac.i(0, scrollY2, 0, i4, this.w, 1, iArr);
                i = i4 - iArr[1];
            }
            if (i != 0) {
                overScrollMode = getOverScrollMode();
                if (overScrollMode != 0 || (overScrollMode == 1 && scrollRange > 0)) {
                    if (i < 0) {
                        if (edgeEffect.isFinished()) {
                            edgeEffect.onAbsorb((int) this.g.getCurrVelocity());
                        }
                    } else if (edgeEffect2.isFinished()) {
                        edgeEffect2.onAbsorb((int) this.g.getCurrVelocity());
                    }
                }
                this.g.abortAnimation();
                bb(1);
            }
            if (this.g.isFinished()) {
                bb(1);
            } else {
                postInvalidateOnAnimation();
            }
        }
        iRound = Math.round(cnd.bb(edgeEffect, ((-i2) * 4.0f) / height, 0.5f) * ((-height) / 4.0f));
        if (iRound != i2) {
            edgeEffect.finish();
        }
        i2 -= iRound;
        int i32 = i2;
        this.z = currY;
        iArr = this.x;
        iArr[1] = 0;
        this.ac.h(iArr, 0, i32, 1, null);
        i = i32 - iArr[1];
        scrollRange = getScrollRange();
        if (Build.VERSION.SDK_INT >= 35) {
            cko.a(this, Math.abs(this.g.getCurrVelocity()));
        }
        if (i != 0) {
            int scrollY3 = getScrollY();
            au(i, getScrollX(), scrollY3, scrollRange);
            int scrollY22 = getScrollY() - scrollY3;
            int i42 = i - scrollY22;
            iArr[1] = 0;
            this.ac.i(0, scrollY22, 0, i42, this.w, 1, iArr);
            i = i42 - iArr[1];
        }
        if (i != 0) {
            overScrollMode = getOverScrollMode();
            if (overScrollMode != 0) {
                if (i < 0) {
                    if (edgeEffect.isFinished()) {
                        edgeEffect.onAbsorb((int) this.g.getCurrVelocity());
                    }
                } else if (edgeEffect2.isFinished()) {
                    edgeEffect2.onAbsorb((int) this.g.getCurrVelocity());
                }
            } else if (i < 0) {
                if (edgeEffect.isFinished()) {
                    edgeEffect.onAbsorb((int) this.g.getCurrVelocity());
                }
            } else if (edgeEffect2.isFinished()) {
                edgeEffect2.onAbsorb((int) this.g.getCurrVelocity());
            }
            this.g.abortAnimation();
            bb(1);
        }
        if (this.g.isFinished()) {
            postInvalidateOnAnimation();
        } else {
            bb(1);
        }
    }

    @Override // android.view.View
    public final int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override // android.view.View
    public final int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override // android.view.View
    public final int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int iMax = Math.max(0, bottom - height);
        return scrollY < 0 ? bottom - scrollY : scrollY > iMax ? (scrollY - iMax) + bottom : bottom;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || ao(keyEvent);
    }

    @Override // android.view.View
    public final boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.ac.f(f, f2, z);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreFling(float f, float f2) {
        return this.ac.g(f, f2);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.ac.h(iArr, i, i2, 0, iArr2);
    }

    @Override // android.view.View
    public final boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.ac.i(i, i2, i3, i4, iArr, 0, null);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int paddingLeft;
        super.draw(canvas);
        int scrollY = getScrollY();
        EdgeEffect edgeEffect = this.h;
        int paddingLeft2 = 0;
        if (!edgeEffect.isFinished()) {
            int iSave = canvas.save();
            int width = getWidth();
            int height = getHeight();
            int iMin = Math.min(0, scrollY);
            if (getClipToPadding()) {
                width -= getPaddingRight() + getPaddingLeft();
                paddingLeft = getPaddingLeft();
            } else {
                paddingLeft = 0;
            }
            if (getClipToPadding()) {
                height -= getPaddingBottom() + getPaddingTop();
                iMin += getPaddingTop();
            }
            canvas.translate(paddingLeft, iMin);
            edgeEffect.setSize(width, height);
            if (edgeEffect.draw(canvas)) {
                postInvalidateOnAnimation();
            }
            canvas.restoreToCount(iSave);
        }
        EdgeEffect edgeEffect2 = this.i;
        if (edgeEffect2.isFinished()) {
            return;
        }
        int iSave2 = canvas.save();
        int width2 = getWidth();
        int height2 = getHeight();
        int iMax = Math.max(getScrollRange(), scrollY) + height2;
        if (getClipToPadding()) {
            width2 -= getPaddingRight() + getPaddingLeft();
            paddingLeft2 = getPaddingLeft();
        }
        if (getClipToPadding()) {
            height2 -= getPaddingBottom() + getPaddingTop();
            iMax -= getPaddingBottom();
        }
        canvas.translate(paddingLeft2 - width2, iMax);
        canvas.rotate(180.0f, width2, 0.0f);
        edgeEffect2.setSize(width2, height2);
        if (edgeEffect2.draw(canvas)) {
            postInvalidateOnAnimation();
        }
        canvas.restoreToCount(iSave2);
    }

    @Override // android.view.View
    public float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + layoutParams.bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return bottom / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (getHeight() * 0.5f);
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        cjn cjnVar = this.ab;
        return cjnVar.b | cjnVar.a;
    }

    public int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    @Override // android.view.View
    public float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return scrollY / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public float getVerticalScrollFactorCompat() {
        if (this.ad == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (!context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
            this.ad = typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return this.ad;
    }

    @Override // android.view.View
    public final boolean hasNestedScrollingParent() {
        return this.ac.k(0);
    }

    @Override // android.view.View
    public final boolean isNestedScrollingEnabled() {
        return this.ac.d;
    }

    @Override // android.view.ViewGroup
    public final void measureChild(View view, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i, getPaddingRight() + getPaddingLeft(), layoutParams.width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override // android.view.ViewGroup
    public final void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i, getPaddingRight() + getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.m = false;
    }

    @Override // android.view.View
    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        int i;
        int width;
        float axisValue;
        if (motionEvent.getAction() == 8 && !this.o) {
            if (ewz.ak(motionEvent, 2)) {
                axisValue = motionEvent.getAxisValue(9);
                i = 9;
                width = (int) motionEvent.getX();
            } else if (ewz.ak(motionEvent, 4194304)) {
                float axisValue2 = motionEvent.getAxisValue(26);
                width = getWidth() / 2;
                i = 26;
                axisValue = axisValue2;
            } else {
                i = 0;
                width = 0;
                axisValue = 0.0f;
            }
            if (axisValue != 0.0f) {
                ax(-((int) (getVerticalScrollFactorCompat() * axisValue)), i, motionEvent, width, 1, ewz.ak(motionEvent, q.a.s));
                if (i == 0) {
                    return true;
                }
                this.ae.i(motionEvent, i);
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Found duplicated region for block: B:34:0x0083  */
    /* JADX WARN: Found duplicated region for block: B:36:0x008b  */
    /* JADX WARN: Found duplicated region for block: B:39:0x00a7  */
    /* JADX WARN: Found duplicated region for block: B:62:0x0119  */
    /* JADX WARN: Found duplicated region for block: B:70:0x012f  */
    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        VelocityTracker velocityTracker;
        VelocityTracker velocityTracker2;
        int action = motionEvent.getAction();
        boolean z = true;
        if (action == 2 && this.o) {
            return true;
        }
        int i = action & Opcodes.CONST_METHOD_TYPE;
        if (i == 0) {
            int y = (int) motionEvent.getY();
            int x = (int) motionEvent.getX();
            if (getChildCount() > 0) {
                int scrollY = getScrollY();
                View childAt = getChildAt(0);
                if (y < childAt.getTop() - scrollY || y >= childAt.getBottom() - scrollY || x < childAt.getLeft() || x >= childAt.getRight()) {
                    if (!ba(motionEvent) && this.g.isFinished()) {
                        z = false;
                    }
                    this.o = z;
                    velocityTracker = this.p;
                    if (velocityTracker != null) {
                        velocityTracker.recycle();
                        this.p = null;
                    }
                } else {
                    this.k = y;
                    this.v = motionEvent.getPointerId(0);
                    VelocityTracker velocityTracker3 = this.p;
                    if (velocityTracker3 == null) {
                        this.p = VelocityTracker.obtain();
                    } else {
                        velocityTracker3.clear();
                    }
                    this.p.addMovement(motionEvent);
                    this.g.computeScrollOffset();
                    if (!ba(motionEvent) && this.g.isFinished()) {
                        z = false;
                    }
                    this.o = z;
                    this.ac.l(2, 0);
                }
            } else {
                if (!ba(motionEvent)) {
                    z = false;
                }
                this.o = z;
                velocityTracker = this.p;
                if (velocityTracker != null) {
                    velocityTracker.recycle();
                    this.p = null;
                }
            }
        } else if (i == 1) {
            this.o = false;
            this.v = -1;
            velocityTracker2 = this.p;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.p = null;
            }
            if (this.g.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                postInvalidateOnAnimation();
            }
            bb(0);
        } else if (i == 2) {
            int i2 = this.v;
            if (i2 != -1) {
                int iFindPointerIndex = motionEvent.findPointerIndex(i2);
                if (iFindPointerIndex == -1) {
                    Log.e("NestedScrollView", "Invalid pointerId=" + i2 + " in onInterceptTouchEvent");
                } else {
                    int y2 = (int) motionEvent.getY(iFindPointerIndex);
                    if (Math.abs(y2 - this.k) > this.s && (2 & getNestedScrollAxes()) == 0) {
                        this.o = true;
                        this.k = y2;
                        if (this.p == null) {
                            this.p = VelocityTracker.obtain();
                        }
                        this.p.addMovement(motionEvent);
                        this.y = 0;
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                }
            }
        } else if (i == 3) {
            this.o = false;
            this.v = -1;
            velocityTracker2 = this.p;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.p = null;
            }
            if (this.g.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                postInvalidateOnAnimation();
            }
            bb(0);
        } else if (i == 6) {
            at(motionEvent);
        }
        return this.o;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredHeight;
        super.onLayout(z, i, i2, i3, i4);
        int i5 = 0;
        this.l = false;
        View view = this.n;
        if (view != null && af(view, this)) {
            View view2 = this.n;
            Rect rect = this.f;
            view2.getDrawingRect(rect);
            offsetDescendantRectToMyCoords(view2, rect);
            int iAn = an(rect);
            if (iAn != 0) {
                scrollBy(0, iAn);
            }
        }
        this.n = null;
        if (!this.m) {
            if (this.aa != null) {
                scrollTo(getScrollX(), this.aa.a);
                this.aa = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                measuredHeight = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            } else {
                measuredHeight = 0;
            }
            int paddingTop = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            if (paddingTop < measuredHeight && scrollY >= 0) {
                i5 = paddingTop + scrollY > measuredHeight ? measuredHeight - paddingTop : scrollY;
            }
            if (i5 != scrollY) {
                scrollTo(getScrollX(), i5);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.m = true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.q && View.MeasureSpec.getMode(i2) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                childAt.measure(ViewGroup.getChildMeasureSpec(i, getPaddingRight() + getPaddingLeft() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (z) {
            return false;
        }
        dispatchNestedFling(0.0f, f2, true);
        ap((int) f2);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f, float f2) {
        return this.ac.g(f, f2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        this.ac.h(iArr, i, i2, 0, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        as(null, i4, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i) {
        aj(view, view2, i, 0);
    }

    @Override // android.view.View
    public final void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.scrollTo(i, i2);
    }

    @Override // android.view.ViewGroup
    public final boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (i == 2) {
            i = 130;
        } else if (i == 1) {
            i = 33;
        }
        View viewFindNextFocus = rect == null ? FocusFinder.getInstance().findNextFocus(this, null, i) : FocusFinder.getInstance().findNextFocusFromRect(this, rect, i);
        if (viewFindNextFocus != null && ar(viewFindNextFocus, 0, getHeight())) {
            return viewFindNextFocus.requestFocus(i, rect);
        }
        return false;
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof ckq)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ckq ckqVar = (ckq) parcelable;
        super.onRestoreInstanceState(ckqVar.getSuperState());
        this.aa = ckqVar;
        requestLayout();
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        ckq ckqVar = new ckq(super.onSaveInstanceState());
        ckqVar.a = getScrollY();
        return ckqVar;
    }

    @Override // android.view.View
    public final void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        View viewFindFocus = findFocus();
        if (viewFindFocus == null || this == viewFindFocus || !ar(viewFindFocus, 0, i4)) {
            return;
        }
        Rect rect = this.f;
        viewFindFocus.getDrawingRect(rect);
        offsetDescendantRectToMyCoords(viewFindFocus, rect);
        int iAn = an(rect);
        if (iAn != 0) {
            if (this.r) {
                az(0, iAn, false);
            } else {
                scrollBy(0, iAn);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i) {
        return ai(view, view2, i, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        ak(view, 0);
    }

    /* JADX WARN: Found duplicated region for block: B:49:0x0120  */
    /* JADX WARN: Found duplicated region for block: B:56:0x0136  */
    /* JADX WARN: Found duplicated region for block: B:59:0x013d  */
    /* JADX WARN: Found duplicated region for block: B:60:0x0141  */
    /* JADX WARN: Found duplicated region for block: B:63:0x0148  */
    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        float fBb;
        int iRound;
        int i;
        ViewParent parent2;
        if (this.p == null) {
            this.p = VelocityTracker.obtain();
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.y = 0;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        float f = 0.0f;
        motionEventObtain.offsetLocation(0.0f, this.y);
        cks cksVar = this.ac;
        if (actionMasked != 0) {
            EdgeEffect edgeEffect = this.h;
            EdgeEffect edgeEffect2 = this.i;
            if (actionMasked == 1) {
                VelocityTracker velocityTracker = this.p;
                velocityTracker.computeCurrentVelocity(1000, this.u);
                int yVelocity = (int) velocityTracker.getYVelocity(this.v);
                if (Math.abs(yVelocity) >= this.t) {
                    if (cnd.at(edgeEffect) != 0.0f) {
                        if (ay(edgeEffect, yVelocity)) {
                            edgeEffect.onAbsorb(yVelocity);
                        } else {
                            ap(-yVelocity);
                        }
                    } else if (cnd.at(edgeEffect2) != 0.0f) {
                        int i2 = -yVelocity;
                        if (ay(edgeEffect2, i2)) {
                            edgeEffect2.onAbsorb(i2);
                        } else {
                            ap(i2);
                        }
                    } else {
                        int i3 = -yVelocity;
                        float f2 = i3;
                        if (!cksVar.g(0.0f, f2)) {
                            dispatchNestedFling(0.0f, f2, true);
                            ap(i3);
                        }
                    }
                } else if (this.g.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    postInvalidateOnAnimation();
                }
                this.v = -1;
                this.o = false;
                VelocityTracker velocityTracker2 = this.p;
                if (velocityTracker2 != null) {
                    velocityTracker2.recycle();
                    this.p = null;
                }
                bb(0);
                edgeEffect.onRelease();
                edgeEffect2.onRelease();
            } else if (actionMasked == 2) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.v);
                if (iFindPointerIndex == -1) {
                    Log.e("NestedScrollView", "Invalid pointerId=" + this.v + " in onTouchEvent");
                } else {
                    int y = (int) motionEvent.getY(iFindPointerIndex);
                    int i4 = this.k - y;
                    float x = motionEvent.getX(iFindPointerIndex) / getWidth();
                    float height = i4 / getHeight();
                    if (cnd.at(edgeEffect) != 0.0f) {
                        fBb = -cnd.bb(edgeEffect, -height, x);
                        if (cnd.at(edgeEffect) == 0.0f) {
                            edgeEffect.onRelease();
                        }
                    } else if (cnd.at(edgeEffect2) != 0.0f) {
                        fBb = cnd.bb(edgeEffect2, height, 1.0f - x);
                        if (cnd.at(edgeEffect2) == 0.0f) {
                            edgeEffect2.onRelease();
                        }
                    } else {
                        iRound = Math.round(f * getHeight());
                        if (iRound != 0) {
                            invalidate();
                        }
                        i = i4 - iRound;
                        if (!this.o && Math.abs(i) > this.s) {
                            parent2 = getParent();
                            if (parent2 != null) {
                                parent2.requestDisallowInterceptTouchEvent(true);
                            }
                            this.o = true;
                            i = i > 0 ? i - this.s : i + this.s;
                        }
                        if (this.o) {
                            int iAx = ax(i, 1, motionEvent, (int) motionEvent.getX(iFindPointerIndex), 0, false);
                            this.k = y - iAx;
                            this.y += iAx;
                        }
                    }
                    f = fBb;
                    iRound = Math.round(f * getHeight());
                    if (iRound != 0) {
                        invalidate();
                    }
                    i = i4 - iRound;
                    if (!this.o) {
                        parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.o = true;
                        if (i > 0) {
                        }
                    }
                    if (this.o) {
                        int iAx2 = ax(i, 1, motionEvent, (int) motionEvent.getX(iFindPointerIndex), 0, false);
                        this.k = y - iAx2;
                        this.y += iAx2;
                    }
                }
            } else if (actionMasked == 3) {
                if (this.o && getChildCount() > 0) {
                    if (this.g.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                        postInvalidateOnAnimation();
                    }
                }
                this.v = -1;
                this.o = false;
                VelocityTracker velocityTracker3 = this.p;
                if (velocityTracker3 != null) {
                    velocityTracker3.recycle();
                    this.p = null;
                }
                bb(0);
                edgeEffect.onRelease();
                edgeEffect2.onRelease();
            } else if (actionMasked == 5) {
                int actionIndex = motionEvent.getActionIndex();
                this.k = (int) motionEvent.getY(actionIndex);
                this.v = motionEvent.getPointerId(actionIndex);
            } else if (actionMasked == 6) {
                at(motionEvent);
                this.k = (int) motionEvent.getY(motionEvent.findPointerIndex(this.v));
            }
        } else {
            if (getChildCount() == 0) {
                return false;
            }
            if (this.o && (parent = getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            if (!this.g.isFinished()) {
                this.g.abortAnimation();
                bb(1);
            }
            int y2 = (int) motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            this.k = y2;
            this.v = pointerId;
            cksVar.l(2, 0);
        }
        VelocityTracker velocityTracker4 = this.p;
        if (velocityTracker4 != null) {
            velocityTracker4.addMovement(motionEventObtain);
        }
        motionEventObtain.recycle();
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestChildFocus(View view, View view2) {
        if (this.l) {
            this.n = view2;
        } else {
            Rect rect = this.f;
            view2.getDrawingRect(rect);
            offsetDescendantRectToMyCoords(view2, rect);
            int iAn = an(rect);
            if (iAn != 0) {
                scrollBy(0, iAn);
            }
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        int iAn = an(rect);
        boolean z2 = iAn != 0;
        if (z2) {
            if (z) {
                scrollBy(0, iAn);
                return z2;
            }
            az(0, iAn, false);
        }
        return z2;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z) {
        VelocityTracker velocityTracker;
        if (z && (velocityTracker = this.p) != null) {
            velocityTracker.recycle();
            this.p = null;
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        this.l = true;
        super.requestLayout();
    }

    @Override // android.view.View
    public final void scrollTo(int i, int i2) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int width2 = childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int height2 = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            if (width >= width2 || i < 0) {
                i = 0;
            } else if (width + i > width2) {
                i = width2 - width;
            }
            if (height >= height2 || i2 < 0) {
                i2 = 0;
            } else if (height + i2 > height2) {
                i2 = height2 - height;
            }
            if (i == getScrollX() && i2 == getScrollY()) {
                return;
            }
            super.scrollTo(i, i2);
        }
    }

    public void setFillViewport(boolean z) {
        if (z != this.q) {
            this.q = z;
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        cks cksVar = this.ac;
        if (cksVar.d) {
            ViewGroup viewGroup = cksVar.c;
            WeakHashMap weakHashMap = eqz.a;
            eqq.m(viewGroup);
        }
        cksVar.d = z;
    }

    public void setOnScrollChangeListener(ckp ckpVar) {
    }

    public void setSmoothScrollingEnabled(boolean z) {
        this.r = z;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return true;
    }

    @Override // android.view.View
    public final boolean startNestedScroll(int i) {
        return this.ac.l(i, 0);
    }

    @Override // android.view.View
    public final void stopNestedScroll() {
        bb(0);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i) {
        if (getChildCount() <= 0) {
            super.addView(view, i);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, i, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }
}
