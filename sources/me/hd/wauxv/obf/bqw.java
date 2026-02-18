package me.hd.wauxv.obf;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bqw extends GestureDetector.SimpleOnGestureListener {
    public boolean a = true;
    public final /* synthetic */ bqx b;

    public bqw(bqx bqxVar) {
        this.b = bqxVar;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent motionEvent) {
        View viewAm;
        czx czxVarDv;
        bqx bqxVar = this.b;
        xe xeVar = bqxVar.n;
        if (!this.a || (viewAm = bqxVar.am(motionEvent)) == null || (czxVarDv = bqxVar.s.dv(viewAm)) == null) {
            return;
        }
        RecyclerView recyclerView = bqxVar.s;
        xeVar.getClass();
        if ((xe.h(786444, recyclerView.getLayoutDirection()) & 16711680) != 0) {
            int pointerId = motionEvent.getPointerId(0);
            int i = bqxVar.m;
            if (pointerId == i) {
                int iFindPointerIndex = motionEvent.findPointerIndex(i);
                float x = motionEvent.getX(iFindPointerIndex);
                float y = motionEvent.getY(iFindPointerIndex);
                bqxVar.e = x;
                bqxVar.f = y;
                bqxVar.j = 0.0f;
                bqxVar.i = 0.0f;
                xeVar.getClass();
                bqxVar.aq(czxVarDv, 2);
            }
        }
    }
}
