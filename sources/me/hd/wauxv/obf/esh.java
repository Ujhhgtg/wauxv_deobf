package me.hd.wauxv.obf;

import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class esh {
    public Interpolator c;
    public esi d;
    public boolean e;
    public long b = -1;
    public final eks f = new eks(this);
    public final ArrayList a = new ArrayList();

    public final void g() {
        if (this.e) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                ((esg) it.next()).c();
            }
            this.e = false;
        }
    }

    public final void h() {
        View view;
        if (this.e) {
            return;
        }
        for (esg esgVar : this.a) {
            long j = this.b;
            if (j >= 0) {
                esgVar.d(j);
            }
            Interpolator interpolator = this.c;
            if (interpolator != null && (view = (View) esgVar.a.get()) != null) {
                view.animate().setInterpolator(interpolator);
            }
            if (this.d != null) {
                esgVar.e(this.f);
            }
            View view2 = (View) esgVar.a.get();
            if (view2 != null) {
                view2.animate().start();
            }
        }
        this.e = true;
    }
}
