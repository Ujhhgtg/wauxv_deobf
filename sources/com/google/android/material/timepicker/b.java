package com.google.android.material.timepicker;

import android.view.ViewTreeObserver;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ ClockFaceView a;

    public b(ClockFaceView clockFaceView) {
        this.a = clockFaceView;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        ClockFaceView clockFaceView = this.a;
        if (!clockFaceView.isShown()) {
            return true;
        }
        clockFaceView.getViewTreeObserver().removeOnPreDrawListener(this);
        int height = ((clockFaceView.getHeight() / 2) - clockFaceView.w.d) - clockFaceView.ae;
        if (height != clockFaceView.ao) {
            clockFaceView.ao = height;
            clockFaceView.al();
            ClockHandView clockHandView = clockFaceView.w;
            clockHandView.l = clockFaceView.ao;
            clockHandView.invalidate();
        }
        return true;
    }
}
