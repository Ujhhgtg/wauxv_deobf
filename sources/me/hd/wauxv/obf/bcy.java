package me.hd.wauxv.obf;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class bcy implements View.OnTouchListener, View.OnAttachStateChangeListener {
    public final float f;
    public final int g;
    public final int h;
    public final View i;
    public bcx j;
    public bcx k;
    public boolean l;
    public int m;
    public final int[] n = new int[2];

    public bcy(View view) {
        this.i = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.g = tapTimeout;
        this.h = (ViewConfiguration.getLongPressTimeout() + tapTimeout) / 2;
    }

    public abstract dho callOriginalMethod();

    public abstract boolean getArgs();

    public boolean getThisObject() {
        dho dhoVarC = callOriginalMethod();
        if (dhoVarC == null || !dhoVarC.e()) {
            return true;
        }
        dhoVarC.dismiss();
        return true;
    }

    public final void o() {
        bcx bcxVar = this.k;
        View view = this.i;
        if (bcxVar != null) {
            view.removeCallbacks(bcxVar);
        }
        bcx bcxVar2 = this.j;
        if (bcxVar2 != null) {
            view.removeCallbacks(bcxVar2);
        }
    }

    /* JADX WARN: Found duplicated region for block: B:22:0x005c */
    /* JADX WARN: Found duplicated region for block: B:24:0x0062 */
    /* JADX WARN: Found duplicated region for block: B:25:0x0065 */
    /* JADX WARN: Found duplicated region for block: B:50:0x00cb */
    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        aqe aqeVarAi;
        boolean z2 = this.l;
        View view2 = this.i;
        if (z2) {
            dho dhoVarC = callOriginalMethod();
            if (dhoVarC == null || !dhoVarC.e() || (aqeVarAi = dhoVarC.ai()) == null || !aqeVarAi.isShown()) {
                z = !getThisObject();
            } else {
                MotionEvent motionEventObtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
                int[] iArr = this.n;
                view2.getLocationOnScreen(iArr);
                motionEventObtainNoHistory.offsetLocation(iArr[0], iArr[1]);
                aqeVarAi.getLocationOnScreen(iArr);
                motionEventObtainNoHistory.offsetLocation(-iArr[0], -iArr[1]);
                boolean zN = aqeVarAi.n(motionEventObtainNoHistory, this.m);
                motionEventObtainNoHistory.recycle();
                int actionMasked = motionEvent.getActionMasked();
                boolean z3 = (actionMasked == 1 || actionMasked == 3) ? false : true;
                if (!zN || !z3) {
                    if (!getThisObject()) {
                    }
                }
            }
        } else {
            if (view2.isEnabled()) {
                int actionMasked2 = motionEvent.getActionMasked();
                if (actionMasked2 == 0) {
                    this.m = motionEvent.getPointerId(0);
                    if (this.j == null) {
                        this.j = new bcx(this, 0);
                    }
                    view2.postDelayed(this.j, this.g);
                    if (this.k == null) {
                        this.k = new bcx(this, 1);
                    }
                    view2.postDelayed(this.k, this.h);
                } else if (actionMasked2 == 1) {
                    o();
                } else if (actionMasked2 == 2) {
                    int iFindPointerIndex = motionEvent.findPointerIndex(this.m);
                    if (iFindPointerIndex >= 0) {
                        float x = motionEvent.getX(iFindPointerIndex);
                        float y = motionEvent.getY(iFindPointerIndex);
                        float f = this.f;
                        float f2 = -f;
                        if (x < f2 || y < f2 || x >= (view2.getRight() - view2.getLeft()) + f
                                || y >= (view2.getBottom() - view2.getTop()) + f) {
                            o();
                            view2.getParent().requestDisallowInterceptTouchEvent(true);
                            if (getArgs()) {
                                z = true;
                            }
                        }
                    }
                } else if (actionMasked2 == 3) {
                    o();
                }
                z = false;
            } else {
                z = false;
            }
            if (z) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                view2.onTouchEvent(motionEventObtain);
                motionEventObtain.recycle();
            }
        }
        this.l = z;
        return z || z2;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.l = false;
        this.m = -1;
        bcx bcxVar = this.j;
        if (bcxVar != null) {
            this.i.removeCallbacks(bcxVar);
        }
    }
}
