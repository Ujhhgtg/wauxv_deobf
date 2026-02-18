package com.umeng.commonsdk.debug;

import me.hd.wauxv.obf.bjs;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class UMLogUtils {
    public static String makeUrl(String str) {
        return bjs.o("https://developer.umeng.com/docs/66632/detail/", str, "?um_channel=sdk");
    }
}
