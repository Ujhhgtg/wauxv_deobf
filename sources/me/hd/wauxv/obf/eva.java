package me.hd.wauxv.obf;

import android.os.Build;
import android.view.animation.Interpolator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class eva {
    public euz a;

    public eva(int i, Interpolator interpolator, long j) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.a = new euy(aw.j(i, interpolator, j));
        } else {
            this.a = new euw(i, interpolator, j);
        }
    }
}
