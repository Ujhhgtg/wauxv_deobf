package com.kongzue.dialogx.util.views;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import me.hd.wauxv.obf.anj;
import me.hd.wauxv.obf.bfp;
import me.hd.wauxv.obf.ResourcesCompat;
import me.hd.wauxv.obf.di;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class ActivityScreenShotImageView extends ImageView {
    public static boolean a = true;
    public float b;
    public float c;
    public float d;
    public boolean e;
    public int f;
    public int g;
    public boolean h;
    public bfp i;

    public ActivityScreenShotImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = false;
        setLayerType(a ? 2 : 1, null);
    }

    private ViewGroup getDecorView() {
        bfp bfpVar = this.i;
        if (bfpVar != null) {
            return (ViewGroup) bfpVar.as().getWindow().getDecorView();
        }
        Activity activityD = di.d();
        if (activityD != null) {
            return (ViewGroup) activityD.getWindow().getDecorView();
        }
        return null;
    }

    public final void j(ViewGroup viewGroup) {
        if (viewGroup.getWidth() == 0 || viewGroup.getHeight() == 0) {
            return;
        }
        this.i.ar().setVisibility(8);
        setContentViewVisibility(true);
        if (viewGroup.getHeight() + viewGroup.getWidth() == 0) {
            viewGroup.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            viewGroup.layout(0, 0, viewGroup.getMeasuredWidth(), viewGroup.getMeasuredHeight());
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(viewGroup.getWidth(), viewGroup.getHeight(), Bitmap.Config.ARGB_8888);
        try {
            viewGroup.draw(new Canvas(bitmapCreateBitmap));
        } catch (Exception e) {
            ResourcesCompat resourcesCompatVar = anj.a;
            e.printStackTrace();
            if (a) {
                a = false;
                setLayerType(1, null);
                j(viewGroup);
            }
        }
        setImageBitmap(Bitmap.createBitmap(bitmapCreateBitmap, 0, 0, viewGroup.getWidth(), viewGroup.getHeight()));
        this.h = true;
        setContentViewVisibility(false);
        this.i.ar().setVisibility(0);
        this.i.ar().requestFocus();
    }

    public final void k() {
        if (isAttachedToWindow()) {
            if (this.f == getMeasuredWidth() && this.g == getMeasuredHeight()) {
                return;
            }
            this.f = getMeasuredWidth();
            this.g = getMeasuredHeight();
            ViewGroup decorView = getDecorView();
            if (decorView == null) {
                return;
            }
            j(decorView);
            setVisibility(0);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setContentViewVisibility(true);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas canvas) {
        if (!this.e) {
            super.onDraw(canvas);
        }
        float f = this.b;
        float f2 = this.d;
        if (f >= f2 && this.c > f2) {
            if (this.h) {
                canvas.drawColor(-16777216);
            }
            Path path = new Path();
            path.moveTo(this.d, 0.0f);
            path.lineTo(this.b - this.d, 0.0f);
            float f3 = this.b;
            path.quadTo(f3, 0.0f, f3, this.d);
            path.lineTo(this.b, this.c - this.d);
            float f4 = this.b;
            float f5 = this.c;
            path.quadTo(f4, f5, f4 - this.d, f5);
            path.lineTo(this.d, this.c);
            float f6 = this.c;
            path.quadTo(0.0f, f6, 0.0f, f6 - this.d);
            path.lineTo(0.0f, this.d);
            path.quadTo(0.0f, 0.0f, this.d, 0.0f);
            canvas.clipPath(path);
        }
        canvas.drawColor(-1);
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.b != getWidth() || this.c != getHeight()) {
            k();
        }
        this.b = getWidth();
        this.c = getHeight();
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.h) {
            return;
        }
        k();
    }

    public void setContentViewVisibility(boolean z) {
    }

    public void setRadius(float f) {
        this.d = f;
        invalidate();
    }

    public void setScale(float f) {
        setScaleX(f);
        setScaleY(f);
        this.e = true;
    }
}
