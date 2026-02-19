package me.hd.wauxv.obf;

import android.graphics.Typeface;
import android.os.Build;
import android.widget.TextView;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class jg extends ResourcesCompat {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ WeakReference c;
    public final /* synthetic */ jl d;

    public jg(jl jlVar, int i, int i2, WeakReference weakReference) {
        this.d = jlVar;
        this.a = i;
        this.b = i2;
        this.c = weakReference;
    }

    @Override // me.hd.wauxv.obf.bht
    public final void e(int i) {
    }

    @Override // me.hd.wauxv.obf.bht
    public final void f(Typeface typeface) {
        int i;
        if (Build.VERSION.SDK_INT >= 28 && (i = this.a) != -1) {
            typeface = jk.a(typeface, i, (this.b & 2) != 0);
        }
        jl jlVar = this.d;
        if (jlVar.m) {
            jlVar.l = typeface;
            TextView textView = (TextView) this.c.get();
            if (textView != null) {
                if (textView.isAttachedToWindow()) {
                    textView.post(new jh(textView, typeface, jlVar.j));
                } else {
                    textView.setTypeface(typeface, jlVar.j);
                }
            }
        }
    }
}
