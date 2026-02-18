package me.hd.wauxv.obf;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import java.util.HashMap;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class axy extends ell {
    public static final String[] a = {"android:visibility:visibility", "android:visibility:parent"};
    public final int b;

    public axy(int i) {
        this();
        this.b = i;
    }

    public static void c(elt eltVar) {
        View view = eltVar.b;
        int visibility = view.getVisibility();
        HashMap map = eltVar.a;
        map.put("android:visibility:visibility", Integer.valueOf(visibility));
        map.put("android:visibility:parent", view.getParent());
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        map.put("android:visibility:screenLocation", iArr);
    }

    public static float d(elt eltVar, float f) {
        Float f2;
        return (eltVar == null || (f2 = (Float) eltVar.a.get("android:fade:transitionAlpha")) == null) ? f : f2.floatValue();
    }

    /* JADX WARN: Found duplicated region for block: B:12:0x0052  */
    /* JADX WARN: Found duplicated region for block: B:7:0x002f  */
    public static esz e(elt eltVar, elt eltVar2) {
        esz eszVar = new esz();
        eszVar.a = false;
        eszVar.b = false;
        if (eltVar != null) {
            HashMap map = eltVar.a;
            if (map.containsKey("android:visibility:visibility")) {
                eszVar.c = ((Integer) map.get("android:visibility:visibility")).intValue();
                eszVar.e = (ViewGroup) map.get("android:visibility:parent");
            } else {
                eszVar.c = -1;
                eszVar.e = null;
            }
        } else {
            eszVar.c = -1;
            eszVar.e = null;
        }
        if (eltVar2 != null) {
            HashMap map2 = eltVar2.a;
            if (map2.containsKey("android:visibility:visibility")) {
                eszVar.d = ((Integer) map2.get("android:visibility:visibility")).intValue();
                eszVar.f = (ViewGroup) map2.get("android:visibility:parent");
            } else {
                eszVar.d = -1;
                eszVar.f = null;
            }
        } else {
            eszVar.d = -1;
            eszVar.f = null;
        }
        if (eltVar != null && eltVar2 != null) {
            int i = eszVar.c;
            int i2 = eszVar.d;
            if (i != i2 || eszVar.e != eszVar.f) {
                if (i != i2) {
                    if (i == 0) {
                        eszVar.b = false;
                        eszVar.a = true;
                        return eszVar;
                    }
                    if (i2 == 0) {
                        eszVar.b = true;
                        eszVar.a = true;
                        return eszVar;
                    }
                } else {
                    if (eszVar.f == null) {
                        eszVar.b = false;
                        eszVar.a = true;
                        return eszVar;
                    }
                    if (eszVar.e == null) {
                        eszVar.b = true;
                        eszVar.a = true;
                        return eszVar;
                    }
                }
            }
        } else {
            if (eltVar == null && eszVar.d == 0) {
                eszVar.b = true;
                eszVar.a = true;
                return eszVar;
            }
            if (eltVar2 == null && eszVar.c == 0) {
                eszVar.b = false;
                eszVar.a = true;
            }
        }
        return eszVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0048, code lost:
    
        if (e(bm(r3, false), bo(r3, false)).a != false) goto L9;
     */
    /* JADX WARN: Found duplicated region for block: B:49:0x009e  */
    /* JADX WARN: Found duplicated region for block: B:51:0x00a4  */
    /* JADX WARN: Found duplicated region for block: B:52:0x00b1  */
    /* JADX WARN: Found duplicated region for block: B:54:0x00b9  */
    /* JADX WARN: Found duplicated region for block: B:56:0x00d3  */
    /* JADX WARN: Found duplicated region for block: B:58:0x0131  */
    /* JADX WARN: Found duplicated region for block: B:61:0x013a  */
    /* JADX WARN: Found duplicated region for block: B:63:0x013e A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:64:0x0140  */
    /* JADX WARN: Found duplicated region for block: B:65:0x0148 A[MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:66:0x0160  */
    /* JADX WARN: Found duplicated region for block: B:69:0x017c A[ADDED_TO_REGION] */
    /* JADX WARN: Found duplicated region for block: B:74:0x01d0  */
    /* JADX WARN: Found duplicated region for block: B:76:0x01d4  */
    /* JADX WARN: Found duplicated region for block: B:78:0x01e0  */
    /* JADX WARN: Found duplicated region for block: B:81:0x01fd  */
    /* JADX WARN: Found duplicated region for block: B:83:0x020d  */
    /* JADX WARN: Found duplicated region for block: B:86:0x0214  */
    @Override // me.hd.wauxv.obf.ell
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.animation.Animator aa(android.view.ViewGroup r24, me.hd.wauxv.obf.elt r25, me.hd.wauxv.obf.elt r26) {
        /*
            Method dump skipped, instruction units count: 728
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: me.hd.wauxv.obf.axy.aa(android.view.ViewGroup, me.hd.wauxv.obf.elt, me.hd.wauxv.obf.elt):android.animation.Animator");
    }

    @Override // me.hd.wauxv.obf.ell
    public final String[] ab() {
        return a;
    }

    @Override // me.hd.wauxv.obf.ell
    public final void f(elt eltVar) {
        c(eltVar);
    }

    @Override // me.hd.wauxv.obf.ell
    public final void h(elt eltVar) {
        c(eltVar);
        View view = eltVar.b;
        Float fValueOf = (Float) view.getTag(R.id.transition_pause_alpha);
        if (fValueOf == null) {
            fValueOf = view.getVisibility() == 0 ? Float.valueOf(eso.a.ab(view)) : Float.valueOf(0.0f);
        }
        eltVar.a.put("android:fade:transitionAlpha", fValueOf);
    }

    @Override // me.hd.wauxv.obf.ell
    public final boolean y(elt eltVar, elt eltVar2) {
        if (eltVar == null && eltVar2 == null) {
            return false;
        }
        if (eltVar != null && eltVar2 != null && eltVar2.a.containsKey("android:visibility:visibility") != eltVar.a.containsKey("android:visibility:visibility")) {
            return false;
        }
        esz eszVarE = e(eltVar, eltVar2);
        if (eszVarE.a) {
            return eszVarE.c == 0 || eszVarE.d == 0;
        }
        return false;
    }

    public final ObjectAnimator z(View view, float f, float f2) {
        if (f == f2) {
            return null;
        }
        eso.a.af(view, f);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, eso.b, f2);
        axx axxVar = new axx(view);
        objectAnimatorOfFloat.addListener(axxVar);
        bn().bh(axxVar);
        return objectAnimatorOfFloat;
    }

    public axy() {
        this.b = 3;
    }
}
