package me.hd.wauxv.obf;

import android.os.Handler;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cvt implements bup {
    public static final cvt a = new cvt();
    public int b;
    public int c;
    public Handler f;
    public boolean d = true;
    public boolean e = true;
    public final bur g = new bur(this);
    public final dh h = new dh(this, 15);
    public final bmu i = new bmu(this);

    @Override // me.hd.wauxv.obf.bup
    public final bur ap() {
        return this.g;
    }

    public final void j() {
        int i = this.c + 1;
        this.c = i;
        if (i == 1) {
            if (this.d) {
                this.g.m(bug.ON_RESUME);
                this.d = false;
            } else {
                Handler handler = this.f;
                bzo.n(handler);
                handler.removeCallbacks(this.h);
            }
        }
    }
}
