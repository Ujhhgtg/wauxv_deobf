package me.hd.wauxv.obf;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bwo implements View.OnTouchListener {
    public static final int a = ViewConfiguration.getTapTimeout();
    public final me b;
    public final AccelerateInterpolator c;
    public final aqe d;
    public dc e;
    public final float[] f;
    public final float[] g;
    public final int h;
    public final int i;
    public final float[] j;
    public final float[] k;
    public final float[] l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public final aqe r;

    public bwo(aqe aqeVar) {
        me meVar = new me();
        meVar.e = Long.MIN_VALUE;
        meVar.g = -1L;
        meVar.f = 0L;
        this.b = meVar;
        this.c = new AccelerateInterpolator();
        float[] fArr = {0.0f, 0.0f};
        this.f = fArr;
        float[] fArr2 = {Float.MAX_VALUE, Float.MAX_VALUE};
        this.g = fArr2;
        float[] fArr3 = {0.0f, 0.0f};
        this.j = fArr3;
        float[] fArr4 = {0.0f, 0.0f};
        this.k = fArr4;
        float[] fArr5 = {Float.MAX_VALUE, Float.MAX_VALUE};
        this.l = fArr5;
        this.d = aqeVar;
        float f = Resources.getSystem().getDisplayMetrics().density;
        float f2 = ((int) ((1575.0f * f) + 0.5f)) / 1000.0f;
        fArr5[0] = f2;
        fArr5[1] = f2;
        float f3 = ((int) ((f * 315.0f) + 0.5f)) / 1000.0f;
        fArr4[0] = f3;
        fArr4[1] = f3;
        this.h = 1;
        fArr2[0] = Float.MAX_VALUE;
        fArr2[1] = Float.MAX_VALUE;
        fArr[0] = 0.2f;
        fArr[1] = 0.2f;
        fArr3[0] = 0.001f;
        fArr3[1] = 0.001f;
        this.i = a;
        meVar.a = 500;
        meVar.b = 500;
        this.r = aqeVar;
    }

    public static float s(float f, float f2, float f3) {
        return f > f3 ? f3 : f < f2 ? f2 : f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0014, code lost:
    
        if (r0 != 3) goto L29;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouch(android.view.View r9, android.view.MotionEvent r10) {
        /*
            r8 = this;
            boolean r0 = r8.q
            r1 = 0
            if (r0 != 0) goto L7
            goto L7c
        L7:
            int r0 = r10.getActionMasked()
            r2 = 2
            r3 = 1
            if (r0 == 0) goto L1b
            if (r0 == r3) goto L17
            if (r0 == r2) goto L1f
            r9 = 3
            if (r0 == r9) goto L17
            goto L7c
        L17:
            r8.v()
            return r1
        L1b:
            r8.o = r3
            r8.m = r1
        L1f:
            float r0 = r10.getX()
            int r4 = r9.getWidth()
            float r4 = (float) r4
            me.hd.wauxv.obf.aqe r5 = r8.d
            int r6 = r5.getWidth()
            float r6 = (float) r6
            float r0 = r8.t(r0, r4, r6, r1)
            float r10 = r10.getY()
            int r9 = r9.getHeight()
            float r9 = (float) r9
            int r4 = r5.getHeight()
            float r4 = (float) r4
            float r9 = r8.t(r10, r9, r4, r3)
            me.hd.wauxv.obf.me r10 = r8.b
            r10.c = r0
            r10.d = r9
            boolean r9 = r8.p
            if (r9 != 0) goto L7c
            boolean r9 = r8.w()
            if (r9 == 0) goto L7c
            me.hd.wauxv.obf.dc r9 = r8.e
            if (r9 != 0) goto L60
            me.hd.wauxv.obf.dc r9 = new me.hd.wauxv.obf.dc
            r9.<init>(r8, r2)
            r8.e = r9
        L60:
            r8.p = r3
            r8.n = r3
            boolean r9 = r8.m
            if (r9 != 0) goto L75
            int r9 = r8.i
            if (r9 <= 0) goto L75
            me.hd.wauxv.obf.dc r10 = r8.e
            long r6 = (long) r9
            java.util.WeakHashMap r9 = me.hd.wauxv.obf.eqz.a
            r5.postOnAnimationDelayed(r10, r6)
            goto L7a
        L75:
            me.hd.wauxv.obf.dc r9 = r8.e
            r9.run()
        L7a:
            r8.m = r3
        L7c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: me.hd.wauxv.obf.bwo.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Found duplicated region for block: B:12:0x003b A[RETURN] */
    /* JADX WARN: Found duplicated region for block: B:13:0x003c  */
    /* JADX WARN: Found duplicated region for block: B:15:0x004b  */
    /* JADX WARN: Found duplicated region for block: B:17:0x0051  */
    public final float t(float f, float f2, float f3, int i) {
        float fS;
        float interpolation;
        float fS2 = s(this.f[i] * f2, 0.0f, this.g[i]);
        float fU = u(f2 - f, fS2) - u(f, fS2);
        AccelerateInterpolator accelerateInterpolator = this.c;
        if (fU >= 0.0f) {
            if (fU > 0.0f) {
                interpolation = accelerateInterpolator.getInterpolation(fU);
            } else {
                fS = 0.0f;
            }
            if (fS == 0.0f) {
                return 0.0f;
            }
            float f4 = this.j[i];
            float f5 = this.k[i];
            float f6 = this.l[i];
            float f7 = f4 * f3;
            return fS > 0.0f ? s(fS * f7, f5, f6) : -s((-fS) * f7, f5, f6);
        }
        interpolation = -accelerateInterpolator.getInterpolation(-fU);
        fS = s(interpolation, -1.0f, 1.0f);
        if (fS == 0.0f) {
            return 0.0f;
        }
        float f42 = this.j[i];
        float f52 = this.k[i];
        float f62 = this.l[i];
        float f72 = f42 * f3;
        if (fS > 0.0f) {
        }
    }

    public final float u(float f, float f2) {
        if (f2 != 0.0f) {
            int i = this.h;
            if (i == 0 || i == 1) {
                if (f < f2) {
                    if (f >= 0.0f) {
                        return 1.0f - (f / f2);
                    }
                    if (this.p && i == 1) {
                        return 1.0f;
                    }
                }
            } else if (i == 2 && f < 0.0f) {
                return f / (-f2);
            }
        }
        return 0.0f;
    }

    public final void v() {
        int i = 0;
        if (this.n) {
            this.p = false;
            return;
        }
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        me meVar = this.b;
        int i2 = (int) (jCurrentAnimationTimeMillis - meVar.e);
        int i3 = meVar.b;
        if (i2 > i3) {
            i = i3;
        } else if (i2 >= 0) {
            i = i2;
        }
        meVar.i = i;
        meVar.h = meVar.j(jCurrentAnimationTimeMillis);
        meVar.g = jCurrentAnimationTimeMillis;
    }

    public final boolean w() {
        aqe aqeVar;
        int count;
        me meVar = this.b;
        float f = meVar.d;
        int iAbs = (int) (f / Math.abs(f));
        Math.abs(meVar.c);
        if (iAbs != 0 && (count = (aqeVar = this.r).getCount()) != 0) {
            int childCount = aqeVar.getChildCount();
            int firstVisiblePosition = aqeVar.getFirstVisiblePosition();
            int i = firstVisiblePosition + childCount;
            if (iAbs <= 0 ? !(iAbs >= 0 || (firstVisiblePosition <= 0 && aqeVar.getChildAt(0).getTop() >= 0)) : !(i >= count && aqeVar.getChildAt(childCount - 1).getBottom() <= aqeVar.getHeight())) {
                return true;
            }
        }
        return false;
    }
}
