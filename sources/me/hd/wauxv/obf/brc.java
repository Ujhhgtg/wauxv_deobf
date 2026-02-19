package me.hd.wauxv.obf;

import android.os.Bundle;
import android.util.SparseIntArray;
import io.github.rosemoe.sora.widget.CodeEditor;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class brc extends lj {
    public static final Pattern aa = Pattern.compile(
            "https?:\\/\\/(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()@:%_\\+.~#?&/=]*)");
    public final ThreadLocal ab = new ThreadLocal();
    public final io ac = new io(26);

    public static void ad(CharSequence charSequence, int i, ekk ekkVar, ArrayList arrayList) {
        Matcher matcher = aa.matcher(charSequence);
        int i2 = 0;
        while (i2 < charSequence.length() && matcher.find(i2)) {
            int iStart = matcher.start();
            int iEnd = matcher.end();
            if (iStart > i2) {
                arrayList.add(new brb(ekkVar, i2 + i));
            }
            String strGroup = matcher.group();
            brb brbVar = new brb();
            brbVar.a = ekkVar;
            brbVar.b = iStart + i;
            brbVar.c = strGroup;
            arrayList.add(brbVar);
            i2 = iEnd;
        }
        if (i2 != charSequence.length()) {
            arrayList.add(new brb(ekkVar, i + i2));
        }
    }

    /*
     * JADX WARN: Failed to find 'out' block for switch in B:21:0x0048. Please
     * report as an issue.
     */
    /* JADX WARN: Found duplicated region for block: B:34:0x007b */
    /* JADX WARN: Found duplicated region for block: B:71:0x0100 */
    /* JADX WARN: Found duplicated region for block: B:76:0x0127 A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v23 */
    /* JADX WARN: Type inference failed for: r5v24 */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v3, types: [me.hd.wauxv.obf.coe] */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v8, types: [me.hd.wauxv.obf.dlh] */
    public final ArrayList ae(bow bowVar) {
        coe coeVarAa;
        boolean z;
        ?? Aa;
        int iOrdinal;
        int i;
        int i2;
        int iOrdinal2;
        coe coeVarAa2;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = bowVar.b;
        ekk ekkVar = ekk.c;
        ekk ekkVar2 = ekkVar;
        int i3 = 0;
        boolean z2 = false;
        while (i3 < arrayList2.size()) {
            brb brbVar = (brb) arrayList2.get(i3);
            ekk ekkVar3 = brbVar.a;
            String str = brbVar.c;
            int i4 = brbVar.b;
            int iOrdinal3 = ekkVar3.ordinal();
            if (iOrdinal3 == 0 || iOrdinal3 == 1) {
                cmz.l(5);
                coeVarAa = ajn.aa(i4, 5);
            } else if (iOrdinal3 == 4 || iOrdinal3 == 5 || iOrdinal3 == 6) {
                coeVarAa = ajn.aa(i4, cmz.af(22, false, true, true));
            } else {
                if (iOrdinal3 == 9) {
                    if (z2) {
                        i = 25;
                        z = false;
                    } else {
                        if (ekkVar2 == ekk.cl) {
                            i2 = 28;
                        } else {
                            ekk ekkVar4 = ekkVar;
                            for (int i5 = i3 + 1; i5 < arrayList2.size() && ((iOrdinal2 = (ekkVar4 = ((brb) arrayList2.get(i5)).a).ordinal()) == 0 || iOrdinal2 == 1 || iOrdinal2 == 4 || iOrdinal2 == 5 || iOrdinal2 == 6); i5++) {
                            }
                            if (ekkVar4 == ekk.p) {
                                i2 = 27;
                            } else {
                                i = 26;
                                z = true;
                            }
                        }
                        int i6 = i2;
                        z = z2;
                        i = i6;
                    }
                    cmz.l(i);
                    Aa = ajn.aa(i4, i);
                } else if (iOrdinal3 != 10 && iOrdinal3 != 13 && iOrdinal3 != 14) {
                    switch (iOrdinal3) {
                        case 35:
                            cmz.l(24);
                            coeVarAa2 = ajn.aa(i4, ((long) 24) | 2199023255552L);
                            z = false;
                            Aa = coeVarAa2;
                            break;
                        case 36:
                        case 41:
                        case 42:
                        case 43:
                        case 46:
                        case 48:
                        case 51:
                        case 52:
                        case 60:
                        case 71:
                            z = true;
                            Aa = ajn.aa(i4, cmz.af(21, true, false, false));
                            break;
                        default:
                            switch (iOrdinal3) {
                                case 90:
                                case 91:
                                case 92:
                                    break;
                                default:
                                    ekk ekkVar5 = ekk.t;
                                    if (ekkVar3 == ekkVar5 || (ekkVar3 == ekk.u && ekkVar2 == ekkVar5)) {
                                        coeVarAa = ajn.aa(i4, 23L);
                                    } else {
                                        coeVarAa2 = ajn.aa(i4, 23L);
                                        z = false;
                                        Aa = coeVarAa2;
                                    }
                                    break;
                            }
                        case 37:
                        case 38:
                        case 39:
                        case 40:
                        case 44:
                        case 45:
                        case 47:
                        case 49:
                        case 50:
                        case 53:
                        case 54:
                        case 55:
                        case 56:
                        case 57:
                        case 58:
                        case 59:
                        case 61:
                        case 62:
                        case 63:
                        case 64:
                        case 65:
                        case 66:
                        case 67:
                        case 68:
                        case 69:
                        case 70:
                        case 72:
                        case 73:
                        case 74:
                        case 75:
                        case 76:
                        case 77:
                        case 78:
                        case 79:
                        case 80:
                        case 81:
                        case 82:
                        case 83:
                        case 84:
                        case 85:
                        case 86:
                        case 87:
                        case 88:
                            coeVarAa2 = ajn.aa(i4, cmz.af(21, true, false, false));
                            z = false;
                            Aa = coeVarAa2;
                            break;
                    }
                } else {
                    cmz.l(24);
                    coeVarAa2 = ajn.aa(i4, ((long) 24) | 2199023255552L);
                    z = false;
                    Aa = coeVarAa2;
                }
                iOrdinal = ekkVar3.ordinal();
                if (iOrdinal != 0 && iOrdinal != 1 && iOrdinal != 4 && iOrdinal != 5 && iOrdinal != 6) {
                    ekkVar2 = ekkVar3;
                }
                if (str != null) {
                    Aa = (dlh) dlh.a.x(Aa.b, Aa.c);
                    Aa.k(2, new dlf());
                    Aa.k(3, new arp((int) (Aa.d() & 524287)));
                }
                arrayList.add(Aa);
                i3++;
                z2 = z;
            }
            z = z2;
            Aa = coeVarAa;
            iOrdinal = ekkVar3.ordinal();
            if (iOrdinal != 0) {
                ekkVar2 = ekkVar3;
            }
            if (str != null) {
                Aa = (dlh) dlh.a.x(Aa.b, Aa.c);
                Aa.k(2, new dlf());
                Aa.k(3, new arp((int) (Aa.d() & 524287)));
            }
            arrayList.add(Aa);
            i3++;
            z2 = z;
        }
        return arrayList;
    }

    public final bow af(afo afoVar, Object obj) {
        int iAg;
        long jAl;
        ArrayList arrayList = new ArrayList();
        dmk dmkVar = new dmk();
        int i = ((dmk) obj).a;
        if (i == 0) {
            iAg = ag(afoVar, 0, arrayList, dmkVar);
        } else if (i == 1) {
            char c = 0;
            char c2 = 0;
            int i2 = 0;
            while (true) {
                if ((c == '*' && c2 == '/') || i2 >= afoVar.b) {
                    break;
                }
                char cCharAt = afoVar.charAt(i2);
                i2++;
                char c3 = c2;
                c2 = cCharAt;
                c = c3;
            }
            if (c == '*' && c2 == '/') {
                ekk ekkVar = ekk.e;
                if (i2 < 1000) {
                    ad(afoVar.subSequence(0, i2), 0, ekkVar, arrayList);
                } else {
                    arrayList.add(new brb(ekkVar, 0));
                }
                jAl = KotlinHelpers.al(0, i2);
            } else {
                ekk ekkVar2 = ekk.f;
                if (i2 < 1000) {
                    ad(afoVar.subSequence(0, i2), 0, ekkVar2, arrayList);
                } else {
                    arrayList.add(new brb(ekkVar2, 0));
                }
                jAl = KotlinHelpers.al(1, i2);
            }
            iAg = ((int) (jAl >> 32)) == 0 ? ag(afoVar, (int) (jAl & 4294967295L), arrayList, dmkVar) : 1;
        } else {
            iAg = 0;
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new brb(ekk.c, 0));
        }
        dmkVar.a = iAg;
        bow bowVar = new bow();
        bowVar.a = dmkVar;
        bowVar.b = arrayList;
        return bowVar;
    }

    public final int ag(CharSequence charSequence, int i, ArrayList arrayList, dmk dmkVar) {
        bre breVar;
        synchronized (this) {
            breVar = (bre) this.ab.get();
            if (breVar == null) {
                breVar = new bre("");
                this.ab.set(breVar);
            }
        }
        if (charSequence == null) {
            throw new IllegalArgumentException();
        }
        breVar.c = charSequence;
        breVar.f = 0;
        breVar.e = 0;
        breVar.d = charSequence.length();
        breVar.e = i;
        while (true) {
            ekk ekkVarI = breVar.i();
            if (ekkVarI == ekk.d) {
                return 0;
            }
            int i2 = breVar.f;
            if (i2 >= 1000 || !(ekkVarI == ekk.n || ekkVarI == ekk.e || ekkVarI == ekk.f || ekkVarI == ekk.g)) {
                arrayList.add(new brb(ekkVarI, breVar.e));
                if (ekkVarI == ekk.r || ekkVarI == ekk.s) {
                    dmkVar.b = true;
                }
                if (ekkVarI == ekk.j) {
                    CharSequence charSequence2 = breVar.c;
                    int i3 = breVar.e;
                    CharSequence charSequenceSubSequence = charSequence2.subSequence(i3, breVar.f + i3);
                    if (dmkVar.c == null) {
                        dmkVar.c = new ArrayList();
                    }
                    if (charSequenceSubSequence instanceof String) {
                        dmkVar.c.add((String) charSequenceSubSequence);
                    } else {
                        dmkVar.c.add(charSequenceSubSequence.toString());
                    }
                }
                if (ekkVarI == ekk.f) {
                    return 1;
                }
            } else {
                CharSequence charSequence3 = breVar.c;
                int i4 = breVar.e;
                ad(charSequence3.subSequence(i4, i2 + i4), breVar.e, ekkVarI, arrayList);
                if (ekkVarI == ekk.f) {
                    return 1;
                }
            }
        }
    }

    @Override // me.hd.wauxv.obf.hz
    public final void s(afq afqVar, Bundle bundle) {
        super.s(afqVar, bundle);
        io ioVar = this.ac;
        ReentrantLock reentrantLock = (ReentrantLock) ioVar.c;
        reentrantLock.lock();
        try {
            ((HashMap) ioVar.d).clear();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // me.hd.wauxv.obf.lj
    public final ArrayList v(aff affVar, ik ikVar) {
        FactoryPools factoryPoolsVar;
        CodeEditor codeEditor;
        Stack stack;
        int i;
        Stack stack2 = new Stack();
        ArrayList arrayList = new ArrayList();
        SyntheticPileOfMess bmuVar = new SyntheticPileOfMess(25);
        SparseIntArray sparseIntArray = (SparseIntArray) bmuVar.obj;
        Stack stack3 = new Stack();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < affVar.a.size() && ikVar.t()) {
            lh lhVar = this.b;
            if (lhVar != Thread.currentThread()) {
                throw new SecurityException("Can not get state from non-analytical or abandoned thread");
            }
            bow bowVar = (i2 < 0 || i2 >= lhVar.e.size()) ? null : (bow) lhVar.e.get(i2);
            dmk dmkVar = bowVar.a;
            ArrayList arrayList2 = bowVar.b;
            int i5 = dmkVar.a;
            int i6 = 1;
            boolean z = i5 == 0 || (i5 == 1 && arrayList2.size() > 1);
            if (bowVar.a.b || z) {
                int i7 = 0;
                while (i7 < arrayList2.size()) {
                    brb brbVar = (brb) arrayList2.get(i7);
                    ekk ekkVar = brbVar.a;
                    int i8 = brbVar.b;
                    ekk ekkVar2 = ekk.s;
                    int i9 = i6;
                    ekk ekkVar3 = ekk.r;
                    if (ekkVar == ekkVar3) {
                        if (stack2.isEmpty()) {
                            if (i4 > i3) {
                                i3 = i4;
                            }
                            i4 = 0;
                        }
                        i4++;
                        i = i3;
                        aah aahVar = new aah();
                        aahVar.c = i2;
                        aahVar.d = i8;
                        stack2.push(aahVar);
                        stack = stack2;
                    } else if (ekkVar != ekkVar2 || stack2.isEmpty()) {
                        stack = stack2;
                        i = i3;
                    } else {
                        stack = stack2;
                        aah aahVar2 = (aah) stack2.pop();
                        aahVar2.e = i2;
                        aahVar2.f = i8;
                        i = i3;
                        if (aahVar2.c != i2) {
                            arrayList.add(aahVar2);
                        }
                    }
                    int i10 = i;
                    ekk ekkVar4 = ekk.p;
                    ArrayList arrayList3 = arrayList;
                    ekk ekkVar5 = ekk.t;
                    int i11 = (ekkVar == ekkVar3 || ekkVar == ekkVar2) ? 3
                            : (ekkVar == ekkVar5 || ekkVar == ekk.u) ? 2
                                    : (ekkVar == ekkVar4 || ekkVar == ekk.q) ? i9 : 0;
                    if (i11 > 0) {
                        if (ekkVar == ekkVar3 || ekkVar == ekkVar5 || ekkVar == ekkVar4) {
                            stack3.push(Long.valueOf(KotlinHelpers.al(i11, affVar.v(i2, i8))));
                        } else if (!stack3.isEmpty()) {
                            Long l = (Long) stack3.pop();
                            if (((int) (l.longValue() >> 32)) == i11) {
                                int iLongValue = ((int) (l.longValue() & 4294967295L)) + 1;
                                int iV = affVar.v(i2, i8) + 1;
                                sparseIntArray.put(iLongValue, iV);
                                sparseIntArray.put(iV, iLongValue);
                            } else if (i11 == 3) {
                                while (!stack3.isEmpty()) {
                                    Long l2 = (Long) stack3.pop();
                                    if (((int) (l2.longValue() >> 32)) == 3) {
                                        int iLongValue2 = ((int) (l2.longValue() & 4294967295L)) + 1;
                                        int iV2 = affVar.v(i2, i8) + 1;
                                        sparseIntArray.put(iLongValue2, iV2);
                                        sparseIntArray.put(iV2, iLongValue2);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    i7++;
                    i6 = i9;
                    i3 = i10;
                    stack2 = stack;
                    arrayList = arrayList3;
                }
            }
            i2++;
            stack2 = stack2;
            arrayList = arrayList;
        }
        ArrayList arrayList4 = arrayList;
        if (ikVar.t() && (factoryPoolsVar = (FactoryPools) this.g) != null
                && (codeEditor = (CodeEditor) ((WeakReference) factoryPoolsVar.e).get()) != null
                && this == codeEditor.getEditorLanguage().e() && ((SyntheticPileOfMess) factoryPoolsVar.h) != bmuVar) {
            factoryPoolsVar.h = bmuVar;
            factoryPoolsVar.af(new dh(factoryPoolsVar, 10));
        }
        return arrayList4;
    }

    @Override // me.hd.wauxv.obf.lj
    public final void x(dmk dmkVar) {
        ArrayList<String> arrayList = dmkVar.c;
        if (arrayList != null) {
            for (String str : arrayList) {
                io ioVar = this.ac;
                HashMap map = (HashMap) ioVar.d;
                ReentrantLock reentrantLock = (ReentrantLock) ioVar.c;
                reentrantLock.lock();
                try {
                    chr chrVar = (chr) map.get(str);
                    if (chrVar != null) {
                        int i = chrVar.a - 1;
                        chrVar.a = i;
                        if (i <= 0) {
                            map.remove(str);
                        } else {
                            continue;
                        }
                    }
                    reentrantLock.unlock();
                } catch (Throwable th) {
                    reentrantLock.unlock();
                    throw th;
                }
            }
        }
    }

    @Override // me.hd.wauxv.obf.lj
    public final void y(dmk dmkVar) {
        ArrayList<String> arrayList = dmkVar.c;
        if (arrayList != null) {
            for (String str : arrayList) {
                io ioVar = this.ac;
                ReentrantLock reentrantLock = (ReentrantLock) ioVar.c;
                reentrantLock.lock();
                try {
                    ((chr) ((HashMap) ioVar.d).computeIfAbsent(str, new ky(11))).a++;
                    reentrantLock.unlock();
                } catch (Throwable th) {
                    reentrantLock.unlock();
                    throw th;
                }
            }
        }
    }
}
