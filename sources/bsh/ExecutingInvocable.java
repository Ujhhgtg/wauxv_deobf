package bsh;

import bsh.Invocable;
import java.lang.invoke.MethodHandle;
import java.lang.reflect.Executable;
import java.lang.reflect.Member;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
abstract class ExecutingInvocable extends Invocable {
    private final boolean isVarargs;
    private final int parameterCount;
    private final Class<?>[] parameterTypes;
    private final Class<?> varArgsType;

    /* JADX WARN: Multi-variable type inference failed */
    public <M extends Executable & Member> ExecutingInvocable(M m) {
        super(m);
        this.parameterTypes = m.getParameterTypes();
        int parameterCount = m.getParameterCount();
        this.parameterCount = parameterCount;
        this.isVarargs = m.isVarArgs();
        this.lastParameterIndex = parameterCount > 1 ? parameterCount - 1 : 0;
        this.varArgsType = isVarArgs() ? getParameterTypes()[this.lastParameterIndex] : Void.TYPE;
    }

    @Override // bsh.Invocable
    public Invocable.ParameterType collectParamaters(Object obj, Object[] objArr) {
        super.collectParamaters(obj, objArr);
        boolean z = false;
        if (isVarArgs()) {
            if (getLastParameterIndex() < objArr.length) {
                if (getParameterCount() == objArr.length && objArr[getLastParameterIndex()].getClass().isArray() && getVarArgsComponentType().isAssignableFrom(objArr[getLastParameterIndex()].getClass().getComponentType())) {
                    this.parameters.add(objArr[getLastParameterIndex()]);
                    z = true;
                } else {
                    Object[] objArrCopyOfRange = Arrays.copyOfRange(objArr, getLastParameterIndex(), objArr.length);
                    for (Object obj2 : objArrCopyOfRange) {
                        this.parameters.add(super.coerceToType(obj2, getVarArgsComponentType()));
                    }
                }
            }
        } else if (objArr != null && getLastParameterIndex() < objArr.length) {
            this.parameters.add(super.coerceToType(objArr[getLastParameterIndex()], getParameterTypes()[getLastParameterIndex()]));
        }
        return new Invocable.ParameterType(this.parameters, z);
    }

    @Override // bsh.Invocable
    public int getParameterCount() {
        return this.parameterCount;
    }

    @Override // bsh.Invocable
    public Class<?>[] getParameterTypes() {
        return this.parameterTypes;
    }

    @Override // bsh.Invocable
    public Class<?> getVarArgsComponentType() {
        return Types.arrayElementType(getVarArgsType());
    }

    @Override // bsh.Invocable
    public Class<?> getVarArgsType() {
        return this.varArgsType;
    }

    @Override // bsh.Invocable
    public boolean isVarArgs() {
        return this.isVarargs;
    }

    @Override // bsh.Invocable
    public MethodHandle lookup(MethodHandle methodHandle) {
        return (!isVarArgs() || methodHandle == null) ? methodHandle : methodHandle.asVarargsCollector(getVarArgsType());
    }
}
