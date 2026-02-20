package me.hd.wauxv.obf;

import android.net.Uri;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cjd {
    public static final dap a = new dap("^[a-zA-Z]+[+\\w\\-.]*:");
    public static final dap b = new dap("\\{(.+?)\\}");
    public static final dap c = new dap("http[s]?://");
    public static final dap d = new dap(".*");
    public static final dap e = new dap("([^/]*?|)");
    public static final dap f = new dap("^[^?#]+\\?([^#]*).*");
    public final String g;
    public final String h;
    public final String i;
    public final ArrayList j;
    public final String k;
    public final Kotlin$Lazy l;
    public final Kotlin$Lazy m;
    public final Object n;
    public boolean o;
    public final Object p;
    public final Object q;
    public final Object r;
    public final Kotlin$Lazy s;
    public final String t;
    public final Kotlin$Lazy u;
    public final boolean v;

    public cjd(String str, String str2, String str3) {
        List listBf;
        List listU;
        this.g = str;
        this.h = str2;
        this.i = str3;
        ArrayList arrayList = new ArrayList();
        this.j = arrayList;
        final int i = 0;
        this.l = new Kotlin$Lazy(new IFunction0(this) { // from class: me.hd.wauxv.obf.cja
            public final /* synthetic */ cjd b;

            {
                this.b = this;
            }

            /*
             * JADX WARN: Type inference failed for: r1v20, types: [java.lang.Object,
             * me.hd.wauxv.obf.btt]
             */
            /*
             * JADX WARN: Type inference failed for: r1v27, types: [java.lang.Object,
             * me.hd.wauxv.obf.btt]
             */
            /*
             * JADX WARN: Type inference failed for: r1v34, types: [java.lang.Object,
             * me.hd.wauxv.obf.btt]
             */
            @Override // me.hd.wauxv.obf.bfu
            public final Object invoke() {
                List list;
                switch (i) {
                    case 0:
                        String str4 = this.b.k;
                        if (str4 != null) {
                            return new dap(str4, 0);
                        }
                        return null;
                    case 1:
                        String str5 = this.b.g;
                        return Boolean.valueOf(str5 != null && cjd.f.f(str5));
                    case 2:
                        cjd cjdVar = this.b;
                        String str6 = cjdVar.g;
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        if (((Boolean) cjdVar.m.getValue()).booleanValue()) {
                            throwIfVar1IsNull(str6);
                            Uri uri = Uri.parse(str6);
                            throwIfVar1IsNull(uri, "parse(...)");
                            for (String str7 : uri.getQueryParameterNames()) {
                                StringBuilder sb = new StringBuilder();
                                List<String> queryParameters = uri.getQueryParameters(str7);
                                int i2 = 1;
                                if (queryParameters.size() > 1) {
                                    throw new IllegalArgumentException(("Query parameter " + str7
                                            + " must only be present once in " + str6
                                            + ". To support repeated query parameters, use an array type for your argument and the pattern provided in your URI will be used to parse each query parameter instance.")
                                            .toString());
                                }
                                String str8 = (String) StaticHelpers5.g(queryParameters);
                                if (str8 == null) {
                                    cjdVar.o = true;
                                    str8 = str7;
                                }
                                bzx bzxVarD = cjd.b.d(str8);
                                cjc cjcVar = new cjc();
                                int i3 = 0;
                                while (bzxVarD != null) {
                                    bzt bztVarC = bzxVarD.c.c(i2);
                                    throwIfVar1IsNull(bztVarC);
                                    int i4 = i2;
                                    cjcVar.b.add(bztVarC.a);
                                    if (bzxVarD.f().first > i3) {
                                        String strSubstring = str8.substring(i3, bzxVarD.f().first);
                                        throwIfVar1IsNull(strSubstring, "substring(...)");
                                        String strQuote = Pattern.quote(strSubstring);
                                        throwIfVar1IsNull(strQuote, "quote(...)");
                                        sb.append(strQuote);
                                    }
                                    sb.append("([\\s\\S]+?)?");
                                    i3 = bzxVarD.f().last + 1;
                                    bzxVarD = bzxVarD.g();
                                    i2 = i4;
                                }
                                if (i3 < str8.length()) {
                                    String strSubstring2 = str8.substring(i3);
                                    throwIfVar1IsNull(strSubstring2, "substring(...)");
                                    String strQuote2 = Pattern.quote(strSubstring2);
                                    throwIfVar1IsNull(strQuote2, "quote(...)");
                                    sb.append(strQuote2);
                                }
                                sb.append("$");
                                String string = sb.toString();
                                throwIfVar1IsNull(string, "toString(...)");
                                cjcVar.a = cjd.y(string);
                                linkedHashMap.put(str7, cjcVar);
                            }
                        }
                        return linkedHashMap;
                    case 3:
                        String str9 = this.b.g;
                        if (str9 != null) {
                            Uri uri2 = Uri.parse(str9);
                            throwIfVar1IsNull(uri2, "parse(...)");
                            if (uri2.getFragment() != null) {
                                ArrayList arrayList2 = new ArrayList();
                                Uri uri3 = Uri.parse(str9);
                                throwIfVar1IsNull(uri3, "parse(...)");
                                String fragment = uri3.getFragment();
                                StringBuilder sb2 = new StringBuilder();
                                throwIfVar1IsNull(fragment);
                                cjd.w(fragment, arrayList2, sb2);
                                return new Pair(arrayList2, sb2.toString());
                            }
                        }
                        return null;
                    case 4:
                        Pair pairVar = (Pair) this.b.p.getValue();
                        return (pairVar == null || (list = (List) pairVar.a) == null) ? new ArrayList() : list;
                    case 5:
                        Pair pairVar2 = (Pair) this.b.p.getValue();
                        if (pairVar2 != null) {
                            return (String) pairVar2.b;
                        }
                        return null;
                    case 6:
                        String str10 = (String) this.b.r.getValue();
                        if (str10 != null) {
                            return new dap(str10, 0);
                        }
                        return null;
                    default:
                        String str11 = this.b.t;
                        if (str11 != null) {
                            return new dap(str11);
                        }
                        return null;
                }
            }
        });
        final int i2 = 1;
        this.m = new Kotlin$Lazy(new IFunction0(this) { // from class: me.hd.wauxv.obf.cja
            public final /* synthetic */ cjd b;

            {
                this.b = this;
            }

            /*
             * JADX WARN: Type inference failed for: r1v20, types: [java.lang.Object,
             * me.hd.wauxv.obf.btt]
             */
            /*
             * JADX WARN: Type inference failed for: r1v27, types: [java.lang.Object,
             * me.hd.wauxv.obf.btt]
             */
            /*
             * JADX WARN: Type inference failed for: r1v34, types: [java.lang.Object,
             * me.hd.wauxv.obf.btt]
             */
            @Override // me.hd.wauxv.obf.bfu
            public final Object invoke() {
                List list;
                switch (i2) {
                    case 0:
                        String str4 = this.b.k;
                        if (str4 != null) {
                            return new dap(str4, 0);
                        }
                        return null;
                    case 1:
                        String str5 = this.b.g;
                        return Boolean.valueOf(str5 != null && cjd.f.f(str5));
                    case 2:
                        cjd cjdVar = this.b;
                        String str6 = cjdVar.g;
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        if (((Boolean) cjdVar.m.getValue()).booleanValue()) {
                            throwIfVar1IsNull(str6);
                            Uri uri = Uri.parse(str6);
                            throwIfVar1IsNull(uri, "parse(...)");
                            for (String str7 : uri.getQueryParameterNames()) {
                                StringBuilder sb = new StringBuilder();
                                List<String> queryParameters = uri.getQueryParameters(str7);
                                int i22 = 1;
                                if (queryParameters.size() > 1) {
                                    throw new IllegalArgumentException(("Query parameter " + str7
                                            + " must only be present once in " + str6
                                            + ". To support repeated query parameters, use an array type for your argument and the pattern provided in your URI will be used to parse each query parameter instance.")
                                            .toString());
                                }
                                String str8 = (String) StaticHelpers5.g(queryParameters);
                                if (str8 == null) {
                                    cjdVar.o = true;
                                    str8 = str7;
                                }
                                bzx bzxVarD = cjd.b.d(str8);
                                cjc cjcVar = new cjc();
                                int i3 = 0;
                                while (bzxVarD != null) {
                                    bzt bztVarC = bzxVarD.c.c(i22);
                                    throwIfVar1IsNull(bztVarC);
                                    int i4 = i22;
                                    cjcVar.b.add(bztVarC.a);
                                    if (bzxVarD.f().first > i3) {
                                        String strSubstring = str8.substring(i3, bzxVarD.f().first);
                                        throwIfVar1IsNull(strSubstring, "substring(...)");
                                        String strQuote = Pattern.quote(strSubstring);
                                        throwIfVar1IsNull(strQuote, "quote(...)");
                                        sb.append(strQuote);
                                    }
                                    sb.append("([\\s\\S]+?)?");
                                    i3 = bzxVarD.f().last + 1;
                                    bzxVarD = bzxVarD.g();
                                    i22 = i4;
                                }
                                if (i3 < str8.length()) {
                                    String strSubstring2 = str8.substring(i3);
                                    throwIfVar1IsNull(strSubstring2, "substring(...)");
                                    String strQuote2 = Pattern.quote(strSubstring2);
                                    throwIfVar1IsNull(strQuote2, "quote(...)");
                                    sb.append(strQuote2);
                                }
                                sb.append("$");
                                String string = sb.toString();
                                throwIfVar1IsNull(string, "toString(...)");
                                cjcVar.a = cjd.y(string);
                                linkedHashMap.put(str7, cjcVar);
                            }
                        }
                        return linkedHashMap;
                    case 3:
                        String str9 = this.b.g;
                        if (str9 != null) {
                            Uri uri2 = Uri.parse(str9);
                            throwIfVar1IsNull(uri2, "parse(...)");
                            if (uri2.getFragment() != null) {
                                ArrayList arrayList2 = new ArrayList();
                                Uri uri3 = Uri.parse(str9);
                                throwIfVar1IsNull(uri3, "parse(...)");
                                String fragment = uri3.getFragment();
                                StringBuilder sb2 = new StringBuilder();
                                throwIfVar1IsNull(fragment);
                                cjd.w(fragment, arrayList2, sb2);
                                return new Pair(arrayList2, sb2.toString());
                            }
                        }
                        return null;
                    case 4:
                        Pair pairVar = (Pair) this.b.p.getValue();
                        return (pairVar == null || (list = (List) pairVar.a) == null) ? new ArrayList() : list;
                    case 5:
                        Pair pairVar2 = (Pair) this.b.p.getValue();
                        if (pairVar2 != null) {
                            return (String) pairVar2.b;
                        }
                        return null;
                    case 6:
                        String str10 = (String) this.b.r.getValue();
                        if (str10 != null) {
                            return new dap(str10, 0);
                        }
                        return null;
                    default:
                        String str11 = this.b.t;
                        if (str11 != null) {
                            return new dap(str11);
                        }
                        return null;
                }
            }
        });
        final int i3 = 2;
        IFunction0 bfuVar = new IFunction0(this) { // from class: me.hd.wauxv.obf.cja
            public final /* synthetic */ cjd b;

            {
                this.b = this;
            }

            /*
             * JADX WARN: Type inference failed for: r1v20, types: [java.lang.Object,
             * me.hd.wauxv.obf.btt]
             */
            /*
             * JADX WARN: Type inference failed for: r1v27, types: [java.lang.Object,
             * me.hd.wauxv.obf.btt]
             */
            /*
             * JADX WARN: Type inference failed for: r1v34, types: [java.lang.Object,
             * me.hd.wauxv.obf.btt]
             */
            @Override // me.hd.wauxv.obf.bfu
            public final Object invoke() {
                List list;
                switch (i3) {
                    case 0:
                        String str4 = this.b.k;
                        if (str4 != null) {
                            return new dap(str4, 0);
                        }
                        return null;
                    case 1:
                        String str5 = this.b.g;
                        return Boolean.valueOf(str5 != null && cjd.f.f(str5));
                    case 2:
                        cjd cjdVar = this.b;
                        String str6 = cjdVar.g;
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        if (((Boolean) cjdVar.m.getValue()).booleanValue()) {
                            throwIfVar1IsNull(str6);
                            Uri uri = Uri.parse(str6);
                            throwIfVar1IsNull(uri, "parse(...)");
                            for (String str7 : uri.getQueryParameterNames()) {
                                StringBuilder sb = new StringBuilder();
                                List<String> queryParameters = uri.getQueryParameters(str7);
                                int i22 = 1;
                                if (queryParameters.size() > 1) {
                                    throw new IllegalArgumentException(("Query parameter " + str7
                                            + " must only be present once in " + str6
                                            + ". To support repeated query parameters, use an array type for your argument and the pattern provided in your URI will be used to parse each query parameter instance.")
                                            .toString());
                                }
                                String str8 = (String) StaticHelpers5.g(queryParameters);
                                if (str8 == null) {
                                    cjdVar.o = true;
                                    str8 = str7;
                                }
                                bzx bzxVarD = cjd.b.d(str8);
                                cjc cjcVar = new cjc();
                                int i32 = 0;
                                while (bzxVarD != null) {
                                    bzt bztVarC = bzxVarD.c.c(i22);
                                    throwIfVar1IsNull(bztVarC);
                                    int i4 = i22;
                                    cjcVar.b.add(bztVarC.a);
                                    if (bzxVarD.f().first > i32) {
                                        String strSubstring = str8.substring(i32, bzxVarD.f().first);
                                        throwIfVar1IsNull(strSubstring, "substring(...)");
                                        String strQuote = Pattern.quote(strSubstring);
                                        throwIfVar1IsNull(strQuote, "quote(...)");
                                        sb.append(strQuote);
                                    }
                                    sb.append("([\\s\\S]+?)?");
                                    i32 = bzxVarD.f().last + 1;
                                    bzxVarD = bzxVarD.g();
                                    i22 = i4;
                                }
                                if (i32 < str8.length()) {
                                    String strSubstring2 = str8.substring(i32);
                                    throwIfVar1IsNull(strSubstring2, "substring(...)");
                                    String strQuote2 = Pattern.quote(strSubstring2);
                                    throwIfVar1IsNull(strQuote2, "quote(...)");
                                    sb.append(strQuote2);
                                }
                                sb.append("$");
                                String string = sb.toString();
                                throwIfVar1IsNull(string, "toString(...)");
                                cjcVar.a = cjd.y(string);
                                linkedHashMap.put(str7, cjcVar);
                            }
                        }
                        return linkedHashMap;
                    case 3:
                        String str9 = this.b.g;
                        if (str9 != null) {
                            Uri uri2 = Uri.parse(str9);
                            throwIfVar1IsNull(uri2, "parse(...)");
                            if (uri2.getFragment() != null) {
                                ArrayList arrayList2 = new ArrayList();
                                Uri uri3 = Uri.parse(str9);
                                throwIfVar1IsNull(uri3, "parse(...)");
                                String fragment = uri3.getFragment();
                                StringBuilder sb2 = new StringBuilder();
                                throwIfVar1IsNull(fragment);
                                cjd.w(fragment, arrayList2, sb2);
                                return new Pair(arrayList2, sb2.toString());
                            }
                        }
                        return null;
                    case 4:
                        Pair pairVar = (Pair) this.b.p.getValue();
                        return (pairVar == null || (list = (List) pairVar.a) == null) ? new ArrayList() : list;
                    case 5:
                        Pair pairVar2 = (Pair) this.b.p.getValue();
                        if (pairVar2 != null) {
                            return (String) pairVar2.b;
                        }
                        return null;
                    case 6:
                        String str10 = (String) this.b.r.getValue();
                        if (str10 != null) {
                            return new dap(str10, 0);
                        }
                        return null;
                    default:
                        String str11 = this.b.t;
                        if (str11 != null) {
                            return new dap(str11);
                        }
                        return null;
                }
            }
        };
        btx btxVar = btx.b;
        this.n = StaticAndroidHelpers.am(btxVar, bfuVar);
        final int i4 = 3;
        this.p = StaticAndroidHelpers.am(btxVar, new IFunction0(this) { // from class: me.hd.wauxv.obf.cja
            public final /* synthetic */ cjd b;

            {
                this.b = this;
            }

            /*
             * JADX WARN: Type inference failed for: r1v20, types: [java.lang.Object,
             * me.hd.wauxv.obf.btt]
             */
            /*
             * JADX WARN: Type inference failed for: r1v27, types: [java.lang.Object,
             * me.hd.wauxv.obf.btt]
             */
            /*
             * JADX WARN: Type inference failed for: r1v34, types: [java.lang.Object,
             * me.hd.wauxv.obf.btt]
             */
            @Override // me.hd.wauxv.obf.bfu
            public final Object invoke() {
                List list;
                switch (i4) {
                    case 0:
                        String str4 = this.b.k;
                        if (str4 != null) {
                            return new dap(str4, 0);
                        }
                        return null;
                    case 1:
                        String str5 = this.b.g;
                        return Boolean.valueOf(str5 != null && cjd.f.f(str5));
                    case 2:
                        cjd cjdVar = this.b;
                        String str6 = cjdVar.g;
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        if (((Boolean) cjdVar.m.getValue()).booleanValue()) {
                            throwIfVar1IsNull(str6);
                            Uri uri = Uri.parse(str6);
                            throwIfVar1IsNull(uri, "parse(...)");
                            for (String str7 : uri.getQueryParameterNames()) {
                                StringBuilder sb = new StringBuilder();
                                List<String> queryParameters = uri.getQueryParameters(str7);
                                int i22 = 1;
                                if (queryParameters.size() > 1) {
                                    throw new IllegalArgumentException(("Query parameter " + str7
                                            + " must only be present once in " + str6
                                            + ". To support repeated query parameters, use an array type for your argument and the pattern provided in your URI will be used to parse each query parameter instance.")
                                            .toString());
                                }
                                String str8 = (String) StaticHelpers5.g(queryParameters);
                                if (str8 == null) {
                                    cjdVar.o = true;
                                    str8 = str7;
                                }
                                bzx bzxVarD = cjd.b.d(str8);
                                cjc cjcVar = new cjc();
                                int i32 = 0;
                                while (bzxVarD != null) {
                                    bzt bztVarC = bzxVarD.c.c(i22);
                                    throwIfVar1IsNull(bztVarC);
                                    int i42 = i22;
                                    cjcVar.b.add(bztVarC.a);
                                    if (bzxVarD.f().first > i32) {
                                        String strSubstring = str8.substring(i32, bzxVarD.f().first);
                                        throwIfVar1IsNull(strSubstring, "substring(...)");
                                        String strQuote = Pattern.quote(strSubstring);
                                        throwIfVar1IsNull(strQuote, "quote(...)");
                                        sb.append(strQuote);
                                    }
                                    sb.append("([\\s\\S]+?)?");
                                    i32 = bzxVarD.f().last + 1;
                                    bzxVarD = bzxVarD.g();
                                    i22 = i42;
                                }
                                if (i32 < str8.length()) {
                                    String strSubstring2 = str8.substring(i32);
                                    throwIfVar1IsNull(strSubstring2, "substring(...)");
                                    String strQuote2 = Pattern.quote(strSubstring2);
                                    throwIfVar1IsNull(strQuote2, "quote(...)");
                                    sb.append(strQuote2);
                                }
                                sb.append("$");
                                String string = sb.toString();
                                throwIfVar1IsNull(string, "toString(...)");
                                cjcVar.a = cjd.y(string);
                                linkedHashMap.put(str7, cjcVar);
                            }
                        }
                        return linkedHashMap;
                    case 3:
                        String str9 = this.b.g;
                        if (str9 != null) {
                            Uri uri2 = Uri.parse(str9);
                            throwIfVar1IsNull(uri2, "parse(...)");
                            if (uri2.getFragment() != null) {
                                ArrayList arrayList2 = new ArrayList();
                                Uri uri3 = Uri.parse(str9);
                                throwIfVar1IsNull(uri3, "parse(...)");
                                String fragment = uri3.getFragment();
                                StringBuilder sb2 = new StringBuilder();
                                throwIfVar1IsNull(fragment);
                                cjd.w(fragment, arrayList2, sb2);
                                return new Pair(arrayList2, sb2.toString());
                            }
                        }
                        return null;
                    case 4:
                        Pair pairVar = (Pair) this.b.p.getValue();
                        return (pairVar == null || (list = (List) pairVar.a) == null) ? new ArrayList() : list;
                    case 5:
                        Pair pairVar2 = (Pair) this.b.p.getValue();
                        if (pairVar2 != null) {
                            return (String) pairVar2.b;
                        }
                        return null;
                    case 6:
                        String str10 = (String) this.b.r.getValue();
                        if (str10 != null) {
                            return new dap(str10, 0);
                        }
                        return null;
                    default:
                        String str11 = this.b.t;
                        if (str11 != null) {
                            return new dap(str11);
                        }
                        return null;
                }
            }
        });
        final int i5 = 4;
        this.q = StaticAndroidHelpers.am(btxVar, new IFunction0(this) { // from class: me.hd.wauxv.obf.cja
            public final /* synthetic */ cjd b;

            {
                this.b = this;
            }

            /*
             * JADX WARN: Type inference failed for: r1v20, types: [java.lang.Object,
             * me.hd.wauxv.obf.btt]
             */
            /*
             * JADX WARN: Type inference failed for: r1v27, types: [java.lang.Object,
             * me.hd.wauxv.obf.btt]
             */
            /*
             * JADX WARN: Type inference failed for: r1v34, types: [java.lang.Object,
             * me.hd.wauxv.obf.btt]
             */
            @Override // me.hd.wauxv.obf.bfu
            public final Object invoke() {
                List list;
                switch (i5) {
                    case 0:
                        String str4 = this.b.k;
                        if (str4 != null) {
                            return new dap(str4, 0);
                        }
                        return null;
                    case 1:
                        String str5 = this.b.g;
                        return Boolean.valueOf(str5 != null && cjd.f.f(str5));
                    case 2:
                        cjd cjdVar = this.b;
                        String str6 = cjdVar.g;
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        if (((Boolean) cjdVar.m.getValue()).booleanValue()) {
                            throwIfVar1IsNull(str6);
                            Uri uri = Uri.parse(str6);
                            throwIfVar1IsNull(uri, "parse(...)");
                            for (String str7 : uri.getQueryParameterNames()) {
                                StringBuilder sb = new StringBuilder();
                                List<String> queryParameters = uri.getQueryParameters(str7);
                                int i22 = 1;
                                if (queryParameters.size() > 1) {
                                    throw new IllegalArgumentException(("Query parameter " + str7
                                            + " must only be present once in " + str6
                                            + ". To support repeated query parameters, use an array type for your argument and the pattern provided in your URI will be used to parse each query parameter instance.")
                                            .toString());
                                }
                                String str8 = (String) StaticHelpers5.g(queryParameters);
                                if (str8 == null) {
                                    cjdVar.o = true;
                                    str8 = str7;
                                }
                                bzx bzxVarD = cjd.b.d(str8);
                                cjc cjcVar = new cjc();
                                int i32 = 0;
                                while (bzxVarD != null) {
                                    bzt bztVarC = bzxVarD.c.c(i22);
                                    throwIfVar1IsNull(bztVarC);
                                    int i42 = i22;
                                    cjcVar.b.add(bztVarC.a);
                                    if (bzxVarD.f().first > i32) {
                                        String strSubstring = str8.substring(i32, bzxVarD.f().first);
                                        throwIfVar1IsNull(strSubstring, "substring(...)");
                                        String strQuote = Pattern.quote(strSubstring);
                                        throwIfVar1IsNull(strQuote, "quote(...)");
                                        sb.append(strQuote);
                                    }
                                    sb.append("([\\s\\S]+?)?");
                                    i32 = bzxVarD.f().last + 1;
                                    bzxVarD = bzxVarD.g();
                                    i22 = i42;
                                }
                                if (i32 < str8.length()) {
                                    String strSubstring2 = str8.substring(i32);
                                    throwIfVar1IsNull(strSubstring2, "substring(...)");
                                    String strQuote2 = Pattern.quote(strSubstring2);
                                    throwIfVar1IsNull(strQuote2, "quote(...)");
                                    sb.append(strQuote2);
                                }
                                sb.append("$");
                                String string = sb.toString();
                                throwIfVar1IsNull(string, "toString(...)");
                                cjcVar.a = cjd.y(string);
                                linkedHashMap.put(str7, cjcVar);
                            }
                        }
                        return linkedHashMap;
                    case 3:
                        String str9 = this.b.g;
                        if (str9 != null) {
                            Uri uri2 = Uri.parse(str9);
                            throwIfVar1IsNull(uri2, "parse(...)");
                            if (uri2.getFragment() != null) {
                                ArrayList arrayList2 = new ArrayList();
                                Uri uri3 = Uri.parse(str9);
                                throwIfVar1IsNull(uri3, "parse(...)");
                                String fragment = uri3.getFragment();
                                StringBuilder sb2 = new StringBuilder();
                                throwIfVar1IsNull(fragment);
                                cjd.w(fragment, arrayList2, sb2);
                                return new Pair(arrayList2, sb2.toString());
                            }
                        }
                        return null;
                    case 4:
                        Pair pairVar = (Pair) this.b.p.getValue();
                        return (pairVar == null || (list = (List) pairVar.a) == null) ? new ArrayList() : list;
                    case 5:
                        Pair pairVar2 = (Pair) this.b.p.getValue();
                        if (pairVar2 != null) {
                            return (String) pairVar2.b;
                        }
                        return null;
                    case 6:
                        String str10 = (String) this.b.r.getValue();
                        if (str10 != null) {
                            return new dap(str10, 0);
                        }
                        return null;
                    default:
                        String str11 = this.b.t;
                        if (str11 != null) {
                            return new dap(str11);
                        }
                        return null;
                }
            }
        });
        final int i6 = 5;
        this.r = StaticAndroidHelpers.am(btxVar, new IFunction0(this) { // from class: me.hd.wauxv.obf.cja
            public final /* synthetic */ cjd b;

            {
                this.b = this;
            }

            /*
             * JADX WARN: Type inference failed for: r1v20, types: [java.lang.Object,
             * me.hd.wauxv.obf.btt]
             */
            /*
             * JADX WARN: Type inference failed for: r1v27, types: [java.lang.Object,
             * me.hd.wauxv.obf.btt]
             */
            /*
             * JADX WARN: Type inference failed for: r1v34, types: [java.lang.Object,
             * me.hd.wauxv.obf.btt]
             */
            @Override // me.hd.wauxv.obf.bfu
            public final Object invoke() {
                List list;
                switch (i6) {
                    case 0:
                        String str4 = this.b.k;
                        if (str4 != null) {
                            return new dap(str4, 0);
                        }
                        return null;
                    case 1:
                        String str5 = this.b.g;
                        return Boolean.valueOf(str5 != null && cjd.f.f(str5));
                    case 2:
                        cjd cjdVar = this.b;
                        String str6 = cjdVar.g;
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        if (((Boolean) cjdVar.m.getValue()).booleanValue()) {
                            throwIfVar1IsNull(str6);
                            Uri uri = Uri.parse(str6);
                            throwIfVar1IsNull(uri, "parse(...)");
                            for (String str7 : uri.getQueryParameterNames()) {
                                StringBuilder sb = new StringBuilder();
                                List<String> queryParameters = uri.getQueryParameters(str7);
                                int i22 = 1;
                                if (queryParameters.size() > 1) {
                                    throw new IllegalArgumentException(("Query parameter " + str7
                                            + " must only be present once in " + str6
                                            + ". To support repeated query parameters, use an array type for your argument and the pattern provided in your URI will be used to parse each query parameter instance.")
                                            .toString());
                                }
                                String str8 = (String) StaticHelpers5.g(queryParameters);
                                if (str8 == null) {
                                    cjdVar.o = true;
                                    str8 = str7;
                                }
                                bzx bzxVarD = cjd.b.d(str8);
                                cjc cjcVar = new cjc();
                                int i32 = 0;
                                while (bzxVarD != null) {
                                    bzt bztVarC = bzxVarD.c.c(i22);
                                    throwIfVar1IsNull(bztVarC);
                                    int i42 = i22;
                                    cjcVar.b.add(bztVarC.a);
                                    if (bzxVarD.f().first > i32) {
                                        String strSubstring = str8.substring(i32, bzxVarD.f().first);
                                        throwIfVar1IsNull(strSubstring, "substring(...)");
                                        String strQuote = Pattern.quote(strSubstring);
                                        throwIfVar1IsNull(strQuote, "quote(...)");
                                        sb.append(strQuote);
                                    }
                                    sb.append("([\\s\\S]+?)?");
                                    i32 = bzxVarD.f().last + 1;
                                    bzxVarD = bzxVarD.g();
                                    i22 = i42;
                                }
                                if (i32 < str8.length()) {
                                    String strSubstring2 = str8.substring(i32);
                                    throwIfVar1IsNull(strSubstring2, "substring(...)");
                                    String strQuote2 = Pattern.quote(strSubstring2);
                                    throwIfVar1IsNull(strQuote2, "quote(...)");
                                    sb.append(strQuote2);
                                }
                                sb.append("$");
                                String string = sb.toString();
                                throwIfVar1IsNull(string, "toString(...)");
                                cjcVar.a = cjd.y(string);
                                linkedHashMap.put(str7, cjcVar);
                            }
                        }
                        return linkedHashMap;
                    case 3:
                        String str9 = this.b.g;
                        if (str9 != null) {
                            Uri uri2 = Uri.parse(str9);
                            throwIfVar1IsNull(uri2, "parse(...)");
                            if (uri2.getFragment() != null) {
                                ArrayList arrayList2 = new ArrayList();
                                Uri uri3 = Uri.parse(str9);
                                throwIfVar1IsNull(uri3, "parse(...)");
                                String fragment = uri3.getFragment();
                                StringBuilder sb2 = new StringBuilder();
                                throwIfVar1IsNull(fragment);
                                cjd.w(fragment, arrayList2, sb2);
                                return new Pair(arrayList2, sb2.toString());
                            }
                        }
                        return null;
                    case 4:
                        Pair pairVar = (Pair) this.b.p.getValue();
                        return (pairVar == null || (list = (List) pairVar.a) == null) ? new ArrayList() : list;
                    case 5:
                        Pair pairVar2 = (Pair) this.b.p.getValue();
                        if (pairVar2 != null) {
                            return (String) pairVar2.b;
                        }
                        return null;
                    case 6:
                        String str10 = (String) this.b.r.getValue();
                        if (str10 != null) {
                            return new dap(str10, 0);
                        }
                        return null;
                    default:
                        String str11 = this.b.t;
                        if (str11 != null) {
                            return new dap(str11);
                        }
                        return null;
                }
            }
        });
        final int i7 = 6;
        this.s = new Kotlin$Lazy(new IFunction0(this) { // from class: me.hd.wauxv.obf.cja
            public final /* synthetic */ cjd b;

            {
                this.b = this;
            }

            /*
             * JADX WARN: Type inference failed for: r1v20, types: [java.lang.Object,
             * me.hd.wauxv.obf.btt]
             */
            /*
             * JADX WARN: Type inference failed for: r1v27, types: [java.lang.Object,
             * me.hd.wauxv.obf.btt]
             */
            /*
             * JADX WARN: Type inference failed for: r1v34, types: [java.lang.Object,
             * me.hd.wauxv.obf.btt]
             */
            @Override // me.hd.wauxv.obf.bfu
            public final Object invoke() {
                List list;
                switch (i7) {
                    case 0:
                        String str4 = this.b.k;
                        if (str4 != null) {
                            return new dap(str4, 0);
                        }
                        return null;
                    case 1:
                        String str5 = this.b.g;
                        return Boolean.valueOf(str5 != null && cjd.f.f(str5));
                    case 2:
                        cjd cjdVar = this.b;
                        String str6 = cjdVar.g;
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        if (((Boolean) cjdVar.m.getValue()).booleanValue()) {
                            throwIfVar1IsNull(str6);
                            Uri uri = Uri.parse(str6);
                            throwIfVar1IsNull(uri, "parse(...)");
                            for (String str7 : uri.getQueryParameterNames()) {
                                StringBuilder sb = new StringBuilder();
                                List<String> queryParameters = uri.getQueryParameters(str7);
                                int i22 = 1;
                                if (queryParameters.size() > 1) {
                                    throw new IllegalArgumentException(("Query parameter " + str7
                                            + " must only be present once in " + str6
                                            + ". To support repeated query parameters, use an array type for your argument and the pattern provided in your URI will be used to parse each query parameter instance.")
                                            .toString());
                                }
                                String str8 = (String) StaticHelpers5.g(queryParameters);
                                if (str8 == null) {
                                    cjdVar.o = true;
                                    str8 = str7;
                                }
                                bzx bzxVarD = cjd.b.d(str8);
                                cjc cjcVar = new cjc();
                                int i32 = 0;
                                while (bzxVarD != null) {
                                    bzt bztVarC = bzxVarD.c.c(i22);
                                    throwIfVar1IsNull(bztVarC);
                                    int i42 = i22;
                                    cjcVar.b.add(bztVarC.a);
                                    if (bzxVarD.f().first > i32) {
                                        String strSubstring = str8.substring(i32, bzxVarD.f().first);
                                        throwIfVar1IsNull(strSubstring, "substring(...)");
                                        String strQuote = Pattern.quote(strSubstring);
                                        throwIfVar1IsNull(strQuote, "quote(...)");
                                        sb.append(strQuote);
                                    }
                                    sb.append("([\\s\\S]+?)?");
                                    i32 = bzxVarD.f().last + 1;
                                    bzxVarD = bzxVarD.g();
                                    i22 = i42;
                                }
                                if (i32 < str8.length()) {
                                    String strSubstring2 = str8.substring(i32);
                                    throwIfVar1IsNull(strSubstring2, "substring(...)");
                                    String strQuote2 = Pattern.quote(strSubstring2);
                                    throwIfVar1IsNull(strQuote2, "quote(...)");
                                    sb.append(strQuote2);
                                }
                                sb.append("$");
                                String string = sb.toString();
                                throwIfVar1IsNull(string, "toString(...)");
                                cjcVar.a = cjd.y(string);
                                linkedHashMap.put(str7, cjcVar);
                            }
                        }
                        return linkedHashMap;
                    case 3:
                        String str9 = this.b.g;
                        if (str9 != null) {
                            Uri uri2 = Uri.parse(str9);
                            throwIfVar1IsNull(uri2, "parse(...)");
                            if (uri2.getFragment() != null) {
                                ArrayList arrayList2 = new ArrayList();
                                Uri uri3 = Uri.parse(str9);
                                throwIfVar1IsNull(uri3, "parse(...)");
                                String fragment = uri3.getFragment();
                                StringBuilder sb2 = new StringBuilder();
                                throwIfVar1IsNull(fragment);
                                cjd.w(fragment, arrayList2, sb2);
                                return new Pair(arrayList2, sb2.toString());
                            }
                        }
                        return null;
                    case 4:
                        Pair pairVar = (Pair) this.b.p.getValue();
                        return (pairVar == null || (list = (List) pairVar.a) == null) ? new ArrayList() : list;
                    case 5:
                        Pair pairVar2 = (Pair) this.b.p.getValue();
                        if (pairVar2 != null) {
                            return (String) pairVar2.b;
                        }
                        return null;
                    case 6:
                        String str10 = (String) this.b.r.getValue();
                        if (str10 != null) {
                            return new dap(str10, 0);
                        }
                        return null;
                    default:
                        String str11 = this.b.t;
                        if (str11 != null) {
                            return new dap(str11);
                        }
                        return null;
                }
            }
        });
        final int i8 = 7;
        this.u = new Kotlin$Lazy(new IFunction0(this) { // from class: me.hd.wauxv.obf.cja
            public final /* synthetic */ cjd b;

            {
                this.b = this;
            }

            /*
             * JADX WARN: Type inference failed for: r1v20, types: [java.lang.Object,
             * me.hd.wauxv.obf.btt]
             */
            /*
             * JADX WARN: Type inference failed for: r1v27, types: [java.lang.Object,
             * me.hd.wauxv.obf.btt]
             */
            /*
             * JADX WARN: Type inference failed for: r1v34, types: [java.lang.Object,
             * me.hd.wauxv.obf.btt]
             */
            @Override // me.hd.wauxv.obf.bfu
            public final Object invoke() {
                List list;
                switch (i8) {
                    case 0:
                        String str4 = this.b.k;
                        if (str4 != null) {
                            return new dap(str4, 0);
                        }
                        return null;
                    case 1:
                        String str5 = this.b.g;
                        return Boolean.valueOf(str5 != null && cjd.f.f(str5));
                    case 2:
                        cjd cjdVar = this.b;
                        String str6 = cjdVar.g;
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        if (((Boolean) cjdVar.m.getValue()).booleanValue()) {
                            throwIfVar1IsNull(str6);
                            Uri uri = Uri.parse(str6);
                            throwIfVar1IsNull(uri, "parse(...)");
                            for (String str7 : uri.getQueryParameterNames()) {
                                StringBuilder sb = new StringBuilder();
                                List<String> queryParameters = uri.getQueryParameters(str7);
                                int i22 = 1;
                                if (queryParameters.size() > 1) {
                                    throw new IllegalArgumentException(("Query parameter " + str7
                                            + " must only be present once in " + str6
                                            + ". To support repeated query parameters, use an array type for your argument and the pattern provided in your URI will be used to parse each query parameter instance.")
                                            .toString());
                                }
                                String str8 = (String) StaticHelpers5.g(queryParameters);
                                if (str8 == null) {
                                    cjdVar.o = true;
                                    str8 = str7;
                                }
                                bzx bzxVarD = cjd.b.d(str8);
                                cjc cjcVar = new cjc();
                                int i32 = 0;
                                while (bzxVarD != null) {
                                    bzt bztVarC = bzxVarD.c.c(i22);
                                    throwIfVar1IsNull(bztVarC);
                                    int i42 = i22;
                                    cjcVar.b.add(bztVarC.a);
                                    if (bzxVarD.f().first > i32) {
                                        String strSubstring = str8.substring(i32, bzxVarD.f().first);
                                        throwIfVar1IsNull(strSubstring, "substring(...)");
                                        String strQuote = Pattern.quote(strSubstring);
                                        throwIfVar1IsNull(strQuote, "quote(...)");
                                        sb.append(strQuote);
                                    }
                                    sb.append("([\\s\\S]+?)?");
                                    i32 = bzxVarD.f().last + 1;
                                    bzxVarD = bzxVarD.g();
                                    i22 = i42;
                                }
                                if (i32 < str8.length()) {
                                    String strSubstring2 = str8.substring(i32);
                                    throwIfVar1IsNull(strSubstring2, "substring(...)");
                                    String strQuote2 = Pattern.quote(strSubstring2);
                                    throwIfVar1IsNull(strQuote2, "quote(...)");
                                    sb.append(strQuote2);
                                }
                                sb.append("$");
                                String string = sb.toString();
                                throwIfVar1IsNull(string, "toString(...)");
                                cjcVar.a = cjd.y(string);
                                linkedHashMap.put(str7, cjcVar);
                            }
                        }
                        return linkedHashMap;
                    case 3:
                        String str9 = this.b.g;
                        if (str9 != null) {
                            Uri uri2 = Uri.parse(str9);
                            throwIfVar1IsNull(uri2, "parse(...)");
                            if (uri2.getFragment() != null) {
                                ArrayList arrayList2 = new ArrayList();
                                Uri uri3 = Uri.parse(str9);
                                throwIfVar1IsNull(uri3, "parse(...)");
                                String fragment = uri3.getFragment();
                                StringBuilder sb2 = new StringBuilder();
                                throwIfVar1IsNull(fragment);
                                cjd.w(fragment, arrayList2, sb2);
                                return new Pair(arrayList2, sb2.toString());
                            }
                        }
                        return null;
                    case 4:
                        Pair pairVar = (Pair) this.b.p.getValue();
                        return (pairVar == null || (list = (List) pairVar.a) == null) ? new ArrayList() : list;
                    case 5:
                        Pair pairVar2 = (Pair) this.b.p.getValue();
                        if (pairVar2 != null) {
                            return (String) pairVar2.b;
                        }
                        return null;
                    case 6:
                        String str10 = (String) this.b.r.getValue();
                        if (str10 != null) {
                            return new dap(str10, 0);
                        }
                        return null;
                    default:
                        String str11 = this.b.t;
                        if (str11 != null) {
                            return new dap(str11);
                        }
                        return null;
                }
            }
        });
        if (str != null) {
            StringBuilder sb = new StringBuilder("^");
            if (!a.c(str)) {
                String strPattern = c.a.pattern();
                throwIfVar1IsNull(strPattern, "pattern(...)");
                sb.append(strPattern);
            }
            Pattern patternCompile = Pattern.compile("(\\?|#|$)");
            throwIfVar1IsNull(patternCompile, "compile(...)");
            Matcher matcher = patternCompile.matcher(str);
            throwIfVar1IsNull(matcher, "matcher(...)");
            bzx bzxVarY = StaticAndroidHelpers.y(matcher, 0, str);
            if (bzxVarY != null) {
                String strSubstring = str.substring(0, bzxVarY.f().first);
                throwIfVar1IsNull(strSubstring, "substring(...)");
                w(strSubstring, arrayList, sb);
                this.v = (d.c(sb) || e.c(sb)) ? false : true;
                sb.append("($|(\\?(.)*)|(#(.)*))");
            }
            String string = sb.toString();
            throwIfVar1IsNull(string, "toString(...)");
            this.k = y(string);
        }
        if (str3 == null) {
            return;
        }
        Pattern patternCompile2 = Pattern.compile("^[\\s\\S]+/[\\s\\S]+$");
        throwIfVar1IsNull(patternCompile2, "compile(...)");
        if (!patternCompile2.matcher(str3).matches()) {
            throw new IllegalArgumentException(
                    concat("The given mimeType ", str3, " does not match to required \"type/subtype\" format")
                            .toString());
        }
        Pattern patternCompile3 = Pattern.compile("/");
        throwIfVar1IsNull(patternCompile3, "compile(...)");
        Matcher matcher2 = patternCompile3.matcher(str3);
        if (matcher2.find()) {
            ArrayList arrayList2 = new ArrayList(10);
            int iEnd = 0;
            do {
                arrayList2.add(str3.subSequence(iEnd, matcher2.start()).toString());
                iEnd = matcher2.end();
            } while (matcher2.find());
            arrayList2.add(str3.subSequence(iEnd, str3.length()).toString());
            listBf = arrayList2;
        } else {
            listBf = dqc.toSingletonList(str3.toString());
        }
        if (listBf.isEmpty()) {
            listU = EmptyReadonlyList.INSTANCE;
        } else {
            ListIterator listIterator = listBf.listIterator(listBf.size());
            while (listIterator.hasPrevious()) {
                if (((String) listIterator.previous()).length() != 0) {
                    listU = StaticHelpers5.u(listIterator.nextIndex() + 1, listBf);
                }
            }
            listU = EmptyReadonlyList.INSTANCE;
        }
        this.t = dnr.bo("^(" + ((String) listU.get(0)) + "|[*]+)/(" + ((String) listU.get(1)) + "|[*]+)$", "*|[*]",
                "[\\s\\S]");
    }

    public static void w(String str, ArrayList arrayList, StringBuilder sb) {
        int i = 0;
        for (bzx bzxVarD = b.d(str); bzxVarD != null; bzxVarD = bzxVarD.g()) {
            bzt bztVarC = bzxVarD.c.c(1);
            throwIfVar1IsNull(bztVarC);
            arrayList.add(bztVarC.a);
            if (bzxVarD.f().first > i) {
                String strSubstring = str.substring(i, bzxVarD.f().first);
                throwIfVar1IsNull(strSubstring, "substring(...)");
                String strQuote = Pattern.quote(strSubstring);
                throwIfVar1IsNull(strQuote, "quote(...)");
                sb.append(strQuote);
            }
            String strPattern = e.a.pattern();
            throwIfVar1IsNull(strPattern, "pattern(...)");
            sb.append(strPattern);
            i = bzxVarD.f().last + 1;
        }
        if (i < str.length()) {
            String strSubstring2 = str.substring(i);
            throwIfVar1IsNull(strSubstring2, "substring(...)");
            String strQuote2 = Pattern.quote(strSubstring2);
            throwIfVar1IsNull(strQuote2, "quote(...)");
            sb.append(strQuote2);
        }
    }

    public static void x(Bundle bundle, String str, String str2, cin cinVar) {
        if (cinVar == null) {
            cnb.ah(str, str2, bundle);
            return;
        }
        cjv cjvVar = cinVar.a;
        throwIfVar1IsNull(str, "key");
        cjvVar.j(bundle, str, cjvVar.i(str2));
    }

    public static String y(String str) {
        return (StringsKt.contains(str, "\\Q", false) && StringsKt.contains(str, "\\E", false)) ? dnr.bo(str, ".*", "\\E.*\\Q")
                : StringsKt.contains(str, "\\.\\*", false) ? dnr.bo(str, "\\.\\*", ".*") : str;
    }

    public final boolean aa(bzx bzxVar, Bundle bundle, Map map) {
        ArrayList arrayList = this.j;
        ArrayList arrayList2 = new ArrayList(StaticHelpers4.ak(arrayList, 10));
        int i = 0;
        for (Object obj : arrayList) {
            int i2 = i + 1;
            String strDecode = null;
            if (i < 0) {
                OtherStaticHelpers.aj();
                throw null;
            }
            String str = (String) obj;
            bzt bztVarC = bzxVar.c.c(i2);
            if (bztVarC != null) {
                strDecode = Uri.decode(bztVarC.a);
                throwIfVar1IsNull(strDecode, "decode(...)");
            }
            if (strDecode == null) {
                strDecode = "";
            }
            try {
                x(bundle, str, strDecode, (cin) map.get(str));
                arrayList2.add(Kotlin$Unit.INSTANCE);
                i = i2;
            } catch (IllegalArgumentException unused) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Found duplicated region for block: B:41:0x00d8 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v3, types: [int] */
    /* JADX WARN: Type inference failed for: r14v9 */
    /* JADX WARN: Type inference failed for: r22v0, types: [java.util.Map] */
    /*
     * JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object,
     * me.hd.wauxv.obf.btt]
     */
    public final boolean ab(Uri uri, Bundle bundle, Map map) {
        bzx bzxVar;
        Object objValueOf;
        boolean z;
        Object obj;
        String query;
        for (Map.Entry entry : ((Map) this.n.getValue()).entrySet()) {
            String str = (String) entry.getKey();
            cjc cjcVar = (cjc) entry.getValue();
            List<String> queryParameters = uri.getQueryParameters(str);
            if (this.o && (query = uri.getQuery()) != null && !query.equals(uri.toString())) {
                queryParameters = dqc.toSingletonList(query);
            }
            Kotlin$Unit kotlinUnitVar = Kotlin$Unit.INSTANCE;
            boolean z2 = false;
            Bundle bundleR = ResourcesCompat.r((Pair[]) Arrays.copyOf(new Pair[0], 0));
            for (String str2 : cjcVar.b) {
                cin cinVar = (cin) map.get(str2);
                cjv cjvVar = cinVar != null ? cinVar.a : null;
                if ((cjvVar instanceof pr) && !cinVar.c) {
                    pr prVar = (pr) cjvVar;
                    switch (prVar.a) {
                        case 0:
                            obj = new boolean[0];
                            break;
                        case 1:
                        case 3:
                        case 5:
                        case 7:
                        default:
                            obj = EmptyReadonlyList.INSTANCE;
                            break;
                        case 2:
                            obj = new float[0];
                            break;
                        case 4:
                            obj = new int[0];
                            break;
                        case 6:
                            obj = new long[0];
                            break;
                        case 8:
                            obj = new String[0];
                            break;
                    }
                    prVar.j(bundleR, str2, obj);
                }
            }
            for (String str3 : queryParameters) {
                String str4 = cjcVar.a;
                if (str4 != null) {
                    Pattern patternCompile = Pattern.compile(str4);
                    throwIfVar1IsNull(patternCompile, "compile(...)");
                    throwIfVar1IsNull(str3, "input");
                    Matcher matcher = patternCompile.matcher(str3);
                    throwIfVar1IsNull(matcher, "matcher(...)");
                    bzxVar = !matcher.matches() ? null : new bzx(matcher, str3);
                }
                if (bzxVar == null) {
                    return z2;
                }
                ArrayList arrayList = cjcVar.b;
                ArrayList arrayList2 = new ArrayList(StaticHelpers4.ak(arrayList, 10));
                ?? r14 = z2;
                for (Object obj2 : arrayList) {
                    int i = r14 + 1;
                    if (r14 < 0) {
                        OtherStaticHelpers.aj();
                        throw null;
                    }
                    String str5 = (String) obj2;
                    bzt bztVarC = bzxVar.c.c(i);
                    String str6 = bztVarC != null ? bztVarC.a : null;
                    if (str6 == null) {
                        str6 = "";
                    }
                    cin cinVar2 = (cin) map.get(str5);
                    try {
                        throwIfVar1IsNull(str5, "key");
                    } catch (IllegalArgumentException unused) {
                    }
                    if (bundleR.containsKey(str5)) {
                        if (bundleR.containsKey(str5)) {
                            if (cinVar2 != null) {
                                cjv cjvVar2 = cinVar2.a;
                                Object objF = cjvVar2.f(str5, bundleR);
                                if (!bundleR.containsKey(str5)) {
                                    throw new IllegalArgumentException("There is no previous value in this savedState.");
                                }
                                cjvVar2.j(bundleR, str5, cjvVar2.h(objF, str6));
                                objValueOf = kotlinUnitVar;
                            }
                            z = false;
                        } else {
                            z = true;
                        }
                        objValueOf = Boolean.valueOf(z);
                    } else {
                        x(bundleR, str5, str6, cinVar2);
                        objValueOf = kotlinUnitVar;
                    }
                    arrayList2.add(objValueOf);
                    r14 = i;
                    z2 = false;
                }
            }
            bundle.putAll(bundleR);
        }
        return true;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof cjd)) {
            cjd cjdVar = (cjd) obj;
            if (nullSafeIsEqual(this.g, cjdVar.g) && nullSafeIsEqual(this.h, cjdVar.h)
                    && nullSafeIsEqual(this.i, cjdVar.i)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.g;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.h;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.i;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    /*
     * JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object,
     * me.hd.wauxv.obf.btt]
     */
    /*
     * JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object,
     * me.hd.wauxv.obf.btt]
     */
    public final ArrayList z() {
        Collection collectionValues = ((Map) this.n.getValue()).values();
        ArrayList arrayList = new ArrayList();
        Iterator it = collectionValues.iterator();
        while (it.hasNext()) {
            StaticHelpers2.an(arrayList, ((cjc) it.next()).b);
        }
        return StaticHelpers5.o(StaticHelpers5.o(this.j, arrayList), (List) this.q.getValue());
    }
}
