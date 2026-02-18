package me.hd.wauxv.obf;

import java.util.List;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class cqi {
    public static final void a(OkHttpClient.Builder builder) {
        throwIfVar1IsNull(builder, "<this>");
        List<Interceptor> listInterceptors = builder.interceptors();
        cld cldVar = cld.a;
        if (listInterceptors.contains(cldVar)) {
            return;
        }
        builder.addInterceptor(cldVar);
    }
}
