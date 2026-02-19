package me.hd.wauxv.obf;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class MethodResolver extends ExecutableResolver {
    public Object returnType;
    public IInvokable ai;

    public final List findMethods() {
        Configuration configurationVar = this.config;
        if (configurationVar == null) {
            throw new IllegalArgumentException(
                    "You must provide a configuration to resolve the member use build(configuration).");
        }
        List listQ = cbp.q(this, configurationVar, configurationVar.declaringClass, new cbo(this, configurationVar, 0));
        throwIfVar1IsNull(listQ,
                "null cannot be cast to non-null type kotlin.collections.List<R of com.highcapable.kavaref.resolver.processor.MemberProcessor.resolve>");
        return listQ;
    }

    public final void ak(cdy... cdyVarArr) {
        StaticHelpers2.ao(this.modifiers, (cdy[]) Arrays.copyOf(cdyVarArr, cdyVarArr.length));
    }

    @Override // me.hd.wauxv.obf.axd, me.hd.wauxv.obf.cbh
    public final Map toFieldsNameValueMap() {
        Map mapX = super.toFieldsNameValueMap();
        Map mapAi = KotlinHelpers.mapOf(new Pair("returnType", this.returnType), new Pair("returnTypeCondition", this.ai),
                new Pair("isBridge", null), new Pair("isBridgeNot", null), new Pair("isDefault", null),
                new Pair("isDefaultNot", null));
        LinkedHashMap linkedHashMap = new LinkedHashMap(mapX);
        linkedHashMap.putAll(mapAi);
        return linkedHashMap;
    }
}
