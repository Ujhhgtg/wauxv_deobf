package me.hd.wauxv.obf;

import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ace implements ViewTreeObserver.OnDrawListener, Runnable, Executor {
    public final long a = SystemClock.uptimeMillis() + ((long) 10000);
    public Runnable b;
    public boolean c;
    public final /* synthetic */ hb d;

    public ace(hb hbVar) {
        this.d = hbVar;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        throwIfVar1IsNull(runnable, "runnable");
        this.b = runnable;
        View decorView = this.d.getWindow().getDecorView();
        throwIfVar1IsNull(decorView, "window.decorView");
        if (!this.c) {
            decorView.postOnAnimation(new dh(this, 4));
        } else if (nullSafeIsEqual(Looper.myLooper(), Looper.getMainLooper())) {
            decorView.invalidate();
        } else {
            decorView.postInvalidate();
        }
    }

    @Override // android.view.ViewTreeObserver.OnDrawListener
    public final void onDraw() {
        boolean z;
        Runnable runnable = this.b;
        if (runnable == null) {
            if (SystemClock.uptimeMillis() > this.a) {
                this.c = false;
                this.d.getWindow().getDecorView().post(this);
                return;
            }
            return;
        }
        runnable.run();
        this.b = null;
        bft bftVar = (bft) this.d.w.getValue();
        synchronized (bftVar.a) {
            z = bftVar.b;
        }
        if (z) {
            this.c = false;
            this.d.getWindow().getDecorView().post(this);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.d.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
    }
}
