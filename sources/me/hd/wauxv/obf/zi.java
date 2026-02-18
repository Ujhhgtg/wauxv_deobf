package me.hd.wauxv.obf;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class zi {
    public static final zi a = new zi();
    public final HashMap b = new HashMap();
    public final HashMap c = new HashMap();

    public static void d(HashMap map, zh zhVar, bug bugVar, Class cls) {
        bug bugVar2 = (bug) map.get(zhVar);
        if (bugVar2 == null || bugVar == bugVar2) {
            if (bugVar2 == null) {
                map.put(zhVar, bugVar);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Method " + zhVar.b.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + bugVar2 + ", new value " + bugVar);
    }

    public final zg e(Class cls, Method[] methodArr) {
        int i;
        Class superclass = cls.getSuperclass();
        HashMap map = new HashMap();
        HashMap map2 = this.b;
        if (superclass != null) {
            zg zgVarE = (zg) map2.get(superclass);
            if (zgVarE == null) {
                zgVarE = e(superclass, null);
            }
            map.putAll(zgVarE.b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            zg zgVarE2 = (zg) map2.get(cls2);
            if (zgVarE2 == null) {
                zgVarE2 = e(cls2, null);
            }
            for (Map.Entry entry : zgVarE2.b.entrySet()) {
                d(map, (zh) entry.getKey(), (bug) entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            try {
                methodArr = cls.getDeclaredMethods();
            } catch (NoClassDefFoundError e) {
                throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e);
            }
        }
        boolean z = false;
        for (Method method : methodArr) {
            cqy cqyVar = (cqy) method.getAnnotation(cqy.class);
            if (cqyVar != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i = 0;
                } else {
                    if (!bup.class.isAssignableFrom(parameterTypes[0])) {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                    i = 1;
                }
                bug bugVarValue = cqyVar.value();
                if (parameterTypes.length > 1) {
                    if (!bug.class.isAssignableFrom(parameterTypes[1])) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if (bugVarValue != bug.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    i = 2;
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                d(map, new zh(method, i), bugVarValue, cls);
                z = true;
            }
        }
        zg zgVar = new zg(map);
        map2.put(cls, zgVar);
        this.c.put(cls, Boolean.valueOf(z));
        return zgVar;
    }
}
