package okhttp3.internal.tls;

import com.umeng.analytics.pro.f;
import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import me.hd.wauxv.obf.StaticHelpers5;
import me.hd.wauxv.obf.EmptyReadonlyList;
import me.hd.wauxv.obf.StaticHelpers6;
import me.hd.wauxv.obf.dnj;
import me.hd.wauxv.obf.dnr;
import me.hd.wauxv.obf.yg;
import net.bytebuddy.pool.TypePool;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class OkHostnameVerifier implements HostnameVerifier {
    private static final int ALT_DNS_NAME = 2;
    private static final int ALT_IPA_NAME = 7;
    public static final OkHostnameVerifier INSTANCE = new OkHostnameVerifier();

    private OkHostnameVerifier() {
    }

    private final String asciiToLowercase(String str) {
        if (!isAscii(str)) {
            return str;
        }
        Locale locale = Locale.US;
        throwIfVar1IsNull(locale, "US");
        String lowerCase = str.toLowerCase(locale);
        throwIfVar1IsNull(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }

    private final List<String> getSubjectAltNames(X509Certificate x509Certificate, int i) {
        Object obj;
        EmptyReadonlyList emptyReadonlyListVar = EmptyReadonlyList.INSTANCE;
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return emptyReadonlyListVar;
            }
            ArrayList arrayList = new ArrayList();
            for (List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && nullSafeIsEqual(list.get(0), Integer.valueOf(i))
                        && (obj = list.get(1)) != null) {
                    arrayList.add((String) obj);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return emptyReadonlyListVar;
        }
    }

    private final boolean isAscii(String str) {
        int i;
        int length = str.length();
        int length2 = str.length();
        if (length2 < 0) {
            throw new IllegalArgumentException(StaticHelpers6.p(length2, "endIndex < beginIndex: ", " < ", 0).toString());
        }
        if (length2 > str.length()) {
            StringBuilder sbR = yg.concatVar213(length2, "endIndex > string.length: ", " > ");
            sbR.append(str.length());
            throw new IllegalArgumentException(sbR.toString().toString());
        }
        long j = 0;
        int i2 = 0;
        while (i2 < length2) {
            char cCharAt = str.charAt(i2);
            if (cCharAt < 128) {
                j++;
            } else {
                if (cCharAt < 2048) {
                    i = 2;
                } else if (cCharAt < 55296 || cCharAt > 57343) {
                    i = 3;
                } else {
                    int i3 = i2 + 1;
                    char cCharAt2 = i3 < length2 ? str.charAt(i3) : (char) 0;
                    if (cCharAt > 56319 || cCharAt2 < 56320 || cCharAt2 > 57343) {
                        j++;
                        i2 = i3;
                    } else {
                        j += (long) 4;
                        i2 += 2;
                    }
                }
                j += (long) i;
            }
            i2++;
        }
        return length == ((int) j);
    }

    private final boolean verifyHostname(String str, X509Certificate x509Certificate) {
        String strAsciiToLowercase = asciiToLowercase(str);
        List<String> subjectAltNames = getSubjectAltNames(x509Certificate, 2);
        if (subjectAltNames != null && subjectAltNames.isEmpty()) {
            return false;
        }
        Iterator<T> it = subjectAltNames.iterator();
        while (it.hasNext()) {
            if (INSTANCE.verifyHostname(strAsciiToLowercase, (String) it.next())) {
                return true;
            }
        }
        return false;
    }

    private final boolean verifyIpAddress(String str, X509Certificate x509Certificate) {
        String canonicalHost = HostnamesKt.toCanonicalHost(str);
        List<String> subjectAltNames = getSubjectAltNames(x509Certificate, 7);
        if (subjectAltNames != null && subjectAltNames.isEmpty()) {
            return false;
        }
        Iterator<T> it = subjectAltNames.iterator();
        while (it.hasNext()) {
            if (nullSafeIsEqual(canonicalHost, HostnamesKt.toCanonicalHost((String) it.next()))) {
                return true;
            }
        }
        return false;
    }

    public final List<String> allSubjectAltNames(X509Certificate x509Certificate) {
        throwIfVar1IsNull(x509Certificate, "certificate");
        return StaticHelpers5.o(getSubjectAltNames(x509Certificate, 7), getSubjectAltNames(x509Certificate, 2));
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        throwIfVar1IsNull(str, "host");
        throwIfVar1IsNull(sSLSession, f.aC);
        if (!isAscii(str)) {
            return false;
        }
        try {
            Certificate certificate = sSLSession.getPeerCertificates()[0];
            throwIfVar1IsNull(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
            return verify(str, (X509Certificate) certificate);
        } catch (SSLException unused) {
            return false;
        }
    }

    public final boolean verify(String str, X509Certificate x509Certificate) {
        throwIfVar1IsNull(str, "host");
        throwIfVar1IsNull(x509Certificate, "certificate");
        return Util.canParseAsIpAddress(str) ? verifyIpAddress(str, x509Certificate)
                : verifyHostname(str, x509Certificate);
    }

    private final boolean verifyHostname(String str, String str2) {
        int length;
        if (str != null && str.length() != 0 && !dnr.bp(str, ".", false) && !dnr.bi(str, "..") && str2 != null
                && str2.length() != 0 && !dnr.bp(str2, ".", false) && !dnr.bi(str2, "..")) {
            if (!dnr.bi(str, ".")) {
                str = str.concat(".");
            }
            if (!dnr.bi(str2, ".")) {
                str2 = str2.concat(".");
            }
            String strAsciiToLowercase = asciiToLowercase(str2);
            if (!dnj.ab(strAsciiToLowercase, "*", false)) {
                return nullSafeIsEqual(str, strAsciiToLowercase);
            }
            if (dnr.bp(strAsciiToLowercase, "*.", false)
                    && dnj.ah(TypePool.Default.LazyTypeDescription.GenericTypeToken.WILDCARD_TYPE_PATH, 1, 4,
                            strAsciiToLowercase) == -1
                    && str.length() >= strAsciiToLowercase.length() && !"*.".equals(strAsciiToLowercase)) {
                String strSubstring = strAsciiToLowercase.substring(1);
                throwIfVar1IsNull(strSubstring, "this as java.lang.String).substring(startIndex)");
                if (dnr.bi(str, strSubstring) && ((length = str.length() - strSubstring.length()) <= 0 || dnj.am(str,
                        TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH, length - 1, 4) == -1)) {
                    return true;
                }
            }
        }
        return false;
    }
}
