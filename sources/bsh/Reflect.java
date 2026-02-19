package bsh;

import bsh.util.ReferenceCache;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.Security;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import me.hd.wauxv.obf.cpt;
import me.hd.wauxv.obf.cpv;
import me.hd.wauxv.obf.StaticHelpers6;
import me.hd.wauxv.obf.kx;
import me.hd.wauxv.obf.ra;
import me.hd.wauxv.obf.rb;
import me.hd.wauxv.obf.yg;
import me.hd.wauxv.obf.yz;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class Reflect {
    static final String GET_PREFIX = "get";
    static final String IS_PREFIX = "is";
    private static final Pattern PACKAGE_ACCESS;
    static final String SET_PREFIX = "set";
    static final Map<Class<?>, Object> instanceCache;
    public static final Object[] ZERO_ARGS = new Object[0];
    public static final Class<?>[] ZERO_TYPES = new Class[0];
    private static final Map<String, String> ACCESSOR_NAMES = new WeakHashMap();
    private static final Pattern DEFAULT_PACKAGE = Pattern.compile("[^\\.]+|bsh\\..*");

    static {
        String property = Security.getProperty("package.access");
        if (property == null) {
            property = "null";
        }
        PACKAGE_ACCESS = Pattern.compile((String) Stream.of((Object[]) property.split(",")).filter(new ra(8))
                .collect(Collectors.joining("|", "(?:", ").*")));
        instanceCache = new WeakHashMap();
    }

    public static String accessorName(String str, String str2) {
        Map<String, String> map = ACCESSOR_NAMES;
        if (!map.containsKey(str2)) {
            char[] charArray = str2.toCharArray();
            charArray[0] = Character.toUpperCase(charArray[0]);
            map.put(str2, new String(charArray));
        }
        StringBuilder sbY = StaticHelpers6.toSb(str);
        sbY.append(map.get(str2));
        return sbY.toString();
    }

    private static ReflectError cantFindConstructor(Class<?> cls, Class<?>[] clsArr) {
        if (clsArr.length == 0) {
            return new ReflectError(concatVar2Var1(cls, "Can't find default constructor for: "));
        }
        return new ReflectError("Can't find constructor: " + StringUtil.methodString(cls.getName(), clsArr)
                + " in class: " + cls.getName());
    }

    private static void checkFoundStaticMethod(Invocable invocable, boolean z, Class<?> cls) throws UtilEvalError {
        if (invocable == null || !z || invocable.isStatic()) {
            return;
        }
        throw new UtilEvalError("Cannot reach instance method: "
                + StringUtil.methodString(invocable.getName(), invocable.getParameterTypes()) + " from static context: "
                + cls.getName());
    }

    public static Object constructObject(Class<?> cls, Object[] objArr) {
        return constructObject(cls, null, objArr);
    }

    public static BshMethod findMostSpecificBshMethod(Class<?>[] clsArr, List<BshMethod> list) {
        Interpreter.debug("find most specific BshMethod for: " + Arrays.toString(clsArr));
        int iFindMostSpecificBshMethodIndex = findMostSpecificBshMethodIndex(clsArr, list);
        if (iFindMostSpecificBshMethodIndex == -1) {
            return null;
        }
        return list.get(iFindMostSpecificBshMethodIndex);
    }

    public static int findMostSpecificBshMethodIndex(Class<?>[] clsArr, List<BshMethod> list) {
        for (int i = 0; i < list.size(); i++) {
            StringBuilder sbR = yg.concatVar213(i, "  ", ":");
            sbR.append(list.get(i).toString());
            sbR.append(" ");
            sbR.append(list.get(i).getClass().getName());
            Interpreter.debug(sbR.toString());
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<BshMethod> it = list.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            Class<?>[] parameterTypes = it.next().getParameterTypes();
            if (clsArr.length == parameterTypes.length) {
                arrayList2.add(Integer.valueOf(i2));
                arrayList.add(parameterTypes);
            }
            i2++;
        }
        int iFindMostSpecificSignature = findMostSpecificSignature(clsArr,
                (Class[][]) arrayList.toArray(new Class[arrayList.size()][]));
        if (iFindMostSpecificSignature >= 0) {
            int iIntValue = ((Integer) arrayList2.get(iFindMostSpecificSignature)).intValue();
            Interpreter.debug(" remap: " + arrayList2);
            Interpreter.debug(" match:" + iIntValue);
            return iIntValue;
        }
        arrayList.clear();
        arrayList2.clear();
        int i3 = 0;
        for (BshMethod bshMethod : list) {
            Class<?>[] parameterTypes2 = bshMethod.getParameterTypes();
            if (bshMethod.isVarArgs() && clsArr.length >= parameterTypes2.length - 1) {
                Class[] clsArr2 = new Class[clsArr.length];
                System.arraycopy(parameterTypes2, 0, clsArr2, 0, parameterTypes2.length - 1);
                Arrays.fill(clsArr2, parameterTypes2.length - 1, clsArr.length,
                        parameterTypes2[parameterTypes2.length - 1].getComponentType());
                arrayList2.add(Integer.valueOf(i3));
                arrayList.add(clsArr2);
            }
            i3++;
        }
        int iFindMostSpecificSignature2 = findMostSpecificSignature(clsArr,
                (Class[][]) arrayList.toArray(new Class[arrayList.size()][]));
        if (iFindMostSpecificSignature2 < 0) {
            return iFindMostSpecificSignature2;
        }
        int iIntValue2 = ((Integer) arrayList2.get(iFindMostSpecificSignature2)).intValue();
        Interpreter.debug(" remap (varargs): " + Arrays.toString(arrayList2.toArray(new Integer[0])));
        Interpreter.debug(" match (varargs):" + iIntValue2);
        return iIntValue2;
    }

    public static Invocable findMostSpecificInvocable(Class<?>[] clsArr, List<Invocable> list) {
        Interpreter.debug("find most specific Invocable for: " + Arrays.toString(clsArr));
        int iFindMostSpecificInvocableIndex = findMostSpecificInvocableIndex(clsArr, list);
        if (iFindMostSpecificInvocableIndex == -1) {
            return null;
        }
        return list.get(iFindMostSpecificInvocableIndex);
    }

    public static int findMostSpecificInvocableIndex(Class<?>[] clsArr, List<Invocable> list) {
        for (int i = 0; i < list.size(); i++) {
            StringBuilder sbR = yg.concatVar213(i, "  ", "=");
            sbR.append(list.get(i).toString());
            Interpreter.debug(sbR.toString());
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<Invocable> it = list.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            Class<?>[] parameterTypes = it.next().getParameterTypes();
            if (clsArr.length == parameterTypes.length) {
                arrayList2.add(Integer.valueOf(i2));
                arrayList.add(parameterTypes);
            }
            i2++;
        }
        int iFindMostSpecificSignature = findMostSpecificSignature(clsArr,
                (Class[][]) arrayList.toArray(new Class[arrayList.size()][]));
        if (iFindMostSpecificSignature >= 0) {
            int iIntValue = ((Integer) arrayList2.get(iFindMostSpecificSignature)).intValue();
            Interpreter.debug(" remap=" + Arrays.toString(arrayList2.toArray(new Integer[0])));
            Interpreter.debug(" match=" + iIntValue);
            return iIntValue;
        }
        arrayList.clear();
        arrayList2.clear();
        int i3 = 0;
        for (Invocable invocable : list) {
            Class<?>[] parameterTypes2 = invocable.getParameterTypes();
            if (invocable.isVarArgs() && clsArr.length >= parameterTypes2.length - 1) {
                Class[] clsArr2 = new Class[clsArr.length];
                System.arraycopy(parameterTypes2, 0, clsArr2, 0, parameterTypes2.length - 1);
                Arrays.fill(clsArr2, parameterTypes2.length - 1, clsArr.length, invocable.getVarArgsComponentType());
                arrayList2.add(Integer.valueOf(i3));
                arrayList.add(clsArr2);
            }
            i3++;
        }
        int iFindMostSpecificSignature2 = findMostSpecificSignature(clsArr,
                (Class[][]) arrayList.toArray(new Class[arrayList.size()][]));
        if (iFindMostSpecificSignature2 >= 0) {
            iFindMostSpecificSignature2 = ((Integer) arrayList2.get(iFindMostSpecificSignature2)).intValue();
        }
        Interpreter.debug(" remap (varargs) =" + Arrays.toString(arrayList2.toArray(new Integer[0])));
        Interpreter.debug(" match (varargs) =" + iFindMostSpecificSignature2);
        return iFindMostSpecificSignature2;
    }

    public static int findMostSpecificSignature(Class<?>[] clsArr, Class<?>[][] clsArr2) {
        int i = 1;
        while (true) {
            int i2 = -1;
            if (i > 4) {
                return -1;
            }
            Class<?>[] clsArr3 = null;
            for (int i3 = 0; i3 < clsArr2.length; i3++) {
                Class<?>[] clsArr4 = clsArr2[i3];
                if ((clsArr3 == null || !Types.areSignaturesEqual(clsArr4, clsArr3))
                        && Types.isSignatureAssignable(clsArr, clsArr4, i)
                        && (clsArr3 == null || Types.areSignaturesEqual(clsArr, clsArr4)
                                || (Types.isSignatureAssignable(clsArr4, clsArr3, 1)
                                        && !Types.areSignaturesEqual(clsArr, clsArr3)))) {
                    i2 = i3;
                    clsArr3 = clsArr4;
                }
            }
            if (clsArr3 != null) {
                return i2;
            }
            i++;
        }
    }

    public static This getClassInstanceThis(Object obj, String str) {
        try {
            return (This) Primitive.unwrap(getObjectFieldValue(obj, This.Keys.BSHTHIS + str));
        } catch (Exception e) {
            throw new InterpreterError("Generated class: Error getting This " + e, e);
        }
    }

    public static Modifiers getClassModifiers(Class<?> cls) {
        try {
            return (Modifiers) getVariable(cls, This.Keys.BSHCLASSMODIFIERS.toString()).getValue();
        } catch (Exception unused) {
            return new Modifiers(cls.isInterface() ? 1 : 0);
        }
    }

    public static This getClassStaticThis(Class<?> cls, String str) {
        try {
            return (This) getStaticFieldValue(cls, This.Keys.BSHSTATIC + str);
        } catch (Exception e) {
            throw new InterpreterError("Unable to get class static space: " + e, e);
        }
    }

    public static BshMethod getDeclaredMethod(Class<?> cls, String str, Class<?>[] clsArr) {
        if (!isGeneratedClass(cls)) {
            return null;
        }
        BshMethod method = getMethod(cls, str, clsArr);
        return (method != null || cls.isInterface()) ? method : getMethod(getNewInstance(cls), str, clsArr);
    }

    public static BshMethod[] getDeclaredMethods(Class<?> cls) {
        return !isGeneratedClass(cls) ? new BshMethod[0]
                : cls.isInterface() ? getMethods(cls) : getMethods(getNewInstance(cls));
    }

    public static Variable getDeclaredVariable(Class<?> cls, String str) {
        if (!isGeneratedClass(cls)) {
            return null;
        }
        Variable variable = getVariable(cls, str);
        return (variable != null || cls.isInterface()) ? variable : getVariable(getNewInstance(cls), str);
    }

    public static Variable[] getDeclaredVariables(Class<?> cls) {
        return !isGeneratedClass(cls) ? new Variable[0]
                : cls.isInterface() ? getVariables(cls) : getVariables(getNewInstance(cls));
    }

    public static Map.Entry getEntryForKey(Object obj, Map.Entry[] entryArr) {
        for (Map.Entry entry : entryArr) {
            if (obj.equals(entry.getKey())) {
                return entry;
            }
        }
        return null;
    }

    public static <T> T[] getEnumConstants(Class<T> cls) {
        return (T[]) Stream.of((Object[]) cls.getFields()).filter(new yz(cls, 1)).map(new cpv(25)).filter(new ra(6))
                .toArray(new kx(cls, 3));
    }

    private static Object getFieldValue(Class<?> cls, Object obj, String str, boolean z) throws UtilTargetError {
        try {
            return resolveExpectedJavaField(cls, str, z).invoke(obj, new Object[0]);
        } catch (ReflectError e) {
            NameSpace thisNS = getThisNS(cls);
            if (isGeneratedClass(cls) && thisNS != null && thisNS.isClass) {
                if (z) {
                    Variable variableImpl = thisNS.getVariableImpl(str, true);
                    Primitive primitive = Primitive.VOID;
                    Object objUnwrapVariable = (variableImpl == null
                            || (variableImpl.hasModifier("private") && !Capabilities.haveAccessibility())) ? primitive
                                    : thisNS.unwrapVariable(variableImpl);
                    if (primitive != objUnwrapVariable) {
                        return objUnwrapVariable;
                    }
                } else {
                    NameSpace thisNS2 = getThisNS(obj);
                    if (thisNS2 != null) {
                        Variable variableImpl2 = thisNS2.getVariableImpl(str, true);
                        Primitive primitive2 = Primitive.VOID;
                        Object objUnwrapVariable2 = (variableImpl2 == null
                                || (variableImpl2.hasModifier("private") && !Capabilities.haveAccessibility()))
                                        ? primitive2
                                        : thisNS2.unwrapVariable(variableImpl2);
                        if (primitive2 != objUnwrapVariable2) {
                            return objUnwrapVariable2;
                        }
                    }
                }
            }
            throw e;
        } catch (InvocationTargetException e2) {
            if (e2.getCause() instanceof InterpreterError) {
                throw ((InterpreterError) e2.getCause());
            }
            if (e2.getCause() instanceof UtilEvalError) {
                throw new UtilTargetError(e2.getCause());
            }
            throw new ReflectError(yg.k("Can't access field: ", str), e2.getCause());
        }
    }

    public static LHS getLHSObjectField(Object obj, String str) {
        Variable variableImpl;
        if (obj instanceof This) {
            return new LHS(((This) obj).namespace, str, false);
        }
        try {
            return new LHS(obj, resolveExpectedJavaField(obj.getClass(), str, false));
        } catch (ReflectError e) {
            NameSpace thisNS = getThisNS(obj);
            if (isGeneratedClass(obj.getClass()) && thisNS != null && thisNS.isClass
                    && (variableImpl = thisNS.getVariableImpl(str, true)) != null
                    && (!variableImpl.hasModifier("private") || Capabilities.haveAccessibility())) {
                return new LHS(thisNS, str);
            }
            if (hasObjectPropertySetter(obj.getClass(), str)) {
                return new LHS(obj, str);
            }
            throw e;
        }
    }

    public static LHS getLHSStaticField(Class<?> cls, String str) {
        Variable variableImpl;
        try {
            return new LHS(resolveExpectedJavaField(cls, str, true));
        } catch (ReflectError e) {
            NameSpace thisNS = getThisNS(cls);
            if (isGeneratedClass(cls) && thisNS != null && thisNS.isClass
                    && (variableImpl = thisNS.getVariableImpl(str, true)) != null
                    && (!variableImpl.hasModifier("private") || Capabilities.haveAccessibility())) {
                return new LHS(thisNS, str);
            }
            if (hasObjectPropertySetter(cls, str)) {
                return new LHS(cls, str);
            }
            throw e;
        }
    }

    public static BshMethod getMethod(Class<?> cls, String str, Class<?>[] clsArr) {
        return getMethod(getThisNS(cls), str, clsArr);
    }

    public static String[] getMethodNames(NameSpace nameSpace) {
        return nameSpace == null ? new String[0] : nameSpace.getMethodNames();
    }

    public static BshMethod[] getMethods(Class<?> cls) {
        return getMethods(getThisNS(cls));
    }

    public static Object getNewInstance(Class<?> cls) {
        Map<Class<?>, Object> map = instanceCache;
        if (map.containsKey(cls)) {
            return map.get(cls);
        }
        try {
            map.put(cls, cls.getConstructor(null).newInstance(null));
        } catch (IllegalArgumentException | ReflectiveOperationException | SecurityException unused) {
            instanceCache.put(cls, null);
        }
        return instanceCache.get(cls);
    }

    public static Object getObjectFieldValue(Object obj, String str) throws UtilTargetError {
        if (obj instanceof This) {
            return ((This) obj).namespace.getVariable(str);
        }
        if (obj == Primitive.NULL) {
            throw new UtilTargetError(
                    new NullPointerException(concat("Attempt to access field '", str, "' on null value")));
        }
        try {
            return getFieldValue(obj.getClass(), obj, str, false);
        } catch (ReflectError e) {
            if (hasObjectPropertyGetter(obj.getClass(), str)) {
                return getObjectProperty(obj, str);
            }
            throw e;
        }
    }

    public static Object getObjectProperty(Object obj, String str) {
        if (Types.isPropertyTypeEntry(obj)) {
            str.getClass();
            switch (str) {
                case "key":
                    return ((Map.Entry) obj).getKey();
                case "val":
                case "value":
                    return ((Map.Entry) obj).getValue();
            }
        }
        return getObjectProperty(obj, (Object) str);
    }

    public static Object getStaticFieldValue(Class<?> cls, String str) {
        return getFieldValue(cls, null, str, true);
    }

    public static NameSpace getThisNS(Class<?> cls) {
        if (!isGeneratedClass(cls)) {
            return null;
        }
        try {
            return getClassStaticThis(cls, cls.getSimpleName()).namespace;
        } catch (Exception e) {
            if (e.getCause() instanceof UtilTargetError) {
                throw new InterpreterError(e.getCause().getCause().getMessage(), e.getCause().getCause());
            }
            return null;
        }
    }

    public static Class<?> getType(Object obj) {
        return Types.getType(obj);
    }

    public static Variable getVariable(Class<?> cls, String str) {
        return getVariable(getThisNS(cls), str);
    }

    public static String[] getVariableNames(NameSpace nameSpace) {
        return nameSpace == null ? new String[0]
                : (String[]) Stream.of((Object[]) nameSpace.getVariableNames()).filter(new ra(7)).toArray(new rb(14));
    }

    public static Variable[] getVariables(Class<?> cls) {
        return getVariables(getThisNS(cls));
    }

    public static boolean hasModifier(String str, int i) {
        return Modifier.toString(i).contains(str);
    }

    public static boolean hasObjectPropertyGetter(Class<?> cls, String str) {
        if (Types.isPropertyType(cls)) {
            return true;
        }
        ReferenceCache<Class<?>, BshClassManager.MemberCache> referenceCache = BshClassManager.memberCache;
        return referenceCache.get(cls).hasMember(str) && referenceCache.get(cls).findGetter(str) != null;
    }

    public static boolean hasObjectPropertySetter(Class<?> cls, String str) {
        if (Types.isPropertyType(cls)) {
            return true;
        }
        ReferenceCache<Class<?>, BshClassManager.MemberCache> referenceCache = BshClassManager.memberCache;
        return referenceCache.get(cls).hasMember(str) && referenceCache.get(cls).findSetter(str) != null;
    }

    public static Object invokeCompiledCommand(Class<?> cls, Object[] objArr, Interpreter interpreter,
            CallStack callStack, Node node) throws UtilEvalError {
        Object[] objArr2 = new Object[objArr.length + 2];
        objArr2[0] = interpreter;
        objArr2[1] = callStack;
        System.arraycopy(objArr, 0, objArr2, 2, objArr.length);
        try {
            return invokeStaticMethod(interpreter.getClassManager(), cls, "invoke", objArr2, node);
        } catch (ReflectError e) {
            throw new UtilEvalError("Error invoking compiled command: " + e, e);
        } catch (InvocationTargetException e2) {
            throw new UtilEvalError("Error in compiled command: " + e2.getCause(), e2);
        }
    }

    private static Object invokeMathMethod(Class<?> cls, Object obj, Class<?> cls2, String str, Object[] objArr,
            Interpreter interpreter, CallStack callStack, Node node) throws EvalError {
        Object objInvokeObjectMethod = invokeObjectMethod(Primitive.castWrapper(cls, obj), str, objArr, interpreter,
                callStack, node);
        return ((objInvokeObjectMethod instanceof Primitive) && ((Primitive) objInvokeObjectMethod).getType() == cls)
                ? Primitive.wrap(Primitive.castWrapper(cls2, objInvokeObjectMethod), cls2)
                : objInvokeObjectMethod;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v2 */
    public static Object invokeObjectMethod(Object obj, String str, Object[] objArr, Interpreter interpreter,
            CallStack callStack, Node node) throws EvalError {
        Object[] objArr2;
        Node node2;
        UtilEvalError utilEvalError;
        CallStack callStack2;
        String str2;
        String str3;
        Object obj2;
        Object[] objArr3;
        CallStack callStack3;
        Node node3;
        if ((obj instanceof This) && !This.isExposedThisMethod(str)) {
            return ((This) obj).invokeMethod(str, objArr, interpreter, callStack, node, false);
        }
        BshClassManager classManager = interpreter.getClassManager();
        boolean z = obj instanceof Primitive;
        try {
            Class<?> type = obj.getClass();
            if (z) {
                try {
                    if (str.equals("equals")) {
                        return Boolean.valueOf(((Primitive) obj).equals(objArr[0]));
                    }
                    if (obj != Primitive.NULL && obj != Primitive.VOID) {
                        type = ((Primitive) obj).getType();
                        obj = Primitive.unwrap(obj);
                    }
                    if (str.equals("getType") || str.equals("getClass")) {
                        return obj == Primitive.VOID ? ((Primitive) obj).getType() : type;
                    }
                } catch (UtilEvalError e) {
                    utilEvalError = e;
                    callStack2 = callStack;
                    node2 = node;
                    throw utilEvalError.toEvalError(node2, callStack2);
                }
            }
            node2 = null;
            objArr2 = objArr;
            Object obj3 = obj;
            Class<?> cls = type;
            try {
                Invocable invocableResolveExpectedJavaMethod = resolveExpectedJavaMethod(classManager, cls, obj3, str,
                        objArr2, false);
                str3 = "Attempt to invoke method: ";
                obj2 = obj3;
                str2 = str;
                objArr3 = objArr2;
                try {
                    NameSpace thisNS = getThisNS(obj2);
                    if (thisNS != null) {
                        thisNS.setNode(node);
                    }
                    return invocableResolveExpectedJavaMethod.invoke(obj2, objArr3);
                } catch (ReflectError e2) {
                    e = e2;
                    ReflectError reflectError = e;
                    try {
                        if (obj2 == Primitive.VOID) {
                            throw new EvalError(str3 + str2 + "() on undefined", node, callStack, reflectError);
                        }
                        if (!z || interpreter.getStrictJava()) {
                            callStack3 = callStack;
                            node3 = node;
                        } else {
                            try {
                                if (Types.isNumeric(obj2)) {
                                    callStack3 = callStack;
                                    node3 = node;
                                    try {
                                        return numericMathMethod(obj2, type, str2, objArr3, interpreter, callStack3,
                                                node3);
                                    } catch (TargetError e3) {
                                        e = e3;
                                        throw e;
                                    } catch (EvalError unused) {
                                        throw new EvalError("Error in method invocation: " + reflectError.getMessage(),
                                                node3, callStack3, reflectError);
                                    }
                                }
                                try {
                                    return invokeObjectMethod(obj2, str2, objArr3, interpreter, callStack, node);
                                } catch (TargetError e4) {
                                    e = e4;
                                    throw e;
                                } catch (EvalError unused2) {
                                    node3 = node;
                                    callStack3 = callStack;
                                    throw new EvalError("Error in method invocation: " + reflectError.getMessage(),
                                            node3, callStack3, reflectError);
                                } catch (UtilEvalError e5) {
                                    e = e5;
                                    node2 = node;
                                    objArr2 = callStack;
                                    utilEvalError = e;
                                    callStack2 = objArr2;
                                    throw utilEvalError.toEvalError(node2, callStack2);
                                }
                            } catch (TargetError e6) {
                                e = e6;
                            } catch (EvalError unused3) {
                                callStack3 = callStack;
                                node3 = node;
                                throw new EvalError("Error in method invocation: " + reflectError.getMessage(), node3,
                                        callStack3, reflectError);
                            }
                        }
                        throw new EvalError("Error in method invocation: " + reflectError.getMessage(), node3,
                                callStack3, reflectError);
                    } catch (UtilEvalError e7) {
                        e = e7;
                    }
                    utilEvalError = e;
                    callStack2 = objArr2;
                    throw utilEvalError.toEvalError(node2, callStack2);
                } catch (InvocationTargetException e8) {
                    e = e8;
                    throw targetErrorFromTargetException(e, str2, callStack, node);
                }
            } catch (ReflectError e9) {
                e = e9;
                str3 = "Attempt to invoke method: ";
                type = cls;
                obj2 = obj3;
                str2 = str;
                objArr3 = objArr2;
            } catch (InvocationTargetException e10) {
                e = e10;
                str2 = str;
            }
        } catch (UtilEvalError e11) {
            e = e11;
            objArr2 = callStack;
            node2 = node;
        }
    }

    public static Object invokeStaticMethod(BshClassManager bshClassManager, Class<?> cls, String str, Object[] objArr,
            Node node) {
        Interpreter.debug("invoke static Method");
        NameSpace thisNS = getThisNS(cls);
        if (thisNS != null) {
            thisNS.setNode(node);
        }
        return resolveExpectedJavaMethod(bshClassManager, cls, null, str, objArr, true).invoke(null, objArr);
    }

    public static boolean isGeneratedClass(Class<?> cls) {
        return (cls == null || cls == GeneratedClass.class || !GeneratedClass.class.isAssignableFrom(cls)) ? false
                : true;
    }

    public static boolean isPackageAccessible(Class<?> cls) {
        return Capabilities.haveAccessibility() || !PACKAGE_ACCESS.matcher(cls.getName()).matches();
    }

    public static boolean isPackageScope(Class<?> cls) {
        return DEFAULT_PACKAGE.matcher(cls.getName()).matches();
    }

    public static boolean isPrivate(Member member) {
        return Modifier.isPrivate(member.getModifiers());
    }

    public static boolean isPublic(Member member) {
        return Modifier.isPublic(member.getModifiers());
    }

    public static boolean isStatic(Member member) {
        return Modifier.isStatic(member.getModifiers());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Class[] lambda$constructObject$1(int i) {
        return new Class[i];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getEnumConstants$6(Class cls, Field field) {
        return field.getType() == cls;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$getEnumConstants$7(Field field) {
        try {
            return field.get(null);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object[] lambda$getEnumConstants$8(Class cls, int i) {
        return (Object[]) Array.newInstance((Class<?>) cls, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getVariableNames$2(String str) {
        return !str.matches("_?bsh.*");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String[] lambda$getVariableNames$3(int i) {
        return new String[i];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Variable[] lambda$getVariables$5(int i) {
        return new Variable[i];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$static$0(String str) {
        return !str.isEmpty();
    }

    public static void logInvokeMethod(String str, Invocable invocable, List<Object> list) {
        if (Interpreter.DEBUG.get().booleanValue()) {
            logInvokeMethod(str, invocable, list.toArray());
        }
    }

    private static Object numericMathMethod(Object obj, Class<?> cls, String str, Object[] objArr,
            Interpreter interpreter, CallStack callStack, Node node) throws EvalError {
        Class cls2 = Types.isFloatingpoint(obj) ? BigDecimal.class : BigInteger.class;
        try {
            return invokeMathMethod(cls2, obj, cls, str, objArr, interpreter, callStack, node);
        } catch (TargetError e) {
            throw e.reThrow("Method found on " + cls2.getSimpleName() + " but with error");
        } catch (EvalError unused) {
            return invokeMathMethod(Types.isFloatingpoint(obj) ? BigInteger.class : BigDecimal.class, obj, cls, str,
                    objArr, interpreter, callStack, node);
        }
    }

    public static Invocable resolveExpectedJavaField(Class<?> cls, String str, boolean z) throws UtilEvalError {
        Invocable invocableFindField = BshClassManager.memberCache.get(cls).findField(str);
        if (invocableFindField == null) {
            StringBuilder sbZ = StaticHelpers6.concatAndToSb("No such field: ", str, " for class: ");
            sbZ.append(cls.getName());
            throw new ReflectError(sbZ.toString());
        }
        if (!z || invocableFindField.isStatic()) {
            return invocableFindField;
        }
        StringBuilder sbZ2 = StaticHelpers6.concatAndToSb("Can't reach instance field: ", str, " from static context: ");
        sbZ2.append(cls.getName());
        throw new UtilEvalError(sbZ2.toString());
    }

    public static Invocable resolveExpectedJavaMethod(BshClassManager bshClassManager, Class<?> cls, Object obj,
            String str, Object[] objArr, boolean z) throws UtilEvalError {
        if (obj == Primitive.NULL) {
            throw new UtilTargetError(
                    new NullPointerException(concat("Attempt to invoke method ", str, " on null value")));
        }
        Class<?>[] types = Types.getTypes(objArr);
        Invocable invocableResolveJavaMethod = resolveJavaMethod(cls, str, types, z);
        if (bshClassManager != null && bshClassManager.getStrictJava() && invocableResolveJavaMethod != null
                && invocableResolveJavaMethod.getDeclaringClass().isInterface()
                && invocableResolveJavaMethod.getDeclaringClass() != cls
                && Modifier.isStatic(invocableResolveJavaMethod.getModifiers())) {
            invocableResolveJavaMethod = null;
        }
        if (invocableResolveJavaMethod != null) {
            return invocableResolveJavaMethod;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(z ? "Static method " : "Method ");
        sb.append(StringUtil.methodString(str, types));
        sb.append(" not found in class'");
        sb.append(cls.getName());
        sb.append("'");
        throw new ReflectError(sb.toString());
    }

    public static Invocable resolveJavaField(Class<?> cls, String str, boolean z) {
        try {
            return resolveExpectedJavaField(cls, str, z);
        } catch (ReflectError unused) {
            return null;
        }
    }

    public static Invocable resolveJavaMethod(Class<?> cls, String str, Class<?>[] clsArr, boolean z)
            throws UtilEvalError {
        if (cls == null) {
            throw new InterpreterError("null class");
        }
        Invocable invocableFindMethod = BshClassManager.memberCache.get(cls).findMethod(str, clsArr);
        Interpreter.debug("resolved java method: ", invocableFindMethod, " on class: ", cls);
        checkFoundStaticMethod(invocableFindMethod, z, cls);
        return invocableFindMethod;
    }

    public static Object setObjectProperty(Object obj, String str, Object obj2) {
        if (Types.isPropertyTypeEntry(obj)) {
            str.getClass();
            if (str.equals("val") || str.equals("value")) {
                return ((Map.Entry) obj).setValue(obj2);
            }
        }
        return setObjectProperty(obj, (Object) str, obj2);
    }

    public static BshMethod staticMethodImport(Class<?> cls, String str) {
        Invocable invocableFindStaticMethod = BshClassManager.memberCache.get(cls).findStaticMethod(str);
        if (invocableFindStaticMethod != null) {
            return new BshMethod(invocableFindStaticMethod, (Object) null);
        }
        return null;
    }

    public static TargetError targetErrorFromTargetException(InvocationTargetException invocationTargetException,
            String str, CallStack callStack, Node node) {
        String strK = yg.k("Method Invocation ", str);
        Throwable cause = invocationTargetException.getCause();
        boolean z = true;
        if ((cause instanceof EvalError)
                && (!(cause instanceof TargetError) || !((TargetError) cause).inNativeCode())) {
            z = false;
        }
        return new TargetError(strK, cause, node, callStack, z);
    }

    public static Object constructObject(Class<?> cls, Object obj, Object[] objArr) throws InvocationTargetException {
        if (cls == null) {
            return Primitive.NULL;
        }
        if (cls.isInterface()) {
            throw new ReflectError(concatVar2Var1(cls, "Can't create instance of an interface: "));
        }
        Class<?>[] types = Types.getTypes(objArr);
        if (cls.isMemberClass() && !isStatic(cls) && obj != null) {
            types = (Class[]) Stream.concat(Stream.of(obj.getClass()), Stream.of((Object[]) types)).toArray(new rb(12));
        }
        Interpreter.debug("Looking for most specific constructor: ", cls);
        Invocable invocableFindMethod = BshClassManager.memberCache.get(cls).findMethod(cls.getName(), types);
        if (invocableFindMethod == null || !(objArr.length == invocableFindMethod.getParameterCount()
                || invocableFindMethod.isVarArgs() || invocableFindMethod.isInnerClass())) {
            throw cantFindConstructor(cls, types);
        }
        try {
            return invocableFindMethod.invoke(obj, objArr);
        } catch (InvocationTargetException e) {
            if (!(e.getCause().getCause() instanceof IllegalAccessException)) {
                throw e;
            }
            throw new ReflectError("We don't have permission to create an instance. "
                    + e.getCause().getCause().getMessage() + " Use setAccessibility(true) to enable access.",
                    e.getCause().getCause());
        }
    }

    public static BshMethod getMethod(Object obj, String str, Class<?>[] clsArr) {
        return getMethod(getThisNS(obj), str, clsArr);
    }

    public static BshMethod[] getMethods(Object obj) {
        return getMethods(getThisNS(obj));
    }

    public static Variable getVariable(Object obj, String str) {
        return getVariable(getThisNS(obj), str);
    }

    public static Variable[] getVariables(Object obj) {
        return getVariables(getThisNS(obj));
    }

    public static boolean isPrivate(Class<?> cls) {
        return Modifier.isPrivate(cls.getModifiers());
    }

    public static boolean isPublic(Class<?> cls) {
        return Modifier.isPublic(cls.getModifiers());
    }

    public static boolean isStatic(Class<?> cls) {
        return Modifier.isStatic(cls.getModifiers());
    }

    public static BshMethod getMethod(NameSpace nameSpace, String str, Class<?>[] clsArr) {
        return getMethod(nameSpace, str, clsArr, true);
    }

    public static BshMethod[] getMethods(NameSpace nameSpace) {
        if (nameSpace == null) {
            return new BshMethod[0];
        }
        return nameSpace.getMethods();
    }

    public static Variable getVariable(NameSpace nameSpace, String str) {
        if (nameSpace == null) {
            return null;
        }
        try {
            return nameSpace.getVariableImpl(str, false);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Variable[] getVariables(NameSpace nameSpace) {
        return getVariables(nameSpace, getVariableNames(nameSpace));
    }

    public static void logInvokeMethod(String str, Invocable invocable, Object[] objArr) {
        if (Interpreter.DEBUG.get().booleanValue()) {
            Interpreter.debug(str, invocable, " with args:");
            for (int i = 0; i < objArr.length; i++) {
                Object obj = objArr[i];
                Interpreter.debug("args[", Integer.valueOf(i), "] = ", obj, " type = ",
                        obj == null ? "<unknown>" : obj.getClass());
            }
        }
    }

    public static BshMethod getMethod(NameSpace nameSpace, String str, Class<?>[] clsArr, boolean z) {
        if (nameSpace == null) {
            return null;
        }
        try {
            return nameSpace.getMethod(str, clsArr, z);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Variable[] getVariables(NameSpace nameSpace, String[] strArr) {
        if (nameSpace != null && strArr != null) {
            return (Variable[]) Stream.of((Object[]) strArr).map(new cpt(nameSpace, 4)).filter(new ra(5))
                    .toArray(new rb(13));
        }
        return new Variable[0];
    }

    public static Object setObjectProperty(Object obj, Object obj2, Object obj3) {
        if (Types.isPropertyTypeMap(obj)) {
            return ((Map) obj).put(obj2, Primitive.unwrap(obj3));
        }
        if (Types.isPropertyTypeEntry(obj)) {
            Map.Entry entry = (Map.Entry) obj;
            if (obj2.equals(entry.getKey())) {
                return entry.setValue(Primitive.unwrap(obj3));
            }
            throw new ReflectError("No such property setter: " + obj2 + " for type: " + StringUtil.typeString(obj));
        }
        Class<?> cls = obj.getClass();
        if (Types.isPropertyTypeEntryList(cls)) {
            return getEntryForKey(obj2, (Map.Entry[]) obj).setValue(Primitive.unwrap(obj3));
        }
        if (obj instanceof Class) {
            cls = (Class) obj;
        }
        Invocable invocableFindSetter = BshClassManager.memberCache.get(cls).findSetter(obj2.toString());
        if (invocableFindSetter != null) {
            try {
                return invocableFindSetter.invoke(obj, Primitive.unwrap(obj3));
            } catch (InvocationTargetException e) {
                throw new ReflectError("Property accessor threw exception: " + e.getCause(), e.getCause());
            }
        }
        throw new ReflectError("No such property setter: " + obj2 + " for type: " + StringUtil.typeString(cls));
    }

    public static Object getObjectProperty(Object obj, Object obj2) {
        if (Types.isPropertyTypeMap(obj)) {
            Map map = (Map) obj;
            if (map.containsKey(obj2)) {
                return map.get(obj2);
            }
            return Primitive.VOID;
        }
        if (Types.isPropertyTypeEntry(obj)) {
            Map.Entry entry = (Map.Entry) obj;
            if (obj2.equals(entry.getKey())) {
                return entry.getValue();
            }
            return Primitive.VOID;
        }
        Class<?> cls = obj.getClass();
        if (Types.isPropertyTypeEntryList(cls)) {
            Map.Entry entryForKey = getEntryForKey(obj2, (Map.Entry[]) obj);
            if (entryForKey != null) {
                return entryForKey.getValue();
            }
            return Primitive.VOID;
        }
        if (obj instanceof Class) {
            cls = (Class) obj;
        }
        Invocable invocableFindGetter = BshClassManager.memberCache.get(cls).findGetter(obj2.toString());
        if (invocableFindGetter == null) {
            Interpreter.debug("property getter not found");
            return Primitive.VOID;
        }
        try {
            return invocableFindGetter.invoke(obj, new Object[0]);
        } catch (InvocationTargetException unused) {
            Interpreter.debug("Property accessor threw exception");
            return Primitive.VOID;
        }
    }

    public static NameSpace getThisNS(Object obj) {
        if (obj == null) {
            return null;
        }
        Class<?> cls = obj.getClass();
        if (!isGeneratedClass(cls)) {
            return null;
        }
        try {
            if (obj instanceof Proxy) {
                return getThisNS(cls.getInterfaces()[0]);
            }
            return getClassInstanceThis(obj, cls.getSimpleName()).namespace;
        } catch (Exception unused) {
            return null;
        }
    }
}
