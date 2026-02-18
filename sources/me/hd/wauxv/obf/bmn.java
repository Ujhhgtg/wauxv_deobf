package me.hd.wauxv.obf;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bmn extends eun {
    public static final int[] a = new int[2];

    public static void b(int[] iArr, int i, int i2, int i3, int i4, float f, int i5) {
        int i6 = i2 - i;
        int i7 = i4 - i3;
        if (i5 != -1) {
            if (i5 == 0) {
                iArr[0] = (int) ((i7 * f) + 0.5f);
                iArr[1] = i7;
                return;
            } else {
                if (i5 != 1) {
                    return;
                }
                iArr[0] = i6;
                iArr[1] = (int) ((i6 * f) + 0.5f);
                return;
            }
        }
        int i8 = (int) ((i7 * f) + 0.5f);
        int i9 = (int) ((i6 / f) + 0.5f);
        if (i8 <= i6) {
            iArr[0] = i8;
            iArr[1] = i7;
        } else if (i9 <= i7) {
            iArr[0] = i6;
            iArr[1] = i9;
        }
    }

    /* JADX WARN: Found duplicated region for block: B:116:0x0268  */
    /* JADX WARN: Found duplicated region for block: B:118:0x0278  */
    /* JADX WARN: Found duplicated region for block: B:11:0x0026  */
    @Override // me.hd.wauxv.obf.alx
    public final void c(alx alxVar) {
        float f;
        int iY;
        int i;
        int iY2;
        float f2;
        float f3;
        float f4;
        int i2;
        if (dkz.ae(this.t) == 3) {
            adq adqVar = this.l;
            z(adqVar.as, adqVar.au, 0);
            return;
        }
        anp anpVar = this.o;
        boolean z = anpVar.k;
        alz alzVar = this.r;
        alz alzVar2 = this.s;
        if (z || this.n != 3) {
            f = 0.5f;
        } else {
            adq adqVar2 = this.l;
            int i3 = adqVar2.ab;
            if (i3 == 2) {
                f = 0.5f;
                adq adqVar3 = adqVar2.bd;
                if (adqVar3 != null) {
                    if (adqVar3.n.o.k) {
                        anpVar.p((int) ((r5.h * adqVar2.ag) + 0.5f));
                    }
                }
            } else if (i3 == 3) {
                int i4 = adqVar2.ac;
                if (i4 == 0 || i4 == 3) {
                    eps epsVar = adqVar2.o;
                    alz alzVar3 = epsVar.r;
                    alz alzVar4 = epsVar.s;
                    boolean z2 = adqVar2.as.f != null;
                    boolean z3 = adqVar2.at.f != null;
                    boolean z4 = adqVar2.au.f != null;
                    boolean z5 = adqVar2.av.f != null;
                    f = 0.5f;
                    int i5 = adqVar2.bh;
                    if (z2 && z3 && z4 && z5) {
                        float f5 = adqVar2.bg;
                        boolean z6 = alzVar3.k;
                        ArrayList arrayList = alzVar3.m;
                        int[] iArr = a;
                        if (z6 && alzVar4.k) {
                            if (alzVar.d && alzVar2.d) {
                                b(iArr, ((alz) alzVar.m.get(0)).h + alzVar.g, ((alz) alzVar2.m.get(0)).h - alzVar2.g, alzVar3.h + alzVar3.g, alzVar4.h - alzVar4.g, f5, i5);
                                anpVar.p(iArr[0]);
                                this.l.o.o.p(iArr[1]);
                                return;
                            }
                            return;
                        }
                        if (alzVar.k && alzVar2.k) {
                            if (!alzVar3.d || !alzVar4.d) {
                                return;
                            }
                            b(iArr, alzVar.h + alzVar.g, alzVar2.h - alzVar2.g, ((alz) arrayList.get(0)).h + alzVar3.g, ((alz) alzVar4.m.get(0)).h - alzVar4.g, f5, i5);
                            anpVar.p(iArr[0]);
                            this.l.o.o.p(iArr[1]);
                        }
                        if (!alzVar.d || !alzVar2.d || !alzVar3.d || !alzVar4.d) {
                            return;
                        }
                        b(iArr, ((alz) alzVar.m.get(0)).h + alzVar.g, ((alz) alzVar2.m.get(0)).h - alzVar2.g, ((alz) arrayList.get(0)).h + alzVar3.g, ((alz) alzVar4.m.get(0)).h - alzVar4.g, f5, i5);
                        anpVar.p(iArr[0]);
                        this.l.o.o.p(iArr[1]);
                    } else if (z2 && z4) {
                        if (!alzVar.d || !alzVar2.d) {
                            return;
                        }
                        float f6 = adqVar2.bg;
                        int i6 = ((alz) alzVar.m.get(0)).h + alzVar.g;
                        int i7 = ((alz) alzVar2.m.get(0)).h - alzVar2.g;
                        if (i5 == -1 || i5 == 0) {
                            int iY3 = y(i7 - i6, 0);
                            int i8 = (int) ((iY3 * f6) + 0.5f);
                            int iY4 = y(i8, 1);
                            if (i8 != iY4) {
                                iY3 = (int) ((iY4 / f6) + 0.5f);
                            }
                            anpVar.p(iY3);
                            this.l.o.o.p(iY4);
                        } else if (i5 == 1) {
                            int iY5 = y(i7 - i6, 0);
                            int i9 = (int) ((iY5 / f6) + 0.5f);
                            int iY6 = y(i9, 1);
                            if (i9 != iY6) {
                                iY5 = (int) ((iY6 * f6) + 0.5f);
                            }
                            anpVar.p(iY5);
                            this.l.o.o.p(iY6);
                        }
                    } else if (z3 && z5) {
                        if (!alzVar3.d || !alzVar4.d) {
                            return;
                        }
                        float f7 = adqVar2.bg;
                        int i10 = ((alz) alzVar3.m.get(0)).h + alzVar3.g;
                        int i11 = ((alz) alzVar4.m.get(0)).h - alzVar4.g;
                        if (i5 == -1) {
                            iY = y(i11 - i10, 1);
                            i = (int) ((iY / f7) + 0.5f);
                            iY2 = y(i, 0);
                            if (i != iY2) {
                                iY = (int) ((iY2 * f7) + 0.5f);
                            }
                            anpVar.p(iY2);
                            this.l.o.o.p(iY);
                        } else if (i5 == 0) {
                            int iY7 = y(i11 - i10, 1);
                            int i12 = (int) ((iY7 * f7) + 0.5f);
                            int iY8 = y(i12, 0);
                            if (i12 != iY8) {
                                iY7 = (int) ((iY8 / f7) + 0.5f);
                            }
                            anpVar.p(iY8);
                            this.l.o.o.p(iY7);
                        } else if (i5 == 1) {
                            iY = y(i11 - i10, 1);
                            i = (int) ((iY / f7) + 0.5f);
                            iY2 = y(i, 0);
                            if (i != iY2) {
                                iY = (int) ((iY2 * f7) + 0.5f);
                            }
                            anpVar.p(iY2);
                            this.l.o.o.p(iY);
                        }
                    }
                } else {
                    int i13 = adqVar2.bh;
                    if (i13 != -1) {
                        if (i13 == 0) {
                            f4 = adqVar2.o.o.h / adqVar2.bg;
                            i2 = (int) (f4 + 0.5f);
                        } else if (i13 != 1) {
                            i2 = 0;
                        } else {
                            f2 = adqVar2.o.o.h;
                            f3 = adqVar2.bg;
                        }
                        anpVar.p(i2);
                        f = 0.5f;
                    } else {
                        f2 = adqVar2.o.o.h;
                        f3 = adqVar2.bg;
                    }
                    f4 = f2 * f3;
                    i2 = (int) (f4 + 0.5f);
                    anpVar.p(i2);
                    f = 0.5f;
                }
            } else {
                f = 0.5f;
            }
        }
        boolean z7 = alzVar.d;
        ArrayList arrayList2 = alzVar.m;
        if (z7) {
            boolean z8 = alzVar2.d;
            ArrayList arrayList3 = alzVar2.m;
            if (z8) {
                if (alzVar.k && alzVar2.k && anpVar.k) {
                    return;
                }
                if (!anpVar.k && this.n == 3) {
                    adq adqVar4 = this.l;
                    if (adqVar4.ab == 0 && !adqVar4.cx()) {
                        alz alzVar5 = (alz) arrayList2.get(0);
                        alz alzVar6 = (alz) arrayList3.get(0);
                        int i14 = alzVar5.h + alzVar.g;
                        int i15 = alzVar6.h + alzVar2.g;
                        alzVar.p(i14);
                        alzVar2.p(i15);
                        anpVar.p(i15 - i14);
                        return;
                    }
                }
                if (!anpVar.k && this.n == 3 && this.k == 1 && arrayList2.size() > 0 && arrayList3.size() > 0) {
                    int iMin = Math.min((((alz) arrayList3.get(0)).h + alzVar2.g) - (((alz) arrayList2.get(0)).h + alzVar.g), anpVar.q);
                    adq adqVar5 = this.l;
                    int i16 = adqVar5.af;
                    int iMax = Math.max(adqVar5.ae, iMin);
                    if (i16 > 0) {
                        iMax = Math.min(i16, iMax);
                    }
                    anpVar.p(iMax);
                }
                if (anpVar.k) {
                    alz alzVar7 = (alz) arrayList2.get(0);
                    alz alzVar8 = (alz) arrayList3.get(0);
                    int i17 = alzVar7.h;
                    int i18 = alzVar.g + i17;
                    int i19 = alzVar8.h;
                    int i20 = alzVar2.g + i19;
                    float f8 = this.l.bn;
                    if (alzVar7 == alzVar8) {
                        f8 = f;
                    } else {
                        i17 = i18;
                        i19 = i20;
                    }
                    alzVar.p((int) ((((i19 - i17) - anpVar.h) * f8) + i17 + f));
                    alzVar2.p(alzVar.h + anpVar.h);
                }
            }
        }
    }

    @Override // me.hd.wauxv.obf.eun
    public final void d() {
        adq adqVar;
        adq adqVar2;
        int i;
        adq adqVar3;
        adq adqVar4;
        int i2;
        adq adqVar5 = this.l;
        boolean z = adqVar5.k;
        anp anpVar = this.o;
        if (z) {
            anpVar.p(adqVar5.cq());
        }
        boolean z2 = anpVar.k;
        ArrayList arrayList = anpVar.l;
        ArrayList arrayList2 = anpVar.m;
        alz alzVar = this.s;
        alz alzVar2 = this.r;
        if (!z2) {
            adq adqVar6 = this.l;
            int i3 = adqVar6.bz[0];
            this.n = i3;
            if (i3 != 3) {
                if (i3 == 4 && (adqVar4 = adqVar6.bd) != null && ((i2 = adqVar4.bz[0]) == 1 || i2 == 4)) {
                    int iCq = (adqVar4.cq() - this.l.as.n()) - this.l.au.n();
                    eun.u(alzVar2, adqVar4.n.r, this.l.as.n());
                    eun.u(alzVar, adqVar4.n.s, -this.l.au.n());
                    anpVar.p(iCq);
                    return;
                }
                if (i3 == 1) {
                    anpVar.p(adqVar6.cq());
                }
            }
        } else if (this.n == 4 && (adqVar2 = (adqVar = this.l).bd) != null && ((i = adqVar2.bz[0]) == 1 || i == 4)) {
            eun.u(alzVar2, adqVar2.n.r, adqVar.as.n());
            eun.u(alzVar, adqVar2.n.s, -this.l.au.n());
            return;
        }
        if (anpVar.k) {
            adq adqVar7 = this.l;
            if (adqVar7.k) {
                adb[] adbVarArr = adqVar7.ba;
                adb adbVar = adbVarArr[0];
                adb adbVar2 = adbVar.f;
                if (adbVar2 != null && adbVarArr[1].f != null) {
                    if (adqVar7.cx()) {
                        alzVar2.g = this.l.ba[0].n();
                        alzVar.g = -this.l.ba[1].n();
                        return;
                    }
                    alz alzVarV = eun.v(this.l.ba[0]);
                    if (alzVarV != null) {
                        eun.u(alzVar2, alzVarV, this.l.ba[0].n());
                    }
                    alz alzVarV2 = eun.v(this.l.ba[1]);
                    if (alzVarV2 != null) {
                        eun.u(alzVar, alzVarV2, -this.l.ba[1].n());
                    }
                    alzVar2.b = true;
                    alzVar.b = true;
                    return;
                }
                if (adbVar2 != null) {
                    alz alzVarV3 = eun.v(adbVar);
                    if (alzVarV3 != null) {
                        eun.u(alzVar2, alzVarV3, this.l.ba[0].n());
                        eun.u(alzVar, alzVar2, anpVar.h);
                        return;
                    }
                    return;
                }
                adb adbVar3 = adbVarArr[1];
                if (adbVar3.f != null) {
                    alz alzVarV4 = eun.v(adbVar3);
                    if (alzVarV4 != null) {
                        eun.u(alzVar, alzVarV4, -this.l.ba[1].n());
                        eun.u(alzVar2, alzVar, -anpVar.h);
                        return;
                    }
                    return;
                }
                if ((adqVar7 instanceof bkw) || adqVar7.bd == null || adqVar7.ck(7).f != null) {
                    return;
                }
                adq adqVar8 = this.l;
                eun.u(alzVar2, adqVar8.bd.n.r, adqVar8.cr());
                eun.u(alzVar, alzVar2, anpVar.h);
                return;
            }
        }
        if (this.n == 3) {
            adq adqVar9 = this.l;
            int i4 = adqVar9.ab;
            if (i4 == 2) {
                adq adqVar10 = adqVar9.bd;
                if (adqVar10 != null) {
                    anp anpVar2 = adqVar10.o.o;
                    arrayList2.add(anpVar2);
                    anpVar2.l.add(anpVar);
                    anpVar.b = true;
                    arrayList.add(alzVar2);
                    arrayList.add(alzVar);
                }
            } else if (i4 == 3) {
                if (adqVar9.ac == 3) {
                    alzVar2.a = this;
                    alzVar.a = this;
                    eps epsVar = adqVar9.o;
                    epsVar.r.a = this;
                    epsVar.s.a = this;
                    anpVar.a = this;
                    if (adqVar9.cy()) {
                        arrayList2.add(this.l.o.o);
                        this.l.o.o.l.add(anpVar);
                        eps epsVar2 = this.l.o;
                        epsVar2.o.a = this;
                        arrayList2.add(epsVar2.r);
                        arrayList2.add(this.l.o.s);
                        this.l.o.r.l.add(anpVar);
                        this.l.o.s.l.add(anpVar);
                    } else if (this.l.cx()) {
                        this.l.o.o.m.add(anpVar);
                        arrayList.add(this.l.o.o);
                    } else {
                        this.l.o.o.m.add(anpVar);
                    }
                } else {
                    anp anpVar3 = adqVar9.o.o;
                    arrayList2.add(anpVar3);
                    anpVar3.l.add(anpVar);
                    this.l.o.r.l.add(anpVar);
                    this.l.o.s.l.add(anpVar);
                    anpVar.b = true;
                    arrayList.add(alzVar2);
                    arrayList.add(alzVar);
                    alzVar2.m.add(anpVar);
                    alzVar.m.add(anpVar);
                }
            }
        }
        adq adqVar11 = this.l;
        adb[] adbVarArr2 = adqVar11.ba;
        adb adbVar4 = adbVarArr2[0];
        adb adbVar5 = adbVar4.f;
        if (adbVar5 != null && adbVarArr2[1].f != null) {
            if (adqVar11.cx()) {
                alzVar2.g = this.l.ba[0].n();
                alzVar.g = -this.l.ba[1].n();
                return;
            }
            alz alzVarV5 = eun.v(this.l.ba[0]);
            alz alzVarV6 = eun.v(this.l.ba[1]);
            if (alzVarV5 != null) {
                alzVarV5.n(this);
            }
            if (alzVarV6 != null) {
                alzVarV6.n(this);
            }
            this.t = 4;
            return;
        }
        if (adbVar5 != null) {
            alz alzVarV7 = eun.v(adbVar4);
            if (alzVarV7 != null) {
                eun.u(alzVar2, alzVarV7, this.l.ba[0].n());
                x(alzVar, alzVar2, 1, anpVar);
                return;
            }
            return;
        }
        adb adbVar6 = adbVarArr2[1];
        if (adbVar6.f != null) {
            alz alzVarV8 = eun.v(adbVar6);
            if (alzVarV8 != null) {
                eun.u(alzVar, alzVarV8, -this.l.ba[1].n());
                x(alzVar2, alzVar, -1, anpVar);
                return;
            }
            return;
        }
        if ((adqVar11 instanceof bkw) || (adqVar3 = adqVar11.bd) == null) {
            return;
        }
        eun.u(alzVar2, adqVar3.n.r, adqVar11.cr());
        x(alzVar, alzVar2, 1, anpVar);
    }

    @Override // me.hd.wauxv.obf.eun
    public final void e() {
        alz alzVar = this.r;
        if (alzVar.k) {
            this.l.bi = alzVar.h;
        }
    }

    @Override // me.hd.wauxv.obf.eun
    public final void f() {
        this.m = null;
        this.r.o();
        this.s.o();
        this.o.o();
        this.q = false;
    }

    @Override // me.hd.wauxv.obf.eun
    public final boolean h() {
        return this.n != 3 || this.l.ab == 0;
    }

    public final void i() {
        this.q = false;
        alz alzVar = this.r;
        alzVar.o();
        alzVar.k = false;
        alz alzVar2 = this.s;
        alzVar2.o();
        alzVar2.k = false;
        this.o.k = false;
    }

    public final String toString() {
        return "HorizontalRun " + this.l.br;
    }
}
