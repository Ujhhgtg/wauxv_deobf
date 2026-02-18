package me.hd.wauxv.obf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class aph {
    public static final LinkedHashSet a = new LinkedHashSet(Arrays.asList(pj.class, bkl.class, aze.class, bmr.class, drl.class, bvu.class, box.class));
    public static final Map b;
    public CharSequence c;
    public boolean f;
    public boolean j;
    public final List k;
    public final cbm l;
    public final List m;
    public final apg n;
    public final ArrayList p;
    public final LinkedHashSet q;
    public int d = 0;
    public int e = 0;
    public int g = 0;
    public int h = 0;
    public int i = 0;
    public final LinkedHashMap o = new LinkedHashMap();

    static {
        HashMap map = new HashMap();
        map.put(pj.class, new pk(0));
        map.put(bkl.class, new pk(2));
        map.put(aze.class, new pk(1));
        map.put(bmr.class, new pk(3));
        map.put(drl.class, new pk(6));
        map.put(bvu.class, new pk(5));
        map.put(box.class, new pk(4));
        b = Collections.unmodifiableMap(map);
    }

    public aph(ArrayList arrayList, cbm cbmVar, ArrayList arrayList2) {
        ArrayList arrayList3 = new ArrayList();
        this.p = arrayList3;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this.q = linkedHashSet;
        this.k = arrayList;
        this.l = cbmVar;
        this.m = arrayList2;
        apg apgVar = new apg(0);
        this.n = apgVar;
        arrayList3.add(apgVar);
        linkedHashSet.add(apgVar);
    }

    public final void aa(int i) {
        int i2;
        int i3 = this.h;
        if (i >= i3) {
            this.d = this.g;
            this.e = i3;
        }
        int length = this.c.length();
        while (true) {
            i2 = this.e;
            if (i2 >= i || this.d == length) {
                break;
            } else {
                u();
            }
        }
        if (i2 <= i) {
            this.f = false;
            return;
        }
        this.d--;
        this.e = i;
        this.f = true;
    }

    public final void ab(int i) {
        int i2 = this.g;
        if (i >= i2) {
            this.d = i2;
            this.e = this.h;
        }
        int length = this.c.length();
        while (true) {
            int i3 = this.d;
            if (i3 >= i || i3 == length) {
                break;
            } else {
                u();
            }
        }
        this.f = false;
    }

    public final void r(p pVar) {
        while (!y().b(pVar.d())) {
            v(y());
        }
        y().d().n(pVar.d());
        this.p.add(pVar);
        this.q.add(pVar);
    }

    public final void s(css cssVar) {
        bvq bvqVar = cssVar.i;
        bvqVar.j();
        for (bvp bvpVar : bvqVar.c) {
            csr csrVar = cssVar.h;
            bvpVar.o();
            coi coiVar = csrVar.l;
            bvpVar.l = coiVar;
            if (coiVar != null) {
                coiVar.m = bvpVar;
            }
            bvpVar.m = csrVar;
            csrVar.l = bvpVar;
            coi coiVar2 = csrVar.i;
            bvpVar.i = coiVar2;
            if (bvpVar.l == null) {
                coiVar2.j = bvpVar;
            }
            String str = bvpVar.d;
            LinkedHashMap linkedHashMap = this.o;
            if (!linkedHashMap.containsKey(str)) {
                linkedHashMap.put(str, bvpVar);
            }
        }
    }

    public final void t() {
        CharSequence charSequenceSubSequence;
        if (this.f) {
            int i = this.d + 1;
            CharSequence charSequence = this.c;
            CharSequence charSequenceSubSequence2 = charSequence.subSequence(i, charSequence.length());
            int i2 = 4 - (this.e % 4);
            StringBuilder sb = new StringBuilder(charSequenceSubSequence2.length() + i2);
            for (int i3 = 0; i3 < i2; i3++) {
                sb.append(' ');
            }
            sb.append(charSequenceSubSequence2);
            charSequenceSubSequence = sb.toString();
        } else {
            CharSequence charSequence2 = this.c;
            charSequenceSubSequence = charSequence2.subSequence(this.d, charSequence2.length());
        }
        y().a(charSequenceSubSequence);
    }

    public final void u() {
        if (this.c.charAt(this.d) != '\t') {
            this.d++;
            this.e++;
        } else {
            this.d++;
            int i = this.e;
            this.e = (4 - (i % 4)) + i;
        }
    }

    public final void v(p pVar) {
        if (y() == pVar) {
            this.p.remove(r0.size() - 1);
        }
        if (pVar instanceof css) {
            s((css) pVar);
        }
        pVar.c();
    }

    public final void w(List list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            v((p) list.get(size));
        }
    }

    public final void x() {
        int i = this.d;
        int i2 = this.e;
        this.j = true;
        int length = this.c.length();
        while (i < length) {
            char cCharAt = this.c.charAt(i);
            if (cCharAt == '\t') {
                i++;
                i2 += 4 - (i2 % 4);
            } else if (cCharAt != ' ') {
                this.j = false;
                break;
            } else {
                i++;
                i2++;
            }
        }
        this.g = i;
        this.h = i2;
        this.i = i2 - this.e;
    }

    public final p y() {
        return (p) dkz.l(1, this.p);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:106:0x01b6. Please report as an issue. */
    /* JADX WARN: Found duplicated region for block: B:152:0x0265  */
    /* JADX WARN: Found duplicated region for block: B:159:0x0277 A[PHI: r21
      0x0277: PHI (r21v11 me.hd.wauxv.obf.p) = 
      (r21v5 me.hd.wauxv.obf.p)
      (r21v6 me.hd.wauxv.obf.p)
      (r21v6 me.hd.wauxv.obf.p)
      (r21v8 me.hd.wauxv.obf.p)
      (r21v8 me.hd.wauxv.obf.p)
      (r21v8 me.hd.wauxv.obf.p)
      (r21v9 me.hd.wauxv.obf.p)
      (r21v9 me.hd.wauxv.obf.p)
      (r21v9 me.hd.wauxv.obf.p)
      (r21v10 me.hd.wauxv.obf.p)
      (r21v10 me.hd.wauxv.obf.p)
      (r21v13 me.hd.wauxv.obf.p)
      (r21v17 me.hd.wauxv.obf.p)
     binds: [B:299:0x0532, B:267:0x04b9, B:296:0x0514, B:201:0x0387, B:258:0x047f, B:264:0x0496, B:186:0x0332, B:188:0x033a, B:387:0x0277, B:178:0x02fd, B:184:0x0326, B:158:0x0275, B:84:0x016c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Found duplicated region for block: B:174:0x02cf  */
    /* JADX WARN: Found duplicated region for block: B:242:0x0424  */
    /* JADX WARN: Found duplicated region for block: B:254:0x0461  */
    /* JADX WARN: Found duplicated region for block: B:256:0x047b  */
    /* JADX WARN: Found duplicated region for block: B:257:0x047d  */
    /* JADX WARN: Found duplicated region for block: B:263:0x0495  */
    /* JADX WARN: Found duplicated region for block: B:295:0x0513  */
    /* JADX WARN: Found duplicated region for block: B:89:0x0186  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r22v0, types: [me.hd.wauxv.obf.aph] */
    /* JADX WARN: Type inference failed for: r4v45 */
    /* JADX WARN: Type inference failed for: r4v50 */
    /* JADX WARN: Type inference failed for: r4v65 */
    /* JADX WARN: Type inference failed for: r4v66 */
    public final void z(String str) {
        p pVar;
        int i;
        po poVar;
        boolean z;
        char cCharAt;
        int i2;
        azf azfVar;
        po poVar2;
        bkm bkmVar;
        int i3;
        StringBuilder sb;
        StringBuilder sb2;
        int i4;
        bvv bvvVar;
        char cCharAt2;
        bvv bvvVar2;
        ?? r4;
        boolean zEquals;
        boolean zEquals2;
        int i5;
        int i6;
        char cCharAt3;
        String string = str;
        int length = string.length();
        int i7 = 0;
        StringBuilder sb3 = null;
        for (int i8 = 0; i8 < length; i8++) {
            char cCharAt4 = string.charAt(i8);
            if (cCharAt4 == 0) {
                if (sb3 == null) {
                    sb3 = new StringBuilder(length);
                    sb3.append((CharSequence) string, 0, i8);
                }
                sb3.append((char) 65533);
            } else if (sb3 != null) {
                sb3.append(cCharAt4);
            }
        }
        if (sb3 != null) {
            string = sb3.toString();
        }
        this.c = string;
        this.d = 0;
        this.e = 0;
        this.f = false;
        ArrayList arrayList = this.p;
        int i9 = 1;
        for (p pVar2 : arrayList.subList(1, arrayList.size())) {
            x();
            pf pfVarG = pVar2.g(this);
            if (pfVarG == null) {
                break;
            }
            if (pfVarG.c) {
                v(pVar2);
                return;
            }
            int i10 = pfVarG.a;
            if (i10 != -1) {
                ab(i10);
            } else {
                int i11 = pfVarG.b;
                if (i11 != -1) {
                    aa(i11);
                }
            }
            i9++;
        }
        ArrayList arrayList2 = new ArrayList(arrayList.subList(i9, arrayList.size()));
        p pVar3 = (p) arrayList.get(i9 - 1);
        boolean zIsEmpty = arrayList2.isEmpty();
        boolean zE = (pVar3.d() instanceof csr) || pVar3.e();
        while (true) {
            if (zE) {
                x();
                if (!this.j) {
                    int i12 = 4;
                    if (this.i >= 4 || !Character.isLetter(Character.codePointAt(this.c, this.g))) {
                        erp erpVar = new erp(pVar3, 17);
                        Iterator it = this.k.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                i = i7;
                                char c = ' ';
                                switch (((pk) it.next()).a) {
                                    case 0:
                                        pVar = pVar3;
                                        int i13 = this.g;
                                        if (pl.i(this, i13)) {
                                            int i14 = this.e + this.i;
                                            int i15 = i14 + 1;
                                            CharSequence charSequence = this.c;
                                            int i16 = i13 + 1;
                                            if (i16 < charSequence.length() && ((cCharAt = charSequence.charAt(i16)) == '\t' || cCharAt == ' ')) {
                                                i15 = i14 + 2;
                                            }
                                            p[] pVarArr = new p[1];
                                            pVarArr[i] = new pl();
                                            poVar = new po(pVarArr);
                                            poVar.b = i15;
                                        } else {
                                            poVar = null;
                                        }
                                        break;
                                    case 1:
                                        pVar = pVar3;
                                        int i17 = this.i;
                                        if (i17 < 4) {
                                            int i18 = this.g;
                                            CharSequence charSequence2 = this.c;
                                            int length2 = charSequence2.length();
                                            int i19 = i18;
                                            int i20 = i;
                                            int i21 = i20;
                                            while (true) {
                                                i2 = i18;
                                                if (i19 < length2) {
                                                    char cCharAt5 = charSequence2.charAt(i19);
                                                    if (cCharAt5 == '`') {
                                                        i20++;
                                                    } else if (cCharAt5 == '~') {
                                                        i21++;
                                                    }
                                                    i19++;
                                                    i18 = i2;
                                                }
                                            }
                                            int i22 = 3;
                                            if (i20 < 3) {
                                                azfVar = (i21 >= i22 || i20 != 0) ? null : new azf('~', i21, i17);
                                            } else if (i21 == 0) {
                                                int i23 = i2 + i20;
                                                int length3 = charSequence2.length();
                                                while (true) {
                                                    if (i23 >= length3) {
                                                        i23 = -1;
                                                    } else if (charSequence2.charAt(i23) != '`') {
                                                        i23++;
                                                    }
                                                }
                                                if (i23 == -1) {
                                                    azfVar = new azf('`', i20, i17);
                                                }
                                            } else {
                                                i22 = 3;
                                                if (i21 >= i22) {
                                                }
                                            }
                                            if (azfVar != null) {
                                                p[] pVarArr2 = new p[1];
                                                pVarArr2[i] = azfVar;
                                                poVar2 = new po(pVarArr2);
                                                poVar2.a = i2 + azfVar.h.e;
                                                poVar = poVar2;
                                            }
                                        }
                                        poVar = null;
                                        break;
                                    case 2:
                                        pVar = pVar3;
                                        if (this.i < 4) {
                                            CharSequence charSequence3 = this.c;
                                            int i24 = this.g;
                                            int iAu = ewz.au('#', i24, charSequence3.length(), charSequence3) - i24;
                                            if (iAu == 0 || iAu > 6) {
                                                bkmVar = null;
                                            } else {
                                                int i25 = i24 + iAu;
                                                if (i25 >= charSequence3.length()) {
                                                    bkmVar = new bkm(iAu, "");
                                                } else {
                                                    char cCharAt6 = charSequence3.charAt(i25);
                                                    char c2 = ' ';
                                                    char c3 = '\t';
                                                    if (cCharAt6 == ' ' || cCharAt6 == '\t') {
                                                        int length4 = charSequence3.length() - 1;
                                                        while (true) {
                                                            if (length4 < i25) {
                                                                length4 = i25 - 1;
                                                            } else {
                                                                char cCharAt7 = charSequence3.charAt(length4);
                                                                if (cCharAt7 == c3 || cCharAt7 == c2) {
                                                                    length4--;
                                                                    c2 = ' ';
                                                                    c3 = '\t';
                                                                }
                                                            }
                                                        }
                                                        int i26 = length4;
                                                        while (true) {
                                                            if (i26 < i25) {
                                                                i26 = i25 - 1;
                                                            } else if (charSequence3.charAt(i26) == '#') {
                                                                i26--;
                                                            }
                                                        }
                                                        int i27 = i26;
                                                        while (true) {
                                                            if (i27 < i25) {
                                                                i27 = i25 - 1;
                                                            } else {
                                                                char cCharAt8 = charSequence3.charAt(i27);
                                                                if (cCharAt8 == '\t' || cCharAt8 == ' ') {
                                                                    i27--;
                                                                }
                                                            }
                                                        }
                                                        bkmVar = i27 != i26 ? new bkm(iAu, charSequence3.subSequence(i25, i27 + 1).toString()) : new bkm(iAu, charSequence3.subSequence(i25, length4 + 1).toString());
                                                    } else {
                                                        bkmVar = null;
                                                    }
                                                }
                                            }
                                            if (bkmVar != null) {
                                                p[] pVarArr3 = new p[1];
                                                pVarArr3[i] = bkmVar;
                                                poVar2 = new po(pVarArr3);
                                                poVar2.a = charSequence3.length();
                                            } else {
                                                char cCharAt9 = charSequence3.charAt(i24);
                                                if (cCharAt9 == '-') {
                                                    i3 = ewz.av(ewz.au(SignatureVisitor.SUPER, i24 + 1, charSequence3.length(), charSequence3), charSequence3.length(), charSequence3) >= charSequence3.length() ? 2 : i;
                                                } else if (cCharAt9 == '=') {
                                                    if (ewz.av(ewz.au(SignatureVisitor.INSTANCEOF, i24 + 1, charSequence3.length(), charSequence3), charSequence3.length(), charSequence3) >= charSequence3.length()) {
                                                        i3 = 1;
                                                    } else if (ewz.av(ewz.au(SignatureVisitor.SUPER, i24 + 1, charSequence3.length(), charSequence3), charSequence3.length(), charSequence3) >= charSequence3.length()) {
                                                    }
                                                }
                                                if (i3 > 0) {
                                                    p pVar4 = (p) erpVar.v;
                                                    if (pVar4 instanceof css) {
                                                        sb = ((css) pVar4).i.b;
                                                        if (sb.length() == 0) {
                                                            sb = null;
                                                        }
                                                    } else {
                                                        sb = null;
                                                    }
                                                    if (sb != null) {
                                                        bkm bkmVar2 = new bkm(i3, sb.toString());
                                                        p[] pVarArr4 = new p[1];
                                                        pVarArr4[i] = bkmVar2;
                                                        poVar2 = new po(pVarArr4);
                                                        poVar2.a = charSequence3.length();
                                                        poVar2.c = true;
                                                    }
                                                }
                                            }
                                            poVar = poVar2;
                                        }
                                        poVar = null;
                                        break;
                                    case 3:
                                        pVar = pVar3;
                                        int i28 = i12;
                                        int i29 = this.g;
                                        CharSequence charSequence4 = this.c;
                                        if (this.i >= i28 || charSequence4.charAt(i29) != '<') {
                                            poVar = null;
                                        } else {
                                            int i30 = 1;
                                            while (true) {
                                                if (i30 > 7) {
                                                    poVar = null;
                                                } else {
                                                    if (i30 != 7 || !(((p) erpVar.v).d() instanceof csr)) {
                                                        Pattern[] patternArr = bms.h[i30];
                                                        Pattern pattern = patternArr[i];
                                                        Pattern pattern2 = patternArr[1];
                                                        if (pattern.matcher(charSequence4.subSequence(i29, charSequence4.length())).find()) {
                                                            p[] pVarArr5 = new p[1];
                                                            pVarArr5[i] = new bms(pattern2);
                                                            poVar = new po(pVarArr5);
                                                            poVar.a = this.d;
                                                            break;
                                                        }
                                                    }
                                                    i30++;
                                                }
                                            }
                                        }
                                        break;
                                    case 4:
                                        pVar = pVar3;
                                        if (this.i < 4) {
                                            poVar = null;
                                        } else if (this.j || (y().d() instanceof csr)) {
                                            poVar = null;
                                        } else {
                                            p[] pVarArr6 = new p[1];
                                            pVarArr6[i] = new bkm();
                                            poVar = new po(pVarArr6);
                                            poVar.b = this.e + 4;
                                        }
                                        break;
                                    case 5:
                                        p pVar5 = (p) erpVar.v;
                                        int i31 = this.i;
                                        if (i31 < 4) {
                                            int i32 = this.g;
                                            int i33 = this.e + i31;
                                            if (pVar5 instanceof css) {
                                                sb2 = ((css) pVar5).i.b;
                                                if (sb2.length() == 0) {
                                                    sb2 = null;
                                                }
                                            } else {
                                                sb2 = null;
                                            }
                                            int i34 = sb2 != null ? 1 : i;
                                            CharSequence charSequence5 = this.c;
                                            char cCharAt10 = charSequence5.charAt(i32);
                                            if (cCharAt10 == '*' || cCharAt10 == '+' || cCharAt10 == '-') {
                                                i4 = i34;
                                                pVar = pVar3;
                                                int i35 = i32 + 1;
                                                if (i35 >= charSequence5.length() || (cCharAt2 = charSequence5.charAt(i35)) == '\t' || cCharAt2 == ' ') {
                                                    rq rqVar = new rq();
                                                    rqVar.d = cCharAt10;
                                                    bvvVar = new bvv(rqVar, i35);
                                                } else {
                                                    bvvVar = null;
                                                }
                                            } else {
                                                int length5 = charSequence5.length();
                                                int i36 = i32;
                                                int i37 = i;
                                                while (true) {
                                                    i4 = i34;
                                                    if (i36 < length5) {
                                                        char cCharAt11 = charSequence5.charAt(i36);
                                                        pVar = pVar3;
                                                        if (cCharAt11 != ')' && cCharAt11 != '.') {
                                                            switch (cCharAt11) {
                                                                case '0':
                                                                case '1':
                                                                case '2':
                                                                case '3':
                                                                case '4':
                                                                case '5':
                                                                case '6':
                                                                case '7':
                                                                case '8':
                                                                case '9':
                                                                    i37++;
                                                                    if (i37 <= 9) {
                                                                        i36++;
                                                                        i34 = i4;
                                                                        pVar3 = pVar;
                                                                    }
                                                                    break;
                                                                default:
                                                                    break;
                                                            }
                                                        } else if (i37 >= 1 && ((i6 = i36 + 1) >= charSequence5.length() || (cCharAt3 = charSequence5.charAt(i6)) == '\t' || cCharAt3 == ' ')) {
                                                            String string2 = charSequence5.subSequence(i32, i36).toString();
                                                            crx crxVar = new crx();
                                                            crxVar.d = Integer.parseInt(string2);
                                                            crxVar.g = cCharAt11;
                                                            bvvVar = new bvv(crxVar, i6);
                                                        }
                                                    } else {
                                                        pVar = pVar3;
                                                    }
                                                    bvvVar = null;
                                                }
                                            }
                                            if (bvvVar == null) {
                                                bvvVar2 = null;
                                            } else {
                                                bvu bvuVar = bvvVar.a;
                                                int i38 = bvvVar.b;
                                                int i39 = (i38 - i32) + i33;
                                                int length6 = charSequence5.length();
                                                int i40 = i39;
                                                while (true) {
                                                    if (i38 >= length6) {
                                                        i5 = i;
                                                    } else {
                                                        char cCharAt12 = charSequence5.charAt(i38);
                                                        if (cCharAt12 == '\t') {
                                                            i40 = (4 - (i40 % 4)) + i40;
                                                        } else if (cCharAt12 == ' ') {
                                                            i40++;
                                                        } else {
                                                            i5 = 1;
                                                        }
                                                        i38++;
                                                    }
                                                }
                                                if (i4 == 0 || ((!(bvuVar instanceof crx) || ((crx) bvuVar).d == 1) && i5 != 0)) {
                                                    if (i5 == 0 || i40 - i39 > 4) {
                                                        i40 = i39 + 1;
                                                    }
                                                    bvvVar2 = new bvv(bvuVar, i40);
                                                } else {
                                                    bvvVar2 = null;
                                                }
                                            }
                                            if (bvvVar2 != null) {
                                                bvu bvuVar2 = bvvVar2.a;
                                                int i41 = bvvVar2.b;
                                                bwc bwcVar = new bwc(i41 - this.e);
                                                if (pVar5 instanceof bvw) {
                                                    bvu bvuVar3 = ((bvw) pVar5).h;
                                                    if ((bvuVar3 instanceof rq) && (bvuVar2 instanceof rq)) {
                                                        zEquals2 = Character.valueOf(((rq) bvuVar3).d).equals(Character.valueOf(((rq) bvuVar2).d));
                                                    } else if ((bvuVar3 instanceof crx) && (bvuVar2 instanceof crx)) {
                                                        zEquals = Character.valueOf(((crx) bvuVar3).g).equals(Character.valueOf(((crx) bvuVar2).g));
                                                    } else {
                                                        r4 = i;
                                                    }
                                                    if (r4 == 0) {
                                                        r4 = zEquals;
                                                        r4 = zEquals2;
                                                        bvw bvwVar = new bvw(bvuVar2);
                                                        bvuVar2.e = true;
                                                        p[] pVarArr7 = new p[2];
                                                        pVarArr7[i] = bvwVar;
                                                        pVarArr7[1] = bwcVar;
                                                        po poVar3 = new po(pVarArr7);
                                                        poVar3.b = i41;
                                                        poVar = poVar3;
                                                    } else {
                                                        r4 = zEquals;
                                                        p[] pVarArr8 = new p[1];
                                                        pVarArr8[i] = bwcVar;
                                                        po poVar4 = new po(pVarArr8);
                                                        poVar4.b = i41;
                                                        poVar = poVar4;
                                                    }
                                                } else {
                                                    r4 = zEquals;
                                                    r4 = zEquals2;
                                                    bvw bvwVar2 = new bvw(bvuVar2);
                                                    bvuVar2.e = true;
                                                    p[] pVarArr72 = new p[2];
                                                    pVarArr72[i] = bvwVar2;
                                                    pVarArr72[1] = bwcVar;
                                                    po poVar32 = new po(pVarArr72);
                                                    poVar32.b = i41;
                                                    poVar = poVar32;
                                                }
                                                break;
                                            }
                                        } else {
                                            pVar = pVar3;
                                        }
                                        poVar = null;
                                        break;
                                    default:
                                        if (this.i >= i12) {
                                            poVar = null;
                                        } else {
                                            int i42 = this.g;
                                            CharSequence charSequence6 = this.c;
                                            int length7 = charSequence6.length();
                                            int i43 = i;
                                            int i44 = i43;
                                            int i45 = i44;
                                            while (true) {
                                                if (i42 >= length7) {
                                                    int i46 = i44;
                                                    int i47 = i45;
                                                    if ((i43 >= 3 && i46 == 0 && i47 == 0) || ((i46 >= 3 && i43 == 0 && i47 == 0) || (i47 >= 3 && i43 == 0 && i46 == 0))) {
                                                        p[] pVarArr9 = new p[1];
                                                        pVarArr9[i] = new apg(1);
                                                        poVar = new po(pVarArr9);
                                                        poVar.a = charSequence6.length();
                                                    }
                                                } else {
                                                    char cCharAt13 = charSequence6.charAt(i42);
                                                    if (cCharAt13 == '\t' || cCharAt13 == c) {
                                                        i44 = i44;
                                                        i45 = i45;
                                                    } else if (cCharAt13 == '*') {
                                                        i45++;
                                                    } else if (cCharAt13 == '-') {
                                                        i43++;
                                                    } else if (cCharAt13 == '_') {
                                                        i44++;
                                                    }
                                                    i42++;
                                                    c = ' ';
                                                }
                                                poVar = null;
                                            }
                                        }
                                        pVar = pVar3;
                                        break;
                                }
                                if (poVar != null) {
                                    r4 = zEquals2;
                                } else {
                                    r4 = zEquals2;
                                    i7 = i;
                                    pVar3 = pVar;
                                    i12 = 4;
                                }
                            } else {
                                i = i7;
                                pVar = pVar3;
                                poVar = null;
                            }
                        }
                        if (poVar == null) {
                            ab(this.g);
                        } else {
                            if (!zIsEmpty) {
                                w(arrayList2);
                                zIsEmpty = true;
                            }
                            int i48 = poVar.a;
                            if (i48 != -1) {
                                ab(i48);
                            } else {
                                int i49 = poVar.b;
                                if (i49 != -1) {
                                    aa(i49);
                                }
                            }
                            if (poVar.c) {
                                p pVarY = y();
                                z = true;
                                arrayList.remove(arrayList.size() - 1);
                                this.q.remove(pVarY);
                                if (pVarY instanceof css) {
                                    s((css) pVarY);
                                }
                                pVarY.d().o();
                            } else {
                                z = true;
                            }
                            p[] pVarArr10 = (p[]) poVar.d;
                            int length8 = pVarArr10.length;
                            pVar3 = pVar;
                            for (int i50 = i; i50 < length8; i50++) {
                                pVar3 = pVarArr10[i50];
                                r(pVar3);
                                zE = pVar3.e();
                            }
                            i7 = i;
                        }
                    }
                }
                pVar = pVar3;
                ab(this.g);
            } else {
                pVar = pVar3;
            }
            if (!zIsEmpty && !this.j) {
                p pVarY2 = y();
                pVarY2.getClass();
                if (pVarY2 instanceof css) {
                    t();
                    return;
                }
            }
            if (!zIsEmpty) {
                w(arrayList2);
            }
            if (!pVar.e()) {
                t();
                return;
            } else {
                if (this.j) {
                    return;
                }
                r(new css());
                t();
                return;
            }
        }
    }
}
