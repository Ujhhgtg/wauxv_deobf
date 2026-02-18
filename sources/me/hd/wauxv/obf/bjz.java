package me.hd.wauxv.obf;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import com.android.dx.io.Opcodes;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bjz implements dfp {
    public final Drawable a;
    public final int b;
    public final int c;
    public int d = 0;
    public final int e;
    public final Paint f;

    public bjz(Context context) {
        this.a = context.getDrawable(R.drawable.ic_sora_handle_drop).mutate();
        this.b = (int) TypedValue.applyDimension(1, 20.0f, context.getResources().getDisplayMetrics());
        this.c = (int) TypedValue.applyDimension(1, 30.0f, context.getResources().getDisplayMetrics());
        this.e = (int) TypedValue.applyDimension(1, 22.0f, context.getResources().getDisplayMetrics());
        Paint paint = new Paint();
        this.f = paint;
        paint.setAntiAlias(true);
    }

    public final void g(Canvas canvas, int i, float f, float f2, int i2, dfo dfoVar) {
        float f3;
        Canvas canvas2;
        float f4;
        float f5 = this.e / 2.0f;
        Paint paint = this.f;
        paint.setColor(i2);
        if (i == 0 || i == -1) {
            int i3 = this.d;
            Drawable drawable = this.a;
            if (i3 != i2) {
                this.d = i2;
                drawable.setColorFilter(new PorterDuffColorFilter(i2, PorterDuff.Mode.SRC_ATOP));
            }
            float f6 = (this.b * 1.0f) / 2.0f;
            int i4 = (int) (f - f6);
            int i5 = (int) f2;
            int i6 = (int) (f6 + f);
            int i7 = (int) ((this.c * 1.0f) + f2);
            drawable.setBounds(i4, i5, i6, i7);
            drawable.setAlpha(Opcodes.CONST_METHOD_TYPE);
            drawable.draw(canvas);
            dfoVar.b = 0;
            dfoVar.a.set(i4, i5, i6, i7);
            return;
        }
        boolean z = i == 1;
        float f7 = z ? f - f5 : f + f5;
        float f8 = f2 + f5;
        canvas.drawCircle(f7, f8, f5, paint);
        float f9 = z ? f7 : f7 - f5;
        if (z) {
            f3 = f7 + f5;
            f4 = f2;
            canvas2 = canvas;
        } else {
            f3 = f7;
            canvas2 = canvas;
            f4 = f2;
        }
        canvas2.drawRect(f9, f4, f3, f8, paint);
        float f10 = f7 - f5;
        float f11 = f7 + f5;
        float f12 = (f5 * 2.0f) + f4;
        dfoVar.b = z ? 1 : 2;
        dfoVar.a.set(f10, f4, f11, f12);
    }
}
