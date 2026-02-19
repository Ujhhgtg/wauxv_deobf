package okhttp3;

import com.umeng.analytics.pro.f;
import java.io.IOException;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import me.hd.wauxv.obf.aaz;
import me.hd.wauxv.obf.abb;
import me.hd.wauxv.obf.akd;
import me.hd.wauxv.obf.EmptyReadonlyList;
import me.hd.wauxv.obf.bfu;
import me.hd.wauxv.obf.btp;
import me.hd.wauxv.obf.IHasGetValue;
import me.hd.wauxv.obf.dov;
import okhttp3.internal.Util;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class Handshake {
    public static final Companion Companion = new Companion(null);
    private final CipherSuite cipherSuite;
    private final List<Certificate> localCertificates;
    private final IHasGetValue peerCertificates$delegate;
    private final TlsVersion tlsVersion;

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public static final class Companion {
        public /* synthetic */ Companion(akd akdVar) {
            this();
        }

        private final List<Certificate> toImmutableList(Certificate[] certificateArr) {
            return certificateArr != null ? Util.immutableListOf(Arrays.copyOf(certificateArr, certificateArr.length))
                    : EmptyReadonlyList.a;
        }

        public final Handshake a(SSLSession sSLSession) {
            throwIfVar1IsNull(sSLSession, "sslSession");
            return get(sSLSession);
        }

        public final Handshake get(SSLSession sSLSession) throws IOException {
            List<Certificate> immutableList;
            throwIfVar1IsNull(sSLSession, "<this>");
            String cipherSuite = sSLSession.getCipherSuite();
            if (cipherSuite == null) {
                throw new IllegalStateException("cipherSuite == null");
            }
            if (cipherSuite.equals("TLS_NULL_WITH_NULL_NULL") ? true : cipherSuite.equals("SSL_NULL_WITH_NULL_NULL")) {
                throw new IOException("cipherSuite == ".concat(cipherSuite));
            }
            CipherSuite cipherSuiteForJavaName = CipherSuite.Companion.forJavaName(cipherSuite);
            String protocol = sSLSession.getProtocol();
            if (protocol == null) {
                throw new IllegalStateException("tlsVersion == null");
            }
            if ("NONE".equals(protocol)) {
                throw new IOException("tlsVersion == NONE");
            }
            TlsVersion tlsVersionForJavaName = TlsVersion.Companion.forJavaName(protocol);
            try {
                immutableList = toImmutableList(sSLSession.getPeerCertificates());
            } catch (SSLPeerUnverifiedException unused) {
                immutableList = EmptyReadonlyList.a;
            }
            return new Handshake(tlsVersionForJavaName, cipherSuiteForJavaName,
                    toImmutableList(sSLSession.getLocalCertificates()),
                    new Handshake$Companion$handshake$1(immutableList));
        }

        private Companion() {
        }

        public final Handshake get(TlsVersion tlsVersion, CipherSuite cipherSuite, List<? extends Certificate> list,
                List<? extends Certificate> list2) {
            throwIfVar1IsNull(tlsVersion, "tlsVersion");
            throwIfVar1IsNull(cipherSuite, "cipherSuite");
            throwIfVar1IsNull(list, "peerCertificates");
            throwIfVar1IsNull(list2, "localCertificates");
            return new Handshake(tlsVersion, cipherSuite, Util.toImmutableList(list2),
                    new Handshake$Companion$get$1(Util.toImmutableList(list)));
        }
    }

    /*
     * JADX INFO: renamed from: okhttp3.Handshake$peerCertificates$2, reason:
     * invalid class name
     */
    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public static final class AnonymousClass2 extends btp implements bfu {
        final /* synthetic */ bfu $peerCertificatesFn;

        /*
         * JADX WARN: 'super' call moved to the top of the method (can break code
         * semantics)
         */
        public AnonymousClass2(bfu bfuVar) {
            super(0);
            this.$peerCertificatesFn = bfuVar;
        }

        @Override // me.hd.wauxv.obf.bfu
        public final List<Certificate> invoke() {
            try {
                return (List) this.$peerCertificatesFn.invoke();
            } catch (SSLPeerUnverifiedException unused) {
                return EmptyReadonlyList.a;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Handshake(TlsVersion tlsVersion, CipherSuite cipherSuite, List<? extends Certificate> list, bfu bfuVar) {
        throwIfVar1IsNull(tlsVersion, "tlsVersion");
        throwIfVar1IsNull(cipherSuite, "cipherSuite");
        throwIfVar1IsNull(list, "localCertificates");
        throwIfVar1IsNull(bfuVar, "peerCertificatesFn");
        this.tlsVersion = tlsVersion;
        this.cipherSuite = cipherSuite;
        this.localCertificates = list;
        this.peerCertificates$delegate = new dov(new AnonymousClass2(bfuVar));
    }

    public static final Handshake get(SSLSession sSLSession) {
        return Companion.get(sSLSession);
    }

    private final String getName(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return ((X509Certificate) certificate).getSubjectDN().toString();
        }
        String type = certificate.getType();
        throwIfVar1IsNull(type, f.y);
        return type;
    }

    public final CipherSuite a() {
        return this.cipherSuite;
    }

    public final List<Certificate> b() {
        return this.localCertificates;
    }

    public final Principal c() {
        return localPrincipal();
    }

    public final CipherSuite cipherSuite() {
        return this.cipherSuite;
    }

    public final List<Certificate> d() {
        return peerCertificates();
    }

    public final Principal e() {
        return peerPrincipal();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Handshake)) {
            return false;
        }
        Handshake handshake = (Handshake) obj;
        return handshake.tlsVersion == this.tlsVersion && nullSafeIsEqual(handshake.cipherSuite, this.cipherSuite)
                && nullSafeIsEqual(handshake.peerCertificates(), peerCertificates())
                && nullSafeIsEqual(handshake.localCertificates, this.localCertificates);
    }

    public final TlsVersion f() {
        return this.tlsVersion;
    }

    public int hashCode() {
        return this.localCertificates.hashCode() + ((peerCertificates().hashCode()
                + ((this.cipherSuite.hashCode() + ((this.tlsVersion.hashCode() + 527) * 31)) * 31)) * 31);
    }

    public final List<Certificate> localCertificates() {
        return this.localCertificates;
    }

    public final Principal localPrincipal() {
        Object objG = aaz.g(this.localCertificates);
        X509Certificate x509Certificate = objG instanceof X509Certificate ? (X509Certificate) objG : null;
        if (x509Certificate != null) {
            return x509Certificate.getSubjectX500Principal();
        }
        return null;
    }

    public final List<Certificate> peerCertificates() {
        return (List) this.peerCertificates$delegate.getValue();
    }

    public final Principal peerPrincipal() {
        Object objG = aaz.g(peerCertificates());
        X509Certificate x509Certificate = objG instanceof X509Certificate ? (X509Certificate) objG : null;
        if (x509Certificate != null) {
            return x509Certificate.getSubjectX500Principal();
        }
        return null;
    }

    public final TlsVersion tlsVersion() {
        return this.tlsVersion;
    }

    public String toString() {
        List<Certificate> listPeerCertificates = peerCertificates();
        ArrayList arrayList = new ArrayList(abb.ak(listPeerCertificates, 10));
        Iterator<T> it = listPeerCertificates.iterator();
        while (it.hasNext()) {
            arrayList.add(getName((Certificate) it.next()));
        }
        String string = arrayList.toString();
        StringBuilder sb = new StringBuilder("Handshake{tlsVersion=");
        sb.append(this.tlsVersion);
        sb.append(" cipherSuite=");
        sb.append(this.cipherSuite);
        sb.append(" peerCertificates=");
        sb.append(string);
        sb.append(" localCertificates=");
        List<Certificate> list = this.localCertificates;
        ArrayList arrayList2 = new ArrayList(abb.ak(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList2.add(getName((Certificate) it2.next()));
        }
        sb.append(arrayList2);
        sb.append('}');
        return sb.toString();
    }

    public static final Handshake get(TlsVersion tlsVersion, CipherSuite cipherSuite, List<? extends Certificate> list,
            List<? extends Certificate> list2) {
        return Companion.get(tlsVersion, cipherSuite, list, list2);
    }
}
