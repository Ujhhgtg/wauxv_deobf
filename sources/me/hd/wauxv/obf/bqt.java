package me.hd.wauxv.obf;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bqt implements czk {
    public final /* synthetic */ bqx a;

    public bqt(bqx bqxVar) {
        this.a = bqxVar;
    }

    @Override // me.hd.wauxv.obf.czk
    public final void ag(MotionEvent motionEvent) {
        bqx bqxVar = this.a;
        dc dcVar = bqxVar.t;
        bqxVar.y.onTouchEvent(motionEvent);
        VelocityTracker velocityTracker = bqxVar.u;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        if (bqxVar.m == -1) {
            return;
        }
        int actionMasked = motionEvent.getActionMasked();
        int iFindPointerIndex = motionEvent.findPointerIndex(bqxVar.m);
        if (iFindPointerIndex >= 0) {
            bqxVar.aj(actionMasked, iFindPointerIndex, motionEvent);
        }
        SomeView someViewVar = bqxVar.d;
        if (someViewVar == null) {
            return;
        }
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                if (iFindPointerIndex >= 0) {
                    bqxVar.ar(bqxVar.p, iFindPointerIndex, motionEvent);
                    bqxVar.ao(someViewVar);
                    bqxVar.s.removeCallbacks(dcVar);
                    dcVar.run();
                    bqxVar.s.invalidate();
                    return;
                }
                return;
            }
            if (actionMasked != 3) {
                if (actionMasked != 6) {
                    return;
                }
                int actionIndex = motionEvent.getActionIndex();
                if (motionEvent.getPointerId(actionIndex) == bqxVar.m) {
                    bqxVar.m = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
                    bqxVar.ar(bqxVar.p, actionIndex, motionEvent);
                    return;
                }
                return;
            }
            VelocityTracker velocityTracker2 = bqxVar.u;
            if (velocityTracker2 != null) {
                velocityTracker2.clear();
            }
        }
        bqxVar.aq(null, 0);
        bqxVar.m = -1;
    }

    @Override // me.hd.wauxv.obf.czk
    public final boolean ah(MotionEvent motionEvent) {
        int iFindPointerIndex;
        bqx bqxVar = this.a;
        bqxVar.y.onTouchEvent(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        bqu bquVar = null;
        if (actionMasked == 0) {
            bqxVar.m = motionEvent.getPointerId(0);
            bqxVar.e = motionEvent.getX();
            bqxVar.f = motionEvent.getY();
            VelocityTracker velocityTracker = bqxVar.u;
            if (velocityTracker != null) {
                velocityTracker.recycle();
            }
            bqxVar.u = VelocityTracker.obtain();
            if (bqxVar.d == null) {
                ArrayList arrayList = bqxVar.q;
                if (!arrayList.isEmpty()) {
                    View viewAm = bqxVar.am(motionEvent);
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        bqu bquVar2 = (bqu) arrayList.get(size);
                        if (bquVar2.e.d == viewAm) {
                            bquVar = bquVar2;
                            break;
                        }
                    }
                }
                if (bquVar != null) {
                    SomeView someViewVar = bquVar.e;
                    bqxVar.e -= bquVar.i;
                    bqxVar.f -= bquVar.j;
                    bqxVar.al(someViewVar, true);
                    if (bqxVar.a.remove(someViewVar.d)) {
                        bqxVar.n.getClass();
                        xe.g(someViewVar);
                    }
                    bqxVar.aq(someViewVar, bquVar.f);
                    bqxVar.ar(bqxVar.p, 0, motionEvent);
                }
            }
        } else if (actionMasked == 3 || actionMasked == 1) {
            bqxVar.m = -1;
            bqxVar.aq(null, 0);
        } else {
            int i = bqxVar.m;
            if (i != -1 && (iFindPointerIndex = motionEvent.findPointerIndex(i)) >= 0) {
                bqxVar.aj(actionMasked, iFindPointerIndex, motionEvent);
            }
        }
        VelocityTracker velocityTracker2 = bqxVar.u;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(motionEvent);
        }
        return bqxVar.d != null;
    }

    @Override // me.hd.wauxv.obf.czk
    public final void ai(boolean z) {
        if (z) {
            this.a.aq(null, 0);
        }
    }
}
