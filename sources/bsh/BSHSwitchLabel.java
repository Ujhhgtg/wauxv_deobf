package bsh;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
class BSHSwitchLabel extends SimpleNode {
    boolean isDefault;

    public BSHSwitchLabel(int i) {
        super(i);
    }

    @Override // bsh.SimpleNode, bsh.Node
    public Object eval(CallStack callStack, Interpreter interpreter) {
        return jjtGetChild(0).eval(callStack, interpreter);
    }

    @Override // bsh.SimpleNode
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(": ");
        sb.append(this.isDefault ? "default" : "case");
        return sb.toString();
    }
}
