package bsh;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import me.hd.wauxv.obf.bqo;
import me.hd.wauxv.obf.ky;
import me.hd.wauxv.obf.rb;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Invocable implements Member {
    private final Class<?> declaringClass;
    private final int flags;
    private final boolean isStatic;
    private final boolean isSynthetic;
    private final String name;
    private final String toString;
    private MethodHandle handle = null;
    protected final List<Object> parameters = new ArrayList();
    protected int lastParameterIndex = 0;

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static class ParameterType {
        boolean isFixedArity;
        List<Object> params;

        public ParameterType(List<Object> list, boolean z) {
            this.params = list;
            this.isFixedArity = z;
        }
    }

    public <M extends AccessibleObject & Member> Invocable(M m) {
        M m2 = m;
        this.flags = m2.getModifiers();
        this.declaringClass = m2.getDeclaringClass();
        this.name = m2.getName();
        this.toString = m.toString();
        M m3 = m;
        this.isStatic = Reflect.isStatic(m3);
        this.isSynthetic = m3.isSynthetic();
        if (!Capabilities.haveAccessibility() || m3.getDeclaringClass() == Class.class) {
            return;
        }
        m.setAccessible(true);
    }

    public static Invocable get(Method method) {
        return new MethodInvocable(method);
    }

    private synchronized Object invokeTarget(Object obj, Object[] objArr) {
        try {
            Reflect.logInvokeMethod("Invoking method (entry): ", this, objArr);
            ParameterType parameterTypeCollectParamaters = collectParamaters(obj, objArr);
            List<?> list = parameterTypeCollectParamaters.params;
            Reflect.logInvokeMethod("Invoking method (after): ", this, list);
            if (getParameterCount() > 0) {
                MethodHandle methodHandle = getMethodHandle();
                if (parameterTypeCollectParamaters.isFixedArity) {
                    methodHandle = methodHandle.asFixedArity();
                }
                return methodHandle.invokeWithArguments(list);
            }
            if (!isStatic() && !(this instanceof ConstructorInvocable)) {
                return (Object) getMethodHandle().invoke(list.get(0));
            }
            return (Object) getMethodHandle().invoke();
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String[] lambda$getParamTypeDescriptors$0(int i) {
        return new String[i];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer lambda$hashCode$1(Class cls) {
        return Integer.valueOf(cls == null ? 39 : cls.hashCode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer lambda$hashCode$2(Integer num, Integer num2) {
        return Integer.valueOf(num.intValue() ^ num2.intValue());
    }

    public Object coerceToType(Object obj, Class<?> cls) {
        Class<?> type = Types.getType(obj);
        if (type == null || !cls.isAssignableFrom(type)) {
            obj = Types.castObject(obj, cls, 0);
        }
        return Primitive.unwrap(obj);
    }

    public ParameterType collectParamaters(Object obj, Object[] objArr) throws InvocationTargetException {
        if (getLastParameterIndex() > objArr.length) {
            throw new InvocationTargetException(null, "Insufficient parameters passed for method: " + getName() + Arrays.asList(getParameterTypes()));
        }
        this.parameters.clear();
        for (int i = 0; i < getLastParameterIndex(); i++) {
            this.parameters.add(coerceToType(objArr[i], getParameterTypes()[i]));
        }
        return new ParameterType(this.parameters, false);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Invocable invocable = (Invocable) obj;
        if (!getName().equals(invocable.getName()) || getDeclaringClass() != invocable.getDeclaringClass() || getParameterCount() != invocable.getParameterCount() || getReturnType() != invocable.getReturnType() || getModifiers() != invocable.getModifiers()) {
            return false;
        }
        for (int i = 0; i < getParameterCount(); i++) {
            if (getParameterTypes()[i] != invocable.getParameterTypes()[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.lang.reflect.Member
    public Class<?> getDeclaringClass() {
        return this.declaringClass;
    }

    public int getLastParameterIndex() {
        return this.lastParameterIndex;
    }

    public String getMethodDescriptor() {
        return methodType().toMethodDescriptorString();
    }

    public MethodHandle getMethodHandle() {
        if (this.handle == null) {
            this.handle = lookup(null);
        }
        return this.handle;
    }

    @Override // java.lang.reflect.Member
    public int getModifiers() {
        return this.flags;
    }

    @Override // java.lang.reflect.Member
    public String getName() {
        return this.name;
    }

    public String[] getParamTypeDescriptors() {
        return (String[]) methodType().parameterList().stream().map(new b()).toArray(new rb(5));
    }

    public abstract int getParameterCount();

    public abstract Class<?>[] getParameterTypes();

    public abstract Class<?> getReturnType();

    public String getReturnTypeDescriptor() {
        return BSHType.getTypeDescriptor(getReturnType());
    }

    public Class<?> getVarArgsComponentType() {
        return Void.TYPE;
    }

    public Class<?> getVarArgsType() {
        return Void.TYPE;
    }

    public int hashCode() {
        return (((((getClass().hashCode() ^ getName().hashCode()) ^ getDeclaringClass().hashCode()) ^ getParameterCount()) ^ getReturnType().hashCode()) ^ getModifiers()) ^ ((Integer) Stream.of((Object[]) getParameterTypes()).map(new ky(12)).reduce(75, new bqo())).intValue();
    }

    public synchronized Object invoke(Object obj, Object... objArr) {
        if (objArr == null) {
            objArr = Reflect.ZERO_ARGS;
            try {
            } catch (Throwable th) {
                throw new InvocationTargetException(th);
            }
        }
        throw th;
        return Primitive.wrap(invokeTarget(obj, objArr), getReturnType());
    }

    public boolean isGetter() {
        return false;
    }

    public boolean isInnerClass() {
        return false;
    }

    public boolean isSetter() {
        return false;
    }

    public boolean isStatic() {
        return this.isStatic;
    }

    @Override // java.lang.reflect.Member
    public boolean isSynthetic() {
        return this.isSynthetic;
    }

    public boolean isVarArgs() {
        return false;
    }

    public abstract MethodHandle lookup(MethodHandle methodHandle);

    public MethodType methodType() {
        return MethodType.methodType(getReturnType(), getParameterTypes());
    }

    public String toString() {
        return this.toString;
    }

    public static Invocable get(Constructor<?> constructor) {
        return new ConstructorInvocable(constructor);
    }

    public static FieldAccess get(Field field) {
        return new FieldAccess(field);
    }
}
