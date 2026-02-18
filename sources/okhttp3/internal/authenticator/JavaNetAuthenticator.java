package okhttp3.internal.authenticator;

import java.net.Authenticator;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.SocketAddress;
import java.util.List;
import me.hd.wauxv.obf.aaz;
import me.hd.wauxv.obf.akd;
import me.hd.wauxv.obf.KotlinHelpers;
import okhttp3.Address;
import okhttp3.Authenticator;
import okhttp3.Challenge;
import okhttp3.Credentials;
import okhttp3.Dns;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class JavaNetAuthenticator implements Authenticator {
    private final Dns defaultDns;

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Proxy.Type.values().length];
            try {
                iArr[Proxy.Type.DIRECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public JavaNetAuthenticator() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private final InetAddress connectToInetAddress(Proxy proxy, HttpUrl httpUrl, Dns dns) {
        Proxy.Type type = proxy.type();
        if ((type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) == 1) {
            return (InetAddress) aaz.e(dns.lookup(httpUrl.host()));
        }
        SocketAddress socketAddressAddress = proxy.address();
        throwIfVar1IsNull(socketAddressAddress, "null cannot be cast to non-null type java.net.InetSocketAddress");
        InetAddress address = ((InetSocketAddress) socketAddressAddress).getAddress();
        throwIfVar1IsNull(address, "address() as InetSocketAddress).address");
        return address;
    }

    @Override // okhttp3.Authenticator
    public Request authenticate(Route route, Response response) {
        Proxy proxy;
        Dns dns;
        PasswordAuthentication passwordAuthenticationRequestPasswordAuthentication;
        Address address;
        throwIfVar1IsNull(response, "response");
        List<Challenge> listChallenges = response.challenges();
        Request request = response.request();
        HttpUrl httpUrlUrl = request.url();
        boolean z = response.code() == 407;
        if (route == null || (proxy = route.proxy()) == null) {
            proxy = Proxy.NO_PROXY;
        }
        for (Challenge challenge : listChallenges) {
            if ("Basic".equalsIgnoreCase(challenge.scheme())) {
                if (route == null || (address = route.address()) == null || (dns = address.dns()) == null) {
                    dns = this.defaultDns;
                }
                if (z) {
                    SocketAddress socketAddressAddress = proxy.address();
                    throwIfVar1IsNull(socketAddressAddress,
                            "null cannot be cast to non-null type java.net.InetSocketAddress");
                    InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
                    passwordAuthenticationRequestPasswordAuthentication = java.net.Authenticator
                            .requestPasswordAuthentication(inetSocketAddress.getHostName(),
                                    connectToInetAddress(proxy, httpUrlUrl, dns), inetSocketAddress.getPort(),
                                    httpUrlUrl.scheme(), challenge.realm(), challenge.scheme(), httpUrlUrl.url(),
                                    Authenticator.RequestorType.PROXY);
                } else {
                    String strHost = httpUrlUrl.host();
                    throwIfVar1IsNull(proxy, "proxy");
                    passwordAuthenticationRequestPasswordAuthentication = java.net.Authenticator
                            .requestPasswordAuthentication(strHost, connectToInetAddress(proxy, httpUrlUrl, dns),
                                    httpUrlUrl.port(), httpUrlUrl.scheme(), challenge.realm(), challenge.scheme(),
                                    httpUrlUrl.url(), Authenticator.RequestorType.SERVER);
                }
                if (passwordAuthenticationRequestPasswordAuthentication != null) {
                    String str = z ? "Proxy-Authorization" : "Authorization";
                    String userName = passwordAuthenticationRequestPasswordAuthentication.getUserName();
                    throwIfVar1IsNull(userName, "auth.userName");
                    char[] password = passwordAuthenticationRequestPasswordAuthentication.getPassword();
                    throwIfVar1IsNull(password, "auth.password");
                    return request.newBuilder()
                            .header(str, Credentials.basic(userName, new String(password), challenge.charset()))
                            .build();
                }
            }
        }
        return null;
    }

    public JavaNetAuthenticator(Dns dns) {
        throwIfVar1IsNull(dns, "defaultDns");
        this.defaultDns = dns;
    }

    public /* synthetic */ JavaNetAuthenticator(Dns dns, int i, akd akdVar) {
        this((i & 1) != 0 ? Dns.SYSTEM : dns);
    }
}
