package me.hd.wauxv.obf;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dfd extends czl {
    public aco a;
    public final ViewPager2 c;
    public final esd d;
    public final LinearLayoutManager f;
    public int g;
    public int h;
    public final dfc i;
    public int j;
    public int k;
    public boolean l;
    public boolean m;
    public boolean n;

    public dfd(ViewPager2 viewPager2) {
        this.c = viewPager2;
        esd esdVar = viewPager2.j;
        this.d = esdVar;
        this.f = (LinearLayoutManager) esdVar.getLayoutManager();
        this.i = new dfc();
        q();
    }

    /* JADX WARN: Found duplicated region for block: B:15:0x002a  */
    /* JADX WARN: Found duplicated region for block: B:17:0x002e  */
    @Override // me.hd.wauxv.obf.czl
    public final void b(RecyclerView recyclerView, int i, int i2) {
        int i3;
        this.m = true;
        r();
        boolean z = this.l;
        dfc dfcVar = this.i;
        if (z) {
            this.l = false;
            if (i2 > 0) {
                i3 = dfcVar.c != 0 ? dfcVar.a + 1 : dfcVar.a;
            } else {
                if (i2 == 0) {
                    if ((i < 0) == (this.c.g.dp.getLayoutDirection() == 1)) {
                        if (dfcVar.c != 0) {
                        }
                    }
                }
            }
            this.k = i3;
            if (this.j != i3) {
                o(i3);
            }
        } else if (this.g == 0) {
            int i4 = dfcVar.a;
            if (i4 == -1) {
                i4 = 0;
            }
            o(i4);
        }
        int i5 = dfcVar.a;
        if (i5 == -1) {
            i5 = 0;
        }
        float f = dfcVar.b;
        int i6 = dfcVar.c;
        aco acoVar = this.a;
        if (acoVar != null) {
            acoVar.d(i5, f, i6);
        }
        int i7 = dfcVar.a;
        int i8 = this.k;
        if ((i7 == i8 || i8 == -1) && dfcVar.c == 0 && this.h != 1) {
            p(0);
            q();
        }
    }

    @Override // me.hd.wauxv.obf.czl
    public final void e(RecyclerView recyclerView, int i) {
        aco acoVar;
        int i2 = this.g;
        if (!(i2 == 1 && this.h == 1) && i == 1) {
            this.g = 1;
            int i3 = this.k;
            if (i3 != -1) {
                this.j = i3;
                this.k = -1;
            } else if (this.j == -1) {
                this.j = this.f.ct();
            }
            p(1);
            return;
        }
        if ((i2 == 1 || i2 == 4) && i == 2) {
            if (this.m) {
                p(2);
                this.l = true;
                return;
            }
            return;
        }
        dfc dfcVar = this.i;
        if ((i2 == 1 || i2 == 4) && i == 0) {
            r();
            if (!this.m) {
                int i4 = dfcVar.a;
                if (i4 != -1 && (acoVar = this.a) != null) {
                    acoVar.d(i4, 0.0f, 0);
                }
            } else if (dfcVar.c == 0) {
                int i5 = this.j;
                int i6 = dfcVar.a;
                if (i5 != i6) {
                    o(i6);
                }
            }
            p(0);
            q();
        }
        if (this.g == 2 && i == 0 && this.n) {
            r();
            if (dfcVar.c == 0) {
                int i7 = this.k;
                int i8 = dfcVar.a;
                if (i7 != i8) {
                    if (i8 == -1) {
                        i8 = 0;
                    }
                    o(i8);
                }
                p(0);
                q();
            }
        }
    }

    public final void o(int i) {
        aco acoVar = this.a;
        if (acoVar != null) {
            acoVar.e(i);
        }
    }

    public final void p(int i) {
        if ((this.g == 3 && this.h == 0) || this.h == i) {
            return;
        }
        this.h = i;
        aco acoVar = this.a;
        if (acoVar != null) {
            acoVar.c(i);
        }
    }

    public final void q() {
        this.g = 0;
        this.h = 0;
        dfc dfcVar = this.i;
        dfcVar.a = -1;
        dfcVar.b = 0.0f;
        dfcVar.c = 0;
        this.j = -1;
        this.k = -1;
        this.l = false;
        this.m = false;
        this.n = false;
    }

    /* JADX WARN: Found duplicated region for block: B:61:0x0134  */
    /* JADX WARN: Found duplicated region for block: B:65:0x0140  */
    /* JADX WARN: Found duplicated region for block: B:67:0x014a A[LOOP:2: B:64:0x013e->B:67:0x014a, LOOP_END] */
    /* JADX WARN: Found duplicated region for block: B:82:0x014d A[SYNTHETIC] */
    public final void r() {
        int top;
        int iEs;
        int top2;
        int i;
        int bottom;
        int i2;
        LinearLayoutManager linearLayoutManager = this.f;
        int iCt = linearLayoutManager.ct();
        dfc dfcVar = this.i;
        dfcVar.a = iCt;
        if (iCt == -1) {
            dfcVar.a = -1;
            dfcVar.b = 0.0f;
            dfcVar.c = 0;
            return;
        }
        View viewCa = linearLayoutManager.ca(iCt);
        if (viewCa == null) {
            dfcVar.a = -1;
            dfcVar.b = 0.0f;
            dfcVar.c = 0;
            return;
        }
        int i3 = ((czh) viewCa.getLayoutParams()).d.left;
        int i4 = ((czh) viewCa.getLayoutParams()).d.right;
        int i5 = ((czh) viewCa.getLayoutParams()).d.top;
        int i6 = ((czh) viewCa.getLayoutParams()).d.bottom;
        ViewGroup.LayoutParams layoutParams = viewCa.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            i3 += marginLayoutParams.leftMargin;
            i4 += marginLayoutParams.rightMargin;
            i5 += marginLayoutParams.topMargin;
            i6 += marginLayoutParams.bottomMargin;
        }
        int height = viewCa.getHeight() + i5 + i6;
        int width = viewCa.getWidth() + i3 + i4;
        int i7 = linearLayoutManager.bd;
        esd esdVar = this.d;
        if (i7 == 0) {
            top = (viewCa.getLeft() - i3) - esdVar.getPaddingLeft();
            if (this.c.g.dp.getLayoutDirection() == 1) {
                top = -top;
            }
            height = width;
        } else {
            top = (viewCa.getTop() - i5) - esdVar.getPaddingTop();
        }
        int i8 = -top;
        dfcVar.c = i8;
        if (i8 >= 0) {
            dfcVar.b = height != 0 ? i8 / height : 0.0f;
            return;
        }
        int iEs2 = linearLayoutManager.es();
        if (iEs2 != 0) {
            boolean z = linearLayoutManager.bd == 0;
            int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, iEs2, 2);
            for (int i9 = 0; i9 < iEs2; i9++) {
                View viewEr = linearLayoutManager.er(i9);
                if (viewEr == null) {
                    throw new IllegalStateException("null view contained in the view hierarchy");
                }
                ViewGroup.LayoutParams layoutParams2 = viewEr.getLayoutParams();
                ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : ey.a;
                int[] iArr2 = iArr[i9];
                if (z) {
                    top2 = viewEr.getLeft();
                    i = marginLayoutParams2.leftMargin;
                } else {
                    top2 = viewEr.getTop();
                    i = marginLayoutParams2.topMargin;
                }
                iArr2[0] = top2 - i;
                int[] iArr3 = iArr[i9];
                if (z) {
                    bottom = viewEr.getRight();
                    i2 = marginLayoutParams2.rightMargin;
                } else {
                    bottom = viewEr.getBottom();
                    i2 = marginLayoutParams2.bottomMargin;
                }
                iArr3[1] = bottom + i2;
            }
            Arrays.sort(iArr, new ex(0));
            int i10 = 1;
            while (true) {
                if (i10 >= iEs2) {
                    int[] iArr4 = iArr[0];
                    int i11 = iArr4[1];
                    int i12 = iArr4[0];
                    int i13 = i11 - i12;
                    if (i12 <= 0 && iArr[iEs2 - 1][1] >= i13) {
                        if (linearLayoutManager.es() <= 1) {
                        }
                    }
                } else if (iArr[i10 - 1][1] == iArr[i10][0]) {
                    i10++;
                }
                iEs = linearLayoutManager.es();
                for (int i14 = 0; i14 < iEs; i14++) {
                    if (!ey.b(linearLayoutManager.er(i14))) {
                        throw new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
                    }
                }
            }
        } else if (linearLayoutManager.es() <= 1) {
            iEs = linearLayoutManager.es();
            while (i14 < iEs) {
                if (!ey.b(linearLayoutManager.er(i14))) {
                    throw new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
                }
            }
        }
        Locale locale = Locale.US;
        throw new IllegalStateException(bjs.i(dfcVar.c, "Page can only be offset by a positive amount, not by "));
    }
}
