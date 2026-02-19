package okhttp3.internal;

import com.android.dx.io.Opcodes;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import me.hd.wauxv.obf.aaz;
import me.hd.wauxv.obf.OtherStaticHelpers;
import me.hd.wauxv.obf.abb;
import me.hd.wauxv.obf.EmptyReadonlyList;
import me.hd.wauxv.obf.ave;
import me.hd.wauxv.obf.aye;
import me.hd.wauxv.obf.bfu;
import me.hd.wauxv.obf.IInvokable;
import me.hd.wauxv.obf.bqe;
import me.hd.wauxv.obf.IntRange;
import me.hd.wauxv.obf.KotlinHelpers;
import me.hd.wauxv.obf.cnb;
import me.hd.wauxv.obf.cnh;
import me.hd.wauxv.obf.crv;
import me.hd.wauxv.obf.dap;
import me.hd.wauxv.obf.dhy;
import me.hd.wauxv.obf.dlc;
import me.hd.wauxv.obf.dnj;
import me.hd.wauxv.obf.dqc;
import me.hd.wauxv.obf.emc;
import me.hd.wauxv.obf.emn;
import me.hd.wauxv.obf.nu;
import me.hd.wauxv.obf.qp;
import me.hd.wauxv.obf.rh;
import me.hd.wauxv.obf.rl;
import me.hd.wauxv.obf.rm;
import me.hd.wauxv.obf.sj;
import me.hd.wauxv.obf.uj;
import me.hd.wauxv.obf.z;
import net.bytebuddy.implementation.MethodDelegation;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http2.Header;
import okhttp3.internal.io.FileSystem;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class Util {
    public static final byte[] EMPTY_BYTE_ARRAY;
    public static final Headers EMPTY_HEADERS = Headers.Companion.of(new String[0]);
    public static final RequestBody EMPTY_REQUEST;
    public static final ResponseBody EMPTY_RESPONSE;
    private static final crv UNICODE_BOMS;
    public static final TimeZone UTC;
    private static final dap VERIFY_AS_IP_ADDRESS;
    public static final boolean assertionsEnabled;
    public static final String okHttpName;
    public static final String userAgent = "okhttp/4.12.0";

    static {
        byte[] bArr = new byte[0];
        EMPTY_BYTE_ARRAY = bArr;
        EMPTY_RESPONSE = ResponseBody.Companion.create$default(ResponseBody.Companion, bArr, (MediaType) null, 1,
                (Object) null);
        EMPTY_REQUEST = RequestBody.Companion.create$default(RequestBody.Companion, bArr, (MediaType) null, 0, 0, 7,
                (Object) null);
        sj sjVar = sj.a;
        UNICODE_BOMS = emn.ao(nu.f("efbbbf"), nu.f("feff"), nu.f("fffe"), nu.f("0000ffff"), nu.f("ffff0000"));
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        throwIfVar1IsNull(timeZone);
        UTC = timeZone;
        VERIFY_AS_IP_ADDRESS = new dap("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
        assertionsEnabled = false;
        okHttpName = dnj.ap(dnj.ao(OkHttpClient.class.getName(), "okhttp3."), "Client");
    }

    public static final <E> void addIfAbsent(List<E> list, E e) {
        throwIfVar1IsNull(list, "<this>");
        if (list.contains(e)) {
            return;
        }
        list.add(e);
    }

    public static final int and(byte b, int i) {
        return b & i;
    }

    public static final EventListener.Factory asFactory(EventListener eventListener) {
        throwIfVar1IsNull(eventListener, "<this>");
        return new qp(eventListener, 11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventListener asFactory$lambda$8(EventListener eventListener, Call call) {
        throwIfVar1IsNull(eventListener, "$this_asFactory");
        throwIfVar1IsNull(call, "it");
        return eventListener;
    }

    public static final void assertThreadDoesntHoldLock(Object obj) {
        throwIfVar1IsNull(obj, "<this>");
        if (assertionsEnabled && Thread.holdsLock(obj)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + obj);
        }
    }

    public static final void assertThreadHoldsLock(Object obj) {
        throwIfVar1IsNull(obj, "<this>");
        if (!assertionsEnabled || Thread.holdsLock(obj)) {
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + obj);
    }

    public static final boolean canParseAsIpAddress(String str) {
        throwIfVar1IsNull(str, "<this>");
        return VERIFY_AS_IP_ADDRESS.f(str);
    }

    public static final boolean canReuseConnectionFor(HttpUrl httpUrl, HttpUrl httpUrl2) {
        throwIfVar1IsNull(httpUrl, "<this>");
        throwIfVar1IsNull(httpUrl2, "other");
        return nullSafeIsEqual(httpUrl.host(), httpUrl2.host()) && httpUrl.port() == httpUrl2.port()
                && nullSafeIsEqual(httpUrl.scheme(), httpUrl2.scheme());
    }

    public static final int checkDuration(String str, long j, TimeUnit timeUnit) {
        throwIfVar1IsNull(str, "name");
        if (j < 0) {
            throw new IllegalStateException(str.concat(" < 0").toString());
        }
        if (timeUnit == null) {
            throw new IllegalStateException("unit == null");
        }
        long millis = timeUnit.toMillis(j);
        if (millis > 2147483647L) {
            throw new IllegalArgumentException(str.concat(" too large.").toString());
        }
        if (millis != 0 || j <= 0) {
            return (int) millis;
        }
        throw new IllegalArgumentException(str.concat(" too small.").toString());
    }

    public static final void checkOffsetAndCount(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static final void closeQuietly(Closeable closeable) {
        throwIfVar1IsNull(closeable, "<this>");
        try {
            closeable.close();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception unused) {
        }
    }

    public static final String[] concat(String[] strArr, String str) {
        throwIfVar1IsNull(strArr, "<this>");
        throwIfVar1IsNull(str, "value");
        Object[] objArrCopyOf = Arrays.copyOf(strArr, strArr.length + 1);
        throwIfVar1IsNull(objArrCopyOf, "copyOf(this, newSize)");
        String[] strArr2 = (String[]) objArrCopyOf;
        strArr2[strArr2.length - 1] = str;
        return strArr2;
    }

    public static final int delimiterOffset(String str, String str2, int i, int i2) {
        throwIfVar1IsNull(str, "<this>");
        throwIfVar1IsNull(str2, "delimiters");
        while (i < i2) {
            if (dnj.ac(str2, str.charAt(i))) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static /* synthetic */ int delimiterOffset$default(String str, String str2, int i, int i2, int i3,
            Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = str.length();
        }
        return delimiterOffset(str, str2, i, i2);
    }

    public static final boolean discard(dlc dlcVar, int i, TimeUnit timeUnit) {
        throwIfVar1IsNull(dlcVar, "<this>");
        throwIfVar1IsNull(timeUnit, "timeUnit");
        try {
            return skipAll(dlcVar, i, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static final <T> List<T> filterList(Iterable<? extends T> iterable, IInvokable bgfVar) {
        throwIfVar1IsNull(iterable, "<this>");
        throwIfVar1IsNull(bgfVar, "predicate");
        ArrayList arrayList = EmptyReadonlyList.a;
        for (T t : iterable) {
            if (((Boolean) bgfVar.invoke(t)).booleanValue()) {
                if (arrayList.isEmpty()) {
                    arrayList = new ArrayList();
                }
                emc.ad(arrayList).add(t);
            }
        }
        return arrayList;
    }

    public static final String format(String str, Object... objArr) {
        throwIfVar1IsNull(str, "format");
        throwIfVar1IsNull(objArr, "args");
        Locale locale = Locale.US;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        return String.format(locale, str, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
    }

    public static final boolean hasIntersection(String[] strArr, String[] strArr2,
            Comparator<? super String> comparator) {
        throwIfVar1IsNull(strArr, "<this>");
        throwIfVar1IsNull(comparator, "comparator");
        if (strArr.length != 0 && strArr2 != null && strArr2.length != 0) {
            for (String str : strArr) {
                z zVarAe = cnb.ae(strArr2);
                while (zVarAe.hasNext()) {
                    if (comparator.compare(str, (String) zVarAe.next()) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static final long headersContentLength(Response response) {
        throwIfVar1IsNull(response, "<this>");
        String str = response.headers().get("Content-Length");
        if (str != null) {
            return toLongOrDefault(str, -1L);
        }
        return -1L;
    }

    public static final void ignoreIoExceptions(bfu bfuVar) {
        throwIfVar1IsNull(bfuVar, "block");
        try {
            bfuVar.invoke();
        } catch (IOException unused) {
        }
    }

    @SafeVarargs
    public static final <T> List<T> immutableListOf(T... tArr) {
        throwIfVar1IsNull(tArr, "elements");
        Object[] objArr = (Object[]) tArr.clone();
        List<T> listUnmodifiableList = Collections.unmodifiableList(OtherStaticHelpers.argsToList(Arrays.copyOf(objArr, objArr.length)));
        throwIfVar1IsNull(listUnmodifiableList, "unmodifiableList(listOf(*elements.clone()))");
        return listUnmodifiableList;
    }

    public static final int indexOf(String[] strArr, String str, Comparator<String> comparator) {
        throwIfVar1IsNull(strArr, "<this>");
        throwIfVar1IsNull(str, "value");
        throwIfVar1IsNull(comparator, "comparator");
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            if (comparator.compare(strArr[i], str) == 0) {
                return i;
            }
        }
        return -1;
    }

    public static final int indexOfControlOrNonAscii(String str) {
        throwIfVar1IsNull(str, "<this>");
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (KotlinHelpers.r(cCharAt, 31) <= 0 || KotlinHelpers.r(cCharAt, 127) >= 0) {
                return i;
            }
        }
        return -1;
    }

    public static final int indexOfFirstNonAsciiWhitespace(String str, int i, int i2) {
        throwIfVar1IsNull(str, "<this>");
        while (i < i2) {
            char cCharAt = str.charAt(i);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static /* synthetic */ int indexOfFirstNonAsciiWhitespace$default(String str, int i, int i2, int i3,
            Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        return indexOfFirstNonAsciiWhitespace(str, i, i2);
    }

    public static final int indexOfLastNonAsciiWhitespace(String str, int i, int i2) {
        throwIfVar1IsNull(str, "<this>");
        int i3 = i2 - 1;
        if (i <= i3) {
            while (true) {
                char cCharAt = str.charAt(i3);
                if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                    return i3 + 1;
                }
                if (i3 != i) {
                    i3--;
                }
            }
        }
        return i;
    }

    public static /* synthetic */ int indexOfLastNonAsciiWhitespace$default(String str, int i, int i2, int i3,
            Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        return indexOfLastNonAsciiWhitespace(str, i, i2);
    }

    public static final int indexOfNonWhitespace(String str, int i) {
        throwIfVar1IsNull(str, "<this>");
        int length = str.length();
        while (i < length) {
            char cCharAt = str.charAt(i);
            if (cCharAt != ' ' && cCharAt != '\t') {
                return i;
            }
            i++;
        }
        return str.length();
    }

    public static /* synthetic */ int indexOfNonWhitespace$default(String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return indexOfNonWhitespace(str, i);
    }

    public static final String[] intersect(String[] strArr, String[] strArr2, Comparator<? super String> comparator) {
        throwIfVar1IsNull(strArr, "<this>");
        throwIfVar1IsNull(strArr2, "other");
        throwIfVar1IsNull(comparator, "comparator");
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            for (String str2 : strArr2) {
                if (comparator.compare(str, str2) == 0) {
                    arrayList.add(str);
                    break;
                }
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public static final boolean isCivilized(FileSystem fileSystem, File file) {
        throwIfVar1IsNull(fileSystem, "<this>");
        throwIfVar1IsNull(file, "file");
        dhy dhyVarSink = fileSystem.sink(file);
        try {
            fileSystem.delete(file);
            cnh.m(dhyVarSink, null);
            return true;
        } catch (IOException unused) {
            cnh.m(dhyVarSink, null);
            fileSystem.delete(file);
            return false;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                cnh.m(dhyVarSink, th);
                throw th2;
            }
        }
    }

    public static final boolean isHealthy(Socket socket, rm rmVar) {
        throwIfVar1IsNull(socket, "<this>");
        throwIfVar1IsNull(rmVar, "source");
        try {
            int soTimeout = socket.getSoTimeout();
            try {
                socket.setSoTimeout(1);
                return !rmVar.i();
            } finally {
                socket.setSoTimeout(soTimeout);
            }
        } catch (SocketTimeoutException unused) {
            return true;
        } catch (IOException unused2) {
            return false;
        }
    }

    public static final boolean isSensitiveHeader(String str) {
        throwIfVar1IsNull(str, "name");
        return str.equalsIgnoreCase("Authorization") || str.equalsIgnoreCase("Cookie")
                || str.equalsIgnoreCase("Proxy-Authorization") || str.equalsIgnoreCase("Set-Cookie");
    }

    public static final void notify(Object obj) {
        throwIfVar1IsNull(obj, "<this>");
        obj.notify();
    }

    public static final void notifyAll(Object obj) {
        throwIfVar1IsNull(obj, "<this>");
        obj.notifyAll();
    }

    public static final int parseHexDigit(char c) {
        if ('0' <= c && c < ':') {
            return c - '0';
        }
        if ('a' <= c && c < 'g') {
            return c - 'W';
        }
        if ('A' > c || c >= 'G') {
            return -1;
        }
        return c - '7';
    }

    public static final String peerName(Socket socket) {
        throwIfVar1IsNull(socket, "<this>");
        SocketAddress remoteSocketAddress = socket.getRemoteSocketAddress();
        if (!(remoteSocketAddress instanceof InetSocketAddress)) {
            return remoteSocketAddress.toString();
        }
        String hostName = ((InetSocketAddress) remoteSocketAddress).getHostName();
        throwIfVar1IsNull(hostName, "address.hostName");
        return hostName;
    }

    public static final Charset readBomAsCharset(rm rmVar, Charset charset) {
        throwIfVar1IsNull(rmVar, "<this>");
        throwIfVar1IsNull(charset, "default");
        int iAb = rmVar.ab(UNICODE_BOMS);
        if (iAb == -1) {
            return charset;
        }
        if (iAb == 0) {
            Charset charset2 = StandardCharsets.UTF_8;
            throwIfVar1IsNull(charset2, "UTF_8");
            return charset2;
        }
        if (iAb == 1) {
            Charset charset3 = StandardCharsets.UTF_16BE;
            throwIfVar1IsNull(charset3, "UTF_16BE");
            return charset3;
        }
        if (iAb == 2) {
            Charset charset4 = StandardCharsets.UTF_16LE;
            throwIfVar1IsNull(charset4, "UTF_16LE");
            return charset4;
        }
        if (iAb == 3) {
            Charset charset5 = uj.a;
            Charset charset6 = uj.c;
            if (charset6 != null) {
                return charset6;
            }
            Charset charsetForName = Charset.forName("UTF-32BE");
            throwIfVar1IsNull(charsetForName, "forName(...)");
            uj.c = charsetForName;
            return charsetForName;
        }
        if (iAb != 4) {
            throw new AssertionError();
        }
        Charset charset7 = uj.a;
        Charset charset8 = uj.b;
        if (charset8 != null) {
            return charset8;
        }
        Charset charsetForName2 = Charset.forName("UTF-32LE");
        throwIfVar1IsNull(charsetForName2, "forName(...)");
        uj.b = charsetForName2;
        return charsetForName2;
    }

    public static final <T> T readFieldOrNull(Object obj, Class<T> cls, String str) throws IllegalAccessException {
        Object fieldOrNull;
        throwIfVar1IsNull(obj, "instance");
        throwIfVar1IsNull(cls, "fieldType");
        throwIfVar1IsNull(str, "fieldName");
        Class<?> superclass = obj.getClass();
        while (true) {
            T tCast = null;
            if (superclass.equals(Object.class)) {
                if (str.equals(MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX)
                        || (fieldOrNull = readFieldOrNull(obj, Object.class,
                                MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX)) == null) {
                    return null;
                }
                return (T) readFieldOrNull(fieldOrNull, cls, str);
            }
            try {
                Field declaredField = superclass.getDeclaredField(str);
                declaredField.setAccessible(true);
                Object obj2 = declaredField.get(obj);
                if (cls.isInstance(obj2)) {
                    tCast = cls.cast(obj2);
                }
                return tCast;
            } catch (NoSuchFieldException unused) {
                superclass = superclass.getSuperclass();
                throwIfVar1IsNull(superclass, "c.superclass");
            }
        }
    }

    public static final int readMedium(rm rmVar) {
        throwIfVar1IsNull(rmVar, "<this>");
        return and(rmVar.readByte(), Opcodes.CONST_METHOD_TYPE)
                | (and(rmVar.readByte(), Opcodes.CONST_METHOD_TYPE) << 16)
                | (and(rmVar.readByte(), Opcodes.CONST_METHOD_TYPE) << 8);
    }

    public static final boolean skipAll(dlc dlcVar, int i, TimeUnit timeUnit) {
        throwIfVar1IsNull(dlcVar, "<this>");
        throwIfVar1IsNull(timeUnit, "timeUnit");
        long jNanoTime = System.nanoTime();
        long jDeadlineNanoTime = dlcVar.timeout().hasDeadline() ? dlcVar.timeout().deadlineNanoTime() - jNanoTime
                : Long.MAX_VALUE;
        dlcVar.timeout().deadlineNanoTime(Math.min(jDeadlineNanoTime, timeUnit.toNanos(i)) + jNanoTime);
        try {
            rh rhVar = new rh();
            while (dlcVar.read(rhVar, 8192L) != -1) {
                rhVar.d();
            }
            if (jDeadlineNanoTime == Long.MAX_VALUE) {
                dlcVar.timeout().clearDeadline();
                return true;
            }
            dlcVar.timeout().deadlineNanoTime(jNanoTime + jDeadlineNanoTime);
            return true;
        } catch (InterruptedIOException unused) {
            if (jDeadlineNanoTime == Long.MAX_VALUE) {
                dlcVar.timeout().clearDeadline();
                return false;
            }
            dlcVar.timeout().deadlineNanoTime(jNanoTime + jDeadlineNanoTime);
            return false;
        } catch (Throwable th) {
            if (jDeadlineNanoTime == Long.MAX_VALUE) {
                dlcVar.timeout().clearDeadline();
            } else {
                dlcVar.timeout().deadlineNanoTime(jNanoTime + jDeadlineNanoTime);
            }
            throw th;
        }
    }

    public static final ThreadFactory threadFactory(final String str, final boolean z) {
        throwIfVar1IsNull(str, "name");
        return new ThreadFactory() { // from class: me.hd.wauxv.obf.eor
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return Util.threadFactory$lambda$1(str, z, runnable);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Thread threadFactory$lambda$1(String str, boolean z, Runnable runnable) {
        throwIfVar1IsNull(str, "$name");
        Thread thread = new Thread(runnable, str);
        thread.setDaemon(z);
        return thread;
    }

    public static final void threadName(String str, bfu bfuVar) {
        throwIfVar1IsNull(str, "name");
        throwIfVar1IsNull(bfuVar, "block");
        Thread threadCurrentThread = Thread.currentThread();
        String name = threadCurrentThread.getName();
        threadCurrentThread.setName(str);
        try {
            bfuVar.invoke();
        } finally {
            threadCurrentThread.setName(name);
        }
    }

    public static final List<Header> toHeaderList(Headers headers) {
        throwIfVar1IsNull(headers, "<this>");
        IntRange intRangeVarBm = dqc.bm(0, headers.size());
        ArrayList arrayList = new ArrayList(abb.ak(intRangeVarBm, 10));
        Iterator it = intRangeVarBm.iterator();
        while (it.hasNext()) {
            int iNextInt = ((bqe) it).nextInt();
            arrayList.add(new Header(headers.name(iNextInt), headers.value(iNextInt)));
        }
        return arrayList;
    }

    public static final Headers toHeaders(List<Header> list) {
        throwIfVar1IsNull(list, "<this>");
        Headers.Builder builder = new Headers.Builder();
        for (Header header : list) {
            builder.addLenient$okhttp(header.component1().n(), header.component2().n());
        }
        return builder.build();
    }

    public static final String toHexString(long j) {
        String hexString = Long.toHexString(j);
        throwIfVar1IsNull(hexString, "toHexString(this)");
        return hexString;
    }

    public static final String toHostHeader(HttpUrl httpUrl, boolean z) {
        String strHost;
        throwIfVar1IsNull(httpUrl, "<this>");
        if (dnj.ab(httpUrl.host(), ":", false)) {
            strHost = "[" + httpUrl.host() + ']';
        } else {
            strHost = httpUrl.host();
        }
        if (!z && httpUrl.port() == HttpUrl.Companion.defaultPort(httpUrl.scheme())) {
            return strHost;
        }
        return strHost + ':' + httpUrl.port();
    }

    public static /* synthetic */ String toHostHeader$default(HttpUrl httpUrl, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return toHostHeader(httpUrl, z);
    }

    public static final <T> List<T> toImmutableList(List<? extends T> list) {
        throwIfVar1IsNull(list, "<this>");
        List<T> listUnmodifiableList = Collections.unmodifiableList(aaz.ab(list));
        throwIfVar1IsNull(listUnmodifiableList, "unmodifiableList(toMutableList())");
        return listUnmodifiableList;
    }

    public static final <K, V> Map<K, V> toImmutableMap(Map<K, ? extends V> map) {
        throwIfVar1IsNull(map, "<this>");
        if (map.isEmpty()) {
            return ave.a;
        }
        Map<K, V> mapUnmodifiableMap = Collections.unmodifiableMap(new LinkedHashMap(map));
        throwIfVar1IsNull(mapUnmodifiableMap, "{\n    Collections.unmodi…(LinkedHashMap(this))\n  }");
        return mapUnmodifiableMap;
    }

    public static final long toLongOrDefault(String str, long j) {
        throwIfVar1IsNull(str, "<this>");
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return j;
        }
    }

    public static final int toNonNegativeInt(String str, int i) {
        if (str != null) {
            try {
                long j = Long.parseLong(str);
                if (j > 2147483647L) {
                    return Integer.MAX_VALUE;
                }
                if (j < 0) {
                    return 0;
                }
                return (int) j;
            } catch (NumberFormatException unused) {
            }
        }
        return i;
    }

    public static final String trimSubstring(String str, int i, int i2) {
        throwIfVar1IsNull(str, "<this>");
        int iIndexOfFirstNonAsciiWhitespace = indexOfFirstNonAsciiWhitespace(str, i, i2);
        String strSubstring = str.substring(iIndexOfFirstNonAsciiWhitespace,
                indexOfLastNonAsciiWhitespace(str, iIndexOfFirstNonAsciiWhitespace, i2));
        throwIfVar1IsNull(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static /* synthetic */ String trimSubstring$default(String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        return trimSubstring(str, i, i2);
    }

    public static final void wait(Object obj) throws InterruptedException {
        throwIfVar1IsNull(obj, "<this>");
        obj.wait();
    }

    public static final Throwable withSuppressed(Exception exc, List<? extends Exception> list) {
        throwIfVar1IsNull(exc, "<this>");
        throwIfVar1IsNull(list, "suppressed");
        Iterator<? extends Exception> it = list.iterator();
        while (it.hasNext()) {
            aye.j(exc, it.next());
        }
        return exc;
    }

    public static final void writeMedium(rl rlVar, int i) {
        throwIfVar1IsNull(rlVar, "<this>");
        rlVar.writeByte((i >>> 16) & Opcodes.CONST_METHOD_TYPE);
        rlVar.writeByte((i >>> 8) & Opcodes.CONST_METHOD_TYPE);
        rlVar.writeByte(i & Opcodes.CONST_METHOD_TYPE);
    }

    public static final int and(short s, int i) {
        return s & i;
    }

    public static final int delimiterOffset(String str, char c, int i, int i2) {
        throwIfVar1IsNull(str, "<this>");
        while (i < i2) {
            if (str.charAt(i) == c) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static /* synthetic */ int delimiterOffset$default(String str, char c, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = str.length();
        }
        return delimiterOffset(str, c, i, i2);
    }

    public static final String toHexString(int i) {
        String hexString = Integer.toHexString(i);
        throwIfVar1IsNull(hexString, "toHexString(this)");
        return hexString;
    }

    public static final long and(int i, long j) {
        return ((long) i) & j;
    }

    public static final void closeQuietly(Socket socket) {
        throwIfVar1IsNull(socket, "<this>");
        try {
            socket.close();
        } catch (AssertionError e) {
            throw e;
        } catch (RuntimeException e2) {
            if (!nullSafeIsEqual(e2.getMessage(), "bio == null")) {
                throw e2;
            }
        } catch (Exception unused) {
        }
    }

    public static final void closeQuietly(ServerSocket serverSocket) {
        throwIfVar1IsNull(serverSocket, "<this>");
        try {
            serverSocket.close();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception unused) {
        }
    }

    public static final int skipAll(rh rhVar, byte b) throws EOFException {
        throwIfVar1IsNull(rhVar, "<this>");
        int i = 0;
        while (!rhVar.i() && rhVar.n(0L) == b) {
            i++;
            rhVar.readByte();
        }
        return i;
    }
}
