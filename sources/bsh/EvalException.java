package bsh;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class EvalException extends EvalError {
    public EvalException(String str, Node node, CallStack callStack, Throwable th) {
        super(str, node, callStack, th);
    }

    public EvalException(String str, Node node, CallStack callStack) {
        super(str, node, callStack);
    }

    @Override // bsh.EvalError
    public EvalException reThrow(String str) {
        prependMessage(str);
        return this;
    }
}
