package okhttp3.internal.http2;

import me.hd.wauxv.obf.akd;
import me.hd.wauxv.obf.KotlinHelpers;
import me.hd.wauxv.obf.nu;
import me.hd.wauxv.obf.sj;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class Header {
    public static final Companion Companion = new Companion(null);
    public static final sj PSEUDO_PREFIX;
    public static final sj RESPONSE_STATUS;
    public static final String RESPONSE_STATUS_UTF8 = ":status";
    public static final sj TARGET_AUTHORITY;
    public static final String TARGET_AUTHORITY_UTF8 = ":authority";
    public static final sj TARGET_METHOD;
    public static final String TARGET_METHOD_UTF8 = ":method";
    public static final sj TARGET_PATH;
    public static final String TARGET_PATH_UTF8 = ":path";
    public static final sj TARGET_SCHEME;
    public static final String TARGET_SCHEME_UTF8 = ":scheme";
    public final int hpackSize;
    public final sj name;
    public final sj value;

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public static final class Companion {
        public /* synthetic */ Companion(akd akdVar) {
            this();
        }

        private Companion() {
        }
    }

    static {
        sj sjVar = sj.a;
        PSEUDO_PREFIX = nu.g(":");
        RESPONSE_STATUS = nu.g(RESPONSE_STATUS_UTF8);
        TARGET_METHOD = nu.g(TARGET_METHOD_UTF8);
        TARGET_PATH = nu.g(TARGET_PATH_UTF8);
        TARGET_SCHEME = nu.g(TARGET_SCHEME_UTF8);
        TARGET_AUTHORITY = nu.g(TARGET_AUTHORITY_UTF8);
    }

    public Header(sj sjVar, sj sjVar2) {
        throwIfVar1IsNull(sjVar, "name");
        throwIfVar1IsNull(sjVar2, "value");
        this.name = sjVar;
        this.value = sjVar2;
        this.hpackSize = sjVar2.g() + sjVar.g() + 32;
    }

    public static /* synthetic */ Header copy$default(Header header, sj sjVar, sj sjVar2, int i, Object obj) {
        if ((i & 1) != 0) {
            sjVar = header.name;
        }
        if ((i & 2) != 0) {
            sjVar2 = header.value;
        }
        return header.copy(sjVar, sjVar2);
    }

    public final sj component1() {
        return this.name;
    }

    public final sj component2() {
        return this.value;
    }

    public final Header copy(sj sjVar, sj sjVar2) {
        throwIfVar1IsNull(sjVar, "name");
        throwIfVar1IsNull(sjVar2, "value");
        return new Header(sjVar, sjVar2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Header)) {
            return false;
        }
        Header header = (Header) obj;
        return nullSafeIsEqual(this.name, header.name) && nullSafeIsEqual(this.value, header.value);
    }

    public int hashCode() {
        return this.value.hashCode() + (this.name.hashCode() * 31);
    }

    public String toString() {
        return this.name.n() + ": " + this.value.n();
    }

    /*
     * JADX WARN: 'this' call moved to the top of the method (can break code
     * semantics)
     */
    public Header(String str, String str2) {
        this(nu.g(str), nu.g(str2));
        throwIfVar1IsNull(str, "name");
        throwIfVar1IsNull(str2, "value");
        sj sjVar = sj.a;
    }

    /*
     * JADX WARN: 'this' call moved to the top of the method (can break code
     * semantics)
     */
    public Header(sj sjVar, String str) {
        this(sjVar, nu.g(str));
        throwIfVar1IsNull(sjVar, "name");
        throwIfVar1IsNull(str, "value");
        sj sjVar2 = sj.a;
    }
}
