package me.hd.wauxv.obf;

import android.content.Context;
import android.text.TextPaint;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dqk {
    public float c;
    public float d;
    public final WeakReference f;
    public dqh g;
    public final TextPaint a = new TextPaint(1);
    public final yk b = new yk(this, 1);
    public boolean e = true;

    public dqk(dqj dqjVar) {
        this.f = new WeakReference(null);
        this.f = new WeakReference(dqjVar);
    }

    public final float h(String str) {
        if (!this.e) {
            return this.c;
        }
        i(str);
        return this.c;
    }

    public final void i(String str) {
        TextPaint textPaint = this.a;
        this.c = str == null ? 0.0f : textPaint.measureText((CharSequence) str, 0, str.length());
        this.d = str != null ? Math.abs(textPaint.getFontMetrics().ascent) : 0.0f;
        this.e = false;
    }

    public final void j(dqh dqhVar, Context context) {
        if (this.g != dqhVar) {
            this.g = dqhVar;
            if (dqhVar != null) {
                TextPaint textPaint = this.a;
                yk ykVar = this.b;
                dqhVar.t(context, textPaint, ykVar);
                dqj dqjVar = (dqj) this.f.get();
                if (dqjVar != null) {
                    textPaint.drawableState = dqjVar.getState();
                }
                dqhVar.s(context, textPaint, ykVar);
                this.e = true;
            }
            dqj dqjVar2 = (dqj) this.f.get();
            if (dqjVar2 != null) {
                dqjVar2.n();
                dqjVar2.onStateChange(dqjVar2.getState());
            }
        }
    }
}
