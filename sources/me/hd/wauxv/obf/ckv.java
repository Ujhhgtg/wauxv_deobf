package me.hd.wauxv.obf;

import android.content.Context;
import java.util.concurrent.ConcurrentLinkedQueue;
import okhttp3.OkHttpClient;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ckv {
    public static Context a = null;
    public static String b = "";
    public static OkHttpClient c;
    public static bcm d;
    public static final boolean e;
    public static final String f;
    public static final ConcurrentLinkedQueue g;
    public static final ckw h;
    public static final arj i;

    static {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        cqi.a(builder);
        c = builder.build();
        e = true;
        f = "NET_LOG";
        g = new ConcurrentLinkedQueue();
        h = ckw.a;
        i = arj.l;
    }

    public static Context j() {
        Context context = a;
        if (context != null) {
            return context;
        }
        throwLateinitPropNotInitYet("app");
        throw null;
    }
}
