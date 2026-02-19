package me.hd.wauxv.obf;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.PointF;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import me.hd.wauxv.data.bean.MsgInfoBean;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class don extends ViewGroup {
    public final int a;
    public int b;
    public int c;
    public final PointF d;
    public final PointF e;
    public boolean f;
    public boolean g;
    public dom h;

    public don(Context context) {
        super(context, null, 0);
        this.d = new PointF();
        this.e = new PointF();
        this.a = ViewConfiguration.get(context).getScaledTouchSlop();
        setClickable(true);
    }

    /* JADX WARN: Found duplicated region for block: B:34:0x00cd */
    /* JADX WARN: Found duplicated region for block: B:36:0x00dc */
    /* JADX WARN: Found duplicated region for block: B:38:0x00fa */
    /* JADX WARN: Found duplicated region for block: B:40:0x0128 */
    /* JADX WARN: Found duplicated region for block: B:41:0x014e */
    /* JADX WARN: Found duplicated region for block: B:43:0x0198 */
    /* JADX WARN: Found duplicated region for block: B:44:0x01a1 */
    /* JADX WARN: Found duplicated region for block: B:45:0x01a9 */
    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) throws IllegalAccessException {
        dom domVar;
        chm chmVar;
        Object obj;
        Object objE;
        Object origin;
        MethodHookWrapper methodHookWrapperVar;
        Vibrator defaultVibrator;
        int action = motionEvent.getAction();
        PointF pointF = this.e;
        int i = 1;
        if (action != 0) {
            if (action == 1) {
                if (Math.abs(getScrollX()) > this.c) {
                    ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(getScrollX(), 0);
                    valueAnimatorOfInt.addUpdateListener(new aqi(this, 4));
                    valueAnimatorOfInt.setDuration(100L);
                    valueAnimatorOfInt.start();
                    domVar = this.h;
                    if (domVar != null) {
                        chmVar = (chm) domVar;
                        int i2 = 0;
                        obj = chmVar.d;
                        azg azgVarR = dqc.bi(obj).r();
                        azgVarR.ab = "checkBox" /* "checkBox" /* "checkBox" /* "checkBox" /* cnb.z(-473640403467050L)   */;
                        objE = ((azk) yg.e(azgVarR)).e();
                        throwIfVar1IsNull(objE);
                        if (((View) objE).getVisibility() == 0) {
                            azg azgVarR2 = dqc.bi(obj).r();
                            azgVarR2.ab = "maskView" /* "maskView" /* "maskView" /* "maskView" /* cnb.z(-473051992947498L)   */;
                            Object objE2 = ((azk) yg.e(azgVarR2)).e();
                            throwIfVar1IsNull(objE2);
                            ((View) objE2).performClick();
                        } else {
                            dov dovVar = new dov(new wi(chmVar.f, i));
                            uq uqVar = uq.a;
                            FrameLayout frameLayout = (FrameLayout) dovVar.getValue();
                            origin = ((MsgInfoBean) chmVar.e).getOrigin();
                            uqVar.getClass();
                            cde cdeVarT = dqc.bi(frameLayout).t();
                            cdeVarT.a = dal.b(Boolean.TYPE);
                            cdeVarT.d = new SomeHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(26);
                            methodHookWrapperVar = (MethodHookWrapper) aaz.e(cdeVarT.aj());
                            if (methodHookWrapperVar.a.getParameterCount() == 2) {
                                methodHookWrapperVar.e(origin, null);
                            } else {
                                methodHookWrapperVar.e(origin);
                            }
                        }
                    }
                } else {
                    ValueAnimator valueAnimatorOfInt2 = ValueAnimator.ofInt(getScrollX(), 0);
                    valueAnimatorOfInt2.addUpdateListener(new aqi(this, 4));
                    valueAnimatorOfInt2.setDuration(100L);
                    valueAnimatorOfInt2.start();
                }
                this.f = false;
                this.g = false;
            } else if (action == 2) {
                float rawX = pointF.x - motionEvent.getRawX();
                if (Math.abs(rawX) > 10.0f || Math.abs(getScrollX()) > 10) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    scrollBy((int) rawX, 0);
                    if (getScrollX() < 0) {
                        scrollTo(0, 0);
                    }
                    int scrollX = getScrollX();
                    int i3 = this.b;
                    if (scrollX > i3) {
                        scrollTo(i3, 0);
                    }
                    if (Math.abs(getScrollX()) <= this.c) {
                        this.g = false;
                    } else if (!this.g) {
                        dom domVar2 = this.h;
                        if (domVar2 != null) {
                            Context context = ((don) ((chm) domVar2).c).getContext();
                            if (Build.VERSION.SDK_INT >= 31) {
                                Object systemService = context.getSystemService("vibrator_manager" /*
                                                                                                    * cnb.z(-
                                                                                                    * 71210557766442L)
                                                                                                    */);
                                throwIfVar1IsNull(systemService,
                                        "null cannot be cast to non-null type android.os.VibratorManager" /*
                                                                                                           * cnb.z(-
                                                                                                           * 70587787508522L)
                                                                                                           */);
                                defaultVibrator = qc.m(systemService).getDefaultVibrator();
                            } else {
                                Object systemService2 = context.getSystemService("vibrator" /*
                                                                                             * "vibrator" /* "vibrator" /* "vibrator" /* cnb.z(-70862665415466L)  */
                                                                                             */);
                                throwIfVar1IsNull(systemService2,
                                        "null cannot be cast to non-null type android.os.Vibrator" /*
                                                                                                    * cnb.z(-
                                                                                                    * 70841190578986L)
                                                                                                    */);
                                defaultVibrator = (Vibrator) systemService2;
                            }
                            defaultVibrator.vibrate(VibrationEffect.createOneShot(40L, -1));
                        }
                        this.g = true;
                    }
                }
                pointF.set(motionEvent.getRawX(), motionEvent.getRawY());
            } else if (action == 3) {
                if (Math.abs(getScrollX()) > this.c) {
                    ValueAnimator valueAnimatorOfInt3 = ValueAnimator.ofInt(getScrollX(), 0);
                    valueAnimatorOfInt3.addUpdateListener(new aqi(this, 4));
                    valueAnimatorOfInt3.setDuration(100L);
                    valueAnimatorOfInt3.start();
                    domVar = this.h;
                    if (domVar != null) {
                        chmVar = (chm) domVar;
                        int i22 = 0;
                        obj = chmVar.d;
                        azg azgVarR3 = dqc.bi(obj).r();
                        azgVarR3.ab = "checkBox" /* "checkBox" /* "checkBox" /* "checkBox" /* cnb.z(-473640403467050L)   */;
                        objE = ((azk) yg.e(azgVarR3)).e();
                        throwIfVar1IsNull(objE);
                        if (((View) objE).getVisibility() == 0) {
                            azg azgVarR22 = dqc.bi(obj).r();
                            azgVarR22.ab = "maskView" /* "maskView" /* "maskView" /* "maskView" /* cnb.z(-473051992947498L)   */;
                            Object objE22 = ((azk) yg.e(azgVarR22)).e();
                            throwIfVar1IsNull(objE22);
                            ((View) objE22).performClick();
                        } else {
                            dov dovVar2 = new dov(new wi(chmVar.f, i));
                            uq uqVar2 = uq.a;
                            FrameLayout frameLayout2 = (FrameLayout) dovVar2.getValue();
                            origin = ((MsgInfoBean) chmVar.e).getOrigin();
                            uqVar2.getClass();
                            cde cdeVarT2 = dqc.bi(frameLayout2).t();
                            cdeVarT2.a = dal.b(Boolean.TYPE);
                            cdeVarT2.d = new SomeHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(26);
                            methodHookWrapperVar = (MethodHookWrapper) aaz.e(cdeVarT2.aj());
                            if (methodHookWrapperVar.a.getParameterCount() == 2) {
                                methodHookWrapperVar.e(origin, null);
                            } else {
                                methodHookWrapperVar.e(origin);
                            }
                        }
                    }
                } else {
                    ValueAnimator valueAnimatorOfInt22 = ValueAnimator.ofInt(getScrollX(), 0);
                    valueAnimatorOfInt22.addUpdateListener(new aqi(this, 4));
                    valueAnimatorOfInt22.setDuration(100L);
                    valueAnimatorOfInt22.start();
                }
                this.f = false;
                this.g = false;
            }
        } else {
            if (this.f) {
                return false;
            }
            this.f = true;
            this.d.set(motionEvent.getRawX(), motionEvent.getRawY());
            pointF.set(motionEvent.getRawX(), motionEvent.getRawY());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public final dom getSmoothListener() {
        return this.h;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 2 || Math.abs(motionEvent.getRawX() - this.d.x) <= this.a) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft = getPaddingLeft();
        baa baaVar = new baa(new bae(new lb(this, 3), true, new dko(25)));
        while (baaVar.hasNext()) {
            View view = (View) baaVar.next();
            view.layout(paddingLeft, getPaddingTop(), view.getMeasuredWidth() + paddingLeft,
                    view.getMeasuredHeight() + getPaddingTop());
            paddingLeft += view.getMeasuredWidth();
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        don donVar = this;
        super.onMeasure(i, i2);
        int measuredWidth = 0;
        donVar.b = 0;
        baa baaVar = new baa(new bae(new lb(donVar, 3), true, new dko(26)));
        int iMax = 0;
        boolean z = false;
        int i3 = 0;
        while (baaVar.hasNext()) {
            Object next = baaVar.next();
            int i4 = i3 + 1;
            if (i3 < 0) {
                OtherStaticHelpers.aj();
                throw null;
            }
            View view = (View) next;
            donVar.setClickable(true);
            donVar.measureChild(view, i, i2);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            throwIfVar1IsNull(layoutParams,
                    "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams" /*
                                                                                                      * cnb.z(-
                                                                                                      * 411479341792042L)
                                                                                                      */);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            iMax = Math.max(iMax, view.getMeasuredHeight());
            if (View.MeasureSpec.getMode(i2) != 1073741824 && marginLayoutParams.height == -1) {
                z = true;
            }
            if (i3 > 0) {
                donVar.b = view.getMeasuredWidth() + donVar.b;
            } else {
                measuredWidth = view.getMeasuredWidth();
            }
            i3 = i4;
        }
        int i5 = i;
        donVar.setMeasuredDimension(donVar.getPaddingRight() + donVar.getPaddingLeft() + measuredWidth,
                donVar.getPaddingBottom() + donVar.getPaddingTop() + iMax);
        donVar.c = (donVar.b * 4) / 10;
        if (z) {
            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(donVar.getMeasuredHeight(), 1073741824);
            baa baaVar2 = new baa(new bae(new lb(donVar, 3), true, new dko(27)));
            while (baaVar2.hasNext()) {
                View view2 = (View) baaVar2.next();
                ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                throwIfVar1IsNull(layoutParams2,
                        "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams" /*
                                                                                                          * cnb.z(-
                                                                                                          * 411689795189546L)
                                                                                                          */);
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                if (marginLayoutParams2.height == -1) {
                    int i6 = marginLayoutParams2.width;
                    marginLayoutParams2.width = view2.getMeasuredWidth();
                    donVar.measureChildWithMargins(view2, i5, 0, iMakeMeasureSpec, 0);
                    marginLayoutParams2.width = i6;
                }
                donVar = this;
                i5 = i;
            }
        }
    }

    public final void setSmoothListener(dom domVar) {
        this.h = domVar;
    }
}
