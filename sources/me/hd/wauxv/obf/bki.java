package me.hd.wauxv.obf;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class bki extends ers {
    public int aa;
    public int ab;
    public VelocityTracker ac;
    public bkh w;
    public OverScroller x;
    public boolean y;
    public int z;

    public final void ad(CoordinatorLayout coordinatorLayout, View view, int i) {
        r(coordinatorLayout, view, i, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public abstract int q();

    public abstract int r(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3);

    /* JADX WARN: Found duplicated region for block: B:21:0x0048 A[MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:35:0x007f  */
    /* JADX WARN: Found duplicated region for block: B:37:0x008b  */
    /* JADX WARN: Found duplicated region for block: B:46:0x00a5  */
    @Override // me.hd.wauxv.obf.agr
    public final boolean t(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        VelocityTracker velocityTracker;
        int y;
        boolean z;
        OverScroller overScroller;
        View view2;
        int iFindPointerIndex;
        if (this.ab < 0) {
            this.ab = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getActionMasked() == 2 && this.y) {
            int i = this.z;
            if (i != -1 && (iFindPointerIndex = motionEvent.findPointerIndex(i)) != -1) {
                int y2 = (int) motionEvent.getY(iFindPointerIndex);
                if (Math.abs(y2 - this.aa) > this.ab) {
                    this.aa = y2;
                    return true;
                }
                if (motionEvent.getActionMasked() == 0) {
                    this.z = -1;
                    int x = (int) motionEvent.getX();
                    y = (int) motionEvent.getY();
                    WeakReference weakReference = ((AppBarLayout.BaseBehavior) this)._m;
                    if (weakReference == null) {
                    }
                    this.y = z;
                    if (z) {
                        this.aa = y;
                        this.z = motionEvent.getPointerId(0);
                        if (this.ac == null) {
                            this.ac = VelocityTracker.obtain();
                        }
                        overScroller = this.x;
                        if (overScroller != null) {
                            this.x.abortAnimation();
                            return true;
                        }
                    }
                }
                velocityTracker = this.ac;
                if (velocityTracker != null) {
                    velocityTracker.addMovement(motionEvent);
                }
            }
        } else {
            if (motionEvent.getActionMasked() == 0) {
                this.z = -1;
                int x2 = (int) motionEvent.getX();
                y = (int) motionEvent.getY();
                WeakReference weakReference2 = ((AppBarLayout.BaseBehavior) this)._m;
                z = !(weakReference2 == null && ((view2 = (View) weakReference2.get()) == null || !view2.isShown() || view2.canScrollVertically(-1))) && coordinatorLayout.ao(view, x2, y);
                this.y = z;
                if (z) {
                    this.aa = y;
                    this.z = motionEvent.getPointerId(0);
                    if (this.ac == null) {
                        this.ac = VelocityTracker.obtain();
                    }
                    overScroller = this.x;
                    if (overScroller != null && !overScroller.isFinished()) {
                        this.x.abortAnimation();
                        return true;
                    }
                }
            }
            velocityTracker = this.ac;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
        }
        return false;
    }

    /* JADX WARN: Found duplicated region for block: B:39:0x00ec  */
    /* JADX WARN: Found duplicated region for block: B:42:0x00f5  */
    /* JADX WARN: Found duplicated region for block: B:45:0x00fc A[ADDED_TO_REGION] */
    @Override // me.hd.wauxv.obf.agr
    public final boolean u(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        boolean z;
        VelocityTracker velocityTracker;
        VelocityTracker velocityTracker2;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.z);
                if (iFindPointerIndex != -1) {
                    int y = (int) motionEvent.getY(iFindPointerIndex);
                    int i = this.aa - y;
                    this.aa = y;
                    AppBarLayout appBarLayout = (AppBarLayout) view;
                    r(coordinatorLayout, view, q() - i, appBarLayout.getTopInset() + (-appBarLayout.getDownNestedScrollRange()), 0);
                }
            }
            if (actionMasked != 3) {
                if (actionMasked == 6) {
                    int i2 = motionEvent.getActionIndex() == 0 ? 1 : 0;
                    this.z = motionEvent.getPointerId(i2);
                    this.aa = (int) (motionEvent.getY(i2) + 0.5f);
                }
            }
            z = false;
            velocityTracker2 = this.ac;
            if (velocityTracker2 != null) {
                velocityTracker2.addMovement(motionEvent);
            }
            return !this.y || z;
        }
        VelocityTracker velocityTracker3 = this.ac;
        if (velocityTracker3 != null) {
            velocityTracker3.addMovement(motionEvent);
            this.ac.computeCurrentVelocity(1000);
            float yVelocity = this.ac.getYVelocity(this.z);
            AppBarLayout appBarLayout2 = (AppBarLayout) view;
            int i3 = -appBarLayout2.getTotalScrollRange();
            Runnable runnable = this.w;
            if (runnable != null) {
                view.removeCallbacks(runnable);
                this.w = null;
            }
            if (this.x == null) {
                this.x = new OverScroller(view.getContext());
            }
            this.x.fling(0, ag(), 0, Math.round(yVelocity), 0, 0, i3, 0);
            if (this.x.computeScrollOffset()) {
                bkh bkhVar = new bkh(this, coordinatorLayout, view);
                this.w = bkhVar;
                WeakHashMap weakHashMap = ViewCompat.a;
                view.postOnAnimation(bkhVar);
            } else {
                ((AppBarLayout.BaseBehavior) this).v(coordinatorLayout, appBarLayout2);
                if (appBarLayout2.m) {
                    appBarLayout2.af(appBarLayout2.ag(AppBarLayout.BaseBehavior.g(coordinatorLayout)));
                }
            }
            z = true;
        }
        this.y = false;
        this.z = -1;
        velocityTracker = this.ac;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.ac = null;
        }
        velocityTracker2 = this.ac;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(motionEvent);
        }
        if (this.y) {
        }
        z = false;
        this.y = false;
        this.z = -1;
        velocityTracker = this.ac;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.ac = null;
        }
        velocityTracker2 = this.ac;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(motionEvent);
        }
        if (this.y) {
        }
    }
}
