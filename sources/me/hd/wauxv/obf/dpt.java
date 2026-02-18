package me.hd.wauxv.obf;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dpt {
    public final String a;
    public final String b;
    public final ArrayList c = new ArrayList();
    public String d;

    public dpt(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public final void e(String str) {
        if (str != null) {
            for (int i = 0; i < str.length(); i++) {
                char cCharAt = str.charAt(i);
                if (cCharAt != ' ' && cCharAt != '\n') {
                    this.d = str;
                    return;
                }
            }
        }
    }

    public final String toString() {
        return "Tag: " + this.b + ", " + this.c.size() + " children, Content: " + this.d;
    }
}
