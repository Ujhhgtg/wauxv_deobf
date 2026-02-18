package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import com.umeng.analytics.pro.q;
import java.util.ArrayList;
import java.util.List;
import me.hd.wauxv.obf.atb;
import me.hd.wauxv.obf.ax;
import me.hd.wauxv.obf.bd;
import me.hd.wauxv.obf.bjs;
import me.hd.wauxv.obf.bpq;
import me.hd.wauxv.obf.bvh;
import me.hd.wauxv.obf.bvi;
import me.hd.wauxv.obf.bvj;
import me.hd.wauxv.obf.bvk;
import me.hd.wauxv.obf.bvl;
import me.hd.wauxv.obf.cnf;
import me.hd.wauxv.obf.cyw;
import me.hd.wauxv.obf.czf;
import me.hd.wauxv.obf.czg;
import me.hd.wauxv.obf.czh;
import me.hd.wauxv.obf.czo;
import me.hd.wauxv.obf.czs;
import me.hd.wauxv.obf.czt;
import me.hd.wauxv.obf.czx;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class LinearLayoutManager extends czg implements czs {
    public int bd;
    public bvj be;
    public atb bf;
    public boolean bg;
    public final boolean bh;
    public boolean bi;
    public boolean bj;
    public final boolean bk;
    public int bl;
    public int bm;
    public bvk bn;
    public final bvh bo;
    public final bvi bp;
    public final int bq;
    public final int[] br;

    public LinearLayoutManager(int i) {
        this.bd = 1;
        this.bh = false;
        this.bi = false;
        this.bj = false;
        this.bk = true;
        this.bl = -1;
        this.bm = Integer.MIN_VALUE;
        this.bn = null;
        this.bo = new bvh();
        this.bp = new bvi();
        this.bq = 2;
        this.br = new int[2];
        dh(i);
        bt(null);
        if (this.bh) {
            this.bh = false;
            ff();
        }
    }

    /* JADX WARN: Found duplicated region for block: B:102:0x01ab */
    /* JADX WARN: Found duplicated region for block: B:104:0x01ae */
    /* JADX WARN: Found duplicated region for block: B:111:0x01d9 */
    /* JADX WARN: Found duplicated region for block: B:114:0x01e0 */
    /* JADX WARN: Found duplicated region for block: B:118:0x01f3 */
    /*
     * JADX WARN: Found duplicated region for block: B:122:0x0213 A[ADDED_TO_REGION]
     */
    /* JADX WARN: Found duplicated region for block: B:124:0x0217 */
    /*
     * JADX WARN: Found duplicated region for block: B:126:0x021a A[ADDED_TO_REGION]
     */
    /* JADX WARN: Found duplicated region for block: B:128:0x021e */
    /*
     * JADX WARN: Found duplicated region for block: B:130:0x0221 A[ADDED_TO_REGION]
     */
    /* JADX WARN: Found duplicated region for block: B:131:0x0223 */
    /* JADX WARN: Found duplicated region for block: B:133:0x0227 */
    /* JADX WARN: Found duplicated region for block: B:135:0x022b */
    /* JADX WARN: Found duplicated region for block: B:137:0x0232 */
    /* JADX WARN: Found duplicated region for block: B:138:0x0238 */
    /* JADX WARN: Found duplicated region for block: B:95:0x0194 */
    @Override // me.hd.wauxv.obf.czg
    public void ae(czo czoVar, czt cztVar) {
        View focusedChild;
        RecyclerView recyclerView;
        View focusedChild2;
        boolean z;
        boolean z2;
        View viewAm;
        int iN;
        int iJ;
        boolean z3;
        czh czhVar;
        int i;
        int iH;
        int i2;
        int i3;
        List list;
        int i4;
        int i5;
        int iCx;
        int i6;
        View viewCa;
        int iH2;
        int iJ2;
        int i7;
        int i8 = -1;
        if (!(this.bn == null && this.bl == -1) && cztVar.p() == 0) {
            fb(czoVar);
            return;
        }
        bvk bvkVar = this.bn;
        if (bvkVar != null && (i7 = bvkVar.a) >= 0) {
            this.bl = i7;
        }
        cp();
        this.be.a = false;
        de();
        RecyclerView recyclerView2 = this.dp;
        if (recyclerView2 == null || (focusedChild = recyclerView2.getFocusedChild()) == null
                || ((ArrayList) this.f4do.e).contains(focusedChild)) {
            focusedChild = null;
        }
        bvh bvhVar = this.bo;
        if (!bvhVar.e || this.bl != -1 || this.bn != null) {
            bvhVar.i();
            bvhVar.d = this.bi ^ this.bj;
            if (cztVar.g || (i = this.bl) == -1) {
                if (es() != 0) {
                    recyclerView = this.dp;
                    if (recyclerView != null || (focusedChild2 = recyclerView.getFocusedChild()) == null
                            || ((ArrayList) this.f4do.e).contains(focusedChild2)) {
                    }
                    if (focusedChild2 != null) {
                        czhVar = (czh) focusedChild2.getLayoutParams();
                        if (!czhVar.c.af() || czhVar.c.z() < 0 || czhVar.c.z() >= cztVar.p()) {
                            z = this.bg;
                            z2 = this.bj;
                            if (z == z2 || (viewAm = am(czoVar, cztVar, bvhVar.d, z2)) == null) {
                                bvhVar.f();
                                bvhVar.b = this.bj ? cztVar.p() - 1 : 0;
                            } else {
                                bvhVar.g(viewAm, czg.el(viewAm));
                                if (!cztVar.g && ak()) {
                                    int iH3 = this.bf.locateDex(viewAm);
                                    int iE = this.bf.e(viewAm);
                                    iN = this.bf.n();
                                    iJ = this.bf.j();
                                    z3 = iE > iN && iH3 < iN;
                                    boolean z4 = iH3 < iJ && iE > iJ;
                                    if (z3 || z4) {
                                        if (bvhVar.d) {
                                            iN = iJ;
                                        }
                                        bvhVar.c = iN;
                                    }
                                }
                            }
                        } else {
                            bvhVar.h(focusedChild2, czg.el(focusedChild2));
                        }
                    } else {
                        z = this.bg;
                        z2 = this.bj;
                        if (z == z2) {
                            bvhVar.f();
                            bvhVar.b = this.bj ? cztVar.p() - 1 : 0;
                        } else {
                            bvhVar.g(viewAm, czg.el(viewAm));
                            if (!cztVar.g) {
                                int iH32 = this.bf.locateDex(viewAm);
                                int iE2 = this.bf.e(viewAm);
                                iN = this.bf.n();
                                iJ = this.bf.j();
                                if (iE2 > iN) {
                                }
                                if (iH32 < iJ) {
                                }
                                if (z3) {
                                    if (bvhVar.d) {
                                        iN = iJ;
                                    }
                                    bvhVar.c = iN;
                                } else {
                                    if (bvhVar.d) {
                                        iN = iJ;
                                    }
                                    bvhVar.c = iN;
                                }
                            }
                        }
                    }
                } else {
                    bvhVar.f();
                    bvhVar.b = this.bj ? cztVar.p() - 1 : 0;
                }
            } else if (i < 0 || i >= cztVar.p()) {
                this.bl = -1;
                this.bm = Integer.MIN_VALUE;
                if (es() != 0) {
                    recyclerView = this.dp;
                    focusedChild2 = recyclerView != null ? null : null;
                    if (focusedChild2 != null) {
                        czhVar = (czh) focusedChild2.getLayoutParams();
                        if (czhVar.c.af()) {
                            z = this.bg;
                            z2 = this.bj;
                            if (z == z2) {
                                bvhVar.f();
                                bvhVar.b = this.bj ? cztVar.p() - 1 : 0;
                            } else {
                                bvhVar.g(viewAm, czg.el(viewAm));
                                if (!cztVar.g) {
                                    int iH322 = this.bf.locateDex(viewAm);
                                    int iE22 = this.bf.e(viewAm);
                                    iN = this.bf.n();
                                    iJ = this.bf.j();
                                    if (iE22 > iN) {
                                    }
                                    if (iH322 < iJ) {
                                    }
                                    if (z3) {
                                        if (bvhVar.d) {
                                            iN = iJ;
                                        }
                                        bvhVar.c = iN;
                                    } else {
                                        if (bvhVar.d) {
                                            iN = iJ;
                                        }
                                        bvhVar.c = iN;
                                    }
                                }
                            }
                        } else {
                            z = this.bg;
                            z2 = this.bj;
                            if (z == z2) {
                                bvhVar.f();
                                bvhVar.b = this.bj ? cztVar.p() - 1 : 0;
                            } else {
                                bvhVar.g(viewAm, czg.el(viewAm));
                                if (!cztVar.g) {
                                    int iH3222 = this.bf.locateDex(viewAm);
                                    int iE222 = this.bf.e(viewAm);
                                    iN = this.bf.n();
                                    iJ = this.bf.j();
                                    if (iE222 > iN) {
                                    }
                                    if (iH3222 < iJ) {
                                    }
                                    if (z3) {
                                        if (bvhVar.d) {
                                            iN = iJ;
                                        }
                                        bvhVar.c = iN;
                                    } else {
                                        if (bvhVar.d) {
                                            iN = iJ;
                                        }
                                        bvhVar.c = iN;
                                    }
                                }
                            }
                        }
                    } else {
                        z = this.bg;
                        z2 = this.bj;
                        if (z == z2) {
                            bvhVar.f();
                            bvhVar.b = this.bj ? cztVar.p() - 1 : 0;
                        } else {
                            bvhVar.g(viewAm, czg.el(viewAm));
                            if (!cztVar.g) {
                                int iH32222 = this.bf.locateDex(viewAm);
                                int iE2222 = this.bf.e(viewAm);
                                iN = this.bf.n();
                                iJ = this.bf.j();
                                if (iE2222 > iN) {
                                }
                                if (iH32222 < iJ) {
                                }
                                if (z3) {
                                    if (bvhVar.d) {
                                        iN = iJ;
                                    }
                                    bvhVar.c = iN;
                                } else {
                                    if (bvhVar.d) {
                                        iN = iJ;
                                    }
                                    bvhVar.c = iN;
                                }
                            }
                        }
                    }
                } else {
                    bvhVar.f();
                    bvhVar.b = this.bj ? cztVar.p() - 1 : 0;
                }
            } else {
                int i9 = this.bl;
                bvhVar.b = i9;
                bvk bvkVar2 = this.bn;
                if (bvkVar2 != null && bvkVar2.a >= 0) {
                    boolean z5 = bvkVar2.c;
                    bvhVar.d = z5;
                    if (z5) {
                        bvhVar.c = this.bf.j() - this.bn.b;
                    } else {
                        bvhVar.c = this.bf.n() + this.bn.b;
                    }
                } else if (this.bm == Integer.MIN_VALUE) {
                    View viewCa2 = ca(i9);
                    if (viewCa2 == null) {
                        if (es() > 0) {
                            bvhVar.d = (this.bl < czg.el(er(0))) == this.bi;
                        }
                        bvhVar.f();
                    } else if (this.bf.f(viewCa2) > this.bf.o()) {
                        bvhVar.f();
                    } else if (this.bf.locateDex(viewCa2) - this.bf.n() < 0) {
                        bvhVar.c = this.bf.n();
                        bvhVar.d = false;
                    } else if (this.bf.j() - this.bf.e(viewCa2) < 0) {
                        bvhVar.c = this.bf.j();
                        bvhVar.d = true;
                    } else {
                        if (bvhVar.d) {
                            int iE3 = this.bf.e(viewCa2);
                            atb atbVar = this.bf;
                            iH = (Integer.MIN_VALUE == atbVar.a ? 0 : atbVar.o() - atbVar.a) + iE3;
                        } else {
                            iH = this.bf.locateDex(viewCa2);
                        }
                        bvhVar.c = iH;
                    }
                } else {
                    boolean z6 = this.bi;
                    bvhVar.d = z6;
                    if (z6) {
                        bvhVar.c = this.bf.j() - this.bm;
                    } else {
                        bvhVar.c = this.bf.n() + this.bm;
                    }
                }
            }
            bvhVar.e = true;
        } else if (focusedChild != null
                && (this.bf.locateDex(focusedChild) >= this.bf.j() || this.bf.e(focusedChild) <= this.bf.n())) {
            bvhVar.h(focusedChild, czg.el(focusedChild));
        }
        bvj bvjVar = this.be;
        bvjVar.f = bvjVar.j >= 0 ? 1 : -1;
        int[] iArr = this.br;
        iArr[0] = 0;
        iArr[1] = 0;
        ck(cztVar, iArr);
        int iN2 = this.bf.n() + Math.max(0, iArr[0]);
        int iK = this.bf.k() + Math.max(0, iArr[1]);
        if (cztVar.g && (i6 = this.bl) != -1 && this.bm != Integer.MIN_VALUE && (viewCa = ca(i6)) != null) {
            if (this.bi) {
                iJ2 = this.bf.j() - this.bf.e(viewCa);
                iH2 = this.bm;
            } else {
                iH2 = this.bf.locateDex(viewCa) - this.bf.n();
                iJ2 = this.bm;
            }
            int i10 = iJ2 - iH2;
            if (i10 > 0) {
                iN2 += i10;
            } else {
                iK -= i10;
            }
        }
        if (!bvhVar.d ? !this.bi : this.bi) {
            i8 = 1;
        }
        ao(czoVar, cztVar, bvhVar, i8);
        eq(czoVar);
        this.be.l = this.bf.l() == 0 && this.bf.i() == 0;
        this.be.getClass();
        this.be.i = 0;
        if (bvhVar.d) {
            dk(bvhVar.b, bvhVar.c);
            bvj bvjVar2 = this.be;
            bvjVar2.h = iN2;
            cq(czoVar, bvjVar2, cztVar, false);
            bvj bvjVar3 = this.be;
            i3 = bvjVar3.b;
            int i11 = bvjVar3.d;
            int i12 = bvjVar3.c;
            if (i12 > 0) {
                iK += i12;
            }
            dj(bvhVar.b, bvhVar.c);
            bvj bvjVar4 = this.be;
            bvjVar4.h = iK;
            bvjVar4.d += bvjVar4.e;
            cq(czoVar, bvjVar4, cztVar, false);
            bvj bvjVar5 = this.be;
            i2 = bvjVar5.b;
            int i13 = bvjVar5.c;
            if (i13 > 0) {
                dk(i11, i3);
                bvj bvjVar6 = this.be;
                bvjVar6.h = i13;
                cq(czoVar, bvjVar6, cztVar, false);
                i3 = this.be.b;
            }
        } else {
            dj(bvhVar.b, bvhVar.c);
            bvj bvjVar7 = this.be;
            bvjVar7.h = iK;
            cq(czoVar, bvjVar7, cztVar, false);
            bvj bvjVar8 = this.be;
            i2 = bvjVar8.b;
            int i14 = bvjVar8.d;
            int i15 = bvjVar8.c;
            if (i15 > 0) {
                iN2 += i15;
            }
            dk(bvhVar.b, bvhVar.c);
            bvj bvjVar9 = this.be;
            bvjVar9.h = iN2;
            bvjVar9.d += bvjVar9.e;
            cq(czoVar, bvjVar9, cztVar, false);
            bvj bvjVar10 = this.be;
            int i16 = bvjVar10.b;
            int i17 = bvjVar10.c;
            if (i17 > 0) {
                dj(i14, i2);
                bvj bvjVar11 = this.be;
                bvjVar11.h = i17;
                cq(czoVar, bvjVar11, cztVar, false);
                i2 = this.be.b;
            }
            i3 = i16;
        }
        if (es() > 0) {
            if (this.bi ^ this.bj) {
                int iCx2 = cx(i2, czoVar, cztVar, true);
                i4 = i3 + iCx2;
                i5 = i2 + iCx2;
                iCx = cy(i4, czoVar, cztVar, false);
            } else {
                int iCy = cy(i3, czoVar, cztVar, true);
                i4 = i3 + iCy;
                i5 = i2 + iCy;
                iCx = cx(i5, czoVar, cztVar, false);
            }
            i3 = i4 + iCx;
            i2 = i5 + iCx;
        }
        if (cztVar.k && es() != 0 && !cztVar.g && ak()) {
            List list2 = czoVar.d;
            int size = list2.size();
            int iEl = czg.el(er(0));
            int iF = 0;
            int iF2 = 0;
            for (int i18 = 0; i18 < size; i18++) {
                czx czxVar = (czx) list2.get(i18);
                boolean zAf = czxVar.af();
                View view = czxVar.d;
                if (!zAf) {
                    if ((czxVar.z() < iEl) != this.bi) {
                        iF += this.bf.f(view);
                    } else {
                        iF2 += this.bf.f(view);
                    }
                }
            }
            this.be.k = list2;
            if (iF > 0) {
                dk(czg.el(da()), i3);
                bvj bvjVar12 = this.be;
                bvjVar12.h = iF;
                bvjVar12.c = 0;
                bvjVar12.m(null);
                cq(czoVar, this.be, cztVar, false);
            }
            if (iF2 > 0) {
                dj(czg.el(cz()), i2);
                bvj bvjVar13 = this.be;
                bvjVar13.h = iF2;
                bvjVar13.c = 0;
                list = null;
                bvjVar13.m(null);
                cq(czoVar, this.be, cztVar, false);
            } else {
                list = null;
            }
            this.be.k = list;
        }
        if (cztVar.g) {
            bvhVar.i();
        } else {
            atb atbVar2 = this.bf;
            atbVar2.a = atbVar2.o();
        }
        this.bg = this.bj;
    }

    @Override // me.hd.wauxv.obf.czg
    public void af(czt cztVar) {
        this.bn = null;
        this.bl = -1;
        this.bm = Integer.MIN_VALUE;
        this.bo.i();
    }

    @Override // me.hd.wauxv.obf.czg
    public boolean ag(int i, Bundle bundle) {
        int iMin;
        if (super.ag(i, bundle)) {
            return true;
        }
        if (i == 16908343 && bundle != null) {
            if (this.bd == 1) {
                int i2 = bundle.getInt("android.view.accessibility.action.ARGUMENT_ROW_INT", -1);
                if (i2 < 0) {
                    return false;
                }
                RecyclerView recyclerView = this.dp;
                iMin = Math.min(i2, v(recyclerView.m, recyclerView.bo) - 1);
            } else {
                int i3 = bundle.getInt("android.view.accessibility.action.ARGUMENT_COLUMN_INT", -1);
                if (i3 < 0) {
                    return false;
                }
                RecyclerView recyclerView2 = this.dp;
                iMin = Math.min(i3, u(recyclerView2.m, recyclerView2.bo) - 1);
            }
            if (iMin >= 0) {
                dg(iMin, 0);
                return true;
            }
        }
        return false;
    }

    @Override // me.hd.wauxv.obf.czg
    public int ah(int i, czo czoVar, czt cztVar) {
        if (this.bd == 1) {
            return 0;
        }
        return df(i, czoVar, cztVar);
    }

    @Override // me.hd.wauxv.obf.czg
    public int ai(int i, czo czoVar, czt cztVar) {
        if (this.bd == 0) {
            return 0;
        }
        return df(i, czoVar, cztVar);
    }

    @Override // me.hd.wauxv.obf.czg
    public boolean ak() {
        return this.bn == null && this.bg == this.bj;
    }

    public void al(czt cztVar, bvj bvjVar, bpq bpqVar) {
        int i = bvjVar.d;
        if (i < 0 || i >= cztVar.p()) {
            return;
        }
        bpqVar.f(i, Math.max(0, bvjVar.g));
    }

    /* JADX WARN: Found duplicated region for block: B:33:0x0075 */
    /* JADX WARN: Found duplicated region for block: B:35:0x0079 */
    public View am(czo czoVar, czt cztVar, boolean z, boolean z2) {
        int i;
        int iEs;
        int i2;
        cp();
        int iEs2 = es();
        if (z2) {
            iEs = es() - 1;
            i = -1;
            i2 = -1;
        } else {
            i = iEs2;
            iEs = 0;
            i2 = 1;
        }
        int iP = cztVar.p();
        int iN = this.bf.n();
        int iJ = this.bf.j();
        View view = null;
        View view2 = null;
        View view3 = null;
        while (iEs != i) {
            View viewEr = er(iEs);
            int iEl = czg.el(viewEr);
            int iH = this.bf.locateDex(viewEr);
            int iE = this.bf.e(viewEr);
            if (iEl >= 0 && iEl < iP) {
                if (!((czh) viewEr.getLayoutParams()).c.af()) {
                    boolean z3 = iE <= iN && iH < iN;
                    boolean z4 = iH >= iJ && iE > iJ;
                    if (!z3 && !z4) {
                        return viewEr;
                    }
                    if (z) {
                        if (z4) {
                            view2 = viewEr;
                        } else if (view == null) {
                            view = viewEr;
                        }
                    } else if (z3) {
                        view2 = viewEr;
                    } else if (view == null) {
                        view = viewEr;
                    }
                } else if (view3 == null) {
                    view3 = viewEr;
                }
            }
            iEs += i2;
        }
        return view != null ? view : view2 != null ? view2 : view3;
    }

    public void an(czo czoVar, czt cztVar, bvj bvjVar, bvi bviVar) {
        int iEv;
        int i;
        int i2;
        int iG;
        View viewN = bvjVar.n(czoVar);
        if (viewN == null) {
            bviVar.b = true;
            return;
        }
        czh czhVar = (czh) viewN.getLayoutParams();
        if (bvjVar.k == null) {
            if (this.bi == (bvjVar.f == -1)) {
                ep(viewN, -1, false);
            } else {
                ep(viewN, 0, false);
            }
        } else {
            if (this.bi == (bvjVar.f == -1)) {
                ep(viewN, -1, true);
            } else {
                ep(viewN, 0, true);
            }
        }
        czh czhVar2 = (czh) viewN.getLayoutParams();
        Rect rectDw = this.dp.dw(viewN);
        int i3 = rectDw.left + rectDw.right;
        int i4 = rectDw.top + rectDw.bottom;
        int iEe = czg.ee(this.eb, this.dz,
                ew() + ev() + ((ViewGroup.MarginLayoutParams) czhVar2).leftMargin
                        + ((ViewGroup.MarginLayoutParams) czhVar2).rightMargin + i3,
                ((ViewGroup.MarginLayoutParams) czhVar2).width, bu());
        int iEe2 = czg.ee(this.ec, this.ea,
                eu() + ex() + ((ViewGroup.MarginLayoutParams) czhVar2).topMargin
                        + ((ViewGroup.MarginLayoutParams) czhVar2).bottomMargin + i4,
                ((ViewGroup.MarginLayoutParams) czhVar2).height, bv());
        if (fk(viewN, iEe, iEe2, czhVar2)) {
            viewN.measure(iEe, iEe2);
        }
        bviVar.a = this.bf.f(viewN);
        if (this.bd == 1) {
            if (db()) {
                iG = this.eb - ew();
                iEv = iG - this.bf.g(viewN);
            } else {
                iEv = ev();
                iG = this.bf.g(viewN) + iEv;
            }
            if (bvjVar.f == -1) {
                i = bvjVar.b;
                i2 = i - bviVar.a;
            } else {
                i2 = bvjVar.b;
                i = bviVar.a + i2;
            }
        } else {
            int iEx = ex();
            int iG2 = this.bf.g(viewN) + iEx;
            if (bvjVar.f == -1) {
                int i5 = bvjVar.b;
                int i6 = i5 - bviVar.a;
                iG = i5;
                i = iG2;
                iEv = i6;
                i2 = iEx;
            } else {
                int i7 = bvjVar.b;
                int i8 = bviVar.a + i7;
                iEv = i7;
                i = iG2;
                i2 = iEx;
                iG = i8;
            }
        }
        czg.eo(viewN, iEv, i2, iG, i);
        if (czhVar.c.af() || czhVar.c.ai()) {
            bviVar.c = true;
        }
        bviVar.d = viewN.hasFocusable();
    }

    public void ao(czo czoVar, czt cztVar, bvh bvhVar, int i) {
    }

    public void ap(boolean z) {
        bt(null);
        if (this.bj == z) {
            return;
        }
        this.bj = z;
        ff();
    }

    @Override // me.hd.wauxv.obf.czs
    public final PointF bs(int i) {
        if (es() == 0) {
            return null;
        }
        int i2 = (i < czg.el(er(0))) != this.bi ? -1 : 1;
        return this.bd == 0 ? new PointF(i2, 0.0f) : new PointF(0.0f, i2);
    }

    @Override // me.hd.wauxv.obf.czg
    public final void bt(String str) {
        if (this.bn == null) {
            super.bt(str);
        }
    }

    @Override // me.hd.wauxv.obf.czg
    public final boolean bu() {
        return this.bd == 0;
    }

    @Override // me.hd.wauxv.obf.czg
    public final boolean bv() {
        return this.bd == 1;
    }

    @Override // me.hd.wauxv.obf.czg
    public final void bw(int i, int i2, czt cztVar, bpq bpqVar) {
        if (this.bd != 0) {
            i = i2;
        }
        if (es() == 0 || i == 0) {
            return;
        }
        cp();
        di(i > 0 ? 1 : -1, Math.abs(i), true, cztVar);
        al(cztVar, this.be, bpqVar);
    }

    @Override // me.hd.wauxv.obf.czg
    public final void bx(int i, bpq bpqVar) {
        boolean z;
        int i2;
        bvk bvkVar = this.bn;
        if (bvkVar == null || (i2 = bvkVar.a) < 0) {
            de();
            z = this.bi;
            i2 = this.bl;
            if (i2 == -1) {
                i2 = z ? i - 1 : 0;
            }
        } else {
            z = bvkVar.c;
        }
        int i3 = z ? -1 : 1;
        for (int i4 = 0; i4 < this.bq && i2 >= 0 && i2 < i; i4++) {
            bpqVar.f(i2, 0);
            i2 += i3;
        }
    }

    @Override // me.hd.wauxv.obf.czg
    public final int by(czt cztVar) {
        return cl(cztVar);
    }

    @Override // me.hd.wauxv.obf.czg
    public final int bz(czt cztVar) {
        return cl(cztVar);
    }

    @Override // me.hd.wauxv.obf.czg
    public final View ca(int i) {
        int iEs = es();
        if (iEs == 0) {
            return null;
        }
        int iEl = i - czg.el(er(0));
        if (iEl >= 0 && iEl < iEs) {
            View viewEr = er(iEl);
            if (czg.el(viewEr) == i) {
                return viewEr;
            }
        }
        return super.ca(i);
    }

    @Override // me.hd.wauxv.obf.czg
    public final boolean cb() {
        return true;
    }

    @Override // me.hd.wauxv.obf.czg
    public final boolean cc() {
        return this.bh;
    }

    @Override // me.hd.wauxv.obf.czg
    public void cd(RecyclerView recyclerView) {
    }

    @Override // me.hd.wauxv.obf.czg
    public final void ce(AccessibilityEvent accessibilityEvent) {
        super.ce(accessibilityEvent);
        if (es() > 0) {
            accessibilityEvent.setFromIndex(ct());
            accessibilityEvent.setToIndex(cu());
        }
    }

    @Override // me.hd.wauxv.obf.czg
    public final void cf(Parcelable parcelable) {
        if (parcelable instanceof bvk) {
            bvk bvkVar = (bvk) parcelable;
            this.bn = bvkVar;
            if (this.bl != -1) {
                bvkVar.a = -1;
            }
            ff();
        }
    }

    @Override // me.hd.wauxv.obf.czg
    public final Parcelable cg() {
        bvk bvkVar = this.bn;
        if (bvkVar != null) {
            bvk bvkVar2 = new bvk();
            bvkVar2.a = bvkVar.a;
            bvkVar2.b = bvkVar.b;
            bvkVar2.c = bvkVar.c;
            return bvkVar2;
        }
        bvk bvkVar3 = new bvk();
        if (es() <= 0) {
            bvkVar3.a = -1;
            return bvkVar3;
        }
        cp();
        boolean z = this.bg ^ this.bi;
        bvkVar3.c = z;
        if (z) {
            View viewCz = cz();
            bvkVar3.b = this.bf.j() - this.bf.e(viewCz);
            bvkVar3.a = czg.el(viewCz);
            return bvkVar3;
        }
        View viewDa = da();
        bvkVar3.a = czg.el(viewDa);
        bvkVar3.b = this.bf.locateDex(viewDa) - this.bf.n();
        return bvkVar3;
    }

    @Override // me.hd.wauxv.obf.czg
    public void ch(int i) {
        this.bl = i;
        this.bm = Integer.MIN_VALUE;
        bvk bvkVar = this.bn;
        if (bvkVar != null) {
            bvkVar.a = -1;
        }
        ff();
    }

    @Override // me.hd.wauxv.obf.czg
    public final boolean ci() {
        if (this.ea != 1073741824 && this.dz != 1073741824) {
            int iEs = es();
            for (int i = 0; i < iEs; i++) {
                ViewGroup.LayoutParams layoutParams = er(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // me.hd.wauxv.obf.czg
    public void cj(RecyclerView recyclerView, czt cztVar, int i) {
        bvl bvlVar = new bvl(recyclerView.getContext());
        bvlVar.f = i;
        fm(bvlVar);
    }

    public void ck(czt cztVar, int[] iArr) {
        int i;
        int iO = cztVar.a != -1 ? this.bf.o() : 0;
        if (this.be.f == -1) {
            i = 0;
        } else {
            i = iO;
            iO = 0;
        }
        iArr[0] = iO;
        iArr[1] = i;
    }

    public final int cl(czt cztVar) {
        if (es() == 0) {
            return 0;
        }
        cp();
        atb atbVar = this.bf;
        boolean z = !this.bk;
        return cnf.au(cztVar, atbVar, cs(z), cr(z), this, this.bk);
    }

    public final int cm(czt cztVar) {
        if (es() == 0) {
            return 0;
        }
        cp();
        atb atbVar = this.bf;
        boolean z = !this.bk;
        return cnf.av(cztVar, atbVar, cs(z), cr(z), this, this.bk, this.bi);
    }

    public final int cn(czt cztVar) {
        if (es() == 0) {
            return 0;
        }
        cp();
        atb atbVar = this.bf;
        boolean z = !this.bk;
        return cnf.aw(cztVar, atbVar, cs(z), cr(z), this, this.bk);
    }

    public final int co(int i) {
        return i != 1
                ? i != 2 ? i != 17
                        ? i != 33
                                ? i != 66 ? (i == 130 && this.bd == 1) ? 1 : Integer.MIN_VALUE
                                        : this.bd == 0 ? 1 : Integer.MIN_VALUE
                                : this.bd == 1 ? -1 : Integer.MIN_VALUE
                        : this.bd == 0 ? -1 : Integer.MIN_VALUE : (this.bd != 1 && db()) ? -1 : 1
                : (this.bd != 1 && db()) ? 1 : -1;
    }

    public final void cp() {
        if (this.be == null) {
            bvj bvjVar = new bvj();
            bvjVar.a = true;
            bvjVar.h = 0;
            bvjVar.i = 0;
            bvjVar.k = null;
            this.be = bvjVar;
        }
    }

    public final int cq(czo czoVar, bvj bvjVar, czt cztVar, boolean z) {
        int i;
        int i2 = bvjVar.c;
        int i3 = bvjVar.g;
        if (i3 != Integer.MIN_VALUE) {
            if (i2 < 0) {
                bvjVar.g = i3 + i2;
            }
            dc(czoVar, bvjVar);
        }
        int i4 = bvjVar.c + bvjVar.h;
        while (true) {
            if ((!bvjVar.l && i4 <= 0) || (i = bvjVar.d) < 0 || i >= cztVar.p()) {
                break;
            }
            bvi bviVar = this.bp;
            bviVar.a = 0;
            bviVar.b = false;
            bviVar.c = false;
            bviVar.d = false;
            an(czoVar, cztVar, bvjVar, bviVar);
            if (!bviVar.b) {
                int i5 = bvjVar.b;
                int i6 = bviVar.a;
                bvjVar.b = (bvjVar.f * i6) + i5;
                if (!bviVar.c || bvjVar.k != null || !cztVar.g) {
                    bvjVar.c -= i6;
                    i4 -= i6;
                }
                int i7 = bvjVar.g;
                if (i7 != Integer.MIN_VALUE) {
                    int i8 = i7 + i6;
                    bvjVar.g = i8;
                    int i9 = bvjVar.c;
                    if (i9 < 0) {
                        bvjVar.g = i8 + i9;
                    }
                    dc(czoVar, bvjVar);
                }
                if (z && bviVar.d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i2 - bvjVar.c;
    }

    public final View cr(boolean z) {
        return this.bi ? cw(0, es(), z) : cw(es() - 1, -1, z);
    }

    public final View cs(boolean z) {
        return this.bi ? cw(es() - 1, -1, z) : cw(0, es(), z);
    }

    public int ct() {
        View viewCw = cw(0, es(), false);
        if (viewCw == null) {
            return -1;
        }
        return czg.el(viewCw);
    }

    public int cu() {
        View viewCw = cw(es() - 1, -1, false);
        if (viewCw == null) {
            return -1;
        }
        return czg.el(viewCw);
    }

    public final View cv(int i, int i2) {
        int i3;
        int i4;
        cp();
        if (i2 <= i && i2 >= i) {
            return er(i);
        }
        if (this.bf.locateDex(er(i)) < this.bf.n()) {
            i3 = 16644;
            i4 = 16388;
        } else {
            i3 = 4161;
            i4 = q.a.a;
        }
        return this.bd == 0 ? this.dq.j(i, i2, i3, i4) : this.dr.j(i, i2, i3, i4);
    }

    public final View cw(int i, int i2, boolean z) {
        cp();
        int i3 = z ? 24579 : 320;
        return this.bd == 0 ? this.dq.j(i, i2, i3, 320) : this.dr.j(i, i2, i3, 320);
    }

    public final int cx(int i, czo czoVar, czt cztVar, boolean z) {
        int iJ;
        int iJ2 = this.bf.j() - i;
        if (iJ2 <= 0) {
            return 0;
        }
        int i2 = -df(-iJ2, czoVar, cztVar);
        int i3 = i + i2;
        if (!z || (iJ = this.bf.j() - i3) <= 0) {
            return i2;
        }
        this.bf.r(iJ);
        return iJ + i2;
    }

    public final int cy(int i, czo czoVar, czt cztVar, boolean z) {
        int iN;
        int iN2 = i - this.bf.n();
        if (iN2 <= 0) {
            return 0;
        }
        int i2 = -df(iN2, czoVar, cztVar);
        int i3 = i + i2;
        if (!z || (iN = i3 - this.bf.n()) <= 0) {
            return i2;
        }
        this.bf.r(-iN);
        return i2 - iN;
    }

    public final View cz() {
        return er(this.bi ? 0 : es() - 1);
    }

    public final View da() {
        return er(this.bi ? es() - 1 : 0);
    }

    public final boolean db() {
        return this.dp.getLayoutDirection() == 1;
    }

    public final void dc(czo czoVar, bvj bvjVar) {
        if (!bvjVar.a || bvjVar.l) {
            return;
        }
        int i = bvjVar.g;
        int i2 = bvjVar.i;
        if (bvjVar.f == -1) {
            int iEs = es();
            if (i < 0) {
                return;
            }
            int i3 = (this.bf.i() - i) + i2;
            if (this.bi) {
                for (int i4 = 0; i4 < iEs; i4++) {
                    View viewEr = er(i4);
                    if (this.bf.locateDex(viewEr) < i3 || this.bf.q(viewEr) < i3) {
                        dd(czoVar, 0, i4);
                        return;
                    }
                }
                return;
            }
            int i5 = iEs - 1;
            for (int i6 = i5; i6 >= 0; i6--) {
                View viewEr2 = er(i6);
                if (this.bf.locateDex(viewEr2) < i3 || this.bf.q(viewEr2) < i3) {
                    dd(czoVar, i5, i6);
                    return;
                }
            }
            return;
        }
        if (i < 0) {
            return;
        }
        int i7 = i - i2;
        int iEs2 = es();
        if (!this.bi) {
            for (int i8 = 0; i8 < iEs2; i8++) {
                View viewEr3 = er(i8);
                if (this.bf.e(viewEr3) > i7 || this.bf.p(viewEr3) > i7) {
                    dd(czoVar, 0, i8);
                    return;
                }
            }
            return;
        }
        int i9 = iEs2 - 1;
        for (int i10 = i9; i10 >= 0; i10--) {
            View viewEr4 = er(i10);
            if (this.bf.e(viewEr4) > i7 || this.bf.p(viewEr4) > i7) {
                dd(czoVar, i9, i10);
                return;
            }
        }
    }

    public final void dd(czo czoVar, int i, int i2) {
        if (i == i2) {
            return;
        }
        if (i2 <= i) {
            while (i > i2) {
                View viewEr = er(i);
                fe(i);
                czoVar.p(viewEr);
                i--;
            }
            return;
        }
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            View viewEr2 = er(i3);
            fe(i3);
            czoVar.p(viewEr2);
        }
    }

    public final void de() {
        if (this.bd == 1 || !db()) {
            this.bi = this.bh;
        } else {
            this.bi = !this.bh;
        }
    }

    public final int df(int i, czo czoVar, czt cztVar) {
        if (es() != 0 && i != 0) {
            cp();
            this.be.a = true;
            int i2 = i > 0 ? 1 : -1;
            int iAbs = Math.abs(i);
            di(i2, iAbs, true, cztVar);
            bvj bvjVar = this.be;
            int iCq = cq(czoVar, bvjVar, cztVar, false) + bvjVar.g;
            if (iCq >= 0) {
                if (iAbs > iCq) {
                    i = i2 * iCq;
                }
                this.bf.r(-i);
                this.be.j = i;
                return i;
            }
        }
        return 0;
    }

    public void dg(int i, int i2) {
        this.bl = i;
        this.bm = i2;
        bvk bvkVar = this.bn;
        if (bvkVar != null) {
            bvkVar.a = -1;
        }
        ff();
    }

    public final void dh(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException(concatVar2Var1(i, "invalid orientation:"));
        }
        bt(null);
        if (i != this.bd || this.bf == null) {
            atb atbVarD = atb.d(this, i);
            this.bf = atbVarD;
            this.bo.a = atbVarD;
            this.bd = i;
            ff();
        }
    }

    public final void di(int i, int i2, boolean z, czt cztVar) {
        int iN;
        this.be.l = this.bf.l() == 0 && this.bf.i() == 0;
        this.be.f = i;
        int[] iArr = this.br;
        iArr[0] = 0;
        iArr[1] = 0;
        ck(cztVar, iArr);
        int iMax = Math.max(0, iArr[0]);
        int iMax2 = Math.max(0, iArr[1]);
        boolean z2 = i == 1;
        bvj bvjVar = this.be;
        int i3 = z2 ? iMax2 : iMax;
        bvjVar.h = i3;
        if (!z2) {
            iMax = iMax2;
        }
        bvjVar.i = iMax;
        if (z2) {
            bvjVar.h = this.bf.k() + i3;
            View viewCz = cz();
            bvj bvjVar2 = this.be;
            bvjVar2.e = this.bi ? -1 : 1;
            int iEl = czg.el(viewCz);
            bvj bvjVar3 = this.be;
            bvjVar2.d = iEl + bvjVar3.e;
            bvjVar3.b = this.bf.e(viewCz);
            iN = this.bf.e(viewCz) - this.bf.j();
        } else {
            View viewDa = da();
            bvj bvjVar4 = this.be;
            bvjVar4.h = this.bf.n() + bvjVar4.h;
            bvj bvjVar5 = this.be;
            bvjVar5.e = this.bi ? 1 : -1;
            int iEl2 = czg.el(viewDa);
            bvj bvjVar6 = this.be;
            bvjVar5.d = iEl2 + bvjVar6.e;
            bvjVar6.b = this.bf.locateDex(viewDa);
            iN = (-this.bf.locateDex(viewDa)) + this.bf.n();
        }
        bvj bvjVar7 = this.be;
        bvjVar7.c = i2;
        if (z) {
            bvjVar7.c = i2 - iN;
        }
        bvjVar7.g = iN;
    }

    public final void dj(int i, int i2) {
        this.be.c = this.bf.j() - i2;
        bvj bvjVar = this.be;
        bvjVar.e = this.bi ? -1 : 1;
        bvjVar.d = i;
        bvjVar.f = 1;
        bvjVar.b = i2;
        bvjVar.g = Integer.MIN_VALUE;
    }

    public final void dk(int i, int i2) {
        this.be.c = i2 - this.bf.n();
        bvj bvjVar = this.be;
        bvjVar.d = i;
        bvjVar.e = this.bi ? 1 : -1;
        bvjVar.f = -1;
        bvjVar.b = i2;
        bvjVar.g = Integer.MIN_VALUE;
    }

    @Override // me.hd.wauxv.obf.czg
    public int n(czt cztVar) {
        return cm(cztVar);
    }

    @Override // me.hd.wauxv.obf.czg
    public int o(czt cztVar) {
        return cn(cztVar);
    }

    @Override // me.hd.wauxv.obf.czg
    public int p(czt cztVar) {
        return cm(cztVar);
    }

    @Override // me.hd.wauxv.obf.czg
    public int q(czt cztVar) {
        return cn(cztVar);
    }

    @Override // me.hd.wauxv.obf.czg
    public czh r() {
        return new czh(-2, -2);
    }

    @Override // me.hd.wauxv.obf.czg
    public View w(View view, int i, czo czoVar, czt cztVar) {
        int iCo;
        de();
        if (es() != 0 && (iCo = co(i)) != Integer.MIN_VALUE) {
            cp();
            di(iCo, (int) (this.bf.o() * 0.33333334f), false, cztVar);
            bvj bvjVar = this.be;
            bvjVar.g = Integer.MIN_VALUE;
            bvjVar.a = false;
            cq(czoVar, bvjVar, cztVar, true);
            View viewCv = iCo == -1 ? this.bi ? cv(es() - 1, -1) : cv(0, es())
                    : this.bi ? cv(0, es()) : cv(es() - 1, -1);
            View viewDa = iCo == -1 ? da() : cz();
            if (!viewDa.hasFocusable()) {
                return viewCv;
            }
            if (viewCv != null) {
                return viewDa;
            }
        }
        return null;
    }

    @Override // me.hd.wauxv.obf.czg
    public void x(czo czoVar, czt cztVar, bd bdVar) {
        super.x(czoVar, cztVar, bdVar);
        cyw cywVar = this.dp.w;
        if (cywVar == null || cywVar.d() <= 0) {
            return;
        }
        bdVar.e(ax.g);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.bd = 1;
        this.bh = false;
        this.bi = false;
        this.bj = false;
        this.bk = true;
        this.bl = -1;
        this.bm = Integer.MIN_VALUE;
        this.bn = null;
        this.bo = new bvh();
        this.bp = new bvi();
        this.bq = 2;
        this.br = new int[2];
        czf czfVarEm = czg.em(context, attributeSet, i, i2);
        dh(czfVarEm.a);
        boolean z = czfVarEm.c;
        bt(null);
        if (z != this.bh) {
            this.bh = z;
            ff();
        }
        ap(czfVarEm.d);
    }
}
