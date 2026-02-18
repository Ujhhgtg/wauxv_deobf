package bsh;

import bsh.Invocable;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.util.stream.Stream;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
class ConstructorInvocable extends ExecutingInvocable {
    private Constructor<?> constructor;
    private final boolean isStatic;

    public ConstructorInvocable(Constructor<?> constructor) {
        super(constructor);
        this.constructor = constructor;
        this.isStatic = Reflect.isStatic(getDeclaringClass());
    }

    @Override // bsh.ExecutingInvocable, bsh.Invocable
    public Invocable.ParameterType collectParamaters(Object obj, Object[] objArr) {
        if (isInnerClass() && !isStatic()) {
            objArr = Stream.concat(Stream.of(obj), Stream.of(objArr)).toArray();
        }
        return super.collectParamaters(obj, objArr);
    }

    @Override // bsh.Invocable
    public Class<?> getReturnType() {
        return getDeclaringClass();
    }

    @Override // bsh.Invocable
    public boolean isInnerClass() {
        return getDeclaringClass().isMemberClass();
    }

    @Override // bsh.Invocable
    public boolean isStatic() {
        return this.isStatic;
    }

    @Override // bsh.ExecutingInvocable, bsh.Invocable
    public MethodHandle lookup(MethodHandle methodHandle) {
        try {
            try {
                MethodHandle methodHandleLookup = super.lookup(MethodHandles.lookup().unreflectConstructor(this.constructor));
                this.constructor = null;
                return methodHandleLookup;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (Throwable th) {
            this.constructor = null;
            throw th;
        }
    }
}
