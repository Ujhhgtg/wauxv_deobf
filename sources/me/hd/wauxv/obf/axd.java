package me.hd.wauxv.obf;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class axd extends cbh {
    public IInvokable d;
    public Integer g;
    public final ArrayList b = new ArrayList();
    public final ArrayList c = new ArrayList();
    public final LinkedHashSet e = new LinkedHashSet();
    public final LinkedHashSet f = new LinkedHashSet();
    public final LinkedHashSet h = new LinkedHashSet();
    public final LinkedHashSet i = new LinkedHashSet();
    public final LinkedHashSet j = new LinkedHashSet();
    public final LinkedHashSet k = new LinkedHashSet();
    public final LinkedHashSet l = new LinkedHashSet();
    public final LinkedHashSet m = new LinkedHashSet();
    public final ArrayList n = new ArrayList();
    public final ArrayList o = new ArrayList();
    public final LinkedHashSet p = new LinkedHashSet();
    public final LinkedHashSet q = new LinkedHashSet();
    public final LinkedHashSet r = new LinkedHashSet();
    public final LinkedHashSet s = new LinkedHashSet();
    public final LinkedHashSet t = new LinkedHashSet();
    public final LinkedHashSet u = new LinkedHashSet();
    public final LinkedHashSet v = new LinkedHashSet();
    public final LinkedHashSet w = new LinkedHashSet();

    @Override // me.hd.wauxv.obf.cbh
    public Map x() {
        Map mapX = super.x();
        Map mapAi = KotlinHelpers.ai(new Pair("parameters", this.b), new Pair("parametersNot", this.c),
                new Pair("parametersCondition", this.d), new Pair("parameterCount", this.g),
                new Pair("parameterCountCondition", null), new Pair("typeParameters", this.e),
                new Pair("typeParametersNot", this.f), new Pair("exceptionTypes", this.h),
                new Pair("exceptionTypesNot", this.i), new Pair("genericExceptionTypes", this.j),
                new Pair("genericExceptionTypesNot", this.k), new Pair("genericParameters", this.l),
                new Pair("genericParametersNot", this.m), new Pair("isVarArgs", null), new Pair("isVarArgsNot", null),
                new Pair("parameterAnnotations", this.n), new Pair("parameterAnnotationsNot", this.o),
                new Pair("annotatedReturnType", this.p), new Pair("annotatedReturnTypeNot", this.q),
                new Pair("annotatedReceiverType", this.r), new Pair("annotatedReceiverTypeNot", this.s),
                new Pair("annotatedParameterTypes", this.t), new Pair("annotatedParameterTypesNot", this.u),
                new Pair("annotatedExceptionTypes", this.v), new Pair("annotatedExceptionTypesNot", this.w));
        LinkedHashMap linkedHashMap = new LinkedHashMap(mapX);
        linkedHashMap.putAll(mapAi);
        return linkedHashMap;
    }

    public final void y() {
        this.g = 0;
    }

    public final void z(Object... objArr) {
        abf.ao(this.b, objArr);
    }
}
