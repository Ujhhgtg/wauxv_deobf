package me.hd.wauxv.obf;

import android.R;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.RenderNode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.util.Log;
import android.util.SparseArray;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import io.github.rosemoe.sora.widget.CodeEditor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Stack;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class asn {
    public static final int[] a = { R.attr.state_pressed, R.attr.state_enabled };
    public static final int[] b = { R.attr.state_enabled };
    public final Drawable aa;
    public volatile long ab;
    public Paint.FontMetricsInt ac;
    public Paint.FontMetricsInt ad;
    public int ae;
    public ahy af;
    public afo ag;
    public aff ah;
    public volatile boolean ai;
    public boolean aj;
    public final rj c;
    public final csk d;
    public final csk e;
    public final Rect f;
    public final RectF g;
    public final Path h;
    public final csk i;
    public final RectF j;
    public final RectF k;
    public final ek l = new ek((byte) 0, 11);
    public final chs m = new chs();
    public final ek n = new ek((byte) 0, 11);
    public final chw o;
    public final SparseArray p;
    public final SparseArray q;
    public final CodeEditor r;
    public final ArrayList s;
    public Paint.FontMetricsInt t;
    public Drawable u;
    public Drawable v;
    public Drawable w;
    public Drawable x;
    public final Drawable y;
    public final Drawable z;

    public asn(CodeEditor codeEditor) {
        chw chwVar = new chw();
        long[] jArr = dev.a;
        chwVar.a = jArr;
        chwVar.b = byb.a;
        chwVar.c = KotlinHelpers.b;
        int iD = dev.d(6);
        int iMax = iD > 0 ? Math.max(7, dev.c(iD)) : 0;
        chwVar.d = iMax;
        if (iMax != 0) {
            jArr = new long[((iMax + 15) & (-8)) >> 3];
            la.n(jArr);
        }
        chwVar.a = jArr;
        int i = iMax >> 3;
        long j = 255 << ((iMax & 7) << 3);
        jArr[i] = (jArr[i] & (~j)) | j;
        dev.b(chwVar.d);
        chwVar.b = new long[iMax];
        chwVar.c = new Object[iMax];
        this.o = chwVar;
        this.p = new SparseArray();
        this.q = new SparseArray();
        this.s = new ArrayList();
        new ArrayList();
        this.r = codeEditor;
        this.j = new RectF();
        this.k = new RectF();
        rj rjVar = new rj();
        rjVar.b = new float[128];
        this.c = rjVar;
        csk cskVar = new csk(codeEditor.bg);
        this.d = cskVar;
        cskVar.setAntiAlias(true);
        csk cskVar2 = new csk(false);
        this.e = cskVar2;
        cskVar2.setStrokeWidth(codeEditor.getDpUnit() * 1.8f);
        cskVar2.setStrokeCap(Paint.Cap.ROUND);
        cskVar2.setTypeface(Typeface.MONOSPACE);
        cskVar2.setAntiAlias(true);
        csk cskVar3 = new csk(false);
        this.i = cskVar3;
        cskVar3.setAntiAlias(true);
        this.t = cskVar.getFontMetricsInt();
        this.ac = cskVar2.getFontMetricsInt();
        this.f = new Rect();
        this.g = new RectF();
        this.h = new Path();
        this.y = codeEditor.getContext().getDrawable(me.hd.wauxv.R.drawable.line_break);
        this.z = codeEditor.getContext().getDrawable(me.hd.wauxv.R.drawable.softwrap_left);
        this.aa = codeEditor.getContext().getDrawable(me.hd.wauxv.R.drawable.softwrap_right);
        this.af = codeEditor.getCursor();
        this.ah = codeEditor.getText();
    }

    public static boolean ak(int i, int i2, int i3, boolean z) {
        return (i != i3 || z) && i >= i2 && i <= i3;
    }

    public final void al(asm asmVar, int i, int i2) {
        long jBd = bd(i, i2);
        asmVar.f = ((int) (jBd >> 32)) == 1;
        asmVar.g = ((int) (jBd & 4294967295L)) == 1;
    }

    public final void am(drd drdVar, int i) {
        ahy ahyVar;
        ud udVar;
        int i2;
        ud udVar2;
        int i3;
        if (!this.af.h() || i < (i2 = (udVar = (ahyVar = this.af).c).b) || i > (i3 = (udVar2 = ahyVar.d).b)) {
            return;
        }
        int i4 = i == i2 ? udVar.c : 0;
        int i5 = i == i3 ? udVar2.c : this.ag.b;
        int iMax = Math.max(drdVar.g, i4);
        int iMin = Math.min(drdVar.h, i5);
        if (iMax < iMin) {
            drdVar.n = iMax;
            drdVar.o = iMin;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v3, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r14v5, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r14v6 */
    /*
     * JADX WARN: Type inference failed for: r17v0, types: [java.lang.Object,
     * java.util.List]
     */
    /* JADX WARN: Type inference failed for: r17v1, types: [me.hd.wauxv.obf.drd] */
    /* JADX WARN: Type inference failed for: r17v2, types: [me.hd.wauxv.obf.drd] */
    /* JADX WARN: Type inference failed for: r17v5 */
    /* JADX WARN: Type inference failed for: r9v16, types: [me.hd.wauxv.obf.drd] */
    /* JADX WARN: Type inference failed for: r9v18, types: [me.hd.wauxv.obf.drd] */
    public final void an(int i, int i2, long j, boolean z) {
        boolean z2;
        cba cbaVar;
        aff affVar = this.ah;
        CodeEditor codeEditor = this.r;
        dbg renderContext = codeEditor.getRenderContext();
        for (int i3 = i; i3 <= i2 && i3 < affVar.a.size(); i3++) {
            afo afoVarBe = z ? be(i3) : this.ah.y(i3);
            ik ikVar = codeEditor.getRenderContext().a;
            ArrayList arrayList = (ArrayList) ikVar.d;
            cba cbaVarAc = ikVar.ac(i3);
            if (cbaVarAc == null) {
                cbaVarAc = new cba();
                cbaVarAc.a = i3;
                cbaVarAc.b = null;
                cbaVarAc.c = 0L;
                arrayList.add(cbaVarAc);
                while (arrayList.size() > ikVar.b && !arrayList.isEmpty()) {
                    arrayList.remove(0);
                }
            }
            if (cbaVarAc.c < j) {
                ek ekVar = cbaVarAc.b;
                if (ekVar == null || ekVar.c < afoVarBe.b) {
                    cbaVarAc.b = new ek(Math.max(afoVarBe.b + 8, 90));
                    z2 = true;
                } else {
                    z2 = false;
                }
                ?? L = codeEditor.e;
                dnv dnvVar = codeEditor.cm;
                io ioVar = dnvVar == null ? null : dnvVar.a;
                if (L.isEmpty()) {
                    cbaVar = cbaVarAc;
                    L.add(ajn.aa(0, 5L));
                } else {
                    cbaVar = cbaVarAc;
                }
                if (ioVar != null) {
                    try {
                        L = new io(ioVar, 6).l(i3);
                    } catch (Exception unused) {
                    }
                }
                ?? r17 = L;
                Integer numValueOf = Integer.valueOf(afoVarBe.b);
                Integer numValueOf2 = Integer.valueOf(codeEditor.getTabWidth());
                csk cskVar = this.d;
                int iHash = Objects.hash(r17, numValueOf, numValueOf2, Integer.valueOf(cskVar.getFlags()), Float.valueOf(cskVar.getTextSize()), Float.valueOf(cskVar.getTextScaleX()), Float.valueOf(cskVar.getLetterSpacing()), cskVar.getFontFeatureSettings(), Integer.valueOf(cskVar.getTypeface().hashCode()));
                if (((chs) renderContext.a.c).d(i3) != iHash || z2) {
                    chs chsVar = (chs) renderContext.a.c;
                    if (i3 < 0) {
                        chsVar.getClass();
                    } else if (i3 < chsVar.b) {
                        int[] iArr = chsVar.a;
                        int i4 = iArr[i3];
                        iArr[i3] = iHash;
                        ddo ddoVarI = codeEditor.j.i(codeEditor.j.l(affVar.v(i3, 0)), null);
                        ?? drdVar = new drd();
                        afo afoVarY = affVar.y(i3);
                        anu anuVarZ = affVar.z(i3);
                        int i5 = afoVarY.b + 10;
                        cba cbaVar2 = cbaVar;
                        ek ekVar2 = cbaVar2.b;
                        if (ekVar2 == null || ekVar2.c < i5) {
                            ekVar2 = new ek(i5);
                            cbaVar2.b = ekVar2;
                        }
                        while (ddoVarI.hasNext()) {
                            ddm next = ddoVarI.next();
                            if (next.a != i3) {
                                break;
                            }
                            afo afoVar = afoVarY;
                            drdVar.ac(afoVar, next.d, next.e, r17, next.f, anuVarZ, this.d, null, ap());
                            ?? r9 = drdVar;
                            dqz dqzVar = new dqz();
                            dqzVar.n = ekVar2;
                            r9.aa(new cbr(r9, dqzVar), true);
                            drdVar = r9;
                            afoVarY = afoVar;
                        }
                        afo afoVar2 = afoVarY;
                        ?? r92 = drdVar;
                        int i6 = afoVar2.b;
                        char c = 0;
                        r92.g = 0;
                        r92.h = i6;
                        float[][] fArr = (float[][]) ekVar2.d;
                        int length = fArr.length;
                        int i7 = 0;
                        while (i7 < length) {
                            float[] fArr2 = fArr[i7];
                            float f = fArr2[c];
                            fArr2[c] = 0.0f;
                            float f2 = f;
                            int i8 = 1;
                            while (i8 <= fArr2.length - 1) {
                                float f3 = fArr2[i8];
                                fArr2[i8] = fArr2[i8 - 1] + f2;
                                i8++;
                                f2 = f3;
                            }
                            i7++;
                            c = 0;
                        }
                        cbaVar2.c = j;
                    }
                    throw new IndexOutOfBoundsException("Index must be between 0 and size");
                }
            }
        }
    }

    public final drd ao(int i) {
        dnv styles = this.r.getStyles();
        io ioVar = styles != null ? styles.a : null;
        dln ioVar2 = ioVar != null ? new io(ioVar, 6) : null;
        if (ioVar2 == null) {
            ioVar2 = avf.a;
        }
        ddm ddmVarQ = this.r.getLayout().q(i);
        afo afoVarY = this.ah.y(ddmVarQ.a);
        drd drdVar = new drd();
        cba cbaVarAc = this.r.getRenderContext().a.ac(ddmVarQ.a);
        ek ekVar = (cbaVarAc == null || cbaVarAc.c < this.ab) ? null : cbaVarAc.b;
        drdVar.ac(afoVarY, ddmVarQ.d, ddmVarQ.e, ioVar2.l(ddmVarQ.a), ddmVarQ.f, this.ah.z(ddmVarQ.a), this.d,
                (ekVar == null || ekVar.c <= afoVarY.b) ? null : ekVar, ap());
        am(drdVar, ddmVarQ.a);
        return drdVar;
    }

    public final dre ap() {
        CodeEditor codeEditor = this.r;
        int tabWidth = codeEditor.getTabWidth();
        Paint.FontMetricsInt fontMetricsInt = this.t;
        int iDu = codeEditor.du(0);
        int iDt = codeEditor.dt(0) - (codeEditor.getLineSpacingPixels() / 2);
        int rowHeightOfText = codeEditor.getRowHeightOfText();
        int iDs = codeEditor.ds(0);
        codeEditor.getRowHeight();
        return new dre(tabWidth, fontMetricsInt, iDu, iDt, rowHeightOfText, iDs, codeEditor.dt(0),
                codeEditor.getRowHeight(), codeEditor.getProps().t, codeEditor, codeEditor.getColorScheme(), this.e,
                this.i, this.ad);
    }

    public final void aq(Canvas canvas, float f, float f2, float f3, boolean z) {
        float f4 = f3 * 0.2f;
        float f5 = 0.866f * f4;
        Path path = this.h;
        path.reset();
        path.moveTo(f, f2);
        if (z) {
            f5 = -f5;
        }
        path.lineTo(f5 + f, (f4 / 2.0f) + f2);
        path.lineTo(f, f2 + f4);
        path.close();
        canvas.drawPath(path, this.d);
    }

    public final void ar(Canvas canvas, int i, RectF rectF) {
        if (i != 0) {
            csk cskVar = this.d;
            cskVar.setColor(i);
            canvas.drawRect(rectF, cskVar);
        }
    }

    public final void as(Canvas canvas, float f, int i) {
        CodeEditor codeEditor = this.r;
        boolean z = codeEditor.ay && !codeEditor.af && codeEditor.getOffsetX() > 0;
        float dividerWidth = codeEditor.getDividerWidth() + f;
        if (dividerWidth < 0.0f) {
            return;
        }
        float fMax = Math.max(0.0f, f);
        float height = codeEditor.getHeight();
        RectF rectF = this.g;
        rectF.bottom = height;
        rectF.top = 0.0f;
        int offsetY = codeEditor.getOffsetY();
        if (offsetY < 0) {
            float f2 = offsetY;
            rectF.bottom -= f2;
            rectF.top -= f2;
        }
        rectF.left = fMax;
        rectF.right = dividerWidth;
        csk cskVar = this.d;
        if (z) {
            canvas.save();
            canvas.clipRect(rectF.left, rectF.top, codeEditor.getWidth(), rectF.bottom);
            cskVar.setShadowLayer(Math.min(codeEditor.getDpUnit() * 8.0f, codeEditor.getOffsetX()), 0.0f, 0.0f,
                    -16777216);
        }
        ar(canvas, i, rectF);
        if (z) {
            canvas.restore();
            cskVar.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        }
    }

    public final void at(Canvas canvas, int i, int i2, float f, float f2, int i3) {
        char[] cArr;
        int i4;
        int i5;
        int i6;
        csk cskVar = this.e;
        CodeEditor codeEditor = this.r;
        float f3 = f2 + f;
        if (f3 <= 0.0f) {
            return;
        }
        if (cskVar.getTextAlign() != codeEditor.getLineNumberAlign()) {
            cskVar.setTextAlign(codeEditor.getLineNumberAlign());
        }
        cskVar.setColor(i3);
        Paint.FontMetricsInt fontMetricsInt = this.ac;
        int i7 = fontMetricsInt.descent;
        int i8 = fontMetricsInt.ascent;
        float rowHeight = (((((codeEditor.getRowHeight() * i2) + codeEditor.dt(i2)) / 2.0f) - ((i7 - i8) / 2.0f)) - i8)
                - codeEditor.getOffsetY();
        synchronized (dqc.class) {
            cArr = dqc.as;
            dqc.as = null;
        }
        if (cArr == null || cArr.length < 20) {
            cArr = new char[20];
        }
        char[] cArr2 = cArr;
        int i9 = i + 1;
        if (i9 >= 0) {
            i5 = -i9;
            i4 = 0;
        } else {
            i4 = 1;
            i5 = i9;
        }
        int i10 = -10;
        int i11 = 1;
        while (true) {
            if (i11 >= 10) {
                i6 = i4 + 10;
                break;
            } else if (i5 > i10) {
                i6 = i11 + i4;
                break;
            } else {
                i10 *= 10;
                i11++;
            }
        }
        int i12 = i6;
        char[] cArr3 = cnd.af;
        char[] cArr4 = cnd.ag;
        boolean z = i9 < 0;
        if (!z) {
            i9 = -i9;
        }
        int i13 = i12;
        while (i9 <= -100) {
            int i14 = i9 / 100;
            int i15 = (i14 * 100) - i9;
            cArr2[i13 - 1] = cArr4[i15];
            i13 -= 2;
            cArr2[i13] = cArr3[i15];
            i9 = i14;
        }
        int i16 = i13 - 1;
        int i17 = -i9;
        cArr2[i16] = cArr4[i17];
        if (i9 < -9) {
            i16 = i13 - 2;
            cArr2[i16] = cArr3[i17];
        }
        if (z) {
            cArr2[i16 - 1] = SignatureVisitor.SUPER;
        }
        int i18 = asl.a[codeEditor.getLineNumberAlign().ordinal()];
        if (i18 == 1) {
            canvas.drawText(cArr2, 0, i12, f, rowHeight, this.e);
        } else if (i18 == 2) {
            canvas.drawText(cArr2, 0, i12, f3, rowHeight, this.e);
            cArr2 = cArr2;
        } else if (i18 == 3) {
            canvas.drawText(cArr2, 0, i12, ((codeEditor.getDividerMarginLeft() + f2) / 2.0f) + f, rowHeight, this.e);
        }
        if (cArr2.length > 1000) {
            return;
        }
        synchronized (dqc.class) {
            dqc.as = cArr2;
        }
    }

    public final void au(Canvas canvas, float f, float f2, int i) {
        float f3 = f2 + f;
        if (f3 < 0.0f) {
            return;
        }
        float fMax = Math.max(0.0f, f);
        CodeEditor codeEditor = this.r;
        float height = codeEditor.getHeight();
        RectF rectF = this.g;
        rectF.bottom = height;
        rectF.top = 0.0f;
        int offsetY = codeEditor.getOffsetY();
        if (offsetY < 0) {
            float f4 = offsetY;
            rectF.bottom -= f4;
            rectF.top -= f4;
        }
        rectF.left = fMax;
        rectF.right = f3;
        ar(canvas, i, rectF);
    }

    public final void av(Canvas canvas, float f, int i, Drawable drawable) {
        int iDt;
        int offsetY;
        CodeEditor codeEditor = this.r;
        if (i == -1) {
            iDt = codeEditor.dt(0);
            offsetY = codeEditor.getLineSpacingPixels() / 2;
        } else {
            iDt = codeEditor.dt(i) - (codeEditor.getLineSpacingPixels() / 2);
            offsetY = codeEditor.getOffsetY();
        }
        float f2 = iDt - offsetY;
        float rowHeightOfText = codeEditor.getRowHeightOfText();
        Objects.requireNonNull(codeEditor.getProps());
        float f3 = rowHeightOfText * 0.5f;
        if (f3 <= 0.0f || drawable == null) {
            return;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            return;
        }
        drawable.setColorFilter(codeEditor.getColorScheme().b.get(31), PorterDuff.Mode.SRC_ATOP);
        drawable.setBounds((int) f, (int) (f2 - f3), (int) (f + ((intrinsicWidth / intrinsicHeight) * f3)), (int) f2);
        drawable.draw(canvas);
    }

    public final void aw(Canvas canvas, int i, int i2, int i3) {
        CodeEditor codeEditor = this.r;
        float rowHeight = (codeEditor.getRowHeight() * i2) - codeEditor.getOffsetY();
        RectF rectF = this.g;
        rectF.top = rowHeight;
        rectF.bottom = codeEditor.dt(i2) - codeEditor.getOffsetY();
        rectF.left = 0.0f;
        rectF.right = i3;
        ar(canvas, i, rectF);
    }

    public final void ax(final Canvas canvas, int i, int i2, int i3, int i4, int i5, int i6) {
        int iMax = Math.max(i2, i4);
        int iMin = Math.min(i3, i5);
        if (iMax < iMin) {
            CodeEditor codeEditor = this.r;
            codeEditor.getProps().getClass();
            float rowHeight = (codeEditor.getRowHeight() * i) - codeEditor.getOffsetY();
            RectF rectF = this.g;
            rectF.top = rowHeight;
            rectF.bottom = bh(i) - codeEditor.getOffsetY();
            this.d.setColor(i6);
            final float fEb = codeEditor.eb() - codeEditor.getOffsetX();
            if (codeEditor.af && !codeEditor.getLayout().q(i).b
                    && (codeEditor.getNonPrintablePaintingFlags() & 128) != 0) {
                fEb += bg();
            }
            drd drdVarAo = ao(i);
            final int width = codeEditor.getWidth();
            drdVarAo.y(iMax, iMin, new dqx() { // from class: me.hd.wauxv.obf.ask
                @Override // me.hd.wauxv.obf.dqx
                public final boolean g(float f, float f2) {
                    asn asnVar = this.a;
                    RectF rectF2 = asnVar.g;
                    float f3 = fEb;
                    float f4 = f + f3;
                    rectF2.left = f4;
                    float f5 = f3 + f2;
                    rectF2.right = f5;
                    if (f5 < 0.0f || f4 > width) {
                        return false;
                    }
                    csk cskVar = asnVar.d;
                    CodeEditor codeEditor2 = asnVar.r;
                    boolean z = codeEditor2.getProps().r;
                    Canvas canvas2 = canvas;
                    if (z) {
                        canvas2.drawRoundRect(rectF2, codeEditor2.getRowHeight() * codeEditor2.getProps().t,
                                codeEditor2.getRowHeight() * codeEditor2.getProps().t, cskVar);
                        return true;
                    }
                    canvas2.drawRect(rectF2, cskVar);
                    return true;
                }
            });
        }
    }

    /* JADX WARN: Found duplicated region for block: B:123:0x03e6 */
    /* JADX WARN: Found duplicated region for block: B:24:0x009b */
    /* JADX WARN: Found duplicated region for block: B:256:0x072a */
    /* JADX WARN: Found duplicated region for block: B:258:0x0737 */
    /* JADX WARN: Found duplicated region for block: B:261:0x074d */
    /* JADX WARN: Found duplicated region for block: B:264:0x075e */
    /* JADX WARN: Found duplicated region for block: B:321:0x08b3 */
    /* JADX WARN: Found duplicated region for block: B:324:0x091d */
    /* JADX WARN: Found duplicated region for block: B:325:0x091f */
    /* JADX WARN: Found duplicated region for block: B:328:0x092d */
    /* JADX WARN: Found duplicated region for block: B:333:0x093b */
    /* JADX WARN: Found duplicated region for block: B:335:0x093f */
    /*
     * JADX WARN: Found duplicated region for block: B:342:0x0952 A[ADDED_TO_REGION]
     */
    /* JADX WARN: Found duplicated region for block: B:346:0x0959 */
    /* JADX WARN: Found duplicated region for block: B:350:0x0a19 */
    /* JADX WARN: Found duplicated region for block: B:354:0x0a3b A[MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:357:0x0aa1 */
    /* JADX WARN: Found duplicated region for block: B:359:0x0aa9 */
    /* JADX WARN: Found duplicated region for block: B:366:0x0b14 */
    /* JADX WARN: Found duplicated region for block: B:369:0x0b1f */
    /* JADX WARN: Found duplicated region for block: B:373:0x0b5d */
    /* JADX WARN: Found duplicated region for block: B:374:0x0b5f */
    /* JADX WARN: Found duplicated region for block: B:377:0x0b89 */
    /* JADX WARN: Found duplicated region for block: B:379:0x0b94 */
    /* JADX WARN: Found duplicated region for block: B:383:0x0beb */
    /* JADX WARN: Found duplicated region for block: B:385:0x0bef */
    /* JADX WARN: Found duplicated region for block: B:389:0x0c39 */
    /* JADX WARN: Found duplicated region for block: B:391:0x0c41 */
    /* JADX WARN: Found duplicated region for block: B:46:0x0126 */
    /* JADX WARN: Found duplicated region for block: B:71:0x01ad */
    /* JADX WARN: Multi-variable type inference failed */
    public final void ay(Canvas canvas, float f, ek ekVar, ArrayList arrayList, chs chsVar, chr chrVar) {
        ud udVarN;
        ud udVar;
        int i;
        ek ekVar2;
        int i2;
        int i3;
        int i4;
        io ioVar;
        int i5;
        dln dlnVar;
        int i6;
        ek ekVar3;
        int i7;
        float f2;
        float f3;
        float f4;
        int i8;
        int i9;
        final Canvas canvas2;
        float f5;
        float f6;
        CodeEditor codeEditor;
        final int i10;
        float f7;
        float f8;
        float f9;
        boolean z;
        float fIntBitsToFloat;
        ddm ddmVar;
        final asn asnVar;
        int i11;
        int i12;
        int i13;
        final float f10;
        int i14;
        ud udVar2;
        btr layout;
        ArrayList arrayList2;
        ud udVar3;
        ud udVar4;
        ud selectingTarget;
        ud udVar5;
        ud udVar6;
        int iMin;
        int iMin2;
        dbh dbhVar;
        dbh dbhVar2;
        ek ekVar4;
        dln ioVar2;
        ArrayList<din> arrayList3;
        float f11;
        int i15;
        Canvas canvas3;
        chw chwVar;
        ahy ahyVar;
        ud udVar7;
        int i16;
        ud udVar8;
        int i17;
        int i18;
        long[] jArr;
        int i19;
        int i20;
        int i21;
        int i22;
        long[] jArr2;
        chw chwVar2;
        int i23;
        int i24;
        int i25;
        boolean z2;
        int i26;
        final asn asnVar2 = this;
        Canvas canvas4 = canvas;
        int firstVisibleRow = asnVar2.r.getFirstVisibleRow();
        ddo ddoVarI = asnVar2.r.getLayout().i(firstVisibleRow, asnVar2.p);
        io ioVar3 = asnVar2.r.getStyles() == null ? null : asnVar2.r.getStyles().a;
        ek ekVar5 = asnVar2.n;
        chw chwVar3 = asnVar2.o;
        ekVar5.c = 0;
        chwVar3.f();
        int i27 = asnVar2.af.h() ? -1 : asnVar2.af.c.b;
        int i28 = asnVar2.r.getColorScheme().b.get(9);
        CodeEditor codeEditor2 = asnVar2.r;
        float fBg = (!codeEditor2.af || (codeEditor2.getNonPrintablePaintingFlags() & 128) == 0) ? 0.0f : asnVar2.bg();
        if (asnVar2.r.h.c.e() && (i26 = asnVar2.r.h.c.a) >= 0) {
            aff affVar = asnVar2.ah;
            udVarN = i26 < affVar.d ? affVar.x().n(asnVar2.r.h.c.a) : null;
        }
        CodeEditor codeEditor3 = asnVar2.r;
        pf pfVar = codeEditor3.h.c;
        chw chwVar4 = chwVar3;
        int i29 = pfVar.b - pfVar.a;
        ud udVar9 = codeEditor3.getEventHandler().ai;
        float fMin = (asnVar2.r.o & (-185)) != 0 ? Math.min(r5.getRowHeight(), asnVar2.d.a) * 0.125f : 0.0f;
        if (Build.VERSION.SDK_INT < 29 || asnVar2.r.af || !canvas4.isHardwareAccelerated()) {
            udVar = udVar9;
        } else {
            CodeEditor codeEditor4 = asnVar2.r;
            if (codeEditor4.cp) {
                jx jxVar = codeEditor4.getRenderContext().b;
                int lastVisibleRow = asnVar2.r.getLastVisibleRow();
                Iterator it = ((ArrayList) jxVar.f).iterator();
                udVar = udVar9;
                throwIfVar1IsNull(it, "iterator(...)");
                while (it.hasNext()) {
                    Object next = it.next();
                    Iterator it2 = it;
                    throwIfVar1IsNull(next, "next(...)");
                    dbh dbhVar3 = (dbh) next;
                    int i30 = dbhVar3.a;
                    if (i30 < firstVisibleRow || i30 > lastVisibleRow) {
                        it2.remove();
                        dbhVar3.b.discardDisplayList();
                    }
                    it = it2;
                }
            } else {
                udVar = udVar9;
            }
        }
        float offsetX = asnVar2.r.getOffsetX() - asnVar2.r.eb();
        if (((cfg) asnVar2.r.getCursorAnimator()).m()) {
            CodeEditor codeEditor5 = asnVar2.r;
            if (codeEditor5.au && codeEditor5.dw()) {
                asnVar2.r.getProps().getClass();
                asnVar2.r.getProps().getClass();
            }
        }
        int i31 = -1;
        for (int i32 = firstVisibleRow; i32 <= asnVar2.r.getLastVisibleRow() && ddoVarI.hasNext(); i32++) {
            int i33 = ddoVarI.next().a;
            if (i31 != i33) {
                asnVar2.ag = asnVar2.be(i33);
                i31 = i33;
            }
            asnVar2.r.getProps().getClass();
            if (i33 == i27 && !((cfg) asnVar2.r.getCursorAnimator()).m()) {
                CodeEditor codeEditor6 = asnVar2.r;
                z2 = codeEditor6.au && codeEditor6.dw();
            }
            if (z2) {
                asnVar2.r.getProps().getClass();
            } else {
                asnVar2.r.getStyles();
            }
            if (z2) {
                asnVar2.aw(canvas4, i28, i32, asnVar2.f.right);
                chsVar.c(chsVar.b + 1);
                int[] iArr = chsVar.a;
                int i34 = chsVar.b;
                iArr[i34] = i32;
                chsVar.b = i34 + 1;
            }
        }
        int i35 = 1;
        if (((cfg) asnVar2.r.getCursorAnimator()).m()) {
            CodeEditor codeEditor7 = asnVar2.r;
            if (codeEditor7.au) {
                codeEditor7.getProps().getClass();
                RectF rectF = asnVar2.g;
                CodeEditor codeEditor8 = asnVar2.r;
                float fFloatValue = ((Float) ((cfg) codeEditor8.getCursorAnimator()).e.getAnimatedValue()).floatValue()
                        - codeEditor8.getOffsetY();
                rectF.bottom = fFloatValue;
                rectF.top = fFloatValue
                        - ((Float) ((cfg) codeEditor8.getCursorAnimator()).f.getAnimatedValue()).floatValue();
                rectF.left = 0.0f;
                rectF.right = asnVar2.f.right;
                asnVar2.ar(canvas4, i28, rectF);
            }
        }
        ddoVarI.reset();
        int i36 = firstVisibleRow;
        while (i36 <= asnVar2.r.getLastVisibleRow() && ddoVarI.hasNext()) {
            ddm next2 = ddoVarI.next();
            canvas4.save();
            canvas4.translate(next2.g, 0.0f);
            int i37 = next2.a;
            int i38 = asnVar2.be(i37).b;
            if (i31 != i37) {
                CodeEditor codeEditor9 = asnVar2.r;
                codeEditor9.getClass();
                f11 = 2.0f;
                ekVar5.c = 0;
                codeEditor9.cg.getClass();
                asnVar2.r.getClass();
                chwVar4.f();
                asnVar2.ag = asnVar2.be(i37);
                i15 = i37;
            } else {
                f11 = 2.0f;
                i15 = i31;
            }
            float f12 = -offsetX;
            if (!next2.b) {
                f12 += fBg;
            }
            float f13 = f12;
            if (ekVar5.c > 0) {
                int i39 = 0;
                while (i39 < ekVar5.c) {
                    long jK = ekVar5.k(i39);
                    ek ekVar6 = ekVar5;
                    int i40 = (int) (jK >> 32);
                    int i41 = (int) (jK & 4294967295L);
                    int i42 = i37;
                    int i43 = next2.d;
                    int i44 = i39;
                    int i45 = next2.e;
                    int i46 = i36;
                    int i47 = asnVar2.r.getColorScheme().b.get(29);
                    asnVar2 = this;
                    asnVar2.ax(canvas, i46, i40, i41, i43, i45, i47);
                    i39 = i44 + 1;
                    i38 = i38;
                    next2 = next2;
                    i36 = i46;
                    i37 = i42;
                    ekVar5 = ekVar6;
                    udVarN = udVarN;
                    offsetX = offsetX;
                    ioVar3 = ioVar3;
                    chwVar4 = chwVar4;
                }
            }
            ek ekVar7 = ekVar5;
            float f14 = offsetX;
            int i48 = i38;
            ud udVar10 = udVarN;
            chw chwVar5 = chwVar4;
            ud udVar11 = udVar;
            int i49 = i36;
            ddm ddmVar2 = next2;
            int i50 = i37;
            io ioVar4 = ioVar3;
            char c = ' ';
            if (chwVar5.e > 0) {
                long[] jArr3 = chwVar5.b;
                Object[] objArr = chwVar5.c;
                long[] jArr4 = chwVar5.a;
                int length = jArr4.length - 2;
                if (length >= 0) {
                    long[] jArr5 = jArr3;
                    int i51 = 0;
                    while (true) {
                        int i52 = i49;
                        long j = jArr4[i51];
                        Object[] objArr2 = objArr;
                        long[] jArr6 = jArr4;
                        if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i53 = 8;
                            int i54 = 8 - ((~(i51 - length)) >>> 31);
                            long j2 = j;
                            int i55 = 0;
                            while (i55 < i54) {
                                if ((j2 & 255) < 128) {
                                    int i56 = (i51 << 3) + i55;
                                    long j3 = jArr5[i56];
                                    arp arpVar = (arp) objArr2[i56];
                                    int i57 = length;
                                    int i58 = (int) (j3 >> c);
                                    int i59 = (int) (j3 & 4294967295L);
                                    int i60 = ddmVar2.d;
                                    int i61 = i51;
                                    int i62 = ddmVar2.e;
                                    arq colorScheme = asnVar2.r.getColorScheme();
                                    arpVar.getClass();
                                    throwIfVar1IsNull(colorScheme, "colorScheme");
                                    int i63 = colorScheme.b.get(arpVar.a);
                                    i20 = i54;
                                    chwVar2 = chwVar5;
                                    i25 = i57;
                                    i23 = i52;
                                    i22 = i61;
                                    i21 = 8;
                                    i24 = i55;
                                    jArr2 = jArr5;
                                    asnVar2 = this;
                                    asnVar2.ax(canvas, i23, i58, i59, i60, i62, i63);
                                } else {
                                    i20 = i54;
                                    i21 = i53;
                                    i22 = i51;
                                    jArr2 = jArr5;
                                    chwVar2 = chwVar5;
                                    i23 = i52;
                                    i24 = i55;
                                    i25 = length;
                                }
                                j2 >>= i21;
                                int i64 = i24 + 1;
                                i52 = i23;
                                i55 = i64;
                                i54 = i20;
                                i53 = i21;
                                length = i25;
                                i51 = i22;
                                jArr5 = jArr2;
                                chwVar5 = chwVar2;
                                c = ' ';
                            }
                            canvas3 = canvas;
                            i18 = i51;
                            jArr = jArr5;
                            chwVar = chwVar5;
                            i49 = i52;
                            i19 = length;
                            if (i54 != i53) {
                                break;
                            }
                        } else {
                            canvas3 = canvas;
                            i18 = i51;
                            jArr = jArr5;
                            chwVar = chwVar5;
                            i49 = i52;
                            i19 = length;
                        }
                        if (i18 == i19) {
                            break;
                        }
                        i51 = i18 + 1;
                        length = i19;
                        objArr = objArr2;
                        jArr5 = jArr;
                        jArr4 = jArr6;
                        chwVar5 = chwVar;
                        c = ' ';
                    }
                } else {
                    canvas3 = canvas;
                    chwVar = chwVar5;
                }
            } else {
                canvas3 = canvas;
                chwVar = chwVar5;
            }
            if (asnVar2.af.h() && i50 >= (i16 = (udVar7 = (ahyVar = asnVar2.af).c).b)
                    && i50 <= (i17 = (udVar8 = ahyVar.d).b)) {
                int i65 = i50 == i16 ? udVar7.c : 0;
                int i66 = i50 == i17 ? udVar8.c : i48;
                if (asnVar2.be(i50).b == 0 && i50 != asnVar2.af.d.b) {
                    asnVar2.g.top = (asnVar2.r.getRowHeight() * i49) - asnVar2.r.getOffsetY();
                    asnVar2.g.bottom = asnVar2.r.dt(i49) - asnVar2.r.getOffsetY();
                    RectF rectF2 = asnVar2.g;
                    rectF2.left = f13;
                    csk cskVar = asnVar2.d;
                    rectF2.right = (cskVar.a * f11) + f13;
                    cskVar.setColor(asnVar2.r.getColorScheme().b.get(6));
                    if (asnVar2.r.getProps().r) {
                        canvas3.drawRoundRect(asnVar2.g, asnVar2.r.getRowHeight() * asnVar2.r.getProps().t,
                                asnVar2.r.getRowHeight() * asnVar2.r.getProps().t, asnVar2.d);
                    } else {
                        canvas3.drawRect(asnVar2.g, asnVar2.d);
                    }
                } else if (i65 < i66) {
                    asnVar2.ax(canvas3, i49, i65, i66, ddmVar2.d, ddmVar2.e, asnVar2.r.getColorScheme().b.get(6));
                }
            }
            canvas.restore();
            i36 = i49 + 1;
            canvas4 = canvas;
            ekVar5 = ekVar7;
            i31 = i15;
            udVarN = udVar10;
            offsetX = f14;
            ioVar3 = ioVar4;
            chwVar4 = chwVar;
            udVar = udVar11;
        }
        float f15 = offsetX;
        ud udVar12 = udVarN;
        io ioVar5 = ioVar3;
        ud udVar13 = udVar;
        int i67 = 31;
        ddoVarI.reset();
        List<din> list = avd.a;
        CodeEditor codeEditor10 = asnVar2.r;
        dik snippetController = codeEditor10.getSnippetController();
        if (snippetController.l()) {
            ctr ctrVarJ = snippetController.j();
            if (ctrVarJ != null) {
                asnVar2.bl(canvas, f, ctrVarJ.c, ctrVarJ.d, 0, codeEditor10.getColorScheme().b.get(48), 0);
            }
            ctr ctrVarJ2 = snippetController.j();
            if (ctrVarJ2 != null) {
                aao aaoVar = snippetController.c;
                throwIfVar1IsNull(aaoVar);
                List list2 = aaoVar.a;
                throwIfVar1IsNull(list2);
                arrayList3 = new ArrayList();
                for (Object obj : list2) {
                    din dinVar = (din) obj;
                    if ((dinVar instanceof ctr) && nullSafeIsEqual(((ctr) dinVar).a, ctrVarJ2.a)
                            && !dinVar.equals(ctrVarJ2)) {
                        arrayList3.add(obj);
                    }
                }
            } else {
                arrayList3 = list;
            }
            for (din dinVar2 : arrayList3) {
                bl(canvas, f, dinVar2.c, dinVar2.d, 0, codeEditor10.getColorScheme().b.get(47), 0);
            }
            ctr ctrVarJ3 = snippetController.j();
            if (ctrVarJ3 != null) {
                aao aaoVar2 = snippetController.c;
                throwIfVar1IsNull(aaoVar2);
                List list3 = aaoVar2.a;
                throwIfVar1IsNull(list3);
                ArrayList arrayList4 = new ArrayList();
                for (Object obj2 : list3) {
                    din dinVar3 = (din) obj2;
                    if ((dinVar3 instanceof ctr) && !nullSafeIsEqual(((ctr) dinVar3).a, ctrVarJ3.a)) {
                        arrayList4.add(obj2);
                    }
                }
                list = arrayList4;
            }
            for (din dinVar4 : list) {
                bl(canvas, f, dinVar4.c, dinVar4.d, 0, codeEditor10.getColorScheme().b.get(46), 0);
            }
            asnVar2 = this;
        }
        float f16 = f;
        asnVar2.r.getProps().getClass();
        int i68 = firstVisibleRow;
        dln dlnVar2 = null;
        int i69 = 0;
        ek ekVar8 = null;
        int i70 = 0;
        int i71 = -1;
        while (i68 <= asnVar2.r.getLastVisibleRow() && ddoVarI.hasNext()) {
            ddm next3 = ddoVarI.next();
            int i72 = next3.a;
            final int i73 = asnVar2.be(i72).b;
            if (i68 != firstVisibleRow || chrVar == null) {
                i = i69;
                if (next3.b) {
                    long jAl = KotlinHelpers.al(i72, i68);
                    ekVar2 = ekVar8;
                    long[] jArr7 = (long[]) ekVar.d;
                    i2 = i70;
                    int i74 = ekVar.c;
                    int i75 = i74 + 1;
                    ekVar.c = i75;
                    jArr7[i74] = jAl;
                    i3 = firstVisibleRow;
                    if (jArr7.length == i75) {
                        long[] jArr8 = new long[i75 << 1];
                        System.arraycopy(jArr7, 0, jArr8, 0, i75);
                        ekVar.d = jArr8;
                    }
                } else {
                    ekVar2 = ekVar8;
                    i2 = i70;
                    i3 = firstVisibleRow;
                }
            } else {
                chrVar.a = i72;
                i = i69;
                ekVar2 = ekVar8;
                i2 = i70;
                i3 = firstVisibleRow;
            }
            if (i71 != i72) {
                cba cbaVarAc = asnVar2.r.getRenderContext().a.ac(i72);
                if (cbaVarAc == null || cbaVarAc.c != asnVar2.ab || (ekVar4 = cbaVarAc.b) == null || ekVar4.c <= i73) {
                    ekVar4 = null;
                }
                asnVar2.ag = asnVar2.be(i72);
                if (dlnVar2 != null) {
                    try {
                        dlnVar2.i(-1);
                    } catch (Exception e) {
                        Log.w("EditorRenderer", "Failed to release SpanReader", e);
                    }
                }
                if (ioVar5 == null) {
                    ioVar2 = avf.a;
                    ioVar = ioVar5;
                } else {
                    ioVar = ioVar5;
                    ioVar2 = new io(ioVar, 6);
                }
                try {
                    ioVar2.i(i72);
                } catch (Exception e2) {
                    Log.w("EditorRenderer", "Failed to read span", e2);
                    ioVar2 = avf.a;
                }
                if (ioVar2.n() == 0) {
                    ioVar2 = avf.a;
                }
                CodeEditor codeEditor11 = asnVar2.r;
                if ((codeEditor11.o & (-185)) != 0) {
                    afo afoVar = asnVar2.ag;
                    codeEditor11.getClass();
                    char[] cArr = afoVar.a;
                    int i76 = afoVar.b;
                    int i77 = 0;
                    while (i77 < i76) {
                        char c2 = cArr[i77];
                        if (c2 != '\t' && c2 != ' ') {
                            break;
                        } else {
                            i77++;
                        }
                    }
                    if (i77 != i76 && (codeEditor11.o & 6) != 0) {
                        while (true) {
                            if (i76 <= 0) {
                                break;
                                break;
                            }
                            char c3 = cArr[i76 - 1];
                            if (c3 != '\t' && c3 != ' ') {
                                break;
                            } else {
                                i76--;
                            }
                        }
                    } else {
                        break;
                    }
                    long jAl2 = KotlinHelpers.al(i77, i76);
                    i4 = i68;
                    i7 = (int) (jAl2 >> 32);
                    i5 = (int) (jAl2 & 4294967295L);
                    dlnVar = ioVar2;
                    ekVar3 = ekVar4;
                    i6 = i72;
                } else {
                    i4 = i68;
                    i5 = i;
                    dlnVar = ioVar2;
                    ekVar3 = ekVar4;
                    i6 = i72;
                }
                f2 = f15;
                float f17 = next3.g;
                f3 = (-f2) + f17;
                f4 = f2 - f17;
                if (next3.b) {
                    i8 = i6;
                } else {
                    i8 = i6;
                    if ((asnVar2.r.getNonPrintablePaintingFlags() & 128) != 0) {
                        i9 = i4;
                        canvas2 = canvas;
                        asnVar2.av(canvas2, f16, i9, asnVar2.z);
                        f3 += fBg;
                        f4 -= fBg;
                    }
                    f5 = f4;
                    f6 = f3;
                    final int nonPrintablePaintingFlags = asnVar2.r.getNonPrintablePaintingFlags();
                    codeEditor = asnVar2.r;
                    i10 = i5;
                    if (codeEditor.cp || codeEditor.getEventHandler().k || !canvas2.isHardwareAccelerated()) {
                        f7 = f6;
                        f8 = f2;
                        ioVar5 = ioVar;
                        drd drdVar = new drd();
                        drdVar.ac(asnVar2.ag, next3.d, next3.e, dlnVar.l(i72), next3.f, asnVar2.bf(i72), asnVar2.d,
                                ekVar3, asnVar2.ap());
                        asnVar2.am(drdVar, i72);
                        canvas2.save();
                        canvas2.translate(-f5, (asnVar2.r.getRowHeight() * i9) - asnVar2.r.getOffsetY());
                        float fMax = Math.max(0.0f, f5);
                        long jS = drdVar.s(canvas2, fMax, asnVar2.r.getWidth() + fMax);
                        canvas2.restore();
                        f9 = 0.0f;
                        z = ((int) (jS >> 32)) == i35;
                        fIntBitsToFloat = Float.intBitsToFloat((int) (jS & 4294967295L)) + f7;
                        ddmVar = next3;
                        if (!z && ddmVar.c && (nonPrintablePaintingFlags & 16) != 0) {
                            asnVar2.av(canvas2, fIntBitsToFloat, i9, asnVar2.y);
                        } else if (!ddmVar.c && asnVar2.r.af && (nonPrintablePaintingFlags & 128) != 0) {
                            asnVar2.av(canvas2, fIntBitsToFloat, i9, asnVar2.aa);
                        }
                    } else {
                        CodeEditor codeEditor12 = asnVar2.r;
                        if (codeEditor12.af) {
                            f7 = f6;
                            f8 = f2;
                            ioVar5 = ioVar;
                        } else {
                            ioVar5 = ioVar;
                            if (Build.VERSION.SDK_INT >= 29) {
                                if (next3.e - next3.d > 128) {
                                    codeEditor12.getProps().getClass();
                                } else {
                                    jx jxVar2 = codeEditor12.getRenderContext().b;
                                    float rowHeight = (asnVar2.r.getRowHeight() * i9) - asnVar2.r.getOffsetY();
                                    CodeEditor codeEditor13 = (CodeEditor) jxVar2.e;
                                    if (!canvas2.isHardwareAccelerated()) {
                                        throw new UnsupportedOperationException(
                                                "Only hardware-accelerated canvas can be used");
                                    }
                                    dnv styles = codeEditor13.getStyles();
                                    Stack stack = (Stack) jxVar2.h;
                                    ArrayList arrayList5 = (ArrayList) jxVar2.f;
                                    int size = arrayList5.size();
                                    f8 = f2;
                                    int i78 = 0;
                                    while (true) {
                                        if (i78 >= size) {
                                            f7 = f6;
                                            if (stack.isEmpty()) {
                                                dbhVar = new dbh();
                                                dbhVar.a = i72;
                                                dbhVar.b = at.f();
                                                dbhVar.c = true;
                                            } else {
                                                dbhVar = (dbh) stack.pop();
                                            }
                                            dbhVar.a = i72;
                                            dbhVar.c = true;
                                            arrayList5.add(0, dbhVar);
                                            dbhVar2 = dbhVar;
                                            break;
                                        }
                                        int i79 = size;
                                        Object obj3 = arrayList5.get(i78);
                                        f7 = f6;
                                        throwIfVar1IsNull(obj3, "get(...)");
                                        dbhVar2 = (dbh) obj3;
                                        if (dbhVar2.a == i72) {
                                            Collections.swap(arrayList5, 0, i78);
                                            break;
                                        } else {
                                            i78++;
                                            size = i79;
                                            f6 = f7;
                                        }
                                    }
                                    if (dbhVar2.c || !dbhVar2.b.hasDisplayList()) {
                                        io ioVar6 = styles != null ? styles.a : null;
                                        dln ioVar7 = ioVar6 == null ? avf.a : new io(ioVar6, 6);
                                        try {
                                            ioVar7.i(i72);
                                        } catch (Exception unused) {
                                            ioVar7 = avf.a;
                                        }
                                        dln dlnVar3 = ioVar7;
                                        asn renderer = codeEditor13.getRenderer();
                                        RenderNode renderNode = dbhVar2.b;
                                        renderNode.setPosition(0, 0,
                                                (int) (renderer.ba(null, i72, 0.0f, 0.0f, dlnVar3, false) + 0.5f),
                                                renderer.r.getRowHeight());
                                        try {
                                            renderer.ba(renderNode.beginRecording(), i72, 0.0f, 0.0f, dlnVar3, false);
                                            i72 = i72;
                                            renderNode.endRecording();
                                            try {
                                                dlnVar3.i(-1);
                                            } catch (Exception e3) {
                                                e3.printStackTrace();
                                            }
                                            dbhVar2.c = false;
                                        } catch (Throwable th) {
                                            renderNode.endRecording();
                                            throw th;
                                        }
                                    }
                                    canvas2.save();
                                    canvas2.translate(f16, rowHeight);
                                    canvas2.drawRenderNode(dbhVar2.b);
                                    canvas2.restore();
                                    float width = dbhVar2.b.getWidth() + f16;
                                    if (next3.c && (nonPrintablePaintingFlags & 16) != 0) {
                                        asnVar2.av(canvas2, width, i9, asnVar2.y);
                                    }
                                    ddmVar = next3;
                                    f9 = 0.0f;
                                }
                            }
                            f7 = f6;
                            f8 = f2;
                        }
                        drd drdVar2 = new drd();
                        drdVar2.ac(asnVar2.ag, next3.d, next3.e, dlnVar.l(i72), next3.f, asnVar2.bf(i72), asnVar2.d,
                                ekVar3, asnVar2.ap());
                        asnVar2.am(drdVar2, i72);
                        canvas2.save();
                        canvas2.translate(-f5, (asnVar2.r.getRowHeight() * i9) - asnVar2.r.getOffsetY());
                        float fMax2 = Math.max(0.0f, f5);
                        long jS2 = drdVar2.s(canvas2, fMax2, asnVar2.r.getWidth() + fMax2);
                        canvas2.restore();
                        f9 = 0.0f;
                        if (((int) (jS2 >> 32)) == i35) {
                        }
                        fIntBitsToFloat = Float.intBitsToFloat((int) (jS2 & 4294967295L)) + f7;
                        ddmVar = next3;
                        if (!z) {
                            if (!ddmVar.c) {
                                asnVar2.av(canvas2, fIntBitsToFloat, i9, asnVar2.aa);
                            }
                        } else if (!ddmVar.c) {
                            asnVar2.av(canvas2, fIntBitsToFloat, i9, asnVar2.aa);
                        }
                    }
                    if (fMin != f9 || (i7 == i73 && (nonPrintablePaintingFlags & 8) == 0)) {
                        asnVar = asnVar2;
                        i11 = i72;
                        i12 = i7;
                        i13 = i67;
                        f10 = f7;
                        i14 = i10;
                    } else {
                        final drd drdVar3 = new drd();
                        drdVar3.ac(asnVar2.ag, ddmVar.d, ddmVar.e, dlnVar.l(i72), ddmVar.f, asnVar2.bf(i72), asnVar2.d,
                                ekVar3, asnVar2.ap());
                        canvas2.save();
                        float f18 = f7;
                        canvas2.translate(f18, asnVar2.r.du(i9) - asnVar2.r.getOffsetY());
                        rj rjVar = asnVar2.c;
                        float fDu = asnVar2.r.du(i9) - asnVar2.r.getOffsetY();
                        rjVar.c = f18;
                        rjVar.d = fDu;
                        float fMax3 = Math.max(f9, f18);
                        float width2 = fMax3 + asnVar2.r.getWidth();
                        i13 = i67;
                        asnVar2.e.setColor(asnVar2.r.getColorScheme().b.get(i13));
                        final int i80 = i7;
                        final int i81 = i72;
                        f10 = f18;
                        i12 = i80;
                        i14 = i10;
                        i11 = i81;
                        asnVar = this;
                        drdVar3.z(ddmVar.d, ddmVar.e, canvas2, fMax3, width2, false, new dqy() { // from class:
                                                                                                 // me.hd.wauxv.obf.ash
                            @Override // me.hd.wauxv.obf.dqy
                            public final void h(Canvas canvas5, char[] cArr2, int i82, int i83, int i84, int i85,
                                    boolean z3, float f19, float f20, dre dreVar, dle dleVar) {
                                int i86;
                                int i87;
                                ahy ahyVar2;
                                ud udVar14;
                                int i88;
                                int i89;
                                ud udVar15;
                                int i90;
                                int i91;
                                int i92;
                                asn asnVar3;
                                int i93 = nonPrintablePaintingFlags;
                                int i94 = i93 & 1;
                                asn asnVar4 = this.a;
                                drd drdVar4 = drdVar3;
                                int i95 = i80;
                                if (i94 != 0) {
                                    asnVar4.bc(canvas5, drdVar4, cArr2, i82, i83, i84, i85, z3, f19, f20, 0, i95);
                                }
                                int i96 = i93 & 2;
                                int i97 = i10;
                                if (i96 != 0) {
                                    asnVar4.bc(canvas5, drdVar4, cArr2, i82, i83, i84, i85, z3, f19, f20, i95, i97);
                                    i95 = i95;
                                    i97 = i97;
                                }
                                int i98 = i93 & 4;
                                int i99 = i95;
                                int i100 = i73;
                                if (i98 != 0) {
                                    i86 = i93;
                                    i87 = i99;
                                    asnVar4.bc(canvas5, drdVar4, cArr2, i82, i83, i84, i85, z3, f19, f20, i97, i100);
                                } else {
                                    i86 = i93;
                                    i87 = i99;
                                }
                                if ((i86 & 64) == 0 || !asnVar4.af.h()
                                        || (i89 = i81) < (i88 = (udVar14 = (ahyVar2 = asnVar4.af).c).b)
                                        || i89 > (i90 = (udVar15 = ahyVar2.d).b)) {
                                    return;
                                }
                                int i101 = i89 == i88 ? udVar14.c : 0;
                                if (i89 == i90) {
                                    i100 = udVar15.c;
                                }
                                if ((i86 & 14) == 0) {
                                    asnVar4.bc(canvas5, drdVar4, cArr2, i82, i83, i84, i85, z3, f19, f20, i101, i100);
                                    return;
                                }
                                asn asnVar5 = asnVar4;
                                int i102 = i97;
                                int i103 = i100;
                                int i104 = i101;
                                if (i94 == 0) {
                                    i91 = i103;
                                    asnVar5.bc(canvas5, drdVar4, cArr2, i82, i83, i84, i85, z3, f19, f20, i104,
                                            Math.min(i87, i103));
                                    asnVar5 = asnVar5;
                                } else {
                                    i91 = i103;
                                }
                                if (i96 == 0) {
                                    i92 = i104;
                                    asnVar3 = asnVar5;
                                    asnVar3.bc(canvas5, drdVar4, cArr2, i82, i83, i84, i85, z3, f19, f20,
                                            Math.max(i87, i104), Math.min(i102, i91));
                                } else {
                                    i92 = i104;
                                    asnVar3 = asnVar5;
                                }
                                if (i98 == 0) {
                                    asnVar3.bc(canvas5, drdVar4, cArr2, i82, i83, i84, i85, z3, f19, f20,
                                            Math.max(i102, i92), i91);
                                }
                            }
                        });
                        canvas2.restore();
                        rj rjVar2 = asnVar.c;
                        rjVar2.c = 0.0f;
                        rjVar2.d = 0.0f;
                    }
                    udVar2 = udVar12;
                    if (udVar12 != null && i11 == udVar2.b) {
                        int i82 = udVar2.c;
                        int i83 = i82 + i29;
                        iMin = Math.min(Math.max(i82, ddmVar.d), ddmVar.e);
                        iMin2 = Math.min(Math.max(i83, ddmVar.d), ddmVar.e);
                        if (iMin < iMin2) {
                            drd drdVar4 = new drd();
                            drdVar4.ac(asnVar.ag, ddmVar.d, ddmVar.e, dlnVar.l(i11), ddmVar.f, asnVar.ah.z(i11),
                                    asnVar.d, ekVar3, asnVar.ap());
                            asnVar.g.top = asnVar.r.dt(i9) - asnVar.r.getOffsetY();
                            RectF rectF3 = asnVar.g;
                            rectF3.bottom = (asnVar.r.getRowHeight() * 0.06f) + rectF3.top;
                            drdVar4.y(iMin, iMin2, new dqx() { // from class: me.hd.wauxv.obf.asi
                                @Override // me.hd.wauxv.obf.dqx
                                public final boolean g(float f19, float f20) {
                                    asn asnVar3 = this.a;
                                    CodeEditor codeEditor14 = asnVar3.r;
                                    RectF rectF4 = asnVar3.g;
                                    float f21 = f10;
                                    float f22 = f19 + f21;
                                    rectF4.left = f22;
                                    rectF4.right = f21 + f20;
                                    if (f22 > 0.0f) {
                                        asnVar3.ar(canvas2, codeEditor14.getColorScheme().b.get(10), rectF4);
                                    }
                                    return rectF4.right < ((float) codeEditor14.getWidth());
                                }
                            });
                        }
                    }
                    layout = asnVar.r.getLayout();
                    if (asnVar.af.h()) {
                        udVar5 = asnVar.af.c;
                        if (udVar5.b == i11 || !ak(udVar5.c, ddmVar.d, ddmVar.e, ddmVar.c)) {
                            asnVar2 = asnVar;
                            arrayList2 = arrayList;
                        } else {
                            float fEb = asnVar.r.eb();
                            ud udVar14 = asnVar.af.c;
                            float offsetX2 = (fEb + layout.r(udVar14.b, udVar14.c)[1]) - asnVar.r.getOffsetX();
                            aff affVar2 = asnVar.ah;
                            ud udVar15 = asnVar.af.c;
                            int i84 = affVar2.ad(udVar15.b, udVar15.c) ? 2 : 1;
                            asnVar2 = asnVar;
                            asm asmVar = new asm(asnVar2, offsetX2, asnVar.bh(i9) - asnVar.r.getOffsetY(), i84,
                                    asnVar.r.getLeftHandleDescriptor());
                            arrayList2 = arrayList;
                            arrayList2.add(asmVar);
                            ud udVar16 = asnVar2.af.c;
                            asnVar2.al(asmVar, udVar16.b, udVar16.c);
                        }
                        udVar6 = asnVar2.af.d;
                        if (udVar6.b == i11 && ak(udVar6.c, ddmVar.d, ddmVar.e, ddmVar.c)) {
                            float fEb2 = asnVar2.r.eb();
                            ud udVar17 = asnVar2.af.d;
                            float offsetX3 = (fEb2 + layout.r(udVar17.b, udVar17.c)[1]) - asnVar2.r.getOffsetX();
                            aff affVar3 = asnVar2.ah;
                            ud udVar18 = asnVar2.af.d;
                            asm asmVar2 = new asm(asnVar2, offsetX3, asnVar2.bh(i9) - asnVar2.r.getOffsetY(),
                                    affVar3.ad(udVar18.b, udVar18.c) ? 1 : 2, asnVar2.r.getRightHandleDescriptor());
                            arrayList2.add(asmVar2);
                            ud udVar19 = asnVar2.af.d;
                            asnVar2.al(asmVar2, udVar19.b, udVar19.c);
                        }
                    } else {
                        asnVar2 = asnVar;
                        arrayList2 = arrayList;
                        udVar3 = asnVar2.af.c;
                        if (udVar3.b == i11 && ak(udVar3.c, ddmVar.d, ddmVar.e, ddmVar.c)) {
                            float fEb3 = asnVar2.r.eb();
                            ud udVar20 = asnVar2.af.c;
                            asm asmVar3 = new asm(asnVar2,
                                    (fEb3 + layout.r(udVar20.b, udVar20.c)[1]) - asnVar2.r.getOffsetX(),
                                    asnVar2.bh(i9) - asnVar2.r.getOffsetY(), 0, asnVar2.r.getInsertHandleDescriptor());
                            arrayList2.add(asmVar3);
                            ud udVar21 = asnVar2.af.c;
                            asnVar2.al(asmVar3, udVar21.b, udVar21.c);
                        }
                    }
                    udVar4 = udVar13;
                    if (udVar4 != null) {
                        if (!asnVar2.r.dy() && asnVar2.r.bo.h()
                                && (selectingTarget = asnVar2.r.getSelectingTarget()) != null
                                && selectingTarget.b == i11 && ak(selectingTarget.c, ddmVar.d, ddmVar.e, ddmVar.c)) {
                            i35 = 1;
                            asm asmVar4 = new asm(asnVar2,
                                    (asnVar2.r.eb() + layout.r(selectingTarget.b, selectingTarget.c)[1])
                                            - asnVar2.r.getOffsetX(),
                                    asnVar2.bh(i9) - asnVar2.r.getOffsetY(), -1, null);
                            arrayList2.add(asmVar4);
                            asnVar2.al(asmVar4, selectingTarget.b, selectingTarget.c);
                        }
                        i68 = i9 + 1;
                        udVar12 = udVar2;
                        dlnVar2 = dlnVar;
                        udVar13 = udVar4;
                        firstVisibleRow = i3;
                        f15 = f8;
                        i69 = i14;
                        i70 = i12;
                        ekVar8 = ekVar3;
                        i71 = i8;
                        i67 = i13;
                        f16 = f;
                    } else if (udVar4.b == i11 && ak(udVar4.c, ddmVar.d, ddmVar.e, ddmVar.c)) {
                        asm asmVar5 = new asm(asnVar2,
                                (asnVar2.r.eb() + layout.r(udVar4.b, udVar4.c)[1]) - asnVar2.r.getOffsetX(),
                                asnVar2.bh(i9) - asnVar2.r.getOffsetY(), -1, null);
                        arrayList2.add(asmVar5);
                        asnVar2.al(asmVar5, udVar4.b, udVar4.c);
                    }
                    i35 = 1;
                    i68 = i9 + 1;
                    udVar12 = udVar2;
                    dlnVar2 = dlnVar;
                    udVar13 = udVar4;
                    firstVisibleRow = i3;
                    f15 = f8;
                    i69 = i14;
                    i70 = i12;
                    ekVar8 = ekVar3;
                    i71 = i8;
                    i67 = i13;
                    f16 = f;
                }
                i9 = i4;
                canvas2 = canvas;
                f5 = f4;
                f6 = f3;
                final int nonPrintablePaintingFlags2 = asnVar2.r.getNonPrintablePaintingFlags();
                codeEditor = asnVar2.r;
                i10 = i5;
                if (codeEditor.cp) {
                    f7 = f6;
                    f8 = f2;
                    ioVar5 = ioVar;
                    drd drdVar22 = new drd();
                    drdVar22.ac(asnVar2.ag, next3.d, next3.e, dlnVar.l(i72), next3.f, asnVar2.bf(i72), asnVar2.d,
                            ekVar3, asnVar2.ap());
                    asnVar2.am(drdVar22, i72);
                    canvas2.save();
                    canvas2.translate(-f5, (asnVar2.r.getRowHeight() * i9) - asnVar2.r.getOffsetY());
                    float fMax22 = Math.max(0.0f, f5);
                    long jS22 = drdVar22.s(canvas2, fMax22, asnVar2.r.getWidth() + fMax22);
                    canvas2.restore();
                    f9 = 0.0f;
                    if (((int) (jS22 >> 32)) == i35) {
                    }
                    fIntBitsToFloat = Float.intBitsToFloat((int) (jS22 & 4294967295L)) + f7;
                    ddmVar = next3;
                    if (!z) {
                        if (!ddmVar.c) {
                            asnVar2.av(canvas2, fIntBitsToFloat, i9, asnVar2.aa);
                        }
                    } else if (!ddmVar.c) {
                        asnVar2.av(canvas2, fIntBitsToFloat, i9, asnVar2.aa);
                    }
                } else {
                    f7 = f6;
                    f8 = f2;
                    ioVar5 = ioVar;
                    drd drdVar222 = new drd();
                    drdVar222.ac(asnVar2.ag, next3.d, next3.e, dlnVar.l(i72), next3.f, asnVar2.bf(i72), asnVar2.d,
                            ekVar3, asnVar2.ap());
                    asnVar2.am(drdVar222, i72);
                    canvas2.save();
                    canvas2.translate(-f5, (asnVar2.r.getRowHeight() * i9) - asnVar2.r.getOffsetY());
                    float fMax222 = Math.max(0.0f, f5);
                    long jS222 = drdVar222.s(canvas2, fMax222, asnVar2.r.getWidth() + fMax222);
                    canvas2.restore();
                    f9 = 0.0f;
                    if (((int) (jS222 >> 32)) == i35) {
                    }
                    fIntBitsToFloat = Float.intBitsToFloat((int) (jS222 & 4294967295L)) + f7;
                    ddmVar = next3;
                    if (!z) {
                        if (!ddmVar.c) {
                            asnVar2.av(canvas2, fIntBitsToFloat, i9, asnVar2.aa);
                        }
                    } else if (!ddmVar.c) {
                        asnVar2.av(canvas2, fIntBitsToFloat, i9, asnVar2.aa);
                    }
                }
                if (fMin != f9) {
                    asnVar = asnVar2;
                    i11 = i72;
                    i12 = i7;
                    i13 = i67;
                    f10 = f7;
                    i14 = i10;
                } else {
                    asnVar = asnVar2;
                    i11 = i72;
                    i12 = i7;
                    i13 = i67;
                    f10 = f7;
                    i14 = i10;
                }
                udVar2 = udVar12;
                if (udVar12 != null) {
                    int i822 = udVar2.c;
                    int i832 = i822 + i29;
                    iMin = Math.min(Math.max(i822, ddmVar.d), ddmVar.e);
                    iMin2 = Math.min(Math.max(i832, ddmVar.d), ddmVar.e);
                    if (iMin < iMin2) {
                        drd drdVar42 = new drd();
                        drdVar42.ac(asnVar.ag, ddmVar.d, ddmVar.e, dlnVar.l(i11), ddmVar.f, asnVar.ah.z(i11), asnVar.d,
                                ekVar3, asnVar.ap());
                        asnVar.g.top = asnVar.r.dt(i9) - asnVar.r.getOffsetY();
                        RectF rectF32 = asnVar.g;
                        rectF32.bottom = (asnVar.r.getRowHeight() * 0.06f) + rectF32.top;
                        drdVar42.y(iMin, iMin2, new dqx() { // from class: me.hd.wauxv.obf.asi
                            @Override // me.hd.wauxv.obf.dqx
                            public final boolean g(float f19, float f20) {
                                asn asnVar3 = this.a;
                                CodeEditor codeEditor14 = asnVar3.r;
                                RectF rectF4 = asnVar3.g;
                                float f21 = f10;
                                float f22 = f19 + f21;
                                rectF4.left = f22;
                                rectF4.right = f21 + f20;
                                if (f22 > 0.0f) {
                                    asnVar3.ar(canvas2, codeEditor14.getColorScheme().b.get(10), rectF4);
                                }
                                return rectF4.right < ((float) codeEditor14.getWidth());
                            }
                        });
                    }
                }
                layout = asnVar.r.getLayout();
                if (asnVar.af.h()) {
                    udVar5 = asnVar.af.c;
                    if (udVar5.b == i11) {
                        asnVar2 = asnVar;
                        arrayList2 = arrayList;
                    } else {
                        asnVar2 = asnVar;
                        arrayList2 = arrayList;
                    }
                    udVar6 = asnVar2.af.d;
                    if (udVar6.b == i11) {
                        float fEb22 = asnVar2.r.eb();
                        ud udVar172 = asnVar2.af.d;
                        float offsetX32 = (fEb22 + layout.r(udVar172.b, udVar172.c)[1]) - asnVar2.r.getOffsetX();
                        aff affVar32 = asnVar2.ah;
                        ud udVar182 = asnVar2.af.d;
                        asm asmVar22 = new asm(asnVar2, offsetX32, asnVar2.bh(i9) - asnVar2.r.getOffsetY(),
                                affVar32.ad(udVar182.b, udVar182.c) ? 1 : 2, asnVar2.r.getRightHandleDescriptor());
                        arrayList2.add(asmVar22);
                        ud udVar192 = asnVar2.af.d;
                        asnVar2.al(asmVar22, udVar192.b, udVar192.c);
                    }
                } else {
                    asnVar2 = asnVar;
                    arrayList2 = arrayList;
                    udVar3 = asnVar2.af.c;
                    if (udVar3.b == i11) {
                        float fEb32 = asnVar2.r.eb();
                        ud udVar202 = asnVar2.af.c;
                        asm asmVar32 = new asm(asnVar2,
                                (fEb32 + layout.r(udVar202.b, udVar202.c)[1]) - asnVar2.r.getOffsetX(),
                                asnVar2.bh(i9) - asnVar2.r.getOffsetY(), 0, asnVar2.r.getInsertHandleDescriptor());
                        arrayList2.add(asmVar32);
                        ud udVar212 = asnVar2.af.c;
                        asnVar2.al(asmVar32, udVar212.b, udVar212.c);
                    }
                }
                udVar4 = udVar13;
                if (udVar4 != null) {
                    if (!asnVar2.r.dy()) {
                    }
                    i68 = i9 + 1;
                    udVar12 = udVar2;
                    dlnVar2 = dlnVar;
                    udVar13 = udVar4;
                    firstVisibleRow = i3;
                    f15 = f8;
                    i69 = i14;
                    i70 = i12;
                    ekVar8 = ekVar3;
                    i71 = i8;
                    i67 = i13;
                    f16 = f;
                } else if (udVar4.b == i11) {
                    asm asmVar52 = new asm(asnVar2,
                            (asnVar2.r.eb() + layout.r(udVar4.b, udVar4.c)[1]) - asnVar2.r.getOffsetX(),
                            asnVar2.bh(i9) - asnVar2.r.getOffsetY(), -1, null);
                    arrayList2.add(asmVar52);
                    asnVar2.al(asmVar52, udVar4.b, udVar4.c);
                }
                i35 = 1;
                i68 = i9 + 1;
                udVar12 = udVar2;
                dlnVar2 = dlnVar;
                udVar13 = udVar4;
                firstVisibleRow = i3;
                f15 = f8;
                i69 = i14;
                i70 = i12;
                ekVar8 = ekVar3;
                i71 = i8;
                i67 = i13;
                f16 = f;
            } else {
                i4 = i68;
                ioVar = ioVar5;
                i5 = i;
                dlnVar = dlnVar2;
                i6 = i71;
                ekVar3 = ekVar2;
            }
            i7 = i2;
            f2 = f15;
            float f172 = next3.g;
            f3 = (-f2) + f172;
            f4 = f2 - f172;
            if (next3.b) {
                i8 = i6;
                if ((asnVar2.r.getNonPrintablePaintingFlags() & 128) != 0) {
                    i9 = i4;
                    canvas2 = canvas;
                    asnVar2.av(canvas2, f16, i9, asnVar2.z);
                    f3 += fBg;
                    f4 -= fBg;
                }
                f5 = f4;
                f6 = f3;
                final int nonPrintablePaintingFlags22 = asnVar2.r.getNonPrintablePaintingFlags();
                codeEditor = asnVar2.r;
                i10 = i5;
                if (codeEditor.cp) {
                    f7 = f6;
                    f8 = f2;
                    ioVar5 = ioVar;
                    drd drdVar2222 = new drd();
                    drdVar2222.ac(asnVar2.ag, next3.d, next3.e, dlnVar.l(i72), next3.f, asnVar2.bf(i72), asnVar2.d,
                            ekVar3, asnVar2.ap());
                    asnVar2.am(drdVar2222, i72);
                    canvas2.save();
                    canvas2.translate(-f5, (asnVar2.r.getRowHeight() * i9) - asnVar2.r.getOffsetY());
                    float fMax2222 = Math.max(0.0f, f5);
                    long jS2222 = drdVar2222.s(canvas2, fMax2222, asnVar2.r.getWidth() + fMax2222);
                    canvas2.restore();
                    f9 = 0.0f;
                    if (((int) (jS2222 >> 32)) == i35) {
                    }
                    fIntBitsToFloat = Float.intBitsToFloat((int) (jS2222 & 4294967295L)) + f7;
                    ddmVar = next3;
                    if (!z) {
                        if (!ddmVar.c) {
                            asnVar2.av(canvas2, fIntBitsToFloat, i9, asnVar2.aa);
                        }
                    } else if (!ddmVar.c) {
                        asnVar2.av(canvas2, fIntBitsToFloat, i9, asnVar2.aa);
                    }
                } else {
                    f7 = f6;
                    f8 = f2;
                    ioVar5 = ioVar;
                    drd drdVar22222 = new drd();
                    drdVar22222.ac(asnVar2.ag, next3.d, next3.e, dlnVar.l(i72), next3.f, asnVar2.bf(i72), asnVar2.d,
                            ekVar3, asnVar2.ap());
                    asnVar2.am(drdVar22222, i72);
                    canvas2.save();
                    canvas2.translate(-f5, (asnVar2.r.getRowHeight() * i9) - asnVar2.r.getOffsetY());
                    float fMax22222 = Math.max(0.0f, f5);
                    long jS22222 = drdVar22222.s(canvas2, fMax22222, asnVar2.r.getWidth() + fMax22222);
                    canvas2.restore();
                    f9 = 0.0f;
                    if (((int) (jS22222 >> 32)) == i35) {
                    }
                    fIntBitsToFloat = Float.intBitsToFloat((int) (jS22222 & 4294967295L)) + f7;
                    ddmVar = next3;
                    if (!z) {
                        if (!ddmVar.c) {
                            asnVar2.av(canvas2, fIntBitsToFloat, i9, asnVar2.aa);
                        }
                    } else if (!ddmVar.c) {
                        asnVar2.av(canvas2, fIntBitsToFloat, i9, asnVar2.aa);
                    }
                }
                if (fMin != f9) {
                    asnVar = asnVar2;
                    i11 = i72;
                    i12 = i7;
                    i13 = i67;
                    f10 = f7;
                    i14 = i10;
                } else {
                    asnVar = asnVar2;
                    i11 = i72;
                    i12 = i7;
                    i13 = i67;
                    f10 = f7;
                    i14 = i10;
                }
                udVar2 = udVar12;
                if (udVar12 != null) {
                    int i8222 = udVar2.c;
                    int i8322 = i8222 + i29;
                    iMin = Math.min(Math.max(i8222, ddmVar.d), ddmVar.e);
                    iMin2 = Math.min(Math.max(i8322, ddmVar.d), ddmVar.e);
                    if (iMin < iMin2) {
                        drd drdVar422 = new drd();
                        drdVar422.ac(asnVar.ag, ddmVar.d, ddmVar.e, dlnVar.l(i11), ddmVar.f, asnVar.ah.z(i11), asnVar.d,
                                ekVar3, asnVar.ap());
                        asnVar.g.top = asnVar.r.dt(i9) - asnVar.r.getOffsetY();
                        RectF rectF322 = asnVar.g;
                        rectF322.bottom = (asnVar.r.getRowHeight() * 0.06f) + rectF322.top;
                        drdVar422.y(iMin, iMin2, new dqx() { // from class: me.hd.wauxv.obf.asi
                            @Override // me.hd.wauxv.obf.dqx
                            public final boolean g(float f19, float f20) {
                                asn asnVar3 = this.a;
                                CodeEditor codeEditor14 = asnVar3.r;
                                RectF rectF4 = asnVar3.g;
                                float f21 = f10;
                                float f22 = f19 + f21;
                                rectF4.left = f22;
                                rectF4.right = f21 + f20;
                                if (f22 > 0.0f) {
                                    asnVar3.ar(canvas2, codeEditor14.getColorScheme().b.get(10), rectF4);
                                }
                                return rectF4.right < ((float) codeEditor14.getWidth());
                            }
                        });
                    }
                }
                layout = asnVar.r.getLayout();
                if (asnVar.af.h()) {
                    udVar5 = asnVar.af.c;
                    if (udVar5.b == i11) {
                        asnVar2 = asnVar;
                        arrayList2 = arrayList;
                    } else {
                        asnVar2 = asnVar;
                        arrayList2 = arrayList;
                    }
                    udVar6 = asnVar2.af.d;
                    if (udVar6.b == i11) {
                        float fEb222 = asnVar2.r.eb();
                        ud udVar1722 = asnVar2.af.d;
                        float offsetX322 = (fEb222 + layout.r(udVar1722.b, udVar1722.c)[1]) - asnVar2.r.getOffsetX();
                        aff affVar322 = asnVar2.ah;
                        ud udVar1822 = asnVar2.af.d;
                        asm asmVar222 = new asm(asnVar2, offsetX322, asnVar2.bh(i9) - asnVar2.r.getOffsetY(),
                                affVar322.ad(udVar1822.b, udVar1822.c) ? 1 : 2, asnVar2.r.getRightHandleDescriptor());
                        arrayList2.add(asmVar222);
                        ud udVar1922 = asnVar2.af.d;
                        asnVar2.al(asmVar222, udVar1922.b, udVar1922.c);
                    }
                } else {
                    asnVar2 = asnVar;
                    arrayList2 = arrayList;
                    udVar3 = asnVar2.af.c;
                    if (udVar3.b == i11) {
                        float fEb322 = asnVar2.r.eb();
                        ud udVar2022 = asnVar2.af.c;
                        asm asmVar322 = new asm(asnVar2,
                                (fEb322 + layout.r(udVar2022.b, udVar2022.c)[1]) - asnVar2.r.getOffsetX(),
                                asnVar2.bh(i9) - asnVar2.r.getOffsetY(), 0, asnVar2.r.getInsertHandleDescriptor());
                        arrayList2.add(asmVar322);
                        ud udVar2122 = asnVar2.af.c;
                        asnVar2.al(asmVar322, udVar2122.b, udVar2122.c);
                    }
                }
                udVar4 = udVar13;
                if (udVar4 != null) {
                    if (!asnVar2.r.dy()) {
                    }
                    i68 = i9 + 1;
                    udVar12 = udVar2;
                    dlnVar2 = dlnVar;
                    udVar13 = udVar4;
                    firstVisibleRow = i3;
                    f15 = f8;
                    i69 = i14;
                    i70 = i12;
                    ekVar8 = ekVar3;
                    i71 = i8;
                    i67 = i13;
                    f16 = f;
                } else if (udVar4.b == i11) {
                    asm asmVar522 = new asm(asnVar2,
                            (asnVar2.r.eb() + layout.r(udVar4.b, udVar4.c)[1]) - asnVar2.r.getOffsetX(),
                            asnVar2.bh(i9) - asnVar2.r.getOffsetY(), -1, null);
                    arrayList2.add(asmVar522);
                    asnVar2.al(asmVar522, udVar4.b, udVar4.c);
                }
                i35 = 1;
                i68 = i9 + 1;
                udVar12 = udVar2;
                dlnVar2 = dlnVar;
                udVar13 = udVar4;
                firstVisibleRow = i3;
                f15 = f8;
                i69 = i14;
                i70 = i12;
                ekVar8 = ekVar3;
                i71 = i8;
                i67 = i13;
                f16 = f;
            } else {
                i8 = i6;
            }
            i9 = i4;
            canvas2 = canvas;
            f5 = f4;
            f6 = f3;
            final int nonPrintablePaintingFlags222 = asnVar2.r.getNonPrintablePaintingFlags();
            codeEditor = asnVar2.r;
            i10 = i5;
            if (codeEditor.cp) {
                f7 = f6;
                f8 = f2;
                ioVar5 = ioVar;
                drd drdVar222222 = new drd();
                drdVar222222.ac(asnVar2.ag, next3.d, next3.e, dlnVar.l(i72), next3.f, asnVar2.bf(i72), asnVar2.d,
                        ekVar3, asnVar2.ap());
                asnVar2.am(drdVar222222, i72);
                canvas2.save();
                canvas2.translate(-f5, (asnVar2.r.getRowHeight() * i9) - asnVar2.r.getOffsetY());
                float fMax222222 = Math.max(0.0f, f5);
                long jS222222 = drdVar222222.s(canvas2, fMax222222, asnVar2.r.getWidth() + fMax222222);
                canvas2.restore();
                f9 = 0.0f;
                if (((int) (jS222222 >> 32)) == i35) {
                }
                fIntBitsToFloat = Float.intBitsToFloat((int) (jS222222 & 4294967295L)) + f7;
                ddmVar = next3;
                if (!z) {
                    if (!ddmVar.c) {
                        asnVar2.av(canvas2, fIntBitsToFloat, i9, asnVar2.aa);
                    }
                } else if (!ddmVar.c) {
                    asnVar2.av(canvas2, fIntBitsToFloat, i9, asnVar2.aa);
                }
            } else {
                f7 = f6;
                f8 = f2;
                ioVar5 = ioVar;
                drd drdVar2222222 = new drd();
                drdVar2222222.ac(asnVar2.ag, next3.d, next3.e, dlnVar.l(i72), next3.f, asnVar2.bf(i72), asnVar2.d,
                        ekVar3, asnVar2.ap());
                asnVar2.am(drdVar2222222, i72);
                canvas2.save();
                canvas2.translate(-f5, (asnVar2.r.getRowHeight() * i9) - asnVar2.r.getOffsetY());
                float fMax2222222 = Math.max(0.0f, f5);
                long jS2222222 = drdVar2222222.s(canvas2, fMax2222222, asnVar2.r.getWidth() + fMax2222222);
                canvas2.restore();
                f9 = 0.0f;
                if (((int) (jS2222222 >> 32)) == i35) {
                }
                fIntBitsToFloat = Float.intBitsToFloat((int) (jS2222222 & 4294967295L)) + f7;
                ddmVar = next3;
                if (!z) {
                    if (!ddmVar.c) {
                        asnVar2.av(canvas2, fIntBitsToFloat, i9, asnVar2.aa);
                    }
                } else if (!ddmVar.c) {
                    asnVar2.av(canvas2, fIntBitsToFloat, i9, asnVar2.aa);
                }
            }
            if (fMin != f9) {
                asnVar = asnVar2;
                i11 = i72;
                i12 = i7;
                i13 = i67;
                f10 = f7;
                i14 = i10;
            } else {
                asnVar = asnVar2;
                i11 = i72;
                i12 = i7;
                i13 = i67;
                f10 = f7;
                i14 = i10;
            }
            udVar2 = udVar12;
            if (udVar12 != null) {
                int i82222 = udVar2.c;
                int i83222 = i82222 + i29;
                iMin = Math.min(Math.max(i82222, ddmVar.d), ddmVar.e);
                iMin2 = Math.min(Math.max(i83222, ddmVar.d), ddmVar.e);
                if (iMin < iMin2) {
                    drd drdVar4222 = new drd();
                    drdVar4222.ac(asnVar.ag, ddmVar.d, ddmVar.e, dlnVar.l(i11), ddmVar.f, asnVar.ah.z(i11), asnVar.d,
                            ekVar3, asnVar.ap());
                    asnVar.g.top = asnVar.r.dt(i9) - asnVar.r.getOffsetY();
                    RectF rectF3222 = asnVar.g;
                    rectF3222.bottom = (asnVar.r.getRowHeight() * 0.06f) + rectF3222.top;
                    drdVar4222.y(iMin, iMin2, new dqx() { // from class: me.hd.wauxv.obf.asi
                        @Override // me.hd.wauxv.obf.dqx
                        public final boolean g(float f19, float f20) {
                            asn asnVar3 = this.a;
                            CodeEditor codeEditor14 = asnVar3.r;
                            RectF rectF4 = asnVar3.g;
                            float f21 = f10;
                            float f22 = f19 + f21;
                            rectF4.left = f22;
                            rectF4.right = f21 + f20;
                            if (f22 > 0.0f) {
                                asnVar3.ar(canvas2, codeEditor14.getColorScheme().b.get(10), rectF4);
                            }
                            return rectF4.right < ((float) codeEditor14.getWidth());
                        }
                    });
                }
            }
            layout = asnVar.r.getLayout();
            if (asnVar.af.h()) {
                udVar5 = asnVar.af.c;
                if (udVar5.b == i11) {
                    asnVar2 = asnVar;
                    arrayList2 = arrayList;
                } else {
                    asnVar2 = asnVar;
                    arrayList2 = arrayList;
                }
                udVar6 = asnVar2.af.d;
                if (udVar6.b == i11) {
                    float fEb2222 = asnVar2.r.eb();
                    ud udVar17222 = asnVar2.af.d;
                    float offsetX3222 = (fEb2222 + layout.r(udVar17222.b, udVar17222.c)[1]) - asnVar2.r.getOffsetX();
                    aff affVar3222 = asnVar2.ah;
                    ud udVar18222 = asnVar2.af.d;
                    asm asmVar2222 = new asm(asnVar2, offsetX3222, asnVar2.bh(i9) - asnVar2.r.getOffsetY(),
                            affVar3222.ad(udVar18222.b, udVar18222.c) ? 1 : 2, asnVar2.r.getRightHandleDescriptor());
                    arrayList2.add(asmVar2222);
                    ud udVar19222 = asnVar2.af.d;
                    asnVar2.al(asmVar2222, udVar19222.b, udVar19222.c);
                }
            } else {
                asnVar2 = asnVar;
                arrayList2 = arrayList;
                udVar3 = asnVar2.af.c;
                if (udVar3.b == i11) {
                    float fEb3222 = asnVar2.r.eb();
                    ud udVar20222 = asnVar2.af.c;
                    asm asmVar3222 = new asm(asnVar2,
                            (fEb3222 + layout.r(udVar20222.b, udVar20222.c)[1]) - asnVar2.r.getOffsetX(),
                            asnVar2.bh(i9) - asnVar2.r.getOffsetY(), 0, asnVar2.r.getInsertHandleDescriptor());
                    arrayList2.add(asmVar3222);
                    ud udVar21222 = asnVar2.af.c;
                    asnVar2.al(asmVar3222, udVar21222.b, udVar21222.c);
                }
            }
            udVar4 = udVar13;
            if (udVar4 != null) {
                if (!asnVar2.r.dy()) {
                }
                i68 = i9 + 1;
                udVar12 = udVar2;
                dlnVar2 = dlnVar;
                udVar13 = udVar4;
                firstVisibleRow = i3;
                f15 = f8;
                i69 = i14;
                i70 = i12;
                ekVar8 = ekVar3;
                i71 = i8;
                i67 = i13;
                f16 = f;
            } else if (udVar4.b == i11) {
                asm asmVar5222 = new asm(asnVar2,
                        (asnVar2.r.eb() + layout.r(udVar4.b, udVar4.c)[1]) - asnVar2.r.getOffsetX(),
                        asnVar2.bh(i9) - asnVar2.r.getOffsetY(), -1, null);
                arrayList2.add(asmVar5222);
                asnVar2.al(asmVar5222, udVar4.b, udVar4.c);
            }
            i35 = 1;
            i68 = i9 + 1;
            udVar12 = udVar2;
            dlnVar2 = dlnVar;
            udVar13 = udVar4;
            firstVisibleRow = i3;
            f15 = f8;
            i69 = i14;
            i70 = i12;
            ekVar8 = ekVar3;
            i71 = i8;
            i67 = i13;
            f16 = f;
        }
        if (dlnVar2 != null) {
            try {
                dlnVar2.i(-1);
            } catch (Exception e4) {
                Log.w("EditorRenderer", "Failed to release SpanReader", e4);
            }
        }
        asnVar2.d.setFakeBoldText(false);
        asnVar2.d.setTextSkewX(0.0f);
        asnVar2.e.setStrokeWidth(fMin * 2.0f);
        rj rjVar3 = asnVar2.c;
        csk cskVar2 = asnVar2.e;
        int i85 = rjVar3.a;
        if (i85 == 0) {
            return;
        }
        canvas.drawPoints(rjVar3.b, 0, i85 * 2, cskVar2);
        rjVar3.a = 0;
    }

    public final void az(Canvas canvas) {
        float f;
        float fCurrentTimeMillis;
        float f2;
        float f3;
        int[] iArr;
        CodeEditor codeEditor;
        float rowHeight;
        float[] fArr;
        float f4;
        Path path;
        float f5;
        float f6;
        RectF rectF = this.j;
        rectF.setEmpty();
        RectF rectF2 = this.k;
        rectF2.setEmpty();
        CodeEditor codeEditor2 = this.r;
        asv eventHandler = codeEditor2.getEventHandler();
        eventHandler.getClass();
        if (System.currentTimeMillis() - eventHandler.o < 3200 || eventHandler.q || eventHandler.r
                || (codeEditor2.dy() && codeEditor2.getProps().ae)) {
            asv eventHandler2 = codeEditor2.getEventHandler();
            eventHandler2.getClass();
            if (System.currentTimeMillis() - eventHandler2.o < 3000 || eventHandler2.q || eventHandler2.r) {
                f = 1.0f;
                fCurrentTimeMillis = 0.0f;
            } else {
                f = 1.0f;
                if (System.currentTimeMillis() - eventHandler2.o < 3000
                        || System.currentTimeMillis() - eventHandler2.o >= 3200) {
                    fCurrentTimeMillis = 1.0f;
                } else {
                    eventHandler2.a.postInvalidateOnAnimation();
                    fCurrentTimeMillis = (((System.currentTimeMillis() - eventHandler2.o) - 3000) * 1.0f) / 200.0f;
                }
            }
            if (codeEditor2.dy() && codeEditor2.getProps().ae) {
                fCurrentTimeMillis = 0.0f;
            }
            float dpUnit = codeEditor2.getDpUnit() * 10.0f;
            boolean z = codeEditor2.aw;
            int[] iArr2 = b;
            int[] iArr3 = a;
            float f7 = f;
            RectF rectF3 = this.g;
            if (!z || codeEditor2.af || codeEditor2.getScrollMaxX() <= (codeEditor2.getWidth() * 3) / 4) {
                f2 = 60.0f;
            } else {
                canvas.save();
                canvas.translate(0.0f, dpUnit * fCurrentTimeMillis);
                if (codeEditor2.getEventHandler().r) {
                    f2 = 60.0f;
                    rectF3.set(0.0f, codeEditor2.getHeight() - (codeEditor2.getDpUnit() * 10.0f),
                            codeEditor2.getWidth(), codeEditor2.getHeight());
                    Drawable drawable = this.v;
                    if (drawable != null) {
                        drawable.setBounds((int) rectF3.left, (int) rectF3.top, (int) rectF3.right,
                                (int) rectF3.bottom);
                        this.v.draw(canvas);
                    } else {
                        ar(canvas, codeEditor2.getColorScheme().b.get(13), rectF3);
                    }
                } else {
                    f2 = 60.0f;
                }
                int width = codeEditor2.getWidth();
                float scrollMaxX = codeEditor2.getScrollMaxX();
                float width2 = (width / (codeEditor2.getWidth() + scrollMaxX)) * codeEditor2.getWidth();
                float dpUnit2 = codeEditor2.getDpUnit() * f2;
                if (width2 <= dpUnit2) {
                    width2 = dpUnit2;
                }
                float width3 = (codeEditor2.getWidth() - width2) * (codeEditor2.getOffsetX() / scrollMaxX);
                rectF3.top = codeEditor2.getHeight() - (codeEditor2.getDpUnit() * 10.0f);
                rectF3.bottom = codeEditor2.getHeight();
                rectF3.right = width2 + width3;
                rectF3.left = width3;
                rectF2.set(rectF3);
                Drawable drawable2 = this.u;
                if (drawable2 != null) {
                    drawable2.setState(codeEditor2.getEventHandler().r ? iArr3 : iArr2);
                    this.u.setBounds((int) rectF3.left, (int) rectF3.top, (int) rectF3.right, (int) rectF3.bottom);
                    this.u.draw(canvas);
                } else {
                    ar(canvas, codeEditor2.getColorScheme().b.get(codeEditor2.getEventHandler().r ? 12 : 11), rectF3);
                }
                canvas.restore();
            }
            if (!codeEditor2.av || codeEditor2.getScrollMaxY() <= codeEditor2.getHeight() / 2) {
                return;
            }
            canvas.save();
            canvas.translate(dpUnit * fCurrentTimeMillis, 0.0f);
            if (codeEditor2.getEventHandler().q) {
                rectF3.right = codeEditor2.getWidth();
                rectF3.left = codeEditor2.getWidth() - (codeEditor2.getDpUnit() * 10.0f);
                rectF3.top = 0.0f;
                float height = codeEditor2.getHeight();
                rectF3.bottom = height;
                Drawable drawable3 = this.x;
                if (drawable3 != null) {
                    drawable3.setBounds((int) rectF3.left, (int) rectF3.top, (int) rectF3.right, (int) height);
                    this.x.draw(canvas);
                } else {
                    ar(canvas, codeEditor2.getColorScheme().b.get(13), rectF3);
                }
            }
            int height2 = codeEditor2.getHeight();
            float scrollMaxY = codeEditor2.getScrollMaxY() + height2;
            float f8 = height2;
            float fMax = Math.max((f8 / scrollMaxY) * f8, codeEditor2.getDpUnit() * f2);
            float offsetY = (f8 - fMax) * ((codeEditor2.getOffsetY() * f7) / codeEditor2.getScrollMaxY());
            if (codeEditor2.getEventHandler().q && codeEditor2.al) {
                int lnPanelPositionMode = codeEditor2.getLnPanelPositionMode();
                int lnPanelPosition = codeEditor2.getLnPanelPosition();
                ((arj) codeEditor2.getLineNumberTipTextProvider()).getClass();
                String strI = concatVar2Var1(codeEditor2.getFirstVisibleLine() + 1, "L");
                csk cskVar = this.d;
                float textSize = cskVar.getTextSize();
                cskVar.setTextSize(codeEditor2.getLineInfoTextSize());
                Paint.FontMetricsInt fontMetricsInt = this.t;
                this.t = cskVar.getFontMetricsInt();
                float dpUnit3 = codeEditor2.getDpUnit() * 8.0f;
                float fMeasureText = cskVar.measureText(strI);
                f3 = fMax;
                if (lnPanelPositionMode == 0) {
                    rectF3.top = ((codeEditor2.getHeight() / 2.0f) - (codeEditor2.getRowHeight() / 2.0f)) - dpUnit3;
                    rectF3.bottom = (codeEditor2.getRowHeight() / 2.0f) + (codeEditor2.getHeight() / 2.0f) + dpUnit3;
                    float f9 = fMeasureText / 2.0f;
                    rectF3.left = ((codeEditor2.getWidth() / 2.0f) - f9) - dpUnit3;
                    rectF3.right = (codeEditor2.getWidth() / 2.0f) + f9 + dpUnit3;
                    float f10 = dpUnit3 * 2.0f;
                    float height3 = (codeEditor2.getHeight() / 2.0f) + f10;
                    float dpUnit4 = codeEditor2.getDpUnit() * 10.0f;
                    if (lnPanelPosition != 15) {
                        if ((lnPanelPosition | 2) == lnPanelPosition) {
                            rectF3.top = dpUnit4;
                            rectF3.bottom = codeEditor2.getRowHeight() + dpUnit4 + f10;
                            iArr = iArr2;
                            height3 = codeEditor2.ds(0) + dpUnit4 + dpUnit3;
                        } else {
                            iArr = iArr2;
                        }
                        if ((lnPanelPosition | 8) == lnPanelPosition) {
                            rectF3.top = ((codeEditor2.getHeight() - dpUnit4) - f10) - codeEditor2.getRowHeight();
                            rectF3.bottom = codeEditor2.getHeight() - dpUnit4;
                            height3 = ((codeEditor2.ds(0) + (codeEditor2.getHeight() - codeEditor2.getRowHeight()))
                                    - dpUnit4) - dpUnit3;
                        }
                        if ((lnPanelPosition | 1) == lnPanelPosition) {
                            rectF3.left = dpUnit4;
                            rectF3.right = dpUnit4 + f10 + fMeasureText;
                        }
                        if ((lnPanelPosition | 4) == lnPanelPosition) {
                            rectF3.right = codeEditor2.getWidth() - dpUnit4;
                            rectF3.left = ((codeEditor2.getWidth() - dpUnit4) - f10) - fMeasureText;
                        }
                    } else {
                        iArr = iArr2;
                    }
                    f6 = height3;
                    int i = codeEditor2.getColorScheme().b.get(16);
                    if (i != 0) {
                        cskVar.setColor(i);
                        canvas.drawRoundRect(rectF3, rectF3.height() * 0.13f, rectF3.height() * 0.13f, cskVar);
                    }
                    codeEditor = codeEditor2;
                    f5 = 0.0f;
                } else {
                    iArr = iArr2;
                    rectF3.right = codeEditor2.getWidth() - (codeEditor2.getDpUnit() * 30.0f);
                    float f11 = dpUnit3 * 2.0f;
                    rectF3.left = ((codeEditor2.getWidth() - (codeEditor2.getDpUnit() * 30.0f)) - f11) - fMeasureText;
                    if (lnPanelPosition == 2) {
                        rectF3.top = offsetY;
                        rectF3.bottom = codeEditor2.getRowHeight() + offsetY + f11;
                        rowHeight = codeEditor2.ds(0) + offsetY + dpUnit3;
                        fArr = new float[8];
                        int i2 = 0;
                        for (int i3 = 8; i2 < i3; i3 = 8) {
                            if (i2 != 5) {
                                fArr[i2] = rectF3.height() * 0.5f;
                            }
                            i2++;
                        }
                    } else if (lnPanelPosition == 8) {
                        float f12 = offsetY + f3;
                        rectF3.top = (f12 - codeEditor2.getRowHeight()) - f11;
                        rectF3.bottom = f12;
                        rowHeight = f12 - (codeEditor2.ds(0) / 2.0f);
                        float[] fArr2 = new float[8];
                        int i4 = 0;
                        for (int i5 = 8; i4 < i5; i5 = 8) {
                            if (i4 != 3) {
                                fArr2[i4] = rectF3.height() * 0.5f;
                            }
                            i4++;
                        }
                        fArr = fArr2;
                    } else {
                        float f13 = (f3 / 2.0f) + offsetY;
                        rectF3.top = (f13 - (codeEditor2.getRowHeight() / 2.0f)) - dpUnit3;
                        rectF3.bottom = (codeEditor2.getRowHeight() / 2.0f) + f13 + dpUnit3;
                        rowHeight = (f13 - (codeEditor2.getRowHeight() / 2.0f)) + codeEditor2.ds(0);
                        fArr = null;
                    }
                    Path path2 = this.h;
                    if (fArr != null) {
                        path2.reset();
                        path2.addRoundRect(rectF3, fArr, Path.Direction.CW);
                        codeEditor = codeEditor2;
                        f4 = rowHeight;
                        path = path2;
                        f5 = 0.0f;
                    } else {
                        float f14 = -dpUnit3;
                        rectF3.offset(f14, 0.0f);
                        rectF3.right += dpUnit3;
                        Matrix matrix = re.a;
                        path2.reset();
                        float fWidth = rectF3.width();
                        float fHeight = rectF3.height() / 2.0f;
                        codeEditor = codeEditor2;
                        f4 = rowHeight;
                        float fSqrt = (float) Math.sqrt(2.0d);
                        float f15 = fSqrt * fHeight;
                        float fMax2 = Math.max(fHeight + f15, fWidth);
                        re.b(path2, fHeight, fHeight, fHeight, 90.0f, 180.0f);
                        float f16 = fMax2 - f15;
                        re.b(path2, f16, fHeight, fHeight, -90.0f, 45.0f);
                        float f17 = fHeight / 5.0f;
                        re.b(path2, fMax2 - (fSqrt * f17), fHeight, f17, -45.0f, 90.0f);
                        re.b(path2, f16, fHeight, fHeight, 45.0f, 45.0f);
                        path = path2;
                        path.close();
                        Matrix matrix2 = re.a;
                        matrix2.reset();
                        matrix2.postTranslate(rectF3.left, rectF3.top);
                        path.transform(matrix2);
                        f5 = f14 / 2.0f;
                    }
                    cskVar.setColor(codeEditor.getColorScheme().b.get(16));
                    canvas.drawPath(path, cskVar);
                    f6 = f4;
                }
                float f18 = ((rectF3.left + rectF3.right) / 2.0f) + f5;
                cskVar.setColor(codeEditor.getColorScheme().b.get(17));
                cskVar.setTextAlign(Paint.Align.CENTER);
                canvas.drawText(strI, f18, f6, cskVar);
                cskVar.setTextAlign(Paint.Align.LEFT);
                cskVar.setTextSize(textSize);
                this.t = fontMetricsInt;
            } else {
                f3 = fMax;
                iArr = iArr2;
                codeEditor = codeEditor2;
            }
            rectF3.right = codeEditor.getWidth();
            rectF3.left = codeEditor.getWidth() - (codeEditor.getDpUnit() * 10.0f);
            rectF3.top = offsetY;
            rectF3.bottom = offsetY + f3;
            rectF.set(rectF3);
            Drawable drawable4 = this.w;
            if (drawable4 != null) {
                drawable4.setState(codeEditor.getEventHandler().q ? iArr3 : iArr);
                this.w.setBounds((int) rectF3.left, (int) rectF3.top, (int) rectF3.right, (int) rectF3.bottom);
                this.w.draw(canvas);
            } else {
                ar(canvas, codeEditor.getColorScheme().b.get(codeEditor.getEventHandler().q ? 12 : 11), rectF3);
            }
            canvas.restore();
        }
    }

    public final float ba(Canvas canvas, int i, float f, float f2, dln dlnVar, boolean z) {
        this.ag = be(i);
        int i2 = be(i).b;
        dln dlnVar2 = (dlnVar == null || dlnVar.n() <= 0) ? avf.a : dlnVar;
        drd drdVar = new drd();
        this.r.getInlayHints();
        List list = Collections.EMPTY_LIST;
        cba cbaVarAc = this.r.getRenderContext().a.ac(i);
        ek ekVar = (cbaVarAc == null || cbaVarAc.c < this.ab) ? null : cbaVarAc.b;
        drdVar.ac(this.ag, 0, i2, dlnVar2.l(i), list, bf(i), this.d,
                (ekVar == null || ekVar.c <= this.ag.b) ? null : ekVar, ap());
        am(drdVar, i);
        if (canvas != null) {
            canvas.save();
            this.r.getRowHeight();
            canvas.translate(f, 0 + f2);
            if (z) {
                float f3 = -f;
                float fMax = Math.max(0.0f, f3);
                drdVar.s(canvas, fMax, Math.max(fMax, f3 + this.r.getWidth()));
            } else {
                drdVar.s(canvas, 0.0f, Float.MAX_VALUE);
            }
            canvas.restore();
        }
        if (canvas != null) {
            return 0.0f;
        }
        cbr cbrVar = new cbr(drdVar, new dqz());
        drdVar.aa(cbrVar, true);
        return cbrVar.a;
    }

    /* JADX WARN: Found duplicated region for block: B:104:0x03a0 */
    /* JADX WARN: Found duplicated region for block: B:123:0x0477 */
    /* JADX WARN: Found duplicated region for block: B:173:0x05dd */
    /* JADX WARN: Found duplicated region for block: B:229:0x0731 */
    /* JADX WARN: Found duplicated region for block: B:235:0x0740 */
    /* JADX WARN: Found duplicated region for block: B:238:0x0749 */
    /* JADX WARN: Found duplicated region for block: B:240:0x074f */
    /* JADX WARN: Found duplicated region for block: B:245:0x075e A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:246:0x0760 */
    /* JADX WARN: Found duplicated region for block: B:249:0x0765 */
    /* JADX WARN: Found duplicated region for block: B:257:0x0781 */
    /* JADX WARN: Found duplicated region for block: B:258:0x0786 */
    /* JADX WARN: Found duplicated region for block: B:261:0x078c */
    /* JADX WARN: Found duplicated region for block: B:262:0x078e */
    /* JADX WARN: Found duplicated region for block: B:268:0x07ae */
    /* JADX WARN: Found duplicated region for block: B:275:0x07c7 */
    /* JADX WARN: Found duplicated region for block: B:277:0x0806 */
    /* JADX WARN: Found duplicated region for block: B:283:0x083c */
    /* JADX WARN: Found duplicated region for block: B:286:0x085e */
    /* JADX WARN: Found duplicated region for block: B:290:0x0871 */
    /* JADX WARN: Found duplicated region for block: B:296:0x0884 */
    /*
     * JADX WARN: Found duplicated region for block: B:399:0x0c02 A[PHI: r5
     * 0x0c02: PHI (r5v15 boolean) = (r5v14 boolean), (r5v16 boolean), (r5v16
     * boolean) binds: [B:376:0x0b9b, B:389:0x0bd3, B:393:0x0be3] A[DONT_GENERATE,
     * DONT_INLINE]]
     */
    public final void bb(Canvas canvas) {
        Canvas canvas2;
        float f;
        chs chsVar;
        float f2;
        float f3;
        float f4;
        int i;
        int i2;
        chr chrVar;
        asn asnVar;
        char c;
        ek ekVar;
        float f5;
        int i3;
        asn asnVar2;
        boolean z;
        boolean zDraw;
        boolean z2;
        boolean z3;
        dfo dfoVar;
        RectF rectF;
        float rowHeight;
        float f6;
        int i4;
        dfo dfoVar2;
        int i5;
        CodeEditor codeEditor;
        int i6;
        boolean z4;
        ArrayList arrayList;
        int i7;
        int i8;
        int currentCursorBlock;
        int offsetY;
        float rowHeight2;
        cjn cjnVar;
        cjn cjnVar2;
        float f7;
        int i9;
        int i10;
        asn asnVar3 = this;
        asnVar3.af.b.o(asnVar3.r.getFirstVisibleLine(), 0);
        arq colorScheme = asnVar3.r.getColorScheme();
        int i11 = colorScheme.b.get(4);
        Rect rect = asnVar3.f;
        csk cskVar = asnVar3.d;
        if (i11 != 0) {
            cskVar.setColor(i11);
            canvas.drawRect(rect, cskVar);
        }
        float fEa = asnVar3.r.ea();
        asnVar3.bi();
        float fEb = asnVar3.r.eb() + (-asnVar3.r.getOffsetX());
        float f8 = fEa + 0.0f;
        int dividerMarginRight = (int) (asnVar3.r.getDividerMarginRight() + asnVar3.r.getDividerMarginLeft()
                + asnVar3.r.getDividerWidth() + f8);
        CodeEditor codeEditor2 = asnVar3.r;
        if (codeEditor2.af) {
            int i12 = asnVar3.ae;
            if (i12 == 0) {
                asnVar3.ae = dividerMarginRight;
            } else if (i12 != dividerMarginRight && !codeEditor2.getEventHandler().k) {
                asnVar3.ae = dividerMarginRight;
                CodeEditor codeEditor3 = asnVar3.r;
                Objects.requireNonNull(codeEditor3);
                codeEditor3.ei(new dh(codeEditor3, 9));
                asnVar3.r.dh(false);
            } else if (asnVar3.aj) {
                asnVar3.r.dh(true);
                CodeEditor codeEditor4 = asnVar3.r;
                Objects.requireNonNull(codeEditor4);
                codeEditor4.ei(new dh(codeEditor4, 9));
            }
        } else {
            asnVar3.ae = 0;
            if (asnVar3.aj) {
                codeEditor2.dh(true);
            }
        }
        asnVar3.aj = false;
        int firstVisibleLine = asnVar3.r.getFirstVisibleLine();
        int lastVisibleLine = asnVar3.r.getLastVisibleLine();
        asnVar3.p.clear();
        asnVar3.q.clear();
        aff affVar = asnVar3.ah;
        int iMin = Math.min(asnVar3.ah.a.size() - 1, lastVisibleLine + 5);
        affVar.ae(false);
        for (int iMax = Math.max(0, firstVisibleLine - 5); iMax <= iMin; iMax++) {
            try {
                afo afoVar = (afo) affVar.a.get(iMax);
                anu anuVarC = affVar.h.c(iMax, afoVar);
                asnVar3.p.put(iMax, afoVar);
                asnVar3.q.put(iMax, anuVarC);
            } catch (Throwable th) {
                affVar.ap(false);
                throw th;
            }
        }
        affVar.ap(false);
        asnVar3.an(asnVar3.r.getFirstVisibleLine(), asnVar3.r.getLastVisibleLine(), asnVar3.ab, true);
        CodeEditor codeEditor5 = asnVar3.r;
        if (!codeEditor5.af) {
            codeEditor5.getProps().getClass();
        }
        if (asnVar3.af.h()) {
            dfo insertHandleDescriptor = asnVar3.r.getInsertHandleDescriptor();
            insertHandleDescriptor.a.setEmpty();
            insertHandleDescriptor.b = 0;
        } else {
            dfo leftHandleDescriptor = asnVar3.r.getLeftHandleDescriptor();
            leftHandleDescriptor.a.setEmpty();
            leftHandleDescriptor.b = 0;
            dfo rightHandleDescriptor = asnVar3.r.getRightHandleDescriptor();
            rightHandleDescriptor.a.setEmpty();
            rightHandleDescriptor.b = 0;
        }
        CodeEditor codeEditor6 = asnVar3.r;
        boolean z5 = codeEditor6.aq && (codeEditor6.af || !codeEditor6.ay);
        ek ekVar2 = asnVar3.l;
        ekVar2.c = 0;
        chs chsVar2 = asnVar3.m;
        chsVar2.b = 0;
        ArrayList<asm> arrayList2 = new ArrayList(3);
        CodeEditor codeEditor7 = asnVar3.r;
        chr chrVar2 = (codeEditor7.ba && codeEditor7.af) ? new chr(-1) : null;
        canvas.save();
        canvas.clipRect(0.0f, 0.0f, asnVar3.r.getWidth(), asnVar3.r.getHeight());
        chr chrVar3 = chrVar2;
        asnVar3.ay(canvas, fEb, ekVar2, arrayList2, chsVar2, chrVar3);
        CodeEditor codeEditor8 = asnVar3.r;
        if (codeEditor8.h.c.e() || !codeEditor8.getProps().p || codeEditor8.getCursor().h()
                || (cjnVar = (cjn) codeEditor8.f.f) == null) {
            canvas2 = canvas;
            f = fEb;
            chsVar = chsVar2;
            f2 = fEa;
            f3 = 0.0f;
            f4 = f8;
            i = 1;
            i2 = 3;
            chrVar = chrVar3;
        } else {
            int i13 = cjnVar.b;
            int i14 = codeEditor8.getColorScheme().b.get(39);
            i = 1;
            int i15 = codeEditor8.getColorScheme().b.get(41);
            f3 = 0.0f;
            int i16 = codeEditor8.getColorScheme().b.get(40);
            int i17 = codeEditor8.getColorScheme().b.get(75);
            float highlightedDelimiterBorderWidth = codeEditor8.getHighlightedDelimiterBorderWidth();
            int i18 = cjnVar.a;
            if (i18 >= 0) {
                int i19 = i18 + 1;
                int i20 = asnVar3.ah.d;
                if (i19 > i20) {
                    f = fEb;
                } else if (i13 < 0 || i13 + 1 > i20) {
                    canvas2 = canvas;
                    chsVar = chsVar2;
                    chrVar = chrVar3;
                    f2 = fEa;
                    f = fEb;
                    f4 = f8;
                    i2 = 3;
                } else {
                    int i21 = i18 + 1;
                    boolean z6 = i21 == i13;
                    if (i14 == 0 && i16 == 0) {
                        chsVar = chsVar2;
                        i10 = i15;
                        chrVar = chrVar3;
                        f2 = fEa;
                        cjnVar2 = cjnVar;
                        f7 = fEb;
                        i9 = i13;
                        f4 = f8;
                        i2 = 3;
                    } else {
                        if (z6) {
                            chsVar = chsVar2;
                            chrVar = chrVar3;
                            f2 = fEa;
                            cjnVar2 = cjnVar;
                            f7 = fEb;
                            i9 = i13;
                            f4 = f8;
                            i2 = 3;
                            asnVar3.bl(canvas, f7, i18, i13 + 1, i14, i15, i16);
                        } else {
                            chsVar = chsVar2;
                            chrVar = chrVar3;
                            f2 = fEa;
                            cjnVar2 = cjnVar;
                            f7 = fEb;
                            i9 = i13;
                            f4 = f8;
                            i2 = 3;
                            asnVar3.bl(canvas, f7, i18, i21, i14, i15, i16);
                            int i22 = cjnVar2.b;
                            bl(canvas, f7, i22, i22 + 1, i14, i15, i16);
                        }
                        i10 = 0;
                    }
                    if (i10 == 0 && (i17 == 0 || highlightedDelimiterBorderWidth <= 0.0f)) {
                        asnVar3 = this;
                        canvas2 = canvas;
                    } else if (z6) {
                        asnVar3 = this;
                        canvas2 = canvas;
                        asnVar3.bk(canvas2, f7, cjnVar2.a, i9 + 1, i10, highlightedDelimiterBorderWidth, i17);
                    } else {
                        int i23 = cjnVar2.a;
                        asnVar3 = this;
                        canvas2 = canvas;
                        asnVar3.bk(canvas2, f7, i23, i23 + 1, i10, highlightedDelimiterBorderWidth, i17);
                        int i24 = cjnVar2.b;
                        asnVar3.bk(canvas2, f7, i24, i24 + 1, i10, highlightedDelimiterBorderWidth, i17);
                    }
                    f = f7;
                }
            } else {
                f = fEb;
            }
            canvas2 = canvas;
            chsVar = chsVar2;
            chrVar = chrVar3;
            f2 = fEa;
            f4 = f8;
            i2 = 3;
        }
        CodeEditor codeEditor9 = asnVar3.r;
        codeEditor9.getDiagnostics();
        codeEditor9.getDiagnosticIndicatorStyle();
        asnVar3.s.clear();
        canvas2.restore();
        float f9 = -asnVar3.r.getOffsetX();
        int i25 = asnVar3.af.h() ? -1 : asnVar3.af.c.b;
        char c2 = 2;
        if (z5) {
            asnVar3.au(canvas2, f9, asnVar3.r.getDividerMarginLeft() + f4, colorScheme.b.get(i2));
            int i26 = asnVar3.r.getColorScheme().b.get(2);
            int i27 = asnVar3.r.getColorScheme().b.get(9);
            if (((cfg) asnVar3.r.getCursorAnimator()).m()) {
                CodeEditor codeEditor10 = asnVar3.r;
                if (codeEditor10.au && codeEditor10.dw()) {
                    c = ' ';
                    asnVar3.g.bottom = ((Float) ((cfg) asnVar3.r.getCursorAnimator()).e.getAnimatedValue()).floatValue()
                            - asnVar3.r.getOffsetY();
                    RectF rectF2 = asnVar3.g;
                    rectF2.top = rectF2.bottom
                            - ((Float) ((cfg) asnVar3.r.getCursorAnimator()).f.getAnimatedValue()).floatValue();
                    RectF rectF3 = asnVar3.g;
                    rectF3.left = f3;
                    rectF3.right = (int) (f - asnVar3.r.getDividerMarginRight());
                    asnVar3.ar(canvas2, i27, asnVar3.g);
                } else {
                    c = ' ';
                }
            } else {
                c = ' ';
            }
            canvas2.save();
            canvas2.clipRect(0.0f, 0.0f, asnVar3.r.getWidth(), asnVar3.r.getHeight());
            for (int i28 = 0; i28 < chsVar.b; i28++) {
                asnVar3.aw(canvas2, i27, chsVar.d(i28), (int) (f - asnVar3.r.getDividerMarginRight()));
            }
            asnVar3.r.getDividerMarginRight();
            CodeEditor codeEditor11 = asnVar3.r;
            int lastVisibleLine2 = codeEditor11.getLastVisibleLine();
            for (int firstVisibleLine2 = codeEditor11
                    .getFirstVisibleLine(); firstVisibleLine2 <= lastVisibleLine2; firstVisibleLine2++) {
                codeEditor11.getStyles();
            }
            float f10 = f9 + f2;
            asnVar3.bi();
            canvas2.restore();
            asnVar3.as(canvas2, asnVar3.r.getDividerMarginLeft() + f10 + 0.0f, colorScheme.b.get(i));
            canvas2.save();
            canvas2.clipRect(0.0f, 0.0f, asnVar3.r.getWidth(), asnVar3.r.getHeight());
            if (chrVar != null && chrVar.a != -1) {
                int iDt = asnVar3.r.dt(0);
                if (ekVar2.c == 0) {
                    int iDt2 = asnVar3.r.dt(0);
                    asnVar3.r.getRowHeight();
                    Paint.FontMetricsInt fontMetricsInt = asnVar3.ac;
                    int i29 = fontMetricsInt.descent;
                    offsetY = fontMetricsInt.ascent;
                    rowHeight2 = (iDt2 / 2.0f) - ((i29 - offsetY) / 2.0f);
                } else if ((asnVar3.r.getRowHeight() * ((int) (ekVar2.k(0) & 4294967295L)))
                        - asnVar3.r.getOffsetY() > iDt) {
                    int iDt22 = asnVar3.r.dt(0);
                    asnVar3.r.getRowHeight();
                    Paint.FontMetricsInt fontMetricsInt2 = asnVar3.ac;
                    int i292 = fontMetricsInt2.descent;
                    offsetY = fontMetricsInt2.ascent;
                    rowHeight2 = (iDt22 / 2.0f) - ((i292 - offsetY) / 2.0f);
                } else {
                    int iK = ((int) (ekVar2.k(0) & 4294967295L)) - 1;
                    Paint.FontMetricsInt fontMetricsInt3 = asnVar3.ac;
                    int i30 = fontMetricsInt3.descent;
                    int i31 = fontMetricsInt3.ascent;
                    rowHeight2 = ((((asnVar3.r.getRowHeight() * iK) + asnVar3.r.dt(iK)) / 2.0f) - ((i30 - i31) / 2.0f))
                            - i31;
                    offsetY = asnVar3.r.getOffsetY();
                }
                float f11 = rowHeight2 - offsetY;
                asnVar3.e.setTextAlign(asnVar3.r.getLineNumberAlign());
                asnVar3.e.setColor(chrVar.a == i25 ? colorScheme.b.get(45) : i26);
                String string = Integer.toString(chrVar.a + 1);
                int i32 = asl.a[asnVar3.r.getLineNumberAlign().ordinal()];
                if (i32 == 1) {
                    canvas2.drawText(string, f9, f11, asnVar3.e);
                } else if (i32 == 2) {
                    canvas2.drawText(string, f10, f11, asnVar3.e);
                } else if (i32 == 3) {
                    canvas2.drawText(string, ((asnVar3.r.getDividerMarginLeft() + f2) / 2.0f) + f9, f11, asnVar3.e);
                }
            }
            int i33 = 0;
            while (i33 < ekVar2.c) {
                long jK = ekVar2.k(i33);
                int i34 = (int) (jK >> c);
                int i35 = (int) (jK & 4294967295L);
                char c3 = c2;
                float f12 = f2;
                asnVar3.at(canvas2, i34, i35, f9, f12, i34 == i25 ? colorScheme.b.get(45) : i26);
                f2 = f12;
                i33++;
                c2 = c3;
            }
            asnVar = asnVar3;
            canvas2.restore();
        } else {
            asnVar = asnVar3;
            c = ' ';
        }
        if (asnVar.r.ar) {
            canvas2.save();
            canvas2.clipRect(0.0f, 0.0f, asnVar.r.getWidth(), asnVar.r.getHeight());
            CodeEditor codeEditor12 = asnVar.r;
            if (codeEditor12.af) {
                csk cskVar2 = asnVar.d;
                if (codeEditor12.getProps().n) {
                    ArrayList arrayList3 = codeEditor12.getStyles() == null ? null : codeEditor12.getStyles().b;
                    if (arrayList3 == null || arrayList3.isEmpty()
                            || (currentCursorBlock = codeEditor12.getCurrentCursorBlock()) < 0
                            || currentCursorBlock >= arrayList3.size()) {
                        ekVar = ekVar2;
                    } else {
                        aah aahVar = (aah) arrayList3.get(currentCursorBlock);
                        btr layout = codeEditor12.getLayout();
                        try {
                            float rowHeight3 = (layout.r(aahVar.c, aahVar.d)[0] - codeEditor12.getRowHeight())
                                    - codeEditor12.getOffsetY();
                            float offsetY2 = layout.r(aahVar.e, aahVar.f)[0] - codeEditor12.getOffsetY();
                            float fEa2 = codeEditor12.ea();
                            float dividerMarginLeft = (((codeEditor12.getDividerMarginLeft() + fEa2) + fEa2) / 2.0f)
                                    - codeEditor12.getOffsetX();
                            cskVar2.setColor(codeEditor12.getColorScheme().b.get(38));
                            cskVar2.setStrokeWidth(codeEditor12.getDpUnit() * codeEditor12.getBlockLineWidth());
                            ekVar = ekVar2;
                            Canvas canvas3 = canvas2;
                            try {
                                canvas3.drawLine(dividerMarginLeft, rowHeight3, dividerMarginLeft, offsetY2, asnVar.d);
                                canvas2 = canvas3;
                            } catch (IndexOutOfBoundsException unused) {
                                canvas2 = canvas3;
                            }
                        } catch (IndexOutOfBoundsException unused2) {
                            ekVar = ekVar2;
                        }
                    }
                } else {
                    ekVar = ekVar2;
                }
            } else {
                ekVar = ekVar2;
                RectF rectF4 = asnVar.g;
                dnv styles = codeEditor12.getStyles();
                ArrayList arrayList4 = styles == null ? null : styles.b;
                if (arrayList4 != null && !arrayList4.isEmpty()) {
                    int firstVisibleRow = codeEditor12.getFirstVisibleRow();
                    int lastVisibleRow = codeEditor12.getLastVisibleRow();
                    int i36 = styles.c;
                    int iCx = CodeEditor.cx(firstVisibleRow, arrayList4);
                    if (iCx == -1) {
                        iCx = 0;
                    }
                    int currentCursorBlock2 = codeEditor12.getCurrentCursorBlock();
                    f5 = f;
                    int i37 = 0;
                    boolean z7 = false;
                    while (true) {
                        if (iCx < arrayList4.size()) {
                            aah aahVar2 = (aah) arrayList4.get(iCx);
                            if (aahVar2 == null) {
                                arrayList = arrayList4;
                                i7 = firstVisibleRow;
                                i8 = lastVisibleRow;
                                i3 = i25;
                            } else {
                                arrayList = arrayList4;
                                int i38 = aahVar2.c;
                                i3 = i25;
                                int i39 = aahVar2.e;
                                if (i39 <= firstVisibleRow || i38 >= lastVisibleRow) {
                                    i7 = firstVisibleRow;
                                    i8 = lastVisibleRow;
                                    if (!z7) {
                                        continue;
                                    } else if (i37 >= i36) {
                                        break;
                                    } else {
                                        i37++;
                                    }
                                } else {
                                    try {
                                        i7 = firstVisibleRow;
                                    } catch (IndexOutOfBoundsException unused3) {
                                        i7 = firstVisibleRow;
                                    }
                                    try {
                                        i8 = lastVisibleRow;
                                        try {
                                            float fMin = Math.min(
                                                    asnVar.ao(aahVar2.e).u(Math.min(aahVar2.f, asnVar.be(i39).b)),
                                                    asnVar.ao(aahVar2.c).u(Math.min(aahVar2.d, asnVar.be(aahVar2.c).b)))
                                                    + f5;
                                            rectF4.top = Math.max(0,
                                                    codeEditor12.dt(aahVar2.c) - codeEditor12.getOffsetY());
                                            rectF4.bottom = Math.min(codeEditor12.getHeight(),
                                                    (codeEditor12.getRowHeight() * aahVar2.e)
                                                            - codeEditor12.getOffsetY());
                                            rectF4.left = fMin
                                                    - ((codeEditor12.getDpUnit() * codeEditor12.getBlockLineWidth())
                                                            / 2.0f);
                                            rectF4.right = ((codeEditor12.getDpUnit()
                                                    * codeEditor12.getBlockLineWidth()) / 2.0f) + fMin;
                                            asnVar.ar(canvas2, codeEditor12.getColorScheme().b
                                                    .get(iCx == currentCursorBlock2 ? 15 : 14), rectF4);
                                        } catch (IndexOutOfBoundsException unused4) {
                                        }
                                    } catch (IndexOutOfBoundsException unused5) {
                                        i8 = lastVisibleRow;
                                    }
                                    z7 = true;
                                }
                            }
                            iCx++;
                            arrayList4 = arrayList;
                            i25 = i3;
                            firstVisibleRow = i7;
                            lastVisibleRow = i8;
                        }
                    }
                    canvas2.restore();
                }
                i3 = i25;
                canvas2.restore();
            }
            f5 = f;
            i3 = i25;
            canvas2.restore();
        } else {
            ekVar = ekVar2;
            f5 = f;
            i3 = i25;
        }
        if (((cfg) asnVar.r.getCursorAnimator()).m()) {
            RectF rectF5 = asnVar.g;
            CodeEditor codeEditor13 = asnVar.r;
            if (codeEditor13.dw()) {
                float fFloatValue = ((Float) ((cfg) codeEditor13.getCursorAnimator()).d.getAnimatedValue()).floatValue()
                        - codeEditor13.getOffsetY();
                rectF5.bottom = fFloatValue;
                codeEditor13.getProps().getClass();
                rectF5.top = fFloatValue - codeEditor13.getRowHeight();
                float fFloatValue2 = ((Float) ((cfg) codeEditor13.getCursorAnimator()).c.getAnimatedValue())
                        .floatValue() - codeEditor13.getOffsetX();
                rectF5.left = fFloatValue2 - (codeEditor13.getInsertSelectionWidth() / 2.0f);
                rectF5.right = (codeEditor13.getInsertSelectionWidth() / 2.0f) + fFloatValue2;
                asnVar.ar(canvas2, codeEditor13.getColorScheme().b.get(7), rectF5);
                ud udVar = asnVar.af.c;
                long jBd = asnVar.bd(udVar.b, udVar.c);
                if (((int) (jBd >> c)) == 1) {
                    asn asnVar4 = asnVar;
                    asnVar4.aq(canvas, fFloatValue2, rectF5.top, rectF5.height(), ((int) (jBd & 4294967295L)) == 1);
                    asnVar = asnVar4;
                }
                if (!codeEditor13.getEventHandler().be() || codeEditor13.dy()) {
                    canvas2 = canvas;
                } else {
                    dfp handleStyle = codeEditor13.getHandleStyle();
                    float f13 = rectF5.bottom;
                    codeEditor13.getRowHeight();
                    ((bjz) handleStyle).g(canvas, 0, fFloatValue2, f13, codeEditor13.getColorScheme().b.get(8),
                            codeEditor13.getInsertHandleDescriptor());
                    canvas2 = canvas;
                }
            }
        } else {
            for (asm asmVar : arrayList2) {
                dfo dfoVar3 = asm.a;
                asn asnVar5 = asmVar.h;
                int i40 = asmVar.d;
                if (i40 != -1) {
                    CodeEditor codeEditor14 = asnVar5.r;
                    if (!codeEditor14.h.d && codeEditor14.isFocused()) {
                        if (i40 == 0 || asnVar5.r.dw()) {
                            dfoVar = asmVar.e;
                            if (dfoVar == null) {
                                dfoVar = dfoVar3;
                            }
                            rectF = dfoVar.a;
                            if (!rectF.isEmpty()) {
                                codeEditor = asnVar5.r;
                                if (!codeEditor.bc) {
                                    i6 = codeEditor.getEventHandler().e;
                                    z4 = asmVar.g;
                                    if (i6 == ((z4 || i40 != 1) ? (z4 || i40 != 2) ? i40 : 1 : 2) && i40 != -1
                                            && asnVar5.r.getEventHandler().f) {
                                        asmVar.b = ((dfoVar.b != 0 ? rectF.width() : 0.0f) * (dfoVar.b == 1 ? 1 : -1))
                                                + asnVar5.r.getEventHandler().g;
                                        asmVar.c = asnVar5.r.getEventHandler().h - ((rectF.height() * 2.0f) / 3.0f);
                                    }
                                }
                            }
                            if (i40 != 1 || i40 == 2) {
                                asnVar5.r.getProps().getClass();
                            }
                            if (!asmVar.i() || i40 == -1) {
                                float f14 = asmVar.c;
                                asnVar5.r.getProps().getClass();
                                rowHeight = f14 - asnVar5.r.getRowHeight();
                                f6 = asmVar.c;
                                asnVar5.d.setColor(asnVar5.r.getColorScheme().b.get(7));
                                asnVar5.d.setStrokeWidth(asnVar5.r.getInsertSelectionWidth());
                                asnVar5.d.setStyle(Paint.Style.STROKE);
                                if (!asnVar5.r.be && i40 != 1 && i40 != 2) {
                                    float f15 = f6 - rowHeight;
                                    float f16 = f15 / 8.0f;
                                    i4 = i40;
                                    asnVar5.d.setPathEffect(new DashPathEffect(new float[] { f16, f16 }, f15 / 16.0f));
                                    asnVar5.d.setStrokeWidth(asnVar5.r.getInsertSelectionWidth() * 1.5f);
                                }
                                dfo dfoVar4 = dfoVar;
                                float f17 = asmVar.b;
                                dfoVar2 = dfoVar4;
                                canvas.drawLine(f17, rowHeight, f17, f6, asnVar5.d);
                                asnVar5.d.setStyle(Paint.Style.FILL);
                                asnVar5.d.setPathEffect(null);
                                if (asmVar.i() && asmVar.f) {
                                    asmVar.h.aq(canvas, asmVar.b, rowHeight, f6 - rowHeight, asmVar.g);
                                }
                            } else {
                                i4 = i40;
                                dfoVar2 = dfoVar;
                            }
                            if (i4 == 0) {
                                CodeEditor codeEditor15 = asnVar5.r;
                                i5 = (codeEditor15.be && codeEditor15.getEventHandler().be()) ? i4 : -1;
                            }
                            if (i5 != -1 || asnVar5.r.dy()) {
                                canvas2 = canvas;
                                dfo dfoVar5 = dfoVar2;
                                dfoVar5.a.setEmpty();
                                dfoVar5.b = 0;
                            } else {
                                dfp handleStyle2 = asnVar5.r.getHandleStyle();
                                float f18 = asmVar.b;
                                float f19 = asmVar.c;
                                asnVar5.r.getRowHeight();
                                dfo dfoVar6 = dfoVar2;
                                ((bjz) handleStyle2).g(canvas, i5, f18, f19, asnVar5.r.getColorScheme().b.get(8),
                                        dfoVar6);
                                canvas2 = canvas;
                                if (dfoVar6 == dfoVar3) {
                                    dfoVar6.a.setEmpty();
                                    dfoVar6.b = 0;
                                }
                            }
                        }
                    }
                } else {
                    if (i40 == 0) {
                    }
                    dfoVar = asmVar.e;
                    if (dfoVar == null) {
                        dfoVar = dfoVar3;
                    }
                    rectF = dfoVar.a;
                    if (!rectF.isEmpty()) {
                        codeEditor = asnVar5.r;
                        if (!codeEditor.bc) {
                            i6 = codeEditor.getEventHandler().e;
                            z4 = asmVar.g;
                            if (i6 == ((z4 || i40 != 1) ? (z4 || i40 != 2) ? i40 : 1 : 2)) {
                                asmVar.b = ((dfoVar.b != 0 ? rectF.width() : 0.0f) * (dfoVar.b == 1 ? 1 : -1))
                                        + asnVar5.r.getEventHandler().g;
                                asmVar.c = asnVar5.r.getEventHandler().h - ((rectF.height() * 2.0f) / 3.0f);
                            }
                        }
                    }
                    if (i40 != 1) {
                        asnVar5.r.getProps().getClass();
                    } else {
                        asnVar5.r.getProps().getClass();
                    }
                    if (asmVar.i()) {
                        float f142 = asmVar.c;
                        asnVar5.r.getProps().getClass();
                        rowHeight = f142 - asnVar5.r.getRowHeight();
                        f6 = asmVar.c;
                        asnVar5.d.setColor(asnVar5.r.getColorScheme().b.get(7));
                        asnVar5.d.setStrokeWidth(asnVar5.r.getInsertSelectionWidth());
                        asnVar5.d.setStyle(Paint.Style.STROKE);
                        i4 = !asnVar5.r.be ? i40 : i40;
                        dfo dfoVar42 = dfoVar;
                        float f172 = asmVar.b;
                        dfoVar2 = dfoVar42;
                        canvas.drawLine(f172, rowHeight, f172, f6, asnVar5.d);
                        asnVar5.d.setStyle(Paint.Style.FILL);
                        asnVar5.d.setPathEffect(null);
                        if (asmVar.i()) {
                            asmVar.h.aq(canvas, asmVar.b, rowHeight, f6 - rowHeight, asmVar.g);
                        }
                    } else {
                        float f1422 = asmVar.c;
                        asnVar5.r.getProps().getClass();
                        rowHeight = f1422 - asnVar5.r.getRowHeight();
                        f6 = asmVar.c;
                        asnVar5.d.setColor(asnVar5.r.getColorScheme().b.get(7));
                        asnVar5.d.setStrokeWidth(asnVar5.r.getInsertSelectionWidth());
                        asnVar5.d.setStyle(Paint.Style.STROKE);
                        if (!asnVar5.r.be) {
                        }
                        dfo dfoVar422 = dfoVar;
                        float f1722 = asmVar.b;
                        dfoVar2 = dfoVar422;
                        canvas.drawLine(f1722, rowHeight, f1722, f6, asnVar5.d);
                        asnVar5.d.setStyle(Paint.Style.FILL);
                        asnVar5.d.setPathEffect(null);
                        if (asmVar.i()) {
                            asmVar.h.aq(canvas, asmVar.b, rowHeight, f6 - rowHeight, asmVar.g);
                        }
                    }
                    if (i4 == 0) {
                        CodeEditor codeEditor152 = asnVar5.r;
                        if (codeEditor152.be) {
                        }
                    }
                    if (i5 != -1) {
                    }
                    canvas2 = canvas;
                    dfo dfoVar52 = dfoVar2;
                    dfoVar52.a.setEmpty();
                    dfoVar52.b = 0;
                }
            }
        }
        CodeEditor codeEditor16 = asnVar.r;
        if (!codeEditor16.aq || z5) {
            asnVar2 = asnVar;
            z = true;
        } else {
            asnVar.au(canvas2, 0.0f, codeEditor16.getDividerMarginLeft() + f4, colorScheme.b.get(3));
            canvas2.save();
            canvas2.clipRect(0.0f, 0.0f, asnVar.r.getWidth(), asnVar.r.getHeight());
            int i41 = asnVar.r.getColorScheme().b.get(2);
            int i42 = asnVar.r.getColorScheme().b.get(9);
            if (((cfg) asnVar.r.getCursorAnimator()).m()) {
                CodeEditor codeEditor17 = asnVar.r;
                if (codeEditor17.au && codeEditor17.dw()) {
                    asnVar.g.bottom = ((Float) ((cfg) asnVar.r.getCursorAnimator()).e.getAnimatedValue()).floatValue()
                            - asnVar.r.getOffsetY();
                    RectF rectF6 = asnVar.g;
                    rectF6.top = rectF6.bottom
                            - ((Float) ((cfg) asnVar.r.getCursorAnimator()).f.getAnimatedValue()).floatValue();
                    RectF rectF7 = asnVar.g;
                    rectF7.left = 0.0f;
                    rectF7.right = (int) (f5 - asnVar.r.getDividerMarginRight());
                    asnVar.ar(canvas2, i42, asnVar.g);
                }
            }
            for (int i43 = 0; i43 < chsVar.b; i43++) {
                asnVar.aw(canvas2, i42, chsVar.d(i43),
                        (int) ((f5 - asnVar.r.getDividerMarginRight()) + asnVar.r.getOffsetX()));
            }
            asnVar.r.getDividerMarginRight();
            asnVar.r.getOffsetX();
            CodeEditor codeEditor18 = asnVar.r;
            int lastVisibleLine3 = codeEditor18.getLastVisibleLine();
            for (int firstVisibleLine3 = codeEditor18
                    .getFirstVisibleLine(); firstVisibleLine3 <= lastVisibleLine3; firstVisibleLine3++) {
                codeEditor18.getStyles();
            }
            asnVar.bi();
            canvas2.restore();
            z = true;
            asnVar.as(canvas2, asnVar.r.getDividerMarginLeft() + f4, colorScheme.b.get(1));
            canvas2.save();
            canvas2.clipRect(0.0f, 0.0f, asnVar.r.getWidth(), asnVar.r.getHeight());
            int i44 = 0;
            while (i44 < ekVar.c) {
                long jK2 = ekVar.k(i44);
                int i45 = (int) (jK2 >> c);
                int i46 = (int) (jK2 & 4294967295L);
                int i47 = i3;
                int i48 = i45 == i47 ? colorScheme.b.get(45) : i41;
                asn asnVar6 = asnVar;
                asnVar6.at(canvas2, i45, i46, 0.0f, f2, i48);
                i44++;
                asnVar = asnVar6;
                i3 = i47;
            }
            asnVar2 = asnVar;
            canvas2.restore();
        }
        asnVar2.r.getColorScheme().b.get(2);
        az(canvas);
        CodeEditor codeEditor19 = asnVar2.r;
        EdgeEffect verticalEdgeEffect = codeEditor19.getVerticalEdgeEffect();
        EdgeEffect horizontalEdgeEffect = codeEditor19.getHorizontalEdgeEffect();
        if (verticalEdgeEffect.isFinished()) {
            zDraw = false;
        } else {
            boolean z8 = codeEditor19.getEventHandler().i;
            if (z8) {
                canvas2.save();
                canvas2.translate(-codeEditor19.getMeasuredWidth(), codeEditor19.getMeasuredHeight());
                canvas2.rotate(180.0f, codeEditor19.getMeasuredWidth(), 0.0f);
            }
            zDraw = verticalEdgeEffect.draw(canvas2);
            if (z8) {
                canvas2.restore();
            }
        }
        if (codeEditor19.af) {
            horizontalEdgeEffect.finish();
        }
        if (horizontalEdgeEffect.isFinished()) {
            z2 = zDraw;
        } else {
            canvas2.save();
            if (codeEditor19.getEventHandler().j) {
                canvas2.rotate(90.0f);
                canvas2.translate(0.0f, -codeEditor19.getMeasuredWidth());
            } else {
                canvas2.translate(0.0f, codeEditor19.getMeasuredHeight());
                canvas2.rotate(-90.0f);
            }
            z2 = (horizontalEdgeEffect.draw(canvas2) || zDraw) ? z : false;
            canvas2.restore();
        }
        OverScroller overScroller = codeEditor19.getScroller().b;
        if (overScroller.isOverScrolled()) {
            if (verticalEdgeEffect.isFinished()
                    && (overScroller.getCurrY() < 0 || overScroller.getCurrY() > codeEditor19.getScrollMaxY())) {
                codeEditor19.getEventHandler().i = overScroller.getCurrY() >= codeEditor19.getScrollMaxY() ? z : false;
                verticalEdgeEffect.onAbsorb((int) overScroller.getCurrVelocity());
                z2 = z;
            }
            if (!horizontalEdgeEffect.isFinished()
                    || (overScroller.getCurrX() >= 0 && overScroller.getCurrX() <= codeEditor19.getScrollMaxX())) {
                z3 = z2;
            } else {
                codeEditor19.getEventHandler().j = overScroller.getCurrX() >= codeEditor19.getScrollMaxX() ? z : false;
                horizontalEdgeEffect.onAbsorb((int) overScroller.getCurrVelocity());
                z3 = z;
            }
        } else {
            z3 = z2;
        }
        if (z3) {
            codeEditor19.postInvalidate();
        }
        asnVar2.p.clear();
        asnVar2.q.clear();
        asnVar2.r.dx();
    }

    public final void bc(Canvas canvas, drd drdVar, char[] cArr, int i, int i2, int i3, int i4, boolean z, float f,
            float f2, int i5, int i6) {
        float f3;
        char c;
        int tabWidth;
        int i7;
        char c2;
        char c3;
        int i8;
        int i9 = i;
        int i10 = i9 + i2;
        int iMax = Math.max(i9, Math.min(i10, i5));
        int iMax2 = Math.max(i9, Math.min(i10, i6));
        if (iMax < iMax2) {
            float f4 = this.d.a;
            CodeEditor codeEditor = this.r;
            float f5 = 2.0f;
            int i11 = 0;
            float rowHeightOfText = (codeEditor.getRowHeightOfText() / 2.0f) + codeEditor.du(0);
            float f6 = z ? f + f2 : f;
            while (iMax < iMax2) {
                char c4 = cArr[iMax];
                if (c4 == ' ' || c4 == '\t') {
                    f3 = f5;
                    c = ' ';
                    float fW = drdVar.w(iMax, z, i9, iMax, i3, i3 + i4);
                    f6 = z ? (f + f2) - fW : f + fW;
                } else {
                    f3 = f5;
                    c = ' ';
                }
                if (c4 == c) {
                    i7 = i11;
                    tabWidth = 1;
                } else if (c4 != '\t') {
                    tabWidth = i11;
                    i7 = tabWidth;
                } else if ((codeEditor.getNonPrintablePaintingFlags() & c) != 0) {
                    tabWidth = codeEditor.getTabWidth();
                    i7 = i11;
                } else {
                    tabWidth = i11;
                    i7 = 1;
                }
                for (int i12 = i11; i12 < tabWidth; i12++) {
                    float f7 = (i12 * f4) + f6;
                    float f8 = ((f7 + f4) + f7) / f3;
                    if (z) {
                        f8 -= f4;
                    }
                    rj rjVar = this.c;
                    float[] fArr = rjVar.b;
                    int length = fArr.length;
                    int i13 = rjVar.a;
                    if (length < (i13 + 1) * 2) {
                        float[] fArr2 = new float[fArr.length << 1];
                        System.arraycopy(fArr, 0, fArr2, 0, i13 * 2);
                        rjVar.b = fArr2;
                    }
                    float[] fArr3 = rjVar.b;
                    int i14 = rjVar.a;
                    int i15 = i14 * 2;
                    fArr3[i15] = f8 + rjVar.c;
                    fArr3[i15 + 1] = rjVar.d + rowHeightOfText;
                    rjVar.a = i14 + 1;
                }
                if (i7 != 0) {
                    float tabWidth2 = codeEditor.getTabWidth() * f4;
                    float f9 = 0.05f * tabWidth2;
                    float f10 = z ? -tabWidth2 : 0.0f;
                    c2 = c4;
                    c3 = '\t';
                    i8 = 0;
                    canvas.drawLine(f6 + f9 + f10, rowHeightOfText, ((tabWidth2 + f6) + f10) - f9, rowHeightOfText,
                            this.e);
                } else {
                    c2 = c4;
                    c3 = '\t';
                    i8 = 0;
                }
                if (c2 == ' ' || c2 == c3) {
                    float tabWidth3 = c2 == ' ' ? f4 : codeEditor.getTabWidth() * f4;
                    if (z) {
                        tabWidth3 = -tabWidth3;
                    }
                    f6 += tabWidth3;
                }
                iMax++;
                i9 = i;
                f5 = f3;
                i11 = i8;
            }
        }
    }

    public final long bd(int i, int i2) {
        anu anuVarBf = bf(i);
        int length = anuVarBf.a.length;
        if (length == 1) {
            return KotlinHelpers.al(0, anuVarBf.f(0) ? 1 : 0);
        }
        int i3 = 0;
        while (i3 < length) {
            int i4 = i3 + 1;
            if (i4 == length || (anuVarBf.d(i3) <= i2 && i2 < anuVarBf.e(i3))) {
                return KotlinHelpers.al(this.r.getProps().ah ? 1 : 0, anuVarBf.f(i3) ? 1 : 0);
            }
            i3 = i4;
        }
        return KotlinHelpers.al(0, 0);
    }

    public final afo be(int i) {
        if (!this.ai) {
            return this.ah.y(i);
        }
        afo afoVar = (afo) this.p.get(i);
        if (afoVar != null) {
            return afoVar;
        }
        afo afoVarY = this.ah.y(i);
        this.p.put(i, afoVarY);
        return afoVarY;
    }

    public final anu bf(int i) {
        if (!this.ai) {
            return this.ah.z(i);
        }
        anu anuVar = (anu) this.q.get(i);
        if (anuVar != null) {
            return anuVar;
        }
        anu anuVarZ = this.ah.z(i);
        this.q.put(i, anuVarZ);
        return anuVarZ;
    }

    public final float bg() {
        CodeEditor codeEditor = this.r;
        float rowHeightOfText = codeEditor.getRowHeightOfText();
        Objects.requireNonNull(codeEditor.getProps());
        float f = rowHeightOfText * 0.5f;
        Drawable drawable = codeEditor.getContext().getDrawable(me.hd.wauxv.R.drawable.line_break);
        if (drawable == null) {
            return 0.0f;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0 || f <= 0.0f) {
            return 0.0f;
        }
        return (intrinsicWidth / intrinsicHeight) * f;
    }

    public final int bh(int i) {
        CodeEditor codeEditor = this.r;
        codeEditor.getProps().getClass();
        return codeEditor.dt(i);
    }

    public final void bi() {
        this.r.getStyles();
    }

    public final void bj() {
        CodeEditor codeEditor = this.r;
        boolean z = codeEditor.bg;
        csk cskVar = this.d;
        cskVar.b = z;
        this.ad = this.i.getFontMetricsInt();
        this.ac = this.e.getFontMetricsInt();
        this.t = cskVar.getFontMetricsInt();
        codeEditor.getRenderContext().c();
        bn();
        codeEditor.dh(true);
        codeEditor.invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [me.hd.wauxv.obf.asg] */
    public final void bk(final Canvas canvas, final float f, int i, int i2, final int i3, final float f2,
            final int i4) {
        if (i3 != 0 || (f2 > 0.0f && i4 != 0)) {
            bm(canvas, f, i, i2, null, new dqx() { // from class: me.hd.wauxv.obf.asg
                @Override // me.hd.wauxv.obf.dqx
                public final boolean g(float f3, float f4) {
                    int i5;
                    asn asnVar = this.a;
                    RectF rectF = asnVar.g;
                    csk cskVar = asnVar.e;
                    CodeEditor codeEditor = asnVar.r;
                    float f5 = f;
                    if (f5 + f3 < 0.0f) {
                        return true;
                    }
                    codeEditor.getProps().getClass();
                    codeEditor.getRowHeight();
                    rectF.top = 0;
                    rectF.bottom = asnVar.bh(0);
                    rectF.left = f3;
                    rectF.right = f4;
                    int i6 = i3;
                    Canvas canvas2 = canvas;
                    if (i6 != 0) {
                        cskVar.setColor(i6);
                        if (codeEditor.getProps().r) {
                            canvas2.drawRoundRect(rectF, codeEditor.getRowHeight() * codeEditor.getProps().t,
                                    codeEditor.getRowHeight() * codeEditor.getProps().t, cskVar);
                        } else {
                            canvas2.drawRect(rectF, cskVar);
                        }
                    }
                    float f6 = f2;
                    if (f6 > 0.0f && (i5 = i4) != 0) {
                        cskVar.setStyle(Paint.Style.STROKE);
                        cskVar.setColor(i5);
                        cskVar.setStrokeWidth(f6);
                        if (codeEditor.getProps().r) {
                            canvas2.drawRoundRect(rectF, codeEditor.getRowHeight() * codeEditor.getProps().t,
                                    codeEditor.getRowHeight() * codeEditor.getProps().t, cskVar);
                        } else {
                            canvas2.drawRect(rectF, cskVar);
                        }
                        cskVar.setStyle(Paint.Style.FILL);
                    }
                    return f5 + f4 > ((float) codeEditor.getWidth());
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [me.hd.wauxv.obf.asj] */
    public final void bl(final Canvas canvas, float f, int i, int i2, final int i3, final int i4, final int i5) {
        csk cskVar = this.d;
        cskVar.setColor(i3);
        CodeEditor codeEditor = this.r;
        this.e.setStrokeWidth(codeEditor.getRowHeightOfText() * 0.1f);
        boolean z = codeEditor.getProps().q;
        cskVar.setStyle(z ? Paint.Style.FILL_AND_STROKE : Paint.Style.FILL);
        cskVar.setFakeBoldText(z);
        bm(canvas, f, i, i2, new dqy() { // from class: me.hd.wauxv.obf.asj
            @Override // me.hd.wauxv.obf.dqy
            public final void h(Canvas canvas2, char[] cArr, int i6, int i7, int i8, int i9, boolean z2, float f2,
                    float f3, dre dreVar, dle dleVar) {
                Canvas canvas3;
                asn asnVar = this.a;
                csk cskVar2 = asnVar.d;
                csk cskVar3 = asnVar.e;
                CodeEditor codeEditor2 = asnVar.r;
                RectF rectF = asnVar.g;
                if (dleVar == null) {
                    return;
                }
                int i10 = i4;
                Canvas canvas4 = canvas;
                if (i10 != 0) {
                    codeEditor2.getProps().getClass();
                    codeEditor2.getRowHeight();
                    rectF.top = 0;
                    rectF.bottom = asnVar.bh(0);
                    rectF.left = f2;
                    rectF.right = f2 + f3;
                    cskVar3.setColor(i10);
                    if (codeEditor2.getProps().r) {
                        canvas4.drawRoundRect(rectF, codeEditor2.getRowHeight() * codeEditor2.getProps().t,
                                codeEditor2.getRowHeight() * codeEditor2.getProps().t, cskVar3);
                    } else {
                        canvas4.drawRect(rectF, cskVar3);
                    }
                }
                long jD = dleVar.d();
                if (i3 != 0) {
                    cskVar2.setTextSkewX((549755813888L & jD) != 0 ? -0.2f : 0.0f);
                    cskVar2.setStrikeThruText((jD & 1099511627776L) != 0);
                    canvas3 = canvas4;
                    canvas3.drawTextRun(cArr, i6, i7, i8, i9, f2, dreVar.f, z2, asnVar.d);
                } else {
                    canvas3 = canvas4;
                }
                int i11 = i5;
                if (i11 != 0) {
                    cskVar3.setColor(i11);
                    float f4 = dreVar.d - (dreVar.e * 0.05f);
                    canvas3.drawLine(f2, f4, f2 + f3, f4, asnVar.e);
                }
            }
        }, null);
        cskVar.setStyle(Paint.Style.FILL);
        cskVar.setFakeBoldText(false);
        cskVar.setTextSkewX(0.0f);
        cskVar.setStrikeThruText(false);
    }

    public final void bm(Canvas canvas, float f, int i, int i2, asj asjVar, asg asgVar) {
        ud udVar;
        asn asnVar = this;
        if (asjVar == null && asgVar == null) {
            return;
        }
        CodeEditor codeEditor = asnVar.r;
        int firstVisibleRow = codeEditor.getFirstVisibleRow();
        int lastVisibleRow = codeEditor.getLastVisibleRow();
        btr layout = codeEditor.getLayout();
        int iL = layout.l(i);
        int iL2 = layout.l(i2);
        ud udVarN = asnVar.af.b.n(i);
        ud udVarN2 = asnVar.af.b.n(i2);
        ddo ddoVarI = layout.i(iL, asnVar.p);
        int i3 = iL;
        while (i3 <= iL2 && ddoVarI.hasNext()) {
            ddm next = ddoVarI.next();
            if (firstVisibleRow > i3 || i3 > lastVisibleRow) {
                udVar = udVarN;
            } else {
                int i4 = i3 == iL ? udVarN.c : next.d;
                int i5 = i3 == iL2 ? udVarN2.c : next.e;
                drd drdVarAo = asnVar.ao(i3);
                float fBg = ((codeEditor.getNonPrintablePaintingFlags() & 128) == 0 || next.b) ? f : asnVar.bg() + f;
                udVar = udVarN;
                float fMax = Math.max(0.0f, -fBg);
                float width = fMax + codeEditor.getWidth();
                canvas.save();
                canvas.translate(fBg + next.g, (codeEditor.getRowHeight() * i3) - codeEditor.getOffsetY());
                if (asgVar != null) {
                    drdVarAo.y(i4, i5, asgVar);
                }
                if (asjVar != null) {
                    drdVarAo.z(i4, i5, canvas, fMax, width, true, asjVar);
                }
                canvas.restore();
            }
            i3++;
            asnVar = this;
            udVarN = udVar;
        }
    }

    public final void bn() {
        this.ab = SystemClock.elapsedRealtimeNanos();
    }
}
