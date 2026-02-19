package me.hd.wauxv.obf;

import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bvm {
    public static boolean a;
    public final cvr e;
    public final FactoryPools n;
    public kw q;
    public int b = 1000;
    public boolean c = false;
    public int d = 0;
    public int f = 32;
    public int g = 32;
    public boolean i = false;
    public boolean[] j = new boolean[32];
    public int k = 1;
    public int l = 0;
    public int m = 32;
    public dla[] o = new dla[1000];
    public int p = 0;
    public kw[] h = new kw[32];

    public bvm() {
        aj();
        FactoryPools factoryPoolsVar = new FactoryPools(3, false);
        factoryPoolsVar.e = new cuw();
        factoryPoolsVar.f = new cuw();
        factoryPoolsVar.h = new dla[32];
        this.n = factoryPoolsVar;
        cvr cvrVar = new cvr(factoryPoolsVar);
        cvrVar.o = new dla[128];
        cvrVar.p = new dla[128];
        cvrVar.q = 0;
        cvrVar.r = new but(cvrVar);
        this.e = cvrVar;
        this.q = new kw(factoryPoolsVar);
    }

    public static int r(Object obj) {
        dla dlaVar = ((adb) obj).i;
        if (dlaVar != null) {
            return (int) (dlaVar.e + 0.5f);
        }
        return 0;
    }

    public final void aa() {
        for (int i = 0; i < this.l; i++) {
            kw kwVar = this.h[i];
            kwVar.a.e = kwVar.b;
        }
    }

    public final dla ab(int i) {
        if (this.k + 1 >= this.g) {
            af();
        }
        dla dlaVarS = s(4);
        float[] fArr = dlaVarS.h;
        int i2 = this.d + 1;
        this.d = i2;
        this.k++;
        dlaVarS.b = i2;
        dlaVarS.d = i;
        ((dla[]) this.n.h)[i2] = dlaVarS;
        cvr cvrVar = this.e;
        cvrVar.r.b = dlaVarS;
        Arrays.fill(fArr, 0.0f);
        fArr[dlaVarS.d] = 1.0f;
        cvrVar.s(dlaVarS);
        return dlaVarS;
    }

    public final dla ac(Object obj) {
        if (obj == null) {
            return null;
        }
        if (this.k + 1 >= this.g) {
            af();
        }
        if (!(obj instanceof adb)) {
            return null;
        }
        adb adbVar = (adb) obj;
        dla dlaVar = adbVar.i;
        if (dlaVar == null) {
            adbVar.t();
            dlaVar = adbVar.i;
        }
        int i = dlaVar.b;
        FactoryPools factoryPoolsVar = this.n;
        if (i != -1 && i <= this.d && ((dla[]) factoryPoolsVar.h)[i] != null) {
            return dlaVar;
        }
        if (i != -1) {
            dlaVar.o();
        }
        int i2 = this.d + 1;
        this.d = i2;
        this.k++;
        dlaVar.b = i2;
        dlaVar.l = 1;
        ((dla[]) factoryPoolsVar.h)[i2] = dlaVar;
        return dlaVar;
    }

    public final kw ad() {
        Object obj;
        FactoryPools factoryPoolsVar = this.n;
        cuw cuwVar = (cuw) factoryPoolsVar.e;
        int i = cuwVar.b;
        if (i > 0) {
            int i2 = i - 1;
            Object[] objArr = cuwVar.a;
            obj = objArr[i2];
            objArr[i2] = null;
            cuwVar.b = i2;
        } else {
            obj = null;
        }
        kw kwVar = (kw) obj;
        if (kwVar == null) {
            return new kw(factoryPoolsVar);
        }
        kwVar.a = null;
        kwVar.d.l();
        kwVar.b = 0.0f;
        kwVar.e = false;
        return kwVar;
    }

    public final dla ae() {
        if (this.k + 1 >= this.g) {
            af();
        }
        dla dlaVarS = s(3);
        int i = this.d + 1;
        this.d = i;
        this.k++;
        dlaVarS.b = i;
        ((dla[]) this.n.h)[i] = dlaVarS;
        return dlaVarS;
    }

    public final void af() {
        int i = this.f * 2;
        this.f = i;
        this.h = (kw[]) Arrays.copyOf(this.h, i);
        FactoryPools factoryPoolsVar = this.n;
        factoryPoolsVar.h = (dla[]) Arrays.copyOf((dla[]) factoryPoolsVar.h, this.f);
        int i2 = this.f;
        this.j = new boolean[i2];
        this.g = i2;
        this.m = i2;
    }

    public final void ag() {
        cvr cvrVar = this.e;
        if (cvrVar.j()) {
            aa();
            return;
        }
        if (!this.i) {
            ah(cvrVar);
            return;
        }
        for (int i = 0; i < this.l; i++) {
            if (!this.h[i].e) {
                ah(cvrVar);
                return;
            }
        }
        aa();
    }

    public final void ah(cvr cvrVar) {
        for (int i = 0; i < this.l; i++) {
            kw kwVar = this.h[i];
            int i2 = 1;
            if (kwVar.a.l != 1) {
                float f = 0.0f;
                if (kwVar.b < 0.0f) {
                    boolean z = false;
                    int i3 = 0;
                    while (!z) {
                        i3 += i2;
                        float f2 = Float.MAX_VALUE;
                        int i4 = -1;
                        int i5 = -1;
                        int i6 = 0;
                        int i7 = 0;
                        while (i6 < this.l) {
                            kw kwVar2 = this.h[i6];
                            if (kwVar2.a.l != i2 && !kwVar2.e && kwVar2.b < f) {
                                int iN = kwVar2.d.n();
                                int i8 = 0;
                                while (i8 < iN) {
                                    dla dlaVarO = kwVar2.d.o(i8);
                                    float fM = kwVar2.d.m(dlaVarO);
                                    if (fM > f) {
                                        for (int i9 = 0; i9 < 9; i9++) {
                                            float f3 = dlaVarO.g[i9] / fM;
                                            if ((f3 < f2 && i9 == i7) || i9 > i7) {
                                                i7 = i9;
                                                i5 = dlaVarO.b;
                                                i4 = i6;
                                                f2 = f3;
                                            }
                                        }
                                    }
                                    i8++;
                                    f = 0.0f;
                                }
                            }
                            i6++;
                            f = 0.0f;
                            i2 = 1;
                        }
                        if (i4 != -1) {
                            kw kwVar3 = this.h[i4];
                            kwVar3.a.c = -1;
                            kwVar3.l(((dla[]) this.n.h)[i5]);
                            dla dlaVar = kwVar3.a;
                            dlaVar.c = i4;
                            dlaVar.q(this, kwVar3);
                        } else {
                            z = true;
                        }
                        if (i3 > this.k / 2) {
                            z = true;
                        }
                        f = 0.0f;
                        i2 = 1;
                    }
                    break;
                }
            }
        }
        ai(cvrVar);
        aa();
    }

    public final void ai(kw kwVar) {
        boolean z;
        int i = 0;
        for (int i2 = 0; i2 < this.k; i2++) {
            this.j[i2] = false;
        }
        boolean z2 = false;
        int i3 = 0;
        while (!z2) {
            int i4 = 1;
            i3++;
            if (i3 >= this.k * 2) {
                return;
            }
            dla dlaVar = kwVar.a;
            if (dlaVar != null) {
                this.j[dlaVar.b] = true;
            }
            dla dlaVarI = kwVar.i(this.j);
            if (dlaVarI != null) {
                boolean[] zArr = this.j;
                int i5 = dlaVarI.b;
                if (zArr[i5]) {
                    return;
                } else {
                    zArr[i5] = true;
                }
            }
            if (dlaVarI != null) {
                float f = Float.MAX_VALUE;
                int i6 = i;
                int i7 = -1;
                while (i6 < this.l) {
                    kw kwVar2 = this.h[i6];
                    if (kwVar2.a.l != i4 && !kwVar2.e) {
                        kn knVar = kwVar2.d;
                        int i8 = knVar.h;
                        if (i8 == -1) {
                            z = false;
                            break;
                        }
                        int i9 = 0;
                        while (true) {
                            if (i8 == -1 || i9 >= knVar.a) {
                                z = false;
                                break;
                            } else if (knVar.e[i8] == dlaVarI.b) {
                                z = true;
                                break;
                            } else {
                                i8 = knVar.f[i8];
                                i9++;
                            }
                        }
                        if (z) {
                            float fM = kwVar2.d.m(dlaVarI);
                            if (fM < 0.0f) {
                                float f2 = (-kwVar2.b) / fM;
                                if (f2 < f) {
                                    f = f2;
                                    i7 = i6;
                                }
                            }
                        }
                    }
                    i6++;
                    i4 = 1;
                }
                if (i7 > -1) {
                    kw kwVar3 = this.h[i7];
                    kwVar3.a.c = -1;
                    kwVar3.l(dlaVarI);
                    dla dlaVar2 = kwVar3.a;
                    dlaVar2.c = i7;
                    dlaVar2.q(this, kwVar3);
                }
            } else {
                z2 = true;
            }
            i = 0;
        }
    }

    public final void aj() {
        for (int i = 0; i < this.l; i++) {
            kw kwVar = this.h[i];
            if (kwVar != null) {
                ((cuw) this.n.e).c(kwVar);
            }
            this.h[i] = null;
        }
    }

    public final void ak() {
        FactoryPools factoryPoolsVar;
        int i = 0;
        while (true) {
            factoryPoolsVar = this.n;
            dla[] dlaVarArr = (dla[]) factoryPoolsVar.h;
            if (i >= dlaVarArr.length) {
                break;
            }
            dla dlaVar = dlaVarArr[i];
            if (dlaVar != null) {
                dlaVar.o();
            }
            i++;
        }
        cuw cuwVar = (cuw) factoryPoolsVar.f;
        dla[] dlaVarArr2 = this.o;
        int length = this.p;
        cuwVar.getClass();
        if (length > dlaVarArr2.length) {
            length = dlaVarArr2.length;
        }
        for (int i2 = 0; i2 < length; i2++) {
            dla dlaVar2 = dlaVarArr2[i2];
            int i3 = cuwVar.b;
            Object[] objArr = cuwVar.a;
            if (i3 < objArr.length) {
                objArr[i3] = dlaVar2;
                cuwVar.b = i3 + 1;
            }
        }
        this.p = 0;
        Arrays.fill((dla[]) factoryPoolsVar.h, (Object) null);
        this.d = 0;
        cvr cvrVar = this.e;
        cvrVar.q = 0;
        cvrVar.b = 0.0f;
        this.k = 1;
        for (int i4 = 0; i4 < this.l; i4++) {
            kw kwVar = this.h[i4];
        }
        aj();
        this.l = 0;
        this.q = new kw(factoryPoolsVar);
    }

    public final dla s(int i) {
        cuw cuwVar = (cuw) this.n.f;
        int i2 = cuwVar.b;
        Object obj = null;
        if (i2 > 0) {
            int i3 = i2 - 1;
            Object[] objArr = cuwVar.a;
            Object obj2 = objArr[i3];
            objArr[i3] = null;
            cuwVar.b = i3;
            obj = obj2;
        }
        dla dlaVar = (dla) obj;
        if (dlaVar == null) {
            dlaVar = new dla(i);
            dlaVar.l = i;
        } else {
            dlaVar.o();
            dlaVar.l = i;
        }
        int i4 = this.p;
        int i5 = this.b;
        if (i4 >= i5) {
            int i6 = i5 * 2;
            this.b = i6;
            this.o = (dla[]) Arrays.copyOf(this.o, i6);
        }
        dla[] dlaVarArr = this.o;
        int i7 = this.p;
        this.p = i7 + 1;
        dlaVarArr[i7] = dlaVar;
        return dlaVar;
    }

    public final void t(dla dlaVar, dla dlaVar2, int i, float f, dla dlaVar3, dla dlaVar4, int i2, int i3) {
        kw kwVarAd = ad();
        if (dlaVar2 == dlaVar3) {
            kwVarAd.d.q(dlaVar, 1.0f);
            kwVarAd.d.q(dlaVar4, 1.0f);
            kwVarAd.d.q(dlaVar2, -2.0f);
        } else if (f == 0.5f) {
            kwVarAd.d.q(dlaVar, 1.0f);
            kwVarAd.d.q(dlaVar2, -1.0f);
            kwVarAd.d.q(dlaVar3, -1.0f);
            kwVarAd.d.q(dlaVar4, 1.0f);
            if (i > 0 || i2 > 0) {
                kwVarAd.b = (-i) + i2;
            }
        } else if (f <= 0.0f) {
            kwVarAd.d.q(dlaVar, -1.0f);
            kwVarAd.d.q(dlaVar2, 1.0f);
            kwVarAd.b = i;
        } else if (f >= 1.0f) {
            kwVarAd.d.q(dlaVar4, -1.0f);
            kwVarAd.d.q(dlaVar3, 1.0f);
            kwVarAd.b = -i2;
        } else {
            float f2 = 1.0f - f;
            kwVarAd.d.q(dlaVar, f2 * 1.0f);
            kwVarAd.d.q(dlaVar2, f2 * (-1.0f));
            kwVarAd.d.q(dlaVar3, (-1.0f) * f);
            kwVarAd.d.q(dlaVar4, 1.0f * f);
            if (i > 0 || i2 > 0) {
                kwVarAd.b = (i2 * f) + ((-i) * f2);
            }
        }
        if (i3 != 8) {
            kwVarAd.f(this, i3);
        }
        u(kwVarAd);
    }

    /* JADX WARN: Found duplicated region for block: B:120:0x01ae  */
    /* JADX WARN: Found duplicated region for block: B:58:0x00d6  */
    /* JADX WARN: Found duplicated region for block: B:76:0x00f8  */
    public final void u(kw kwVar) {
        boolean z;
        boolean z2;
        dla dlaVarK;
        if (this.l + 1 >= this.m || this.k + 1 >= this.g) {
            af();
        }
        if (kwVar.e) {
            z = false;
        } else {
            ArrayList arrayList = kwVar.c;
            if (this.h.length != 0) {
                boolean z3 = false;
                while (!z3) {
                    int iN = kwVar.d.n();
                    for (int i = 0; i < iN; i++) {
                        dla dlaVarO = kwVar.d.o(i);
                        if (dlaVarO.c != -1 || dlaVarO.f) {
                            arrayList.add(dlaVarO);
                        }
                    }
                    int size = arrayList.size();
                    if (size > 0) {
                        for (int i2 = 0; i2 < size; i2++) {
                            dla dlaVar = (dla) arrayList.get(i2);
                            if (dlaVar.f) {
                                kwVar.m(this, dlaVar, true);
                            } else {
                                kwVar.n(this, this.h[dlaVar.c], true);
                            }
                        }
                        arrayList.clear();
                    } else {
                        z3 = true;
                    }
                }
                if (kwVar.a != null && kwVar.d.n() == 0) {
                    kwVar.e = true;
                    this.c = true;
                }
            }
            if (kwVar.j()) {
                return;
            }
            float f = kwVar.b;
            float f2 = 0.0f;
            if (f < 0.0f) {
                kwVar.b = f * (-1.0f);
                kn knVar = kwVar.d;
                int i3 = knVar.h;
                for (int i4 = 0; i3 != -1 && i4 < knVar.a; i4++) {
                    float[] fArr = knVar.g;
                    fArr[i3] = fArr[i3] * (-1.0f);
                    i3 = knVar.f[i3];
                }
            }
            int iN2 = kwVar.d.n();
            float f3 = 0.0f;
            float f4 = 0.0f;
            dla dlaVar2 = null;
            dla dlaVar3 = null;
            int i5 = 0;
            boolean z4 = false;
            boolean z5 = false;
            while (i5 < iN2) {
                float fP = kwVar.d.p(i5);
                dla dlaVarO2 = kwVar.d.o(i5);
                float f5 = f2;
                if (dlaVarO2.l == 1) {
                    if (dlaVar2 == null) {
                        z4 = dlaVarO2.k <= 1;
                        dlaVar2 = dlaVarO2;
                        f3 = fP;
                    } else {
                        if (f3 > fP) {
                            if (dlaVarO2.k <= 1) {
                            }
                            dlaVar2 = dlaVarO2;
                            f3 = fP;
                        } else if (z4 || dlaVarO2.k > 1) {
                        }
                        dlaVar2 = dlaVarO2;
                        f3 = fP;
                    }
                } else if (dlaVar2 == null && fP < f5) {
                    if (dlaVar3 == null) {
                        z5 = dlaVarO2.k <= 1;
                        dlaVar3 = dlaVarO2;
                        f4 = fP;
                    } else {
                        if (f4 > fP) {
                            if (dlaVarO2.k <= 1) {
                            }
                            dlaVar3 = dlaVarO2;
                            f4 = fP;
                        } else if (z5 || dlaVarO2.k > 1) {
                        }
                        dlaVar3 = dlaVarO2;
                        f4 = fP;
                    }
                }
                i5++;
                f2 = f5;
            }
            float f6 = f2;
            if (dlaVar2 == null) {
                dlaVar2 = dlaVar3;
            }
            if (dlaVar2 == null) {
                z2 = true;
            } else {
                kwVar.l(dlaVar2);
                z2 = false;
            }
            if (kwVar.d.n() == 0) {
                kwVar.e = true;
            }
            if (z2) {
                if (this.k + 1 >= this.g) {
                    af();
                }
                dla dlaVarS = s(3);
                int i6 = this.d + 1;
                this.d = i6;
                this.k++;
                dlaVarS.b = i6;
                FactoryPools factoryPoolsVar = this.n;
                ((dla[]) factoryPoolsVar.h)[i6] = dlaVarS;
                kwVar.a = dlaVarS;
                int i7 = this.l;
                z(kwVar);
                if (this.l == i7 + 1) {
                    kw kwVar2 = this.q;
                    kwVar2.a = null;
                    kwVar2.d.l();
                    for (int i8 = 0; i8 < kwVar.d.n(); i8++) {
                        kwVar2.d.k(kwVar.d.o(i8), kwVar.d.p(i8), true);
                    }
                    ai(this.q);
                    if (dlaVarS.c == -1) {
                        if (kwVar.a == dlaVarS && (dlaVarK = kwVar.k(null, dlaVarS)) != null) {
                            kwVar.l(dlaVarK);
                        }
                        if (!kwVar.e) {
                            kwVar.a.q(this, kwVar);
                        }
                        ((cuw) factoryPoolsVar.e).c(kwVar);
                        this.l--;
                    }
                    z = true;
                } else {
                    z = false;
                }
            } else {
                z = false;
            }
            dla dlaVar4 = kwVar.a;
            if (dlaVar4 == null) {
                return;
            }
            if (dlaVar4.l != 1 && kwVar.b < f6) {
                return;
            }
        }
        if (z) {
            return;
        }
        z(kwVar);
    }

    public final void v(dla dlaVar, int i) {
        int i2 = dlaVar.c;
        if (i2 == -1) {
            dlaVar.p(this, i);
            for (int i3 = 0; i3 < this.d + 1; i3++) {
                dla dlaVar2 = ((dla[]) this.n.h)[i3];
            }
            return;
        }
        if (i2 == -1) {
            kw kwVarAd = ad();
            kwVarAd.a = dlaVar;
            float f = i;
            dlaVar.e = f;
            kwVarAd.b = f;
            kwVarAd.e = true;
            u(kwVarAd);
            return;
        }
        kw kwVar = this.h[i2];
        if (kwVar.e) {
            kwVar.b = i;
            return;
        }
        if (kwVar.d.n() == 0) {
            kwVar.e = true;
            kwVar.b = i;
            return;
        }
        kw kwVarAd2 = ad();
        if (i < 0) {
            kwVarAd2.b = i * (-1);
            kwVarAd2.d.q(dlaVar, 1.0f);
        } else {
            kwVarAd2.b = i;
            kwVarAd2.d.q(dlaVar, -1.0f);
        }
        u(kwVarAd2);
    }

    public final void w(dla dlaVar, dla dlaVar2, int i, int i2) {
        if (i2 == 8 && dlaVar2.f && dlaVar.c == -1) {
            dlaVar.p(this, dlaVar2.e + i);
            return;
        }
        kw kwVarAd = ad();
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            kwVarAd.b = i;
        }
        if (z) {
            kwVarAd.d.q(dlaVar, 1.0f);
            kwVarAd.d.q(dlaVar2, -1.0f);
        } else {
            kwVarAd.d.q(dlaVar, -1.0f);
            kwVarAd.d.q(dlaVar2, 1.0f);
        }
        if (i2 != 8) {
            kwVarAd.f(this, i2);
        }
        u(kwVarAd);
    }

    public final void x(dla dlaVar, dla dlaVar2, int i, int i2) {
        kw kwVarAd = ad();
        dla dlaVarAe = ae();
        dlaVarAe.d = 0;
        kwVarAd.g(dlaVar, dlaVar2, dlaVarAe, i);
        if (i2 != 8) {
            kwVarAd.d.q(ab(i2), (int) (kwVarAd.d.m(dlaVarAe) * (-1.0f)));
        }
        u(kwVarAd);
    }

    public final void y(dla dlaVar, dla dlaVar2, int i, int i2) {
        kw kwVarAd = ad();
        dla dlaVarAe = ae();
        dlaVarAe.d = 0;
        kwVarAd.h(dlaVar, dlaVar2, dlaVarAe, i);
        if (i2 != 8) {
            kwVarAd.d.q(ab(i2), (int) (kwVarAd.d.m(dlaVarAe) * (-1.0f)));
        }
        u(kwVarAd);
    }

    public final void z(kw kwVar) {
        int i;
        if (kwVar.e) {
            kwVar.a.p(this, kwVar.b);
        } else {
            kw[] kwVarArr = this.h;
            int i2 = this.l;
            kwVarArr[i2] = kwVar;
            dla dlaVar = kwVar.a;
            dlaVar.c = i2;
            this.l = i2 + 1;
            dlaVar.q(this, kwVar);
        }
        if (this.c) {
            int i3 = 0;
            while (i3 < this.l) {
                if (this.h[i3] == null) {
                    System.out.println("WTF");
                }
                kw kwVar2 = this.h[i3];
                if (kwVar2 != null && kwVar2.e) {
                    kwVar2.a.p(this, kwVar2.b);
                    ((cuw) this.n.e).c(kwVar2);
                    this.h[i3] = null;
                    int i4 = i3 + 1;
                    int i5 = i4;
                    while (true) {
                        i = this.l;
                        if (i4 >= i) {
                            break;
                        }
                        kw[] kwVarArr2 = this.h;
                        int i6 = i4 - 1;
                        kw kwVar3 = kwVarArr2[i4];
                        kwVarArr2[i6] = kwVar3;
                        dla dlaVar2 = kwVar3.a;
                        if (dlaVar2.c == i4) {
                            dlaVar2.c = i6;
                        }
                        i5 = i4;
                        i4++;
                    }
                    if (i5 < i) {
                        this.h[i5] = null;
                    }
                    this.l = i - 1;
                    i3--;
                }
                i3++;
            }
            this.c = false;
        }
    }
}
