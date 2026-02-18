package me.hd.wauxv.obf;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class exj extends nh {
    public final /* synthetic */ aki a;
    public final /* synthetic */ Member b;

    /*
     * JADX WARN: 'super' call moved to the top of the method (can break code
     * semantics)
     */
    public exj(but butVar, aki akiVar, Member member, exg exgVar) {
        super(exgVar);
        this.a = akiVar;
        this.b = member;
    }

    @Override // me.hd.wauxv.obf.nh
    public final void c(blq blqVar) {
        Object objX;
        int i = HookParam.a;
        aki akiVar = this.a;
        HookParam hookParam = new HookParam();
        hookParam.b = blqVar;
        Member member = this.b;
        try {
            IHasInvokeMethod bgfVar = (IHasInvokeMethod) akiVar.g;
            if (bgfVar != null) {
                bgfVar.invoke(hookParam);
            }
            if (((IHasInvokeMethod) akiVar.g) != null) {
                ArrayList arrayList = ewq.a;
                StringBuilder sb = new StringBuilder("After Hook Member [");
                sb.append(member);
                sb.append("] done");
                ewq.f();
            }
            objX = ens.a;
        } catch (Throwable th) {
            objX = bhu.x(th);
        }
        Throwable thB = dcy.b(objX);
        if (thB != null) {
            akiVar.p(thB, member);
        }
    }

    @Override // me.hd.wauxv.obf.nh
    public final void d(blq blqVar) {
        Object objX;
        int i = HookParam.a;
        aki akiVar = this.a;
        HookParam hookParam = new HookParam();
        hookParam.b = blqVar;
        Member member = this.b;
        try {
            IHasInvokeMethod bgfVar = (IHasInvokeMethod) akiVar.f;
            if (bgfVar != null) {
                bgfVar.invoke(hookParam);
            }
            Member member2 = ((bmh) blqVar.a).b.method;
            Method method = member2 instanceof Method ? (Method) member2 : null;
            Class<?> returnType = method != null ? method.getReturnType() : null;
            Object objG = ((bmi) blqVar.d).g(null, Boolean.FALSE);
            aki.k(akiVar, returnType, objG != null ? objG.getClass() : null);
            if (((IHasInvokeMethod) akiVar.f) != null) {
                ArrayList arrayList = ewq.a;
                StringBuilder sb = new StringBuilder("Before Hook Member [");
                sb.append(member);
                sb.append("] done");
                ewq.f();
            }
            objX = ens.a;
        } catch (Throwable th) {
            objX = bhu.x(th);
        }
        Throwable thB = dcy.b(objX);
        if (thB != null) {
            akiVar.p(thB, member);
        }
    }
}
