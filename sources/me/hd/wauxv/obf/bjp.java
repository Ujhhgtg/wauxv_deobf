package me.hd.wauxv.obf;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bjp extends adq {
    public float a = -1.0f;
    public int b = -1;
    public int c = -1;
    public adb d = this.at;
    public int i = 0;
    public boolean j;

    public bjp() {
        this.bb.clear();
        this.bb.add(this.d);
        int length = this.ba.length;
        for (int i = 0; i < length; i++) {
            this.ba[i] = this.d;
        }
    }

    @Override // me.hd.wauxv.obf.adq
    public final adb ck(int i) {
        int iAe = dkz.ae(i);
        if (iAe != 1) {
            if (iAe != 2) {
                if (iAe != 3) {
                    if (iAe != 4) {
                        return null;
                    }
                }
            }
            if (this.i == 0) {
                return this.d;
            }
            return null;
        }
        if (this.i == 1) {
            return this.d;
        }
        return null;
    }

    @Override // me.hd.wauxv.obf.adq
    public final void dm(bvm bvmVar, boolean z) {
        if (this.bd == null) {
            return;
        }
        adb adbVar = this.d;
        bvmVar.getClass();
        int iR = bvm.r(adbVar);
        if (this.i == 1) {
            this.bi = iR;
            this.bj = 0;
            dh(this.bd.cm());
            dk(0);
            return;
        }
        this.bi = 0;
        this.bj = iR;
        dk(this.bd.cq());
        dh(0);
    }

    public final void dn(int i) {
        this.d.u(i);
        this.j = true;
    }

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public final void m11do(int i) {
        if (this.i == i) {
            return;
        }
        this.i = i;
        ArrayList arrayList = this.bb;
        arrayList.clear();
        if (this.i == 1) {
            this.d = this.as;
        } else {
            this.d = this.at;
        }
        arrayList.add(this.d);
        adb[] adbVarArr = this.ba;
        int length = adbVarArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            adbVarArr[i2] = this.d;
        }
    }

    @Override // me.hd.wauxv.obf.adq
    public final void e(bvm bvmVar, boolean z) {
        adr adrVar = (adr) this.bd;
        if (adrVar == null) {
            return;
        }
        Object objCk = adrVar.ck(2);
        Object objCk2 = adrVar.ck(4);
        adq adqVar = this.bd;
        boolean z2 = adqVar != null && adqVar.bz[0] == 2;
        if (this.i == 0) {
            objCk = adrVar.ck(3);
            objCk2 = adrVar.ck(5);
            adq adqVar2 = this.bd;
            z2 = adqVar2 != null && adqVar2.bz[1] == 2;
        }
        if (this.j) {
            adb adbVar = this.d;
            if (adbVar.c) {
                dla dlaVarAc = bvmVar.ac(adbVar);
                bvmVar.v(dlaVarAc, this.d.m());
                if (this.b != -1) {
                    if (z2) {
                        bvmVar.x(bvmVar.ac(objCk2), dlaVarAc, 0, 5);
                    }
                } else if (this.c != -1 && z2) {
                    dla dlaVarAc2 = bvmVar.ac(objCk2);
                    bvmVar.x(dlaVarAc, bvmVar.ac(objCk), 0, 5);
                    bvmVar.x(dlaVarAc2, dlaVarAc, 0, 5);
                }
                this.j = false;
                return;
            }
        }
        if (this.b != -1) {
            dla dlaVarAc3 = bvmVar.ac(this.d);
            bvmVar.w(dlaVarAc3, bvmVar.ac(objCk), this.b, 8);
            if (z2) {
                bvmVar.x(bvmVar.ac(objCk2), dlaVarAc3, 0, 5);
                return;
            }
            return;
        }
        if (this.c != -1) {
            dla dlaVarAc4 = bvmVar.ac(this.d);
            dla dlaVarAc5 = bvmVar.ac(objCk2);
            bvmVar.w(dlaVarAc4, dlaVarAc5, -this.c, 8);
            if (z2) {
                bvmVar.x(dlaVarAc4, bvmVar.ac(objCk), 0, 5);
                bvmVar.x(dlaVarAc5, dlaVarAc4, 0, 5);
                return;
            }
            return;
        }
        if (this.a != -1.0f) {
            dla dlaVarAc6 = bvmVar.ac(this.d);
            dla dlaVarAc7 = bvmVar.ac(objCk2);
            float f = this.a;
            kw kwVarAd = bvmVar.ad();
            kwVarAd.d.q(dlaVarAc6, -1.0f);
            kwVarAd.d.q(dlaVarAc7, f);
            bvmVar.u(kwVarAd);
        }
    }

    @Override // me.hd.wauxv.obf.adq
    public final boolean f() {
        return true;
    }

    @Override // me.hd.wauxv.obf.adq
    public final boolean g() {
        return this.j;
    }

    @Override // me.hd.wauxv.obf.adq
    public final boolean h() {
        return this.j;
    }
}
