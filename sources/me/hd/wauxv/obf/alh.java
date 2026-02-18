package me.hd.wauxv.obf;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.Resources;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class alh extends nh {
    public final boolean a;
    public boolean b;
    public DefaultConfig f;

    /*
     * JADX WARN: 'super' call moved to the top of the method (can break code
     * semantics)
     */
    public alh(dlr dlrVar, boolean z) {
        super(dlrVar);
        throwIfVar1IsNull(dlrVar, "operation");
        this.a = z;
    }

    /* JADX WARN: Found duplicated region for block: B:18:0x0027 */
    /*
     * JADX WARN: Found duplicated region for block: B:80:0x00e5 A[Catch:
     * RuntimeException -> 0x00eb, TRY_LEAVE, TryCatch #2 {RuntimeException ->
     * 0x00eb, blocks: (B:78:0x00df, B:80:0x00e5), top: B:91:0x00df }]
     */
    public final DefaultConfig j(Context context) {
        int iAh;
        Animation animationLoadAnimation;
        DefaultConfig ioVar;
        Animator animatorLoadAnimator;
        if (this.b) {
            return this.f;
        }
        dlr dlrVar = (dlr) this.g;
        bdj bdjVar = dlrVar.c;
        boolean z = dlrVar.a == 2;
        bdg bdgVar = bdjVar.cc;
        int i = bdgVar == null ? 0 : bdgVar.f;
        if (this.a) {
            if (z) {
                iAh = bdgVar == null ? 0 : bdgVar.d;
            } else if (bdgVar != null) {
                iAh = bdgVar.e;
            }
        } else if (z) {
            if (bdgVar != null) {
                iAh = bdgVar.b;
            }
        } else if (bdgVar != null) {
            iAh = bdgVar.c;
        }
        bdjVar.de(0, 0, 0, 0);
        ViewGroup viewGroup = bdjVar.by;
        DefaultConfig ioVar2 = null;
        if (viewGroup != null && viewGroup.getTag(R.id.visible_removing_fragment_view_tag) != null) {
            bdjVar.by.setTag(R.id.visible_removing_fragment_view_tag, null);
        }
        ViewGroup viewGroup2 = bdjVar.by;
        if (viewGroup2 == null || viewGroup2.getLayoutTransition() == null) {
            if (iAh == 0 && i != 0) {
                iAh = i != 4097
                        ? i != 8194
                                ? i != 8197
                                        ? i != 4099
                                                ? i != 4100 ? -1
                                                        : z ? cna.ah(context, android.R.attr.activityOpenEnterAnimation)
                                                                : cna.ah(context,
                                                                        android.R.attr.activityOpenExitAnimation)
                                                : z ? R.animator.fragment_fade_enter : R.animator.fragment_fade_exit
                                        : z ? cna.ah(context, android.R.attr.activityCloseEnterAnimation)
                                                : cna.ah(context, android.R.attr.activityCloseExitAnimation)
                                : z ? R.animator.fragment_close_enter : R.animator.fragment_close_exit
                        : z ? R.animator.fragment_open_enter : R.animator.fragment_open_exit;
            }
            if (iAh != 0) {
                boolean zEquals = "anim".equals(context.getResources().getResourceTypeName(iAh));
                if (zEquals) {
                    try {
                        animationLoadAnimation = AnimationUtils.loadAnimation(context, iAh);
                    } catch (Resources.NotFoundException e) {
                        throw e;
                    } catch (RuntimeException unused) {
                        try {
                            animatorLoadAnimator = AnimatorInflater.loadAnimator(context, iAh);
                            if (animatorLoadAnimator != null) {
                                ioVar = new DefaultConfig(animatorLoadAnimator);
                                ioVar2 = ioVar;
                            }
                        } catch (RuntimeException e2) {
                            if (zEquals) {
                                throw e2;
                            }
                            Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(context, iAh);
                            if (animationLoadAnimation2 != null) {
                                ioVar2 = new DefaultConfig(animationLoadAnimation2);
                            }
                        }
                    }
                    if (animationLoadAnimation != null) {
                        ioVar = new DefaultConfig(animationLoadAnimation);
                        ioVar2 = ioVar;
                    }
                } else {
                    animatorLoadAnimator = AnimatorInflater.loadAnimator(context, iAh);
                    if (animatorLoadAnimator != null) {
                        ioVar = new DefaultConfig(animatorLoadAnimator);
                        ioVar2 = ioVar;
                    }
                }
            }
        }
        this.f = ioVar2;
        this.b = true;
        return ioVar2;
    }
}
