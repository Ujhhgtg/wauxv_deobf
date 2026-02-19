package me.hd.wauxv.obf;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ReflectionWrapper {
    public static final ConcurrentHashMap cachedConstructors = new ConcurrentHashMap();

    public static final Class tryGetClassByName(ClassLoader classLoader, String str) {
        if (classLoader == null) {
            classLoader = null;
        }
        Class<?> cls = classLoader != null ? Class.forName(str, false, classLoader) : Class.forName(str);
        if (cls != null) {
            return cls;
        }
        throw new IllegalStateException(("JVM class not resolved: " + str).toString());
    }

    public static final Object createInstanceWithArgs(Class cls, final Object[] objArr) {
        if (objArr.length != 0) {
            int length = objArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    throw new IllegalStateException(
                            ("Not allowed to create an instance with all null arguments for " + cls + ".").toString());
                }
                if (objArr[i] != null) {
                    break;
                }
                i++;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(cls.getName());
        sb.append('|');
        int length2 = objArr.length;
        for (int i2 = 0; i2 < length2; i2++) {
            Object obj = objArr[i2];
            sb.append(obj != null ? obj.getClass().getName() : "null");
            sb.append('|');
        }
        sb.append("isPublic: true");
        String string = sb.toString();
        ConcurrentHashMap concurrentHashMap = cachedConstructors;
        Constructor constructor = (Constructor) concurrentHashMap.get(string);
        if (constructor != null) {
            return d(constructor, objArr);
        }
        final int i3 = 0;
        final int i4 = 1;
        Constructor constructor2 = (Constructor) dfv
                .ah(new bae(new bae(new bae(SomeStaticHelpers.b(cls.getDeclaredConstructors()), true, new ws(23)), true, new IInvokable() { // from
                                                                                                                      // class:
                                                                                                                      // me.hd.wauxv.obf.ze
                    @Override // me.hd.wauxv.obf.bgf
                    public final Object invoke(Object obj2) {
                        Constructor constructor3 = (Constructor) obj2;
                        switch (i3) {
                            case 0:
                                return Boolean.valueOf(constructor3.getParameterCount() == objArr.length);
                            default:
                                Class<?>[] parameterTypes = constructor3.getParameterTypes();
                                throwIfVar1IsNull(parameterTypes, "<this>");
                                Object[] objArr2 = objArr;
                                throwIfVar1IsNull(objArr2, "other");
                                int iMin = Math.min(parameterTypes.length, objArr2.length);
                                ArrayList<Pair> arrayList = new ArrayList(iMin);
                                boolean z = false;
                                for (int i5 = 0; i5 < iMin; i5++) {
                                    arrayList.add(new Pair(parameterTypes[i5], objArr2[i5]));
                                }
                                if (arrayList.isEmpty()) {
                                    z = true;
                                } else {
                                    for (Pair pairVar : arrayList) {
                                        Class cls2 = (Class) pairVar.first;
                                        Object obj3 = pairVar.second;
                                        if (obj3 != null || cls2.isPrimitive()) {
                                            if (obj3 != null) {
                                                Class<?> cls3 = obj3.getClass();
                                                if (nullSafeIsEqual(cls2, Boolean.TYPE)) {
                                                    cls2 = Boolean.class;
                                                } else if (nullSafeIsEqual(cls2, Byte.TYPE)) {
                                                    cls2 = Byte.class;
                                                } else if (nullSafeIsEqual(cls2, Character.TYPE)) {
                                                    cls2 = Character.class;
                                                } else if (nullSafeIsEqual(cls2, Short.TYPE)) {
                                                    cls2 = Short.class;
                                                } else if (nullSafeIsEqual(cls2, Integer.TYPE)) {
                                                    cls2 = Integer.class;
                                                } else if (nullSafeIsEqual(cls2, Long.TYPE)) {
                                                    cls2 = Long.class;
                                                } else if (nullSafeIsEqual(cls2, Float.TYPE)) {
                                                    cls2 = Float.class;
                                                } else if (nullSafeIsEqual(cls2, Double.TYPE)) {
                                                    cls2 = Double.class;
                                                } else if (nullSafeIsEqual(cls2, Void.TYPE)) {
                                                    cls2 = Void.class;
                                                }
                                                if (cls2.isAssignableFrom(cls3)) {
                                                }
                                            }
                                        }
                                    }
                                    z = true;
                                }
                                return Boolean.valueOf(z);
                        }
                    }
                }), true, new IInvokable() { // from class: me.hd.wauxv.obf.ze
                    @Override // me.hd.wauxv.obf.bgf
                    public final Object invoke(Object obj2) {
                        Constructor constructor3 = (Constructor) obj2;
                        switch (i4) {
                            case 0:
                                return Boolean.valueOf(constructor3.getParameterCount() == objArr.length);
                            default:
                                Class<?>[] parameterTypes = constructor3.getParameterTypes();
                                throwIfVar1IsNull(parameterTypes, "<this>");
                                Object[] objArr2 = objArr;
                                throwIfVar1IsNull(objArr2, "other");
                                int iMin = Math.min(parameterTypes.length, objArr2.length);
                                ArrayList<Pair> arrayList = new ArrayList(iMin);
                                boolean z = false;
                                for (int i5 = 0; i5 < iMin; i5++) {
                                    arrayList.add(new Pair(parameterTypes[i5], objArr2[i5]));
                                }
                                if (arrayList.isEmpty()) {
                                    z = true;
                                } else {
                                    for (Pair pairVar : arrayList) {
                                        Class cls2 = (Class) pairVar.first;
                                        Object obj3 = pairVar.second;
                                        if (obj3 != null || cls2.isPrimitive()) {
                                            if (obj3 != null) {
                                                Class<?> cls3 = obj3.getClass();
                                                if (nullSafeIsEqual(cls2, Boolean.TYPE)) {
                                                    cls2 = Boolean.class;
                                                } else if (nullSafeIsEqual(cls2, Byte.TYPE)) {
                                                    cls2 = Byte.class;
                                                } else if (nullSafeIsEqual(cls2, Character.TYPE)) {
                                                    cls2 = Character.class;
                                                } else if (nullSafeIsEqual(cls2, Short.TYPE)) {
                                                    cls2 = Short.class;
                                                } else if (nullSafeIsEqual(cls2, Integer.TYPE)) {
                                                    cls2 = Integer.class;
                                                } else if (nullSafeIsEqual(cls2, Long.TYPE)) {
                                                    cls2 = Long.class;
                                                } else if (nullSafeIsEqual(cls2, Float.TYPE)) {
                                                    cls2 = Float.class;
                                                } else if (nullSafeIsEqual(cls2, Double.TYPE)) {
                                                    cls2 = Double.class;
                                                } else if (nullSafeIsEqual(cls2, Void.TYPE)) {
                                                    cls2 = Void.class;
                                                }
                                                if (cls2.isAssignableFrom(cls3)) {
                                                }
                                            }
                                        }
                                    }
                                    z = true;
                                }
                                return Boolean.valueOf(z);
                        }
                    }
                }));
        Constructor constructor3 = null;
        if (constructor2 == null) {
            constructor2 = null;
        } else if (!constructor2.isAccessible()) {
            constructor2.setAccessible(true);
        }
        if (constructor2 != null) {
            concurrentHashMap.put(string, constructor2);
            constructor3 = constructor2;
        }
        return d(constructor3, objArr);
    }

    public static final Object d(Constructor constructor, Object[] objArr) {
        Object objNewInstance = constructor != null ? constructor.newInstance(Arrays.copyOf(objArr, objArr.length))
                : null;
        Object obj = objNewInstance != null ? objNewInstance : null;
        if (obj != null) {
            return obj;
        }
        String strU = SomeStaticHelpers.joinToString(objArr, null, null, null, null, 63);
        if (dnj.ak(strU)) {
            strU = "(empty)";
        }
        throw new NoSuchMethodError("Could not find a suitable constructor for " + constructor + " with arguments: "
                + ((Object) strU) + ".");
    }

    public static Object e(Class cls, Object[] objArr) {
        Object objX;
        try {
            objX = createInstanceWithArgs(cls, Arrays.copyOf(objArr, objArr.length));
        } catch (Throwable th) {
            objX = FastKV.getFailureFromException(th);
        }
        if (objX instanceof Failure) {
            return null;
        }
        return objX;
    }

    public static Class f(String str, int i, ClassLoader classLoader) {
        Object objX;
        if ((i & 1) != 0) {
            classLoader = null;
        }
        try {
            objX = tryGetClassByName(classLoader, str);
        } catch (Throwable th) {
            objX = FastKV.getFailureFromException(th);
        }
        return (Class) (objX instanceof Failure ? null : objX);
    }

    public static final boolean g(ClassLoader classLoader, String str) {
        Object objX;
        try {
            objX = classLoader.loadClass(str);
            if (objX == null) {
                objX = null;
            }
        } catch (Throwable th) {
            objX = FastKV.getFailureFromException(th);
        }
        return ((Class) (objX instanceof Failure ? null : objX)) != null;
    }

    public static FactoryPools h(String str, amd amdVar, int i) {
        if ((i & 4) != 0) {
            amdVar = null;
        }
        return new FactoryPools(str, amdVar);
    }
}
