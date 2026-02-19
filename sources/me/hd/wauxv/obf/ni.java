package me.hd.wauxv.obf;

import com.drake.net.exception.URLParseException;
import java.util.List;
import okhttp3.Cache;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpUtils;
import okhttp3.Request;
import okhttp3.internal.cache.DiskLruCache;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ni {
    public HttpUrl.Builder a = new HttpUrl.Builder();
    public final ckw b = ckv.h;
    public int c = 1;
    public final Request.Builder d = new Request.Builder();
    public OkHttpClient e = ckv.c;

    public Request f() {
        Request.Builder builderUrl = this.d.method(bjs.z(this.c), null).url(this.a.build());
        throwIfVar1IsNull(builderUrl, "<this>");
        ckw ckwVar = this.b;
        throwIfVar1IsNull(ckwVar, "converter");
        builderUrl.tag(ckw.class, ckwVar);
        return builderUrl.build();
    }

    public final void g(IInvokable bgfVar) {
        bcm bcmVar;
        OkHttpClient.Builder builderNewBuilder = this.e.newBuilder();
        bgfVar.invoke(builderNewBuilder);
        cqi.a(builderNewBuilder);
        OkHttpClient okHttpClientBuild = builderNewBuilder.build();
        throwIfVar1IsNull(okHttpClientBuild, "value");
        List<Interceptor> listInterceptors = okHttpClientBuild.interceptors();
        cld cldVar = cld.a;
        if (!listInterceptors.contains(cldVar)) {
            okHttpClientBuild = okHttpClientBuild.newBuilder().addInterceptor(cldVar).build();
        }
        this.e = okHttpClientBuild;
        Cache cache = okHttpClientBuild.cache();
        if (cache != null) {
            DiskLruCache diskLruCache = OkHttpUtils.diskLruCache(cache);
            throwIfVar1IsNull(diskLruCache, "diskLruCache(it)");
            bcmVar = new bcm(diskLruCache);
        } else {
            bcmVar = null;
        }
        this.d.tag(bcm.class, bcmVar);
    }

    public final void h(String str) {
        throwIfVar1IsNull(str, "name");
        this.d.tag(cnc.class, new cnc(str));
    }

    public final void i(ahf ahfVar) {
        Request.Builder builder = this.d;
        throwIfVar1IsNull(builder, "<this>");
        if (ahfVar == null) {
            ahfVar = null;
        }
        builder.tag(cni.class, ahfVar != null ? new cni(ahfVar) : null);
    }

    public final void j(String str) throws URLParseException {
        HttpUrl httpUrl = str != null ? HttpUrl.Companion.parse(str) : null;
        if (httpUrl != null) {
            HttpUrl.Builder builderNewBuilder = httpUrl.newBuilder();
            throwIfVar1IsNull(builderNewBuilder, "<set-?>");
            this.a = builderNewBuilder;
            return;
        }
        try {
            HttpUrl.Builder builderNewBuilder2 = HttpUrl.Companion.get(ckv.b + str).newBuilder();
            throwIfVar1IsNull(builderNewBuilder2, "<set-?>");
            this.a = builderNewBuilder2;
        } catch (Throwable th) {
            throw new URLParseException(yg.concatToVar1(new StringBuilder(), ckv.b, str), th);
        }
    }

    public final void k(Object obj) {
        this.d.tag(obj);
    }
}
