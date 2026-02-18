package okhttp3.internal.platform.android;

import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import me.hd.wauxv.obf.akd;
import me.hd.wauxv.obf.bzo;
import okhttp3.Protocol;
import okhttp3.internal.platform.ConscryptPlatform;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.platform.android.DeferredSocketAdapter;
import okhttp3.internal.platform.android.SocketAdapter;
import org.conscrypt.Conscrypt;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ConscryptSocketAdapter implements SocketAdapter {
    public static final Companion Companion = new Companion(null);
    private static final DeferredSocketAdapter.Factory factory = new DeferredSocketAdapter.Factory() { // from class: okhttp3.internal.platform.android.ConscryptSocketAdapter$Companion$factory$1
        @Override // okhttp3.internal.platform.android.DeferredSocketAdapter.Factory
        public SocketAdapter create(SSLSocket sSLSocket) {
            bzo.q(sSLSocket, "sslSocket");
            return new ConscryptSocketAdapter();
        }

        @Override // okhttp3.internal.platform.android.DeferredSocketAdapter.Factory
        public boolean matchesSocket(SSLSocket sSLSocket) {
            bzo.q(sSLSocket, "sslSocket");
            return ConscryptPlatform.Companion.isSupported() && Conscrypt.isConscrypt(sSLSocket);
        }
    };

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static final class Companion {
        public /* synthetic */ Companion(akd akdVar) {
            this();
        }

        public final DeferredSocketAdapter.Factory getFactory() {
            return ConscryptSocketAdapter.factory;
        }

        private Companion() {
        }
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<? extends Protocol> list) {
        bzo.q(sSLSocket, "sslSocket");
        bzo.q(list, "protocols");
        if (matchesSocket(sSLSocket)) {
            Conscrypt.setUseSessionTickets(sSLSocket, true);
            Conscrypt.setApplicationProtocols(sSLSocket, (String[]) Platform.Companion.alpnProtocolNames(list).toArray(new String[0]));
        }
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public String getSelectedProtocol(SSLSocket sSLSocket) {
        bzo.q(sSLSocket, "sslSocket");
        if (matchesSocket(sSLSocket)) {
            return Conscrypt.getApplicationProtocol(sSLSocket);
        }
        return null;
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public boolean isSupported() {
        return ConscryptPlatform.Companion.isSupported();
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public boolean matchesSocket(SSLSocket sSLSocket) {
        bzo.q(sSLSocket, "sslSocket");
        return Conscrypt.isConscrypt(sSLSocket);
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public boolean matchesSocketFactory(SSLSocketFactory sSLSocketFactory) {
        return SocketAdapter.DefaultImpls.matchesSocketFactory(this, sSLSocketFactory);
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) {
        return SocketAdapter.DefaultImpls.trustManager(this, sSLSocketFactory);
    }
}
