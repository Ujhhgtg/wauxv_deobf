package me.hd.wauxv.obf;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bcx implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ bcy b;

    public /* synthetic */ bcx(bcy bcyVar, int i) {
        this.a = i;
        this.b = bcyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.a) {
            case 0:
                ViewParent parent = this.b.i.getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                break;
            default:
                bcy bcyVar = this.b;
                bcyVar.o();
                View view = bcyVar.i;
                if (view.isEnabled() && !view.isLongClickable() && bcyVar.getArgs()) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                    view.onTouchEvent(motionEventObtain);
                    motionEventObtain.recycle();
                    bcyVar.l = true;
                    break;
                }
                break;
        }
    }
}
