package me.hd.wauxv.obf;

import android.graphics.Typeface;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dqf extends bht {
    public final /* synthetic */ bhv a;
    public final /* synthetic */ dqh b;

    public dqf(dqh dqhVar, bhv bhvVar) {
        this.b = dqhVar;
        this.a = bhvVar;
    }

    @Override // me.hd.wauxv.obf.bht
    public final void e(int i) {
        this.b.m = true;
        this.a.d(i);
    }

    @Override // me.hd.wauxv.obf.bht
    public final void f(Typeface typeface) {
        dqh dqhVar = this.b;
        dqhVar.n = Typeface.create(typeface, dqhVar.c);
        dqhVar.m = true;
        this.a.e(dqhVar.n, false);
    }
}
