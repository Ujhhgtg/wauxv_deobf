package bsh;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class RuntimeEvalError extends RuntimeException {
    private EvalError error;

    public RuntimeEvalError(String str, Node node, CallStack callStack, Throwable th) {
        this.error = new EvalError(str, node, callStack);
    }

    public int getErrorLineNumber() {
        return this.error.getErrorLineNumber();
    }

    public String getErrorSourceFile() {
        return this.error.getErrorSourceFile();
    }

    public String getErrorText() {
        return this.error.getErrorText();
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.error.getMessage();
    }

    public Node getNode() {
        return this.error.getNode();
    }

    public String getRawMessage() {
        return this.error.getRawMessage();
    }

    public String getScriptStackTrace() {
        return this.error.getScriptStackTrace();
    }

    public EvalError reThrow(String str) {
        return this.error.reThrow(str);
    }

    public void setNode(Node node) {
        this.error.setNode(node);
    }

    public RuntimeEvalError(String str, Node node, CallStack callStack) {
        this.error = new EvalError(str, node, callStack);
    }

    public RuntimeEvalError(EvalError evalError) {
        this.error = evalError;
    }
}
