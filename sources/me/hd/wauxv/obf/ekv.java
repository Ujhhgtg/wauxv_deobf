package me.hd.wauxv.obf;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ekv extends cau implements dqj {
    public CharSequence a;
    public final Context b;
    public final Paint.FontMetrics d;
    public final dqk e;
    public final pw f;
    public final Rect g;
    public int h;
    public int i;
    public int j;
    public int k;
    public boolean l;
    public int m;
    public int o;
    public float p;
    public float q;
    public float r;
    public float s;

    public ekv(Context context, int i) {
        super(context, null, 0, i);
        this.d = new Paint.FontMetrics();
        dqk dqkVar = new dqk(this);
        this.e = dqkVar;
        this.f = new pw(this, 4);
        this.g = new Rect();
        this.p = 1.0f;
        this.q = 1.0f;
        this.r = 0.5f;
        this.s = 1.0f;
        this.b = context;
        float f = context.getResources().getDisplayMetrics().density;
        TextPaint textPaint = dqkVar.a;
        textPaint.density = f;
        textPaint.setTextAlign(Paint.Align.CENTER);
    }

    @Override // me.hd.wauxv.obf.cau, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Canvas canvas2;
        canvas.save();
        float fT = t();
        float f = (float) (-((Math.sqrt(2.0d) * ((double) this.m)) - ((double) this.m)));
        canvas.scale(this.p, this.q, (getBounds().width() * 0.5f) + getBounds().left, (getBounds().height() * this.r) + getBounds().top);
        canvas.translate(fT, f);
        super.draw(canvas);
        if (this.a == null) {
            canvas2 = canvas;
        } else {
            float fCenterY = getBounds().centerY();
            dqk dqkVar = this.e;
            TextPaint textPaint = dqkVar.a;
            Paint.FontMetrics fontMetrics = this.d;
            textPaint.getFontMetrics(fontMetrics);
            int i = (int) (fCenterY - ((fontMetrics.descent + fontMetrics.ascent) / 2.0f));
            if (dqkVar.g != null) {
                textPaint.drawableState = getState();
                dqkVar.g.s(this.b, dqkVar.a, dqkVar.b);
                textPaint.setAlpha((int) (this.s * 255.0f));
            }
            CharSequence charSequence = this.a;
            canvas2 = canvas;
            canvas2.drawText(charSequence, 0, charSequence.length(), r0.centerX(), i, textPaint);
        }
        canvas2.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return (int) Math.max(this.e.a.getTextSize(), this.j);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        float f = this.h * 2;
        CharSequence charSequence = this.a;
        return (int) Math.max(f + (charSequence == null ? 0.0f : this.e.h(charSequence.toString())), this.i);
    }

    @Override // me.hd.wauxv.obf.cau, android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.l) {
            dgl dglVarQ = this.ct.b.q();
            dglVarQ.k = u();
            setShapeAppearanceModel(dglVarQ.m());
        }
    }

    public final float t() {
        int i;
        Rect rect = this.g;
        if (((rect.right - getBounds().right) - this.o) - this.k < 0) {
            i = ((rect.right - getBounds().right) - this.o) - this.k;
        } else {
            if (((rect.left - getBounds().left) - this.o) + this.k <= 0) {
                return 0.0f;
            }
            i = ((rect.left - getBounds().left) - this.o) + this.k;
        }
        return i;
    }

    public final cqh u() {
        float f = -t();
        float fWidth = ((float) (((double) getBounds().width()) - (Math.sqrt(2.0d) * ((double) this.m)))) / 2.0f;
        return new cqh(new bzq(this.m), Math.min(Math.max(f, -fWidth), fWidth));
    }
}
