package me.hd.wauxv.obf;

import com.alibaba.fastjson2.PropertyNamingStrategy;
import com.alibaba.fastjson2.filter.NameFilter;
import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class cij implements NameFilter {
    public final /* synthetic */ int d;
    public final /* synthetic */ Object e;

    public /* synthetic */ cij(Object obj, int i) {
        this.d = i;
        this.e = obj;
    }

    @Override // com.alibaba.fastjson2.filter.NameFilter
    public final String process(Object obj, String str, Object obj2) {
        switch (this.d) {
            case 0:
                return NameFilter.lambda$of$0((PropertyNamingStrategy) this.e, obj, str, obj2);
            default:
                return NameFilter.lambda$of$2((Function) this.e, obj, str, obj2);
        }
    }
}
