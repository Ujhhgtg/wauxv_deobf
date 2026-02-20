package me.hd.wauxv.obf;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class MethodResolver_ extends MemberResolver {
    public IInvokable parametersCondition;
    public Integer parameterCount;
    public final ArrayList parameters = new ArrayList();
    public final ArrayList parametersNot = new ArrayList();
    public final LinkedHashSet typeParameters = new LinkedHashSet();
    public final LinkedHashSet typeParametersNot = new LinkedHashSet();
    public final LinkedHashSet exceptionTypes = new LinkedHashSet();
    public final LinkedHashSet exceptionTypesNot = new LinkedHashSet();
    public final LinkedHashSet genericExceptionTypes = new LinkedHashSet();
    public final LinkedHashSet genericExceptionTypesNot = new LinkedHashSet();
    public final LinkedHashSet genericParameters = new LinkedHashSet();
    public final LinkedHashSet genericParametersNot = new LinkedHashSet();
    public final ArrayList parameterAnnotations = new ArrayList();
    public final ArrayList parameterAnnotationsNot = new ArrayList();
    public final LinkedHashSet annotatedReturnType = new LinkedHashSet();
    public final LinkedHashSet annotatedReturnTypeNot = new LinkedHashSet();
    public final LinkedHashSet annotatedReceiverType = new LinkedHashSet();
    public final LinkedHashSet annotatedReceiverTypeNot = new LinkedHashSet();
    public final LinkedHashSet annotatedParameterTypes = new LinkedHashSet();
    public final LinkedHashSet annotatedParameterTypesNot = new LinkedHashSet();
    public final LinkedHashSet annotatedExceptionTypes = new LinkedHashSet();
    public final LinkedHashSet annotatedExceptionTypesNot = new LinkedHashSet();

    @Override // me.hd.wauxv.obf.cbh
    public Map toFieldsNameValueMap() {
        Map mapX = super.toFieldsNameValueMap();
        Map mapAi = KotlinHelpers.mapOf(new Pair("parameters", this.parameters), new Pair("parametersNot", this.parametersNot),
                new Pair("parametersCondition", this.parametersCondition), new Pair("parameterCount", this.parameterCount),
                new Pair("parameterCountCondition", null), new Pair("typeParameters", this.typeParameters),
                new Pair("typeParametersNot", this.typeParametersNot), new Pair("exceptionTypes", this.exceptionTypes),
                new Pair("exceptionTypesNot", this.exceptionTypesNot), new Pair("genericExceptionTypes", this.genericExceptionTypes),
                new Pair("genericExceptionTypesNot", this.genericExceptionTypesNot), new Pair("genericParameters", this.genericParameters),
                new Pair("genericParametersNot", this.genericParametersNot), new Pair("isVarArgs", null), new Pair("isVarArgsNot", null),
                new Pair("parameterAnnotations", this.parameterAnnotations), new Pair("parameterAnnotationsNot", this.parameterAnnotationsNot),
                new Pair("annotatedReturnType", this.annotatedReturnType), new Pair("annotatedReturnTypeNot", this.annotatedReturnTypeNot),
                new Pair("annotatedReceiverType", this.annotatedReceiverType), new Pair("annotatedReceiverTypeNot", this.annotatedReceiverTypeNot),
                new Pair("annotatedParameterTypes", this.annotatedParameterTypes), new Pair("annotatedParameterTypesNot", this.annotatedParameterTypesNot),
                new Pair("annotatedExceptionTypes", this.annotatedExceptionTypes), new Pair("annotatedExceptionTypesNot", this.annotatedExceptionTypesNot));
        LinkedHashMap linkedHashMap = new LinkedHashMap(mapX);
        linkedHashMap.putAll(mapAi);
        return linkedHashMap;
    }

    public final void setParamCountTo0() {
        this.parameterCount = 0;
    }

    public final void setParams(Object... objArr) {
        StaticHelpers2.addAllFromVar2ToVar1(this.parameters, objArr);
    }
}
