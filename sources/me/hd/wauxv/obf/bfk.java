package me.hd.wauxv.obf;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import com.kongzue.dialogx.util.views.DialogXBaseRelativeLayout;
import com.kongzue.dialogx.util.views.MaxRelativeLayout;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bfk extends ajn {
    public final /* synthetic */ int an;
    public final /* synthetic */ Object ao;

    public /* synthetic */ bfk(Object obj, int i) {
        this.an = i;
        this.ao = obj;
    }

    public final void ap(Object obj) {
        int i = this.an;
        int i2 = 1;
        Object obj2 = this.ao;
        switch (i) {
            case 0:
                bfo bfoVar = (bfo) obj2;
                long j = bfoVar.l.r;
                if (j == -1) {
                    j = 300;
                }
                MaxRelativeLayout maxRelativeLayout = bfoVar.e;
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(maxRelativeLayout, "y", maxRelativeLayout.getY(), bfoVar.d.getHeight());
                objectAnimatorOfFloat.setDuration(j);
                objectAnimatorOfFloat.start();
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
                valueAnimatorOfFloat.setDuration(j);
                valueAnimatorOfFloat.addUpdateListener(new no(this, 5));
                valueAnimatorOfFloat.start();
                break;
            default:
                cct cctVar = (cct) obj2;
                ccu ccuVar = cctVar.o;
                ccuVar.o.getClass();
                ccuVar.o.getClass();
                ccuVar.getClass();
                Animation animationLoadAnimation = AnimationUtils.loadAnimation(ccuVar.as(), R.anim.anim_dialogx_default_exit);
                long jQ = cctVar.q(animationLoadAnimation);
                animationLoadAnimation.setInterpolator(new AccelerateInterpolator());
                animationLoadAnimation.setDuration(jQ);
                cctVar.c.startAnimation(animationLoadAnimation);
                ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
                valueAnimatorOfFloat2.setDuration(jQ);
                valueAnimatorOfFloat2.addUpdateListener(new ccs(this, i2));
                valueAnimatorOfFloat2.start();
                break;
        }
    }

    public final void aq(Object obj) {
        int i = this.an;
        int i2 = 0;
        Object obj2 = this.ao;
        switch (i) {
            case 0:
                bfo bfoVar = (bfo) obj2;
                bfoVar.p();
                DialogXBaseRelativeLayout dialogXBaseRelativeLayout = bfoVar.c;
                float safeHeight = dialogXBaseRelativeLayout.getSafeHeight() - bfoVar.i;
                bfoVar.h = safeHeight;
                if (safeHeight < 0.0f) {
                    bfoVar.h = 0.0f;
                }
                bfoVar.n(dialogXBaseRelativeLayout.getHeight(), (int) bfoVar.h, false);
                break;
            default:
                cct cctVar = (cct) obj2;
                ccu ccuVar = cctVar.o;
                MaxRelativeLayout maxRelativeLayout = cctVar.c;
                ccuVar.o.getClass();
                ccuVar.o.getClass();
                ccuVar.getClass();
                Animation animationLoadAnimation = AnimationUtils.loadAnimation(ccuVar.as(), R.anim.anim_dialogx_default_enter);
                Animation animation = (animationLoadAnimation != null || maxRelativeLayout.getAnimation() == null) ? animationLoadAnimation : maxRelativeLayout.getAnimation();
                long duration = (animation == null || animation.getDuration() == 0) ? 300L : animation.getDuration();
                long j = ccuVar.q;
                if (j >= 0) {
                    duration = j;
                }
                animationLoadAnimation.setDuration(duration);
                animationLoadAnimation.setInterpolator(new DecelerateInterpolator());
                maxRelativeLayout.startAnimation(animationLoadAnimation);
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                valueAnimatorOfFloat.setDuration(duration);
                valueAnimatorOfFloat.addUpdateListener(new ccs(this, i2));
                valueAnimatorOfFloat.start();
                break;
        }
    }
}
