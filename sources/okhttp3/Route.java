package okhttp3;

import java.net.InetSocketAddress;
import java.net.Proxy;
import me.hd.wauxv.obf.KotlinHelpers;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class Route {
    private final Address address;
    private final Proxy proxy;
    private final InetSocketAddress socketAddress;

    public Route(Address address, Proxy proxy, InetSocketAddress inetSocketAddress) {
        throwIfVar1IsNull(address, "address");
        throwIfVar1IsNull(proxy, "proxy");
        throwIfVar1IsNull(inetSocketAddress, "socketAddress");
        this.address = address;
        this.proxy = proxy;
        this.socketAddress = inetSocketAddress;
    }

    public final Address a() {
        return this.address;
    }

    public final Address address() {
        return this.address;
    }

    public final Proxy b() {
        return this.proxy;
    }

    public final InetSocketAddress c() {
        return this.socketAddress;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Route)) {
            return false;
        }
        Route route = (Route) obj;
        return nullSafeIsEqual(route.address, this.address) && nullSafeIsEqual(route.proxy, this.proxy)
                && nullSafeIsEqual(route.socketAddress, this.socketAddress);
    }

    public int hashCode() {
        return this.socketAddress.hashCode() + ((this.proxy.hashCode() + ((this.address.hashCode() + 527) * 31)) * 31);
    }

    public final Proxy proxy() {
        return this.proxy;
    }

    public final boolean requiresTunnel() {
        return this.address.sslSocketFactory() != null && this.proxy.type() == Proxy.Type.HTTP;
    }

    public final InetSocketAddress socketAddress() {
        return this.socketAddress;
    }

    public String toString() {
        return "Route{" + this.socketAddress + '}';
    }
}
