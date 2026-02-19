package bsh;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;
import java.util.regex.Pattern;
import me.hd.wauxv.obf.StaticHelpers6;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
class MethodInvocable extends ExecutingInvocable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Pattern PROPERTY_PATTERN = Pattern.compile("(?:[gs]et|is)\\p{javaUpperCase}.*");
    private boolean getter;
    private Method method;
    private boolean setter;
    private final Class<?> type;

    public MethodInvocable(Method method) {
        super(method);
        this.getter = false;
        this.setter = false;
        this.method = method;
        Class<?> returnType = method.getReturnType();
        this.type = returnType;
        this.lastParameterIndex = getParameterCount() - (isVarArgs() ? 1 : 0);
        if (PROPERTY_PATTERN.matcher(getName()).matches()) {
            boolean zStartsWith = getName().startsWith("set");
            this.setter = zStartsWith;
            Class<?> cls = Void.TYPE;
            this.getter = (zStartsWith || getParameterCount() != 0 || returnType == cls) ? false : true;
            this.setter &= getParameterCount() == 1 && returnType == cls;
            if (this.getter && getName().startsWith("is")) {
                this.getter = returnType == Boolean.class || returnType == Boolean.TYPE;
            }
        }
    }

    private static MethodHandle getHandle(Method method) {
        String name = method.getName();
        Class<?>[] parameterTypes = method.getParameterTypes();
        Class<?> declaringClass = method.getDeclaringClass();
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        Class<?> superclass = declaringClass;
        while (superclass != null) {
            if (method != null) {
                try {
                    return lookup.unreflect(method);
                } catch (IllegalAccessException unused) {
                }
            }
            for (Class<?> cls : superclass.getInterfaces()) {
                try {
                    return lookup.unreflect(cls.getDeclaredMethod(name, parameterTypes));
                } catch (IllegalAccessException | NoSuchMethodException | SecurityException unused2) {
                }
            }
            superclass = superclass.getSuperclass();
            if (superclass != null) {
                try {
                    method = superclass.getDeclaredMethod(name, parameterTypes);
                } catch (NoSuchMethodException | SecurityException unused3) {
                    method = null;
                }
            }
        }
        StringBuilder sbZ = StaticHelpers6.concatAndToSb("MethodHandle lookup failed to find a ", name, " in ");
        sbZ.append(declaringClass.getName());
        throw new RuntimeException(sbZ.toString());
    }

    @Override // bsh.ExecutingInvocable, bsh.Invocable
    public Invocable.ParameterType collectParamaters(Object obj, Object[] objArr) {
        Invocable.ParameterType parameterTypeCollectParamaters = super.collectParamaters(obj, objArr);
        if (!isStatic()) {
            this.parameters.add(0, obj);
        }
        return new Invocable.ParameterType(this.parameters, parameterTypeCollectParamaters.isFixedArity);
    }

    @Override // bsh.Invocable
    public Class<?> getReturnType() {
        return this.type;
    }

    @Override // bsh.Invocable
    public boolean isGetter() {
        return this.getter;
    }

    @Override // bsh.Invocable
    public boolean isSetter() {
        return this.setter;
    }

    @Override // bsh.ExecutingInvocable, bsh.Invocable
    public MethodHandle lookup(MethodHandle methodHandle) {
        try {
            try {
                MethodHandle methodHandleLookup = super.lookup(getHandle(this.method));
                this.method = null;
                return methodHandleLookup;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (Throwable th) {
            this.method = null;
            throw th;
        }
    }
}
