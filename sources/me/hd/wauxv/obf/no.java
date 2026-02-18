package me.hd.wauxv.obf;

import android.animation.ValueAnimator;
import android.widget.TextView;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.textfield.TextInputLayout;
import com.kongzue.dialogx.util.views.MaxRelativeLayout;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class no implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ no(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ns nsVar = (ns) obj;
                for (ekv ekvVar : nsVar.l) {
                    ekvVar.r = 1.2f;
                    ekvVar.p = fFloatValue;
                    ekvVar.q = fFloatValue;
                    ekvVar.s = ff.g(0.0f, 1.0f, 0.19f, 1.0f, fFloatValue);
                    ekvVar.invalidateSelf();
                }
                WeakHashMap weakHashMap = eqz.a;
                nsVar.postInvalidateOnAnimation();
                break;
            case 1:
                float fFloatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                cau cauVar = ((BottomSheetBehavior) obj).w;
                if (cauVar != null) {
                    cauVar.ea(fFloatValue2);
                }
                break;
            case 2:
                ((CollapsingToolbarLayout) obj).setScrimAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
                break;
            case 3:
                int iFloatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
                ayj ayjVar = (ayj) obj;
                ayjVar.f.setAlpha(iFloatValue);
                ayjVar.g.setAlpha(iFloatValue);
                ayjVar.v.invalidate();
                break;
            case 4:
                ((bfo) obj).c.s(((Float) valueAnimator.getAnimatedValue()).floatValue());
                break;
            case 5:
                float fFloatValue3 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                bfo bfoVar = (bfo) ((bfk) obj).ao;
                bfoVar.c.s(fFloatValue3);
                bfoVar.k = fFloatValue3 != 1.0f;
                break;
            case 6:
                ((bqu) obj).m = valueAnimator.getAnimatedFraction();
                break;
            case 7:
                float fFloatValue4 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                int i2 = MaxRelativeLayout.a;
                long j = (long) ((fFloatValue4 * 0.0f) + 0.0f);
                bfm bfmVar = ((MaxRelativeLayout) obj).i;
                if (bfmVar != null) {
                    bfmVar.c(j);
                }
                break;
            case 8:
                ((dih) obj).m = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                break;
            case 9:
                ((TabLayout) obj).scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
                break;
            case 10:
                ((TextInputLayout) obj).bt.cg(((Float) valueAnimator.getAnimatedValue()).floatValue());
                break;
            default:
                float fFloatValue5 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                TextView textView = (TextView) obj;
                textView.setScaleX(fFloatValue5);
                textView.setScaleY(fFloatValue5);
                break;
        }
    }
}
