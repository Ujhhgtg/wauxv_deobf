package me.hd.wauxv.obf;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dla implements Comparable {
    public boolean a;
    public float e;
    public int l;
    public int b = -1;
    public int c = -1;
    public int d = 0;
    public boolean f = false;
    public final float[] g = new float[9];
    public final float[] h = new float[9];
    public kw[] i = new kw[16];
    public int j = 0;
    public int k = 0;

    public dla(int i) {
        this.l = i;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.b - ((dla) obj).b;
    }

    public final void m(kw kwVar) {
        int i = 0;
        while (true) {
            int i2 = this.j;
            if (i >= i2) {
                kw[] kwVarArr = this.i;
                if (i2 >= kwVarArr.length) {
                    this.i = (kw[]) Arrays.copyOf(kwVarArr, kwVarArr.length * 2);
                }
                kw[] kwVarArr2 = this.i;
                int i3 = this.j;
                kwVarArr2[i3] = kwVar;
                this.j = i3 + 1;
                return;
            }
            if (this.i[i] == kwVar) {
                return;
            } else {
                i++;
            }
        }
    }

    public final void n(kw kwVar) {
        int i = this.j;
        int i2 = 0;
        while (i2 < i) {
            if (this.i[i2] == kwVar) {
                while (i2 < i - 1) {
                    kw[] kwVarArr = this.i;
                    int i3 = i2 + 1;
                    kwVarArr[i2] = kwVarArr[i3];
                    i2 = i3;
                }
                this.j--;
                return;
            }
            i2++;
        }
    }

    public final void o() {
        this.l = 5;
        this.d = 0;
        this.b = -1;
        this.c = -1;
        this.e = 0.0f;
        this.f = false;
        int i = this.j;
        for (int i2 = 0; i2 < i; i2++) {
            this.i[i2] = null;
        }
        this.j = 0;
        this.k = 0;
        this.a = false;
        Arrays.fill(this.h, 0.0f);
    }

    public final void p(bvm bvmVar, float f) {
        this.e = f;
        this.f = true;
        int i = this.j;
        this.c = -1;
        for (int i2 = 0; i2 < i; i2++) {
            this.i[i2].m(bvmVar, this, false);
        }
        this.j = 0;
    }

    public final void q(bvm bvmVar, kw kwVar) {
        int i = this.j;
        for (int i2 = 0; i2 < i; i2++) {
            this.i[i2].n(bvmVar, kwVar, false);
        }
        this.j = 0;
    }

    public final String toString() {
        return "" + this.b;
    }
}
