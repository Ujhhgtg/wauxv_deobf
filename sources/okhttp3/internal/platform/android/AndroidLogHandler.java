package okhttp3.internal.platform.android;

import java.util.logging.Handler;
import java.util.logging.LogRecord;
import me.hd.wauxv.obf.bzo;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidLogHandler extends Handler {
    public static final AndroidLogHandler INSTANCE = new AndroidLogHandler();

    private AndroidLogHandler() {
    }

    @Override // java.util.logging.Handler
    public void close() {
    }

    @Override // java.util.logging.Handler
    public void flush() {
    }

    @Override // java.util.logging.Handler
    public void publish(LogRecord logRecord) {
        bzo.q(logRecord, "record");
        AndroidLog androidLog = AndroidLog.INSTANCE;
        String loggerName = logRecord.getLoggerName();
        bzo.p(loggerName, "record.loggerName");
        int androidLevel = AndroidLogKt.getAndroidLevel(logRecord);
        String message = logRecord.getMessage();
        bzo.p(message, "record.message");
        androidLog.androidLog$okhttp(loggerName, androidLevel, message, logRecord.getThrown());
    }
}
