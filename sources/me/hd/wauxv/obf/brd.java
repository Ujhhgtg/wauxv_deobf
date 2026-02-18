package me.hd.wauxv.obf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import net.bytebuddy.pool.TypePool;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class brd implements btq {
    public static final aao a = chm.i("for(int ${1:i} = 0;$1 < ${2:count};$1++) {\n    $0\n}");
    public static final aao h = chm.i("private final static ${1:type} ${2/(.*)/${1:/upcase}/} = ${3:value};");
    public static final aao i = chm.i("${1:${CLIPBOARD}}");
    public DefaultConfig j;
    public final brc k;
    public final awp l = new awp(20);
    public final awp[] m = { new awp(this) };

    public brd() {
        String[] strArr = bre.b;
        DefaultConfig ioVar = new DefaultConfig(27, false);
        ioVar.c = strArr;
        HashMap map = new HashMap();
        for (String str : strArr) {
            map.put(str, Boolean.TRUE);
        }
        ioVar.d = map;
        this.j = ioVar;
        this.k = new brc();
    }

    public static int n(String str) {
        bre breVar = new bre(str);
        int i2 = 0;
        while (true) {
            ekk ekkVarI = breVar.i();
            if (ekkVarI == ekk.d) {
                return Math.max(0, i2) * 4;
            }
            if (ekkVarI == ekk.r) {
                i2++;
            }
        }
    }

    @Override // me.hd.wauxv.obf.btq
    public final awp[] b() {
        return this.m;
    }

    @Override // me.hd.wauxv.obf.btq
    public final int c(afq afqVar, int i2, int i3) {
        afqVar.f();
        return n(afqVar.a.aa(i2).substring(0, i3));
    }

    @Override // me.hd.wauxv.obf.btq
    public final awp d() {
        return this.l;
    }

    @Override // me.hd.wauxv.obf.btq
    public final void destroy() {
        this.j = null;
    }

    @Override // me.hd.wauxv.obf.btq
    public final hz e() {
        return this.k;
    }

    @Override // me.hd.wauxv.obf.btq
    public final void f(afq afqVar, ud udVar, abw abwVar) {
        boolean zTryLock;
        List<dhr> list;
        afq afqVar2 = afqVar;
        int i2 = udVar.c;
        int i3 = udVar.b;
        afqVar2.f();
        String strAa = afqVar2.a.aa(i3);
        while (i2 > 0) {
            if (!cib.c(cib.b, strAa.charAt(i2 - 1))) {
                break;
            } else {
                i2--;
            }
        }
        String strSubstring = strAa.substring(i2, udVar.c);
        DefaultConfig ioVar = this.k.ac;
        if (ioVar != null) {
            DefaultConfig ioVar2 = this.j;
            ioVar2.getClass();
            int length = strSubstring.length();
            int i4 = 0;
            if (length == 0) {
                list = Collections.EMPTY_LIST;
            } else {
                ArrayList arrayList = new ArrayList();
                String[] strArr = (String[]) ioVar2.c;
                HashMap map = (HashMap) ioVar2.d;
                String lowerCase = strSubstring.toLowerCase(Locale.ROOT);
                for (String str : strArr) {
                    Locale locale = Locale.ROOT;
                    bgs bgsVarC = baf.c(strSubstring, strSubstring.toLowerCase(locale), str, 0,
                            str.toLowerCase(locale));
                    int i5 = bgsVarC == null ? -100 : bgsVarC.b;
                    if (str.startsWith(lowerCase) || i5 >= -20) {
                        dhr dhrVar = new dhr(length, str, "Keyword", str);
                        dhrVar.i(abu.b);
                        arrayList.add(dhrVar);
                    }
                }
                ArrayList<String> arrayList2 = new ArrayList();
                ReentrantLock reentrantLock = (ReentrantLock) ioVar.c;
                try {
                    zTryLock = reentrantLock.tryLock(3L, TimeUnit.MILLISECONDS);
                } catch (InterruptedException unused) {
                    zTryLock = false;
                }
                if (zTryLock) {
                    try {
                        for (String str2 : ((HashMap) ioVar.d).keySet()) {
                            Locale locale2 = Locale.ROOT;
                            bgs bgsVarC2 = baf.c(strSubstring, strSubstring.toLowerCase(locale2), str2, 0,
                                    str2.toLowerCase(locale2));
                            int i6 = bgsVarC2 == null ? -100 : bgsVarC2.b;
                            if (cna.ag(str2, strSubstring, true) || i6 >= -20) {
                                if (strSubstring.length() != str2.length() || !cna.ag(strSubstring, str2, false)) {
                                    arrayList2.add(str2);
                                }
                            }
                        }
                        reentrantLock.unlock();
                    } catch (Throwable th) {
                        reentrantLock.unlock();
                        throw th;
                    }
                }
                for (String str3 : arrayList2) {
                    if (map == null || !map.containsKey(str3)) {
                        dhr dhrVar2 = new dhr(length, str3, "Identifier", str3);
                        dhrVar2.i(abu.a);
                        arrayList.add(dhrVar2);
                    }
                }
                list = arrayList;
            }
            throwIfVar1IsNull(list, "completionItemList");
            ArrayList arrayList3 = new ArrayList();
            afqVar2.f();
            afo afoVarY = ((aff) afqVar2.b).y(udVar.b);
            String string = "";
            String lowerCase2 = string;
            for (dhr dhrVar3 : list) {
                afqVar2.f();
                int i7 = dhrVar3.e;
                if (string.length() != i7) {
                    if (i7 == 0) {
                        string = "";
                    } else {
                        throwIfVar1IsNull(afoVarY);
                        int i8 = udVar.c;
                        string = afoVarY.subSequence(i8 - i7, i8).toString();
                    }
                    lowerCase2 = string.toLowerCase(Locale.ROOT);
                    throwIfVar1IsNull(lowerCase2, "toLowerCase(...)");
                }
                String str4 = string;
                bgs bgsVar = bgs.a;
                dlb dlbVar = new dlb(dhrVar3, bgsVar);
                if (i7 == 0) {
                    dlbVar.b = bgsVar;
                } else {
                    int i9 = i4;
                    while (i9 < i7) {
                        char cCharAt = str4.charAt(i9);
                        if (cCharAt != '\t' && cCharAt != ' ') {
                            break;
                        } else {
                            i9++;
                        }
                    }
                    if (i9 >= i7) {
                        bgs bgsVar2 = bgs.a;
                        throwIfVar1IsNull(bgsVar2, "<set-?>");
                        dlbVar.b = bgsVar2;
                    } else {
                        String strAa2 = ewz.aa(dhrVar3.b);
                        String lowerCase3 = ewz.aa(dhrVar3.b).toLowerCase(Locale.ROOT);
                        throwIfVar1IsNull(lowerCase3, "toLowerCase(...)");
                        throwIfVar1IsNull(lowerCase2, "lowPattern");
                        throwIfVar1IsNull(strAa2, "wordText");
                        bgs bgsVarB = afoVarY.b > 2000 ? baf.b(str4, lowerCase2, i9, strAa2, lowerCase3, bgt.a)
                                : baf.c(str4, lowerCase2, strAa2, i9, lowerCase3);
                        if (bgsVarB != null) {
                            dlbVar.b = bgsVarB;
                        }
                        afqVar2 = afqVar;
                        string = str4;
                        i4 = 0;
                    }
                    dhrVar3.f = dlbVar;
                }
                arrayList3.add(dhrVar3);
                afqVar2 = afqVar;
                string = str4;
                i4 = 0;
            }
            if (!arrayList3.isEmpty() && ((dhr) aaz.d(arrayList3)).f != null && ((dhr) aaz.d(arrayList3)).f == null) {
                throw new IllegalArgumentException(
                        "The completionItemList must run through the filterCompletionItems() method first");
            }
            za zaVar = new za(3);
            ArrayList arrayList4 = abwVar.b;
            ReentrantLock reentrantLock2 = abwVar.c;
            abwVar.k();
            if (!abwVar.i) {
                reentrantLock2.lock();
                try {
                    arrayList4.addAll(arrayList3);
                    reentrantLock2.unlock();
                    if (arrayList4.size() >= abwVar.h) {
                        abwVar.l(false);
                    }
                } catch (Throwable th2) {
                    reentrantLock2.unlock();
                    throw th2;
                }
            }
            abwVar.k();
            if (!abwVar.i) {
                abwVar.g = zaVar;
                if (!abwVar.a.isEmpty()) {
                    abwVar.d.post(new hl(abwVar, 1, zaVar));
                }
            }
        }
        if ("fori".startsWith(strSubstring) && strSubstring.length() > 0) {
            abwVar.j(new dhr("fori", "Snippet - For loop on index", new dil(strSubstring.length(), a)));
        }
        if ("sconst".startsWith(strSubstring) && strSubstring.length() > 0) {
            abwVar.j(new dhr("sconst", "Snippet - Static Constant", new dil(strSubstring.length(), h)));
        }
        if (!"clip".startsWith(strSubstring) || strSubstring.length() <= 0) {
            return;
        }
        abwVar.j(new dhr("clip", "Snippet - Clipboard contents", new dil(strSubstring.length(), i)));
    }

    @Override // me.hd.wauxv.obf.btq
    public final jx g() {
        doq doqVar = new doq(19);
        doqVar.ad('{', new dor("{", "}"));
        doqVar.ad('(', new dor("(", ")"));
        doqVar.ad(TypePool.Default.LazyTypeDescription.GenericTypeToken.COMPONENT_TYPE_PATH, new dor("[", "]"));
        doqVar.ad('\"', new dor("\"", "\"", new dop(0)));
        doqVar.ad('\'', new dor("'", "'", new dop(1)));
        return doqVar;
    }
}
