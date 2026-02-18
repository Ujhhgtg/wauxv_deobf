package me.hd.wauxv.obf;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bvh {
    public atb a;
    public int b;
    public int c;
    public boolean d;
    public boolean e;

    public bvh() {
        i();
    }

    public final void f() {
        this.c = this.d ? this.a.j() : this.a.n();
    }

    public final void g(View view, int i) {
        if (this.d) {
            int iE = this.a.e(view);
            atb atbVar = this.a;
            this.c = (Integer.MIN_VALUE == atbVar.a ? 0 : atbVar.o() - atbVar.a) + iE;
        } else {
            this.c = this.a.locateDex(view);
        }
        this.b = i;
    }

    public final void h(View view, int i) {
        atb atbVar = this.a;
        int iO = Integer.MIN_VALUE == atbVar.a ? 0 : atbVar.o() - atbVar.a;
        if (iO >= 0) {
            g(view, i);
            return;
        }
        this.b = i;
        if (!this.d) {
            int iH = this.a.locateDex(view);
            int iN = iH - this.a.n();
            this.c = iH;
            if (iN > 0) {
                int iJ = (this.a.j() - Math.min(0, (this.a.j() - iO) - this.a.e(view))) - (this.a.f(view) + iH);
                if (iJ < 0) {
                    this.c -= Math.min(iN, -iJ);
                    return;
                }
                return;
            }
            return;
        }
        int iJ2 = (this.a.j() - iO) - this.a.e(view);
        this.c = this.a.j() - iJ2;
        if (iJ2 > 0) {
            int iF = this.c - this.a.f(view);
            int iN2 = this.a.n();
            int iMin = iF - (Math.min(this.a.locateDex(view) - iN2, 0) + iN2);
            if (iMin < 0) {
                this.c = Math.min(iJ2, -iMin) + this.c;
            }
        }
    }

    public final void i() {
        this.b = -1;
        this.c = Integer.MIN_VALUE;
        this.d = false;
        this.e = false;
    }

    public final String toString() {
        return "AnchorInfo{mPosition=" + this.b + ", mCoordinate=" + this.c + ", mLayoutFromEnd=" + this.d + ", mValid="
                + this.e + '}';
    }
}
