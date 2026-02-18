package me.hd.wauxv.obf;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bmo {
    public static final bmo a;
    public static final /* synthetic */ btc[] b;
    public static final bc c;
    public static final bc d;
    public static final bc e;
    public static final bc f;
    public static final bc g;
    public static final bc h;
    public static final bc i;
    public static final bc j;
    public static final bc k;
    public static final bc l;

    static {
        chx chxVar = new chx("modulePath" /* cnb.z(-30661771524906L) */, "getModulePath()Ljava/lang/String;" /* cnb.z(-30648886623018L) */);
        dal.a.getClass();
        b = new btc[]{chxVar, new chx("appContext" /* cnb.z(-29901562313514L) */, "getAppContext()Landroid/content/Context;" /* cnb.z(-29871497542442L) */), new chx("appPackageName" /* cnb.z(-29712583752490L) */, "getAppPackageName()Ljava/lang/String;" /* cnb.z(-30180735187754L) */), new chx("appClassLoader" /* cnb.z(-30000346561322L) */, "getAppClassLoader()Ljava/lang/ClassLoader;" /* cnb.z(-27187142982442L) */), new chx("appFilePath" /* cnb.z(-27019639257898L) */, "getAppFilePath()Ljava/lang/String;" /* cnb.z(-27002459388714L) */), new chx("appName" /* cnb.z(-27367531608874L) */, "getAppName()Ljava/lang/String;" /* cnb.z(-27333171870506L) */), new chx("verName" /* cnb.z(-26633092201258L) */, "getVerName()Ljava/lang/String;" /* cnb.z(-26598732462890L) */), new chx("verCode" /* cnb.z(-26465588476714L) */, "getVerCode()I" /* cnb.z(-26431228738346L) */), new chx("verClient" /* cnb.z(-26422638803754L) */, "getVerClient()Ljava/lang/String;" /* cnb.z(-26877905337130L) */), new chx("isPlay" /* cnb.z(-26736171416362L) */, "isPlay()Z" /* cnb.z(-26706106645290L) */)};
        a = new bmo();
        c = new bc(4);
        d = new bc(4);
        e = new bc(4);
        f = new bc(4);
        g = new bc(4);
        h = new bc(4);
        i = new bc(4);
        j = new bc(4);
        k = new bc(4);
        l = new bc(4);
    }

    public static ClassLoader m() {
        return (ClassLoader) f.h(b[3]);
    }

    public static Context n() {
        return (Context) d.h(b[1]);
    }

    public static String o() {
        return (String) h.h(b[5]);
    }

    public static String p() {
        return (String) e.h(b[2]);
    }

    public static int q() {
        return ((Number) j.h(b[7])).intValue();
    }

    public static boolean r() {
        return ((Boolean) l.h(b[9])).booleanValue();
    }

    public static String s() {
        StringBuilder sb = new StringBuilder();
        a.getClass();
        if (r()) {
            sb.append("Play" /* cnb.z(-30709016165162L) */);
        }
        btc[] btcVarArr = b;
        sb.append((String) i.h(btcVarArr[6]));
        sb.append("(" + q() + ')');
        sb.append("_" /* cnb.z(-30653181590314L) */);
        sb.append((String) k.h(btcVarArr[8]));
        return sb.toString();
    }
}
