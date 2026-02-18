package bsh;

import me.hd.wauxv.obf.bjs;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class UtilTargetError extends UtilEvalError {
    public UtilTargetError(String str, Throwable th) {
        super(str);
        initCause(th);
    }

    @Override // bsh.UtilEvalError
    public EvalError toEvalError(String str, Node node, CallStack callStack) {
        String string;
        if (str == null) {
            string = getMessage();
        } else {
            StringBuilder sbR = concat(str, ": ");
            sbR.append(getMessage());
            string = sbR.toString();
        }
        return new TargetError(string, getCause(), node, callStack, false);
    }

    public UtilTargetError(Throwable th) {
        this(th.getMessage(), th);
    }
}
