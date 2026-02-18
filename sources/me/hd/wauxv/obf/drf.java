package me.hd.wauxv.obf;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class drf extends ell {
    @Override // me.hd.wauxv.obf.ell
    public final Animator aa(ViewGroup viewGroup, elt eltVar, elt eltVar2) {
        if (eltVar == null || eltVar2 == null || !(eltVar.b instanceof TextView)) {
            return null;
        }
        View view = eltVar2.b;
        if (!(view instanceof TextView)) {
            return null;
        }
        TextView textView = (TextView) view;
        HashMap map = eltVar.a;
        HashMap map2 = eltVar2.a;
        float fFloatValue = map.get("android:textscale:scale") != null ? ((Float) map.get("android:textscale:scale")).floatValue() : 1.0f;
        float fFloatValue2 = map2.get("android:textscale:scale") != null ? ((Float) map2.get("android:textscale:scale")).floatValue() : 1.0f;
        if (fFloatValue == fFloatValue2) {
            return null;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fFloatValue, fFloatValue2);
        valueAnimatorOfFloat.addUpdateListener(new no(textView, 11));
        return valueAnimatorOfFloat;
    }

    @Override // me.hd.wauxv.obf.ell
    public final void f(elt eltVar) {
        View view = eltVar.b;
        if (view instanceof TextView) {
            eltVar.a.put("android:textscale:scale", Float.valueOf(((TextView) view).getScaleX()));
        }
    }

    @Override // me.hd.wauxv.obf.ell
    public final void h(elt eltVar) {
        View view = eltVar.b;
        if (view instanceof TextView) {
            eltVar.a.put("android:textscale:scale", Float.valueOf(((TextView) view).getScaleX()));
        }
    }
}
