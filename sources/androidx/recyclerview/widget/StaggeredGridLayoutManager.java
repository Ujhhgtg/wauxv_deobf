package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.WeakHashMap;
import me.hd.wauxv.obf.atb;
import me.hd.wauxv.obf.LateinitProperty;
import me.hd.wauxv.obf.bd;
import me.hd.wauxv.obf.bpq;
import me.hd.wauxv.obf.bts;
import me.hd.wauxv.obf.but;
import me.hd.wauxv.obf.bvl;
import me.hd.wauxv.obf.byj;
import me.hd.wauxv.obf.HugeSyntheticPileOfHelpers;
import me.hd.wauxv.obf.cyw;
import me.hd.wauxv.obf.czf;
import me.hd.wauxv.obf.czg;
import me.hd.wauxv.obf.czh;
import me.hd.wauxv.obf.RecyclerView;
import me.hd.wauxv.obf.czs;
import me.hd.wauxv.obf.czt;
import me.hd.wauxv.obf.dc;
import me.hd.wauxv.obf.StaticHelpers6;
import me.hd.wauxv.obf.dma;
import me.hd.wauxv.obf.dmb;
import me.hd.wauxv.obf.dmc;
import me.hd.wauxv.obf.dmd;
import me.hd.wauxv.obf.ViewCompat;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class StaggeredGridLayoutManager extends czg implements czs {
    public final int a;
    public final but al;
    public final int am;
    public boolean an;
    public boolean ao;
    public dmd ap;
    public int aq;
    public final Rect ar;
    public final dma as;
    public boolean at;
    public final boolean au;
    public int[] av;
    public final dc aw;
    public final byj[] b;
    public final atb c;
    public final atb d;
    public final int e;
    public int f;
    public final bts g;
    public boolean h;
    public final BitSet j;
    public boolean i = false;
    public int k = -1;
    public int l = Integer.MIN_VALUE;

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.a = -1;
        this.h = false;
        but butVar = new but(13);
        this.al = butVar;
        this.am = 2;
        this.ar = new Rect();
        this.as = new dma(this);
        this.at = false;
        this.au = true;
        this.aw = new dc(this, 16);
        czf czfVarEm = czg.em(context, attributeSet, i, i2);
        int i3 = czfVarEm.a;
        if (i3 != 0 && i3 != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        bt(null);
        if (i3 != this.e) {
            this.e = i3;
            atb atbVar = this.c;
            this.c = this.d;
            this.d = atbVar;
            ff();
        }
        int i4 = czfVarEm.b;
        bt(null);
        if (i4 != this.a) {
            butVar.f();
            ff();
            this.a = i4;
            this.j = new BitSet(this.a);
            this.b = new byj[this.a];
            for (int i5 = 0; i5 < this.a; i5++) {
                this.b[i5] = new byj(this, i5);
            }
            ff();
        }
        boolean z = czfVarEm.c;
        bt(null);
        dmd dmdVar = this.ap;
        if (dmdVar != null && dmdVar.h != z) {
            dmdVar.h = z;
        }
        this.h = z;
        ff();
        bts btsVar = new bts();
        btsVar.a = true;
        btsVar.f = 0;
        btsVar.g = 0;
        this.g = btsVar;
        this.c = atb.d(this, this.e);
        this.d = atb.d(this, 1 - this.e);
    }

    public static int ax(int i, int i2, int i3) {
        int mode;
        return (!(i2 == 0 && i3 == 0)
                && ((mode = View.MeasureSpec.getMode(i)) == Integer.MIN_VALUE || mode == 1073741824))
                        ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i) - i2) - i3), mode)
                        : i;
    }

    @Override // me.hd.wauxv.obf.czg
    public final void aa() {
        this.al.f();
        ff();
    }

    @Override // me.hd.wauxv.obf.czg
    public final void ab(int i, int i2) {
        bn(i, i2, 8);
    }

    @Override // me.hd.wauxv.obf.czg
    public final void ac(int i, int i2) {
        bn(i, i2, 2);
    }

    @Override // me.hd.wauxv.obf.czg
    public final void ad(int i, int i2) {
        bn(i, i2, 4);
    }

    @Override // me.hd.wauxv.obf.czg
    public final void ae(RecyclerView recyclerViewVar, czt cztVar) {
        br(recyclerViewVar, cztVar, true);
    }

    @Override // me.hd.wauxv.obf.czg
    public final void af(czt cztVar) {
        this.k = -1;
        this.l = Integer.MIN_VALUE;
        this.ap = null;
        this.as.h();
    }

    @Override // me.hd.wauxv.obf.czg
    public final int ah(int i, RecyclerView recyclerViewVar, czt cztVar) {
        return cq(i, recyclerViewVar, cztVar);
    }

    @Override // me.hd.wauxv.obf.czg
    public final int ai(int i, RecyclerView recyclerViewVar, czt cztVar) {
        return cq(i, recyclerViewVar, cztVar);
    }

    @Override // me.hd.wauxv.obf.czg
    public final void aj(Rect rect, int i, int i2) {
        int iEd;
        int iEd2;
        int iEw = ew() + ev();
        int iEu = eu() + ex();
        int i3 = this.e;
        int i4 = this.a;
        if (i3 == 1) {
            int iHeight = rect.height() + iEu;
            androidx.recyclerview.widget.RecyclerView recyclerView = this.dp;
            WeakHashMap weakHashMap = ViewCompat.a;
            iEd2 = czg.ed(i2, iHeight, recyclerView.getMinimumHeight());
            iEd = czg.ed(i, (this.f * i4) + iEw, this.dp.getMinimumWidth());
        } else {
            int iWidth = rect.width() + iEw;
            androidx.recyclerview.widget.RecyclerView recyclerView2 = this.dp;
            WeakHashMap weakHashMap2 = ViewCompat.a;
            iEd = czg.ed(i, iWidth, recyclerView2.getMinimumWidth());
            iEd2 = czg.ed(i2, (this.f * i4) + iEu, this.dp.getMinimumHeight());
        }
        this.dp.setMeasuredDimension(iEd, iEd2);
    }

    @Override // me.hd.wauxv.obf.czg
    public final boolean ak() {
        return this.ap == null;
    }

    @Override // me.hd.wauxv.obf.czg
    public final void ay(int i) {
        super.ay(i);
        for (int i2 = 0; i2 < this.a; i2++) {
            byj byjVar = this.b[i2];
            int i3 = byjVar.b;
            if (i3 != Integer.MIN_VALUE) {
                byjVar.b = i3 + i;
            }
            int i4 = byjVar.c;
            if (i4 != Integer.MIN_VALUE) {
                byjVar.c = i4 + i;
            }
        }
    }

    @Override // me.hd.wauxv.obf.czg
    public final void az(int i) {
        super.az(i);
        for (int i2 = 0; i2 < this.a; i2++) {
            byj byjVar = this.b[i2];
            int i3 = byjVar.b;
            if (i3 != Integer.MIN_VALUE) {
                byjVar.b = i3 + i;
            }
            int i4 = byjVar.c;
            if (i4 != Integer.MIN_VALUE) {
                byjVar.c = i4 + i;
            }
        }
    }

    @Override // me.hd.wauxv.obf.czg
    public final void ba(cyw cywVar) {
        this.al.f();
        for (int i = 0; i < this.a; i++) {
            this.b[i].k();
        }
    }

    @Override // me.hd.wauxv.obf.czg
    public final void bb(int i) {
        if (i == 0) {
            bc();
        }
    }

    public final boolean bc() {
        int iBj;
        int iBk;
        if (es() != 0 && this.am != 0 && this.du) {
            if (this.i) {
                iBj = bk();
                iBk = bj();
            } else {
                iBj = bj();
                iBk = bk();
            }
            but butVar = this.al;
            if (iBj == 0 && bo() != null) {
                butVar.f();
                this.dt = true;
                ff();
                return true;
            }
            if (this.at) {
                int i = this.i ? -1 : 1;
                int i2 = iBk + 1;
                dmc dmcVarO = butVar.o(iBj, i2, i);
                if (dmcVarO == null) {
                    this.at = false;
                    butVar.m(i2);
                    return false;
                }
                dmc dmcVarO2 = butVar.o(iBj, dmcVarO.a, i * (-1));
                if (dmcVarO2 == null) {
                    butVar.m(dmcVarO.a);
                } else {
                    butVar.m(dmcVarO2.a + 1);
                }
                this.dt = true;
                ff();
                return true;
            }
        }
        return false;
    }

    public final int bd(czt cztVar) {
        if (es() == 0) {
            return 0;
        }
        boolean z = !this.au;
        return HugeSyntheticPileOfHelpers.av(cztVar, this.c, bg(z), bf(z), this, this.au, this.i);
    }

    /* JADX WARN: Found duplicated region for block: B:138:0x02a0 */
    /* JADX WARN: Found duplicated region for block: B:140:0x02a4 */
    /*
     * JADX WARN: Found duplicated region for block: B:142:0x02a9 A[LOOP:2:
     * B:141:0x02a7->B:142:0x02a9, LOOP_END]
     */
    /* JADX WARN: Found duplicated region for block: B:143:0x02b3 */
    /* JADX WARN: Found duplicated region for block: B:144:0x02b9 */
    /* JADX WARN: Found duplicated region for block: B:146:0x02bd */
    /*
     * JADX WARN: Found duplicated region for block: B:148:0x02c5 A[LOOP:3:
     * B:147:0x02c3->B:148:0x02c5, LOOP_END]
     */
    /* JADX WARN: Found duplicated region for block: B:149:0x02cf */
    /* JADX WARN: Found duplicated region for block: B:159:0x0303 */
    /* JADX WARN: Found duplicated region for block: B:161:0x0307 */
    /* JADX WARN: Found duplicated region for block: B:162:0x030f */
    /* JADX WARN: Found duplicated region for block: B:166:0x0327 */
    /* JADX WARN: Found duplicated region for block: B:167:0x032b */
    /* JADX WARN: Found duplicated region for block: B:170:0x0332 */
    /* JADX WARN: Found duplicated region for block: B:172:0x033a */
    public final int be(RecyclerView recyclerViewVar, bts btsVar, czt cztVar) {
        byj byjVar;
        int i;
        int iBm;
        int iF;
        int i2;
        int i3;
        int iN;
        int iF2;
        int i4;
        boolean z;
        int i5;
        int i6;
        int i7;
        RecyclerView recyclerViewVar2 = recyclerViewVar;
        int i8 = 0;
        int i9 = 1;
        this.j.set(0, this.a, true);
        bts btsVar2 = this.g;
        int i10 = btsVar2.i ? btsVar.e == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE
                : btsVar.e == 1 ? btsVar.g + btsVar.b : btsVar.f - btsVar.b;
        cs(btsVar.e, i10);
        int iJ = this.i ? this.c.j() : this.c.n();
        boolean z2 = false;
        while (true) {
            int i11 = btsVar.c;
            if (i11 < 0 || i11 >= cztVar.p() || (!btsVar2.i && this.j.isEmpty())) {
                break;
            }
            View view = recyclerViewVar2.s(btsVar.c, Long.MAX_VALUE).d;
            btsVar.c += btsVar.d;
            dmb dmbVar = (dmb) view.getLayoutParams();
            int iZ = dmbVar.c.z();
            but butVar = this.al;
            int[] iArr = (int[]) butVar.b;
            int i12 = (iArr == null || iZ >= iArr.length) ? -1 : iArr[iZ];
            int i13 = i12 == -1 ? i9 : i8;
            if (i13 != 0) {
                if (dmbVar.b) {
                    byjVar = this.b[i8];
                } else {
                    if (ck(btsVar.e)) {
                        i7 = this.a - i9;
                        i6 = -1;
                        i5 = -1;
                    } else {
                        i5 = i9;
                        i6 = this.a;
                        i7 = i8;
                    }
                    byj byjVar2 = null;
                    if (btsVar.e == i9) {
                        int iN2 = this.c.n();
                        int i14 = Integer.MAX_VALUE;
                        while (i7 != i6) {
                            byj byjVar3 = this.b[i7];
                            int i15 = i7;
                            int iP = byjVar3.p(iN2);
                            if (iP < i14) {
                                byjVar2 = byjVar3;
                                i14 = iP;
                            }
                            i7 = i15 + i5;
                        }
                    } else {
                        int iJ2 = this.c.j();
                        int i16 = Integer.MIN_VALUE;
                        while (i7 != i6) {
                            byj byjVar4 = this.b[i7];
                            int i17 = i7;
                            int iR = byjVar4.r(iJ2);
                            if (iR > i16) {
                                i16 = iR;
                                byjVar2 = byjVar4;
                            }
                            i7 = i17 + i5;
                        }
                    }
                    byjVar = byjVar2;
                }
                butVar.i(iZ);
                ((int[]) butVar.b)[iZ] = byjVar.e;
            } else {
                byjVar = this.b[i12];
            }
            dmbVar.a = byjVar;
            if (btsVar.e == 1) {
                ep(view, -1, false);
            } else {
                ep(view, 0, false);
            }
            if (!dmbVar.b) {
                i = i13;
                if (this.e == 1) {
                    bq(view, czg.ee(this.f, this.dz, 0, ((ViewGroup.MarginLayoutParams) dmbVar).width, false), czg
                            .ee(this.ec, this.ea, eu() + ex(), ((ViewGroup.MarginLayoutParams) dmbVar).height, true));
                } else {
                    bq(view, czg.ee(this.eb, this.dz, ew() + ev(), ((ViewGroup.MarginLayoutParams) dmbVar).width, true),
                            czg.ee(this.f, this.ea, 0, ((ViewGroup.MarginLayoutParams) dmbVar).height, false));
                }
            } else if (this.e == 1) {
                i = i13;
                bq(view, this.aq,
                        czg.ee(this.ec, this.ea, eu() + ex(), ((ViewGroup.MarginLayoutParams) dmbVar).height, true));
            } else {
                i = i13;
                bq(view, czg.ee(this.eb, this.dz, ew() + ev(), ((ViewGroup.MarginLayoutParams) dmbVar).width, true),
                        this.aq);
            }
            if (btsVar.e == 1) {
                iF = dmbVar.b ? bl(iJ) : byjVar.p(iJ);
                iBm = this.c.f(view) + iF;
                if (i != 0 && dmbVar.b) {
                    dmc dmcVar = new dmc();
                    dmcVar.c = new int[this.a];
                    for (int i18 = 0; i18 < this.a; i18++) {
                        dmcVar.c[i18] = iF - this.b[i18].p(iF);
                    }
                    dmcVar.b = -1;
                    dmcVar.a = iZ;
                    butVar.d(dmcVar);
                }
            } else {
                iBm = dmbVar.b ? bm(iJ) : byjVar.r(iJ);
                iF = iBm - this.c.f(view);
                if (i != 0 && dmbVar.b) {
                    dmc dmcVar2 = new dmc();
                    dmcVar2.c = new int[this.a];
                    for (int i19 = 0; i19 < this.a; i19++) {
                        dmcVar2.c[i19] = this.b[i19].r(iBm) - iBm;
                    }
                    dmcVar2.b = 1;
                    dmcVar2.a = iZ;
                    butVar.d(dmcVar2);
                }
            }
            if (dmbVar.b && btsVar.d == -1) {
                if (i != 0) {
                    i2 = 1;
                    this.at = true;
                } else {
                    if (btsVar.e != 1) {
                        int iR2 = this.b[0].r(Integer.MIN_VALUE);
                        int i20 = 1;
                        while (true) {
                            if (i20 >= this.a) {
                                z = true;
                                break;
                            }
                            if (this.b[i20].r(Integer.MIN_VALUE) != iR2) {
                                z = false;
                                break;
                            }
                            i20++;
                        }
                    } else {
                        int iP2 = this.b[0].p(Integer.MIN_VALUE);
                        int i21 = 1;
                        while (true) {
                            if (i21 >= this.a) {
                                z = true;
                                break;
                            }
                            if (this.b[i21].p(Integer.MIN_VALUE) != iP2) {
                                z = false;
                                break;
                            }
                            i21++;
                        }
                    }
                    i2 = 1;
                    if (!z) {
                        dmc dmcVarP = butVar.p(iZ);
                        if (dmcVarP != null) {
                            dmcVarP.d = true;
                        }
                        this.at = true;
                    }
                }
                if (btsVar.e == i2) {
                    if (dmbVar.b) {
                        for (i4 = this.a - i2; i4 >= 0; i4--) {
                            this.b[i4].dexFind(view);
                        }
                    } else {
                        dmbVar.a.dexFind(view);
                    }
                } else if (dmbVar.b) {
                    for (i3 = this.a - 1; i3 >= 0; i3--) {
                        this.b[i3].u(view);
                    }
                } else {
                    dmbVar.a.u(view);
                }
                if (bp() || this.e != 1) {
                    iN = dmbVar.b ? this.d.n() : this.d.n() + (byjVar.e * this.f);
                    iF2 = this.d.f(view) + iN;
                } else {
                    iF2 = dmbVar.b ? this.d.j() : this.d.j() - (((this.a - 1) - byjVar.e) * this.f);
                    iN = iF2 - this.d.f(view);
                }
                if (this.e == 1) {
                    czg.eo(view, iN, iF, iF2, iBm);
                } else {
                    czg.eo(view, iF, iN, iBm, iF2);
                }
                if (dmbVar.b) {
                    cs(btsVar2.e, i10);
                } else {
                    cu(byjVar, btsVar2.e, i10);
                }
                recyclerViewVar2 = recyclerViewVar;
                cm(recyclerViewVar2, btsVar2);
                if (!btsVar2.h && view.hasFocusable()) {
                    if (dmbVar.b) {
                        this.j.clear();
                    } else {
                        this.j.set(byjVar.e, false);
                    }
                }
                i9 = 1;
                z2 = true;
                i8 = 0;
            } else {
                i2 = 1;
            }
            if (btsVar.e == i2) {
                if (dmbVar.b) {
                    while (i4 >= 0) {
                        this.b[i4].dexFind(view);
                    }
                } else {
                    dmbVar.a.dexFind(view);
                }
            } else if (dmbVar.b) {
                while (i3 >= 0) {
                    this.b[i3].u(view);
                }
            } else {
                dmbVar.a.u(view);
            }
            if (bp()) {
                if (dmbVar.b) {
                }
                iF2 = this.d.f(view) + iN;
            } else {
                if (dmbVar.b) {
                }
                iF2 = this.d.f(view) + iN;
            }
            if (this.e == 1) {
                czg.eo(view, iN, iF, iF2, iBm);
            } else {
                czg.eo(view, iF, iN, iBm, iF2);
            }
            if (dmbVar.b) {
                cs(btsVar2.e, i10);
            } else {
                cu(byjVar, btsVar2.e, i10);
            }
            recyclerViewVar2 = recyclerViewVar;
            cm(recyclerViewVar2, btsVar2);
            if (!btsVar2.h) {
            }
            i9 = 1;
            z2 = true;
            i8 = 0;
        }
        if (!z2) {
            cm(recyclerViewVar2, btsVar2);
        }
        int iN3 = btsVar2.e == -1 ? this.c.n() - bm(this.c.n()) : bl(this.c.j()) - this.c.j();
        if (iN3 > 0) {
            return Math.min(btsVar.b, iN3);
        }
        return 0;
    }

    public final View bf(boolean z) {
        int iN = this.c.n();
        int iJ = this.c.j();
        View view = null;
        for (int iEs = es() - 1; iEs >= 0; iEs--) {
            View viewEr = er(iEs);
            int iH = this.c.dexFind(viewEr);
            int iE = this.c.e(viewEr);
            if (iE > iN && iH < iJ) {
                if (iE <= iJ || !z) {
                    return viewEr;
                }
                if (view == null) {
                    view = viewEr;
                }
            }
        }
        return view;
    }

    public final View bg(boolean z) {
        int iN = this.c.n();
        int iJ = this.c.j();
        int iEs = es();
        View view = null;
        for (int i = 0; i < iEs; i++) {
            View viewEr = er(i);
            int iH = this.c.dexFind(viewEr);
            if (this.c.e(viewEr) > iN && iH < iJ) {
                if (iH >= iN || !z) {
                    return viewEr;
                }
                if (view == null) {
                    view = viewEr;
                }
            }
        }
        return view;
    }

    public final void bh(RecyclerView recyclerViewVar, czt cztVar, boolean z) {
        int iJ;
        int iBl = bl(Integer.MIN_VALUE);
        if (iBl != Integer.MIN_VALUE && (iJ = this.c.j() - iBl) > 0) {
            int i = iJ - (-cq(-iJ, recyclerViewVar, cztVar));
            if (!z || i <= 0) {
                return;
            }
            this.c.r(i);
        }
    }

    public final void bi(RecyclerView recyclerViewVar, czt cztVar, boolean z) {
        int iN;
        int iBm = bm(Integer.MAX_VALUE);
        if (iBm != Integer.MAX_VALUE && (iN = iBm - this.c.n()) > 0) {
            int iCq = iN - cq(iN, recyclerViewVar, cztVar);
            if (!z || iCq <= 0) {
                return;
            }
            this.c.r(-iCq);
        }
    }

    public final int bj() {
        if (es() == 0) {
            return 0;
        }
        return czg.el(er(0));
    }

    public final int bk() {
        int iEs = es();
        if (iEs == 0) {
            return 0;
        }
        return czg.el(er(iEs - 1));
    }

    public final int bl(int i) {
        int iP = this.b[0].p(i);
        for (int i2 = 1; i2 < this.a; i2++) {
            int iP2 = this.b[i2].p(i);
            if (iP2 > iP) {
                iP = iP2;
            }
        }
        return iP;
    }

    public final int bm(int i) {
        int iR = this.b[0].r(i);
        for (int i2 = 1; i2 < this.a; i2++) {
            int iR2 = this.b[i2].r(i);
            if (iR2 < iR) {
                iR = iR2;
            }
        }
        return iR;
    }

    /* JADX WARN: Found duplicated region for block: B:15:0x0026 */
    /* JADX WARN: Found duplicated region for block: B:17:0x0029 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:19:0x002c */
    /* JADX WARN: Found duplicated region for block: B:20:0x0033 */
    /* JADX WARN: Found duplicated region for block: B:21:0x0037 */
    /* JADX WARN: Found duplicated region for block: B:24:0x003d */
    /* JADX WARN: Found duplicated region for block: B:26:0x0041 */
    /* JADX WARN: Found duplicated region for block: B:27:0x0046 */
    /* JADX WARN: Found duplicated region for block: B:29:0x004c */
    /* JADX WARN: Found duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    public final void bn(int i, int i2, int i3) {
        int i4;
        int i5;
        but butVar;
        int iBk = this.i ? bk() : bj();
        if (i3 == 8) {
            if (i < i2) {
                i4 = i2 + 1;
            } else {
                i4 = i + 1;
                i5 = i2;
            }
            butVar = this.al;
            butVar.u(i5);
            if (i3 != 1) {
                butVar.y(i, i2);
            } else if (i3 != 2) {
                butVar.z(i, i2);
            } else if (i3 == 8) {
                butVar.z(i, 1);
                butVar.y(i2, 1);
            }
            if (i4 <= iBk) {
                return;
            }
            if (i5 <= (this.i ? bj() : bk())) {
                ff();
            }
        }
        i4 = i + i2;
        i5 = i;
        butVar = this.al;
        butVar.u(i5);
        if (i3 != 1) {
            butVar.y(i, i2);
        } else if (i3 != 2) {
            butVar.z(i, i2);
        } else if (i3 == 8) {
            butVar.z(i, 1);
            butVar.y(i2, 1);
        }
        if (i4 <= iBk) {
            return;
        }
        if (i5 <= (this.i ? bj() : bk())) {
            ff();
        }
    }

    /* JADX WARN: Found duplicated region for block: B:34:0x0095 */
    /* JADX WARN: Found duplicated region for block: B:45:0x00b2 */
    /* JADX WARN: Found duplicated region for block: B:48:0x00c1 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:50:0x00c4 */
    /* JADX WARN: Found duplicated region for block: B:53:0x00d3 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:54:0x00d5 */
    /* JADX WARN: Found duplicated region for block: B:55:0x00d7 */
    /* JADX WARN: Found duplicated region for block: B:57:0x00da */
    /* JADX WARN: Found duplicated region for block: B:59:0x00eb */
    /* JADX WARN: Found duplicated region for block: B:60:0x00ed */
    /* JADX WARN: Found duplicated region for block: B:62:0x00f0 */
    /* JADX WARN: Found duplicated region for block: B:63:0x00f2 */
    /* JADX WARN: Found duplicated region for block: B:69:0x00f5 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:72:0x00f5 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:73:0x00f5 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:75:0x00f6 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:76:0x00f6 A[SYNTHETIC] */
    public final View bo() {
        int i;
        View viewEr;
        int iH;
        int iH2;
        boolean z;
        int iE;
        int iE2;
        boolean z2;
        boolean z3;
        int iEs = es();
        int i2 = iEs - 1;
        BitSet bitSet = new BitSet(this.a);
        bitSet.set(0, this.a, true);
        byte b = (this.e == 1 && bp()) ? (byte) 1 : (byte) -1;
        if (this.i) {
            iEs = -1;
        } else {
            i2 = 0;
        }
        int i3 = i2 < iEs ? 1 : -1;
        while (i2 != iEs) {
            View viewEr2 = er(i2);
            dmb dmbVar = (dmb) viewEr2.getLayoutParams();
            if (bitSet.get(dmbVar.a.e)) {
                byj byjVar = dmbVar.a;
                if (this.i) {
                    int i4 = byjVar.c;
                    if (i4 == Integer.MIN_VALUE) {
                        byjVar.i();
                        i4 = byjVar.c;
                    }
                    if (i4 < this.c.j()) {
                        z2 = ((dmb) ((View) StaticHelpers6.getLastNElem(1, (ArrayList) byjVar.f)).getLayoutParams()).b;
                        z3 = !z2;
                    } else {
                        z3 = false;
                    }
                } else {
                    int i5 = byjVar.b;
                    if (i5 == Integer.MIN_VALUE) {
                        byjVar.j();
                        i5 = byjVar.b;
                    }
                    if (i5 > this.c.n()) {
                        z2 = ((dmb) ((View) ((ArrayList) byjVar.f).get(0)).getLayoutParams()).b;
                        z3 = !z2;
                    } else {
                        z3 = false;
                    }
                }
                if (!z3) {
                    bitSet.clear(dmbVar.a.e);
                    if (!dmbVar.b && (i = i2 + i3) != iEs) {
                        viewEr = er(i);
                        if (this.i) {
                            iE = this.c.e(viewEr2);
                            iE2 = this.c.e(viewEr);
                            if (iE >= iE2) {
                                z = iE == iE2;
                                if (z) {
                                    if ((dmbVar.a.e - ((dmb) viewEr.getLayoutParams()).a.e < 0) != (b < 0)) {
                                    }
                                } else {
                                    continue;
                                }
                            }
                        } else {
                            iH = this.c.dexFind(viewEr2);
                            iH2 = this.c.dexFind(viewEr);
                            if (iH <= iH2) {
                                if (iH == iH2) {
                                }
                                if (z) {
                                    if ((dmbVar.a.e - ((dmb) viewEr.getLayoutParams()).a.e < 0) != (b < 0)) {
                                    }
                                } else {
                                    continue;
                                }
                            }
                        }
                    }
                    i2 += i3;
                }
            } else {
                if (!dmbVar.b) {
                    viewEr = er(i);
                    if (this.i) {
                        iE = this.c.e(viewEr2);
                        iE2 = this.c.e(viewEr);
                        if (iE >= iE2) {
                            if (iE == iE2) {
                            }
                            if (z) {
                                if ((dmbVar.a.e - ((dmb) viewEr.getLayoutParams()).a.e < 0) != (b < 0)) {
                                }
                            } else {
                                continue;
                            }
                        }
                    } else {
                        iH = this.c.dexFind(viewEr2);
                        iH2 = this.c.dexFind(viewEr);
                        if (iH <= iH2) {
                            if (iH == iH2) {
                            }
                            if (z) {
                                if ((dmbVar.a.e - ((dmb) viewEr.getLayoutParams()).a.e < 0) != (b < 0)) {
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                }
                i2 += i3;
            }
            return viewEr2;
        }
        return null;
    }

    public final boolean bp() {
        return this.dp.getLayoutDirection() == 1;
    }

    public final void bq(View view, int i, int i2) {
        androidx.recyclerview.widget.RecyclerView recyclerView = this.dp;
        Rect rect = this.ar;
        if (recyclerView == null) {
            rect.set(0, 0, 0, 0);
        } else {
            rect.set(recyclerView.dw(view));
        }
        dmb dmbVar = (dmb) view.getLayoutParams();
        int iAx = ax(i, ((ViewGroup.MarginLayoutParams) dmbVar).leftMargin + rect.left,
                ((ViewGroup.MarginLayoutParams) dmbVar).rightMargin + rect.right);
        int iAx2 = ax(i2, ((ViewGroup.MarginLayoutParams) dmbVar).topMargin + rect.top,
                ((ViewGroup.MarginLayoutParams) dmbVar).bottomMargin + rect.bottom);
        if (fk(view, iAx, iAx2, dmbVar)) {
            view.measure(iAx, iAx2);
        }
    }

    /* JADX WARN: Found duplicated region for block: B:108:0x01a8 */
    /* JADX WARN: Found duplicated region for block: B:109:0x01aa */
    /* JADX WARN: Found duplicated region for block: B:123:0x01e1 */
    /* JADX WARN: Found duplicated region for block: B:125:0x01ec */
    /* JADX WARN: Found duplicated region for block: B:131:0x01fe */
    /* JADX WARN: Found duplicated region for block: B:133:0x0209 */
    /* JADX WARN: Found duplicated region for block: B:262:0x042f */
    /* JADX WARN: Found duplicated region for block: B:273:0x01fc A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:277:0x01fc A[SYNTHETIC] */
    public final void br(RecyclerView recyclerViewVar, czt cztVar, boolean z) {
        boolean z2;
        dmd dmdVar;
        int iEs;
        int i;
        int iEl;
        int iEl2;
        int iEs2;
        int i2;
        boolean z3;
        dmd dmdVar2 = this.ap;
        dma dmaVar = this.as;
        if (!(dmdVar2 == null && this.k == -1) && cztVar.p() == 0) {
            fb(recyclerViewVar);
            dmaVar.h();
            return;
        }
        boolean z4 = dmaVar.e;
        StaggeredGridLayoutManager staggeredGridLayoutManager = dmaVar.g;
        boolean z5 = (z4 && this.k == -1 && this.ap == null) ? false : true;
        but butVar = this.al;
        if (z5) {
            dmaVar.h();
            dmd dmdVar3 = this.ap;
            if (dmdVar3 != null) {
                int i3 = dmdVar3.c;
                if (i3 > 0) {
                    if (i3 == this.a) {
                        for (int i4 = 0; i4 < this.a; i4++) {
                            this.b[i4].k();
                            dmd dmdVar4 = this.ap;
                            int iJ = dmdVar4.d[i4];
                            if (iJ != Integer.MIN_VALUE) {
                                iJ += dmdVar4.i ? this.c.j() : this.c.n();
                            }
                            byj byjVar = this.b[i4];
                            byjVar.b = iJ;
                            byjVar.c = iJ;
                        }
                    } else {
                        dmdVar3.d = null;
                        dmdVar3.c = 0;
                        dmdVar3.e = 0;
                        dmdVar3.f = null;
                        dmdVar3.g = null;
                        dmdVar3.a = dmdVar3.b;
                    }
                }
                dmd dmdVar5 = this.ap;
                this.ao = dmdVar5.j;
                boolean z6 = dmdVar5.h;
                bt(null);
                dmd dmdVar6 = this.ap;
                if (dmdVar6 != null && dmdVar6.h != z6) {
                    dmdVar6.h = z6;
                }
                this.h = z6;
                ff();
                cp();
                dmd dmdVar7 = this.ap;
                int i5 = dmdVar7.a;
                if (i5 != -1) {
                    this.k = i5;
                    dmaVar.c = dmdVar7.i;
                } else {
                    dmaVar.c = this.i;
                }
                if (dmdVar7.e > 1) {
                    butVar.b = dmdVar7.f;
                    butVar.c = dmdVar7.g;
                }
            } else {
                cp();
                dmaVar.c = this.i;
            }
            if (cztVar.g || (i2 = this.k) == -1) {
                if (this.an) {
                    int iP = cztVar.p();
                    iEs2 = es() - 1;
                    while (true) {
                        if (iEs2 < 0) {
                            iEl2 = 0;
                            break;
                        }
                        iEl2 = czg.el(er(iEs2));
                        if (iEl2 < 0 && iEl2 < iP) {
                            break;
                        } else {
                            iEs2--;
                        }
                    }
                } else {
                    int iP2 = cztVar.p();
                    iEs = es();
                    i = 0;
                    while (true) {
                        if (i >= iEs) {
                            iEl2 = 0;
                            break;
                        }
                        iEl = czg.el(er(i));
                        if (iEl < 0 && iEl < iP2) {
                            iEl2 = iEl;
                            break;
                        }
                        i++;
                    }
                }
                dmaVar.a = iEl2;
                dmaVar.b = Integer.MIN_VALUE;
            } else if (i2 < 0 || i2 >= cztVar.p()) {
                this.k = -1;
                this.l = Integer.MIN_VALUE;
                if (this.an) {
                    int iP3 = cztVar.p();
                    iEs2 = es() - 1;
                    while (true) {
                        if (iEs2 < 0) {
                            iEl2 = 0;
                            break;
                        } else {
                            iEl2 = czg.el(er(iEs2));
                            if (iEl2 < 0) {
                            }
                            iEs2--;
                        }
                    }
                } else {
                    int iP22 = cztVar.p();
                    iEs = es();
                    i = 0;
                    while (true) {
                        if (i >= iEs) {
                            iEl2 = 0;
                            break;
                        } else {
                            iEl = czg.el(er(i));
                            if (iEl < 0) {
                            }
                            i++;
                        }
                    }
                }
                dmaVar.a = iEl2;
                dmaVar.b = Integer.MIN_VALUE;
            } else {
                dmd dmdVar8 = this.ap;
                if (dmdVar8 == null || dmdVar8.a == -1 || dmdVar8.c < 1) {
                    View viewCa = ca(this.k);
                    if (viewCa != null) {
                        dmaVar.a = this.i ? bk() : bj();
                        if (this.l != Integer.MIN_VALUE) {
                            if (dmaVar.c) {
                                dmaVar.b = (this.c.j() - this.l) - this.c.e(viewCa);
                            } else {
                                dmaVar.b = (this.c.n() + this.l) - this.c.dexFind(viewCa);
                            }
                        } else if (this.c.f(viewCa) > this.c.o()) {
                            dmaVar.b = dmaVar.c ? this.c.j() : this.c.n();
                        } else {
                            int iH = this.c.dexFind(viewCa) - this.c.n();
                            if (iH < 0) {
                                dmaVar.b = -iH;
                            } else {
                                int iJ2 = this.c.j() - this.c.e(viewCa);
                                if (iJ2 < 0) {
                                    dmaVar.b = iJ2;
                                } else {
                                    dmaVar.b = Integer.MIN_VALUE;
                                }
                            }
                        }
                    } else {
                        int i6 = this.k;
                        dmaVar.a = i6;
                        int i7 = this.l;
                        if (i7 == Integer.MIN_VALUE) {
                            if (es() == 0) {
                                z3 = this.i;
                            } else if ((i6 < bj()) != this.i) {
                            }
                            dmaVar.c = z3;
                            dmaVar.b = z3 ? staggeredGridLayoutManager.c.j() : staggeredGridLayoutManager.c.n();
                        } else if (dmaVar.c) {
                            dmaVar.b = staggeredGridLayoutManager.c.j() - i7;
                        } else {
                            dmaVar.b = staggeredGridLayoutManager.c.n() + i7;
                        }
                        dmaVar.d = true;
                    }
                } else {
                    dmaVar.b = Integer.MIN_VALUE;
                    dmaVar.a = this.k;
                }
            }
            dmaVar.e = true;
        }
        if (this.ap == null && this.k == -1 && (dmaVar.c != this.an || bp() != this.ao)) {
            butVar.f();
            dmaVar.d = true;
        }
        if (es() > 0 && ((dmdVar = this.ap) == null || dmdVar.c < 1)) {
            if (dmaVar.d) {
                for (int i8 = 0; i8 < this.a; i8++) {
                    this.b[i8].k();
                    int i9 = dmaVar.b;
                    if (i9 != Integer.MIN_VALUE) {
                        byj byjVar2 = this.b[i8];
                        byjVar2.b = i9;
                        byjVar2.c = i9;
                    }
                }
            } else if (z5 || dmaVar.f == null) {
                for (int i10 = 0; i10 < this.a; i10++) {
                    byj byjVar3 = this.b[i10];
                    boolean z7 = this.i;
                    int i11 = dmaVar.b;
                    StaggeredGridLayoutManager staggeredGridLayoutManager2 = (StaggeredGridLayoutManager) byjVar3.g;
                    int iP4 = z7 ? byjVar3.p(Integer.MIN_VALUE) : byjVar3.r(Integer.MIN_VALUE);
                    byjVar3.k();
                    if (iP4 != Integer.MIN_VALUE && ((!z7 || iP4 >= staggeredGridLayoutManager2.c.j())
                            && (z7 || iP4 <= staggeredGridLayoutManager2.c.n()))) {
                        if (i11 != Integer.MIN_VALUE) {
                            iP4 += i11;
                        }
                        byjVar3.c = iP4;
                        byjVar3.b = iP4;
                    }
                }
                byj[] byjVarArr = this.b;
                int length = byjVarArr.length;
                int[] iArr = dmaVar.f;
                if (iArr == null || iArr.length < length) {
                    dmaVar.f = new int[staggeredGridLayoutManager.b.length];
                }
                for (int i12 = 0; i12 < length; i12++) {
                    dmaVar.f[i12] = byjVarArr[i12].r(Integer.MIN_VALUE);
                }
            } else {
                for (int i13 = 0; i13 < this.a; i13++) {
                    byj byjVar4 = this.b[i13];
                    byjVar4.k();
                    int i14 = dmaVar.f[i13];
                    byjVar4.b = i14;
                    byjVar4.c = i14;
                }
            }
        }
        eq(recyclerViewVar);
        bts btsVar = this.g;
        btsVar.a = false;
        this.at = false;
        int iO = this.d.o();
        this.f = iO / this.a;
        this.aq = View.MeasureSpec.makeMeasureSpec(iO, this.d.l());
        ct(dmaVar.a, cztVar);
        if (dmaVar.c) {
            cr(-1);
            be(recyclerViewVar, btsVar, cztVar);
            cr(1);
            btsVar.c = dmaVar.a + btsVar.d;
            be(recyclerViewVar, btsVar, cztVar);
        } else {
            cr(1);
            be(recyclerViewVar, btsVar, cztVar);
            cr(-1);
            btsVar.c = dmaVar.a + btsVar.d;
            be(recyclerViewVar, btsVar, cztVar);
        }
        if (this.d.l() != 1073741824) {
            int iEs3 = es();
            float fMax = 0.0f;
            for (int i15 = 0; i15 < iEs3; i15++) {
                View viewEr = er(i15);
                float f = this.d.f(viewEr);
                if (f >= fMax) {
                    if (((dmb) viewEr.getLayoutParams()).b) {
                        f = (f * 1.0f) / this.a;
                    }
                    fMax = Math.max(fMax, f);
                }
            }
            int i16 = this.f;
            int iRound = Math.round(fMax * this.a);
            if (this.d.l() == Integer.MIN_VALUE) {
                iRound = Math.min(iRound, this.d.o());
            }
            this.f = iRound / this.a;
            this.aq = View.MeasureSpec.makeMeasureSpec(iRound, this.d.l());
            if (this.f != i16) {
                for (int i17 = 0; i17 < iEs3; i17++) {
                    View viewEr2 = er(i17);
                    dmb dmbVar = (dmb) viewEr2.getLayoutParams();
                    if (!dmbVar.b) {
                        if (bp() && this.e == 1) {
                            int i18 = -((this.a - 1) - dmbVar.a.e);
                            viewEr2.offsetLeftAndRight((this.f * i18) - (i18 * i16));
                        } else {
                            int i19 = dmbVar.a.e;
                            int i20 = this.f * i19;
                            int i21 = i19 * i16;
                            if (this.e == 1) {
                                viewEr2.offsetLeftAndRight(i20 - i21);
                            } else {
                                viewEr2.offsetTopAndBottom(i20 - i21);
                            }
                        }
                    }
                }
            }
        }
        if (es() > 0) {
            if (this.i) {
                bh(recyclerViewVar, cztVar, true);
                bi(recyclerViewVar, cztVar, false);
            } else {
                bi(recyclerViewVar, cztVar, true);
                bh(recyclerViewVar, cztVar, false);
            }
        }
        if (z && !cztVar.g && this.am != 0 && es() > 0 && (this.at || bo() != null)) {
            androidx.recyclerview.widget.RecyclerView recyclerView = this.dp;
            if (recyclerView != null) {
                recyclerView.removeCallbacks(this.aw);
            }
            z2 = bc();
        }
        if (cztVar.g) {
            dmaVar.h();
        }
        this.an = dmaVar.c;
        this.ao = bp();
        if (z2) {
            dmaVar.h();
            br(recyclerViewVar, cztVar, false);
        }
    }

    /* JADX WARN: Found duplicated region for block: B:6:0x000c */
    @Override // me.hd.wauxv.obf.czs
    public final PointF bs(int i) {
        int i2 = -1;
        if (es() != 0) {
            if ((i < bj()) == this.i) {
                i2 = 1;
            }
        } else if (this.i) {
            i2 = 1;
        }
        PointF pointF = new PointF();
        if (i2 == 0) {
            return null;
        }
        if (this.e == 0) {
            pointF.x = i2;
            pointF.y = 0.0f;
            return pointF;
        }
        pointF.x = 0.0f;
        pointF.y = i2;
        return pointF;
    }

    @Override // me.hd.wauxv.obf.czg
    public final void bt(String str) {
        if (this.ap == null) {
            super.bt(str);
        }
    }

    @Override // me.hd.wauxv.obf.czg
    public final boolean bu() {
        return this.e == 0;
    }

    @Override // me.hd.wauxv.obf.czg
    public final boolean bv() {
        return this.e == 1;
    }

    @Override // me.hd.wauxv.obf.czg
    public final void bw(int i, int i2, czt cztVar, bpq bpqVar) {
        bts btsVar;
        int iP;
        int iR;
        if (this.e != 0) {
            i = i2;
        }
        if (es() == 0 || i == 0) {
            return;
        }
        cl(i, cztVar);
        int[] iArr = this.av;
        if (iArr == null || iArr.length < this.a) {
            this.av = new int[this.a];
        }
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int i5 = this.a;
            btsVar = this.g;
            if (i3 >= i5) {
                break;
            }
            if (btsVar.d == -1) {
                iP = btsVar.f;
                iR = this.b[i3].r(iP);
            } else {
                iP = this.b[i3].p(btsVar.g);
                iR = btsVar.g;
            }
            int i6 = iP - iR;
            if (i6 >= 0) {
                this.av[i4] = i6;
                i4++;
            }
            i3++;
        }
        Arrays.sort(this.av, 0, i4);
        for (int i7 = 0; i7 < i4; i7++) {
            int i8 = btsVar.c;
            if (i8 < 0 || i8 >= cztVar.p()) {
                return;
            }
            bpqVar.f(btsVar.c, this.av[i7]);
            btsVar.c += btsVar.d;
        }
    }

    @Override // me.hd.wauxv.obf.czg
    public final int by(czt cztVar) {
        if (es() == 0) {
            return 0;
        }
        boolean z = !this.au;
        return HugeSyntheticPileOfHelpers.au(cztVar, this.c, bg(z), bf(z), this, this.au);
    }

    @Override // me.hd.wauxv.obf.czg
    public final int bz(czt cztVar) {
        if (es() == 0) {
            return 0;
        }
        boolean z = !this.au;
        return HugeSyntheticPileOfHelpers.au(cztVar, this.c, bg(z), bf(z), this, this.au);
    }

    @Override // me.hd.wauxv.obf.czg
    public final boolean cb() {
        return this.am != 0;
    }

    @Override // me.hd.wauxv.obf.czg
    public final boolean cc() {
        return this.h;
    }

    @Override // me.hd.wauxv.obf.czg
    public final void cd(androidx.recyclerview.widget.RecyclerView recyclerView) {
        androidx.recyclerview.widget.RecyclerView recyclerView2 = this.dp;
        if (recyclerView2 != null) {
            recyclerView2.removeCallbacks(this.aw);
        }
        for (int i = 0; i < this.a; i++) {
            this.b[i].k();
        }
        recyclerView.requestLayout();
    }

    @Override // me.hd.wauxv.obf.czg
    public final void ce(AccessibilityEvent accessibilityEvent) {
        super.ce(accessibilityEvent);
        if (es() > 0) {
            View viewBg = bg(false);
            View viewBf = bf(false);
            if (viewBg == null || viewBf == null) {
                return;
            }
            int iEl = czg.el(viewBg);
            int iEl2 = czg.el(viewBf);
            if (iEl < iEl2) {
                accessibilityEvent.setFromIndex(iEl);
                accessibilityEvent.setToIndex(iEl2);
            } else {
                accessibilityEvent.setFromIndex(iEl2);
                accessibilityEvent.setToIndex(iEl);
            }
        }
    }

    @Override // me.hd.wauxv.obf.czg
    public final void cf(Parcelable parcelable) {
        if (parcelable instanceof dmd) {
            dmd dmdVar = (dmd) parcelable;
            this.ap = dmdVar;
            if (this.k != -1) {
                dmdVar.a = -1;
                dmdVar.b = -1;
                dmdVar.d = null;
                dmdVar.c = 0;
                dmdVar.e = 0;
                dmdVar.f = null;
                dmdVar.g = null;
            }
            ff();
        }
    }

    @Override // me.hd.wauxv.obf.czg
    public final Parcelable cg() {
        int iR;
        int iN;
        int[] iArr;
        dmd dmdVar = this.ap;
        if (dmdVar != null) {
            dmd dmdVar2 = new dmd();
            dmdVar2.c = dmdVar.c;
            dmdVar2.a = dmdVar.a;
            dmdVar2.b = dmdVar.b;
            dmdVar2.d = dmdVar.d;
            dmdVar2.e = dmdVar.e;
            dmdVar2.f = dmdVar.f;
            dmdVar2.h = dmdVar.h;
            dmdVar2.i = dmdVar.i;
            dmdVar2.j = dmdVar.j;
            dmdVar2.g = dmdVar.g;
            return dmdVar2;
        }
        dmd dmdVar3 = new dmd();
        dmdVar3.h = this.h;
        dmdVar3.i = this.an;
        dmdVar3.j = this.ao;
        but butVar = this.al;
        if (butVar == null || (iArr = (int[]) butVar.b) == null) {
            dmdVar3.e = 0;
        } else {
            dmdVar3.f = iArr;
            dmdVar3.e = iArr.length;
            dmdVar3.g = (ArrayList) butVar.c;
        }
        if (es() <= 0) {
            dmdVar3.a = -1;
            dmdVar3.b = -1;
            dmdVar3.c = 0;
            return dmdVar3;
        }
        dmdVar3.a = this.an ? bk() : bj();
        View viewBf = this.i ? bf(true) : bg(true);
        dmdVar3.b = viewBf != null ? czg.el(viewBf) : -1;
        int i = this.a;
        dmdVar3.c = i;
        dmdVar3.d = new int[i];
        for (int i2 = 0; i2 < this.a; i2++) {
            if (this.an) {
                iR = this.b[i2].p(Integer.MIN_VALUE);
                if (iR != Integer.MIN_VALUE) {
                    iN = this.c.j();
                    iR -= iN;
                }
            } else {
                iR = this.b[i2].r(Integer.MIN_VALUE);
                if (iR != Integer.MIN_VALUE) {
                    iN = this.c.n();
                    iR -= iN;
                }
            }
            dmdVar3.d[i2] = iR;
        }
        return dmdVar3;
    }

    @Override // me.hd.wauxv.obf.czg
    public final void ch(int i) {
        dmd dmdVar = this.ap;
        if (dmdVar != null && dmdVar.a != i) {
            dmdVar.d = null;
            dmdVar.c = 0;
            dmdVar.a = -1;
            dmdVar.b = -1;
        }
        this.k = i;
        this.l = Integer.MIN_VALUE;
        ff();
    }

    @Override // me.hd.wauxv.obf.czg
    public final void cj(androidx.recyclerview.widget.RecyclerView recyclerView, czt cztVar, int i) {
        bvl bvlVar = new bvl(recyclerView.getContext());
        bvlVar.f = i;
        fm(bvlVar);
    }

    public final boolean ck(int i) {
        if (this.e == 0) {
            return (i == -1) != this.i;
        }
        return ((i == -1) == this.i) == bp();
    }

    public final void cl(int i, czt cztVar) {
        int iBj;
        int i2;
        if (i > 0) {
            iBj = bk();
            i2 = 1;
        } else {
            iBj = bj();
            i2 = -1;
        }
        bts btsVar = this.g;
        btsVar.a = true;
        ct(iBj, cztVar);
        cr(i2);
        btsVar.c = iBj + btsVar.d;
        btsVar.b = Math.abs(i);
    }

    public final void cm(RecyclerView recyclerViewVar, bts btsVar) {
        if (!btsVar.a || btsVar.i) {
            return;
        }
        if (btsVar.b == 0) {
            if (btsVar.e == -1) {
                cn(recyclerViewVar, btsVar.g);
                return;
            } else {
                co(recyclerViewVar, btsVar.f);
                return;
            }
        }
        int i = 1;
        if (btsVar.e == -1) {
            int i2 = btsVar.f;
            int iR = this.b[0].r(i2);
            while (i < this.a) {
                int iR2 = this.b[i].r(i2);
                if (iR2 > iR) {
                    iR = iR2;
                }
                i++;
            }
            int i3 = i2 - iR;
            cn(recyclerViewVar, i3 < 0 ? btsVar.g : btsVar.g - Math.min(i3, btsVar.b));
            return;
        }
        int i4 = btsVar.g;
        int iP = this.b[0].p(i4);
        while (i < this.a) {
            int iP2 = this.b[i].p(i4);
            if (iP2 < iP) {
                iP = iP2;
            }
            i++;
        }
        int i5 = iP - btsVar.g;
        co(recyclerViewVar, i5 < 0 ? btsVar.f : Math.min(i5, btsVar.b) + btsVar.f);
    }

    public final void cn(RecyclerView recyclerViewVar, int i) {
        for (int iEs = es() - 1; iEs >= 0; iEs--) {
            View viewEr = er(iEs);
            if (this.c.dexFind(viewEr) < i || this.c.q(viewEr) < i) {
                return;
            }
            dmb dmbVar = (dmb) viewEr.getLayoutParams();
            if (dmbVar.b) {
                for (int i2 = 0; i2 < this.a; i2++) {
                    if (((ArrayList) this.b[i2].f).size() == 1) {
                        return;
                    }
                }
                for (int i3 = 0; i3 < this.a; i3++) {
                    this.b[i3].s();
                }
            } else if (((ArrayList) dmbVar.a.f).size() == 1) {
                return;
            } else {
                dmbVar.a.s();
            }
            fd(viewEr, recyclerViewVar);
        }
    }

    public final void co(RecyclerView recyclerViewVar, int i) {
        while (es() > 0) {
            View viewEr = er(0);
            if (this.c.e(viewEr) > i || this.c.p(viewEr) > i) {
                return;
            }
            dmb dmbVar = (dmb) viewEr.getLayoutParams();
            if (dmbVar.b) {
                for (int i2 = 0; i2 < this.a; i2++) {
                    if (((ArrayList) this.b[i2].f).size() == 1) {
                        return;
                    }
                }
                for (int i3 = 0; i3 < this.a; i3++) {
                    this.b[i3].t();
                }
            } else if (((ArrayList) dmbVar.a.f).size() == 1) {
                return;
            } else {
                dmbVar.a.t();
            }
            fd(viewEr, recyclerViewVar);
        }
    }

    public final void cp() {
        if (this.e == 1 || !bp()) {
            this.i = this.h;
        } else {
            this.i = !this.h;
        }
    }

    public final int cq(int i, RecyclerView recyclerViewVar, czt cztVar) {
        if (es() == 0 || i == 0) {
            return 0;
        }
        cl(i, cztVar);
        bts btsVar = this.g;
        int iBe = be(recyclerViewVar, btsVar, cztVar);
        if (btsVar.b >= iBe) {
            i = i < 0 ? -iBe : iBe;
        }
        this.c.r(-i);
        this.an = this.i;
        btsVar.b = 0;
        cm(recyclerViewVar, btsVar);
        return i;
    }

    public final void cr(int i) {
        bts btsVar = this.g;
        btsVar.e = i;
        btsVar.d = this.i != (i == -1) ? -1 : 1;
    }

    public final void cs(int i, int i2) {
        for (int i3 = 0; i3 < this.a; i3++) {
            if (!((ArrayList) this.b[i3].f).isEmpty()) {
                cu(this.b[i3], i, i2);
            }
        }
    }

    public final void ct(int i, czt cztVar) {
        int iO;
        int iO2;
        int i2;
        bts btsVar = this.g;
        boolean z = false;
        btsVar.b = 0;
        btsVar.c = i;
        bvl bvlVar = this.ds;
        if (bvlVar == null || !bvlVar.j || (i2 = cztVar.a) == -1) {
            iO = 0;
            iO2 = 0;
        } else {
            if (this.i == (i2 < i)) {
                iO = this.c.o();
                iO2 = 0;
            } else {
                iO2 = this.c.o();
                iO = 0;
            }
        }
        androidx.recyclerview.widget.RecyclerView recyclerView = this.dp;
        if (recyclerView == null || !recyclerView.r) {
            btsVar.g = this.c.i() + iO;
            btsVar.f = -iO2;
        } else {
            btsVar.f = this.c.n() - iO2;
            btsVar.g = this.c.j() + iO;
        }
        btsVar.h = false;
        btsVar.a = true;
        if (this.c.l() == 0 && this.c.i() == 0) {
            z = true;
        }
        btsVar.i = z;
    }

    public final void cu(byj byjVar, int i, int i2) {
        int i3 = byjVar.d;
        int i4 = byjVar.e;
        if (i == -1) {
            int i5 = byjVar.b;
            if (i5 == Integer.MIN_VALUE) {
                byjVar.j();
                i5 = byjVar.b;
            }
            if (i5 + i3 <= i2) {
                this.j.set(i4, false);
                return;
            }
            return;
        }
        int i6 = byjVar.c;
        if (i6 == Integer.MIN_VALUE) {
            byjVar.i();
            i6 = byjVar.c;
        }
        if (i6 - i3 >= i2) {
            this.j.set(i4, false);
        }
    }

    @Override // me.hd.wauxv.obf.czg
    public final boolean m(czh czhVar) {
        return czhVar instanceof dmb;
    }

    @Override // me.hd.wauxv.obf.czg
    public final int n(czt cztVar) {
        return bd(cztVar);
    }

    @Override // me.hd.wauxv.obf.czg
    public final int o(czt cztVar) {
        if (es() == 0) {
            return 0;
        }
        boolean z = !this.au;
        return HugeSyntheticPileOfHelpers.aw(cztVar, this.c, bg(z), bf(z), this, this.au);
    }

    @Override // me.hd.wauxv.obf.czg
    public final int p(czt cztVar) {
        return bd(cztVar);
    }

    @Override // me.hd.wauxv.obf.czg
    public final int q(czt cztVar) {
        if (es() == 0) {
            return 0;
        }
        boolean z = !this.au;
        return HugeSyntheticPileOfHelpers.aw(cztVar, this.c, bg(z), bf(z), this, this.au);
    }

    @Override // me.hd.wauxv.obf.czg
    public final czh r() {
        return this.e == 0 ? new dmb(-2, -1) : new dmb(-1, -2);
    }

    @Override // me.hd.wauxv.obf.czg
    public final czh s(Context context, AttributeSet attributeSet) {
        return new dmb(context, attributeSet);
    }

    @Override // me.hd.wauxv.obf.czg
    public final czh t(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams
                ? new dmb((ViewGroup.MarginLayoutParams) layoutParams)
                : new dmb(layoutParams);
    }

    @Override // me.hd.wauxv.obf.czg
    public final int u(RecyclerView recyclerViewVar, czt cztVar) {
        if (this.e == 1) {
            return Math.min(this.a, cztVar.p());
        }
        return -1;
    }

    @Override // me.hd.wauxv.obf.czg
    public final int v(RecyclerView recyclerViewVar, czt cztVar) {
        if (this.e == 0) {
            return Math.min(this.a, cztVar.p());
        }
        return -1;
    }

    /* JADX WARN: Found duplicated region for block: B:31:0x0048 */
    /* JADX WARN: Found duplicated region for block: B:37:0x0053 */
    @Override // me.hd.wauxv.obf.czg
    public final View w(View view, int i, RecyclerView recyclerViewVar, czt cztVar) {
        View viewM0do;
        int i2;
        View viewQ;
        if (es() != 0) {
            androidx.recyclerview.widget.RecyclerView recyclerView = this.dp;
            if (recyclerView == null || (viewM0do = recyclerView.m0do(view)) == null
                    || ((ArrayList) this.f4do.e).contains(viewM0do)) {
                viewM0do = null;
            }
            if (viewM0do != null) {
                cp();
                if (i != 1) {
                    if (i != 2) {
                        if (i == 17) {
                            i2 = this.e == 0 ? -1 : Integer.MIN_VALUE;
                        } else if (i != 33) {
                            if (i == 66 ? this.e == 0 : !(i != 130 || this.e != 1)) {
                                i2 = 1;
                            }
                        } else if (this.e == 1) {
                        }
                    } else if (this.e == 1 || !bp()) {
                        i2 = 1;
                    }
                } else if (this.e != 1 && bp()) {
                    i2 = 1;
                }
                if (i2 != Integer.MIN_VALUE) {
                    dmb dmbVar = (dmb) viewM0do.getLayoutParams();
                    boolean z = dmbVar.b;
                    byj byjVar = dmbVar.a;
                    int iBk = i2 == 1 ? bk() : bj();
                    ct(iBk, cztVar);
                    cr(i2);
                    bts btsVar = this.g;
                    btsVar.c = btsVar.d + iBk;
                    btsVar.b = (int) (this.c.o() * 0.33333334f);
                    btsVar.h = true;
                    btsVar.a = false;
                    be(recyclerViewVar, btsVar, cztVar);
                    this.an = this.i;
                    if (!z && (viewQ = byjVar.q(iBk, i2)) != null && viewQ != viewM0do) {
                        return viewQ;
                    }
                    if (ck(i2)) {
                        for (int i3 = this.a - 1; i3 >= 0; i3--) {
                            View viewQ2 = this.b[i3].q(iBk, i2);
                            if (viewQ2 != null && viewQ2 != viewM0do) {
                                return viewQ2;
                            }
                        }
                    } else {
                        for (int i4 = 0; i4 < this.a; i4++) {
                            View viewQ3 = this.b[i4].q(iBk, i2);
                            if (viewQ3 != null && viewQ3 != viewM0do) {
                                return viewQ3;
                            }
                        }
                    }
                    boolean z2 = (this.h ^ true) == (i2 == -1);
                    if (!z) {
                        View viewCa = ca(z2 ? byjVar.l() : byjVar.m());
                        if (viewCa != null && viewCa != viewM0do) {
                            return viewCa;
                        }
                    }
                    if (ck(i2)) {
                        for (int i5 = this.a - 1; i5 >= 0; i5--) {
                            if (i5 != byjVar.e) {
                                View viewCa2 = ca(z2 ? this.b[i5].l() : this.b[i5].m());
                                if (viewCa2 != null && viewCa2 != viewM0do) {
                                    return viewCa2;
                                }
                            }
                        }
                    } else {
                        for (int i6 = 0; i6 < this.a; i6++) {
                            View viewCa3 = ca(z2 ? this.b[i6].l() : this.b[i6].m());
                            if (viewCa3 != null && viewCa3 != viewM0do) {
                                return viewCa3;
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    @Override // me.hd.wauxv.obf.czg
    public final void x(RecyclerView recyclerViewVar, czt cztVar, bd bdVar) {
        super.x(recyclerViewVar, cztVar, bdVar);
        bdVar.k("androidx.recyclerview.widget.StaggeredGridLayoutManager");
    }

    @Override // me.hd.wauxv.obf.czg
    public final void y(RecyclerView recyclerViewVar, czt cztVar, View view, bd bdVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof dmb)) {
            ez(view, bdVar);
            return;
        }
        dmb dmbVar = (dmb) layoutParams;
        if (this.e == 0) {
            byj byjVar = dmbVar.a;
            bdVar.l(LateinitProperty.g(byjVar == null ? -1 : byjVar.e, dmbVar.b ? this.a : 1, -1, -1, false));
        } else {
            byj byjVar2 = dmbVar.a;
            bdVar.l(LateinitProperty.g(-1, -1, byjVar2 == null ? -1 : byjVar2.e, dmbVar.b ? this.a : 1, false));
        }
    }

    @Override // me.hd.wauxv.obf.czg
    public final void z(int i, int i2) {
        bn(i, i2, 1);
    }
}
