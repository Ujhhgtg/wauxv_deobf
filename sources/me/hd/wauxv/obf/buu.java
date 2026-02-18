package me.hd.wauxv.obf;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import net.bytebuddy.pool.TypePool;
import net.bytebuddy.utility.JavaConstant;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class buu {
    public static final HashMap a = new HashMap();
    public static final HashMap b = new HashMap();

    public static void c(Constructor constructor, buo buoVar) {
        try {
            throwIfVar1IsNull(constructor.newInstance(buoVar));
            throw new ClassCastException();
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e2) {
            throw new RuntimeException(e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    /* JADX WARN: Found duplicated region for block: B:61:0x010f */
    /* JADX WARN: Found duplicated region for block: B:66:0x011f */
    /* JADX WARN: Found duplicated region for block: B:72:0x012d A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:73:0x012f */
    /* JADX WARN: Found duplicated region for block: B:76:0x0143 */
    /* JADX WARN: Found duplicated region for block: B:86:0x0123 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:88:0x0148 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:90:0x0109 A[SYNTHETIC] */
    public static int d(Class cls) {
        Constructor<?> declaredConstructor;
        boolean zBooleanValue;
        z zVarAe;
        Class cls2;
        HashMap map = a;
        Integer num = (Integer) map.get(cls);
        if (num != null) {
            return num.intValue();
        }
        int i = 1;
        if (cls.getCanonicalName() != null) {
            ArrayList arrayList = null;
            try {
                Package r3 = cls.getPackage();
                String canonicalName = cls.getCanonicalName();
                String name = r3 != null ? r3.getName() : "";
                throwIfVar1IsNull(name);
                if (name.length() != 0) {
                    throwIfVar1IsNull(canonicalName);
                    canonicalName = canonicalName.substring(name.length() + 1);
                    throwIfVar1IsNull(canonicalName, "substring(...)");
                }
                throwIfVar1IsNull(canonicalName);
                String strConcat = dnr.bo(canonicalName, ".", JavaConstant.Dynamic.DEFAULT_NAME)
                        .concat("_LifecycleAdapter");
                if (name.length() != 0) {
                    strConcat = name + TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH
                            + strConcat;
                }
                declaredConstructor = Class.forName(strConcat).getDeclaredConstructor(cls);
                if (!declaredConstructor.isAccessible()) {
                    declaredConstructor.setAccessible(true);
                }
            } catch (ClassNotFoundException unused) {
                declaredConstructor = null;
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
            HashMap map2 = b;
            if (declaredConstructor != null) {
                map2.put(cls, dqc.bf(declaredConstructor));
            } else {
                zi ziVar = zi.a;
                HashMap map3 = ziVar.c;
                Boolean bool = (Boolean) map3.get(cls);
                if (bool != null) {
                    zBooleanValue = bool.booleanValue();
                } else {
                    try {
                        Method[] declaredMethods = cls.getDeclaredMethods();
                        int length = declaredMethods.length;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= length) {
                                map3.put(cls, Boolean.FALSE);
                                zBooleanValue = false;
                                break;
                            }
                            if (((cqy) declaredMethods[i2].getAnnotation(cqy.class)) != null) {
                                ziVar.e(cls, declaredMethods);
                                zBooleanValue = true;
                                break;
                            }
                            i2++;
                        }
                    } catch (NoClassDefFoundError e2) {
                        throw new IllegalArgumentException(
                                "The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.",
                                e2);
                    }
                }
                if (!zBooleanValue) {
                    Class superclass = cls.getSuperclass();
                    if (superclass != null && buo.class.isAssignableFrom(superclass)) {
                        throwIfVar1IsNull(superclass);
                        if (d(superclass) != 1) {
                            Object obj = map2.get(superclass);
                            throwIfVar1IsNull(obj);
                            arrayList = new ArrayList((Collection) obj);
                            zVarAe = cnb.ae(cls.getInterfaces());
                            while (zVarAe.hasNext()) {
                                cls2 = (Class) zVarAe.next();
                                if (!(cls2 == null && buo.class.isAssignableFrom(cls2))) {
                                    throwIfVar1IsNull(cls2);
                                    if (d(cls2) == 1) {
                                        if (arrayList == null) {
                                            arrayList = new ArrayList();
                                        }
                                        Object obj2 = map2.get(cls2);
                                        throwIfVar1IsNull(obj2);
                                        arrayList.addAll((Collection) obj2);
                                    }
                                }
                            }
                            if (arrayList != null) {
                                map2.put(cls, arrayList);
                            }
                        }
                    } else {
                        zVarAe = cnb.ae(cls.getInterfaces());
                        while (zVarAe.hasNext()) {
                            cls2 = (Class) zVarAe.next();
                            if (!(cls2 == null && buo.class.isAssignableFrom(cls2))) {
                                throwIfVar1IsNull(cls2);
                                if (d(cls2) == 1) {
                                    if (arrayList == null) {
                                        arrayList = new ArrayList();
                                    }
                                    Object obj22 = map2.get(cls2);
                                    throwIfVar1IsNull(obj22);
                                    arrayList.addAll((Collection) obj22);
                                }
                            }
                        }
                        if (arrayList != null) {
                            map2.put(cls, arrayList);
                        }
                    }
                }
            }
            i = 2;
        }
        map.put(cls, Integer.valueOf(i));
        return i;
    }
}
