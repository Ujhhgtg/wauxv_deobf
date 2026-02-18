package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public enum bvd {
    NONE(""),
    LF("\n"),
    CR("\r"),
    CRLF("\r\n");

    public final String f;
    public final int g;

    bvd(String str) {
        this.f = str;
        this.g = str.length();
        str.toCharArray();
    }
}
