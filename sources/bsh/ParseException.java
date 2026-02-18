package bsh;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class ParseException extends EvalError {
    private static final long serialVersionUID = 1;
    private static String sourceFile;
    public Token currentToken;
    public int[][] expectedTokenSequences;
    public String[] tokenImage;

    public ParseException(Token token, int[][] iArr, String[] strArr) {
        super(initialise(token, iArr, strArr), null, null);
        this.currentToken = token;
        this.expectedTokenSequences = iArr;
        this.tokenImage = strArr;
    }

    public static String add_escapes(String str) {
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
                        char cCharAt2 = str.charAt(i);
                        if (cCharAt2 < ' ' || cCharAt2 > '~') {
                            String str2 = "0000" + Integer.toString(cCharAt2, 16);
                            sb.append("\\u" + str2.substring(str2.length() - 4, str2.length()));
                        } else {
                            sb.append(cCharAt2);
                        }
                        break;
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }

    private static String initialise(Token token, int[][] iArr, String[] strArr) {
        StringBuilder sb = new StringBuilder("Unable to parse code syntax. Encountered:");
        if (token != null) {
            Token token2 = token;
            while (true) {
                token2 = token2.next;
                if (token2 == null) {
                    break;
                }
                sb.append(" ");
                sb.append(add_escapes(token2.image));
            }
            sb.append(" at line ");
            sb.append(token.next.beginLine);
            sb.append(", column ");
            sb.append(token.next.beginColumn);
            if (sourceFile != null) {
                sb.append(" in: ");
                sb.append(sourceFile);
            }
        }
        if (Interpreter.DEBUG.get().booleanValue() && iArr.length != 0) {
            sb.append(System.getProperty("line.separator", "\n"));
            sb.append("Exppected");
            if (iArr.length > 1) {
                sb.append(" one of");
            }
            sb.append(": ");
            for (int[] iArr2 : iArr) {
                int i = 0;
                while (true) {
                    if (i < iArr2.length) {
                        sb.append(strArr[iArr2[i]].replace('\"', ' ').trim());
                        sb.append(' ');
                        i++;
                    }
                }
            }
        }
        return sb.toString();
    }

    @Override // bsh.EvalError
    public int getErrorLineNumber() {
        return this.currentToken.next.beginLine;
    }

    @Override // bsh.EvalError
    public String getErrorSourceFile() {
        return sourceFile;
    }

    @Override // bsh.EvalError
    public String getErrorText() {
        return getMessage();
    }

    @Override // bsh.EvalError, java.lang.Throwable
    public String getMessage() {
        return initialise(this.currentToken, this.expectedTokenSequences, this.tokenImage);
    }

    public void setErrorSourceFile(String str) {
        sourceFile = str;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return getMessage();
    }

    public String getMessage(boolean z) {
        return getMessage();
    }

    public ParseException() {
        this("");
    }

    public ParseException(String str) {
        super(str, null, null);
    }

    public ParseException(String str, Throwable th) {
        super(str, null, null, th);
    }
}
