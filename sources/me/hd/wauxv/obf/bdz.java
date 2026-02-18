package me.hd.wauxv.obf;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bdz {
    public static final dhq a = new dhq(0);
    public final /* synthetic */ beg b;

    public bdz(beg begVar) {
        this.b = begVar;
    }

    public static Class c(ClassLoader classLoader, String str) throws ClassNotFoundException {
        dhq dhqVar = a;
        dhq dhqVar2 = (dhq) dhqVar.get(classLoader);
        if (dhqVar2 == null) {
            dhqVar2 = new dhq(0);
            dhqVar.put(classLoader, dhqVar2);
        }
        Class cls = (Class) dhqVar2.get(str);
        if (cls != null) {
            return cls;
        }
        Class<?> cls2 = Class.forName(str, false, classLoader);
        dhqVar2.put(str, cls2);
        return cls2;
    }

    public static Class d(ClassLoader classLoader, String str) {
        try {
            return c(classLoader, str);
        } catch (ClassCastException e) {
            throw new abt(bjs.o("Unable to instantiate fragment ", str, ": make sure class is a valid subclass of Fragment"), e);
        } catch (ClassNotFoundException e2) {
            throw new abt(bjs.o("Unable to instantiate fragment ", str, ": make sure class name exists"), e2);
        }
    }

    public final bdj e(String str) {
        try {
            return (bdj) d(this.b.w.e.getClassLoader(), str).getConstructor(null).newInstance(null);
        } catch (IllegalAccessException e) {
            throw new abt(bjs.o("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e);
        } catch (InstantiationException e2) {
            throw new abt(bjs.o("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e2);
        } catch (NoSuchMethodException e3) {
            throw new abt(bjs.o("Unable to instantiate fragment ", str, ": could not find Fragment constructor"), e3);
        } catch (InvocationTargetException e4) {
            throw new abt(bjs.o("Unable to instantiate fragment ", str, ": calling Fragment constructor caused an exception"), e4);
        }
    }
}
