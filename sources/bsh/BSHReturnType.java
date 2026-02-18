package bsh;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
class BSHReturnType extends SimpleNode {
    public boolean isVoid;

    public BSHReturnType(int i) {
        super(i);
    }

    public Class<?> evalReturnType(CallStack callStack, Interpreter interpreter) {
        return this.isVoid ? Void.TYPE : getTypeNode().getType(callStack, interpreter);
    }

    public String getTypeDescriptor(CallStack callStack, Interpreter interpreter, String str) {
        return this.isVoid ? "V" : getTypeNode().getTypeDescriptor(callStack, interpreter, str);
    }

    public BSHType getTypeNode() {
        return (BSHType) jjtGetChild(0);
    }

    @Override // bsh.SimpleNode
    public String toString() {
        return super.toString() + ": void=" + this.isVoid;
    }
}
