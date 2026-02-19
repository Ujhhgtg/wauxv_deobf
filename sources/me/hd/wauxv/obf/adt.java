package me.hd.wauxv.obf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class adt extends ExecutableResolver {
    public final List a() {
        Configuration configurationVar = this.config;
        if (configurationVar == null) {
            throw new IllegalArgumentException(
                    "You must provide a configuration to resolve the member use build(configuration).");
        }
        List listQ = cbp.q(this, configurationVar, configurationVar.declaringClass, new cbo(this, configurationVar, 1));
        throwIfVar1IsNull(listQ,
                "null cannot be cast to non-null type kotlin.collections.List<R of com.highcapable.kavaref.resolver.processor.MemberProcessor.resolve>");
        return listQ;
    }
}
