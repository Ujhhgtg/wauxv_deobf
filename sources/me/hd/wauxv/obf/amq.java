package me.hd.wauxv.obf;

import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.pool.TypePool;
import org.luckypray.dexkit.util.NativeReflect;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class amq {
    public final String a;
    public final String b;
    public final ArrayList c;
    public final String d;
    public final dov e;

    public amq(String str) {
        int i;
        throwIfVar1IsNull(str, "descriptor");
        this.e = new dov(new bp(this, 17));
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
        this.a = ams.f(strSubstring);
        String strSubstring2 = str.substring(iAi + 2, iAi2);
        throwIfVar1IsNull(strSubstring2, "substring(...)");
        this.b = strSubstring2;
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
        this.c = arrayList;
        String strSubstring5 = str.substring(iAi3 + 1);
        throwIfVar1IsNull(strSubstring5, "substring(...)");
        this.d = ams.f(strSubstring5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /*
     * JADX WARN: Type inference failed for: r6v5, types: [java.lang.reflect.Method]
     */
    /* JADX WARN: Type inference failed for: r6v9 */
    public static Method f(amq amqVar, ClassLoader classLoader) throws NoSuchMethodException {
        Object objX;
        Object objX2;
        dov dovVar = amqVar.e;
        chm chmVar = bpv.a;
        String str = amqVar.b;
        if (nullSafeIsEqual(str, MethodDescription.TYPE_INITIALIZER_INTERNAL_NAME)
                || nullSafeIsEqual(str, MethodDescription.CONSTRUCTOR_INTERNAL_NAME)) {
            throw new IllegalArgumentException((amqVar + " not a method").toString());
        }
        Class clsC = bpv.c(classLoader, amqVar.a);
        Object objD = bpv.d(classLoader, amqVar.c);
        Throwable thB = dcy.b(objD);
        if (thB != null) {
            NoSuchMethodException noSuchMethodException = new NoSuchMethodException(
                    "Method " + amqVar + " not available: parameter type(s) missing");
            noSuchMethodException.initCause(thB);
            throw noSuchMethodException;
        }
        Class[] clsArr = (Class[]) objD;
        try {
            objX = bpv.c(classLoader, amqVar.d);
        } catch (Throwable th) {
            objX = bhu.x(th);
        }
        Throwable thB2 = dcy.b(objX);
        if (thB2 != null) {
            NoSuchMethodException noSuchMethodException2 = new NoSuchMethodException(
                    "Method " + amqVar + " not available: return type missing");
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
                                    && nullSafeIsEqual((String) dovVar.getValue(), ams.d(method))) {
                                method.setAccessible(true);
                                bool = method;
                                return bool;
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
                Member reflectedMethod = NativeReflect.getReflectedMethod(clsC, str, (String) dovVar.getValue(), bool);
                if (reflectedMethod != null) {
                    Method method2 = (Method) reflectedMethod;
                    method2.setAccessible(true);
                    return method2;
                }
                throw new NoSuchMethodException("Method " + amqVar + " not found");
            }
            try {
                Method declaredMethod = superclass.getDeclaredMethod(str,
                        (Class[]) Arrays.copyOf(clsArr, clsArr.length));
                declaredMethod.setAccessible(true);
                objX2 = declaredMethod;
            } catch (Throwable th2) {
                objX2 = bhu.x(th2);
            }
            Method method3 = (Method) (objX2 instanceof dcx ? null : objX2);
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
        if (!(obj instanceof amq)) {
            return false;
        }
        amq amqVar = (amq) obj;
        return nullSafeIsEqual(this.a, amqVar.a) && nullSafeIsEqual(this.b, amqVar.b)
                && nullSafeIsEqual(this.c, amqVar.c) && nullSafeIsEqual(this.d, amqVar.d);
    }

    /* JADX WARN: Found duplicated region for block: B:26:0x007b */
    /* JADX WARN: Found duplicated region for block: B:28:0x0081 */
    public final Constructor g(ClassLoader classLoader) throws NoSuchMethodException {
        Object objX;
        Member reflectedMethod;
        Constructor<?>[] declaredConstructors;
        int i;
        dov dovVar = this.e;
        chm chmVar = bpv.a;
        String str = this.b;
        if (!nullSafeIsEqual(str, MethodDescription.CONSTRUCTOR_INTERNAL_NAME)) {
            throw new IllegalArgumentException((this + " not a constructor").toString());
        }
        Class clsC = bpv.c(classLoader, this.a);
        Object objD = bpv.d(classLoader, this.c);
        Throwable thB = dcy.b(objD);
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
            objX = bhu.x(th);
        }
        boolean z = objX instanceof dcx;
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
            String str2 = (String) dovVar.getValue();
            throwIfVar1IsNull(constructor2);
            if (nullSafeIsEqual(str2, ams.c(constructor2))) {
                constructor2.setAccessible(true);
                return constructor2;
            }
            reflectedMethod = NativeReflect.getReflectedMethod(clsC, str, (String) dovVar.getValue(), Boolean.FALSE);
            if (reflectedMethod != null) {
                Constructor constructor3 = (Constructor) reflectedMethod;
                constructor3.setAccessible(true);
                return constructor3;
            }
            throw new NoSuchMethodException("Constructor " + this + " not found");
        }
        reflectedMethod = NativeReflect.getReflectedMethod(clsC, str, (String) dovVar.getValue(), Boolean.FALSE);
        if (reflectedMethod != null) {
            Constructor constructor32 = (Constructor) reflectedMethod;
            constructor32.setAccessible(true);
            return constructor32;
        }
        throw new NoSuchMethodException("Constructor " + this + " not found");
    }

    public final int hashCode() {
        return this.d.hashCode() + (this.c.hashCode() * 31) + (this.b.hashCode() * 31) + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return ams.h(this.a) + "->" + this.b + ((String) this.e.getValue());
    }
}
