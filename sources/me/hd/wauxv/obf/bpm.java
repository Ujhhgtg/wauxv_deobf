package me.hd.wauxv.obf;

import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.bytebuddy.pool.TypePool;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bpm {
    public static final Pattern a = Pattern.compile("^[!\"#\\$%&'\\(\\)\\*\\+,\\-\\./:;<=>\\?@\\[\\\\\\]\\^_`\\{\\|\\}~\\p{Pc}\\p{Pd}\\p{Pe}\\p{Pf}\\p{Pi}\\p{Po}\\p{Ps}]");
    public static final Pattern b = Pattern.compile("^(?:<[A-Za-z][A-Za-z0-9-]*(?:\\s+[a-zA-Z_:][a-zA-Z0-9:._-]*(?:\\s*=\\s*(?:[^\"'=<>`\\x00-\\x20]+|'[^']*'|\"[^\"]*\"))?)*\\s*/?>|</[A-Za-z][A-Za-z0-9-]*\\s*[>]|<!---->|<!--(?:-?[^>-])(?:-?[^-])*-->|[<][?].*?[?][>]|<![A-Z]+\\s+[^>]*>|<!\\[CDATA\\[[\\s\\S]*?\\]\\]>)", 2);
    public static final Pattern c = Pattern.compile("^[!\"#$%&'()*+,./:;<=>?@\\[\\\\\\]^_`{|}~-]");
    public static final Pattern d = Pattern.compile("^&(?:#x[a-f0-9]{1,6}|#[0-9]{1,7}|[a-z][a-z0-9]{1,31});", 2);
    public static final Pattern e = Pattern.compile("`+");
    public static final Pattern f = Pattern.compile("^`+");
    public static final Pattern g = Pattern.compile("^<([a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*)>");
    public static final Pattern h = Pattern.compile("^<[a-zA-Z][a-zA-Z0-9.+-]{1,31}:[^<>\u0000- ]*>");
    public static final Pattern i = Pattern.compile("^ *(?:\n *)?");
    public static final Pattern j = Pattern.compile("^[\\p{Zs}\t\r\n\f]");
    public static final Pattern k = Pattern.compile("\\s+");
    public static final Pattern l = Pattern.compile(" *$");
    public final BitSet m;
    public final BitSet n;
    public final HashMap o;
    public final DefaultConfig p;
    public String q;
    public int r;
    public alv s;
    public qx t;

    public bpm(DefaultConfig ioVar) {
        List list = (List) ioVar.c;
        HashMap map = new HashMap();
        v(Arrays.asList(new lf(TypePool.Default.LazyTypeDescription.GenericTypeToken.WILDCARD_TYPE_PATH), new lf('_')), map);
        v(list, map);
        this.o = map;
        Set setKeySet = map.keySet();
        BitSet bitSet = new BitSet();
        Iterator it = setKeySet.iterator();
        while (it.hasNext()) {
            bitSet.set(((Character) it.next()).charValue());
        }
        this.n = bitSet;
        BitSet bitSet2 = new BitSet();
        bitSet2.or(bitSet);
        bitSet2.set(10);
        bitSet2.set(96);
        bitSet2.set(91);
        bitSet2.set(93);
        bitSet2.set(92);
        bitSet2.set(33);
        bitSet2.set(60);
        bitSet2.set(38);
        this.m = bitSet2;
        this.p = ioVar;
    }

    public static void u(char c2, alw alwVar, HashMap map) {
        if (((alw) map.put(Character.valueOf(c2), alwVar)) == null) {
            return;
        }
        throw new IllegalArgumentException("Delimiter processor conflict with delimiter char '" + c2 + "'");
    }

    public static void v(Iterable iterable, HashMap map) {
        dlz dlzVar;
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            alw alwVar = (alw) it.next();
            char cF = alwVar.f();
            char c2 = alwVar.c();
            if (cF == c2) {
                alw alwVar2 = (alw) map.get(Character.valueOf(cF));
                if (alwVar2 == null || alwVar2.f() != alwVar2.c()) {
                    u(cF, alwVar, map);
                } else {
                    if (alwVar2 instanceof dlz) {
                        dlzVar = (dlz) alwVar2;
                    } else {
                        dlz dlzVar2 = new dlz(cF);
                        dlzVar2.i(alwVar2);
                        dlzVar = dlzVar2;
                    }
                    dlzVar.i(alwVar);
                    map.put(Character.valueOf(cF), dlzVar);
                }
            } else {
                u(cF, alwVar, map);
                u(c2, alwVar, map);
            }
        }
    }

    public static void w(dqe dqeVar, dqe dqeVar2, int i2) {
        if (dqeVar == null || dqeVar2 == null || dqeVar == dqeVar2) {
            return;
        }
        StringBuilder sb = new StringBuilder(i2);
        sb.append(dqeVar.d);
        coi coiVar = dqeVar.m;
        coi coiVar2 = dqeVar2.m;
        while (coiVar != coiVar2) {
            sb.append(((dqe) coiVar).d);
            coi coiVar3 = coiVar.m;
            coiVar.o();
            coiVar = coiVar3;
        }
        dqeVar.d = sb.toString();
    }

    public static void x(coi coiVar, coi coiVar2) {
        dqe dqeVar = null;
        dqe dqeVar2 = null;
        int length = 0;
        while (coiVar != null) {
            if (coiVar instanceof dqe) {
                dqeVar2 = (dqe) coiVar;
                if (dqeVar == null) {
                    dqeVar = dqeVar2;
                }
                length = dqeVar2.d.length() + length;
            } else {
                w(dqeVar, dqeVar2, length);
                dqeVar = null;
                dqeVar2 = null;
                length = 0;
            }
            if (coiVar == coiVar2) {
                break;
            } else {
                coiVar = coiVar.m;
            }
        }
        w(dqeVar, dqeVar2, length);
    }

    public final char aa() {
        if (this.r < this.q.length()) {
            return this.q.charAt(this.r);
        }
        return (char) 0;
    }

    public final void ab(alv alvVar) {
        boolean z;
        coi coiVar;
        HashMap map = new HashMap();
        alv alvVar2 = this.s;
        while (alvVar2 != null) {
            alv alvVar3 = alvVar2.e;
            if (alvVar3 == alvVar) {
                break;
            } else {
                alvVar2 = alvVar3;
            }
        }
        while (alvVar2 != null) {
            dqe dqeVar = alvVar2.a;
            char c2 = alvVar2.b;
            alw alwVar = (alw) this.o.get(Character.valueOf(c2));
            if (!alvVar2.d || alwVar == null) {
                alvVar2 = alvVar2.f;
            } else {
                char cF = alwVar.f();
                alv alvVar4 = alvVar2.e;
                int iD = 0;
                boolean z2 = false;
                while (true) {
                    if (alvVar4 == null || alvVar4 == alvVar || alvVar4 == map.get(Character.valueOf(c2))) {
                        z = z2;
                        z2 = false;
                        break;
                    }
                    if (alvVar4.c && alvVar4.b == cF) {
                        iD = alwVar.d(alvVar4, alvVar2);
                        z2 = true;
                        if (iD > 0) {
                            z = true;
                            break;
                        }
                    }
                    alvVar4 = alvVar4.e;
                }
                if (z2) {
                    dqe dqeVar2 = alvVar4.a;
                    alvVar4.g -= iD;
                    alvVar2.g -= iD;
                    dqeVar2.d = yg.j(dqeVar2.d, iD, 0);
                    dqeVar.d = yg.j(dqeVar.d, iD, 0);
                    alv alvVar5 = alvVar2.e;
                    while (alvVar5 != null && alvVar5 != alvVar4) {
                        alv alvVar6 = alvVar5.e;
                        ac(alvVar5);
                        alvVar5 = alvVar6;
                    }
                    if (dqeVar2 != dqeVar && (coiVar = dqeVar2.m) != dqeVar) {
                        x(coiVar, dqeVar.l);
                    }
                    alwVar.b(dqeVar2, dqeVar, iD);
                    if (alvVar4.g == 0) {
                        alvVar4.a.o();
                        ac(alvVar4);
                    }
                    if (alvVar2.g == 0) {
                        alv alvVar7 = alvVar2.f;
                        dqeVar.o();
                        ac(alvVar2);
                        alvVar2 = alvVar7;
                    }
                } else {
                    if (!z) {
                        map.put(Character.valueOf(c2), alvVar2.e);
                        if (!alvVar2.c) {
                            ac(alvVar2);
                        }
                    }
                    alvVar2 = alvVar2.f;
                }
            }
        }
        while (true) {
            alv alvVar8 = this.s;
            if (alvVar8 == null || alvVar8 == alvVar) {
                return;
            } else {
                ac(alvVar8);
            }
        }
    }

    public final void ac(alv alvVar) {
        alv alvVar2 = alvVar.e;
        if (alvVar2 != null) {
            alvVar2.f = alvVar.f;
        }
        alv alvVar3 = alvVar.f;
        if (alvVar3 == null) {
            this.s = alvVar2;
        } else {
            alvVar3.e = alvVar2;
        }
    }

    public final String y(Pattern pattern) {
        if (this.r >= this.q.length()) {
            return null;
        }
        Matcher matcher = pattern.matcher(this.q);
        matcher.region(this.r, this.q.length());
        if (!matcher.find()) {
            return null;
        }
        this.r = matcher.end();
        return matcher.group();
    }

    /* JADX WARN: Found duplicated region for block: B:117:0x01ef  */
    /* JADX WARN: Found duplicated region for block: B:119:0x01f4 A[PHI: r2
      0x01f4: PHI (r2v79 char) = (r2v78 char), (r2v83 char), (r2v84 char) binds: [B:113:0x01e7, B:115:0x01eb, B:118:0x01f2] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Found duplicated region for block: B:122:0x01fe  */
    /* JADX WARN: Found duplicated region for block: B:205:0x03c6  */
    /* JADX WARN: Found duplicated region for block: B:231:0x0468  */
    /* JADX WARN: Found duplicated region for block: B:233:0x0470  */
    /* JADX WARN: Found duplicated region for block: B:260:0x0514  */
    /* JADX WARN: Found duplicated region for block: B:265:0x0534 A[LOOP:0: B:3:0x0013->B:265:0x0534, LOOP_END] */
    /* JADX WARN: Found duplicated region for block: B:268:0x0545 A[RETURN] */
    /* JADX WARN: Found duplicated region for block: B:269:0x0546  */
    /* JADX WARN: Found duplicated region for block: B:271:0x053b A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:73:0x00f1  */
    /* JADX WARN: Multi-variable type inference failed */
    public final void z(String str, coi coiVar) {
        int i2;
        coi dkxVar;
        coi coiVar2;
        coi coiVar3;
        coi dqeVar;
        coi coiVar4;
        coi dqeVar2;
        coi bvoVar;
        coi dqeVar3;
        int i3;
        String strE;
        boolean z;
        String strE2;
        int iAb;
        int i4;
        coi dqeVar4;
        boolean z2;
        boolean z3;
        bpl bplVar;
        coi coiVar5;
        coi coiVar6;
        this.q = str.trim();
        int i5 = 0;
        this.r = 0;
        dqe dqeVar5 = null;
        this.s = null;
        this.t = null;
        coi coiVar7 = null;
        while (true) {
            char cAa = aa();
            if (cAa == 0) {
                i2 = i5;
            } else {
                if (cAa == '\n') {
                    this.r++;
                    if (coiVar7 instanceof dqe) {
                        dqe dqeVar6 = (dqe) coiVar7;
                        if (dqeVar6.d.endsWith(" ")) {
                            String str2 = dqeVar6.d;
                            Matcher matcher = l.matcher(str2);
                            int iEnd = matcher.find() ? matcher.end() - matcher.start() : 0;
                            i2 = 0;
                            if (iEnd > 0) {
                                dqeVar6.d = yg.j(str2, iEnd, 0);
                            }
                            dkxVar = iEnd >= 2 ? new bke() : new dkx();
                        } else {
                            i2 = 0;
                            dkxVar = new dkx();
                        }
                    } else {
                        i2 = 0;
                        dkxVar = new dkx();
                    }
                    coiVar2 = dkxVar;
                } else if (cAa == '!') {
                    int i6 = this.r + 1;
                    this.r = i6;
                    if (aa() == '[') {
                        this.r++;
                        dqe dqeVar7 = new dqe("![");
                        qx qxVar = this.t;
                        qx qxVar2 = new qx(dqeVar7, i6, qxVar, this.s, true);
                        if (qxVar != null) {
                            qxVar.g = true;
                        }
                        this.t = qxVar2;
                        coiVar4 = dqeVar7;
                    } else {
                        dqeVar = new dqe("!");
                        coiVar4 = dqeVar;
                    }
                    i2 = 0;
                    coiVar2 = coiVar4;
                } else if (cAa == '&') {
                    String strY = y(d);
                    if (strY != null) {
                        dqeVar2 = new dqe(bmq.c(strY));
                        coiVar4 = dqeVar2;
                    } else {
                        coiVar4 = null;
                    }
                    i2 = 0;
                    coiVar2 = coiVar4;
                } else if (cAa == '<') {
                    String strY2 = y(g);
                    if (strY2 != null) {
                        String strJ = yg.j(strY2, 1, 1);
                        bvoVar = new bvo(yg.k("mailto:", strJ), null);
                        bvoVar.n(new dqe(strJ));
                    } else {
                        String strY3 = y(h);
                        if (strY3 != null) {
                            String strJ2 = yg.j(strY3, 1, 1);
                            bvoVar = new bvo(strJ2, null);
                            bvoVar.n(new dqe(strJ2));
                        } else {
                            coiVar4 = null;
                        }
                        if (coiVar4 == null) {
                            if (y(b) != null) {
                                dqeVar = new bmt();
                                coiVar4 = dqeVar;
                            } else {
                                coiVar4 = null;
                            }
                        }
                        i2 = 0;
                        coiVar2 = coiVar4;
                    }
                    coiVar4 = bvoVar;
                    if (coiVar4 == null) {
                        if (y(b) != null) {
                            dqeVar = new bmt();
                            coiVar4 = dqeVar;
                        } else {
                            coiVar4 = null;
                        }
                    }
                    i2 = 0;
                    coiVar2 = coiVar4;
                } else if (cAa != '`') {
                    switch (cAa) {
                        case '[':
                            int i7 = this.r;
                            this.r = i7 + 1;
                            dqe dqeVar8 = new dqe("[");
                            qx qxVar3 = this.t;
                            qx qxVar4 = new qx(dqeVar8, i7, qxVar3, this.s, false);
                            if (qxVar3 != null) {
                                qxVar3.g = true;
                            }
                            this.t = qxVar4;
                            coiVar4 = dqeVar8;
                            i2 = 0;
                            coiVar2 = coiVar4;
                            break;
                        case '\\':
                            this.r++;
                            if (aa() == '\n') {
                                dqeVar = new bke();
                                this.r++;
                            } else {
                                if (this.r < this.q.length()) {
                                    String str3 = this.q;
                                    int i8 = this.r;
                                    if (c.matcher(str3.substring(i8, i8 + 1)).matches()) {
                                        String str4 = this.q;
                                        int i9 = this.r;
                                        coi dqeVar9 = new dqe(str4.substring(i9, i9 + 1));
                                        this.r++;
                                        coiVar4 = dqeVar9;
                                    }
                                    i2 = 0;
                                    coiVar2 = coiVar4;
                                }
                                dqeVar = new dqe("\\");
                            }
                            coiVar4 = dqeVar;
                            i2 = 0;
                            coiVar2 = coiVar4;
                            break;
                        case ']':
                            int i10 = this.r + 1;
                            this.r = i10;
                            qx qxVar5 = this.t;
                            if (qxVar5 != null) {
                                dqe dqeVar10 = qxVar5.a;
                                boolean z4 = qxVar5.c;
                                if (qxVar5.f) {
                                    int i11 = -1;
                                    if (aa() == '(') {
                                        this.r++;
                                        Pattern pattern = i;
                                        y(pattern);
                                        i3 = 1;
                                        int iZ = bht.z(this.r, this.q);
                                        if (iZ == -1) {
                                            strE2 = null;
                                        } else {
                                            String strSubstring = aa() == '<' ? this.q.substring(this.r + 1, iZ - 1) : this.q.substring(this.r, iZ);
                                            this.r = iZ;
                                            strE2 = awq.e(strSubstring);
                                        }
                                        if (strE2 != null) {
                                            y(pattern);
                                            String str5 = this.q;
                                            int i12 = this.r;
                                            if (k.matcher(str5.substring(i12 - 1, i12)).matches()) {
                                                String str6 = this.q;
                                                int i13 = this.r;
                                                if (i13 >= str6.length()) {
                                                    i4 = -1;
                                                } else {
                                                    char cCharAt = str6.charAt(i13);
                                                    char c2 = '\"';
                                                    if (cCharAt != '\"') {
                                                        c2 = '\'';
                                                        if (cCharAt == '\'') {
                                                            iAb = bht.ab(str6, i13 + 1, c2);
                                                            if (iAb == -1 && iAb < str6.length() && str6.charAt(iAb) == c2) {
                                                                i4 = iAb + 1;
                                                                i11 = -1;
                                                            } else {
                                                                i11 = -1;
                                                                i4 = -1;
                                                            }
                                                        } else if (cCharAt != '(') {
                                                            i11 = -1;
                                                            i4 = -1;
                                                        } else {
                                                            c2 = ')';
                                                            iAb = bht.ab(str6, i13 + 1, c2);
                                                            if (iAb == -1) {
                                                                i11 = -1;
                                                                i4 = -1;
                                                            } else {
                                                                i4 = iAb + 1;
                                                                i11 = -1;
                                                            }
                                                        }
                                                    } else {
                                                        iAb = bht.ab(str6, i13 + 1, c2);
                                                        if (iAb == -1) {
                                                            i11 = -1;
                                                            i4 = -1;
                                                        } else {
                                                            i4 = iAb + 1;
                                                            i11 = -1;
                                                        }
                                                    }
                                                }
                                                if (i4 == i11) {
                                                    strE = null;
                                                } else {
                                                    String strSubstring2 = this.q.substring(this.r + 1, i4 - 1);
                                                    this.r = i4;
                                                    strE = awq.e(strSubstring2);
                                                }
                                                y(pattern);
                                            } else {
                                                strE = null;
                                            }
                                            if (aa() == ')') {
                                                this.r++;
                                                z = true;
                                            } else {
                                                this.r = i10;
                                            }
                                        } else {
                                            strE = null;
                                        }
                                        z = false;
                                    } else {
                                        i3 = 1;
                                        strE = null;
                                        z = false;
                                        strE2 = null;
                                    }
                                    if (!z) {
                                        int i14 = this.r;
                                        if (i14 < this.q.length() && this.q.charAt(this.r) == '[') {
                                            int i15 = this.r + 1;
                                            int iAa = bht.aa(i15, this.q);
                                            int i16 = iAa - i15;
                                            if (iAa != -1 && i16 <= 999 && iAa < this.q.length() && this.q.charAt(iAa) == ']') {
                                                this.r = iAa + 1;
                                            }
                                        }
                                        int i17 = this.r - i14;
                                        String strSubstring3 = i17 > 2 ? this.q.substring(i14, i17 + i14) : !qxVar5.g ? this.q.substring(qxVar5.b, i10) : null;
                                        if (strSubstring3 != null) {
                                            Pattern pattern2 = awq.a;
                                            bvp bvpVar = (bvp) ((Map) this.p.d).get(awq.c.matcher(strSubstring3.substring(i3, strSubstring3.length() - 1).trim().toLowerCase(Locale.ROOT)).replaceAll(" "));
                                            if (bvpVar != null) {
                                                strE2 = bvpVar.e;
                                                strE = bvpVar.g;
                                                z = true;
                                            }
                                        }
                                    }
                                    if (!z) {
                                        this.r = i10;
                                        this.t = this.t.d;
                                        dqeVar = new dqe("]");
                                        coiVar4 = dqeVar;
                                        i2 = 0;
                                        coiVar2 = coiVar4;
                                    } else {
                                        if (z4) {
                                            boe boeVar = new boe();
                                            boeVar.d = strE2;
                                            boeVar.e = strE;
                                            dqeVar2 = boeVar;
                                        } else {
                                            dqeVar2 = new bvo(strE2, strE);
                                        }
                                        coi coiVar8 = dqeVar10.m;
                                        while (coiVar8 != null) {
                                            coi coiVar9 = coiVar8.m;
                                            dqeVar2.n(coiVar8);
                                            coiVar8 = coiVar9;
                                        }
                                        ab(qxVar5.e);
                                        coi coiVar10 = dqeVar2.j;
                                        coi coiVar11 = dqeVar2.k;
                                        if (coiVar10 != coiVar11) {
                                            x(coiVar10, coiVar11);
                                        }
                                        dqeVar10.o();
                                        qx qxVar6 = this.t.d;
                                        this.t = qxVar6;
                                        if (!z4) {
                                            while (qxVar6 != null) {
                                                if (!qxVar6.c) {
                                                    qxVar6.f = false;
                                                }
                                                qxVar6 = qxVar6.d;
                                            }
                                        }
                                        coiVar4 = dqeVar2;
                                        i2 = 0;
                                        coiVar2 = coiVar4;
                                    }
                                } else {
                                    this.t = qxVar5.d;
                                    dqeVar3 = new dqe("]");
                                }
                            } else {
                                dqeVar3 = new dqe("]");
                            }
                            coiVar4 = dqeVar3;
                            i2 = 0;
                            coiVar2 = coiVar4;
                            break;
                        default:
                            if (this.n.get(cAa)) {
                                alw alwVar = (alw) this.o.get(Character.valueOf(cAa));
                                int i18 = this.r;
                                int i19 = i5;
                                while (aa() == cAa) {
                                    i19++;
                                    this.r++;
                                }
                                if (i19 < alwVar.e()) {
                                    this.r = i18;
                                    bplVar = dqeVar5;
                                } else {
                                    String strSubstring4 = i18 == 0 ? "\n" : this.q.substring(i18 - 1, i18);
                                    char cAa2 = aa();
                                    String strValueOf = cAa2 != 0 ? String.valueOf(cAa2) : "\n";
                                    Pattern pattern3 = a;
                                    boolean zMatches = pattern3.matcher(strSubstring4).matches();
                                    Pattern pattern4 = j;
                                    boolean zMatches2 = pattern4.matcher(strSubstring4).matches();
                                    boolean zMatches3 = pattern3.matcher(strValueOf).matches();
                                    boolean zMatches4 = pattern4.matcher(strValueOf).matches();
                                    int i20 = (zMatches4 || !(!zMatches3 || zMatches2 || zMatches)) ? i5 : 1;
                                    int i21 = (zMatches2 || !(!zMatches || zMatches4 || zMatches3)) ? i5 : 1;
                                    if (cAa == '_') {
                                        int i22 = (i20 == 0 || !(i21 == 0 || zMatches)) ? i5 : 1;
                                        if (i21 == 0 || !(i20 == 0 || zMatches3)) {
                                            z3 = i5;
                                            z2 = i22;
                                        } else {
                                            z3 = 1;
                                            z2 = i22;
                                        }
                                    } else {
                                        int i23 = (i20 == 0 || cAa != alwVar.f()) ? i5 : 1;
                                        int i24 = (i21 == 0 || cAa != alwVar.c()) ? i5 : 1;
                                        z2 = i23;
                                        z3 = i24;
                                    }
                                    this.r = i18;
                                    bplVar = new bpl(i19, z2, z3);
                                }
                                if (bplVar != 0) {
                                    int i25 = bplVar.a;
                                    int i26 = this.r;
                                    int i27 = i26 + i25;
                                    this.r = i27;
                                    dqe dqeVar11 = new dqe(this.q.substring(i26, i27));
                                    boolean z5 = bplVar.c;
                                    boolean z6 = bplVar.b;
                                    alv alvVar = this.s;
                                    alv alvVar2 = new alv(dqeVar11, cAa, z5, z6, alvVar);
                                    this.s = alvVar2;
                                    alvVar2.g = i25;
                                    alvVar2.h = i25;
                                    if (alvVar != null) {
                                        alvVar.f = alvVar2;
                                    }
                                    dqeVar4 = dqeVar11;
                                }
                            } else {
                                int i28 = this.r;
                                int length = this.q.length();
                                while (true) {
                                    int i29 = this.r;
                                    if (i29 != length) {
                                        if (!this.m.get(this.q.charAt(i29))) {
                                            this.r++;
                                        }
                                    }
                                }
                                int i30 = this.r;
                                dqeVar4 = i28 != i30 ? new dqe(this.q.substring(i28, i30)) : dqeVar5;
                            }
                            i2 = i5;
                            coiVar2 = dqeVar4;
                            break;
                    }
                } else {
                    String strY4 = y(f);
                    if (strY4 == null) {
                        coiVar4 = null;
                    } else {
                        int i31 = this.r;
                        while (true) {
                            String strY5 = y(e);
                            if (strY5 == null) {
                                this.r = i31;
                                dqeVar2 = new dqe(strY4);
                                coiVar4 = dqeVar2;
                            } else if (strY5.equals(strY4)) {
                                aaf aafVar = new aaf();
                                String strReplace = this.q.substring(i31, this.r - strY4.length()).replace('\n', ' ');
                                if (strReplace.length() >= 3 && strReplace.charAt(0) == ' ' && strReplace.charAt(strReplace.length() - 1) == ' ') {
                                    int length2 = strReplace.length();
                                    if (ewz.au(' ', 0, length2, strReplace) != length2) {
                                        strReplace = yg.j(strReplace, 1, 1);
                                    }
                                }
                                aafVar.d = strReplace;
                                dqeVar3 = aafVar;
                                coiVar4 = dqeVar3;
                            }
                        }
                    }
                    i2 = 0;
                    coiVar2 = coiVar4;
                }
                if (coiVar2 != null) {
                    coiVar3 = coiVar2;
                } else {
                    this.r++;
                    dqeVar5 = new dqe(String.valueOf(cAa));
                }
                if (coiVar3 != null) {
                    ab(null);
                    coiVar5 = coiVar.j;
                    coiVar6 = coiVar.k;
                    if (coiVar5 == coiVar6) {
                        return;
                    }
                    x(coiVar5, coiVar6);
                    return;
                }
                coiVar.n(coiVar3);
                i5 = i2;
                dqeVar5 = null;
                coiVar7 = coiVar3;
            }
            coiVar3 = dqeVar5;
            if (coiVar3 != null) {
                ab(null);
                coiVar5 = coiVar.j;
                coiVar6 = coiVar.k;
                if (coiVar5 == coiVar6) {
                    return;
                }
                x(coiVar5, coiVar6);
                return;
            }
            coiVar.n(coiVar3);
            i5 = i2;
            dqeVar5 = null;
            coiVar7 = coiVar3;
        }
    }
}
