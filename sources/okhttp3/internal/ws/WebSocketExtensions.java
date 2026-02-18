package okhttp3.internal.ws;

import me.hd.wauxv.obf.akd;
import me.hd.wauxv.obf.bzo;
import me.hd.wauxv.obf.dnq;
import me.hd.wauxv.obf.dnr;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import net.bytebuddy.pool.TypePool;
import okhttp3.Headers;
import okhttp3.internal.Util;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class WebSocketExtensions {
    public static final Companion Companion = new Companion(null);
    private static final String HEADER_WEB_SOCKET_EXTENSION = "Sec-WebSocket-Extensions";
    public final Integer clientMaxWindowBits;
    public final boolean clientNoContextTakeover;
    public final boolean perMessageDeflate;
    public final Integer serverMaxWindowBits;
    public final boolean serverNoContextTakeover;
    public final boolean unknownValues;

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public static final class Companion {
        public /* synthetic */ Companion(akd akdVar) {
            this();
        }

        /*
         * JADX WARN: Found duplicated region for block: B:36:0x00b8 A[PHI: r7 r9 r11
         * 0x00b8: PHI (r7v4 java.lang.Integer) = (r7v3 java.lang.Integer), (r7v8
         * java.lang.Integer) binds: [B:51:0x00df, B:33:0x00b1] A[DONT_GENERATE,
         * DONT_INLINE]
         * 0x00b8: PHI (r9v7 java.lang.Integer) = (r9v5 java.lang.Integer), (r9v3
         * java.lang.Integer) binds: [B:51:0x00df, B:33:0x00b1] A[DONT_GENERATE,
         * DONT_INLINE]
         * 0x00b8: PHI (r11v15 boolean) = (r11v9 boolean), (r11v18 boolean) binds:
         * [B:51:0x00df, B:33:0x00b1] A[DONT_GENERATE, DONT_INLINE]]
         */
        public final WebSocketExtensions parse(Headers headers) {
            String strTrimSubstring;
            throwIfVar1IsNull(headers, "responseHeaders");
            int size = headers.size();
            boolean z = false;
            Integer numBf = null;
            boolean z2 = false;
            Integer numBf2 = null;
            boolean z3 = false;
            boolean z4 = false;
            for (int i = 0; i < size; i++) {
                if (dnr.bj(headers.name(i), WebSocketExtensions.HEADER_WEB_SOCKET_EXTENSION, true)) {
                    String strValue = headers.value(i);
                    int i2 = 0;
                    while (i2 < strValue.length()) {
                        int i3 = i2;
                        int iDelimiterOffset$default = Util.delimiterOffset$default(strValue, ',', i3, 0, 4,
                                (Object) null);
                        char c = TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER;
                        int iDelimiterOffset = Util.delimiterOffset(strValue,
                                TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER, i3,
                                iDelimiterOffset$default);
                        String strTrimSubstring2 = Util.trimSubstring(strValue, i3, iDelimiterOffset);
                        int i4 = iDelimiterOffset + 1;
                        if (dnr.bj(strTrimSubstring2, "permessage-deflate", true)) {
                            if (z) {
                                z4 = true;
                            }
                            while (i4 < iDelimiterOffset$default) {
                                int iDelimiterOffset2 = Util.delimiterOffset(strValue, c, i4, iDelimiterOffset$default);
                                int iDelimiterOffset3 = Util.delimiterOffset(strValue, SignatureVisitor.INSTANCEOF, i4,
                                        iDelimiterOffset2);
                                String strTrimSubstring3 = Util.trimSubstring(strValue, i4, iDelimiterOffset3);
                                if (iDelimiterOffset3 < iDelimiterOffset2) {
                                    strTrimSubstring = Util.trimSubstring(strValue, iDelimiterOffset3 + 1,
                                            iDelimiterOffset2);
                                    throwIfVar1IsNull(strTrimSubstring, "<this>");
                                    if (strTrimSubstring.length() >= 2 && dnr.bp(strTrimSubstring, "\"", false)
                                            && dnr.bi(strTrimSubstring, "\"")) {
                                        strTrimSubstring = strTrimSubstring.substring(1, strTrimSubstring.length() - 1);
                                        throwIfVar1IsNull(strTrimSubstring, "substring(...)");
                                    }
                                } else {
                                    strTrimSubstring = null;
                                }
                                int i5 = iDelimiterOffset2 + 1;
                                if (dnr.bj(strTrimSubstring3, "client_max_window_bits", true)) {
                                    if (numBf != null) {
                                        z4 = true;
                                    }
                                    numBf = strTrimSubstring != null ? dnq.bf(strTrimSubstring) : null;
                                    if (numBf == null) {
                                        i4 = i5;
                                        z4 = true;
                                    } else {
                                        i4 = i5;
                                    }
                                } else if (dnr.bj(strTrimSubstring3, "client_no_context_takeover", true)) {
                                    if (z2) {
                                        z4 = true;
                                    }
                                    if (strTrimSubstring != null) {
                                        z4 = true;
                                    }
                                    i4 = i5;
                                    z2 = true;
                                } else {
                                    if (dnr.bj(strTrimSubstring3, "server_max_window_bits", true)) {
                                        if (numBf2 != null) {
                                            z4 = true;
                                        }
                                        numBf2 = strTrimSubstring != null ? dnq.bf(strTrimSubstring) : null;
                                        if (numBf2 != null) {
                                            i4 = i5;
                                        }
                                    } else if (dnr.bj(strTrimSubstring3, "server_no_context_takeover", true)) {
                                        if (z3) {
                                            z4 = true;
                                        }
                                        if (strTrimSubstring != null) {
                                            z4 = true;
                                        }
                                        i4 = i5;
                                        z3 = true;
                                    }
                                    i4 = i5;
                                    z4 = true;
                                }
                                c = TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER;
                            }
                            i2 = i4;
                            z = true;
                        } else {
                            i2 = i4;
                            z4 = true;
                        }
                    }
                }
            }
            return new WebSocketExtensions(z, numBf, z2, numBf2, z3, z4);
        }

        private Companion() {
        }
    }

    public WebSocketExtensions() {
        this(false, null, false, null, false, false, 63, null);
    }

    public static /* synthetic */ WebSocketExtensions copy$default(WebSocketExtensions webSocketExtensions, boolean z,
            Integer num, boolean z2, Integer num2, boolean z3, boolean z4, int i, Object obj) {
        if ((i & 1) != 0) {
            z = webSocketExtensions.perMessageDeflate;
        }
        if ((i & 2) != 0) {
            num = webSocketExtensions.clientMaxWindowBits;
        }
        if ((i & 4) != 0) {
            z2 = webSocketExtensions.clientNoContextTakeover;
        }
        if ((i & 8) != 0) {
            num2 = webSocketExtensions.serverMaxWindowBits;
        }
        if ((i & 16) != 0) {
            z3 = webSocketExtensions.serverNoContextTakeover;
        }
        if ((i & 32) != 0) {
            z4 = webSocketExtensions.unknownValues;
        }
        boolean z5 = z3;
        boolean z6 = z4;
        return webSocketExtensions.copy(z, num, z2, num2, z5, z6);
    }

    public final boolean component1() {
        return this.perMessageDeflate;
    }

    public final Integer component2() {
        return this.clientMaxWindowBits;
    }

    public final boolean component3() {
        return this.clientNoContextTakeover;
    }

    public final Integer component4() {
        return this.serverMaxWindowBits;
    }

    public final boolean component5() {
        return this.serverNoContextTakeover;
    }

    public final boolean component6() {
        return this.unknownValues;
    }

    public final WebSocketExtensions copy(boolean z, Integer num, boolean z2, Integer num2, boolean z3, boolean z4) {
        return new WebSocketExtensions(z, num, z2, num2, z3, z4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WebSocketExtensions)) {
            return false;
        }
        WebSocketExtensions webSocketExtensions = (WebSocketExtensions) obj;
        return this.perMessageDeflate == webSocketExtensions.perMessageDeflate
                && nullSafeIsEqual(this.clientMaxWindowBits, webSocketExtensions.clientMaxWindowBits)
                && this.clientNoContextTakeover == webSocketExtensions.clientNoContextTakeover
                && nullSafeIsEqual(this.serverMaxWindowBits, webSocketExtensions.serverMaxWindowBits)
                && this.serverNoContextTakeover == webSocketExtensions.serverNoContextTakeover
                && this.unknownValues == webSocketExtensions.unknownValues;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9 */
    public int hashCode() {
        boolean z = this.perMessageDeflate;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        Integer num = this.clientMaxWindowBits;
        int iHashCode = (i + (num == null ? 0 : num.hashCode())) * 31;
        boolean z2 = this.clientNoContextTakeover;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i2 = (iHashCode + r2) * 31;
        Integer num2 = this.serverMaxWindowBits;
        int iHashCode2 = (i2 + (num2 != null ? num2.hashCode() : 0)) * 31;
        boolean z3 = this.serverNoContextTakeover;
        ?? r22 = z3;
        if (z3) {
            r22 = 1;
        }
        int i3 = (iHashCode2 + r22) * 31;
        boolean z4 = this.unknownValues;
        return i3 + (z4 ? 1 : z4);
    }

    public final boolean noContextTakeover(boolean z) {
        return z ? this.clientNoContextTakeover : this.serverNoContextTakeover;
    }

    public String toString() {
        return "WebSocketExtensions(perMessageDeflate=" + this.perMessageDeflate + ", clientMaxWindowBits="
                + this.clientMaxWindowBits + ", clientNoContextTakeover=" + this.clientNoContextTakeover
                + ", serverMaxWindowBits=" + this.serverMaxWindowBits + ", serverNoContextTakeover="
                + this.serverNoContextTakeover + ", unknownValues=" + this.unknownValues + ')';
    }

    public WebSocketExtensions(boolean z, Integer num, boolean z2, Integer num2, boolean z3, boolean z4) {
        this.perMessageDeflate = z;
        this.clientMaxWindowBits = num;
        this.clientNoContextTakeover = z2;
        this.serverMaxWindowBits = num2;
        this.serverNoContextTakeover = z3;
        this.unknownValues = z4;
    }

    public /* synthetic */ WebSocketExtensions(boolean z, Integer num, boolean z2, Integer num2, boolean z3, boolean z4,
            int i, akd akdVar) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : num, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? null : num2,
                (i & 16) != 0 ? false : z3, (i & 32) != 0 ? false : z4);
    }
}
