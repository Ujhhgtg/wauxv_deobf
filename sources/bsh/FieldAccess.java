package bsh;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
class FieldAccess extends Invocable {
    private Field field;
    private boolean getter;
    private MethodHandle setter;
    private final Class<?> type;

    public FieldAccess(Field field) {
        super(field);
        this.getter = false;
        this.type = field.getType();
        this.field = field;
    }

    @Override // bsh.Invocable
    public int getParameterCount() {
        return 1;
    }

    @Override // bsh.Invocable
    public Class<?>[] getParameterTypes() {
        return new Class[]{this.type};
    }

    @Override // bsh.Invocable
    public Class<?> getReturnType() {
        return this.type;
    }

    public MethodHandle getSetterHandle() {
        if (this.setter == null) {
            this.setter = lookup();
        }
        return this.setter;
    }

    @Override // bsh.Invocable
    public synchronized Object invoke(Object obj, Object... objArr) {
        try {
            if (objArr.length == 0) {
                if (isStatic()) {
                    return Primitive.wrap((Object) getMethodHandle().invoke(), getReturnType());
                }
                return Primitive.wrap((Object) getMethodHandle().invoke(obj), getReturnType());
            }
            if (isStatic()) {
                return (Object) getSetterHandle().invoke(super.coerceToType(objArr[0], getParameterTypes()[0]));
            }
            return (Object) getSetterHandle().invoke(obj, super.coerceToType(objArr[0], getParameterTypes()[0]));
        } catch (Throwable th) {
            throw new InvocationTargetException(th.getCause());
        }
    }

    @Override // bsh.Invocable
    public MethodHandle lookup(MethodHandle methodHandle) {
        try {
            try {
                MethodHandle methodHandleUnreflectGetter = MethodHandles.lookup().unreflectGetter(this.field);
                this.getter = true;
                if (this.setter != null) {
                    this.field = null;
                }
                return methodHandleUnreflectGetter;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (Throwable th) {
            this.getter = true;
            if (this.setter != null) {
                this.field = null;
            }
            throw th;
        }
    }

    public MethodHandle lookup() {
        try {
            try {
                MethodHandle methodHandleUnreflectSetter = MethodHandles.lookup().unreflectSetter(this.field);
                if (this.getter) {
                    this.field = null;
                }
                return methodHandleUnreflectSetter;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (Throwable th) {
            if (this.getter) {
                this.field = null;
            }
            throw th;
        }
    }
}
