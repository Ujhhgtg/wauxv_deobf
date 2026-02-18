package com.umeng.commonsdk.vchannel;

import me.hd.wauxv.obf.dkz;
import me.hd.wauxv.obf.dts;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class a {
    public static String a = "https://pslog.umeng.com";
    public static String b = "https://pslog.umeng.com/";
    public static String c = "explog";
    public static final String d = "analytics";
    public static final String e = "ekv";
    public static final String f = "id";
    public static final String g = "ts";
    public static final String h = "ds";
    public static final String i = "pn";
    public static String j = "";

    static {
        String strB = dts.b(System.currentTimeMillis(), "SUB");
        StringBuilder sbY = dkz.y(strB);
        sbY.append(String.format("%0" + (32 - strB.length()) + "d", 0));
        j = sbY.toString();
    }
}
