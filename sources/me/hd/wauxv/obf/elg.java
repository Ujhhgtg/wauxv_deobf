package me.hd.wauxv.obf;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class elg extends AnimatorListenerAdapter {
    public final /* synthetic */ int a = 1;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public elg(View view, eva evaVar) {
        this.b = evaVar;
        this.c = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.a) {
            case 0:
                ((ku) this.b).remove(animator);
                ((ell) this.c).at.remove(animator);
                break;
            default:
                eva evaVar = (eva) this.b;
                evaVar.a.e(1.0f);
                euw._cj((View) this.c, evaVar);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        switch (this.a) {
            case 0:
                ((ell) this.c).at.add(animator);
                break;
            default:
                super.onAnimationStart(animator);
                break;
        }
    }

    public elg(ell ellVar, ku kuVar) {
        this.c = ellVar;
        this.b = kuVar;
    }
}
