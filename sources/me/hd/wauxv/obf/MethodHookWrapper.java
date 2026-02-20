package me.hd.wauxv.obf;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class MethodHookWrapper extends InstanceResolver {
    public final Method method;

    public MethodHookWrapper(Method method) {
        this.method = method;
    }

    @Override // me.hd.wauxv.obf.cbq
    public final Member getMember() {
        return this.method;
    }

    @Override // me.hd.wauxv.obf.bpu
    public final InstanceResolver copy(Object obj) {
        bindInstance(obj);
        return this;
    }

    public final MethodHookWrapper d() {
        return new MethodHookWrapper(this.method);
    }

    public final Object invokeAndThrowIfFailed(Object... objArr) {
        Method method = this.method;
        Method method2 = method != null ? method : null;
        if (method2 != null && !method2.isAccessible()) {
            method2.setAccessible(true);
        }
        return method.invoke(this.boundInstance, Arrays.copyOf(objArr, objArr.length));
    }

    public final Object f(Object... objArr) {
        Object objX;
        try {
            objX = invokeAndThrowIfFailed(Arrays.copyOf(objArr, objArr.length));
        } catch (Throwable th) {
            objX = FastKV.getFailureFromException(th);
        }
        if (objX instanceof Failure) {
            return null;
        }
        return objX;
    }

    public final Object i(Object... objArr) {
        Object objX;
        try {
            objX = invoke(Arrays.copyOf(objArr, objArr.length));
        } catch (Throwable th) {
            objX = FastKV.getFailureFromException(th);
        }
        if (objX instanceof Failure) {
            return null;
        }
        return objX;
    }

    public final Object invoke(Object... objArr) {
        Method method = this.method;
        Method method2 = method != null ? method : null;
        if (method2 != null && !method2.isAccessible()) {
            method2.setAccessible(true);
        }
        Object objInvoke = method.invoke(this.boundInstance, Arrays.copyOf(objArr, objArr.length));
        if (objInvoke == null) {
            return null;
        }
        return objInvoke;
    }
}
