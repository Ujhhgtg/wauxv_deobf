package me.hd.wauxv.obf;

import android.util.Log;
import android.view.animation.Interpolator;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class czr {
    public int a;
    public int b;
    public int c;
    public int d;
    public Interpolator e;
    public boolean f;
    public int g;

    public final void h(RecyclerView recyclerView) {
        int i = this.d;
        if (i >= 0) {
            this.d = -1;
            recyclerView.dz(i);
            this.f = false;
            return;
        }
        if (!this.f) {
            this.g = 0;
            return;
        }
        Interpolator interpolator = this.e;
        if (interpolator != null && this.c < 1) {
            throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
        }
        int i2 = this.c;
        if (i2 < 1) {
            throw new IllegalStateException("Scroll duration must be a positive number");
        }
        recyclerView.bl.j(this.a, this.b, i2, interpolator);
        int i3 = this.g + 1;
        this.g = i3;
        if (i3 > 10) {
            Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
        }
        this.f = false;
    }
}
