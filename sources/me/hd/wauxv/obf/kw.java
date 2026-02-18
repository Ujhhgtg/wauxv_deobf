package me.hd.wauxv.obf;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class kw {
    public final kn d;
    public dla a = null;
    public float b = 0.0f;
    public final ArrayList c = new ArrayList();
    public boolean e = false;

    public kw(jx jxVar) {
        this.d = new kn(this, jxVar);
    }

    public final void f(bvm bvmVar, int i) {
        this.d.q(bvmVar.ab(i), 1.0f);
        this.d.q(bvmVar.ab(i), -1.0f);
    }

    public final void g(dla dlaVar, dla dlaVar2, dla dlaVar3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.b = i;
        }
        if (z) {
            this.d.q(dlaVar, 1.0f);
            this.d.q(dlaVar2, -1.0f);
            this.d.q(dlaVar3, -1.0f);
        } else {
            this.d.q(dlaVar, -1.0f);
            this.d.q(dlaVar2, 1.0f);
            this.d.q(dlaVar3, 1.0f);
        }
    }

    public final void h(dla dlaVar, dla dlaVar2, dla dlaVar3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.b = i;
        }
        if (z) {
            this.d.q(dlaVar, 1.0f);
            this.d.q(dlaVar2, -1.0f);
            this.d.q(dlaVar3, 1.0f);
        } else {
            this.d.q(dlaVar, -1.0f);
            this.d.q(dlaVar2, 1.0f);
            this.d.q(dlaVar3, -1.0f);
        }
    }

    public dla i(boolean[] zArr) {
        return k(zArr, null);
    }

    public boolean j() {
        return this.a == null && this.b == 0.0f && this.d.n() == 0;
    }

    public final dla k(boolean[] zArr, dla dlaVar) {
        int i;
        int iN = this.d.n();
        dla dlaVar2 = null;
        float f = 0.0f;
        for (int i2 = 0; i2 < iN; i2++) {
            float fP = this.d.p(i2);
            if (fP < 0.0f) {
                dla dlaVarO = this.d.o(i2);
                if ((zArr == null || !zArr[dlaVarO.b]) && dlaVarO != dlaVar && (((i = dlaVarO.l) == 3 || i == 4) && fP < f)) {
                    f = fP;
                    dlaVar2 = dlaVarO;
                }
            }
        }
        return dlaVar2;
    }

    public final void l(dla dlaVar) {
        dla dlaVar2 = this.a;
        if (dlaVar2 != null) {
            this.d.q(dlaVar2, -1.0f);
            this.a.c = -1;
            this.a = null;
        }
        float fR = this.d.r(dlaVar, true) * (-1.0f);
        this.a = dlaVar;
        if (fR == 1.0f) {
            return;
        }
        this.b /= fR;
        kn knVar = this.d;
        int i = knVar.h;
        for (int i2 = 0; i != -1 && i2 < knVar.a; i2++) {
            float[] fArr = knVar.g;
            fArr[i] = fArr[i] / fR;
            i = knVar.f[i];
        }
    }

    public final void m(bvm bvmVar, dla dlaVar, boolean z) {
        if (dlaVar.f) {
            float fM = this.d.m(dlaVar);
            this.b = (dlaVar.e * fM) + this.b;
            this.d.r(dlaVar, z);
            if (z) {
                dlaVar.n(this);
            }
            if (this.d.n() == 0) {
                this.e = true;
                bvmVar.c = true;
            }
        }
    }

    public void n(bvm bvmVar, kw kwVar, boolean z) {
        kn knVar = this.d;
        knVar.getClass();
        float fM = knVar.m(kwVar.a);
        knVar.r(kwVar.a, z);
        kn knVar2 = kwVar.d;
        int iN = knVar2.n();
        for (int i = 0; i < iN; i++) {
            dla dlaVarO = knVar2.o(i);
            knVar.k(dlaVarO, knVar2.m(dlaVarO) * fM, z);
        }
        this.b = (kwVar.b * fM) + this.b;
        if (z) {
            kwVar.a.n(this);
        }
        if (this.a == null || this.d.n() != 0) {
            return;
        }
        this.e = true;
        bvmVar.c = true;
    }

    public String toString() {
        boolean z;
        String strS = dkz.s(this.a == null ? "0" : "" + this.a, " = ");
        if (this.b != 0.0f) {
            StringBuilder sbY = dkz.y(strS);
            sbY.append(this.b);
            strS = sbY.toString();
            z = true;
        } else {
            z = false;
        }
        int iN = this.d.n();
        for (int i = 0; i < iN; i++) {
            dla dlaVarO = this.d.o(i);
            if (dlaVarO != null) {
                float fP = this.d.p(i);
                if (fP != 0.0f) {
                    String string = dlaVarO.toString();
                    if (z) {
                        if (fP > 0.0f) {
                            strS = dkz.s(strS, " + ");
                        } else {
                            strS = dkz.s(strS, " - ");
                            fP *= -1.0f;
                        }
                    } else if (fP < 0.0f) {
                        strS = dkz.s(strS, "- ");
                        fP *= -1.0f;
                    }
                    strS = fP == 1.0f ? dkz.s(strS, string) : strS + fP + " " + string;
                    z = true;
                }
            }
        }
        return !z ? dkz.s(strS, "0.0") : strS;
    }
}
