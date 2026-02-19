package me.hd.wauxv.obf;

import android.content.Context;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class cjg {
    public static final /* synthetic */ int e = 0;
    public final String f;
    public final ea g;
    public cji h;
    public CharSequence i;
    public final dlo j;

    static {
        new LinkedHashMap();
    }

    public cjg(ckl cklVar) {
        LinkedHashMap linkedHashMap = ckm.a;
        this.f = KotlinHelpers2.au(cklVar.getClass());
        this.g = new ea(this);
        this.j = new dlo(0);
    }

    public void d(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainAttributes = context.getResources().obtainAttributes(attributeSet, cyc.e);
        throwIfVar1IsNull(typedArrayObtainAttributes, "obtainAttributes(...)");
        String string = typedArrayObtainAttributes.getString(2);
        ea eaVar = this.g;
        if (string == null) {
            eaVar.a = 0;
            eaVar.d = null;
        } else {
            eaVar.getClass();
            if (dnj.ak(string)) {
                throw new IllegalArgumentException("Cannot have an empty route");
            }
            String strConcat = "android-app://androidx.navigation/".concat(string);
            throwIfVar1IsNull(strConcat, "uriPattern");
            ArrayList arrayListAk = FastKV.ak((LinkedHashMap) eaVar.e, new cjh(new cjd(strConcat, null, null), 1));
            if (!arrayListAk.isEmpty()) {
                StringBuilder sbZ = StaticHelpers6.concatAndToSb("Cannot set route \"", string, "\" for destination ");
                sbZ.append((cjg) eaVar.b);
                sbZ.append(". Following required arguments are missing: ");
                sbZ.append(arrayListAk);
                throw new IllegalArgumentException(sbZ.toString().toString());
            }
            new Kotlin$Lazy(new ake(strConcat, 1));
            eaVar.a = strConcat.hashCode();
            eaVar.d = null;
        }
        eaVar.f = string;
        if (typedArrayObtainAttributes.hasValue(1)) {
            int resourceId = typedArrayObtainAttributes.getResourceId(1, 0);
            eaVar.a = resourceId;
            eaVar.d = null;
            eaVar.d = bmy.r(new anr(context, 8), resourceId);
        }
        this.i = typedArrayObtainAttributes.getText(0);
        typedArrayObtainAttributes.recycle();
    }

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this != obj) {
            if (obj != null && (obj instanceof cjg)) {
                ea eaVar = this.g;
                ArrayList arrayList = (ArrayList) eaVar.c;
                cjg cjgVar = (cjg) obj;
                dlo dloVar = cjgVar.j;
                ea eaVar2 = cjgVar.g;
                boolean zF = nullSafeIsEqual(arrayList, (ArrayList) eaVar2.c);
                dlo dloVar2 = this.j;
                if (dloVar2.i() != dloVar.i()) {
                    z = false;
                    break;
                }
                Iterator it = ((ada) dfv.a(new dlp(dloVar2))).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = true;
                        break;
                    }
                    int iIntValue = ((Number) it.next()).intValue();
                    if (!nullSafeIsEqual(dloVar2.f(iIntValue), dloVar.f(iIntValue))) {
                        z = false;
                        break;
                    }
                }
                if (n().size() != cjgVar.n().size()) {
                    z2 = false;
                    break;
                }
                Iterator it2 = ((Iterable) StaticHelpers5.a(n().entrySet()).b).iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        z2 = true;
                        break;
                    }
                    Map.Entry entry = (Map.Entry) it2.next();
                    if (!cjgVar.n().containsKey(entry.getKey())
                            || !nullSafeIsEqual(cjgVar.n().get(entry.getKey()), entry.getValue())) {
                        z2 = false;
                        break;
                    }
                }
                if (eaVar.a != eaVar2.a || !nullSafeIsEqual((String) eaVar.f, (String) eaVar2.f) || !zF || !z || !z2) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        ea eaVar = this.g;
        int i = eaVar.a * 31;
        String str = (String) eaVar.f;
        int iHashCode = i + (str != null ? str.hashCode() : 0);
        for (cjd cjdVar : (ArrayList) eaVar.c) {
            int i2 = iHashCode * 31;
            String str2 = cjdVar.g;
            int iHashCode2 = (i2 + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = cjdVar.h;
            int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = cjdVar.i;
            iHashCode = iHashCode3 + (str4 != null ? str4.hashCode() : 0);
        }
        dlo dloVar = this.j;
        throwIfVar1IsNull(dloVar, "<this>");
        int i3 = 0;
        while (true) {
            if (!(i3 < dloVar.i())) {
                break;
            }
            int i4 = i3 + 1;
            cim cimVar = (cim) dloVar.j(i3);
            int i5 = ((iHashCode * 31) + cimVar.a) * 31;
            cjo cjoVar = cimVar.b;
            iHashCode = i5 + (cjoVar != null ? cjoVar.hashCode() : 0);
            Bundle bundle = cimVar.c;
            if (bundle != null) {
                iHashCode = cna.l(bundle) + (iHashCode * 31);
            }
            i3 = i4;
        }
        for (String str5 : n().keySet()) {
            int iE = bjs.e(str5, iHashCode * 31, 31);
            Object obj = n().get(str5);
            iHashCode = iE + (obj != null ? obj.hashCode() : 0);
        }
        return iHashCode;
    }

    public final Bundle k(Bundle bundle) {
        Object obj;
        LinkedHashMap linkedHashMap = (LinkedHashMap) this.g.e;
        if (bundle == null && linkedHashMap.isEmpty()) {
            return null;
        }
        Bundle bundleR = ResourcesCompat.r((Pair[]) Arrays.copyOf(new Pair[0], 0));
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            String str = (String) entry.getKey();
            cin cinVar = (cin) entry.getValue();
            cinVar.getClass();
            throwIfVar1IsNull(str, "name");
            if (cinVar.c && (obj = cinVar.d) != null) {
                cinVar.a.j(bundleR, str, obj);
            }
        }
        if (bundle != null) {
            bundleR.putAll(bundle);
            for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                String str2 = (String) entry2.getKey();
                cin cinVar2 = (cin) entry2.getValue();
                cinVar2.getClass();
                cjv cjvVar = cinVar2.a;
                throwIfVar1IsNull(str2, "name");
                if (cinVar2.b || !bundleR.containsKey(str2)
                        || !ifVar2BundleContainsVar1AsKeyAndValueIsNull(str2, bundleR)) {
                    try {
                        cjvVar.f(str2, bundleR);
                    } catch (IllegalStateException unused) {
                    }
                }
                StringBuilder sbZ = StaticHelpers6.concatAndToSb("Wrong argument type for '", str2, "' in argument savedState. ");
                sbZ.append(cjvVar.g());
                sbZ.append(" expected.");
                throw new IllegalArgumentException(sbZ.toString().toString());
            }
        }
        return bundleR;
    }

    /* JADX WARN: Found duplicated region for block: B:11:0x0023 */
    /* JADX WARN: Found duplicated region for block: B:14:0x002d */
    public final int[] l(cjg cjgVar) {
        km kmVar = new km();
        cjg cjgVar2 = this;
        while (true) {
            ea eaVar = cjgVar2.g;
            cji cjiVar = cjgVar2.h;
            if ((cjgVar != null ? cjgVar.h : null) != null) {
                cji cjiVar2 = cjgVar.h;
                throwIfVar1IsNull(cjiVar2);
                if (cjiVar2.p(eaVar.a) != cjgVar2) {
                    if (cjiVar != null || cjiVar.b.c != eaVar.a) {
                        kmVar.addFirst(cjgVar2);
                    }
                    if (!nullSafeIsEqual(cjiVar, cjgVar) || cjiVar == null) {
                        break;
                    }
                    cjgVar2 = cjiVar;
                } else {
                    kmVar.addFirst(cjgVar2);
                    break;
                }
            } else {
                if (cjiVar != null) {
                    kmVar.addFirst(cjgVar2);
                } else {
                    kmVar.addFirst(cjgVar2);
                }
                if (!nullSafeIsEqual(cjiVar, cjgVar)) {
                    break;
                }
                cjgVar2 = cjiVar;
            }
        }
        List listZ = StaticHelpers5.z(kmVar);
        ArrayList arrayList = new ArrayList(StaticHelpers4.ak(listZ, 10));
        Iterator it = listZ.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((cjg) it.next()).g.a));
        }
        return StaticHelpers5.y(arrayList);
    }

    public final cim m(int i) {
        dlo dloVar = this.j;
        cim cimVar = dloVar.i() == 0 ? null : (cim) dloVar.f(i);
        if (cimVar != null) {
            return cimVar;
        }
        cji cjiVar = this.h;
        if (cjiVar != null) {
            return cjiVar.m(i);
        }
        return null;
    }

    public final Map n() {
        return KotlinHelpers.at((LinkedHashMap) this.g.e);
    }

    /* JADX WARN: Found duplicated region for block: B:135:0x0308 */
    /* JADX WARN: Found duplicated region for block: B:137:0x030b */
    /* JADX WARN: Found duplicated region for block: B:140:0x0310 */
    /* JADX WARN: Found duplicated region for block: B:143:0x0325 */
    /* JADX WARN: Found duplicated region for block: B:150:0x0349 */
    /* JADX WARN: Found duplicated region for block: B:153:0x035c A[MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:155:0x0371 */
    /*
     * JADX WARN: Found duplicated region for block: B:166:0x0377 A[ADDED_TO_REGION,
     * REMOVE, SYNTHETIC]
     */
    /* JADX WARN: Found duplicated region for block: B:168:0x037f A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:16:0x0063 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:170:0x0381 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:17:0x0065 */
    /* JADX WARN: Found duplicated region for block: B:18:0x0068 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:19:0x006a */
    /* JADX WARN: Found duplicated region for block: B:20:0x006c */
    /* JADX WARN: Found duplicated region for block: B:22:0x0072 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:23:0x0074 */
    /* JADX WARN: Found duplicated region for block: B:24:0x0077 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:25:0x0079 */
    /* JADX WARN: Found duplicated region for block: B:26:0x007b */
    /* JADX WARN: Found duplicated region for block: B:28:0x008a */
    /* JADX WARN: Found duplicated region for block: B:29:0x008d */
    /* JADX WARN: Found duplicated region for block: B:31:0x0090 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:32:0x0092 */
    /* JADX WARN: Found duplicated region for block: B:34:0x00a9 */
    /* JADX WARN: Found duplicated region for block: B:36:0x00b5 */
    /* JADX WARN: Found duplicated region for block: B:37:0x00bb */
    /* JADX WARN: Found duplicated region for block: B:49:0x00fc */
    /* JADX WARN: Found duplicated region for block: B:70:0x0179 */
    /* JADX WARN: Found duplicated region for block: B:71:0x017b */
    /* JADX WARN: Found duplicated region for block: B:74:0x0186 */
    /* JADX WARN: Found duplicated region for block: B:81:0x01bd */
    /* JADX WARN: Found duplicated region for block: B:86:0x01ca */
    /*
     * JADX WARN: Type inference failed for: r15v12, types: [java.lang.Object,
     * me.hd.wauxv.obf.btt]
     */
    public cjf o(FactoryPools factoryPoolsVar) {
        boolean z;
        boolean zF;
        boolean z2;
        Iterator it;
        Kotlin$Lazy kotlin$LazyVar;
        Bundle bundle;
        int size;
        int i;
        boolean z3;
        int i2;
        cjf cjfVar;
        final Bundle bundleR;
        final int i3;
        dap dapVar;
        bzx bzxVarE;
        List listBf;
        List listU;
        List listBf2;
        int i4;
        dap dapVar2;
        Bundle bundle2;
        Bundle bundle3;
        bzx bzxVarE2;
        final Bundle bundleR2;
        dap dapVar3;
        final int i5;
        bzx bzxVarE3;
        int i6;
        String strDecode;
        boolean zF2;
        ea eaVar = this.g;
        LinkedHashMap linkedHashMap = (LinkedHashMap) eaVar.e;
        String str = (String) factoryPoolsVar.h;
        Object obj = (String) factoryPoolsVar.f;
        Uri uri = (Uri) factoryPoolsVar.e;
        ArrayList arrayList = (ArrayList) eaVar.c;
        if (arrayList.isEmpty()) {
            return null;
        }
        Iterator it2 = arrayList.iterator();
        cjf cjfVar2 = null;
        while (it2.hasNext()) {
            cjd cjdVar = (cjd) it2.next();
            cjdVar.getClass();
            Kotlin$Lazy kotlin$LazyVar2 = cjdVar.u;
            Kotlin$Lazy kotlin$LazyVar3 = cjdVar.l;
            String str2 = cjdVar.i;
            String str3 = cjdVar.h;
            if (((dap) kotlin$LazyVar3.getValue()) == null) {
                zF = true;
            } else {
                if (uri == null) {
                    zF = false;
                } else {
                    dap dapVar4 = (dap) kotlin$LazyVar3.getValue();
                    throwIfVar1IsNull(dapVar4);
                    z = true;
                    zF = dapVar4.f(uri.toString());
                }
                if (!zF) {
                    if (!(str3 == null ? z : obj == null ? false : str3.equals(obj))) {
                        if (str2 == null) {
                            zF2 = z;
                        } else if (str == null) {
                            zF2 = false;
                        } else {
                            dap dapVar5 = (dap) kotlin$LazyVar2.getValue();
                            throwIfVar1IsNull(dapVar5);
                            zF2 = dapVar5.f(str);
                        }
                        z2 = zF2 ? z : false;
                    }
                }
                if (z2) {
                    if (uri != null) {
                        cjdVar.getClass();
                        throwIfVar1IsNull(uri, "deepLink");
                        throwIfVar1IsNull(linkedHashMap, "arguments");
                        dapVar2 = (dap) cjdVar.l.getValue();
                        if (dapVar2 != null) {
                            bundle2 = null;
                            bzxVarE2 = dapVar2.e(uri.toString());
                            if (bzxVarE2 == null) {
                                it = it2;
                                kotlin$LazyVar = kotlin$LazyVar2;
                            } else {
                                bundleR2 = ResourcesCompat.r((Pair[]) Arrays.copyOf(new Pair[0], 0));
                                if (!cjdVar.aa(bzxVarE2, bundleR2, linkedHashMap)
                                        && (!((Boolean) cjdVar.m.getValue()).booleanValue()
                                                || cjdVar.ab(uri, bundleR2, linkedHashMap))) {
                                    String fragment = uri.getFragment();
                                    dapVar3 = (dap) cjdVar.s.getValue();
                                    if (dapVar3 != null || (bzxVarE3 = dapVar3.e(String.valueOf(fragment))) == null) {
                                        it = it2;
                                    } else {
                                        List list = (List) cjdVar.q.getValue();
                                        it = it2;
                                        ArrayList arrayList2 = new ArrayList(StaticHelpers4.ak(list, 10));
                                        Iterator it3 = list.iterator();
                                        int i7 = 0;
                                        while (it3.hasNext()) {
                                            Object next = it3.next();
                                            Iterator it4 = it3;
                                            int i8 = i7 + 1;
                                            if (i7 < 0) {
                                                OtherStaticHelpers.aj();
                                                throw null;
                                            }
                                            String str4 = (String) next;
                                            kotlin$LazyVar = kotlin$LazyVar2;
                                            bzt bztVarC = bzxVarE3.c.c(i8);
                                            if (bztVarC != null) {
                                                strDecode = Uri.decode(bztVarC.a);
                                                i6 = i8;
                                                throwIfVar1IsNull(strDecode, "decode(...)");
                                            } else {
                                                i6 = i8;
                                                strDecode = null;
                                            }
                                            if (strDecode == null) {
                                                strDecode = "";
                                            }
                                            try {
                                                cjd.x(bundleR2, str4, strDecode, (cin) linkedHashMap.get(str4));
                                                arrayList2.add(KotlinUnit.INSTANCE);
                                                kotlin$LazyVar2 = kotlin$LazyVar;
                                                it3 = it4;
                                                i7 = i6;
                                            } catch (IllegalArgumentException unused) {
                                            }
                                        }
                                    }
                                    kotlin$LazyVar = kotlin$LazyVar2;
                                    i5 = 0;
                                    if (!FastKV.ak(linkedHashMap, new IInvokable() { // from class: me.hd.wauxv.obf.cjb
                                        @Override // me.hd.wauxv.obf.bgf
                                        public final Object invoke(Object obj2) {
                                            boolean zContainsKey;
                                            String str5 = (String) obj2;
                                            switch (i5) {
                                                case 0:
                                                    throwIfVar1IsNull(str5, "argName");
                                                    Bundle bundle4 = bundleR2;
                                                    throwIfVar1IsNull(bundle4, "source");
                                                    zContainsKey = bundle4.containsKey(str5);
                                                    break;
                                                default:
                                                    throwIfVar1IsNull(str5, "key");
                                                    Bundle bundle5 = bundleR2;
                                                    throwIfVar1IsNull(bundle5, "source");
                                                    zContainsKey = bundle5.containsKey(str5);
                                                    break;
                                            }
                                            return Boolean.valueOf(!zContainsKey);
                                        }
                                    }).isEmpty()) {
                                        bundle3 = bundleR2;
                                    }
                                } else {
                                    it = it2;
                                    kotlin$LazyVar = kotlin$LazyVar2;
                                }
                            }
                            bundle = bundle3;
                        } else {
                            it = it2;
                            kotlin$LazyVar = kotlin$LazyVar2;
                            bundle2 = null;
                        }
                        bundle3 = bundle2;
                        bundle = bundle3;
                    } else {
                        it = it2;
                        kotlin$LazyVar = kotlin$LazyVar2;
                        bundle = null;
                    }
                    String str5 = cjdVar.g;
                    if (uri == null && str5 != null) {
                        List<String> pathSegments = uri.getPathSegments();
                        Uri uri2 = Uri.parse(str5);
                        throwIfVar1IsNull(uri2, "parse(...)");
                        List<String> pathSegments2 = uri2.getPathSegments();
                        throwIfVar1IsNull(pathSegments, "<this>");
                        throwIfVar1IsNull(pathSegments2, "other");
                        LinkedHashSet linkedHashSet = new LinkedHashSet(pathSegments);
                        linkedHashSet.retainAll(pathSegments2);
                        size = linkedHashSet.size();
                    }
                    i = size;
                    z3 = (obj == null && obj.equals(str3)) ? z : false;
                    if (str == null && str2 != null) {
                        dap dapVar6 = (dap) kotlin$LazyVar.getValue();
                        throwIfVar1IsNull(dapVar6);
                        if (dapVar6.f(str)) {
                            Pattern patternCompile = Pattern.compile("/");
                            throwIfVar1IsNull(patternCompile, "compile(...)");
                            Matcher matcher = patternCompile.matcher(str2);
                            if (matcher.find()) {
                                ArrayList arrayList3 = new ArrayList(10);
                                int iEnd = 0;
                                do {
                                    arrayList3.add(str2.subSequence(iEnd, matcher.start()).toString());
                                    iEnd = matcher.end();
                                } while (matcher.find());
                                arrayList3.add(str2.subSequence(iEnd, str2.length()).toString());
                                listBf = arrayList3;
                            } else {
                                listBf = dqc.toSingletonList(str2.toString());
                            }
                            boolean zIsEmpty = listBf.isEmpty();
                            List listU2 = EmptyReadonlyList.INSTANCE;
                            if (!zIsEmpty) {
                                ListIterator listIterator = listBf.listIterator(listBf.size());
                                while (true) {
                                    if (!listIterator.hasPrevious()) {
                                        listU = listU2;
                                        break;
                                    }
                                    if (((String) listIterator.previous()).length() != 0) {
                                        listU = StaticHelpers5.u(listIterator.nextIndex() + 1, listBf);
                                        break;
                                    }
                                }
                            } else {
                                listU = listU2;
                                break;
                            }
                            String str6 = (String) listU.get(0);
                            String str7 = (String) listU.get(z ? 1 : 0);
                            Pattern patternCompile2 = Pattern.compile("/");
                            throwIfVar1IsNull(patternCompile2, "compile(...)");
                            Matcher matcher2 = patternCompile2.matcher(str);
                            if (matcher2.find()) {
                                ArrayList arrayList4 = new ArrayList(10);
                                int iEnd2 = 0;
                                do {
                                    arrayList4.add(str.subSequence(iEnd2, matcher2.start()).toString());
                                    iEnd2 = matcher2.end();
                                } while (matcher2.find());
                                arrayList4.add(str.subSequence(iEnd2, str.length()).toString());
                                listBf2 = arrayList4;
                            } else {
                                listBf2 = dqc.toSingletonList(str.toString());
                            }
                            if (!listBf2.isEmpty()) {
                                ListIterator listIterator2 = listBf2.listIterator(listBf2.size());
                                while (true) {
                                    if (!listIterator2.hasPrevious()) {
                                        i4 = 1;
                                        break;
                                    }
                                    if (((String) listIterator2.previous()).length() != 0) {
                                        i4 = 1;
                                        listU2 = StaticHelpers5.u(listIterator2.nextIndex() + 1, listBf2);
                                        break;
                                    }
                                }
                            } else {
                                i4 = 1;
                                break;
                            }
                            List list2 = listU2;
                            String str8 = (String) list2.get(0);
                            String str9 = (String) list2.get(i4);
                            i2 = nullSafeIsEqual(str6, str8) ? 2 : 0;
                            if (nullSafeIsEqual(str7, str9)) {
                                i2++;
                            }
                        }
                    }
                    if (bundle != null) {
                        cjfVar = new cjf((cjg) eaVar.b, bundle, cjdVar.v, i, z3, i2);
                        if (cjfVar2 != null || cjfVar.compareTo(cjfVar2) > 0) {
                            cjfVar2 = cjfVar;
                            it2 = it;
                        }
                    } else if (z3 || i2 > -1) {
                        throwIfVar1IsNull(linkedHashMap, "arguments");
                        bundleR = ResourcesCompat.r((Pair[]) Arrays.copyOf(new Pair[0], 0));
                        if (uri != null && (dapVar = (dap) kotlin$LazyVar3.getValue()) != null
                                && (bzxVarE = dapVar.e(uri.toString())) != null) {
                            cjdVar.aa(bzxVarE, bundleR, linkedHashMap);
                            if (((Boolean) cjdVar.m.getValue()).booleanValue()) {
                                cjdVar.ab(uri, bundleR, linkedHashMap);
                            }
                        }
                        i3 = 1;
                        if (FastKV.ak(linkedHashMap, new IInvokable() { // from class: me.hd.wauxv.obf.cjb
                            @Override // me.hd.wauxv.obf.bgf
                            public final Object invoke(Object obj2) {
                                boolean zContainsKey;
                                String str52 = (String) obj2;
                                switch (i3) {
                                    case 0:
                                        throwIfVar1IsNull(str52, "argName");
                                        Bundle bundle4 = bundleR;
                                        throwIfVar1IsNull(bundle4, "source");
                                        zContainsKey = bundle4.containsKey(str52);
                                        break;
                                    default:
                                        throwIfVar1IsNull(str52, "key");
                                        Bundle bundle5 = bundleR;
                                        throwIfVar1IsNull(bundle5, "source");
                                        zContainsKey = bundle5.containsKey(str52);
                                        break;
                                }
                                return Boolean.valueOf(!zContainsKey);
                            }
                        }).isEmpty()) {
                            cjfVar = new cjf((cjg) eaVar.b, bundle, cjdVar.v, i, z3, i2);
                            if (cjfVar2 != null) {
                            }
                            cjfVar2 = cjfVar;
                            it2 = it;
                        }
                    }
                } else {
                    it = it2;
                }
                it2 = it;
            }
            z = true;
            if (!zF) {
                if (!(str3 == null ? z : obj == null ? false : str3.equals(obj))) {
                    if (str2 == null) {
                        zF2 = z;
                    } else if (str == null) {
                        zF2 = false;
                    } else {
                        dap dapVar52 = (dap) kotlin$LazyVar2.getValue();
                        throwIfVar1IsNull(dapVar52);
                        zF2 = dapVar52.f(str);
                    }
                    if (zF2) {
                    }
                }
            }
            if (z2) {
                if (uri != null) {
                    cjdVar.getClass();
                    throwIfVar1IsNull(uri, "deepLink");
                    throwIfVar1IsNull(linkedHashMap, "arguments");
                    dapVar2 = (dap) cjdVar.l.getValue();
                    if (dapVar2 != null) {
                        bundle2 = null;
                        bzxVarE2 = dapVar2.e(uri.toString());
                        if (bzxVarE2 == null) {
                            it = it2;
                            kotlin$LazyVar = kotlin$LazyVar2;
                        } else {
                            bundleR2 = ResourcesCompat.r((Pair[]) Arrays.copyOf(new Pair[0], 0));
                            if (cjdVar.aa(bzxVarE2, bundleR2, linkedHashMap)) {
                                it = it2;
                                kotlin$LazyVar = kotlin$LazyVar2;
                            } else {
                                String fragment2 = uri.getFragment();
                                dapVar3 = (dap) cjdVar.s.getValue();
                                if (dapVar3 != null) {
                                    it = it2;
                                    kotlin$LazyVar = kotlin$LazyVar2;
                                } else {
                                    it = it2;
                                    kotlin$LazyVar = kotlin$LazyVar2;
                                }
                                i5 = 0;
                                if (!FastKV.ak(linkedHashMap, new IInvokable() { // from class: me.hd.wauxv.obf.cjb
                                    @Override // me.hd.wauxv.obf.bgf
                                    public final Object invoke(Object obj2) {
                                        boolean zContainsKey;
                                        String str52 = (String) obj2;
                                        switch (i5) {
                                            case 0:
                                                throwIfVar1IsNull(str52, "argName");
                                                Bundle bundle4 = bundleR2;
                                                throwIfVar1IsNull(bundle4, "source");
                                                zContainsKey = bundle4.containsKey(str52);
                                                break;
                                            default:
                                                throwIfVar1IsNull(str52, "key");
                                                Bundle bundle5 = bundleR2;
                                                throwIfVar1IsNull(bundle5, "source");
                                                zContainsKey = bundle5.containsKey(str52);
                                                break;
                                        }
                                        return Boolean.valueOf(!zContainsKey);
                                    }
                                }).isEmpty()) {
                                    bundle3 = bundleR2;
                                }
                            }
                        }
                        bundle = bundle3;
                    } else {
                        it = it2;
                        kotlin$LazyVar = kotlin$LazyVar2;
                        bundle2 = null;
                    }
                    bundle3 = bundle2;
                    bundle = bundle3;
                } else {
                    it = it2;
                    kotlin$LazyVar = kotlin$LazyVar2;
                    bundle = null;
                }
                String str52 = cjdVar.g;
                size = uri == null ? 0 : 0;
                i = size;
                if (obj == null) {
                }
                i2 = str == null ? -1 : -1;
                if (bundle != null) {
                    cjfVar = new cjf((cjg) eaVar.b, bundle, cjdVar.v, i, z3, i2);
                    if (cjfVar2 != null) {
                    }
                    cjfVar2 = cjfVar;
                    it2 = it;
                } else if (z3) {
                    throwIfVar1IsNull(linkedHashMap, "arguments");
                    bundleR = ResourcesCompat.r((Pair[]) Arrays.copyOf(new Pair[0], 0));
                    if (uri != null) {
                        cjdVar.aa(bzxVarE, bundleR, linkedHashMap);
                        if (((Boolean) cjdVar.m.getValue()).booleanValue()) {
                            cjdVar.ab(uri, bundleR, linkedHashMap);
                        }
                    }
                    i3 = 1;
                    if (FastKV.ak(linkedHashMap, new IInvokable() { // from class: me.hd.wauxv.obf.cjb
                        @Override // me.hd.wauxv.obf.bgf
                        public final Object invoke(Object obj2) {
                            boolean zContainsKey;
                            String str522 = (String) obj2;
                            switch (i3) {
                                case 0:
                                    throwIfVar1IsNull(str522, "argName");
                                    Bundle bundle4 = bundleR;
                                    throwIfVar1IsNull(bundle4, "source");
                                    zContainsKey = bundle4.containsKey(str522);
                                    break;
                                default:
                                    throwIfVar1IsNull(str522, "key");
                                    Bundle bundle5 = bundleR;
                                    throwIfVar1IsNull(bundle5, "source");
                                    zContainsKey = bundle5.containsKey(str522);
                                    break;
                            }
                            return Boolean.valueOf(!zContainsKey);
                        }
                    }).isEmpty()) {
                        cjfVar = new cjf((cjg) eaVar.b, bundle, cjdVar.v, i, z3, i2);
                        if (cjfVar2 != null) {
                        }
                        cjfVar2 = cjfVar;
                        it2 = it;
                    }
                } else {
                    throwIfVar1IsNull(linkedHashMap, "arguments");
                    bundleR = ResourcesCompat.r((Pair[]) Arrays.copyOf(new Pair[0], 0));
                    if (uri != null) {
                        cjdVar.aa(bzxVarE, bundleR, linkedHashMap);
                        if (((Boolean) cjdVar.m.getValue()).booleanValue()) {
                            cjdVar.ab(uri, bundleR, linkedHashMap);
                        }
                    }
                    i3 = 1;
                    if (FastKV.ak(linkedHashMap, new IInvokable() { // from class: me.hd.wauxv.obf.cjb
                        @Override // me.hd.wauxv.obf.bgf
                        public final Object invoke(Object obj2) {
                            boolean zContainsKey;
                            String str522 = (String) obj2;
                            switch (i3) {
                                case 0:
                                    throwIfVar1IsNull(str522, "argName");
                                    Bundle bundle4 = bundleR;
                                    throwIfVar1IsNull(bundle4, "source");
                                    zContainsKey = bundle4.containsKey(str522);
                                    break;
                                default:
                                    throwIfVar1IsNull(str522, "key");
                                    Bundle bundle5 = bundleR;
                                    throwIfVar1IsNull(bundle5, "source");
                                    zContainsKey = bundle5.containsKey(str522);
                                    break;
                            }
                            return Boolean.valueOf(!zContainsKey);
                        }
                    }).isEmpty()) {
                        cjfVar = new cjf((cjg) eaVar.b, bundle, cjdVar.v, i, z3, i2);
                        if (cjfVar2 != null) {
                        }
                        cjfVar2 = cjfVar;
                        it2 = it;
                    }
                }
            } else {
                it = it2;
            }
            it2 = it;
        }
        return cjfVar2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("(");
        ea eaVar = this.g;
        String str = (String) eaVar.d;
        if (str == null) {
            sb.append("0x");
            sb.append(Integer.toHexString(eaVar.a));
        } else {
            sb.append(str);
        }
        sb.append(")");
        String str2 = (String) eaVar.f;
        if (str2 != null && !dnj.ak(str2)) {
            sb.append(" route=");
            sb.append((String) eaVar.f);
        }
        if (this.i != null) {
            sb.append(" label=");
            sb.append(this.i);
        }
        String string = sb.toString();
        throwIfVar1IsNull(string, "toString(...)");
        return string;
    }
}
