package com.google.android.material.timepicker;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import me.hd.wauxv.R;
import me.hd.wauxv.obf.aq;
import me.hd.wauxv.obf.ax;
import me.hd.wauxv.obf.bc;
import me.hd.wauxv.obf.bd;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends aq {
    public final /* synthetic */ ClockFaceView a;

    public c(ClockFaceView clockFaceView) {
        this.a = clockFaceView;
    }

    @Override // me.hd.wauxv.obf.aq
    public final void d(View view, bd bdVar) {
        AccessibilityNodeInfo accessibilityNodeInfo = bdVar.a;
        this.g.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        int iIntValue = ((Integer) view.getTag(R.id.material_value_index)).intValue();
        if (iIntValue > 0) {
            accessibilityNodeInfo.setTraversalAfter((View) this.a.aa.get(iIntValue - 1));
        }
        bdVar.l(bc.g(0, 1, iIntValue, 1, view.isSelected()));
        accessibilityNodeInfo.setClickable(true);
        bdVar.e(ax.a);
    }

    @Override // me.hd.wauxv.obf.aq
    public final boolean e(View view, int i, Bundle bundle) {
        if (i != 16) {
            return super.e(view, i, bundle);
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        ClockFaceView clockFaceView = this.a;
        view.getHitRect(clockFaceView.x);
        float fCenterX = clockFaceView.x.centerX();
        float fCenterY = clockFaceView.x.centerY();
        clockFaceView.w.onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 0, fCenterX, fCenterY, 0));
        clockFaceView.w.onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 1, fCenterX, fCenterY, 0));
        return true;
    }
}
