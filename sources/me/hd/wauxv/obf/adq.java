package me.hd.wauxv.obf;

import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class adq {
    public int aa;
    public int ab;
    public int ac;
    public final int[] ad;
    public int ae;
    public int af;
    public float ag;
    public int ah;
    public int ai;
    public float aj;
    public int ak;
    public float al;
    public final int[] am;
    public float an;
    public boolean ao;
    public boolean ap;
    public int aq;
    public int ar;
    public final adb as;
    public final adb at;
    public final adb au;
    public final adb av;
    public final adb aw;
    public final adb ax;
    public final adb ay;
    public final adb az;
    public final adb[] ba;
    public final ArrayList bb;
    public final boolean[] bc;
    public adq bd;
    public int be;
    public int bf;
    public float bg;
    public int bh;
    public int bi;
    public int bj;
    public int bk;
    public int bl;
    public int bm;
    public float bn;
    public float bo;
    public View bp;
    public int bq;
    public String br;
    public int bs;
    public int bt;
    public final float[] bu;
    public final adq[] bv;
    public final adq[] bw;
    public int bx;
    public int by;
    public final int[] bz;
    public tq l;
    public tq m;
    public String t;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public int y;
    public int z;
    public boolean k = false;
    public bmn n = null;
    public eps o = null;
    public final boolean[] p = {true, true};
    public boolean q = true;
    public int r = -1;
    public int s = -1;

    public adq() {
        new HashMap();
        this.u = false;
        this.v = false;
        this.w = false;
        this.x = false;
        this.y = -1;
        this.z = -1;
        this.aa = 0;
        this.ab = 0;
        this.ac = 0;
        this.ad = new int[2];
        this.ae = 0;
        this.af = 0;
        this.ag = 1.0f;
        this.ah = 0;
        this.ai = 0;
        this.aj = 1.0f;
        this.ak = -1;
        this.al = 1.0f;
        this.am = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.an = Float.NaN;
        this.ao = false;
        this.ap = false;
        this.aq = 0;
        this.ar = 0;
        adb adbVar = new adb(this, 2);
        this.as = adbVar;
        adb adbVar2 = new adb(this, 3);
        this.at = adbVar2;
        adb adbVar3 = new adb(this, 4);
        this.au = adbVar3;
        adb adbVar4 = new adb(this, 5);
        this.av = adbVar4;
        adb adbVar5 = new adb(this, 6);
        this.aw = adbVar5;
        adb adbVar6 = new adb(this, 8);
        this.ax = adbVar6;
        adb adbVar7 = new adb(this, 9);
        this.ay = adbVar7;
        adb adbVar8 = new adb(this, 7);
        this.az = adbVar8;
        this.ba = new adb[]{adbVar, adbVar3, adbVar2, adbVar4, adbVar5, adbVar8};
        ArrayList arrayList = new ArrayList();
        this.bb = arrayList;
        this.bc = new boolean[2];
        this.bz = new int[]{1, 1};
        this.bd = null;
        this.be = 0;
        this.bf = 0;
        this.bg = 0.0f;
        this.bh = -1;
        this.bi = 0;
        this.bj = 0;
        this.bk = 0;
        this.bn = 0.5f;
        this.bo = 0.5f;
        this.bq = 0;
        this.br = null;
        this.bs = 0;
        this.bt = 0;
        this.bu = new float[]{-1.0f, -1.0f};
        this.bv = new adq[]{null, null};
        this.bw = new adq[]{null, null};
        this.bx = -1;
        this.by = -1;
        arrayList.add(adbVar);
        arrayList.add(adbVar2);
        arrayList.add(adbVar3);
        arrayList.add(adbVar4);
        arrayList.add(adbVar6);
        arrayList.add(adbVar7);
        arrayList.add(adbVar8);
        arrayList.add(adbVar5);
    }

    public static void ca(StringBuilder sb, String str, int i, int i2, int i3, int i4, int i5, float f, int i6) {
        String str2;
        sb.append(str);
        sb.append(" :  {\n");
        if (i6 == 1) {
            str2 = "FIXED";
        } else if (i6 == 2) {
            str2 = "WRAP_CONTENT";
        } else if (i6 == 3) {
            str2 = "MATCH_CONSTRAINT";
        } else {
            if (i6 != 4) {
                throw null;
            }
            str2 = "MATCH_PARENT";
        }
        if (!"FIXED".equals(str2)) {
            sb.append("      behavior");
            sb.append(" :   ");
            sb.append(str2);
            sb.append(",\n");
        }
        cc(i, 0, "      size", sb);
        cc(i2, 0, "      min", sb);
        cc(i3, Integer.MAX_VALUE, "      max", sb);
        cc(i4, 0, "      matchMin", sb);
        cc(i5, 0, "      matchDef", sb);
        cd(sb, "      matchPercent", f, 1.0f);
        sb.append("    },\n");
    }

    public static void cb(StringBuilder sb, String str, adb adbVar) {
        if (adbVar.f == null) {
            return;
        }
        sb.append("    ");
        sb.append(str);
        sb.append(" : [ '");
        sb.append(adbVar.f);
        sb.append("'");
        if (adbVar.h != Integer.MIN_VALUE || adbVar.g != 0) {
            sb.append(",");
            sb.append(adbVar.g);
            if (adbVar.h != Integer.MIN_VALUE) {
                sb.append(",");
                sb.append(adbVar.h);
                sb.append(",");
            }
        }
        sb.append(" ] ,\n");
    }

    public static void cc(int i, int i2, String str, StringBuilder sb) {
        if (i == i2) {
            return;
        }
        sb.append(str);
        sb.append(" :   ");
        sb.append(i);
        sb.append(",\n");
    }

    public static void cd(StringBuilder sb, String str, float f, float f2) {
        if (f == f2) {
            return;
        }
        sb.append(str);
        sb.append(" :   ");
        sb.append(f);
        sb.append(",\n");
    }

    public final void ce(adr adrVar, bvm bvmVar, HashSet hashSet, int i, boolean z) {
        if (z) {
            if (!hashSet.contains(this)) {
                return;
            }
            cnf.aq(adrVar, bvmVar, this);
            hashSet.remove(this);
            e(bvmVar, adrVar.ei(64));
        }
        if (i == 0) {
            HashSet hashSet2 = this.as.a;
            if (hashSet2 != null) {
                Iterator it = hashSet2.iterator();
                while (it.hasNext()) {
                    ((adb) it.next()).d.ce(adrVar, bvmVar, hashSet, i, true);
                }
            }
            HashSet hashSet3 = this.au.a;
            if (hashSet3 != null) {
                Iterator it2 = hashSet3.iterator();
                while (it2.hasNext()) {
                    ((adb) it2.next()).d.ce(adrVar, bvmVar, hashSet, i, true);
                }
                return;
            }
            return;
        }
        HashSet hashSet4 = this.at.a;
        if (hashSet4 != null) {
            Iterator it3 = hashSet4.iterator();
            while (it3.hasNext()) {
                ((adb) it3.next()).d.ce(adrVar, bvmVar, hashSet, i, true);
            }
        }
        HashSet hashSet5 = this.av.a;
        if (hashSet5 != null) {
            Iterator it4 = hashSet5.iterator();
            while (it4.hasNext()) {
                ((adb) it4.next()).d.ce(adrVar, bvmVar, hashSet, i, true);
            }
        }
        HashSet hashSet6 = this.aw.a;
        if (hashSet6 != null) {
            Iterator it5 = hashSet6.iterator();
            while (it5.hasNext()) {
                ((adb) it5.next()).d.ce(adrVar, bvmVar, hashSet, i, true);
            }
        }
    }

    /* JADX WARN: Found duplicated region for block: B:220:0x03c5  */
    /* JADX WARN: Found duplicated region for block: B:222:0x03c9  */
    /* JADX WARN: Found duplicated region for block: B:229:0x03dd  */
    /* JADX WARN: Found duplicated region for block: B:231:0x0402  */
    /* JADX WARN: Found duplicated region for block: B:240:0x041f  */
    /* JADX WARN: Found duplicated region for block: B:257:0x0452  */
    /* JADX WARN: Found duplicated region for block: B:259:0x0458  */
    /* JADX WARN: Found duplicated region for block: B:270:0x046d  */
    /* JADX WARN: Found duplicated region for block: B:275:0x0477  */
    /* JADX WARN: Found duplicated region for block: B:277:0x047b  */
    /* JADX WARN: Found duplicated region for block: B:278:0x047d  */
    /* JADX WARN: Found duplicated region for block: B:281:0x0485  */
    /* JADX WARN: Found duplicated region for block: B:287:0x0493 A[PHI: r3
      0x0493: PHI (r3v17 int) = (r3v16 int), (r3v21 int), (r3v21 int), (r3v21 int) binds: [B:280:0x0483, B:282:0x0489, B:283:0x048b, B:285:0x048f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Found duplicated region for block: B:290:0x04a5 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:291:0x04a7  */
    /* JADX WARN: Found duplicated region for block: B:292:0x04ac  */
    /* JADX WARN: Found duplicated region for block: B:294:0x04af  */
    /* JADX WARN: Found duplicated region for block: B:303:0x04c6  */
    /* JADX WARN: Found duplicated region for block: B:337:0x0521  */
    public final void cf(bvm bvmVar, boolean z, boolean z2, boolean z3, boolean z4, dla dlaVar, dla dlaVar2, int i, boolean z5, adb adbVar, adb adbVar2, int i2, int i3, int i4, int i5, float f, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, int i6, int i7, int i8, int i9, float f2, boolean z11) {
        boolean z12;
        boolean z13;
        int iMin;
        boolean z14;
        boolean z15;
        int i10;
        int i11;
        boolean z16;
        dla dlaVarAc;
        dla dlaVarAc2;
        adb adbVar3;
        dla dlaVar3;
        boolean z17;
        int i12;
        dla dlaVar4;
        dla dlaVar5;
        dla dlaVar6;
        dla dlaVar7;
        int i13;
        int i14;
        int i15;
        boolean z18;
        boolean z19;
        boolean z20;
        boolean z21;
        adq adqVar;
        int i16;
        int i17;
        adb adbVar4;
        boolean z22;
        int iMin2;
        boolean z23;
        int i18;
        int iN;
        int i19;
        HashSet hashSet;
        boolean z24;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        boolean z25;
        boolean z26;
        int i25;
        bvm bvmVar2 = bvmVar;
        int i26 = i8;
        int i27 = i9;
        dla dlaVarAc3 = bvmVar2.ac(adbVar);
        dla dlaVarAc4 = bvmVar2.ac(adbVar2);
        dla dlaVarAc5 = bvmVar2.ac(adbVar.f);
        dla dlaVarAc6 = bvmVar2.ac(adbVar2.f);
        boolean zQ = adbVar.q();
        boolean zQ2 = adbVar2.q();
        boolean zQ3 = this.az.q();
        int i28 = zQ2 ? (zQ ? 1 : 0) + 1 : zQ ? 1 : 0;
        if (zQ3) {
            i28++;
        }
        int i29 = i28;
        int i30 = z6 ? 3 : i6;
        int iAe = dkz.ae(i);
        boolean z27 = (iAe == 0 || iAe == 1 || iAe != 2 || i30 == 4) ? false : true;
        int i31 = this.r;
        if (i31 == -1 || !z) {
            i31 = i3;
            z12 = z27;
        } else {
            this.r = -1;
            z12 = false;
        }
        int i32 = this.s;
        if (i32 == -1 || z) {
            z13 = z12;
        } else {
            this.s = -1;
            i31 = i32;
            z13 = false;
        }
        boolean z28 = z13;
        if (this.bq == 8) {
            z14 = false;
            iMin = 0;
        } else {
            iMin = i31;
            z14 = z28;
        }
        if (z11) {
            if (!zQ && !zQ2 && !zQ3) {
                bvmVar2.v(dlaVarAc3, i2);
            } else if (zQ && !zQ2) {
                z15 = z14;
                i10 = 8;
                bvmVar2.w(dlaVarAc3, dlaVarAc5, adbVar.n(), 8);
            }
            z15 = z14;
            i10 = 8;
        } else {
            z15 = z14;
            i10 = 8;
        }
        if (z15) {
            if (i29 == 2 || z6 || !(i30 == 1 || i30 == 0)) {
                if (i26 == -2) {
                    i26 = iMin;
                }
                if (i27 == -2) {
                    i27 = iMin;
                }
                if (iMin > 0 && i30 != 1) {
                    iMin = 0;
                }
                if (i26 > 0) {
                    bvmVar2.x(dlaVarAc4, dlaVarAc3, i26, 8);
                    iMin = Math.max(iMin, i26);
                }
                if (i27 > 0) {
                    if (!z2 || i30 != 1) {
                        bvmVar2.y(dlaVarAc4, dlaVarAc3, i27, 8);
                    }
                    iMin = Math.min(iMin, i27);
                }
                if (i30 == 1) {
                    if (z2) {
                        bvmVar2.w(dlaVarAc4, dlaVarAc3, iMin, 8);
                    } else if (z8) {
                        bvmVar2.w(dlaVarAc4, dlaVarAc3, iMin, 5);
                        bvmVar2.y(dlaVarAc4, dlaVarAc3, iMin, 8);
                    } else {
                        bvmVar2.w(dlaVarAc4, dlaVarAc3, iMin, 5);
                        bvmVar2.y(dlaVarAc4, dlaVarAc3, iMin, 8);
                    }
                } else if (i30 == 2) {
                    int i33 = adbVar.e;
                    if (i33 == 3 || i33 == 5) {
                        dlaVarAc = bvmVar2.ac(this.bd.ck(3));
                        dlaVarAc2 = bvmVar2.ac(this.bd.ck(5));
                    } else {
                        dlaVarAc = bvmVar2.ac(this.bd.ck(2));
                        dlaVarAc2 = bvmVar2.ac(this.bd.ck(4));
                    }
                    kw kwVarAd = bvmVar2.ad();
                    int i34 = i26;
                    kwVarAd.d.q(dlaVarAc4, -1.0f);
                    kwVarAd.d.q(dlaVarAc3, 1.0f);
                    kwVarAd.d.q(dlaVarAc2, f2);
                    kwVarAd.d.q(dlaVarAc, -f2);
                    bvmVar2.u(kwVarAd);
                    if (z2) {
                        z15 = false;
                    }
                    z16 = z4;
                    i11 = i34;
                } else {
                    i11 = i26;
                    z16 = true;
                }
            } else {
                int iMax = Math.max(i26, iMin);
                if (i27 > 0) {
                    iMax = Math.min(i27, iMax);
                }
                bvmVar2.w(dlaVarAc4, dlaVarAc3, iMax, 8);
                z16 = z4;
                i11 = i26;
                z15 = false;
            }
            if (z11 || z8) {
                boolean z29 = z16;
                if (i29 >= 2 && z2 && z29) {
                    bvmVar2.x(dlaVarAc3, dlaVar, 0, 8);
                    adb adbVar5 = this.aw;
                    boolean z30 = z || adbVar5.f == null;
                    if (!z && (adbVar3 = adbVar5.f) != null) {
                        adq adqVar2 = adbVar3.d;
                        if (adqVar2.bg != 0.0f) {
                            int[] iArr = adqVar2.bz;
                            z30 = iArr[0] == 3 && iArr[1] == 3;
                        }
                    }
                    if (z30) {
                        bvmVar2.x(dlaVar2, dlaVarAc4, 0, 8);
                        return;
                    }
                    return;
                }
                return;
            }
            if (zQ || zQ2 || zQ3) {
                if (!zQ || zQ2) {
                    if (zQ || !zQ2) {
                        dlaVar3 = dlaVarAc6;
                        if (zQ && zQ2) {
                            adq adqVar3 = adbVar.f.d;
                            adq adqVar4 = adbVar2.f.d;
                            z17 = z16;
                            adq adqVar5 = this.bd;
                            int i35 = 6;
                            if (z15) {
                                if (i30 == 0) {
                                    if (i27 != 0 || i11 != 0) {
                                        i23 = 5;
                                        i24 = 5;
                                        z25 = true;
                                        z26 = false;
                                        z19 = true;
                                    } else if (dlaVarAc5.f && dlaVar3.f) {
                                        bvmVar2.w(dlaVarAc3, dlaVarAc5, adbVar.n(), 8);
                                        bvmVar2.w(dlaVarAc4, dlaVar3, -adbVar2.n(), 8);
                                        return;
                                    } else {
                                        i23 = 8;
                                        i24 = 8;
                                        z25 = false;
                                        z26 = true;
                                        z19 = false;
                                    }
                                    if ((adqVar3 instanceof nb) || (adqVar4 instanceof nb)) {
                                        bvmVar2 = bvmVar;
                                        i12 = i30;
                                        dlaVar5 = dlaVarAc3;
                                        dlaVar6 = dlaVarAc4;
                                        z20 = z26;
                                        dlaVar4 = dlaVar2;
                                        i14 = i23;
                                        dlaVar7 = dlaVarAc5;
                                        i13 = 6;
                                        z18 = z25;
                                        i15 = 4;
                                    } else {
                                        bvmVar2 = bvmVar;
                                        dlaVar5 = dlaVarAc3;
                                        dlaVar6 = dlaVarAc4;
                                        z20 = z26;
                                        i14 = i23;
                                        dlaVar7 = dlaVarAc5;
                                        i13 = 6;
                                        z18 = z25;
                                        i15 = i24;
                                        i12 = i30;
                                        dlaVar4 = dlaVar2;
                                    }
                                } else {
                                    if (i30 == 2) {
                                        if ((adqVar3 instanceof nb) || (adqVar4 instanceof nb)) {
                                            bvmVar2 = bvmVar;
                                            i12 = i30;
                                            dlaVar5 = dlaVarAc3;
                                            dlaVar6 = dlaVarAc4;
                                            dlaVar7 = dlaVarAc5;
                                            i13 = 6;
                                            i14 = 5;
                                        } else {
                                            bvmVar2 = bvmVar;
                                            i12 = i30;
                                            dlaVar5 = dlaVarAc3;
                                            dlaVar6 = dlaVarAc4;
                                            dlaVar7 = dlaVarAc5;
                                            i13 = 6;
                                            i14 = 5;
                                            i15 = 5;
                                        }
                                        z18 = true;
                                        z19 = true;
                                        z20 = false;
                                        dlaVar4 = dlaVar2;
                                    } else if (i30 == 1) {
                                        bvmVar2 = bvmVar;
                                        i12 = i30;
                                        dlaVar5 = dlaVarAc3;
                                        dlaVar6 = dlaVarAc4;
                                        dlaVar7 = dlaVarAc5;
                                        i13 = 6;
                                        i14 = 8;
                                    } else if (i30 == 3) {
                                        i12 = i30;
                                        if (this.ak != -1) {
                                            if (z6) {
                                                if (i7 == 2 || i7 == 1) {
                                                    i21 = 5;
                                                    i22 = 4;
                                                } else {
                                                    i21 = 8;
                                                    i22 = 5;
                                                }
                                                i15 = i22;
                                                dlaVar5 = dlaVarAc3;
                                                dlaVar6 = dlaVarAc4;
                                                dlaVar7 = dlaVarAc5;
                                                i13 = 6;
                                                z18 = true;
                                                z19 = true;
                                                z20 = true;
                                                dlaVar4 = dlaVar2;
                                            } else {
                                                if (i27 > 0) {
                                                    bvmVar2 = bvmVar;
                                                    dlaVar4 = dlaVar2;
                                                    dlaVar5 = dlaVarAc3;
                                                    dlaVar6 = dlaVarAc4;
                                                    dlaVar7 = dlaVarAc5;
                                                    i13 = 6;
                                                    i14 = 5;
                                                } else if (i27 != 0 || i11 != 0) {
                                                    bvmVar2 = bvmVar;
                                                    dlaVar4 = dlaVar2;
                                                    dlaVar5 = dlaVarAc3;
                                                    dlaVar6 = dlaVarAc4;
                                                    dlaVar7 = dlaVarAc5;
                                                    i13 = 6;
                                                    i14 = 5;
                                                    i15 = 4;
                                                } else if (z9) {
                                                    i21 = (adqVar3 == adqVar5 || adqVar4 == adqVar5) ? 5 : 4;
                                                    dlaVar4 = dlaVar2;
                                                    dlaVar5 = dlaVarAc3;
                                                    dlaVar6 = dlaVarAc4;
                                                    dlaVar7 = dlaVarAc5;
                                                    i13 = 6;
                                                    i15 = 4;
                                                    z18 = true;
                                                    z19 = true;
                                                    z20 = true;
                                                } else {
                                                    bvmVar2 = bvmVar;
                                                    dlaVar4 = dlaVar2;
                                                    dlaVar5 = dlaVarAc3;
                                                    dlaVar6 = dlaVarAc4;
                                                    dlaVar7 = dlaVarAc5;
                                                    i13 = 6;
                                                    i14 = 5;
                                                    i15 = 8;
                                                }
                                                z18 = true;
                                                z19 = true;
                                                z20 = true;
                                            }
                                            i14 = i21;
                                            bvmVar2 = bvmVar;
                                        } else if (z9) {
                                            bvmVar2 = bvmVar;
                                            dlaVar4 = dlaVar2;
                                            dlaVar5 = dlaVarAc3;
                                            dlaVar6 = dlaVarAc4;
                                            dlaVar7 = dlaVarAc5;
                                            i14 = 8;
                                            i13 = z2 ? 5 : 4;
                                        } else {
                                            bvmVar2 = bvmVar;
                                            dlaVar4 = dlaVar2;
                                            dlaVar5 = dlaVarAc3;
                                            dlaVar6 = dlaVarAc4;
                                            dlaVar7 = dlaVarAc5;
                                            i14 = 8;
                                            i13 = 8;
                                        }
                                        i15 = 5;
                                        z18 = true;
                                        z19 = true;
                                        z20 = true;
                                    } else {
                                        i12 = i30;
                                        bvmVar2 = bvmVar;
                                        dlaVar4 = dlaVar2;
                                        dlaVar5 = dlaVarAc3;
                                        dlaVar6 = dlaVarAc4;
                                        dlaVar7 = dlaVarAc5;
                                        i13 = 6;
                                        i14 = 5;
                                        i15 = 4;
                                        z18 = false;
                                        z19 = false;
                                    }
                                    i15 = 4;
                                    z18 = true;
                                    z19 = true;
                                    z20 = false;
                                    dlaVar4 = dlaVar2;
                                }
                                if (!z19 && dlaVar7 == dlaVar3 && adqVar3 != adqVar5) {
                                    z19 = false;
                                    z21 = false;
                                }
                                if (z18) {
                                    if (z15 && !z7 && !z9 && dlaVar7 == dlaVar && dlaVar3 == dlaVar4) {
                                        i13 = 8;
                                        z22 = false;
                                        i20 = 8;
                                        z24 = false;
                                    } else {
                                        z22 = z2;
                                        z24 = z21;
                                        i20 = i14;
                                    }
                                    dla dlaVar8 = dlaVar7;
                                    i16 = i11;
                                    i17 = i12;
                                    adqVar = adqVar4;
                                    adbVar4 = adbVar2;
                                    bvmVar2.t(dlaVar5, dlaVar8, adbVar.n(), f, dlaVar3, dlaVar6, adbVar2.n(), i13);
                                    dlaVar7 = dlaVar8;
                                    i14 = i20;
                                    z21 = z24;
                                } else {
                                    adqVar = adqVar4;
                                    i16 = i11;
                                    i17 = i12;
                                    adbVar4 = adbVar2;
                                    z22 = z2;
                                }
                                if (this.bq != 8 && ((hashSet = adbVar4.a) == null || hashSet.size() <= 0)) {
                                    return;
                                }
                                if (z19) {
                                    if (z22 && dlaVar7 != dlaVar3 && !z15 && ((adqVar3 instanceof nb) || (adqVar instanceof nb))) {
                                        i14 = 6;
                                    }
                                    bvmVar2.x(dlaVar5, dlaVar7, adbVar.n(), i14);
                                    bvmVar2.y(dlaVar6, dlaVar3, -adbVar4.n(), i14);
                                }
                                if (z22 || !z10 || (adqVar3 instanceof nb) || (adqVar instanceof nb) || adqVar == adqVar5) {
                                    iMin2 = i15;
                                    z23 = z21;
                                } else {
                                    iMin2 = 6;
                                    i14 = 6;
                                    z23 = true;
                                }
                                if (z23) {
                                    if (z20 && (!z9 || z3)) {
                                        if (adqVar3 != adqVar5 && adqVar != adqVar5) {
                                            i35 = iMin2;
                                        }
                                        if (!(adqVar3 instanceof bjp) || (adqVar instanceof bjp)) {
                                        }
                                        if (!(adqVar3 instanceof nb) || (adqVar instanceof nb)) {
                                        }
                                        iMin2 = Math.max(z9 ? 5 : i35, iMin2);
                                    }
                                    if (z22) {
                                        iMin2 = Math.min(i14, iMin2);
                                        i19 = (z6 || z9 || !(adqVar3 == adqVar5 || adqVar == adqVar5)) ? iMin2 : 4;
                                    }
                                    bvmVar2.w(dlaVar5, dlaVar7, adbVar.n(), i19);
                                    bvmVar2.w(dlaVar6, dlaVar3, -adbVar4.n(), i19);
                                }
                                if (z22) {
                                    iN = dlaVar == dlaVar7 ? adbVar.n() : 0;
                                    if (dlaVar7 != dlaVar) {
                                        bvmVar2.x(dlaVar5, dlaVar, iN, 5);
                                    }
                                }
                                if (!z22 && z15 && i4 == 0 && i16 == 0) {
                                    if (z15 && i17 == 3) {
                                        bvmVar2.x(dlaVar6, dlaVar5, 0, 8);
                                    } else {
                                        i18 = 5;
                                        bvmVar2.x(dlaVar6, dlaVar5, 0, 5);
                                    }
                                }
                            } else {
                                i12 = i30;
                                if (dlaVarAc5.f && dlaVar3.f) {
                                    bvmVar.t(dlaVarAc3, dlaVarAc5, adbVar.n(), f, dlaVar3, dlaVarAc4, adbVar2.n(), 8);
                                    if (z2 && z17) {
                                        int iN2 = adbVar2.f != null ? adbVar2.n() : 0;
                                        if (dlaVar3 != dlaVar2) {
                                            bvmVar.x(dlaVar2, dlaVarAc4, iN2, 5);
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                bvmVar2 = bvmVar;
                                dlaVar4 = dlaVar2;
                                dlaVar5 = dlaVarAc3;
                                dlaVar6 = dlaVarAc4;
                                dlaVar7 = dlaVarAc5;
                                i13 = 6;
                                i14 = 5;
                                i15 = 4;
                                z18 = true;
                                z19 = true;
                            }
                            z20 = false;
                            z21 = !z19 ? true : true;
                            if (z18) {
                                if (z15) {
                                    z22 = z2;
                                    z24 = z21;
                                    i20 = i14;
                                } else {
                                    z22 = z2;
                                    z24 = z21;
                                    i20 = i14;
                                }
                                dla dlaVar82 = dlaVar7;
                                i16 = i11;
                                i17 = i12;
                                adqVar = adqVar4;
                                adbVar4 = adbVar2;
                                bvmVar2.t(dlaVar5, dlaVar82, adbVar.n(), f, dlaVar3, dlaVar6, adbVar2.n(), i13);
                                dlaVar7 = dlaVar82;
                                i14 = i20;
                                z21 = z24;
                            } else {
                                adqVar = adqVar4;
                                i16 = i11;
                                i17 = i12;
                                adbVar4 = adbVar2;
                                z22 = z2;
                            }
                            if (this.bq != 8) {
                            }
                            if (z19) {
                                if (z22) {
                                    i14 = 6;
                                }
                                bvmVar2.x(dlaVar5, dlaVar7, adbVar.n(), i14);
                                bvmVar2.y(dlaVar6, dlaVar3, -adbVar4.n(), i14);
                            }
                            if (z22) {
                                iMin2 = i15;
                                z23 = z21;
                            } else {
                                iMin2 = i15;
                                z23 = z21;
                            }
                            if (z23) {
                                if (z20) {
                                    if (adqVar3 != adqVar5) {
                                        i35 = iMin2;
                                    }
                                    i35 = !(adqVar3 instanceof bjp) ? 5 : 5;
                                    i35 = !(adqVar3 instanceof nb) ? 5 : 5;
                                    iMin2 = Math.max(z9 ? 5 : i35, iMin2);
                                }
                                if (z22) {
                                    iMin2 = Math.min(i14, iMin2);
                                    if (z6) {
                                    }
                                }
                                bvmVar2.w(dlaVar5, dlaVar7, adbVar.n(), i19);
                                bvmVar2.w(dlaVar6, dlaVar3, -adbVar4.n(), i19);
                            }
                            if (z22) {
                                if (dlaVar == dlaVar7) {
                                }
                                if (dlaVar7 != dlaVar) {
                                    bvmVar2.x(dlaVar5, dlaVar, iN, 5);
                                }
                            }
                            i18 = !z22 ? 5 : 5;
                        }
                        i25 = i18;
                    } else {
                        dlaVar3 = dlaVarAc6;
                        bvmVar2.w(dlaVarAc4, dlaVar3, -adbVar2.n(), 8);
                        if (z2) {
                            bvmVar2.x(dlaVarAc3, dlaVar, 0, 5);
                            adbVar4 = adbVar2;
                            i18 = 5;
                            dlaVar6 = dlaVarAc4;
                            z17 = z16;
                        }
                        z22 = z2;
                        i25 = i18;
                    }
                    adbVar4 = adbVar2;
                    dlaVar6 = dlaVarAc4;
                    z17 = z16;
                } else {
                    adbVar4 = adbVar2;
                    dlaVar6 = dlaVarAc4;
                    z17 = z16;
                    dlaVar3 = dlaVarAc6;
                    z22 = z2;
                    i25 = (z2 && (adbVar.f.d instanceof nb)) ? 8 : 5;
                }
                if (z22 || !z17) {
                    return;
                }
                int iN3 = adbVar4.f != null ? adbVar4.n() : 0;
                if (dlaVar3 != dlaVar2) {
                    bvmVar2.x(dlaVar2, dlaVar6, iN3, i25);
                    return;
                }
                return;
            }
            adbVar4 = adbVar2;
            dlaVar6 = dlaVarAc4;
            z17 = z16;
            dlaVar3 = dlaVarAc6;
            i18 = 5;
            z22 = z2;
            i25 = i18;
            if (z22) {
                return;
            } else {
                return;
            }
        }
        if (z5) {
            bvmVar2.w(dlaVarAc4, dlaVarAc3, 0, 3);
            if (i4 > 0) {
                bvmVar2.x(dlaVarAc4, dlaVarAc3, i4, i10);
            }
            if (i5 < Integer.MAX_VALUE) {
                bvmVar2.y(dlaVarAc4, dlaVarAc3, i5, i10);
            }
        } else {
            bvmVar2.w(dlaVarAc4, dlaVarAc3, iMin, i10);
        }
        z16 = z4;
        i11 = i26;
        if (z11) {
        }
        boolean z292 = z16;
        if (i29 >= 2) {
        }
    }

    public final void cg(int i, adq adqVar, int i2, int i3) {
        boolean z;
        if (i == 7) {
            if (i2 != 7) {
                if (i2 == 2 || i2 == 4) {
                    cg(2, adqVar, i2, 0);
                    cg(4, adqVar, i2, 0);
                    ck(7).j(adqVar.ck(i2), 0);
                    return;
                } else {
                    if (i2 == 3 || i2 == 5) {
                        cg(3, adqVar, i2, 0);
                        cg(5, adqVar, i2, 0);
                        ck(7).j(adqVar.ck(i2), 0);
                        return;
                    }
                    return;
                }
            }
            adb adbVarCk = ck(2);
            adb adbVarCk2 = ck(4);
            adb adbVarCk3 = ck(3);
            adb adbVarCk4 = ck(5);
            boolean z2 = true;
            if ((adbVarCk == null || !adbVarCk.q()) && (adbVarCk2 == null || !adbVarCk2.q())) {
                cg(2, adqVar, 2, 0);
                cg(4, adqVar, 4, 0);
                z = true;
            } else {
                z = false;
            }
            if ((adbVarCk3 == null || !adbVarCk3.q()) && (adbVarCk4 == null || !adbVarCk4.q())) {
                cg(3, adqVar, 3, 0);
                cg(5, adqVar, 5, 0);
            } else {
                z2 = false;
            }
            if (z && z2) {
                ck(7).j(adqVar.ck(7), 0);
                return;
            } else if (z) {
                ck(8).j(adqVar.ck(8), 0);
                return;
            } else {
                if (z2) {
                    ck(9).j(adqVar.ck(9), 0);
                    return;
                }
                return;
            }
        }
        if (i == 8 && (i2 == 2 || i2 == 4)) {
            adb adbVarCk5 = ck(2);
            adb adbVarCk6 = adqVar.ck(i2);
            adb adbVarCk7 = ck(4);
            adbVarCk5.j(adbVarCk6, 0);
            adbVarCk7.j(adbVarCk6, 0);
            ck(8).j(adbVarCk6, 0);
            return;
        }
        if (i == 9 && (i2 == 3 || i2 == 5)) {
            adb adbVarCk8 = adqVar.ck(i2);
            ck(3).j(adbVarCk8, 0);
            ck(5).j(adbVarCk8, 0);
            ck(9).j(adbVarCk8, 0);
            return;
        }
        if (i == 8 && i2 == 8) {
            ck(2).j(adqVar.ck(2), 0);
            ck(4).j(adqVar.ck(4), 0);
            ck(8).j(adqVar.ck(i2), 0);
            return;
        }
        if (i == 9 && i2 == 9) {
            ck(3).j(adqVar.ck(3), 0);
            ck(5).j(adqVar.ck(5), 0);
            ck(9).j(adqVar.ck(i2), 0);
            return;
        }
        adb adbVarCk9 = ck(i);
        adb adbVarCk10 = adqVar.ck(i2);
        if (adbVarCk9.r(adbVarCk10)) {
            if (i == 6) {
                adb adbVarCk11 = ck(3);
                adb adbVarCk12 = ck(5);
                if (adbVarCk11 != null) {
                    adbVarCk11.s();
                }
                if (adbVarCk12 != null) {
                    adbVarCk12.s();
                }
            } else if (i == 3 || i == 5) {
                adb adbVarCk13 = ck(6);
                if (adbVarCk13 != null) {
                    adbVarCk13.s();
                }
                adb adbVarCk14 = ck(7);
                if (adbVarCk14.f != adbVarCk10) {
                    adbVarCk14.s();
                }
                adb adbVarO = ck(i).o();
                adb adbVarCk15 = ck(9);
                if (adbVarCk15.q()) {
                    adbVarO.s();
                    adbVarCk15.s();
                }
            } else if (i == 2 || i == 4) {
                adb adbVarCk16 = ck(7);
                if (adbVarCk16.f != adbVarCk10) {
                    adbVarCk16.s();
                }
                adb adbVarO2 = ck(i).o();
                adb adbVarCk17 = ck(8);
                if (adbVarCk17.q()) {
                    adbVarO2.s();
                    adbVarCk17.s();
                }
            }
            adbVarCk9.j(adbVarCk10, i3);
        }
    }

    public final void ch(adb adbVar, adb adbVar2, int i) {
        if (adbVar.d == this) {
            cg(adbVar.e, adbVar2.d, adbVar2.e, i);
        }
    }

    public final void ci(bvm bvmVar) {
        bvmVar.ac(this.as);
        bvmVar.ac(this.at);
        bvmVar.ac(this.au);
        bvmVar.ac(this.av);
        if (this.bk > 0) {
            bvmVar.ac(this.aw);
        }
    }

    public final void cj() {
        if (this.n == null) {
            bmn bmnVar = new bmn(this);
            bmnVar.r.f = 4;
            bmnVar.s.f = 5;
            bmnVar.p = 0;
            this.n = bmnVar;
        }
        if (this.o == null) {
            eps epsVar = new eps(this);
            alz alzVar = new alz(epsVar);
            epsVar.a = alzVar;
            epsVar.b = null;
            epsVar.r.f = 6;
            epsVar.s.f = 7;
            alzVar.f = 8;
            epsVar.p = 1;
            this.o = epsVar;
        }
    }

    public adb ck(int i) {
        switch (dkz.ae(i)) {
            case 0:
                return null;
            case 1:
                return this.as;
            case 2:
                return this.at;
            case 3:
                return this.au;
            case 4:
                return this.av;
            case 5:
                return this.aw;
            case 6:
                return this.az;
            case 7:
                return this.ax;
            case 8:
                return this.ay;
            default:
                throw new AssertionError(yg.w(i));
        }
    }

    public final int cl(int i) {
        int[] iArr = this.bz;
        if (i == 0) {
            return iArr[0];
        }
        if (i == 1) {
            return iArr[1];
        }
        return 0;
    }

    public final int cm() {
        if (this.bq == 8) {
            return 0;
        }
        return this.bf;
    }

    public final adq cn(int i) {
        adb adbVar;
        adb adbVar2;
        if (i != 0) {
            if (i == 1 && (adbVar2 = (adbVar = this.av).f) != null && adbVar2.f == adbVar) {
                return adbVar2.d;
            }
            return null;
        }
        adb adbVar3 = this.au;
        adb adbVar4 = adbVar3.f;
        if (adbVar4 == null || adbVar4.f != adbVar3) {
            return null;
        }
        return adbVar4.d;
    }

    public final adq co(int i) {
        adb adbVar;
        adb adbVar2;
        if (i != 0) {
            if (i == 1 && (adbVar2 = (adbVar = this.at).f) != null && adbVar2.f == adbVar) {
                return adbVar2.d;
            }
            return null;
        }
        adb adbVar3 = this.as;
        adb adbVar4 = adbVar3.f;
        if (adbVar4 == null || adbVar4.f != adbVar3) {
            return null;
        }
        return adbVar4.d;
    }

    public void cp(StringBuilder sb) {
        sb.append("  " + this.t + ":{\n");
        StringBuilder sb2 = new StringBuilder("    actualWidth:");
        sb2.append(this.be);
        sb.append(sb2.toString());
        sb.append("\n");
        sb.append("    actualHeight:" + this.bf);
        sb.append("\n");
        sb.append("    actualLeft:" + this.bi);
        sb.append("\n");
        sb.append("    actualTop:" + this.bj);
        sb.append("\n");
        cb(sb, "left", this.as);
        cb(sb, "top", this.at);
        cb(sb, "right", this.au);
        cb(sb, "bottom", this.av);
        cb(sb, "baseline", this.aw);
        cb(sb, "centerX", this.ax);
        cb(sb, "centerY", this.ay);
        int i = this.be;
        int i2 = this.bl;
        int[] iArr = this.am;
        int i3 = iArr[0];
        int i4 = this.ae;
        int i5 = this.ab;
        float f = this.ag;
        int[] iArr2 = this.bz;
        int i6 = iArr2[0];
        float[] fArr = this.bu;
        float f2 = fArr[0];
        ca(sb, "    width", i, i2, i3, i4, i5, f, i6);
        int i7 = this.bf;
        int i8 = this.bm;
        int i9 = iArr[1];
        int i10 = this.ah;
        int i11 = this.ac;
        float f3 = this.aj;
        int i12 = iArr2[1];
        float f4 = fArr[1];
        ca(sb, "    height", i7, i8, i9, i10, i11, f3, i12);
        float f5 = this.bg;
        int i13 = this.bh;
        if (f5 != 0.0f) {
            sb.append("    dimensionRatio");
            sb.append(" :  [");
            sb.append(f5);
            sb.append(",");
            sb.append(i13);
            sb.append("");
            sb.append("],\n");
        }
        cd(sb, "    horizontalBias", this.bn, 0.5f);
        cd(sb, "    verticalBias", this.bo, 0.5f);
        cc(this.bs, 0, "    horizontalChainStyle", sb);
        cc(this.bt, 0, "    verticalChainStyle", sb);
        sb.append("  }");
    }

    public final int cq() {
        if (this.bq == 8) {
            return 0;
        }
        return this.be;
    }

    public final int cr() {
        adq adqVar = this.bd;
        return (adqVar == null || !(adqVar instanceof adr)) ? this.bi : ((adr) adqVar).f0do + this.bi;
    }

    public final int cs() {
        adq adqVar = this.bd;
        return (adqVar == null || !(adqVar instanceof adr)) ? this.bj : ((adr) adqVar).dp + this.bj;
    }

    /* JADX WARN: Found duplicated region for block: B:29:0x003a A[RETURN] */
    /* JADX WARN: Found duplicated region for block: B:30:0x003b A[RETURN] */
    public final boolean ct(int i) {
        if (i == 0) {
            return (this.as.f != null ? 1 : 0) + (this.au.f != null ? 1 : 0) < 2;
        }
        if ((this.at.f != null ? 1 : 0) + (this.av.f != null ? 1 : 0) + (this.aw.f != null ? 1 : 0) < 2) {
        }
    }

    public final boolean cu(int i, int i2) {
        adb adbVar;
        adb adbVar2;
        adb adbVar3;
        adb adbVar4;
        if (i == 0) {
            adb adbVar5 = this.as;
            adb adbVar6 = adbVar5.f;
            if (adbVar6 == null || !adbVar6.c || (adbVar4 = (adbVar3 = this.au).f) == null || !adbVar4.c) {
                return false;
            }
            return (adbVar4.m() - adbVar3.n()) - (adbVar5.n() + adbVar5.f.m()) >= i2;
        }
        adb adbVar7 = this.at;
        adb adbVar8 = adbVar7.f;
        if (adbVar8 == null || !adbVar8.c || (adbVar2 = (adbVar = this.av).f) == null || !adbVar2.c) {
            return false;
        }
        return (adbVar2.m() - adbVar.n()) - (adbVar7.n() + adbVar7.f.m()) >= i2;
    }

    public final void cv(int i, int i2, int i3, int i4, adq adqVar) {
        ck(i).k(adqVar.ck(i2), i3, i4, true);
    }

    public final boolean cw(int i) {
        adb adbVar;
        adb adbVar2;
        int i2 = i * 2;
        adb[] adbVarArr = this.ba;
        adb adbVar3 = adbVarArr[i2];
        adb adbVar4 = adbVar3.f;
        return (adbVar4 == null || adbVar4.f == adbVar3 || (adbVar2 = (adbVar = adbVarArr[i2 + 1]).f) == null || adbVar2.f != adbVar) ? false : true;
    }

    public final boolean cx() {
        adb adbVar = this.as;
        adb adbVar2 = adbVar.f;
        if (adbVar2 != null && adbVar2.f == adbVar) {
            return true;
        }
        adb adbVar3 = this.au;
        adb adbVar4 = adbVar3.f;
        return adbVar4 != null && adbVar4.f == adbVar3;
    }

    public final boolean cy() {
        adb adbVar = this.at;
        adb adbVar2 = adbVar.f;
        if (adbVar2 != null && adbVar2.f == adbVar) {
            return true;
        }
        adb adbVar3 = this.av;
        adb adbVar4 = adbVar3.f;
        return adbVar4 != null && adbVar4.f == adbVar3;
    }

    public final boolean cz() {
        return this.q && this.bq != 8;
    }

    public void da() {
        this.as.s();
        this.at.s();
        this.au.s();
        this.av.s();
        this.aw.s();
        this.ax.s();
        this.ay.s();
        this.az.s();
        this.bd = null;
        this.an = Float.NaN;
        this.be = 0;
        this.bf = 0;
        this.bg = 0.0f;
        this.bh = -1;
        this.bi = 0;
        this.bj = 0;
        this.bk = 0;
        this.bl = 0;
        this.bm = 0;
        this.bn = 0.5f;
        this.bo = 0.5f;
        int[] iArr = this.bz;
        iArr[0] = 1;
        iArr[1] = 1;
        this.bp = null;
        this.bq = 0;
        this.bs = 0;
        this.bt = 0;
        float[] fArr = this.bu;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.y = -1;
        this.z = -1;
        int[] iArr2 = this.am;
        iArr2[0] = Integer.MAX_VALUE;
        iArr2[1] = Integer.MAX_VALUE;
        this.ab = 0;
        this.ac = 0;
        this.ag = 1.0f;
        this.aj = 1.0f;
        this.af = Integer.MAX_VALUE;
        this.ai = Integer.MAX_VALUE;
        this.ae = 0;
        this.ah = 0;
        this.ak = -1;
        this.al = 1.0f;
        boolean[] zArr = this.p;
        zArr[0] = true;
        zArr[1] = true;
        this.ap = false;
        boolean[] zArr2 = this.bc;
        zArr2[0] = false;
        zArr2[1] = false;
        this.q = true;
        int[] iArr3 = this.ad;
        iArr3[0] = 0;
        iArr3[1] = 0;
        this.r = -1;
        this.s = -1;
    }

    public final void db() {
        adq adqVar = this.bd;
        if (adqVar != null && (adqVar instanceof adr)) {
            ((adr) adqVar).getClass();
        }
        ArrayList arrayList = this.bb;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((adb) arrayList.get(i)).s();
        }
    }

    public final void dc() {
        this.u = false;
        this.v = false;
        this.w = false;
        this.x = false;
        ArrayList arrayList = this.bb;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            adb adbVar = (adb) arrayList.get(i);
            adbVar.c = false;
            adbVar.b = 0;
        }
    }

    public void dd(jx jxVar) {
        this.as.t();
        this.at.t();
        this.au.t();
        this.av.t();
        this.aw.t();
        this.az.t();
        this.ax.t();
        this.ay.t();
    }

    public final void de(int i) {
        this.bk = i;
        this.ao = i > 0;
    }

    public final void df(int i, int i2) {
        if (this.u) {
            return;
        }
        this.as.u(i);
        this.au.u(i2);
        this.bi = i;
        this.be = i2 - i;
        this.u = true;
    }

    public final void dg(int i, int i2) {
        if (this.v) {
            return;
        }
        this.at.u(i);
        this.av.u(i2);
        this.bj = i;
        this.bf = i2 - i;
        if (this.ao) {
            this.aw.u(i + this.bk);
        }
        this.v = true;
    }

    public final void dh(int i) {
        this.bf = i;
        int i2 = this.bm;
        if (i < i2) {
            this.bf = i2;
        }
    }

    public final void di(int i) {
        this.bz[0] = i;
    }

    public final void dj(int i) {
        this.bz[1] = i;
    }

    public final void dk(int i) {
        this.be = i;
        int i2 = this.bl;
        if (i < i2) {
            this.be = i2;
        }
    }

    public void dl(boolean z, boolean z2) {
        int i;
        int i2;
        bmn bmnVar = this.n;
        boolean z3 = z & bmnVar.q;
        eps epsVar = this.o;
        boolean z4 = z2 & epsVar.q;
        int i3 = bmnVar.r.h;
        int i4 = epsVar.r.h;
        int i5 = bmnVar.s.h;
        int i6 = epsVar.s.h;
        int i7 = i6 - i4;
        if (i5 - i3 < 0 || i7 < 0 || i3 == Integer.MIN_VALUE || i3 == Integer.MAX_VALUE || i4 == Integer.MIN_VALUE || i4 == Integer.MAX_VALUE || i5 == Integer.MIN_VALUE || i5 == Integer.MAX_VALUE || i6 == Integer.MIN_VALUE || i6 == Integer.MAX_VALUE) {
            i5 = 0;
            i6 = 0;
            i3 = 0;
            i4 = 0;
        }
        int i8 = i5 - i3;
        int i9 = i6 - i4;
        if (z3) {
            this.bi = i3;
        }
        if (z4) {
            this.bj = i4;
        }
        if (this.bq == 8) {
            this.be = 0;
            this.bf = 0;
            return;
        }
        int[] iArr = this.bz;
        if (z3) {
            if (iArr[0] == 1 && i8 < (i2 = this.be)) {
                i8 = i2;
            }
            this.be = i8;
            int i10 = this.bl;
            if (i8 < i10) {
                this.be = i10;
            }
        }
        if (z4) {
            if (iArr[1] == 1 && i9 < (i = this.bf)) {
                i9 = i;
            }
            this.bf = i9;
            int i11 = this.bm;
            if (i9 < i11) {
                this.bf = i11;
            }
        }
    }

    public void dm(bvm bvmVar, boolean z) {
        int i;
        int i2;
        eps epsVar;
        bmn bmnVar;
        bvmVar.getClass();
        int iR = bvm.r(this.as);
        int iR2 = bvm.r(this.at);
        int iR3 = bvm.r(this.au);
        int iR4 = bvm.r(this.av);
        if (z && (bmnVar = this.n) != null) {
            alz alzVar = bmnVar.r;
            if (alzVar.k) {
                alz alzVar2 = bmnVar.s;
                if (alzVar2.k) {
                    iR = alzVar.h;
                    iR3 = alzVar2.h;
                }
            }
        }
        if (z && (epsVar = this.o) != null) {
            alz alzVar3 = epsVar.r;
            if (alzVar3.k) {
                alz alzVar4 = epsVar.s;
                if (alzVar4.k) {
                    iR2 = alzVar3.h;
                    iR4 = alzVar4.h;
                }
            }
        }
        int i3 = iR4 - iR2;
        if (iR3 - iR < 0 || i3 < 0 || iR == Integer.MIN_VALUE || iR == Integer.MAX_VALUE || iR2 == Integer.MIN_VALUE || iR2 == Integer.MAX_VALUE || iR3 == Integer.MIN_VALUE || iR3 == Integer.MAX_VALUE || iR4 == Integer.MIN_VALUE || iR4 == Integer.MAX_VALUE) {
            iR = 0;
            iR2 = 0;
            iR3 = 0;
            iR4 = 0;
        }
        int i4 = iR3 - iR;
        int i5 = iR4 - iR2;
        this.bi = iR;
        this.bj = iR2;
        if (this.bq == 8) {
            this.be = 0;
            this.bf = 0;
            return;
        }
        int[] iArr = this.bz;
        int i6 = iArr[0];
        if (i6 == 1 && i4 < (i2 = this.be)) {
            i4 = i2;
        }
        if (iArr[1] == 1 && i5 < (i = this.bf)) {
            i5 = i;
        }
        this.be = i4;
        this.bf = i5;
        int i7 = this.bm;
        if (i5 < i7) {
            this.bf = i7;
        }
        int i8 = this.bl;
        if (i4 < i8) {
            this.be = i8;
        }
        int i9 = this.af;
        if (i9 > 0 && i6 == 3) {
            this.be = Math.min(this.be, i9);
        }
        int i10 = this.ai;
        if (i10 > 0 && iArr[1] == 3) {
            this.bf = Math.min(this.bf, i10);
        }
        int i11 = this.be;
        if (i4 != i11) {
            this.r = i11;
        }
        int i12 = this.bf;
        if (i5 != i12) {
            this.s = i12;
        }
    }

    /* JADX WARN: Found duplicated region for block: B:121:0x0204  */
    /* JADX WARN: Found duplicated region for block: B:125:0x020c  */
    /* JADX WARN: Found duplicated region for block: B:128:0x0215  */
    /* JADX WARN: Found duplicated region for block: B:130:0x021b  */
    /* JADX WARN: Found duplicated region for block: B:131:0x0226  */
    /* JADX WARN: Found duplicated region for block: B:134:0x0232  */
    /* JADX WARN: Found duplicated region for block: B:135:0x023b  */
    /* JADX WARN: Found duplicated region for block: B:145:0x0261  */
    /* JADX WARN: Found duplicated region for block: B:157:0x028b  */
    /* JADX WARN: Found duplicated region for block: B:161:0x029a  */
    /* JADX WARN: Found duplicated region for block: B:164:0x02a3  */
    /* JADX WARN: Found duplicated region for block: B:165:0x02a6  */
    /* JADX WARN: Found duplicated region for block: B:168:0x02b5  */
    /* JADX WARN: Found duplicated region for block: B:170:0x02bc  */
    /* JADX WARN: Found duplicated region for block: B:173:0x02c3  */
    /* JADX WARN: Found duplicated region for block: B:174:0x02c6  */
    /* JADX WARN: Found duplicated region for block: B:177:0x02e4  */
    /* JADX WARN: Found duplicated region for block: B:179:0x02ec  */
    /* JADX WARN: Found duplicated region for block: B:183:0x02f3  */
    /* JADX WARN: Found duplicated region for block: B:187:0x02fd  */
    /* JADX WARN: Found duplicated region for block: B:249:0x03ae A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:24:0x0062  */
    /* JADX WARN: Found duplicated region for block: B:250:0x03b0 A[ADDED_TO_REGION] */
    /* JADX WARN: Found duplicated region for block: B:255:0x03c7 A[PHI: r13
      0x03c7: PHI (r13v37 int) = (r13v22 int), (r13v22 int), (r13v34 int), (r13v22 int), (r13v22 int), (r13v22 int), (r13v22 int), (r13v22 int) binds: [B:257:0x03cf, B:258:0x03d1, B:252:0x03bb, B:239:0x0390, B:245:0x039e, B:247:0x03a2, B:248:0x03a4, B:244:0x039a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Found duplicated region for block: B:257:0x03cf A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:258:0x03d1 A[ADDED_TO_REGION] */
    /* JADX WARN: Found duplicated region for block: B:268:0x03f5  */
    /* JADX WARN: Found duplicated region for block: B:26:0x006e A[MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:272:0x040d  */
    /* JADX WARN: Found duplicated region for block: B:274:0x0412 A[ADDED_TO_REGION] */
    /* JADX WARN: Found duplicated region for block: B:276:0x0416  */
    /* JADX WARN: Found duplicated region for block: B:279:0x041a  */
    /* JADX WARN: Found duplicated region for block: B:284:0x0426  */
    /* JADX WARN: Found duplicated region for block: B:287:0x042e  */
    /* JADX WARN: Found duplicated region for block: B:290:0x0434  */
    /* JADX WARN: Found duplicated region for block: B:292:0x0437  */
    /* JADX WARN: Found duplicated region for block: B:295:0x0453  */
    /* JADX WARN: Found duplicated region for block: B:314:0x049a  */
    /* JADX WARN: Found duplicated region for block: B:330:0x0537  */
    /* JADX WARN: Found duplicated region for block: B:346:0x058a  */
    /* JADX WARN: Found duplicated region for block: B:349:0x059c  */
    /* JADX WARN: Found duplicated region for block: B:352:0x05a0  */
    /* JADX WARN: Found duplicated region for block: B:389:0x0661  */
    /* JADX WARN: Found duplicated region for block: B:38:0x0092  */
    /* JADX WARN: Found duplicated region for block: B:391:0x0667  */
    /* JADX WARN: Found duplicated region for block: B:393:0x066e  */
    /* JADX WARN: Found duplicated region for block: B:394:0x0697  */
    /* JADX WARN: Found duplicated region for block: B:397:0x06c5 A[MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:400:0x0089 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:43:0x009c A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:44:0x009e  */
    /* JADX WARN: Found duplicated region for block: B:46:0x00ad  */
    /* JADX WARN: Found duplicated region for block: B:50:0x00b7  */
    /* JADX WARN: Found duplicated region for block: B:54:0x00cf  */
    /* JADX WARN: Found duplicated region for block: B:57:0x00da  */
    /* JADX WARN: Found duplicated region for block: B:61:0x00f2  */
    /* JADX WARN: Found duplicated region for block: B:64:0x00fd  */
    /* JADX WARN: Found duplicated region for block: B:67:0x010f  */
    /* JADX WARN: Found duplicated region for block: B:71:0x011f  */
    /* JADX WARN: Found duplicated region for block: B:75:0x0129  */
    /* JADX WARN: Found duplicated region for block: B:79:0x0141  */
    /* JADX WARN: Found duplicated region for block: B:82:0x014c  */
    /* JADX WARN: Found duplicated region for block: B:86:0x0164  */
    /* JADX WARN: Found duplicated region for block: B:89:0x016f  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v8, types: [boolean] */
    /* JADX WARN: Type inference failed for: r17v10, types: [boolean] */
    /* JADX WARN: Type inference failed for: r17v9, types: [boolean] */
    /* JADX WARN: Type inference failed for: r18v25 */
    /* JADX WARN: Type inference failed for: r18v6, types: [boolean] */
    /* JADX WARN: Type inference failed for: r18v7 */
    /* JADX WARN: Type inference failed for: r27v3 */
    /* JADX WARN: Type inference failed for: r27v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r27v6 */
    /* JADX WARN: Type inference failed for: r27v7 */
    /* JADX WARN: Type inference failed for: r27v8 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v19, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r4v19, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v20, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v41 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r58v0, types: [me.hd.wauxv.obf.adq] */
    public void e(bvm bvmVar, boolean z) {
        int i;
        int i2;
        int i3;
        int i4;
        boolean[] zArr;
        int i5;
        int i6;
        boolean z2;
        HashSet hashSet;
        adq adqVar;
        adr adrVar;
        WeakReference weakReference;
        WeakReference weakReference2;
        adq adqVar2;
        adr adrVar2;
        WeakReference weakReference3;
        WeakReference weakReference4;
        boolean[] zArr2;
        adb adbVar;
        boolean[] zArr3;
        adb adbVar2;
        adb adbVar3;
        int i7;
        boolean z3;
        boolean z4;
        int i8;
        int i9;
        int i10;
        int[] iArr;
        int i11;
        int i12;
        int i13;
        float f;
        int i14;
        int i15;
        adb adbVar4;
        dla dlaVar;
        adb adbVar5;
        int i16;
        int i17;
        int i18;
        boolean z5;
        int i19;
        boolean z6;
        adb adbVar6;
        int i20;
        int[] iArr2;
        adb adbVar7;
        dla dlaVar2;
        dla dlaVar3;
        adb adbVar8;
        int[] iArr3;
        dla dlaVar4;
        boolean z7;
        ?? r3;
        ?? r4;
        dla dlaVar5;
        adb adbVar9;
        dla dlaVar6;
        int i21;
        boolean[] zArr4;
        dla dlaVar7;
        dla dlaVar8;
        dla dlaVar9;
        int i22;
        int i23;
        boolean z8;
        int i24;
        dla dlaVar10;
        dla dlaVar11;
        ?? r27;
        eps epsVar;
        boolean z9;
        bmn bmnVar;
        int i25;
        int i26;
        boolean zCx;
        int i27;
        boolean zCy;
        bmn bmnVar2;
        eps epsVar2;
        boolean z10;
        ArrayList arrayList;
        int size;
        int i28;
        HashSet hashSet2;
        bvm bvmVar2 = bvmVar;
        adb adbVar10 = this.as;
        dla dlaVarAc = bvmVar2.ac(adbVar10);
        adb adbVar11 = this.au;
        dla dlaVarAc2 = bvmVar2.ac(adbVar11);
        adb adbVar12 = this.at;
        dla dlaVarAc3 = bvmVar2.ac(adbVar12);
        adb adbVar13 = this.av;
        dla dlaVarAc4 = bvmVar2.ac(adbVar13);
        adb adbVar14 = this.aw;
        dla dlaVarAc5 = bvmVar2.ac(adbVar14);
        adq adqVar3 = this.bd;
        if (adqVar3 != null) {
            int[] iArr4 = adqVar3.bz;
            i = 0;
            i3 = iArr4[0] == 2 ? 1 : 0;
            int i29 = iArr4[1] == 2 ? 1 : 0;
            int i30 = this.aa;
            if (i30 != 1) {
                if (i30 == 2) {
                    i3 = 0;
                } else if (i30 != 3) {
                }
                i2 = i29;
            } else {
                i2 = 0;
            }
            i4 = this.bq;
            zArr = this.bc;
            i5 = i2;
            if (i4 == 8) {
                arrayList = this.bb;
                size = arrayList.size();
                i6 = i3;
                i28 = i;
                while (true) {
                    if (i28 < size) {
                        if (!zArr[i] || zArr[1]) {
                            break;
                            break;
                        }
                        return;
                    }
                    int i31 = size;
                    hashSet2 = ((adb) arrayList.get(i28)).a;
                    if (hashSet2 != null && hashSet2.size() > 0) {
                        break;
                    }
                    i28++;
                    size = i31;
                }
            } else {
                i6 = i3;
            }
            z2 = this.u;
            if (z2 || this.v) {
                if (z2) {
                    bvmVar2.v(dlaVarAc, this.bi);
                    bvmVar2.v(dlaVarAc2, this.bi + this.be);
                    if (i6 != 0 && (adqVar2 = this.bd) != null) {
                        adrVar2 = (adr) adqVar2;
                        weakReference3 = adrVar2.dy;
                        if (weakReference3 != null || weakReference3.get() == null || adbVar10.m() > ((adb) adrVar2.dy.get()).m()) {
                            adrVar2.dy = new WeakReference(adbVar10);
                        }
                        weakReference4 = adrVar2.ea;
                        if (weakReference4 != null || weakReference4.get() == null || adbVar11.m() > ((adb) adrVar2.ea.get()).m()) {
                            adrVar2.ea = new WeakReference(adbVar11);
                        }
                    }
                }
                if (this.v) {
                    bvmVar2.v(dlaVarAc3, this.bj);
                    bvmVar2.v(dlaVarAc4, this.bj + this.bf);
                    hashSet = adbVar14.a;
                    if (hashSet != null && hashSet.size() > 0) {
                        bvmVar2.v(dlaVarAc5, this.bj + this.bk);
                    }
                    if (i5 != 0 && (adqVar = this.bd) != null) {
                        adrVar = (adr) adqVar;
                        weakReference = adrVar.dx;
                        if (weakReference != null || weakReference.get() == null || adbVar12.m() > ((adb) adrVar.dx.get()).m()) {
                            adrVar.dx = new WeakReference(adbVar12);
                        }
                        weakReference2 = adrVar.dz;
                        if (weakReference2 != null || weakReference2.get() == null || adbVar13.m() > ((adb) adrVar.dz.get()).m()) {
                            adrVar.dz = new WeakReference(adbVar13);
                        }
                    }
                }
                if (this.u && this.v) {
                    ?? r12 = i;
                    this.u = r12;
                    this.v = r12;
                    return;
                }
            }
            zArr2 = this.p;
            if (z || (bmnVar2 = this.n) == null || (epsVar2 = this.o) == null) {
                adbVar = adbVar14;
                zArr3 = zArr2;
            } else {
                adbVar = adbVar14;
                alz alzVar = bmnVar2.r;
                zArr3 = zArr2;
                if (alzVar.k && bmnVar2.s.k && epsVar2.r.k && epsVar2.s.k) {
                    bvmVar2.v(dlaVarAc, alzVar.h);
                    bvmVar2.v(dlaVarAc2, this.n.s.h);
                    bvmVar2.v(dlaVarAc3, this.o.r.h);
                    bvmVar2.v(dlaVarAc4, this.o.s.h);
                    bvmVar2.v(dlaVarAc5, this.o.a.h);
                    if (this.bd == null) {
                        z10 = false;
                    } else {
                        if (i6 != 0 && zArr3[0] && !cx()) {
                            bvmVar2.x(bvmVar2.ac(this.bd.au), dlaVarAc2, 0, 8);
                        }
                        if (i5 == 0 || !zArr3[1] || cy()) {
                            z10 = false;
                        } else {
                            z10 = false;
                            bvmVar2.x(bvmVar2.ac(this.bd.av), dlaVarAc4, 0, 8);
                        }
                    }
                    this.u = z10;
                    this.v = z10;
                    return;
                }
            }
            if (this.bd != null) {
                if (cw(0)) {
                    ((adr) this.bd).ee(this, 0);
                    zCx = true;
                    i27 = 1;
                } else {
                    zCx = cx();
                    i27 = 1;
                }
                if (cw(i27)) {
                    ((adr) this.bd).ee(this, i27);
                    zCy = true;
                } else {
                    zCy = cy();
                }
                if (zCx && i6 != 0 && this.bq != 8 && adbVar10.f == null && adbVar11.f == null) {
                    adbVar2 = adbVar10;
                    bvmVar2.x(bvmVar2.ac(this.bd.au), dlaVarAc2, 0, 1);
                }
                if (!zCy && i5 != 0 && this.bq != 8 && adbVar12.f == null && adbVar13.f == null && adbVar == null) {
                    bvmVar2.x(bvmVar2.ac(this.bd.av), dlaVarAc4, 0, 1);
                }
                adbVar3 = adbVar11;
                i7 = i5;
                z4 = zCy;
                z3 = zCx;
            } else {
                adbVar2 = adbVar10;
                adbVar3 = adbVar11;
                i7 = i5;
                z3 = false;
                z4 = false;
            }
            i8 = this.be;
            i9 = this.bl;
            if (i8 >= i9) {
                i9 = i8;
            }
            int i32 = this.bf;
            adb adbVar15 = adbVar3;
            int i33 = this.bm;
            i10 = i32 < i33 ? i33 : i32;
            iArr = this.bz;
            i11 = iArr[0];
            i12 = i7;
            boolean z11 = i11 != 3;
            i13 = iArr[1];
            boolean z12 = i13 != 3;
            int i34 = this.bh;
            this.ak = i34;
            f = this.bg;
            this.al = f;
            i14 = this.ab;
            i15 = this.ac;
            if (f > 0.0f) {
                adbVar4 = adbVar13;
                if (this.bq != 8) {
                    int i35 = (i11 == 3 || i14 != 0) ? i14 : 3;
                    if (i13 == 3 || i15 != 0) {
                        dlaVar = dlaVarAc4;
                        i26 = i15;
                    } else {
                        dlaVar = dlaVarAc4;
                        i26 = 3;
                    }
                    if (i11 == 3 || i13 != 3 || i35 != 3 || i26 != 3) {
                        if (i11 != 3 && i35 == 3) {
                            this.ak = 0;
                            i9 = (int) (f * i32);
                            if (i13 != 3) {
                                adbVar5 = adbVar;
                                i16 = i10;
                                i17 = 4;
                                z5 = false;
                            }
                            i18 = i26;
                            int[] iArr5 = this.ad;
                            iArr5[0] = i17;
                            iArr5[1] = i18;
                            if (z5) {
                                int i36 = this.ak;
                                i19 = -1;
                                if (i36 != 0) {
                                }
                                if (z5) {
                                }
                                if (iArr[0] != 2) {
                                }
                                if (z6) {
                                    i9 = 0;
                                }
                                adbVar6 = this.az;
                                boolean z13 = !adbVar6.q();
                                char c = '\b';
                                boolean z14 = zArr[0];
                                boolean z15 = zArr[1];
                                i20 = this.y;
                                iArr2 = this.am;
                                if (i20 != 2) {
                                    adbVar7 = adbVar5;
                                    dlaVar2 = dlaVarAc;
                                    dlaVar3 = dlaVarAc2;
                                    adbVar8 = adbVar6;
                                    iArr3 = iArr2;
                                    dlaVar4 = dlaVarAc5;
                                    z7 = z3;
                                    r3 = i6;
                                    r4 = i12;
                                    dlaVar5 = dlaVarAc3;
                                    adbVar9 = adbVar4;
                                    dlaVar6 = dlaVar;
                                    i21 = i17;
                                    zArr4 = zArr3;
                                } else {
                                    adbVar7 = adbVar5;
                                    dlaVar2 = dlaVarAc;
                                    dlaVar3 = dlaVarAc2;
                                    adbVar8 = adbVar6;
                                    iArr3 = iArr2;
                                    dlaVar4 = dlaVarAc5;
                                    z7 = z3;
                                    r3 = i6;
                                    r4 = i12;
                                    dlaVar5 = dlaVarAc3;
                                    adbVar9 = adbVar4;
                                    dlaVar6 = dlaVar;
                                    i21 = i17;
                                    zArr4 = zArr3;
                                }
                                if (z) {
                                    dlaVar7 = dlaVar5;
                                    dlaVar8 = dlaVar6;
                                    dlaVar9 = dlaVar4;
                                    i22 = 0;
                                    i23 = 8;
                                    z8 = true;
                                    i24 = 1;
                                } else {
                                    dlaVar7 = dlaVar5;
                                    dlaVar8 = dlaVar6;
                                    dlaVar9 = dlaVar4;
                                    i22 = 0;
                                    i23 = 8;
                                    z8 = true;
                                    i24 = 1;
                                }
                                if (this.z == 2) {
                                    i24 = i22;
                                }
                                if (i24 != 0) {
                                    dlaVar10 = dlaVar7;
                                    dlaVar11 = dlaVar8;
                                } else {
                                    dlaVar10 = dlaVar7;
                                    dlaVar11 = dlaVar8;
                                }
                                if (z5) {
                                    if (this.ak == 1) {
                                        float f2 = this.al;
                                        kw kwVarAd = bvmVar2.ad();
                                        kwVarAd.d.q(dlaVar11, -1.0f);
                                        kwVarAd.d.q(dlaVar10, 1.0f);
                                        kwVarAd.d.q(dlaVar3, f2);
                                        kwVarAd.d.q(dlaVar2, -f2);
                                        bvmVar2.u(kwVarAd);
                                    } else {
                                        float f3 = this.al;
                                        kw kwVarAd2 = bvmVar2.ad();
                                        kwVarAd2.d.q(dlaVar3, -1.0f);
                                        kwVarAd2.d.q(dlaVar2, 1.0f);
                                        kwVarAd2.d.q(dlaVar11, f3);
                                        kwVarAd2.d.q(dlaVar10, -f3);
                                        bvmVar2.u(kwVarAd2);
                                    }
                                }
                                if (adbVar8.q()) {
                                    adb adbVar16 = adbVar8;
                                    adq adqVar4 = adbVar16.f.d;
                                    float radians = (float) Math.toRadians(this.an + 90.0f);
                                    int iN = adbVar16.n();
                                    dla dlaVarAc6 = bvmVar2.ac(ck(2));
                                    dla dlaVarAc7 = bvmVar2.ac(ck(3));
                                    dla dlaVarAc8 = bvmVar2.ac(ck(4));
                                    dla dlaVarAc9 = bvmVar2.ac(ck(5));
                                    dla dlaVarAc10 = bvmVar2.ac(adqVar4.ck(2));
                                    dla dlaVarAc11 = bvmVar2.ac(adqVar4.ck(3));
                                    dla dlaVarAc12 = bvmVar2.ac(adqVar4.ck(4));
                                    dla dlaVarAc13 = bvmVar2.ac(adqVar4.ck(5));
                                    kw kwVarAd3 = bvmVar2.ad();
                                    double d = radians;
                                    double dSin = Math.sin(d);
                                    double d2 = iN;
                                    kwVarAd3.d.q(dlaVarAc11, 0.5f);
                                    kwVarAd3.d.q(dlaVarAc13, 0.5f);
                                    kwVarAd3.d.q(dlaVarAc7, -0.5f);
                                    kwVarAd3.d.q(dlaVarAc9, -0.5f);
                                    kwVarAd3.b = -((float) (dSin * d2));
                                    bvmVar2.u(kwVarAd3);
                                    kw kwVarAd4 = bvmVar2.ad();
                                    float fCos = (float) (Math.cos(d) * d2);
                                    kwVarAd4.d.q(dlaVarAc10, 0.5f);
                                    kwVarAd4.d.q(dlaVarAc12, 0.5f);
                                    kwVarAd4.d.q(dlaVarAc6, -0.5f);
                                    kwVarAd4.d.q(dlaVarAc8, -0.5f);
                                    kwVarAd4.b = -fCos;
                                    bvmVar2.u(kwVarAd4);
                                }
                                this.u = false;
                                this.v = false;
                            }
                            i19 = -1;
                            if (z5) {
                            }
                            if (iArr[0] != 2) {
                            }
                            if (z6) {
                                i9 = 0;
                            }
                            adbVar6 = this.az;
                            boolean z132 = !adbVar6.q();
                            char c2 = '\b';
                            boolean z142 = zArr[0];
                            boolean z152 = zArr[1];
                            i20 = this.y;
                            iArr2 = this.am;
                            if (i20 != 2) {
                                adbVar7 = adbVar5;
                                dlaVar2 = dlaVarAc;
                                dlaVar3 = dlaVarAc2;
                                adbVar8 = adbVar6;
                                iArr3 = iArr2;
                                dlaVar4 = dlaVarAc5;
                                z7 = z3;
                                r3 = i6;
                                r4 = i12;
                                dlaVar5 = dlaVarAc3;
                                adbVar9 = adbVar4;
                                dlaVar6 = dlaVar;
                                i21 = i17;
                                zArr4 = zArr3;
                            } else {
                                adbVar7 = adbVar5;
                                dlaVar2 = dlaVarAc;
                                dlaVar3 = dlaVarAc2;
                                adbVar8 = adbVar6;
                                iArr3 = iArr2;
                                dlaVar4 = dlaVarAc5;
                                z7 = z3;
                                r3 = i6;
                                r4 = i12;
                                dlaVar5 = dlaVarAc3;
                                adbVar9 = adbVar4;
                                dlaVar6 = dlaVar;
                                i21 = i17;
                                zArr4 = zArr3;
                            }
                            if (z) {
                                dlaVar7 = dlaVar5;
                                dlaVar8 = dlaVar6;
                                dlaVar9 = dlaVar4;
                                i22 = 0;
                                i23 = 8;
                                z8 = true;
                                i24 = 1;
                            } else {
                                dlaVar7 = dlaVar5;
                                dlaVar8 = dlaVar6;
                                dlaVar9 = dlaVar4;
                                i22 = 0;
                                i23 = 8;
                                z8 = true;
                                i24 = 1;
                            }
                            if (this.z == 2) {
                                i24 = i22;
                            }
                            if (i24 != 0) {
                                dlaVar10 = dlaVar7;
                                dlaVar11 = dlaVar8;
                            } else {
                                dlaVar10 = dlaVar7;
                                dlaVar11 = dlaVar8;
                            }
                            if (z5) {
                                if (this.ak == 1) {
                                    float f22 = this.al;
                                    kw kwVarAd5 = bvmVar2.ad();
                                    kwVarAd5.d.q(dlaVar11, -1.0f);
                                    kwVarAd5.d.q(dlaVar10, 1.0f);
                                    kwVarAd5.d.q(dlaVar3, f22);
                                    kwVarAd5.d.q(dlaVar2, -f22);
                                    bvmVar2.u(kwVarAd5);
                                } else {
                                    float f32 = this.al;
                                    kw kwVarAd22 = bvmVar2.ad();
                                    kwVarAd22.d.q(dlaVar3, -1.0f);
                                    kwVarAd22.d.q(dlaVar2, 1.0f);
                                    kwVarAd22.d.q(dlaVar11, f32);
                                    kwVarAd22.d.q(dlaVar10, -f32);
                                    bvmVar2.u(kwVarAd22);
                                }
                            }
                            if (adbVar8.q()) {
                                adb adbVar162 = adbVar8;
                                adq adqVar42 = adbVar162.f.d;
                                float radians2 = (float) Math.toRadians(this.an + 90.0f);
                                int iN2 = adbVar162.n();
                                dla dlaVarAc62 = bvmVar2.ac(ck(2));
                                dla dlaVarAc72 = bvmVar2.ac(ck(3));
                                dla dlaVarAc82 = bvmVar2.ac(ck(4));
                                dla dlaVarAc92 = bvmVar2.ac(ck(5));
                                dla dlaVarAc102 = bvmVar2.ac(adqVar42.ck(2));
                                dla dlaVarAc112 = bvmVar2.ac(adqVar42.ck(3));
                                dla dlaVarAc122 = bvmVar2.ac(adqVar42.ck(4));
                                dla dlaVarAc132 = bvmVar2.ac(adqVar42.ck(5));
                                kw kwVarAd32 = bvmVar2.ad();
                                double d3 = radians2;
                                double dSin2 = Math.sin(d3);
                                double d22 = iN2;
                                kwVarAd32.d.q(dlaVarAc112, 0.5f);
                                kwVarAd32.d.q(dlaVarAc132, 0.5f);
                                kwVarAd32.d.q(dlaVarAc72, -0.5f);
                                kwVarAd32.d.q(dlaVarAc92, -0.5f);
                                kwVarAd32.b = -((float) (dSin2 * d22));
                                bvmVar2.u(kwVarAd32);
                                kw kwVarAd42 = bvmVar2.ad();
                                float fCos2 = (float) (Math.cos(d3) * d22);
                                kwVarAd42.d.q(dlaVarAc102, 0.5f);
                                kwVarAd42.d.q(dlaVarAc122, 0.5f);
                                kwVarAd42.d.q(dlaVarAc62, -0.5f);
                                kwVarAd42.d.q(dlaVarAc82, -0.5f);
                                kwVarAd42.b = -fCos2;
                                bvmVar2.u(kwVarAd42);
                            }
                            this.u = false;
                            this.v = false;
                        }
                        if (i13 != 3 && i26 == 3) {
                            this.ak = 1;
                            if (i34 == -1) {
                                this.al = 1.0f / f;
                            }
                            i16 = (int) (this.al * i8);
                            if (i11 != 3) {
                                i17 = i35;
                                adbVar5 = adbVar;
                                i18 = 4;
                            } else {
                                i17 = i35;
                                adbVar5 = adbVar;
                            }
                        }
                        z5 = true;
                        i18 = i26;
                        int[] iArr52 = this.ad;
                        iArr52[0] = i17;
                        iArr52[1] = i18;
                        if (z5) {
                            int i362 = this.ak;
                            i19 = -1;
                            boolean z16 = i362 != 0 || i362 == -1;
                            boolean z17 = !z5 && ((i25 = this.ak) == 1 || i25 == i19);
                            z6 = iArr[0] != 2 && (this instanceof adr);
                            if (z6) {
                                i9 = 0;
                            }
                            adbVar6 = this.az;
                            boolean z1322 = !adbVar6.q();
                            char c22 = '\b';
                            boolean z1422 = zArr[0];
                            boolean z1522 = zArr[1];
                            i20 = this.y;
                            iArr2 = this.am;
                            if (i20 != 2 || this.u) {
                                adbVar7 = adbVar5;
                                dlaVar2 = dlaVarAc;
                                dlaVar3 = dlaVarAc2;
                                adbVar8 = adbVar6;
                                iArr3 = iArr2;
                                dlaVar4 = dlaVarAc5;
                                z7 = z3;
                                r3 = i6;
                                r4 = i12;
                                dlaVar5 = dlaVarAc3;
                                adbVar9 = adbVar4;
                                dlaVar6 = dlaVar;
                                i21 = i17;
                                zArr4 = zArr3;
                            } else {
                                if (z && (bmnVar = this.n) != null) {
                                    alz alzVar2 = bmnVar.r;
                                    if (alzVar2.k && bmnVar.s.k) {
                                        if (z) {
                                            bvmVar2.v(dlaVarAc, alzVar2.h);
                                            bvmVar2.v(dlaVarAc2, this.n.s.h);
                                            if (this.bd != null && i6 != 0 && zArr3[0] && !cx()) {
                                                bvmVar2.x(bvmVar2.ac(this.bd.au), dlaVarAc2, 0, 8);
                                            }
                                        }
                                        adbVar7 = adbVar5;
                                        dlaVar2 = dlaVarAc;
                                        dlaVar3 = dlaVarAc2;
                                        adbVar8 = adbVar6;
                                        iArr3 = iArr2;
                                        dlaVar4 = dlaVarAc5;
                                        z7 = z3;
                                        r3 = i6;
                                        r4 = i12;
                                        dlaVar5 = dlaVarAc3;
                                        adbVar9 = adbVar4;
                                        dlaVar6 = dlaVar;
                                        i21 = i17;
                                        zArr4 = zArr3;
                                    } else {
                                        c22 = '\b';
                                    }
                                }
                                adq adqVar5 = this.bd;
                                dla dlaVarAc14 = adqVar5 != null ? bvmVar2.ac(adqVar5.au) : null;
                                adq adqVar6 = this.bd;
                                dla dlaVarAc15 = adqVar6 != null ? bvmVar2.ac(adqVar6.as) : null;
                                ?? r32 = i6;
                                i21 = i17;
                                z7 = z3;
                                adbVar8 = adbVar6;
                                iArr3 = iArr2;
                                boolean z18 = z16;
                                dlaVar2 = dlaVarAc;
                                ?? r42 = i12;
                                dlaVar5 = dlaVarAc3;
                                dlaVar3 = dlaVarAc2;
                                adbVar9 = adbVar4;
                                dlaVar6 = dlaVar;
                                adbVar7 = adbVar5;
                                dlaVar4 = dlaVarAc5;
                                zArr4 = zArr3;
                                bvmVar2 = bvmVar;
                                cf(bvmVar2, true, r32, r42, zArr3[0], dlaVarAc15, dlaVarAc14, iArr[0], z6, this.as, this.au, this.bi, i9, this.bl, iArr2[0], this.bn, z18, iArr[1] == 3, z7, z4, z1422, i21, i18, this.ae, this.af, this.ag, z1322);
                                r3 = r32;
                                r4 = r42;
                            }
                            if (z || (epsVar = this.o) == null) {
                                dlaVar7 = dlaVar5;
                                dlaVar8 = dlaVar6;
                                dlaVar9 = dlaVar4;
                                i22 = 0;
                                i23 = 8;
                                z8 = true;
                                i24 = 1;
                            } else {
                                alz alzVar3 = epsVar.r;
                                if (alzVar3.k && epsVar.s.k) {
                                    int i37 = alzVar3.h;
                                    dlaVar7 = dlaVar5;
                                    bvmVar2.v(dlaVar7, i37);
                                    dlaVar8 = dlaVar6;
                                    bvmVar2.v(dlaVar8, this.o.s.h);
                                    dlaVar9 = dlaVar4;
                                    bvmVar2.v(dlaVar9, this.o.a.h);
                                    adq adqVar7 = this.bd;
                                    if (adqVar7 == null || z4 || r4 == 0) {
                                        i22 = 0;
                                        i23 = 8;
                                        z9 = true;
                                    } else {
                                        z9 = true;
                                        z9 = true;
                                        if (zArr4[1]) {
                                            i22 = 0;
                                            i23 = 8;
                                            bvmVar2.x(bvmVar2.ac(adqVar7.av), dlaVar8, 0, 8);
                                        } else {
                                            i22 = 0;
                                            i23 = 8;
                                        }
                                    }
                                    i24 = i22;
                                    z8 = z9;
                                } else {
                                    dlaVar7 = dlaVar5;
                                    dlaVar8 = dlaVar6;
                                    dlaVar9 = dlaVar4;
                                    i22 = 0;
                                    i23 = 8;
                                    z8 = true;
                                    i24 = 1;
                                }
                            }
                            if (this.z == 2) {
                                i24 = i22;
                            }
                            if (i24 != 0 || this.v) {
                                dlaVar10 = dlaVar7;
                                dlaVar11 = dlaVar8;
                            } else {
                                int i38 = (iArr[z8 ? 1 : 0] == 2 && (this instanceof adr)) ? z8 ? 1 : 0 : i22;
                                int i39 = i38 != 0 ? i22 : i16;
                                adq adqVar8 = this.bd;
                                dla dlaVarAc16 = adqVar8 != null ? bvmVar2.ac(adqVar8.av) : null;
                                adq adqVar9 = this.bd;
                                dla dlaVarAc17 = adqVar9 != null ? bvmVar2.ac(adqVar9.at) : null;
                                int i40 = this.bk;
                                if (i40 > 0 || this.bq == i23) {
                                    r27 = z1322;
                                    adb adbVar17 = adbVar7;
                                    if (adbVar17.f != null) {
                                        bvmVar2.w(dlaVar9, dlaVar7, i40, i23);
                                        bvmVar2.w(dlaVar9, bvmVar2.ac(adbVar17.f), adbVar17.n(), i23);
                                        if (r4 != 0) {
                                            bvmVar2.x(dlaVarAc16, bvmVar2.ac(adbVar9), i22, 5);
                                        }
                                        r27 = i22;
                                    } else if (this.bq == i23) {
                                        bvmVar2.w(dlaVar9, dlaVar7, adbVar17.n(), i23);
                                        r27 = z1322;
                                    } else {
                                        bvmVar2.w(dlaVar9, dlaVar7, i40, i23);
                                        r27 = z1322;
                                    }
                                }
                                r27 = z1322;
                                boolean z19 = zArr4[z8 ? 1 : 0];
                                int i41 = i22;
                                int i42 = iArr[z8 ? 1 : 0];
                                int i43 = this.bj;
                                int i44 = this.bm;
                                int i45 = iArr3[z8 ? 1 : 0];
                                float f4 = this.bo;
                                int i46 = iArr[i41];
                                boolean z20 = z8 ? 1 : 0;
                                ?? r18 = z8;
                                if (i46 != 3) {
                                    r18 = i41;
                                }
                                dlaVar11 = dlaVar8;
                                dlaVar10 = dlaVar7;
                                bvmVar2 = bvmVar;
                                cf(bvmVar2, false, r4, r3, z19, dlaVarAc17, dlaVarAc16, i42, i38, this.at, this.av, i43, i39, i44, i45, f4, z17, r18, z4, z7, z1522, i18, i21, this.ah, this.ai, this.aj, r27);
                            }
                            if (z5) {
                                if (this.ak == 1) {
                                    float f222 = this.al;
                                    kw kwVarAd52 = bvmVar2.ad();
                                    kwVarAd52.d.q(dlaVar11, -1.0f);
                                    kwVarAd52.d.q(dlaVar10, 1.0f);
                                    kwVarAd52.d.q(dlaVar3, f222);
                                    kwVarAd52.d.q(dlaVar2, -f222);
                                    bvmVar2.u(kwVarAd52);
                                } else {
                                    float f322 = this.al;
                                    kw kwVarAd222 = bvmVar2.ad();
                                    kwVarAd222.d.q(dlaVar3, -1.0f);
                                    kwVarAd222.d.q(dlaVar2, 1.0f);
                                    kwVarAd222.d.q(dlaVar11, f322);
                                    kwVarAd222.d.q(dlaVar10, -f322);
                                    bvmVar2.u(kwVarAd222);
                                }
                            }
                            if (adbVar8.q()) {
                                adb adbVar1622 = adbVar8;
                                adq adqVar422 = adbVar1622.f.d;
                                float radians22 = (float) Math.toRadians(this.an + 90.0f);
                                int iN22 = adbVar1622.n();
                                dla dlaVarAc622 = bvmVar2.ac(ck(2));
                                dla dlaVarAc722 = bvmVar2.ac(ck(3));
                                dla dlaVarAc822 = bvmVar2.ac(ck(4));
                                dla dlaVarAc922 = bvmVar2.ac(ck(5));
                                dla dlaVarAc1022 = bvmVar2.ac(adqVar422.ck(2));
                                dla dlaVarAc1122 = bvmVar2.ac(adqVar422.ck(3));
                                dla dlaVarAc1222 = bvmVar2.ac(adqVar422.ck(4));
                                dla dlaVarAc1322 = bvmVar2.ac(adqVar422.ck(5));
                                kw kwVarAd322 = bvmVar2.ad();
                                double d32 = radians22;
                                double dSin22 = Math.sin(d32);
                                double d222 = iN22;
                                kwVarAd322.d.q(dlaVarAc1122, 0.5f);
                                kwVarAd322.d.q(dlaVarAc1322, 0.5f);
                                kwVarAd322.d.q(dlaVarAc722, -0.5f);
                                kwVarAd322.d.q(dlaVarAc922, -0.5f);
                                kwVarAd322.b = -((float) (dSin22 * d222));
                                bvmVar2.u(kwVarAd322);
                                kw kwVarAd422 = bvmVar2.ad();
                                float fCos22 = (float) (Math.cos(d32) * d222);
                                kwVarAd422.d.q(dlaVarAc1022, 0.5f);
                                kwVarAd422.d.q(dlaVarAc1222, 0.5f);
                                kwVarAd422.d.q(dlaVarAc622, -0.5f);
                                kwVarAd422.d.q(dlaVarAc822, -0.5f);
                                kwVarAd422.b = -fCos22;
                                bvmVar2.u(kwVarAd422);
                            }
                            this.u = false;
                            this.v = false;
                        }
                        i19 = -1;
                        if (z5) {
                        }
                        if (iArr[0] != 2) {
                        }
                        if (z6) {
                            i9 = 0;
                        }
                        adbVar6 = this.az;
                        boolean z13222 = !adbVar6.q();
                        char c222 = '\b';
                        boolean z14222 = zArr[0];
                        boolean z15222 = zArr[1];
                        i20 = this.y;
                        iArr2 = this.am;
                        if (i20 != 2) {
                            adbVar7 = adbVar5;
                            dlaVar2 = dlaVarAc;
                            dlaVar3 = dlaVarAc2;
                            adbVar8 = adbVar6;
                            iArr3 = iArr2;
                            dlaVar4 = dlaVarAc5;
                            z7 = z3;
                            r3 = i6;
                            r4 = i12;
                            dlaVar5 = dlaVarAc3;
                            adbVar9 = adbVar4;
                            dlaVar6 = dlaVar;
                            i21 = i17;
                            zArr4 = zArr3;
                        } else {
                            adbVar7 = adbVar5;
                            dlaVar2 = dlaVarAc;
                            dlaVar3 = dlaVarAc2;
                            adbVar8 = adbVar6;
                            iArr3 = iArr2;
                            dlaVar4 = dlaVarAc5;
                            z7 = z3;
                            r3 = i6;
                            r4 = i12;
                            dlaVar5 = dlaVarAc3;
                            adbVar9 = adbVar4;
                            dlaVar6 = dlaVar;
                            i21 = i17;
                            zArr4 = zArr3;
                        }
                        if (z) {
                            dlaVar7 = dlaVar5;
                            dlaVar8 = dlaVar6;
                            dlaVar9 = dlaVar4;
                            i22 = 0;
                            i23 = 8;
                            z8 = true;
                            i24 = 1;
                        } else {
                            dlaVar7 = dlaVar5;
                            dlaVar8 = dlaVar6;
                            dlaVar9 = dlaVar4;
                            i22 = 0;
                            i23 = 8;
                            z8 = true;
                            i24 = 1;
                        }
                        if (this.z == 2) {
                            i24 = i22;
                        }
                        if (i24 != 0) {
                            dlaVar10 = dlaVar7;
                            dlaVar11 = dlaVar8;
                        } else {
                            dlaVar10 = dlaVar7;
                            dlaVar11 = dlaVar8;
                        }
                        if (z5) {
                            if (this.ak == 1) {
                                float f2222 = this.al;
                                kw kwVarAd522 = bvmVar2.ad();
                                kwVarAd522.d.q(dlaVar11, -1.0f);
                                kwVarAd522.d.q(dlaVar10, 1.0f);
                                kwVarAd522.d.q(dlaVar3, f2222);
                                kwVarAd522.d.q(dlaVar2, -f2222);
                                bvmVar2.u(kwVarAd522);
                            } else {
                                float f3222 = this.al;
                                kw kwVarAd2222 = bvmVar2.ad();
                                kwVarAd2222.d.q(dlaVar3, -1.0f);
                                kwVarAd2222.d.q(dlaVar2, 1.0f);
                                kwVarAd2222.d.q(dlaVar11, f3222);
                                kwVarAd2222.d.q(dlaVar10, -f3222);
                                bvmVar2.u(kwVarAd2222);
                            }
                        }
                        if (adbVar8.q()) {
                            adb adbVar16222 = adbVar8;
                            adq adqVar4222 = adbVar16222.f.d;
                            float radians222 = (float) Math.toRadians(this.an + 90.0f);
                            int iN222 = adbVar16222.n();
                            dla dlaVarAc6222 = bvmVar2.ac(ck(2));
                            dla dlaVarAc7222 = bvmVar2.ac(ck(3));
                            dla dlaVarAc8222 = bvmVar2.ac(ck(4));
                            dla dlaVarAc9222 = bvmVar2.ac(ck(5));
                            dla dlaVarAc10222 = bvmVar2.ac(adqVar4222.ck(2));
                            dla dlaVarAc11222 = bvmVar2.ac(adqVar4222.ck(3));
                            dla dlaVarAc12222 = bvmVar2.ac(adqVar4222.ck(4));
                            dla dlaVarAc13222 = bvmVar2.ac(adqVar4222.ck(5));
                            kw kwVarAd3222 = bvmVar2.ad();
                            double d322 = radians222;
                            double dSin222 = Math.sin(d322);
                            double d2222 = iN222;
                            kwVarAd3222.d.q(dlaVarAc11222, 0.5f);
                            kwVarAd3222.d.q(dlaVarAc13222, 0.5f);
                            kwVarAd3222.d.q(dlaVarAc7222, -0.5f);
                            kwVarAd3222.d.q(dlaVarAc9222, -0.5f);
                            kwVarAd3222.b = -((float) (dSin222 * d2222));
                            bvmVar2.u(kwVarAd3222);
                            kw kwVarAd4222 = bvmVar2.ad();
                            float fCos222 = (float) (Math.cos(d322) * d2222);
                            kwVarAd4222.d.q(dlaVarAc10222, 0.5f);
                            kwVarAd4222.d.q(dlaVarAc12222, 0.5f);
                            kwVarAd4222.d.q(dlaVarAc6222, -0.5f);
                            kwVarAd4222.d.q(dlaVarAc8222, -0.5f);
                            kwVarAd4222.b = -fCos222;
                            bvmVar2.u(kwVarAd4222);
                        }
                        this.u = false;
                        this.v = false;
                    }
                    if (i34 == -1) {
                        if (z11 && !z12) {
                            this.ak = 0;
                        } else if (!z11 && z12) {
                            this.ak = 1;
                            if (i34 == -1) {
                                this.al = 1.0f / f;
                            }
                        }
                    }
                    if (this.ak == 0 && (!adbVar12.q() || !adbVar4.q())) {
                        this.ak = 1;
                    } else if (this.ak == 1 && (!adbVar2.q() || !adbVar15.q())) {
                        this.ak = 0;
                    }
                    if (this.ak == -1 && (!adbVar12.q() || !adbVar4.q() || !adbVar2.q() || !adbVar15.q())) {
                        if (adbVar12.q() && adbVar4.q()) {
                            this.ak = 0;
                        } else if (adbVar2.q() && adbVar15.q()) {
                            this.al = 1.0f / this.al;
                            this.ak = 1;
                        }
                    }
                    if (this.ak == -1) {
                        int i47 = this.ae;
                        if (i47 > 0 && this.ah == 0) {
                            this.ak = 0;
                        } else if (i47 == 0 && this.ah > 0) {
                            this.al = 1.0f / this.al;
                            this.ak = 1;
                        }
                    }
                    i17 = i35;
                    adbVar5 = adbVar;
                    i16 = i10;
                    z5 = true;
                    i18 = i26;
                    int[] iArr522 = this.ad;
                    iArr522[0] = i17;
                    iArr522[1] = i18;
                    if (z5) {
                        int i3622 = this.ak;
                        i19 = -1;
                        if (i3622 != 0) {
                        }
                        if (z5) {
                        }
                        if (iArr[0] != 2) {
                        }
                        if (z6) {
                            i9 = 0;
                        }
                        adbVar6 = this.az;
                        boolean z132222 = !adbVar6.q();
                        char c2222 = '\b';
                        boolean z142222 = zArr[0];
                        boolean z152222 = zArr[1];
                        i20 = this.y;
                        iArr2 = this.am;
                        if (i20 != 2) {
                            adbVar7 = adbVar5;
                            dlaVar2 = dlaVarAc;
                            dlaVar3 = dlaVarAc2;
                            adbVar8 = adbVar6;
                            iArr3 = iArr2;
                            dlaVar4 = dlaVarAc5;
                            z7 = z3;
                            r3 = i6;
                            r4 = i12;
                            dlaVar5 = dlaVarAc3;
                            adbVar9 = adbVar4;
                            dlaVar6 = dlaVar;
                            i21 = i17;
                            zArr4 = zArr3;
                        } else {
                            adbVar7 = adbVar5;
                            dlaVar2 = dlaVarAc;
                            dlaVar3 = dlaVarAc2;
                            adbVar8 = adbVar6;
                            iArr3 = iArr2;
                            dlaVar4 = dlaVarAc5;
                            z7 = z3;
                            r3 = i6;
                            r4 = i12;
                            dlaVar5 = dlaVarAc3;
                            adbVar9 = adbVar4;
                            dlaVar6 = dlaVar;
                            i21 = i17;
                            zArr4 = zArr3;
                        }
                        if (z) {
                            dlaVar7 = dlaVar5;
                            dlaVar8 = dlaVar6;
                            dlaVar9 = dlaVar4;
                            i22 = 0;
                            i23 = 8;
                            z8 = true;
                            i24 = 1;
                        } else {
                            dlaVar7 = dlaVar5;
                            dlaVar8 = dlaVar6;
                            dlaVar9 = dlaVar4;
                            i22 = 0;
                            i23 = 8;
                            z8 = true;
                            i24 = 1;
                        }
                        if (this.z == 2) {
                            i24 = i22;
                        }
                        if (i24 != 0) {
                            dlaVar10 = dlaVar7;
                            dlaVar11 = dlaVar8;
                        } else {
                            dlaVar10 = dlaVar7;
                            dlaVar11 = dlaVar8;
                        }
                        if (z5) {
                            if (this.ak == 1) {
                                float f22222 = this.al;
                                kw kwVarAd5222 = bvmVar2.ad();
                                kwVarAd5222.d.q(dlaVar11, -1.0f);
                                kwVarAd5222.d.q(dlaVar10, 1.0f);
                                kwVarAd5222.d.q(dlaVar3, f22222);
                                kwVarAd5222.d.q(dlaVar2, -f22222);
                                bvmVar2.u(kwVarAd5222);
                            } else {
                                float f32222 = this.al;
                                kw kwVarAd22222 = bvmVar2.ad();
                                kwVarAd22222.d.q(dlaVar3, -1.0f);
                                kwVarAd22222.d.q(dlaVar2, 1.0f);
                                kwVarAd22222.d.q(dlaVar11, f32222);
                                kwVarAd22222.d.q(dlaVar10, -f32222);
                                bvmVar2.u(kwVarAd22222);
                            }
                        }
                        if (adbVar8.q()) {
                            adb adbVar162222 = adbVar8;
                            adq adqVar42222 = adbVar162222.f.d;
                            float radians2222 = (float) Math.toRadians(this.an + 90.0f);
                            int iN2222 = adbVar162222.n();
                            dla dlaVarAc62222 = bvmVar2.ac(ck(2));
                            dla dlaVarAc72222 = bvmVar2.ac(ck(3));
                            dla dlaVarAc82222 = bvmVar2.ac(ck(4));
                            dla dlaVarAc92222 = bvmVar2.ac(ck(5));
                            dla dlaVarAc102222 = bvmVar2.ac(adqVar42222.ck(2));
                            dla dlaVarAc112222 = bvmVar2.ac(adqVar42222.ck(3));
                            dla dlaVarAc122222 = bvmVar2.ac(adqVar42222.ck(4));
                            dla dlaVarAc132222 = bvmVar2.ac(adqVar42222.ck(5));
                            kw kwVarAd32222 = bvmVar2.ad();
                            double d3222 = radians2222;
                            double dSin2222 = Math.sin(d3222);
                            double d22222 = iN2222;
                            kwVarAd32222.d.q(dlaVarAc112222, 0.5f);
                            kwVarAd32222.d.q(dlaVarAc132222, 0.5f);
                            kwVarAd32222.d.q(dlaVarAc72222, -0.5f);
                            kwVarAd32222.d.q(dlaVarAc92222, -0.5f);
                            kwVarAd32222.b = -((float) (dSin2222 * d22222));
                            bvmVar2.u(kwVarAd32222);
                            kw kwVarAd42222 = bvmVar2.ad();
                            float fCos2222 = (float) (Math.cos(d3222) * d22222);
                            kwVarAd42222.d.q(dlaVarAc102222, 0.5f);
                            kwVarAd42222.d.q(dlaVarAc122222, 0.5f);
                            kwVarAd42222.d.q(dlaVarAc62222, -0.5f);
                            kwVarAd42222.d.q(dlaVarAc82222, -0.5f);
                            kwVarAd42222.b = -fCos2222;
                            bvmVar2.u(kwVarAd42222);
                        }
                        this.u = false;
                        this.v = false;
                    }
                    i19 = -1;
                    if (z5) {
                    }
                    if (iArr[0] != 2) {
                    }
                    if (z6) {
                        i9 = 0;
                    }
                    adbVar6 = this.az;
                    boolean z1322222 = !adbVar6.q();
                    char c22222 = '\b';
                    boolean z1422222 = zArr[0];
                    boolean z1522222 = zArr[1];
                    i20 = this.y;
                    iArr2 = this.am;
                    if (i20 != 2) {
                        adbVar7 = adbVar5;
                        dlaVar2 = dlaVarAc;
                        dlaVar3 = dlaVarAc2;
                        adbVar8 = adbVar6;
                        iArr3 = iArr2;
                        dlaVar4 = dlaVarAc5;
                        z7 = z3;
                        r3 = i6;
                        r4 = i12;
                        dlaVar5 = dlaVarAc3;
                        adbVar9 = adbVar4;
                        dlaVar6 = dlaVar;
                        i21 = i17;
                        zArr4 = zArr3;
                    } else {
                        adbVar7 = adbVar5;
                        dlaVar2 = dlaVarAc;
                        dlaVar3 = dlaVarAc2;
                        adbVar8 = adbVar6;
                        iArr3 = iArr2;
                        dlaVar4 = dlaVarAc5;
                        z7 = z3;
                        r3 = i6;
                        r4 = i12;
                        dlaVar5 = dlaVarAc3;
                        adbVar9 = adbVar4;
                        dlaVar6 = dlaVar;
                        i21 = i17;
                        zArr4 = zArr3;
                    }
                    if (z) {
                        dlaVar7 = dlaVar5;
                        dlaVar8 = dlaVar6;
                        dlaVar9 = dlaVar4;
                        i22 = 0;
                        i23 = 8;
                        z8 = true;
                        i24 = 1;
                    } else {
                        dlaVar7 = dlaVar5;
                        dlaVar8 = dlaVar6;
                        dlaVar9 = dlaVar4;
                        i22 = 0;
                        i23 = 8;
                        z8 = true;
                        i24 = 1;
                    }
                    if (this.z == 2) {
                        i24 = i22;
                    }
                    if (i24 != 0) {
                        dlaVar10 = dlaVar7;
                        dlaVar11 = dlaVar8;
                    } else {
                        dlaVar10 = dlaVar7;
                        dlaVar11 = dlaVar8;
                    }
                    if (z5) {
                        if (this.ak == 1) {
                            float f222222 = this.al;
                            kw kwVarAd52222 = bvmVar2.ad();
                            kwVarAd52222.d.q(dlaVar11, -1.0f);
                            kwVarAd52222.d.q(dlaVar10, 1.0f);
                            kwVarAd52222.d.q(dlaVar3, f222222);
                            kwVarAd52222.d.q(dlaVar2, -f222222);
                            bvmVar2.u(kwVarAd52222);
                        } else {
                            float f322222 = this.al;
                            kw kwVarAd222222 = bvmVar2.ad();
                            kwVarAd222222.d.q(dlaVar3, -1.0f);
                            kwVarAd222222.d.q(dlaVar2, 1.0f);
                            kwVarAd222222.d.q(dlaVar11, f322222);
                            kwVarAd222222.d.q(dlaVar10, -f322222);
                            bvmVar2.u(kwVarAd222222);
                        }
                    }
                    if (adbVar8.q()) {
                        adb adbVar1622222 = adbVar8;
                        adq adqVar422222 = adbVar1622222.f.d;
                        float radians22222 = (float) Math.toRadians(this.an + 90.0f);
                        int iN22222 = adbVar1622222.n();
                        dla dlaVarAc622222 = bvmVar2.ac(ck(2));
                        dla dlaVarAc722222 = bvmVar2.ac(ck(3));
                        dla dlaVarAc822222 = bvmVar2.ac(ck(4));
                        dla dlaVarAc922222 = bvmVar2.ac(ck(5));
                        dla dlaVarAc1022222 = bvmVar2.ac(adqVar422222.ck(2));
                        dla dlaVarAc1122222 = bvmVar2.ac(adqVar422222.ck(3));
                        dla dlaVarAc1222222 = bvmVar2.ac(adqVar422222.ck(4));
                        dla dlaVarAc1322222 = bvmVar2.ac(adqVar422222.ck(5));
                        kw kwVarAd322222 = bvmVar2.ad();
                        double d32222 = radians22222;
                        double dSin22222 = Math.sin(d32222);
                        double d222222 = iN22222;
                        kwVarAd322222.d.q(dlaVarAc1122222, 0.5f);
                        kwVarAd322222.d.q(dlaVarAc1322222, 0.5f);
                        kwVarAd322222.d.q(dlaVarAc722222, -0.5f);
                        kwVarAd322222.d.q(dlaVarAc922222, -0.5f);
                        kwVarAd322222.b = -((float) (dSin22222 * d222222));
                        bvmVar2.u(kwVarAd322222);
                        kw kwVarAd422222 = bvmVar2.ad();
                        float fCos22222 = (float) (Math.cos(d32222) * d222222);
                        kwVarAd422222.d.q(dlaVarAc1022222, 0.5f);
                        kwVarAd422222.d.q(dlaVarAc1222222, 0.5f);
                        kwVarAd422222.d.q(dlaVarAc622222, -0.5f);
                        kwVarAd422222.d.q(dlaVarAc822222, -0.5f);
                        kwVarAd422222.b = -fCos22222;
                        bvmVar2.u(kwVarAd422222);
                    }
                    this.u = false;
                    this.v = false;
                }
                z5 = false;
                int[] iArr5222 = this.ad;
                iArr5222[0] = i17;
                iArr5222[1] = i18;
                if (z5) {
                    int i36222 = this.ak;
                    i19 = -1;
                    if (i36222 != 0) {
                    }
                    if (z5) {
                    }
                    if (iArr[0] != 2) {
                    }
                    if (z6) {
                        i9 = 0;
                    }
                    adbVar6 = this.az;
                    boolean z13222222 = !adbVar6.q();
                    char c222222 = '\b';
                    boolean z14222222 = zArr[0];
                    boolean z15222222 = zArr[1];
                    i20 = this.y;
                    iArr2 = this.am;
                    if (i20 != 2) {
                        adbVar7 = adbVar5;
                        dlaVar2 = dlaVarAc;
                        dlaVar3 = dlaVarAc2;
                        adbVar8 = adbVar6;
                        iArr3 = iArr2;
                        dlaVar4 = dlaVarAc5;
                        z7 = z3;
                        r3 = i6;
                        r4 = i12;
                        dlaVar5 = dlaVarAc3;
                        adbVar9 = adbVar4;
                        dlaVar6 = dlaVar;
                        i21 = i17;
                        zArr4 = zArr3;
                    } else {
                        adbVar7 = adbVar5;
                        dlaVar2 = dlaVarAc;
                        dlaVar3 = dlaVarAc2;
                        adbVar8 = adbVar6;
                        iArr3 = iArr2;
                        dlaVar4 = dlaVarAc5;
                        z7 = z3;
                        r3 = i6;
                        r4 = i12;
                        dlaVar5 = dlaVarAc3;
                        adbVar9 = adbVar4;
                        dlaVar6 = dlaVar;
                        i21 = i17;
                        zArr4 = zArr3;
                    }
                    if (z) {
                        dlaVar7 = dlaVar5;
                        dlaVar8 = dlaVar6;
                        dlaVar9 = dlaVar4;
                        i22 = 0;
                        i23 = 8;
                        z8 = true;
                        i24 = 1;
                    } else {
                        dlaVar7 = dlaVar5;
                        dlaVar8 = dlaVar6;
                        dlaVar9 = dlaVar4;
                        i22 = 0;
                        i23 = 8;
                        z8 = true;
                        i24 = 1;
                    }
                    if (this.z == 2) {
                        i24 = i22;
                    }
                    if (i24 != 0) {
                        dlaVar10 = dlaVar7;
                        dlaVar11 = dlaVar8;
                    } else {
                        dlaVar10 = dlaVar7;
                        dlaVar11 = dlaVar8;
                    }
                    if (z5) {
                        if (this.ak == 1) {
                            float f2222222 = this.al;
                            kw kwVarAd522222 = bvmVar2.ad();
                            kwVarAd522222.d.q(dlaVar11, -1.0f);
                            kwVarAd522222.d.q(dlaVar10, 1.0f);
                            kwVarAd522222.d.q(dlaVar3, f2222222);
                            kwVarAd522222.d.q(dlaVar2, -f2222222);
                            bvmVar2.u(kwVarAd522222);
                        } else {
                            float f3222222 = this.al;
                            kw kwVarAd2222222 = bvmVar2.ad();
                            kwVarAd2222222.d.q(dlaVar3, -1.0f);
                            kwVarAd2222222.d.q(dlaVar2, 1.0f);
                            kwVarAd2222222.d.q(dlaVar11, f3222222);
                            kwVarAd2222222.d.q(dlaVar10, -f3222222);
                            bvmVar2.u(kwVarAd2222222);
                        }
                    }
                    if (adbVar8.q()) {
                        adb adbVar16222222 = adbVar8;
                        adq adqVar4222222 = adbVar16222222.f.d;
                        float radians222222 = (float) Math.toRadians(this.an + 90.0f);
                        int iN222222 = adbVar16222222.n();
                        dla dlaVarAc6222222 = bvmVar2.ac(ck(2));
                        dla dlaVarAc7222222 = bvmVar2.ac(ck(3));
                        dla dlaVarAc8222222 = bvmVar2.ac(ck(4));
                        dla dlaVarAc9222222 = bvmVar2.ac(ck(5));
                        dla dlaVarAc10222222 = bvmVar2.ac(adqVar4222222.ck(2));
                        dla dlaVarAc11222222 = bvmVar2.ac(adqVar4222222.ck(3));
                        dla dlaVarAc12222222 = bvmVar2.ac(adqVar4222222.ck(4));
                        dla dlaVarAc13222222 = bvmVar2.ac(adqVar4222222.ck(5));
                        kw kwVarAd3222222 = bvmVar2.ad();
                        double d322222 = radians222222;
                        double dSin222222 = Math.sin(d322222);
                        double d2222222 = iN222222;
                        kwVarAd3222222.d.q(dlaVarAc11222222, 0.5f);
                        kwVarAd3222222.d.q(dlaVarAc13222222, 0.5f);
                        kwVarAd3222222.d.q(dlaVarAc7222222, -0.5f);
                        kwVarAd3222222.d.q(dlaVarAc9222222, -0.5f);
                        kwVarAd3222222.b = -((float) (dSin222222 * d2222222));
                        bvmVar2.u(kwVarAd3222222);
                        kw kwVarAd4222222 = bvmVar2.ad();
                        float fCos222222 = (float) (Math.cos(d322222) * d2222222);
                        kwVarAd4222222.d.q(dlaVarAc10222222, 0.5f);
                        kwVarAd4222222.d.q(dlaVarAc12222222, 0.5f);
                        kwVarAd4222222.d.q(dlaVarAc6222222, -0.5f);
                        kwVarAd4222222.d.q(dlaVarAc8222222, -0.5f);
                        kwVarAd4222222.b = -fCos222222;
                        bvmVar2.u(kwVarAd4222222);
                    }
                    this.u = false;
                    this.v = false;
                }
                i19 = -1;
                if (z5) {
                }
                if (iArr[0] != 2) {
                }
                if (z6) {
                    i9 = 0;
                }
                adbVar6 = this.az;
                boolean z132222222 = !adbVar6.q();
                char c2222222 = '\b';
                boolean z142222222 = zArr[0];
                boolean z152222222 = zArr[1];
                i20 = this.y;
                iArr2 = this.am;
                if (i20 != 2) {
                    adbVar7 = adbVar5;
                    dlaVar2 = dlaVarAc;
                    dlaVar3 = dlaVarAc2;
                    adbVar8 = adbVar6;
                    iArr3 = iArr2;
                    dlaVar4 = dlaVarAc5;
                    z7 = z3;
                    r3 = i6;
                    r4 = i12;
                    dlaVar5 = dlaVarAc3;
                    adbVar9 = adbVar4;
                    dlaVar6 = dlaVar;
                    i21 = i17;
                    zArr4 = zArr3;
                } else {
                    adbVar7 = adbVar5;
                    dlaVar2 = dlaVarAc;
                    dlaVar3 = dlaVarAc2;
                    adbVar8 = adbVar6;
                    iArr3 = iArr2;
                    dlaVar4 = dlaVarAc5;
                    z7 = z3;
                    r3 = i6;
                    r4 = i12;
                    dlaVar5 = dlaVarAc3;
                    adbVar9 = adbVar4;
                    dlaVar6 = dlaVar;
                    i21 = i17;
                    zArr4 = zArr3;
                }
                if (z) {
                    dlaVar7 = dlaVar5;
                    dlaVar8 = dlaVar6;
                    dlaVar9 = dlaVar4;
                    i22 = 0;
                    i23 = 8;
                    z8 = true;
                    i24 = 1;
                } else {
                    dlaVar7 = dlaVar5;
                    dlaVar8 = dlaVar6;
                    dlaVar9 = dlaVar4;
                    i22 = 0;
                    i23 = 8;
                    z8 = true;
                    i24 = 1;
                }
                if (this.z == 2) {
                    i24 = i22;
                }
                if (i24 != 0) {
                    dlaVar10 = dlaVar7;
                    dlaVar11 = dlaVar8;
                } else {
                    dlaVar10 = dlaVar7;
                    dlaVar11 = dlaVar8;
                }
                if (z5) {
                    if (this.ak == 1) {
                        float f22222222 = this.al;
                        kw kwVarAd5222222 = bvmVar2.ad();
                        kwVarAd5222222.d.q(dlaVar11, -1.0f);
                        kwVarAd5222222.d.q(dlaVar10, 1.0f);
                        kwVarAd5222222.d.q(dlaVar3, f22222222);
                        kwVarAd5222222.d.q(dlaVar2, -f22222222);
                        bvmVar2.u(kwVarAd5222222);
                    } else {
                        float f32222222 = this.al;
                        kw kwVarAd22222222 = bvmVar2.ad();
                        kwVarAd22222222.d.q(dlaVar3, -1.0f);
                        kwVarAd22222222.d.q(dlaVar2, 1.0f);
                        kwVarAd22222222.d.q(dlaVar11, f32222222);
                        kwVarAd22222222.d.q(dlaVar10, -f32222222);
                        bvmVar2.u(kwVarAd22222222);
                    }
                }
                if (adbVar8.q()) {
                    adb adbVar162222222 = adbVar8;
                    adq adqVar42222222 = adbVar162222222.f.d;
                    float radians2222222 = (float) Math.toRadians(this.an + 90.0f);
                    int iN2222222 = adbVar162222222.n();
                    dla dlaVarAc62222222 = bvmVar2.ac(ck(2));
                    dla dlaVarAc72222222 = bvmVar2.ac(ck(3));
                    dla dlaVarAc82222222 = bvmVar2.ac(ck(4));
                    dla dlaVarAc92222222 = bvmVar2.ac(ck(5));
                    dla dlaVarAc102222222 = bvmVar2.ac(adqVar42222222.ck(2));
                    dla dlaVarAc112222222 = bvmVar2.ac(adqVar42222222.ck(3));
                    dla dlaVarAc122222222 = bvmVar2.ac(adqVar42222222.ck(4));
                    dla dlaVarAc132222222 = bvmVar2.ac(adqVar42222222.ck(5));
                    kw kwVarAd32222222 = bvmVar2.ad();
                    double d3222222 = radians2222222;
                    double dSin2222222 = Math.sin(d3222222);
                    double d22222222 = iN2222222;
                    kwVarAd32222222.d.q(dlaVarAc112222222, 0.5f);
                    kwVarAd32222222.d.q(dlaVarAc132222222, 0.5f);
                    kwVarAd32222222.d.q(dlaVarAc72222222, -0.5f);
                    kwVarAd32222222.d.q(dlaVarAc92222222, -0.5f);
                    kwVarAd32222222.b = -((float) (dSin2222222 * d22222222));
                    bvmVar2.u(kwVarAd32222222);
                    kw kwVarAd42222222 = bvmVar2.ad();
                    float fCos2222222 = (float) (Math.cos(d3222222) * d22222222);
                    kwVarAd42222222.d.q(dlaVarAc102222222, 0.5f);
                    kwVarAd42222222.d.q(dlaVarAc122222222, 0.5f);
                    kwVarAd42222222.d.q(dlaVarAc62222222, -0.5f);
                    kwVarAd42222222.d.q(dlaVarAc82222222, -0.5f);
                    kwVarAd42222222.b = -fCos2222222;
                    bvmVar2.u(kwVarAd42222222);
                }
                this.u = false;
                this.v = false;
            }
            adbVar4 = adbVar13;
            dlaVar = dlaVarAc4;
            adbVar5 = adbVar;
            i16 = i10;
            i17 = i14;
            i18 = i15;
            z5 = false;
            int[] iArr52222 = this.ad;
            iArr52222[0] = i17;
            iArr52222[1] = i18;
            if (z5) {
                int i362222 = this.ak;
                i19 = -1;
                if (i362222 != 0) {
                }
                if (z5) {
                }
                if (iArr[0] != 2) {
                }
                if (z6) {
                    i9 = 0;
                }
                adbVar6 = this.az;
                boolean z1322222222 = !adbVar6.q();
                char c22222222 = '\b';
                boolean z1422222222 = zArr[0];
                boolean z1522222222 = zArr[1];
                i20 = this.y;
                iArr2 = this.am;
                if (i20 != 2) {
                    adbVar7 = adbVar5;
                    dlaVar2 = dlaVarAc;
                    dlaVar3 = dlaVarAc2;
                    adbVar8 = adbVar6;
                    iArr3 = iArr2;
                    dlaVar4 = dlaVarAc5;
                    z7 = z3;
                    r3 = i6;
                    r4 = i12;
                    dlaVar5 = dlaVarAc3;
                    adbVar9 = adbVar4;
                    dlaVar6 = dlaVar;
                    i21 = i17;
                    zArr4 = zArr3;
                } else {
                    adbVar7 = adbVar5;
                    dlaVar2 = dlaVarAc;
                    dlaVar3 = dlaVarAc2;
                    adbVar8 = adbVar6;
                    iArr3 = iArr2;
                    dlaVar4 = dlaVarAc5;
                    z7 = z3;
                    r3 = i6;
                    r4 = i12;
                    dlaVar5 = dlaVarAc3;
                    adbVar9 = adbVar4;
                    dlaVar6 = dlaVar;
                    i21 = i17;
                    zArr4 = zArr3;
                }
                if (z) {
                    dlaVar7 = dlaVar5;
                    dlaVar8 = dlaVar6;
                    dlaVar9 = dlaVar4;
                    i22 = 0;
                    i23 = 8;
                    z8 = true;
                    i24 = 1;
                } else {
                    dlaVar7 = dlaVar5;
                    dlaVar8 = dlaVar6;
                    dlaVar9 = dlaVar4;
                    i22 = 0;
                    i23 = 8;
                    z8 = true;
                    i24 = 1;
                }
                if (this.z == 2) {
                    i24 = i22;
                }
                if (i24 != 0) {
                    dlaVar10 = dlaVar7;
                    dlaVar11 = dlaVar8;
                } else {
                    dlaVar10 = dlaVar7;
                    dlaVar11 = dlaVar8;
                }
                if (z5) {
                    if (this.ak == 1) {
                        float f222222222 = this.al;
                        kw kwVarAd52222222 = bvmVar2.ad();
                        kwVarAd52222222.d.q(dlaVar11, -1.0f);
                        kwVarAd52222222.d.q(dlaVar10, 1.0f);
                        kwVarAd52222222.d.q(dlaVar3, f222222222);
                        kwVarAd52222222.d.q(dlaVar2, -f222222222);
                        bvmVar2.u(kwVarAd52222222);
                    } else {
                        float f322222222 = this.al;
                        kw kwVarAd222222222 = bvmVar2.ad();
                        kwVarAd222222222.d.q(dlaVar3, -1.0f);
                        kwVarAd222222222.d.q(dlaVar2, 1.0f);
                        kwVarAd222222222.d.q(dlaVar11, f322222222);
                        kwVarAd222222222.d.q(dlaVar10, -f322222222);
                        bvmVar2.u(kwVarAd222222222);
                    }
                }
                if (adbVar8.q()) {
                    adb adbVar1622222222 = adbVar8;
                    adq adqVar422222222 = adbVar1622222222.f.d;
                    float radians22222222 = (float) Math.toRadians(this.an + 90.0f);
                    int iN22222222 = adbVar1622222222.n();
                    dla dlaVarAc622222222 = bvmVar2.ac(ck(2));
                    dla dlaVarAc722222222 = bvmVar2.ac(ck(3));
                    dla dlaVarAc822222222 = bvmVar2.ac(ck(4));
                    dla dlaVarAc922222222 = bvmVar2.ac(ck(5));
                    dla dlaVarAc1022222222 = bvmVar2.ac(adqVar422222222.ck(2));
                    dla dlaVarAc1122222222 = bvmVar2.ac(adqVar422222222.ck(3));
                    dla dlaVarAc1222222222 = bvmVar2.ac(adqVar422222222.ck(4));
                    dla dlaVarAc1322222222 = bvmVar2.ac(adqVar422222222.ck(5));
                    kw kwVarAd322222222 = bvmVar2.ad();
                    double d32222222 = radians22222222;
                    double dSin22222222 = Math.sin(d32222222);
                    double d222222222 = iN22222222;
                    kwVarAd322222222.d.q(dlaVarAc1122222222, 0.5f);
                    kwVarAd322222222.d.q(dlaVarAc1322222222, 0.5f);
                    kwVarAd322222222.d.q(dlaVarAc722222222, -0.5f);
                    kwVarAd322222222.d.q(dlaVarAc922222222, -0.5f);
                    kwVarAd322222222.b = -((float) (dSin22222222 * d222222222));
                    bvmVar2.u(kwVarAd322222222);
                    kw kwVarAd422222222 = bvmVar2.ad();
                    float fCos22222222 = (float) (Math.cos(d32222222) * d222222222);
                    kwVarAd422222222.d.q(dlaVarAc1022222222, 0.5f);
                    kwVarAd422222222.d.q(dlaVarAc1222222222, 0.5f);
                    kwVarAd422222222.d.q(dlaVarAc622222222, -0.5f);
                    kwVarAd422222222.d.q(dlaVarAc822222222, -0.5f);
                    kwVarAd422222222.b = -fCos22222222;
                    bvmVar2.u(kwVarAd422222222);
                }
                this.u = false;
                this.v = false;
            }
            i19 = -1;
            if (z5) {
            }
            if (iArr[0] != 2) {
            }
            if (z6) {
                i9 = 0;
            }
            adbVar6 = this.az;
            boolean z13222222222 = !adbVar6.q();
            char c222222222 = '\b';
            boolean z14222222222 = zArr[0];
            boolean z15222222222 = zArr[1];
            i20 = this.y;
            iArr2 = this.am;
            if (i20 != 2) {
                adbVar7 = adbVar5;
                dlaVar2 = dlaVarAc;
                dlaVar3 = dlaVarAc2;
                adbVar8 = adbVar6;
                iArr3 = iArr2;
                dlaVar4 = dlaVarAc5;
                z7 = z3;
                r3 = i6;
                r4 = i12;
                dlaVar5 = dlaVarAc3;
                adbVar9 = adbVar4;
                dlaVar6 = dlaVar;
                i21 = i17;
                zArr4 = zArr3;
            } else {
                adbVar7 = adbVar5;
                dlaVar2 = dlaVarAc;
                dlaVar3 = dlaVarAc2;
                adbVar8 = adbVar6;
                iArr3 = iArr2;
                dlaVar4 = dlaVarAc5;
                z7 = z3;
                r3 = i6;
                r4 = i12;
                dlaVar5 = dlaVarAc3;
                adbVar9 = adbVar4;
                dlaVar6 = dlaVar;
                i21 = i17;
                zArr4 = zArr3;
            }
            if (z) {
                dlaVar7 = dlaVar5;
                dlaVar8 = dlaVar6;
                dlaVar9 = dlaVar4;
                i22 = 0;
                i23 = 8;
                z8 = true;
                i24 = 1;
            } else {
                dlaVar7 = dlaVar5;
                dlaVar8 = dlaVar6;
                dlaVar9 = dlaVar4;
                i22 = 0;
                i23 = 8;
                z8 = true;
                i24 = 1;
            }
            if (this.z == 2) {
                i24 = i22;
            }
            if (i24 != 0) {
                dlaVar10 = dlaVar7;
                dlaVar11 = dlaVar8;
            } else {
                dlaVar10 = dlaVar7;
                dlaVar11 = dlaVar8;
            }
            if (z5) {
                if (this.ak == 1) {
                    float f2222222222 = this.al;
                    kw kwVarAd522222222 = bvmVar2.ad();
                    kwVarAd522222222.d.q(dlaVar11, -1.0f);
                    kwVarAd522222222.d.q(dlaVar10, 1.0f);
                    kwVarAd522222222.d.q(dlaVar3, f2222222222);
                    kwVarAd522222222.d.q(dlaVar2, -f2222222222);
                    bvmVar2.u(kwVarAd522222222);
                } else {
                    float f3222222222 = this.al;
                    kw kwVarAd2222222222 = bvmVar2.ad();
                    kwVarAd2222222222.d.q(dlaVar3, -1.0f);
                    kwVarAd2222222222.d.q(dlaVar2, 1.0f);
                    kwVarAd2222222222.d.q(dlaVar11, f3222222222);
                    kwVarAd2222222222.d.q(dlaVar10, -f3222222222);
                    bvmVar2.u(kwVarAd2222222222);
                }
            }
            if (adbVar8.q()) {
                adb adbVar16222222222 = adbVar8;
                adq adqVar4222222222 = adbVar16222222222.f.d;
                float radians222222222 = (float) Math.toRadians(this.an + 90.0f);
                int iN222222222 = adbVar16222222222.n();
                dla dlaVarAc6222222222 = bvmVar2.ac(ck(2));
                dla dlaVarAc7222222222 = bvmVar2.ac(ck(3));
                dla dlaVarAc8222222222 = bvmVar2.ac(ck(4));
                dla dlaVarAc9222222222 = bvmVar2.ac(ck(5));
                dla dlaVarAc10222222222 = bvmVar2.ac(adqVar4222222222.ck(2));
                dla dlaVarAc11222222222 = bvmVar2.ac(adqVar4222222222.ck(3));
                dla dlaVarAc12222222222 = bvmVar2.ac(adqVar4222222222.ck(4));
                dla dlaVarAc13222222222 = bvmVar2.ac(adqVar4222222222.ck(5));
                kw kwVarAd3222222222 = bvmVar2.ad();
                double d322222222 = radians222222222;
                double dSin222222222 = Math.sin(d322222222);
                double d2222222222 = iN222222222;
                kwVarAd3222222222.d.q(dlaVarAc11222222222, 0.5f);
                kwVarAd3222222222.d.q(dlaVarAc13222222222, 0.5f);
                kwVarAd3222222222.d.q(dlaVarAc7222222222, -0.5f);
                kwVarAd3222222222.d.q(dlaVarAc9222222222, -0.5f);
                kwVarAd3222222222.b = -((float) (dSin222222222 * d2222222222));
                bvmVar2.u(kwVarAd3222222222);
                kw kwVarAd4222222222 = bvmVar2.ad();
                float fCos222222222 = (float) (Math.cos(d322222222) * d2222222222);
                kwVarAd4222222222.d.q(dlaVarAc10222222222, 0.5f);
                kwVarAd4222222222.d.q(dlaVarAc12222222222, 0.5f);
                kwVarAd4222222222.d.q(dlaVarAc6222222222, -0.5f);
                kwVarAd4222222222.d.q(dlaVarAc8222222222, -0.5f);
                kwVarAd4222222222.b = -fCos222222222;
                bvmVar2.u(kwVarAd4222222222);
            }
            this.u = false;
            this.v = false;
        }
        i = 0;
        i2 = i;
        i3 = i2;
        i4 = this.bq;
        zArr = this.bc;
        i5 = i2;
        if (i4 == 8) {
            arrayList = this.bb;
            size = arrayList.size();
            i6 = i3;
            i28 = i;
            while (true) {
                if (i28 < size) {
                    if (!zArr[i]) {
                        break;
                    } else {
                        return;
                    }
                }
                int i312 = size;
                hashSet2 = ((adb) arrayList.get(i28)).a;
                if (hashSet2 != null) {
                    break;
                    break;
                }
                i28++;
                size = i312;
            }
        } else {
            i6 = i3;
        }
        z2 = this.u;
        if (z2) {
            if (z2) {
                bvmVar2.v(dlaVarAc, this.bi);
                bvmVar2.v(dlaVarAc2, this.bi + this.be);
                if (i6 != 0) {
                    adrVar2 = (adr) adqVar2;
                    weakReference3 = adrVar2.dy;
                    if (weakReference3 != null) {
                        adrVar2.dy = new WeakReference(adbVar10);
                    } else {
                        adrVar2.dy = new WeakReference(adbVar10);
                    }
                    weakReference4 = adrVar2.ea;
                    if (weakReference4 != null) {
                        adrVar2.ea = new WeakReference(adbVar11);
                    } else {
                        adrVar2.ea = new WeakReference(adbVar11);
                    }
                }
            }
            if (this.v) {
                bvmVar2.v(dlaVarAc3, this.bj);
                bvmVar2.v(dlaVarAc4, this.bj + this.bf);
                hashSet = adbVar14.a;
                if (hashSet != null) {
                    bvmVar2.v(dlaVarAc5, this.bj + this.bk);
                }
                if (i5 != 0) {
                    adrVar = (adr) adqVar;
                    weakReference = adrVar.dx;
                    if (weakReference != null) {
                        adrVar.dx = new WeakReference(adbVar12);
                    } else {
                        adrVar.dx = new WeakReference(adbVar12);
                    }
                    weakReference2 = adrVar.dz;
                    if (weakReference2 != null) {
                        adrVar.dz = new WeakReference(adbVar13);
                    } else {
                        adrVar.dz = new WeakReference(adbVar13);
                    }
                }
            }
            if (this.u) {
                ?? r122 = i;
                this.u = r122;
                this.v = r122;
                return;
            }
        } else {
            if (z2) {
                bvmVar2.v(dlaVarAc, this.bi);
                bvmVar2.v(dlaVarAc2, this.bi + this.be);
                if (i6 != 0) {
                    adrVar2 = (adr) adqVar2;
                    weakReference3 = adrVar2.dy;
                    if (weakReference3 != null) {
                        adrVar2.dy = new WeakReference(adbVar10);
                    } else {
                        adrVar2.dy = new WeakReference(adbVar10);
                    }
                    weakReference4 = adrVar2.ea;
                    if (weakReference4 != null) {
                        adrVar2.ea = new WeakReference(adbVar11);
                    } else {
                        adrVar2.ea = new WeakReference(adbVar11);
                    }
                }
            }
            if (this.v) {
                bvmVar2.v(dlaVarAc3, this.bj);
                bvmVar2.v(dlaVarAc4, this.bj + this.bf);
                hashSet = adbVar14.a;
                if (hashSet != null) {
                    bvmVar2.v(dlaVarAc5, this.bj + this.bk);
                }
                if (i5 != 0) {
                    adrVar = (adr) adqVar;
                    weakReference = adrVar.dx;
                    if (weakReference != null) {
                        adrVar.dx = new WeakReference(adbVar12);
                    } else {
                        adrVar.dx = new WeakReference(adbVar12);
                    }
                    weakReference2 = adrVar.dz;
                    if (weakReference2 != null) {
                        adrVar.dz = new WeakReference(adbVar13);
                    } else {
                        adrVar.dz = new WeakReference(adbVar13);
                    }
                }
            }
            if (this.u) {
                ?? r1222 = i;
                this.u = r1222;
                this.v = r1222;
                return;
            }
        }
        zArr2 = this.p;
        if (z) {
            adbVar = adbVar14;
            zArr3 = zArr2;
        } else {
            adbVar = adbVar14;
            zArr3 = zArr2;
        }
        if (this.bd != null) {
            if (cw(0)) {
                ((adr) this.bd).ee(this, 0);
                zCx = true;
                i27 = 1;
            } else {
                zCx = cx();
                i27 = 1;
            }
            if (cw(i27)) {
                ((adr) this.bd).ee(this, i27);
                zCy = true;
            } else {
                zCy = cy();
            }
            adbVar2 = zCx ? adbVar10 : adbVar10;
            if (!zCy) {
                bvmVar2.x(bvmVar2.ac(this.bd.av), dlaVarAc4, 0, 1);
            }
            adbVar3 = adbVar11;
            i7 = i5;
            z4 = zCy;
            z3 = zCx;
        } else {
            adbVar2 = adbVar10;
            adbVar3 = adbVar11;
            i7 = i5;
            z3 = false;
            z4 = false;
        }
        i8 = this.be;
        i9 = this.bl;
        if (i8 >= i9) {
            i9 = i8;
        }
        int i322 = this.bf;
        adb adbVar152 = adbVar3;
        int i332 = this.bm;
        if (i322 < i332) {
        }
        iArr = this.bz;
        i11 = iArr[0];
        i12 = i7;
        if (i11 != 3) {
        }
        i13 = iArr[1];
        if (i13 != 3) {
        }
        int i342 = this.bh;
        this.ak = i342;
        f = this.bg;
        this.al = f;
        i14 = this.ab;
        i15 = this.ac;
        if (f > 0.0f) {
            adbVar4 = adbVar13;
            if (this.bq != 8) {
                if (i11 == 3) {
                }
                if (i13 == 3) {
                    dlaVar = dlaVarAc4;
                    i26 = i15;
                } else {
                    dlaVar = dlaVarAc4;
                    i26 = i15;
                }
                if (i11 == 3) {
                    if (i11 != 3) {
                        if (i13 != 3) {
                            i17 = i35;
                            adbVar5 = adbVar;
                            i16 = i10;
                        } else {
                            i17 = i35;
                            adbVar5 = adbVar;
                            i16 = i10;
                        }
                        z5 = true;
                    } else {
                        if (i13 != 3) {
                            i17 = i35;
                            adbVar5 = adbVar;
                            i16 = i10;
                        } else {
                            i17 = i35;
                            adbVar5 = adbVar;
                            i16 = i10;
                        }
                        z5 = true;
                    }
                } else if (i11 != 3) {
                    if (i13 != 3) {
                        i17 = i35;
                        adbVar5 = adbVar;
                        i16 = i10;
                    } else {
                        i17 = i35;
                        adbVar5 = adbVar;
                        i16 = i10;
                    }
                    z5 = true;
                } else {
                    if (i13 != 3) {
                        i17 = i35;
                        adbVar5 = adbVar;
                        i16 = i10;
                    } else {
                        i17 = i35;
                        adbVar5 = adbVar;
                        i16 = i10;
                    }
                    z5 = true;
                }
                i18 = i26;
                int[] iArr522222 = this.ad;
                iArr522222[0] = i17;
                iArr522222[1] = i18;
                if (z5) {
                    int i3622222 = this.ak;
                    i19 = -1;
                    if (i3622222 != 0) {
                    }
                    if (z5) {
                    }
                    if (iArr[0] != 2) {
                    }
                    if (z6) {
                        i9 = 0;
                    }
                    adbVar6 = this.az;
                    boolean z132222222222 = !adbVar6.q();
                    char c2222222222 = '\b';
                    boolean z142222222222 = zArr[0];
                    boolean z152222222222 = zArr[1];
                    i20 = this.y;
                    iArr2 = this.am;
                    if (i20 != 2) {
                        adbVar7 = adbVar5;
                        dlaVar2 = dlaVarAc;
                        dlaVar3 = dlaVarAc2;
                        adbVar8 = adbVar6;
                        iArr3 = iArr2;
                        dlaVar4 = dlaVarAc5;
                        z7 = z3;
                        r3 = i6;
                        r4 = i12;
                        dlaVar5 = dlaVarAc3;
                        adbVar9 = adbVar4;
                        dlaVar6 = dlaVar;
                        i21 = i17;
                        zArr4 = zArr3;
                    } else {
                        adbVar7 = adbVar5;
                        dlaVar2 = dlaVarAc;
                        dlaVar3 = dlaVarAc2;
                        adbVar8 = adbVar6;
                        iArr3 = iArr2;
                        dlaVar4 = dlaVarAc5;
                        z7 = z3;
                        r3 = i6;
                        r4 = i12;
                        dlaVar5 = dlaVarAc3;
                        adbVar9 = adbVar4;
                        dlaVar6 = dlaVar;
                        i21 = i17;
                        zArr4 = zArr3;
                    }
                    if (z) {
                        dlaVar7 = dlaVar5;
                        dlaVar8 = dlaVar6;
                        dlaVar9 = dlaVar4;
                        i22 = 0;
                        i23 = 8;
                        z8 = true;
                        i24 = 1;
                    } else {
                        dlaVar7 = dlaVar5;
                        dlaVar8 = dlaVar6;
                        dlaVar9 = dlaVar4;
                        i22 = 0;
                        i23 = 8;
                        z8 = true;
                        i24 = 1;
                    }
                    if (this.z == 2) {
                        i24 = i22;
                    }
                    if (i24 != 0) {
                        dlaVar10 = dlaVar7;
                        dlaVar11 = dlaVar8;
                    } else {
                        dlaVar10 = dlaVar7;
                        dlaVar11 = dlaVar8;
                    }
                    if (z5) {
                        if (this.ak == 1) {
                            float f22222222222 = this.al;
                            kw kwVarAd5222222222 = bvmVar2.ad();
                            kwVarAd5222222222.d.q(dlaVar11, -1.0f);
                            kwVarAd5222222222.d.q(dlaVar10, 1.0f);
                            kwVarAd5222222222.d.q(dlaVar3, f22222222222);
                            kwVarAd5222222222.d.q(dlaVar2, -f22222222222);
                            bvmVar2.u(kwVarAd5222222222);
                        } else {
                            float f32222222222 = this.al;
                            kw kwVarAd22222222222 = bvmVar2.ad();
                            kwVarAd22222222222.d.q(dlaVar3, -1.0f);
                            kwVarAd22222222222.d.q(dlaVar2, 1.0f);
                            kwVarAd22222222222.d.q(dlaVar11, f32222222222);
                            kwVarAd22222222222.d.q(dlaVar10, -f32222222222);
                            bvmVar2.u(kwVarAd22222222222);
                        }
                    }
                    if (adbVar8.q()) {
                        adb adbVar162222222222 = adbVar8;
                        adq adqVar42222222222 = adbVar162222222222.f.d;
                        float radians2222222222 = (float) Math.toRadians(this.an + 90.0f);
                        int iN2222222222 = adbVar162222222222.n();
                        dla dlaVarAc62222222222 = bvmVar2.ac(ck(2));
                        dla dlaVarAc72222222222 = bvmVar2.ac(ck(3));
                        dla dlaVarAc82222222222 = bvmVar2.ac(ck(4));
                        dla dlaVarAc92222222222 = bvmVar2.ac(ck(5));
                        dla dlaVarAc102222222222 = bvmVar2.ac(adqVar42222222222.ck(2));
                        dla dlaVarAc112222222222 = bvmVar2.ac(adqVar42222222222.ck(3));
                        dla dlaVarAc122222222222 = bvmVar2.ac(adqVar42222222222.ck(4));
                        dla dlaVarAc132222222222 = bvmVar2.ac(adqVar42222222222.ck(5));
                        kw kwVarAd32222222222 = bvmVar2.ad();
                        double d3222222222 = radians2222222222;
                        double dSin2222222222 = Math.sin(d3222222222);
                        double d22222222222 = iN2222222222;
                        kwVarAd32222222222.d.q(dlaVarAc112222222222, 0.5f);
                        kwVarAd32222222222.d.q(dlaVarAc132222222222, 0.5f);
                        kwVarAd32222222222.d.q(dlaVarAc72222222222, -0.5f);
                        kwVarAd32222222222.d.q(dlaVarAc92222222222, -0.5f);
                        kwVarAd32222222222.b = -((float) (dSin2222222222 * d22222222222));
                        bvmVar2.u(kwVarAd32222222222);
                        kw kwVarAd42222222222 = bvmVar2.ad();
                        float fCos2222222222 = (float) (Math.cos(d3222222222) * d22222222222);
                        kwVarAd42222222222.d.q(dlaVarAc102222222222, 0.5f);
                        kwVarAd42222222222.d.q(dlaVarAc122222222222, 0.5f);
                        kwVarAd42222222222.d.q(dlaVarAc62222222222, -0.5f);
                        kwVarAd42222222222.d.q(dlaVarAc82222222222, -0.5f);
                        kwVarAd42222222222.b = -fCos2222222222;
                        bvmVar2.u(kwVarAd42222222222);
                    }
                    this.u = false;
                    this.v = false;
                }
                i19 = -1;
                if (z5) {
                }
                if (iArr[0] != 2) {
                }
                if (z6) {
                    i9 = 0;
                }
                adbVar6 = this.az;
                boolean z1322222222222 = !adbVar6.q();
                char c22222222222 = '\b';
                boolean z1422222222222 = zArr[0];
                boolean z1522222222222 = zArr[1];
                i20 = this.y;
                iArr2 = this.am;
                if (i20 != 2) {
                    adbVar7 = adbVar5;
                    dlaVar2 = dlaVarAc;
                    dlaVar3 = dlaVarAc2;
                    adbVar8 = adbVar6;
                    iArr3 = iArr2;
                    dlaVar4 = dlaVarAc5;
                    z7 = z3;
                    r3 = i6;
                    r4 = i12;
                    dlaVar5 = dlaVarAc3;
                    adbVar9 = adbVar4;
                    dlaVar6 = dlaVar;
                    i21 = i17;
                    zArr4 = zArr3;
                } else {
                    adbVar7 = adbVar5;
                    dlaVar2 = dlaVarAc;
                    dlaVar3 = dlaVarAc2;
                    adbVar8 = adbVar6;
                    iArr3 = iArr2;
                    dlaVar4 = dlaVarAc5;
                    z7 = z3;
                    r3 = i6;
                    r4 = i12;
                    dlaVar5 = dlaVarAc3;
                    adbVar9 = adbVar4;
                    dlaVar6 = dlaVar;
                    i21 = i17;
                    zArr4 = zArr3;
                }
                if (z) {
                    dlaVar7 = dlaVar5;
                    dlaVar8 = dlaVar6;
                    dlaVar9 = dlaVar4;
                    i22 = 0;
                    i23 = 8;
                    z8 = true;
                    i24 = 1;
                } else {
                    dlaVar7 = dlaVar5;
                    dlaVar8 = dlaVar6;
                    dlaVar9 = dlaVar4;
                    i22 = 0;
                    i23 = 8;
                    z8 = true;
                    i24 = 1;
                }
                if (this.z == 2) {
                    i24 = i22;
                }
                if (i24 != 0) {
                    dlaVar10 = dlaVar7;
                    dlaVar11 = dlaVar8;
                } else {
                    dlaVar10 = dlaVar7;
                    dlaVar11 = dlaVar8;
                }
                if (z5) {
                    if (this.ak == 1) {
                        float f222222222222 = this.al;
                        kw kwVarAd52222222222 = bvmVar2.ad();
                        kwVarAd52222222222.d.q(dlaVar11, -1.0f);
                        kwVarAd52222222222.d.q(dlaVar10, 1.0f);
                        kwVarAd52222222222.d.q(dlaVar3, f222222222222);
                        kwVarAd52222222222.d.q(dlaVar2, -f222222222222);
                        bvmVar2.u(kwVarAd52222222222);
                    } else {
                        float f322222222222 = this.al;
                        kw kwVarAd222222222222 = bvmVar2.ad();
                        kwVarAd222222222222.d.q(dlaVar3, -1.0f);
                        kwVarAd222222222222.d.q(dlaVar2, 1.0f);
                        kwVarAd222222222222.d.q(dlaVar11, f322222222222);
                        kwVarAd222222222222.d.q(dlaVar10, -f322222222222);
                        bvmVar2.u(kwVarAd222222222222);
                    }
                }
                if (adbVar8.q()) {
                    adb adbVar1622222222222 = adbVar8;
                    adq adqVar422222222222 = adbVar1622222222222.f.d;
                    float radians22222222222 = (float) Math.toRadians(this.an + 90.0f);
                    int iN22222222222 = adbVar1622222222222.n();
                    dla dlaVarAc622222222222 = bvmVar2.ac(ck(2));
                    dla dlaVarAc722222222222 = bvmVar2.ac(ck(3));
                    dla dlaVarAc822222222222 = bvmVar2.ac(ck(4));
                    dla dlaVarAc922222222222 = bvmVar2.ac(ck(5));
                    dla dlaVarAc1022222222222 = bvmVar2.ac(adqVar422222222222.ck(2));
                    dla dlaVarAc1122222222222 = bvmVar2.ac(adqVar422222222222.ck(3));
                    dla dlaVarAc1222222222222 = bvmVar2.ac(adqVar422222222222.ck(4));
                    dla dlaVarAc1322222222222 = bvmVar2.ac(adqVar422222222222.ck(5));
                    kw kwVarAd322222222222 = bvmVar2.ad();
                    double d32222222222 = radians22222222222;
                    double dSin22222222222 = Math.sin(d32222222222);
                    double d222222222222 = iN22222222222;
                    kwVarAd322222222222.d.q(dlaVarAc1122222222222, 0.5f);
                    kwVarAd322222222222.d.q(dlaVarAc1322222222222, 0.5f);
                    kwVarAd322222222222.d.q(dlaVarAc722222222222, -0.5f);
                    kwVarAd322222222222.d.q(dlaVarAc922222222222, -0.5f);
                    kwVarAd322222222222.b = -((float) (dSin22222222222 * d222222222222));
                    bvmVar2.u(kwVarAd322222222222);
                    kw kwVarAd422222222222 = bvmVar2.ad();
                    float fCos22222222222 = (float) (Math.cos(d32222222222) * d222222222222);
                    kwVarAd422222222222.d.q(dlaVarAc1022222222222, 0.5f);
                    kwVarAd422222222222.d.q(dlaVarAc1222222222222, 0.5f);
                    kwVarAd422222222222.d.q(dlaVarAc622222222222, -0.5f);
                    kwVarAd422222222222.d.q(dlaVarAc822222222222, -0.5f);
                    kwVarAd422222222222.b = -fCos22222222222;
                    bvmVar2.u(kwVarAd422222222222);
                }
                this.u = false;
                this.v = false;
            }
            z5 = false;
            int[] iArr5222222 = this.ad;
            iArr5222222[0] = i17;
            iArr5222222[1] = i18;
            if (z5) {
                int i36222222 = this.ak;
                i19 = -1;
                if (i36222222 != 0) {
                }
                if (z5) {
                }
                if (iArr[0] != 2) {
                }
                if (z6) {
                    i9 = 0;
                }
                adbVar6 = this.az;
                boolean z13222222222222 = !adbVar6.q();
                char c222222222222 = '\b';
                boolean z14222222222222 = zArr[0];
                boolean z15222222222222 = zArr[1];
                i20 = this.y;
                iArr2 = this.am;
                if (i20 != 2) {
                    adbVar7 = adbVar5;
                    dlaVar2 = dlaVarAc;
                    dlaVar3 = dlaVarAc2;
                    adbVar8 = adbVar6;
                    iArr3 = iArr2;
                    dlaVar4 = dlaVarAc5;
                    z7 = z3;
                    r3 = i6;
                    r4 = i12;
                    dlaVar5 = dlaVarAc3;
                    adbVar9 = adbVar4;
                    dlaVar6 = dlaVar;
                    i21 = i17;
                    zArr4 = zArr3;
                } else {
                    adbVar7 = adbVar5;
                    dlaVar2 = dlaVarAc;
                    dlaVar3 = dlaVarAc2;
                    adbVar8 = adbVar6;
                    iArr3 = iArr2;
                    dlaVar4 = dlaVarAc5;
                    z7 = z3;
                    r3 = i6;
                    r4 = i12;
                    dlaVar5 = dlaVarAc3;
                    adbVar9 = adbVar4;
                    dlaVar6 = dlaVar;
                    i21 = i17;
                    zArr4 = zArr3;
                }
                if (z) {
                    dlaVar7 = dlaVar5;
                    dlaVar8 = dlaVar6;
                    dlaVar9 = dlaVar4;
                    i22 = 0;
                    i23 = 8;
                    z8 = true;
                    i24 = 1;
                } else {
                    dlaVar7 = dlaVar5;
                    dlaVar8 = dlaVar6;
                    dlaVar9 = dlaVar4;
                    i22 = 0;
                    i23 = 8;
                    z8 = true;
                    i24 = 1;
                }
                if (this.z == 2) {
                    i24 = i22;
                }
                if (i24 != 0) {
                    dlaVar10 = dlaVar7;
                    dlaVar11 = dlaVar8;
                } else {
                    dlaVar10 = dlaVar7;
                    dlaVar11 = dlaVar8;
                }
                if (z5) {
                    if (this.ak == 1) {
                        float f2222222222222 = this.al;
                        kw kwVarAd522222222222 = bvmVar2.ad();
                        kwVarAd522222222222.d.q(dlaVar11, -1.0f);
                        kwVarAd522222222222.d.q(dlaVar10, 1.0f);
                        kwVarAd522222222222.d.q(dlaVar3, f2222222222222);
                        kwVarAd522222222222.d.q(dlaVar2, -f2222222222222);
                        bvmVar2.u(kwVarAd522222222222);
                    } else {
                        float f3222222222222 = this.al;
                        kw kwVarAd2222222222222 = bvmVar2.ad();
                        kwVarAd2222222222222.d.q(dlaVar3, -1.0f);
                        kwVarAd2222222222222.d.q(dlaVar2, 1.0f);
                        kwVarAd2222222222222.d.q(dlaVar11, f3222222222222);
                        kwVarAd2222222222222.d.q(dlaVar10, -f3222222222222);
                        bvmVar2.u(kwVarAd2222222222222);
                    }
                }
                if (adbVar8.q()) {
                    adb adbVar16222222222222 = adbVar8;
                    adq adqVar4222222222222 = adbVar16222222222222.f.d;
                    float radians222222222222 = (float) Math.toRadians(this.an + 90.0f);
                    int iN222222222222 = adbVar16222222222222.n();
                    dla dlaVarAc6222222222222 = bvmVar2.ac(ck(2));
                    dla dlaVarAc7222222222222 = bvmVar2.ac(ck(3));
                    dla dlaVarAc8222222222222 = bvmVar2.ac(ck(4));
                    dla dlaVarAc9222222222222 = bvmVar2.ac(ck(5));
                    dla dlaVarAc10222222222222 = bvmVar2.ac(adqVar4222222222222.ck(2));
                    dla dlaVarAc11222222222222 = bvmVar2.ac(adqVar4222222222222.ck(3));
                    dla dlaVarAc12222222222222 = bvmVar2.ac(adqVar4222222222222.ck(4));
                    dla dlaVarAc13222222222222 = bvmVar2.ac(adqVar4222222222222.ck(5));
                    kw kwVarAd3222222222222 = bvmVar2.ad();
                    double d322222222222 = radians222222222222;
                    double dSin222222222222 = Math.sin(d322222222222);
                    double d2222222222222 = iN222222222222;
                    kwVarAd3222222222222.d.q(dlaVarAc11222222222222, 0.5f);
                    kwVarAd3222222222222.d.q(dlaVarAc13222222222222, 0.5f);
                    kwVarAd3222222222222.d.q(dlaVarAc7222222222222, -0.5f);
                    kwVarAd3222222222222.d.q(dlaVarAc9222222222222, -0.5f);
                    kwVarAd3222222222222.b = -((float) (dSin222222222222 * d2222222222222));
                    bvmVar2.u(kwVarAd3222222222222);
                    kw kwVarAd4222222222222 = bvmVar2.ad();
                    float fCos222222222222 = (float) (Math.cos(d322222222222) * d2222222222222);
                    kwVarAd4222222222222.d.q(dlaVarAc10222222222222, 0.5f);
                    kwVarAd4222222222222.d.q(dlaVarAc12222222222222, 0.5f);
                    kwVarAd4222222222222.d.q(dlaVarAc6222222222222, -0.5f);
                    kwVarAd4222222222222.d.q(dlaVarAc8222222222222, -0.5f);
                    kwVarAd4222222222222.b = -fCos222222222222;
                    bvmVar2.u(kwVarAd4222222222222);
                }
                this.u = false;
                this.v = false;
            }
            i19 = -1;
            if (z5) {
            }
            if (iArr[0] != 2) {
            }
            if (z6) {
                i9 = 0;
            }
            adbVar6 = this.az;
            boolean z132222222222222 = !adbVar6.q();
            char c2222222222222 = '\b';
            boolean z142222222222222 = zArr[0];
            boolean z152222222222222 = zArr[1];
            i20 = this.y;
            iArr2 = this.am;
            if (i20 != 2) {
                adbVar7 = adbVar5;
                dlaVar2 = dlaVarAc;
                dlaVar3 = dlaVarAc2;
                adbVar8 = adbVar6;
                iArr3 = iArr2;
                dlaVar4 = dlaVarAc5;
                z7 = z3;
                r3 = i6;
                r4 = i12;
                dlaVar5 = dlaVarAc3;
                adbVar9 = adbVar4;
                dlaVar6 = dlaVar;
                i21 = i17;
                zArr4 = zArr3;
            } else {
                adbVar7 = adbVar5;
                dlaVar2 = dlaVarAc;
                dlaVar3 = dlaVarAc2;
                adbVar8 = adbVar6;
                iArr3 = iArr2;
                dlaVar4 = dlaVarAc5;
                z7 = z3;
                r3 = i6;
                r4 = i12;
                dlaVar5 = dlaVarAc3;
                adbVar9 = adbVar4;
                dlaVar6 = dlaVar;
                i21 = i17;
                zArr4 = zArr3;
            }
            if (z) {
                dlaVar7 = dlaVar5;
                dlaVar8 = dlaVar6;
                dlaVar9 = dlaVar4;
                i22 = 0;
                i23 = 8;
                z8 = true;
                i24 = 1;
            } else {
                dlaVar7 = dlaVar5;
                dlaVar8 = dlaVar6;
                dlaVar9 = dlaVar4;
                i22 = 0;
                i23 = 8;
                z8 = true;
                i24 = 1;
            }
            if (this.z == 2) {
                i24 = i22;
            }
            if (i24 != 0) {
                dlaVar10 = dlaVar7;
                dlaVar11 = dlaVar8;
            } else {
                dlaVar10 = dlaVar7;
                dlaVar11 = dlaVar8;
            }
            if (z5) {
                if (this.ak == 1) {
                    float f22222222222222 = this.al;
                    kw kwVarAd5222222222222 = bvmVar2.ad();
                    kwVarAd5222222222222.d.q(dlaVar11, -1.0f);
                    kwVarAd5222222222222.d.q(dlaVar10, 1.0f);
                    kwVarAd5222222222222.d.q(dlaVar3, f22222222222222);
                    kwVarAd5222222222222.d.q(dlaVar2, -f22222222222222);
                    bvmVar2.u(kwVarAd5222222222222);
                } else {
                    float f32222222222222 = this.al;
                    kw kwVarAd22222222222222 = bvmVar2.ad();
                    kwVarAd22222222222222.d.q(dlaVar3, -1.0f);
                    kwVarAd22222222222222.d.q(dlaVar2, 1.0f);
                    kwVarAd22222222222222.d.q(dlaVar11, f32222222222222);
                    kwVarAd22222222222222.d.q(dlaVar10, -f32222222222222);
                    bvmVar2.u(kwVarAd22222222222222);
                }
            }
            if (adbVar8.q()) {
                adb adbVar162222222222222 = adbVar8;
                adq adqVar42222222222222 = adbVar162222222222222.f.d;
                float radians2222222222222 = (float) Math.toRadians(this.an + 90.0f);
                int iN2222222222222 = adbVar162222222222222.n();
                dla dlaVarAc62222222222222 = bvmVar2.ac(ck(2));
                dla dlaVarAc72222222222222 = bvmVar2.ac(ck(3));
                dla dlaVarAc82222222222222 = bvmVar2.ac(ck(4));
                dla dlaVarAc92222222222222 = bvmVar2.ac(ck(5));
                dla dlaVarAc102222222222222 = bvmVar2.ac(adqVar42222222222222.ck(2));
                dla dlaVarAc112222222222222 = bvmVar2.ac(adqVar42222222222222.ck(3));
                dla dlaVarAc122222222222222 = bvmVar2.ac(adqVar42222222222222.ck(4));
                dla dlaVarAc132222222222222 = bvmVar2.ac(adqVar42222222222222.ck(5));
                kw kwVarAd32222222222222 = bvmVar2.ad();
                double d3222222222222 = radians2222222222222;
                double dSin2222222222222 = Math.sin(d3222222222222);
                double d22222222222222 = iN2222222222222;
                kwVarAd32222222222222.d.q(dlaVarAc112222222222222, 0.5f);
                kwVarAd32222222222222.d.q(dlaVarAc132222222222222, 0.5f);
                kwVarAd32222222222222.d.q(dlaVarAc72222222222222, -0.5f);
                kwVarAd32222222222222.d.q(dlaVarAc92222222222222, -0.5f);
                kwVarAd32222222222222.b = -((float) (dSin2222222222222 * d22222222222222));
                bvmVar2.u(kwVarAd32222222222222);
                kw kwVarAd42222222222222 = bvmVar2.ad();
                float fCos2222222222222 = (float) (Math.cos(d3222222222222) * d22222222222222);
                kwVarAd42222222222222.d.q(dlaVarAc102222222222222, 0.5f);
                kwVarAd42222222222222.d.q(dlaVarAc122222222222222, 0.5f);
                kwVarAd42222222222222.d.q(dlaVarAc62222222222222, -0.5f);
                kwVarAd42222222222222.d.q(dlaVarAc82222222222222, -0.5f);
                kwVarAd42222222222222.b = -fCos2222222222222;
                bvmVar2.u(kwVarAd42222222222222);
            }
            this.u = false;
            this.v = false;
        }
        adbVar4 = adbVar13;
        dlaVar = dlaVarAc4;
        adbVar5 = adbVar;
        i16 = i10;
        i17 = i14;
        i18 = i15;
        z5 = false;
        int[] iArr52222222 = this.ad;
        iArr52222222[0] = i17;
        iArr52222222[1] = i18;
        if (z5) {
            int i362222222 = this.ak;
            i19 = -1;
            if (i362222222 != 0) {
            }
            if (z5) {
            }
            if (iArr[0] != 2) {
            }
            if (z6) {
                i9 = 0;
            }
            adbVar6 = this.az;
            boolean z1322222222222222 = !adbVar6.q();
            char c22222222222222 = '\b';
            boolean z1422222222222222 = zArr[0];
            boolean z1522222222222222 = zArr[1];
            i20 = this.y;
            iArr2 = this.am;
            if (i20 != 2) {
                adbVar7 = adbVar5;
                dlaVar2 = dlaVarAc;
                dlaVar3 = dlaVarAc2;
                adbVar8 = adbVar6;
                iArr3 = iArr2;
                dlaVar4 = dlaVarAc5;
                z7 = z3;
                r3 = i6;
                r4 = i12;
                dlaVar5 = dlaVarAc3;
                adbVar9 = adbVar4;
                dlaVar6 = dlaVar;
                i21 = i17;
                zArr4 = zArr3;
            } else {
                adbVar7 = adbVar5;
                dlaVar2 = dlaVarAc;
                dlaVar3 = dlaVarAc2;
                adbVar8 = adbVar6;
                iArr3 = iArr2;
                dlaVar4 = dlaVarAc5;
                z7 = z3;
                r3 = i6;
                r4 = i12;
                dlaVar5 = dlaVarAc3;
                adbVar9 = adbVar4;
                dlaVar6 = dlaVar;
                i21 = i17;
                zArr4 = zArr3;
            }
            if (z) {
                dlaVar7 = dlaVar5;
                dlaVar8 = dlaVar6;
                dlaVar9 = dlaVar4;
                i22 = 0;
                i23 = 8;
                z8 = true;
                i24 = 1;
            } else {
                dlaVar7 = dlaVar5;
                dlaVar8 = dlaVar6;
                dlaVar9 = dlaVar4;
                i22 = 0;
                i23 = 8;
                z8 = true;
                i24 = 1;
            }
            if (this.z == 2) {
                i24 = i22;
            }
            if (i24 != 0) {
                dlaVar10 = dlaVar7;
                dlaVar11 = dlaVar8;
            } else {
                dlaVar10 = dlaVar7;
                dlaVar11 = dlaVar8;
            }
            if (z5) {
                if (this.ak == 1) {
                    float f222222222222222 = this.al;
                    kw kwVarAd52222222222222 = bvmVar2.ad();
                    kwVarAd52222222222222.d.q(dlaVar11, -1.0f);
                    kwVarAd52222222222222.d.q(dlaVar10, 1.0f);
                    kwVarAd52222222222222.d.q(dlaVar3, f222222222222222);
                    kwVarAd52222222222222.d.q(dlaVar2, -f222222222222222);
                    bvmVar2.u(kwVarAd52222222222222);
                } else {
                    float f322222222222222 = this.al;
                    kw kwVarAd222222222222222 = bvmVar2.ad();
                    kwVarAd222222222222222.d.q(dlaVar3, -1.0f);
                    kwVarAd222222222222222.d.q(dlaVar2, 1.0f);
                    kwVarAd222222222222222.d.q(dlaVar11, f322222222222222);
                    kwVarAd222222222222222.d.q(dlaVar10, -f322222222222222);
                    bvmVar2.u(kwVarAd222222222222222);
                }
            }
            if (adbVar8.q()) {
                adb adbVar1622222222222222 = adbVar8;
                adq adqVar422222222222222 = adbVar1622222222222222.f.d;
                float radians22222222222222 = (float) Math.toRadians(this.an + 90.0f);
                int iN22222222222222 = adbVar1622222222222222.n();
                dla dlaVarAc622222222222222 = bvmVar2.ac(ck(2));
                dla dlaVarAc722222222222222 = bvmVar2.ac(ck(3));
                dla dlaVarAc822222222222222 = bvmVar2.ac(ck(4));
                dla dlaVarAc922222222222222 = bvmVar2.ac(ck(5));
                dla dlaVarAc1022222222222222 = bvmVar2.ac(adqVar422222222222222.ck(2));
                dla dlaVarAc1122222222222222 = bvmVar2.ac(adqVar422222222222222.ck(3));
                dla dlaVarAc1222222222222222 = bvmVar2.ac(adqVar422222222222222.ck(4));
                dla dlaVarAc1322222222222222 = bvmVar2.ac(adqVar422222222222222.ck(5));
                kw kwVarAd322222222222222 = bvmVar2.ad();
                double d32222222222222 = radians22222222222222;
                double dSin22222222222222 = Math.sin(d32222222222222);
                double d222222222222222 = iN22222222222222;
                kwVarAd322222222222222.d.q(dlaVarAc1122222222222222, 0.5f);
                kwVarAd322222222222222.d.q(dlaVarAc1322222222222222, 0.5f);
                kwVarAd322222222222222.d.q(dlaVarAc722222222222222, -0.5f);
                kwVarAd322222222222222.d.q(dlaVarAc922222222222222, -0.5f);
                kwVarAd322222222222222.b = -((float) (dSin22222222222222 * d222222222222222));
                bvmVar2.u(kwVarAd322222222222222);
                kw kwVarAd422222222222222 = bvmVar2.ad();
                float fCos22222222222222 = (float) (Math.cos(d32222222222222) * d222222222222222);
                kwVarAd422222222222222.d.q(dlaVarAc1022222222222222, 0.5f);
                kwVarAd422222222222222.d.q(dlaVarAc1222222222222222, 0.5f);
                kwVarAd422222222222222.d.q(dlaVarAc622222222222222, -0.5f);
                kwVarAd422222222222222.d.q(dlaVarAc822222222222222, -0.5f);
                kwVarAd422222222222222.b = -fCos22222222222222;
                bvmVar2.u(kwVarAd422222222222222);
            }
            this.u = false;
            this.v = false;
        }
        i19 = -1;
        if (z5) {
        }
        if (iArr[0] != 2) {
        }
        if (z6) {
            i9 = 0;
        }
        adbVar6 = this.az;
        boolean z13222222222222222 = !adbVar6.q();
        char c222222222222222 = '\b';
        boolean z14222222222222222 = zArr[0];
        boolean z15222222222222222 = zArr[1];
        i20 = this.y;
        iArr2 = this.am;
        if (i20 != 2) {
            adbVar7 = adbVar5;
            dlaVar2 = dlaVarAc;
            dlaVar3 = dlaVarAc2;
            adbVar8 = adbVar6;
            iArr3 = iArr2;
            dlaVar4 = dlaVarAc5;
            z7 = z3;
            r3 = i6;
            r4 = i12;
            dlaVar5 = dlaVarAc3;
            adbVar9 = adbVar4;
            dlaVar6 = dlaVar;
            i21 = i17;
            zArr4 = zArr3;
        } else {
            adbVar7 = adbVar5;
            dlaVar2 = dlaVarAc;
            dlaVar3 = dlaVarAc2;
            adbVar8 = adbVar6;
            iArr3 = iArr2;
            dlaVar4 = dlaVarAc5;
            z7 = z3;
            r3 = i6;
            r4 = i12;
            dlaVar5 = dlaVarAc3;
            adbVar9 = adbVar4;
            dlaVar6 = dlaVar;
            i21 = i17;
            zArr4 = zArr3;
        }
        if (z) {
            dlaVar7 = dlaVar5;
            dlaVar8 = dlaVar6;
            dlaVar9 = dlaVar4;
            i22 = 0;
            i23 = 8;
            z8 = true;
            i24 = 1;
        } else {
            dlaVar7 = dlaVar5;
            dlaVar8 = dlaVar6;
            dlaVar9 = dlaVar4;
            i22 = 0;
            i23 = 8;
            z8 = true;
            i24 = 1;
        }
        if (this.z == 2) {
            i24 = i22;
        }
        if (i24 != 0) {
            dlaVar10 = dlaVar7;
            dlaVar11 = dlaVar8;
        } else {
            dlaVar10 = dlaVar7;
            dlaVar11 = dlaVar8;
        }
        if (z5) {
            if (this.ak == 1) {
                float f2222222222222222 = this.al;
                kw kwVarAd522222222222222 = bvmVar2.ad();
                kwVarAd522222222222222.d.q(dlaVar11, -1.0f);
                kwVarAd522222222222222.d.q(dlaVar10, 1.0f);
                kwVarAd522222222222222.d.q(dlaVar3, f2222222222222222);
                kwVarAd522222222222222.d.q(dlaVar2, -f2222222222222222);
                bvmVar2.u(kwVarAd522222222222222);
            } else {
                float f3222222222222222 = this.al;
                kw kwVarAd2222222222222222 = bvmVar2.ad();
                kwVarAd2222222222222222.d.q(dlaVar3, -1.0f);
                kwVarAd2222222222222222.d.q(dlaVar2, 1.0f);
                kwVarAd2222222222222222.d.q(dlaVar11, f3222222222222222);
                kwVarAd2222222222222222.d.q(dlaVar10, -f3222222222222222);
                bvmVar2.u(kwVarAd2222222222222222);
            }
        }
        if (adbVar8.q()) {
            adb adbVar16222222222222222 = adbVar8;
            adq adqVar4222222222222222 = adbVar16222222222222222.f.d;
            float radians222222222222222 = (float) Math.toRadians(this.an + 90.0f);
            int iN222222222222222 = adbVar16222222222222222.n();
            dla dlaVarAc6222222222222222 = bvmVar2.ac(ck(2));
            dla dlaVarAc7222222222222222 = bvmVar2.ac(ck(3));
            dla dlaVarAc8222222222222222 = bvmVar2.ac(ck(4));
            dla dlaVarAc9222222222222222 = bvmVar2.ac(ck(5));
            dla dlaVarAc10222222222222222 = bvmVar2.ac(adqVar4222222222222222.ck(2));
            dla dlaVarAc11222222222222222 = bvmVar2.ac(adqVar4222222222222222.ck(3));
            dla dlaVarAc12222222222222222 = bvmVar2.ac(adqVar4222222222222222.ck(4));
            dla dlaVarAc13222222222222222 = bvmVar2.ac(adqVar4222222222222222.ck(5));
            kw kwVarAd3222222222222222 = bvmVar2.ad();
            double d322222222222222 = radians222222222222222;
            double dSin222222222222222 = Math.sin(d322222222222222);
            double d2222222222222222 = iN222222222222222;
            kwVarAd3222222222222222.d.q(dlaVarAc11222222222222222, 0.5f);
            kwVarAd3222222222222222.d.q(dlaVarAc13222222222222222, 0.5f);
            kwVarAd3222222222222222.d.q(dlaVarAc7222222222222222, -0.5f);
            kwVarAd3222222222222222.d.q(dlaVarAc9222222222222222, -0.5f);
            kwVarAd3222222222222222.b = -((float) (dSin222222222222222 * d2222222222222222));
            bvmVar2.u(kwVarAd3222222222222222);
            kw kwVarAd4222222222222222 = bvmVar2.ad();
            float fCos222222222222222 = (float) (Math.cos(d322222222222222) * d2222222222222222);
            kwVarAd4222222222222222.d.q(dlaVarAc10222222222222222, 0.5f);
            kwVarAd4222222222222222.d.q(dlaVarAc12222222222222222, 0.5f);
            kwVarAd4222222222222222.d.q(dlaVarAc6222222222222222, -0.5f);
            kwVarAd4222222222222222.d.q(dlaVarAc8222222222222222, -0.5f);
            kwVarAd4222222222222222.b = -fCos222222222222222;
            bvmVar2.u(kwVarAd4222222222222222);
        }
        this.u = false;
        this.v = false;
    }

    public boolean f() {
        return this.bq != 8;
    }

    public boolean g() {
        if (this.u) {
            return true;
        }
        return this.as.c && this.au.c;
    }

    public boolean h() {
        if (this.v) {
            return true;
        }
        return this.at.c && this.av.c;
    }

    public String toString() {
        StringBuilder sbY = dkz.y("");
        sbY.append(this.br != null ? yg.concatToVar1(new StringBuilder("id: "), this.br, " ") : "");
        sbY.append("(");
        sbY.append(this.bi);
        sbY.append(", ");
        sbY.append(this.bj);
        sbY.append(") - (");
        sbY.append(this.be);
        sbY.append(" x ");
        return yg.concatToVar1(sbY, ")", this.bf);
    }
}
