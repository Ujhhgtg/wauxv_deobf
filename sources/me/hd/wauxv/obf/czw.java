package me.hd.wauxv.obf;

import android.os.Build;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class czw implements Runnable {
    public int a;
    public int b;
    public OverScroller c;
    public Interpolator d;
    public boolean e;
    public boolean f;
    public final /* synthetic */ RecyclerView g;

    public czw(RecyclerView recyclerView) {
        this.g = recyclerView;
        bqv bqvVar = RecyclerView.i;
        this.d = bqvVar;
        this.e = false;
        this.f = false;
        this.c = new OverScroller(recyclerView.getContext(), bqvVar);
    }

    public final void h(int i, int i2) {
        RecyclerView recyclerView = this.g;
        recyclerView.setScrollState(2);
        this.b = 0;
        this.a = 0;
        Interpolator interpolator = this.d;
        bqv bqvVar = RecyclerView.i;
        if (interpolator != bqvVar) {
            this.d = bqvVar;
            this.c = new OverScroller(recyclerView.getContext(), bqvVar);
        }
        this.c.fling(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        i();
    }

    public final void i() {
        if (this.e) {
            this.f = true;
            return;
        }
        RecyclerView recyclerView = this.g;
        recyclerView.removeCallbacks(this);
        WeakHashMap weakHashMap = eqz.a;
        recyclerView.postOnAnimation(this);
    }

    public final void j(int i, int i2, int i3, Interpolator interpolator) {
        RecyclerView recyclerView = this.g;
        if (i3 == Integer.MIN_VALUE) {
            int iAbs = Math.abs(i);
            int iAbs2 = Math.abs(i2);
            boolean z = iAbs > iAbs2;
            int width = z ? recyclerView.getWidth() : recyclerView.getHeight();
            if (!z) {
                iAbs = iAbs2;
            }
            i3 = Math.min((int) (((iAbs / width) + 1.0f) * 300.0f), 2000);
        }
        int i4 = i3;
        if (interpolator == null) {
            interpolator = RecyclerView.i;
        }
        if (this.d != interpolator) {
            this.d = interpolator;
            this.c = new OverScroller(recyclerView.getContext(), interpolator);
        }
        this.b = 0;
        this.a = 0;
        recyclerView.setScrollState(2);
        this.c.startScroll(0, 0, i, i2, i4);
        i();
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        int i2;
        int i3;
        int i4;
        RecyclerView recyclerView = this.g;
        int[] iArr = recyclerView.ca;
        if (recyclerView.x == null) {
            recyclerView.removeCallbacks(this);
            this.c.abortAnimation();
            return;
        }
        this.f = false;
        this.e = true;
        recyclerView.cz();
        OverScroller overScroller = this.c;
        if (overScroller.computeScrollOffset()) {
            int currX = overScroller.getCurrX();
            int currY = overScroller.getCurrY();
            int i5 = currX - this.a;
            int i6 = currY - this.b;
            this.a = currX;
            this.b = currY;
            int iCq = RecyclerView.cq(i5, recyclerView.as, recyclerView.au, recyclerView.getWidth());
            int iCq2 = RecyclerView.cq(i6, recyclerView.at, recyclerView.av, recyclerView.getHeight());
            int[] iArr2 = recyclerView.ca;
            iArr2[0] = 0;
            iArr2[1] = 0;
            if (recyclerView.df(iArr2, iCq, iCq2, 1, null)) {
                iCq -= iArr[0];
                iCq2 -= iArr[1];
            }
            if (recyclerView.getOverScrollMode() != 2) {
                recyclerView.cy(iCq, iCq2);
            }
            if (recyclerView.w != null) {
                iArr[0] = 0;
                iArr[1] = 0;
                recyclerView.ep(iArr, iCq, iCq2);
                i2 = iArr[0];
                int i7 = iArr[1];
                int i8 = iCq - i2;
                int i9 = iCq2 - i7;
                bvl bvlVar = recyclerView.x.ds;
                if (bvlVar != null && !bvlVar.i && bvlVar.j) {
                    int iP = recyclerView.bo.p();
                    if (iP == 0) {
                        bvlVar.z();
                    } else if (bvlVar.f >= iP) {
                        bvlVar.f = iP - 1;
                        bvlVar.x(i2, i7);
                    } else {
                        bvlVar.x(i2, i7);
                    }
                }
                i3 = i8;
                i4 = i7;
                i = i9;
            } else {
                i = iCq2;
                i2 = 0;
                i3 = iCq;
                i4 = 0;
            }
            if (!recyclerView.z.isEmpty()) {
                recyclerView.invalidate();
            }
            int[] iArr3 = recyclerView.ca;
            iArr3[0] = 0;
            iArr3[1] = 0;
            recyclerView.dg(i2, i4, i3, i, null, 1, iArr3);
            int i10 = i3 - iArr[0];
            int i11 = i - iArr[1];
            if (i2 != 0 || i4 != 0) {
                recyclerView.dh(i2, i4);
            }
            if (!recyclerView.awakenScrollBars()) {
                recyclerView.invalidate();
            }
            boolean z = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i10 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i11 != 0));
            bvl bvlVar2 = recyclerView.x.ds;
            if ((bvlVar2 == null || !bvlVar2.i) && z) {
                if (recyclerView.getOverScrollMode() != 2) {
                    int currVelocity = (int) overScroller.getCurrVelocity();
                    int i12 = i10 < 0 ? -currVelocity : i10 > 0 ? currVelocity : 0;
                    if (i11 < 0) {
                        currVelocity = -currVelocity;
                    } else if (i11 <= 0) {
                        currVelocity = 0;
                    }
                    if (i12 < 0) {
                        recyclerView.dj();
                        if (recyclerView.as.isFinished()) {
                            recyclerView.as.onAbsorb(-i12);
                        }
                    } else if (i12 > 0) {
                        recyclerView.dk();
                        if (recyclerView.au.isFinished()) {
                            recyclerView.au.onAbsorb(i12);
                        }
                    }
                    if (currVelocity < 0) {
                        recyclerView.dl();
                        if (recyclerView.at.isFinished()) {
                            recyclerView.at.onAbsorb(-currVelocity);
                        }
                    } else if (currVelocity > 0) {
                        recyclerView.di();
                        if (recyclerView.av.isFinished()) {
                            recyclerView.av.onAbsorb(currVelocity);
                        }
                    }
                    if (i12 != 0 || currVelocity != 0) {
                        recyclerView.postInvalidateOnAnimation();
                    }
                }
                if (RecyclerView.g) {
                    bpq bpqVar = recyclerView.bn;
                    int[] iArr4 = (int[]) bpqVar.e;
                    if (iArr4 != null) {
                        Arrays.fill(iArr4, -1);
                    }
                    bpqVar.d = 0;
                }
            } else {
                i();
                bgv bgvVar = recyclerView.bm;
                if (bgvVar != null) {
                    bgvVar.h(recyclerView, i2, i4);
                }
            }
            if (Build.VERSION.SDK_INT >= 35) {
                cyz.a(recyclerView, Math.abs(overScroller.getCurrVelocity()));
            }
        }
        bvl bvlVar3 = recyclerView.x.ds;
        if (bvlVar3 != null && bvlVar3.i) {
            bvlVar3.x(0, 0);
        }
        this.e = false;
        if (!this.f) {
            recyclerView.setScrollState(0);
            recyclerView.ex(1);
        } else {
            recyclerView.removeCallbacks(this);
            WeakHashMap weakHashMap = eqz.a;
            recyclerView.postOnAnimation(this);
        }
    }
}
