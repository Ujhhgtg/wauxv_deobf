package com.google.android.material.timepicker;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import me.hd.wauxv.R;
import me.hd.wauxv.obf.ajn;
import me.hd.wauxv.obf.cxs;
import me.hd.wauxv.obf.eqz;
import me.hd.wauxv.obf.ewz;
import me.hd.wauxv.obf.ff;
import me.hd.wauxv.obf.zz;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
class ClockHandView extends View {
    public final ValueAnimator a;
    public boolean b;
    public final ArrayList c;
    public final int d;
    public final float e;
    public final Paint f;
    public final RectF g;
    public final int h;
    public float i;
    public boolean j;
    public double k;
    public int l;
    public int m;

    public ClockHandView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.materialClockStyle);
        this.a = new ValueAnimator();
        this.c = new ArrayList();
        Paint paint = new Paint();
        this.f = paint;
        this.g = new RectF();
        this.m = 1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, cxs.j, R.attr.materialClockStyle, R.style.Widget_MaterialComponents_TimePicker_Clock);
        ajn.ad(context, R.attr.motionDurationLong2, 200);
        ajn.ae(context, R.attr.motionEasingEmphasizedInterpolator, ff.b);
        this.l = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.d = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, 0);
        this.h = getResources().getDimensionPixelSize(R.dimen.material_clock_hand_stroke_width);
        this.e = r4.getDimensionPixelSize(R.dimen.material_clock_hand_center_dot_radius);
        int color = typedArrayObtainStyledAttributes.getColor(0, 0);
        paint.setAntiAlias(true);
        paint.setColor(color);
        o(0.0f);
        ViewConfiguration.get(context).getScaledTouchSlop();
        WeakHashMap weakHashMap = eqz.a;
        setImportantForAccessibility(2);
        typedArrayObtainStyledAttributes.recycle();
    }

    public final int n(int i) {
        return i == 2 ? Math.round(this.l * 0.66f) : this.l;
    }

    public final void o(float f) {
        ValueAnimator valueAnimator = this.a;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        float f2 = f % 360.0f;
        this.i = f2;
        this.k = Math.toRadians(f2 - 90.0f);
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        float fN = n(this.m);
        float fCos = (((float) Math.cos(this.k)) * fN) + width;
        float fSin = (fN * ((float) Math.sin(this.k))) + height;
        float f3 = this.d;
        this.g.set(fCos - f3, fSin - f3, fCos + f3, fSin + f3);
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            ClockFaceView clockFaceView = (ClockFaceView) ((zz) it.next());
            if (Math.abs(clockFaceView.aj - f2) > 0.001f) {
                clockFaceView.aj = f2;
                clockFaceView.am();
            }
        }
        invalidate();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        float f = width;
        float fN = n(this.m);
        float fCos = (((float) Math.cos(this.k)) * fN) + f;
        float f2 = height;
        float fSin = (fN * ((float) Math.sin(this.k))) + f2;
        Paint paint = this.f;
        paint.setStrokeWidth(0.0f);
        canvas.drawCircle(fCos, fSin, this.d, paint);
        double dSin = Math.sin(this.k);
        paint.setStrokeWidth(this.h);
        canvas.drawLine(f, f2, width + ((int) (Math.cos(this.k) * d)), height + ((int) (d * dSin)), paint);
        canvas.drawCircle(f, f2, this.e, paint);
    }

    @Override // android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.a.isRunning()) {
            return;
        }
        o(this.i);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        int actionMasked = motionEvent.getActionMasked();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        boolean z3 = false;
        if (actionMasked == 0) {
            this.j = false;
            z = true;
            z2 = false;
        } else if (actionMasked == 1 || actionMasked == 2) {
            z2 = this.j;
            if (this.b) {
                this.m = ((float) Math.hypot((double) (x - ((float) (getWidth() / 2))), (double) (y - ((float) (getHeight() / 2))))) <= ((float) n(2)) + ewz.ag(getContext(), 12) ? 2 : 1;
            }
            z = false;
        } else {
            z2 = false;
            z = false;
        }
        boolean z4 = this.j;
        int degrees = (int) Math.toDegrees(Math.atan2(y - (getHeight() / 2), x - (getWidth() / 2)));
        int i = degrees + 90;
        if (i < 0) {
            i = degrees + 450;
        }
        float f = i;
        boolean z5 = this.i != f;
        if (z && z5) {
            z3 = true;
        } else if (z5 || z2) {
            o(f);
            z3 = true;
        }
        this.j = z4 | z3;
        return true;
    }
}
