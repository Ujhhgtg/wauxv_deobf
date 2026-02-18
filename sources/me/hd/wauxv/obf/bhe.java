package me.hd.wauxv.obf;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bhe implements dpw {
    public final int a;
    public final int b;
    public dbs c;
    public final Handler d;
    public final int e;
    public final long f;
    public Bitmap g;

    public bhe(Handler handler, int i, long j) {
        if (!eot.l(Integer.MIN_VALUE, Integer.MIN_VALUE)) {
            throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: -2147483648 and height: -2147483648");
        }
        this.a = Integer.MIN_VALUE;
        this.b = Integer.MIN_VALUE;
        this.d = handler;
        this.e = i;
        this.f = j;
    }

    @Override // me.hd.wauxv.obf.dpw
    public final void h(dbs dbsVar) {
        this.c = dbsVar;
    }

    @Override // me.hd.wauxv.obf.dpw
    public final void i(Object obj) {
        this.g = (Bitmap) obj;
        Handler handler = this.d;
        handler.sendMessageAtTime(handler.obtainMessage(1, this), this.f);
    }

    @Override // me.hd.wauxv.obf.bun
    public final void j() {
    }

    @Override // me.hd.wauxv.obf.dpw
    public final void k(dht dhtVar) {
    }

    @Override // me.hd.wauxv.obf.dpw
    public final void l(Drawable drawable) {
    }

    @Override // me.hd.wauxv.obf.bun
    public final void m() {
    }

    @Override // me.hd.wauxv.obf.dpw
    public final void n(Drawable drawable) {
    }

    @Override // me.hd.wauxv.obf.dpw
    public final dbs o() {
        return this.c;
    }

    @Override // me.hd.wauxv.obf.dpw
    public final void p(Drawable drawable) {
        this.g = null;
    }

    @Override // me.hd.wauxv.obf.bun
    public final void q() {
    }

    @Override // me.hd.wauxv.obf.dpw
    public final void r(dht dhtVar) throws Throwable {
        dhtVar.ao(this.a, this.b);
    }
}
