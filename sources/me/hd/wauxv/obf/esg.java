package me.hd.wauxv.obf;

import android.view.View;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class esg {
    public final WeakReference a;

    public esg(View view) {
        this.a = new WeakReference(view);
    }

    public final void b(float f) {
        View view = (View) this.a.get();
        if (view != null) {
            view.animate().alpha(f);
        }
    }

    public final void c() {
        View view = (View) this.a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public final void d(long j) {
        View view = (View) this.a.get();
        if (view != null) {
            view.animate().setDuration(j);
        }
    }

    public final void e(esi esiVar) {
        View view = (View) this.a.get();
        if (view != null) {
            if (esiVar != null) {
                view.animate().setListener(new ci(esiVar, view));
            } else {
                view.animate().setListener(null);
            }
        }
    }

    public final void f(float f) {
        View view = (View) this.a.get();
        if (view != null) {
            view.animate().translationY(f);
        }
    }
}
