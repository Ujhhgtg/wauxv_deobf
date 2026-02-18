package com.umeng.commonsdk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.umeng.commonsdk.debug.UMRTLog;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class b {
    private static HashMap<String, PackageInfo> a = new HashMap<>();
    private static Object b = new Object();

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static class a {
        private static final b a = new b();

        private a() {
        }
    }

    public static b a() {
        return a.a;
    }

    private b() {
    }

    /* JADX WARN: Undo finally extract visitor
    jadx.core.utils.exceptions.JadxRuntimeException: Expected to find fallthrough terminus for handler TryEdge: [TRUE_FALLTHROUGH B:19:0x0036 -> B:7:0x0030] - Handler: None
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.findCommonInsns(MarkFinallyVisitor.java:419)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.extractFinally(MarkFinallyVisitor.java:302)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.processTryBlock(MarkFinallyVisitor.java:222)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:150)
     */
    public PackageInfo a(Context context, String str, int i) {
        PackageInfo packageInfo;
        synchronized (b) {
            try {
                if (a.containsKey(str)) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> pkg： " + str + ", pkgInfo缓存命中，直接返回");
                    packageInfo = a.get(str);
                } else {
                    try {
                        packageInfo = context.getPackageManager().getPackageInfo(str, i);
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> pkg： " + str + ", 获取pkgInfo并缓存");
                        a.put(str, packageInfo);
                    } catch (PackageManager.NameNotFoundException unused) {
                        a.put(str, null);
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> pkg: " + str + "，目标包未安装。");
                        packageInfo = null;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return packageInfo;
    }
}
