package me.hd.wauxv.obf;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bbp extends bkw {
    public int a;
    public int b;
    public int c;
    public int d;
    public boolean dn;

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public int f1do;
    public int dp;
    public of dq;
    public adg dr;
    public int ds;
    public int dt;
    public int du;
    public int dv;
    public int dw;
    public int dx;
    public float dy;
    public float dz;
    public float ea;
    public float eb;
    public float ec;
    public float ed;
    public int ee;
    public int ef;
    public int eg;
    public int eh;
    public int ei;
    public int ej;
    public int ek;
    public ArrayList el;
    public adq[] em;
    public adq[] en;
    public int[] eo;
    public adq[] ep;
    public int eq;
    public int i;
    public int j;

    @Override // me.hd.wauxv.obf.adq
    public final void e(bvm bvmVar, boolean z) {
        adq adqVar;
        float f;
        int i;
        ArrayList arrayList = this.el;
        super.e(bvmVar, z);
        adq adqVar2 = this.bd;
        boolean z2 = adqVar2 != null && ((adr) adqVar2).j;
        int i2 = this.ei;
        if (i2 != 0) {
            if (i2 == 1) {
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    ((bbo) arrayList.get(i3)).t(i3, z2, i3 == size + (-1));
                    i3++;
                }
            } else if (i2 != 2) {
                if (i2 == 3) {
                    int size2 = arrayList.size();
                    int i4 = 0;
                    while (i4 < size2) {
                        ((bbo) arrayList.get(i4)).t(i4, z2, i4 == size2 + (-1));
                        i4++;
                    }
                }
            } else if (this.eo != null && this.en != null && this.em != null) {
                for (int i5 = 0; i5 < this.eq; i5++) {
                    this.ep[i5].db();
                }
                int[] iArr = this.eo;
                int i6 = iArr[0];
                int i7 = iArr[1];
                float f2 = this.dy;
                adq adqVar3 = null;
                int i8 = 0;
                while (i8 < i6) {
                    if (z2) {
                        i = (i6 - i8) - 1;
                        f = 1.0f - this.dy;
                    } else {
                        f = f2;
                        i = i8;
                    }
                    adq adqVar4 = this.en[i];
                    if (adqVar4 != null) {
                        adb adbVar = adqVar4.as;
                        if (adqVar4.bq != 8) {
                            if (i8 == 0) {
                                adqVar4.ch(adbVar, this.as, this.i);
                                adqVar4.bs = this.ds;
                                adqVar4.bn = f;
                            }
                            if (i8 == i6 - 1) {
                                adqVar4.ch(adqVar4.au, this.au, this.j);
                            }
                            if (i8 > 0 && adqVar3 != null) {
                                adb adbVar2 = adqVar3.au;
                                adqVar4.ch(adbVar, adbVar2, this.ee);
                                adqVar3.ch(adbVar2, adbVar, 0);
                            }
                            adqVar3 = adqVar4;
                        }
                    }
                    i8++;
                    f2 = f;
                }
                for (int i9 = 0; i9 < i7; i9++) {
                    adq adqVar5 = this.em[i9];
                    if (adqVar5 != null) {
                        adb adbVar3 = adqVar5.at;
                        if (adqVar5.bq != 8) {
                            if (i9 == 0) {
                                adqVar5.ch(adbVar3, this.at, this.a);
                                adqVar5.bt = this.dt;
                                adqVar5.bo = this.dz;
                            }
                            if (i9 == i7 - 1) {
                                adqVar5.ch(adqVar5.av, this.av, this.b);
                            }
                            if (i9 > 0 && adqVar3 != null) {
                                adb adbVar4 = adqVar3.av;
                                adqVar5.ch(adbVar3, adbVar4, this.ef);
                                adqVar3.ch(adbVar4, adbVar3, 0);
                            }
                            adqVar3 = adqVar5;
                        }
                    }
                }
                for (int i10 = 0; i10 < i6; i10++) {
                    for (int i11 = 0; i11 < i7; i11++) {
                        int i12 = (i11 * i6) + i10;
                        if (this.ek == 1) {
                            i12 = (i10 * i7) + i11;
                        }
                        adq[] adqVarArr = this.ep;
                        if (i12 < adqVarArr.length && (adqVar = adqVarArr[i12]) != null && adqVar.bq != 8) {
                            adq adqVar6 = this.en[i10];
                            adq adqVar7 = this.em[i11];
                            if (adqVar != adqVar6) {
                                adqVar.ch(adqVar.as, adqVar6.as, 0);
                                adqVar.ch(adqVar.au, adqVar6.au, 0);
                            }
                            if (adqVar != adqVar7) {
                                adqVar.ch(adqVar.at, adqVar7.at, 0);
                                adqVar.ch(adqVar.av, adqVar7.av, 0);
                            }
                        }
                    }
                }
            }
        } else if (arrayList.size() > 0) {
            ((bbo) arrayList.get(0)).t(0, z2, true);
        }
        this.dn = false;
    }

    @Override // me.hd.wauxv.obf.bkw
    public final void er() {
        for (int i = 0; i < this.ew; i++) {
            adq adqVar = this.ev[i];
            if (adqVar != null) {
                adqVar.ap = true;
            }
        }
    }

    public final int es(adq adqVar, int i) {
        adq adqVar2;
        if (adqVar != null) {
            int[] iArr = adqVar.bz;
            if (iArr[1] == 3) {
                int i2 = adqVar.ac;
                if (i2 != 0) {
                    if (i2 == 2) {
                        int i3 = (int) (adqVar.aj * i);
                        if (i3 != adqVar.cm()) {
                            adqVar.q = true;
                            eu(iArr[0], adqVar.cq(), 1, i3, adqVar);
                        }
                        return i3;
                    }
                    adqVar2 = adqVar;
                    if (i2 == 1) {
                        return adqVar2.cm();
                    }
                    if (i2 == 3) {
                        return (int) ((adqVar2.cq() * adqVar2.bg) + 0.5f);
                    }
                }
            } else {
                adqVar2 = adqVar;
            }
            return adqVar2.cm();
        }
        return 0;
    }

    public final int et(adq adqVar, int i) {
        adq adqVar2;
        if (adqVar != null) {
            int[] iArr = adqVar.bz;
            if (iArr[0] == 3) {
                int i2 = adqVar.ab;
                if (i2 != 0) {
                    if (i2 == 2) {
                        int i3 = (int) (adqVar.ag * i);
                        if (i3 != adqVar.cq()) {
                            adqVar.q = true;
                            eu(1, i3, iArr[1], adqVar.cm(), adqVar);
                        }
                        return i3;
                    }
                    adqVar2 = adqVar;
                    if (i2 == 1) {
                        return adqVar2.cq();
                    }
                    if (i2 == 3) {
                        return (int) ((adqVar2.cm() * adqVar2.bg) + 0.5f);
                    }
                }
            } else {
                adqVar2 = adqVar;
            }
            return adqVar2.cq();
        }
        return 0;
    }

    public final void eu(int i, int i2, int i3, int i4, adq adqVar) {
        adg adgVar;
        adq adqVar2;
        of ofVar = this.dq;
        while (true) {
            adgVar = this.dr;
            if (adgVar != null || (adqVar2 = this.bd) == null) {
                break;
            } else {
                this.dr = ((adr) adqVar2).i;
            }
        }
        ofVar.a = i;
        ofVar.b = i3;
        ofVar.c = i2;
        ofVar.d = i4;
        adgVar.j(adqVar, ofVar);
        adqVar.dk(ofVar.e);
        adqVar.dh(ofVar.f);
        adqVar.ao = ofVar.h;
        adqVar.de(ofVar.g);
    }
}
