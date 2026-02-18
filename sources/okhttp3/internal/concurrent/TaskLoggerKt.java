package okhttp3.internal.concurrent;

import java.util.Arrays;
import java.util.logging.Level;
import me.hd.wauxv.obf.bfu;
import me.hd.wauxv.obf.bzo;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class TaskLoggerKt {
    public static final String formatDuration(long j) {
        String str;
        if (j <= -999500000) {
            str = ((j - ((long) 500000000)) / ((long) Http2Connection.DEGRADED_PONG_TIMEOUT_NS)) + " s ";
        } else if (j <= -999500) {
            str = ((j - ((long) 500000)) / ((long) 1000000)) + " ms";
        } else if (j <= 0) {
            str = ((j - ((long) 500)) / ((long) 1000)) + " µs";
        } else if (j < 999500) {
            str = ((j + ((long) 500)) / ((long) 1000)) + " µs";
        } else if (j < 999500000) {
            str = ((j + ((long) 500000)) / ((long) 1000000)) + " ms";
        } else {
            str = ((j + ((long) 500000000)) / ((long) Http2Connection.DEGRADED_PONG_TIMEOUT_NS)) + " s ";
        }
        return String.format("%6s", Arrays.copyOf(new Object[]{str}, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void log(Task task, TaskQueue taskQueue, String str) {
        TaskRunner.Companion.getLogger().fine(taskQueue.getName$okhttp() + ' ' + String.format("%-22s", Arrays.copyOf(new Object[]{str}, 1)) + ": " + task.getName());
    }

    public static final <T> T logElapsed(Task task, TaskQueue taskQueue, bfu bfuVar) {
        long jNanoTime;
        bzo.q(task, "task");
        bzo.q(taskQueue, "queue");
        bzo.q(bfuVar, "block");
        boolean zIsLoggable = TaskRunner.Companion.getLogger().isLoggable(Level.FINE);
        if (zIsLoggable) {
            jNanoTime = taskQueue.getTaskRunner$okhttp().getBackend().nanoTime();
            log(task, taskQueue, "starting");
        } else {
            jNanoTime = -1;
        }
        try {
            T t = (T) bfuVar.invoke();
            if (zIsLoggable) {
                long jNanoTime2 = taskQueue.getTaskRunner$okhttp().getBackend().nanoTime() - jNanoTime;
                StringBuilder sb = new StringBuilder("finished run in ");
            }
            return t;
        } finally {
            if (zIsLoggable) {
                log(task, taskQueue, "failed a run in " + formatDuration(taskQueue.getTaskRunner$okhttp().getBackend().nanoTime() - jNanoTime));
            }
        }
    }

    public static final void taskLog(Task task, TaskQueue taskQueue, bfu bfuVar) {
        bzo.q(task, "task");
        bzo.q(taskQueue, "queue");
        bzo.q(bfuVar, "messageBlock");
        if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
            log(task, taskQueue, (String) bfuVar.invoke());
        }
    }
}
