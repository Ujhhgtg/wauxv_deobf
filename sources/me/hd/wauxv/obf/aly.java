package me.hd.wauxv.obf;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class aly {
    public adr a;
    public boolean b;
    public boolean c;
    public adr d;
    public ArrayList e;
    public adg f;
    public of g;
    public ArrayList h;

    public final void i(alz alzVar, int i, ArrayList arrayList, ddq ddqVar) {
        eun eunVar = alzVar.e;
        ddq ddqVar2 = eunVar.m;
        alz alzVar2 = eunVar.s;
        alz alzVar3 = eunVar.r;
        if (ddqVar2 == null) {
            adr adrVar = this.a;
            if (eunVar == adrVar.n || eunVar == adrVar.o) {
                return;
            }
            if (ddqVar == null) {
                ddqVar = new ddq();
                ddqVar.a = null;
                ddqVar.b = new ArrayList();
                ddqVar.a = eunVar;
                arrayList.add(ddqVar);
            }
            eunVar.m = ddqVar;
            ddqVar.b.add(eunVar);
            for (alx alxVar : alzVar3.l) {
                if (alxVar instanceof alz) {
                    i((alz) alxVar, i, arrayList, ddqVar);
                }
            }
            for (alx alxVar2 : alzVar2.l) {
                if (alxVar2 instanceof alz) {
                    i((alz) alxVar2, i, arrayList, ddqVar);
                }
            }
            if (i == 1 && (eunVar instanceof eps)) {
                for (alx alxVar3 : ((eps) eunVar).a.l) {
                    if (alxVar3 instanceof alz) {
                        i((alz) alxVar3, i, arrayList, ddqVar);
                    }
                }
            }
            Iterator it = alzVar3.m.iterator();
            while (it.hasNext()) {
                i((alz) it.next(), i, arrayList, ddqVar);
            }
            Iterator it2 = alzVar2.m.iterator();
            while (it2.hasNext()) {
                i((alz) it2.next(), i, arrayList, ddqVar);
            }
            if (i == 1 && (eunVar instanceof eps)) {
                Iterator it3 = ((eps) eunVar).a.m.iterator();
                while (it3.hasNext()) {
                    i((alz) it3.next(), i, arrayList, ddqVar);
                }
            }
        }
    }

    /* JADX WARN: Found duplicated region for block: B:101:0x01b2 A[MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:102:0x01be  */
    /* JADX WARN: Found duplicated region for block: B:105:0x01cb  */
    /* JADX WARN: Found duplicated region for block: B:114:0x021a  */
    /* JADX WARN: Found duplicated region for block: B:123:0x025d  */
    /* JADX WARN: Found duplicated region for block: B:146:0x0303  */
    /* JADX WARN: Found duplicated region for block: B:149:0x0315  */
    /* JADX WARN: Found duplicated region for block: B:150:0x0328  */
    /* JADX WARN: Found duplicated region for block: B:156:0x00bc A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:157:0x02f8 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:158:0x00bc A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:159:0x00d7 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:160:0x0118 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:165:0x01b0 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:166:0x01fc A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:167:0x0226 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:169:0x0268 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:171:0x0293 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:180:0x028c A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:182:0x0253 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:184:0x0216 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:186:0x0211 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:187:0x01f6 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:188:0x019d A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:190:0x016b A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:192:0x0130 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:194:0x012c A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:195:0x0113 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:197:0x00c2 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:199:0x000a A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:57:0x00b3  */
    /* JADX WARN: Found duplicated region for block: B:59:0x00b6  */
    /* JADX WARN: Found duplicated region for block: B:61:0x00b9  */
    /* JADX WARN: Found duplicated region for block: B:66:0x00c7  */
    /* JADX WARN: Found duplicated region for block: B:73:0x00d9 A[MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:95:0x01a2  */
    /* JADX WARN: Found duplicated region for block: B:95:0x01a2 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:96:0x01a4 A[ADDED_TO_REGION] */
    public final void j(adr adrVar) {
        int i;
        int i2;
        int i3;
        int iCq;
        int iCm;
        int iCm2;
        int i4;
        int i5;
        int i6;
        aly alyVar;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        float f;
        int i22;
        int i23;
        ArrayList<adq> arrayList = adrVar.a;
        int[] iArr = adrVar.bz;
        for (adq adqVar : arrayList) {
            int[] iArr2 = adqVar.bz;
            adb[] adbVarArr = adqVar.ba;
            adb adbVar = adqVar.av;
            adb adbVar2 = adqVar.at;
            adb adbVar3 = adqVar.au;
            adb adbVar4 = adqVar.as;
            int i24 = iArr2[0];
            int i25 = iArr2[1];
            if (adqVar.bq == 8) {
                adqVar.k = true;
            } else {
                float f2 = adqVar.ag;
                if (f2 < 1.0f && i24 == 3) {
                    adqVar.ab = 2;
                }
                float f3 = adqVar.aj;
                if (f3 < 1.0f && i25 == 3) {
                    adqVar.ac = 2;
                }
                if (adqVar.bg > 0.0f) {
                    if (i24 == 3 && (i25 == 2 || i25 == 1)) {
                        adqVar.ab = 3;
                    } else if (i25 == 3 && (i24 == 2 || i24 == 1)) {
                        adqVar.ac = 3;
                    } else if (i24 == 3 && i25 == 3) {
                        if (adqVar.ab == 0) {
                            adqVar.ab = 3;
                        }
                        if (adqVar.ac == 0) {
                            adqVar.ac = 3;
                        }
                    }
                }
                if (i24 == 3 && adqVar.ab == 1 && (adbVar4.f == null || adbVar3.f == null)) {
                    i24 = 2;
                }
                if (i25 == 3 && adqVar.ac == 1 && (adbVar2.f == null || adbVar.f == null)) {
                    i25 = 2;
                }
                bmn bmnVar = adqVar.n;
                bmnVar.n = i24;
                int i26 = adqVar.ab;
                bmnVar.k = i26;
                eps epsVar = adqVar.o;
                epsVar.n = i25;
                int i27 = adqVar.ac;
                epsVar.k = i27;
                if (i24 == 4 || i24 == 1) {
                    if (i25 == 4) {
                        if (i25 != 1) {
                            i7 = 2;
                            if (i25 != 2) {
                                if (i24 != 3) {
                                    i8 = i25;
                                    i9 = 1;
                                } else if (i25 == i7 && i25 != 1) {
                                    i8 = i25;
                                    i10 = 3;
                                    i9 = 1;
                                    if (i8 != i10) {
                                        i11 = i8;
                                        i12 = i7;
                                        i13 = 1;
                                        i14 = i24;
                                    } else if (i24 == i7 && i24 != i9) {
                                        i15 = i10;
                                        i11 = i8;
                                        i12 = i7;
                                        i13 = 1;
                                        i14 = i24;
                                        if (i14 != i15 && i11 == i15) {
                                            if (i26 == i13 || i27 == i13) {
                                                n(i12, 0, i12, 0, adqVar);
                                                adqVar.n.o.q = adqVar.cq();
                                                adqVar.o.o.q = adqVar.cm();
                                            } else if (i27 == 2 && i26 == 2 && iArr[0] == i9 && iArr[i13] == i9) {
                                                n(i9, (int) ((f2 * adrVar.cq()) + 0.5f), i9, (int) ((f3 * adrVar.cm()) + 0.5f), adqVar);
                                                adqVar.n.o.p(adqVar.cq());
                                                adqVar.o.o.p(adqVar.cm());
                                                adqVar.k = true;
                                            }
                                        }
                                    } else if (i27 == i10) {
                                        if (i24 == i7) {
                                            i21 = i9;
                                            n(i7, 0, i7, 0, adqVar);
                                        } else {
                                            i21 = i9;
                                        }
                                        int iCq2 = adqVar.cq();
                                        f = adqVar.bg;
                                        if (adqVar.bh == -1) {
                                            f = 1.0f / f;
                                        }
                                        n(i21, iCq2, i21, (int) ((iCq2 * f) + 0.5f), adqVar);
                                        adqVar.n.o.p(adqVar.cq());
                                        adqVar.o.o.p(adqVar.cm());
                                        adqVar.k = true;
                                    } else {
                                        i16 = i8;
                                        i17 = i9;
                                        i18 = i7;
                                        if (i27 == 1) {
                                            n(i24, 0, i18, 0, adqVar);
                                            adqVar.o.o.q = adqVar.cm();
                                        } else {
                                            i19 = i24;
                                            if (i27 == 2) {
                                                i20 = iArr[1];
                                                if (i20 != i17 || i20 == 4) {
                                                    n(i19, adqVar.cq(), i17, (int) ((f3 * adrVar.cm()) + 0.5f), adqVar);
                                                    adqVar.n.o.p(adqVar.cq());
                                                    adqVar.o.o.p(adqVar.cm());
                                                    adqVar.k = true;
                                                } else {
                                                    i11 = i16;
                                                    i14 = i19;
                                                    i9 = i17;
                                                    i12 = i18;
                                                    i13 = 1;
                                                }
                                            } else {
                                                i14 = i19;
                                                i9 = i17;
                                                if (adbVarArr[2].f != null || adbVarArr[3].f == null) {
                                                    n(i18, 0, i16, 0, adqVar);
                                                    adqVar.n.o.p(adqVar.cq());
                                                    adqVar.o.o.p(adqVar.cm());
                                                    adqVar.k = true;
                                                } else {
                                                    i11 = i16;
                                                    i12 = i18;
                                                    i13 = 1;
                                                }
                                            }
                                        }
                                    }
                                    i15 = 3;
                                    if (i14 != i15) {
                                    }
                                } else if (i26 == 3) {
                                    if (i25 == i7) {
                                        n(i7, 0, i7, 0, adqVar);
                                    }
                                    int iCm3 = adqVar.cm();
                                    n(1, (int) ((iCm3 * adqVar.bg) + 0.5f), 1, iCm3, adqVar);
                                    adqVar.n.o.p(adqVar.cq());
                                    adqVar.o.o.p(adqVar.cm());
                                    adqVar.k = true;
                                } else {
                                    i22 = i7;
                                    if (i26 == 1) {
                                        n(i22, 0, i25, 0, adqVar);
                                        adqVar.n.o.q = adqVar.cq();
                                    } else {
                                        i7 = i22;
                                        if (i26 == 2) {
                                            i23 = iArr[0];
                                            if (i23 != 1 || i23 == 4) {
                                                n(1, (int) ((f2 * adrVar.cq()) + 0.5f), i25, adqVar.cm(), adqVar);
                                                adqVar.n.o.p(adqVar.cq());
                                                adqVar.o.o.p(adqVar.cm());
                                                adqVar.k = true;
                                            } else {
                                                i9 = 1;
                                                i8 = i25;
                                            }
                                        } else {
                                            i9 = 1;
                                            i8 = i25;
                                            if (adbVarArr[0].f != null || adbVarArr[1].f == null) {
                                                n(i7, 0, i8, 0, adqVar);
                                                adqVar.n.o.p(adqVar.cq());
                                                adqVar.o.o.p(adqVar.cm());
                                                adqVar.k = true;
                                            }
                                        }
                                    }
                                }
                                i10 = 3;
                                if (i8 != i10) {
                                    if (i24 == i7) {
                                    }
                                    if (i27 == i10) {
                                        if (i24 == i7) {
                                            i21 = i9;
                                            n(i7, 0, i7, 0, adqVar);
                                        } else {
                                            i21 = i9;
                                        }
                                        int iCq22 = adqVar.cq();
                                        f = adqVar.bg;
                                        if (adqVar.bh == -1) {
                                            f = 1.0f / f;
                                        }
                                        n(i21, iCq22, i21, (int) ((iCq22 * f) + 0.5f), adqVar);
                                        adqVar.n.o.p(adqVar.cq());
                                        adqVar.o.o.p(adqVar.cm());
                                        adqVar.k = true;
                                    } else {
                                        i16 = i8;
                                        i17 = i9;
                                        i18 = i7;
                                        if (i27 == 1) {
                                            n(i24, 0, i18, 0, adqVar);
                                            adqVar.o.o.q = adqVar.cm();
                                        } else {
                                            i19 = i24;
                                            if (i27 == 2) {
                                                i20 = iArr[1];
                                                if (i20 != i17) {
                                                }
                                                n(i19, adqVar.cq(), i17, (int) ((f3 * adrVar.cm()) + 0.5f), adqVar);
                                                adqVar.n.o.p(adqVar.cq());
                                                adqVar.o.o.p(adqVar.cm());
                                                adqVar.k = true;
                                            } else {
                                                i14 = i19;
                                                i9 = i17;
                                                if (adbVarArr[2].f != null) {
                                                }
                                                n(i18, 0, i16, 0, adqVar);
                                                adqVar.n.o.p(adqVar.cq());
                                                adqVar.o.o.p(adqVar.cm());
                                                adqVar.k = true;
                                            }
                                        }
                                    }
                                } else {
                                    i11 = i8;
                                    i12 = i7;
                                    i13 = 1;
                                    i14 = i24;
                                }
                                i15 = 3;
                                if (i14 != i15) {
                                }
                            }
                        } else {
                            i3 = i25;
                            i = 1;
                            i2 = i24;
                        }
                        iCq = adqVar.cq();
                        if (i2 == 4) {
                            iCq = (adrVar.cq() - adbVar4.g) - adbVar3.g;
                            i2 = i;
                        }
                        iCm = adqVar.cm();
                        if (i3 == 4) {
                            iCm2 = (adrVar.cm() - adbVar2.g) - adbVar.g;
                            i4 = i;
                            alyVar = this;
                            i5 = iCq;
                            i6 = i2;
                        } else {
                            iCm2 = iCm;
                            i4 = i3;
                            i5 = iCq;
                            i6 = i2;
                            alyVar = this;
                        }
                        alyVar.n(i6, i5, i4, iCm2, adqVar);
                        adqVar.n.o.p(adqVar.cq());
                        adqVar.o.o.p(adqVar.cm());
                        adqVar.k = true;
                    }
                    i3 = i25;
                    i2 = i24;
                    i = 1;
                    iCq = adqVar.cq();
                    if (i2 == 4) {
                        iCq = (adrVar.cq() - adbVar4.g) - adbVar3.g;
                        i2 = i;
                    }
                    iCm = adqVar.cm();
                    if (i3 == 4) {
                        iCm2 = (adrVar.cm() - adbVar2.g) - adbVar.g;
                        i4 = i;
                        alyVar = this;
                        i5 = iCq;
                        i6 = i2;
                    } else {
                        iCm2 = iCm;
                        i4 = i3;
                        i5 = iCq;
                        i6 = i2;
                        alyVar = this;
                    }
                    alyVar.n(i6, i5, i4, iCm2, adqVar);
                    adqVar.n.o.p(adqVar.cq());
                    adqVar.o.o.p(adqVar.cm());
                    adqVar.k = true;
                } else {
                    i7 = 2;
                    if (i24 == 2) {
                        if (i25 == 4) {
                            if (i25 != 1) {
                                i7 = 2;
                                if (i25 != 2) {
                                }
                            } else {
                                i3 = i25;
                                i = 1;
                                i2 = i24;
                            }
                            iCq = adqVar.cq();
                            if (i2 == 4) {
                                iCq = (adrVar.cq() - adbVar4.g) - adbVar3.g;
                                i2 = i;
                            }
                            iCm = adqVar.cm();
                            if (i3 == 4) {
                                iCm2 = (adrVar.cm() - adbVar2.g) - adbVar.g;
                                i4 = i;
                                alyVar = this;
                                i5 = iCq;
                                i6 = i2;
                            } else {
                                iCm2 = iCm;
                                i4 = i3;
                                i5 = iCq;
                                i6 = i2;
                                alyVar = this;
                            }
                            alyVar.n(i6, i5, i4, iCm2, adqVar);
                            adqVar.n.o.p(adqVar.cq());
                            adqVar.o.o.p(adqVar.cm());
                            adqVar.k = true;
                        }
                        i3 = i25;
                        i2 = i24;
                        i = 1;
                        iCq = adqVar.cq();
                        if (i2 == 4) {
                            iCq = (adrVar.cq() - adbVar4.g) - adbVar3.g;
                            i2 = i;
                        }
                        iCm = adqVar.cm();
                        if (i3 == 4) {
                            iCm2 = (adrVar.cm() - adbVar2.g) - adbVar.g;
                            i4 = i;
                            alyVar = this;
                            i5 = iCq;
                            i6 = i2;
                        } else {
                            iCm2 = iCm;
                            i4 = i3;
                            i5 = iCq;
                            i6 = i2;
                            alyVar = this;
                        }
                        alyVar.n(i6, i5, i4, iCm2, adqVar);
                        adqVar.n.o.p(adqVar.cq());
                        adqVar.o.o.p(adqVar.cm());
                        adqVar.k = true;
                    }
                    if (i24 != 3) {
                        if (i25 == i7) {
                        }
                        if (i26 == 3) {
                            if (i25 == i7) {
                                n(i7, 0, i7, 0, adqVar);
                            }
                            int iCm32 = adqVar.cm();
                            n(1, (int) ((iCm32 * adqVar.bg) + 0.5f), 1, iCm32, adqVar);
                            adqVar.n.o.p(adqVar.cq());
                            adqVar.o.o.p(adqVar.cm());
                            adqVar.k = true;
                        } else {
                            i22 = i7;
                            if (i26 == 1) {
                                n(i22, 0, i25, 0, adqVar);
                                adqVar.n.o.q = adqVar.cq();
                            } else {
                                i7 = i22;
                                if (i26 == 2) {
                                    i23 = iArr[0];
                                    if (i23 != 1) {
                                    }
                                    n(1, (int) ((f2 * adrVar.cq()) + 0.5f), i25, adqVar.cm(), adqVar);
                                    adqVar.n.o.p(adqVar.cq());
                                    adqVar.o.o.p(adqVar.cm());
                                    adqVar.k = true;
                                } else {
                                    i9 = 1;
                                    i8 = i25;
                                    if (adbVarArr[0].f != null) {
                                    }
                                    n(i7, 0, i8, 0, adqVar);
                                    adqVar.n.o.p(adqVar.cq());
                                    adqVar.o.o.p(adqVar.cm());
                                    adqVar.k = true;
                                }
                            }
                        }
                    } else {
                        i8 = i25;
                        i9 = 1;
                    }
                    i10 = 3;
                    if (i8 != i10) {
                        if (i24 == i7) {
                        }
                        if (i27 == i10) {
                            if (i24 == i7) {
                                i21 = i9;
                                n(i7, 0, i7, 0, adqVar);
                            } else {
                                i21 = i9;
                            }
                            int iCq222 = adqVar.cq();
                            f = adqVar.bg;
                            if (adqVar.bh == -1) {
                                f = 1.0f / f;
                            }
                            n(i21, iCq222, i21, (int) ((iCq222 * f) + 0.5f), adqVar);
                            adqVar.n.o.p(adqVar.cq());
                            adqVar.o.o.p(adqVar.cm());
                            adqVar.k = true;
                        } else {
                            i16 = i8;
                            i17 = i9;
                            i18 = i7;
                            if (i27 == 1) {
                                n(i24, 0, i18, 0, adqVar);
                                adqVar.o.o.q = adqVar.cm();
                            } else {
                                i19 = i24;
                                if (i27 == 2) {
                                    i20 = iArr[1];
                                    if (i20 != i17) {
                                    }
                                    n(i19, adqVar.cq(), i17, (int) ((f3 * adrVar.cm()) + 0.5f), adqVar);
                                    adqVar.n.o.p(adqVar.cq());
                                    adqVar.o.o.p(adqVar.cm());
                                    adqVar.k = true;
                                } else {
                                    i14 = i19;
                                    i9 = i17;
                                    if (adbVarArr[2].f != null) {
                                    }
                                    n(i18, 0, i16, 0, adqVar);
                                    adqVar.n.o.p(adqVar.cq());
                                    adqVar.o.o.p(adqVar.cm());
                                    adqVar.k = true;
                                }
                            }
                        }
                    } else {
                        i11 = i8;
                        i12 = i7;
                        i13 = 1;
                        i14 = i24;
                    }
                    i15 = 3;
                    if (i14 != i15) {
                    }
                }
            }
        }
    }

    public final void k() {
        adr adrVar = this.a;
        ArrayList arrayList = this.h;
        ArrayList<eun> arrayList2 = this.e;
        arrayList2.clear();
        adr adrVar2 = this.d;
        adrVar2.n.f();
        adrVar2.o.f();
        arrayList2.add(adrVar2.n);
        arrayList2.add(adrVar2.o);
        HashSet hashSet = null;
        for (adq adqVar : adrVar2.a) {
            if (adqVar instanceof bjp) {
                bjq bjqVar = new bjq(adqVar);
                adqVar.n.f();
                adqVar.o.f();
                bjqVar.p = ((bjp) adqVar).i;
                arrayList2.add(bjqVar);
            } else {
                if (adqVar.cx()) {
                    if (adqVar.l == null) {
                        adqVar.l = new tq(adqVar, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(adqVar.l);
                } else {
                    arrayList2.add(adqVar.n);
                }
                if (adqVar.cy()) {
                    if (adqVar.m == null) {
                        adqVar.m = new tq(adqVar, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(adqVar.m);
                } else {
                    arrayList2.add(adqVar.o);
                }
                if (adqVar instanceof bkw) {
                    arrayList2.add(new bkv(adqVar));
                }
            }
        }
        if (hashSet != null) {
            arrayList2.addAll(hashSet);
        }
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            ((eun) it.next()).f();
        }
        for (eun eunVar : arrayList2) {
            if (eunVar.l != adrVar2) {
                eunVar.d();
            }
        }
        arrayList.clear();
        m(adrVar.n, 0, arrayList);
        m(adrVar.o, 1, arrayList);
        this.b = false;
    }

    public final int l(adr adrVar, int i) {
        ArrayList arrayList;
        int i2;
        long jMax;
        float f;
        adr adrVar2 = adrVar;
        ArrayList arrayList2 = this.h;
        int size = arrayList2.size();
        long j = 0;
        int i3 = 0;
        long jMax2 = 0;
        while (i3 < size) {
            eun eunVar = ((ddq) arrayList2.get(i3)).a;
            if (!(eunVar instanceof tq) ? !(i != 0 ? (eunVar instanceof eps) : (eunVar instanceof bmn)) : ((tq) eunVar).p != i) {
                alz alzVar = (i == 0 ? adrVar2.n : adrVar2.o).r;
                alz alzVar2 = (i == 0 ? adrVar2.n : adrVar2.o).s;
                alz alzVar3 = eunVar.r;
                alz alzVar4 = eunVar.s;
                boolean zContains = alzVar3.m.contains(alzVar);
                boolean zContains2 = alzVar4.m.contains(alzVar2);
                long jG = eunVar.g();
                if (zContains && zContains2) {
                    long jD = ddq.d(alzVar3, j);
                    long jC = ddq.c(alzVar4, j);
                    long j2 = jD - jG;
                    int i4 = alzVar4.g;
                    arrayList = arrayList2;
                    i2 = size;
                    if (j2 >= (-i4)) {
                        j2 += (long) i4;
                    }
                    long j3 = alzVar3.g;
                    long j4 = ((-jC) - jG) - j3;
                    if (j4 >= j3) {
                        j4 -= j3;
                    }
                    adq adqVar = eunVar.l;
                    if (i == 0) {
                        f = adqVar.bn;
                    } else if (i == 1) {
                        f = adqVar.bo;
                    } else {
                        adqVar.getClass();
                        f = -1.0f;
                    }
                    float f2 = f > 0.0f ? (long) ((j2 / (1.0f - f)) + (j4 / f)) : 0L;
                    jMax = (((long) alzVar3.g) + ((((long) ((f2 * f) + 0.5f)) + jG) + ((long) yg.a(1.0f, f, f2, 0.5f)))) - ((long) alzVar4.g);
                } else {
                    arrayList = arrayList2;
                    i2 = size;
                    jMax = zContains ? Math.max(ddq.d(alzVar3, alzVar3.g), ((long) alzVar3.g) + jG) : zContains2 ? Math.max(-ddq.c(alzVar4, alzVar4.g), ((long) (-alzVar4.g)) + jG) : (eunVar.g() + ((long) alzVar3.g)) - ((long) alzVar4.g);
                }
            } else {
                arrayList = arrayList2;
                i2 = size;
                jMax = j;
            }
            jMax2 = Math.max(jMax2, jMax);
            i3++;
            adrVar2 = adrVar;
            arrayList2 = arrayList;
            size = i2;
            j = 0;
        }
        return (int) jMax2;
    }

    public final void m(eun eunVar, int i, ArrayList arrayList) {
        alz alzVar = eunVar.r;
        alz alzVar2 = eunVar.s;
        for (alx alxVar : alzVar.l) {
            if (alxVar instanceof alz) {
                i((alz) alxVar, i, arrayList, null);
            } else if (alxVar instanceof eun) {
                i(((eun) alxVar).r, i, arrayList, null);
            }
        }
        for (alx alxVar2 : alzVar2.l) {
            if (alxVar2 instanceof alz) {
                i((alz) alxVar2, i, arrayList, null);
            } else if (alxVar2 instanceof eun) {
                i(((eun) alxVar2).s, i, arrayList, null);
            }
        }
        if (i == 1) {
            for (alx alxVar3 : ((eps) eunVar).a.l) {
                if (alxVar3 instanceof alz) {
                    i((alz) alxVar3, i, arrayList, null);
                }
            }
        }
    }

    public final void n(int i, int i2, int i3, int i4, adq adqVar) {
        of ofVar = this.g;
        ofVar.a = i;
        ofVar.b = i3;
        ofVar.c = i2;
        ofVar.d = i4;
        this.f.j(adqVar, ofVar);
        adqVar.dk(ofVar.e);
        adqVar.dh(ofVar.f);
        adqVar.ao = ofVar.h;
        adqVar.de(ofVar.g);
    }

    public final void o() {
        od odVar;
        for (adq adqVar : this.a.a) {
            if (!adqVar.k) {
                int[] iArr = adqVar.bz;
                boolean z = false;
                int i = iArr[0];
                int i2 = iArr[1];
                int i3 = adqVar.ab;
                int i4 = adqVar.ac;
                boolean z2 = i == 2 || (i == 3 && i3 == 1);
                if (i2 == 2 || (i2 == 3 && i4 == 1)) {
                    z = true;
                }
                anp anpVar = adqVar.n.o;
                boolean z3 = anpVar.k;
                anp anpVar2 = adqVar.o.o;
                boolean z4 = anpVar2.k;
                boolean z5 = z2;
                if (z3 && z4) {
                    n(1, anpVar.h, 1, anpVar2.h, adqVar);
                    adqVar.k = true;
                } else if (z3 && z) {
                    n(1, anpVar.h, 2, anpVar2.h, adqVar);
                    if (i2 == 3) {
                        adqVar.o.o.q = adqVar.cm();
                    } else {
                        adqVar.o.o.p(adqVar.cm());
                        adqVar.k = true;
                    }
                } else if (z4 && z5) {
                    n(2, anpVar.h, 1, anpVar2.h, adqVar);
                    if (i == 3) {
                        adqVar.n.o.q = adqVar.cq();
                    } else {
                        adqVar.n.o.p(adqVar.cq());
                        adqVar.k = true;
                    }
                }
                if (adqVar.k && (odVar = adqVar.o.b) != null) {
                    odVar.p(adqVar.bk);
                }
            }
        }
    }
}
