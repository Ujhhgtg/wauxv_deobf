package me.hd.wauxv.obf;

import java.lang.ref.WeakReference;
import java.util.Iterator;
import okhttp3.Call;
import okhttp3.Interceptor;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class clc extends btp implements bfu {
    public final /* synthetic */ Interceptor.Chain a;

    /*
     * JADX WARN: 'super' call moved to the top of the method (can break code
     * semantics)
     */
    public clc(Interceptor.Chain chain) {
        super(0);
        this.a = chain;
    }

    @Override // me.hd.wauxv.obf.bfu
    public final Object invoke() {
        Iterator it = ckv.g.iterator();
        throwIfVar1IsNull(it, "NetConfig.runningCalls.iterator()");
        while (it.hasNext()) {
            Call call = (Call) ((WeakReference) it.next()).get();
            if (call == null) {
                it.remove();
            } else if (call.equals(this.a.call())) {
                it.remove();
                break;
            }
        }
        return Kotlin$Unit.INSTANCE;
    }
}
