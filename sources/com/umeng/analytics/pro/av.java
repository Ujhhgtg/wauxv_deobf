package com.umeng.analytics.pro;

import com.umeng.commonsdk.debug.UMRTLog;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class av {
    private static final String a = "UMExecutor";
    private static volatile ScheduledThreadPoolExecutor b;
    private static final ThreadFactory c = new ThreadFactory() { // from class: com.umeng.analytics.pro.av.1
        private final AtomicInteger a = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ccg-" + this.a.incrementAndGet());
        }
    };

    private static ScheduledThreadPoolExecutor a() {
        if (b == null) {
            synchronized (av.class) {
                try {
                    if (b == null) {
                        b = new ScheduledThreadPoolExecutor(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors(), 4)), c);
                        b.setKeepAliveTime(3L, TimeUnit.SECONDS);
                        b.allowCoreThreadTimeOut(true);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    public static void a(Runnable runnable, long j, TimeUnit timeUnit) {
        try {
            a().schedule(runnable, j, timeUnit);
        } catch (Throwable th) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "schedule error:" + th.getMessage());
        }
    }
}
