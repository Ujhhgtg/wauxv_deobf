package me.hd.wauxv.obf;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bqx extends czd implements czi {
    public Rect ab;
    public long ac;
    public float e;
    public float f;
    public float g;
    public float h;
    public float i;
    public float j;
    public float k;
    public float l;
    public final xe n;
    public int p;
    public int r;
    public RecyclerView s;
    public VelocityTracker u;
    public ArrayList v;
    public ArrayList w;
    public GestureDetector y;
    public bqw z;
    public final ArrayList a = new ArrayList();
    public final float[] b = new float[2];
    public czx d = null;
    public int m = -1;
    public int o = 0;
    public final ArrayList q = new ArrayList();
    public final dc t = new dc(this, 11);
    public View x = null;
    public final bqt aa = new bqt(this);

    public bqx(xe xeVar) {
        this.n = xeVar;
    }

    public static boolean ad(View view, float f, float f2, float f3, float f4) {
        return f >= f3 && f <= f3 + ((float) view.getWidth()) && f2 >= f4 && f2 <= f4 + ((float) view.getHeight());
    }

    @Override // me.hd.wauxv.obf.czd
    public final void _bj(Rect rect, View view, RecyclerView recyclerView, czt cztVar) {
        rect.setEmpty();
    }

    @Override // me.hd.wauxv.obf.czd
    public final void _bk(Canvas canvas, RecyclerView recyclerView) {
        float f;
        float f2;
        if (this.d != null) {
            float[] fArr = this.b;
            an(fArr);
            f = fArr[0];
            f2 = fArr[1];
        } else {
            f = 0.0f;
            f2 = 0.0f;
        }
        czx czxVar = this.d;
        this.n.getClass();
        ArrayList arrayList = this.q;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            bqu bquVar = (bqu) arrayList.get(i);
            czx czxVar2 = bquVar.e;
            float f3 = bquVar.a;
            float f4 = bquVar.c;
            if (f3 == f4) {
                bquVar.i = czxVar2.d.getTranslationX();
            } else {
                bquVar.i = yg.a(f4, f3, bquVar.m, f3);
            }
            float f5 = bquVar.b;
            float f6 = bquVar.d;
            if (f5 == f6) {
                bquVar.j = czxVar2.d.getTranslationY();
            } else {
                bquVar.j = yg.a(f6, f5, bquVar.m, f5);
            }
            int iSave = canvas.save();
            xe.j(recyclerView, bquVar.e, bquVar.i, bquVar.j, false);
            canvas.restoreToCount(iSave);
        }
        if (czxVar != null) {
            int iSave2 = canvas.save();
            xe.j(recyclerView, czxVar, f, f2, true);
            canvas.restoreToCount(iSave2);
        }
    }

    @Override // me.hd.wauxv.obf.czi
    public final void ae(View view) {
        ap(view);
        czx czxVarDv = this.s.dv(view);
        if (czxVarDv == null) {
            return;
        }
        czx czxVar = this.d;
        if (czxVar != null && czxVarDv == czxVar) {
            aq(null, 0);
            return;
        }
        al(czxVarDv, false);
        if (this.a.remove(czxVarDv.d)) {
            this.n.getClass();
            xe.g(czxVarDv);
        }
    }

    @Override // me.hd.wauxv.obf.czi
    public final void af(View view) {
    }

    public final int ai(int i) {
        if ((i & 12) == 0) {
            return 0;
        }
        int i2 = this.i > 0.0f ? 8 : 4;
        VelocityTracker velocityTracker = this.u;
        xe xeVar = this.n;
        if (velocityTracker != null && this.m > -1) {
            float f = this.h;
            xeVar.getClass();
            velocityTracker.computeCurrentVelocity(1000, f);
            float xVelocity = this.u.getXVelocity(this.m);
            float yVelocity = this.u.getYVelocity(this.m);
            int i3 = xVelocity > 0.0f ? 8 : 4;
            float fAbs = Math.abs(xVelocity);
            if ((i3 & i) != 0 && i2 == i3 && fAbs >= this.g && fAbs > Math.abs(yVelocity)) {
                return i3;
            }
        }
        float width = this.s.getWidth();
        xeVar.getClass();
        float f2 = width * 0.5f;
        if ((i & i2) == 0 || Math.abs(this.i) <= f2) {
            return 0;
        }
        return i2;
    }

    public final void aj(int i, int i2, MotionEvent motionEvent) {
        int iH;
        View viewAm;
        if (this.d == null && i == 2 && this.o != 2) {
            this.n.getClass();
            if (this.s.getScrollState() == 1) {
                return;
            }
            czg layoutManager = this.s.getLayoutManager();
            int i3 = this.m;
            czx czxVarDv = null;
            if (i3 != -1) {
                int iFindPointerIndex = motionEvent.findPointerIndex(i3);
                float x = motionEvent.getX(iFindPointerIndex) - this.e;
                float y = motionEvent.getY(iFindPointerIndex) - this.f;
                float fAbs = Math.abs(x);
                float fAbs2 = Math.abs(y);
                float f = this.r;
                if ((fAbs >= f || fAbs2 >= f) && ((fAbs <= fAbs2 || !layoutManager.bu())
                        && ((fAbs2 <= fAbs || !layoutManager.bv()) && (viewAm = am(motionEvent)) != null))) {
                    czxVarDv = this.s.dv(viewAm);
                }
            }
            if (czxVarDv == null || (iH = (xe.h(786444, this.s.getLayoutDirection()) & 65280) >> 8) == 0) {
                return;
            }
            float x2 = motionEvent.getX(i2);
            float y2 = motionEvent.getY(i2);
            float f2 = x2 - this.e;
            float f3 = y2 - this.f;
            float fAbs3 = Math.abs(f2);
            float fAbs4 = Math.abs(f3);
            float f4 = this.r;
            if (fAbs3 >= f4 || fAbs4 >= f4) {
                if (fAbs3 > fAbs4) {
                    if (f2 < 0.0f && (iH & 4) == 0) {
                        return;
                    }
                    if (f2 > 0.0f && (iH & 8) == 0) {
                        return;
                    }
                } else {
                    if (f3 < 0.0f && (iH & 1) == 0) {
                        return;
                    }
                    if (f3 > 0.0f && (iH & 2) == 0) {
                        return;
                    }
                }
                this.j = 0.0f;
                this.i = 0.0f;
                this.m = motionEvent.getPointerId(0);
                aq(czxVarDv, 1);
            }
        }
    }

    public final int ak(int i) {
        if ((i & 3) == 0) {
            return 0;
        }
        int i2 = this.j > 0.0f ? 2 : 1;
        VelocityTracker velocityTracker = this.u;
        xe xeVar = this.n;
        if (velocityTracker != null && this.m > -1) {
            float f = this.h;
            xeVar.getClass();
            velocityTracker.computeCurrentVelocity(1000, f);
            float xVelocity = this.u.getXVelocity(this.m);
            float yVelocity = this.u.getYVelocity(this.m);
            int i3 = yVelocity > 0.0f ? 2 : 1;
            float fAbs = Math.abs(yVelocity);
            if ((i3 & i) != 0 && i3 == i2 && fAbs >= this.g && fAbs > Math.abs(xVelocity)) {
                return i3;
            }
        }
        float height = this.s.getHeight();
        xeVar.getClass();
        float f2 = height * 0.5f;
        if ((i & i2) == 0 || Math.abs(this.j) <= f2) {
            return 0;
        }
        return i2;
    }

    public final void al(czx czxVar, boolean z) {
        ArrayList arrayList = this.q;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            bqu bquVar = (bqu) arrayList.get(size);
            if (bquVar.e == czxVar) {
                bquVar.k |= z;
                if (!bquVar.l) {
                    bquVar.g.cancel();
                }
                arrayList.remove(size);
                return;
            }
        }
    }

    public final View am(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        czx czxVar = this.d;
        if (czxVar != null) {
            View view = czxVar.d;
            if (ad(view, x, y, this.k + this.i, this.l + this.j)) {
                return view;
            }
        }
        ArrayList arrayList = this.q;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            bqu bquVar = (bqu) arrayList.get(size);
            View view2 = bquVar.e.d;
            if (ad(view2, x, y, bquVar.i, bquVar.j)) {
                return view2;
            }
        }
        RecyclerView recyclerView = this.s;
        for (int iY = recyclerView.p.y() - 1; iY >= 0; iY--) {
            View viewX = recyclerView.p.x(iY);
            float translationX = viewX.getTranslationX();
            float translationY = viewX.getTranslationY();
            if (x >= viewX.getLeft() + translationX && x <= viewX.getRight() + translationX
                    && y >= viewX.getTop() + translationY && y <= viewX.getBottom() + translationY) {
                return viewX;
            }
        }
        return null;
    }

    public final void an(float[] fArr) {
        if ((this.p & 12) != 0) {
            fArr[0] = (this.k + this.i) - this.d.d.getLeft();
        } else {
            fArr[0] = this.d.d.getTranslationX();
        }
        if ((this.p & 3) != 0) {
            fArr[1] = (this.l + this.j) - this.d.d.getTop();
        } else {
            fArr[1] = this.d.d.getTranslationY();
        }
    }

    public final void ao(czx czxVar) {
        akf akfVar;
        int bottom;
        int iAbs;
        int top;
        int iAbs2;
        int left;
        int iAbs3;
        int right;
        int iAbs4;
        int i;
        int i2;
        int i3;
        if (!this.s.isLayoutRequested() && this.o == 2) {
            xe xeVar = this.n;
            xeVar.getClass();
            int i4 = (int) (this.k + this.i);
            int i5 = (int) (this.l + this.j);
            View view = czxVar.d;
            if (Math.abs(i5 - view.getTop()) >= view.getHeight() * 0.5f
                    || Math.abs(i4 - view.getLeft()) >= view.getWidth() * 0.5f) {
                ArrayList arrayList = this.v;
                if (arrayList == null) {
                    this.v = new ArrayList();
                    this.w = new ArrayList();
                } else {
                    arrayList.clear();
                    this.w.clear();
                }
                int iRound = Math.round(this.k + this.i);
                int iRound2 = Math.round(this.l + this.j);
                int width = view.getWidth() + iRound;
                int height = view.getHeight() + iRound2;
                int i6 = (iRound + width) / 2;
                int i7 = (iRound2 + height) / 2;
                czg layoutManager = this.s.getLayoutManager();
                int iEs = layoutManager.es();
                int i8 = 0;
                while (i8 < iEs) {
                    View viewEr = layoutManager.er(i8);
                    if (viewEr == view) {
                        i = i8;
                    } else {
                        i = i8;
                        if (viewEr.getBottom() >= iRound2 && viewEr.getTop() <= height && viewEr.getRight() >= iRound
                                && viewEr.getLeft() <= width) {
                            czx czxVarDv = this.s.dv(viewEr);
                            int iAbs5 = Math.abs(i6 - ((viewEr.getRight() + viewEr.getLeft()) / 2));
                            int iAbs6 = Math.abs(i7 - ((viewEr.getBottom() + viewEr.getTop()) / 2));
                            int i9 = (iAbs6 * iAbs6) + (iAbs5 * iAbs5);
                            i2 = i4;
                            int size = this.v.size();
                            i3 = i5;
                            int i10 = 0;
                            int i11 = 0;
                            while (i10 < size) {
                                int i12 = size;
                                if (i9 <= ((Integer) this.w.get(i10)).intValue()) {
                                    break;
                                }
                                i11++;
                                i10++;
                                size = i12;
                            }
                            this.v.add(i11, czxVarDv);
                            this.w.add(i11, Integer.valueOf(i9));
                        }
                        i8 = i + 1;
                        i4 = i2;
                        i5 = i3;
                    }
                    i2 = i4;
                    i3 = i5;
                    i8 = i + 1;
                    i4 = i2;
                    i5 = i3;
                }
                int i13 = i4;
                int i14 = i5;
                ArrayList arrayList2 = this.v;
                if (arrayList2.size() == 0) {
                    return;
                }
                int width2 = view.getWidth() + i13;
                int height2 = view.getHeight() + i14;
                int left2 = i13 - view.getLeft();
                int top2 = i14 - view.getTop();
                int size2 = arrayList2.size();
                czx czxVar2 = null;
                int i15 = -1;
                for (int i16 = 0; i16 < size2; i16++) {
                    czx czxVar3 = (czx) arrayList2.get(i16);
                    if (left2 > 0 && (right = czxVar3.d.getRight() - width2) < 0
                            && czxVar3.d.getRight() > view.getRight() && (iAbs4 = Math.abs(right)) > i15) {
                        i15 = iAbs4;
                        czxVar2 = czxVar3;
                    }
                    if (left2 < 0 && (left = czxVar3.d.getLeft() - i13) > 0 && czxVar3.d.getLeft() < view.getLeft()
                            && (iAbs3 = Math.abs(left)) > i15) {
                        i15 = iAbs3;
                        czxVar2 = czxVar3;
                    }
                    if (top2 < 0 && (top = czxVar3.d.getTop() - i14) > 0 && czxVar3.d.getTop() < view.getTop()
                            && (iAbs2 = Math.abs(top)) > i15) {
                        i15 = iAbs2;
                        czxVar2 = czxVar3;
                    }
                    if (top2 > 0 && (bottom = czxVar3.d.getBottom() - height2) < 0
                            && czxVar3.d.getBottom() > view.getBottom() && (iAbs = Math.abs(bottom)) > i15) {
                        i15 = iAbs;
                        czxVar2 = czxVar3;
                    }
                }
                if (czxVar2 == null) {
                    this.v.clear();
                    this.w.clear();
                    return;
                }
                View view2 = czxVar2.d;
                int iX = czxVar2.x();
                czxVar.x();
                int iY = czxVar.y();
                int iY2 = czxVar2.y();
                List list = (List) xeVar.d;
                list.add(iY2, list.remove(iY));
                ((cyw) xeVar.e).ac.c(iY, iY2);
                if (list.isEmpty()) {
                    akfVar = xd.a;
                    break;
                }
                Iterator it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (((wz) it.next()).b.equals("群工具" /* "群工具" /* "群工具" /* cnb.z(-549485230947114L)  */)) {
                            akfVar = xc.a;
                            break;
                        }
                    } else {
                        akfVar = xd.a;
                        break;
                    }
                }
                akfVar.u(aaz.k((List) xeVar.d, "," /* "," /* "," /* cnb.z(-549502410816298L)  */, null, null, new ws(7), 30));
                RecyclerView recyclerView = this.s;
                czg layoutManager2 = recyclerView.getLayoutManager();
                if (!(layoutManager2 instanceof LinearLayoutManager)) {
                    if (layoutManager2.bu()) {
                        if (czg.eg(view2) <= recyclerView.getPaddingLeft()) {
                            recyclerView.eq(iX);
                        }
                        if (czg.ej(view2) >= recyclerView.getWidth() - recyclerView.getPaddingRight()) {
                            recyclerView.eq(iX);
                        }
                    }
                    if (layoutManager2.bv()) {
                        if (czg.ek(view2) <= recyclerView.getPaddingTop()) {
                            recyclerView.eq(iX);
                        }
                        if (czg.ef(view2) >= recyclerView.getHeight() - recyclerView.getPaddingBottom()) {
                            recyclerView.eq(iX);
                            return;
                        }
                        return;
                    }
                    return;
                }
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager2;
                linearLayoutManager.bt("Cannot drop a view during a scroll or layout calculation");
                linearLayoutManager.cp();
                linearLayoutManager.de();
                int iEl = czg.el(view);
                int iEl2 = czg.el(view2);
                byte b = iEl < iEl2 ? (byte) 1 : (byte) -1;
                if (linearLayoutManager.bi) {
                    if (b == 1) {
                        linearLayoutManager.dg(iEl2, linearLayoutManager.bf.j()
                                - (linearLayoutManager.bf.f(view) + linearLayoutManager.bf.h(view2)));
                        return;
                    } else {
                        linearLayoutManager.dg(iEl2, linearLayoutManager.bf.j() - linearLayoutManager.bf.e(view2));
                        return;
                    }
                }
                if (b == -1) {
                    linearLayoutManager.dg(iEl2, linearLayoutManager.bf.h(view2));
                } else {
                    linearLayoutManager.dg(iEl2, linearLayoutManager.bf.e(view2) - linearLayoutManager.bf.f(view));
                }
            }
        }
    }

    public final void ap(View view) {
        if (view == this.x) {
            this.x = null;
        }
    }

    /* JADX WARN: Found duplicated region for block: B:18:0x004a */
    /* JADX WARN: Multi-variable type inference failed */
    /*
     * JADX WARN: Type inference failed for: r0v6, types: [android.view.ViewParent]
     */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v7, types: [boolean] */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r2v1, types: [me.hd.wauxv.obf.czx] */
    public final void aq(czx czxVar, int i) {
        xe xeVar;
        ?? r12;
        boolean z;
        Vibrator defaultVibrator;
        ?? r122;
        ?? r123;
        int i2;
        char c;
        float fSignum;
        char c2;
        if (czxVar == this.d && i == this.o) {
            return;
        }
        this.ac = Long.MIN_VALUE;
        int i3 = this.o;
        al(czxVar, true);
        this.o = i;
        if (i == 2) {
            if (czxVar == null) {
                throw new IllegalArgumentException("Must pass a ViewHolder when dragging");
            }
            this.x = czxVar.d;
        }
        int i4 = (1 << ((i * 8) + 8)) - 1;
        ?? r2 = this.d;
        xe xeVar2 = this.n;
        if (r2 != 0) {
            View view = r2.d;
            if (view.getParent() != null) {
                if (i3 != 2 && this.o != 2) {
                    xeVar2.getClass();
                    int iH = (xe.h(786444, this.s.getLayoutDirection()) & 65280) >> 8;
                    if (iH != 0) {
                        if (Math.abs(this.i) > Math.abs(this.j)) {
                            int iAi = ai(iH);
                            if (iAi > 0) {
                                i2 = xe.i(iAi, this.s.getLayoutDirection());
                            } else {
                                i2 = ak(iH);
                                if (i2 <= 0) {
                                }
                            }
                        } else {
                            int iAk = ak(iH);
                            if (iAk > 0) {
                                i2 = iAk;
                            } else {
                                int iAi2 = ai(iH);
                                i2 = iAi2 > 0 ? xe.i(iAi2, this.s.getLayoutDirection()) : 0;
                            }
                        }
                    }
                }
                VelocityTracker velocityTracker = this.u;
                if (velocityTracker != null) {
                    velocityTracker.recycle();
                    this.u = null;
                }
                float fSignum2 = 0.0f;
                if (i2 == 1 || i2 == 2) {
                    c = 0;
                    fSignum = Math.signum(this.j) * this.s.getHeight();
                    c2 = 4;
                } else if (i2 == 4 || i2 == 8 || i2 == 16 || i2 == 32) {
                    c = 0;
                    fSignum2 = Math.signum(this.i) * this.s.getWidth();
                    c2 = 4;
                    fSignum = 0.0f;
                } else {
                    c2 = 4;
                    fSignum = 0.0f;
                    c = 0;
                }
                if (i3 == 2) {
                    c2 = '\b';
                } else if (i2 > 0) {
                    c2 = 2;
                }
                float[] fArr = this.b;
                an(fArr);
                xeVar = xeVar2;
                char c3 = c2;
                ?? r124 = c;
                bqu bquVar = new bqu(this, r2, i3, fArr[c], fArr[1], fSignum2, fSignum, i2, r2);
                RecyclerView recyclerView = this.s;
                xeVar.getClass();
                czc itemAnimator = recyclerView.getItemAnimator();
                long j = itemAnimator == null ? c3 == '\b' ? 200L : 250L : c3 == '\b' ? itemAnimator.ab : itemAnimator.aa;
                ValueAnimator valueAnimator = bquVar.g;
                valueAnimator.setDuration(j);
                this.q.add(bquVar);
                r2.al(r124);
                valueAnimator.start();
                z = true;
                r123 = r124;
            } else {
                xeVar = xeVar2;
                r123 = 0;
                ap(view);
                xeVar.getClass();
                xe.g(r2);
                z = false;
            }
            this.d = null;
            r12 = r123;
        } else {
            xeVar = xeVar2;
            r12 = 0;
            z = false;
        }
        if (czxVar != null) {
            View view2 = czxVar.d;
            RecyclerView recyclerView2 = this.s;
            xeVar.getClass();
            this.p = (xe.h(786444, recyclerView2.getLayoutDirection()) & i4) >> (this.o * 8);
            this.k = view2.getLeft();
            this.l = view2.getTop();
            this.d = czxVar;
            if (i == 2) {
                view2.performHapticFeedback(r12 == true ? 1 : 0);
            }
        }
        ?? parent = this.s.getParent();
        if (parent != 0) {
            if (this.d != null) {
                r122 = r12;
                r122 = 1;
            }
            r122 = r12;
            parent.requestDisallowInterceptTouchEvent(r122);
        }
        if (!z) {
            this.s.getLayoutManager().dt = true;
        }
        if (this.o != 0) {
            Context context = ((RecyclerView) xeVar.f).getContext();
            if (Build.VERSION.SDK_INT >= 31) {
                Object systemService = context.getSystemService("vibrator_manager" /* "vibrator_manager" /* "vibrator_manager" /* cnb.z(-71210557766442L)  */);
                throwIfVar1IsNull(systemService, "null cannot be cast to non-null type android.os.VibratorManager" /* "null cannot be cast to non-null type android.os.VibratorManager" /* "null cannot be cast to non-null type android.os.VibratorManager" /* cnb.z(-70587787508522L)  */);
                defaultVibrator = qc.m(systemService).getDefaultVibrator();
            } else {
                Object systemService2 = context.getSystemService("vibrator" /* "vibrator" /* "vibrator" /* cnb.z(-70862665415466L)  */);
                throwIfVar1IsNull(systemService2, "null cannot be cast to non-null type android.os.Vibrator" /* "null cannot be cast to non-null type android.os.Vibrator" /* "null cannot be cast to non-null type android.os.Vibrator" /* cnb.z(-70841190578986L)  */);
                defaultVibrator = (Vibrator) systemService2;
            }
            defaultVibrator.vibrate(VibrationEffect.createOneShot(40L, -1));
        } else {
            xeVar.getClass();
        }
        this.s.invalidate();
    }

    public final void ar(int i, int i2, MotionEvent motionEvent) {
        float x = motionEvent.getX(i2);
        float y = motionEvent.getY(i2);
        float f = x - this.e;
        this.i = f;
        this.j = y - this.f;
        if ((i & 4) == 0) {
            this.i = Math.max(0.0f, f);
        }
        if ((i & 8) == 0) {
            this.i = Math.min(0.0f, this.i);
        }
        if ((i & 1) == 0) {
            this.j = Math.max(0.0f, this.j);
        }
        if ((i & 2) == 0) {
            this.j = Math.min(0.0f, this.j);
        }
    }

    @Override // me.hd.wauxv.obf.czd
    public final void c(Canvas canvas, RecyclerView recyclerView) {
        boolean z = false;
        if (this.d != null) {
            float[] fArr = this.b;
            an(fArr);
            float f = fArr[0];
            float f2 = fArr[1];
        }
        czx czxVar = this.d;
        this.n.getClass();
        ArrayList arrayList = this.q;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            bqu bquVar = (bqu) arrayList.get(i);
            int iSave = canvas.save();
            View view = bquVar.e.d;
            canvas.restoreToCount(iSave);
        }
        if (czxVar != null) {
            canvas.restoreToCount(canvas.save());
        }
        for (int i2 = size - 1; i2 >= 0; i2--) {
            bqu bquVar2 = (bqu) arrayList.get(i2);
            boolean z2 = bquVar2.l;
            if (z2 && !bquVar2.h) {
                arrayList.remove(i2);
            } else if (!z2) {
                z = true;
            }
        }
        if (z) {
            recyclerView.invalidate();
        }
    }
}
