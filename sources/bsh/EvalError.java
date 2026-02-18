package bsh;

import me.hd.wauxv.obf.bjs;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class EvalError extends Exception {
    private final CallStack callstack;
    private String message;
    private Node node;

    public EvalError(String str, Node node, CallStack callStack, Throwable th) {
        this(str, node, callStack);
        initCause(th);
    }

    public int getErrorLineNumber() {
        Node node = this.node;
        if (node != null) {
            return node.getLineNumber();
        }
        return -1;
    }

    public String getErrorSourceFile() {
        Node node = this.node;
        return node != null ? node.getSourceFile() : "<unknown file>";
    }

    public String getErrorText() {
        Node node = this.node;
        return node != null ? node.getText() : "<unknown error>";
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String string;
        if (this.node != null) {
            string = " : at Line: " + this.node.getLineNumber() + " : in file: " + this.node.getSourceFile() + " : " + this.node.getText();
        } else {
            string = ": <at unknown location>";
        }
        if (this.callstack != null) {
            StringBuilder sbR = concat(string, "\n");
            sbR.append(getScriptStackTrace());
            string = sbR.toString();
        }
        return getRawMessage() + string;
    }

    public Node getNode() {
        return this.node;
    }

    public String getRawMessage() {
        return this.message;
    }

    public String getScriptStackTrace() {
        CallStack callStack = this.callstack;
        if (callStack == null) {
            return "<Unknown>";
        }
        CallStack callStackCopy = callStack.copy();
        String string = "";
        while (callStackCopy.depth() > 0) {
            NameSpace nameSpacePop = callStackCopy.pop();
            Node node = nameSpacePop.getNode();
            if (nameSpacePop.isMethod) {
                StringBuilder sbR = concat(string, "\nCalled from method: ");
                sbR.append(nameSpacePop.getName());
                string = sbR.toString();
                if (node != null) {
                    StringBuilder sbR2 = concat(string, " : at Line: ");
                    sbR2.append(node.getLineNumber());
                    sbR2.append(" : in file: ");
                    sbR2.append(node.getSourceFile());
                    sbR2.append(" : ");
                    sbR2.append(node.getText());
                    string = sbR2.toString();
                }
            }
        }
        return string;
    }

    public void prependMessage(String str) {
        if (str == null) {
            return;
        }
        if (this.message == null) {
            this.message = str;
            return;
        }
        StringBuilder sbR = concat(str, " : ");
        sbR.append(this.message);
        this.message = sbR.toString();
    }

    public EvalError reThrow(String str) {
        prependMessage(str);
        return this;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public EvalError(String str, Node node, CallStack callStack) {
        this.message = str;
        this.node = node;
        this.callstack = callStack == null ? null : callStack.copy();
    }
}
