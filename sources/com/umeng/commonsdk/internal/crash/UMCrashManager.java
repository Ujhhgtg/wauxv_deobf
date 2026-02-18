package com.umeng.commonsdk.internal.crash;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.bt;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.b;
import com.umeng.commonsdk.stateless.d;
import com.umeng.commonsdk.statistics.UMServerURL;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class UMCrashManager {
    private static final String CM_VERSION = "2.0";
    private static boolean isReportCrash;
    private static Object mObject = new Object();

    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.BlockNode.getSuccessors()" because "blk" is null
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.exploreTryPath(TryCatchBlockAttr.java:210)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(TryCatchBlockAttr.java:196)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(TryCatchBlockAttr.java:180)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getTryEdges(TryCatchBlockAttr.java:201)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getEdgeBlockMap(TryCatchBlockAttr.java:347)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getExecutionScopeGroups(TryCatchBlockAttr.java:356)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.getTryBlockData(MarkFinallyVisitor.java:202)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:119)
     */
    public static void buildEnvelope(Context context, Object obj) {
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> UMCrashManager.buildEnvelope enter.");
        try {
            synchronized (mObject) {
                try {
                    if (context == null || obj == null) {
                        return;
                    }
                    String str = (String) obj;
                    if (!TextUtils.isEmpty(str)) {
                        String str2 = context.getFilesDir() + File.separator + com.umeng.commonsdk.stateless.a.f;
                        File file = new File(str2);
                        if (!file.isDirectory()) {
                            file.mkdir();
                        }
                        d.a(context, str2, bt.aD, 10);
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put(bt.aM, CM_VERSION);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("content", str);
                            jSONObject2.put("ts", System.currentTimeMillis());
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("crash", jSONObject2);
                            JSONObject jSONObject4 = new JSONObject();
                            jSONObject4.put("tp", jSONObject3);
                            UMEnvelopeBuild.buildEnvelopeWithExtHeader(context, jSONObject, jSONObject4, UMServerURL.PATH_INNER_CRASH, bt.aD, CM_VERSION);
                        } catch (JSONException unused) {
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Throwable unused2) {
        }
    }

    public static void reportCrash(Context context, Throwable th) {
        synchronized (mObject) {
            try {
                if (!isReportCrash) {
                    isReportCrash = true;
                    UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.u, b.a(context).a(), a.a(th));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
