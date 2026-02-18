package me.hd.wauxv.obf;

import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class adf extends ViewGroup.MarginLayoutParams {
    public int a;
    public int aa;
    public int ab;
    public int ac;
    public int ad;
    public float ae;
    public float af;
    public String ag;
    public float ah;
    public float ai;
    public int aj;
    public int ak;
    public int al;
    public int am;
    public int an;
    public int ao;
    public int ap;
    public int aq;
    public float ar;
    public float as;
    public int at;
    public int au;
    public int av;
    public boolean aw;
    public boolean ax;
    public String ay;
    public int az;
    public int b;
    public boolean ba;
    public boolean bb;
    public boolean bc;
    public boolean bd;
    public boolean be;
    public int bf;
    public int bg;
    public int bh;
    public int bi;
    public int bj;
    public int bk;
    public float bl;
    public int bm;
    public int bn;
    public float bo;
    public adq bp;
    public float c;
    public boolean d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public float r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;

    public final void bq() {
        this.bd = false;
        this.ba = true;
        this.bb = true;
        int i = ((ViewGroup.MarginLayoutParams) this).width;
        if (i == -2 && this.aw) {
            this.ba = false;
            if (this.al == 0) {
                this.al = 1;
            }
        }
        int i2 = ((ViewGroup.MarginLayoutParams) this).height;
        if (i2 == -2 && this.ax) {
            this.bb = false;
            if (this.am == 0) {
                this.am = 1;
            }
        }
        if (i == 0 || i == -1) {
            this.ba = false;
            if (i == 0 && this.al == 1) {
                ((ViewGroup.MarginLayoutParams) this).width = -2;
                this.aw = true;
            }
        }
        if (i2 == 0 || i2 == -1) {
            this.bb = false;
            if (i2 == 0 && this.am == 1) {
                ((ViewGroup.MarginLayoutParams) this).height = -2;
                this.ax = true;
            }
        }
        if (this.c == -1.0f && this.a == -1 && this.b == -1) {
            return;
        }
        this.bd = true;
        this.ba = true;
        this.bb = true;
        if (!(this.bp instanceof bjp)) {
            this.bp = new bjp();
        }
        ((bjp) this.bp).m11do(this.av);
    }

    /* JADX WARN: Found duplicated region for block: B:17:0x004a  */
    /* JADX WARN: Found duplicated region for block: B:20:0x0051  */
    /* JADX WARN: Found duplicated region for block: B:23:0x0058  */
    /* JADX WARN: Found duplicated region for block: B:26:0x005e  */
    /* JADX WARN: Found duplicated region for block: B:29:0x0064  */
    /* JADX WARN: Found duplicated region for block: B:38:0x007a  */
    /* JADX WARN: Found duplicated region for block: B:39:0x0082 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:40:0x0084  */
    /* JADX WARN: Found duplicated region for block: B:41:0x008b A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:42:0x008d  */
    @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
    public final void resolveLayoutDirection(int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6 = ((ViewGroup.MarginLayoutParams) this).leftMargin;
        int i7 = ((ViewGroup.MarginLayoutParams) this).rightMargin;
        super.resolveLayoutDirection(i);
        boolean z = false;
        boolean z2 = 1 == getLayoutDirection();
        this.bh = -1;
        this.bi = -1;
        this.bf = -1;
        this.bg = -1;
        this.bj = this.w;
        this.bk = this.y;
        float f = this.ae;
        this.bl = f;
        int i8 = this.a;
        this.bm = i8;
        int i9 = this.b;
        this.bn = i9;
        float f2 = this.c;
        this.bo = f2;
        if (z2) {
            int i10 = this.s;
            if (i10 != -1) {
                this.bh = i10;
            } else {
                int i11 = this.t;
                if (i11 != -1) {
                    this.bi = i11;
                } else {
                    i2 = this.u;
                    if (i2 != -1) {
                        this.bg = i2;
                        z = true;
                    }
                    i3 = this.v;
                    if (i3 != -1) {
                        this.bf = i3;
                        z = true;
                    }
                    i4 = this.aa;
                    if (i4 != Integer.MIN_VALUE) {
                        this.bk = i4;
                    }
                    i5 = this.ab;
                    if (i5 != Integer.MIN_VALUE) {
                        this.bj = i5;
                    }
                    if (z) {
                        this.bl = 1.0f - f;
                    }
                    if (this.bd && this.av == 1 && this.d) {
                        if (f2 != -1.0f) {
                            this.bo = 1.0f - f2;
                            this.bm = -1;
                            this.bn = -1;
                        } else if (i8 != -1) {
                            this.bn = i8;
                            this.bm = -1;
                            this.bo = -1.0f;
                        } else if (i9 != -1) {
                            this.bm = i9;
                            this.bn = -1;
                            this.bo = -1.0f;
                        }
                    }
                }
            }
            z = true;
            i2 = this.u;
            if (i2 != -1) {
                this.bg = i2;
                z = true;
            }
            i3 = this.v;
            if (i3 != -1) {
                this.bf = i3;
                z = true;
            }
            i4 = this.aa;
            if (i4 != Integer.MIN_VALUE) {
                this.bk = i4;
            }
            i5 = this.ab;
            if (i5 != Integer.MIN_VALUE) {
                this.bj = i5;
            }
            if (z) {
                this.bl = 1.0f - f;
            }
            if (this.bd) {
                if (f2 != -1.0f) {
                    this.bo = 1.0f - f2;
                    this.bm = -1;
                    this.bn = -1;
                } else if (i8 != -1) {
                    this.bn = i8;
                    this.bm = -1;
                    this.bo = -1.0f;
                } else if (i9 != -1) {
                    this.bm = i9;
                    this.bn = -1;
                    this.bo = -1.0f;
                }
            }
        } else {
            int i12 = this.s;
            if (i12 != -1) {
                this.bg = i12;
            }
            int i13 = this.t;
            if (i13 != -1) {
                this.bf = i13;
            }
            int i14 = this.u;
            if (i14 != -1) {
                this.bh = i14;
            }
            int i15 = this.v;
            if (i15 != -1) {
                this.bi = i15;
            }
            int i16 = this.aa;
            if (i16 != Integer.MIN_VALUE) {
                this.bj = i16;
            }
            int i17 = this.ab;
            if (i17 != Integer.MIN_VALUE) {
                this.bk = i17;
            }
        }
        if (this.u == -1 && this.v == -1 && this.t == -1 && this.s == -1) {
            int i18 = this.g;
            if (i18 != -1) {
                this.bh = i18;
                if (((ViewGroup.MarginLayoutParams) this).rightMargin <= 0 && i7 > 0) {
                    ((ViewGroup.MarginLayoutParams) this).rightMargin = i7;
                }
            } else {
                int i19 = this.h;
                if (i19 != -1) {
                    this.bi = i19;
                    if (((ViewGroup.MarginLayoutParams) this).rightMargin <= 0 && i7 > 0) {
                        ((ViewGroup.MarginLayoutParams) this).rightMargin = i7;
                    }
                }
            }
            int i20 = this.e;
            if (i20 != -1) {
                this.bf = i20;
                if (((ViewGroup.MarginLayoutParams) this).leftMargin > 0 || i6 <= 0) {
                    return;
                }
                ((ViewGroup.MarginLayoutParams) this).leftMargin = i6;
                return;
            }
            int i21 = this.f;
            if (i21 != -1) {
                this.bg = i21;
                if (((ViewGroup.MarginLayoutParams) this).leftMargin > 0 || i6 <= 0) {
                    return;
                }
                ((ViewGroup.MarginLayoutParams) this).leftMargin = i6;
            }
        }
    }
}
