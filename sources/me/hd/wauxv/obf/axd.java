package me.hd.wauxv.obf;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class axd extends cbh {
    public bgf d;
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
        Map mapAi = bzo.ai(new csm("parameters", this.b), new csm("parametersNot", this.c), new csm("parametersCondition", this.d), new csm("parameterCount", this.g), new csm("parameterCountCondition", null), new csm("typeParameters", this.e), new csm("typeParametersNot", this.f), new csm("exceptionTypes", this.h), new csm("exceptionTypesNot", this.i), new csm("genericExceptionTypes", this.j), new csm("genericExceptionTypesNot", this.k), new csm("genericParameters", this.l), new csm("genericParametersNot", this.m), new csm("isVarArgs", null), new csm("isVarArgsNot", null), new csm("parameterAnnotations", this.n), new csm("parameterAnnotationsNot", this.o), new csm("annotatedReturnType", this.p), new csm("annotatedReturnTypeNot", this.q), new csm("annotatedReceiverType", this.r), new csm("annotatedReceiverTypeNot", this.s), new csm("annotatedParameterTypes", this.t), new csm("annotatedParameterTypesNot", this.u), new csm("annotatedExceptionTypes", this.v), new csm("annotatedExceptionTypesNot", this.w));
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
