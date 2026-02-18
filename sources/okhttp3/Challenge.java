package okhttp3;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import me.hd.wauxv.obf.bjs;
import me.hd.wauxv.obf.KotlinHelpers;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class Challenge {
    private final Map<String, String> authParams;
    private final String scheme;

    public Challenge(String str, Map<String, String> map) {
        String lowerCase;
        throwIfVar1IsNull(str, "scheme");
        throwIfVar1IsNull(map, "authParams");
        this.scheme = str;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key != null) {
                Locale locale = Locale.US;
                throwIfVar1IsNull(locale, "US");
                lowerCase = key.toLowerCase(locale);
                throwIfVar1IsNull(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            } else {
                lowerCase = null;
            }
            linkedHashMap.put(lowerCase, value);
        }
        Map<String, String> mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        throwIfVar1IsNull(mapUnmodifiableMap, "unmodifiableMap<String?, String>(newAuthParams)");
        this.authParams = mapUnmodifiableMap;
    }

    public final Map<String, String> a() {
        return this.authParams;
    }

    public final Map<String, String> authParams() {
        return this.authParams;
    }

    public final Charset b() {
        return charset();
    }

    public final String c() {
        return realm();
    }

    public final Charset charset() {
        String str = this.authParams.get("charset");
        if (str != null) {
            try {
                Charset charsetForName = Charset.forName(str);
                throwIfVar1IsNull(charsetForName, "forName(charset)");
                return charsetForName;
            } catch (Exception unused) {
            }
        }
        Charset charset = StandardCharsets.ISO_8859_1;
        throwIfVar1IsNull(charset, "ISO_8859_1");
        return charset;
    }

    public final String d() {
        return this.scheme;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Challenge)) {
            return false;
        }
        Challenge challenge = (Challenge) obj;
        return nullSafeIsEqual(challenge.scheme, this.scheme) && nullSafeIsEqual(challenge.authParams, this.authParams);
    }

    public int hashCode() {
        return this.authParams.hashCode() + bjs.e(this.scheme, 899, 31);
    }

    public final String realm() {
        return this.authParams.get("realm");
    }

    public final String scheme() {
        return this.scheme;
    }

    public String toString() {
        return this.scheme + " authParams=" + this.authParams;
    }

    public final Challenge withCharset(Charset charset) {
        throwIfVar1IsNull(charset, "charset");
        Map<String, String> map = this.authParams;
        throwIfVar1IsNull(map, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        String strName = charset.name();
        throwIfVar1IsNull(strName, "charset.name()");
        linkedHashMap.put("charset", strName);
        return new Challenge(this.scheme, linkedHashMap);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Challenge(String str, String str2) {
        throwIfVar1IsNull(str, "scheme");
        throwIfVar1IsNull(str2, "realm");
        Map mapSingletonMap = Collections.singletonMap("realm", str2);
        throwIfVar1IsNull(mapSingletonMap, "singletonMap(\"realm\", realm)");
        this(str, (Map<String, String>) mapSingletonMap);
    }
}
