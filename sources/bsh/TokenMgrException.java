package bsh;

import me.hd.wauxv.obf.yg;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class TokenMgrException extends RuntimeException {
    public static final int INVALID_LEXICAL_STATE = 2;
    public static final int LEXICAL_ERROR = 0;
    public static final int LOOP_DETECTED = 3;
    public static final int STATIC_LEXER_ERROR = 1;
    private static final long serialVersionUID = 1;
    int errorCode;

    public TokenMgrException() {
    }

    public static String LexicalErr(boolean z, int i, int i2, int i3, String str, int i4) {
        String str2;
        char c = (char) i4;
        StringBuilder sbQ = yg.concatVar31425(i2, i3, "Lexical error at line ", ", column ", ".  Encountered: ");
        if (z) {
            str2 = "<EOF> ";
        } else {
            str2 = "\"" + addEscapes(String.valueOf(c)) + "\" (" + i4 + "), ";
        }
        sbQ.append(str2);
        sbQ.append("after : \"");
        sbQ.append(addEscapes(str));
        sbQ.append("\"");
        return sbQ.toString();
    }

    public static final String addEscapes(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '\f') {
                sb.append("\\f");
            } else if (cCharAt == '\r') {
                sb.append("\\r");
            } else if (cCharAt == '\"') {
                sb.append("\\\"");
            } else if (cCharAt == '\'') {
                sb.append("\\'");
            } else if (cCharAt != '\\') {
                switch (cCharAt) {
                    case '\b':
                        sb.append("\\b");
                        break;
                    case '\t':
                        sb.append("\\t");
                        break;
                    case '\n':
                        sb.append("\\n");
                        break;
                    default:
                        if (cCharAt < ' ' || cCharAt > '~') {
                            String str2 = "0000" + Integer.toString(cCharAt, 16);
                            sb.append("\\u");
                            sb.append(str2.substring(str2.length() - 4, str2.length()));
                        } else {
                            sb.append(cCharAt);
                        }
                        break;
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return super.getMessage();
    }

    public TokenMgrException(String str, int i) {
        super(str);
        this.errorCode = i;
    }

    public TokenMgrException(boolean z, int i, int i2, int i3, String str, int i4, int i5) {
        this(LexicalErr(z, i, i2, i3, str, i4), i5);
    }
}
