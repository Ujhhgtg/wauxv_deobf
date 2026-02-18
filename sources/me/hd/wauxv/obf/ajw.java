package me.hd.wauxv.obf;

import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ajw extends il {
    public final float a;
    public final Rect b;

    public ajw(Context context, float f) {
        super(context);
        this.a = f;
        this.b = new Rect();
    }

    private final Rect getDecreasedHitRect() {
        float width = getWidth();
        float f = this.a;
        float f2 = (width - f) / 2.0f;
        float height = (getHeight() - f) / 2.0f;
        Rect rect = this.b;
        rect.set((int) f2, (int) height, (int) (getWidth() - f2), (int) (getHeight() - height));
        return rect;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        throwIfVar1IsNull(motionEvent, "ev");
        if (motionEvent.getAction() != 0
                || getDecreasedHitRect().contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }
}
