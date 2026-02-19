package me.hd.wauxv.obf;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class eps extends eun {
    public alz a;
    public od b;

    @Override // me.hd.wauxv.obf.alx
    public final void c(alx alxVar) {
        float f;
        float f2;
        float f3;
        int i;
        if (StaticHelpers6.ae(this.t) == 3) {
            adq adqVar = this.l;
            z(adqVar.at, adqVar.av, 1);
            return;
        }
        anp anpVar = this.o;
        if (anpVar.d && !anpVar.k && this.n == 3) {
            adq adqVar2 = this.l;
            int i2 = adqVar2.ac;
            if (i2 == 2) {
                adq adqVar3 = adqVar2.bd;
                if (adqVar3 != null) {
                    if (adqVar3.o.o.k) {
                        anpVar.p((int) ((r5.h * adqVar2.aj) + 0.5f));
                    }
                }
            } else if (i2 == 3) {
                anp anpVar2 = adqVar2.n.o;
                if (anpVar2.k) {
                    int i3 = adqVar2.bh;
                    if (i3 != -1) {
                        if (i3 == 0) {
                            f3 = anpVar2.h * adqVar2.bg;
                            i = (int) (f3 + 0.5f);
                        } else if (i3 != 1) {
                            i = 0;
                        } else {
                            f = anpVar2.h;
                            f2 = adqVar2.bg;
                        }
                        anpVar.p(i);
                    } else {
                        f = anpVar2.h;
                        f2 = adqVar2.bg;
                    }
                    f3 = f / f2;
                    i = (int) (f3 + 0.5f);
                    anpVar.p(i);
                }
            }
        }
        alz alzVar = this.r;
        boolean z = alzVar.d;
        ArrayList arrayList = alzVar.m;
        if (z) {
            alz alzVar2 = this.s;
            boolean z2 = alzVar2.d;
            ArrayList arrayList2 = alzVar2.m;
            if (z2) {
                if (alzVar.k && alzVar2.k && anpVar.k) {
                    return;
                }
                if (!anpVar.k && this.n == 3) {
                    adq adqVar4 = this.l;
                    if (adqVar4.ab == 0 && !adqVar4.cy()) {
                        alz alzVar3 = (alz) arrayList.get(0);
                        alz alzVar4 = (alz) arrayList2.get(0);
                        int i4 = alzVar3.h + alzVar.g;
                        int i5 = alzVar4.h + alzVar2.g;
                        alzVar.p(i4);
                        alzVar2.p(i5);
                        anpVar.p(i5 - i4);
                        return;
                    }
                }
                if (!anpVar.k && this.n == 3 && this.k == 1 && arrayList.size() > 0 && arrayList2.size() > 0) {
                    alz alzVar5 = (alz) arrayList.get(0);
                    int i6 = (((alz) arrayList2.get(0)).h + alzVar2.g) - (alzVar5.h + alzVar.g);
                    int i7 = anpVar.q;
                    if (i6 < i7) {
                        anpVar.p(i6);
                    } else {
                        anpVar.p(i7);
                    }
                }
                if (anpVar.k && arrayList.size() > 0 && arrayList2.size() > 0) {
                    alz alzVar6 = (alz) arrayList.get(0);
                    alz alzVar7 = (alz) arrayList2.get(0);
                    int i8 = alzVar6.h;
                    int i9 = alzVar.g + i8;
                    int i10 = alzVar7.h;
                    int i11 = alzVar2.g + i10;
                    float f4 = this.l.bo;
                    if (alzVar6 == alzVar7) {
                        f4 = 0.5f;
                    } else {
                        i8 = i9;
                        i10 = i11;
                    }
                    alzVar.p((int) ((((i10 - i8) - anpVar.h) * f4) + i8 + 0.5f));
                    alzVar2.p(alzVar.h + anpVar.h);
                }
            }
        }
    }

    @Override // me.hd.wauxv.obf.eun
    public final void d() {
        adq adqVar;
        adq adqVar2;
        adq adqVar3;
        adq adqVar4;
        alz alzVar = this.a;
        adq adqVar5 = this.l;
        boolean z = adqVar5.k;
        anp anpVar = this.o;
        if (z) {
            anpVar.p(adqVar5.cm());
        }
        boolean z2 = anpVar.k;
        ArrayList arrayList = anpVar.l;
        ArrayList arrayList2 = anpVar.m;
        alz alzVar2 = this.s;
        alz alzVar3 = this.r;
        if (!z2) {
            adq adqVar6 = this.l;
            this.n = adqVar6.bz[1];
            if (adqVar6.ao) {
                this.b = new od(this);
            }
            int i = this.n;
            if (i != 3) {
                if (i == 4 && (adqVar4 = this.l.bd) != null && adqVar4.bz[1] == 1) {
                    int iCm = (adqVar4.cm() - this.l.at.n()) - this.l.av.n();
                    eun.u(alzVar3, adqVar4.o.r, this.l.at.n());
                    eun.u(alzVar2, adqVar4.o.s, -this.l.av.n());
                    anpVar.p(iCm);
                    return;
                }
                if (i == 1) {
                    anpVar.p(this.l.cm());
                }
            }
        } else if (this.n == 4 && (adqVar2 = (adqVar = this.l).bd) != null && adqVar2.bz[1] == 1) {
            eun.u(alzVar3, adqVar2.o.r, adqVar.at.n());
            eun.u(alzVar2, adqVar2.o.s, -this.l.av.n());
            return;
        }
        boolean z3 = anpVar.k;
        if (z3) {
            adq adqVar7 = this.l;
            if (adqVar7.k) {
                adb[] adbVarArr = adqVar7.ba;
                adb adbVar = adbVarArr[2];
                adb adbVar2 = adbVar.f;
                if (adbVar2 != null && adbVarArr[3].f != null) {
                    if (adqVar7.cy()) {
                        alzVar3.g = this.l.ba[2].n();
                        alzVar2.g = -this.l.ba[3].n();
                    } else {
                        alz alzVarV = eun.v(this.l.ba[2]);
                        if (alzVarV != null) {
                            eun.u(alzVar3, alzVarV, this.l.ba[2].n());
                        }
                        alz alzVarV2 = eun.v(this.l.ba[3]);
                        if (alzVarV2 != null) {
                            eun.u(alzVar2, alzVarV2, -this.l.ba[3].n());
                        }
                        alzVar3.b = true;
                        alzVar2.b = true;
                    }
                    adq adqVar8 = this.l;
                    if (adqVar8.ao) {
                        eun.u(alzVar, alzVar3, adqVar8.bk);
                        return;
                    }
                    return;
                }
                if (adbVar2 != null) {
                    alz alzVarV3 = eun.v(adbVar);
                    if (alzVarV3 != null) {
                        eun.u(alzVar3, alzVarV3, this.l.ba[2].n());
                        eun.u(alzVar2, alzVar3, anpVar.h);
                        adq adqVar9 = this.l;
                        if (adqVar9.ao) {
                            eun.u(alzVar, alzVar3, adqVar9.bk);
                            return;
                        }
                        return;
                    }
                    return;
                }
                adb adbVar3 = adbVarArr[3];
                if (adbVar3.f != null) {
                    alz alzVarV4 = eun.v(adbVar3);
                    if (alzVarV4 != null) {
                        eun.u(alzVar2, alzVarV4, -this.l.ba[3].n());
                        eun.u(alzVar3, alzVar2, -anpVar.h);
                    }
                    adq adqVar10 = this.l;
                    if (adqVar10.ao) {
                        eun.u(alzVar, alzVar3, adqVar10.bk);
                        return;
                    }
                    return;
                }
                adb adbVar4 = adbVarArr[4];
                if (adbVar4.f != null) {
                    alz alzVarV5 = eun.v(adbVar4);
                    if (alzVarV5 != null) {
                        eun.u(alzVar, alzVarV5, 0);
                        eun.u(alzVar3, alzVar, -this.l.bk);
                        eun.u(alzVar2, alzVar3, anpVar.h);
                        return;
                    }
                    return;
                }
                if ((adqVar7 instanceof bkw) || adqVar7.bd == null || adqVar7.ck(7).f != null) {
                    return;
                }
                adq adqVar11 = this.l;
                eun.u(alzVar3, adqVar11.bd.o.r, adqVar11.cs());
                eun.u(alzVar2, alzVar3, anpVar.h);
                adq adqVar12 = this.l;
                if (adqVar12.ao) {
                    eun.u(alzVar, alzVar3, adqVar12.bk);
                    return;
                }
                return;
            }
        }
        if (z3 || this.n != 3) {
            anpVar.n(this);
        } else {
            adq adqVar13 = this.l;
            int i2 = adqVar13.ac;
            if (i2 == 2) {
                adq adqVar14 = adqVar13.bd;
                if (adqVar14 != null) {
                    anp anpVar2 = adqVar14.o.o;
                    arrayList2.add(anpVar2);
                    anpVar2.l.add(anpVar);
                    anpVar.b = true;
                    arrayList.add(alzVar3);
                    arrayList.add(alzVar2);
                }
            } else if (i2 == 3 && !adqVar13.cy()) {
                adq adqVar15 = this.l;
                if (adqVar15.ab != 3) {
                    anp anpVar3 = adqVar15.n.o;
                    arrayList2.add(anpVar3);
                    anpVar3.l.add(anpVar);
                    anpVar.b = true;
                    arrayList.add(alzVar3);
                    arrayList.add(alzVar2);
                }
            }
        }
        adq adqVar16 = this.l;
        adb[] adbVarArr2 = adqVar16.ba;
        adb adbVar5 = adbVarArr2[2];
        adb adbVar6 = adbVar5.f;
        if (adbVar6 != null && adbVarArr2[3].f != null) {
            if (adqVar16.cy()) {
                alzVar3.g = this.l.ba[2].n();
                alzVar2.g = -this.l.ba[3].n();
            } else {
                alz alzVarV6 = eun.v(this.l.ba[2]);
                alz alzVarV7 = eun.v(this.l.ba[3]);
                if (alzVarV6 != null) {
                    alzVarV6.n(this);
                }
                if (alzVarV7 != null) {
                    alzVarV7.n(this);
                }
                this.t = 4;
            }
            if (this.l.ao) {
                x(alzVar, alzVar3, 1, this.b);
            }
        } else if (adbVar6 != null) {
            alz alzVarV8 = eun.v(adbVar5);
            if (alzVarV8 != null) {
                eun.u(alzVar3, alzVarV8, this.l.ba[2].n());
                x(alzVar2, alzVar3, 1, anpVar);
                if (this.l.ao) {
                    x(alzVar, alzVar3, 1, this.b);
                }
                if (this.n == 3) {
                    adq adqVar17 = this.l;
                    if (adqVar17.bg > 0.0f) {
                        bmn bmnVar = adqVar17.n;
                        if (bmnVar.n == 3) {
                            bmnVar.o.l.add(anpVar);
                            arrayList2.add(this.l.n.o);
                            anpVar.a = this;
                        }
                    }
                }
            }
        } else {
            adb adbVar7 = adbVarArr2[3];
            if (adbVar7.f != null) {
                alz alzVarV9 = eun.v(adbVar7);
                if (alzVarV9 != null) {
                    eun.u(alzVar2, alzVarV9, -this.l.ba[3].n());
                    x(alzVar3, alzVar2, -1, anpVar);
                    if (this.l.ao) {
                        x(alzVar, alzVar3, 1, this.b);
                    }
                }
            } else {
                adb adbVar8 = adbVarArr2[4];
                if (adbVar8.f != null) {
                    alz alzVarV10 = eun.v(adbVar8);
                    if (alzVarV10 != null) {
                        eun.u(alzVar, alzVarV10, 0);
                        x(alzVar3, alzVar, -1, this.b);
                        x(alzVar2, alzVar3, 1, anpVar);
                    }
                } else if (!(adqVar16 instanceof bkw) && (adqVar3 = adqVar16.bd) != null) {
                    eun.u(alzVar3, adqVar3.o.r, adqVar16.cs());
                    x(alzVar2, alzVar3, 1, anpVar);
                    if (this.l.ao) {
                        x(alzVar, alzVar3, 1, this.b);
                    }
                    if (this.n == 3) {
                        adq adqVar18 = this.l;
                        if (adqVar18.bg > 0.0f) {
                            bmn bmnVar2 = adqVar18.n;
                            if (bmnVar2.n == 3) {
                                bmnVar2.o.l.add(anpVar);
                                arrayList2.add(this.l.n.o);
                                anpVar.a = this;
                            }
                        }
                    }
                }
            }
        }
        if (arrayList2.size() == 0) {
            anpVar.d = true;
        }
    }

    @Override // me.hd.wauxv.obf.eun
    public final void e() {
        alz alzVar = this.r;
        if (alzVar.k) {
            this.l.bj = alzVar.h;
        }
    }

    @Override // me.hd.wauxv.obf.eun
    public final void f() {
        this.m = null;
        this.r.o();
        this.s.o();
        this.a.o();
        this.o.o();
        this.q = false;
    }

    @Override // me.hd.wauxv.obf.eun
    public final boolean h() {
        return this.n != 3 || this.l.ac == 0;
    }

    public final void i() {
        this.q = false;
        alz alzVar = this.r;
        alzVar.o();
        alzVar.k = false;
        alz alzVar2 = this.s;
        alzVar2.o();
        alzVar2.k = false;
        alz alzVar3 = this.a;
        alzVar3.o();
        alzVar3.k = false;
        this.o.k = false;
    }

    public final String toString() {
        return "VerticalRun " + this.l.br;
    }
}
