package me.hd.wauxv.obf;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cvr extends kw {
    public dla[] o;
    public dla[] p;
    public int q;
    public but r;

    @Override // me.hd.wauxv.obf.kw
    public final dla i(boolean[] zArr) {
        int i = -1;
        for (int i2 = 0; i2 < this.q; i2++) {
            dla[] dlaVarArr = this.o;
            dla dlaVar = dlaVarArr[i2];
            if (!zArr[dlaVar.b]) {
                but butVar = this.r;
                butVar.b = dlaVar;
                int i3 = 8;
                if (i != -1) {
                    dla dlaVar2 = dlaVarArr[i];
                    while (i3 >= 0) {
                        float f = dlaVar2.h[i3];
                        float f2 = ((dla) butVar.b).h[i3];
                        if (f2 != f) {
                            if (f2 >= f) {
                                break;
                            }
                            i = i2;
                            break;
                            break;
                        }
                        i3--;
                    }
                } else {
                    while (i3 >= 0) {
                        float f3 = ((dla) butVar.b).h[i3];
                        if (f3 > 0.0f) {
                            break;
                        }
                        if (f3 < 0.0f) {
                            i = i2;
                            break;
                        }
                        i3--;
                    }
                }
            }
        }
        if (i == -1) {
            return null;
        }
        return this.o[i];
    }

    @Override // me.hd.wauxv.obf.kw
    public final boolean j() {
        return this.q == 0;
    }

    @Override // me.hd.wauxv.obf.kw
    public final void n(bvm bvmVar, kw kwVar, boolean z) {
        dla dlaVar = kwVar.a;
        if (dlaVar == null) {
            return;
        }
        float[] fArr = dlaVar.h;
        kn knVar = kwVar.d;
        int iN = knVar.n();
        for (int i = 0; i < iN; i++) {
            dla dlaVarO = knVar.o(i);
            float fP = knVar.p(i);
            but butVar = this.r;
            butVar.b = dlaVarO;
            if (dlaVarO.a) {
                boolean z2 = true;
                for (int i2 = 0; i2 < 9; i2++) {
                    float[] fArr2 = ((dla) butVar.b).h;
                    float f = (fArr[i2] * fP) + fArr2[i2];
                    fArr2[i2] = f;
                    if (Math.abs(f) < 1.0E-4f) {
                        ((dla) butVar.b).h[i2] = 0.0f;
                    } else {
                        z2 = false;
                    }
                }
                if (z2) {
                    ((cvr) butVar.c).t((dla) butVar.b);
                }
            } else {
                for (int i3 = 0; i3 < 9; i3++) {
                    float f2 = fArr[i3];
                    if (f2 != 0.0f) {
                        float f3 = f2 * fP;
                        if (Math.abs(f3) < 1.0E-4f) {
                            f3 = 0.0f;
                        }
                        ((dla) butVar.b).h[i3] = f3;
                    } else {
                        ((dla) butVar.b).h[i3] = 0.0f;
                    }
                }
                s(dlaVarO);
            }
            this.b = (kwVar.b * fP) + this.b;
        }
        t(dlaVar);
    }

    public final void s(dla dlaVar) {
        int i;
        int i2 = this.q + 1;
        dla[] dlaVarArr = this.o;
        if (i2 > dlaVarArr.length) {
            dla[] dlaVarArr2 = (dla[]) Arrays.copyOf(dlaVarArr, dlaVarArr.length * 2);
            this.o = dlaVarArr2;
            this.p = (dla[]) Arrays.copyOf(dlaVarArr2, dlaVarArr2.length * 2);
        }
        dla[] dlaVarArr3 = this.o;
        int i3 = this.q;
        dlaVarArr3[i3] = dlaVar;
        int i4 = i3 + 1;
        this.q = i4;
        if (i4 > 1 && dlaVarArr3[i3].b > dlaVar.b) {
            int i5 = 0;
            while (true) {
                i = this.q;
                if (i5 >= i) {
                    break;
                }
                this.p[i5] = this.o[i5];
                i5++;
            }
            Arrays.sort(this.p, 0, i, new ex(9));
            for (int i6 = 0; i6 < this.q; i6++) {
                this.o[i6] = this.p[i6];
            }
        }
        dlaVar.a = true;
        dlaVar.m(this);
    }

    public final void t(dla dlaVar) {
        int i = 0;
        while (i < this.q) {
            if (this.o[i] == dlaVar) {
                while (true) {
                    int i2 = this.q;
                    if (i >= i2 - 1) {
                        this.q = i2 - 1;
                        dlaVar.a = false;
                        return;
                    } else {
                        dla[] dlaVarArr = this.o;
                        int i3 = i + 1;
                        dlaVarArr[i] = dlaVarArr[i3];
                        i = i3;
                    }
                }
            } else {
                i++;
            }
        }
    }

    @Override // me.hd.wauxv.obf.kw
    public final String toString() {
        but butVar = this.r;
        String str = " goal -> (" + this.b + ") : ";
        for (int i = 0; i < this.q; i++) {
            butVar.b = this.o[i];
            str = str + butVar + " ";
        }
        return str;
    }
}
