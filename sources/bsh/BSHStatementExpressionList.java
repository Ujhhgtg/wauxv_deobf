package bsh;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
class BSHStatementExpressionList extends SimpleNode {
    public BSHStatementExpressionList(int i) {
        super(i);
    }

    @Override // bsh.SimpleNode, bsh.Node
    public Object eval(CallStack callStack, Interpreter interpreter) {
        int iJjtGetNumChildren = jjtGetNumChildren();
        for (int i = 0; i < iJjtGetNumChildren; i++) {
            jjtGetChild(i).eval(callStack, interpreter);
        }
        return Primitive.VOID;
    }
}
