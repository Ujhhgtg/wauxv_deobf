package com.umeng.commonsdk.statistics;

import android.util.Log;
import com.umeng.commonsdk.debug.UMLogCommon;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class TagHelper {
    private static Object lock = new Object();
    private static Map<String, String> moduleTags = new HashMap();

    public static void deleteModuleTag(String str) {
        synchronized (lock) {
            try {
                if (moduleTags.containsKey(str)) {
                    moduleTags.remove(str);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static Map<String, String> getModuleTags() {
        HashMap map = new HashMap();
        synchronized (lock) {
            if (moduleTags.size() > 0) {
                for (Map.Entry<String, String> entry : moduleTags.entrySet()) {
                    map.put(entry.getKey(), entry.getValue());
                }
            }
        }
        return map;
    }

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
    public static void setModuleTag(String str, String str2) {
        synchronized (lock) {
            try {
                if (moduleTags.size() >= 30) {
                    Log.e("UMLog", UMLogCommon.SC_10023);
                } else {
                    if (!moduleTags.containsKey(str)) {
                        moduleTags.put(str, str2);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
