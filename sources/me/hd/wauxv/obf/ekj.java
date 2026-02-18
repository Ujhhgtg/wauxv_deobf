package me.hd.wauxv.obf;

import net.bytebuddy.jar.asm.signature.SignatureVisitor;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public enum ekj {
    Dollar('$'),
    Colon(':'),
    Comma(','),
    CurlyOpen('{'),
    CurlyClose('}'),
    Backslash('\\'),
    Forwardslash('/'),
    Pipe('|'),
    Int(0),
    VariableName(0),
    Format(0),
    Plus(SignatureVisitor.EXTENDS),
    Dash(SignatureVisitor.SUPER),
    QuestionMark('?'),
    Backtick('`'),
    EOF(0);

    public final char r;

    ekj(char c) {
        this.r = c;
    }
}
