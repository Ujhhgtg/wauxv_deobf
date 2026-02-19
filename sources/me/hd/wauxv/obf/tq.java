package me.hd.wauxv.obf;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class tq extends eun {
    public final ArrayList a;
    public int b;

    public tq(adq adqVar, int i) {
        adq adqVar2;
        super(adqVar);
        ArrayList<eun> arrayList = new ArrayList();
        this.a = arrayList;
        this.p = i;
        adq adqVar3 = this.l;
        adq adqVarCo = adqVar3.co(i);
        while (true) {
            adqVar2 = adqVar3;
            adqVar3 = adqVarCo;
            if (adqVar3 == null) {
                break;
            } else {
                adqVarCo = adqVar3.co(this.p);
            }
        }
        this.l = adqVar2;
        int i2 = this.p;
        arrayList.add(i2 == 0 ? adqVar2.n : i2 == 1 ? adqVar2.o : null);
        adq adqVarCn = adqVar2.cn(this.p);
        while (adqVarCn != null) {
            int i3 = this.p;
            arrayList.add(i3 == 0 ? adqVarCn.n : i3 == 1 ? adqVarCn.o : null);
            adqVarCn = adqVarCn.cn(this.p);
        }
        for (eun eunVar : arrayList) {
            int i4 = this.p;
            if (i4 == 0) {
                eunVar.l.l = this;
            } else if (i4 == 1) {
                eunVar.l.m = this;
            }
        }
        if (this.p == 0 && ((adr) this.l.bd).j && arrayList.size() > 1) {
            this.l = ((eun) StaticHelpers6.getLastNElem(1, arrayList)).l;
        }
        this.b = this.p == 0 ? this.l.bs : this.l.bt;
    }

    /* JADX WARN: Found duplicated region for block: B:293:0x00e8 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:62:0x00ce  */
    /* JADX WARN: Found duplicated region for block: B:64:0x00da  */
    /* JADX WARN: Found duplicated region for block: B:65:0x00dd  */
    /* JADX WARN: Found duplicated region for block: B:67:0x00e0 A[ADDED_TO_REGION] */
    @Override // me.hd.wauxv.obf.alx
    public final void c(alx alxVar) {
        int i;
        int i2;
        boolean z;
        float f;
        int i3;
        int i4;
        int i5;
        int i6;
        float f2;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        boolean z2;
        int i13;
        float f3;
        alz alzVar = this.r;
        if (alzVar.k) {
            alz alzVar2 = this.s;
            if (alzVar2.k) {
                adq adqVar = this.l.bd;
                boolean z3 = adqVar instanceof adr ? ((adr) adqVar).j : false;
                int i14 = alzVar2.h - alzVar.h;
                ArrayList arrayList = this.a;
                int size = arrayList.size();
                int i15 = 0;
                while (true) {
                    i = -1;
                    i2 = 8;
                    if (i15 >= size) {
                        i15 = -1;
                        break;
                    } else if (((eun) arrayList.get(i15)).l.bq != 8) {
                        break;
                    } else {
                        i15++;
                    }
                }
                int i16 = size - 1;
                for (int i17 = i16; i17 >= 0; i17--) {
                    if (((eun) arrayList.get(i17)).l.bq != 8) {
                        i = i17;
                        break;
                    }
                }
                int i18 = 0;
                while (true) {
                    if (i18 >= 2) {
                        z = z3;
                        f = 0.0f;
                        i3 = 0;
                        i4 = 0;
                        i5 = 0;
                        break;
                    }
                    f = 0.0f;
                    int i19 = 0;
                    i5 = 0;
                    int i20 = 0;
                    int i21 = 0;
                    while (i19 < size) {
                        eun eunVar = (eun) arrayList.get(i19);
                        adq adqVar2 = eunVar.l;
                        boolean z4 = z3;
                        if (adqVar2.bq == i2) {
                            i12 = i18;
                        } else {
                            i21++;
                            if (i19 > 0 && i19 >= i15) {
                                i5 += eunVar.r.g;
                            }
                            anp anpVar = eunVar.o;
                            int i22 = anpVar.h;
                            i12 = i18;
                            boolean z5 = eunVar.n != 3;
                            if (z5) {
                                int i23 = this.p;
                                if (i23 == 0 && !adqVar2.n.o.k) {
                                    return;
                                }
                                if (i23 == 1 && !adqVar2.o.o.k) {
                                    return;
                                } else {
                                    z2 = z5;
                                }
                            } else {
                                z2 = z5;
                                if (eunVar.k == 1 && i12 == 0) {
                                    i13 = anpVar.q;
                                    i20++;
                                } else {
                                    if (anpVar.k) {
                                        i13 = i22;
                                    }
                                    if (z2) {
                                        i5 += i13;
                                    } else {
                                        i20++;
                                        f3 = adqVar2.bu[this.p];
                                        if (f3 >= 0.0f) {
                                            f += f3;
                                        }
                                    }
                                    if (i19 >= i16 && i19 < i) {
                                        i5 += -eunVar.s.g;
                                    }
                                }
                                z2 = true;
                                if (z2) {
                                    i20++;
                                    f3 = adqVar2.bu[this.p];
                                    if (f3 >= 0.0f) {
                                        f += f3;
                                    }
                                } else {
                                    i5 += i13;
                                }
                                if (i19 >= i16) {
                                }
                            }
                            i13 = i22;
                            if (z2) {
                                i20++;
                                f3 = adqVar2.bu[this.p];
                                if (f3 >= 0.0f) {
                                    f += f3;
                                }
                            } else {
                                i5 += i13;
                            }
                            if (i19 >= i16) {
                            }
                        }
                        i19++;
                        z3 = z4;
                        i18 = i12;
                        i2 = 8;
                    }
                    z = z3;
                    int i24 = i18;
                    if (i5 < i14 || i20 == 0) {
                        i3 = i20;
                        i4 = i21;
                        break;
                    } else {
                        i18 = i24 + 1;
                        z3 = z;
                        i2 = 8;
                    }
                }
                int i25 = alzVar.h;
                if (z) {
                    i25 = alzVar2.h;
                }
                float f4 = 0.5f;
                if (i5 > i14) {
                    i25 = z ? i25 + ((int) (((i5 - i14) / 2.0f) + 0.5f)) : i25 - ((int) (((i5 - i14) / 2.0f) + 0.5f));
                }
                if (i3 > 0) {
                    float f5 = i14 - i5;
                    int i26 = (int) ((f5 / i3) + 0.5f);
                    int i27 = 0;
                    int i28 = 0;
                    while (i27 < size) {
                        float f6 = f4;
                        eun eunVar2 = (eun) arrayList.get(i27);
                        int i29 = i25;
                        adq adqVar3 = eunVar2.l;
                        int i30 = i3;
                        anp anpVar2 = eunVar2.o;
                        float f7 = f5;
                        int i31 = i26;
                        if (adqVar3.bq == 8 || eunVar2.n != 3 || anpVar2.k) {
                            i11 = i27;
                        } else {
                            int i32 = f > 0.0f ? (int) (((adqVar3.bu[this.p] * f7) / f) + f6) : i31;
                            if (this.p == 0) {
                                i9 = adqVar3.af;
                                i10 = adqVar3.ae;
                            } else {
                                i9 = adqVar3.ai;
                                i10 = adqVar3.ah;
                            }
                            i11 = i27;
                            int iMax = Math.max(i10, eunVar2.k == 1 ? Math.min(i32, anpVar2.q) : i32);
                            if (i9 > 0) {
                                iMax = Math.min(i9, iMax);
                            }
                            if (iMax != i32) {
                                i28++;
                                i32 = iMax;
                            }
                            anpVar2.p(i32);
                        }
                        i27 = i11 + 1;
                        i25 = i29;
                        f4 = f6;
                        i3 = i30;
                        f5 = f7;
                        i26 = i31;
                    }
                    i6 = i25;
                    f2 = f4;
                    int i33 = i3;
                    if (i28 > 0) {
                        i3 = i33 - i28;
                        i5 = 0;
                        for (int i34 = 0; i34 < size; i34++) {
                            eun eunVar3 = (eun) arrayList.get(i34);
                            if (eunVar3.l.bq != 8) {
                                if (i34 > 0 && i34 >= i15) {
                                    i5 += eunVar3.r.g;
                                }
                                i5 += eunVar3.o.h;
                                if (i34 < i16 && i34 < i) {
                                    i5 += -eunVar3.s.g;
                                }
                            }
                        }
                    } else {
                        i3 = i33;
                    }
                    i8 = 2;
                    if (this.b == 2 && i28 == 0) {
                        i7 = 0;
                        this.b = 0;
                    } else {
                        i7 = 0;
                    }
                } else {
                    i6 = i25;
                    f2 = 0.5f;
                    i7 = 0;
                    i8 = 2;
                }
                if (i5 > i14) {
                    this.b = i8;
                }
                if (i4 > 0 && i3 == 0 && i15 == i) {
                    this.b = i8;
                }
                int i35 = this.b;
                if (i35 == 1) {
                    int i36 = i4 > 1 ? (i14 - i5) / (i4 - 1) : i4 == 1 ? (i14 - i5) / 2 : i7;
                    if (i3 > 0) {
                        i36 = i7;
                    }
                    int i37 = i6;
                    for (int i38 = i7; i38 < size; i38++) {
                        eun eunVar4 = (eun) arrayList.get(z ? size - (i38 + 1) : i38);
                        adq adqVar4 = eunVar4.l;
                        alz alzVar3 = eunVar4.s;
                        alz alzVar4 = eunVar4.r;
                        if (adqVar4.bq == 8) {
                            alzVar4.p(i37);
                            alzVar3.p(i37);
                        } else {
                            if (i38 > 0) {
                                i37 = z ? i37 - i36 : i37 + i36;
                            }
                            if (i38 > 0 && i38 >= i15) {
                                i37 = z ? i37 - alzVar4.g : i37 + alzVar4.g;
                            }
                            if (z) {
                                alzVar3.p(i37);
                            } else {
                                alzVar4.p(i37);
                            }
                            anp anpVar3 = eunVar4.o;
                            int i39 = anpVar3.h;
                            if (eunVar4.n == 3 && eunVar4.k == 1) {
                                i39 = anpVar3.q;
                            }
                            i37 = z ? i37 - i39 : i37 + i39;
                            if (z) {
                                alzVar4.p(i37);
                            } else {
                                alzVar3.p(i37);
                            }
                            eunVar4.q = true;
                            if (i38 < i16 && i38 < i) {
                                i37 = z ? i37 - (-alzVar3.g) : i37 + (-alzVar3.g);
                            }
                        }
                    }
                    return;
                }
                if (i35 == 0) {
                    int i40 = (i14 - i5) / (i4 + 1);
                    if (i3 > 0) {
                        i40 = i7;
                    }
                    int i41 = i6;
                    for (int i42 = i7; i42 < size; i42++) {
                        eun eunVar5 = (eun) arrayList.get(z ? size - (i42 + 1) : i42);
                        adq adqVar5 = eunVar5.l;
                        alz alzVar5 = eunVar5.s;
                        alz alzVar6 = eunVar5.r;
                        if (adqVar5.bq == 8) {
                            alzVar6.p(i41);
                            alzVar5.p(i41);
                        } else {
                            int i43 = z ? i41 - i40 : i41 + i40;
                            if (i42 > 0 && i42 >= i15) {
                                i43 = z ? i43 - alzVar6.g : i43 + alzVar6.g;
                            }
                            if (z) {
                                alzVar5.p(i43);
                            } else {
                                alzVar6.p(i43);
                            }
                            anp anpVar4 = eunVar5.o;
                            int iMin = anpVar4.h;
                            if (eunVar5.n == 3 && eunVar5.k == 1) {
                                iMin = Math.min(iMin, anpVar4.q);
                            }
                            i41 = z ? i43 - iMin : i43 + iMin;
                            if (z) {
                                alzVar6.p(i41);
                            } else {
                                alzVar5.p(i41);
                            }
                            if (i42 < i16 && i42 < i) {
                                i41 = z ? i41 - (-alzVar5.g) : i41 + (-alzVar5.g);
                            }
                        }
                    }
                    return;
                }
                if (i35 == 2) {
                    float f8 = this.p == 0 ? this.l.bn : this.l.bo;
                    if (z) {
                        f8 = 1.0f - f8;
                    }
                    int i44 = (int) (((i14 - i5) * f8) + f2);
                    if (i44 < 0 || i3 > 0) {
                        i44 = i7;
                    }
                    int i45 = z ? i6 - i44 : i6 + i44;
                    for (int i46 = i7; i46 < size; i46++) {
                        eun eunVar6 = (eun) arrayList.get(z ? size - (i46 + 1) : i46);
                        adq adqVar6 = eunVar6.l;
                        alz alzVar7 = eunVar6.s;
                        alz alzVar8 = eunVar6.r;
                        if (adqVar6.bq == 8) {
                            alzVar8.p(i45);
                            alzVar7.p(i45);
                        } else {
                            if (i46 > 0 && i46 >= i15) {
                                i45 = z ? i45 - alzVar8.g : i45 + alzVar8.g;
                            }
                            if (z) {
                                alzVar7.p(i45);
                            } else {
                                alzVar8.p(i45);
                            }
                            anp anpVar5 = eunVar6.o;
                            int i47 = anpVar5.h;
                            if (eunVar6.n == 3 && eunVar6.k == 1) {
                                i47 = anpVar5.q;
                            }
                            i45 = z ? i45 - i47 : i45 + i47;
                            if (z) {
                                alzVar8.p(i45);
                            } else {
                                alzVar7.p(i45);
                            }
                            if (i46 < i16 && i46 < i) {
                                i45 = z ? i45 - (-alzVar7.g) : i45 + (-alzVar7.g);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // me.hd.wauxv.obf.eun
    public final void d() {
        ArrayList arrayList = this.a;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((eun) it.next()).d();
        }
        int size = arrayList.size();
        if (size < 1) {
            return;
        }
        adq adqVar = ((eun) arrayList.get(0)).l;
        adq adqVar2 = ((eun) arrayList.get(size - 1)).l;
        int i = this.p;
        alz alzVar = this.s;
        alz alzVar2 = this.r;
        if (i == 0) {
            adb adbVar = adqVar.as;
            adb adbVar2 = adqVar2.au;
            alz alzVarW = eun.w(adbVar, 0);
            int iN = adbVar.n();
            adq adqVarI = i();
            if (adqVarI != null) {
                iN = adqVarI.as.n();
            }
            if (alzVarW != null) {
                eun.u(alzVar2, alzVarW, iN);
            }
            alz alzVarW2 = eun.w(adbVar2, 0);
            int iN2 = adbVar2.n();
            adq adqVarJ = j();
            if (adqVarJ != null) {
                iN2 = adqVarJ.au.n();
            }
            if (alzVarW2 != null) {
                eun.u(alzVar, alzVarW2, -iN2);
            }
        } else {
            adb adbVar3 = adqVar.at;
            adb adbVar4 = adqVar2.av;
            alz alzVarW3 = eun.w(adbVar3, 1);
            int iN3 = adbVar3.n();
            adq adqVarI2 = i();
            if (adqVarI2 != null) {
                iN3 = adqVarI2.at.n();
            }
            if (alzVarW3 != null) {
                eun.u(alzVar2, alzVarW3, iN3);
            }
            alz alzVarW4 = eun.w(adbVar4, 1);
            int iN4 = adbVar4.n();
            adq adqVarJ2 = j();
            if (adqVarJ2 != null) {
                iN4 = adqVarJ2.av.n();
            }
            if (alzVarW4 != null) {
                eun.u(alzVar, alzVarW4, -iN4);
            }
        }
        alzVar2.a = this;
        alzVar.a = this;
    }

    @Override // me.hd.wauxv.obf.eun
    public final void e() {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.a;
            if (i >= arrayList.size()) {
                return;
            }
            ((eun) arrayList.get(i)).e();
            i++;
        }
    }

    @Override // me.hd.wauxv.obf.eun
    public final void f() {
        this.m = null;
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((eun) it.next()).f();
        }
    }

    @Override // me.hd.wauxv.obf.eun
    public final long g() {
        ArrayList arrayList = this.a;
        int size = arrayList.size();
        long jG = 0;
        for (int i = 0; i < size; i++) {
            eun eunVar = (eun) arrayList.get(i);
            jG = ((long) eunVar.s.g) + eunVar.g() + jG + ((long) eunVar.r.g);
        }
        return jG;
    }

    @Override // me.hd.wauxv.obf.eun
    public final boolean h() {
        ArrayList arrayList = this.a;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (!((eun) arrayList.get(i)).h()) {
                return false;
            }
        }
        return true;
    }

    public final adq i() {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.a;
            if (i >= arrayList.size()) {
                return null;
            }
            adq adqVar = ((eun) arrayList.get(i)).l;
            if (adqVar.bq != 8) {
                return adqVar;
            }
            i++;
        }
    }

    public final adq j() {
        ArrayList arrayList = this.a;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            adq adqVar = ((eun) arrayList.get(size)).l;
            if (adqVar.bq != 8) {
                return adqVar;
            }
        }
        return null;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ChainRun ");
        sb.append(this.p == 0 ? "horizontal : " : "vertical : ");
        for (eun eunVar : this.a) {
            sb.append("<");
            sb.append(eunVar);
            sb.append("> ");
        }
        return sb.toString();
    }
}
