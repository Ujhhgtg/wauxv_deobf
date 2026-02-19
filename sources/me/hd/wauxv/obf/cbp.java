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

    public static bae b(lb lbVar, MemberResolver memberResolverVar, Configuration configurationVar) {
        return o(
                o(o(o(o(o(o(
                        o(o(o(lbVar, configurationVar, "name", memberResolverVar.name, new fq(23)), configurationVar, "nameCondition", memberResolverVar.nameCondition,
                                new fq(24)), configurationVar, "modifiers", memberResolverVar.modifiers, new fq(26)),
                                                configurationVar, "modifiersNot", memberResolverVar.modifiersNot, new fq(27)), configurationVar, "modifiersCondition", null, new fq(28)),
                                        configurationVar, "isSynthetic", null, new fq(29)), configurationVar, "isSyntheticNot", null, new cbk(0)), configurationVar,
                        "annotations", memberResolverVar.annotations, new cbi(configurationVar, 15)), configurationVar, "annotationsNot", memberResolverVar.annotationsNot,
                        new cbi(configurationVar, 16)),
                configurationVar, "genericString", null, new cbk(1));
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
        return iC > 0 ? StaticHelpers6.concat(str, dnr.bm(iC, " ")) : str;
    }

    public static boolean e(Collection collection, List list, Configuration configurationVar) {
        Class cls;
        if (collection.size() == list.size()) {
            ArrayList arrayList = new ArrayList(StaticHelpers4.ak(collection, 10));
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                arrayList.add(t(it.next(), configurationVar, null));
            }
            ArrayList arrayList2 = new ArrayList();
            int i = 0;
            for (Object obj : arrayList) {
                int i2 = i + 1;
                if (i < 0) {
                    OtherStaticHelpers.aj();
                    throw null;
                }
                Class cls2 = (Class) obj;
                Class cls3 = (Class) list.get(i);
                cls = eoz.class;
                Class<eoz> clsBf = HugeSyntheticPileOfHelpers.bf(dal.b(cls));
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

    public static bae f(bae baeVar, ExecutableResolver executableResolverVar, Configuration configurationVar) {
        return o(
                o(o(o(o(o(o(
                        o(o(o(o(o(
                                o(o(o(o(o(
                                        o(o(o(o(o(
                                                o(o(o(baeVar, configurationVar, "parameters", executableResolverVar.b, new cbi(configurationVar, 1)),
                                                                configurationVar, "parametersNot", executableResolverVar.c, new cbi(configurationVar, 7)), configurationVar,
                                                        "parametersCondition", executableResolverVar.d, new fq(16)),
                                                                        configurationVar, "parameterCount", executableResolverVar.paramCount, new fq(18)), configurationVar,
                                                "parameterCountCondition", null, new fq(19)), configurationVar, "typeParameters",
                                                executableResolverVar.e, new fq(20)), configurationVar, "typeParametersNot", executableResolverVar.f,
                                                new fq(21)), configurationVar, "exceptionTypes", executableResolverVar.h, new cbi(configurationVar, 13)),
                                                                configurationVar, "exceptionTypesNot", executableResolverVar.i, new cbi(configurationVar, 14)), configurationVar,
                                        "genericExceptionTypes", executableResolverVar.j, new fq(22)), configurationVar,
                                        "genericExceptionTypesNot", executableResolverVar.k, new fq(10)), configurationVar, "genericParameters",
                                        executableResolverVar.l, new fq(11)), configurationVar, "genericParametersNot", executableResolverVar.m, new fq(12)),
                                                        configurationVar, "isVarArgs", null, new fq(13)), configurationVar, "isVarArgsNot", null, new fq(14)),
                                                configurationVar, "parameterAnnotations", executableResolverVar.n, new cbi(configurationVar, 2)), configurationVar,
                                "parameterAnnotationsNot", executableResolverVar.o, new cbi(configurationVar, 3)), configurationVar, "annotatedReturnType",
                                executableResolverVar.p, new cbi(configurationVar, 4)),
                                                        configurationVar, "annotatedReturnTypeNot", executableResolverVar.q, new cbi(configurationVar, 5)), configurationVar,
                        "annotatedReceiverType", executableResolverVar.r, new cbi(configurationVar, 6)), configurationVar, "annotatedReceiverTypeNot",
                        executableResolverVar.s, new cbi(configurationVar, 8)), configurationVar, "annotatedParameterTypes", executableResolverVar.t, new cbi(configurationVar, 9)),
                                configurationVar, "annotatedParameterTypesNot", executableResolverVar.u, new cbi(configurationVar, 10)), configurationVar,
                        "annotatedExceptionTypes", executableResolverVar.v, new cbi(configurationVar, 11)),
                configurationVar, "annotatedExceptionTypesNot", executableResolverVar.w, new cbi(configurationVar, 12));
    }

    public static final boolean g(Configuration configurationVar, Set set, Executable executable) {
        Annotation[] annotations = executable.getAnnotatedReturnType().getAnnotations();
        ArrayList arrayList = new ArrayList(annotations.length);
        for (Annotation annotation : annotations) {
            arrayList.add(HugeSyntheticPileOfHelpers.getJavaClass(HugeSyntheticPileOfHelpers.bb(annotation)));
        }
        return e(set, arrayList, configurationVar);
    }

    public static final boolean h(Configuration configurationVar, Set set, Executable executable) {
        Annotation[] annotations = executable.getAnnotatedReturnType().getAnnotations();
        ArrayList arrayList = new ArrayList(annotations.length);
        for (Annotation annotation : annotations) {
            arrayList.add(HugeSyntheticPileOfHelpers.getJavaClass(HugeSyntheticPileOfHelpers.bb(annotation)));
        }
        return !e(set, arrayList, configurationVar);
    }

    public static final boolean i(Configuration configurationVar, Set set, Executable executable) {
        Annotation[] annotations = executable.getAnnotatedReceiverType().getAnnotations();
        ArrayList arrayList = new ArrayList(annotations.length);
        for (Annotation annotation : annotations) {
            arrayList.add(HugeSyntheticPileOfHelpers.getJavaClass(HugeSyntheticPileOfHelpers.bb(annotation)));
        }
        return e(set, arrayList, configurationVar);
    }

    public static final boolean j(Configuration configurationVar, Set set, Executable executable) {
        Annotation[] annotations = executable.getAnnotatedReceiverType().getAnnotations();
        ArrayList arrayList = new ArrayList(annotations.length);
        for (Annotation annotation : annotations) {
            arrayList.add(HugeSyntheticPileOfHelpers.getJavaClass(HugeSyntheticPileOfHelpers.bb(annotation)));
        }
        return !e(set, arrayList, configurationVar);
    }

    public static final boolean k(Configuration configurationVar, Set set, Executable executable) {
        AnnotatedType[] annotatedParameterTypes = executable.getAnnotatedParameterTypes();
        ArrayList arrayList = new ArrayList(annotatedParameterTypes.length);
        for (AnnotatedType annotatedType : annotatedParameterTypes) {
            Annotation[] annotations = annotatedType.getAnnotations();
            ArrayList arrayList2 = new ArrayList(annotations.length);
            for (Annotation annotation : annotations) {
                arrayList2.add(HugeSyntheticPileOfHelpers.getJavaClass(HugeSyntheticPileOfHelpers.bb(annotation)));
            }
            arrayList.add(arrayList2);
        }
        return e(set, StaticHelpers4.al(arrayList), configurationVar);
    }

    public static final boolean l(Configuration configurationVar, Set set, Executable executable) {
        AnnotatedType[] annotatedParameterTypes = executable.getAnnotatedParameterTypes();
        ArrayList arrayList = new ArrayList(annotatedParameterTypes.length);
        for (AnnotatedType annotatedType : annotatedParameterTypes) {
            Annotation[] annotations = annotatedType.getAnnotations();
            ArrayList arrayList2 = new ArrayList(annotations.length);
            for (Annotation annotation : annotations) {
                arrayList2.add(HugeSyntheticPileOfHelpers.getJavaClass(HugeSyntheticPileOfHelpers.bb(annotation)));
            }
            arrayList.add(arrayList2);
        }
        return !e(set, StaticHelpers4.al(arrayList), configurationVar);
    }

    public static final boolean m(Configuration configurationVar, Set set, Executable executable) {
        AnnotatedType[] annotatedExceptionTypes = executable.getAnnotatedExceptionTypes();
        ArrayList arrayList = new ArrayList(annotatedExceptionTypes.length);
        for (AnnotatedType annotatedType : annotatedExceptionTypes) {
            Annotation[] annotations = annotatedType.getAnnotations();
            ArrayList arrayList2 = new ArrayList(annotations.length);
            for (Annotation annotation : annotations) {
                arrayList2.add(HugeSyntheticPileOfHelpers.getJavaClass(HugeSyntheticPileOfHelpers.bb(annotation)));
            }
            arrayList.add(arrayList2);
        }
        return e(set, StaticHelpers4.al(arrayList), configurationVar);
    }

    public static final boolean n(Configuration configurationVar, Set set, Executable executable) {
        AnnotatedType[] annotatedExceptionTypes = executable.getAnnotatedExceptionTypes();
        ArrayList arrayList = new ArrayList(annotatedExceptionTypes.length);
        for (AnnotatedType annotatedType : annotatedExceptionTypes) {
            Annotation[] annotations = annotatedType.getAnnotations();
            ArrayList arrayList2 = new ArrayList(annotations.length);
            for (Annotation annotation : annotations) {
                arrayList2.add(HugeSyntheticPileOfHelpers.getJavaClass(HugeSyntheticPileOfHelpers.bb(annotation)));
            }
            arrayList.add(arrayList2);
        }
        return !e(set, StaticHelpers4.al(arrayList), configurationVar);
    }

    public static bae o(dft dftVar, Configuration configurationVar, String str, Object obj, bgj bgjVar) {
        return new bae(dftVar, true, new cbj(obj, bgjVar, configurationVar, str, 0));
    }

    public static Annotation[] p(Member member) {
        if (member instanceof AnnotatedElement) {
            return ((AnnotatedElement) member).getDeclaredAnnotations();
        }
        throw new IllegalStateException(("Unsupported member type: " + member).toString());
    }

    public static List q(MemberResolver memberResolverVar, Configuration configurationVar, Class cls, IInvokable bgfVar) {
        Class cls2;
        List listQ = EmptyReadonlyList.INSTANCE;
        if (cls != null) {
            cls2 = Object.class;
            Class<Object> clsBf = HugeSyntheticPileOfHelpers.bf(dal.b(cls2));
            if (!cls.equals(clsBf != null ? clsBf : Object.class)) {
                Collection collection = (Collection) bgfVar.invoke(cls);
                if (collection.isEmpty()) {
                    if (configurationVar.superclass) {
                        listQ = q(memberResolverVar, configurationVar, cls.getSuperclass(), bgfVar);
                    } else {
                        r(memberResolverVar, configurationVar);
                    }
                    collection = listQ;
                }
                return (List) collection;
            }
        }
        r(memberResolverVar, configurationVar);
        return listQ;
    }

    public static void r(MemberResolver memberResolverVar, Configuration configurationVar) throws NoSuchFieldException, NoSuchMethodException {
        String strS;
        boolean z = memberResolverVar instanceof MethodResolver;
        if (z) {
            strS = s(configurationVar, memberResolverVar, "method");
        } else if (memberResolverVar instanceof adt) {
            strS = s(configurationVar, memberResolverVar, "constructor");
        } else {
            if (!(memberResolverVar instanceof FieldResolver)) {
                throw new IllegalStateException(("Unsupported condition type: " + memberResolverVar).toString());
            }
            strS = s(configurationVar, memberResolverVar, "field");
        }
        OptionalType optionalTypeVar = configurationVar.optional;
        if (optionalTypeVar != OptionalType.ENUM_NO) {
            if (optionalTypeVar == OptionalType.ENUM_NOTICE) {
                Kotlin$Lazy kotlin$LazyVar = bth.a;
                bth.e(dnj.ba(strS).toString(), null);
                return;
            }
            return;
        }
        if (z) {
            throw new NoSuchMethodException(StaticHelpers6.concat(strS,
                    "\nIf you want to ignore this exception, adding optional() in your condition.\n\n====== Generated by KavaRef 1.0.2 ======\n"));
        }
        if (memberResolverVar instanceof adt) {
            throw new NoSuchMethodException(StaticHelpers6.concat(strS,
                    "\nIf you want to ignore this exception, adding optional() in your condition.\n\n====== Generated by KavaRef 1.0.2 ======\n"));
        }
        if (memberResolverVar instanceof FieldResolver) {
            throw new NoSuchFieldException(StaticHelpers6.concat(strS,
                    "\nIf you want to ignore this exception, adding optional() in your condition.\n\n====== Generated by KavaRef 1.0.2 ======\n"));
        }
        throw new IllegalStateException(("Unsupported condition type: " + memberResolverVar).toString());
    }

    public static final String s(Configuration configurationVar, MemberResolver memberResolverVar, String str) {
        String strConcat;
        String strB;
        boolean z = configurationVar.superclass;
        Class cls = configurationVar.declaringClass;
        String str2 = z ? " (Also tried for superclass)" : "";
        try {
            Map mapX = memberResolverVar.toFieldsNameValueMap();
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
                strConcat = StaticHelpers5.k(
                        OtherStaticHelpers.argsToList("+-" + dnr.bm(i2, "-") + "-+", "| " + d(i2, strBo2) + " |", str4,
                                StaticHelpers5.k(arrayList, "\n", null, null, new cbl(iC, i, 0), 30), str4),
                        "\n", null, null, null, 62);
            }
        } catch (Throwable th) {
            FastKV.x(th);
            strConcat = dnr.bo(cls.toString(), " (Kotlin reflection is not available)", "")
                    .concat("\nFailed to build condition table.");
        }
        return "No " + str + " found matching the condition for current class" + str2 + ".\n" + strConcat
                + "\nSuggestion: "
                + (!configurationVar.superclass
                        ? "Members in superclass are not reflected in the current class, you can try adding superclass() in your condition and try again. "
                        : "Check if the conditions are correct and valid, and try again. ");
    }

    public static Class t(Object obj, Configuration configurationVar, String str) {
        Class<?> clsF;
        Class cls;
        if (obj instanceof Class) {
            clsF = (Class) obj;
        } else if (obj instanceof IEmpty5) {
            clsF = HugeSyntheticPileOfHelpers.getJavaClass((IEmpty5) obj);
        } else if (obj instanceof String) {
            OptionalType optionalTypeVar = configurationVar.optional;
            Class cls2 = configurationVar.declaringClass;
            if (optionalTypeVar == OptionalType.ENUM_NO) {
                clsF = ReflectionWrapper.tryGetClassByName(cls2.getClassLoader(), (String) obj);
            } else {
                clsF = ReflectionWrapper.f((String) obj, 2, cls2.getClassLoader());
                if (clsF == null) {
                    clsF = Object.class;
                    Class<?> clsBf = HugeSyntheticPileOfHelpers.bf(dal.b(clsF));
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
        Class<eoz> clsBf2 = HugeSyntheticPileOfHelpers.bf(dal.b(cls));
        if (!clsF.equals(clsBf2 != null ? clsBf2 : eoz.class) || str == null) {
            return clsF;
        }
        throw new IllegalStateException(("VagueType is not supported for \"" + str + "\".").toString());
    }
}
