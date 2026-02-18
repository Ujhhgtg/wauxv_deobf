package bsh;

import me.hd.wauxv.obf.dkz;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class UtilEvalError extends Exception {
    public UtilEvalError() {
    }

    public EvalError toEvalError(String str, Node node, CallStack callStack) {
        if (Interpreter.DEBUG.get().booleanValue()) {
            printStackTrace();
        }
        StringBuilder sbY = dkz.y(str == null ? "" : str.concat(": "));
        sbY.append(getMessage());
        return new EvalError(sbY.toString(), node, callStack, this);
    }

    public EvalException toEvalException(String str, Node node, CallStack callStack) {
        if (Interpreter.DEBUG.get().booleanValue()) {
            printStackTrace();
        }
        StringBuilder sbY = dkz.y(str == null ? "" : str.concat(": "));
        sbY.append(getMessage());
        return new EvalException(sbY.toString(), node, callStack, this);
    }

    public UtilEvalError(String str) {
        super(str);
    }

    public UtilEvalError(String str, Throwable th) {
        super(str, th);
    }

    public EvalError toEvalError(Node node, CallStack callStack) {
        return toEvalError(null, node, callStack);
    }

    public EvalException toEvalException(Node node, CallStack callStack) {
        return toEvalException(null, node, callStack);
    }
}
