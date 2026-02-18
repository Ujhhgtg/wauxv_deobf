package me.hd.wauxv.obf;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class alf implements Animation.AnimationListener {
    public final /* synthetic */ dlr a;
    public final /* synthetic */ ViewGroup b;
    public final /* synthetic */ View c;
    public final /* synthetic */ alg d;

    public alf(dlr dlrVar, ViewGroup viewGroup, View view, alg algVar) {
        this.a = dlrVar;
        this.b = viewGroup;
        this.c = view;
        this.d = algVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        throwIfVar1IsNull(animation, "animation");
        ViewGroup viewGroup = this.b;
        viewGroup.post(new ale(viewGroup, this.c, this.d, 0));
        if (beg.ar(2)) {
            Log.v("FragmentManager", "Animation from operation " + this.a + " has ended.");
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
        throwIfVar1IsNull(animation, "animation");
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
        throwIfVar1IsNull(animation, "animation");
        if (beg.ar(2)) {
            Log.v("FragmentManager", "Animation from operation " + this.a + " has reached onAnimationStart.");
        }
    }
}
