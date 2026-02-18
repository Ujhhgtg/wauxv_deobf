package bsh;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
class BSHForStatement extends SimpleNode implements ParserConstants {
    final int blockId;
    public boolean hasExpression;
    public boolean hasForInit;
    public boolean hasForUpdate;
    String label;

    public BSHForStatement(int i) {
        super(i);
        this.blockId = BlockNameSpace.blockCount.incrementAndGet();
    }

    @Override // bsh.SimpleNode, bsh.Node
    public Object eval(CallStack callStack, Interpreter interpreter) {
        Node nodeJjtGetChild;
        int i;
        Node nodeJjtGetChild2;
        int i2;
        Node nodeJjtGetChild3;
        String str;
        int i3 = 0;
        if (this.hasForInit) {
            nodeJjtGetChild = jjtGetChild(0);
            i3 = 1;
        } else {
            nodeJjtGetChild = null;
        }
        if (this.hasExpression) {
            i = i3 + 1;
            nodeJjtGetChild2 = jjtGetChild(i3);
        } else {
            i = i3;
            nodeJjtGetChild2 = null;
        }
        if (this.hasForUpdate) {
            i2 = i + 1;
            nodeJjtGetChild3 = jjtGetChild(i);
        } else {
            i2 = i;
            nodeJjtGetChild3 = null;
        }
        Node nodeJjtGetChild4 = i2 < jjtGetNumChildren() ? jjtGetChild(i2) : null;
        NameSpace pVar = callStack.top();
        callStack.swap(new BlockNameSpace(pVar, this.blockId));
        try {
            if (this.hasForInit) {
                nodeJjtGetChild.eval(callStack, interpreter);
            }
            while (!Thread.interrupted() && (!this.hasExpression || BSHIfStatement.evaluateCondition(nodeJjtGetChild2, callStack, interpreter))) {
                if (nodeJjtGetChild4 != null) {
                    Object objEval = nodeJjtGetChild4 instanceof BSHBlock ? ((BSHBlock) nodeJjtGetChild4).eval(callStack, interpreter, null) : nodeJjtGetChild4.eval(callStack, interpreter);
                    if (objEval instanceof ReturnControl) {
                        ReturnControl returnControl = (ReturnControl) objEval;
                        String str2 = returnControl.label;
                        if (str2 != null && ((str = this.label) == null || !str.equals(str2))) {
                            return objEval;
                        }
                        int i4 = returnControl.kind;
                        if (i4 != 47) {
                            if (i4 == 13) {
                                break;
                            }
                        } else {
                            return objEval;
                        }
                    }
                }
                if (this.hasForUpdate) {
                    nodeJjtGetChild3.eval(callStack, interpreter);
                }
            }
            return Primitive.VOID;
        } finally {
            callStack.swap(pVar);
        }
    }

    @Override // bsh.SimpleNode
    public String toString() {
        return super.toString() + ": " + this.label + ": " + this.hasForInit + " ; " + this.hasExpression + " ; " + this.hasForUpdate;
    }
}
