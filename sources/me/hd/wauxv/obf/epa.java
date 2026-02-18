package me.hd.wauxv.obf;

import com.alibaba.fastjson2.filter.ValueFilter;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class epa implements ValueFilter {
    public final /* synthetic */ int e;
    public final /* synthetic */ Object f;
    public final /* synthetic */ Object g;

    public /* synthetic */ epa(Object obj, int i, Object obj2) {
        this.e = i;
        this.f = obj;
        this.g = obj2;
    }

    @Override // com.alibaba.fastjson2.filter.ValueFilter
    public final Object apply(Object obj, String str, Object obj2) {
        switch (this.e) {
            case 0:
                return ValueFilter.lambda$compose$0((ValueFilter) this.f, (ValueFilter) this.g, obj, str, obj2);
            case 1:
                return ValueFilter.lambda$of$1((String) this.f, (Function) this.g, obj, str, obj2);
            case 2:
                return ValueFilter.lambda$of$2((String) this.f, (Map) this.g, obj, str, obj2);
            default:
                return ValueFilter.lambda$of$3((Predicate) this.f, (Function) this.g, obj, str, obj2);
        }
    }
}
