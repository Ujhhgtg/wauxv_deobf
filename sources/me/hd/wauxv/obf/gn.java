package me.hd.wauxv.obf;

import android.window.BackEvent;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class gn {
    public static final gn a = new gn();

    public final BackEvent b(float f, float f2, float f3, int i) {
        return new BackEvent(f, f2, f3, i);
    }

    public final float c(BackEvent backEvent) {
        throwIfVar1IsNull(backEvent, "backEvent");
        return backEvent.getProgress();
    }

    public final int d(BackEvent backEvent) {
        throwIfVar1IsNull(backEvent, "backEvent");
        return backEvent.getSwipeEdge();
    }

    public final float e(BackEvent backEvent) {
        throwIfVar1IsNull(backEvent, "backEvent");
        return backEvent.getTouchX();
    }

    public final float f(BackEvent backEvent) {
        throwIfVar1IsNull(backEvent, "backEvent");
        return backEvent.getTouchY();
    }
}
