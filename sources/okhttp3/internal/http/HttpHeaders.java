package okhttp3.internal.http;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import me.hd.wauxv.obf.ave;
import me.hd.wauxv.obf.bzo;
import me.hd.wauxv.obf.dkz;
import me.hd.wauxv.obf.dnr;
import me.hd.wauxv.obf.nu;
import me.hd.wauxv.obf.rh;
import me.hd.wauxv.obf.sj;
import me.hd.wauxv.obf.uj;
import okhttp3.Challenge;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class HttpHeaders {
    private static final sj QUOTED_STRING_DELIMITERS;
    private static final sj TOKEN_DELIMITERS;

    static {
        sj sjVar = sj.a;
        QUOTED_STRING_DELIMITERS = nu.g("\"\\");
        TOKEN_DELIMITERS = nu.g("\t ,=");
    }

    public static final boolean hasBody(Response response) {
        bzo.q(response, "response");
        return promisesBody(response);
    }

    public static final List<Challenge> parseChallenges(Headers headers, String str) {
        bzo.q(headers, "<this>");
        bzo.q(str, "headerName");
        ArrayList arrayList = new ArrayList();
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            if (str.equalsIgnoreCase(headers.name(i))) {
                rh rhVar = new rh();
                rhVar.at(headers.value(i));
                try {
                    readChallengeHeader(rhVar, arrayList);
                } catch (EOFException e) {
                    Platform.Companion.get().log("Unable to parse challenge", 5, e);
                }
            }
        }
        return arrayList;
    }

    public static final boolean promisesBody(Response response) {
        bzo.q(response, "<this>");
        if (bzo.f(response.request().method(), "HEAD")) {
            return false;
        }
        int iCode = response.code();
        return (((iCode >= 100 && iCode < 200) || iCode == 204 || iCode == 304) && Util.headersContentLength(response) == -1 && !"chunked".equalsIgnoreCase(Response.header$default(response, "Transfer-Encoding", null, 2, null))) ? false : true;
    }

    /* JADX WARN: Found duplicated region for block: B:27:0x0080  */
    /* JADX WARN: Found duplicated region for block: B:35:0x0093  */
    /* JADX WARN: Found duplicated region for block: B:36:0x0098  */
    /* JADX WARN: Found duplicated region for block: B:59:0x00b7 A[EDGE_INSN: B:59:0x00b7->B:48:0x00b7 BREAK  A[LOOP:2: B:22:0x006d->B:47:0x00b5], SYNTHETIC] */
    private static final void readChallengeHeader(rh rhVar, List<Challenge> list) throws EOFException {
        String quotedString;
        while (true) {
            String token = null;
            while (true) {
                if (token == null) {
                    skipCommasAndWhitespace(rhVar);
                    token = readToken(rhVar);
                    if (token == null) {
                        return;
                    }
                }
                boolean zSkipCommasAndWhitespace = skipCommasAndWhitespace(rhVar);
                String token2 = readToken(rhVar);
                if (token2 == null) {
                    if (rhVar.i()) {
                        list.add(new Challenge(token, ave.a));
                        return;
                    }
                    return;
                }
                int iSkipAll = Util.skipAll(rhVar, (byte) 61);
                boolean zSkipCommasAndWhitespace2 = skipCommasAndWhitespace(rhVar);
                if (zSkipCommasAndWhitespace || !(zSkipCommasAndWhitespace2 || rhVar.i())) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    int iSkipAll2 = Util.skipAll(rhVar, (byte) 61) + iSkipAll;
                    while (true) {
                        if (token2 != null) {
                            if (iSkipAll2 != 0) {
                                break;
                                break;
                            } else {
                                if (iSkipAll2 <= 1) {
                                    return;
                                }
                                if (startsWith(rhVar, (byte) 34)) {
                                }
                                if (quotedString != null) {
                                    return;
                                }
                                if (skipCommasAndWhitespace(rhVar)) {
                                }
                                token2 = null;
                            }
                        } else {
                            token2 = readToken(rhVar);
                            if (!skipCommasAndWhitespace(rhVar)) {
                                iSkipAll2 = Util.skipAll(rhVar, (byte) 61);
                                if (iSkipAll2 != 0) {
                                    break;
                                }
                                if (iSkipAll2 <= 1 || skipCommasAndWhitespace(rhVar)) {
                                    return;
                                }
                                quotedString = startsWith(rhVar, (byte) 34) ? readQuotedString(rhVar) : readToken(rhVar);
                                if (quotedString != null || ((String) linkedHashMap.put(token2, quotedString)) != null) {
                                    return;
                                }
                                if (skipCommasAndWhitespace(rhVar) && !rhVar.i()) {
                                    return;
                                } else {
                                    token2 = null;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                    list.add(new Challenge(token, linkedHashMap));
                    token = token2;
                } else {
                    StringBuilder sbY = dkz.y(token2);
                    sbY.append(dnr.bm(iSkipAll, "="));
                    Map mapSingletonMap = Collections.singletonMap(null, sbY.toString());
                    bzo.p(mapSingletonMap, "singletonMap<String, Str…ek + \"=\".repeat(eqCount))");
                    list.add(new Challenge(token, (Map<String, String>) mapSingletonMap));
                }
            }
        }
    }

    private static final String readQuotedString(rh rhVar) throws EOFException {
        if (rhVar.readByte() != 34) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        rh rhVar2 = new rh();
        while (true) {
            long jT = rhVar.t(QUOTED_STRING_DELIMITERS);
            if (jT == -1) {
                return null;
            }
            if (rhVar.n(jT) == 34) {
                rhVar2.write(rhVar, jT);
                rhVar.readByte();
                return rhVar2.ac();
            }
            if (rhVar.b == jT + 1) {
                return null;
            }
            rhVar2.write(rhVar, jT);
            rhVar.readByte();
            rhVar2.write(rhVar, 1L);
        }
    }

    private static final String readToken(rh rhVar) {
        long jT = rhVar.t(TOKEN_DELIMITERS);
        if (jT == -1) {
            jT = rhVar.b;
        }
        if (jT != 0) {
            return rhVar.z(jT, uj.a);
        }
        return null;
    }

    public static final void receiveHeaders(CookieJar cookieJar, HttpUrl httpUrl, Headers headers) {
        bzo.q(cookieJar, "<this>");
        bzo.q(httpUrl, "url");
        bzo.q(headers, "headers");
        if (cookieJar == CookieJar.NO_COOKIES) {
            return;
        }
        List<Cookie> all = Cookie.Companion.parseAll(httpUrl, headers);
        if (all.isEmpty()) {
            return;
        }
        cookieJar.saveFromResponse(httpUrl, all);
    }

    private static final boolean skipCommasAndWhitespace(rh rhVar) throws EOFException {
        boolean z = false;
        while (!rhVar.i()) {
            byte bN = rhVar.n(0L);
            if (bN == 44) {
                rhVar.readByte();
                z = true;
            } else {
                if (bN != 32 && bN != 9) {
                    break;
                }
                rhVar.readByte();
            }
        }
        return z;
    }

    private static final boolean startsWith(rh rhVar, byte b) {
        return !rhVar.i() && rhVar.n(0L) == b;
    }
}
