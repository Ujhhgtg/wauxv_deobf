package me.hd.wauxv.obf;

import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bwm implements View.OnTouchListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ bwm(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.a) {
            case 0:
                bwn bwnVar = (bwn) this.b;
                bwj bwjVar = bwnVar.an;
                Handler handler = bwnVar.ar;
                in inVar = bwnVar.av;
                int action = motionEvent.getAction();
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (action == 0 && inVar != null && inVar.isShowing() && x >= 0 && x < inVar.getWidth() && y >= 0 && y < inVar.getHeight()) {
                    handler.postDelayed(bwjVar, 250L);
                    return false;
                }
                if (action != 1) {
                    return false;
                }
                handler.removeCallbacks(bwjVar);
                return false;
            default:
                if (((Checkable) view).isChecked()) {
                    return ((GestureDetector) this.b).onTouchEvent(motionEvent);
                }
                return false;
        }
    }
}
