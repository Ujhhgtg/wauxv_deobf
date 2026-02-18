package me.hd.wauxv.obf;

import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bxt {
    public static final WeakHashMap a = new WeakHashMap();
    public final String b;

    public bxt(String str) {
        this.b = str;
    }

    public static synchronized bxt c(String str) {
        bxt bxtVar;
        WeakHashMap weakHashMap = a;
        bxtVar = (bxt) weakHashMap.get(str);
        if (bxtVar == null) {
            bxtVar = new bxt(str);
            weakHashMap.put(str, bxtVar);
        }
        return bxtVar;
    }
}
