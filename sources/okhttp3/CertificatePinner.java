package okhttp3;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import me.hd.wauxv.obf.StaticHelpers5;
import me.hd.wauxv.obf.StaticHelpers4;
import me.hd.wauxv.obf.akd;
import me.hd.wauxv.obf.EmptyReadonlyList;
import me.hd.wauxv.obf.IFunction0;
import me.hd.wauxv.obf.bjs;
import me.hd.wauxv.obf.btp;
import me.hd.wauxv.obf.dnj;
import me.hd.wauxv.obf.dnr;
import me.hd.wauxv.obf.emc;
import me.hd.wauxv.obf.SomeStaticHelpers;
import me.hd.wauxv.obf.nu;
import me.hd.wauxv.obf.sj;
import net.bytebuddy.pool.TypePool;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.tls.CertificateChainCleaner;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class CertificatePinner {
    public static final Companion Companion = new Companion(null);
    public static final CertificatePinner DEFAULT = new Builder().build();
    private final CertificateChainCleaner certificateChainCleaner;
    private final Set<Pin> pins;

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public static final class Builder {
        private final List<Pin> pins = new ArrayList();

        public final Builder add(String str, String... strArr) {
            throwIfVar1IsNull(str, "pattern");
            throwIfVar1IsNull(strArr, "pins");
            for (String str2 : strArr) {
                this.pins.add(new Pin(str, str2));
            }
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final CertificatePinner build() {
            return new CertificatePinner(StaticHelpers5.ad(this.pins), null, 2, 0 == true ? 1 : 0);
        }

        public final List<Pin> getPins() {
            return this.pins;
        }
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public static final class Companion {
        public /* synthetic */ Companion(akd akdVar) {
            this();
        }

        public final String pin(Certificate certificate) {
            throwIfVar1IsNull(certificate, "certificate");
            if (!(certificate instanceof X509Certificate)) {
                throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
            }
            return "sha256/" + sha256Hash((X509Certificate) certificate).e();
        }

        public final sj sha1Hash(X509Certificate x509Certificate) {
            throwIfVar1IsNull(x509Certificate, "<this>");
            sj sjVar = sj.a;
            byte[] encoded = x509Certificate.getPublicKey().getEncoded();
            throwIfVar1IsNull(encoded, "publicKey.encoded");
            return nu.i(encoded).f("SHA-1");
        }

        public final sj sha256Hash(X509Certificate x509Certificate) {
            throwIfVar1IsNull(x509Certificate, "<this>");
            sj sjVar = sj.a;
            byte[] encoded = x509Certificate.getPublicKey().getEncoded();
            throwIfVar1IsNull(encoded, "publicKey.encoded");
            return nu.i(encoded).f("SHA-256");
        }

        private Companion() {
        }
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public static final class Pin {
        private final sj hash;
        private final String hashAlgorithm;
        private final String pattern;

        public Pin(String str, String str2) {
            throwIfVar1IsNull(str, "pattern");
            throwIfVar1IsNull(str2, "pin");
            if ((!dnr.bp(str, "*.", false) || dnj.ai(str, "*", 1, false, 4) != -1)
                    && ((!dnr.bp(str, "**.", false) || dnj.ai(str, "*", 2, false, 4) != -1)
                            && dnj.ai(str, "*", 0, false, 6) != -1)) {
                throw new IllegalArgumentException("Unexpected pattern: ".concat(str).toString());
            }
            String canonicalHost = HostnamesKt.toCanonicalHost(str);
            if (canonicalHost == null) {
                throw new IllegalArgumentException("Invalid pattern: ".concat(str));
            }
            this.pattern = canonicalHost;
            if (dnr.bp(str2, "sha1/", false)) {
                this.hashAlgorithm = "sha1";
                sj sjVar = sj.a;
                String strSubstring = str2.substring(5);
                throwIfVar1IsNull(strSubstring, "this as java.lang.String).substring(startIndex)");
                sj sjVarE = nu.e(strSubstring);
                if (sjVarE == null) {
                    throw new IllegalArgumentException("Invalid pin hash: ".concat(str2));
                }
                this.hash = sjVarE;
                return;
            }
            if (!dnr.bp(str2, "sha256/", false)) {
                throw new IllegalArgumentException("pins must start with 'sha256/' or 'sha1/': ".concat(str2));
            }
            this.hashAlgorithm = "sha256";
            sj sjVar2 = sj.a;
            String strSubstring2 = str2.substring(7);
            throwIfVar1IsNull(strSubstring2, "this as java.lang.String).substring(startIndex)");
            sj sjVarE2 = nu.e(strSubstring2);
            if (sjVarE2 == null) {
                throw new IllegalArgumentException("Invalid pin hash: ".concat(str2));
            }
            this.hash = sjVarE2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Pin)) {
                return false;
            }
            Pin pin = (Pin) obj;
            return nullSafeIsEqual(this.pattern, pin.pattern) && nullSafeIsEqual(this.hashAlgorithm, pin.hashAlgorithm)
                    && nullSafeIsEqual(this.hash, pin.hash);
        }

        public final sj getHash() {
            return this.hash;
        }

        public final String getHashAlgorithm() {
            return this.hashAlgorithm;
        }

        public final String getPattern() {
            return this.pattern;
        }

        public int hashCode() {
            return this.hash.hashCode() + bjs.e(this.hashAlgorithm, this.pattern.hashCode() * 31, 31);
        }

        public final boolean matchesCertificate(X509Certificate x509Certificate) {
            throwIfVar1IsNull(x509Certificate, "certificate");
            String str = this.hashAlgorithm;
            if (nullSafeIsEqual(str, "sha256")) {
                return nullSafeIsEqual(this.hash, CertificatePinner.Companion.sha256Hash(x509Certificate));
            }
            if (nullSafeIsEqual(str, "sha1")) {
                return nullSafeIsEqual(this.hash, CertificatePinner.Companion.sha1Hash(x509Certificate));
            }
            return false;
        }

        /* JADX WARN: Found duplicated region for block: B:16:0x006b A[RETURN] */
        /* JADX WARN: Found duplicated region for block: B:17:0x006c A[RETURN] */
        public final boolean matchesHostname(String str) {
            throwIfVar1IsNull(str, "hostname");
            if (dnr.bp(this.pattern, "**.", false)) {
                int length = this.pattern.length() - 3;
                int length2 = str.length() - length;
                return dnr.bl(str.length() - length, 3, length, str, this.pattern, false)
                        && (length2 == 0 || str.charAt(length2 - 1) == '.');
            }
            if (!dnr.bp(this.pattern, "*.", false)) {
                return str.equals(this.pattern);
            }
            int length3 = this.pattern.length() - 1;
            int length4 = str.length() - length3;
            if (!dnr.bl(str.length() - length3, 1, length3, str, this.pattern, false) || dnj.am(str,
                    TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH, length4 - 1, 4) != -1) {
            }
        }

        public String toString() {
            return this.hashAlgorithm + '/' + this.hash.e();
        }
    }

    /*
     * JADX INFO: renamed from: okhttp3.CertificatePinner$check$1, reason: invalid
     * class name
     */
    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public static final class AnonymousClass1 extends btp implements IFunction0 {
        final /* synthetic */ String $hostname;
        final /* synthetic */ List<Certificate> $peerCertificates;

        /*
         * JADX WARN: 'super' call moved to the top of the method (can break code
         * semantics)
         */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(List<? extends Certificate> list, String str) {
            super(0);
            this.$peerCertificates = list;
            this.$hostname = str;
        }

        @Override // me.hd.wauxv.obf.bfu
        public final List<X509Certificate> invoke() {
            List<Certificate> listClean;
            CertificateChainCleaner certificateChainCleaner$okhttp = CertificatePinner.this
                    .getCertificateChainCleaner$okhttp();
            if (certificateChainCleaner$okhttp == null || (listClean = certificateChainCleaner$okhttp
                    .clean(this.$peerCertificates, this.$hostname)) == null) {
                listClean = this.$peerCertificates;
            }
            ArrayList arrayList = new ArrayList(StaticHelpers4.ak(listClean, 10));
            for (Certificate certificate : listClean) {
                throwIfVar1IsNull(certificate,
                        "null cannot be cast to non-null type java.security.cert.X509Certificate");
                arrayList.add((X509Certificate) certificate);
            }
            return arrayList;
        }
    }

    public CertificatePinner(Set<Pin> set, CertificateChainCleaner certificateChainCleaner) {
        throwIfVar1IsNull(set, "pins");
        this.pins = set;
        this.certificateChainCleaner = certificateChainCleaner;
    }

    public static final String pin(Certificate certificate) {
        return Companion.pin(certificate);
    }

    public static final sj sha1Hash(X509Certificate x509Certificate) {
        return Companion.sha1Hash(x509Certificate);
    }

    public static final sj sha256Hash(X509Certificate x509Certificate) {
        return Companion.sha256Hash(x509Certificate);
    }

    public final void check(String str, List<? extends Certificate> list) {
        throwIfVar1IsNull(str, "hostname");
        throwIfVar1IsNull(list, "peerCertificates");
        check$okhttp(str, new AnonymousClass1(list, str));
    }

    public final void check$okhttp(String str, IFunction0 bfuVar) throws SSLPeerUnverifiedException {
        throwIfVar1IsNull(str, "hostname");
        throwIfVar1IsNull(bfuVar, "cleanedPeerCertificatesFn");
        List<Pin> listFindMatchingPins = findMatchingPins(str);
        if (listFindMatchingPins.isEmpty()) {
            return;
        }
        List<X509Certificate> list = (List) bfuVar.invoke();
        for (X509Certificate x509Certificate : list) {
            sj sjVarSha256Hash = null;
            sj sjVarSha1Hash = null;
            for (Pin pin : listFindMatchingPins) {
                String hashAlgorithm = pin.getHashAlgorithm();
                if (nullSafeIsEqual(hashAlgorithm, "sha256")) {
                    if (sjVarSha256Hash == null) {
                        sjVarSha256Hash = Companion.sha256Hash(x509Certificate);
                    }
                    if (nullSafeIsEqual(pin.getHash(), sjVarSha256Hash)) {
                        return;
                    }
                } else {
                    if (!nullSafeIsEqual(hashAlgorithm, "sha1")) {
                        throw new AssertionError("unsupported hashAlgorithm: " + pin.getHashAlgorithm());
                    }
                    if (sjVarSha1Hash == null) {
                        sjVarSha1Hash = Companion.sha1Hash(x509Certificate);
                    }
                    if (nullSafeIsEqual(pin.getHash(), sjVarSha1Hash)) {
                        return;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder("Certificate pinning failure!\n  Peer certificate chain:");
        for (X509Certificate x509Certificate2 : list) {
            sb.append("\n    ");
            sb.append(Companion.pin(x509Certificate2));
            sb.append(": ");
            sb.append(x509Certificate2.getSubjectDN().getName());
        }
        sb.append("\n  Pinned certificates for ");
        sb.append(str);
        sb.append(":");
        for (Pin pin2 : listFindMatchingPins) {
            sb.append("\n    ");
            sb.append(pin2);
        }
        String string = sb.toString();
        throwIfVar1IsNull(string, "StringBuilder().apply(builderAction).toString()");
        throw new SSLPeerUnverifiedException(string);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CertificatePinner)) {
            return false;
        }
        CertificatePinner certificatePinner = (CertificatePinner) obj;
        return nullSafeIsEqual(certificatePinner.pins, this.pins)
                && nullSafeIsEqual(certificatePinner.certificateChainCleaner, this.certificateChainCleaner);
    }

    public final List<Pin> findMatchingPins(String str) {
        throwIfVar1IsNull(str, "hostname");
        List arrayList = EmptyReadonlyList.INSTANCE;
        for (Object obj : this.pins) {
            if (((Pin) obj).matchesHostname(str)) {
                if (arrayList.isEmpty()) {
                    arrayList = new ArrayList();
                }
                emc.ad(arrayList).add(obj);
            }
        }
        return arrayList;
    }

    public final CertificateChainCleaner getCertificateChainCleaner$okhttp() {
        return this.certificateChainCleaner;
    }

    public final Set<Pin> getPins() {
        return this.pins;
    }

    public int hashCode() {
        int iHashCode = (this.pins.hashCode() + 1517) * 41;
        CertificateChainCleaner certificateChainCleaner = this.certificateChainCleaner;
        return iHashCode + (certificateChainCleaner != null ? certificateChainCleaner.hashCode() : 0);
    }

    public final CertificatePinner withCertificateChainCleaner$okhttp(CertificateChainCleaner certificateChainCleaner) {
        throwIfVar1IsNull(certificateChainCleaner, "certificateChainCleaner");
        return nullSafeIsEqual(this.certificateChainCleaner, certificateChainCleaner) ? this
                : new CertificatePinner(this.pins, certificateChainCleaner);
    }

    public final void check(String str, Certificate... certificateArr) {
        throwIfVar1IsNull(str, "hostname");
        throwIfVar1IsNull(certificateArr, "peerCertificates");
        check(str, SomeStaticHelpers.arrayToList(certificateArr));
    }

    public /* synthetic */ CertificatePinner(Set set, CertificateChainCleaner certificateChainCleaner, int i,
            akd akdVar) {
        this(set, (i & 2) != 0 ? null : certificateChainCleaner);
    }
}
