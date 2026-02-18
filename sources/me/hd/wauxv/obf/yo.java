package me.hd.wauxv.obf;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.android.dx.io.Opcodes;
import com.google.android.material.chip.Chip;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class yo extends cau implements Drawable.Callback, dqj {
    public static final int[] a = {R.attr.state_enabled};
    public static final ShapeDrawable b = new ShapeDrawable(new OvalShape());
    public ColorStateList _bd;
    public cfe aa;
    public cfe ab;
    public float ac;
    public float ad;
    public float ae;
    public float af;
    public float ag;
    public float ah;
    public float ai;
    public float aj;
    public final Context ak;
    public final Paint al;
    public final Paint.FontMetrics am;
    public final RectF an;
    public final PointF ao;
    public final Path ap;
    public final dqk aq;
    public int ar;
    public int as;
    public int at;
    public int au;
    public int av;
    public int aw;
    public boolean ax;
    public int ay;
    public int az;
    public ColorFilter ba;
    public PorterDuffColorFilter bb;
    public ColorStateList bc;
    public PorterDuff.Mode bd;
    public int[] be;
    public ColorStateList bf;
    public WeakReference bg;
    public TextUtils.TruncateAt bh;
    public boolean bi;
    public int bj;
    public boolean bk;
    public ColorStateList d;
    public float e;
    public float f;
    public ColorStateList g;
    public float h;
    public ColorStateList i;
    public CharSequence j;
    public boolean k;
    public Drawable l;
    public ColorStateList m;
    public float o;
    public boolean p;
    public boolean q;
    public Drawable r;
    public RippleDrawable s;
    public ColorStateList t;
    public float u;
    public SpannableStringBuilder v;
    public boolean w;
    public boolean x;
    public Drawable y;
    public ColorStateList z;

    public yo(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, me.hd.wauxv.R.attr.chipStyle, me.hd.wauxv.R.style.Widget_MaterialComponents_Chip_Action);
        this.f = -1.0f;
        this.al = new Paint(1);
        this.am = new Paint.FontMetrics();
        this.an = new RectF();
        this.ao = new PointF();
        this.ap = new Path();
        this.az = Opcodes.CONST_METHOD_TYPE;
        this.bd = PorterDuff.Mode.SRC_IN;
        this.bg = new WeakReference(null);
        dx(context);
        this.ak = context;
        dqk dqkVar = new dqk(this);
        this.aq = dqkVar;
        this.j = "";
        dqkVar.a.density = context.getResources().getDisplayMetrics().density;
        int[] iArr = a;
        setState(iArr);
        if (!Arrays.equals(this.be, iArr)) {
            this.be = iArr;
            if (cr()) {
                bu(getState(), iArr);
            }
        }
        this.bi = true;
        int[] iArr2 = ddb.a;
        b.setTint(-1);
    }

    public static boolean bl(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    public static boolean bm(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    public static void bn(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public final void bo(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setCallback(this);
        drawable.setLayoutDirection(getLayoutDirection());
        drawable.setLevel(getLevel());
        drawable.setVisible(isVisible(), false);
        if (drawable == this.r) {
            if (drawable.isStateful()) {
                drawable.setState(this.be);
            }
            drawable.setTintList(this.t);
            return;
        }
        Drawable drawable2 = this.l;
        if (drawable == drawable2 && this.p) {
            drawable2.setTintList(this.m);
        }
        if (drawable.isStateful()) {
            drawable.setState(getState());
        }
    }

    public final void bp(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (cq() || cp()) {
            float f = this.ac + this.ad;
            Drawable drawable = this.ax ? this.y : this.l;
            float intrinsicWidth = this.o;
            if (intrinsicWidth <= 0.0f && drawable != null) {
                intrinsicWidth = drawable.getIntrinsicWidth();
            }
            if (getLayoutDirection() == 0) {
                float f2 = rect.left + f;
                rectF.left = f2;
                rectF.right = f2 + intrinsicWidth;
            } else {
                float f3 = rect.right - f;
                rectF.right = f3;
                rectF.left = f3 - intrinsicWidth;
            }
            Drawable drawable2 = this.ax ? this.y : this.l;
            float fCeil = this.o;
            if (fCeil <= 0.0f && drawable2 != null) {
                fCeil = (float) Math.ceil(ewz.ag(this.ak, 24));
                if (drawable2.getIntrinsicHeight() <= fCeil) {
                    fCeil = drawable2.getIntrinsicHeight();
                }
            }
            float fExactCenterY = rect.exactCenterY() - (fCeil / 2.0f);
            rectF.top = fExactCenterY;
            rectF.bottom = fExactCenterY + fCeil;
        }
    }

    public final float bq() {
        if (!cq() && !cp()) {
            return 0.0f;
        }
        float f = this.ad;
        Drawable drawable = this.ax ? this.y : this.l;
        float intrinsicWidth = this.o;
        if (intrinsicWidth <= 0.0f && drawable != null) {
            intrinsicWidth = drawable.getIntrinsicWidth();
        }
        return intrinsicWidth + f + this.ae;
    }

    public final float br() {
        if (cr()) {
            return this.ah + this.u + this.ai;
        }
        return 0.0f;
    }

    public final float bs() {
        return this.bk ? dv() : this.f;
    }

    public final void bt() {
        yn ynVar = (yn) this.bg.get();
        if (ynVar != null) {
            Chip chip = (Chip) ynVar;
            chip.x(chip.o);
            chip.requestLayout();
            chip.invalidateOutline();
        }
    }

    public final boolean bu(int[] iArr, int[] iArr2) {
        boolean z;
        boolean z2;
        ColorStateList colorStateList;
        boolean zOnStateChange = super.onStateChange(iArr);
        ColorStateList colorStateList2 = this._bd;
        int iDr = dr(colorStateList2 != null ? colorStateList2.getColorForState(iArr, this.ar) : 0);
        boolean state = true;
        if (this.ar != iDr) {
            this.ar = iDr;
            zOnStateChange = true;
        }
        ColorStateList colorStateList3 = this.d;
        int iDr2 = dr(colorStateList3 != null ? colorStateList3.getColorForState(iArr, this.as) : 0);
        if (this.as != iDr2) {
            this.as = iDr2;
            zOnStateChange = true;
        }
        int iD = abi.d(iDr2, iDr);
        if ((this.at != iD) | (this.ct.d == null)) {
            this.at = iD;
            dz(ColorStateList.valueOf(iD));
            zOnStateChange = true;
        }
        ColorStateList colorStateList4 = this.g;
        int colorForState = colorStateList4 != null ? colorStateList4.getColorForState(iArr, this.au) : 0;
        if (this.au != colorForState) {
            this.au = colorForState;
            zOnStateChange = true;
        }
        int colorForState2 = (this.bf == null || !ddb.j(iArr)) ? 0 : this.bf.getColorForState(iArr, this.av);
        if (this.av != colorForState2) {
            this.av = colorForState2;
        }
        dqh dqhVar = this.aq.g;
        int colorForState3 = (dqhVar == null || (colorStateList = dqhVar.j) == null) ? 0 : colorStateList.getColorForState(iArr, this.aw);
        if (this.aw != colorForState3) {
            this.aw = colorForState3;
            zOnStateChange = true;
        }
        int[] state2 = getState();
        if (state2 != null) {
            int length = state2.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    if (state2[i] != 16842912) {
                        i++;
                    } else if (this.w) {
                        z = true;
                        break;
                    }
                }
                z = false;
                break;
            }
        } else {
            z = false;
            break;
        }
        if (this.ax == z || this.y == null) {
            z2 = false;
        } else {
            float fBq = bq();
            this.ax = z;
            if (fBq != bq()) {
                zOnStateChange = true;
                z2 = true;
            } else {
                z2 = false;
                zOnStateChange = true;
            }
        }
        ColorStateList colorStateList5 = this.bc;
        int colorForState4 = colorStateList5 != null ? colorStateList5.getColorForState(iArr, this.ay) : 0;
        if (this.ay != colorForState4) {
            this.ay = colorForState4;
            ColorStateList colorStateList6 = this.bc;
            PorterDuff.Mode mode = this.bd;
            this.bb = (colorStateList6 == null || mode == null) ? null : new PorterDuffColorFilter(colorStateList6.getColorForState(getState(), 0), mode);
        } else {
            state = zOnStateChange;
        }
        if (bm(this.l)) {
            state |= this.l.setState(iArr);
        }
        if (bm(this.y)) {
            state |= this.y.setState(iArr);
        }
        if (bm(this.r)) {
            int[] iArr3 = new int[iArr.length + iArr2.length];
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            System.arraycopy(iArr2, 0, iArr3, iArr.length, iArr2.length);
            state |= this.r.setState(iArr3);
        }
        int[] iArr4 = ddb.a;
        if (bm(this.s)) {
            state |= this.s.setState(iArr2);
        }
        if (state) {
            invalidateSelf();
        }
        if (z2) {
            bt();
        }
        return state;
    }

    public final void bv(boolean z) {
        if (this.w != z) {
            this.w = z;
            float fBq = bq();
            if (!z && this.ax) {
                this.ax = false;
            }
            float fBq2 = bq();
            invalidateSelf();
            if (fBq != fBq2) {
                bt();
            }
        }
    }

    public final void bw(Drawable drawable) {
        if (this.y != drawable) {
            float fBq = bq();
            this.y = drawable;
            float fBq2 = bq();
            bn(this.y);
            bo(this.y);
            invalidateSelf();
            if (fBq != fBq2) {
                bt();
            }
        }
    }

    public final void bx(ColorStateList colorStateList) {
        Drawable drawable;
        if (this.z != colorStateList) {
            this.z = colorStateList;
            if (this.x && (drawable = this.y) != null && this.w) {
                drawable.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void by(boolean z) {
        if (this.x != z) {
            boolean zCp = cp();
            this.x = z;
            boolean zCp2 = cp();
            if (zCp != zCp2) {
                if (zCp2) {
                    bo(this.y);
                } else {
                    bn(this.y);
                }
                invalidateSelf();
                bt();
            }
        }
    }

    public final void bz(float f) {
        if (this.f != f) {
            this.f = f;
            dgl dglVarQ = this.ct.b.q();
            dglVarQ.n(f);
            setShapeAppearanceModel(dglVarQ.m());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.graphics.drawable.Drawable] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public final void ca(Drawable drawable) {
        ?? r0;
        Object obj = this.l;
        if (obj == null) {
            r0 = 0;
        } else if (obj instanceof ewc) {
            r0 = obj;
            r0 = 0;
        }
        if (r0 != drawable) {
            float fBq = bq();
            this.l = drawable != null ? drawable.mutate() : null;
            float fBq2 = bq();
            bn(r0);
            if (cq()) {
                bo(this.l);
            }
            invalidateSelf();
            if (fBq != fBq2) {
                bt();
            }
        }
    }

    public final void cb(float f) {
        if (this.o != f) {
            float fBq = bq();
            this.o = f;
            float fBq2 = bq();
            invalidateSelf();
            if (fBq != fBq2) {
                bt();
            }
        }
    }

    public final void cc(ColorStateList colorStateList) {
        this.p = true;
        if (this.m != colorStateList) {
            this.m = colorStateList;
            if (cq()) {
                this.l.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void cd(boolean z) {
        if (this.k != z) {
            boolean zCq = cq();
            this.k = z;
            boolean zCq2 = cq();
            if (zCq != zCq2) {
                if (zCq2) {
                    bo(this.l);
                } else {
                    bn(this.l);
                }
                invalidateSelf();
                bt();
            }
        }
    }

    public final void ce(ColorStateList colorStateList) {
        if (this.g != colorStateList) {
            this.g = colorStateList;
            if (this.bk) {
                ed(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void cf(float f) {
        if (this.h != f) {
            this.h = f;
            this.al.setStrokeWidth(f);
            if (this.bk) {
                this.ct.k = f;
                invalidateSelf();
            }
            invalidateSelf();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.graphics.drawable.Drawable] */
    /* JADX WARN: Type inference failed for: r0v6 */
    public final void cg(Drawable drawable) {
        ?? r0;
        Object obj = this.r;
        if (obj == null) {
            r0 = 0;
        } else if (obj instanceof ewc) {
            r0 = obj;
            r0 = 0;
        }
        if (r0 != drawable) {
            float fBr = br();
            this.r = drawable != null ? drawable.mutate() : null;
            int[] iArr = ddb.a;
            this.s = new RippleDrawable(ddb.i(this.i), this.r, b);
            float fBr2 = br();
            bn(r0);
            if (cr()) {
                bo(this.r);
            }
            invalidateSelf();
            if (fBr != fBr2) {
                bt();
            }
        }
    }

    public final void ch(float f) {
        if (this.ai != f) {
            this.ai = f;
            invalidateSelf();
            if (cr()) {
                bt();
            }
        }
    }

    public final void ci(float f) {
        if (this.u != f) {
            this.u = f;
            invalidateSelf();
            if (cr()) {
                bt();
            }
        }
    }

    public final void cj(float f) {
        if (this.ah != f) {
            this.ah = f;
            invalidateSelf();
            if (cr()) {
                bt();
            }
        }
    }

    public final void ck(ColorStateList colorStateList) {
        if (this.t != colorStateList) {
            this.t = colorStateList;
            if (cr()) {
                this.r.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void cl(boolean z) {
        if (this.q != z) {
            boolean zCr = cr();
            this.q = z;
            boolean zCr2 = cr();
            if (zCr != zCr2) {
                if (zCr2) {
                    bo(this.r);
                } else {
                    bn(this.r);
                }
                invalidateSelf();
                bt();
            }
        }
    }

    public final void cm(float f) {
        if (this.ae != f) {
            float fBq = bq();
            this.ae = f;
            float fBq2 = bq();
            invalidateSelf();
            if (fBq != fBq2) {
                bt();
            }
        }
    }

    public final void cn(float f) {
        if (this.ad != f) {
            float fBq = bq();
            this.ad = f;
            float fBq2 = bq();
            invalidateSelf();
            if (fBq != fBq2) {
                bt();
            }
        }
    }

    public final void co(ColorStateList colorStateList) {
        if (this.i != colorStateList) {
            this.i = colorStateList;
            this.bf = null;
            onStateChange(getState());
        }
    }

    public final boolean cp() {
        return this.x && this.y != null && this.ax;
    }

    public final boolean cq() {
        return this.k && this.l != null;
    }

    public final boolean cr() {
        return this.q && this.r != null;
    }

    @Override // me.hd.wauxv.obf.cau, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        int i;
        Canvas canvas2;
        int iSaveLayerAlpha;
        int i2;
        Rect bounds = getBounds();
        if (bounds.isEmpty() || (i = this.az) == 0) {
            return;
        }
        if (i < 255) {
            canvas2 = canvas;
            iSaveLayerAlpha = canvas2.saveLayerAlpha(bounds.left, bounds.top, bounds.right, bounds.bottom, i);
        } else {
            canvas2 = canvas;
            iSaveLayerAlpha = 0;
        }
        boolean z = this.bk;
        Paint paint = this.al;
        RectF rectF = this.an;
        if (!z) {
            paint.setColor(this.ar);
            paint.setStyle(Paint.Style.FILL);
            rectF.set(bounds);
            canvas2.drawRoundRect(rectF, bs(), bs(), paint);
        }
        if (!this.bk) {
            paint.setColor(this.as);
            paint.setStyle(Paint.Style.FILL);
            ColorFilter colorFilter = this.ba;
            if (colorFilter == null) {
                colorFilter = this.bb;
            }
            paint.setColorFilter(colorFilter);
            rectF.set(bounds);
            canvas2.drawRoundRect(rectF, bs(), bs(), paint);
        }
        if (this.bk) {
            super.draw(canvas);
        }
        if (this.h > 0.0f && !this.bk) {
            paint.setColor(this.au);
            paint.setStyle(Paint.Style.STROKE);
            if (!this.bk) {
                ColorFilter colorFilter2 = this.ba;
                if (colorFilter2 == null) {
                    colorFilter2 = this.bb;
                }
                paint.setColorFilter(colorFilter2);
            }
            float f = bounds.left;
            float f2 = this.h / 2.0f;
            rectF.set(f + f2, bounds.top + f2, bounds.right - f2, bounds.bottom - f2);
            float f3 = this.f - (this.h / 2.0f);
            canvas2.drawRoundRect(rectF, f3, f3, paint);
        }
        paint.setColor(this.av);
        paint.setStyle(Paint.Style.FILL);
        rectF.set(bounds);
        if (this.bk) {
            RectF rectF2 = new RectF(bounds);
            cat catVar = this.ct;
            dgm dgmVar = catVar.b;
            float f4 = catVar.j;
            bmu bmuVar = this.dj;
            dgo dgoVar = this.dk;
            Path path = this.ap;
            dgoVar.m(dgmVar, f4, rectF2, bmuVar, path);
            dt(canvas2, paint, path, this.ct.b, du());
        } else {
            canvas2.drawRoundRect(rectF, bs(), bs(), paint);
        }
        if (cq()) {
            bp(bounds, rectF);
            float f5 = rectF.left;
            float f6 = rectF.top;
            canvas2.translate(f5, f6);
            this.l.setBounds(0, 0, (int) rectF.width(), (int) rectF.height());
            this.l.draw(canvas2);
            canvas2.translate(-f5, -f6);
        }
        if (cp()) {
            bp(bounds, rectF);
            float f7 = rectF.left;
            float f8 = rectF.top;
            canvas2.translate(f7, f8);
            this.y.setBounds(0, 0, (int) rectF.width(), (int) rectF.height());
            this.y.draw(canvas2);
            canvas2.translate(-f7, -f8);
        }
        if (this.bi && this.j != null) {
            PointF pointF = this.ao;
            pointF.set(0.0f, 0.0f);
            Paint.Align align = Paint.Align.LEFT;
            CharSequence charSequence = this.j;
            dqk dqkVar = this.aq;
            if (charSequence != null) {
                float fBq = bq() + this.ac + this.af;
                if (getLayoutDirection() == 0) {
                    pointF.x = bounds.left + fBq;
                } else {
                    pointF.x = bounds.right - fBq;
                    align = Paint.Align.RIGHT;
                }
                float fCenterY = bounds.centerY();
                TextPaint textPaint = dqkVar.a;
                Paint.FontMetrics fontMetrics = this.am;
                textPaint.getFontMetrics(fontMetrics);
                pointF.y = fCenterY - ((fontMetrics.descent + fontMetrics.ascent) / 2.0f);
            }
            rectF.setEmpty();
            if (this.j != null) {
                float fBq2 = bq() + this.ac + this.af;
                float fBr = br() + this.aj + this.ag;
                if (getLayoutDirection() == 0) {
                    rectF.left = bounds.left + fBq2;
                    rectF.right = bounds.right - fBr;
                } else {
                    rectF.left = bounds.left + fBr;
                    rectF.right = bounds.right - fBq2;
                }
                rectF.top = bounds.top;
                rectF.bottom = bounds.bottom;
            }
            dqh dqhVar = dqkVar.g;
            TextPaint textPaint2 = dqkVar.a;
            if (dqhVar != null) {
                textPaint2.drawableState = getState();
                dqkVar.g.s(this.ak, textPaint2, dqkVar.b);
            }
            textPaint2.setTextAlign(align);
            boolean z2 = Math.round(dqkVar.h(this.j.toString())) > Math.round(rectF.width());
            if (z2) {
                int iSave = canvas2.save();
                canvas2.clipRect(rectF);
                i2 = iSave;
            } else {
                i2 = 0;
            }
            CharSequence charSequenceEllipsize = this.j;
            if (z2 && this.bh != null) {
                charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, textPaint2, rectF.width(), this.bh);
            }
            canvas.drawText(charSequenceEllipsize, 0, charSequenceEllipsize.length(), pointF.x, pointF.y, textPaint2);
            canvas2 = canvas;
            if (z2) {
                canvas2.restoreToCount(i2);
            }
        }
        if (cr()) {
            rectF.setEmpty();
            if (cr()) {
                float f9 = this.aj + this.ai;
                if (getLayoutDirection() == 0) {
                    float f10 = bounds.right - f9;
                    rectF.right = f10;
                    rectF.left = f10 - this.u;
                } else {
                    float f11 = bounds.left + f9;
                    rectF.left = f11;
                    rectF.right = f11 + this.u;
                }
                float fExactCenterY = bounds.exactCenterY();
                float f12 = this.u;
                float f13 = fExactCenterY - (f12 / 2.0f);
                rectF.top = f13;
                rectF.bottom = f13 + f12;
            }
            float f14 = rectF.left;
            float f15 = rectF.top;
            canvas2.translate(f14, f15);
            this.r.setBounds(0, 0, (int) rectF.width(), (int) rectF.height());
            int[] iArr = ddb.a;
            this.s.setBounds(this.r.getBounds());
            this.s.jumpToCurrentState();
            this.s.draw(canvas2);
            canvas2.translate(-f14, -f15);
        }
        if (this.az < 255) {
            canvas2.restoreToCount(iSaveLayerAlpha);
        }
    }

    @Override // me.hd.wauxv.obf.cau, android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.az;
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        return this.ba;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return (int) this.e;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return Math.min(Math.round(br() + this.aq.h(this.j.toString()) + bq() + this.ac + this.af + this.ag + this.aj), this.bj);
    }

    @Override // me.hd.wauxv.obf.cau, android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // me.hd.wauxv.obf.cau, android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        Outline outline2;
        if (this.bk) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (bounds.isEmpty()) {
            outline2 = outline;
            outline2.setRoundRect(0, 0, getIntrinsicWidth(), (int) this.e, this.f);
        } else {
            outline.setRoundRect(bounds, this.f);
            outline2 = outline;
        }
        outline2.setAlpha(this.az / 255.0f);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // me.hd.wauxv.obf.cau, android.graphics.drawable.Drawable
    public final boolean isStateful() {
        ColorStateList colorStateList;
        if (bl(this._bd) || bl(this.d) || bl(this.g)) {
            return true;
        }
        dqh dqhVar = this.aq.g;
        if (dqhVar == null || (colorStateList = dqhVar.j) == null || !colorStateList.isStateful()) {
            return (this.x && this.y != null && this.w) || bm(this.l) || bm(this.y) || bl(this.bc);
        }
        return true;
    }

    @Override // me.hd.wauxv.obf.cau, me.hd.wauxv.obf.dqj
    public final void n() {
        bt();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLayoutDirectionChanged(int i) {
        boolean zOnLayoutDirectionChanged = super.onLayoutDirectionChanged(i);
        if (cq()) {
            zOnLayoutDirectionChanged |= this.l.setLayoutDirection(i);
        }
        if (cp()) {
            zOnLayoutDirectionChanged |= this.y.setLayoutDirection(i);
        }
        if (cr()) {
            zOnLayoutDirectionChanged |= this.r.setLayoutDirection(i);
        }
        if (!zOnLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i) {
        boolean zOnLevelChange = super.onLevelChange(i);
        if (cq()) {
            zOnLevelChange |= this.l.setLevel(i);
        }
        if (cp()) {
            zOnLevelChange |= this.y.setLevel(i);
        }
        if (cr()) {
            zOnLevelChange |= this.r.setLevel(i);
        }
        if (zOnLevelChange) {
            invalidateSelf();
        }
        return zOnLevelChange;
    }

    @Override // me.hd.wauxv.obf.cau, android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        if (this.bk) {
            super.onStateChange(iArr);
        }
        return bu(iArr, this.be);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    @Override // me.hd.wauxv.obf.cau, android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        if (this.az != i) {
            this.az = i;
            invalidateSelf();
        }
    }

    @Override // me.hd.wauxv.obf.cau, android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        if (this.ba != colorFilter) {
            this.ba = colorFilter;
            invalidateSelf();
        }
    }

    @Override // me.hd.wauxv.obf.cau, android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        if (this.bc != colorStateList) {
            this.bc = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // me.hd.wauxv.obf.cau, android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        if (this.bd != mode) {
            this.bd = mode;
            ColorStateList colorStateList = this.bc;
            this.bb = (colorStateList == null || mode == null) ? null : new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (cq()) {
            visible |= this.l.setVisible(z, z2);
        }
        if (cp()) {
            visible |= this.y.setVisible(z, z2);
        }
        if (cr()) {
            visible |= this.r.setVisible(z, z2);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }
}
