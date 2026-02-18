package me.hd.wauxv.obf;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Executable;
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class cbp {
    public static final cbm a = new cbm(0);

    public static bae b(lb lbVar, cbh cbhVar, cbg cbgVar) {
        return o(
                o(o(o(o(o(o(
                        o(o(o(lbVar, cbgVar, "name", cbhVar.ab, new fq(23)), cbgVar, "nameCondition", cbhVar.ac,
                                new fq(24)), cbgVar, "modifiers", cbhVar.ad, new fq(26)),
                        cbgVar, "modifiersNot", cbhVar.ae, new fq(27)), cbgVar, "modifiersCondition", null, new fq(28)),
                        cbgVar, "isSynthetic", null, new fq(29)), cbgVar, "isSyntheticNot", null, new cbk(0)), cbgVar,
                        "annotations", cbhVar.af, new cbi(cbgVar, 15)), cbgVar, "annotationsNot", cbhVar.ag,
                        new cbi(cbgVar, 16)),
                cbgVar, "genericString", null, new cbk(1));
    }

    public static final int c(String str) {
        long j = 0;
        for (int i = 0; i < str.length(); i++) {
            j += ((long) str.charAt(i)) > 127 ? 2L : 1L;
        }
        return (int) j;
    }

    public static final String d(int i, String str) {
        int iC = i - c(str);
        return iC > 0 ? dkz.s(str, dnr.bm(iC, " ")) : str;
    }

    public static boolean e(Collection collection, List list, cbg cbgVar) {
        Class cls;
        if (collection.size() == list.size()) {
            ArrayList arrayList = new ArrayList(abb.ak(collection, 10));
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                arrayList.add(t(it.next(), cbgVar, null));
            }
            ArrayList arrayList2 = new ArrayList();
            int i = 0;
            for (Object obj : arrayList) {
                int i2 = i + 1;
                if (i < 0) {
                    aba.aj();
                    throw null;
                }
                Class cls2 = (Class) obj;
                Class cls3 = (Class) list.get(i);
                cls = eoz.class;
                Class<eoz> clsBf = cnf.bf(dal.b(cls));
                if (nullSafeIsEqual(cls2, clsBf != null ? clsBf : eoz.class) || nullSafeIsEqual(cls3, cls2)) {
                    arrayList2.add(obj);
                }
                i = i2;
            }
            if (arrayList2.size() == list.size()) {
                return true;
            }
        }
        return false;
    }

    public static bae f(bae baeVar, axd axdVar, cbg cbgVar) {
        return o(
                o(o(o(o(o(o(
                        o(o(o(o(o(
                                o(o(o(o(o(
                                        o(o(o(o(o(
                                                o(o(o(baeVar, cbgVar, "parameters", axdVar.b, new cbi(cbgVar, 1)),
                                                        cbgVar, "parametersNot", axdVar.c, new cbi(cbgVar, 7)), cbgVar,
                                                        "parametersCondition", axdVar.d, new fq(16)),
                                                cbgVar, "parameterCount", axdVar.g, new fq(18)), cbgVar,
                                                "parameterCountCondition", null, new fq(19)), cbgVar, "typeParameters",
                                                axdVar.e, new fq(20)), cbgVar, "typeParametersNot", axdVar.f,
                                                new fq(21)), cbgVar, "exceptionTypes", axdVar.h, new cbi(cbgVar, 13)),
                                        cbgVar, "exceptionTypesNot", axdVar.i, new cbi(cbgVar, 14)), cbgVar,
                                        "genericExceptionTypes", axdVar.j, new fq(22)), cbgVar,
                                        "genericExceptionTypesNot", axdVar.k, new fq(10)), cbgVar, "genericParameters",
                                        axdVar.l, new fq(11)), cbgVar, "genericParametersNot", axdVar.m, new fq(12)),
                                cbgVar, "isVarArgs", null, new fq(13)), cbgVar, "isVarArgsNot", null, new fq(14)),
                                cbgVar, "parameterAnnotations", axdVar.n, new cbi(cbgVar, 2)), cbgVar,
                                "parameterAnnotationsNot", axdVar.o, new cbi(cbgVar, 3)), cbgVar, "annotatedReturnType",
                                axdVar.p, new cbi(cbgVar, 4)),
                        cbgVar, "annotatedReturnTypeNot", axdVar.q, new cbi(cbgVar, 5)), cbgVar,
                        "annotatedReceiverType", axdVar.r, new cbi(cbgVar, 6)), cbgVar, "annotatedReceiverTypeNot",
                        axdVar.s, new cbi(cbgVar, 8)), cbgVar, "annotatedParameterTypes", axdVar.t, new cbi(cbgVar, 9)),
                        cbgVar, "annotatedParameterTypesNot", axdVar.u, new cbi(cbgVar, 10)), cbgVar,
                        "annotatedExceptionTypes", axdVar.v, new cbi(cbgVar, 11)),
                cbgVar, "annotatedExceptionTypesNot", axdVar.w, new cbi(cbgVar, 12));
    }

    public static final boolean g(cbg cbgVar, Set set, Executable executable) {
        Annotation[] annotations = executable.getAnnotatedReturnType().getAnnotations();
        ArrayList arrayList = new ArrayList(annotations.length);
        for (Annotation annotation : annotations) {
            arrayList.add(cnf.bd(cnf.bb(annotation)));
        }
        return e(set, arrayList, cbgVar);
    }

    public static final boolean h(cbg cbgVar, Set set, Executable executable) {
        Annotation[] annotations = executable.getAnnotatedReturnType().getAnnotations();
        ArrayList arrayList = new ArrayList(annotations.length);
        for (Annotation annotation : annotations) {
            arrayList.add(cnf.bd(cnf.bb(annotation)));
        }
        return !e(set, arrayList, cbgVar);
    }

    public static final boolean i(cbg cbgVar, Set set, Executable executable) {
        Annotation[] annotations = executable.getAnnotatedReceiverType().getAnnotations();
        ArrayList arrayList = new ArrayList(annotations.length);
        for (Annotation annotation : annotations) {
            arrayList.add(cnf.bd(cnf.bb(annotation)));
        }
        return e(set, arrayList, cbgVar);
    }

    public static final boolean j(cbg cbgVar, Set set, Executable executable) {
        Annotation[] annotations = executable.getAnnotatedReceiverType().getAnnotations();
        ArrayList arrayList = new ArrayList(annotations.length);
        for (Annotation annotation : annotations) {
            arrayList.add(cnf.bd(cnf.bb(annotation)));
        }
        return !e(set, arrayList, cbgVar);
    }

    public static final boolean k(cbg cbgVar, Set set, Executable executable) {
        AnnotatedType[] annotatedParameterTypes = executable.getAnnotatedParameterTypes();
        ArrayList arrayList = new ArrayList(annotatedParameterTypes.length);
        for (AnnotatedType annotatedType : annotatedParameterTypes) {
            Annotation[] annotations = annotatedType.getAnnotations();
            ArrayList arrayList2 = new ArrayList(annotations.length);
            for (Annotation annotation : annotations) {
                arrayList2.add(cnf.bd(cnf.bb(annotation)));
            }
            arrayList.add(arrayList2);
        }
        return e(set, abb.al(arrayList), cbgVar);
    }

    public static final boolean l(cbg cbgVar, Set set, Executable executable) {
        AnnotatedType[] annotatedParameterTypes = executable.getAnnotatedParameterTypes();
        ArrayList arrayList = new ArrayList(annotatedParameterTypes.length);
        for (AnnotatedType annotatedType : annotatedParameterTypes) {
            Annotation[] annotations = annotatedType.getAnnotations();
            ArrayList arrayList2 = new ArrayList(annotations.length);
            for (Annotation annotation : annotations) {
                arrayList2.add(cnf.bd(cnf.bb(annotation)));
            }
            arrayList.add(arrayList2);
        }
        return !e(set, abb.al(arrayList), cbgVar);
    }

    public static final boolean m(cbg cbgVar, Set set, Executable executable) {
        AnnotatedType[] annotatedExceptionTypes = executable.getAnnotatedExceptionTypes();
        ArrayList arrayList = new ArrayList(annotatedExceptionTypes.length);
        for (AnnotatedType annotatedType : annotatedExceptionTypes) {
            Annotation[] annotations = annotatedType.getAnnotations();
            ArrayList arrayList2 = new ArrayList(annotations.length);
            for (Annotation annotation : annotations) {
                arrayList2.add(cnf.bd(cnf.bb(annotation)));
            }
            arrayList.add(arrayList2);
        }
        return e(set, abb.al(arrayList), cbgVar);
    }

    public static final boolean n(cbg cbgVar, Set set, Executable executable) {
        AnnotatedType[] annotatedExceptionTypes = executable.getAnnotatedExceptionTypes();
        ArrayList arrayList = new ArrayList(annotatedExceptionTypes.length);
        for (AnnotatedType annotatedType : annotatedExceptionTypes) {
            Annotation[] annotations = annotatedType.getAnnotations();
            ArrayList arrayList2 = new ArrayList(annotations.length);
            for (Annotation annotation : annotations) {
                arrayList2.add(cnf.bd(cnf.bb(annotation)));
            }
            arrayList.add(arrayList2);
        }
        return !e(set, abb.al(arrayList), cbgVar);
    }

    public static bae o(dft dftVar, cbg cbgVar, String str, Object obj, bgj bgjVar) {
        return new bae(dftVar, true, new cbj(obj, bgjVar, cbgVar, str, 0));
    }

    public static Annotation[] p(Member member) {
        if (member instanceof AnnotatedElement) {
            return ((AnnotatedElement) member).getDeclaredAnnotations();
        }
        throw new IllegalStateException(("Unsupported member type: " + member).toString());
    }

    public static List q(cbh cbhVar, cbg cbgVar, Class cls, IHasInvokeMethod bgfVar) {
        Class cls2;
        List listQ = avd.a;
        if (cls != null) {
            cls2 = Object.class;
            Class<Object> clsBf = cnf.bf(dal.b(cls2));
            if (!cls.equals(clsBf != null ? clsBf : Object.class)) {
                Collection collection = (Collection) bgfVar.invoke(cls);
                if (collection.isEmpty()) {
                    if (cbgVar.d) {
                        listQ = q(cbhVar, cbgVar, cls.getSuperclass(), bgfVar);
                    } else {
                        r(cbhVar, cbgVar);
                    }
                    collection = listQ;
                }
                return (List) collection;
            }
        }
        r(cbhVar, cbgVar);
        return listQ;
    }

    public static void r(cbh cbhVar, cbg cbgVar) throws NoSuchFieldException, NoSuchMethodException {
        String strS;
        boolean z = cbhVar instanceof cde;
        if (z) {
            strS = s(cbgVar, cbhVar, "method");
        } else if (cbhVar instanceof adt) {
            strS = s(cbgVar, cbhVar, "constructor");
        } else {
            if (!(cbhVar instanceof azg)) {
                throw new IllegalStateException(("Unsupported condition type: " + cbhVar).toString());
            }
            strS = s(cbgVar, cbhVar, "field");
        }
        cbf cbfVar = cbgVar.e;
        if (cbfVar != cbf.a) {
            if (cbfVar == cbf.b) {
                dov dovVar = bth.a;
                bth.e(dnj.ba(strS).toString(), null);
                return;
            }
            return;
        }
        if (z) {
            throw new NoSuchMethodException(dkz.s(strS,
                    "\nIf you want to ignore this exception, adding optional() in your condition.\n\n====== Generated by KavaRef 1.0.2 ======\n"));
        }
        if (cbhVar instanceof adt) {
            throw new NoSuchMethodException(dkz.s(strS,
                    "\nIf you want to ignore this exception, adding optional() in your condition.\n\n====== Generated by KavaRef 1.0.2 ======\n"));
        }
        if (cbhVar instanceof azg) {
            throw new NoSuchFieldException(dkz.s(strS,
                    "\nIf you want to ignore this exception, adding optional() in your condition.\n\n====== Generated by KavaRef 1.0.2 ======\n"));
        }
        throw new IllegalStateException(("Unsupported condition type: " + cbhVar).toString());
    }

    public static final String s(cbg cbgVar, cbh cbhVar, String str) {
        String strConcat;
        String strB;
        boolean z = cbgVar.d;
        Class cls = cbgVar.a;
        String str2 = z ? " (Also tried for superclass)" : "";
        try {
            Map mapX = cbhVar.x();
            ArrayList arrayList = new ArrayList();
            for (Map.Entry entry : mapX.entrySet()) {
                String str3 = (String) entry.getKey();
                Object value = entry.getValue();
                if (value != null) {
                    strB = value instanceof IEmpty4 ? "(Runtime Condition)"
                            : ((value instanceof Collection) && ((Collection) value).isEmpty()) ? null : eoz.b(value);
                }
                String strBo = strB != null ? dnr.bo(strB.toString(), " (Kotlin reflection is not available)", "")
                        : null;
                Pair pairVar = strBo != null ? new Pair(str3, strBo) : null;
                if (pairVar != null) {
                    arrayList.add(pairVar);
                }
            }
            if (arrayList.isEmpty()) {
                strConcat = cls.toString();
            } else {
                Iterator it = arrayList.iterator();
                if (!it.hasNext()) {
                    throw new NoSuchElementException();
                }
                int iC = c((String) ((Pair) it.next()).first);
                while (it.hasNext()) {
                    int iC2 = c((String) ((Pair) it.next()).first);
                    if (iC < iC2) {
                        iC = iC2;
                    }
                }
                Iterator it2 = arrayList.iterator();
                if (!it2.hasNext()) {
                    throw new NoSuchElementException();
                }
                int iC3 = c((String) ((Pair) it2.next()).second);
                while (it2.hasNext()) {
                    int iC4 = c((String) ((Pair) it2.next()).second);
                    if (iC3 < iC4) {
                        iC3 = iC4;
                    }
                }
                String strBo2 = dnr.bo(cls.toString(), " (Kotlin reflection is not available)", "");
                int iC5 = c(strBo2) - ((iC + iC3) + 3);
                if (iC5 < 0) {
                    iC5 = 0;
                }
                int i = iC3 + iC5;
                String str4 = "+-" + dnr.bm(iC, "-") + "-+-" + dnr.bm(i, "-") + "-+";
                int i2 = iC + i + 3;
                strConcat = aaz.k(
                        aba.ag("+-" + dnr.bm(i2, "-") + "-+", "| " + d(i2, strBo2) + " |", str4,
                                aaz.k(arrayList, "\n", null, null, new cbl(iC, i, 0), 30), str4),
                        "\n", null, null, null, 62);
            }
        } catch (Throwable th) {
            bhu.x(th);
            strConcat = dnr.bo(cls.toString(), " (Kotlin reflection is not available)", "")
                    .concat("\nFailed to build condition table.");
        }
        return "No " + str + " found matching the condition for current class" + str2 + ".\n" + strConcat
                + "\nSuggestion: "
                + (!cbgVar.d
                        ? "Members in superclass are not reflected in the current class, you can try adding superclass() in your condition and try again. "
                        : "Check if the conditions are correct and valid, and try again. ");
    }

    public static Class t(Object obj, cbg cbgVar, String str) {
        Class<?> clsF;
        Class cls;
        if (obj instanceof Class) {
            clsF = (Class) obj;
        } else if (obj instanceof bsv) {
            clsF = cnf.bd((bsv) obj);
        } else if (obj instanceof String) {
            cbf cbfVar = cbgVar.e;
            Class cls2 = cbgVar.a;
            if (cbfVar == cbf.a) {
                clsF = ReflectionWrapper.tryGetClassByName(cls2.getClassLoader(), (String) obj);
            } else {
                clsF = ReflectionWrapper.f((String) obj, 2, cls2.getClassLoader());
                if (clsF == null) {
                    clsF = Object.class;
                    Class<?> clsBf = cnf.bf(dal.b(clsF));
                    if (clsBf != null) {
                        clsF = clsBf;
                    }
                }
            }
        } else {
            if (!(obj instanceof eoz)) {
                throw new IllegalStateException(
                        ("Unsupported type: " + obj + ", supported types are Class, KClass, String and VagueType.")
                                .toString());
            }
            clsF = obj.getClass();
        }
        cls = eoz.class;
        Class<eoz> clsBf2 = cnf.bf(dal.b(cls));
        if (!clsF.equals(clsBf2 != null ? clsBf2 : eoz.class) || str == null) {
            return clsF;
        }
        throw new IllegalStateException(("VagueType is not supported for \"" + str + "\".").toString());
    }
}
