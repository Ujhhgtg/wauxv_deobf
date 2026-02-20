package me.hd.wauxv.obf;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class exj extends nh {
    public final /* synthetic */ HookManager a;
    public final /* synthetic */ Member b;

    /*
     * JADX WARN: 'super' call moved to the top of the method (can break code
     * semantics)
     */
    public exj(but butVar, HookManager hookManagerVar, Member member, HookPriorityEnum hookPriorityEnumVar) {
        super(hookPriorityEnumVar);
        this.a = hookManagerVar;
        this.b = member;
    }

    @Override // me.hd.wauxv.obf.nh
    public final void c(blq blqVar) {
        Object objX;
        int i = HookParam.a;
        HookManager hookManagerVar = this.a;
        HookParam hookParam = new HookParam();
        hookParam.b = blqVar;
        Member member = this.b;
        try {
            IInvokable bgfVar = (IInvokable) hookManagerVar.g;
            if (bgfVar != null) {
                bgfVar.invoke(hookParam);
            }
            if (((IInvokable) hookManagerVar.g) != null) {
                ArrayList arrayList = Logger.a;
                StringBuilder sb = new StringBuilder("After Hook Member [");
                sb.append(member);
                sb.append("] done");
                Logger.f();
            }
            objX = Kotlin$Unit.INSTANCE;
        } catch (Throwable th) {
            objX = FastKV.getFailureFromException(th);
        }
        Throwable thB = Success.exceptionOrNull(objX);
        if (thB != null) {
            hookManagerVar.logHookError(thB, member);
        }
    }

    @Override // me.hd.wauxv.obf.nh
    public final void d(blq blqVar) {
        Object objX;
        int i = HookParam.a;
        HookManager hookManagerVar = this.a;
        HookParam hookParam = new HookParam();
        hookParam.b = blqVar;
        Member member = this.b;
        try {
            IInvokable bgfVar = (IInvokable) hookManagerVar.f;
            if (bgfVar != null) {
                bgfVar.invoke(hookParam);
            }
            Member member2 = ((XposedMethodHookParamWrapper) blqVar.a).b.method;
            Method method = member2 instanceof Method ? (Method) member2 : null;
            Class<?> returnType = method != null ? method.getReturnType() : null;
            Object objG = ((bmi) blqVar.d).g(null, Boolean.FALSE);
            HookManager.verifySignature(hookManagerVar, returnType, objG != null ? objG.getClass() : null);
            if (((IInvokable) hookManagerVar.f) != null) {
                ArrayList arrayList = Logger.a;
                StringBuilder sb = new StringBuilder("Before Hook Member [");
                sb.append(member);
                sb.append("] done");
                Logger.f();
            }
            objX = Kotlin$Unit.INSTANCE;
        } catch (Throwable th) {
            objX = FastKV.getFailureFromException(th);
        }
        Throwable thB = Success.exceptionOrNull(objX);
        if (thB != null) {
            hookManagerVar.logHookError(thB, member);
        }
    }
}
