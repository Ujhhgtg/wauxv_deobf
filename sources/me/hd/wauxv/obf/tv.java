package me.hd.wauxv.obf;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class tv extends ell {
    public static final String[] a = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    public static final tr b = new tr("topLeft", 0, PointF.class);
    public static final tr c = new tr("bottomRight", 1, PointF.class);
    public static final tr d = new tr("bottomRight", 2, PointF.class);
    public static final tr e = new tr("topLeft", 3, PointF.class);
    public static final tr _ay = new tr("position", 4, PointF.class);

    public static void z(elt eltVar) {
        View view = eltVar.b;
        HashMap map = eltVar.a;
        if (!view.isLaidOut() && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        map.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        map.put("android:changeBounds:parent", view.getParent());
    }

    @Override // me.hd.wauxv.obf.ell
    public final Animator aa(ViewGroup viewGroup, elt eltVar, elt eltVar2) {
        int i;
        tv tvVar;
        Animator animatorA;
        if (eltVar != null) {
            HashMap map = eltVar.a;
            if (eltVar2 != null) {
                HashMap map2 = eltVar2.a;
                ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
                ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
                if (viewGroup2 != null && viewGroup3 != null) {
                    View view = eltVar2.b;
                    Rect rect = (Rect) map.get("android:changeBounds:bounds");
                    Rect rect2 = (Rect) map2.get("android:changeBounds:bounds");
                    int i2 = rect.left;
                    int i3 = rect2.left;
                    int i4 = rect.top;
                    int i5 = rect2.top;
                    int i6 = rect.right;
                    int i7 = rect2.right;
                    int i8 = rect.bottom;
                    int i9 = rect2.bottom;
                    int i10 = i6 - i2;
                    int i11 = i8 - i4;
                    int i12 = i7 - i3;
                    int i13 = i9 - i5;
                    Rect rect3 = (Rect) map.get("android:changeBounds:clip");
                    Rect rect4 = (Rect) map2.get("android:changeBounds:clip");
                    if ((i10 == 0 || i11 == 0) && (i12 == 0 || i13 == 0)) {
                        i = 0;
                    } else {
                        i = (i2 == i3 && i4 == i5) ? 0 : 1;
                        if (i6 != i7 || i8 != i9) {
                            i++;
                        }
                    }
                    if ((rect3 != null && !rect3.equals(rect4)) || (rect3 == null && rect4 != null)) {
                        i++;
                    }
                    int i14 = i;
                    if (i14 > 0) {
                        eso.c(view, i2, i4, i6, i8);
                        if (i14 != 2) {
                            tvVar = this;
                            if (i2 == i3 && i4 == i5) {
                                tvVar.bb.getClass();
                                animatorA = cph.a(view, d, dop.j(i6, i8, i7, i9));
                            } else {
                                tvVar.bb.getClass();
                                animatorA = cph.a(view, e, dop.j(i2, i4, i3, i5));
                            }
                        } else if (i10 == i12 && i11 == i13) {
                            tvVar = this;
                            tvVar.bb.getClass();
                            animatorA = cph.a(view, _ay, dop.j(i2, i4, i3, i5));
                        } else {
                            tvVar = this;
                            tu tuVar = new tu(view);
                            tvVar.bb.getClass();
                            ObjectAnimator objectAnimatorA = cph.a(tuVar, b, dop.j(i2, i4, i3, i5));
                            tvVar.bb.getClass();
                            ObjectAnimator objectAnimatorA2 = cph.a(tuVar, c, dop.j(i6, i8, i7, i9));
                            AnimatorSet animatorSet = new AnimatorSet();
                            animatorSet.playTogether(objectAnimatorA, objectAnimatorA2);
                            animatorSet.addListener(new ts(tuVar));
                            animatorA = animatorSet;
                        }
                        if (view.getParent() instanceof ViewGroup) {
                            ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                            dqc.tryGetClassByName(viewGroup4, true);
                            tvVar.bn().bh(new tt(viewGroup4));
                        }
                        return animatorA;
                    }
                }
            }
        }
        return null;
    }

    @Override // me.hd.wauxv.obf.ell
    public final String[] ab() {
        return a;
    }

    @Override // me.hd.wauxv.obf.ell
    public final void f(elt eltVar) {
        z(eltVar);
    }

    @Override // me.hd.wauxv.obf.ell
    public final void h(elt eltVar) {
        z(eltVar);
    }
}
