package me.hd.wauxv.obf;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.util.Arrays;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class era {
    public static final bqv a = new bqv(3);
    public int b;
    public final int c;
    public float[] e;
    public float[] f;
    public float[] g;
    public float[] h;
    public int[] i;
    public int[] j;
    public int[] k;
    public int l;
    public VelocityTracker m;
    public final float n;
    public final float o;
    public final int p;
    public final OverScroller q;
    public final cnf r;
    public View s;
    public boolean t;
    public final CoordinatorLayout u;
    public int d = -1;
    public final dc v = new dc(this, 19);

    public era(Context context, CoordinatorLayout coordinatorLayout, cnf cnfVar) {
        if (cnfVar == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        this.u = coordinatorLayout;
        this.r = cnfVar;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.p = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.c = viewConfiguration.getScaledTouchSlop();
        this.n = viewConfiguration.getScaledMaximumFlingVelocity();
        this.o = viewConfiguration.getScaledMinimumFlingVelocity();
        this.q = new OverScroller(context, a);
    }

    public final int aa(int i, int i2, int i3) {
        if (i == 0) {
            return 0;
        }
        float width = this.u.getWidth() / 2;
        float fSin = (((float) Math.sin((Math.min(1.0f, Math.abs(i) / r0) - 0.5f) * 0.47123894f)) * width) + width;
        int iAbs = Math.abs(i2);
        return Math.min(iAbs > 0 ? Math.round(Math.abs(fSin / iAbs) * 1000.0f) * 4 : (int) (((Math.abs(i) / i3) + 1.0f) * 256.0f), 600);
    }

    public final boolean ab() {
        if (this.b == 2) {
            OverScroller overScroller = this.q;
            boolean zComputeScrollOffset = overScroller.computeScrollOffset();
            int currX = overScroller.getCurrX();
            int currY = overScroller.getCurrY();
            int left = currX - this.s.getLeft();
            int top = currY - this.s.getTop();
            if (left != 0) {
                View view = this.s;
                WeakHashMap weakHashMap = eqz.a;
                view.offsetLeftAndRight(left);
            }
            if (top != 0) {
                View view2 = this.s;
                WeakHashMap weakHashMap2 = eqz.a;
                view2.offsetTopAndBottom(top);
            }
            if (left != 0 || top != 0) {
                this.r.h(this.s, currX, currY);
            }
            if (zComputeScrollOffset && currX == overScroller.getFinalX() && currY == overScroller.getFinalY()) {
                overScroller.abortAnimation();
                zComputeScrollOffset = false;
            }
            if (!zComputeScrollOffset) {
                this.u.post(this.v);
            }
        }
        return this.b == 2;
    }

    public final View ac(int i, int i2) {
        CoordinatorLayout coordinatorLayout = this.u;
        for (int childCount = coordinatorLayout.getChildCount() - 1; childCount >= 0; childCount--) {
            this.r.getClass();
            View childAt = coordinatorLayout.getChildAt(childCount);
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public final boolean ad(int i, int i2, int i3, int i4) {
        float f;
        float f2;
        float f3;
        float f4;
        int left = this.s.getLeft();
        int top = this.s.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        OverScroller overScroller = this.q;
        if (i5 == 0 && i6 == 0) {
            overScroller.abortAnimation();
            aj(0);
            return false;
        }
        View view = this.s;
        int i7 = (int) this.o;
        int i8 = (int) this.n;
        int iAbs = Math.abs(i3);
        if (iAbs < i7) {
            i3 = 0;
        } else if (iAbs > i8) {
            i3 = i3 > 0 ? i8 : -i8;
        }
        int iAbs2 = Math.abs(i4);
        if (iAbs2 < i7) {
            i4 = 0;
        } else if (iAbs2 > i8) {
            i4 = i4 > 0 ? i8 : -i8;
        }
        int iAbs3 = Math.abs(i5);
        int iAbs4 = Math.abs(i6);
        int iAbs5 = Math.abs(i3);
        int iAbs6 = Math.abs(i4);
        int i9 = iAbs5 + iAbs6;
        int i10 = iAbs3 + iAbs4;
        if (i3 != 0) {
            f = iAbs5;
            f2 = i9;
        } else {
            f = iAbs3;
            f2 = i10;
        }
        float f5 = f / f2;
        if (i4 != 0) {
            f3 = iAbs6;
            f4 = i9;
        } else {
            f3 = iAbs4;
            f4 = i10;
        }
        float f6 = f3 / f4;
        cnf cnfVar = this.r;
        overScroller.startScroll(left, top, i5, i6, (int) ((aa(i6, i4, cnfVar.f()) * f6) + (aa(i5, i3, cnfVar.e(view)) * f5)));
        aj(2);
        return true;
    }

    public final boolean ae(int i) {
        if ((this.l & (1 << i)) != 0) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    public final void af(MotionEvent motionEvent) {
        int i;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            w();
        }
        if (this.m == null) {
            this.m = VelocityTracker.obtain();
        }
        this.m.addMovement(motionEvent);
        int i2 = 0;
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View viewAc = ac((int) x, (int) y);
            ah(x, y, pointerId);
            am(viewAc, pointerId);
            int i3 = this.i[pointerId];
            return;
        }
        if (actionMasked == 1) {
            if (this.b == 1) {
                ag();
            }
            w();
            return;
        }
        cnf cnfVar = this.r;
        if (actionMasked != 2) {
            if (actionMasked == 3) {
                if (this.b == 1) {
                    this.t = true;
                    cnfVar.i(this.s, 0.0f, 0.0f);
                    this.t = false;
                    if (this.b == 1) {
                        aj(0);
                    }
                }
                w();
                return;
            }
            if (actionMasked == 5) {
                int pointerId2 = motionEvent.getPointerId(actionIndex);
                float x2 = motionEvent.getX(actionIndex);
                float y2 = motionEvent.getY(actionIndex);
                ah(x2, y2, pointerId2);
                if (this.b == 0) {
                    am(ac((int) x2, (int) y2), pointerId2);
                    int i4 = this.i[pointerId2];
                    return;
                }
                int i5 = (int) x2;
                int i6 = (int) y2;
                View view = this.s;
                if (view != null && i5 >= view.getLeft() && i5 < view.getRight() && i6 >= view.getTop() && i6 < view.getBottom()) {
                    i2 = 1;
                }
                if (i2 != 0) {
                    am(this.s, pointerId2);
                    return;
                }
                return;
            }
            if (actionMasked != 6) {
                return;
            }
            int pointerId3 = motionEvent.getPointerId(actionIndex);
            if (this.b == 1 && pointerId3 == this.d) {
                int pointerCount = motionEvent.getPointerCount();
                while (true) {
                    if (i2 >= pointerCount) {
                        i = -1;
                        break;
                    }
                    int pointerId4 = motionEvent.getPointerId(i2);
                    if (pointerId4 != this.d) {
                        View viewAc2 = ac((int) motionEvent.getX(i2), (int) motionEvent.getY(i2));
                        View view2 = this.s;
                        if (viewAc2 == view2 && am(view2, pointerId4)) {
                            i = this.d;
                            break;
                        }
                    }
                    i2++;
                }
                if (i == -1) {
                    ag();
                }
            }
            z(pointerId3);
            return;
        }
        if (this.b == 1) {
            if (ae(this.d)) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.d);
                float x3 = motionEvent.getX(iFindPointerIndex);
                float y3 = motionEvent.getY(iFindPointerIndex);
                float[] fArr = this.g;
                int i7 = this.d;
                int i8 = (int) (x3 - fArr[i7]);
                int i9 = (int) (y3 - this.h[i7]);
                int left = this.s.getLeft() + i8;
                int top = this.s.getTop() + i9;
                int left2 = this.s.getLeft();
                int top2 = this.s.getTop();
                if (i8 != 0) {
                    left = cnfVar.c(this.s, left);
                    WeakHashMap weakHashMap = eqz.a;
                    this.s.offsetLeftAndRight(left - left2);
                }
                if (i9 != 0) {
                    top = cnfVar.d(this.s, top);
                    WeakHashMap weakHashMap2 = eqz.a;
                    this.s.offsetTopAndBottom(top - top2);
                }
                if (i8 != 0 || i9 != 0) {
                    cnfVar.h(this.s, left, top);
                }
                ai(motionEvent);
                return;
            }
            return;
        }
        int pointerCount2 = motionEvent.getPointerCount();
        while (i2 < pointerCount2) {
            int pointerId5 = motionEvent.getPointerId(i2);
            if (ae(pointerId5)) {
                float x4 = motionEvent.getX(i2);
                float y4 = motionEvent.getY(i2);
                float f = x4 - this.e[pointerId5];
                float f2 = y4 - this.f[pointerId5];
                Math.abs(f);
                Math.abs(f2);
                int i10 = this.i[pointerId5];
                Math.abs(f2);
                Math.abs(f);
                int i11 = this.i[pointerId5];
                Math.abs(f);
                Math.abs(f2);
                int i12 = this.i[pointerId5];
                Math.abs(f2);
                Math.abs(f);
                int i13 = this.i[pointerId5];
                if (this.b != 1) {
                    View viewAc3 = ac((int) x4, (int) y4);
                    if (y(viewAc3, f, f2) && am(viewAc3, pointerId5)) {
                        break;
                    }
                } else {
                    break;
                }
            }
            i2++;
        }
        ai(motionEvent);
    }

    public final void ag() {
        VelocityTracker velocityTracker = this.m;
        float f = this.n;
        velocityTracker.computeCurrentVelocity(1000, f);
        float xVelocity = this.m.getXVelocity(this.d);
        float fAbs = Math.abs(xVelocity);
        float f2 = this.o;
        if (fAbs < f2) {
            xVelocity = 0.0f;
        } else if (fAbs > f) {
            xVelocity = xVelocity > 0.0f ? f : -f;
        }
        float yVelocity = this.m.getYVelocity(this.d);
        float fAbs2 = Math.abs(yVelocity);
        if (fAbs2 < f2) {
            f = 0.0f;
        } else if (fAbs2 <= f) {
            f = yVelocity;
        } else if (yVelocity <= 0.0f) {
            f = -f;
        }
        this.t = true;
        this.r.i(this.s, xVelocity, f);
        this.t = false;
        if (this.b == 1) {
            aj(0);
        }
    }

    public final void ah(float f, float f2, int i) {
        float[] fArr = this.e;
        if (fArr == null || fArr.length <= i) {
            int i2 = i + 1;
            float[] fArr2 = new float[i2];
            float[] fArr3 = new float[i2];
            float[] fArr4 = new float[i2];
            float[] fArr5 = new float[i2];
            int[] iArr = new int[i2];
            int[] iArr2 = new int[i2];
            int[] iArr3 = new int[i2];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.f;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.g;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.h;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.i;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.j;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.k;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.e = fArr2;
            this.f = fArr3;
            this.g = fArr4;
            this.h = fArr5;
            this.i = iArr;
            this.j = iArr2;
            this.k = iArr3;
        }
        float[] fArr9 = this.e;
        this.g[i] = f;
        fArr9[i] = f;
        float[] fArr10 = this.f;
        this.h[i] = f2;
        fArr10[i] = f2;
        int[] iArr7 = this.i;
        int i3 = (int) f;
        int i4 = (int) f2;
        CoordinatorLayout coordinatorLayout = this.u;
        int left = coordinatorLayout.getLeft();
        int i5 = this.p;
        int i6 = i3 < left + i5 ? 1 : 0;
        if (i4 < coordinatorLayout.getTop() + i5) {
            i6 |= 4;
        }
        if (i3 > coordinatorLayout.getRight() - i5) {
            i6 |= 2;
        }
        if (i4 > coordinatorLayout.getBottom() - i5) {
            i6 |= 8;
        }
        iArr7[i] = i6;
        this.l |= 1 << i;
    }

    public final void ai(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            int pointerId = motionEvent.getPointerId(i);
            if (ae(pointerId)) {
                float x = motionEvent.getX(i);
                float y = motionEvent.getY(i);
                this.g[pointerId] = x;
                this.h[pointerId] = y;
            }
        }
    }

    public final void aj(int i) {
        this.u.removeCallbacks(this.v);
        if (this.b != i) {
            this.b = i;
            this.r.g(i);
            if (this.b == 0) {
                this.s = null;
            }
        }
    }

    public final boolean ak(int i, int i2) {
        if (this.t) {
            return ad(i, i2, (int) this.m.getXVelocity(this.d), (int) this.m.getYVelocity(this.d));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARN: Found duplicated region for block: B:52:0x00d6  */
    /* JADX WARN: Found duplicated region for block: B:61:0x0114  */
    public final boolean al(MotionEvent motionEvent) {
        View viewAc;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            w();
        }
        if (this.m == null) {
            this.m = VelocityTracker.obtain();
        }
        this.m.addMovement(motionEvent);
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            ah(x, y, pointerId);
            View viewAc2 = ac((int) x, (int) y);
            if (viewAc2 == this.s && this.b == 2) {
                am(viewAc2, pointerId);
            }
            int i = this.i[pointerId];
        } else if (actionMasked == 1) {
            w();
        } else if (actionMasked != 2) {
            if (actionMasked == 3) {
                w();
            } else if (actionMasked == 5) {
                int pointerId2 = motionEvent.getPointerId(actionIndex);
                float x2 = motionEvent.getX(actionIndex);
                float y2 = motionEvent.getY(actionIndex);
                ah(x2, y2, pointerId2);
                int i2 = this.b;
                if (i2 == 0) {
                    int i3 = this.i[pointerId2];
                } else if (i2 == 2 && (viewAc = ac((int) x2, (int) y2)) == this.s) {
                    am(viewAc, pointerId2);
                }
            } else if (actionMasked == 6) {
                z(motionEvent.getPointerId(actionIndex));
            }
        } else if (this.e != null && this.f != null) {
            int pointerCount = motionEvent.getPointerCount();
            for (int i4 = 0; i4 < pointerCount; i4++) {
                int pointerId3 = motionEvent.getPointerId(i4);
                if (ae(pointerId3)) {
                    float x3 = motionEvent.getX(i4);
                    float y3 = motionEvent.getY(i4);
                    float f = x3 - this.e[pointerId3];
                    float f2 = y3 - this.f[pointerId3];
                    View viewAc3 = ac((int) x3, (int) y3);
                    boolean z = viewAc3 != null && y(viewAc3, f, f2);
                    if (!z) {
                        Math.abs(f);
                        Math.abs(f2);
                        int i5 = this.i[pointerId3];
                        Math.abs(f2);
                        Math.abs(f);
                        int i6 = this.i[pointerId3];
                        Math.abs(f);
                        Math.abs(f2);
                        int i7 = this.i[pointerId3];
                        Math.abs(f2);
                        Math.abs(f);
                        int i8 = this.i[pointerId3];
                        if (this.b != 1) {
                            break;
                        }
                    } else {
                        int left = viewAc3.getLeft();
                        cnf cnfVar = this.r;
                        int iC = cnfVar.c(viewAc3, ((int) f) + left);
                        int top = viewAc3.getTop();
                        int iD = cnfVar.d(viewAc3, ((int) f2) + top);
                        int iE = cnfVar.e(viewAc3);
                        int iF = cnfVar.f();
                        if ((iE == 0 || (iE > 0 && iC == left)) && (iF == 0 || (iF > 0 && iD == top))) {
                            break;
                        }
                        Math.abs(f);
                        Math.abs(f2);
                        int i52 = this.i[pointerId3];
                        Math.abs(f2);
                        Math.abs(f);
                        int i62 = this.i[pointerId3];
                        Math.abs(f);
                        Math.abs(f2);
                        int i72 = this.i[pointerId3];
                        Math.abs(f2);
                        Math.abs(f);
                        int i82 = this.i[pointerId3];
                        if (this.b != 1 || (z && am(viewAc3, pointerId3))) {
                            break;
                        }
                    }
                }
            }
            ai(motionEvent);
        }
        return this.b == 1;
    }

    public final boolean am(View view, int i) {
        if (view == this.s && this.d == i) {
            return true;
        }
        if (view == null || !this.r.j(view, i)) {
            return false;
        }
        this.d = i;
        x(view, i);
        return true;
    }

    public final void w() {
        this.d = -1;
        float[] fArr = this.e;
        if (fArr != null) {
            Arrays.fill(fArr, 0.0f);
            Arrays.fill(this.f, 0.0f);
            Arrays.fill(this.g, 0.0f);
            Arrays.fill(this.h, 0.0f);
            Arrays.fill(this.i, 0);
            Arrays.fill(this.j, 0);
            Arrays.fill(this.k, 0);
            this.l = 0;
        }
        VelocityTracker velocityTracker = this.m;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.m = null;
        }
    }

    public final void x(View view, int i) {
        ViewParent parent = view.getParent();
        CoordinatorLayout coordinatorLayout = this.u;
        if (parent != coordinatorLayout) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + coordinatorLayout + ")");
        }
        this.s = view;
        this.d = i;
        this.r.bp(view, i);
        aj(1);
    }

    /* JADX WARN: Found duplicated region for block: B:25:0x0044 A[RETURN] */
    public final boolean y(View view, float f, float f2) {
        if (view != null) {
            cnf cnfVar = this.r;
            boolean z = cnfVar.e(view) > 0;
            boolean z2 = cnfVar.f() > 0;
            if (z && z2) {
                float f3 = (f2 * f2) + (f * f);
                int i = this.c;
                if (f3 > i * i) {
                    return true;
                }
            } else if (!z ? !(!z2 || Math.abs(f2) <= this.c) : Math.abs(f) > this.c) {
                return true;
            }
        }
        return false;
    }

    public final void z(int i) {
        float[] fArr = this.e;
        if (fArr != null) {
            int i2 = this.l;
            int i3 = 1 << i;
            if ((i2 & i3) != 0) {
                fArr[i] = 0.0f;
                this.f[i] = 0.0f;
                this.g[i] = 0.0f;
                this.h[i] = 0.0f;
                this.i[i] = 0;
                this.j[i] = 0;
                this.k[i] = 0;
                this.l = (~i3) & i2;
            }
        }
    }
}
