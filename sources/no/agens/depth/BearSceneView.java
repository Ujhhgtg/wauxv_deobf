package no.agens.depth;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import me.hd.wauxv.R;
import me.hd.wauxv.obf.cay;
import me.hd.wauxv.obf.HugeSyntheticPileOfHelpers;
import me.hd.wauxv.obf.col;
import me.hd.wauxv.obf.cta;
import me.hd.wauxv.obf.dbi;
import me.hd.wauxv.obf.dih;
import me.hd.wauxv.obf.ely;
import me.hd.wauxv.obf.lr;
import me.hd.wauxv.obf.oq;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class BearSceneView extends View {
    public dbi[] a;
    public float b;
    public float c;
    public float d;
    public cta e;
    public cta f;
    public dih g;
    public int h;
    public boolean i;
    public long j;
    public final float k;
    public final float l;
    public final float m;

    public BearSceneView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = 10.0f;
        this.h = 0;
        this.i = false;
        this.k = 0.8f;
        this.l = 0.4f;
        this.m = 0.6f;
    }

    public final void n(Bitmap bitmap, float f, float f2, float f3, float f4) {
        this.a[this.h] = new ely(bitmap, f, f2, f4);
        this.a[this.h].x(f3, f3);
        this.h++;
    }

    public final void o() {
        this.a = new dbi[17];
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(getResources(), R.mipmap.tree);
        n(bitmapDecodeResource, getMeasuredWidth() * 0.18f, getMeasuredHeight() * (-0.65f), 0.28f, 0.46f);
        n(bitmapDecodeResource, getMeasuredWidth() * 0.6f, getMeasuredHeight() * (-0.65f), 0.33f, 0.46f);
        n(bitmapDecodeResource, 0.45f * getMeasuredWidth(), (-0.45f) * getMeasuredHeight(), 0.5f, 0.8f);
        n(bitmapDecodeResource, 0.13f * getMeasuredWidth(), getMeasuredHeight() * (-0.65f), 0.3f, 0.46f);
        n(bitmapDecodeResource, 0.83f * getMeasuredWidth(), (-0.2f) * getMeasuredHeight(), 0.5f, 1.0f);
        n(bitmapDecodeResource, 0.02f * getMeasuredWidth(), getMeasuredHeight() * (-0.1f), 0.8f, 1.0f);
        n(bitmapDecodeResource, getMeasuredWidth() * 0.18f, 0.15f * getMeasuredHeight(), 0.8f, 1.0f);
        n(bitmapDecodeResource, 0.7f * getMeasuredWidth(), getMeasuredHeight() * (-0.1f), 0.8f, 1.0f);
        Bitmap bitmapDecodeResource2 = BitmapFactory.decodeResource(getResources(), R.mipmap.bear_1);
        Bitmap bitmapDecodeResource3 = BitmapFactory.decodeResource(getResources(), R.mipmap.bear_2);
        Bitmap bitmapDecodeResource4 = BitmapFactory.decodeResource(getResources(), R.mipmap.bear_white);
        Bitmap bitmapDecodeResource5 = BitmapFactory.decodeResource(getResources(), R.drawable.stones);
        Bitmap bitmapDecodeResource6 = BitmapFactory.decodeResource(getResources(), R.drawable.smoke);
        Bitmap bitmapDecodeResource7 = BitmapFactory.decodeResource(getResources(), R.drawable.grunge);
        float measuredWidth = getMeasuredWidth() * 0.61f;
        float measuredHeight = getMeasuredHeight() * 0.8f;
        this.a[this.h] = new lr(getResources().getDrawable(R.drawable.aura_gradient), new Rect((int) (getMeasuredWidth() * 0.44f), (int) (getMeasuredHeight() * 0.4f), (int) (getMeasuredWidth() * 0.8f), (int) (getMeasuredHeight() * 1.1f)));
        int i = this.h + 1;
        this.h = i;
        this.a[i] = new lr(getResources().getDrawable(R.drawable.aura_gradient_inner), new Rect((int) (getMeasuredWidth() * 0.5f), (int) (getMeasuredHeight() * 0.6f), (int) (getMeasuredWidth() * 0.72f), (int) (getMeasuredHeight() * 1.0f)));
        this.h++;
        float f = getResources().getDisplayMetrics().density;
        float f2 = f * 5.0f;
        float f3 = f * (-30.0f);
        this.e = new cta(measuredWidth, measuredHeight, 30, f3, f2);
        this.f = new cta(measuredWidth, measuredHeight, 600, f3, f2);
        dbi[] dbiVarArr = this.a;
        int i2 = this.h;
        cta ctaVar = this.e;
        dbiVarArr[i2] = ctaVar;
        ctaVar.l = (int) (8.0f * f);
        ctaVar.m = 20.0f * f;
        ctaVar.j = 1.5f * f;
        ctaVar.p(getResources().getColor(R.color.fire_start_color), getResources().getColor(R.color.fire_end_color));
        int i3 = this.h + 1;
        this.h = i3;
        dbi[] dbiVarArr2 = this.a;
        cta ctaVar2 = this.f;
        dbiVarArr2[i3] = ctaVar2;
        ctaVar2.l = (int) (f * 1.0f);
        ctaVar2.m = 25.0f * f;
        ctaVar2.j = 2.5f * f;
        ctaVar2.k = 900;
        ctaVar2.p(getResources().getColor(R.color.fire_start_color), getResources().getColor(R.color.fire_start_color));
        this.f.i = 0.0f;
        int i4 = this.h;
        int i5 = i4 + 1;
        this.h = i5;
        this.a[i5] = new dbi(bitmapDecodeResource5, measuredWidth - (f2 * 2.0f), measuredHeight);
        this.h = i4 + 2;
        dih dihVar = new dih(bitmapDecodeResource6, measuredWidth, getMeasuredHeight() * 0.68f, f * 110.0f, f * 60.0f, f);
        this.g = dihVar;
        dbi[] dbiVarArr3 = this.a;
        int i6 = this.h;
        dbiVarArr3[i6] = dihVar;
        this.h = i6 + 1;
        dbi[] dbiVarArr4 = this.a;
        int i7 = this.h;
        oq oqVar = new oq(null, getMeasuredWidth() * 0.636f, getMeasuredHeight() * 0.59f);
        oqVar.e = 0;
        oqVar.a = System.currentTimeMillis();
        oqVar.b = new Bitmap[]{bitmapDecodeResource2, bitmapDecodeResource3};
        dbiVarArr4[i7] = oqVar;
        this.h++;
        dbi[] dbiVarArr5 = this.a;
        int i8 = this.h;
        dbiVarArr5[i8] = new dbi(bitmapDecodeResource4, getMeasuredWidth() * 0.44f, getMeasuredHeight() * 0.66f);
        this.h = i8 + 1;
        setLayerType(2, null);
        col colVar = new col(bitmapDecodeResource7);
        this.a[this.h] = colVar;
        colVar.a.setAlpha((int) 63.75f);
        this.h++;
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.a != null || getWidth() == 0) {
            return;
        }
        o();
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        for (dbi dbiVar : this.a) {
            dbiVar.f();
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float fBn = HugeSyntheticPileOfHelpers.bn();
        float f = this.d;
        this.d = ((this.c - f) * 4.0f * fBn) + f;
        for (dbi dbiVar : this.a) {
            dbiVar.c(canvas);
            if ((dbiVar instanceof dih) || (dbiVar instanceof cta)) {
                dbiVar.d(fBn, this.b);
            } else {
                dbiVar.d(fBn, this.b + this.d);
            }
        }
        if (this.j + 300 < System.currentTimeMillis()) {
            this.j = System.currentTimeMillis();
            this.c = cay.a.nextInt((int) r8) - (Math.max(this.b / 2.0f, 1.0f) / 2.0f);
        }
        if (this.i) {
            return;
        }
        invalidate();
    }

    @Override // android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.a == null) {
            o();
        }
    }

    public void setFlamesHeight(int i) {
        float f = this.l;
        float f2 = this.k;
        float f3 = i / 100.0f;
        this.e.i = getHeight() * (f2 - ((f2 - f) * f3));
        float height = getHeight() * (f2 - ((f2 - this.m) * f3));
        dih dihVar = this.g;
        dihVar.r = height;
        dihVar.y();
    }

    public void setPause(boolean z) {
        this.i = z;
        int i = 0;
        if (z) {
            dbi[] dbiVarArr = this.a;
            int length = dbiVarArr.length;
            while (i < length) {
                dbiVarArr[i].v();
                i++;
            }
            return;
        }
        HugeSyntheticPileOfHelpers.bn();
        invalidate();
        dbi[] dbiVarArr2 = this.a;
        int length2 = dbiVarArr2.length;
        while (i < length2) {
            dbiVarArr2[i].w();
            i++;
        }
    }

    public void setWind(int i) {
        this.b = i;
    }
}
