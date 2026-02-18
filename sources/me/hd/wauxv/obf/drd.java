package me.hd.wauxv.obf;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class drd {
    public static final za a = new za(5);
    public afo e;
    public anu f;
    public int g;
    public int h;
    public List i;
    public List j;
    public dre k;
    public csk l;
    public ek m;
    public final RectF b = new RectF();
    public final int[] c = new int[4];
    public final coe d = ajn.aa(0, 0);
    public int n = -1;
    public int o = -1;

    /* JADX WARN: Found duplicated region for block: B:106:0x01a2 */
    /* JADX WARN: Found duplicated region for block: B:109:0x01b5 */
    /* JADX WARN: Found duplicated region for block: B:116:0x01d6 */
    /* JADX WARN: Found duplicated region for block: B:118:0x01db */
    /* JADX WARN: Found duplicated region for block: B:119:0x01dd */
    /* JADX WARN: Found duplicated region for block: B:124:0x01ea */
    /* JADX WARN: Found duplicated region for block: B:125:0x01ec */
    /*
     * JADX WARN: Found duplicated region for block: B:135:0x01f3 A[EDGE_INSN:
     * B:135:0x01f3->B:127:0x01f3 BREAK A[LOOP:1: B:23:0x0056->B:126:0x01ee],
     * SYNTHETIC]
     */
    /*
     * JADX WARN: Found duplicated region for block: B:138:0x00a6 A[ADDED_TO_REGION,
     * EDGE_INSN: B:138:0x00a6->B:49:0x00a6 BREAK A[LOOP:2:
     * B:44:0x008e->B:48:0x00a2], REMOVE, SYNTHETIC]
     */
    /* JADX WARN: Found duplicated region for block: B:140:0x00f8 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:141:0x00eb A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:142:0x00eb A[SYNTHETIC] */
    /*
     * JADX WARN: Found duplicated region for block: B:143:0x0163 A[EDGE_INSN:
     * B:143:0x0163->B:79:0x0163 BREAK A[LOOP:4: B:66:0x0106->B:78:0x015c],
     * SYNTHETIC]
     */
    /* JADX WARN: Found duplicated region for block: B:28:0x0062 */
    /* JADX WARN: Found duplicated region for block: B:33:0x0072 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:34:0x0074 */
    /* JADX WARN: Found duplicated region for block: B:35:0x0077 */
    /* JADX WARN: Found duplicated region for block: B:38:0x007b */
    /* JADX WARN: Found duplicated region for block: B:41:0x0084 */
    /* JADX WARN: Found duplicated region for block: B:42:0x0087 */
    /* JADX WARN: Found duplicated region for block: B:46:0x0094 */
    /* JADX WARN: Found duplicated region for block: B:50:0x00a8 */
    /* JADX WARN: Found duplicated region for block: B:52:0x00ad */
    /* JADX WARN: Found duplicated region for block: B:54:0x00b7 */
    /* JADX WARN: Found duplicated region for block: B:55:0x00bb */
    /* JADX WARN: Found duplicated region for block: B:58:0x00de */
    /* JADX WARN: Found duplicated region for block: B:59:0x00e1 */
    /*
     * JADX WARN: Found duplicated region for block: B:63:0x00ef A[LOOP:3:
     * B:51:0x00ab->B:63:0x00ef, LOOP_END, MOVE_INLINED]
     */
    /* JADX WARN: Found duplicated region for block: B:65:0x00fe */
    /* JADX WARN: Found duplicated region for block: B:67:0x0108 */
    /* JADX WARN: Found duplicated region for block: B:69:0x010c */
    /* JADX WARN: Found duplicated region for block: B:70:0x0111 */
    /* JADX WARN: Found duplicated region for block: B:73:0x014e */
    /* JADX WARN: Found duplicated region for block: B:74:0x0151 */
    /*
     * JADX WARN: Found duplicated region for block: B:78:0x015c A[LOOP:4:
     * B:66:0x0106->B:78:0x015c, LOOP_END]
     */
    /* JADX WARN: Found duplicated region for block: B:81:0x0167 */
    /* JADX WARN: Found duplicated region for block: B:83:0x016b */
    /* JADX WARN: Found duplicated region for block: B:89:0x0176 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:90:0x0178 */
    /* JADX WARN: Found duplicated region for block: B:91:0x017a */
    /* JADX WARN: Found duplicated region for block: B:93:0x017e */
    /* JADX WARN: Found duplicated region for block: B:95:0x0185 */
    /* JADX WARN: Found duplicated region for block: B:99:0x018f */
    public static float p(drd drdVar, ArrayList arrayList, boolean z, cjn cjnVar, Canvas canvas, float f, dqz dqzVar) {
        dqz dqzVar2;
        int i;
        float f2;
        int i2;
        int size;
        int i3;
        boolean z2;
        dqz dqzVar3;
        boolean z3;
        float fX;
        int i4;
        int i5;
        boolean z4;
        int iMin;
        int i6;
        int i7;
        float f3;
        int i8;
        int i9;
        int i10;
        float f4;
        dra draVar;
        ek ekVar;
        dqy dqyVar;
        int i11;
        int i12;
        dle dleVar;
        int i13;
        boolean z5;
        int iMax;
        int i14;
        int i15;
        float f5 = 0.0f;
        for (ddn ddnVar : z ? new bzv(arrayList, 2) : arrayList) {
            ddnVar.getClass();
            float f6 = f + f5;
            char[] cArr = drdVar.e.a;
            boolean z6 = ddnVar.c;
            int i16 = z6 ? ddnVar.b : ddnVar.a;
            int i17 = z6 ? ddnVar.a - 1 : ddnVar.b;
            float f7 = drdVar.k.a * drdVar.l.a;
            int i18 = z6 ? ddnVar.b - 1 : ddnVar.a;
            float f8 = 0.0f;
            while (true) {
                if (!z6) {
                    if (i18 > i17) {
                        dqzVar2 = dqzVar;
                        break;
                    }
                    if (i18 != i17) {
                        if (z6) {
                        }
                        if (!z6) {
                            i16 = i18;
                        }
                        f2 = f6 + f8;
                        i2 = cjnVar.a;
                        if (z6) {
                        }
                        size = drdVar.i.size();
                        while (true) {
                            i3 = i2 + 1;
                            z2 = z6;
                            if (i3 < size) {
                                break;
                            }
                            break;
                            break;
                            i2 = i3;
                            z6 = z2;
                        }
                        if (z2) {
                            i12 = i2;
                            fX = 0.0f;
                            while (true) {
                                if (i16 <= i) {
                                    dqzVar2 = dqzVar;
                                    z6 = z2;
                                    break;
                                }
                                dleVar = (dle) drdVar.i.get(i12);
                                if (i12 == 0) {
                                    i13 = 0;
                                    z5 = false;
                                } else {
                                    i13 = dleVar.i();
                                    z5 = true;
                                }
                                iMax = Math.max(i, i13);
                                i14 = i;
                                int i19 = i12;
                                boolean z7 = z2;
                                float fX2 = drdVar.x(iMax, i16, z7, dleVar, canvas, f2 + fX, dqzVar);
                                z3 = z7;
                                dqzVar3 = dqzVar;
                                fX += fX2;
                                if (z5) {
                                }
                                if (f2 + fX > dqzVar3.c) {
                                    dqzVar2 = dqzVar3;
                                    z6 = z3;
                                    break;
                                }
                                i12 = i15;
                                i16 = iMax;
                                i = i14;
                                z2 = z3;
                            }
                        } else {
                            dqzVar3 = dqzVar;
                            z3 = z2;
                            fX = 0.0f;
                            while (true) {
                                if (i >= i16) {
                                    dqzVar2 = dqzVar3;
                                    z6 = z3;
                                    break;
                                }
                                i4 = i2 + 1;
                                if (i4 >= size) {
                                    i5 = drdVar.h;
                                    z4 = false;
                                } else {
                                    i5 = ((dle) drdVar.i.get(i4)).i();
                                    z4 = true;
                                }
                                iMin = Math.min(i16, i5);
                                i6 = size;
                                dqzVar2 = dqzVar3;
                                z6 = z3;
                                i7 = i16;
                                int i20 = i2;
                                fX += drdVar.x(i, iMin, z6, (dle) drdVar.i.get(i2), canvas, f2 + fX, dqzVar2);
                                if (z4) {
                                }
                                if (f2 + fX > dqzVar2.c) {
                                    break;
                                    break;
                                }
                                i = iMin;
                                z3 = z6;
                                dqzVar3 = dqzVar2;
                                i16 = i7;
                                size = i6;
                            }
                        }
                        f3 = f8 + fX;
                        if (i18 != i17) {
                            i10 = dqzVar2.d;
                            if (i18 != i10) {
                                if (i18 == i10) {
                                }
                                if (z6) {
                                    dqzVar2.e = (f3 + f7) - f4;
                                } else {
                                    dqzVar2.e = f4 + f3;
                                }
                                dqzVar2.c = 0.0f;
                            } else {
                                if (i18 == i10) {
                                }
                                if (z6) {
                                    dqzVar2.e = (f3 + f7) - f4;
                                } else {
                                    dqzVar2.e = f4 + f3;
                                }
                                dqzVar2.c = 0.0f;
                            }
                            draVar = dqzVar2.j;
                            if (draVar != null) {
                                float f9 = f6 + f3;
                                draVar.h(f9, f9 + f7);
                            }
                            ekVar = dqzVar2.n;
                            if (ekVar != null) {
                                ((float[][]) ekVar.d)[i18 / 262144][i18 % 262144] = f7;
                            }
                            i8 = i17;
                            dqyVar = dqzVar2.l;
                            if (dqyVar != null) {
                                dqyVar.h(canvas, cArr, i18, 1, i18, 1, z6, f6 + f3, f7, drdVar.k, null);
                            }
                            f3 += f7;
                        } else {
                            i8 = i17;
                        }
                        f8 = f3;
                        if (z6) {
                        }
                        if (f6 + f8 > dqzVar2.c) {
                            break;
                            break;
                        }
                    } else {
                        if (z6) {
                        }
                        if (!z6) {
                            i16 = i18;
                        }
                        f2 = f6 + f8;
                        i2 = cjnVar.a;
                        if (z6) {
                        }
                        size = drdVar.i.size();
                        while (true) {
                            i3 = i2 + 1;
                            z2 = z6;
                            if (i3 < size) {
                                break;
                                break;
                            }
                            break;
                            break;
                            i2 = i3;
                            z6 = z2;
                        }
                        if (z2) {
                            i12 = i2;
                            fX = 0.0f;
                            while (true) {
                                if (i16 <= i) {
                                    dqzVar2 = dqzVar;
                                    z6 = z2;
                                    break;
                                }
                                dleVar = (dle) drdVar.i.get(i12);
                                if (i12 == 0) {
                                    i13 = 0;
                                    z5 = false;
                                } else {
                                    i13 = dleVar.i();
                                    z5 = true;
                                }
                                iMax = Math.max(i, i13);
                                i14 = i;
                                int i192 = i12;
                                boolean z72 = z2;
                                float fX22 = drdVar.x(iMax, i16, z72, dleVar, canvas, f2 + fX, dqzVar);
                                z3 = z72;
                                dqzVar3 = dqzVar;
                                fX += fX22;
                                if (z5) {
                                }
                                if (f2 + fX > dqzVar3.c) {
                                    dqzVar2 = dqzVar3;
                                    z6 = z3;
                                    break;
                                }
                                i12 = i15;
                                i16 = iMax;
                                i = i14;
                                z2 = z3;
                            }
                        } else {
                            dqzVar3 = dqzVar;
                            z3 = z2;
                            fX = 0.0f;
                            while (true) {
                                if (i >= i16) {
                                    dqzVar2 = dqzVar3;
                                    z6 = z3;
                                    break;
                                }
                                i4 = i2 + 1;
                                if (i4 >= size) {
                                    i5 = drdVar.h;
                                    z4 = false;
                                } else {
                                    i5 = ((dle) drdVar.i.get(i4)).i();
                                    z4 = true;
                                }
                                iMin = Math.min(i16, i5);
                                i6 = size;
                                dqzVar2 = dqzVar3;
                                z6 = z3;
                                i7 = i16;
                                int i202 = i2;
                                fX += drdVar.x(i, iMin, z6, (dle) drdVar.i.get(i2), canvas, f2 + fX, dqzVar2);
                                if (z4) {
                                }
                                if (f2 + fX > dqzVar2.c) {
                                    break;
                                    break;
                                }
                                i = iMin;
                                z3 = z6;
                                dqzVar3 = dqzVar2;
                                i16 = i7;
                                size = i6;
                            }
                        }
                        f3 = f8 + fX;
                        if (i18 != i17) {
                            i10 = dqzVar2.d;
                            if (i18 != i10) {
                                if (i18 == i10) {
                                }
                                if (z6) {
                                    dqzVar2.e = (f3 + f7) - f4;
                                } else {
                                    dqzVar2.e = f4 + f3;
                                }
                                dqzVar2.c = 0.0f;
                            } else {
                                if (i18 == i10) {
                                }
                                if (z6) {
                                    dqzVar2.e = (f3 + f7) - f4;
                                } else {
                                    dqzVar2.e = f4 + f3;
                                }
                                dqzVar2.c = 0.0f;
                            }
                            draVar = dqzVar2.j;
                            if (draVar != null) {
                                float f92 = f6 + f3;
                                draVar.h(f92, f92 + f7);
                            }
                            ekVar = dqzVar2.n;
                            if (ekVar != null) {
                                ((float[][]) ekVar.d)[i18 / 262144][i18 % 262144] = f7;
                            }
                            i8 = i17;
                            dqyVar = dqzVar2.l;
                            if (dqyVar != null) {
                                dqyVar.h(canvas, cArr, i18, 1, i18, 1, z6, f6 + f3, f7, drdVar.k, null);
                            }
                            f3 += f7;
                        } else {
                            i8 = i17;
                        }
                        f8 = f3;
                        if (z6) {
                        }
                        if (f6 + f8 > dqzVar2.c) {
                            break;
                            break;
                        }
                    }
                    i18 += z6 ? -1 : 1;
                    i16 = i9;
                    i17 = i8;
                } else {
                    if (i18 < i17) {
                        dqzVar2 = dqzVar;
                        break;
                    }
                    if (i18 != i17 || cArr[i18] == '\t') {
                        i = z6 ? i18 + 1 : i16;
                        if (!z6) {
                            i16 = i18;
                        }
                        f2 = f6 + f8;
                        i2 = cjnVar.a;
                        int i21 = z6 ? i16 - 1 : i;
                        size = drdVar.i.size();
                        while (true) {
                            i3 = i2 + 1;
                            z2 = z6;
                            if (i3 < size || ((dle) drdVar.i.get(i3)).i() > i21) {
                                break;
                            }
                            i2 = i3;
                            z6 = z2;
                        }
                        if (z2) {
                            i12 = i2;
                            fX = 0.0f;
                            while (true) {
                                if (i16 <= i) {
                                    dqzVar2 = dqzVar;
                                    z6 = z2;
                                    break;
                                }
                                dleVar = (dle) drdVar.i.get(i12);
                                if (i12 == 0) {
                                    i13 = 0;
                                    z5 = false;
                                } else {
                                    i13 = dleVar.i();
                                    z5 = true;
                                }
                                iMax = Math.max(i, i13);
                                i14 = i;
                                int i1922 = i12;
                                boolean z722 = z2;
                                float fX222 = drdVar.x(iMax, i16, z722, dleVar, canvas, f2 + fX, dqzVar);
                                z3 = z722;
                                dqzVar3 = dqzVar;
                                fX += fX222;
                                i15 = z5 ? i1922 - 1 : i1922;
                                if (f2 + fX > dqzVar3.c) {
                                    dqzVar2 = dqzVar3;
                                    z6 = z3;
                                    break;
                                }
                                i12 = i15;
                                i16 = iMax;
                                i = i14;
                                z2 = z3;
                            }
                        } else {
                            dqzVar3 = dqzVar;
                            z3 = z2;
                            fX = 0.0f;
                            while (true) {
                                if (i >= i16) {
                                    dqzVar2 = dqzVar3;
                                    z6 = z3;
                                    break;
                                }
                                i4 = i2 + 1;
                                if (i4 >= size) {
                                    i5 = drdVar.h;
                                    z4 = false;
                                } else {
                                    i5 = ((dle) drdVar.i.get(i4)).i();
                                    z4 = true;
                                }
                                iMin = Math.min(i16, i5);
                                i6 = size;
                                dqzVar2 = dqzVar3;
                                z6 = z3;
                                i7 = i16;
                                int i2022 = i2;
                                fX += drdVar.x(i, iMin, z6, (dle) drdVar.i.get(i2), canvas, f2 + fX, dqzVar2);
                                i2 = z4 ? i4 : i2022;
                                if (f2 + fX > dqzVar2.c) {
                                    break;
                                }
                                i = iMin;
                                z3 = z6;
                                dqzVar3 = dqzVar2;
                                i16 = i7;
                                size = i6;
                            }
                        }
                        f3 = f8 + fX;
                        if (i18 != i17) {
                            i10 = dqzVar2.d;
                            if (i18 != i10 || ((i11 = i18 + 1) == i10 && i11 == drdVar.h)) {
                                f4 = i18 == i10 ? 0.0f : f7;
                                if (z6) {
                                    dqzVar2.e = (f3 + f7) - f4;
                                } else {
                                    dqzVar2.e = f4 + f3;
                                }
                                dqzVar2.c = 0.0f;
                            }
                            draVar = dqzVar2.j;
                            if (draVar != null && i18 >= dqzVar2.h && i18 < dqzVar2.i) {
                                float f922 = f6 + f3;
                                draVar.h(f922, f922 + f7);
                            }
                            ekVar = dqzVar2.n;
                            if (ekVar != null) {
                                ((float[][]) ekVar.d)[i18 / 262144][i18 % 262144] = f7;
                            }
                            i8 = i17;
                            dqyVar = dqzVar2.l;
                            if (dqyVar != null && i18 >= dqzVar2.h && i18 < dqzVar2.i) {
                                dqyVar.h(canvas, cArr, i18, 1, i18, 1, z6, f6 + f3, f7, drdVar.k, null);
                            }
                            f3 += f7;
                        } else {
                            i8 = i17;
                        }
                        f8 = f3;
                        i9 = z6 ? i18 : i18 + 1;
                        if (f6 + f8 > dqzVar2.c) {
                            break;
                        }
                    } else {
                        i9 = i16;
                        i8 = i17;
                    }
                    i18 += z6 ? -1 : 1;
                    i16 = i9;
                    i17 = i8;
                }
            }
            f5 += f8;
            if (f + f5 > dqzVar2.c) {
                break;
            }
        }
        return f5;
    }

    public final void aa(drb drbVar, boolean z) {
        bnh eruVar = (!z || this.e.c <= 0) ? this.f : new eru(this.f);
        cjn cjnVarAb = null;
        for (int i = 0; i < eruVar.c(); i++) {
            int iE = eruVar.e(i);
            int iMax = Math.max(eruVar.d(i), this.g);
            int iMin = Math.min(iE, this.h);
            if (iMax < iMin) {
                cjnVarAb = ab(iMax);
                boolean zF = eruVar.f(i);
                ArrayList arrayList = new ArrayList();
                while (true) {
                    if (cjnVarAb.b < this.j.size()) {
                        this.j.get(cjnVarAb.b).getClass();
                        throw new ClassCastException();
                    }
                    if (iMax >= iMin) {
                        boolean zE = drbVar.e(arrayList, zF, cjnVarAb);
                        int size = this.i.size();
                        while (true) {
                            int i2 = cjnVarAb.a + 1;
                            if (i2 >= size || ((dle) this.i.get(i2)).i() > iMin) {
                                break;
                            } else {
                                cjnVarAb.a++;
                            }
                        }
                        if (zE) {
                            break;
                        } else {
                            break;
                        }
                    }
                    ddn ddnVar = new ddn();
                    ddnVar.a = iMax;
                    ddnVar.b = iMin;
                    ddnVar.c = zF;
                    arrayList.add(ddnVar);
                    iMax = iMin;
                }
            }
        }
        int i3 = cjnVarAb == null ? 0 : cjnVarAb.b;
        ArrayList arrayList2 = new ArrayList();
        if (i3 < this.j.size()) {
            this.j.get(i3).getClass();
            throw new ClassCastException();
        }
        if (arrayList2.isEmpty()) {
            return;
        }
        if (cjnVarAb == null) {
            cjnVarAb = ab(this.h);
        }
        cjnVarAb.b = i3;
        drbVar.e(arrayList2, false, cjnVarAb);
    }

    public final cjn ab(int i) {
        coe coeVar = this.d;
        coeVar.b = i;
        int iBinarySearch = Collections.binarySearch(this.i, coeVar, a);
        if (iBinarySearch < 0) {
            iBinarySearch = -(iBinarySearch + 1);
        }
        if (iBinarySearch == this.i.size()) {
            iBinarySearch--;
        }
        while (iBinarySearch > 0 && ((dle) this.i.get(iBinarySearch)).i() >= i) {
            iBinarySearch--;
        }
        if (this.j.size() > 0) {
            this.j.get(0).getClass();
            throw new ClassCastException();
        }
        cjn cjnVar = new cjn();
        cjnVar.a = iBinarySearch;
        cjnVar.b = 0;
        return cjnVar;
    }

    public final void ac(afo afoVar, int i, int i2, List list, List list2, anu anuVar, csk cskVar, ek ekVar,
            dre dreVar) {
        this.e = afoVar;
        this.g = i;
        this.h = i2;
        this.i = list;
        this.j = list2;
        this.f = anuVar;
        this.l = cskVar;
        this.k = dreVar;
        this.m = ekVar;
        throwIfVar1IsNull(dreVar.b, "textMetrics");
    }

    public final void q(int i, int i2, int i3, int i4, boolean z, Canvas canvas, float f, float f2, dqz dqzVar) {
        int i5 = i2 - i;
        if (i5 < 64 || this.m == null) {
            dqy dqyVar = dqzVar.l;
            if (dqyVar != null) {
                dqyVar.h(canvas, this.e.a, i, i5, i3, i4 - i3, z, f, f2, this.k, dqzVar.m);
                return;
            } else {
                r(i, i2, i3, i4, z, canvas, f, f2);
                return;
            }
        }
        float fMax = Math.max(0.0f, dqzVar.b - f) - this.l.a;
        float fMin = Math.min(f2, dqzVar.c - f) + this.l.a;
        int iT = t(i, i2, i3, i4, z, fMax);
        int iT2 = t(i, i2, i3, i4, z, fMin);
        int iMin = Math.min(iT, iT2);
        int iMax = Math.max(iT, iT2);
        if (iMin < iMax) {
            char[] cArr = this.e.a;
            int i6 = iMin;
            while (true) {
                int i7 = i6 - 1;
                if (i7 < i3 || cArr[i7] == ' ' || iMax - i6 >= 256) {
                    break;
                } else {
                    i6--;
                }
            }
            int i8 = iMax;
            while (true) {
                int i9 = i8 + 1;
                if (i9 >= i4 || cArr[i8] == ' ' || i8 - i6 >= 256) {
                    break;
                } else {
                    i8 = i9;
                }
            }
            float fW = w(iMin, z, i, i2, i3, i4);
            float fW2 = w(iMax, z, i, i2, i3, i4);
            float fAbs = Math.abs(fW - fW2);
            float f3 = z ? (f + f2) - fW2 : f + fW;
            dqy dqyVar2 = dqzVar.l;
            if (dqyVar2 != null) {
                dqyVar2.h(canvas, this.e.a, iMin, iMax - iMin, i3, i4 - i3, z, f3, fAbs, this.k, dqzVar.m);
            } else {
                r(iMin, iMax, i3, i4, z, canvas, f3, fAbs);
            }
        }
    }

    public final void r(int i, int i2, int i3, int i4, boolean z, Canvas canvas, float f, float f2) {
        char c;
        drd drdVar;
        char[] cArr;
        int i5;
        Canvas canvas2;
        drd drdVar2 = this;
        int i6 = i2;
        csk cskVar = drdVar2.l;
        if (!cskVar.b) {
            canvas.drawTextRun(drdVar2.e.a, i, i2 - i, i3, i4 - i3, f, drdVar2.k.f, z, cskVar);
            return;
        }
        char[] cArr2 = drdVar2.e.a;
        float f3 = f + (z ? f2 : 0.0f);
        int i7 = i;
        int i8 = i7;
        float f4 = f3;
        while (i7 <= i6) {
            if (i7 != i6) {
                c = cArr2[i7];
                if (!ajn.u(c)) {
                    drdVar = drdVar2;
                    cArr = cArr2;
                    i5 = i8;
                }
                i7++;
                i6 = i2;
                i8 = i5;
                cArr2 = cArr;
                drdVar2 = drdVar;
            } else {
                c = 0;
            }
            char c2 = c;
            int i9 = i7 - i8;
            if (i9 > 0) {
                if (z) {
                    drdVar2.l.setTextAlign(Paint.Align.RIGHT);
                }
                canvas.drawTextRun(cArr2, i8, i9, i3, i4 - i3, f4, drdVar2.k.f, z, drdVar2.l);
                canvas2 = canvas;
                cArr = cArr2;
                if (z) {
                    drdVar2.l.setTextAlign(Paint.Align.LEFT);
                }
            } else {
                canvas2 = canvas;
                cArr = cArr2;
            }
            if (i7 == i6) {
                break;
            }
            float fMeasureText = drdVar2.l.measureText(ajn.t(c2));
            float fW = drdVar2.w(i7, z, i, i6, i, i2);
            drdVar = drdVar2;
            float f5 = z ? (f3 - fW) - fMeasureText : f3 + fW;
            dre dreVar = drdVar.k;
            Paint paint = dreVar.m;
            Paint.FontMetricsInt fontMetricsInt = dreVar.n;
            paint.setTextAlign(Paint.Align.CENTER);
            int i10 = fontMetricsInt.descent;
            int i11 = fontMetricsInt.ascent;
            float f6 = drdVar.k.h / 2.0f;
            float f7 = (i10 - i11) / 2.0f;
            float f8 = f6 - f7;
            paint.setColor(drdVar.l.getColor());
            float f9 = (fMeasureText / 2.0f) + f5;
            canvas2.drawText(ajn.t(c2), f9, f8 - i11, paint);
            paint.setTextAlign(Paint.Align.LEFT);
            float fMeasureText2 = paint.measureText(ajn.t(c2));
            RectF rectF = drdVar.b;
            rectF.top = f8;
            rectF.bottom = f6 + f7;
            float f10 = fMeasureText2 / 2.0f;
            rectF.left = f9 - f10;
            rectF.right = f9 + f10;
            int color = drdVar.l.getColor();
            drdVar.l.setColor(drdVar.k.k.b.get(52));
            drdVar.l.setStyle(Paint.Style.STROKE);
            drdVar.l.setStrokeWidth(drdVar.k.h * 0.05f);
            float f11 = r3.h * drdVar.k.i;
            canvas2.drawRoundRect(rectF, f11, f11, drdVar.l);
            drdVar.l.setStyle(Paint.Style.FILL);
            drdVar.l.setColor(color);
            float f12 = fW + fMeasureText;
            if (z) {
                f12 = -f12;
            }
            f4 = f3 + f12;
            i5 = i7;
            i7++;
            i6 = i2;
            i8 = i5;
            cArr2 = cArr;
            drdVar2 = drdVar;
        }
    }

    public final long s(Canvas canvas, float f, float f2) {
        dqz dqzVar = new dqz();
        dqzVar.b = f;
        dqzVar.c = f2;
        dqv dqvVar = new dqv(this, canvas, dqzVar, f2);
        aa(dqvVar, true);
        boolean z = dqvVar.b;
        return KotlinHelpers.al(z ? 1 : 0, Float.floatToRawIntBits(dqvVar.a));
    }

    public final int t(int i, int i2, int i3, int i4, boolean z, float f) {
        csk cskVar;
        int i5;
        char[] cArr;
        ek ekVar = this.m;
        if (ekVar != null) {
            float fL = ekVar.l(0, i);
            int i6 = i;
            int i7 = i2;
            while (i6 <= i7) {
                int i8 = (i6 + i7) / 2;
                if (i8 >= i && i8 < i2) {
                    float fL2 = ekVar.l(0, i8) - fL;
                    if (fL2 > f) {
                        i7 = i8 - 1;
                    } else if (fL2 < f) {
                        i6 = i8 + 1;
                    }
                }
                i6 = i8;
                break;
            }
            if (ekVar.l(0, i6) - fL > f) {
                i6--;
            }
            return Math.max(i, Math.min(i2, i6));
        }
        csk cskVar2 = this.l;
        afo afoVar = this.e;
        if (!cskVar2.b) {
            return cskVar2.getOffsetForAdvance(afoVar.a, i, i2, i3, i4, z, f);
        }
        char[] cArr2 = afoVar.a;
        int i9 = i;
        int offsetForAdvance = i9;
        float f2 = 0.0f;
        while (offsetForAdvance < i2) {
            char c = cArr2[offsetForAdvance];
            if (ajn.u(c)) {
                if (i9 == offsetForAdvance) {
                    cskVar = cskVar2;
                    i5 = offsetForAdvance;
                } else {
                    cskVar = cskVar2;
                    i5 = offsetForAdvance;
                    offsetForAdvance = cskVar.getOffsetForAdvance(afoVar.a, i9, offsetForAdvance, i3, i4, z, f - f2);
                }
                if (offsetForAdvance < i5) {
                    return offsetForAdvance;
                }
                cArr = cArr2;
                float fMeasureText = cskVar.measureText(ajn.t(c)) + f2
                        + cskVar.c(cArr, i9, i5 - i9, i3, i4 - i3, z, null, 0);
                if (fMeasureText >= f) {
                    return i5;
                }
                f2 = fMeasureText;
                i9 = i5 + 1;
            } else {
                cskVar = cskVar2;
                i5 = offsetForAdvance;
                cArr = cArr2;
            }
            offsetForAdvance = i5 + 1;
            cskVar2 = cskVar;
            cArr2 = cArr;
        }
        csk cskVar3 = cskVar2;
        if (i9 >= i2) {
            return i2;
        }
        return cskVar3.getOffsetForAdvance(afoVar.a, i9, i2, i3, i4, z, f - f2);
    }

    public final float u(int i) {
        dqz dqzVar = new dqz();
        dqzVar.d = i;
        aa(new dqu(this, dqzVar), true);
        return dqzVar.e;
    }

    public final int v(float f) {
        dqz dqzVar = new dqz();
        dqzVar.f = f;
        dqzVar.c = f;
        aa(new cbr(this, dqzVar), true);
        int i = dqzVar.g;
        return i == -1 ? this.g : i;
    }

    public final float w(int i, boolean z, int i2, int i3, int i4, int i5) {
        ek ekVar = this.m;
        return ekVar != null ? ekVar.l(i2, i) : this.l.getRunAdvance(this.e.a, i2, i3, i4, i5, z, i);
    }

    /* JADX WARN: Found duplicated region for block: B:19:0x005b */
    public final float x(int i, int i2, boolean z, dle dleVar, Canvas canvas, float f, dqz dqzVar) {
        float f2;
        float f3;
        int i3;
        csk cskVar;
        float f4;
        float fC;
        int i4;
        int iMax;
        int iMin;
        drd drdVar;
        int i5;
        float fMax;
        char c;
        csk cskVar2;
        String str;
        float f5;
        RectF rectF;
        csk cskVar3;
        Paint paint;
        float f6;
        drd drdVar2;
        Canvas canvas2;
        float f7;
        float f8;
        csk cskVar4;
        int i6;
        int i7;
        int i8;
        int i9;
        csk cskVar5;
        RectF rectF2;
        int i10;
        float f9;
        int i11;
        Paint paint2;
        String str2;
        float f10;
        csk cskVar6 = this.l;
        if ((canvas == null || dqzVar.l != null) && this.m != null) {
            f2 = 0.0f;
        } else {
            long jD = dleVar.d();
            long j = jD & 1924145348608L;
            if ((dleVar.d() & 1924145348608L) != dqzVar.a) {
                cskVar6.setFakeBoldText((274877906944L & jD) != 0);
                if ((jD & 549755813888L) != 0) {
                    cskVar6.setTextSkewX(-0.2f);
                    f2 = 0.0f;
                } else {
                    f2 = 0.0f;
                    cskVar6.setTextSkewX(0.0f);
                }
                dqzVar.a = j;
            } else {
                f2 = 0.0f;
            }
        }
        float[] fArrB = dqzVar.n != null ? dqd.b(i2 - i) : null;
        int i12 = i2 - i;
        if (this.m != null) {
            if (fArrB != null) {
                for (int i13 = 0; i13 < i12; i13++) {
                    int i14 = i + i13;
                    int i15 = i14 / 262144;
                    int i16 = i14 % 262144;
                    float[] fArr = ((float[][]) this.m.d)[i15];
                    fArrB[i13] = fArr[i16 + 1] - fArr[i16];
                }
            }
            fC = this.m.l(i, i + i12);
            f3 = -0.2f;
            i3 = i;
            cskVar = cskVar6;
            f4 = f2;
        } else {
            f3 = -0.2f;
            i3 = i;
            cskVar = cskVar6;
            f4 = f2;
            fC = this.l.c(this.e.a, i3, i12, i, i12, z, fArrB, 0);
        }
        float f11 = fC;
        if (dqzVar.n != null && fArrB != null) {
            for (int i17 = i3; i17 < i2; i17++) {
                ((float[][]) dqzVar.n.d)[i17 / 262144][i17 % 262144] = fArrB[i17 - i3];
            }
            dqd.c(fArrB);
        }
        int i18 = dqzVar.d;
        if (i18 >= i3 && (i18 < i2 || (i18 == i2 && i2 == this.h))) {
            dqzVar.c = f4;
            float fW = w(i18, z, i3, i2, i, i2);
            if (z) {
                dqzVar.e = (f + f11) - fW;
                return f11;
            }
            dqzVar.e = f + fW;
            return f11;
        }
        int i19 = i2;
        float f12 = dqzVar.f;
        float f13 = -1.0f;
        if (f12 != -1.0f) {
            float f14 = f12 - f;
            if (z) {
                f14 = f11 - f14;
            }
            float f15 = f14;
            if (f15 > f11) {
                dqzVar.g = i19;
            } else if (f15 <= f4) {
                dqzVar.g = i3;
            } else {
                i4 = i;
                i19 = i2;
                dqzVar.g = t(i4, i2, i, i2, z, f15);
            }
            i4 = i3;
        } else {
            i4 = i3;
        }
        if (!(dqzVar.j == null && dqzVar.l == null)
                && (iMax = Math.max(i4, dqzVar.h)) < (iMin = Math.min(i19, dqzVar.i))) {
            if (iMax == i4 && iMin == i19) {
                i5 = i4;
                f13 = f;
                fMax = f + f11;
                drdVar = this;
            } else {
                drdVar = this;
                float fW2 = drdVar.w(iMax, z, i4, i19, i, i2);
                i5 = i;
                i19 = i2;
                float fW3 = drdVar.w(iMin, z, i5, i19, i, i2);
                if (z) {
                    fW2 = f11 - fW2;
                }
                if (z) {
                    fW3 = f11 - fW3;
                }
                float fMin = Math.min(fW2, fW3) + f;
                fMax = Math.max(fW2, fW3) + f;
                f13 = fMin;
            }
            dra draVar = dqzVar.j;
            if (draVar != null) {
                draVar.h(f13, fMax);
            }
        } else {
            drdVar = this;
            i5 = i4;
            fMax = -1.0f;
        }
        float f16 = f + f11;
        if (Math.max(f, dqzVar.b) < Math.min(f16, dqzVar.c) && canvas != null) {
            if (dqzVar.l == null) {
                dqz dqzVar2 = dqzVar;
                float f17 = f11;
                Paint paint3 = drdVar.k.l;
                if (dleVar.e(1) != null) {
                    throw new ClassCastException();
                }
                arq arqVar = drdVar.k.k;
                String str3 = "colorScheme";
                throwIfVar1IsNull(arqVar, "colorScheme");
                if (dleVar.e(0) != null) {
                    throw new ClassCastException();
                }
                int i20 = arqVar.b.get((int) ((dleVar.d() & 274877382656L) >> 19));
                RectF rectF3 = drdVar.b;
                if (i20 == 0 || i5 == i19) {
                    c = 1;
                    cskVar2 = cskVar;
                } else {
                    drdVar.k.getClass();
                    c = 1;
                    rectF3.set(f, 0, f16, drdVar.k.g);
                    cskVar2 = cskVar;
                    cskVar2.setColor(i20);
                    float f18 = r2.h * drdVar.k.i;
                    canvas.drawRoundRect(rectF3, f18, f18, cskVar2);
                }
                arq arqVar2 = drdVar.k.k;
                throwIfVar1IsNull(arqVar2, "colorScheme");
                if (dleVar.e(0) != null) {
                    throw new ClassCastException();
                }
                RectF rectF4 = rectF3;
                int i21 = arqVar2.b.get((int) (dleVar.d() & 524287));
                int i22 = drdVar.n;
                int i23 = drdVar.o;
                if (i22 >= i23 || i22 >= drdVar.h || i23 <= drdVar.g || drdVar.k.k.b.get(30) == 0) {
                    str = "colorScheme";
                    f5 = f16;
                    rectF = rectF4;
                    cskVar3 = cskVar2;
                    paint = paint3;
                    cskVar3.setColor(i21);
                    f6 = f17;
                    q(i, i2, i, i2, z, canvas, f, f6, dqzVar);
                    drdVar2 = this;
                } else {
                    int iMax2 = Math.max(i5, Math.min(i19, drdVar.n));
                    int iMax3 = Math.max(i5, Math.min(i19, drdVar.o));
                    int[] iArr = drdVar.c;
                    boolean z2 = false;
                    iArr[0] = i5;
                    iArr[c] = i19;
                    iArr[2] = iMax2;
                    iArr[3] = iMax3;
                    Arrays.sort(iArr);
                    int i24 = 0;
                    float f19 = 0.0f;
                    while (true) {
                        f5 = f16;
                        int i25 = i24 + 1;
                        cskVar4 = cskVar2;
                        if (i25 >= iArr.length) {
                            break;
                        }
                        int i26 = iArr[i24];
                        int i27 = iArr[i25];
                        if (i26 == i27) {
                            i9 = i21;
                            i10 = iMax2;
                            i11 = iMax3;
                            str2 = str3;
                            i8 = i25;
                            cskVar5 = cskVar4;
                            rectF2 = rectF4;
                            f9 = f17;
                            paint2 = paint3;
                        } else {
                            if (i26 < iMax2 || i27 > iMax3) {
                                i6 = i26;
                                i7 = i27;
                                i8 = i25;
                                drdVar.l.setColor(i21);
                            } else {
                                i6 = i26;
                                i7 = i27;
                                i8 = i25;
                                drdVar.l.setColor(drdVar.k.k.b.get(30));
                            }
                            i9 = i21;
                            int i28 = i6;
                            cskVar5 = cskVar4;
                            rectF2 = rectF4;
                            int i29 = i7;
                            i10 = iMax2;
                            f9 = f17;
                            i11 = iMax3;
                            float fW4 = drdVar.w(i29, z, i28, i7, i, i2);
                            if (z) {
                                paint2 = paint3;
                                str2 = str3;
                                f10 = fW4;
                                q(i28, i29, i, i2, true, canvas, (f5 - f19) - fW4, f10, dqzVar2);
                            } else {
                                paint2 = paint3;
                                str2 = str3;
                                f10 = fW4;
                                q(i28, i29, i, i2, false, canvas, f + f19, f10, dqzVar);
                            }
                            f19 += f10;
                        }
                        drdVar = this;
                        dqzVar2 = dqzVar;
                        cskVar2 = cskVar5;
                        i21 = i9;
                        rectF4 = rectF2;
                        paint3 = paint2;
                        str3 = str2;
                        iMax2 = i10;
                        f16 = f5;
                        iMax3 = i11;
                        f17 = f9;
                        i24 = i8;
                        z2 = false;
                    }
                    str = str3;
                    cskVar3 = cskVar4;
                    rectF = rectF4;
                    float f20 = f17;
                    paint = paint3;
                    drdVar2 = this;
                    f6 = f20;
                }
                if ((dleVar.d() & 1099511627776L) != 0) {
                    int color = drdVar2.k.k.b.get(57);
                    if (color == 0) {
                        color = cskVar3.getColor();
                    }
                    paint.setColor(color);
                    drdVar2.k.getClass();
                    float f21 = 0;
                    int i30 = drdVar2.k.h;
                    float f22 = (i30 / 2.0f) + f21;
                    float f23 = (i30 / 2.0f) + f21;
                    canvas2 = canvas;
                    f8 = f5;
                    canvas2.drawLine(f, f22, f8, f23, paint);
                    f7 = f;
                } else {
                    canvas2 = canvas;
                    f7 = f;
                    f8 = f5;
                }
                arp arpVarG = dleVar.g();
                if (arpVarG == null) {
                    return f6;
                }
                arq arqVar3 = drdVar2.k.k;
                throwIfVar1IsNull(arqVar3, str);
                int i31 = arqVar3.b.get(arpVarG.a);
                if (i31 == 0) {
                    return f6;
                }
                float f24 = drdVar2.k.d;
                rectF.bottom = f24;
                rectF.top = f24 - (r2.e * 0.06f);
                rectF.left = f7;
                rectF.right = f8;
                cskVar3.setColor(i31);
                canvas2.drawRect(rectF, cskVar3);
                return f6;
            }
            if (Math.max(i5, dqzVar.h) < Math.min(i19, dqzVar.i)) {
                if (dqzVar.k) {
                    canvas.save();
                    float f25 = fMax - f13;
                    if ((dleVar.d() & 549755813888L) != 0) {
                        Path path = new Path();
                        float f26 = drdVar.k.d;
                        path.moveTo(f13, f26);
                        float f27 = f26 * f3;
                        path.lineTo(f13 - f27, f4);
                        float f28 = f13 + f25;
                        path.lineTo(f28 - f27, f4);
                        path.lineTo(f28, f26);
                        path.close();
                        canvas.clipPath(path);
                    } else {
                        canvas.clipRect(f13, f4, f25 + f13, drdVar.k.h);
                    }
                }
                dqzVar.m = dleVar;
                drdVar.q(i, i2, i, i2, z, canvas, f, f11, dqzVar);
                dqzVar.m = null;
                dqzVar.a = -1L;
                if (!dqzVar.k) {
                    return f11;
                }
                canvas.restore();
                return f11;
            }
        }
        return f11;
    }

    public final void y(int i, int i2, dqx dqxVar) {
        dqz dqzVar = new dqz();
        dqzVar.h = i;
        dqzVar.i = i2;
        dra draVar = new dra();
        draVar.a = true;
        draVar.d = false;
        draVar.e = dqzVar;
        draVar.f = dqxVar;
        dqzVar.j = draVar;
        aa(new cbr(this, dqzVar), true);
        dqzVar.j.g();
    }

    public final void z(int i, int i2, Canvas canvas, float f, float f2, boolean z, dqy dqyVar) {
        dqz dqzVar = new dqz();
        dqzVar.h = i;
        dqzVar.i = i2;
        dqzVar.b = f;
        dqzVar.c = f2;
        dqzVar.k = z;
        dqzVar.l = dqyVar;
        cbr cbrVar = new cbr(this, dqzVar);
        cbrVar.c = canvas;
        aa(cbrVar, true);
    }
}
