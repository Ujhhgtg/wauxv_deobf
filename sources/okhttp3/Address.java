package okhttp3;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import me.hd.wauxv.obf.bjs;
import me.hd.wauxv.obf.KotlinHelpers;
import okhttp3.HttpUrl;
import okhttp3.internal.Util;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class Address {
    private final CertificatePinner certificatePinner;
    private final List<ConnectionSpec> connectionSpecs;
    private final Dns dns;
    private final HostnameVerifier hostnameVerifier;
    private final List<Protocol> protocols;
    private final Proxy proxy;
    private final Authenticator proxyAuthenticator;
    private final ProxySelector proxySelector;
    private final SocketFactory socketFactory;
    private final SSLSocketFactory sslSocketFactory;
    private final HttpUrl url;

    public Address(String str, int i, Dns dns, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory,
            HostnameVerifier hostnameVerifier, CertificatePinner certificatePinner, Authenticator authenticator,
            Proxy proxy, List<? extends Protocol> list, List<ConnectionSpec> list2, ProxySelector proxySelector) {
        throwIfVar1IsNull(str, "uriHost");
        throwIfVar1IsNull(dns, "dns");
        throwIfVar1IsNull(socketFactory, "socketFactory");
        throwIfVar1IsNull(authenticator, "proxyAuthenticator");
        throwIfVar1IsNull(list, "protocols");
        throwIfVar1IsNull(list2, "connectionSpecs");
        throwIfVar1IsNull(proxySelector, "proxySelector");
        this.dns = dns;
        this.socketFactory = socketFactory;
        this.sslSocketFactory = sSLSocketFactory;
        this.hostnameVerifier = hostnameVerifier;
        this.certificatePinner = certificatePinner;
        this.proxyAuthenticator = authenticator;
        this.proxy = proxy;
        this.proxySelector = proxySelector;
        this.url = new HttpUrl.Builder().scheme(sSLSocketFactory != null ? "https" : "http").host(str).port(i).build();
        this.protocols = Util.toImmutableList(list);
        this.connectionSpecs = Util.toImmutableList(list2);
    }

    public final CertificatePinner a() {
        return this.certificatePinner;
    }

    public final List<ConnectionSpec> b() {
        return this.connectionSpecs;
    }

    public final Dns c() {
        return this.dns;
    }

    public final CertificatePinner certificatePinner() {
        return this.certificatePinner;
    }

    public final List<ConnectionSpec> connectionSpecs() {
        return this.connectionSpecs;
    }

    public final HostnameVerifier d() {
        return this.hostnameVerifier;
    }

    public final Dns dns() {
        return this.dns;
    }

    public final List<Protocol> e() {
        return this.protocols;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Address)) {
            return false;
        }
        Address address = (Address) obj;
        return nullSafeIsEqual(this.url, address.url) && equalsNonHost$okhttp(address);
    }

    public final boolean equalsNonHost$okhttp(Address address) {
        throwIfVar1IsNull(address, "that");
        return nullSafeIsEqual(this.dns, address.dns)
                && nullSafeIsEqual(this.proxyAuthenticator, address.proxyAuthenticator)
                && nullSafeIsEqual(this.protocols, address.protocols)
                && nullSafeIsEqual(this.connectionSpecs, address.connectionSpecs)
                && nullSafeIsEqual(this.proxySelector, address.proxySelector)
                && nullSafeIsEqual(this.proxy, address.proxy)
                && nullSafeIsEqual(this.sslSocketFactory, address.sslSocketFactory)
                && nullSafeIsEqual(this.hostnameVerifier, address.hostnameVerifier)
                && nullSafeIsEqual(this.certificatePinner, address.certificatePinner)
                && this.url.port() == address.url.port();
    }

    public final Proxy f() {
        return this.proxy;
    }

    public final Authenticator g() {
        return this.proxyAuthenticator;
    }

    public final ProxySelector h() {
        return this.proxySelector;
    }

    public int hashCode() {
        return Objects.hashCode(this.certificatePinner) + ((Objects.hashCode(this.hostnameVerifier) + ((Objects
                .hashCode(this.sslSocketFactory)
                + ((Objects.hashCode(this.proxy) + ((this.proxySelector.hashCode() + bjs.g(this.connectionSpecs,
                        bjs.g(this.protocols,
                                (this.proxyAuthenticator.hashCode()
                                        + ((this.dns.hashCode() + ((this.url.hashCode() + 527) * 31)) * 31)) * 31,
                                31),
                        31)) * 31)) * 31))
                * 31)) * 31);
    }

    public final HostnameVerifier hostnameVerifier() {
        return this.hostnameVerifier;
    }

    public final SocketFactory i() {
        return this.socketFactory;
    }

    public final SSLSocketFactory j() {
        return this.sslSocketFactory;
    }

    public final HttpUrl k() {
        return this.url;
    }

    public final List<Protocol> protocols() {
        return this.protocols;
    }

    public final Proxy proxy() {
        return this.proxy;
    }

    public final Authenticator proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    public final ProxySelector proxySelector() {
        return this.proxySelector;
    }

    public final SocketFactory socketFactory() {
        return this.socketFactory;
    }

    public final SSLSocketFactory sslSocketFactory() {
        return this.sslSocketFactory;
    }

    public String toString() {
        StringBuilder sb;
        Object obj;
        StringBuilder sb2 = new StringBuilder("Address{");
        sb2.append(this.url.host());
        sb2.append(':');
        sb2.append(this.url.port());
        sb2.append(", ");
        if (this.proxy != null) {
            sb = new StringBuilder("proxy=");
            obj = this.proxy;
        } else {
            sb = new StringBuilder("proxySelector=");
            obj = this.proxySelector;
        }
        sb.append(obj);
        return concat(sb2, sb.toString(), '}');
    }

    public final HttpUrl url() {
        return this.url;
    }
}
