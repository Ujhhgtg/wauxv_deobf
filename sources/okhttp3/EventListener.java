package okhttp3;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import me.hd.wauxv.obf.akd;
import me.hd.wauxv.obf.KotlinHelpers;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class EventListener {
    public static final Companion Companion = new Companion(null);
    public static final EventListener NONE = new EventListener() { // from class: okhttp3.EventListener$Companion$NONE$1
    };

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public static final class Companion {
        public /* synthetic */ Companion(akd akdVar) {
            this();
        }

        private Companion() {
        }
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public interface Factory {
        EventListener create(Call call);
    }

    public void cacheConditionalHit(Call call, Response response) {
        throwIfVar1IsNull(call, "call");
        throwIfVar1IsNull(response, "cachedResponse");
    }

    public void cacheHit(Call call, Response response) {
        throwIfVar1IsNull(call, "call");
        throwIfVar1IsNull(response, "response");
    }

    public void cacheMiss(Call call) {
        throwIfVar1IsNull(call, "call");
    }

    public void callEnd(Call call) {
        throwIfVar1IsNull(call, "call");
    }

    public void callFailed(Call call, IOException iOException) {
        throwIfVar1IsNull(call, "call");
        throwIfVar1IsNull(iOException, "ioe");
    }

    public void callStart(Call call) {
        throwIfVar1IsNull(call, "call");
    }

    public void canceled(Call call) {
        throwIfVar1IsNull(call, "call");
    }

    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        throwIfVar1IsNull(call, "call");
        throwIfVar1IsNull(inetSocketAddress, "inetSocketAddress");
        throwIfVar1IsNull(proxy, "proxy");
    }

    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol,
            IOException iOException) {
        throwIfVar1IsNull(call, "call");
        throwIfVar1IsNull(inetSocketAddress, "inetSocketAddress");
        throwIfVar1IsNull(proxy, "proxy");
        throwIfVar1IsNull(iOException, "ioe");
    }

    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        throwIfVar1IsNull(call, "call");
        throwIfVar1IsNull(inetSocketAddress, "inetSocketAddress");
        throwIfVar1IsNull(proxy, "proxy");
    }

    public void connectionAcquired(Call call, Connection connection) {
        throwIfVar1IsNull(call, "call");
        throwIfVar1IsNull(connection, "connection");
    }

    public void connectionReleased(Call call, Connection connection) {
        throwIfVar1IsNull(call, "call");
        throwIfVar1IsNull(connection, "connection");
    }

    public void dnsEnd(Call call, String str, List<InetAddress> list) {
        throwIfVar1IsNull(call, "call");
        throwIfVar1IsNull(str, "domainName");
        throwIfVar1IsNull(list, "inetAddressList");
    }

    public void dnsStart(Call call, String str) {
        throwIfVar1IsNull(call, "call");
        throwIfVar1IsNull(str, "domainName");
    }

    public void proxySelectEnd(Call call, HttpUrl httpUrl, List<Proxy> list) {
        throwIfVar1IsNull(call, "call");
        throwIfVar1IsNull(httpUrl, "url");
        throwIfVar1IsNull(list, "proxies");
    }

    public void proxySelectStart(Call call, HttpUrl httpUrl) {
        throwIfVar1IsNull(call, "call");
        throwIfVar1IsNull(httpUrl, "url");
    }

    public void requestBodyEnd(Call call, long j) {
        throwIfVar1IsNull(call, "call");
    }

    public void requestBodyStart(Call call) {
        throwIfVar1IsNull(call, "call");
    }

    public void requestFailed(Call call, IOException iOException) {
        throwIfVar1IsNull(call, "call");
        throwIfVar1IsNull(iOException, "ioe");
    }

    public void requestHeadersEnd(Call call, Request request) {
        throwIfVar1IsNull(call, "call");
        throwIfVar1IsNull(request, "request");
    }

    public void requestHeadersStart(Call call) {
        throwIfVar1IsNull(call, "call");
    }

    public void responseBodyEnd(Call call, long j) {
        throwIfVar1IsNull(call, "call");
    }

    public void responseBodyStart(Call call) {
        throwIfVar1IsNull(call, "call");
    }

    public void responseFailed(Call call, IOException iOException) {
        throwIfVar1IsNull(call, "call");
        throwIfVar1IsNull(iOException, "ioe");
    }

    public void responseHeadersEnd(Call call, Response response) {
        throwIfVar1IsNull(call, "call");
        throwIfVar1IsNull(response, "response");
    }

    public void responseHeadersStart(Call call) {
        throwIfVar1IsNull(call, "call");
    }

    public void satisfactionFailure(Call call, Response response) {
        throwIfVar1IsNull(call, "call");
        throwIfVar1IsNull(response, "response");
    }

    public void secureConnectEnd(Call call, Handshake handshake) {
        throwIfVar1IsNull(call, "call");
    }

    public void secureConnectStart(Call call) {
        throwIfVar1IsNull(call, "call");
    }
}
