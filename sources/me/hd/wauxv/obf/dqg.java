package me.hd.wauxv.obf;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dqg extends bhv {
    public final /* synthetic */ bhv ap;
    public final /* synthetic */ dqh aq;
    public final /* synthetic */ Context b;
    public final /* synthetic */ TextPaint c;

    public dqg(dqh dqhVar, Context context, TextPaint textPaint, bhv bhvVar) {
        this.aq = dqhVar;
        this.b = context;
        this.c = textPaint;
        this.ap = bhvVar;
    }

    @Override // me.hd.wauxv.obf.bhv
    public final void d(int i) {
        this.ap.d(i);
    }

    @Override // me.hd.wauxv.obf.bhv
    public final void e(Typeface typeface, boolean z) {
        this.aq.u(this.b, this.c, typeface);
        this.ap.e(typeface, z);
    }
}
