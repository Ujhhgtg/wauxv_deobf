package me.hd.wauxv.obf;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.res.ColorStateList;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.checkbox.MaterialCheckBox;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ci extends AnimatorListenerAdapter {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ ci(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    @Override // android.animation.AnimatorListenerAdapter,
              // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        switch (this.a) {
            case 0:
                ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) this.b;
                actionBarOverlayLayout.z = null;
                actionBarOverlayLayout.m = false;
                break;
            case 7:
                ((esi) this.b).d();
                break;
            default:
                super.onAnimationCancel(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter,
              // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.a) {
            case 0:
                ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) this.b;
                actionBarOverlayLayout.z = null;
                actionBarOverlayLayout.m = false;
                break;
            case 1:
                fe feVar = (fe) this.b;
                ArrayList arrayList = new ArrayList(feVar.d);
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ColorStateList colorStateList = ((cap) arrayList.get(i)).b.o;
                    if (colorStateList != null) {
                        feVar.setTintList(colorStateList);
                    }
                }
                break;
            case 2:
                super.onAnimationEnd(animator);
                ns nsVar = (ns) this.b;
                ViewGroup viewGroupAh = StaticAndroidHelpers.ah(nsVar);
                InstantCollection instantCollectionVar = viewGroupAh == null ? null : new InstantCollection(viewGroupAh);
                Iterator it = nsVar.l.iterator();
                while (it.hasNext()) {
                    ((ViewOverlay) instantCollectionVar.instantBuilders).remove((ekv) it.next());
                }
                break;
            case 3:
                aql aqlVar = (aql) this.b;
                aqlVar.al();
                aqlVar.x.start();
                break;
            case 4:
                ((HideBottomViewOnScrollBehavior) this.b)._r = null;
                break;
            case 5:
                throwIfVar1IsNull(animator, "animation");
                super.onAnimationEnd(animator);
                IFunction0 onMenuClosed = ((ccz) this.b).getOnMenuClosed();
                if (onMenuClosed != null) {
                    onMenuClosed.invoke();
                }
                break;
            case 6:
                ((ell) this.b).bl();
                animator.removeListener(this);
                break;
            default:
                ((esi) this.b).f();
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter,
              // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        switch (this.a) {
            case 1:
                fe feVar = (fe) this.b;
                ArrayList arrayList = new ArrayList(feVar.d);
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    MaterialCheckBox materialCheckBox = ((cap) arrayList.get(i)).b;
                    ColorStateList colorStateList = materialCheckBox.o;
                    if (colorStateList != null) {
                        feVar.setTint(
                                colorStateList.getColorForState(materialCheckBox.s, colorStateList.getDefaultColor()));
                    }
                }
                break;
            case 7:
                ((esi) this.b).e();
                break;
            default:
                super.onAnimationStart(animator);
                break;
        }
    }

    public ci(esi esiVar, View view) {
        this.a = 7;
        this.b = esiVar;
    }
}
