package me.hd.wauxv.obf;

import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.android.dx.io.Opcodes;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ant extends ccz {
    public axq d;
    public int e;

    private final float getStartAngle() {
        cuy positionGravity = getPositionGravity();
        cuy cuyVar = cuy.d;
        if (positionGravity == cuyVar && getExpandDirection() == axq.b) {
            return 270.0f;
        }
        if (getPositionGravity() == cuyVar && getExpandDirection() == axq.a) {
            return 0.0f;
        }
        cuy positionGravity2 = getPositionGravity();
        cuy cuyVar2 = cuy.e;
        if (positionGravity2 == cuyVar2 && getExpandDirection() == axq.a) {
            return 180.0f;
        }
        if (getPositionGravity() == cuyVar2 && getExpandDirection() == axq.b) {
            return 270.0f;
        }
        cuy positionGravity3 = getPositionGravity();
        cuy cuyVar3 = cuy.c;
        if (positionGravity3 == cuyVar3 && getExpandDirection() == axq.b) {
            return 90.0f;
        }
        if (getPositionGravity() == cuyVar3 && getExpandDirection() == axq.a) {
            return 180.0f;
        }
        cuy positionGravity4 = getPositionGravity();
        cuy cuyVar4 = cuy.b;
        if (positionGravity4 == cuyVar4 && getExpandDirection() == axq.a) {
            return 0.0f;
        }
        if (getPositionGravity() == cuyVar4 && getExpandDirection() == axq.b) {
            return 90.0f;
        }
        return (getPositionGravity() == cuy.a && getExpandDirection() == axq.b) ? 90.0f : 0.0f;
    }

    @Override // me.hd.wauxv.obf.ccz
    public final void f() {
        ant antVar = this;
        antVar.ah();
        float startAngle = antVar.getStartAngle();
        int childCount = antVar.getMetaBallsContainerFrameLayout().getChildCount() - 1;
        long delayBetweenItemsAnimation = 0;
        int i = 0;
        int i2 = 1;
        while (i < childCount) {
            float f = (float) ((((double) startAngle) * 3.141592653589793d) / ((double) 180.0f));
            float f2 = 1.0f;
            if (antVar.getPositionGravity() == cuy.a && i % 2 != 0) {
                f2 = -1.0f;
            }
            if (i > 0 && f2 > 0.0f) {
                i2++;
            }
            int i3 = i2;
            double d = f;
            float fCos = antVar.e * i3 * f2 * ((float) Math.cos(d));
            float fSin = antVar.e * i3 * f2 * ((float) Math.sin(d));
            View childAt = antVar.getMetaBallsContainerFrameLayout().getChildAt(i);
            long openAnimationDuration = (long) (antVar.getOpenAnimationDuration() * 0.33f);
            bzo.n(childAt);
            antVar.ae(childAt, fCos, fSin, delayBetweenItemsAnimation, antVar.getOpenInterpolatorAnimator(), antVar.getOpenAnimationDuration());
            long j = delayBetweenItemsAnimation;
            ccz.ac(this, childAt, 1.0f, (long) (antVar.getOpenAnimationDuration() * 0.125f), j);
            ImageView imageView = (ImageView) childAt;
            Drawable drawable = imageView.getDrawable();
            bzo.p(drawable, "getDrawable(...)");
            ag(drawable, j + openAnimationDuration, openAnimationDuration, Opcodes.CONST_METHOD_TYPE, true);
            delayBetweenItemsAnimation = getDelayBetweenItemsAnimation() + j;
            imageView.setEnabled(true);
            i++;
            antVar = this;
            i2 = i3;
        }
        long j2 = delayBetweenItemsAnimation;
        ImageView menuButton = getMenuButton();
        bzo.o(menuButton, "null cannot be cast to non-null type android.view.View");
        ccz.ac(this, menuButton, 0.78f, 300L, 0L);
        if (this.a) {
            ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 0.0f).setDuration(j2 + this.j);
            duration.addUpdateListener(new aqi(this, 2));
            duration.start();
        }
    }

    public final axq getExpandDirection() {
        axq axqVar = this.d;
        if (axqVar != null) {
            return axqVar;
        }
        bzo.ar("expandDirection");
        throw null;
    }

    public final int getMarginBetweenMenuItems() {
        return this.e;
    }

    public final void setExpandDirection(axq axqVar) {
        bzo.q(axqVar, "<set-?>");
        this.d = axqVar;
    }

    public final void setMarginBetweenMenuItems(int i) {
        this.e = i;
    }
}
