package me.hd.wauxv.obf;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.ViewGroup;
import com.android.dx.io.Opcodes;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class aat {
    public final ViewGroup a;
    public Typeface aa;
    public Typeface ab;
    public Typeface ac;
    public ta ad;
    public ta ae;
    public CharSequence ag;
    public CharSequence ah;
    public boolean ai;
    public Bitmap ak;
    public float al;
    public float am;
    public float an;
    public float ao;
    public float ap;
    public int aq;
    public int[] ar;
    public boolean as;
    public final TextPaint at;
    public final TextPaint au;
    public TimeInterpolator av;
    public TimeInterpolator aw;
    public float ax;
    public float ay;
    public float az;
    public float b;
    public ColorStateList ba;
    public float bb;
    public float bc;
    public float bd;
    public ColorStateList be;
    public float bf;
    public float bg;
    public float bh;
    public StaticLayout bi;
    public float bj;
    public float bk;
    public float bl;
    public CharSequence bm;
    public boolean c;
    public float d;
    public float e;
    public int f;
    public final Rect g;
    public final Rect h;
    public final RectF i;
    public ColorStateList n;
    public ColorStateList o;
    public int p;
    public float q;
    public float r;
    public float s;
    public float t;
    public float u;
    public float v;
    public Typeface w;
    public Typeface x;
    public Typeface y;
    public Typeface z;
    public int j = 16;
    public int k = 16;
    public float l = 15.0f;
    public float m = 15.0f;
    public TextUtils.TruncateAt af = TextUtils.TruncateAt.END;
    public boolean aj = true;
    public int bn = 1;
    public float bo = 0.0f;
    public float bp = 1.0f;
    public int bq = 1;

    public aat(ViewGroup viewGroup) {
        this.a = viewGroup;
        TextPaint textPaint = new TextPaint(129);
        this.at = textPaint;
        this.au = new TextPaint(textPaint);
        this.h = new Rect();
        this.g = new Rect();
        this.i = new RectF();
        float f = this.d;
        this.e = yg.a(1.0f, f, 0.5f, f);
        by(viewGroup.getContext().getResources().getConfiguration());
    }

    public static int br(int i, float f, int i2) {
        float f2 = 1.0f - f;
        return Color.argb(Math.round((Color.alpha(i2) * f) + (Color.alpha(i) * f2)),
                Math.round((Color.red(i2) * f) + (Color.red(i) * f2)),
                Math.round((Color.green(i2) * f) + (Color.green(i) * f2)),
                Math.round((Color.blue(i2) * f) + (Color.blue(i) * f2)));
    }

    public static float bs(float f, float f2, float f3, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f3 = timeInterpolator.getInterpolation(f3);
        }
        return ff.f(f, f2, f3);
    }

    public final boolean bt(CharSequence charSequence) {
        WeakHashMap weakHashMap = ViewCompat.a;
        boolean z = this.a.getLayoutDirection() == 1;
        if (this.aj) {
            return (z ? dqi.d : dqi.c).k(charSequence.length(), charSequence);
        }
        return z;
    }

    public final void bu(float f, boolean z) {
        float f2;
        float f3;
        Typeface typeface;
        boolean z2;
        Layout.Alignment alignment;
        if (this.ag == null) {
            return;
        }
        float fWidth = this.h.width();
        float fWidth2 = this.g.width();
        if (Math.abs(f - 1.0f) < 1.0E-5f) {
            f2 = this.m;
            f3 = this.bf;
            this.al = 1.0f;
            typeface = this.w;
        } else {
            float f4 = this.l;
            float f5 = this.bg;
            Typeface typeface2 = this.z;
            if (Math.abs(f - 0.0f) < 1.0E-5f) {
                this.al = 1.0f;
            } else {
                this.al = bs(this.l, this.m, f, this.aw) / this.l;
            }
            float f6 = this.m / this.l;
            fWidth = (z || this.c || fWidth2 * f6 <= fWidth) ? fWidth2 : Math.min(fWidth / f6, fWidth2);
            f2 = f4;
            f3 = f5;
            typeface = typeface2;
        }
        TextPaint textPaint = this.at;
        if (fWidth > 0.0f) {
            boolean z3 = this.am != f2;
            boolean z4 = this.bh != f3;
            boolean z5 = this.ac != typeface;
            StaticLayout staticLayout = this.bi;
            boolean z6 = z3 || z4 || (staticLayout != null && (fWidth > ((float) staticLayout.getWidth()) ? 1
                    : (fWidth == ((float) staticLayout.getWidth()) ? 0 : -1)) != 0) || z5 || this.as;
            this.am = f2;
            this.bh = f3;
            this.ac = typeface;
            this.as = false;
            textPaint.setLinearText(this.al != 1.0f);
            z2 = z6;
        } else {
            z2 = false;
        }
        if (this.ah == null || z2) {
            textPaint.setTextSize(this.am);
            textPaint.setTypeface(this.ac);
            textPaint.setLetterSpacing(this.bh);
            boolean zBt = bt(this.ag);
            this.ai = zBt;
            int i = this.bn;
            if (i <= 1 || (zBt && !this.c)) {
                i = 1;
            }
            if (i == 1) {
                alignment = Layout.Alignment.ALIGN_NORMAL;
            } else {
                int absoluteGravity = Gravity.getAbsoluteGravity(this.j, zBt ? 1 : 0) & 7;
                alignment = absoluteGravity != 1
                        ? absoluteGravity != 5
                                ? this.ai ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL
                                : this.ai ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_OPPOSITE
                        : Layout.Alignment.ALIGN_CENTER;
            }
            dmp dmpVar = new dmp(this.ag, textPaint, (int) fWidth);
            dmpVar.l = this.af;
            dmpVar.k = zBt;
            dmpVar.e = alignment;
            dmpVar.j = false;
            dmpVar.f = i;
            float f7 = this.bo;
            float f8 = this.bp;
            dmpVar.g = f7;
            dmpVar.h = f8;
            dmpVar.i = this.bq;
            StaticLayout staticLayoutM = dmpVar.m();
            staticLayoutM.getClass();
            this.bi = staticLayoutM;
            this.ah = staticLayoutM.getText();
        }
    }

    public final void bv(Canvas canvas) {
        int iSave = canvas.save();
        if (this.ah != null) {
            RectF rectF = this.i;
            if (rectF.width() <= 0.0f || rectF.height() <= 0.0f) {
                return;
            }
            float f = this.am;
            TextPaint textPaint = this.at;
            textPaint.setTextSize(f);
            float f2 = this.u;
            float f3 = this.v;
            float f4 = this.al;
            if (f4 != 1.0f && !this.c) {
                canvas.scale(f4, f4, f2, f3);
            }
            if (this.bn <= 1 || ((this.ai && !this.c) || (this.c && this.b <= this.e))) {
                canvas.translate(f2, f3);
                this.bi.draw(canvas);
            } else {
                float lineStart = this.u - this.bi.getLineStart(0);
                int alpha = textPaint.getAlpha();
                canvas.translate(lineStart, f3);
                if (!this.c) {
                    textPaint.setAlpha((int) (this.bl * alpha));
                    if (Build.VERSION.SDK_INT >= 31) {
                        float f5 = this.an;
                        float f6 = this.ao;
                        float f7 = this.ap;
                        int i = this.aq;
                        textPaint.setShadowLayer(f5, f6, f7,
                                abi.f(i, (Color.alpha(i) * textPaint.getAlpha()) / Opcodes.CONST_METHOD_TYPE));
                    }
                    this.bi.draw(canvas);
                }
                if (!this.c) {
                    textPaint.setAlpha((int) (this.bk * alpha));
                }
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= 31) {
                    float f8 = this.an;
                    float f9 = this.ao;
                    float f10 = this.ap;
                    int i3 = this.aq;
                    textPaint.setShadowLayer(f8, f9, f10,
                            abi.f(i3, (Color.alpha(i3) * textPaint.getAlpha()) / Opcodes.CONST_METHOD_TYPE));
                }
                int lineBaseline = this.bi.getLineBaseline(0);
                CharSequence charSequence = this.bm;
                float f11 = lineBaseline;
                canvas.drawText(charSequence, 0, charSequence.length(), 0.0f, f11, textPaint);
                if (i2 >= 31) {
                    textPaint.setShadowLayer(this.an, this.ao, this.ap, this.aq);
                }
                if (!this.c) {
                    String strTrim = this.bm.toString().trim();
                    if (strTrim.endsWith("…")) {
                        strTrim = yg.j(strTrim, 1, 0);
                    }
                    String str = strTrim;
                    textPaint.setAlpha(alpha);
                    canvas.drawText(str, 0, Math.min(this.bi.getLineEnd(0), str.length()), 0.0f, f11,
                            (Paint) textPaint);
                }
                canvas = canvas;
            }
            canvas.restoreToCount(iSave);
        }
    }

    public final float bw() {
        float f = this.m;
        TextPaint textPaint = this.au;
        textPaint.setTextSize(f);
        textPaint.setTypeface(this.w);
        textPaint.setLetterSpacing(this.bf);
        return -textPaint.ascent();
    }

    public final int bx(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.ar;
        return iArr != null ? colorStateList.getColorForState(iArr, 0) : colorStateList.getDefaultColor();
    }

    public final void by(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 31) {
            Typeface typeface = this.y;
            if (typeface != null) {
                this.x = ajn.z(configuration, typeface);
            }
            Typeface typeface2 = this.ab;
            if (typeface2 != null) {
                this.aa = ajn.z(configuration, typeface2);
            }
            Typeface typeface3 = this.x;
            if (typeface3 == null) {
                typeface3 = this.y;
            }
            this.w = typeface3;
            Typeface typeface4 = this.aa;
            if (typeface4 == null) {
                typeface4 = this.ab;
            }
            this.z = typeface4;
            bz(true);
        }
    }

    public final void bz(boolean z) {
        float fMeasureText;
        float f;
        StaticLayout staticLayout;
        ViewGroup viewGroup = this.a;
        if ((viewGroup.getHeight() <= 0 || viewGroup.getWidth() <= 0) && !z) {
            return;
        }
        bu(1.0f, z);
        CharSequence charSequence = this.ah;
        TextPaint textPaint = this.at;
        if (charSequence != null && (staticLayout = this.bi) != null) {
            this.bm = TextUtils.ellipsize(charSequence, textPaint, staticLayout.getWidth(), this.af);
        }
        CharSequence charSequence2 = this.bm;
        if (charSequence2 != null) {
            this.bj = textPaint.measureText(charSequence2, 0, charSequence2.length());
        } else {
            this.bj = 0.0f;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(this.k, this.ai ? 1 : 0);
        int i = absoluteGravity & 112;
        Rect rect = this.h;
        if (i == 48) {
            this.r = rect.top;
        } else if (i != 80) {
            this.r = rect.centerY() - ((textPaint.descent() - textPaint.ascent()) / 2.0f);
        } else {
            this.r = textPaint.ascent() + rect.bottom;
        }
        int i2 = absoluteGravity & 8388615;
        if (i2 == 1) {
            this.t = rect.centerX() - (this.bj / 2.0f);
        } else if (i2 != 5) {
            this.t = rect.left;
        } else {
            this.t = rect.right - this.bj;
        }
        bu(0.0f, z);
        float height = this.bi != null ? r1.getHeight() : 0.0f;
        StaticLayout staticLayout2 = this.bi;
        if (staticLayout2 == null || this.bn <= 1) {
            CharSequence charSequence3 = this.ah;
            fMeasureText = charSequence3 != null ? textPaint.measureText(charSequence3, 0, charSequence3.length())
                    : 0.0f;
        } else {
            fMeasureText = staticLayout2.getWidth();
        }
        StaticLayout staticLayout3 = this.bi;
        this.p = staticLayout3 != null ? staticLayout3.getLineCount() : 0;
        int absoluteGravity2 = Gravity.getAbsoluteGravity(this.j, this.ai ? 1 : 0);
        int i3 = absoluteGravity2 & 112;
        Rect rect2 = this.g;
        if (i3 == 48) {
            this.q = rect2.top;
        } else if (i3 != 80) {
            this.q = rect2.centerY() - (height / 2.0f);
        } else {
            this.q = textPaint.descent() + (rect2.bottom - height);
        }
        int i4 = absoluteGravity2 & 8388615;
        if (i4 == 1) {
            this.s = rect2.centerX() - (fMeasureText / 2.0f);
        } else if (i4 != 5) {
            this.s = rect2.left;
        } else {
            this.s = rect2.right - fMeasureText;
        }
        Bitmap bitmap = this.ak;
        if (bitmap != null) {
            bitmap.recycle();
            this.ak = null;
        }
        ch(this.b);
        float f2 = this.b;
        boolean z2 = this.c;
        RectF rectF = this.i;
        if (z2) {
            if (f2 < this.e) {
                rect = rect2;
            }
            rectF.set(rect);
        } else {
            rectF.left = bs(rect2.left, rect.left, f2, this.av);
            rectF.top = bs(this.q, this.r, f2, this.av);
            rectF.right = bs(rect2.right, rect.right, f2, this.av);
            rectF.bottom = bs(rect2.bottom, rect.bottom, f2, this.av);
        }
        if (!this.c) {
            this.u = bs(this.s, this.t, f2, this.av);
            this.v = bs(this.q, this.r, f2, this.av);
            ch(f2);
            f = f2;
        } else if (f2 < this.e) {
            this.u = this.s;
            this.v = this.q;
            ch(0.0f);
            f = 0.0f;
        } else {
            this.u = this.t;
            this.v = this.r - Math.max(0, this.f);
            ch(1.0f);
            f = 1.0f;
        }
        ayf ayfVar = ff.b;
        this.bk = 1.0f - bs(0.0f, 1.0f, 1.0f - f2, ayfVar);
        WeakHashMap weakHashMap = ViewCompat.a;
        viewGroup.postInvalidateOnAnimation();
        this.bl = bs(1.0f, 0.0f, f2, ayfVar);
        viewGroup.postInvalidateOnAnimation();
        ColorStateList colorStateList = this.o;
        ColorStateList colorStateList2 = this.n;
        if (colorStateList != colorStateList2) {
            textPaint.setColor(br(bx(colorStateList2), f, bx(this.o)));
        } else {
            textPaint.setColor(bx(colorStateList));
        }
        int i5 = Build.VERSION.SDK_INT;
        float f3 = this.bf;
        float f4 = this.bg;
        if (f3 != f4) {
            textPaint.setLetterSpacing(bs(f4, f3, f2, ayfVar));
        } else {
            textPaint.setLetterSpacing(f3);
        }
        this.an = ff.f(this.bb, this.ax, f2);
        this.ao = ff.f(this.bc, this.ay, f2);
        this.ap = ff.f(this.bd, this.az, f2);
        int iBr = br(bx(this.be), f2, bx(this.ba));
        this.aq = iBr;
        textPaint.setShadowLayer(this.an, this.ao, this.ap, iBr);
        if (this.c) {
            int alpha = textPaint.getAlpha();
            float f5 = this.e;
            textPaint.setAlpha(
                    (int) ((f2 <= f5 ? ff.g(1.0f, 0.0f, this.d, f5, f2) : ff.g(0.0f, 1.0f, f5, 1.0f, f2)) * alpha));
            if (i5 >= 31) {
                float f6 = this.an;
                float f7 = this.ao;
                float f8 = this.ap;
                int i6 = this.aq;
                textPaint.setShadowLayer(f6, f7, f8,
                        abi.f(i6, (Color.alpha(i6) * textPaint.getAlpha()) / Opcodes.CONST_METHOD_TYPE));
            }
        }
        viewGroup.postInvalidateOnAnimation();
    }

    public final void ca(ColorStateList colorStateList) {
        if (this.o == colorStateList && this.n == colorStateList) {
            return;
        }
        this.o = colorStateList;
        this.n = colorStateList;
        bz(false);
    }

    public final void cb(int i) {
        ViewGroup viewGroup = this.a;
        dqh dqhVar = new dqh(viewGroup.getContext(), i);
        ColorStateList colorStateList = dqhVar.j;
        if (colorStateList != null) {
            this.o = colorStateList;
        }
        float f = dqhVar.k;
        if (f != 0.0f) {
            this.m = f;
        }
        ColorStateList colorStateList2 = dqhVar.a;
        if (colorStateList2 != null) {
            this.ba = colorStateList2;
        }
        this.ay = dqhVar.e;
        this.az = dqhVar.f;
        this.ax = dqhVar.g;
        this.bf = dqhVar.i;
        ta taVar = this.ae;
        if (taVar != null) {
            taVar.c = true;
        }
        aas aasVar = new aas(this, 0);
        dqhVar.o();
        this.ae = new ta(aasVar, dqhVar.n);
        dqhVar.ensureParameterNotNull(viewGroup.getContext(), this.ae);
        bz(false);
    }

    public final void cc(int i) {
        if (this.k != i) {
            this.k = i;
            bz(false);
        }
    }

    public final boolean cd(Typeface typeface) {
        ta taVar = this.ae;
        if (taVar != null) {
            taVar.c = true;
        }
        if (this.y == typeface) {
            return false;
        }
        this.y = typeface;
        Typeface typefaceZ = ajn.z(this.a.getContext().getResources().getConfiguration(), typeface);
        this.x = typefaceZ;
        if (typefaceZ == null) {
            typefaceZ = this.y;
        }
        this.w = typefaceZ;
        return true;
    }

    public final void ce(int i) {
        ViewGroup viewGroup = this.a;
        dqh dqhVar = new dqh(viewGroup.getContext(), i);
        ColorStateList colorStateList = dqhVar.j;
        if (colorStateList != null) {
            this.n = colorStateList;
        }
        float f = dqhVar.k;
        if (f != 0.0f) {
            this.l = f;
        }
        ColorStateList colorStateList2 = dqhVar.a;
        if (colorStateList2 != null) {
            this.be = colorStateList2;
        }
        this.bc = dqhVar.e;
        this.bd = dqhVar.f;
        this.bb = dqhVar.g;
        this.bg = dqhVar.i;
        ta taVar = this.ad;
        if (taVar != null) {
            taVar.c = true;
        }
        aas aasVar = new aas(this, 1);
        dqhVar.o();
        this.ad = new ta(aasVar, dqhVar.n);
        dqhVar.ensureParameterNotNull(viewGroup.getContext(), this.ad);
        bz(false);
    }

    public final boolean cf(Typeface typeface) {
        ta taVar = this.ad;
        if (taVar != null) {
            taVar.c = true;
        }
        if (this.ab == typeface) {
            return false;
        }
        this.ab = typeface;
        Typeface typefaceZ = ajn.z(this.a.getContext().getResources().getConfiguration(), typeface);
        this.aa = typefaceZ;
        if (typefaceZ == null) {
            typefaceZ = this.ab;
        }
        this.z = typefaceZ;
        return true;
    }

    public final void cg(float f) {
        float f2;
        float fAr = HugeSyntheticPileOfHelpers.ar(f, 0.0f, 1.0f);
        if (fAr != this.b) {
            this.b = fAr;
            boolean z = this.c;
            Rect rect = this.h;
            Rect rect2 = this.g;
            RectF rectF = this.i;
            if (z) {
                if (fAr < this.e) {
                    rect = rect2;
                }
                rectF.set(rect);
            } else {
                rectF.left = bs(rect2.left, rect.left, fAr, this.av);
                rectF.top = bs(this.q, this.r, fAr, this.av);
                rectF.right = bs(rect2.right, rect.right, fAr, this.av);
                rectF.bottom = bs(rect2.bottom, rect.bottom, fAr, this.av);
            }
            if (!this.c) {
                this.u = bs(this.s, this.t, fAr, this.av);
                this.v = bs(this.q, this.r, fAr, this.av);
                ch(fAr);
                f2 = fAr;
            } else if (fAr < this.e) {
                this.u = this.s;
                this.v = this.q;
                ch(0.0f);
                f2 = 0.0f;
            } else {
                this.u = this.t;
                this.v = this.r - Math.max(0, this.f);
                ch(1.0f);
                f2 = 1.0f;
            }
            ayf ayfVar = ff.b;
            this.bk = 1.0f - bs(0.0f, 1.0f, 1.0f - fAr, ayfVar);
            WeakHashMap weakHashMap = ViewCompat.a;
            ViewGroup viewGroup = this.a;
            viewGroup.postInvalidateOnAnimation();
            this.bl = bs(1.0f, 0.0f, fAr, ayfVar);
            viewGroup.postInvalidateOnAnimation();
            ColorStateList colorStateList = this.o;
            ColorStateList colorStateList2 = this.n;
            TextPaint textPaint = this.at;
            if (colorStateList != colorStateList2) {
                textPaint.setColor(br(bx(colorStateList2), f2, bx(this.o)));
            } else {
                textPaint.setColor(bx(colorStateList));
            }
            int i = Build.VERSION.SDK_INT;
            float f3 = this.bf;
            float f4 = this.bg;
            if (f3 != f4) {
                textPaint.setLetterSpacing(bs(f4, f3, fAr, ayfVar));
            } else {
                textPaint.setLetterSpacing(f3);
            }
            this.an = ff.f(this.bb, this.ax, fAr);
            this.ao = ff.f(this.bc, this.ay, fAr);
            this.ap = ff.f(this.bd, this.az, fAr);
            int iBr = br(bx(this.be), fAr, bx(this.ba));
            this.aq = iBr;
            textPaint.setShadowLayer(this.an, this.ao, this.ap, iBr);
            if (this.c) {
                int alpha = textPaint.getAlpha();
                float f5 = this.e;
                textPaint.setAlpha(
                        (int) ((fAr <= f5 ? ff.g(1.0f, 0.0f, this.d, f5, fAr) : ff.g(0.0f, 1.0f, f5, 1.0f, fAr))
                                * alpha));
                if (i >= 31) {
                    float f6 = this.an;
                    float f7 = this.ao;
                    float f8 = this.ap;
                    int i2 = this.aq;
                    textPaint.setShadowLayer(f6, f7, f8,
                            abi.f(i2, (Color.alpha(i2) * textPaint.getAlpha()) / Opcodes.CONST_METHOD_TYPE));
                }
            }
            viewGroup.postInvalidateOnAnimation();
        }
    }

    public final void ch(float f) {
        bu(f, false);
        WeakHashMap weakHashMap = ViewCompat.a;
        this.a.postInvalidateOnAnimation();
    }
}
