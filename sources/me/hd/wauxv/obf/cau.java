package me.hd.wauxv.obf;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import java.util.BitSet;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class cau extends Drawable implements dgx {
    public static final Paint cs;
    public cat ct;
    public final dgv[] cu;
    public final dgv[] cv;
    public final BitSet cw;
    public boolean cx;
    public final Matrix cy;
    public final Path cz;
    public final Path da;
    public final RectF db;
    public final RectF dc;
    public final Region dd;
    public final Region de;
    public dgm df;
    public final Paint dg;
    public final Paint dh;
    public final dgk di;
    public final bmu dj;
    public final dgo dk;
    public PorterDuffColorFilter dl;
    public PorterDuffColorFilter dm;
    public int dn;

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public final RectF f3do;
    public boolean dp;

    static {
        Paint paint = new Paint(1);
        cs = paint;
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    public cau() {
        this(new dgm());
    }

    public void c(Canvas canvas) {
        dgm dgmVar = this.df;
        RectF rectFDu = du();
        RectF rectF = this.dc;
        rectF.set(rectFDu);
        boolean zDw = dw();
        Paint paint = this.dh;
        float strokeWidth = zDw ? paint.getStrokeWidth() / 2.0f : 0.0f;
        rectF.inset(strokeWidth, strokeWidth);
        dt(canvas, paint, this.da, dgmVar, rectF);
    }

    public final void dq(RectF rectF, Path path) {
        cat catVar = this.ct;
        this.dk.m(catVar.b, catVar.j, rectF, this.dj, path);
        if (this.ct.i != 1.0f) {
            Matrix matrix = this.cy;
            matrix.reset();
            float f = this.ct.i;
            matrix.setScale(f, f, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(matrix);
        }
        path.computeBounds(this.f3do, true);
    }

    public final int dr(int i) {
        cat catVar = this.ct;
        float f = catVar.n + 0.0f + catVar.m;
        asy asyVar = catVar.c;
        return asyVar != null ? asyVar.g(i, f) : i;
    }

    /* JADX WARN: Found duplicated region for block: B:40:0x00f7  */
    /* JADX WARN: Found duplicated region for block: B:42:0x0122  */
    /* JADX WARN: Found duplicated region for block: B:43:0x012a  */
    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int iWidth;
        PorterDuffColorFilter porterDuffColorFilter = this.dl;
        Paint paint = this.dg;
        paint.setColorFilter(porterDuffColorFilter);
        int alpha = paint.getAlpha();
        int i = this.ct.l;
        paint.setAlpha(((i + (i >>> 7)) * alpha) >>> 8);
        PorterDuffColorFilter porterDuffColorFilter2 = this.dm;
        Paint paint2 = this.dh;
        paint2.setColorFilter(porterDuffColorFilter2);
        paint2.setStrokeWidth(this.ct.k);
        int alpha2 = paint2.getAlpha();
        int i2 = this.ct.l;
        paint2.setAlpha(((i2 + (i2 >>> 7)) * alpha2) >>> 8);
        boolean z = this.cx;
        Path path = this.cz;
        if (z) {
            float f = -(dw() ? paint2.getStrokeWidth() / 2.0f : 0.0f);
            dgm dgmVar = this.ct.b;
            dgl dglVarQ = dgmVar.q();
            ahe edVar = dgmVar.e;
            if (!(edVar instanceof dat)) {
                edVar = new ed(f, edVar);
            }
            dglVarQ.e = edVar;
            ahe edVar2 = dgmVar.f;
            if (!(edVar2 instanceof dat)) {
                edVar2 = new ed(f, edVar2);
            }
            dglVarQ.f = edVar2;
            ahe edVar3 = dgmVar.h;
            if (!(edVar3 instanceof dat)) {
                edVar3 = new ed(f, edVar3);
            }
            dglVarQ.h = edVar3;
            ahe edVar4 = dgmVar.g;
            if (!(edVar4 instanceof dat)) {
                edVar4 = new ed(f, edVar4);
            }
            dglVarQ.g = edVar4;
            dgm dgmVarM = dglVarQ.m();
            this.df = dgmVarM;
            float f2 = this.ct.j;
            RectF rectFDu = du();
            RectF rectF = this.dc;
            rectF.set(rectFDu);
            float strokeWidth = dw() ? paint2.getStrokeWidth() / 2.0f : 0.0f;
            rectF.inset(strokeWidth, strokeWidth);
            this.dk.m(dgmVarM, f2, rectF, null, this.da);
            dq(du(), path);
            this.cx = false;
        }
        cat catVar = this.ct;
        int i3 = catVar.o;
        if (i3 != 1 && catVar.p > 0) {
            if (i3 != 2) {
                int i4 = Build.VERSION.SDK_INT;
                if (!catVar.b.p(du()) && !path.isConvex() && i4 < 29) {
                    canvas.save();
                    double d = 0;
                    canvas.translate((int) (Math.sin(Math.toRadians(d)) * ((double) this.ct.q)), (int) (Math.cos(Math.toRadians(d)) * ((double) this.ct.q)));
                    if (!this.dp) {
                        RectF rectF2 = this.f3do;
                        iWidth = (int) (rectF2.width() - getBounds().width());
                        int iHeight = (int) (rectF2.height() - getBounds().height());
                        if (iWidth >= 0 || iHeight < 0) {
                            throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
                        }
                        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bjs.c(this.ct.p, 2, (int) rectF2.width(), iWidth), bjs.c(this.ct.p, 2, (int) rectF2.height(), iHeight), Bitmap.Config.ARGB_8888);
                        Canvas canvas2 = new Canvas(bitmapCreateBitmap);
                        float f3 = (getBounds().left - this.ct.p) - iWidth;
                        float f4 = (getBounds().top - this.ct.p) - iHeight;
                        canvas2.translate(-f3, -f4);
                        ds(canvas2);
                        canvas.drawBitmap(bitmapCreateBitmap, f3, f4, (Paint) null);
                        bitmapCreateBitmap.recycle();
                        canvas.restore();
                    } else {
                        ds(canvas);
                        canvas.restore();
                    }
                }
            } else {
                canvas.save();
                double d2 = 0;
                canvas.translate((int) (Math.sin(Math.toRadians(d2)) * ((double) this.ct.q)), (int) (Math.cos(Math.toRadians(d2)) * ((double) this.ct.q)));
                if (!this.dp) {
                    RectF rectF22 = this.f3do;
                    iWidth = (int) (rectF22.width() - getBounds().width());
                    int iHeight2 = (int) (rectF22.height() - getBounds().height());
                    if (iWidth >= 0) {
                    }
                    throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
                }
                ds(canvas);
                canvas.restore();
            }
        }
        cat catVar2 = this.ct;
        Paint.Style style = catVar2.r;
        if (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.FILL) {
            dt(canvas, paint, path, catVar2.b, du());
        }
        if (dw()) {
            c(canvas);
        }
        paint.setAlpha(alpha);
        paint2.setAlpha(alpha2);
    }

    public final void ds(Canvas canvas) {
        if (this.cw.cardinality() > 0) {
            Log.w("ᛱᛱᲀᤝᛳ", "Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        int i = this.ct.q;
        Path path = this.cz;
        dgk dgkVar = this.di;
        if (i != 0) {
            canvas.drawPath(path, dgkVar.e);
        }
        for (int i2 = 0; i2 < 4; i2++) {
            dgv dgvVar = this.cu[i2];
            int i3 = this.ct.p;
            Matrix matrix = dgv.f;
            dgvVar.c(matrix, dgkVar, i3, canvas);
            this.cv[i2].c(matrix, dgkVar, this.ct.p, canvas);
        }
        if (this.dp) {
            double d = 0;
            int iSin = (int) (Math.sin(Math.toRadians(d)) * ((double) this.ct.q));
            int iCos = (int) (Math.cos(Math.toRadians(d)) * ((double) this.ct.q));
            canvas.translate(-iSin, -iCos);
            canvas.drawPath(path, cs);
            canvas.translate(iSin, iCos);
        }
    }

    public final void dt(Canvas canvas, Paint paint, Path path, dgm dgmVar, RectF rectF) {
        if (!dgmVar.p(rectF)) {
            canvas.drawPath(path, paint);
        } else {
            float fB = dgmVar.f.b(rectF) * this.ct.j;
            canvas.drawRoundRect(rectF, fB, fB, paint);
        }
    }

    public final RectF du() {
        Rect bounds = getBounds();
        RectF rectF = this.db;
        rectF.set(bounds);
        return rectF;
    }

    public final float dv() {
        return this.ct.b.e.b(du());
    }

    public final boolean dw() {
        Paint.Style style = this.ct.r;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.dh.getStrokeWidth() > 0.0f;
    }

    public final void dx(Context context) {
        this.ct.c = new asy(context);
        eg();
    }

    public final void dy(float f) {
        cat catVar = this.ct;
        if (catVar.n != f) {
            catVar.n = f;
            eg();
        }
    }

    public final void dz(ColorStateList colorStateList) {
        cat catVar = this.ct;
        if (catVar.d != colorStateList) {
            catVar.d = colorStateList;
            onStateChange(getState());
        }
    }

    public final void ea(float f) {
        cat catVar = this.ct;
        if (catVar.j != f) {
            catVar.j = f;
            this.cx = true;
            invalidateSelf();
        }
    }

    public final void eb() {
        this.di.m(-12303292);
        this.ct.getClass();
        super.invalidateSelf();
    }

    public final void ec() {
        cat catVar = this.ct;
        if (catVar.o != 2) {
            catVar.o = 2;
            super.invalidateSelf();
        }
    }

    public final void ed(ColorStateList colorStateList) {
        cat catVar = this.ct;
        if (catVar.e != colorStateList) {
            catVar.e = colorStateList;
            onStateChange(getState());
        }
    }

    public final boolean ee(int[] iArr) {
        boolean z;
        Paint paint;
        int color;
        int colorForState;
        Paint paint2;
        int color2;
        int colorForState2;
        if (this.ct.d == null || color2 == (colorForState2 = this.ct.d.getColorForState(iArr, (color2 = (paint2 = this.dg).getColor())))) {
            z = false;
        } else {
            paint2.setColor(colorForState2);
            z = true;
        }
        if (this.ct.e == null || color == (colorForState = this.ct.e.getColorForState(iArr, (color = (paint = this.dh).getColor())))) {
            return z;
        }
        paint.setColor(colorForState);
        return true;
    }

    public final boolean ef() {
        PorterDuffColorFilter porterDuffColorFilter;
        PorterDuffColorFilter porterDuffColorFilter2 = this.dl;
        PorterDuffColorFilter porterDuffColorFilter3 = this.dm;
        cat catVar = this.ct;
        ColorStateList colorStateList = catVar.f;
        PorterDuff.Mode mode = catVar.g;
        if (colorStateList == null || mode == null) {
            int color = this.dg.getColor();
            int iDr = dr(color);
            this.dn = iDr;
            porterDuffColorFilter = iDr != color ? new PorterDuffColorFilter(iDr, PorterDuff.Mode.SRC_IN) : null;
        } else {
            int iDr2 = dr(colorStateList.getColorForState(getState(), 0));
            this.dn = iDr2;
            porterDuffColorFilter = new PorterDuffColorFilter(iDr2, mode);
        }
        this.dl = porterDuffColorFilter;
        this.ct.getClass();
        this.dm = null;
        this.ct.getClass();
        return (Objects.equals(porterDuffColorFilter2, this.dl) && Objects.equals(porterDuffColorFilter3, this.dm)) ? false : true;
    }

    public final void eg() {
        cat catVar = this.ct;
        float f = catVar.n + 0.0f;
        catVar.p = (int) Math.ceil(0.75f * f);
        this.ct.q = (int) Math.ceil(f * 0.25f);
        ef();
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.ct.l;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        return this.ct;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        cat catVar = this.ct;
        if (catVar.o == 2) {
            return;
        }
        if (catVar.b.p(du())) {
            outline.setRoundRect(getBounds(), dv() * this.ct.j);
            return;
        }
        RectF rectFDu = du();
        Path path = this.cz;
        dq(rectFDu, path);
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            apx.a(outline, path);
            return;
        }
        if (i >= 29) {
            try {
                apw.a(outline, path);
            } catch (IllegalArgumentException unused) {
            }
        } else if (path.isConvex()) {
            apw.a(outline, path);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean getPadding(Rect rect) {
        Rect rect2 = this.ct.h;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final Region getTransparentRegion() {
        Rect bounds = getBounds();
        Region region = this.dd;
        region.set(bounds);
        RectF rectFDu = du();
        Path path = this.cz;
        dq(rectFDu, path);
        Region region2 = this.de;
        region2.setPath(path, region);
        region.op(region2, Region.Op.DIFFERENCE);
        return region;
    }

    @Override // android.graphics.drawable.Drawable
    public final void invalidateSelf() {
        this.cx = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (super.isStateful()) {
            return true;
        }
        ColorStateList colorStateList = this.ct.f;
        if (colorStateList != null && colorStateList.isStateful()) {
            return true;
        }
        this.ct.getClass();
        ColorStateList colorStateList2 = this.ct.e;
        if (colorStateList2 != null && colorStateList2.isStateful()) {
            return true;
        }
        ColorStateList colorStateList3 = this.ct.d;
        return colorStateList3 != null && colorStateList3.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.ct = new cat(this.ct);
        return this;
    }

    public void n() {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.cx = true;
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean z = ee(iArr) || ef();
        if (z) {
            invalidateSelf();
        }
        return z;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        cat catVar = this.ct;
        if (catVar.l != i) {
            catVar.l = i;
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.ct.getClass();
        super.invalidateSelf();
    }

    @Override // me.hd.wauxv.obf.dgx
    public final void setShapeAppearanceModel(dgm dgmVar) {
        this.ct.b = dgmVar;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.ct.f = colorStateList;
        ef();
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        cat catVar = this.ct;
        if (catVar.g != mode) {
            catVar.g = mode;
            ef();
            super.invalidateSelf();
        }
    }

    public cau(Context context, AttributeSet attributeSet, int i, int i2) {
        this(dgm.n(context, attributeSet, i, i2).m());
    }

    public cau(dgm dgmVar) {
        this(new cat(dgmVar));
    }

    public cau(cat catVar) {
        dgo dgoVar;
        this.cu = new dgv[4];
        this.cv = new dgv[4];
        this.cw = new BitSet(8);
        this.cy = new Matrix();
        this.cz = new Path();
        this.da = new Path();
        this.db = new RectF();
        this.dc = new RectF();
        this.dd = new Region();
        this.de = new Region();
        Paint paint = new Paint(1);
        this.dg = paint;
        Paint paint2 = new Paint(1);
        this.dh = paint2;
        this.di = new dgk();
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            dgoVar = dgn.a;
        } else {
            dgoVar = new dgo();
        }
        this.dk = dgoVar;
        this.f3do = new RectF();
        this.dp = true;
        this.ct = catVar;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        ef();
        ee(getState());
        this.dj = new bmu(this);
    }
}
