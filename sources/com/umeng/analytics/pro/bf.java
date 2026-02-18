package com.umeng.analytics.pro;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMRTLog;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class bf {
    private static be a;
    private static String b;
    private static boolean c;

    public static synchronized String a(Context context) {
        if (!UMConfigure.shouldCollectOaid()) {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>*** OpenDeviceId.getOAID(): oaid开关已关闭。");
            return null;
        }
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>*** real call OpenDeviceId.getOaid()");
        if (context == null) {
            return null;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return null;
        }
        if (a == null) {
            a = bh.a();
        }
        be beVar = a;
        if (beVar != null) {
            try {
                String strA = beVar.a(context);
                if (!TextUtils.isEmpty(strA)) {
                    b = strA;
                }
                c = true;
                UMRTLog.i(UMRTLog.RTLOG_TAG, "OpenDeviceId:getOAID() result: " + b);
                return b;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static String b(Context context) {
        if (UMConfigure.shouldCollectOaid()) {
            return c ? b : a(context);
        }
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>*** OpenDeviceId.getOAIDFromCache(): oaid开关已关闭。");
        return null;
    }

    @Deprecated
    public static synchronized String c(Context context) {
        if (UMConfigure.shouldCollectOaid()) {
            return null;
        }
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>*** OpenDeviceId.getHonorCompatibleOaid(): oaid开关已关闭。");
        return null;
    }

    @Deprecated
    public static synchronized String d(Context context) {
        if (UMConfigure.shouldCollectOaid()) {
            return null;
        }
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>*** OpenDeviceId.getHonorCompatibleOaidFromCache(): oaid开关已关闭。");
        return null;
    }
}
