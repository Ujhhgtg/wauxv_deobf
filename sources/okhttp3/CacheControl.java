package okhttp3;

import java.util.concurrent.TimeUnit;
import me.hd.wauxv.obf.akd;
import me.hd.wauxv.obf.StringsKt;
import me.hd.wauxv.obf.dnr;
import okhttp3.internal.Util;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class CacheControl {
    private String headerValue;
    private final boolean immutable;
    private final boolean isPrivate;
    private final boolean isPublic;
    private final int maxAgeSeconds;
    private final int maxStaleSeconds;
    private final int minFreshSeconds;
    private final boolean mustRevalidate;
    private final boolean noCache;
    private final boolean noStore;
    private final boolean noTransform;
    private final boolean onlyIfCached;
    private final int sMaxAgeSeconds;
    public static final Companion Companion = new Companion(null);
    public static final CacheControl FORCE_NETWORK = new Builder().noCache().build();
    public static final CacheControl FORCE_CACHE = new Builder().onlyIfCached()
            .maxStale(Integer.MAX_VALUE, TimeUnit.SECONDS).build();

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public static final class Builder {
        private boolean immutable;
        private int maxAgeSeconds = -1;
        private int maxStaleSeconds = -1;
        private int minFreshSeconds = -1;
        private boolean noCache;
        private boolean noStore;
        private boolean noTransform;
        private boolean onlyIfCached;

        private final int clampToInt(long j) {
            if (j > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            return (int) j;
        }

        public final CacheControl build() {
            return new CacheControl(this.noCache, this.noStore, this.maxAgeSeconds, -1, false, false, false,
                    this.maxStaleSeconds, this.minFreshSeconds, this.onlyIfCached, this.noTransform, this.immutable,
                    null, null);
        }

        public final Builder immutable() {
            this.immutable = true;
            return this;
        }

        public final Builder maxAge(int i, TimeUnit timeUnit) {
            throwIfVar1IsNull(timeUnit, "timeUnit");
            if (i < 0) {
                throw new IllegalArgumentException(concatVar2Var1(i, "maxAge < 0: ").toString());
            }
            this.maxAgeSeconds = clampToInt(timeUnit.toSeconds(i));
            return this;
        }

        public final Builder maxStale(int i, TimeUnit timeUnit) {
            throwIfVar1IsNull(timeUnit, "timeUnit");
            if (i < 0) {
                throw new IllegalArgumentException(concatVar2Var1(i, "maxStale < 0: ").toString());
            }
            this.maxStaleSeconds = clampToInt(timeUnit.toSeconds(i));
            return this;
        }

        public final Builder minFresh(int i, TimeUnit timeUnit) {
            throwIfVar1IsNull(timeUnit, "timeUnit");
            if (i < 0) {
                throw new IllegalArgumentException(concatVar2Var1(i, "minFresh < 0: ").toString());
            }
            this.minFreshSeconds = clampToInt(timeUnit.toSeconds(i));
            return this;
        }

        public final Builder noCache() {
            this.noCache = true;
            return this;
        }

        public final Builder noStore() {
            this.noStore = true;
            return this;
        }

        public final Builder noTransform() {
            this.noTransform = true;
            return this;
        }

        public final Builder onlyIfCached() {
            this.onlyIfCached = true;
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

        private final int indexOfElement(String str, String str2, int i) {
            int length = str.length();
            while (i < length) {
                if (StringsKt.containsChar(str2, str.charAt(i))) {
                    return i;
                }
                i++;
            }
            return str.length();
        }

        public static /* synthetic */ int indexOfElement$default(Companion companion, String str, String str2, int i,
                int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = 0;
            }
            return companion.indexOfElement(str, str2, i);
        }

        /* JADX WARN: Found duplicated region for block: B:15:0x004b */
        /* JADX WARN: Found duplicated region for block: B:17:0x006a */
        /* JADX WARN: Found duplicated region for block: B:28:0x00b8 */
        /* JADX WARN: Found duplicated region for block: B:32:0x00c6 A[MOVE_INLINED] */
        /* JADX WARN: Found duplicated region for block: B:34:0x00d0 */
        /* JADX WARN: Found duplicated region for block: B:36:0x00d8 A[MOVE_INLINED] */
        /* JADX WARN: Found duplicated region for block: B:37:0x00df */
        /* JADX WARN: Found duplicated region for block: B:39:0x00e7 */
        /* JADX WARN: Found duplicated region for block: B:41:0x00f2 */
        /* JADX WARN: Found duplicated region for block: B:43:0x00fb */
        /* JADX WARN: Found duplicated region for block: B:44:0x0100 */
        /* JADX WARN: Found duplicated region for block: B:46:0x0108 A[MOVE_INLINED] */
        /* JADX WARN: Found duplicated region for block: B:47:0x010f */
        /* JADX WARN: Found duplicated region for block: B:49:0x0117 A[MOVE_INLINED] */
        /* JADX WARN: Found duplicated region for block: B:50:0x011e */
        /* JADX WARN: Found duplicated region for block: B:52:0x0126 A[MOVE_INLINED] */
        /* JADX WARN: Found duplicated region for block: B:53:0x012e */
        /* JADX WARN: Found duplicated region for block: B:55:0x0136 */
        /* JADX WARN: Found duplicated region for block: B:56:0x013e */
        /* JADX WARN: Found duplicated region for block: B:58:0x0146 */
        /* JADX WARN: Found duplicated region for block: B:59:0x014c */
        /* JADX WARN: Found duplicated region for block: B:61:0x0155 A[MOVE_INLINED] */
        /* JADX WARN: Found duplicated region for block: B:62:0x015e */
        /* JADX WARN: Found duplicated region for block: B:64:0x0166 A[MOVE_INLINED] */
        /* JADX WARN: Found duplicated region for block: B:65:0x016f */
        /* JADX WARN: Found duplicated region for block: B:67:0x0177 A[MOVE_INLINED] */
        public final CacheControl parse(Headers headers) {
            int i;
            int iIndexOfElement;
            boolean z;
            String string;
            int i2;
            int iIndexOfElement2;
            String string2;
            Headers headers2 = headers;
            throwIfVar1IsNull(headers2, "headers");
            int size = headers2.size();
            boolean z2 = true;
            boolean z3 = true;
            int i3 = 0;
            String str = null;
            boolean z4 = false;
            boolean z5 = false;
            int nonNegativeInt = -1;
            int nonNegativeInt2 = -1;
            boolean z6 = false;
            boolean z7 = false;
            boolean z8 = false;
            int nonNegativeInt3 = -1;
            int nonNegativeInt4 = -1;
            boolean z9 = false;
            boolean z10 = false;
            boolean z11 = false;
            while (i3 < size) {
                String strName = headers2.name(i3);
                String strValue = headers2.value(i3);
                if (dnr.bj(strName, "Cache-Control", z2)) {
                    if (str == null) {
                        str = strValue;
                    }
                    i = 0;
                    while (i < strValue.length()) {
                        iIndexOfElement = indexOfElement(strValue, "=,;", i);
                        String strSubstring = strValue.substring(i, iIndexOfElement);
                        z = z2;
                        throwIfVar1IsNull(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                        string = StringsKt.ba(strSubstring).toString();
                        if (iIndexOfElement != strValue.length()) {
                            i2 = size;
                            if (strValue.charAt(iIndexOfElement) == ',' && strValue.charAt(iIndexOfElement) != ';') {
                                int iIndexOfNonWhitespace = Util.indexOfNonWhitespace(strValue, iIndexOfElement + 1);
                                if (iIndexOfNonWhitespace >= strValue.length()
                                        || strValue.charAt(iIndexOfNonWhitespace) != '\"') {
                                    iIndexOfElement2 = indexOfElement(strValue, ",;", iIndexOfNonWhitespace);
                                    String strSubstring2 = strValue.substring(iIndexOfNonWhitespace, iIndexOfElement2);
                                    throwIfVar1IsNull(strSubstring2,
                                            "this as java.lang.String…ing(startIndex, endIndex)");
                                    string2 = StringsKt.ba(strSubstring2).toString();
                                } else {
                                    int i4 = iIndexOfNonWhitespace + 1;
                                    int iAh = StringsKt.indexOf('\"', i4, 4, strValue);
                                    string2 = strValue.substring(i4, iAh);
                                    throwIfVar1IsNull(string2, "this as java.lang.String…ing(startIndex, endIndex)");
                                    iIndexOfElement2 = iAh + 1;
                                }
                            }
                            if ("no-cache".equalsIgnoreCase(string)) {
                                i = iIndexOfElement2;
                                z2 = z;
                                z4 = z2;
                            } else if ("no-store".equalsIgnoreCase(string)) {
                                i = iIndexOfElement2;
                                z2 = z;
                                z5 = z2;
                            } else {
                                if ("max-age".equalsIgnoreCase(string)) {
                                    nonNegativeInt = Util.toNonNegativeInt(string2, -1);
                                } else if ("s-maxage".equalsIgnoreCase(string)) {
                                    nonNegativeInt2 = Util.toNonNegativeInt(string2, -1);
                                } else if ("private".equalsIgnoreCase(string)) {
                                    i = iIndexOfElement2;
                                    z2 = z;
                                    z6 = z2;
                                } else if ("public".equalsIgnoreCase(string)) {
                                    i = iIndexOfElement2;
                                    z2 = z;
                                    z7 = z2;
                                } else if ("must-revalidate".equalsIgnoreCase(string)) {
                                    i = iIndexOfElement2;
                                    z2 = z;
                                    z8 = z2;
                                } else if ("max-stale".equalsIgnoreCase(string)) {
                                    nonNegativeInt3 = Util.toNonNegativeInt(string2, Integer.MAX_VALUE);
                                } else if ("min-fresh".equalsIgnoreCase(string)) {
                                    nonNegativeInt4 = Util.toNonNegativeInt(string2, -1);
                                } else if ("only-if-cached".equalsIgnoreCase(string)) {
                                    i = iIndexOfElement2;
                                    z2 = z;
                                    z9 = z2;
                                } else if ("no-transform".equalsIgnoreCase(string)) {
                                    i = iIndexOfElement2;
                                    z2 = z;
                                    z10 = z2;
                                } else if ("immutable".equalsIgnoreCase(string)) {
                                    i = iIndexOfElement2;
                                    z2 = z;
                                    z11 = z2;
                                }
                                i = iIndexOfElement2;
                                z2 = z;
                            }
                            size = i2;
                        } else {
                            i2 = size;
                        }
                        iIndexOfElement2 = iIndexOfElement + 1;
                        string2 = null;
                        if ("no-cache".equalsIgnoreCase(string)) {
                            i = iIndexOfElement2;
                            z2 = z;
                            z4 = z2;
                        } else if ("no-store".equalsIgnoreCase(string)) {
                            i = iIndexOfElement2;
                            z2 = z;
                            z5 = z2;
                        } else {
                            if ("max-age".equalsIgnoreCase(string)) {
                                nonNegativeInt = Util.toNonNegativeInt(string2, -1);
                            } else if ("s-maxage".equalsIgnoreCase(string)) {
                                nonNegativeInt2 = Util.toNonNegativeInt(string2, -1);
                            } else if ("private".equalsIgnoreCase(string)) {
                                i = iIndexOfElement2;
                                z2 = z;
                                z6 = z2;
                            } else if ("public".equalsIgnoreCase(string)) {
                                i = iIndexOfElement2;
                                z2 = z;
                                z7 = z2;
                            } else if ("must-revalidate".equalsIgnoreCase(string)) {
                                i = iIndexOfElement2;
                                z2 = z;
                                z8 = z2;
                            } else if ("max-stale".equalsIgnoreCase(string)) {
                                nonNegativeInt3 = Util.toNonNegativeInt(string2, Integer.MAX_VALUE);
                            } else if ("min-fresh".equalsIgnoreCase(string)) {
                                nonNegativeInt4 = Util.toNonNegativeInt(string2, -1);
                            } else if ("only-if-cached".equalsIgnoreCase(string)) {
                                i = iIndexOfElement2;
                                z2 = z;
                                z9 = z2;
                            } else if ("no-transform".equalsIgnoreCase(string)) {
                                i = iIndexOfElement2;
                                z2 = z;
                                z10 = z2;
                            } else if ("immutable".equalsIgnoreCase(string)) {
                                i = iIndexOfElement2;
                                z2 = z;
                                z11 = z2;
                            }
                            i = iIndexOfElement2;
                            z2 = z;
                        }
                        size = i2;
                    }
                    i3++;
                    headers2 = headers;
                    z2 = z2;
                    size = size;
                } else {
                    if (dnr.bj(strName, "Pragma", z2)) {
                    }
                    i3++;
                    headers2 = headers;
                    z2 = z2;
                    size = size;
                }
                z3 = false;
                i = 0;
                while (i < strValue.length()) {
                    iIndexOfElement = indexOfElement(strValue, "=,;", i);
                    String strSubstring3 = strValue.substring(i, iIndexOfElement);
                    z = z2;
                    throwIfVar1IsNull(strSubstring3, "this as java.lang.String…ing(startIndex, endIndex)");
                    string = StringsKt.ba(strSubstring3).toString();
                    if (iIndexOfElement != strValue.length()) {
                        i2 = size;
                        if (strValue.charAt(iIndexOfElement) == ',') {
                        }
                        if ("no-cache".equalsIgnoreCase(string)) {
                            i = iIndexOfElement2;
                            z2 = z;
                            z4 = z2;
                        } else if ("no-store".equalsIgnoreCase(string)) {
                            i = iIndexOfElement2;
                            z2 = z;
                            z5 = z2;
                        } else {
                            if ("max-age".equalsIgnoreCase(string)) {
                                nonNegativeInt = Util.toNonNegativeInt(string2, -1);
                            } else if ("s-maxage".equalsIgnoreCase(string)) {
                                nonNegativeInt2 = Util.toNonNegativeInt(string2, -1);
                            } else if ("private".equalsIgnoreCase(string)) {
                                i = iIndexOfElement2;
                                z2 = z;
                                z6 = z2;
                            } else if ("public".equalsIgnoreCase(string)) {
                                i = iIndexOfElement2;
                                z2 = z;
                                z7 = z2;
                            } else if ("must-revalidate".equalsIgnoreCase(string)) {
                                i = iIndexOfElement2;
                                z2 = z;
                                z8 = z2;
                            } else if ("max-stale".equalsIgnoreCase(string)) {
                                nonNegativeInt3 = Util.toNonNegativeInt(string2, Integer.MAX_VALUE);
                            } else if ("min-fresh".equalsIgnoreCase(string)) {
                                nonNegativeInt4 = Util.toNonNegativeInt(string2, -1);
                            } else if ("only-if-cached".equalsIgnoreCase(string)) {
                                i = iIndexOfElement2;
                                z2 = z;
                                z9 = z2;
                            } else if ("no-transform".equalsIgnoreCase(string)) {
                                i = iIndexOfElement2;
                                z2 = z;
                                z10 = z2;
                            } else if ("immutable".equalsIgnoreCase(string)) {
                                i = iIndexOfElement2;
                                z2 = z;
                                z11 = z2;
                            }
                            i = iIndexOfElement2;
                            z2 = z;
                        }
                        size = i2;
                    } else {
                        i2 = size;
                    }
                    iIndexOfElement2 = iIndexOfElement + 1;
                    string2 = null;
                    if ("no-cache".equalsIgnoreCase(string)) {
                        i = iIndexOfElement2;
                        z2 = z;
                        z4 = z2;
                    } else if ("no-store".equalsIgnoreCase(string)) {
                        i = iIndexOfElement2;
                        z2 = z;
                        z5 = z2;
                    } else {
                        if ("max-age".equalsIgnoreCase(string)) {
                            nonNegativeInt = Util.toNonNegativeInt(string2, -1);
                        } else if ("s-maxage".equalsIgnoreCase(string)) {
                            nonNegativeInt2 = Util.toNonNegativeInt(string2, -1);
                        } else if ("private".equalsIgnoreCase(string)) {
                            i = iIndexOfElement2;
                            z2 = z;
                            z6 = z2;
                        } else if ("public".equalsIgnoreCase(string)) {
                            i = iIndexOfElement2;
                            z2 = z;
                            z7 = z2;
                        } else if ("must-revalidate".equalsIgnoreCase(string)) {
                            i = iIndexOfElement2;
                            z2 = z;
                            z8 = z2;
                        } else if ("max-stale".equalsIgnoreCase(string)) {
                            nonNegativeInt3 = Util.toNonNegativeInt(string2, Integer.MAX_VALUE);
                        } else if ("min-fresh".equalsIgnoreCase(string)) {
                            nonNegativeInt4 = Util.toNonNegativeInt(string2, -1);
                        } else if ("only-if-cached".equalsIgnoreCase(string)) {
                            i = iIndexOfElement2;
                            z2 = z;
                            z9 = z2;
                        } else if ("no-transform".equalsIgnoreCase(string)) {
                            i = iIndexOfElement2;
                            z2 = z;
                            z10 = z2;
                        } else if ("immutable".equalsIgnoreCase(string)) {
                            i = iIndexOfElement2;
                            z2 = z;
                            z11 = z2;
                        }
                        i = iIndexOfElement2;
                        z2 = z;
                    }
                    size = i2;
                }
                i3++;
                headers2 = headers;
                z2 = z2;
                size = size;
            }
            return new CacheControl(z4, z5, nonNegativeInt, nonNegativeInt2, z6, z7, z8, nonNegativeInt3,
                    nonNegativeInt4, z9, z10, z11, !z3 ? null : str, null);
        }

        private Companion() {
        }
    }

    public /* synthetic */ CacheControl(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5,
            int i3, int i4, boolean z6, boolean z7, boolean z8, String str, akd akdVar) {
        this(z, z2, i, i2, z3, z4, z5, i3, i4, z6, z7, z8, str);
    }

    public static final CacheControl parse(Headers headers) {
        return Companion.parse(headers);
    }

    public final boolean a() {
        return this.immutable;
    }

    public final int b() {
        return this.maxAgeSeconds;
    }

    public final int c() {
        return this.maxStaleSeconds;
    }

    public final int d() {
        return this.minFreshSeconds;
    }

    public final boolean e() {
        return this.mustRevalidate;
    }

    public final boolean f() {
        return this.noCache;
    }

    public final boolean g() {
        return this.noStore;
    }

    public final boolean h() {
        return this.noTransform;
    }

    public final boolean i() {
        return this.onlyIfCached;
    }

    public final boolean immutable() {
        return this.immutable;
    }

    public final boolean isPrivate() {
        return this.isPrivate;
    }

    public final boolean isPublic() {
        return this.isPublic;
    }

    public final int j() {
        return this.sMaxAgeSeconds;
    }

    public final int maxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    public final int maxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    public final int minFreshSeconds() {
        return this.minFreshSeconds;
    }

    public final boolean mustRevalidate() {
        return this.mustRevalidate;
    }

    public final boolean noCache() {
        return this.noCache;
    }

    public final boolean noStore() {
        return this.noStore;
    }

    public final boolean noTransform() {
        return this.noTransform;
    }

    public final boolean onlyIfCached() {
        return this.onlyIfCached;
    }

    public final int sMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }

    public String toString() {
        String str = this.headerValue;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        if (this.noCache) {
            sb.append("no-cache, ");
        }
        if (this.noStore) {
            sb.append("no-store, ");
        }
        if (this.maxAgeSeconds != -1) {
            sb.append("max-age=");
            sb.append(this.maxAgeSeconds);
            sb.append(", ");
        }
        if (this.sMaxAgeSeconds != -1) {
            sb.append("s-maxage=");
            sb.append(this.sMaxAgeSeconds);
            sb.append(", ");
        }
        if (this.isPrivate) {
            sb.append("private, ");
        }
        if (this.isPublic) {
            sb.append("public, ");
        }
        if (this.mustRevalidate) {
            sb.append("must-revalidate, ");
        }
        if (this.maxStaleSeconds != -1) {
            sb.append("max-stale=");
            sb.append(this.maxStaleSeconds);
            sb.append(", ");
        }
        if (this.minFreshSeconds != -1) {
            sb.append("min-fresh=");
            sb.append(this.minFreshSeconds);
            sb.append(", ");
        }
        if (this.onlyIfCached) {
            sb.append("only-if-cached, ");
        }
        if (this.noTransform) {
            sb.append("no-transform, ");
        }
        if (this.immutable) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        String string = sb.toString();
        throwIfVar1IsNull(string, "StringBuilder().apply(builderAction).toString()");
        this.headerValue = string;
        return string;
    }

    private CacheControl(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4,
            boolean z6, boolean z7, boolean z8, String str) {
        this.noCache = z;
        this.noStore = z2;
        this.maxAgeSeconds = i;
        this.sMaxAgeSeconds = i2;
        this.isPrivate = z3;
        this.isPublic = z4;
        this.mustRevalidate = z5;
        this.maxStaleSeconds = i3;
        this.minFreshSeconds = i4;
        this.onlyIfCached = z6;
        this.noTransform = z7;
        this.immutable = z8;
        this.headerValue = str;
    }
}
