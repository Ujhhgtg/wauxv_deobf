package me.hd.wauxv.obf;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class FieldResolver extends MemberResolver {
    public Object fieldType;
    public IInvokable b;

    public final List resolve() {
        Configuration configurationVar = this.config;
        if (configurationVar == null) {
            throw new IllegalArgumentException(
                    "You must provide a configuration to resolve the member use build(configuration).");
        }
        List listQ = cbp.q(this, configurationVar, configurationVar.declaringClass, new cbo(this, configurationVar, 2));
        throwIfVar1IsNull(listQ,
                "null cannot be cast to non-null type kotlin.collections.List<R of com.highcapable.kavaref.resolver.processor.MemberProcessor.resolve>");
        return listQ;
    }

    @Override // me.hd.wauxv.obf.cbh
    public final Map toFieldsNameValueMap() {
        Map mapX = super.toFieldsNameValueMap();
        Map mapAi = KotlinHelpers.mapOf(new Pair("isEnumConstant", null), new Pair("isEnumConstantNot", null),
                new Pair("type", this.fieldType), new Pair("typeCondition", this.b),
                new Pair("genericType", null), new Pair("genericTypeCondition", null));
        LinkedHashMap linkedHashMap = new LinkedHashMap(mapX);
        linkedHashMap.putAll(mapAi);
        return linkedHashMap;
    }
}
