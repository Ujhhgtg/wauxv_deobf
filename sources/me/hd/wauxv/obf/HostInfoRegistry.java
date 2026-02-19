package me.hd.wauxv.obf;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class HostInfoRegistry {
    public static final HostInfoRegistry INSTANCE;
    public static final /* synthetic */ IEmpty7[] b;
    public static final LateinitProperty modulePath;
    public static final LateinitProperty appContext;
    public static final LateinitProperty appPackageName;
    public static final LateinitProperty appClassLoader;
    public static final LateinitProperty appFilePath;
    public static final LateinitProperty appName;
    public static final LateinitProperty verName;
    public static final LateinitProperty verCode;
    public static final LateinitProperty verClient;
    public static final LateinitProperty isPlay;

    static {
        chx chxVar = new chx("modulePath" /* "modulePath" /* "modulePath" /* cnb.z(-30661771524906L)  */, "getModulePath()Ljava/lang/String;" /* "getModulePath()Ljava/lang/String;" /* "getModulePath()Ljava/lang/String;" /* cnb.z(-30648886623018L)  */);
        b = new IEmpty7[]{chxVar, new chx("appContext" /* "appContext" /* "appContext" /* cnb.z(-29901562313514L)  */, "getAppContext()Landroid/content/Context;" /* "getAppContext()Landroid/content/Context;" /* "getAppContext()Landroid/content/Context;" /* cnb.z(-29871497542442L)  */), new chx("appPackageName" /* "appPackageName" /* "appPackageName" /* cnb.z(-29712583752490L)  */, "getAppPackageName()Ljava/lang/String;" /* "getAppPackageName()Ljava/lang/String;" /* "getAppPackageName()Ljava/lang/String;" /* cnb.z(-30180735187754L)  */), new chx("appClassLoader" /* "appClassLoader" /* "appClassLoader" /* cnb.z(-30000346561322L)  */, "getAppClassLoader()Ljava/lang/ClassLoader;" /* "getAppClassLoader()Ljava/lang/ClassLoader;" /* "getAppClassLoader()Ljava/lang/ClassLoader;" /* cnb.z(-27187142982442L)  */), new chx("appFilePath" /* "appFilePath" /* "appFilePath" /* cnb.z(-27019639257898L)  */, "getAppFilePath()Ljava/lang/String;" /* "getAppFilePath()Ljava/lang/String;" /* "getAppFilePath()Ljava/lang/String;" /* cnb.z(-27002459388714L)  */), new chx("appName" /* "appName" /* "appName" /* cnb.z(-27367531608874L)  */, "getAppName()Ljava/lang/String;" /* "getAppName()Ljava/lang/String;" /* "getAppName()Ljava/lang/String;" /* cnb.z(-27333171870506L)  */), new chx("verName" /* "verName" /* "verName" /* cnb.z(-26633092201258L)  */, "getVerName()Ljava/lang/String;" /* "getVerName()Ljava/lang/String;" /* "getVerName()Ljava/lang/String;" /* cnb.z(-26598732462890L)  */), new chx("verCode" /* "verCode" /* "verCode" /* cnb.z(-26465588476714L)  */, "getVerCode()I" /* "getVerCode()I" /* "getVerCode()I" /* cnb.z(-26431228738346L)  */), new chx("verClient" /* "verClient" /* "verClient" /* cnb.z(-26422638803754L)  */, "getVerClient()Ljava/lang/String;" /* "getVerClient()Ljava/lang/String;" /* "getVerClient()Ljava/lang/String;" /* cnb.z(-26877905337130L)  */), new chx("isPlay" /* "isPlay" /* "isPlay" /* cnb.z(-26736171416362L)  */, "isPlay()Z" /* "isPlay()Z" /* "isPlay()Z" /* cnb.z(-26706106645290L)  */)};
        INSTANCE = new HostInfoRegistry();
        modulePath = new LateinitProperty(4);
        appContext = new LateinitProperty(4);
        appPackageName = new LateinitProperty(4);
        appClassLoader = new LateinitProperty(4);
        appFilePath = new LateinitProperty(4);
        appName = new LateinitProperty(4);
        verName = new LateinitProperty(4);
        verCode = new LateinitProperty(4);
        verClient = new LateinitProperty(4);
        isPlay = new LateinitProperty(4);
    }

    public static ClassLoader getClassLoader() {
        return (ClassLoader) appClassLoader.h(b[3]);
    }

    public static Context getContext() {
        return (Context) appContext.h(b[1]);
    }

    public static String getAppName() {
        return (String) appName.h(b[5]);
    }

    public static String getPackageName() {
        return (String) appPackageName.h(b[2]);
    }

    public static int getVerCode() {
        return ((Number) verCode.h(b[7])).intValue();
    }

    public static boolean getIsPlay() {
        return ((Boolean) isPlay.h(b[9])).booleanValue();
    }

    public static String getVersionString() {
        StringBuilder sb = new StringBuilder();
        INSTANCE.getClass();
        if (getIsPlay()) {
            sb.append("Play" /* "Play" /* "Play" /* cnb.z(-30709016165162L)  */);
        }
        IEmpty7[] btcVarArr = b;
        sb.append((String) verName.h(btcVarArr[6]));
        sb.append("(" + getVerCode() + ')');
        sb.append("_" /* "_" /* "_" /* cnb.z(-30653181590314L)  */);
        sb.append((String) verClient.h(btcVarArr[8]));
        return sb.toString();
    }
}
