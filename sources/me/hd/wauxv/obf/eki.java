package me.hd.wauxv.obf;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.widget.FrameLayout;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class eki extends FrameLayout {
    public static WeakReference a;
    public final Paint b;
    public final Path c;
    public float d;
    public float e;
    public float f;
    public float g;
    public float h;
    public float i;
    public float j;
    public boolean k;
    public boolean l;
    public ImageView m;

    public eki(Activity activity) {
        super(activity, null, 0);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeWidth(2.0f);
        paint.setColor(-1224624);
        this.b = paint;
        this.c = new Path();
        this.h = 500.0f;
        this.i = 100.0f;
        this.j = 16.0f;
        setBackgroundColor(0);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        double d = 2;
        float f = ((-((float) Math.sqrt(((float) Math.pow(this.e - this.i, d)) + ((float) Math.pow(this.d - this.h, d))))) / 15) + 16.0f;
        this.j = f;
        this.k = f < 5.0f;
        double dAtan = (float) Math.atan((this.e - this.i) / (this.d - this.h));
        float fSin = this.j * ((float) Math.sin(dAtan));
        float fCos = this.j * ((float) Math.cos(dAtan));
        Path path = this.c;
        path.reset();
        path.moveTo(this.h - fSin, this.i + fCos);
        path.quadTo(this.f, this.g, this.d - fSin, this.e + fCos);
        path.lineTo(this.d + fSin, this.e - fCos);
        path.quadTo(this.f, this.g, this.h + fSin, this.i - fCos);
        path.close();
        if (!this.k && this.l && this.m != null) {
            Paint paint = this.b;
            canvas.drawPath(path, paint);
            canvas.drawCircle(this.h, this.i, this.j, paint);
            canvas.drawCircle(this.d, this.e, this.j, paint);
        }
        super.onDraw(canvas);
    }
}
