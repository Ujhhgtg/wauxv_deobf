package me.hd.wauxv.obf;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class adr extends adq {
    public ArrayList a = new ArrayList();
    public final FactoryPools b = new FactoryPools(this);
    public final aly c;
    public int d;
    public final bvm dn;

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public int f0do;
    public int dp;
    public int dq;
    public int dr;
    public tp[] ds;
    public tp[] dt;
    public int du;
    public boolean dv;
    public boolean dw;
    public WeakReference dx;
    public WeakReference dy;
    public WeakReference dz;
    public WeakReference ea;
    public final HashSet eb;
    public final of ec;
    public adg i;
    public boolean j;

    public adr() {
        aly alyVar = new aly();
        alyVar.b = true;
        alyVar.c = true;
        alyVar.e = new ArrayList();
        new ArrayList();
        alyVar.f = null;
        alyVar.g = new of();
        alyVar.h = new ArrayList();
        alyVar.a = this;
        alyVar.d = this;
        this.c = alyVar;
        this.i = null;
        this.j = false;
        this.dn = new bvm();
        this.dq = 0;
        this.dr = 0;
        this.ds = new tp[4];
        this.dt = new tp[4];
        this.du = 257;
        this.dv = false;
        this.dw = false;
        this.dx = null;
        this.dy = null;
        this.dz = null;
        this.ea = null;
        this.eb = new HashSet();
        this.ec = new of();
    }

    public static void ed(adq adqVar, adg adgVar, of ofVar) {
        int i;
        int i2;
        if (adgVar == null) {
            return;
        }
        int i3 = adqVar.bq;
        int[] iArr = adqVar.ad;
        if (i3 == 8 || (adqVar instanceof bjp) || (adqVar instanceof nb)) {
            ofVar.e = 0;
            ofVar.f = 0;
            return;
        }
        int[] iArr2 = adqVar.bz;
        ofVar.a = iArr2[0];
        ofVar.b = iArr2[1];
        ofVar.c = adqVar.cq();
        ofVar.d = adqVar.cm();
        ofVar.i = false;
        ofVar.j = 0;
        boolean z = ofVar.a == 3;
        boolean z2 = ofVar.b == 3;
        boolean z3 = z && adqVar.bg > 0.0f;
        boolean z4 = z2 && adqVar.bg > 0.0f;
        if (z && adqVar.ct(0) && adqVar.ab == 0 && !z3) {
            ofVar.a = 2;
            if (z2 && adqVar.ac == 0) {
                ofVar.a = 1;
            }
            z = false;
        }
        if (z2 && adqVar.ct(1) && adqVar.ac == 0 && !z4) {
            ofVar.b = 2;
            if (z && adqVar.ab == 0) {
                ofVar.b = 1;
            }
            z2 = false;
        }
        if (adqVar.g()) {
            ofVar.a = 1;
            z = false;
        }
        if (adqVar.h()) {
            ofVar.b = 1;
            z2 = false;
        }
        if (z3) {
            if (iArr[0] == 4) {
                ofVar.a = 1;
            } else if (!z2) {
                if (ofVar.b == 1) {
                    i2 = ofVar.d;
                } else {
                    ofVar.a = 2;
                    adgVar.j(adqVar, ofVar);
                    i2 = ofVar.f;
                }
                ofVar.a = 1;
                ofVar.c = (int) (adqVar.bg * i2);
            }
        }
        if (z4) {
            if (iArr[1] == 4) {
                ofVar.b = 1;
            } else if (!z) {
                if (ofVar.a == 1) {
                    i = ofVar.c;
                } else {
                    ofVar.b = 2;
                    adgVar.j(adqVar, ofVar);
                    i = ofVar.e;
                }
                ofVar.b = 1;
                if (adqVar.bh == -1) {
                    ofVar.d = (int) (i / adqVar.bg);
                } else {
                    ofVar.d = (int) (adqVar.bg * i);
                }
            }
        }
        adgVar.j(adqVar, ofVar);
        adqVar.dk(ofVar.e);
        adqVar.dh(ofVar.f);
        adqVar.ao = ofVar.h;
        adqVar.de(ofVar.g);
        ofVar.j = 0;
    }

    @Override // me.hd.wauxv.obf.adq
    public final void cp(StringBuilder sb) {
        sb.append(this.t + ":{\n");
        StringBuilder sb2 = new StringBuilder("  actualWidth:");
        sb2.append(this.be);
        sb.append(sb2.toString());
        sb.append("\n");
        sb.append("  actualHeight:" + this.bf);
        sb.append("\n");
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((adq) it.next()).cp(sb);
            sb.append(",\n");
        }
        sb.append("}");
    }

    @Override // me.hd.wauxv.obf.adq
    public final void da() {
        this.dn.ak();
        this.f0do = 0;
        this.dp = 0;
        this.a.clear();
        super.da();
    }

    @Override // me.hd.wauxv.obf.adq
    public final void dd(FactoryPools factoryPoolsVar) {
        super.dd(factoryPoolsVar);
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            ((adq) this.a.get(i)).dd(factoryPoolsVar);
        }
    }

    @Override // me.hd.wauxv.obf.adq
    public final void dl(boolean z, boolean z2) {
        super.dl(z, z2);
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            ((adq) this.a.get(i)).dl(z, z2);
        }
    }

    public final void ee(adq adqVar, int i) {
        if (i == 0) {
            int i2 = this.dq + 1;
            tp[] tpVarArr = this.dt;
            if (i2 >= tpVarArr.length) {
                this.dt = (tp[]) Arrays.copyOf(tpVarArr, tpVarArr.length * 2);
            }
            tp[] tpVarArr2 = this.dt;
            int i3 = this.dq;
            tpVarArr2[i3] = new tp(adqVar, 0, this.j);
            this.dq = i3 + 1;
            return;
        }
        if (i == 1) {
            int i4 = this.dr + 1;
            tp[] tpVarArr3 = this.ds;
            if (i4 >= tpVarArr3.length) {
                this.ds = (tp[]) Arrays.copyOf(tpVarArr3, tpVarArr3.length * 2);
            }
            tp[] tpVarArr4 = this.ds;
            int i5 = this.dr;
            tpVarArr4[i5] = new tp(adqVar, 1, this.j);
            this.dr = i5 + 1;
        }
    }

    public final void ef(bvm bvmVar) {
        adr adrVar;
        bvm bvmVar2;
        boolean zEi = ei(64);
        e(bvmVar, zEi);
        int size = this.a.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            adq adqVar = (adq) this.a.get(i);
            boolean[] zArr = adqVar.bc;
            zArr[0] = false;
            zArr[1] = false;
            if (adqVar instanceof nb) {
                z = true;
            }
        }
        if (z) {
            for (int i2 = 0; i2 < size; i2++) {
                adq adqVar2 = (adq) this.a.get(i2);
                if (adqVar2 instanceof nb) {
                    nb nbVar = (nb) adqVar2;
                    for (int i3 = 0; i3 < nbVar.ew; i3++) {
                        adq adqVar3 = nbVar.ev[i3];
                        if (nbVar.b || adqVar3.f()) {
                            int i4 = nbVar.a;
                            if (i4 == 0 || i4 == 1) {
                                adqVar3.bc[0] = true;
                            } else if (i4 == 2 || i4 == 3) {
                                adqVar3.bc[1] = true;
                            }
                        }
                    }
                }
            }
        }
        HashSet hashSet = this.eb;
        hashSet.clear();
        for (int i5 = 0; i5 < size; i5++) {
            adq adqVar4 = (adq) this.a.get(i5);
            adqVar4.getClass();
            boolean z2 = adqVar4 instanceof bbp;
            if (z2 || (adqVar4 instanceof bjp)) {
                if (z2) {
                    hashSet.add(adqVar4);
                } else {
                    adqVar4.e(bvmVar, zEi);
                }
            }
        }
        while (hashSet.size() > 0) {
            int size2 = hashSet.size();
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                bbp bbpVar = (bbp) ((adq) it.next());
                for (int i6 = 0; i6 < bbpVar.ew; i6++) {
                    if (hashSet.contains(bbpVar.ev[i6])) {
                        bbpVar.e(bvmVar, zEi);
                        hashSet.remove(bbpVar);
                        break;
                    }
                }
            }
            if (size2 == hashSet.size()) {
                Iterator it2 = hashSet.iterator();
                while (it2.hasNext()) {
                    ((adq) it2.next()).e(bvmVar, zEi);
                }
                hashSet.clear();
            }
        }
        if (bvm.a) {
            HashSet<adq> hashSet2 = new HashSet();
            for (int i7 = 0; i7 < size; i7++) {
                adq adqVar5 = (adq) this.a.get(i7);
                adqVar5.getClass();
                if (!(adqVar5 instanceof bbp) && !(adqVar5 instanceof bjp)) {
                    hashSet2.add(adqVar5);
                }
            }
            adrVar = this;
            bvmVar2 = bvmVar;
            adrVar.ce(this, bvmVar2, hashSet2, this.bz[0] == 2 ? 0 : 1, false);
            for (adq adqVar6 : hashSet2) {
                HugeSyntheticPileOfHelpers.aq(this, bvmVar2, adqVar6);
                adqVar6.e(bvmVar2, zEi);
            }
        } else {
            adrVar = this;
            bvmVar2 = bvmVar;
            for (int i8 = 0; i8 < size; i8++) {
                adq adqVar7 = (adq) adrVar.a.get(i8);
                if (adqVar7 instanceof adr) {
                    int[] iArr = adqVar7.bz;
                    int i9 = iArr[0];
                    int i10 = iArr[1];
                    if (i9 == 2) {
                        adqVar7.di(1);
                    }
                    if (i10 == 2) {
                        adqVar7.dj(1);
                    }
                    adqVar7.e(bvmVar2, zEi);
                    if (i9 == 2) {
                        adqVar7.di(i9);
                    }
                    if (i10 == 2) {
                        adqVar7.dj(i10);
                    }
                } else {
                    HugeSyntheticPileOfHelpers.aq(this, bvmVar2, adqVar7);
                    if (!(adqVar7 instanceof bbp) && !(adqVar7 instanceof bjp)) {
                        adqVar7.e(bvmVar2, zEi);
                    }
                }
            }
        }
        if (adrVar.dq > 0) {
            bmy.k(this, bvmVar2, null, 0);
        }
        if (adrVar.dr > 0) {
            bmy.k(this, bvmVar2, null, 1);
        }
    }

    /* JADX WARN: Found duplicated region for block: B:34:0x009e  */
    public final boolean eg(int i, boolean z) {
        boolean z2;
        boolean z3;
        aly alyVar = this.c;
        ArrayList<eun> arrayList = alyVar.e;
        adr adrVar = alyVar.a;
        boolean z4 = false;
        int iCl = adrVar.cl(0);
        int[] iArr = adrVar.bz;
        int iCl2 = adrVar.cl(1);
        int iCr = adrVar.cr();
        int iCs = adrVar.cs();
        if (z && (iCl == 2 || iCl2 == 2)) {
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z3 = z;
                    break;
                }
                eun eunVar = (eun) it.next();
                if (eunVar.p == i && !eunVar.h()) {
                    z3 = false;
                    break;
                }
            }
            if (i == 0) {
                if (z3 && iCl == 2) {
                    adrVar.di(1);
                    adrVar.dk(alyVar.l(adrVar, 0));
                    adrVar.n.o.p(adrVar.cq());
                }
            } else if (z3 && iCl2 == 2) {
                adrVar.dj(1);
                adrVar.dh(alyVar.l(adrVar, 1));
                adrVar.o.o.p(adrVar.cm());
            }
        }
        if (i == 0) {
            int i2 = iArr[0];
            if (i2 == 1 || i2 == 4) {
                int iCq = adrVar.cq() + iCr;
                adrVar.n.s.p(iCq);
                adrVar.n.o.p(iCq - iCr);
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            int i3 = iArr[1];
            if (i3 == 1 || i3 == 4) {
                int iCm = adrVar.cm() + iCs;
                adrVar.o.s.p(iCm);
                adrVar.o.o.p(iCm - iCs);
                z2 = true;
            } else {
                z2 = false;
            }
        }
        alyVar.o();
        for (eun eunVar2 : arrayList) {
            if (eunVar2.p == i && (eunVar2.l != adrVar || eunVar2.q)) {
                eunVar2.e();
            }
        }
        for (eun eunVar3 : arrayList) {
            if (eunVar3.p == i && (z2 || eunVar3.l != adrVar)) {
                if (!eunVar3.r.k || !eunVar3.s.k || (!(eunVar3 instanceof tq) && !eunVar3.o.k)) {
                    adrVar.di(iCl);
                    adrVar.dj(iCl2);
                    return z4;
                }
            }
        }
        z4 = true;
        adrVar.di(iCl);
        adrVar.dj(iCl2);
        return z4;
    }

    /* JADX WARN: Found duplicated region for block: B:227:0x03a8  */
    /* JADX WARN: Found duplicated region for block: B:361:0x061f  */
    /* JADX WARN: Found duplicated region for block: B:375:0x064e  */
    /* JADX WARN: Found duplicated region for block: B:400:0x0697  */
    /* JADX WARN: Found duplicated region for block: B:405:0x06a8  */
    /* JADX WARN: Found duplicated region for block: B:412:0x06b7  */
    /* JADX WARN: Found duplicated region for block: B:415:0x06bf  */
    /* JADX WARN: Found duplicated region for block: B:417:0x06cb  */
    /* JADX WARN: Found duplicated region for block: B:421:0x06dc  */
    /* JADX WARN: Found duplicated region for block: B:424:0x06ee A[Catch: Exception -> 0x06fc, LOOP:12: B:423:0x06ec->B:424:0x06ee, LOOP_END, TryCatch #1 {Exception -> 0x06fc, blocks: (B:422:0x06e0, B:424:0x06ee, B:427:0x0703), top: B:541:0x06e0 }] */
    /* JADX WARN: Found duplicated region for block: B:440:0x0735  */
    /* JADX WARN: Found duplicated region for block: B:443:0x073b A[Catch: Exception -> 0x072b, TryCatch #3 {Exception -> 0x072b, blocks: (B:434:0x0724, B:441:0x0737, B:443:0x073b, B:445:0x0741, B:446:0x075b, B:448:0x075f, B:450:0x0765, B:454:0x077b, B:457:0x0786, B:459:0x078a, B:461:0x0790), top: B:545:0x0724 }] */
    /* JADX WARN: Found duplicated region for block: B:448:0x075f A[Catch: Exception -> 0x072b, TryCatch #3 {Exception -> 0x072b, blocks: (B:434:0x0724, B:441:0x0737, B:443:0x073b, B:445:0x0741, B:446:0x075b, B:448:0x075f, B:450:0x0765, B:454:0x077b, B:457:0x0786, B:459:0x078a, B:461:0x0790), top: B:545:0x0724 }] */
    /* JADX WARN: Found duplicated region for block: B:459:0x078a A[Catch: Exception -> 0x072b, TryCatch #3 {Exception -> 0x072b, blocks: (B:434:0x0724, B:441:0x0737, B:443:0x073b, B:445:0x0741, B:446:0x075b, B:448:0x075f, B:450:0x0765, B:454:0x077b, B:457:0x0786, B:459:0x078a, B:461:0x0790), top: B:545:0x0724 }] */
    /* JADX WARN: Found duplicated region for block: B:473:0x07b4  */
    /* JADX WARN: Found duplicated region for block: B:478:0x07d7  */
    /* JADX WARN: Found duplicated region for block: B:480:0x07f0  */
    /* JADX WARN: Found duplicated region for block: B:482:0x0804  */
    /* JADX WARN: Found duplicated region for block: B:484:0x0808  */
    /* JADX WARN: Found duplicated region for block: B:487:0x0814  */
    /* JADX WARN: Found duplicated region for block: B:489:0x081b A[LOOP:15: B:488:0x0819->B:489:0x081b, LOOP_END] */
    /* JADX WARN: Found duplicated region for block: B:493:0x082e A[ADDED_TO_REGION] */
    /* JADX WARN: Found duplicated region for block: B:498:0x083b A[LOOP:14: B:497:0x0839->B:498:0x083b, LOOP_END] */
    /* JADX WARN: Found duplicated region for block: B:501:0x0870  */
    /* JADX WARN: Found duplicated region for block: B:505:0x0881  */
    /* JADX WARN: Found duplicated region for block: B:510:0x08a0  */
    /* JADX WARN: Found duplicated region for block: B:511:0x08ac  */
    /* JADX WARN: Found duplicated region for block: B:514:0x08bf  */
    /* JADX WARN: Found duplicated region for block: B:515:0x08c7  */
    /* JADX WARN: Found duplicated region for block: B:517:0x08cb  */
    /* JADX WARN: Found duplicated region for block: B:519:0x08d2 A[ADDED_TO_REGION] */
    /* JADX WARN: Found duplicated region for block: B:522:0x08da  */
    /* JADX WARN: Found duplicated region for block: B:525:0x08e8 A[ADDED_TO_REGION] */
    /* JADX WARN: Found duplicated region for block: B:530:0x0900  */
    /* JADX WARN: Found duplicated region for block: B:532:0x0904  */
    /* JADX WARN: Found duplicated region for block: B:536:0x0912  */
    /* JADX WARN: Found duplicated region for block: B:597:0x06d0 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:600:0x0905 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:62:0x012c  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v84 */
    /* JADX WARN: Type inference failed for: r0v85 */
    /* JADX WARN: Type inference failed for: r0v86 */
    /* JADX WARN: Type inference failed for: r0v87 */
    /* JADX WARN: Type inference failed for: r0v88 */
    /* JADX WARN: Type inference failed for: r0v89 */
    /* JADX WARN: Type inference failed for: r0v90 */
    /* JADX WARN: Type inference failed for: r0v91 */
    /* JADX WARN: Type inference failed for: r0v92 */
    /* JADX WARN: Type inference failed for: r10v10, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v47 */
    /* JADX WARN: Type inference failed for: r13v48 */
    /* JADX WARN: Type inference failed for: r13v49 */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r13v9 */
    /* JADX WARN: Type inference failed for: r17v2 */
    /* JADX WARN: Type inference failed for: r17v3 */
    /* JADX WARN: Type inference failed for: r17v4 */
    /* JADX WARN: Type inference failed for: r21v0 */
    /* JADX WARN: Type inference failed for: r21v1 */
    /* JADX WARN: Type inference failed for: r21v2 */
    /* JADX WARN: Type inference failed for: r33v0, types: [me.hd.wauxv.obf.adq, me.hd.wauxv.obf.adr] */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v126, types: [int] */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v68 */
    /* JADX WARN: Type inference failed for: r3v94, types: [int] */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v66, types: [int] */
    /* JADX WARN: Type inference failed for: r6v80, types: [int] */
    public final void eh() {
        boolean[] zArr;
        ?? r21;
        adb adbVar;
        int i;
        boolean z;
        char c;
        boolean z2;
        int i2;
        boolean zEi;
        ?? r13;
        int i3;
        boolean z3;
        int i4;
        boolean z4;
        adb adbVar2;
        boolean z5;
        int i5;
        boolean z6;
        int iMax;
        ?? r10;
        ?? r17;
        boolean z7;
        int iMax2;
        ?? r0;
        boolean z8;
        boolean z9;
        ?? r02;
        ?? r132;
        int i6;
        boolean z10;
        boolean z11;
        ?? r03;
        ?? r04;
        int i7;
        int iMax3;
        int iMax4;
        int iMax5;
        int iMax6;
        boolean zEi2;
        int size;
        int i8;
        boolean z12;
        adq adqVar;
        boolean z13;
        int i9;
        WeakReference weakReference;
        WeakReference weakReference2;
        WeakReference weakReference3;
        WeakReference weakReference4;
        adb adbVar3;
        adq adqVar2;
        eum eumVar;
        eum eumVar2;
        int iH;
        int i10;
        ArrayList arrayList;
        eum eumVar3;
        eum eumVar4;
        boolean z14;
        ArrayList arrayList2;
        ArrayList arrayList3;
        adg adgVar;
        ArrayList arrayList4;
        int i11;
        boolean z15;
        boolean[] zArr2 = HugeSyntheticPileOfHelpers.ag;
        this.bi = 0;
        this.bj = 0;
        this.dv = false;
        this.dw = false;
        int size2 = this.a.size();
        int iMax7 = Math.max(0, cq());
        int iMax8 = Math.max(0, cm());
        int[] iArr = this.bz;
        int i12 = iArr[1];
        int i13 = iArr[0];
        int i14 = this.d;
        adb adbVar4 = this.at;
        adb adbVar5 = this.as;
        if (i14 == 0 && HugeSyntheticPileOfHelpers.az(this.du, 1)) {
            adg adgVar2 = this.i;
            int i15 = iArr[0];
            int i16 = iArr[1];
            dc();
            ArrayList arrayList5 = this.a;
            int size3 = arrayList5.size();
            for (int i17 = 0; i17 < size3; i17++) {
                ((adq) arrayList5.get(i17)).dc();
            }
            boolean z16 = this.j;
            zArr = zArr2;
            if (i15 == 1) {
                df(0, cq());
            } else {
                adbVar5.u(0);
                this.bi = 0;
            }
            int i18 = 0;
            boolean z17 = false;
            boolean z18 = false;
            while (i18 < size3) {
                int i19 = i18;
                adq adqVar3 = (adq) arrayList5.get(i18);
                int[] iArr2 = iArr;
                if (adqVar3 instanceof bjp) {
                    bjp bjpVar = (bjp) adqVar3;
                    z15 = z17;
                    if (bjpVar.i == 1) {
                        int i20 = bjpVar.b;
                        if (i20 != -1) {
                            bjpVar.dn(i20);
                        } else if (bjpVar.c != -1 && g()) {
                            bjpVar.dn(cq() - bjpVar.c);
                        } else if (g()) {
                            bjpVar.dn((int) ((bjpVar.a * cq()) + 0.5f));
                        }
                        z15 = true;
                    }
                } else {
                    z15 = z17;
                    if ((adqVar3 instanceof nb) && ((nb) adqVar3).j() == 0) {
                        z17 = z15;
                        z18 = true;
                    }
                    i18 = i19 + 1;
                    iArr = iArr2;
                }
                z17 = z15;
                i18 = i19 + 1;
                iArr = iArr2;
            }
            r21 = iArr;
            if (z17) {
                for (int i21 = 0; i21 < size3; i21 = i11 + 1) {
                    adq adqVar4 = (adq) arrayList5.get(i21);
                    if (adqVar4 instanceof bjp) {
                        bjp bjpVar2 = (bjp) adqVar4;
                        i11 = i21;
                        if (bjpVar2.i == 1) {
                            KotlinHelpers2.aw(0, adgVar2, bjpVar2, z16);
                        }
                    } else {
                        i11 = i21;
                    }
                }
            }
            KotlinHelpers2.aw(0, adgVar2, this, z16);
            if (z18) {
                for (int i22 = 0; i22 < size3; i22++) {
                    adq adqVar5 = (adq) arrayList5.get(i22);
                    if (adqVar5 instanceof nb) {
                        nb nbVar = (nb) adqVar5;
                        if (nbVar.j() == 0 && nbVar.i()) {
                            KotlinHelpers2.aw(1, adgVar2, nbVar, z16);
                        }
                    }
                }
            }
            if (i16 == 1) {
                dg(0, cm());
            } else {
                adbVar4.u(0);
                this.bj = 0;
            }
            int i23 = 0;
            boolean z19 = false;
            boolean z20 = false;
            while (i23 < size3) {
                adq adqVar6 = (adq) arrayList5.get(i23);
                int i24 = i23;
                if (adqVar6 instanceof bjp) {
                    bjp bjpVar3 = (bjp) adqVar6;
                    if (bjpVar3.i == 0) {
                        int i25 = bjpVar3.b;
                        if (i25 != -1) {
                            bjpVar3.dn(i25);
                        } else if (bjpVar3.c != -1 && h()) {
                            bjpVar3.dn(cm() - bjpVar3.c);
                        } else if (h()) {
                            bjpVar3.dn((int) ((bjpVar3.a * cm()) + 0.5f));
                        }
                        z19 = true;
                    }
                } else if ((adqVar6 instanceof nb) && ((nb) adqVar6).j() == 1) {
                    z20 = true;
                }
                i23 = i24 + 1;
            }
            if (z19) {
                for (int i26 = 0; i26 < size3; i26++) {
                    adq adqVar7 = (adq) arrayList5.get(i26);
                    if (adqVar7 instanceof bjp) {
                        bjp bjpVar4 = (bjp) adqVar7;
                        if (bjpVar4.i == 0) {
                            KotlinHelpers2.bp(1, adgVar2, bjpVar4);
                        }
                    }
                }
            }
            KotlinHelpers2.bp(0, adgVar2, this);
            if (z20) {
                for (int i27 = 0; i27 < size3; i27++) {
                    adq adqVar8 = (adq) arrayList5.get(i27);
                    if (adqVar8 instanceof nb) {
                        nb nbVar2 = (nb) adqVar8;
                        if (nbVar2.j() == 1 && nbVar2.i()) {
                            KotlinHelpers2.bp(1, adgVar2, nbVar2);
                        }
                    }
                }
            }
            for (int i28 = 0; i28 < size3; i28++) {
                adq adqVar9 = (adq) arrayList5.get(i28);
                if (adqVar9.cz() && KotlinHelpers2.am(adqVar9)) {
                    ed(adqVar9, adgVar2, KotlinHelpers2.ae);
                    if (!(adqVar9 instanceof bjp)) {
                        KotlinHelpers2.aw(0, adgVar2, adqVar9, z16);
                        KotlinHelpers2.bp(0, adgVar2, adqVar9);
                    } else if (((bjp) adqVar9).i == 0) {
                        KotlinHelpers2.bp(0, adgVar2, adqVar9);
                    } else {
                        KotlinHelpers2.aw(0, adgVar2, adqVar9, z16);
                    }
                }
            }
            for (int i29 = 0; i29 < size2; i29++) {
                adq adqVar10 = (adq) this.a.get(i29);
                if (adqVar10.cz() && !(adqVar10 instanceof bjp) && !(adqVar10 instanceof nb) && !(adqVar10 instanceof bbp) && !adqVar10.ap) {
                    int iCl = adqVar10.cl(0);
                    int iCl2 = adqVar10.cl(1);
                    if (iCl != 3 || adqVar10.ab == 1 || iCl2 != 3 || adqVar10.ac == 1) {
                        ed(adqVar10, this.i, new of());
                    }
                }
            }
        } else {
            zArr = zArr2;
            r21 = iArr;
        }
        bvm bvmVar = this.dn;
        if (size2 > 2 && ((i13 == 2 || i12 == 2) && HugeSyntheticPileOfHelpers.az(this.du, 1024))) {
            adg adgVar3 = this.i;
            ArrayList arrayList6 = this.a;
            int size4 = arrayList6.size();
            int i30 = 0;
            while (true) {
                if (i30 >= size4) {
                    adbVar = adbVar5;
                    int i31 = 0;
                    ArrayList arrayList7 = null;
                    ArrayList arrayList8 = null;
                    ArrayList arrayList9 = null;
                    ArrayList arrayList10 = null;
                    ArrayList arrayList11 = null;
                    ArrayList arrayList12 = null;
                    while (i31 < size4) {
                        int i32 = i31;
                        adq adqVar11 = (adq) arrayList6.get(i31);
                        ArrayList arrayList13 = arrayList7;
                        ?? r3 = r21[0];
                        ArrayList arrayList14 = arrayList8;
                        ?? r6 = r21[1];
                        ArrayList arrayList15 = arrayList9;
                        int[] iArr3 = adqVar11.bz;
                        ArrayList arrayList16 = arrayList10;
                        if (!StaticHelpers7.bf(r3, r6, iArr3[0], iArr3[1])) {
                            ed(adqVar11, adgVar3, this.ec);
                        }
                        boolean z21 = adqVar11 instanceof bjp;
                        if (z21) {
                            bjp bjpVar5 = (bjp) adqVar11;
                            if (bjpVar5.i == 0) {
                                arrayList9 = arrayList15 == null ? new ArrayList() : arrayList15;
                                arrayList9.add(bjpVar5);
                            } else {
                                arrayList9 = arrayList15;
                            }
                            z14 = z21;
                            if (bjpVar5.i == 1) {
                                arrayList2 = arrayList13 == null ? new ArrayList() : arrayList13;
                                arrayList2.add(bjpVar5);
                            } else {
                                arrayList2 = arrayList13;
                            }
                        } else {
                            z14 = z21;
                            arrayList2 = arrayList13;
                            arrayList9 = arrayList15;
                        }
                        if (adqVar11 instanceof bkw) {
                            if (adqVar11 instanceof nb) {
                                nb nbVar3 = (nb) adqVar11;
                                if (nbVar3.j() == 0) {
                                    arrayList4 = arrayList14 == null ? new ArrayList() : arrayList14;
                                    arrayList4.add(nbVar3);
                                } else {
                                    arrayList4 = arrayList14;
                                }
                                arrayList3 = arrayList2;
                                adgVar = adgVar3;
                                if (nbVar3.j() == 1) {
                                    ArrayList arrayList17 = arrayList16 == null ? new ArrayList() : arrayList16;
                                    arrayList17.add(nbVar3);
                                    arrayList16 = arrayList17;
                                }
                                arrayList8 = arrayList4;
                            } else {
                                arrayList3 = arrayList2;
                                adgVar = adgVar3;
                                bkw bkwVar = (bkw) adqVar11;
                                arrayList8 = arrayList14 == null ? new ArrayList() : arrayList14;
                                arrayList8.add(bkwVar);
                                arrayList10 = arrayList16 == null ? new ArrayList() : arrayList16;
                                arrayList10.add(bkwVar);
                            }
                            if (adqVar11.as.f == null && adqVar11.au.f == null && !z14 && !(adqVar11 instanceof nb)) {
                                if (arrayList11 == null) {
                                    arrayList11 = new ArrayList();
                                }
                                ArrayList arrayList18 = arrayList11;
                                arrayList18.add(adqVar11);
                                arrayList11 = arrayList18;
                            }
                            if (adqVar11.at.f != null && adqVar11.av.f == null && adqVar11.aw.f == null && !z14 && !(adqVar11 instanceof nb)) {
                                if (arrayList12 == null) {
                                    arrayList12 = new ArrayList();
                                }
                                ArrayList arrayList19 = arrayList12;
                                arrayList19.add(adqVar11);
                                arrayList12 = arrayList19;
                            }
                            i31 = i32 + 1;
                            arrayList7 = arrayList3;
                            adgVar3 = adgVar;
                        } else {
                            arrayList3 = arrayList2;
                            adgVar = adgVar3;
                            arrayList8 = arrayList14;
                        }
                        arrayList10 = arrayList16;
                        if (adqVar11.as.f == null) {
                            if (arrayList11 == null) {
                                arrayList11 = new ArrayList();
                            }
                            ArrayList arrayList182 = arrayList11;
                            arrayList182.add(adqVar11);
                            arrayList11 = arrayList182;
                        }
                        if (adqVar11.at.f != null) {
                        }
                        i31 = i32 + 1;
                        arrayList7 = arrayList3;
                        adgVar3 = adgVar;
                    }
                    ArrayList arrayList20 = arrayList7;
                    ArrayList<bkw> arrayList21 = arrayList8;
                    ArrayList arrayList22 = arrayList9;
                    ArrayList<bkw> arrayList23 = arrayList10;
                    ArrayList<eum> arrayList24 = new ArrayList();
                    if (arrayList20 != null) {
                        Iterator it = arrayList20.iterator();
                        while (it.hasNext()) {
                            StaticHelpers7.ai((bjp) it.next(), 0, arrayList24, null);
                        }
                    }
                    eum eumVar5 = null;
                    int i33 = 0;
                    if (arrayList21 != null) {
                        for (bkw bkwVar2 : arrayList21) {
                            eum eumVarAi = StaticHelpers7.ai(bkwVar2, i33, arrayList24, eumVar5);
                            bkwVar2.ex(i33, arrayList24, eumVarAi);
                            eumVarAi.g(arrayList24);
                            eumVar5 = null;
                            i33 = 0;
                        }
                    }
                    HashSet hashSet = ck(2).a;
                    if (hashSet != null) {
                        Iterator it2 = hashSet.iterator();
                        while (it2.hasNext()) {
                            StaticHelpers7.ai(((adb) it2.next()).d, 0, arrayList24, null);
                        }
                    }
                    HashSet hashSet2 = ck(4).a;
                    if (hashSet2 != null) {
                        Iterator it3 = hashSet2.iterator();
                        while (it3.hasNext()) {
                            StaticHelpers7.ai(((adb) it3.next()).d, 0, arrayList24, null);
                        }
                    }
                    HashSet hashSet3 = ck(7).a;
                    if (hashSet3 != null) {
                        Iterator it4 = hashSet3.iterator();
                        while (it4.hasNext()) {
                            StaticHelpers7.ai(((adb) it4.next()).d, 0, arrayList24, null);
                        }
                    }
                    eum eumVar6 = null;
                    if (arrayList11 != null) {
                        Iterator it5 = arrayList11.iterator();
                        while (it5.hasNext()) {
                            StaticHelpers7.ai((adq) it5.next(), 0, arrayList24, null);
                        }
                    }
                    if (arrayList22 != null) {
                        Iterator it6 = arrayList22.iterator();
                        while (it6.hasNext()) {
                            StaticHelpers7.ai((bjp) it6.next(), 1, arrayList24, null);
                        }
                    }
                    int i34 = 1;
                    if (arrayList23 != null) {
                        for (bkw bkwVar3 : arrayList23) {
                            eum eumVarAi2 = StaticHelpers7.ai(bkwVar3, i34, arrayList24, eumVar6);
                            bkwVar3.ex(i34, arrayList24, eumVarAi2);
                            eumVarAi2.g(arrayList24);
                            eumVar6 = null;
                            i34 = 1;
                        }
                    }
                    HashSet hashSet4 = ck(3).a;
                    if (hashSet4 != null) {
                        Iterator it7 = hashSet4.iterator();
                        while (it7.hasNext()) {
                            StaticHelpers7.ai(((adb) it7.next()).d, 1, arrayList24, null);
                        }
                    }
                    HashSet hashSet5 = ck(6).a;
                    if (hashSet5 != null) {
                        Iterator it8 = hashSet5.iterator();
                        while (it8.hasNext()) {
                            StaticHelpers7.ai(((adb) it8.next()).d, 1, arrayList24, null);
                        }
                    }
                    HashSet hashSet6 = ck(5).a;
                    if (hashSet6 != null) {
                        Iterator it9 = hashSet6.iterator();
                        while (it9.hasNext()) {
                            StaticHelpers7.ai(((adb) it9.next()).d, 1, arrayList24, null);
                        }
                    }
                    HashSet hashSet7 = ck(7).a;
                    if (hashSet7 != null) {
                        Iterator it10 = hashSet7.iterator();
                        while (it10.hasNext()) {
                            StaticHelpers7.ai(((adb) it10.next()).d, 1, arrayList24, null);
                        }
                    }
                    boolean z22 = true;
                    if (arrayList12 != null) {
                        Iterator it11 = arrayList12.iterator();
                        while (it11.hasNext()) {
                            StaticHelpers7.ai((adq) it11.next(), 1, arrayList24, null);
                        }
                    }
                    int i35 = 0;
                    while (i35 < size4) {
                        adq adqVar12 = (adq) arrayList6.get(i35);
                        int[] iArr4 = adqVar12.bz;
                        boolean z23 = z22;
                        if (iArr4[0] == 3 && iArr4[z23 ? 1 : 0] == 3) {
                            int i36 = adqVar12.bx;
                            int size5 = arrayList24.size();
                            int i37 = 0;
                            while (true) {
                                if (i37 >= size5) {
                                    i10 = i35;
                                    arrayList = arrayList6;
                                    eumVar3 = null;
                                    break;
                                }
                                i10 = i35;
                                eumVar3 = (eum) arrayList24.get(i37);
                                arrayList = arrayList6;
                                if (i36 == eumVar3.c) {
                                    break;
                                }
                                i37++;
                                arrayList6 = arrayList;
                                i35 = i10;
                            }
                            int i38 = adqVar12.by;
                            int size6 = arrayList24.size();
                            int i39 = 0;
                            while (true) {
                                if (i39 >= size6) {
                                    eumVar4 = null;
                                    break;
                                }
                                eumVar4 = (eum) arrayList24.get(i39);
                                if (i38 == eumVar4.c) {
                                    break;
                                } else {
                                    i39++;
                                }
                            }
                            if (eumVar3 != null && eumVar4 != null) {
                                eumVar3.i(0, eumVar4);
                                eumVar4.d = 2;
                                arrayList24.remove(eumVar3);
                            }
                        } else {
                            i10 = i35;
                            arrayList = arrayList6;
                        }
                        i35 = i10 + 1;
                        arrayList6 = arrayList;
                        z22 = true;
                    }
                    if (arrayList24.size() <= 1) {
                        break;
                    }
                    int i40 = 0;
                    if (r21[0] == 2) {
                        int i41 = 0;
                        eumVar = null;
                        for (eum eumVar7 : arrayList24) {
                            if (eumVar7.d != 1) {
                                int iH2 = eumVar7.h(bvmVar, i40);
                                if (iH2 > i41) {
                                    eumVar = eumVar7;
                                    i41 = iH2;
                                }
                                i40 = 0;
                            }
                        }
                        if (eumVar != null) {
                            di(1);
                            dk(i41);
                        } else {
                            eumVar = null;
                        }
                    } else {
                        eumVar = null;
                    }
                    if (r21[1] == 2) {
                        int i42 = 0;
                        eumVar2 = null;
                        for (eum eumVar8 : arrayList24) {
                            if (eumVar8.d != 0 && (iH = eumVar8.h(bvmVar, 1)) > i42) {
                                eumVar2 = eumVar8;
                                i42 = iH;
                            }
                        }
                        if (eumVar2 != null) {
                            dj(1);
                            dh(i42);
                        } else {
                            eumVar2 = null;
                        }
                    } else {
                        eumVar2 = null;
                    }
                    if (eumVar != null || eumVar2 != null) {
                        if (i13 == 2) {
                            if (iMax7 >= cq() || iMax7 <= 0) {
                                iMax7 = cq();
                            } else {
                                dk(iMax7);
                                this.dv = true;
                            }
                        }
                        if (i12 == 2) {
                            if (iMax8 >= cm() || iMax8 <= 0) {
                                iMax8 = cm();
                            } else {
                                dh(iMax8);
                                this.dw = true;
                            }
                        }
                        i = iMax7;
                        z = true;
                        break;
                    }
                } else {
                    adq adqVar13 = (adq) arrayList6.get(i30);
                    ?? r32 = r21[0];
                    ?? r62 = r21[1];
                    int i43 = i30;
                    int[] iArr5 = adqVar13.bz;
                    adbVar = adbVar5;
                    if (StaticHelpers7.bf(r32, r62, iArr5[0], iArr5[1]) && !(adqVar13 instanceof bbp)) {
                        i30 = i43 + 1;
                        adbVar5 = adbVar;
                    }
                }
            }
            boolean z24 = !ei(64) || ei(128);
            bvmVar.getClass();
            bvmVar.i = false;
            if (this.du == 0 && z24) {
                c = 1;
                bvmVar.i = true;
            }
            ArrayList arrayList25 = this.a;
            z2 = r21[0] != 2 || r21[c] == 2;
            this.dq = 0;
            this.dr = 0;
            for (i2 = 0; i2 < size2; i2++) {
                adqVar2 = (adq) this.a.get(i2);
                if (adqVar2 instanceof adr) {
                    ((adr) adqVar2).eh();
                }
            }
            zEi = ei(64);
            r13 = z;
            i3 = 0;
            z3 = true;
            while (z3) {
                i4 = i3 + 1;
                try {
                    bvmVar.ak();
                    this.dq = 0;
                    this.dr = 0;
                    ci(bvmVar);
                    for (i9 = 0; i9 < size2; i9++) {
                        ((adq) this.a.get(i9)).ci(bvmVar);
                    }
                    ef(bvmVar);
                    try {
                        weakReference = this.dx;
                        if (weakReference != null || weakReference.get() == null) {
                            z4 = z2;
                        } else {
                            z4 = z2;
                            try {
                                bvmVar.x(bvmVar.ac((adb) this.dx.get()), bvmVar.ac(adbVar4), 0, 5);
                                this.dx = null;
                            } catch (Exception e) {
                                e = e;
                                z13 = true;
                                e.printStackTrace();
                                adbVar2 = adbVar4;
                                System.out.println("EXCEPTION : " + e);
                                z5 = z13;
                                if (z5) {
                                    zArr[2] = false;
                                    zEi2 = ei(64);
                                    dm(bvmVar, zEi2);
                                    size = this.a.size();
                                    i8 = 0;
                                    z12 = false;
                                    while (i8 < size) {
                                        adqVar = (adq) this.a.get(i8);
                                        adqVar.dm(bvmVar, zEi2);
                                        boolean z25 = zEi2;
                                        int i44 = size;
                                        z12 = adqVar.r == -1 ? true : true;
                                        i8++;
                                        zEi2 = z25;
                                        size = i44;
                                        z12 = z12;
                                    }
                                    z6 = z12;
                                } else {
                                    dm(bvmVar, zEi);
                                    for (i5 = 0; i5 < size2; i5++) {
                                        ((adq) this.a.get(i5)).dm(bvmVar, zEi);
                                    }
                                    z6 = false;
                                }
                                if (z4) {
                                    iMax3 = 0;
                                    iMax4 = 0;
                                    for (i7 = 0; i7 < size2; i7++) {
                                        adq adqVar14 = (adq) this.a.get(i7);
                                        iMax4 = Math.max(iMax4, adqVar14.cq() + adqVar14.bi);
                                        iMax3 = Math.max(iMax3, adqVar14.cm() + adqVar14.bj);
                                    }
                                    iMax5 = Math.max(this.bl, iMax4);
                                    iMax6 = Math.max(this.bm, iMax3);
                                    r13 = r13;
                                    z6 = z6;
                                    if (i13 == 2) {
                                        r13 = r13;
                                        z6 = z6;
                                        dk(iMax5);
                                        r21[0] = 2;
                                        r13 = 1;
                                        z6 = true;
                                    }
                                    if (i12 == 2) {
                                        dh(iMax6);
                                        r21[1] = 2;
                                        r13 = 1;
                                        z6 = true;
                                    }
                                }
                                iMax = Math.max(this.bl, cq());
                                if (iMax > cq()) {
                                    dk(iMax);
                                    r10 = 1;
                                    r21[0] = 1;
                                    z7 = true;
                                    r17 = 1;
                                } else {
                                    r10 = 1;
                                    r17 = r13;
                                    z7 = z6;
                                }
                                iMax2 = Math.max(this.bm, cm());
                                if (iMax2 > cm()) {
                                    dh(iMax2);
                                    r21[r10] = r10;
                                    r04 = r10;
                                    z8 = r04 == true ? 1 : 0;
                                } else {
                                    r0 = r17;
                                }
                                if (r0 == 0) {
                                    z8 = z7;
                                    if (r21[0] == 2) {
                                        r03 = r0;
                                        z11 = z8;
                                        if (cq() > i) {
                                            this.dv = r10;
                                            r21[0] = r10;
                                            dk(i);
                                            ?? r05 = r10;
                                            z11 = r05 == true ? 1 : 0;
                                            r03 = r05;
                                        }
                                    }
                                    r0 = r04;
                                    r03 = r0;
                                    r03 = r0;
                                    z11 = z8;
                                    z11 = z8;
                                    r02 = r03;
                                    r02 = r03;
                                    z9 = z11;
                                    z9 = z11;
                                    if (r21[r10] != 2) {
                                    }
                                    if (i4 > i6) {
                                        r02 = r03;
                                        z9 = z11;
                                        z10 = false;
                                    } else {
                                        r02 = r03;
                                        z9 = z11;
                                    }
                                    i3 = i4;
                                    z2 = z4;
                                    adbVar4 = adbVar2;
                                    r13 = r132;
                                    z3 = z10;
                                } else {
                                    z8 = z7;
                                    r0 = r04;
                                    r02 = r0;
                                    z9 = z8;
                                }
                                r02 = r03;
                                z9 = z11;
                                r132 = r02;
                                i6 = 8;
                                z10 = z9;
                                if (i4 > i6) {
                                    r02 = r03;
                                    z9 = z11;
                                    z10 = false;
                                } else {
                                    r02 = r03;
                                    z9 = z11;
                                }
                                i3 = i4;
                                z2 = z4;
                                adbVar4 = adbVar2;
                                r13 = r132;
                                z3 = z10;
                            }
                        }
                        weakReference2 = this.dz;
                        if (weakReference2 != null && weakReference2.get() != null) {
                            bvmVar.x(bvmVar.ac(this.av), bvmVar.ac((adb) this.dz.get()), 0, 5);
                            this.dz = null;
                        }
                        weakReference3 = this.dy;
                        if (weakReference3 != null && weakReference3.get() != null) {
                            adbVar3 = adbVar;
                            try {
                                adbVar = adbVar3;
                                bvmVar.x(bvmVar.ac((adb) this.dy.get()), bvmVar.ac(adbVar3), 0, 5);
                                this.dy = null;
                            } catch (Exception e2) {
                                e = e2;
                                adbVar = adbVar3;
                                z13 = true;
                                e.printStackTrace();
                                adbVar2 = adbVar4;
                                System.out.println("EXCEPTION : " + e);
                                z5 = z13;
                                if (z5) {
                                    zArr[2] = false;
                                    zEi2 = ei(64);
                                    dm(bvmVar, zEi2);
                                    size = this.a.size();
                                    i8 = 0;
                                    z12 = false;
                                    while (i8 < size) {
                                        adqVar = (adq) this.a.get(i8);
                                        adqVar.dm(bvmVar, zEi2);
                                        boolean z252 = zEi2;
                                        int i442 = size;
                                        if (adqVar.r == -1) {
                                        }
                                        i8++;
                                        zEi2 = z252;
                                        size = i442;
                                        z12 = z12;
                                    }
                                    z6 = z12;
                                } else {
                                    dm(bvmVar, zEi);
                                    while (i5 < size2) {
                                        ((adq) this.a.get(i5)).dm(bvmVar, zEi);
                                    }
                                    z6 = false;
                                }
                                if (z4) {
                                    iMax3 = 0;
                                    iMax4 = 0;
                                    while (i7 < size2) {
                                        adq adqVar142 = (adq) this.a.get(i7);
                                        iMax4 = Math.max(iMax4, adqVar142.cq() + adqVar142.bi);
                                        iMax3 = Math.max(iMax3, adqVar142.cm() + adqVar142.bj);
                                    }
                                    iMax5 = Math.max(this.bl, iMax4);
                                    iMax6 = Math.max(this.bm, iMax3);
                                    r13 = r13;
                                    z6 = z6;
                                    if (i13 == 2) {
                                        r13 = r13;
                                        z6 = z6;
                                        dk(iMax5);
                                        r21[0] = 2;
                                        r13 = 1;
                                        z6 = true;
                                    }
                                    if (i12 == 2) {
                                        dh(iMax6);
                                        r21[1] = 2;
                                        r13 = 1;
                                        z6 = true;
                                    }
                                }
                                iMax = Math.max(this.bl, cq());
                                if (iMax > cq()) {
                                    dk(iMax);
                                    r10 = 1;
                                    r21[0] = 1;
                                    z7 = true;
                                    r17 = 1;
                                } else {
                                    r10 = 1;
                                    r17 = r13;
                                    z7 = z6;
                                }
                                iMax2 = Math.max(this.bm, cm());
                                if (iMax2 > cm()) {
                                    dh(iMax2);
                                    r21[r10] = r10;
                                    r04 = r10;
                                    z8 = r04 == true ? 1 : 0;
                                } else {
                                    r0 = r17;
                                }
                                if (r0 == 0) {
                                    z8 = z7;
                                    if (r21[0] == 2) {
                                        r03 = r0;
                                        z11 = z8;
                                        if (cq() > i) {
                                            this.dv = r10;
                                            r21[0] = r10;
                                            dk(i);
                                            ?? r052 = r10;
                                            z11 = r052 == true ? 1 : 0;
                                            r03 = r052;
                                        }
                                    }
                                    r0 = r04;
                                    r03 = r0;
                                    r03 = r0;
                                    z11 = z8;
                                    z11 = z8;
                                    r02 = r03;
                                    r02 = r03;
                                    z9 = z11;
                                    z9 = z11;
                                    if (r21[r10] != 2) {
                                    }
                                    if (i4 > i6) {
                                        r02 = r03;
                                        z9 = z11;
                                        z10 = false;
                                    } else {
                                        r02 = r03;
                                        z9 = z11;
                                    }
                                    i3 = i4;
                                    z2 = z4;
                                    adbVar4 = adbVar2;
                                    r13 = r132;
                                    z3 = z10;
                                } else {
                                    z8 = z7;
                                    r0 = r04;
                                    r02 = r0;
                                    z9 = z8;
                                }
                                r02 = r03;
                                z9 = z11;
                                r132 = r02;
                                i6 = 8;
                                z10 = z9;
                                if (i4 > i6) {
                                    r02 = r03;
                                    z9 = z11;
                                    z10 = false;
                                } else {
                                    r02 = r03;
                                    z9 = z11;
                                }
                                i3 = i4;
                                z2 = z4;
                                adbVar4 = adbVar2;
                                r13 = r132;
                                z3 = z10;
                            }
                        }
                        weakReference4 = this.ea;
                        if (weakReference4 == null && weakReference4.get() != null) {
                            try {
                                try {
                                    bvmVar.x(bvmVar.ac(this.au), bvmVar.ac((adb) this.ea.get()), 0, 5);
                                } catch (Exception e3) {
                                    e = e3;
                                    z13 = true;
                                    e.printStackTrace();
                                    adbVar2 = adbVar4;
                                    System.out.println("EXCEPTION : " + e);
                                    z5 = z13;
                                    if (z5) {
                                        zArr[2] = false;
                                        zEi2 = ei(64);
                                        dm(bvmVar, zEi2);
                                        size = this.a.size();
                                        i8 = 0;
                                        z12 = false;
                                        while (i8 < size) {
                                            adqVar = (adq) this.a.get(i8);
                                            adqVar.dm(bvmVar, zEi2);
                                            boolean z2522 = zEi2;
                                            int i4422 = size;
                                            if (adqVar.r == -1) {
                                            }
                                            i8++;
                                            zEi2 = z2522;
                                            size = i4422;
                                            z12 = z12;
                                        }
                                        z6 = z12;
                                    } else {
                                        dm(bvmVar, zEi);
                                        while (i5 < size2) {
                                            ((adq) this.a.get(i5)).dm(bvmVar, zEi);
                                        }
                                        z6 = false;
                                    }
                                    if (z4) {
                                        iMax3 = 0;
                                        iMax4 = 0;
                                        while (i7 < size2) {
                                            adq adqVar1422 = (adq) this.a.get(i7);
                                            iMax4 = Math.max(iMax4, adqVar1422.cq() + adqVar1422.bi);
                                            iMax3 = Math.max(iMax3, adqVar1422.cm() + adqVar1422.bj);
                                        }
                                        iMax5 = Math.max(this.bl, iMax4);
                                        iMax6 = Math.max(this.bm, iMax3);
                                        r13 = r13;
                                        z6 = z6;
                                        if (i13 == 2) {
                                            r13 = r13;
                                            z6 = z6;
                                            dk(iMax5);
                                            r21[0] = 2;
                                            r13 = 1;
                                            z6 = true;
                                        }
                                        if (i12 == 2) {
                                            dh(iMax6);
                                            r21[1] = 2;
                                            r13 = 1;
                                            z6 = true;
                                        }
                                    }
                                    iMax = Math.max(this.bl, cq());
                                    if (iMax > cq()) {
                                        dk(iMax);
                                        r10 = 1;
                                        r21[0] = 1;
                                        z7 = true;
                                        r17 = 1;
                                    } else {
                                        r10 = 1;
                                        r17 = r13;
                                        z7 = z6;
                                    }
                                    iMax2 = Math.max(this.bm, cm());
                                    if (iMax2 > cm()) {
                                        dh(iMax2);
                                        r21[r10] = r10;
                                        r04 = r10;
                                        z8 = r04 == true ? 1 : 0;
                                    } else {
                                        r0 = r17;
                                    }
                                    if (r0 == 0) {
                                        z8 = z7;
                                        if (r21[0] == 2) {
                                            r03 = r0;
                                            z11 = z8;
                                            if (cq() > i) {
                                                this.dv = r10;
                                                r21[0] = r10;
                                                dk(i);
                                                ?? r0522 = r10;
                                                z11 = r0522 == true ? 1 : 0;
                                                r03 = r0522;
                                            }
                                        }
                                        r0 = r04;
                                        r03 = r0;
                                        r03 = r0;
                                        z11 = z8;
                                        z11 = z8;
                                        r02 = r03;
                                        r02 = r03;
                                        z9 = z11;
                                        z9 = z11;
                                        if (r21[r10] != 2) {
                                        }
                                        if (i4 > i6) {
                                            r02 = r03;
                                            z9 = z11;
                                            z10 = false;
                                        } else {
                                            r02 = r03;
                                            z9 = z11;
                                        }
                                        i3 = i4;
                                        z2 = z4;
                                        adbVar4 = adbVar2;
                                        r13 = r132;
                                        z3 = z10;
                                    } else {
                                        z8 = z7;
                                        r0 = r04;
                                        r02 = r0;
                                        z9 = z8;
                                    }
                                    r02 = r03;
                                    z9 = z11;
                                    r132 = r02;
                                    i6 = 8;
                                    z10 = z9;
                                    if (i4 > i6) {
                                        r02 = r03;
                                        z9 = z11;
                                        z10 = false;
                                    } else {
                                        r02 = r03;
                                        z9 = z11;
                                    }
                                    i3 = i4;
                                    z2 = z4;
                                    adbVar4 = adbVar2;
                                    r13 = r132;
                                    z3 = z10;
                                }
                                try {
                                    this.ea = null;
                                } catch (Exception e4) {
                                    e = e4;
                                    z13 = true;
                                    e.printStackTrace();
                                    adbVar2 = adbVar4;
                                    System.out.println("EXCEPTION : " + e);
                                    z5 = z13;
                                }
                            } catch (Exception e5) {
                                e = e5;
                            }
                        }
                        bvmVar.ag();
                        adbVar2 = adbVar4;
                        z5 = true;
                    } catch (Exception e6) {
                        e = e6;
                        z4 = z2;
                    }
                } catch (Exception e7) {
                    e = e7;
                    z4 = z2;
                    z13 = z3;
                }
                if (z5) {
                    zArr[2] = false;
                    zEi2 = ei(64);
                    dm(bvmVar, zEi2);
                    size = this.a.size();
                    i8 = 0;
                    z12 = false;
                    while (i8 < size) {
                        adqVar = (adq) this.a.get(i8);
                        adqVar.dm(bvmVar, zEi2);
                        boolean z25222 = zEi2;
                        int i44222 = size;
                        if (adqVar.r == -1 || adqVar.s != -1) {
                        }
                        i8++;
                        zEi2 = z25222;
                        size = i44222;
                        z12 = z12;
                    }
                    z6 = z12;
                } else {
                    dm(bvmVar, zEi);
                    while (i5 < size2) {
                        ((adq) this.a.get(i5)).dm(bvmVar, zEi);
                    }
                    z6 = false;
                }
                if (z4 && i4 < 8 && zArr[2]) {
                    iMax3 = 0;
                    iMax4 = 0;
                    while (i7 < size2) {
                        adq adqVar14222 = (adq) this.a.get(i7);
                        iMax4 = Math.max(iMax4, adqVar14222.cq() + adqVar14222.bi);
                        iMax3 = Math.max(iMax3, adqVar14222.cm() + adqVar14222.bj);
                    }
                    iMax5 = Math.max(this.bl, iMax4);
                    iMax6 = Math.max(this.bm, iMax3);
                    r13 = r13;
                    z6 = z6;
                    if (i13 == 2 && cq() < iMax5) {
                        r13 = r13;
                        z6 = z6;
                        dk(iMax5);
                        r21[0] = 2;
                        r13 = 1;
                        z6 = true;
                    }
                    if (i12 == 2 && cm() < iMax6) {
                        dh(iMax6);
                        r21[1] = 2;
                        r13 = 1;
                        z6 = true;
                    }
                }
                iMax = Math.max(this.bl, cq());
                if (iMax > cq()) {
                    dk(iMax);
                    r10 = 1;
                    r21[0] = 1;
                    z7 = true;
                    r17 = 1;
                } else {
                    r10 = 1;
                    r17 = r13;
                    z7 = z6;
                }
                iMax2 = Math.max(this.bm, cm());
                if (iMax2 > cm()) {
                    dh(iMax2);
                    r21[r10] = r10;
                    r04 = r10;
                    z8 = r04 == true ? 1 : 0;
                } else {
                    r0 = r17;
                }
                if (r0 == 0) {
                    z8 = z7;
                    if (r21[0] == 2 && i > 0) {
                        r03 = r0;
                        z11 = z8;
                        if (cq() > i) {
                            this.dv = r10;
                            r21[0] = r10;
                            dk(i);
                            ?? r05222 = r10;
                            z11 = r05222 == true ? 1 : 0;
                            r03 = r05222;
                        }
                    }
                    r0 = r04;
                    r03 = r0;
                    r03 = r0;
                    z11 = z8;
                    z11 = z8;
                    r02 = r03;
                    r02 = r03;
                    z9 = z11;
                    z9 = z11;
                    if (r21[r10] != 2 && iMax8 > 0 && cm() > iMax8) {
                        this.dw = r10;
                        r21[r10] = r10;
                        dh(iMax8);
                        i6 = 8;
                        r132 = 1;
                        z10 = true;
                    }
                    if (i4 > i6) {
                        r02 = r03;
                        z9 = z11;
                        z10 = false;
                    } else {
                        r02 = r03;
                        z9 = z11;
                    }
                    i3 = i4;
                    z2 = z4;
                    adbVar4 = adbVar2;
                    r13 = r132;
                    z3 = z10;
                } else {
                    z8 = z7;
                    r0 = r04;
                    r02 = r0;
                    z9 = z8;
                }
                r02 = r03;
                z9 = z11;
                r132 = r02;
                i6 = 8;
                z10 = z9;
                if (i4 > i6) {
                    r02 = r03;
                    z9 = z11;
                    z10 = false;
                } else {
                    r02 = r03;
                    z9 = z11;
                }
                i3 = i4;
                z2 = z4;
                adbVar4 = adbVar2;
                r13 = r132;
                z3 = z10;
            }
            this.a = arrayList25;
            if (r13 != 0) {
                r21[0] = i13;
                r21[1] = i12;
            }
            dd(bvmVar.n);
        }
        adbVar = adbVar5;
        i = iMax7;
        z = false;
        if (ei(64)) {
        }
        bvmVar.getClass();
        bvmVar.i = false;
        c = this.du == 0 ? (char) 1 : (char) 1;
        ArrayList arrayList252 = this.a;
        if (r21[0] != 2) {
        }
        this.dq = 0;
        this.dr = 0;
        while (i2 < size2) {
            adqVar2 = (adq) this.a.get(i2);
            if (adqVar2 instanceof adr) {
                ((adr) adqVar2).eh();
            }
        }
        zEi = ei(64);
        r13 = z;
        i3 = 0;
        z3 = true;
        while (z3) {
            i4 = i3 + 1;
            bvmVar.ak();
            this.dq = 0;
            this.dr = 0;
            ci(bvmVar);
            while (i9 < size2) {
                ((adq) this.a.get(i9)).ci(bvmVar);
            }
            ef(bvmVar);
            weakReference = this.dx;
            if (weakReference != null) {
                z4 = z2;
                weakReference2 = this.dz;
                if (weakReference2 != null) {
                    bvmVar.x(bvmVar.ac(this.av), bvmVar.ac((adb) this.dz.get()), 0, 5);
                    this.dz = null;
                }
                weakReference3 = this.dy;
                if (weakReference3 != null) {
                    adbVar3 = adbVar;
                    adbVar = adbVar3;
                    bvmVar.x(bvmVar.ac((adb) this.dy.get()), bvmVar.ac(adbVar3), 0, 5);
                    this.dy = null;
                }
                weakReference4 = this.ea;
                if (weakReference4 == null) {
                }
                bvmVar.ag();
                adbVar2 = adbVar4;
                z5 = true;
            } else {
                z4 = z2;
                weakReference2 = this.dz;
                if (weakReference2 != null) {
                    bvmVar.x(bvmVar.ac(this.av), bvmVar.ac((adb) this.dz.get()), 0, 5);
                    this.dz = null;
                }
                weakReference3 = this.dy;
                if (weakReference3 != null) {
                    adbVar3 = adbVar;
                    adbVar = adbVar3;
                    bvmVar.x(bvmVar.ac((adb) this.dy.get()), bvmVar.ac(adbVar3), 0, 5);
                    this.dy = null;
                }
                weakReference4 = this.ea;
                if (weakReference4 == null) {
                }
                bvmVar.ag();
                adbVar2 = adbVar4;
                z5 = true;
            }
            if (z5) {
                zArr[2] = false;
                zEi2 = ei(64);
                dm(bvmVar, zEi2);
                size = this.a.size();
                i8 = 0;
                z12 = false;
                while (i8 < size) {
                    adqVar = (adq) this.a.get(i8);
                    adqVar.dm(bvmVar, zEi2);
                    boolean z252222 = zEi2;
                    int i442222 = size;
                    if (adqVar.r == -1) {
                    }
                    i8++;
                    zEi2 = z252222;
                    size = i442222;
                    z12 = z12;
                }
                z6 = z12;
            } else {
                dm(bvmVar, zEi);
                while (i5 < size2) {
                    ((adq) this.a.get(i5)).dm(bvmVar, zEi);
                }
                z6 = false;
            }
            if (z4) {
                iMax3 = 0;
                iMax4 = 0;
                while (i7 < size2) {
                    adq adqVar142222 = (adq) this.a.get(i7);
                    iMax4 = Math.max(iMax4, adqVar142222.cq() + adqVar142222.bi);
                    iMax3 = Math.max(iMax3, adqVar142222.cm() + adqVar142222.bj);
                }
                iMax5 = Math.max(this.bl, iMax4);
                iMax6 = Math.max(this.bm, iMax3);
                r13 = r13;
                z6 = z6;
                if (i13 == 2) {
                    r13 = r13;
                    z6 = z6;
                    dk(iMax5);
                    r21[0] = 2;
                    r13 = 1;
                    z6 = true;
                }
                if (i12 == 2) {
                    dh(iMax6);
                    r21[1] = 2;
                    r13 = 1;
                    z6 = true;
                }
            }
            iMax = Math.max(this.bl, cq());
            if (iMax > cq()) {
                dk(iMax);
                r10 = 1;
                r21[0] = 1;
                z7 = true;
                r17 = 1;
            } else {
                r10 = 1;
                r17 = r13;
                z7 = z6;
            }
            iMax2 = Math.max(this.bm, cm());
            if (iMax2 > cm()) {
                dh(iMax2);
                r21[r10] = r10;
                r04 = r10;
                z8 = r04 == true ? 1 : 0;
            } else {
                r0 = r17;
            }
            if (r0 == 0) {
                z8 = z7;
                if (r21[0] == 2) {
                    r03 = r0;
                    z11 = z8;
                    if (cq() > i) {
                        this.dv = r10;
                        r21[0] = r10;
                        dk(i);
                        ?? r052222 = r10;
                        z11 = r052222 == true ? 1 : 0;
                        r03 = r052222;
                    }
                }
                r0 = r04;
                r03 = r0;
                r03 = r0;
                z11 = z8;
                z11 = z8;
                r02 = r03;
                r02 = r03;
                z9 = z11;
                z9 = z11;
                if (r21[r10] != 2) {
                }
                if (i4 > i6) {
                    r02 = r03;
                    z9 = z11;
                    z10 = false;
                } else {
                    r02 = r03;
                    z9 = z11;
                }
                i3 = i4;
                z2 = z4;
                adbVar4 = adbVar2;
                r13 = r132;
                z3 = z10;
            } else {
                z8 = z7;
                r0 = r04;
                r02 = r0;
                z9 = z8;
            }
            r02 = r03;
            z9 = z11;
            r132 = r02;
            i6 = 8;
            z10 = z9;
            if (i4 > i6) {
                r02 = r03;
                z9 = z11;
                z10 = false;
            } else {
                r02 = r03;
                z9 = z11;
            }
            i3 = i4;
            z2 = z4;
            adbVar4 = adbVar2;
            r13 = r132;
            z3 = z10;
        }
        this.a = arrayList252;
        if (r13 != 0) {
            r21[0] = i13;
            r21[1] = i12;
        }
        dd(bvmVar.n);
    }

    public final boolean ei(int i) {
        return (this.du & i) == i;
    }
}
