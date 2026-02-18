package me.hd.wauxv.obf;

import android.content.res.Resources;
import android.graphics.PointF;
import android.os.Build;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ViewConfiguration;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import io.github.rosemoe.sora.widget.CodeEditor;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class asv implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener,
        ScaleGestureDetector.OnScaleGestureListener {
    public final CodeEditor a;
    public float aa;
    public float ab;
    public int ac;
    public long ad;
    public boolean ae;
    public PointF af;
    public boolean ag;
    public boolean ah;
    public ud ai;
    public boolean aj;
    public boolean ak;
    public long ap;
    public boolean aq;
    public float ar;
    public final aso b;
    public final byw d;
    public boolean f;
    public float g;
    public float h;
    public boolean i;
    public boolean j;
    public float n;
    public final float w;
    public int x;
    public final int y;
    public MotionEvent z;
    public int e = -1;
    public boolean k = false;
    public long o = 0;
    public long p = 0;
    public boolean q = false;
    public boolean r = false;
    public float s = 0.0f;
    public float t = 0.0f;
    public int al = -1;
    public int am = -1;
    public int an = -1;
    public int ao = -1;
    public final float l = TypedValue.applyDimension(2, 26.0f, Resources.getSystem().getDisplayMetrics());
    public final float m = TypedValue.applyDimension(2, 8.0f, Resources.getSystem().getDisplayMetrics());
    public ek u = new ek(this, 1, 6);
    public ek v = new ek(this, 2, 6);
    public final ek c = new ek(this, 0, 6);

    public asv(CodeEditor codeEditor) {
        this.a = codeEditor;
        this.w = codeEditor.getDpUnit() * 18.0f;
        this.b = new aso(codeEditor);
        this.d = new byw(codeEditor);
        this.y = ViewConfiguration.get(codeEditor.getContext()).getScaledTouchSlop();
    }

    public static boolean as(asv asvVar, float f, float f2) {
        if (Math.abs(f) < 100000.0d || Math.abs(f2) < 100000.0d) {
            return false;
        }
        if (f >= 0.0f || f2 >= 0.0f) {
            return f > 0.0f && f2 > 0.0f;
        }
        return true;
    }

    public final int at(aak aakVar, ud udVar, MotionEvent motionEvent) {
        long jAf = ajn.af(this.a, motionEvent, -1);
        return au(aakVar, udVar, motionEvent, (int) (jAf >> 32), (int) (jAf & 4294967295L));
    }

    public final int au(aak aakVar, ud udVar, MotionEvent motionEvent, int i, int i2) {
        ua bmpVar;
        ud udVarO;
        CodeEditor codeEditor = this.a;
        if (udVar == null) {
            long jDr = codeEditor.dr(motionEvent.getX(), motionEvent.getY());
            udVar = codeEditor.getText().x().o((int) (jDr >> 32), (int) (jDr & 4294967295L));
        }
        dnv styles = codeEditor.getStyles();
        aff text = codeEditor.getText();
        dle dleVarU = bhs.u(styles, udVar, 0);
        dle dleVarU2 = bhs.u(styles, udVar, 1);
        if (dleVarU != null) {
            ud udVarO2 = text.x().o(udVar.b, cnd.an(dleVarU.i(), text.y(udVar.b).b));
            if (dleVarU2 != null) {
                udVarO = text.x().o(udVar.b, cnd.an(dleVarU2.i(), text.y(udVar.b).b));
            } else {
                sq sqVarX = text.x();
                int i3 = udVar.b;
                udVarO = sqVarX.o(i3, text.y(i3).b);
            }
            new dqs(udVarO2, udVarO);
        }
        switch (aakVar.a) {
            case 0:
                bmpVar = new bmp(codeEditor, udVar, motionEvent);
                break;
            case 1:
                bmpVar = new bxy(codeEditor, udVar, motionEvent);
                break;
            case 2:
                bmpVar = new zx(codeEditor, udVar, motionEvent);
                break;
            case 3:
                bmpVar = new zx(codeEditor, udVar, motionEvent);
                break;
            default:
                bmpVar = new zx(codeEditor, udVar, motionEvent);
                break;
        }
        return codeEditor.i.g(bmpVar);
    }

    public final void av(int i, boolean z) {
        CodeEditor codeEditor = this.a;
        codeEditor.i.g(new bjy(codeEditor, i, z));
    }

    public final void aw() {
        boolean z = this.ak;
        this.aj = false;
        this.ak = false;
        this.al = -1;
        this.am = -1;
        this.an = -1;
        this.ao = -1;
        if (z) {
            CodeEditor codeEditor = this.a;
            codeEditor.i.g(new apr(codeEditor));
        }
    }

    /* JADX WARN: Found duplicated region for block: B:20:0x004c */
    /* JADX WARN: Found duplicated region for block: B:22:0x0051 */
    /* JADX WARN: Found duplicated region for block: B:24:0x0055 */
    /* JADX WARN: Found duplicated region for block: B:26:0x0059 */
    /* JADX WARN: Found duplicated region for block: B:27:0x005c */
    /* JADX WARN: Found duplicated region for block: B:30:0x0072 */
    /* JADX WARN: Found duplicated region for block: B:31:0x007f A[MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:34:0x009d */
    public final boolean ax(MotionEvent motionEvent, boolean z) {
        int iMin;
        int iMax;
        sq sqVarX;
        CodeEditor codeEditor = this.a;
        if (!codeEditor.getProps().x || !this.aj) {
            return false;
        }
        aff text = codeEditor.getText();
        if (text.d != 0) {
            long jDr = codeEditor.dr(motionEvent.getX(), motionEvent.getY());
            int iV = text.v((int) (jDr >> 32), (int) (jDr & 4294967295L));
            if (this.ak) {
                if (iV == this.ao) {
                    bf(motionEvent);
                    if (!z) {
                        bd(motionEvent);
                        return true;
                    }
                } else {
                    int iAn = cnd.an(iV <= this.al ? this.an : this.am, text.d);
                    iMin = Math.min(iAn, iV);
                    iMax = Math.max(iAn, iV);
                    sqVarX = text.x();
                    if (iMin == iMax) {
                        ud udVarN = sqVarX.n(iMin);
                        codeEditor.eq(udVarN.b, udVarN.c, 2, false);
                    } else {
                        ud udVarN2 = sqVarX.n(iMin);
                        ud udVarN3 = sqVarX.n(iMax);
                        codeEditor.es(udVarN2.b, false, udVarN2.c, udVarN3.b, udVarN3.c, 2);
                    }
                    this.ao = iV;
                    bf(motionEvent);
                    if (!z) {
                        bd(motionEvent);
                    }
                }
            } else if (iV != this.al) {
                this.ak = true;
                if (iV == this.ao) {
                    bf(motionEvent);
                    if (!z) {
                        bd(motionEvent);
                        return true;
                    }
                } else {
                    int iAn2 = cnd.an(iV <= this.al ? this.an : this.am, text.d);
                    iMin = Math.min(iAn2, iV);
                    iMax = Math.max(iAn2, iV);
                    sqVarX = text.x();
                    if (iMin == iMax) {
                        ud udVarN4 = sqVarX.n(iMin);
                        codeEditor.eq(udVarN4.b, udVarN4.c, 2, false);
                    } else {
                        ud udVarN22 = sqVarX.n(iMin);
                        ud udVarN32 = sqVarX.n(iMax);
                        codeEditor.es(udVarN22.b, false, udVarN22.c, udVarN32.b, udVarN32.c, 2);
                    }
                    this.ao = iV;
                    bf(motionEvent);
                    if (!z) {
                        bd(motionEvent);
                    }
                }
            } else if (!z) {
                bd(motionEvent);
                return true;
            }
        }
        return true;
    }

    public final boolean ay() {
        return this.e != -1;
    }

    /*
     * JADX WARN: Code restructure failed: missing block: B:8:0x001f, code lost:
     * 
     * if (r0 != 3) goto L67;
     */
    /* JADX WARN: Found duplicated region for block: B:47:0x013f */
    /* JADX WARN: Found duplicated region for block: B:64:0x0198 */
    /*
     * Code decompiled incorrectly, please refer to instructions dump.
     * To view partially-correct add '--show-bad-code' argument
     */
    public final boolean az(android.view.MotionEvent r12) {
        /*
         * Method dump skipped, instruction units count: 694
         * To view this dump add '--comments-level debug' option
         */
        throw new UnsupportedOperationException(
                "Method not decompiled: me.hd.wauxv.obf.asv.az(android.view.MotionEvent):boolean");
    }

    public final void ba() {
        this.ab = 0.0f;
        this.aa = 0.0f;
        this.ag = false;
        this.ah = false;
        this.ai = null;
        if (this.ae) {
            this.ae = false;
            this.ad = 0L;
        }
    }

    public final void bb(float f, float f2, boolean z) {
        aso asoVar = this.b;
        int currX = asoVar.b.getCurrX() + ((int) f);
        OverScroller overScroller = asoVar.b;
        int currY = overScroller.getCurrY() + ((int) f2);
        int iMax = Math.max(currX, 0);
        int iMax2 = Math.max(currY, 0);
        CodeEditor codeEditor = this.a;
        int iMin = Math.min(iMax2, codeEditor.getScrollMaxY());
        int iMin2 = Math.min(iMax, codeEditor.getScrollMaxX());
        codeEditor.i.g(new dfb(codeEditor, overScroller.getCurrX(), overScroller.getCurrY(), iMin2, iMin, 1));
        if (z) {
            asoVar.d(overScroller.getCurrX(), overScroller.getCurrY(), iMin2 - overScroller.getCurrX(),
                    iMin - overScroller.getCurrY(), asoVar.a.getProps().i);
        } else {
            asoVar.d(asoVar.b.getCurrX(), overScroller.getCurrY(), iMin2 - overScroller.getCurrX(),
                    iMin - overScroller.getCurrY(), 0);
            overScroller.abortAnimation();
            asoVar.c();
        }
        codeEditor.invalidate();
    }

    public final void bc(MotionEvent motionEvent, float f, float f2) {
        if (motionEvent != null) {
            f = motionEvent.getX();
            f2 = motionEvent.getY();
        }
        float f3 = this.w;
        int i = f < f3 ? 1 : 0;
        if (f2 < f3) {
            i |= 4;
        }
        CodeEditor codeEditor = this.a;
        if (f > codeEditor.getWidth() - f3) {
            i |= 2;
        }
        if (f2 > codeEditor.getHeight() - f3) {
            i |= 8;
        }
        if (i == 0) {
            this.x = 0;
            return;
        }
        int i2 = this.x;
        this.x = i;
        this.z = motionEvent == null ? null : MotionEvent.obtain(motionEvent);
        if (i2 == 0) {
            codeEditor.ei(new asu(this, (int) (codeEditor.getDpUnit() * 8.0f)));
        }
    }

    public final void bd(MotionEvent motionEvent) {
        bc(motionEvent, 0.0f, 0.0f);
    }

    public final boolean be() {
        return System.currentTimeMillis() - this.p < 3500 || this.e == 0;
    }

    public final void bf(MotionEvent motionEvent) {
        boolean z = this.a.getProps().x;
        byw bywVar = this.d;
        if (z && this.x == 0) {
            bywVar.getClass();
            if (this.ak) {
                if (!bywVar.b.isShowing()) {
                    double x = motionEvent.getX() - this.t;
                    double y = motionEvent.getY() - this.s;
                    if (Math.sqrt((y * y) + (x * x)) < 4.0d) {
                        return;
                    }
                }
                bywVar.k((int) motionEvent.getX(), (int) (motionEvent.getY() - r0.getRowHeight()));
                return;
            }
        }
        bywVar.j();
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTap(MotionEvent motionEvent) {
        CodeEditor codeEditor = this.a;
        codeEditor.dx();
        long jDr = codeEditor.dr(motionEvent.getX(), motionEvent.getY());
        int i = (int) (jDr >> 32);
        int i2 = (int) (jDr & 4294967295L);
        if ((at(new aak(3), codeEditor.getText().x().o(i, i2), motionEvent) & 2) == 0 && !codeEditor.getCursor().h()
                && motionEvent.getPointerCount() == 1) {
            codeEditor.en(i, i2);
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent motionEvent) {
        return this.a.isEnabled();
    }

    /* JADX WARN: Found duplicated region for block: B:11:0x002c A[RETURN] */
    /* JADX WARN: Found duplicated region for block: B:12:0x002d */
    /* JADX WARN: Found duplicated region for block: B:16:0x0080 */
    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        float f3;
        float f4;
        float dpUnit;
        CodeEditor codeEditor = this.a;
        if (codeEditor.getProps().aa) {
            f3 = 0.0f;
            if (Math.abs(f) > Math.abs(f2)) {
                f4 = 0.0f;
                f3 = f;
            }
            if (!codeEditor.getProps().h) {
                return false;
            }
            aso asoVar = this.b;
            OverScroller overScroller = asoVar.b;
            OverScroller overScroller2 = asoVar.b;
            overScroller.forceFinished(true);
            asoVar.c();
            int scrollMaxX = codeEditor.getScrollMaxX();
            int scrollMaxY = codeEditor.getScrollMaxY();
            codeEditor.getProps().getClass();
            codeEditor.getProps().getClass();
            overScroller2.fling(overScroller2.getCurrX(), overScroller2.getCurrY(), (int) (-f3), (int) (-f4), 0,
                    scrollMaxX, 0, scrollMaxY, 0, 0);
            asoVar.c();
            dpUnit = codeEditor.getDpUnit() * 2000.0f;
            if (Math.abs(f3) < dpUnit || Math.abs(f4) >= dpUnit) {
                this.o = System.currentTimeMillis();
                codeEditor.eh(new ast(this, 1), 3000L);
            }
            codeEditor.ce.onRelease();
            codeEditor.cd.onRelease();
            codeEditor.i.g(new dfb(codeEditor, overScroller2.getCurrX(), overScroller2.getCurrY(),
                    overScroller2.getFinalX(), overScroller2.getFinalY(), 2));
            codeEditor.postInvalidateOnAnimation();
            return false;
        }
        f3 = f;
        f4 = f2;
        if (!codeEditor.getProps().h) {
            return false;
        }
        aso asoVar2 = this.b;
        OverScroller overScroller3 = asoVar2.b;
        OverScroller overScroller22 = asoVar2.b;
        overScroller3.forceFinished(true);
        asoVar2.c();
        int scrollMaxX2 = codeEditor.getScrollMaxX();
        int scrollMaxY2 = codeEditor.getScrollMaxY();
        codeEditor.getProps().getClass();
        codeEditor.getProps().getClass();
        overScroller22.fling(overScroller22.getCurrX(), overScroller22.getCurrY(), (int) (-f3), (int) (-f4), 0,
                scrollMaxX2, 0, scrollMaxY2, 0, 0);
        asoVar2.c();
        dpUnit = codeEditor.getDpUnit() * 2000.0f;
        if (Math.abs(f3) < dpUnit) {
            this.o = System.currentTimeMillis();
            codeEditor.eh(new ast(this, 1), 3000L);
        } else {
            this.o = System.currentTimeMillis();
            codeEditor.eh(new ast(this, 1), 3000L);
        }
        codeEditor.ce.onRelease();
        codeEditor.cd.onRelease();
        codeEditor.i.g(new dfb(codeEditor, overScroller22.getCurrX(), overScroller22.getCurrY(),
                overScroller22.getFinalX(), overScroller22.getFinalY(), 2));
        codeEditor.postInvalidateOnAnimation();
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent motionEvent) {
        aso asoVar = this.b;
        asoVar.b.forceFinished(true);
        asoVar.c();
        CodeEditor codeEditor = this.a;
        codeEditor.ce.onRelease();
        codeEditor.cd.onRelease();
        codeEditor.dx();
        long jDr = codeEditor.dr(motionEvent.getX(), motionEvent.getY());
        int i = (int) (jDr >> 32);
        int i2 = (int) (jDr & 4294967295L);
        if ((at(new aak(1), codeEditor.getText().x().o(i, i2), motionEvent) & 2) != 0) {
            return;
        }
        if ((codeEditor.getProps().w || !codeEditor.getCursor().h()) && motionEvent.getPointerCount() == 1) {
            codeEditor.performHapticFeedback(0);
            codeEditor.en(i, i2);
            if (codeEditor.getCursor().h() && codeEditor.getProps().x) {
                aff text = codeEditor.getText();
                this.al = text.v(i, i2);
                ahy cursor = codeEditor.getCursor();
                ud udVar = cursor.c;
                this.am = text.v(udVar.b, udVar.c);
                ud udVar2 = cursor.d;
                this.an = text.v(udVar2.b, udVar2.c);
                this.ao = this.al;
                this.aj = true;
                this.ak = false;
            }
        }
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        CodeEditor codeEditor = this.a;
        codeEditor.dx();
        if (!codeEditor.ad) {
            return false;
        }
        float scaleFactor = scaleGestureDetector.getScaleFactor() * codeEditor.getTextSizePx();
        if (scaleFactor >= this.m && scaleFactor <= this.l) {
            float focusX = scaleGestureDetector.getFocusX();
            float focusY = scaleGestureDetector.getFocusY();
            int rowHeight = codeEditor.getRowHeight();
            codeEditor.setTextSizePxDirect(scaleFactor);
            float rowHeight2 = (codeEditor.getRowHeight() * 1.0f) / rowHeight;
            aso asoVar = this.b;
            OverScroller overScroller = asoVar.b;
            OverScroller overScroller2 = asoVar.b;
            int iMax = (int) Math.max(0.0f,
                    Math.min((scaleGestureDetector.getScaleFactor() * (overScroller2.getCurrX() + focusX)) - focusX,
                            codeEditor.getScrollMaxX()));
            int iMax2 = (int) Math.max(0.0f,
                    Math.min(((overScroller.getCurrY() + focusY) * rowHeight2) - focusY, codeEditor.getScrollMaxY()));
            codeEditor.i.g(new dfb(codeEditor, overScroller2.getCurrX(), overScroller2.getCurrY(), iMax, iMax2, 5));
            this.b.d(iMax, iMax2, 0, 0, 0);
            overScroller2.abortAnimation();
            asoVar.c();
            this.k = true;
            codeEditor.invalidate();
        }
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        aso asoVar = this.b;
        asoVar.b.forceFinished(true);
        asoVar.c();
        CodeEditor codeEditor = this.a;
        this.n = codeEditor.getTextSizePx();
        if (!codeEditor.ad) {
            return false;
        }
        codeEditor.dx();
        return !ay();
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        this.k = false;
        float f = this.n;
        CodeEditor codeEditor = this.a;
        if (f == codeEditor.getTextSizePx()) {
            return;
        }
        codeEditor.getRenderer().aj = true;
        if (codeEditor.af) {
            this.ar = scaleGestureDetector.getFocusY();
            this.ap = codeEditor.dr(scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            this.aq = true;
        } else {
            this.aq = false;
        }
        codeEditor.getRenderContext().c();
        codeEditor.getRenderer().bn();
        codeEditor.invalidate();
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        float f3;
        float f4;
        boolean z;
        boolean z2;
        CodeEditor codeEditor = this.a;
        if (!codeEditor.getProps().ab) {
            f3 = f;
            f4 = f2;
        } else if (Math.abs(f) > Math.abs(f2)) {
            f3 = f;
            f4 = 0.0f;
        } else {
            f4 = f2;
            f3 = 0.0f;
        }
        aso asoVar = this.b;
        OverScroller overScroller = asoVar.b;
        OverScroller overScroller2 = asoVar.b;
        int currX = overScroller.getCurrX() + ((int) f3);
        int currY = overScroller2.getCurrY() + ((int) f4);
        int iMax = Math.max(currX, 0);
        int iMin = Math.min(Math.max(currY, 0), codeEditor.getScrollMaxY());
        int iMin2 = Math.min(iMax, codeEditor.getScrollMaxX());
        if (codeEditor.getVerticalEdgeEffect().isFinished()) {
            z = true;
        } else {
            float fMax = Math.max(0.0f, Math.min(1.0f, motionEvent2.getX() / codeEditor.getWidth()));
            float measuredHeight = (this.i ? f4 : -f4) / codeEditor.getMeasuredHeight();
            if (measuredHeight > 0.0f) {
                iMin = overScroller2.getCurrY();
                EdgeEffect verticalEdgeEffect = codeEditor.getVerticalEdgeEffect();
                if (this.i) {
                    fMax = 1.0f - fMax;
                }
                verticalEdgeEffect.onPull(measuredHeight, fMax);
            } else if (Build.VERSION.SDK_INT >= 31) {
                EdgeEffect verticalEdgeEffect2 = codeEditor.getVerticalEdgeEffect();
                if (this.i) {
                    fMax = 1.0f - fMax;
                }
                verticalEdgeEffect2.onPullDistance(measuredHeight, fMax);
                if (verticalEdgeEffect2.getDistance() != 0.0f) {
                    iMin = overScroller2.getCurrY();
                }
            } else {
                codeEditor.getVerticalEdgeEffect().finish();
            }
            z = false;
        }
        int i = iMin;
        if (codeEditor.getHorizontalEdgeEffect().isFinished()) {
            z2 = true;
        } else {
            float fMax2 = Math.max(0.0f, Math.min(1.0f, motionEvent2.getY() / codeEditor.getHeight()));
            float measuredWidth = (this.j ? f3 : -f3) / codeEditor.getMeasuredWidth();
            if (measuredWidth > 0.0f) {
                iMin2 = overScroller2.getCurrX();
                EdgeEffect horizontalEdgeEffect = codeEditor.getHorizontalEdgeEffect();
                if (!this.j) {
                    fMax2 = 1.0f - fMax2;
                }
                horizontalEdgeEffect.onPull(measuredWidth, fMax2);
            } else if (Build.VERSION.SDK_INT >= 31) {
                EdgeEffect horizontalEdgeEffect2 = codeEditor.getHorizontalEdgeEffect();
                if (!this.j) {
                    fMax2 = 1.0f - fMax2;
                }
                horizontalEdgeEffect2.onPullDistance(measuredWidth, fMax2);
                if (horizontalEdgeEffect2.getDistance() != 0.0f) {
                    iMin2 = overScroller2.getCurrX();
                }
            } else {
                codeEditor.getHorizontalEdgeEffect().finish();
            }
            z2 = false;
        }
        int i2 = iMin2;
        asoVar.d(asoVar.b.getCurrX(), overScroller2.getCurrY(), i2 - overScroller2.getCurrX(),
                i - overScroller2.getCurrY(), 0);
        if (z && overScroller2.getCurrY() + f4 < -2.0f) {
            codeEditor.getVerticalEdgeEffect().onPull((-f4) / codeEditor.getMeasuredHeight(),
                    Math.max(0.0f, Math.min(1.0f, motionEvent2.getX() / codeEditor.getWidth())));
            this.i = false;
        }
        if (z && overScroller2.getCurrY() + f4 > codeEditor.getScrollMaxY() + 2.0f) {
            codeEditor.getVerticalEdgeEffect().onPull(f4 / codeEditor.getMeasuredHeight(),
                    Math.max(0.0f, Math.min(1.0f, motionEvent2.getX() / codeEditor.getWidth())));
            this.i = true;
        }
        if (z2 && overScroller2.getCurrX() + f3 < -2.0f) {
            codeEditor.getHorizontalEdgeEffect().onPull((-f3) / codeEditor.getMeasuredWidth(),
                    Math.max(0.0f, Math.min(1.0f, motionEvent2.getY() / codeEditor.getHeight())));
            this.j = false;
        }
        if (z2 && overScroller2.getCurrX() + f3 > codeEditor.getScrollMaxX() + 2.0f) {
            codeEditor.getHorizontalEdgeEffect().onPull(f3 / codeEditor.getMeasuredWidth(),
                    Math.max(0.0f, Math.min(1.0f, motionEvent2.getY() / codeEditor.getHeight())));
            this.j = true;
        }
        codeEditor.invalidate();
        codeEditor.i.g(new dfb(codeEditor, overScroller2.getCurrX(), overScroller2.getCurrY(), i2, i, 1));
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        aso asoVar = this.b;
        asoVar.b.forceFinished(true);
        asoVar.c();
        CodeEditor codeEditor = this.a;
        codeEditor.dx();
        throwIfVar1IsNull(motionEvent, "event");
        long jAf = ajn.af(codeEditor, motionEvent, -1);
        int i = (int) (jAf >> 32);
        int i2 = (int) (jAf & 4294967295L);
        long jDr = codeEditor.dr(motionEvent.getX(), motionEvent.getY());
        int i3 = (int) (jDr >> 32);
        int i4 = (int) (jDr & 4294967295L);
        codeEditor.performClick();
        if (i == 2) {
            if (codeEditor.getLayout()
                    .q(Math.max(0,
                            Math.min(((int) (motionEvent.getY() + codeEditor.getOffsetX())) / codeEditor.getRowHeight(),
                                    codeEditor.getLayout().e() - 1))).b) {
                codeEditor.getRenderer().r.getStyles();
            }
        }
        if ((au(new aak(2), codeEditor.getText().x().o(i3, i4), motionEvent, i, i2) & 2) == 0) {
            if (codeEditor.dw() && codeEditor.isEnabled()) {
                if (codeEditor.isInTouchMode() && !codeEditor.isFocused()) {
                    codeEditor.requestFocusFromTouch();
                }
                if (!codeEditor.isFocused()) {
                    codeEditor.requestFocus();
                }
                if (codeEditor.dd()) {
                    codeEditor.bn.showSoftInput(codeEditor, 0);
                }
            }
            codeEditor.invalidate();
            this.p = System.currentTimeMillis();
            codeEditor.eh(new ast(this, 0), 3500L);
            int i5 = codeEditor.getProps().u;
            if (i == 5) {
                if (!codeEditor.be) {
                    codeEditor.eq(i3, i4, 3, true);
                    return true;
                }
                ud udVar = codeEditor.getCursor().c;
                codeEditor.es(udVar.b, false, udVar.c, i3, i4, 3);
                codeEditor.be = false;
                return true;
            }
            if (i == 1) {
                if (i5 == 1) {
                    codeEditor.es(i3, false, 0, i3, codeEditor.getText().y(i3).b, 3);
                } else if (i5 == 2) {
                    codeEditor.eq(i3, i4, 3, true);
                    return true;
                }
            }
        }
        return true;
    }
}
