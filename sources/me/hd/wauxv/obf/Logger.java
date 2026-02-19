package me.hd.wauxv.obf;

import android.util.Log;
import de.robv.android.xposed.XposedBridge;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class Logger {
    public static final ArrayList a = new ArrayList();
    public static final dop b = new dop(24);
    public static boolean c;

    public static void logD(int i, String str) {
        dispatchLog(LogDestination.a, new LogEntry(cna.d, "D", String.valueOf(str), null, 51), false);
    }

    public static void logE(String str, Exception exc, int i) {
        if ((i & 2) != 0) {
            exc = null;
        }
        dispatchLog(LogDestination.a, new LogEntry(cna.d, "E", String.valueOf(str), exc, 51), false);
    }

    public static void f() {
        int i = 0;
        Kotlin$Lazy kotlin$LazyVar = LogConfig.isDevelopmentMode;
        if (!(Boolean) LogConfig.isVerboseLogging.getValue()) {
            System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "info");
        }
        LogConfig.logLevelEnum = LogLevelEnum.INFO;
        if (c) {
            return;
        }
        LogConfig.logBackend = b;
        c = true;
    }

    public static void logException(int i, String str, Throwable th) {
        if ((i & 2) != 0) {
            th = null;
        }
        Throwable th2 = th;
        dispatchLog(LogDestination.a, new LogEntry(null, "E", String.valueOf(str), th2, 55), (i & 4) == 0);
    }

    public static void logW(String str) {
        dispatchLog(LogDestination.a, new LogEntry(null, "W", String.valueOf(str), null, 55), false);
    }

    public static void dispatchLog(LogDestination logDestinationVar, LogEntry logEntryVar, boolean z) {
        f();
        String str = logEntryVar.g;
        boolean z2 = !dnj.ak(str) || (dnj.ak(str) && logEntryVar.h != null);
        int iOrdinal = logDestinationVar.ordinal();
        if (iOrdinal == 0) {
            writeToLogcat(logEntryVar);
            return;
        }
        if (iOrdinal == 1) {
            writeToXposed(z2, logEntryVar, z);
            return;
        }
        if (iOrdinal == 2) {
            boolean z3 = exm.a;
            if (exm.l()) {
                writeToXposed(z2, logEntryVar, z);
                return;
            } else {
                writeToLogcat(logEntryVar);
                return;
            }
        }
        if (iOrdinal != 3) {
            throw new QueryDidNotReturnUniqueResultRuntimeException();
        }
        writeToLogcat(logEntryVar);
        boolean z4 = exm.a;
        if (exm.l()) {
            writeToXposed(z2, logEntryVar, z);
        }
    }

    public static final void writeToXposed(boolean z, LogEntry logEntryVar, boolean z2) {
        if (z) {
            logEntryVar.i = z2;
            String string = logEntryVar.toString();
            Throwable th = logEntryVar.h;
            if (bhs.r() != bmc.b) {
                int iOrdinal = bhs.r().ordinal();
                if (iOrdinal != 0) {
                    if (iOrdinal == 1) {
                        throw new IllegalStateException(
                                "YukiHookAPI cannot support current Hook API or cannot found any available Hook APIs in current environment");
                    }
                    throw new QueryDidNotReturnUniqueResultRuntimeException();
                }
                XposedBridge.log(string);
                if (th != null) {
                    XposedBridge.log(th);
                }
            }
        }
    }

    public static final void writeToLogcat(LogEntry logEntryVar) {
        String str = logEntryVar.d;
        Throwable th = logEntryVar.h;
        String str2 = logEntryVar.g;
        String str3 = logEntryVar.c;
        int iHashCode = str.hashCode();
        if (iHashCode != 68) {
            if (iHashCode != 69) {
                if (iHashCode != 73) {
                    if (iHashCode == 87 && str.equals("W")) {
                        Log.w(str3, str2, th);
                        return;
                    }
                } else if (str.equals("I")) {
                    Log.i(str3, str2, th);
                    return;
                }
            } else if (str.equals("E")) {
                Log.e(str3, str2, th);
                return;
            }
        } else if (str.equals("D")) {
            Log.d(str3, str2, th);
            return;
        }
        Log.wtf(str3, str2, th);
    }
}
