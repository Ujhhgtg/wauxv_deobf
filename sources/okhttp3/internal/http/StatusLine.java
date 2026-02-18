package okhttp3.internal.http;

import java.net.ProtocolException;
import me.hd.wauxv.obf.akd;
import me.hd.wauxv.obf.bzo;
import me.hd.wauxv.obf.dnr;
import okhttp3.Protocol;
import okhttp3.Response;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class StatusLine {
    public static final Companion Companion = new Companion(null);
    public static final int HTTP_CONTINUE = 100;
    public static final int HTTP_MISDIRECTED_REQUEST = 421;
    public static final int HTTP_PERM_REDIRECT = 308;
    public static final int HTTP_TEMP_REDIRECT = 307;
    public final int code;
    public final String message;
    public final Protocol protocol;

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static final class Companion {
        public /* synthetic */ Companion(akd akdVar) {
            this();
        }

        public final StatusLine get(Response response) {
            bzo.q(response, "response");
            return new StatusLine(response.protocol(), response.code(), response.message());
        }

        public final StatusLine parse(String str) throws ProtocolException {
            Protocol protocol;
            int i;
            String strSubstring;
            bzo.q(str, "statusLine");
            if (dnr.bp(str, "HTTP/1.", false)) {
                i = 9;
                if (str.length() < 9 || str.charAt(8) != ' ') {
                    throw new ProtocolException("Unexpected status line: ".concat(str));
                }
                int iCharAt = str.charAt(7) - '0';
                if (iCharAt == 0) {
                    protocol = Protocol.HTTP_1_0;
                } else {
                    if (iCharAt != 1) {
                        throw new ProtocolException("Unexpected status line: ".concat(str));
                    }
                    protocol = Protocol.HTTP_1_1;
                }
            } else {
                if (!dnr.bp(str, "ICY ", false)) {
                    throw new ProtocolException("Unexpected status line: ".concat(str));
                }
                protocol = Protocol.HTTP_1_0;
                i = 4;
            }
            int i2 = i + 3;
            if (str.length() < i2) {
                throw new ProtocolException("Unexpected status line: ".concat(str));
            }
            try {
                String strSubstring2 = str.substring(i, i2);
                bzo.p(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
                int i3 = Integer.parseInt(strSubstring2);
                if (str.length() <= i2) {
                    strSubstring = "";
                } else {
                    if (str.charAt(i2) != ' ') {
                        throw new ProtocolException("Unexpected status line: ".concat(str));
                    }
                    strSubstring = str.substring(i + 4);
                    bzo.p(strSubstring, "this as java.lang.String).substring(startIndex)");
                }
                return new StatusLine(protocol, i3, strSubstring);
            } catch (NumberFormatException unused) {
                throw new ProtocolException("Unexpected status line: ".concat(str));
            }
        }

        private Companion() {
        }
    }

    public StatusLine(Protocol protocol, int i, String str) {
        bzo.q(protocol, "protocol");
        bzo.q(str, "message");
        this.protocol = protocol;
        this.code = i;
        this.message = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.protocol == Protocol.HTTP_1_0) {
            sb.append("HTTP/1.0");
        } else {
            sb.append("HTTP/1.1");
        }
        sb.append(' ');
        sb.append(this.code);
        sb.append(' ');
        sb.append(this.message);
        String string = sb.toString();
        bzo.p(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
