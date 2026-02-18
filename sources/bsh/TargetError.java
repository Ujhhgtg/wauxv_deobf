package bsh;

import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class TargetError extends EvalError {
    private final boolean inNativeCode;

    public TargetError(String str, Throwable th, Node node, CallStack callStack, boolean z) {
        super(str, node, callStack, th);
        this.inNativeCode = z;
    }

    private synchronized String printTargetError(Throwable th) {
        if (th == null) {
            return "Cause is null";
        }
        StringBuilder sb = new StringBuilder(th.toString());
        while (true) {
            th = th.getCause();
            if (th == null) {
                return sb.toString();
            }
            sb.append("\n");
            sb.append(th.toString());
        }
    }

    @Override // bsh.EvalError, java.lang.Throwable
    public synchronized String getMessage() {
        return super.getMessage() + "Caused by: " + printTargetError(getCause());
    }

    public synchronized Throwable getTarget() {
        Throwable cause = getCause();
        if (!(cause instanceof InvocationTargetException)) {
            return cause;
        }
        return cause.getCause();
    }

    public boolean inNativeCode() {
        return this.inNativeCode;
    }

    public void printStackTrace(boolean z, PrintStream printStream) {
        if (z) {
            printStackTrace(printStream);
            printStream.println("--- Target Stack Trace ---");
        }
        for (StackTraceElement stackTraceElement : getCause().getStackTrace()) {
            if (stackTraceElement.getClassName().contains("reflect")) {
                return;
            }
            printStream.println("        at " + stackTraceElement);
        }
    }

    public TargetError(Throwable th, Node node, CallStack callStack) {
        this("TargetError", th, node, callStack, false);
    }
}
