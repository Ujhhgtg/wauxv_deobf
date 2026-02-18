package me.hd.wauxv.obf;

import android.util.Log;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Executable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class blb {
    public static final Unsafe a;
    public static final long b;
    public static final long c;
    public static final long d;
    public static final long e;

    static {
        long jObjectFieldOffset;
        try {
            Unsafe unsafe = (Unsafe) Unsafe.class.getDeclaredMethod("getUnsafe", null).invoke(null, null);
            a = unsafe;
            agx agxVar = new agx(System.getProperty("java.boot.class.path", "").split(":", 2)[0], null);
            Class clsLoadClass = agxVar.loadClass(Executable.class.getName());
            Class clsLoadClass2 = agxVar.loadClass(MethodHandle.class.getName());
            Class clsLoadClass3 = agxVar.loadClass(Class.class.getName());
            unsafe.objectFieldOffset(clsLoadClass.getDeclaredField("artMethod"));
            unsafe.objectFieldOffset(clsLoadClass.getDeclaredField("declaringClass"));
            b = unsafe.objectFieldOffset(clsLoadClass2.getDeclaredField("artFieldOrMethod"));
            try {
                jObjectFieldOffset = unsafe.objectFieldOffset(clsLoadClass3.getDeclaredField("fields"));
            } catch (NoSuchFieldException unused) {
                Unsafe unsafe2 = a;
                jObjectFieldOffset = unsafe2.objectFieldOffset(clsLoadClass3.getDeclaredField("iFields"));
                unsafe2.objectFieldOffset(clsLoadClass3.getDeclaredField("sFields"));
            }
            Unsafe unsafe3 = a;
            long jObjectFieldOffset2 = unsafe3.objectFieldOffset(clsLoadClass3.getDeclaredField("methods"));
            c = jObjectFieldOffset2;
            Method declaredMethod = bks.class.getDeclaredMethod(com.umeng.analytics.pro.bt.at, null);
            Method declaredMethod2 = bks.class.getDeclaredMethod("b", null);
            declaredMethod.setAccessible(true);
            declaredMethod2.setAccessible(true);
            MethodHandle methodHandleUnreflect = MethodHandles.lookup().unreflect(declaredMethod);
            MethodHandle methodHandleUnreflect2 = MethodHandles.lookup().unreflect(declaredMethod2);
            long j = b;
            long j2 = unsafe3.getLong(methodHandleUnreflect, j);
            long j3 = unsafe3.getLong(methodHandleUnreflect2, j);
            long j4 = unsafe3.getLong(bks.class, jObjectFieldOffset2);
            long j5 = j3 - j2;
            d = j5;
            e = (j2 - j4) - j5;
            Field declaredField = bks.class.getDeclaredField(com.umeng.analytics.pro.bt.aA);
            Field declaredField2 = bks.class.getDeclaredField("j");
            declaredField.setAccessible(true);
            declaredField2.setAccessible(true);
            MethodHandle methodHandleUnreflectGetter = MethodHandles.lookup().unreflectGetter(declaredField);
            MethodHandle methodHandleUnreflectGetter2 = MethodHandles.lookup().unreflectGetter(declaredField2);
            unsafe3.getLong(methodHandleUnreflectGetter, j);
            unsafe3.getLong(methodHandleUnreflectGetter2, j);
            unsafe3.getLong(bks.class, jObjectFieldOffset);
        } catch (ReflectiveOperationException e2) {
            Log.e("HiddenApiBypass", "Initialize error", e2);
            throw new ExceptionInInitializerError(e2);
        }
    }

    public static List f(Class cls) {
        if (cls.isPrimitive() || cls.isArray()) {
            return Collections.EMPTY_LIST;
        }
        try {
            Method declaredMethod = bks.class.getDeclaredMethod(com.umeng.analytics.pro.bt.at, null);
            declaredMethod.setAccessible(true);
            MethodHandle methodHandleUnreflect = MethodHandles.lookup().unreflect(declaredMethod);
            Unsafe unsafe = a;
            long j = unsafe.getLong(cls, c);
            if (j == 0) {
                return Collections.EMPTY_LIST;
            }
            int i = unsafe.getInt(j);
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 < i; i2++) {
                a.putLong(methodHandleUnreflect, b, e + (((long) i2) * d) + j);
                arrayList.add((Executable) MethodHandles.reflectAs(Executable.class, methodHandleUnreflect));
            }
            return arrayList;
        } catch (IllegalAccessException | NoSuchMethodException unused) {
            return Collections.EMPTY_LIST;
        }
    }
}
