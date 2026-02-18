package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public interface bxs {
    boolean c();

    void debug(String str);

    default boolean e(int i) {
        char c;
        if (i == 1) {
            c = '(';
        } else if (i == 2) {
            c = 30;
        } else if (i == 3) {
            c = 20;
        } else if (i == 4) {
            c = '\n';
        } else {
            if (i != 5) {
                throw null;
            }
            c = 0;
        }
        if (c == 0) {
            return c();
        }
        if (c == '\n') {
            return isDebugEnabled();
        }
        if (c == 20) {
            return isInfoEnabled();
        }
        if (c == 30) {
            return isWarnEnabled();
        }
        if (c == '(') {
            return isErrorEnabled();
        }
        StringBuilder sb = new StringBuilder("Level [");
        sb.append(i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "null" : "TRACE" : "DEBUG" : "INFO" : "WARN" : "ERROR");
        sb.append("] not recognized.");
        throw new IllegalArgumentException(sb.toString());
    }

    boolean isDebugEnabled();

    boolean isErrorEnabled();

    boolean isInfoEnabled();

    boolean isWarnEnabled();

    void warn(String str, Throwable th);
}
