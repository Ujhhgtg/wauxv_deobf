package me.hd.wauxv.obf;

import android.animation.AnimatorSet;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class alj extends dlq {
    public final alh a;
    public AnimatorSet d;

    public alj(alh alhVar) {
        this.a = alhVar;
    }

    @Override // me.hd.wauxv.obf.dlq
    public final void b(ViewGroup viewGroup) {
        bzo.q(viewGroup, "container");
        AnimatorSet animatorSet = this.d;
        alh alhVar = this.a;
        if (animatorSet == null) {
            ((dlr) alhVar.g).o(this);
            return;
        }
        dlr dlrVar = (dlr) alhVar.g;
        if (dlrVar.g) {
            all.a.b(animatorSet);
        } else {
            animatorSet.end();
        }
        if (beg.ar(2)) {
            StringBuilder sb = new StringBuilder("Animator from operation ");
            sb.append(dlrVar);
            sb.append(" has been canceled");
            sb.append(dlrVar.g ? " with seeking." : ".");
            sb.append(' ');
            Log.v("FragmentManager", sb.toString());
        }
    }

    @Override // me.hd.wauxv.obf.dlq
    public final void c(ViewGroup viewGroup) {
        bzo.q(viewGroup, "container");
        dlr dlrVar = (dlr) this.a.g;
        AnimatorSet animatorSet = this.d;
        if (animatorSet == null) {
            dlrVar.o(this);
            return;
        }
        animatorSet.start();
        if (beg.ar(2)) {
            Log.v("FragmentManager", "Animator from operation " + dlrVar + " has started.");
        }
    }

    @Override // me.hd.wauxv.obf.dlq
    public final void e(mt mtVar, ViewGroup viewGroup) {
        bzo.q(mtVar, "backEvent");
        bzo.q(viewGroup, "container");
        dlr dlrVar = (dlr) this.a.g;
        AnimatorSet animatorSet = this.d;
        if (animatorSet == null) {
            dlrVar.o(this);
            return;
        }
        if (Build.VERSION.SDK_INT < 34 || !dlrVar.c.be) {
            return;
        }
        if (beg.ar(2)) {
            Log.v("FragmentManager", "Adding BackProgressCallbacks for Animators to operation " + dlrVar);
        }
        long jB = alk.a.b(animatorSet);
        long j = (long) (mtVar.c * jB);
        if (j == 0) {
            j = 1;
        }
        if (j == jB) {
            j = jB - 1;
        }
        if (beg.ar(2)) {
            Log.v("FragmentManager", "Setting currentPlayTime to " + j + " for Animator " + animatorSet + " on operation " + dlrVar);
        }
        all.a.c(animatorSet, j);
    }

    @Override // me.hd.wauxv.obf.dlq
    public final void f(ViewGroup viewGroup) {
        alj aljVar;
        bzo.q(viewGroup, "container");
        alh alhVar = this.a;
        if (alhVar.h()) {
            return;
        }
        Context context = viewGroup.getContext();
        bzo.p(context, com.umeng.analytics.pro.f.X);
        io ioVarJ = alhVar.j(context);
        this.d = ioVarJ != null ? (AnimatorSet) ioVarJ.d : null;
        dlr dlrVar = (dlr) alhVar.g;
        bdj bdjVar = dlrVar.c;
        boolean z = dlrVar.a == 3;
        View view = bdjVar.bz;
        viewGroup.startViewTransition(view);
        AnimatorSet animatorSet = this.d;
        if (animatorSet != null) {
            aljVar = this;
            animatorSet.addListener(new ali(viewGroup, view, z, dlrVar, aljVar));
        } else {
            aljVar = this;
        }
        AnimatorSet animatorSet2 = aljVar.d;
        if (animatorSet2 != null) {
            animatorSet2.setTarget(view);
        }
    }
}
