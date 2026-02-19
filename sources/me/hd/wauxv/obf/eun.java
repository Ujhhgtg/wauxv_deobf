package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class eun implements alx {
    public int k;
    public adq l;
    public ddq m;
    public int n;
    public final anp o = new anp(this);
    public int p = 0;
    public boolean q = false;
    public final alz r = new alz(this);
    public final alz s = new alz(this);
    public int t = 1;

    public eun(adq adqVar) {
        this.l = adqVar;
    }

    public static void u(alz alzVar, alz alzVar2, int i) {
        alzVar.m.add(alzVar2);
        alzVar.g = i;
        alzVar2.l.add(alzVar);
    }

    public static alz v(adb adbVar) {
        adb adbVar2 = adbVar.f;
        if (adbVar2 == null) {
            return null;
        }
        adq adqVar = adbVar2.d;
        int iAe = StaticHelpers6.ae(adbVar2.e);
        if (iAe == 1) {
            return adqVar.n.r;
        }
        if (iAe == 2) {
            return adqVar.o.r;
        }
        if (iAe == 3) {
            return adqVar.n.s;
        }
        if (iAe == 4) {
            return adqVar.o.s;
        }
        if (iAe != 5) {
            return null;
        }
        return adqVar.o.a;
    }

    public static alz w(adb adbVar, int i) {
        adb adbVar2 = adbVar.f;
        if (adbVar2 == null) {
            return null;
        }
        adq adqVar = adbVar2.d;
        eun eunVar = i == 0 ? adqVar.n : adqVar.o;
        int iAe = StaticHelpers6.ae(adbVar2.e);
        if (iAe == 1 || iAe == 2) {
            return eunVar.r;
        }
        if (iAe == 3 || iAe == 4) {
            return eunVar.s;
        }
        return null;
    }

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public long g() {
        if (this.o.k) {
            return r0.h;
        }
        return 0L;
    }

    public abstract boolean h();

    public final void x(alz alzVar, alz alzVar2, int i, anp anpVar) {
        alzVar.m.add(alzVar2);
        alzVar.m.add(this.o);
        alzVar.i = i;
        alzVar.j = anpVar;
        alzVar2.l.add(alzVar);
        anpVar.l.add(alzVar);
    }

    public final int y(int i, int i2) {
        if (i2 == 0) {
            adq adqVar = this.l;
            int i3 = adqVar.af;
            int iMax = Math.max(adqVar.ae, i);
            if (i3 > 0) {
                iMax = Math.min(i3, i);
            }
            if (iMax != i) {
                return iMax;
            }
        } else {
            adq adqVar2 = this.l;
            int i4 = adqVar2.ai;
            int iMax2 = Math.max(adqVar2.ah, i);
            if (i4 > 0) {
                iMax2 = Math.min(i4, i);
            }
            if (iMax2 != i) {
                return iMax2;
            }
        }
        return i;
    }

    /* JADX WARN: Found duplicated region for block: B:28:0x0054 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:29:0x0056  */
    /* JADX WARN: Found duplicated region for block: B:32:0x005e  */
    /* JADX WARN: Found duplicated region for block: B:34:0x0062  */
    /* JADX WARN: Found duplicated region for block: B:35:0x0069  */
    public final void z(adb adbVar, adb adbVar2, int i) {
        alz alzVarV = v(adbVar);
        alz alzVarV2 = v(adbVar2);
        if (alzVarV.k && alzVarV2.k) {
            int iN = adbVar.n() + alzVarV.h;
            int iN2 = alzVarV2.h - adbVar2.n();
            int i2 = iN2 - iN;
            anp anpVar = this.o;
            if (!anpVar.k && this.n == 3) {
                int i3 = this.k;
                if (i3 == 0) {
                    anpVar.p(y(i2, i));
                } else if (i3 == 1) {
                    anpVar.p(Math.min(y(anpVar.q, i), i2));
                } else if (i3 == 2) {
                    adq adqVar = this.l;
                    adq adqVar2 = adqVar.bd;
                    if (adqVar2 != null) {
                        if ((i == 0 ? adqVar2.n : adqVar2.o).o.k) {
                            anpVar.p(y((int) ((r6.h * (i == 0 ? adqVar.ag : adqVar.aj)) + 0.5f), i));
                        }
                    }
                } else if (i3 == 3) {
                    adq adqVar3 = this.l;
                    eun eunVar = adqVar3.n;
                    if (eunVar.n == 3 && eunVar.k == 3) {
                        eps epsVar = adqVar3.o;
                        if (epsVar.n != 3 || epsVar.k != 3) {
                            if (i == 0) {
                                eunVar = adqVar3.o;
                            }
                            if (eunVar.o.k) {
                                float f = adqVar3.bg;
                                anpVar.p(i == 1 ? (int) ((r6.h / f) + 0.5f) : (int) ((f * r6.h) + 0.5f));
                            }
                        }
                    } else {
                        if (i == 0) {
                            eunVar = adqVar3.o;
                        }
                        if (eunVar.o.k) {
                            float f2 = adqVar3.bg;
                            anpVar.p(i == 1 ? (int) ((r6.h / f2) + 0.5f) : (int) ((f2 * r6.h) + 0.5f));
                        }
                    }
                }
            }
            if (anpVar.k) {
                int i4 = anpVar.h;
                alz alzVar = this.s;
                alz alzVar2 = this.r;
                if (i4 == i2) {
                    alzVar2.p(iN);
                    alzVar.p(iN2);
                    return;
                }
                float f3 = i == 0 ? this.l.bn : this.l.bo;
                if (alzVarV == alzVarV2) {
                    iN = alzVarV.h;
                    iN2 = alzVarV2.h;
                    f3 = 0.5f;
                }
                alzVar2.p((int) ((((iN2 - iN) - i4) * f3) + iN + 0.5f));
                alzVar.p(alzVar2.h + anpVar.h);
            }
        }
    }
}
