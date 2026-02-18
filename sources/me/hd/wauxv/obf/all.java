package me.hd.wauxv.obf;

import android.animation.AnimatorSet;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class all {
    public static final all a = new all();

    public final void b(AnimatorSet animatorSet) {
        bzo.q(animatorSet, "animatorSet");
        animatorSet.reverse();
    }

    public final void c(AnimatorSet animatorSet, long j) {
        bzo.q(animatorSet, "animatorSet");
        animatorSet.setCurrentPlayTime(j);
    }
}
