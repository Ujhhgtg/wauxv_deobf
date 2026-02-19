package com.umeng.commonsdk.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import com.alibaba.fastjson2.JSONB;
import com.umeng.analytics.pro.bd;
import com.umeng.analytics.pro.bt;
import com.umeng.analytics.pro.dn;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.idtracking.i;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.microedition.khronos.opengles.GL10;
import me.hd.wauxv.obf.StaticHelpers6;
import me.hd.wauxv.obf.dts;
import me.hd.wauxv.obf.yg;
import net.bytebuddy.utility.JavaConstant;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class UMUtils {
    public static final int DEFAULT_TIMEZONE = 8;
    private static final String KEY_APP_KEY = "appkey";
    private static final String KEY_CHANNEL = "channel";
    private static final String KEY_LAST_APP_KEY = "last_appkey";
    private static final String KEY_MIUI_VERSION_NAME = "ro.miui.ui.version.name";
    private static final String KEY_SESSION_ID = "session_id";
    public static final String MOBILE_NETWORK = "2G/3G";
    private static final String TAG = "UMUtils";
    public static final String UNKNOW = "";
    public static final String WIFI = "Wi-Fi";
    private static final String KEY_SHARED_PREFERENCES_NAME = bd.b().b(bd.i);
    private static final Pattern pattern = Pattern.compile("UTDID\">([^<]+)");
    private static final String SP_FILE_NAME = bd.b().b(bd.k);
    private static Object spLock = new Object();
    public static String VALUE_ANALYTICS_VERSION = "";
    public static String VALUE_GAME_VERSION = "";
    public static String VALUE_PUSH_VERSION = "";
    public static String VALUE_SHARE_VERSION = "";
    public static String VALUE_APM_VERSION = "";
    public static String VALUE_VERIFY_VERSION = "";
    public static String VALUE_SMS_VERSION = "";
    public static String VALUE_REC_VERSION_NAME = "";
    public static String VALUE_VISUAL_VERSION = "";
    public static String VALUE_ASMS_VERSION = "";
    public static String VALUE_LINK_VERSION = "";
    public static String VALUE_ABTEST_VERSION = "";
    public static String VALUE_ANTI_VERSION = "";
    private static volatile String sAppVersionName = "";
    private static volatile String sAppVersionCode = "";

    public static String MD5(String str) {
        try {
            if (str == null) {
                return null;
            }
            try {
                try {
                    byte[] bytes = str.getBytes();
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    messageDigest.reset();
                    messageDigest.update(bytes);
                    byte[] bArrDigest = messageDigest.digest();
                    StringBuffer stringBuffer = new StringBuffer();
                    for (byte b : bArrDigest) {
                        stringBuffer.append(String.format("%02X", Byte.valueOf(b)));
                    }
                    return stringBuffer.toString();
                } catch (Exception e) {
                    if (AnalyticsConstants.UM_DEBUG) {
                        dts.e("MD5 e is ", e, TAG);
                    }
                    return null;
                }
            } catch (Exception unused) {
                return str.replaceAll("[^[a-z][A-Z][0-9][.][_]]", "");
            }
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                dts.f("MD5 e is ", TAG, th);
            }
            return null;
        }
    }

    private static String byte2HexFormatted(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            String hexString = Integer.toHexString(bArr[i]);
            int length = hexString.length();
            if (length == 1) {
                hexString = "0".concat(hexString);
            }
            if (length > 2) {
                hexString = hexString.substring(length - 2, length);
            }
            sb.append(hexString.toUpperCase());
            if (i < bArr.length - 1) {
                sb.append(':');
            }
        }
        return sb.toString();
    }

    private static String bytes2Hex(byte[] bArr) {
        String strS = "";
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                strS = StaticHelpers6.concat(strS, "0");
            }
            strS = StaticHelpers6.concat(strS, hexString);
        }
        return strS;
    }

    public static boolean checkAndroidManifest(Context context, String str) {
        try {
            context.getApplicationContext().getPackageManager().getActivityInfo(new ComponentName(context.getApplicationContext().getPackageName(), str), 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static boolean checkIntentFilterData(Context context, String str) {
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.addCategory("android.intent.category.BROWSABLE");
            intent.setData(Uri.parse("tencent" + str + ":"));
            List<ResolveInfo> listQueryIntentActivities = context.getApplicationContext().getPackageManager().queryIntentActivities(intent, 64);
            if (listQueryIntentActivities.size() > 0) {
                Iterator<ResolveInfo> it = listQueryIntentActivities.iterator();
                while (it.hasNext()) {
                    ActivityInfo activityInfo = it.next().activityInfo;
                    if (activityInfo != null && activityInfo.packageName.equals(context.getApplicationContext().getPackageName())) {
                        return true;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean checkMetaData(Context context, String str) {
        ApplicationInfo applicationInfo;
        try {
            applicationInfo = context.getApplicationContext().getPackageManager().getApplicationInfo(context.getApplicationContext().getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return (applicationInfo == null || applicationInfo.metaData.get(str) == null) ? false : true;
    }

    public static boolean checkPath(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static boolean checkPermission(Context context, String str) {
        if (context == null) {
            return false;
        }
        try {
            return ((Integer) Class.forName("android.content.Context").getMethod("checkSelfPermission", String.class).invoke(context, str)).intValue() == 0;
        } catch (Exception e) {
            UMCrashManager.reportCrash(context, e);
            return false;
        }
    }

    public static boolean checkResource(Context context, String str, String str2) {
        try {
            return context.getApplicationContext().getResources().getIdentifier(str, str2, context.getApplicationContext().getPackageName()) > 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String encryptBySHA1(String str) {
        try {
            try {
                byte[] bytes = str.getBytes();
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                    messageDigest.update(bytes);
                    return bytes2Hex(messageDigest.digest());
                } catch (Exception unused) {
                    return null;
                }
            } catch (Exception e) {
                if (AnalyticsConstants.UM_DEBUG) {
                    dts.e("encrypt by SHA1 e is ", e, TAG);
                }
                return null;
            }
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                dts.f("encrypt by SHA1 e is ", TAG, th);
            }
            return null;
        }
    }

    public static String genId() {
        return "1234567890";
    }

    public static byte[] genIv() {
        byte[] miniArray = getMiniArray();
        return new byte[]{10, 1, (byte) (10 + 1), 5, 4, (byte) (10 + 5), 7, 9, 23, 3, miniArray[0], miniArray[1], miniArray[2], miniArray[3], miniArray[4], (byte) (100 - 9)};
    }

    public static byte[] genSin() {
        byte[] miniArray = getMiniArray();
        return new byte[]{55, 69, (byte) (miniArray[4] + 54), 50, (byte) (55 + 57), 97, (byte) (69 + 43), 83, 57, 97, (byte) (97 + 2), 90, JSONB.Constants.BC_STR_ASCII_FIX_MAX, (byte) (97 + miniArray[1]), (byte) (miniArray[0] + JSONB.Constants.BC_INT32), (byte) (90 + miniArray[2])};
    }

    public static byte[] genUmc() {
        return new byte[]{31, -117, 8, 0, 0, 0, 0, 0, 0, 0, 1, -27, 0, 26, -1, 76, 102, 34, 19, JSONB.Constants.BC_STR_ASCII_FIX_5, 70, 23, 58, 85, 26, 6, JSONB.Constants.BC_INT32_BYTE_ZERO, 16, JSONB.Constants.BC_INT32_SHORT_ZERO, 36, 2, 73, 32, 52, 79, 16, 90, 37, 43, 79, 12, 28, 57, 16, 88, JSONB.Constants.BC_STR_UTF16, 95, 100, 70, 91, 51, 51, 33, 34, 39, 104, 59, 61, 20, 57, 25, 2, JSONB.Constants.BC_INT32_BYTE_MAX, 113, 29, 18, 100, 102, JSONB.Constants.BC_STR_ASCII_FIX_MAX, 100, 5, 35, 98, JSONB.Constants.BC_STR_UTF16, 0, 39, 57, 24, 40, 25, 112, 35, 93, 22, 73, 20, 46, 83, 73, JSONB.Constants.BC_INT32_SHORT_MAX, 117, 70, 69, 110, 73, 73, 117, 114, 2, 75, 65, JSONB.Constants.BC_INT32, 112, 18, 22, JSONB.Constants.BC_STR_ASCII_FIX_MAX, 98, JSONB.Constants.BC_INT32_SHORT_MAX, 85, 98, 83, 35, JSONB.Constants.BC_STR_ASCII_FIX_32, JSONB.Constants.BC_INT32_SHORT_MIN, JSONB.Constants.BC_INT32_BYTE_MAX, 117, 99, 115, 70, 115, 36, 43, 73, 54, JSONB.Constants.BC_INT32_BYTE_MIN, 5, 108, 35, 80, 112, 34, 103, JSONB.Constants.BC_STR_UTF16, 115, JSONB.Constants.BC_STR_ASCII_FIX_1, 53, 58, 53, 3, 98, JSONB.Constants.BC_INT32_BYTE_ZERO, dn.k, JSONB.Constants.BC_INT32_BYTE_MAX, -42, JSONB.Constants.BC_TIMESTAMP_WITH_TIMEZONE, JSONB.Constants.BC_OBJECT_END, -61, -101, -115, JSONB.Constants.BC_TYPED_ANY, -6, JSONB.Constants.BC_INT64_BYTE_ZERO, -117, -118, JSONB.Constants.BC_INT64, -127, -124, JSONB.Constants.BC_DOUBLE_NUM_1, -98, -119, -107, JSONB.Constants.BC_DOUBLE_NUM_0, -62, -117, -127, -120, JSONB.Constants.BC_FALSE, -20, -103, -105, -96, -125, -97, JSONB.Constants.BC_OBJECT_END, JSONB.Constants.BC_BIGINT, -30, JSONB.Constants.BC_CHAR, -108, -29, JSONB.Constants.BC_TRUE, -26, -6, -42, -29, -22, -13, -45, JSONB.Constants.BC_DOUBLE_NUM_1, JSONB.Constants.BC_NULL, JSONB.Constants.BC_REFERENCE, -97, -30, -121, -124, -19, JSONB.Constants.BC_FALSE, -10, -22, -58, -5, -6, -29, -61, JSONB.Constants.BC_OBJECT_END, JSONB.Constants.BC_DOUBLE_LONG, JSONB.Constants.BC_REFERENCE, JSONB.Constants.BC_NULL, -104, -19, -27, -33, -43, JSONB.Constants.BC_INT64_SHORT_MAX, -43, -5, -124, -58, -35, -30, -102, -21, -28, -50, -120, -31, -1, -107, -23, -43, JSONB.Constants.BC_INT64_BYTE_MIN, -27, -122, -35, -53, -62, -59, -42, -5, -33, JSONB.Constants.BC_FLOAT_INT, JSONB.Constants.BC_INT64_SHORT_MAX, -54, -13, -23, JSONB.Constants.BC_LOCAL_DATETIME, -43, 111, 53, -27, 0, 0, 0};
    }

    public static String[] getActiveUser(Context context) {
        return com.umeng.analytics.c.a(context);
    }

    public static String getApmFlag() {
        Method declaredMethod;
        try {
            Class<?> cls = getClass("com.umeng.umcrash.UMCrash");
            if (cls == null || (declaredMethod = cls.getDeclaredMethod("getUMAPMFlag", null)) == null) {
                return "";
            }
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(cls, null);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String getAppHashKey(Context context) {
        return DeviceConfig.getAppHashKey(context);
    }

    public static String getAppMD5Signature(Context context) {
        String strReplace = "";
        try {
            String appMD5Signature = DeviceConfig.getAppMD5Signature(context);
            try {
                if (TextUtils.isEmpty(appMD5Signature)) {
                    return appMD5Signature;
                }
                strReplace = appMD5Signature.replace(":", "");
                return strReplace.toLowerCase();
            } catch (Throwable unused) {
                return appMD5Signature;
            }
        } catch (Throwable unused2) {
            return strReplace;
        }
    }

    public static String getAppName(Context context) {
        return DeviceConfig.getAppName(context);
    }

    public static String getAppSHA1Key(Context context) {
        return DeviceConfig.getAppSHA1Key(context);
    }

    public static String getAppVersinoCode(Context context, String str) {
        if (context != null && str != null) {
            try {
                PackageInfo packageInfoA = b.a().a(context, str, 64);
                if (packageInfoA != null) {
                    return String.valueOf(packageInfoA.versionCode);
                }
            } catch (Exception e) {
                if (AnalyticsConstants.UM_DEBUG) {
                    dts.e("get app version code e is ", e, TAG);
                }
            } catch (Throwable th) {
                if (AnalyticsConstants.UM_DEBUG) {
                    dts.f("get app version code e is ", TAG, th);
                }
            }
        }
        return "";
    }

    public static String getAppVersionCode(Context context) {
        if (!TextUtils.isEmpty(sAppVersionCode)) {
            return sAppVersionCode;
        }
        if (context != null) {
            try {
                PackageInfo packageInfoA = b.a().a(context, context.getPackageName(), 64);
                if (packageInfoA != null) {
                    String strValueOf = String.valueOf(packageInfoA.versionCode);
                    sAppVersionCode = strValueOf;
                    return strValueOf;
                }
            } catch (Exception e) {
                if (AnalyticsConstants.UM_DEBUG) {
                    dts.e("get app version code e is ", e, TAG);
                }
                return "";
            } catch (Throwable th) {
                if (AnalyticsConstants.UM_DEBUG) {
                    dts.f("get app version code e is ", TAG, th);
                }
                return "";
            }
        }
        return "";
    }

    public static String getAppVersionName(Context context) {
        if (!TextUtils.isEmpty(sAppVersionName)) {
            return sAppVersionName;
        }
        if (context != null) {
            try {
                PackageInfo packageInfoA = b.a().a(context, context.getPackageName(), 64);
                if (packageInfoA != null) {
                    String str = packageInfoA.versionName;
                    sAppVersionName = str;
                    return str;
                }
            } catch (Throwable th) {
                if (AnalyticsConstants.UM_DEBUG) {
                    dts.f("get app version name e is ", TAG, th);
                }
                return "";
            }
        }
        return "";
    }

    public static String getAppkey(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return !TextUtils.isEmpty(UMConfigure.sAppkey) ? UMConfigure.sAppkey : getMultiProcessSP(context, "appkey");
        } catch (Exception e) {
            if (AnalyticsConstants.UM_DEBUG) {
                dts.e("get app key e is ", e, TAG);
            }
            UMCrashManager.reportCrash(context, e);
            return null;
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                dts.f("get app key e is ", TAG, th);
            }
            UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    public static String getAppkeyByXML(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null) {
                return null;
            }
            String string = applicationInfo.metaData.getString("UMENG_APPKEY");
            if (string != null) {
                return string.trim();
            }
            if (!AnalyticsConstants.UM_DEBUG) {
                return null;
            }
            MLog.i(AnalyticsConstants.LOG_TAG, "Could not read UMENG_APPKEY meta-data from AndroidManifest.xml.");
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Properties getBuildProp() throws Throwable {
        FileInputStream fileInputStream;
        Properties properties = new Properties();
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(new File(Environment.getRootDirectory(), "build.prop"));
            } catch (IOException unused) {
                return properties;
            }
        } catch (IOException unused2) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            properties.load(fileInputStream);
            fileInputStream.close();
            return properties;
        } catch (IOException unused3) {
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            return properties;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException unused4) {
                }
            }
            throw th;
        }
    }

    public static String getCPU() {
        String line = null;
        try {
            try {
                FileReader fileReader = new FileReader("/proc/cpuinfo");
                try {
                    BufferedReader bufferedReader = new BufferedReader(fileReader, 1024);
                    line = bufferedReader.readLine();
                    bufferedReader.close();
                    fileReader.close();
                } catch (IOException e) {
                    if (AnalyticsConstants.UM_DEBUG) {
                        Log.e(TAG, "Could not read from file /proc/cpuinfo, e is " + e);
                    }
                }
            } catch (FileNotFoundException e2) {
                if (AnalyticsConstants.UM_DEBUG) {
                    Log.e(TAG, "Could not read from file /proc/cpuinfo, e is " + e2);
                }
            }
            return line != null ? line.substring(line.indexOf(58) + 1).trim() : "";
        } catch (Exception e3) {
            if (AnalyticsConstants.UM_DEBUG) {
                dts.e("get cpu e is ", e3, TAG);
            }
            return "";
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                dts.f("get cpu e is ", TAG, th);
            }
            return "";
        }
    }

    public static String getChannel(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return !TextUtils.isEmpty(UMConfigure.sChannel) ? UMConfigure.sChannel : getMultiProcessSP(context, "channel");
        } catch (Exception e) {
            if (AnalyticsConstants.UM_DEBUG) {
                dts.e("get channel e is ", e, TAG);
            }
            UMCrashManager.reportCrash(context, e);
            return null;
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                dts.f("get channel e is ", TAG, th);
            }
            UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    public static String getChannelByXML(Context context) {
        Bundle bundle;
        Object obj;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null || (obj = bundle.get("UMENG_CHANNEL")) == null) {
                return null;
            }
            String string = obj.toString();
            if (string != null) {
                return string.trim();
            }
            if (!AnalyticsConstants.UM_DEBUG) {
                return null;
            }
            MLog.i(AnalyticsConstants.LOG_TAG, "Could not read UMENG_CHANNEL meta-data from AndroidManifest.xml.");
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> getClass(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getDeviceToken(Context context) {
        Object objInvoke;
        Method method;
        Object objInvoke2;
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            try {
                Class<?> cls = Class.forName("com.umeng.message.PushAgent");
                Method method2 = cls.getMethod("getInstance", Context.class);
                if (method2 != null && (objInvoke = method2.invoke(cls, applicationContext)) != null && (method = cls.getMethod("getRegistrationId", null)) != null && (objInvoke2 = method.invoke(objInvoke, null)) != null && (objInvoke2 instanceof String)) {
                    return (String) objInvoke2;
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static String getDeviceType(Context context) {
        if (context == null) {
            return "Phone";
        }
        try {
            return (context.getResources().getConfiguration().screenLayout & 15) >= 3 ? "Tablet" : "Phone";
        } catch (Exception e) {
            if (AnalyticsConstants.UM_DEBUG) {
                dts.e("get device type e is ", e, TAG);
            }
            UMCrashManager.reportCrash(context, e);
            return null;
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                dts.f("get device type e is ", TAG, th);
            }
            UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    public static String getDisplayResolution(Context context) {
        if (context == null) {
            return "";
        }
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager == null) {
                return "";
            }
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            int i = displayMetrics.widthPixels;
            return String.valueOf(displayMetrics.heightPixels) + "*" + String.valueOf(i);
        } catch (Exception e) {
            if (AnalyticsConstants.UM_DEBUG) {
                dts.e("get display resolution e is ", e, TAG);
            }
            UMCrashManager.reportCrash(context, e);
            return "";
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                dts.f("get display resolution e is ", TAG, th);
            }
            UMCrashManager.reportCrash(context, th);
            return "";
        }
    }

    public static String getFileMD5(File file) {
        try {
            try {
                byte[] bArr = new byte[1024];
                try {
                    if (!file.isFile()) {
                        return "";
                    }
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    FileInputStream fileInputStream = new FileInputStream(file);
                    while (true) {
                        int i = fileInputStream.read(bArr, 0, 1024);
                        if (i == -1) {
                            fileInputStream.close();
                            return String.format("%1$032x", new BigInteger(1, messageDigest.digest()));
                        }
                        messageDigest.update(bArr, 0, i);
                    }
                } catch (Exception unused) {
                    return null;
                }
            } catch (Throwable th) {
                if (AnalyticsConstants.UM_DEBUG) {
                    dts.f("get file MD5 e is ", TAG, th);
                }
                return null;
            }
        } catch (Exception e) {
            if (AnalyticsConstants.UM_DEBUG) {
                dts.e("get file MD5 e is ", e, TAG);
            }
            return null;
        }
    }

    private static String getFlymeVersion(Properties properties) {
        try {
            String lowerCase = properties.getProperty("ro.build.display.id").toLowerCase(Locale.getDefault());
            if (lowerCase.contains("flyme os")) {
                return lowerCase.split(" ")[2];
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String[] getGPU(GL10 gl10) {
        try {
            return new String[]{gl10.glGetString(7936), gl10.glGetString(7937)};
        } catch (Exception e) {
            if (AnalyticsConstants.UM_DEBUG) {
                dts.e("Could not read gpu infor, e is ", e, TAG);
            }
            return new String[0];
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                dts.f("Could not read gpu infor, e is ", TAG, th);
            }
            return new String[0];
        }
    }

    public static String getLastAppkey(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return getMultiProcessSP(context, KEY_LAST_APP_KEY);
        } catch (Exception e) {
            if (AnalyticsConstants.UM_DEBUG) {
                dts.e("get last app key e is ", e, TAG);
            }
            UMCrashManager.reportCrash(context, e);
            return null;
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                dts.f("get last app key e is ", TAG, th);
            }
            UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    public static Locale getLocale(Context context) {
        Locale locale;
        if (context == null) {
            return null;
        }
        try {
            try {
                Configuration configuration = new Configuration();
                configuration.setToDefaults();
                Settings.System.getConfiguration(context.getContentResolver(), configuration);
                locale = configuration.locale;
            } catch (Exception e) {
                try {
                    if (AnalyticsConstants.UM_DEBUG) {
                        Log.e(TAG, "fail to read user config locale, e is " + e);
                    }
                    locale = null;
                } catch (Exception e2) {
                    if (AnalyticsConstants.UM_DEBUG) {
                        dts.e("get locale e is ", e2, TAG);
                    }
                    UMCrashManager.reportCrash(context, e2);
                    return null;
                }
            }
            return locale == null ? Locale.getDefault() : locale;
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                dts.f("get locale e is ", TAG, th);
            }
            UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    public static String getMac(Context context) {
        return null;
    }

    private static byte[] getMiniArray() {
        return new byte[]{1, 6, 8, 12, dn.k};
    }

    public static JSONObject getModuleVer() {
        try {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(bt.aX, com.umeng.commonsdk.internal.a.e);
                if (!TextUtils.isEmpty(VALUE_ANALYTICS_VERSION)) {
                    jSONObject.put(bt.aY, VALUE_ANALYTICS_VERSION);
                }
                if (!TextUtils.isEmpty(VALUE_GAME_VERSION)) {
                    jSONObject.put(bt.aZ, VALUE_GAME_VERSION);
                }
                if (!TextUtils.isEmpty(VALUE_PUSH_VERSION)) {
                    jSONObject.put(bt.ba, VALUE_PUSH_VERSION);
                }
                if (!TextUtils.isEmpty(VALUE_SHARE_VERSION)) {
                    jSONObject.put(bt.bb, VALUE_SHARE_VERSION);
                }
                if (!TextUtils.isEmpty(VALUE_APM_VERSION)) {
                    jSONObject.put(bt.bc, VALUE_APM_VERSION);
                }
                if (!TextUtils.isEmpty(VALUE_VERIFY_VERSION)) {
                    jSONObject.put(bt.bd, VALUE_VERIFY_VERSION);
                }
                if (!TextUtils.isEmpty(VALUE_SMS_VERSION)) {
                    jSONObject.put(bt.be, VALUE_SMS_VERSION);
                }
                if (!TextUtils.isEmpty(VALUE_REC_VERSION_NAME)) {
                    jSONObject.put(bt.bf, VALUE_REC_VERSION_NAME);
                }
                if (!TextUtils.isEmpty(VALUE_VISUAL_VERSION)) {
                    jSONObject.put(bt.bg, VALUE_VISUAL_VERSION);
                }
                if (!TextUtils.isEmpty(VALUE_ASMS_VERSION)) {
                    jSONObject.put(bt.bh, VALUE_ASMS_VERSION);
                }
                if (!TextUtils.isEmpty(VALUE_LINK_VERSION)) {
                    jSONObject.put(bt.bi, VALUE_LINK_VERSION);
                }
                if (!TextUtils.isEmpty(VALUE_ABTEST_VERSION)) {
                    jSONObject.put(bt.bj, VALUE_ABTEST_VERSION);
                }
                if (!TextUtils.isEmpty(VALUE_ANTI_VERSION)) {
                    jSONObject.put(bt.bk, VALUE_ANTI_VERSION);
                }
                return jSONObject;
            } catch (Throwable unused) {
                return jSONObject;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static String getMultiProcessSP(Context context, String str) {
        SharedPreferences sharedPreferences;
        try {
            synchronized (spLock) {
                if (context != null) {
                    try {
                        if (!TextUtils.isEmpty(str)) {
                            if (isMainProgress(context)) {
                                sharedPreferences = context.getApplicationContext().getSharedPreferences(KEY_SHARED_PREFERENCES_NAME, 0);
                            } else {
                                String subProcessName = UMFrUtils.getSubProcessName(context);
                                sharedPreferences = context.getApplicationContext().getSharedPreferences(subProcessName + JavaConstant.Dynamic.DEFAULT_NAME + KEY_SHARED_PREFERENCES_NAME, 0);
                            }
                            if (sharedPreferences == null) {
                                return null;
                            }
                            return sharedPreferences.getString(str, null);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return null;
            }
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String[] getNetworkAccessMode(Context context) {
        String[] strArr = {"", ""};
        if (context != null) {
            try {
                if (!checkPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
                    strArr[0] = "";
                    return strArr;
                }
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager == null) {
                    strArr[0] = "";
                    return strArr;
                }
                NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
                if (networkInfo != null && networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                    strArr[0] = "Wi-Fi";
                    return strArr;
                }
                NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
                if (networkInfo2 != null && networkInfo2.getState() == NetworkInfo.State.CONNECTED) {
                    strArr[0] = "2G/3G";
                    strArr[1] = networkInfo2.getSubtypeName();
                    return strArr;
                }
            } catch (Exception e) {
                if (AnalyticsConstants.UM_DEBUG) {
                    dts.e("get network access mode e is ", e, TAG);
                }
                UMCrashManager.reportCrash(context, e);
            } catch (Throwable th) {
                if (AnalyticsConstants.UM_DEBUG) {
                    dts.f("get network access mode e is ", TAG, th);
                }
                UMCrashManager.reportCrash(context, th);
            }
        }
        return strArr;
    }

    public static String getNetworkOperatorName(Context context) {
        return DeviceConfig.getNetworkOperatorName(context);
    }

    public static String getOaidRequiredTime(Context context) {
        if (!FieldManager.allow(d.G)) {
            return null;
        }
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(i.a, 0);
            if (sharedPreferences != null) {
                return sharedPreferences.getString(i.c, "");
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getOperator(Context context) {
        String registeredOperator = DeviceConfig.getRegisteredOperator(context);
        return TextUtils.isEmpty(registeredOperator) ? "Unknown" : registeredOperator;
    }

    public static String getRegisteredOperator(Context context) {
        return DeviceConfig.getRegisteredOperator(context);
    }

    public static String getSubOSName(Context context) {
        if (context == null) {
            return null;
        }
        try {
            try {
                Properties buildProp = getBuildProp();
                try {
                    String property = buildProp.getProperty(KEY_MIUI_VERSION_NAME);
                    return TextUtils.isEmpty(property) ? isFlyMe() ? "Flyme" : !TextUtils.isEmpty(getYunOSVersion(buildProp)) ? "YunOS" : property : "MIUI";
                } catch (Exception e) {
                    UMCrashManager.reportCrash(context, e);
                    return null;
                }
            } catch (Throwable th) {
                if (AnalyticsConstants.UM_DEBUG) {
                    dts.f("get sub os name e is ", TAG, th);
                }
                UMCrashManager.reportCrash(context, th);
                return null;
            }
        } catch (Exception e2) {
            if (AnalyticsConstants.UM_DEBUG) {
                dts.e("get sub os name e is ", e2, TAG);
            }
            UMCrashManager.reportCrash(context, e2);
            return null;
        }
    }

    public static String getSubOSVersion(Context context) {
        if (context == null) {
            return null;
        }
        try {
            try {
                Properties buildProp = getBuildProp();
                try {
                    String property = buildProp.getProperty(KEY_MIUI_VERSION_NAME);
                    if (TextUtils.isEmpty(property)) {
                        try {
                            return isFlyMe() ? getFlymeVersion(buildProp) : getYunOSVersion(buildProp);
                        } catch (Exception unused) {
                        }
                    }
                    return property;
                } catch (Exception e) {
                    UMCrashManager.reportCrash(context, e);
                    return null;
                }
            } catch (Throwable th) {
                if (AnalyticsConstants.UM_DEBUG) {
                    dts.f("get sub os version e is ", TAG, th);
                }
                UMCrashManager.reportCrash(context, th);
                return null;
            }
        } catch (Exception e2) {
            if (AnalyticsConstants.UM_DEBUG) {
                dts.e("get sub os version e is ", e2, TAG);
            }
            UMCrashManager.reportCrash(context, e2);
            return null;
        }
    }

    public static String getSystemProperty(String str, String str2) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    public static int getTargetSdkVersion(Context context) {
        try {
            return context.getApplicationInfo().targetSdkVersion;
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static String getUMId(Context context) {
        if (context != null) {
            try {
                return UMEnvelopeBuild.imprintProperty(context.getApplicationContext(), bt.g, null);
            } catch (Exception e) {
                UMCrashManager.reportCrash(context, e);
            }
        }
        return null;
    }

    public static String getUUIDForZid(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(SP_FILE_NAME, 0);
        return sharedPreferences != null ? sharedPreferences.getString("session_id", "") : "";
    }

    public static String getUmengToken(Context context) {
        if (context != null) {
            try {
                return UMEnvelopeBuild.imprintProperty(context.getApplicationContext(), "ztoken", null);
            } catch (Exception e) {
                UMCrashManager.reportCrash(context, e);
            }
        }
        return null;
    }

    private static String getYunOSVersion(Properties properties) {
        try {
            String property = properties.getProperty("ro.yunos.version");
            if (TextUtils.isEmpty(property)) {
                return null;
            }
            return property;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getZid(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (UMConfigure.needSendZcfgEnv(applicationContext)) {
            return null;
        }
        return com.umeng.commonsdk.internal.b.a(applicationContext).a().a();
    }

    public static boolean isAppInstalled(Context context, String str) {
        if (context == null) {
            return false;
        }
        return b.a().a(context, str, 0) != null;
    }

    public static boolean isApplication(Context context) {
        try {
            String name = context.getApplicationContext().getClass().getSuperclass().getName();
            return !TextUtils.isEmpty(name) && name.equals("android.app.Application");
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isDebug(Context context) {
        if (context == null) {
            return false;
        }
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Exception e) {
            UMCrashManager.reportCrash(context, e);
            return false;
        }
    }

    private static boolean isFlyMe() {
        try {
            Build.class.getMethod("hasSmartBar", null);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isMainProgress(Context context) {
        try {
            String currentProcessName = UMFrUtils.getCurrentProcessName(context);
            String packageName = context.getApplicationContext().getPackageName();
            return (TextUtils.isEmpty(currentProcessName) || TextUtils.isEmpty(packageName) || !currentProcessName.equals(packageName)) ? false : true;
        } catch (Exception unused) {
            return false;
        }
    }

    private static String parseId(String str) {
        if (str == null) {
            return null;
        }
        try {
            Matcher matcher = pattern.matcher(str);
            if (matcher.find()) {
                return matcher.group(1);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private static String readStreamToString(InputStream inputStream) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        char[] cArr = new char[1024];
        StringWriter stringWriter = new StringWriter();
        while (true) {
            int i = inputStreamReader.read(cArr);
            if (-1 == i) {
                return stringWriter.toString();
            }
            stringWriter.write(cArr, 0, i);
        }
    }

    private static void safeClose(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception unused) {
            }
        }
    }

    public static void saveSDKComponent() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(bt.at);
        if (UMConfigure.isDebugLog()) {
            UMLog.mutlInfo(2, "统计SDK版本号: 9.8.8");
        }
        VALUE_ANALYTICS_VERSION = "9.8.8";
        String strB = com.umeng.commonsdk.internal.c.b();
        if (!TextUtils.isEmpty(strB)) {
            VALUE_ASMS_VERSION = strB;
            if (UMConfigure.isDebugLog()) {
                UMLog.mutlInfo(2, yg.k("ZID SDK版本号: ", strB));
            }
        }
        Class<?> cls = getClass("com.umeng.analytics.game.GameSdkVersion");
        if (cls != null) {
            stringBuffer.append("g");
            try {
                String str = (String) cls.getDeclaredField("SDK_VERSION").get(cls);
                if (!TextUtils.isEmpty(str)) {
                    VALUE_GAME_VERSION = str;
                    if (UMConfigure.isDebugLog()) {
                        UMLog.mutlInfo(2, "游戏统计SDK版本号: " + str);
                    }
                }
            } catch (Throwable unused) {
            }
        }
        Class<?> cls2 = getClass("com.umeng.vt.V");
        if (cls2 != null) {
            stringBuffer.append("v");
            try {
                String str2 = (String) cls2.getDeclaredField("VERSION").get(cls2);
                if (!TextUtils.isEmpty(str2)) {
                    VALUE_VISUAL_VERSION = str2;
                    if (UMConfigure.isDebugLog()) {
                        UMLog.mutlInfo(2, "可视化埋点SDK版本号: " + str2);
                    }
                }
            } catch (Throwable unused2) {
            }
        }
        if (getClass("com.umeng.message.PushAgent") != null) {
            stringBuffer.append(bt.av);
            Class<?> cls3 = getClass("com.umeng.message.MsgConstant");
            if (cls3 != null) {
                try {
                    String str3 = (String) cls3.getDeclaredField("SDK_VERSION").get(cls3);
                    if (!TextUtils.isEmpty(str3)) {
                        VALUE_PUSH_VERSION = str3;
                        if (UMConfigure.isDebugLog()) {
                            UMLog.mutlInfo(2, "推送SDK版本号: " + str3);
                        }
                    }
                } catch (Throwable unused3) {
                }
            }
        }
        Class<?> cls4 = getClass("com.umeng.socialize.UMShareAPI");
        if (cls4 != null) {
            stringBuffer.append(bt.az);
            Class<?> cls5 = getClass("com.umeng.a");
            if (cls5 != null) {
                try {
                    String str4 = (String) cls5.getDeclaredField("g").get(cls5);
                    if (!TextUtils.isEmpty(str4)) {
                        VALUE_SHARE_VERSION = str4;
                        if (UMConfigure.isDebugLog()) {
                            UMLog.mutlInfo(2, "分享SDK版本号: " + str4);
                        }
                    }
                } catch (Throwable unused4) {
                }
            }
            if (TextUtils.isEmpty(VALUE_SHARE_VERSION)) {
                try {
                    Method declaredMethod = cls4.getDeclaredMethod("getSdkVersion", null);
                    declaredMethod.setAccessible(true);
                    VALUE_SHARE_VERSION = (String) declaredMethod.invoke(cls4, null);
                } catch (Throwable unused5) {
                }
            }
        }
        if (getClass("com.umeng.error.UMError") != null) {
            stringBuffer.append("e");
        }
        if (getClass("com.umeng.umzid.ZIDManager") != null) {
            stringBuffer.append(bt.aB);
        }
        stringBuffer.append(bt.aA);
        if (SdkVersion.SDK_TYPE != 1 && getClass("com.umeng.commonsdk.internal.UMOplus") != null) {
            stringBuffer.append("o");
        }
        if (getClass("com.umeng.airec.RecAgent") != null) {
            stringBuffer.append(bt.aF);
            Class<?> cls6 = getClass("com.umeng.airec.BuildConfig");
            if (cls6 != null) {
                try {
                    String str5 = (String) cls6.getDeclaredField("VERSION_NAME").get(cls6);
                    if (!TextUtils.isEmpty(str5)) {
                        VALUE_REC_VERSION_NAME = str5;
                        if (UMConfigure.isDebugLog()) {
                            UMLog.mutlInfo(2, "智能推荐SDK版本号: " + str5);
                        }
                    }
                } catch (Throwable unused6) {
                }
            }
        }
        Class<?> cls7 = getClass("com.umeng.umverify.UMVerifyHelper");
        if (cls7 != null) {
            stringBuffer.append("n");
            try {
                Method declaredMethod2 = cls7.getDeclaredMethod("getUVerifyVersion", null);
                if (declaredMethod2 != null) {
                    String str6 = (String) declaredMethod2.invoke(cls7, null);
                    if (!TextUtils.isEmpty(str6)) {
                        VALUE_VERIFY_VERSION = str6;
                        if (UMConfigure.isDebugLog()) {
                            UMLog.mutlInfo(2, "号码认证SDK版本号: " + str6);
                        }
                    }
                }
            } catch (Throwable unused7) {
            }
        }
        Class<?> cls8 = getClass("com.umeng.sms.UMSMS");
        if (cls8 != null) {
            stringBuffer.append("m");
            try {
                Method declaredMethod3 = cls8.getDeclaredMethod("getVersion", null);
                if (declaredMethod3 != null) {
                    String str7 = (String) declaredMethod3.invoke(cls8, null);
                    if (!TextUtils.isEmpty(str7)) {
                        VALUE_SMS_VERSION = str7;
                        if (UMConfigure.isDebugLog()) {
                            UMLog.mutlInfo(2, "短信验证码SDK版本号: " + str7);
                        }
                    }
                }
            } catch (Throwable unused8) {
            }
        }
        try {
            Class<?> cls9 = getClass("com.umeng.umcrash.UMCrash");
            if (cls9 != null) {
                stringBuffer.append(bt.aD);
                Field declaredField = cls9.getDeclaredField("crashSdkVersion");
                declaredField.setAccessible(true);
                String str8 = (String) declaredField.get(cls9);
                if (!TextUtils.isEmpty(str8)) {
                    VALUE_APM_VERSION = str8;
                    if (UMConfigure.isDebugLog()) {
                        UMLog.mutlInfo(2, "APM SDK版本号: " + str8);
                    }
                }
            }
        } catch (Throwable unused9) {
        }
        Class<?> cls10 = getClass("com.umeng.umlink.MobclickLink");
        if (cls10 != null) {
            stringBuffer.append("l");
            try {
                Method declaredMethod4 = cls10.getDeclaredMethod("getVersion", null);
                if (declaredMethod4 != null) {
                    String str9 = (String) declaredMethod4.invoke(cls10, null);
                    if (!TextUtils.isEmpty(str9)) {
                        VALUE_LINK_VERSION = str9;
                        if (UMConfigure.isDebugLog()) {
                            UMLog.mutlInfo(2, "ULink SDK版本号: " + str9);
                        }
                    }
                }
            } catch (Throwable unused10) {
            }
        }
        Class<?> cls11 = getClass("com.umeng.cconfig.UMRemoteConfig");
        if (cls11 != null) {
            try {
                Method declaredMethod5 = cls11.getDeclaredMethod("getVersion", null);
                if (declaredMethod5 != null) {
                    stringBuffer.append(bt.aG);
                    String str10 = (String) declaredMethod5.invoke(cls11, null);
                    if (!TextUtils.isEmpty(str10)) {
                        VALUE_ABTEST_VERSION = str10;
                        if (UMConfigure.isDebugLog()) {
                            UMLog.mutlInfo(2, "UABTEST SDK版本号: " + str10);
                        }
                    }
                }
            } catch (Throwable unused11) {
            }
        }
        Class<?> cls12 = getClass("com.uyumao.sdk.UYMManager");
        if (cls12 != null) {
            try {
                Method declaredMethod6 = cls12.getDeclaredMethod("getSdkVersion", null);
                if (declaredMethod6 != null) {
                    stringBuffer.append("r");
                    String str11 = (String) declaredMethod6.invoke(cls12, null);
                    if (!TextUtils.isEmpty(str11)) {
                        VALUE_ANTI_VERSION = str11;
                        if (UMConfigure.isDebugLog()) {
                            UMLog.mutlInfo(2, "ANTI SDK版本号: " + str11);
                        }
                    }
                }
            } catch (Throwable unused12) {
            }
        }
        if (TextUtils.isEmpty(stringBuffer)) {
            return;
        }
        com.umeng.commonsdk.statistics.b.a = stringBuffer.toString();
        Log.i(AnalyticsConstants.LOG_TAG, "module init:" + com.umeng.commonsdk.statistics.b.a);
    }

    public static void setAppkey(Context context, String str) {
        if (context == null || str == null) {
            return;
        }
        try {
            setMultiProcessSP(context, "appkey", str);
        } catch (Exception e) {
            if (AnalyticsConstants.UM_DEBUG) {
                dts.e("set app key e is ", e, TAG);
            }
            UMCrashManager.reportCrash(context, e);
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                dts.f("set app key e is ", TAG, th);
            }
            UMCrashManager.reportCrash(context, th);
        }
    }

    public static void setChannel(Context context, String str) {
        if (context == null || str == null) {
            return;
        }
        try {
            setMultiProcessSP(context, "channel", str);
        } catch (Exception e) {
            if (AnalyticsConstants.UM_DEBUG) {
                dts.e("set channel e is ", e, TAG);
            }
            UMCrashManager.reportCrash(context, e);
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                dts.f("set channel e is ", TAG, th);
            }
            UMCrashManager.reportCrash(context, th);
        }
    }

    public static void setLastAppkey(Context context, String str) {
        if (context == null || str == null) {
            return;
        }
        try {
            setMultiProcessSP(context, KEY_LAST_APP_KEY, str);
        } catch (Exception e) {
            if (AnalyticsConstants.UM_DEBUG) {
                dts.e("set last app key e is ", e, TAG);
            }
            UMCrashManager.reportCrash(context, e);
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                dts.f("set last app key e is ", TAG, th);
            }
            UMCrashManager.reportCrash(context, th);
        }
    }

    public static void setMultiProcessSP(Context context, String str, String str2) {
        SharedPreferences sharedPreferences;
        try {
            synchronized (spLock) {
                if (context != null) {
                    try {
                        if (!TextUtils.isEmpty(str) && str2 != null) {
                            if (isMainProgress(context)) {
                                sharedPreferences = context.getApplicationContext().getSharedPreferences(KEY_SHARED_PREFERENCES_NAME, 0);
                            } else {
                                String subProcessName = UMFrUtils.getSubProcessName(context);
                                sharedPreferences = context.getApplicationContext().getSharedPreferences(subProcessName + JavaConstant.Dynamic.DEFAULT_NAME + KEY_SHARED_PREFERENCES_NAME, 0);
                            }
                            if (sharedPreferences != null) {
                                sharedPreferences.edit().putString(str, str2).commit();
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void setUUIDForZid(Context context) {
        String string;
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(SP_FILE_NAME, 0);
        try {
            string = UUID.randomUUID().toString();
        } catch (Throwable unused) {
            string = "";
        }
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("session_id", string).commit();
        }
    }

    public static String getAppVersionName(Context context, String str) {
        if (context != null && str != null) {
            try {
                PackageInfo packageInfoA = b.a().a(context, str, 64);
                if (packageInfoA != null) {
                    return packageInfoA.versionName;
                }
            } catch (Throwable th) {
                if (AnalyticsConstants.UM_DEBUG) {
                    dts.f("get app version name e is ", TAG, th);
                }
                UMCrashManager.reportCrash(context, th);
            }
        }
        return "";
    }
}
