package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bbo {
    public int a;
    public adb d;
    public adb e;
    public adb f;
    public adb g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int q;
    public final /* synthetic */ bbp r;
    public adq b = null;
    public int c = 0;
    public int l = 0;
    public int m = 0;
    public int n = 0;
    public int o = 0;
    public int p = 0;

    public bbo(bbp bbpVar, int i, adb adbVar, adb adbVar2, adb adbVar3, adb adbVar4, int i2) {
        this.r = bbpVar;
        this.a = i;
        this.d = adbVar;
        this.e = adbVar2;
        this.f = adbVar3;
        this.g = adbVar4;
        this.h = bbpVar.i;
        this.i = bbpVar.a;
        this.j = bbpVar.j;
        this.k = bbpVar.b;
        this.q = i2;
    }

    public final void s(adq adqVar) {
        int i = this.a;
        bbp bbpVar = this.r;
        if (i == 0) {
            int iEt = bbpVar.et(adqVar, this.q);
            if (adqVar.bz[0] == 3) {
                this.p++;
                iEt = 0;
            }
            this.l = iEt + (adqVar.bq != 8 ? bbpVar.ee : 0) + this.l;
            int iEs = bbpVar.es(adqVar, this.q);
            if (this.b == null || this.c < iEs) {
                this.b = adqVar;
                this.c = iEs;
                this.m = iEs;
            }
        } else {
            int iEt2 = bbpVar.et(adqVar, this.q);
            int iEs2 = bbpVar.es(adqVar, this.q);
            if (adqVar.bz[1] == 3) {
                this.p++;
                iEs2 = 0;
            }
            this.m = iEs2 + (adqVar.bq != 8 ? bbpVar.ef : 0) + this.m;
            if (this.b == null || this.c < iEt2) {
                this.b = adqVar;
                this.c = iEt2;
                this.l = iEt2;
            }
        }
        this.o++;
    }

    public final void t(int i, boolean z, boolean z2) {
        bbp bbpVar;
        int i2;
        int i3;
        adq adqVar;
        boolean z3;
        int i4;
        int i5;
        char c;
        float f;
        float f2;
        float f3;
        int i6;
        float f4;
        float f5;
        int i7;
        int i8 = this.o;
        int i9 = 0;
        while (true) {
            bbpVar = this.r;
            if (i9 >= i8 || (i7 = this.n + i9) >= bbpVar.eq) {
                break;
            }
            adq adqVar2 = bbpVar.ep[i7];
            if (adqVar2 != null) {
                adqVar2.db();
            }
            i9++;
        }
        if (i8 == 0 || this.b == null) {
            return;
        }
        boolean z4 = z2 && i == 0;
        int i10 = -1;
        int i11 = -1;
        for (int i12 = 0; i12 < i8; i12++) {
            int i13 = this.n + (z ? (i8 - 1) - i12 : i12);
            if (i13 >= bbpVar.eq) {
                break;
            }
            adq adqVar3 = bbpVar.ep[i13];
            if (adqVar3 != null && adqVar3.bq == 0) {
                if (i10 == -1) {
                    i10 = i12;
                }
                i11 = i12;
            }
        }
        if (this.a == 0) {
            adq adqVar4 = this.b;
            adqVar4.bt = bbpVar.dt;
            adb adbVar = adqVar4.av;
            adb adbVar2 = adqVar4.at;
            int i14 = this.i;
            if (i > 0) {
                i14 += bbpVar.ef;
            }
            adbVar2.j(this.e, i14);
            if (z2) {
                adbVar.j(this.g, this.k);
            }
            if (i > 0) {
                this.e.d.av.j(adbVar2, 0);
            }
            if (bbpVar.eh != 3 || adqVar4.ao) {
                adqVar = adqVar4;
                break;
            }
            int i15 = 0;
            while (true) {
                if (i15 < i8) {
                    int i16 = this.n + (z ? (i8 - 1) - i15 : i15);
                    if (i16 < bbpVar.eq) {
                        adqVar = bbpVar.ep[i16];
                        if (adqVar.ao) {
                            break;
                        } else {
                            i15++;
                        }
                    }
                }
                adqVar = adqVar4;
                break;
            }
            int i17 = 0;
            adq adqVar5 = null;
            while (i17 < i8) {
                int i18 = z ? (i8 - 1) - i17 : i17;
                int i19 = this.n + i18;
                if (i19 >= bbpVar.eq) {
                    return;
                }
                adq adqVar6 = bbpVar.ep[i19];
                if (adqVar6 == null) {
                    i5 = i8;
                    z3 = z4;
                    i4 = i11;
                    c = 3;
                } else {
                    adb adbVar3 = adqVar6.av;
                    adb adbVar4 = adqVar6.at;
                    adb adbVar5 = adqVar6.as;
                    z3 = z4;
                    if (i17 == 0) {
                        i4 = i11;
                        adqVar6.ch(adbVar5, this.d, this.h);
                    } else {
                        i4 = i11;
                    }
                    if (i18 == 0) {
                        int i20 = bbpVar.ds;
                        if (z) {
                            f = 1.0f;
                            f2 = 1.0f - bbpVar.dy;
                        } else {
                            f = 1.0f;
                            f2 = bbpVar.dy;
                        }
                        if (this.n == 0) {
                            i6 = bbpVar.du;
                            f3 = f2;
                            if (i6 != -1) {
                                if (z) {
                                    f5 = bbpVar.ea;
                                    f4 = f - f5;
                                } else {
                                    f4 = bbpVar.ea;
                                }
                            }
                            adqVar6.bs = i6;
                            adqVar6.bn = f4;
                        } else {
                            f3 = f2;
                        }
                        if (!z2 || (i6 = bbpVar.dw) == -1) {
                            i6 = i20;
                            f4 = f3;
                        } else if (z) {
                            f5 = bbpVar.ec;
                            f4 = f - f5;
                        } else {
                            f4 = bbpVar.ec;
                        }
                        adqVar6.bs = i6;
                        adqVar6.bn = f4;
                    }
                    if (i17 == i8 - 1) {
                        i5 = i8;
                        adqVar6.ch(adqVar6.au, this.f, this.j);
                    } else {
                        i5 = i8;
                    }
                    if (adqVar5 != null) {
                        adb adbVar6 = adqVar5.au;
                        adbVar5.j(adbVar6, bbpVar.ee);
                        if (i17 == i10) {
                            int i21 = this.h;
                            if (adbVar5.q()) {
                                adbVar5.h = i21;
                            }
                        }
                        adbVar6.j(adbVar5, 0);
                        if (i17 == i4 + 1) {
                            int i22 = this.j;
                            if (adbVar6.q()) {
                                adbVar6.h = i22;
                            }
                        }
                    }
                    if (adqVar6 != adqVar4) {
                        int i23 = bbpVar.eh;
                        c = 3;
                        if (i23 == 3 && adqVar.ao && adqVar6 != adqVar && adqVar6.ao) {
                            adqVar6.aw.j(adqVar.aw, 0);
                        } else if (i23 == 0) {
                            adbVar4.j(adbVar2, 0);
                        } else if (i23 == 1) {
                            adbVar3.j(adbVar, 0);
                        } else if (z3) {
                            adbVar4.j(this.e, this.i);
                            adbVar3.j(this.g, this.k);
                        } else {
                            adbVar4.j(adbVar2, 0);
                            adbVar3.j(adbVar, 0);
                        }
                    } else {
                        c = 3;
                    }
                    adqVar5 = adqVar6;
                }
                i17++;
                z4 = z3;
                i11 = i4;
                i8 = i5;
            }
            return;
        }
        int i24 = i8;
        boolean z5 = z4;
        int i25 = i11;
        adq adqVar7 = this.b;
        adqVar7.bs = bbpVar.ds;
        adb adbVar7 = adqVar7.as;
        adb adbVar8 = adqVar7.au;
        int i26 = this.h;
        if (i > 0) {
            i26 += bbpVar.ee;
        }
        if (z) {
            adbVar8.j(this.f, i26);
            if (z2) {
                adbVar7.j(this.d, this.j);
            }
            if (i > 0) {
                this.f.d.as.j(adbVar8, 0);
            }
        } else {
            adbVar7.j(this.d, i26);
            if (z2) {
                adbVar8.j(this.f, this.j);
            }
            if (i > 0) {
                this.d.d.au.j(adbVar7, 0);
            }
        }
        int i27 = 0;
        adq adqVar8 = null;
        while (true) {
            int i28 = i24;
            if (i27 >= i28 || (i2 = this.n + i27) >= bbpVar.eq) {
                return;
            }
            adq adqVar9 = bbpVar.ep[i2];
            if (adqVar9 == null) {
                i24 = i28;
            } else {
                adb adbVar9 = adqVar9.at;
                adb adbVar10 = adqVar9.au;
                adb adbVar11 = adqVar9.as;
                if (i27 == 0) {
                    adqVar9.ch(adbVar9, this.e, this.i);
                    int i29 = bbpVar.dt;
                    float f6 = bbpVar.dz;
                    if (this.n == 0) {
                        int i30 = bbpVar.dv;
                        i24 = i28;
                        i3 = -1;
                        if (i30 != -1) {
                            f6 = bbpVar.eb;
                        }
                        i29 = i30;
                        adqVar9.bt = i29;
                        adqVar9.bo = f6;
                    } else {
                        i24 = i28;
                        i3 = -1;
                    }
                    if (z2 && (i30 = bbpVar.dx) != i3) {
                        f6 = bbpVar.ed;
                        i29 = i30;
                    }
                    adqVar9.bt = i29;
                    adqVar9.bo = f6;
                } else {
                    i24 = i28;
                }
                if (i27 == i24 - 1) {
                    adqVar9.ch(adqVar9.av, this.g, this.k);
                }
                if (adqVar8 != null) {
                    adb adbVar12 = adqVar8.av;
                    adbVar9.j(adbVar12, bbpVar.ef);
                    if (i27 == i10) {
                        int i31 = this.i;
                        if (adbVar9.q()) {
                            adbVar9.h = i31;
                        }
                    }
                    adbVar12.j(adbVar9, 0);
                    if (i27 == i25 + 1) {
                        int i32 = this.k;
                        if (adbVar12.q()) {
                            adbVar12.h = i32;
                        }
                    }
                }
                if (adqVar9 != adqVar7) {
                    if (z) {
                        int i33 = bbpVar.eg;
                        if (i33 == 0) {
                            adbVar10.j(adbVar8, 0);
                        } else if (i33 == 1) {
                            adbVar11.j(adbVar7, 0);
                        } else if (i33 == 2) {
                            adbVar11.j(adbVar7, 0);
                            adbVar10.j(adbVar8, 0);
                        }
                    } else {
                        int i34 = bbpVar.eg;
                        if (i34 == 0) {
                            adbVar11.j(adbVar7, 0);
                        } else if (i34 == 1) {
                            adbVar10.j(adbVar8, 0);
                        } else if (i34 == 2) {
                            if (z5) {
                                adbVar11.j(this.d, this.h);
                                adbVar10.j(this.f, this.j);
                            } else {
                                adbVar11.j(adbVar7, 0);
                                adbVar10.j(adbVar8, 0);
                            }
                        }
                    }
                }
                adqVar8 = adqVar9;
            }
            i27++;
        }
    }

    public final int u() {
        return this.a == 1 ? this.m - this.r.ef : this.m;
    }

    public final int v() {
        return this.a == 0 ? this.l - this.r.ee : this.l;
    }

    public final void w(int i) {
        bbp bbpVar;
        int i2;
        int i3 = this.p;
        if (i3 == 0) {
            return;
        }
        int i4 = this.o;
        int i5 = i / i3;
        int i6 = 0;
        while (true) {
            bbpVar = this.r;
            if (i6 >= i4 || (i2 = this.n + i6) >= bbpVar.eq) {
                break;
            }
            adq adqVar = bbpVar.ep[i2];
            if (this.a == 0) {
                if (adqVar != null) {
                    int[] iArr = adqVar.bz;
                    if (iArr[0] == 3 && adqVar.ab == 0) {
                        bbpVar.eu(1, i5, iArr[1], adqVar.cm(), adqVar);
                    }
                }
            } else if (adqVar != null) {
                int[] iArr2 = adqVar.bz;
                if (iArr2[1] == 3 && adqVar.ac == 0) {
                    int i7 = i5;
                    bbpVar.eu(iArr2[0], adqVar.cq(), 1, i7, adqVar);
                    i5 = i7;
                }
            }
            i6++;
        }
        this.l = 0;
        this.m = 0;
        this.b = null;
        this.c = 0;
        int i8 = this.o;
        for (int i9 = 0; i9 < i8; i9++) {
            int i10 = this.n + i9;
            if (i10 >= bbpVar.eq) {
                return;
            }
            adq adqVar2 = bbpVar.ep[i10];
            if (this.a == 0) {
                int iCq = adqVar2.cq();
                int i11 = bbpVar.ee;
                if (adqVar2.bq == 8) {
                    i11 = 0;
                }
                this.l = iCq + i11 + this.l;
                int iEs = bbpVar.es(adqVar2, this.q);
                if (this.b == null || this.c < iEs) {
                    this.b = adqVar2;
                    this.c = iEs;
                    this.m = iEs;
                }
            } else {
                int iEt = bbpVar.et(adqVar2, this.q);
                int iEs2 = bbpVar.es(adqVar2, this.q);
                int i12 = bbpVar.ef;
                if (adqVar2.bq == 8) {
                    i12 = 0;
                }
                this.m = iEs2 + i12 + this.m;
                if (this.b == null || this.c < iEt) {
                    this.b = adqVar2;
                    this.c = iEt;
                    this.l = iEt;
                }
            }
        }
    }

    public final void x(int i, adb adbVar, adb adbVar2, adb adbVar3, adb adbVar4, int i2, int i3, int i4, int i5, int i6) {
        this.a = i;
        this.d = adbVar;
        this.e = adbVar2;
        this.f = adbVar3;
        this.g = adbVar4;
        this.h = i2;
        this.i = i3;
        this.j = i4;
        this.k = i5;
        this.q = i6;
    }
}
