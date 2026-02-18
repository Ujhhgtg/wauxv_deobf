package me.hd.wauxv.obf;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ayc {
    public static final ConcurrentHashMap a = new ConcurrentHashMap();
    public final String b;
    public final String c;
    public ewo d;

    public ayc(String str, String str2) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("path is empty");
        }
        if (str2.isEmpty()) {
            throw new IllegalArgumentException("name is empty");
        }
        this.b = str.endsWith("/") ? str : str.concat("/");
        this.c = str2;
    }
}
