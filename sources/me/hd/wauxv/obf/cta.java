package me.hd.wauxv.obf;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cta extends dbi {
    public final Paint a;
    public long b;
    public final int e;
    public final float g;
    public final float h;
    public float i;
    public float j;
    public int k;
    public int l;
    public float m;
    public final ArrayList n;
    public ValueAnimator o;

    public cta(float f, float f2, int i, float f3, float f4) {
        super(null, f, f2);
        Paint paint = new Paint();
        this.a = paint;
        this.k = 2000;
        this.l = 20;
        this.m = 10.0f;
        this.n = new ArrayList();
        this.b = System.currentTimeMillis();
        paint.setColor(-65536);
        this.e = i;
        this.g = f3;
        this.h = f4;
    }

    @Override // me.hd.wauxv.obf.dbi
    public final void c(Canvas canvas) {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.n;
            if (i >= arrayList.size()) {
                return;
            }
            csz cszVar = (csz) arrayList.get(i);
            float f = this.r;
            this.o.setCurrentPlayTime((long) (((f - cszVar.r) / (f - this.i)) * 10000.0f));
            int iIntValue = ((Integer) this.o.getAnimatedValue()).intValue();
            Paint paint = this.a;
            paint.setColor(iIntValue);
            float f2 = cszVar.q;
            float f3 = cszVar.r;
            float f4 = this.l;
            canvas.drawRect(f2, f3, f2 + f4, f3 + f4, paint);
            i++;
        }
    }

    @Override // me.hd.wauxv.obf.dbi
    public final void d(float f, float f2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = this.b + ((long) this.e);
        ArrayList arrayList = this.n;
        if (j < jCurrentTimeMillis) {
            float f3 = this.q;
            float f4 = this.h;
            float fB = cay.b(-f4, f4) + f3;
            float f5 = this.r;
            float f6 = this.m;
            float fB2 = cay.b(-f6, f6);
            float f7 = this.j;
            float fB3 = cay.b(-f7, f7);
            csz cszVar = new csz(null, fB, f5);
            cszVar.a = fB2;
            cszVar.b = fB3;
            cszVar.e = System.currentTimeMillis();
            arrayList.add(cszVar);
            this.b = System.currentTimeMillis();
        }
        int i = 0;
        while (i < arrayList.size()) {
            csz cszVar2 = (csz) arrayList.get(i);
            cszVar2.r = (cszVar2.b * f) + (this.g * f) + cszVar2.r;
            cszVar2.q = (f2 * f) + (cszVar2.a * f) + cszVar2.q;
            if (cszVar2.e + ((long) this.k) < jCurrentTimeMillis) {
                cszVar2.e = System.currentTimeMillis();
                float f8 = this.m;
                float fB4 = cay.b(-f8, f8);
                float f9 = this.j;
                float fB5 = cay.b(-f9, f9);
                cszVar2.a = fB4;
                cszVar2.b = fB5;
            }
            if (cszVar2.r < this.i) {
                arrayList.remove(i);
                i--;
            }
            i++;
        }
    }

    public final void p(int i, int i2) {
        this.o = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(i), Integer.valueOf(i2), 0).setDuration(10000L);
    }
}
