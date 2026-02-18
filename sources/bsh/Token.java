package bsh;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class Token implements Serializable {
    private static final long serialVersionUID = 1;
    public int beginColumn;
    public int beginLine;
    public int endColumn;
    public int endLine;
    public String image;
    public int kind;
    public Token next;
    public Token specialToken;

    public Token() {
    }

    public static Token newToken(int i, String str) {
        return new Token(i, str);
    }

    public Object getValue() {
        return null;
    }

    public String toString() {
        return this.image;
    }

    public Token(int i) {
        this(i, null);
    }

    public static Token newToken(int i) {
        return newToken(i, null);
    }

    public Token(int i, String str) {
        this.kind = i;
        this.image = str;
    }
}
