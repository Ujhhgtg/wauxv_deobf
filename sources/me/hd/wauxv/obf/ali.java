package me.hd.wauxv.obf;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ali extends AnimatorListenerAdapter {
    public final /* synthetic */ ViewGroup a;
    public final /* synthetic */ View b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ dlr d;
    public final /* synthetic */ alj e;

    public ali(ViewGroup viewGroup, View view, boolean z, dlr dlrVar, alj aljVar) {
        this.a = viewGroup;
        this.b = view;
        this.c = z;
        this.d = dlrVar;
        this.e = aljVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        bzo.q(animator, "anim");
        ViewGroup viewGroup = this.a;
        View view = this.b;
        viewGroup.endViewTransition(view);
        boolean z = this.c;
        dlr dlrVar = this.d;
        if (z) {
            int i = dlrVar.a;
            bzo.p(view, "viewToAnimate");
            bjs.a(i, view, viewGroup);
        }
        alj aljVar = this.e;
        ((dlr) aljVar.a.g).o(aljVar);
        if (beg.ar(2)) {
            Log.v("FragmentManager", "Animator from operation " + dlrVar + " has ended.");
        }
    }
}
