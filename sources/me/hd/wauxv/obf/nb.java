package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class nb extends bkw {
    public int a;
    public boolean b;
    public int c;
    public boolean d;

    @Override // me.hd.wauxv.obf.adq
    public final void e(bvm bvmVar, boolean z) {
        boolean z2;
        int i;
        int i2;
        adb[] adbVarArr = this.ba;
        adb adbVar = this.as;
        adbVarArr[0] = adbVar;
        int i3 = 2;
        adb adbVar2 = this.at;
        adbVarArr[2] = adbVar2;
        adb adbVar3 = this.au;
        adbVarArr[1] = adbVar3;
        adb adbVar4 = this.av;
        adbVarArr[3] = adbVar4;
        for (adb adbVar5 : adbVarArr) {
            adbVar5.i = bvmVar.ac(adbVar5);
        }
        int i4 = this.a;
        if (i4 < 0 || i4 >= 4) {
            return;
        }
        adb adbVar6 = adbVarArr[i4];
        if (!this.d) {
            i();
        }
        if (this.d) {
            this.d = false;
            int i5 = this.a;
            if (i5 == 0 || i5 == 1) {
                bvmVar.v(adbVar.i, this.bi);
                bvmVar.v(adbVar3.i, this.bi);
                return;
            } else {
                if (i5 == 2 || i5 == 3) {
                    bvmVar.v(adbVar2.i, this.bj);
                    bvmVar.v(adbVar4.i, this.bj);
                    return;
                }
                return;
            }
        }
        int i6 = 0;
        while (true) {
            if (i6 >= this.ew) {
                z2 = false;
                break;
            }
            adq adqVar = this.ev[i6];
            if ((this.b || adqVar.f()) && ((((i2 = this.a) == 0 || i2 == 1) && adqVar.bz[0] == 3 && adqVar.as.f != null && adqVar.au.f != null) || ((i2 == 2 || i2 == 3) && adqVar.bz[1] == 3 && adqVar.at.f != null && adqVar.av.f != null))) {
                z2 = true;
                break;
            }
            i6++;
        }
        boolean z3 = adbVar.p() || adbVar3.p();
        boolean z4 = adbVar2.p() || adbVar4.p();
        int i7 = !(!z2 && (((i = this.a) == 0 && z3) || ((i == 2 && z4) || ((i == 1 && z3) || (i == 3 && z4))))) ? 4 : 5;
        int i8 = 0;
        while (i8 < this.ew) {
            adq adqVar2 = this.ev[i8];
            if (this.b || adqVar2.f()) {
                dla dlaVarAc = bvmVar.ac(adqVar2.ba[this.a]);
                adb[] adbVarArr2 = adqVar2.ba;
                int i9 = this.a;
                adb adbVar7 = adbVarArr2[i9];
                adbVar7.i = dlaVarAc;
                adb adbVar8 = adbVar7.f;
                int i10 = (adbVar8 == null || adbVar8.d != this) ? 0 : adbVar7.g;
                if (i9 == 0 || i9 == i3) {
                    dla dlaVar = adbVar6.i;
                    int i11 = this.c - i10;
                    kw kwVarAd = bvmVar.ad();
                    dla dlaVarAe = bvmVar.ae();
                    dlaVarAe.d = 0;
                    kwVarAd.h(dlaVar, dlaVarAc, dlaVarAe, i11);
                    bvmVar.u(kwVarAd);
                } else {
                    dla dlaVar2 = adbVar6.i;
                    int i12 = this.c + i10;
                    kw kwVarAd2 = bvmVar.ad();
                    dla dlaVarAe2 = bvmVar.ae();
                    dlaVarAe2.d = 0;
                    kwVarAd2.g(dlaVar2, dlaVarAc, dlaVarAe2, i12);
                    bvmVar.u(kwVarAd2);
                }
                bvmVar.w(adbVar6.i, dlaVarAc, this.c + i10, i7);
            }
            i8++;
            i3 = 2;
        }
        int i13 = this.a;
        if (i13 == 0) {
            bvmVar.w(adbVar3.i, adbVar.i, 0, 8);
            bvmVar.w(adbVar.i, this.bd.au.i, 0, 4);
            bvmVar.w(adbVar.i, this.bd.as.i, 0, 0);
            return;
        }
        if (i13 == 1) {
            bvmVar.w(adbVar.i, adbVar3.i, 0, 8);
            bvmVar.w(adbVar.i, this.bd.as.i, 0, 4);
            bvmVar.w(adbVar.i, this.bd.au.i, 0, 0);
        } else if (i13 == 2) {
            bvmVar.w(adbVar4.i, adbVar2.i, 0, 8);
            bvmVar.w(adbVar2.i, this.bd.av.i, 0, 4);
            bvmVar.w(adbVar2.i, this.bd.at.i, 0, 0);
        } else if (i13 == 3) {
            bvmVar.w(adbVar2.i, adbVar4.i, 0, 8);
            bvmVar.w(adbVar2.i, this.bd.at.i, 0, 4);
            bvmVar.w(adbVar2.i, this.bd.av.i, 0, 0);
        }
    }

    @Override // me.hd.wauxv.obf.adq
    public final boolean f() {
        return true;
    }

    @Override // me.hd.wauxv.obf.adq
    public final boolean g() {
        return this.d;
    }

    @Override // me.hd.wauxv.obf.adq
    public final boolean h() {
        return this.d;
    }

    public final boolean i() {
        int i;
        int i2;
        int i3;
        boolean z = true;
        int i4 = 0;
        while (true) {
            i = this.ew;
            if (i4 >= i) {
                break;
            }
            adq adqVar = this.ev[i4];
            if ((this.b || adqVar.f()) && ((((i2 = this.a) == 0 || i2 == 1) && !adqVar.g()) || (((i3 = this.a) == 2 || i3 == 3) && !adqVar.h()))) {
                z = false;
            }
            i4++;
        }
        if (!z || i <= 0) {
            return false;
        }
        int iMax = 0;
        boolean z2 = false;
        for (int i5 = 0; i5 < this.ew; i5++) {
            adq adqVar2 = this.ev[i5];
            if (this.b || adqVar2.f()) {
                if (!z2) {
                    int i6 = this.a;
                    if (i6 == 0) {
                        iMax = adqVar2.ck(2).m();
                    } else if (i6 == 1) {
                        iMax = adqVar2.ck(4).m();
                    } else if (i6 == 2) {
                        iMax = adqVar2.ck(3).m();
                    } else if (i6 == 3) {
                        iMax = adqVar2.ck(5).m();
                    }
                    z2 = true;
                }
                int i7 = this.a;
                if (i7 == 0) {
                    iMax = Math.min(iMax, adqVar2.ck(2).m());
                } else if (i7 == 1) {
                    iMax = Math.max(iMax, adqVar2.ck(4).m());
                } else if (i7 == 2) {
                    iMax = Math.min(iMax, adqVar2.ck(3).m());
                } else if (i7 == 3) {
                    iMax = Math.max(iMax, adqVar2.ck(5).m());
                }
            }
        }
        int i8 = iMax + this.c;
        int i9 = this.a;
        if (i9 == 0 || i9 == 1) {
            df(i8, i8);
        } else {
            dg(i8, i8);
        }
        this.d = true;
        return true;
    }

    public final int j() {
        int i = this.a;
        if (i == 0 || i == 1) {
            return 0;
        }
        return (i == 2 || i == 3) ? 1 : -1;
    }

    @Override // me.hd.wauxv.obf.adq
    public final String toString() {
        String strO = yg.concatToVar1(new StringBuilder("[Barrier] "), this.br, " {");
        for (int i = 0; i < this.ew; i++) {
            adq adqVar = this.ev[i];
            if (i > 0) {
                strO = dkz.s(strO, ", ");
            }
            StringBuilder sbY = dkz.y(strO);
            sbY.append(adqVar.br);
            strO = sbY.toString();
        }
        return dkz.s(strO, "}");
    }
}
