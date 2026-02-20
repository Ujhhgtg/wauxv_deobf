package okhttp3;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import me.hd.wauxv.obf.StaticHelpers2;
import me.hd.wauxv.obf.akd;
import me.hd.wauxv.obf.EmptyReadonlyList;
import me.hd.wauxv.obf.IEmpty;
import me.hd.wauxv.obf.cnb;
import me.hd.wauxv.obf.KotlinHelpers2;
import me.hd.wauxv.obf.Pair;
import me.hd.wauxv.obf.StringsKt;
import me.hd.wauxv.obf.dnr;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class Headers implements Iterable<Pair>, IEmpty {
    public static final Companion Companion = new Companion(null);
    private final String[] namesAndValues;

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public static final class Builder {
        private final List<String> namesAndValues = new ArrayList(20);

        public final Builder add(String str) {
            throwIfVar1IsNull(str, "line");
            int iAh = StringsKt.indexOf(':', 0, 6, str);
            if (iAh == -1) {
                throw new IllegalArgumentException("Unexpected header: ".concat(str).toString());
            }
            String strSubstring = str.substring(0, iAh);
            throwIfVar1IsNull(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            String string = StringsKt.ba(strSubstring).toString();
            String strSubstring2 = str.substring(iAh + 1);
            throwIfVar1IsNull(strSubstring2, "this as java.lang.String).substring(startIndex)");
            add(string, strSubstring2);
            return this;
        }

        public final Builder addAll(Headers headers) {
            throwIfVar1IsNull(headers, "headers");
            int size = headers.size();
            for (int i = 0; i < size; i++) {
                addLenient$okhttp(headers.name(i), headers.value(i));
            }
            return this;
        }

        public final Builder addLenient$okhttp(String str) {
            throwIfVar1IsNull(str, "line");
            int iAh = StringsKt.indexOf(':', 1, 4, str);
            if (iAh != -1) {
                String strSubstring = str.substring(0, iAh);
                throwIfVar1IsNull(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                String strSubstring2 = str.substring(iAh + 1);
                throwIfVar1IsNull(strSubstring2, "this as java.lang.String).substring(startIndex)");
                addLenient$okhttp(strSubstring, strSubstring2);
                return this;
            }
            if (str.charAt(0) != ':') {
                addLenient$okhttp("", str);
                return this;
            }
            String strSubstring3 = str.substring(1);
            throwIfVar1IsNull(strSubstring3, "this as java.lang.String).substring(startIndex)");
            addLenient$okhttp("", strSubstring3);
            return this;
        }

        public final Builder addUnsafeNonAscii(String str, String str2) {
            throwIfVar1IsNull(str, "name");
            throwIfVar1IsNull(str2, "value");
            Headers.Companion.checkName(str);
            addLenient$okhttp(str, str2);
            return this;
        }

        public final Headers build() {
            return new Headers((String[]) this.namesAndValues.toArray(new String[0]), null);
        }

        public final String get(String str) {
            throwIfVar1IsNull(str, "name");
            int size = this.namesAndValues.size() - 2;
            int iAv = KotlinHelpers2.getProgressionLastElement(size, 0, -2);
            if (iAv > size) {
                return null;
            }
            while (!str.equalsIgnoreCase(this.namesAndValues.get(size))) {
                if (size == iAv) {
                    return null;
                }
                size -= 2;
            }
            return this.namesAndValues.get(size + 1);
        }

        public final List<String> getNamesAndValues$okhttp() {
            return this.namesAndValues;
        }

        public final Builder removeAll(String str) {
            throwIfVar1IsNull(str, "name");
            int i = 0;
            while (i < this.namesAndValues.size()) {
                if (str.equalsIgnoreCase(this.namesAndValues.get(i))) {
                    this.namesAndValues.remove(i);
                    this.namesAndValues.remove(i);
                    i -= 2;
                }
                i += 2;
            }
            return this;
        }

        public final Builder set(String str, Date date) {
            throwIfVar1IsNull(str, "name");
            throwIfVar1IsNull(date, "value");
            set(str, DatesKt.toHttpDateString(date));
            return this;
        }

        public final Builder set(String str, Instant instant) {
            throwIfVar1IsNull(str, "name");
            throwIfVar1IsNull(instant, "value");
            return set(str, new Date(instant.toEpochMilli()));
        }

        public final Builder set(String str, String str2) {
            throwIfVar1IsNull(str, "name");
            throwIfVar1IsNull(str2, "value");
            Companion companion = Headers.Companion;
            companion.checkName(str);
            companion.checkValue(str2, str);
            removeAll(str);
            addLenient$okhttp(str, str2);
            return this;
        }

        public final Builder add(String str, String str2) {
            throwIfVar1IsNull(str, "name");
            throwIfVar1IsNull(str2, "value");
            Companion companion = Headers.Companion;
            companion.checkName(str);
            companion.checkValue(str2, str);
            addLenient$okhttp(str, str2);
            return this;
        }

        public final Builder add(String str, Date date) {
            throwIfVar1IsNull(str, "name");
            throwIfVar1IsNull(date, "value");
            add(str, DatesKt.toHttpDateString(date));
            return this;
        }

        public final Builder addLenient$okhttp(String str, String str2) {
            throwIfVar1IsNull(str, "name");
            throwIfVar1IsNull(str2, "value");
            this.namesAndValues.add(str);
            this.namesAndValues.add(StringsKt.ba(str2).toString());
            return this;
        }

        public final Builder add(String str, Instant instant) {
            throwIfVar1IsNull(str, "name");
            throwIfVar1IsNull(instant, "value");
            add(str, new Date(instant.toEpochMilli()));
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

        /* JADX INFO: Access modifiers changed from: private */
        public final void checkName(String str) {
            if (str.length() <= 0) {
                throw new IllegalArgumentException("name is empty");
            }
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = str.charAt(i);
                if ('!' > cCharAt || cCharAt >= 127) {
                    throw new IllegalArgumentException(Util.format("Unexpected char %#04x at %d in header name: %s",
                            Integer.valueOf(cCharAt), Integer.valueOf(i), str).toString());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void checkValue(String str, String str2) {
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = str.charAt(i);
                if (cCharAt != '\t' && (' ' > cCharAt || cCharAt >= 127)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(Util.format("Unexpected char %#04x at %d in %s value", Integer.valueOf(cCharAt),
                            Integer.valueOf(i), str2));
                    sb.append(Util.isSensitiveHeader(str2) ? "" : ": ".concat(str));
                    throw new IllegalArgumentException(sb.toString().toString());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String get(String[] strArr, String str) {
            int length = strArr.length - 2;
            int iAv = KotlinHelpers2.getProgressionLastElement(length, 0, -2);
            if (iAv > length) {
                return null;
            }
            while (!dnr.bj(str, strArr[length], true)) {
                if (length == iAv) {
                    return null;
                }
                length -= 2;
            }
            return strArr[length + 1];
        }

        public final Headers b(String... strArr) {
            throwIfVar1IsNull(strArr, "namesAndValues");
            return of((String[]) Arrays.copyOf(strArr, strArr.length));
        }

        public final Headers of(String... strArr) {
            throwIfVar1IsNull(strArr, "namesAndValues");
            if (strArr.length % 2 != 0) {
                throw new IllegalArgumentException("Expected alternating header names and values");
            }
            String[] strArr2 = (String[]) strArr.clone();
            int length = strArr2.length;
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                String str = strArr2[i2];
                if (str == null) {
                    throw new IllegalArgumentException("Headers cannot be null");
                }
                strArr2[i2] = StringsKt.ba(str).toString();
            }
            int iAv = KotlinHelpers2.getProgressionLastElement(0, strArr2.length - 1, 2);
            if (iAv >= 0) {
                while (true) {
                    String str2 = strArr2[i];
                    String str3 = strArr2[i + 1];
                    checkName(str2);
                    checkValue(str3, str2);
                    if (i == iAv) {
                        break;
                    }
                    i += 2;
                }
            }
            return new Headers(strArr2, null);
        }

        private Companion() {
        }

        public final Headers a(Map<String, String> map) {
            throwIfVar1IsNull(map, "headers");
            return of(map);
        }

        public final Headers of(Map<String, String> map) {
            throwIfVar1IsNull(map, "<this>");
            String[] strArr = new String[map.size() * 2];
            int i = 0;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                String string = StringsKt.ba(key).toString();
                String string2 = StringsKt.ba(value).toString();
                checkName(string);
                checkValue(string2, string);
                strArr[i] = string;
                strArr[i + 1] = string2;
                i += 2;
            }
            return new Headers(strArr, null);
        }
    }

    public /* synthetic */ Headers(String[] strArr, akd akdVar) {
        this(strArr);
    }

    public static final Headers of(Map<String, String> map) {
        return Companion.of(map);
    }

    public final int a() {
        return size();
    }

    public final long byteCount() {
        String[] strArr = this.namesAndValues;
        long length = strArr.length * 2;
        int length2 = strArr.length;
        for (int i = 0; i < length2; i++) {
            length += (long) this.namesAndValues[i].length();
        }
        return length;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Headers) && Arrays.equals(this.namesAndValues, ((Headers) obj).namesAndValues);
    }

    public final String get(String str) {
        throwIfVar1IsNull(str, "name");
        return Companion.get(this.namesAndValues, str);
    }

    public final Date getDate(String str) {
        throwIfVar1IsNull(str, "name");
        String str2 = get(str);
        if (str2 != null) {
            return DatesKt.toHttpDateOrNull(str2);
        }
        return null;
    }

    public final Instant getInstant(String str) {
        throwIfVar1IsNull(str, "name");
        Date date = getDate(str);
        if (date != null) {
            return date.toInstant();
        }
        return null;
    }

    public int hashCode() {
        return Arrays.hashCode(this.namesAndValues);
    }

    @Override // java.lang.Iterable
    public Iterator<Pair> iterator() {
        int size = size();
        Pair[] pairVarArr = new Pair[size];
        for (int i = 0; i < size; i++) {
            pairVarArr[i] = new Pair(name(i), value(i));
        }
        return cnb.ae(pairVarArr);
    }

    public final String name(int i) {
        return this.namesAndValues[i * 2];
    }

    public final Set<String> names() {
        dnr.bk();
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        int size = size();
        for (int i = 0; i < size; i++) {
            treeSet.add(name(i));
        }
        Set<String> setUnmodifiableSet = Collections.unmodifiableSet(treeSet);
        throwIfVar1IsNull(setUnmodifiableSet, "unmodifiableSet(result)");
        return setUnmodifiableSet;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        StaticHelpers2.addAllFromVar2ToVar1(builder.getNamesAndValues$okhttp(), this.namesAndValues);
        return builder;
    }

    public final int size() {
        return this.namesAndValues.length / 2;
    }

    public final Map<String, List<String>> toMultimap() {
        dnr.bk();
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        int size = size();
        for (int i = 0; i < size; i++) {
            String strName = name(i);
            Locale locale = Locale.US;
            throwIfVar1IsNull(locale, "US");
            String lowerCase = strName.toLowerCase(locale);
            throwIfVar1IsNull(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            List arrayList = (List) treeMap.get(lowerCase);
            if (arrayList == null) {
                arrayList = new ArrayList(2);
                treeMap.put(lowerCase, arrayList);
            }
            arrayList.add(value(i));
        }
        return treeMap;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int size = size();
        for (int i = 0; i < size; i++) {
            String strName = name(i);
            String strValue = value(i);
            sb.append(strName);
            sb.append(": ");
            if (Util.isSensitiveHeader(strName)) {
                strValue = "██";
            }
            sb.append(strValue);
            sb.append("\n");
        }
        String string = sb.toString();
        throwIfVar1IsNull(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String value(int i) {
        return this.namesAndValues[(i * 2) + 1];
    }

    public final List<String> values(String str) {
        throwIfVar1IsNull(str, "name");
        int size = size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            if (str.equalsIgnoreCase(name(i))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(value(i));
            }
        }
        if (arrayList == null) {
            return EmptyReadonlyList.INSTANCE;
        }
        List<String> listUnmodifiableList = Collections.unmodifiableList(arrayList);
        throwIfVar1IsNull(listUnmodifiableList, "{\n      Collections.unmodifiableList(result)\n    }");
        return listUnmodifiableList;
    }

    private Headers(String[] strArr) {
        this.namesAndValues = strArr;
    }

    public static final Headers of(String... strArr) {
        return Companion.of(strArr);
    }
}
