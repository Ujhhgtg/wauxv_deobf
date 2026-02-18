package me.hd.wauxv.obf;

import android.content.res.TypedArray;
import android.media.MediaDrm;
import android.media.MediaMetadataRetriever;
import android.util.Log;
import com.umeng.commonsdk.debug.UMLogUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class dts {
    public static int a(int i, int i2, int i3) {
        return (Integer.hashCode(i) + i2) * i3;
    }

    public static String b(long j, String str) {
        return str + j;
    }

    public static String c(StringBuilder sb, String str) {
        sb.append(UMLogUtils.makeUrl(str));
        return sb.toString();
    }

    public static /* synthetic */ void d(AutoCloseable autoCloseable) throws Exception {
        boolean zIsTerminated;
        if (autoCloseable instanceof AutoCloseable) {
            autoCloseable.close();
            return;
        }
        if (!(autoCloseable instanceof ExecutorService)) {
            if (autoCloseable instanceof TypedArray) {
                ((TypedArray) autoCloseable).recycle();
                return;
            } else if (autoCloseable instanceof MediaMetadataRetriever) {
                ((MediaMetadataRetriever) autoCloseable).release();
                return;
            } else {
                if (!(autoCloseable instanceof MediaDrm)) {
                    throw new IllegalArgumentException();
                }
                ((MediaDrm) autoCloseable).release();
                return;
            }
        }
        ExecutorService executorService = (ExecutorService) autoCloseable;
        if (executorService == ForkJoinPool.commonPool() || (zIsTerminated = executorService.isTerminated())) {
            return;
        }
        executorService.shutdown();
        boolean z = false;
        while (!zIsTerminated) {
            try {
                zIsTerminated = executorService.awaitTermination(1L, TimeUnit.DAYS);
            } catch (InterruptedException unused) {
                if (!z) {
                    executorService.shutdownNow();
                    z = true;
                }
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    public static void e(String str, Exception exc, String str2) {
        Log.e(str2, str + exc);
    }

    public static void f(String str, String str2, Throwable th) {
        Log.e(str2, str + th);
    }

    public static void g(StringBuilder sb, Boolean bool, long j) {
        sb.append(bool);
        sb.append(cnb.z(j));
    }

    public static void h(StringBuilder sb, dwj dwjVar, long j) {
        sb.append(dwjVar);
        sb.append(cnb.z(j));
    }
}
