package me.hd.wauxv.obf;

import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.animation.PathInterpolator;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class euu implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ eva a;
    public final /* synthetic */ evr b;
    public final /* synthetic */ evr c;
    public final /* synthetic */ int d;
    public final /* synthetic */ View e;

    public euu(eva evaVar, evr evrVar, evr evrVar2, int i, View view) {
        this.a = evaVar;
        this.b = evrVar;
        this.c = evrVar2;
        this.d = i;
        this.e = view;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float animatedFraction = valueAnimator.getAnimatedFraction();
        eva evaVar = this.a;
        euz euzVar = evaVar.a;
        euzVar.e(animatedFraction);
        evr evrVar = this.b;
        evo evoVar = evrVar.b;
        float fC = euzVar.c();
        PathInterpolator pathInterpolator = euw.a;
        int i = Build.VERSION.SDK_INT;
        evg evfVar = i >= 34 ? new evf(evrVar) : i >= 31 ? new eve(evrVar) : i >= 30 ? new evd(evrVar) : i >= 29 ? new evc(evrVar) : new evb(evrVar);
        for (int i2 = 1; i2 <= 512; i2 <<= 1) {
            if ((this.d & i2) == 0) {
                evfVar.e(i2, evoVar.n(i2));
            } else {
                bps bpsVarN = evoVar.n(i2);
                bps bpsVarN2 = this.c.b.n(i2);
                float f = 1.0f - fC;
                evfVar.e(i2, evr.c(bpsVarN, (int) (((double) ((bpsVarN.b - bpsVarN2.b) * f)) + 0.5d), (int) (((double) ((bpsVarN.c - bpsVarN2.c) * f)) + 0.5d), (int) (((double) ((bpsVarN.d - bpsVarN2.d) * f)) + 0.5d), (int) (((double) ((bpsVarN.e - bpsVarN2.e) * f)) + 0.5d)));
            }
        }
        euw.g(this.e, evfVar.g(), Collections.singletonList(evaVar));
    }
}
