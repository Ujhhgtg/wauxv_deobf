package me.hd.wauxv.obf;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class adb {
    public int b;
    public boolean c;
    public final adq d;
    public final int e;
    public adb f;
    public dla i;
    public HashSet a = null;
    public int g = 0;
    public int h = Integer.MIN_VALUE;

    public adb(adq adqVar, int i) {
        this.d = adqVar;
        this.e = i;
    }

    public final void j(adb adbVar, int i) {
        k(adbVar, i, Integer.MIN_VALUE, false);
    }

    public final boolean k(adb adbVar, int i, int i2, boolean z) {
        if (adbVar == null) {
            s();
            return true;
        }
        if (!z && !r(adbVar)) {
            return false;
        }
        this.f = adbVar;
        if (adbVar.a == null) {
            adbVar.a = new HashSet();
        }
        HashSet hashSet = this.f.a;
        if (hashSet != null) {
            hashSet.add(this);
        }
        this.g = i;
        this.h = i2;
        return true;
    }

    public final void l(int i, ArrayList arrayList, eum eumVar) {
        HashSet hashSet = this.a;
        if (hashSet != null) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                emn.ai(((adb) it.next()).d, i, arrayList, eumVar);
            }
        }
    }

    public final int m() {
        if (this.c) {
            return this.b;
        }
        return 0;
    }

    public final int n() {
        adb adbVar;
        if (this.d.bq == 8) {
            return 0;
        }
        int i = this.h;
        return (i == Integer.MIN_VALUE || (adbVar = this.f) == null || adbVar.d.bq != 8) ? this.g : i;
    }

    public final adb o() {
        int i = this.e;
        int iAe = dkz.ae(i);
        adq adqVar = this.d;
        switch (iAe) {
            case 0:
            case 5:
            case 6:
            case 7:
            case 8:
                return null;
            case 1:
                return adqVar.au;
            case 2:
                return adqVar.av;
            case 3:
                return adqVar.as;
            case 4:
                return adqVar.at;
            default:
                throw new AssertionError(yg.w(i));
        }
    }

    public final boolean p() {
        HashSet hashSet = this.a;
        if (hashSet == null) {
            return false;
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            if (((adb) it.next()).o().q()) {
                return true;
            }
        }
        return false;
    }

    public final boolean q() {
        return this.f != null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Found duplicated region for block: B:46:0x0063 A[RETURN] */
    public final boolean r(adb adbVar) {
        if (adbVar != null) {
            adq adqVar = adbVar.d;
            int i = adbVar.e;
            int i2 = this.e;
            if (i != i2) {
                switch (dkz.ae(i2)) {
                    case 0:
                    case 7:
                    case 8:
                        break;
                    case 1:
                    case 3:
                        boolean z = i == 2 || i == 4;
                        if (!(adqVar instanceof bjp)) {
                            return z;
                        }
                        if (z || i == 8) {
                            return true;
                        }
                        break;
                    case 2:
                    case 4:
                        boolean z2 = i == 3 || i == 5;
                        if (!(adqVar instanceof bjp)) {
                            return z2;
                        }
                        if (z2 || i == 9) {
                            return true;
                        }
                        break;
                    case 5:
                        if (i != 2 && i != 4) {
                            return true;
                        }
                        break;
                    case 6:
                        if (i != 6 && i != 8 && i != 9) {
                            return true;
                        }
                        break;
                    default:
                        throw new AssertionError(yg.w(i2));
                }
            } else if (i2 != 6 || (adqVar.ao && this.d.ao)) {
                return true;
            }
        }
        return false;
    }

    public final void s() {
        HashSet hashSet;
        adb adbVar = this.f;
        if (adbVar != null && (hashSet = adbVar.a) != null) {
            hashSet.remove(this);
            if (this.f.a.size() == 0) {
                this.f.a = null;
            }
        }
        this.a = null;
        this.f = null;
        this.g = 0;
        this.h = Integer.MIN_VALUE;
        this.c = false;
        this.b = 0;
    }

    public final void t() {
        dla dlaVar = this.i;
        if (dlaVar == null) {
            this.i = new dla(1);
        } else {
            dlaVar.o();
        }
    }

    public final String toString() {
        return this.d.br + ":" + yg.w(this.e);
    }

    public final void u(int i) {
        this.b = i;
        this.c = true;
    }
}
