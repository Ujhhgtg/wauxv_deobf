package me.hd.wauxv.obf;

import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import net.bytebuddy.description.method.MethodDescription;
import org.luckypray.dexkit.util.NativeReflect;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class MethodDesc {
    public final String declaringClass;
    public final String methodName;
    public final ArrayList parameterTypes;
    public final String returnType;
    public final Kotlin$Lazy e;

    public MethodDesc(String str) {
        int i;
        throwIfVar1IsNull(str, "descriptor");
        this.e = new Kotlin$Lazy(new bp(this, 17));
        int iAh = 0;
        int iAi = dnj.ai(str, "->", 0, false, 6);
        int iAi2 = dnj.ai(str, "(", iAi + 1, false, 4);
        int i2 = iAi2 + 1;
        int iAi3 = dnj.ai(str, ")", i2, false, 4);
        if (iAi == -1 || iAi2 == -1 || iAi3 == -1) {
            throw new IllegalAccessError("not method descriptor: ".concat(str));
        }
        String strSubstring = str.substring(0, iAi);
        throwIfVar1IsNull(strSubstring, "substring(...)");
        this.declaringClass = ams.f(strSubstring);
        String strSubstring2 = str.substring(iAi + 2, iAi2);
        throwIfVar1IsNull(strSubstring2, "substring(...)");
        this.methodName = strSubstring2;
        String strSubstring3 = str.substring(i2, iAi3);
        throwIfVar1IsNull(strSubstring3, "substring(...)");
        ArrayList arrayList = new ArrayList();
        loop0: while (true) {
            i = iAh;
            while (true) {
                if (iAh >= strSubstring3.length()) {
                    break loop0;
                }
                char cCharAt = strSubstring3.charAt(iAh);
                if (cCharAt == 'L') {
                    iAh = dnj.ah(';', iAh, 4,
                            strSubstring3);
                    break;
                } else if (cCharAt != '[') {
                    break;
                } else {
                    iAh++;
                }
            }
            iAh++;
            String strSubstring4 = strSubstring3.substring(i, iAh);
            throwIfVar1IsNull(strSubstring4, "substring(...)");
            arrayList.add(ams.f(strSubstring4));
        }
        if (i != iAh) {
            throw new IllegalStateException("Unknown signString: ".concat(strSubstring3));
        }
        this.parameterTypes = arrayList;
        String strSubstring5 = str.substring(iAi3 + 1);
        throwIfVar1IsNull(strSubstring5, "substring(...)");
        this.returnType = ams.f(strSubstring5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /*
     * JADX WARN: Type inference failed for: r6v5, types: [java.lang.reflect.Method]
     */
    /* JADX WARN: Type inference failed for: r6v9 */
    public static Method resolveMethod(MethodDesc methodDescVar, ClassLoader classLoader) throws NoSuchMethodException {
        Object objX;
        Object objX2;
        Kotlin$Lazy kotlin$LazyVar = methodDescVar.e;
        String str = methodDescVar.methodName;
        if (nullSafeIsEqual(str, MethodDescription.TYPE_INITIALIZER_INTERNAL_NAME)
                || nullSafeIsEqual(str, MethodDescription.CONSTRUCTOR_INTERNAL_NAME)) {
            throw new IllegalArgumentException((methodDescVar + " not a method").toString());
        }
        Class clsC = TypeResolver.loadType(classLoader, methodDescVar.declaringClass);
        Object objD = TypeResolver.loadParameterTypes(classLoader, methodDescVar.parameterTypes);
        Throwable thB = Success.exceptionOrNull(objD);
        if (thB != null) {
            NoSuchMethodException noSuchMethodException = new NoSuchMethodException(
                    "Method " + methodDescVar + " not available: parameter type(s) missing");
            noSuchMethodException.initCause(thB);
            throw noSuchMethodException;
        }
        Class[] clsArr = (Class[]) objD;
        try {
            objX = TypeResolver.loadType(classLoader, methodDescVar.returnType);
        } catch (Throwable th) {
            objX = FastKV.getFailureFromException(th);
        }
        Throwable thB2 = Success.exceptionOrNull(objX);
        if (thB2 != null) {
            NoSuchMethodException noSuchMethodException2 = new NoSuchMethodException(
                    "Method " + methodDescVar + " not available: return type missing");
            noSuchMethodException2.initCause(thB2);
            throw noSuchMethodException2;
        }
        Class cls = (Class) objX;
        Class superclass = clsC;
        while (true) {
            Boolean bool = 0;
            bool = 0;
            if (superclass == null) {
                for (Class superclass2 = clsC; superclass2 != null; superclass2 = superclass2.getSuperclass()) {
                    try {
                        Method[] declaredMethods = superclass2.getDeclaredMethods();
                        throwIfVar1IsNull(declaredMethods, "getDeclaredMethods(...)");
                        for (Method method : declaredMethods) {
                            if (nullSafeIsEqual(method.getName(), str)
                                    && nullSafeIsEqual((String) kotlin$LazyVar.getValue(), ams.d(method))) {
                                method.setAccessible(true);
                                bool = method;
                                return bool;
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
                Member reflectedMethod = NativeReflect.getReflectedMethod(clsC, str, (String) kotlin$LazyVar.getValue(), bool);
                if (reflectedMethod != null) {
                    Method method2 = (Method) reflectedMethod;
                    method2.setAccessible(true);
                    return method2;
                }
                throw new NoSuchMethodException("Method " + methodDescVar + " not found");
            }
            try {
                Method declaredMethod = superclass.getDeclaredMethod(str,
                        (Class[]) Arrays.copyOf(clsArr, clsArr.length));
                declaredMethod.setAccessible(true);
                objX2 = declaredMethod;
            } catch (Throwable th2) {
                objX2 = FastKV.getFailureFromException(th2);
            }
            Method method3 = (Method) (objX2 instanceof Failure ? null : objX2);
            if (method3 != null && nullSafeIsEqual(method3.getReturnType(), cls)) {
                return method3;
            }
            superclass = superclass.getSuperclass();
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MethodDesc)) {
            return false;
        }
        MethodDesc methodDescVar = (MethodDesc) obj;
        return nullSafeIsEqual(this.declaringClass, methodDescVar.declaringClass) && nullSafeIsEqual(this.methodName, methodDescVar.methodName)
                && nullSafeIsEqual(this.parameterTypes, methodDescVar.parameterTypes) && nullSafeIsEqual(this.returnType, methodDescVar.returnType);
    }

    /* JADX WARN: Found duplicated region for block: B:26:0x007b */
    /* JADX WARN: Found duplicated region for block: B:28:0x0081 */
    public final Constructor resolveConstructor(ClassLoader classLoader) throws NoSuchMethodException {
        Object objX;
        Member reflectedMethod;
        Constructor<?>[] declaredConstructors;
        int i;
        Kotlin$Lazy kotlin$LazyVar = this.e;
        chm chmVar = TypeResolver.globalCache;
        String str = this.methodName;
        if (!nullSafeIsEqual(str, MethodDescription.CONSTRUCTOR_INTERNAL_NAME)) {
            throw new IllegalArgumentException((this + " not a constructor").toString());
        }
        Class clsC = TypeResolver.loadType(classLoader, this.declaringClass);
        Object objD = TypeResolver.loadParameterTypes(classLoader, this.parameterTypes);
        Throwable thB = Success.exceptionOrNull(objD);
        if (thB != null) {
            NoSuchMethodException noSuchMethodException = new NoSuchMethodException(
                    "Constructor " + this + " not available: parameter type(s) missing");
            noSuchMethodException.initCause(thB);
            throw noSuchMethodException;
        }
        Class[] clsArr = (Class[]) objD;
        try {
            Constructor declaredConstructor = clsC
                    .getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr, clsArr.length));
            declaredConstructor.setAccessible(true);
            objX = declaredConstructor;
        } catch (Throwable th) {
            objX = FastKV.getFailureFromException(th);
        }
        boolean z = objX instanceof Failure;
        Object obj = objX;
        if (z) {
            obj = null;
        }
        Constructor constructor = (Constructor) obj;
        if (constructor != null) {
            return constructor;
        }
        try {
            declaredConstructors = clsC.getDeclaredConstructors();
            throwIfVar1IsNull(declaredConstructors, "getDeclaredConstructors(...)");
        } catch (Throwable unused) {
        }
        for (Constructor<?> constructor2 : declaredConstructors) {
            String str2 = (String) kotlin$LazyVar.getValue();
            throwIfVar1IsNull(constructor2);
            if (nullSafeIsEqual(str2, ams.c(constructor2))) {
                constructor2.setAccessible(true);
                return constructor2;
            }
            reflectedMethod = NativeReflect.getReflectedMethod(clsC, str, (String) kotlin$LazyVar.getValue(), Boolean.FALSE);
            if (reflectedMethod != null) {
                Constructor constructor3 = (Constructor) reflectedMethod;
                constructor3.setAccessible(true);
                return constructor3;
            }
            throw new NoSuchMethodException("Constructor " + this + " not found");
        }
        reflectedMethod = NativeReflect.getReflectedMethod(clsC, str, (String) kotlin$LazyVar.getValue(), Boolean.FALSE);
        if (reflectedMethod != null) {
            Constructor constructor32 = (Constructor) reflectedMethod;
            constructor32.setAccessible(true);
            return constructor32;
        }
        throw new NoSuchMethodException("Constructor " + this + " not found");
    }

    public final int hashCode() {
        return this.returnType.hashCode() + (this.parameterTypes.hashCode() * 31) + (this.methodName.hashCode() * 31) + (this.declaringClass.hashCode() * 31);
    }

    public final String toString() {
        return ams.h(this.declaringClass) + "->" + this.methodName + ((String) this.e.getValue());
    }
}
