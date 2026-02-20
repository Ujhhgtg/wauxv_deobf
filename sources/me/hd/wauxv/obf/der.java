package me.hd.wauxv.obf;

import android.app.Application;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class der {
    public static final List a = OtherStaticHelpers.argsToList(Application.class, deh.class);
    public static final List b = dqc.toSingletonList(deh.class);

    public static final Constructor c(Class cls, List list) {
        throwIfVar1IsNull(list, com.umeng.ccg.a.A);
        z zVarAe = cnb.ae(cls.getConstructors());
        while (zVarAe.hasNext()) {
            Constructor constructor = (Constructor) zVarAe.next();
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            throwIfVar1IsNull(parameterTypes, "getParameterTypes(...)");
            List listAb = SomeStaticHelpers.arrayToList(parameterTypes);
            if (list.equals(listAb)) {
                return constructor;
            }
            if (list.size() == listAb.size() && listAb.containsAll(list)) {
                throw new UnsupportedOperationException(
                        "Class " + cls.getSimpleName() + " must have parameters in the proper order: " + list);
            }
        }
        return null;
    }

    public static final erk d(Class cls, Constructor constructor, Object... objArr) {
        try {
            return (erk) constructor.newInstance(Arrays.copyOf(objArr, objArr.length));
        } catch (IllegalAccessException e) {
            throw new RuntimeException(concatVar2Var1(cls, "Failed to access "), e);
        } catch (InstantiationException e2) {
            throw new RuntimeException("A " + cls + " cannot be instantiated.", e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException(concatVar2Var1(cls, "An exception happened in constructor of "), e3.getCause());
        }
    }
}
