package okhttp3;

import com.android.dx.io.Opcodes;
import com.umeng.analytics.pro.dn;
import java.io.EOFException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import me.hd.wauxv.obf.StaticHelpers4;
import me.hd.wauxv.obf.akd;
import me.hd.wauxv.obf.EmptyReadonlyList;
import me.hd.wauxv.obf.avh;
import me.hd.wauxv.obf.KotlinIntProgression;
import me.hd.wauxv.obf.KotlinHelpers;
import me.hd.wauxv.obf.KotlinHelpers2;
import me.hd.wauxv.obf.dnj;
import me.hd.wauxv.obf.dnr;
import me.hd.wauxv.obf.dqc;
import me.hd.wauxv.obf.rh;
import me.hd.wauxv.obf.yg;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import net.bytebuddy.pool.TypePool;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class HttpUrl {
    public static final String FORM_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#&!$(),~";
    public static final String FRAGMENT_ENCODE_SET = "";
    public static final String FRAGMENT_ENCODE_SET_URI = " \"#<>\\^`{|}";
    public static final String PASSWORD_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    public static final String PATH_SEGMENT_ENCODE_SET = " \"<>^`{}|/\\?#";
    public static final String PATH_SEGMENT_ENCODE_SET_URI = "[]";
    public static final String QUERY_COMPONENT_ENCODE_SET = " !\"#$&'(),/:;<=>?@[]\\^`{|}~";
    public static final String QUERY_COMPONENT_ENCODE_SET_URI = "\\^`{|}";
    public static final String QUERY_COMPONENT_REENCODE_SET = " \"'<>#&=";
    public static final String QUERY_ENCODE_SET = " \"'<>#";
    public static final String USERNAME_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    private final String fragment;
    private final String host;
    private final boolean isHttps;
    private final String password;
    private final List<String> pathSegments;
    private final int port;
    private final List<String> queryNamesAndValues;
    private final String scheme;
    private final String url;
    private final String username;
    public static final Companion Companion = new Companion(null);
    private static final char[] HEX_DIGITS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D',
            'E', 'F' };

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public static final class Builder {
        public static final Companion Companion = new Companion(null);
        public static final String INVALID_HOST = "Invalid URL host";
        private String encodedFragment;
        private final List<String> encodedPathSegments;
        private List<String> encodedQueryNamesAndValues;
        private String host;
        private String scheme;
        private String encodedUsername = "";
        private String encodedPassword = "";
        private int port = -1;

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public static final class Companion {
            public /* synthetic */ Companion(akd akdVar) {
                this();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int parsePort(String str, int i, int i2) {
                int i3;
                try {
                    i3 = Integer.parseInt(Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, i, i2, "",
                            false, false, false, false, null, 248, null));
                } catch (NumberFormatException unused) {
                }
                if (1 > i3 || i3 >= 65536) {
                    return -1;
                }
                return i3;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int portColonOffset(String str, int i, int i2) {
                while (i < i2) {
                    char cCharAt = str.charAt(i);
                    if (cCharAt == '[') {
                        do {
                            i++;
                            if (i >= i2) {
                                break;
                            }
                        } while (str.charAt(i) != ']');
                    } else if (cCharAt == ':') {
                        return i;
                    }
                    i++;
                }
                return i2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int schemeDelimiterOffset(String str, int i, int i2) {
                if (i2 - i < 2) {
                    return -1;
                }
                char cCharAt = str.charAt(i);
                if ((KotlinHelpers.r(cCharAt, 97) >= 0 && KotlinHelpers.r(cCharAt, 122) <= 0)
                        || (KotlinHelpers.r(cCharAt, 65) >= 0 && KotlinHelpers.r(cCharAt, 90) <= 0)) {
                    while (true) {
                        i++;
                        if (i >= i2) {
                            break;
                        }
                        char cCharAt2 = str.charAt(i);
                        if ('a' > cCharAt2 || cCharAt2 >= '{') {
                            if ('A' > cCharAt2 || cCharAt2 >= '[') {
                                if ('0' > cCharAt2 || cCharAt2 >= ':') {
                                    if (cCharAt2 != '+' && cCharAt2 != '-' && cCharAt2 != '.') {
                                        if (cCharAt2 == ':') {
                                            return i;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                return -1;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int slashCount(String str, int i, int i2) {
                int i3 = 0;
                while (i < i2) {
                    char cCharAt = str.charAt(i);
                    if (cCharAt != '\\' && cCharAt != '/') {
                        break;
                    }
                    i3++;
                    i++;
                }
                return i3;
            }

            private Companion() {
            }
        }

        public Builder() {
            ArrayList arrayList = new ArrayList();
            this.encodedPathSegments = arrayList;
            arrayList.add("");
        }

        private final int effectivePort() {
            int i = this.port;
            if (i != -1) {
                return i;
            }
            Companion companion = HttpUrl.Companion;
            String str = this.scheme;
            throwIfVar1IsNull(str);
            return companion.defaultPort(str);
        }

        private final boolean isDot(String str) {
            return nullSafeIsEqual(str, ".") || dnr.bj(str, "%2e", true);
        }

        private final boolean isDotDot(String str) {
            return nullSafeIsEqual(str, "..") || dnr.bj(str, "%2e.", true) || dnr.bj(str, ".%2e", true)
                    || dnr.bj(str, "%2e%2e", true);
        }

        private final void pop() {
            if (this.encodedPathSegments.remove(r0.size() - 1).length() != 0 || this.encodedPathSegments.isEmpty()) {
                this.encodedPathSegments.add("");
            } else {
                this.encodedPathSegments.set(r0.size() - 1, "");
            }
        }

        private final void push(String str, int i, int i2, boolean z, boolean z2) {
            String strCanonicalize$okhttp$default = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, i, i2,
                    HttpUrl.PATH_SEGMENT_ENCODE_SET, z2, false, false, false, null, 240, null);
            if (isDot(strCanonicalize$okhttp$default)) {
                return;
            }
            if (isDotDot(strCanonicalize$okhttp$default)) {
                pop();
                return;
            }
            if (this.encodedPathSegments.get(r14.size() - 1).length() == 0) {
                this.encodedPathSegments.set(r14.size() - 1, strCanonicalize$okhttp$default);
            } else {
                this.encodedPathSegments.add(strCanonicalize$okhttp$default);
            }
            if (z) {
                this.encodedPathSegments.add("");
            }
        }

        private final void removeAllCanonicalQueryParameters(String str) {
            List<String> list = this.encodedQueryNamesAndValues;
            throwIfVar1IsNull(list);
            int size = list.size() - 2;
            int iAv = KotlinHelpers2.getProgressionLastElement(size, 0, -2);
            if (iAv > size) {
                return;
            }
            while (true) {
                List<String> list2 = this.encodedQueryNamesAndValues;
                throwIfVar1IsNull(list2);
                if (nullSafeIsEqual(str, list2.get(size))) {
                    List<String> list3 = this.encodedQueryNamesAndValues;
                    throwIfVar1IsNull(list3);
                    list3.remove(size + 1);
                    List<String> list4 = this.encodedQueryNamesAndValues;
                    throwIfVar1IsNull(list4);
                    list4.remove(size);
                    List<String> list5 = this.encodedQueryNamesAndValues;
                    throwIfVar1IsNull(list5);
                    if (list5.isEmpty()) {
                        this.encodedQueryNamesAndValues = null;
                        return;
                    }
                }
                if (size == iAv) {
                    return;
                } else {
                    size -= 2;
                }
            }
        }

        private final void resolvePath(String str, int i, int i2) {
            if (i == i2) {
                return;
            }
            char cCharAt = str.charAt(i);
            if (cCharAt == '/' || cCharAt == '\\') {
                this.encodedPathSegments.clear();
                this.encodedPathSegments.add("");
                i++;
            } else {
                List<String> list = this.encodedPathSegments;
                list.set(list.size() - 1, "");
            }
            int i3 = i;
            while (i3 < i2) {
                int iDelimiterOffset = Util.delimiterOffset(str, "/\\", i3, i2);
                boolean z = iDelimiterOffset < i2;
                String str2 = str;
                push(str2, i3, iDelimiterOffset, z, true);
                if (z) {
                    i3 = iDelimiterOffset + 1;
                    str = str2;
                } else {
                    str = str2;
                    i3 = iDelimiterOffset;
                }
            }
        }

        public final Builder addEncodedPathSegment(String str) {
            throwIfVar1IsNull(str, "encodedPathSegment");
            push(str, 0, str.length(), false, true);
            return this;
        }

        public final Builder addEncodedPathSegments(String str) {
            throwIfVar1IsNull(str, "encodedPathSegments");
            return addPathSegments(str, true);
        }

        public final Builder addEncodedQueryParameter(String str, String str2) {
            throwIfVar1IsNull(str, "encodedName");
            if (this.encodedQueryNamesAndValues == null) {
                this.encodedQueryNamesAndValues = new ArrayList();
            }
            List<String> list = this.encodedQueryNamesAndValues;
            throwIfVar1IsNull(list);
            Companion companion = HttpUrl.Companion;
            list.add(Companion.canonicalize$okhttp$default(companion, str, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET,
                    true, false, true, false, null, Opcodes.DIV_INT_LIT16, null));
            List<String> list2 = this.encodedQueryNamesAndValues;
            throwIfVar1IsNull(list2);
            list2.add(str2 != null
                    ? Companion.canonicalize$okhttp$default(companion, str2, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET,
                            true, false, true, false, null, Opcodes.DIV_INT_LIT16, null)
                    : null);
            return this;
        }

        public final Builder addPathSegment(String str) {
            throwIfVar1IsNull(str, "pathSegment");
            push(str, 0, str.length(), false, false);
            return this;
        }

        public final Builder addPathSegments(String str) {
            throwIfVar1IsNull(str, "pathSegments");
            return addPathSegments(str, false);
        }

        public final Builder addQueryParameter(String str, String str2) {
            throwIfVar1IsNull(str, "name");
            if (this.encodedQueryNamesAndValues == null) {
                this.encodedQueryNamesAndValues = new ArrayList();
            }
            List<String> list = this.encodedQueryNamesAndValues;
            throwIfVar1IsNull(list);
            Companion companion = HttpUrl.Companion;
            list.add(Companion.canonicalize$okhttp$default(companion, str, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET,
                    false, false, true, false, null, Opcodes.DIV_INT_LIT8, null));
            List<String> list2 = this.encodedQueryNamesAndValues;
            throwIfVar1IsNull(list2);
            list2.add(str2 != null
                    ? Companion.canonicalize$okhttp$default(companion, str2, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET,
                            false, false, true, false, null, Opcodes.DIV_INT_LIT8, null)
                    : null);
            return this;
        }

        public final HttpUrl build() {
            ArrayList arrayList;
            String str = this.scheme;
            if (str == null) {
                throw new IllegalStateException("scheme == null");
            }
            Companion companion = HttpUrl.Companion;
            String strPercentDecode$okhttp$default = Companion.percentDecode$okhttp$default(companion,
                    this.encodedUsername, 0, 0, false, 7, null);
            String strPercentDecode$okhttp$default2 = Companion.percentDecode$okhttp$default(companion,
                    this.encodedPassword, 0, 0, false, 7, null);
            String str2 = this.host;
            if (str2 == null) {
                throw new IllegalStateException("host == null");
            }
            int iEffectivePort = effectivePort();
            List<String> list = this.encodedPathSegments;
            ArrayList arrayList2 = new ArrayList(StaticHelpers4.ak(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(Companion.percentDecode$okhttp$default(HttpUrl.Companion, (String) it.next(), 0, 0,
                        false, 7, null));
            }
            List<String> list2 = this.encodedQueryNamesAndValues;
            if (list2 != null) {
                ArrayList arrayList3 = new ArrayList(StaticHelpers4.ak(list2, 10));
                for (String str3 : list2) {
                    arrayList3.add(str3 != null
                            ? Companion.percentDecode$okhttp$default(HttpUrl.Companion, str3, 0, 0, true, 3, null)
                            : null);
                }
                arrayList = arrayList3;
            } else {
                arrayList = null;
            }
            String str4 = this.encodedFragment;
            return new HttpUrl(str, strPercentDecode$okhttp$default, strPercentDecode$okhttp$default2, str2,
                    iEffectivePort, arrayList2, arrayList,
                    str4 != null ? Companion.percentDecode$okhttp$default(HttpUrl.Companion, str4, 0, 0, false, 7, null)
                            : null,
                    toString());
        }

        public final Builder encodedFragment(String str) {
            this.encodedFragment = str != null ? Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, "",
                    true, false, false, true, null, 179, null) : null;
            return this;
        }

        public final Builder encodedPassword(String str) {
            throwIfVar1IsNull(str, "encodedPassword");
            this.encodedPassword = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0,
                    " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 243, null);
            return this;
        }

        public final Builder encodedPath(String str) {
            throwIfVar1IsNull(str, "encodedPath");
            if (!dnr.bp(str, "/", false)) {
                throw new IllegalArgumentException("unexpected encodedPath: ".concat(str).toString());
            }
            resolvePath(str, 0, str.length());
            return this;
        }

        public final Builder encodedQuery(String str) {
            Companion companion;
            String strCanonicalize$okhttp$default;
            this.encodedQueryNamesAndValues = (str == null || (strCanonicalize$okhttp$default = Companion
                    .canonicalize$okhttp$default((companion = HttpUrl.Companion), str, 0, 0, HttpUrl.QUERY_ENCODE_SET,
                            true, false, true, false, null, Opcodes.DIV_INT_LIT16, null)) == null) ? null
                                    : companion.toQueryNamesAndValues$okhttp(strCanonicalize$okhttp$default);
            return this;
        }

        public final Builder encodedUsername(String str) {
            throwIfVar1IsNull(str, "encodedUsername");
            this.encodedUsername = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0,
                    " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 243, null);
            return this;
        }

        public final Builder fragment(String str) {
            this.encodedFragment = str != null ? Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, "",
                    false, false, false, true, null, 187, null) : null;
            return this;
        }

        public final String getEncodedFragment$okhttp() {
            return this.encodedFragment;
        }

        public final String getEncodedPassword$okhttp() {
            return this.encodedPassword;
        }

        public final List<String> getEncodedPathSegments$okhttp() {
            return this.encodedPathSegments;
        }

        public final List<String> getEncodedQueryNamesAndValues$okhttp() {
            return this.encodedQueryNamesAndValues;
        }

        public final String getEncodedUsername$okhttp() {
            return this.encodedUsername;
        }

        public final String getHost$okhttp() {
            return this.host;
        }

        public final int getPort$okhttp() {
            return this.port;
        }

        public final String getScheme$okhttp() {
            return this.scheme;
        }

        public final Builder host(String str) {
            throwIfVar1IsNull(str, "host");
            String canonicalHost = HostnamesKt.toCanonicalHost(
                    Companion.percentDecode$okhttp$default(HttpUrl.Companion, str, 0, 0, false, 7, null));
            if (canonicalHost == null) {
                throw new IllegalArgumentException("unexpected host: ".concat(str));
            }
            this.host = canonicalHost;
            return this;
        }

        public final Builder parse$okhttp(HttpUrl httpUrl, String str) {
            int iDelimiterOffset;
            int i;
            String str2;
            int i2;
            String str3;
            boolean z;
            int i3;
            int i4;
            int i5;
            char c;
            int i6;
            String str4 = str;
            throwIfVar1IsNull(str4, "input");
            int iIndexOfFirstNonAsciiWhitespace$default = Util.indexOfFirstNonAsciiWhitespace$default(str4, 0, 0, 3,
                    null);
            int iIndexOfLastNonAsciiWhitespace$default = Util.indexOfLastNonAsciiWhitespace$default(str4,
                    iIndexOfFirstNonAsciiWhitespace$default, 0, 2, null);
            Companion companion = Companion;
            int iSchemeDelimiterOffset = companion.schemeDelimiterOffset(str4, iIndexOfFirstNonAsciiWhitespace$default,
                    iIndexOfLastNonAsciiWhitespace$default);
            String str5 = "this as java.lang.String…ing(startIndex, endIndex)";
            boolean z2 = true;
            int i7 = -1;
            if (iSchemeDelimiterOffset != -1) {
                if (dnr.bq(str4, true, iIndexOfFirstNonAsciiWhitespace$default, "https:")) {
                    this.scheme = "https";
                    iIndexOfFirstNonAsciiWhitespace$default += 6;
                } else {
                    if (!dnr.bq(str4, true, iIndexOfFirstNonAsciiWhitespace$default, "http:")) {
                        StringBuilder sb = new StringBuilder("Expected URL scheme 'http' or 'https' but was '");
                        String strSubstring = str4.substring(0, iSchemeDelimiterOffset);
                        throwIfVar1IsNull(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                        sb.append(strSubstring);
                        sb.append('\'');
                        throw new IllegalArgumentException(sb.toString());
                    }
                    this.scheme = "http";
                    iIndexOfFirstNonAsciiWhitespace$default += 5;
                }
            } else {
                if (httpUrl == null) {
                    throw new IllegalArgumentException(
                            yg.k("Expected URL scheme 'http' or 'https' but no scheme was found for ",
                                    str4.length() > 6 ? dnj.az(6, str4).concat("...") : str4));
                }
                this.scheme = httpUrl.scheme();
            }
            int iSlashCount = companion.slashCount(str4, iIndexOfFirstNonAsciiWhitespace$default,
                    iIndexOfLastNonAsciiWhitespace$default);
            int i8 = 63;
            int i9 = 35;
            if (iSlashCount >= 2 || httpUrl == null || !nullSafeIsEqual(httpUrl.scheme(), this.scheme)) {
                int i10 = iIndexOfFirstNonAsciiWhitespace$default + iSlashCount;
                boolean z3 = false;
                boolean z4 = false;
                while (true) {
                    iDelimiterOffset = Util.delimiterOffset(str4, "@/\\?#", i10,
                            iIndexOfLastNonAsciiWhitespace$default);
                    int iCharAt = iDelimiterOffset != iIndexOfLastNonAsciiWhitespace$default
                            ? str4.charAt(iDelimiterOffset)
                            : i7;
                    if (iCharAt == i7 || iCharAt == i9 || iCharAt == 47 || iCharAt == 92 || iCharAt == i8) {
                        break;
                    }
                    if (iCharAt == 64) {
                        if (z3) {
                            i2 = iIndexOfLastNonAsciiWhitespace$default;
                            str3 = str5;
                            z = z2;
                            i3 = i7;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(this.encodedPassword);
                            sb2.append("%40");
                            str4 = str;
                            i4 = iDelimiterOffset;
                            sb2.append(Companion.canonicalize$okhttp$default(HttpUrl.Companion, str4, i10,
                                    iDelimiterOffset, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240,
                                    null));
                            this.encodedPassword = sb2.toString();
                        } else {
                            int iDelimiterOffset2 = Util.delimiterOffset(str4, ':', i10, iDelimiterOffset);
                            Companion companion2 = HttpUrl.Companion;
                            str3 = str5;
                            i3 = i7;
                            i2 = iIndexOfLastNonAsciiWhitespace$default;
                            z = z2;
                            String strCanonicalize$okhttp$default = Companion.canonicalize$okhttp$default(companion2,
                                    str4, i10, iDelimiterOffset2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false,
                                    null, 240, null);
                            if (z4) {
                                strCanonicalize$okhttp$default = this.encodedUsername + "%40"
                                        + strCanonicalize$okhttp$default;
                            }
                            this.encodedUsername = strCanonicalize$okhttp$default;
                            if (iDelimiterOffset2 != iDelimiterOffset) {
                                i5 = iDelimiterOffset;
                                this.encodedPassword = Companion.canonicalize$okhttp$default(companion2, str,
                                        iDelimiterOffset2 + 1, i5, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false,
                                        null, 240, null);
                                z3 = z;
                            } else {
                                i5 = iDelimiterOffset;
                            }
                            str4 = str;
                            i4 = i5;
                            z4 = z;
                        }
                        i10 = i4 + 1;
                        i7 = i3;
                        iIndexOfLastNonAsciiWhitespace$default = i2;
                        str5 = str3;
                        z2 = z;
                        i8 = 63;
                        i9 = 35;
                    }
                }
                i = iIndexOfLastNonAsciiWhitespace$default;
                String str6 = str5;
                int i11 = i7;
                Companion companion3 = Companion;
                int iPortColonOffset = companion3.portColonOffset(str4, i10, iDelimiterOffset);
                int i12 = iPortColonOffset + 1;
                if (i12 < iDelimiterOffset) {
                    this.host = HostnamesKt.toCanonicalHost(Companion.percentDecode$okhttp$default(HttpUrl.Companion,
                            str4, i10, iPortColonOffset, false, 4, null));
                    int port = companion3.parsePort(str4, i12, iDelimiterOffset);
                    this.port = port;
                    if (port == i11) {
                        StringBuilder sb3 = new StringBuilder("Invalid URL port: \"");
                        String strSubstring2 = str4.substring(i12, iDelimiterOffset);
                        throwIfVar1IsNull(strSubstring2, str6);
                        sb3.append(strSubstring2);
                        sb3.append('\"');
                        throw new IllegalArgumentException(sb3.toString().toString());
                    }
                    str2 = str6;
                } else {
                    str2 = str6;
                    Companion companion4 = HttpUrl.Companion;
                    this.host = HostnamesKt.toCanonicalHost(Companion.percentDecode$okhttp$default(companion4, str4,
                            i10, iPortColonOffset, false, 4, null));
                    String str7 = this.scheme;
                    throwIfVar1IsNull(str7);
                    this.port = companion4.defaultPort(str7);
                }
                if (this.host == null) {
                    StringBuilder sb4 = new StringBuilder("Invalid URL host: \"");
                    String strSubstring3 = str4.substring(i10, iPortColonOffset);
                    throwIfVar1IsNull(strSubstring3, str2);
                    sb4.append(strSubstring3);
                    sb4.append('\"');
                    throw new IllegalArgumentException(sb4.toString().toString());
                }
                iIndexOfFirstNonAsciiWhitespace$default = iDelimiterOffset;
            } else {
                this.encodedUsername = httpUrl.encodedUsername();
                this.encodedPassword = httpUrl.encodedPassword();
                this.host = httpUrl.host();
                this.port = httpUrl.port();
                this.encodedPathSegments.clear();
                this.encodedPathSegments.addAll(httpUrl.encodedPathSegments());
                if (iIndexOfFirstNonAsciiWhitespace$default == iIndexOfLastNonAsciiWhitespace$default
                        || str4.charAt(iIndexOfFirstNonAsciiWhitespace$default) == '#') {
                    encodedQuery(httpUrl.encodedQuery());
                }
                i = iIndexOfLastNonAsciiWhitespace$default;
            }
            int i13 = i;
            int iDelimiterOffset3 = Util.delimiterOffset(str4, "?#", iIndexOfFirstNonAsciiWhitespace$default, i13);
            resolvePath(str4, iIndexOfFirstNonAsciiWhitespace$default, iDelimiterOffset3);
            if (iDelimiterOffset3 >= i13 || str4.charAt(iDelimiterOffset3) != '?') {
                c = '#';
                i6 = iDelimiterOffset3;
            } else {
                c = '#';
                int iDelimiterOffset4 = Util.delimiterOffset(str4, '#', iDelimiterOffset3, i13);
                Companion companion5 = HttpUrl.Companion;
                this.encodedQueryNamesAndValues = companion5.toQueryNamesAndValues$okhttp(Companion
                        .canonicalize$okhttp$default(companion5, str4, iDelimiterOffset3 + 1, iDelimiterOffset4,
                                HttpUrl.QUERY_ENCODE_SET, true, false, true, false, null, Opcodes.ADD_INT_LIT16, null));
                i6 = iDelimiterOffset4;
            }
            if (i6 < i13 && str4.charAt(i6) == c) {
                this.encodedFragment = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str4, i6 + 1, i13, "",
                        true, false, false, true, null, 176, null);
            }
            return this;
        }

        public final Builder password(String str) {
            throwIfVar1IsNull(str, "password");
            this.encodedPassword = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0,
                    " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, Opcodes.INVOKE_POLYMORPHIC_RANGE, null);
            return this;
        }

        public final Builder port(int i) {
            if (1 > i || i >= 65536) {
                throw new IllegalArgumentException(concatVar2Var1(i, "unexpected port: ").toString());
            }
            this.port = i;
            return this;
        }

        public final Builder query(String str) {
            Companion companion;
            String strCanonicalize$okhttp$default;
            this.encodedQueryNamesAndValues = (str == null || (strCanonicalize$okhttp$default = Companion
                    .canonicalize$okhttp$default((companion = HttpUrl.Companion), str, 0, 0, HttpUrl.QUERY_ENCODE_SET,
                            false, false, true, false, null, Opcodes.DIV_INT_LIT8, null)) == null) ? null
                                    : companion.toQueryNamesAndValues$okhttp(strCanonicalize$okhttp$default);
            return this;
        }

        public final Builder reencodeForUri$okhttp() {
            String strReplaceAll;
            String str = this.host;
            if (str != null) {
                Pattern patternCompile = Pattern.compile("[\"<>^`{|}]");
                throwIfVar1IsNull(patternCompile, "compile(...)");
                strReplaceAll = patternCompile.matcher(str).replaceAll("");
                throwIfVar1IsNull(strReplaceAll, "replaceAll(...)");
            } else {
                strReplaceAll = null;
            }
            this.host = strReplaceAll;
            int size = this.encodedPathSegments.size();
            for (int i = 0; i < size; i++) {
                List<String> list = this.encodedPathSegments;
                list.set(i, Companion.canonicalize$okhttp$default(HttpUrl.Companion, list.get(i), 0, 0,
                        HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, true, true, false, false, null, 227, null));
            }
            List<String> list2 = this.encodedQueryNamesAndValues;
            if (list2 != null) {
                int size2 = list2.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str2 = list2.get(i2);
                    list2.set(i2,
                            str2 != null ? Companion.canonicalize$okhttp$default(HttpUrl.Companion, str2, 0, 0,
                                    HttpUrl.QUERY_COMPONENT_ENCODE_SET_URI, true, true, true, false, null, 195, null)
                                    : null);
                }
            }
            String str3 = this.encodedFragment;
            this.encodedFragment = str3 != null
                    ? Companion.canonicalize$okhttp$default(HttpUrl.Companion, str3, 0, 0,
                            HttpUrl.FRAGMENT_ENCODE_SET_URI, true, true, false, true, null, 163, null)
                    : null;
            return this;
        }

        public final Builder removeAllEncodedQueryParameters(String str) {
            throwIfVar1IsNull(str, "encodedName");
            if (this.encodedQueryNamesAndValues == null) {
                return this;
            }
            removeAllCanonicalQueryParameters(Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0,
                    HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, null, Opcodes.DIV_INT_LIT16, null));
            return this;
        }

        public final Builder removeAllQueryParameters(String str) {
            throwIfVar1IsNull(str, "name");
            if (this.encodedQueryNamesAndValues == null) {
                return this;
            }
            removeAllCanonicalQueryParameters(Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0,
                    HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, null, Opcodes.DIV_INT_LIT8, null));
            return this;
        }

        public final Builder removePathSegment(int i) {
            this.encodedPathSegments.remove(i);
            if (this.encodedPathSegments.isEmpty()) {
                this.encodedPathSegments.add("");
            }
            return this;
        }

        public final Builder scheme(String str) {
            throwIfVar1IsNull(str, "scheme");
            if (str.equalsIgnoreCase("http")) {
                this.scheme = "http";
                return this;
            }
            if (!str.equalsIgnoreCase("https")) {
                throw new IllegalArgumentException("unexpected scheme: ".concat(str));
            }
            this.scheme = "https";
            return this;
        }

        public final void setEncodedFragment$okhttp(String str) {
            this.encodedFragment = str;
        }

        public final void setEncodedPassword$okhttp(String str) {
            throwIfVar1IsNull(str, "<set-?>");
            this.encodedPassword = str;
        }

        public final Builder setEncodedPathSegment(int i, String str) {
            throwIfVar1IsNull(str, "encodedPathSegment");
            String strCanonicalize$okhttp$default = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0,
                    HttpUrl.PATH_SEGMENT_ENCODE_SET, true, false, false, false, null, 243, null);
            this.encodedPathSegments.set(i, strCanonicalize$okhttp$default);
            if (isDot(strCanonicalize$okhttp$default) || isDotDot(strCanonicalize$okhttp$default)) {
                throw new IllegalArgumentException("unexpected path segment: ".concat(str).toString());
            }
            return this;
        }

        public final void setEncodedQueryNamesAndValues$okhttp(List<String> list) {
            this.encodedQueryNamesAndValues = list;
        }

        public final Builder setEncodedQueryParameter(String str, String str2) {
            throwIfVar1IsNull(str, "encodedName");
            removeAllEncodedQueryParameters(str);
            addEncodedQueryParameter(str, str2);
            return this;
        }

        public final void setEncodedUsername$okhttp(String str) {
            throwIfVar1IsNull(str, "<set-?>");
            this.encodedUsername = str;
        }

        public final void setHost$okhttp(String str) {
            this.host = str;
        }

        public final Builder setPathSegment(int i, String str) {
            throwIfVar1IsNull(str, "pathSegment");
            String strCanonicalize$okhttp$default = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0,
                    HttpUrl.PATH_SEGMENT_ENCODE_SET, false, false, false, false, null, Opcodes.INVOKE_POLYMORPHIC_RANGE,
                    null);
            if (isDot(strCanonicalize$okhttp$default) || isDotDot(strCanonicalize$okhttp$default)) {
                throw new IllegalArgumentException("unexpected path segment: ".concat(str).toString());
            }
            this.encodedPathSegments.set(i, strCanonicalize$okhttp$default);
            return this;
        }

        public final void setPort$okhttp(int i) {
            this.port = i;
        }

        public final Builder setQueryParameter(String str, String str2) {
            throwIfVar1IsNull(str, "name");
            removeAllQueryParameters(str);
            addQueryParameter(str, str2);
            return this;
        }

        public final void setScheme$okhttp(String str) {
            this.scheme = str;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            String str = this.scheme;
            if (str != null) {
                sb.append(str);
                sb.append("://");
            } else {
                sb.append("//");
            }
            if (this.encodedUsername.length() > 0 || this.encodedPassword.length() > 0) {
                sb.append(this.encodedUsername);
                if (this.encodedPassword.length() > 0) {
                    sb.append(':');
                    sb.append(this.encodedPassword);
                }
                sb.append('@');
            }
            String str2 = this.host;
            if (str2 != null) {
                if (dnj.ac(str2, ':')) {
                    sb.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.COMPONENT_TYPE_PATH);
                    sb.append(this.host);
                    sb.append(']');
                } else {
                    sb.append(this.host);
                }
            }
            if (this.port != -1 || this.scheme != null) {
                int iEffectivePort = effectivePort();
                String str3 = this.scheme;
                if (str3 == null || iEffectivePort != HttpUrl.Companion.defaultPort(str3)) {
                    sb.append(':');
                    sb.append(iEffectivePort);
                }
            }
            Companion companion = HttpUrl.Companion;
            companion.toPathString$okhttp(this.encodedPathSegments, sb);
            if (this.encodedQueryNamesAndValues != null) {
                sb.append('?');
                List<String> list = this.encodedQueryNamesAndValues;
                throwIfVar1IsNull(list);
                companion.toQueryString$okhttp(list, sb);
            }
            if (this.encodedFragment != null) {
                sb.append('#');
                sb.append(this.encodedFragment);
            }
            String string = sb.toString();
            throwIfVar1IsNull(string, "StringBuilder().apply(builderAction).toString()");
            return string;
        }

        public final Builder username(String str) {
            throwIfVar1IsNull(str, "username");
            this.encodedUsername = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0,
                    " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, Opcodes.INVOKE_POLYMORPHIC_RANGE, null);
            return this;
        }

        private final Builder addPathSegments(String str, boolean z) {
            boolean z2;
            Builder builder;
            String str2;
            boolean z3;
            int i = 0;
            while (true) {
                int iDelimiterOffset = Util.delimiterOffset(str, "/\\", i, str.length());
                if (iDelimiterOffset < str.length()) {
                    z2 = true;
                    str2 = str;
                    z3 = z;
                    builder = this;
                } else {
                    z2 = false;
                    builder = this;
                    str2 = str;
                    z3 = z;
                }
                builder.push(str2, i, iDelimiterOffset, z2, z3);
                i = iDelimiterOffset + 1;
                if (i > str2.length()) {
                    return builder;
                }
                str = str2;
                z = z3;
            }
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

        public static /* synthetic */ String canonicalize$okhttp$default(Companion companion, String str, int i, int i2,
                String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = 0;
            }
            if ((i3 & 2) != 0) {
                i2 = str.length();
            }
            if ((i3 & 8) != 0) {
                z = false;
            }
            if ((i3 & 16) != 0) {
                z2 = false;
            }
            if ((i3 & 32) != 0) {
                z3 = false;
            }
            if ((i3 & 64) != 0) {
                z4 = false;
            }
            if ((i3 & 128) != 0) {
                charset = null;
            }
            return companion.canonicalize$okhttp(str, i, i2, str2, z, z2, z3, z4, charset);
        }

        private final boolean isPercentEncoded(String str, int i, int i2) {
            int i3 = i + 2;
            return i3 < i2 && str.charAt(i) == '%' && Util.parseHexDigit(str.charAt(i + 1)) != -1
                    && Util.parseHexDigit(str.charAt(i3)) != -1;
        }

        public static /* synthetic */ String percentDecode$okhttp$default(Companion companion, String str, int i,
                int i2, boolean z, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = 0;
            }
            if ((i3 & 2) != 0) {
                i2 = str.length();
            }
            if ((i3 & 4) != 0) {
                z = false;
            }
            return companion.percentDecode$okhttp(str, i, i2, z);
        }

        private final void writeCanonicalized(rh rhVar, String str, int i, int i2, String str2, boolean z, boolean z2,
                boolean z3, boolean z4, Charset charset) throws EOFException {
            rh rhVar2 = null;
            while (i < i2) {
                int iCodePointAt = str.codePointAt(i);
                if (!z || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                    if (iCodePointAt == 43 && z3) {
                        rhVar.at(z ? "+" : "%2B");
                    } else if (iCodePointAt < 32 || iCodePointAt == 127
                            || ((iCodePointAt >= 128 && !z4) || dnj.ac(str2, (char) iCodePointAt)
                                    || (iCodePointAt == 37 && (!z || (z2 && !isPercentEncoded(str, i, i2)))))) {
                        if (rhVar2 == null) {
                            rhVar2 = new rh();
                        }
                        if (charset == null || charset.equals(StandardCharsets.UTF_8)) {
                            rhVar2.av(iCodePointAt);
                        } else {
                            rhVar2.as(str, i, Character.charCount(iCodePointAt) + i, charset);
                        }
                        while (!rhVar2.i()) {
                            byte b = rhVar2.readByte();
                            rhVar.am(37);
                            rhVar.am(HttpUrl.HEX_DIGITS[((b & 255) >> 4) & 15]);
                            rhVar.am(HttpUrl.HEX_DIGITS[b & dn.m]);
                        }
                    } else {
                        rhVar.av(iCodePointAt);
                    }
                }
                i += Character.charCount(iCodePointAt);
            }
        }

        private final void writePercentDecoded(rh rhVar, String str, int i, int i2, boolean z) {
            int i3;
            while (i < i2) {
                int iCodePointAt = str.codePointAt(i);
                if (iCodePointAt == 37 && (i3 = i + 2) < i2) {
                    int hexDigit = Util.parseHexDigit(str.charAt(i + 1));
                    int hexDigit2 = Util.parseHexDigit(str.charAt(i3));
                    if (hexDigit == -1 || hexDigit2 == -1) {
                        rhVar.av(iCodePointAt);
                        i += Character.charCount(iCodePointAt);
                    } else {
                        rhVar.am((hexDigit << 4) + hexDigit2);
                        i = Character.charCount(iCodePointAt) + i3;
                    }
                } else if (iCodePointAt == 43 && z) {
                    rhVar.am(32);
                    i++;
                } else {
                    rhVar.av(iCodePointAt);
                    i += Character.charCount(iCodePointAt);
                }
            }
        }

        public final HttpUrl a(String str) {
            throwIfVar1IsNull(str, "url");
            return get(str);
        }

        public final String canonicalize$okhttp(String str, int i, int i2, String str2, boolean z, boolean z2,
                boolean z3, boolean z4, Charset charset) throws EOFException {
            throwIfVar1IsNull(str, "<this>");
            throwIfVar1IsNull(str2, "encodeSet");
            int iCharCount = i;
            while (iCharCount < i2) {
                int iCodePointAt = str.codePointAt(iCharCount);
                if (iCodePointAt < 32 || iCodePointAt == 127
                        || ((iCodePointAt >= 128 && !z4) || dnj.ac(str2, (char) iCodePointAt)
                                || ((iCodePointAt == 37 && (!z || (z2 && !isPercentEncoded(str, iCharCount, i2))))
                                        || (iCodePointAt == 43 && z3)))) {
                    rh rhVar = new rh();
                    rhVar.au(str, i, iCharCount);
                    writeCanonicalized(rhVar, str, iCharCount, i2, str2, z, z2, z3, z4, charset);
                    return rhVar.ac();
                }
                iCharCount += Character.charCount(iCodePointAt);
            }
            String strSubstring = str.substring(i, i2);
            throwIfVar1IsNull(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            return strSubstring;
        }

        public final HttpUrl d(String str) {
            throwIfVar1IsNull(str, "url");
            return parse(str);
        }

        public final int defaultPort(String str) {
            throwIfVar1IsNull(str, "scheme");
            if (str.equals("http")) {
                return 80;
            }
            return str.equals("https") ? 443 : -1;
        }

        public final HttpUrl get(String str) {
            throwIfVar1IsNull(str, "<this>");
            return new Builder().parse$okhttp(null, str).build();
        }

        public final HttpUrl parse(String str) {
            throwIfVar1IsNull(str, "<this>");
            try {
                return get(str);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        public final String percentDecode$okhttp(String str, int i, int i2, boolean z) {
            throwIfVar1IsNull(str, "<this>");
            for (int i3 = i; i3 < i2; i3++) {
                char cCharAt = str.charAt(i3);
                if (cCharAt == '%' || (cCharAt == '+' && z)) {
                    rh rhVar = new rh();
                    rhVar.au(str, i, i3);
                    writePercentDecoded(rhVar, str, i3, i2, z);
                    return rhVar.ac();
                }
            }
            String strSubstring = str.substring(i, i2);
            throwIfVar1IsNull(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            return strSubstring;
        }

        public final void toPathString$okhttp(List<String> list, StringBuilder sb) {
            throwIfVar1IsNull(list, "<this>");
            throwIfVar1IsNull(sb, "out");
            int size = list.size();
            for (int i = 0; i < size; i++) {
                sb.append('/');
                sb.append(list.get(i));
            }
        }

        public final List<String> toQueryNamesAndValues$okhttp(String str) {
            throwIfVar1IsNull(str, "<this>");
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (i <= str.length()) {
                int iAh = dnj.ah('&', i, 4, str);
                if (iAh == -1) {
                    iAh = str.length();
                }
                int iAh2 = dnj.ah(SignatureVisitor.INSTANCEOF, i, 4, str);
                if (iAh2 == -1 || iAh2 > iAh) {
                    String strSubstring = str.substring(i, iAh);
                    throwIfVar1IsNull(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                    arrayList.add(strSubstring);
                    arrayList.add(null);
                } else {
                    String strSubstring2 = str.substring(i, iAh2);
                    throwIfVar1IsNull(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
                    arrayList.add(strSubstring2);
                    String strSubstring3 = str.substring(iAh2 + 1, iAh);
                    throwIfVar1IsNull(strSubstring3, "this as java.lang.String…ing(startIndex, endIndex)");
                    arrayList.add(strSubstring3);
                }
                i = iAh + 1;
            }
            return arrayList;
        }

        public final void toQueryString$okhttp(List<String> list, StringBuilder sb) {
            throwIfVar1IsNull(list, "<this>");
            throwIfVar1IsNull(sb, "out");
            KotlinIntProgression intRangeVarBj = dqc.bj(dqc.bm(0, list.size()), 2);
            int i = intRangeVarBj.first;
            int i2 = intRangeVarBj.last;
            int i3 = intRangeVarBj.step;
            if ((i3 <= 0 || i > i2) && (i3 >= 0 || i2 > i)) {
                return;
            }
            while (true) {
                String str = list.get(i);
                String str2 = list.get(i + 1);
                if (i > 0) {
                    sb.append('&');
                }
                sb.append(str);
                if (str2 != null) {
                    sb.append(SignatureVisitor.INSTANCEOF);
                    sb.append(str2);
                }
                if (i == i2) {
                    return;
                } else {
                    i += i3;
                }
            }
        }

        private Companion() {
        }

        public final HttpUrl c(URL url) {
            throwIfVar1IsNull(url, "url");
            return get(url);
        }

        public final HttpUrl get(URL url) {
            throwIfVar1IsNull(url, "<this>");
            String string = url.toString();
            throwIfVar1IsNull(string, "toString()");
            return parse(string);
        }

        public final HttpUrl b(URI uri) {
            throwIfVar1IsNull(uri, "uri");
            return get(uri);
        }

        public final HttpUrl get(URI uri) {
            throwIfVar1IsNull(uri, "<this>");
            String string = uri.toString();
            throwIfVar1IsNull(string, "toString()");
            return parse(string);
        }
    }

    public HttpUrl(String str, String str2, String str3, String str4, int i, List<String> list, List<String> list2,
            String str5, String str6) {
        throwIfVar1IsNull(str, "scheme");
        throwIfVar1IsNull(str2, "username");
        throwIfVar1IsNull(str3, "password");
        throwIfVar1IsNull(str4, "host");
        throwIfVar1IsNull(list, "pathSegments");
        throwIfVar1IsNull(str6, "url");
        this.scheme = str;
        this.username = str2;
        this.password = str3;
        this.host = str4;
        this.port = i;
        this.pathSegments = list;
        this.queryNamesAndValues = list2;
        this.fragment = str5;
        this.url = str6;
        this.isHttps = nullSafeIsEqual(str, "https");
    }

    public static final int defaultPort(String str) {
        return Companion.defaultPort(str);
    }

    public static final HttpUrl get(String str) {
        return Companion.get(str);
    }

    public static final HttpUrl parse(String str) {
        return Companion.parse(str);
    }

    public final String a() {
        return encodedFragment();
    }

    public final String b() {
        return encodedPassword();
    }

    public final String c() {
        return encodedPath();
    }

    public final List<String> d() {
        return encodedPathSegments();
    }

    public final String e() {
        return encodedQuery();
    }

    public final String encodedFragment() {
        if (this.fragment == null) {
            return null;
        }
        String strSubstring = this.url.substring(dnj.ah('#', 0, 6, this.url) + 1);
        throwIfVar1IsNull(strSubstring, "this as java.lang.String).substring(startIndex)");
        return strSubstring;
    }

    public final String encodedPassword() {
        if (this.password.length() == 0) {
            return "";
        }
        String strSubstring = this.url.substring(dnj.ah(':', this.scheme.length() + 3, 4, this.url) + 1,
                dnj.ah('@', 0, 6, this.url));
        throwIfVar1IsNull(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final String encodedPath() {
        int iAh = dnj.ah('/', this.scheme.length() + 3, 4, this.url);
        String str = this.url;
        String strSubstring = this.url.substring(iAh, Util.delimiterOffset(str, "?#", iAh, str.length()));
        throwIfVar1IsNull(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final List<String> encodedPathSegments() {
        int iAh = dnj.ah('/', this.scheme.length() + 3, 4, this.url);
        String str = this.url;
        int iDelimiterOffset = Util.delimiterOffset(str, "?#", iAh, str.length());
        ArrayList arrayList = new ArrayList();
        while (iAh < iDelimiterOffset) {
            int i = iAh + 1;
            int iDelimiterOffset2 = Util.delimiterOffset(this.url, '/', i, iDelimiterOffset);
            String strSubstring = this.url.substring(i, iDelimiterOffset2);
            throwIfVar1IsNull(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            arrayList.add(strSubstring);
            iAh = iDelimiterOffset2;
        }
        return arrayList;
    }

    public final String encodedQuery() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        int iAh = dnj.ah('?', 0, 6, this.url) + 1;
        String str = this.url;
        String strSubstring = this.url.substring(iAh, Util.delimiterOffset(str, '#', iAh, str.length()));
        throwIfVar1IsNull(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final String encodedUsername() {
        if (this.username.length() == 0) {
            return "";
        }
        int length = this.scheme.length() + 3;
        String str = this.url;
        String strSubstring = this.url.substring(length, Util.delimiterOffset(str, ":@", length, str.length()));
        throwIfVar1IsNull(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public boolean equals(Object obj) {
        return (obj instanceof HttpUrl) && nullSafeIsEqual(((HttpUrl) obj).url, this.url);
    }

    public final String f() {
        return encodedUsername();
    }

    public final String fragment() {
        return this.fragment;
    }

    public final String g() {
        return this.fragment;
    }

    public final String h() {
        return this.host;
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    public final String host() {
        return this.host;
    }

    public final String i() {
        return this.password;
    }

    public final boolean isHttps() {
        return this.isHttps;
    }

    public final List<String> j() {
        return this.pathSegments;
    }

    public final int k() {
        return pathSize();
    }

    public final int l() {
        return this.port;
    }

    public final String m() {
        return query();
    }

    public final Set<String> n() {
        return queryParameterNames();
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.setScheme$okhttp(this.scheme);
        builder.setEncodedUsername$okhttp(encodedUsername());
        builder.setEncodedPassword$okhttp(encodedPassword());
        builder.setHost$okhttp(this.host);
        builder.setPort$okhttp(this.port != Companion.defaultPort(this.scheme) ? this.port : -1);
        builder.getEncodedPathSegments$okhttp().clear();
        builder.getEncodedPathSegments$okhttp().addAll(encodedPathSegments());
        builder.encodedQuery(encodedQuery());
        builder.setEncodedFragment$okhttp(encodedFragment());
        return builder;
    }

    public final int o() {
        return querySize();
    }

    public final String p() {
        return this.scheme;
    }

    public final String password() {
        return this.password;
    }

    public final List<String> pathSegments() {
        return this.pathSegments;
    }

    public final int pathSize() {
        return this.pathSegments.size();
    }

    public final int port() {
        return this.port;
    }

    public final URI q() {
        return uri();
    }

    public final String query() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Companion.toQueryString$okhttp(this.queryNamesAndValues, sb);
        return sb.toString();
    }

    public final String queryParameter(String str) {
        throwIfVar1IsNull(str, "name");
        List<String> list = this.queryNamesAndValues;
        if (list == null) {
            return null;
        }
        KotlinIntProgression intRangeVarBj = dqc.bj(dqc.bm(0, list.size()), 2);
        int i = intRangeVarBj.first;
        int i2 = intRangeVarBj.last;
        int i3 = intRangeVarBj.step;
        if ((i3 <= 0 || i > i2) && (i3 >= 0 || i2 > i)) {
            return null;
        }
        while (!str.equals(this.queryNamesAndValues.get(i))) {
            if (i == i2) {
                return null;
            }
            i += i3;
        }
        return this.queryNamesAndValues.get(i + 1);
    }

    public final String queryParameterName(int i) {
        List<String> list = this.queryNamesAndValues;
        if (list == null) {
            throw new IndexOutOfBoundsException();
        }
        String str = list.get(i * 2);
        throwIfVar1IsNull(str);
        return str;
    }

    public final Set<String> queryParameterNames() {
        if (this.queryNamesAndValues == null) {
            return avh.a;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        KotlinIntProgression intRangeVarBj = dqc.bj(dqc.bm(0, this.queryNamesAndValues.size()), 2);
        int i = intRangeVarBj.first;
        int i2 = intRangeVarBj.last;
        int i3 = intRangeVarBj.step;
        if ((i3 > 0 && i <= i2) || (i3 < 0 && i2 <= i)) {
            while (true) {
                String str = this.queryNamesAndValues.get(i);
                throwIfVar1IsNull(str);
                linkedHashSet.add(str);
                if (i == i2) {
                    break;
                }
                i += i3;
            }
        }
        Set<String> setUnmodifiableSet = Collections.unmodifiableSet(linkedHashSet);
        throwIfVar1IsNull(setUnmodifiableSet, "unmodifiableSet(result)");
        return setUnmodifiableSet;
    }

    public final String queryParameterValue(int i) {
        List<String> list = this.queryNamesAndValues;
        if (list != null) {
            return list.get((i * 2) + 1);
        }
        throw new IndexOutOfBoundsException();
    }

    public final List<String> queryParameterValues(String str) {
        throwIfVar1IsNull(str, "name");
        if (this.queryNamesAndValues == null) {
            return EmptyReadonlyList.INSTANCE;
        }
        ArrayList arrayList = new ArrayList();
        KotlinIntProgression intRangeVarBj = dqc.bj(dqc.bm(0, this.queryNamesAndValues.size()), 2);
        int i = intRangeVarBj.first;
        int i2 = intRangeVarBj.last;
        int i3 = intRangeVarBj.step;
        if ((i3 > 0 && i <= i2) || (i3 < 0 && i2 <= i)) {
            while (true) {
                if (str.equals(this.queryNamesAndValues.get(i))) {
                    arrayList.add(this.queryNamesAndValues.get(i + 1));
                }
                if (i == i2) {
                    break;
                }
                i += i3;
            }
        }
        List<String> listUnmodifiableList = Collections.unmodifiableList(arrayList);
        throwIfVar1IsNull(listUnmodifiableList, "unmodifiableList(result)");
        return listUnmodifiableList;
    }

    public final int querySize() {
        List<String> list = this.queryNamesAndValues;
        if (list != null) {
            return list.size() / 2;
        }
        return 0;
    }

    public final URL r() {
        return url();
    }

    public final String redact() {
        Builder builderNewBuilder = newBuilder("/...");
        throwIfVar1IsNull(builderNewBuilder);
        return builderNewBuilder.username("").password("").build().toString();
    }

    public final HttpUrl resolve(String str) {
        throwIfVar1IsNull(str, "link");
        Builder builderNewBuilder = newBuilder(str);
        if (builderNewBuilder != null) {
            return builderNewBuilder.build();
        }
        return null;
    }

    public final String s() {
        return this.username;
    }

    public final String scheme() {
        return this.scheme;
    }

    public String toString() {
        return this.url;
    }

    public final String topPrivateDomain() {
        if (Util.canParseAsIpAddress(this.host)) {
            return null;
        }
        return PublicSuffixDatabase.Companion.get().getEffectiveTldPlusOne(this.host);
    }

    public final URI uri() {
        String string = newBuilder().reencodeForUri$okhttp().toString();
        try {
            return new URI(string);
        } catch (URISyntaxException e) {
            try {
                Pattern patternCompile = Pattern.compile("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]");
                throwIfVar1IsNull(patternCompile, "compile(...)");
                throwIfVar1IsNull(string, "input");
                String strReplaceAll = patternCompile.matcher(string).replaceAll("");
                throwIfVar1IsNull(strReplaceAll, "replaceAll(...)");
                URI uriCreate = URI.create(strReplaceAll);
                throwIfVar1IsNull(uriCreate, "{\n      // Unlikely edge…Unexpected!\n      }\n    }");
                return uriCreate;
            } catch (Exception unused) {
                throw new RuntimeException(e);
            }
        }
    }

    public final URL url() {
        try {
            return new URL(this.url);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public final String username() {
        return this.username;
    }

    public static final HttpUrl get(URI uri) {
        return Companion.get(uri);
    }

    public static final HttpUrl get(URL url) {
        return Companion.get(url);
    }

    public final Builder newBuilder(String str) {
        throwIfVar1IsNull(str, "link");
        try {
            return new Builder().parse$okhttp(this, str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }
}
