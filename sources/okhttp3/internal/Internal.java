package okhttp3.internal;

import javax.net.ssl.SSLSocket;
import me.hd.wauxv.obf.bzo;
import okhttp3.Cache;
import okhttp3.ConnectionSpec;
import okhttp3.Cookie;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class Internal {
    public static final Headers.Builder addHeaderLenient(Headers.Builder builder, String str) {
        bzo.q(builder, "builder");
        bzo.q(str, "line");
        return builder.addLenient$okhttp(str);
    }

    public static final void applyConnectionSpec(ConnectionSpec connectionSpec, SSLSocket sSLSocket, boolean z) {
        bzo.q(connectionSpec, "connectionSpec");
        bzo.q(sSLSocket, "sslSocket");
        connectionSpec.apply$okhttp(sSLSocket, z);
    }

    public static final Response cacheGet(Cache cache, Request request) {
        bzo.q(cache, "cache");
        bzo.q(request, "request");
        return cache.get$okhttp(request);
    }

    public static final String cookieToString(Cookie cookie, boolean z) {
        bzo.q(cookie, "cookie");
        return cookie.toString$okhttp(z);
    }

    public static final Cookie parseCookie(long j, HttpUrl httpUrl, String str) {
        bzo.q(httpUrl, "url");
        bzo.q(str, "setCookie");
        return Cookie.Companion.parse$okhttp(j, httpUrl, str);
    }

    public static final Headers.Builder addHeaderLenient(Headers.Builder builder, String str, String str2) {
        bzo.q(builder, "builder");
        bzo.q(str, "name");
        bzo.q(str2, "value");
        return builder.addLenient$okhttp(str, str2);
    }
}
