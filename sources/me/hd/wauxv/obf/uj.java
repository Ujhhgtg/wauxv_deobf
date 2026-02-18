package me.hd.wauxv.obf;

import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class uj {
    public static final Charset a;
    public static volatile Charset b;
    public static volatile Charset c;

    static {
        Charset charsetForName = Charset.forName("UTF-8");
        bzo.p(charsetForName, "forName(...)");
        a = charsetForName;
        bzo.p(Charset.forName("UTF-16"), "forName(...)");
        bzo.p(Charset.forName("UTF-16BE"), "forName(...)");
        bzo.p(Charset.forName("UTF-16LE"), "forName(...)");
        bzo.p(Charset.forName("US-ASCII"), "forName(...)");
        bzo.p(Charset.forName("ISO-8859-1"), "forName(...)");
    }
}
