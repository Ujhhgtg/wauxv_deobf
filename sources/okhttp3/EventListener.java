package okhttp3;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import me.hd.wauxv.obf.akd;
import me.hd.wauxv.obf.bzo;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class EventListener {
    public static final Companion Companion = new Companion(null);
    public static final EventListener NONE = new EventListener() { // from class: okhttp3.EventListener$Companion$NONE$1
    };

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static final class Companion {
        public /* synthetic */ Companion(akd akdVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public interface Factory {
        EventListener create(Call call);
    }

    public void cacheConditionalHit(Call call, Response response) {
        bzo.q(call, "call");
        bzo.q(response, "cachedResponse");
    }

    public void cacheHit(Call call, Response response) {
        bzo.q(call, "call");
        bzo.q(response, "response");
    }

    public void cacheMiss(Call call) {
        bzo.q(call, "call");
    }

    public void callEnd(Call call) {
        bzo.q(call, "call");
    }

    public void callFailed(Call call, IOException iOException) {
        bzo.q(call, "call");
        bzo.q(iOException, "ioe");
    }

    public void callStart(Call call) {
        bzo.q(call, "call");
    }

    public void canceled(Call call) {
        bzo.q(call, "call");
    }

    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        bzo.q(call, "call");
        bzo.q(inetSocketAddress, "inetSocketAddress");
        bzo.q(proxy, "proxy");
    }

    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
        bzo.q(call, "call");
        bzo.q(inetSocketAddress, "inetSocketAddress");
        bzo.q(proxy, "proxy");
        bzo.q(iOException, "ioe");
    }

    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        bzo.q(call, "call");
        bzo.q(inetSocketAddress, "inetSocketAddress");
        bzo.q(proxy, "proxy");
    }

    public void connectionAcquired(Call call, Connection connection) {
        bzo.q(call, "call");
        bzo.q(connection, "connection");
    }

    public void connectionReleased(Call call, Connection connection) {
        bzo.q(call, "call");
        bzo.q(connection, "connection");
    }

    public void dnsEnd(Call call, String str, List<InetAddress> list) {
        bzo.q(call, "call");
        bzo.q(str, "domainName");
        bzo.q(list, "inetAddressList");
    }

    public void dnsStart(Call call, String str) {
        bzo.q(call, "call");
        bzo.q(str, "domainName");
    }

    public void proxySelectEnd(Call call, HttpUrl httpUrl, List<Proxy> list) {
        bzo.q(call, "call");
        bzo.q(httpUrl, "url");
        bzo.q(list, "proxies");
    }

    public void proxySelectStart(Call call, HttpUrl httpUrl) {
        bzo.q(call, "call");
        bzo.q(httpUrl, "url");
    }

    public void requestBodyEnd(Call call, long j) {
        bzo.q(call, "call");
    }

    public void requestBodyStart(Call call) {
        bzo.q(call, "call");
    }

    public void requestFailed(Call call, IOException iOException) {
        bzo.q(call, "call");
        bzo.q(iOException, "ioe");
    }

    public void requestHeadersEnd(Call call, Request request) {
        bzo.q(call, "call");
        bzo.q(request, "request");
    }

    public void requestHeadersStart(Call call) {
        bzo.q(call, "call");
    }

    public void responseBodyEnd(Call call, long j) {
        bzo.q(call, "call");
    }

    public void responseBodyStart(Call call) {
        bzo.q(call, "call");
    }

    public void responseFailed(Call call, IOException iOException) {
        bzo.q(call, "call");
        bzo.q(iOException, "ioe");
    }

    public void responseHeadersEnd(Call call, Response response) {
        bzo.q(call, "call");
        bzo.q(response, "response");
    }

    public void responseHeadersStart(Call call) {
        bzo.q(call, "call");
    }

    public void satisfactionFailure(Call call, Response response) {
        bzo.q(call, "call");
        bzo.q(response, "response");
    }

    public void secureConnectEnd(Call call, Handshake handshake) {
        bzo.q(call, "call");
    }

    public void secureConnectStart(Call call) {
        bzo.q(call, "call");
    }
}
