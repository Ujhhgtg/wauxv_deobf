package okhttp3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.hd.wauxv.obf.akd;
import me.hd.wauxv.obf.avd;
import me.hd.wauxv.obf.bjs;
import me.hd.wauxv.obf.KotlinHelpers;
import me.hd.wauxv.obf.dnj;
import me.hd.wauxv.obf.dnr;
import me.hd.wauxv.obf.yg;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import net.bytebuddy.pool.TypePool;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class Cookie {
    private final String domain;
    private final long expiresAt;
    private final boolean hostOnly;
    private final boolean httpOnly;
    private final String name;
    private final String path;
    private final boolean persistent;
    private final boolean secure;
    private final String value;
    public static final Companion Companion = new Companion(null);
    private static final Pattern YEAR_PATTERN = Pattern.compile("(\\d{2,4})[^\\d]*");
    private static final Pattern MONTH_PATTERN = Pattern
            .compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    private static final Pattern DAY_OF_MONTH_PATTERN = Pattern.compile("(\\d{1,2})[^\\d]*");
    private static final Pattern TIME_PATTERN = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public static final class Builder {
        private String domain;
        private boolean hostOnly;
        private boolean httpOnly;
        private String name;
        private boolean persistent;
        private boolean secure;
        private String value;
        private long expiresAt = DatesKt.MAX_DATE;
        private String path = "/";

        public final Cookie build() {
            String str = this.name;
            if (str == null) {
                throw new NullPointerException("builder.name == null");
            }
            String str2 = this.value;
            if (str2 == null) {
                throw new NullPointerException("builder.value == null");
            }
            long j = this.expiresAt;
            String str3 = this.domain;
            if (str3 != null) {
                return new Cookie(str, str2, j, str3, this.path, this.secure, this.httpOnly, this.persistent,
                        this.hostOnly, null);
            }
            throw new NullPointerException("builder.domain == null");
        }

        public final Builder domain(String str) {
            throwIfVar1IsNull(str, "domain");
            return domain(str, false);
        }

        public final Builder expiresAt(long j) {
            if (j <= 0) {
                j = Long.MIN_VALUE;
            }
            if (j > DatesKt.MAX_DATE) {
                j = 253402300799999L;
            }
            this.expiresAt = j;
            this.persistent = true;
            return this;
        }

        public final Builder hostOnlyDomain(String str) {
            throwIfVar1IsNull(str, "domain");
            return domain(str, true);
        }

        public final Builder httpOnly() {
            this.httpOnly = true;
            return this;
        }

        public final Builder name(String str) {
            throwIfVar1IsNull(str, "name");
            if (!nullSafeIsEqual(dnj.ba(str).toString(), str)) {
                throw new IllegalArgumentException("name is not trimmed");
            }
            this.name = str;
            return this;
        }

        public final Builder path(String str) {
            throwIfVar1IsNull(str, "path");
            if (!dnr.bp(str, "/", false)) {
                throw new IllegalArgumentException("path must start with '/'");
            }
            this.path = str;
            return this;
        }

        public final Builder secure() {
            this.secure = true;
            return this;
        }

        public final Builder value(String str) {
            throwIfVar1IsNull(str, "value");
            if (!nullSafeIsEqual(dnj.ba(str).toString(), str)) {
                throw new IllegalArgumentException("value is not trimmed");
            }
            this.value = str;
            return this;
        }

        private final Builder domain(String str, boolean z) {
            String canonicalHost = HostnamesKt.toCanonicalHost(str);
            if (canonicalHost == null) {
                throw new IllegalArgumentException(yg.k("unexpected domain: ", str));
            }
            this.domain = canonicalHost;
            this.hostOnly = z;
            return this;
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

        private final int dateCharacterOffset(String str, int i, int i2, boolean z) {
            while (i < i2) {
                char cCharAt = str.charAt(i);
                if (((cCharAt < ' ' && cCharAt != '\t') || cCharAt >= 127 || ('0' <= cCharAt && cCharAt < ':')
                        || (('a' <= cCharAt && cCharAt < '{')
                                || (('A' <= cCharAt && cCharAt < '[') || cCharAt == ':'))) == (!z)) {
                    return i;
                }
                i++;
            }
            return i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean domainMatch(String str, String str2) {
            return nullSafeIsEqual(str, str2)
                    || (dnr.bi(str, str2) && str.charAt((str.length() - str2.length()) - 1) == '.'
                            && !Util.canParseAsIpAddress(str));
        }

        private final String parseDomain(String str) {
            if (dnr.bi(str, ".")) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            String canonicalHost = HostnamesKt.toCanonicalHost(dnj.ao(str, "."));
            if (canonicalHost != null) {
                return canonicalHost;
            }
            throw new IllegalArgumentException();
        }

        private final long parseExpires(String str, int i, int i2) {
            int iDateCharacterOffset = dateCharacterOffset(str, i, i2, false);
            Matcher matcher = Cookie.TIME_PATTERN.matcher(str);
            int i3 = -1;
            int i4 = -1;
            int i5 = -1;
            int iAi = -1;
            int i6 = -1;
            int i7 = -1;
            while (iDateCharacterOffset < i2) {
                int iDateCharacterOffset2 = dateCharacterOffset(str, iDateCharacterOffset + 1, i2, true);
                matcher.region(iDateCharacterOffset, iDateCharacterOffset2);
                if (i4 == -1 && matcher.usePattern(Cookie.TIME_PATTERN).matches()) {
                    String strGroup = matcher.group(1);
                    throwIfVar1IsNull(strGroup, "matcher.group(1)");
                    i4 = Integer.parseInt(strGroup);
                    String strGroup2 = matcher.group(2);
                    throwIfVar1IsNull(strGroup2, "matcher.group(2)");
                    i6 = Integer.parseInt(strGroup2);
                    String strGroup3 = matcher.group(3);
                    throwIfVar1IsNull(strGroup3, "matcher.group(3)");
                    i7 = Integer.parseInt(strGroup3);
                } else if (i5 == -1 && matcher.usePattern(Cookie.DAY_OF_MONTH_PATTERN).matches()) {
                    String strGroup4 = matcher.group(1);
                    throwIfVar1IsNull(strGroup4, "matcher.group(1)");
                    i5 = Integer.parseInt(strGroup4);
                } else if (iAi == -1 && matcher.usePattern(Cookie.MONTH_PATTERN).matches()) {
                    String strGroup5 = matcher.group(1);
                    throwIfVar1IsNull(strGroup5, "matcher.group(1)");
                    Locale locale = Locale.US;
                    throwIfVar1IsNull(locale, "US");
                    String lowerCase = strGroup5.toLowerCase(locale);
                    throwIfVar1IsNull(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                    String strPattern = Cookie.MONTH_PATTERN.pattern();
                    throwIfVar1IsNull(strPattern, "MONTH_PATTERN.pattern()");
                    iAi = dnj.ai(strPattern, lowerCase, 0, false, 6) / 4;
                } else if (i3 == -1 && matcher.usePattern(Cookie.YEAR_PATTERN).matches()) {
                    String strGroup6 = matcher.group(1);
                    throwIfVar1IsNull(strGroup6, "matcher.group(1)");
                    i3 = Integer.parseInt(strGroup6);
                }
                iDateCharacterOffset = dateCharacterOffset(str, iDateCharacterOffset2 + 1, i2, false);
            }
            if (70 <= i3 && i3 < 100) {
                i3 += 1900;
            }
            if (i3 >= 0 && i3 < 70) {
                i3 += 2000;
            }
            if (i3 < 1601) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (iAi == -1) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (1 > i5 || i5 >= 32) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (i4 < 0 || i4 >= 24) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (i6 < 0 || i6 >= 60) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (i7 < 0 || i7 >= 60) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            GregorianCalendar gregorianCalendar = new GregorianCalendar(Util.UTC);
            gregorianCalendar.setLenient(false);
            gregorianCalendar.set(1, i3);
            gregorianCalendar.set(2, iAi - 1);
            gregorianCalendar.set(5, i5);
            gregorianCalendar.set(11, i4);
            gregorianCalendar.set(12, i6);
            gregorianCalendar.set(13, i7);
            gregorianCalendar.set(14, 0);
            return gregorianCalendar.getTimeInMillis();
        }

        private final long parseMaxAge(String str) {
            try {
                long j = Long.parseLong(str);
                if (j <= 0) {
                    return Long.MIN_VALUE;
                }
                return j;
            } catch (NumberFormatException e) {
                Pattern patternCompile = Pattern.compile("-?\\d+");
                throwIfVar1IsNull(patternCompile, "compile(...)");
                throwIfVar1IsNull(str, "input");
                if (patternCompile.matcher(str).matches()) {
                    return dnr.bp(str, "-", false) ? Long.MIN_VALUE : Long.MAX_VALUE;
                }
                throw e;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean pathMatch(HttpUrl httpUrl, String str) {
            String strEncodedPath = httpUrl.encodedPath();
            if (nullSafeIsEqual(strEncodedPath, str)) {
                return true;
            }
            return dnr.bp(strEncodedPath, str, false)
                    && (dnr.bi(str, "/") || strEncodedPath.charAt(str.length()) == '/');
        }

        public final Cookie parse(HttpUrl httpUrl, String str) {
            throwIfVar1IsNull(httpUrl, "url");
            throwIfVar1IsNull(str, "setCookie");
            return parse$okhttp(System.currentTimeMillis(), httpUrl, str);
        }

        public final Cookie parse$okhttp(long j, HttpUrl httpUrl, String str) {
            long j2;
            throwIfVar1IsNull(httpUrl, "url");
            throwIfVar1IsNull(str, "setCookie");
            int iDelimiterOffset$default = Util.delimiterOffset$default(str,
                    TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER, 0, 0, 6,
                    (Object) null);
            int iDelimiterOffset$default2 = Util.delimiterOffset$default(str, SignatureVisitor.INSTANCEOF, 0,
                    iDelimiterOffset$default, 2, (Object) null);
            String domain = null;
            if (iDelimiterOffset$default2 != iDelimiterOffset$default) {
                String strTrimSubstring$default = Util.trimSubstring$default(str, 0, iDelimiterOffset$default2, 1,
                        null);
                if (strTrimSubstring$default.length() != 0
                        && Util.indexOfControlOrNonAscii(strTrimSubstring$default) == -1) {
                    String strTrimSubstring = Util.trimSubstring(str, iDelimiterOffset$default2 + 1,
                            iDelimiterOffset$default);
                    if (Util.indexOfControlOrNonAscii(strTrimSubstring) == -1) {
                        int i = iDelimiterOffset$default + 1;
                        int length = str.length();
                        String str2 = null;
                        boolean z = false;
                        boolean z2 = false;
                        boolean z3 = false;
                        boolean z4 = true;
                        long maxAge = -1;
                        long expires = DatesKt.MAX_DATE;
                        while (i < length) {
                            int iDelimiterOffset = Util.delimiterOffset(str,
                                    TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER, i,
                                    length);
                            int iDelimiterOffset2 = Util.delimiterOffset(str, SignatureVisitor.INSTANCEOF, i,
                                    iDelimiterOffset);
                            String strTrimSubstring2 = Util.trimSubstring(str, i, iDelimiterOffset2);
                            String strTrimSubstring3 = iDelimiterOffset2 < iDelimiterOffset
                                    ? Util.trimSubstring(str, iDelimiterOffset2 + 1, iDelimiterOffset)
                                    : "";
                            if (dnr.bj(strTrimSubstring2, "expires", true)) {
                                try {
                                    expires = parseExpires(strTrimSubstring3, 0, strTrimSubstring3.length());
                                    z2 = true;
                                } catch (NumberFormatException | IllegalArgumentException unused) {
                                }
                            } else if (dnr.bj(strTrimSubstring2, "max-age", true)) {
                                maxAge = parseMaxAge(strTrimSubstring3);
                                z2 = true;
                            } else if (dnr.bj(strTrimSubstring2, "domain", true)) {
                                domain = parseDomain(strTrimSubstring3);
                                z4 = false;
                            } else if (dnr.bj(strTrimSubstring2, "path", true)) {
                                str2 = strTrimSubstring3;
                            } else if (dnr.bj(strTrimSubstring2, "secure", true)) {
                                z3 = true;
                            } else if (dnr.bj(strTrimSubstring2, "httponly", true)) {
                                z = true;
                            }
                            i = iDelimiterOffset + 1;
                        }
                        if (maxAge == Long.MIN_VALUE) {
                            j2 = Long.MIN_VALUE;
                        } else if (maxAge != -1) {
                            long j3 = j + (maxAge <= 9223372036854775L ? maxAge * ((long) 1000) : Long.MAX_VALUE);
                            j2 = (j3 < j || j3 > DatesKt.MAX_DATE) ? 253402300799999L : j3;
                        } else {
                            j2 = expires;
                        }
                        String strHost = httpUrl.host();
                        if (domain == null) {
                            domain = strHost;
                        } else if (!domainMatch(strHost, domain)) {
                            return null;
                        }
                        if (strHost.length() != domain.length()
                                && PublicSuffixDatabase.Companion.get().getEffectiveTldPlusOne(domain) == null) {
                            return null;
                        }
                        String strSubstring = "/";
                        if (str2 == null || !dnr.bp(str2, "/", false)) {
                            String strEncodedPath = httpUrl.encodedPath();
                            int iAm = dnj.am(strEncodedPath, '/', 0, 6);
                            if (iAm != 0) {
                                strSubstring = strEncodedPath.substring(0, iAm);
                                throwIfVar1IsNull(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                            }
                            str2 = strSubstring;
                        }
                        return new Cookie(strTrimSubstring$default, strTrimSubstring, j2, domain, str2, z3, z, z2, z4,
                                null);
                    }
                }
            }
            return null;
        }

        public final List<Cookie> parseAll(HttpUrl httpUrl, Headers headers) {
            throwIfVar1IsNull(httpUrl, "url");
            throwIfVar1IsNull(headers, "headers");
            List<String> listValues = headers.values("Set-Cookie");
            int size = listValues.size();
            ArrayList arrayList = null;
            for (int i = 0; i < size; i++) {
                Cookie cookie = parse(httpUrl, listValues.get(i));
                if (cookie != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(cookie);
                }
            }
            if (arrayList == null) {
                return avd.a;
            }
            List<Cookie> listUnmodifiableList = Collections.unmodifiableList(arrayList);
            throwIfVar1IsNull(listUnmodifiableList, "{\n        Collections.un…ableList(cookies)\n      }");
            return listUnmodifiableList;
        }

        private Companion() {
        }
    }

    public /* synthetic */ Cookie(String str, String str2, long j, String str3, String str4, boolean z, boolean z2,
            boolean z3, boolean z4, akd akdVar) {
        this(str, str2, j, str3, str4, z, z2, z3, z4);
    }

    public static final Cookie parse(HttpUrl httpUrl, String str) {
        return Companion.parse(httpUrl, str);
    }

    public static final List<Cookie> parseAll(HttpUrl httpUrl, Headers headers) {
        return Companion.parseAll(httpUrl, headers);
    }

    public final String a() {
        return this.domain;
    }

    public final long b() {
        return this.expiresAt;
    }

    public final boolean c() {
        return this.hostOnly;
    }

    public final boolean d() {
        return this.httpOnly;
    }

    public final String domain() {
        return this.domain;
    }

    public final String e() {
        return this.name;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Cookie)) {
            return false;
        }
        Cookie cookie = (Cookie) obj;
        return nullSafeIsEqual(cookie.name, this.name) && nullSafeIsEqual(cookie.value, this.value)
                && cookie.expiresAt == this.expiresAt
                && nullSafeIsEqual(cookie.domain, this.domain) && nullSafeIsEqual(cookie.path, this.path)
                && cookie.secure == this.secure
                && cookie.httpOnly == this.httpOnly && cookie.persistent == this.persistent
                && cookie.hostOnly == this.hostOnly;
    }

    public final long expiresAt() {
        return this.expiresAt;
    }

    public final String f() {
        return this.path;
    }

    public final boolean g() {
        return this.persistent;
    }

    public final boolean h() {
        return this.secure;
    }

    public int hashCode() {
        return Boolean.hashCode(this.hostOnly) + ((Boolean.hashCode(this.persistent) + ((Boolean.hashCode(this.httpOnly)
                + ((Boolean.hashCode(this.secure) + bjs.e(this.path, bjs.e(this.domain,
                        (Long.hashCode(this.expiresAt) + bjs.e(this.value, bjs.e(this.name, 527, 31), 31)) * 31, 31),
                        31)) * 31))
                * 31)) * 31);
    }

    public final boolean hostOnly() {
        return this.hostOnly;
    }

    public final boolean httpOnly() {
        return this.httpOnly;
    }

    public final String i() {
        return this.value;
    }

    public final boolean matches(HttpUrl httpUrl) {
        throwIfVar1IsNull(httpUrl, "url");
        if ((this.hostOnly ? nullSafeIsEqual(httpUrl.host(), this.domain)
                : Companion.domainMatch(httpUrl.host(), this.domain))
                && Companion.pathMatch(httpUrl, this.path)) {
            return !this.secure || httpUrl.isHttps();
        }
        return false;
    }

    public final String name() {
        return this.name;
    }

    public final String path() {
        return this.path;
    }

    public final boolean persistent() {
        return this.persistent;
    }

    public final boolean secure() {
        return this.secure;
    }

    public String toString() {
        return toString$okhttp(false);
    }

    public final String toString$okhttp(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        sb.append(SignatureVisitor.INSTANCEOF);
        sb.append(this.value);
        if (this.persistent) {
            if (this.expiresAt == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(DatesKt.toHttpDateString(new Date(this.expiresAt)));
            }
        }
        if (!this.hostOnly) {
            sb.append("; domain=");
            if (z) {
                sb.append(".");
            }
            sb.append(this.domain);
        }
        sb.append("; path=");
        sb.append(this.path);
        if (this.secure) {
            sb.append("; secure");
        }
        if (this.httpOnly) {
            sb.append("; httponly");
        }
        String string = sb.toString();
        throwIfVar1IsNull(string, "toString()");
        return string;
    }

    public final String value() {
        return this.value;
    }

    private Cookie(String str, String str2, long j, String str3, String str4, boolean z, boolean z2, boolean z3,
            boolean z4) {
        this.name = str;
        this.value = str2;
        this.expiresAt = j;
        this.domain = str3;
        this.path = str4;
        this.secure = z;
        this.httpOnly = z2;
        this.persistent = z3;
        this.hostOnly = z4;
    }
}
