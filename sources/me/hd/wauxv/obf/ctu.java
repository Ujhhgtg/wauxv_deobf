package me.hd.wauxv.obf;

import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ctu {
    public static final Method a;

    static {
        Method method;
        Method[] methods = Throwable.class.getMethods();
        throwIfVar1IsNull(methods);
        int length = methods.length;
        int i = 0;
        while (true) {
            method = null;
            if (i >= length) {
                break;
            }
            Method method2 = methods[i];
            if (nullSafeIsEqual(method2.getName(), "addSuppressed")) {
                Class<?>[] parameterTypes = method2.getParameterTypes();
                throwIfVar1IsNull(parameterTypes, "getParameterTypes(...)");
                if (nullSafeIsEqual(parameterTypes.length == 1 ? parameterTypes[0] : null, Throwable.class)) {
                    method = method2;
                    break;
                }
            }
            i++;
        }
        a = method;
        int length2 = methods.length;
        for (int i2 = 0; i2 < length2 && !nullSafeIsEqual(methods[i2].getName(), "getSuppressed"); i2++) {
        }
    }
}
