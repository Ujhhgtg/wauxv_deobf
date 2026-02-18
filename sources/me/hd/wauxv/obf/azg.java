package me.hd.wauxv.obf;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class azg extends cbh {
    public Object a;
    public bgf b;

    public final List c() {
        cbg cbgVar = this.aa;
        if (cbgVar == null) {
            throw new IllegalArgumentException("You must provide a configuration to resolve the member use build(configuration).");
        }
        List listQ = cbp.q(this, cbgVar, cbgVar.a, new cbo(this, cbgVar, 2));
        bzo.o(listQ, "null cannot be cast to non-null type kotlin.collections.List<R of com.highcapable.kavaref.resolver.processor.MemberProcessor.resolve>");
        return listQ;
    }

    @Override // me.hd.wauxv.obf.cbh
    public final Map x() {
        Map mapX = super.x();
        Map mapAi = bzo.ai(new csm("isEnumConstant", null), new csm("isEnumConstantNot", null), new csm(com.umeng.analytics.pro.f.y, this.a), new csm("typeCondition", this.b), new csm("genericType", null), new csm("genericTypeCondition", null));
        LinkedHashMap linkedHashMap = new LinkedHashMap(mapX);
        linkedHashMap.putAll(mapAi);
        return linkedHashMap;
    }
}
