package me.hd.wauxv.obf;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class alg extends dlq {
    public final alh a;

    public alg(alh alhVar) {
        this.a = alhVar;
    }

    @Override // me.hd.wauxv.obf.dlq
    public final void b(ViewGroup viewGroup) {
        bzo.q(viewGroup, "container");
        alh alhVar = this.a;
        dlr dlrVar = (dlr) alhVar.g;
        View view = dlrVar.c.bz;
        view.clearAnimation();
        viewGroup.endViewTransition(view);
        ((dlr) alhVar.g).o(this);
        if (beg.ar(2)) {
            Log.v("FragmentManager", "Animation from operation " + dlrVar + " has been cancelled.");
        }
    }

    @Override // me.hd.wauxv.obf.dlq
    public final void c(ViewGroup viewGroup) {
        bzo.q(viewGroup, "container");
        alh alhVar = this.a;
        dlr dlrVar = (dlr) alhVar.g;
        if (alhVar.h()) {
            dlrVar.o(this);
            return;
        }
        Context context = viewGroup.getContext();
        View view = dlrVar.c.bz;
        bzo.p(context, com.umeng.analytics.pro.f.X);
        io ioVarJ = alhVar.j(context);
        if (ioVarJ == null) {
            throw new IllegalStateException("Required value was null.");
        }
        Animation animation = (Animation) ioVarJ.c;
        if (animation == null) {
            throw new IllegalStateException("Required value was null.");
        }
        if (dlrVar.a != 1) {
            view.startAnimation(animation);
            dlrVar.o(this);
            return;
        }
        viewGroup.startViewTransition(view);
        bdn bdnVar = new bdn(animation, viewGroup, view);
        bdnVar.setAnimationListener(new alf(dlrVar, viewGroup, view, this));
        view.startAnimation(bdnVar);
        if (beg.ar(2)) {
            Log.v("FragmentManager", "Animation from operation " + dlrVar + " has started.");
        }
    }
}
