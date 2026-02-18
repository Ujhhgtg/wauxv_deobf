package bsh.security;

import bsh.Interpreter;
import bsh.Primitive;
import bsh.Reflect;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import net.bytebuddy.implementation.auxiliary.TypeProxy;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class MainSecurityGuard {
    private final Set<SecurityGuard> securityGuards;

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public class BasicSecurityGuard implements SecurityGuard {
        public /* synthetic */ BasicSecurityGuard(MainSecurityGuard mainSecurityGuard, int i) {
            this();
        }

        @Override // bsh.security.SecurityGuard
        public boolean canConstruct(Class<?> cls, Object[] objArr) {
            return (MainSecurityGuard.class.isAssignableFrom(cls) || SecurityGuard.class.isAssignableFrom(cls)) ? false : true;
        }

        @Override // bsh.security.SecurityGuard
        public boolean canGetStaticField(Class<?> cls, String str) {
            return (cls == Interpreter.class && str.equals("mainSecurityGuard")) ? false : true;
        }

        @Override // bsh.security.SecurityGuard
        public boolean canImplements(Class<?> cls) {
            return cls != SecurityGuard.class;
        }

        @Override // bsh.security.SecurityGuard
        public boolean canInvokeMethod(Object obj, String str, Object[] objArr) {
            return !(obj instanceof MainSecurityGuard);
        }

        private BasicSecurityGuard() {
        }
    }

    public MainSecurityGuard() {
        HashSet hashSet = new HashSet();
        this.securityGuards = hashSet;
        hashSet.add(new BasicSecurityGuard(this, 0));
    }

    private final void canInvokeMethodImpl(Object obj, String str, Object[] objArr) throws SecurityError {
        Iterator<SecurityGuard> it = this.securityGuards.iterator();
        while (it.hasNext()) {
            if (!it.next().canInvokeMethod(obj, str, objArr)) {
                throw SecurityError.cantInvokeMethod(obj, str, objArr);
            }
        }
    }

    private final void canInvokeMethodImplToReflectionCanConstruct(Object obj, String str, Object[] objArr) throws SecurityError {
        if ((obj instanceof Class) && str.equals(TypeProxy.SilentConstruction.Appender.NEW_INSTANCE_METHOD_NAME)) {
            Class<?> cls = (Class) obj;
            Object[] objArr2 = new Object[0];
            try {
                canConstruct(cls, objArr2);
                return;
            } catch (SecurityError unused) {
                throw SecurityError.reflectCantConstruct(cls, objArr2);
            }
        }
        if ((obj instanceof Constructor) && str.equals(TypeProxy.SilentConstruction.Appender.NEW_INSTANCE_METHOD_NAME)) {
            Class<?> declaringClass = ((Constructor) obj).getDeclaringClass();
            if (objArr.length == 1) {
                Object obj2 = objArr[0];
                if (obj2 instanceof Object[]) {
                    objArr = (Object[]) obj2;
                }
            }
            try {
                canConstruct(declaringClass, objArr);
            } catch (SecurityError unused2) {
                throw SecurityError.reflectCantConstruct(declaringClass, objArr);
            }
        }
    }

    private final void canInvokeMethodImplToReflectionCanGetField(Object obj, String str, Object[] objArr) throws SecurityError {
        if (str.equals("get") && objArr.length == 1 && (obj instanceof Field)) {
            Field field = (Field) obj;
            String name = field.getName();
            if (Reflect.isStatic(field)) {
                Class<?> declaringClass = field.getDeclaringClass();
                try {
                    canGetStaticField(declaringClass, name);
                } catch (SecurityError unused) {
                    throw SecurityError.reflectCantGetStaticField(declaringClass, name);
                }
            } else {
                Object obj2 = objArr[0];
                try {
                    canGetField(obj2, name);
                } catch (SecurityError unused2) {
                    throw SecurityError.reflectCantGetField(obj2, name);
                }
            }
        }
    }

    /* JADX WARN: Found duplicated region for block: B:14:0x0024  */
    private final void canInvokeMethodImplToReflectionCanInvokeMethod(Object obj, String str, Object[] objArr) throws SecurityError {
        Object[] objArrCopyOfRange;
        if (str.equals("invoke") && objArr.length != 0 && (obj instanceof Method)) {
            Method method = (Method) obj;
            String name = method.getName();
            if (objArr.length == 2) {
                Object obj2 = objArr[1];
                objArrCopyOfRange = obj2 instanceof Object[] ? (Object[]) obj2 : Arrays.copyOfRange(objArr, 1, objArr.length);
            }
            if (Reflect.isStatic(method)) {
                Class<?> declaringClass = method.getDeclaringClass();
                try {
                    canInvokeStaticMethod(declaringClass, name, objArrCopyOfRange);
                } catch (SecurityError unused) {
                    throw SecurityError.reflectCantInvokeStaticMethod(declaringClass, name, objArrCopyOfRange);
                }
            } else {
                Object obj3 = objArr[0];
                try {
                    canInvokeMethod(obj3, name, objArrCopyOfRange);
                } catch (SecurityError unused2) {
                    throw SecurityError.reflectCantInvokeMethod(obj3, name, objArrCopyOfRange);
                }
            }
        }
    }

    private void canInvokeStaticMethodImpl(Class<?> cls, String str, Object[] objArr) throws SecurityError {
        Iterator<SecurityGuard> it = this.securityGuards.iterator();
        while (it.hasNext()) {
            if (!it.next().canInvokeStaticMethod(cls, str, objArr)) {
                throw SecurityError.cantInvokeStaticMethod(cls, str, objArr);
            }
        }
    }

    private void canInvokeStaticMethodImplToReflectionCanGetArrayLength(Class<?> cls, String str, Object[] objArr) throws SecurityError {
        if (str.equals("getLength") && objArr.length == 1 && cls.isAssignableFrom(Array.class)) {
            Object obj = objArr[0];
            try {
                canGetField(obj, "length");
            } catch (SecurityError unused) {
                throw SecurityError.reflectCantGetField(obj, "length");
            }
        }
    }

    public void add(SecurityGuard securityGuard) {
        this.securityGuards.add(securityGuard);
    }

    public void canConstruct(Class<?> cls, Object[] objArr) throws SecurityError {
        Object[] objArrUnwrap = Primitive.unwrap(objArr);
        Iterator<SecurityGuard> it = this.securityGuards.iterator();
        while (it.hasNext()) {
            if (!it.next().canConstruct(cls, objArrUnwrap)) {
                throw SecurityError.cantConstruct(cls, objArrUnwrap);
            }
        }
    }

    public void canExtends(Class<?> cls) throws SecurityError {
        Iterator<SecurityGuard> it = this.securityGuards.iterator();
        while (it.hasNext()) {
            if (!it.next().canExtends(cls)) {
                throw SecurityError.cantExtends(cls);
            }
        }
    }

    public void canGetField(Object obj, String str) {
        Iterator<SecurityGuard> it = this.securityGuards.iterator();
        while (it.hasNext()) {
            if (!it.next().canGetField(obj, str)) {
                throw SecurityError.cantGetField(obj, str);
            }
        }
    }

    public void canGetStaticField(Class<?> cls, String str) {
        Iterator<SecurityGuard> it = this.securityGuards.iterator();
        while (it.hasNext()) {
            if (!it.next().canGetStaticField(cls, str)) {
                throw SecurityError.cantGetStaticField(cls, str);
            }
        }
    }

    public void canImplements(Class<?> cls) throws SecurityError {
        Iterator<SecurityGuard> it = this.securityGuards.iterator();
        while (it.hasNext()) {
            if (!it.next().canImplements(cls)) {
                throw SecurityError.cantImplements(cls);
            }
        }
    }

    public void canInvokeLocalMethod(String str, Object[] objArr) {
        Object[] objArrUnwrap = Primitive.unwrap(objArr);
        Iterator<SecurityGuard> it = this.securityGuards.iterator();
        while (it.hasNext()) {
            if (!it.next().canInvokeLocalMethod(str, objArrUnwrap)) {
                throw SecurityError.cantInvokeLocalMethod(str, objArrUnwrap);
            }
        }
    }

    public void canInvokeMethod(Object obj, String str, Object[] objArr) {
        Object[] objArrUnwrap = Primitive.unwrap(objArr);
        canInvokeMethodImpl(obj, str, objArrUnwrap);
        canInvokeMethodImplToReflectionCanGetField(obj, str, objArrUnwrap);
        canInvokeMethodImplToReflectionCanConstruct(obj, str, objArrUnwrap);
        canInvokeMethodImplToReflectionCanInvokeMethod(obj, str, objArrUnwrap);
    }

    public void canInvokeStaticMethod(Class<?> cls, String str, Object[] objArr) {
        Object[] objArrUnwrap = Primitive.unwrap(objArr);
        canInvokeStaticMethodImpl(cls, str, objArrUnwrap);
        canInvokeStaticMethodImplToReflectionCanGetArrayLength(cls, str, objArrUnwrap);
    }

    public void remove(SecurityGuard securityGuard) {
        this.securityGuards.remove(securityGuard);
    }
}
