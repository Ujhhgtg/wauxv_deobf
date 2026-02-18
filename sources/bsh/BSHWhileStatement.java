package bsh;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
class BSHWhileStatement extends SimpleNode implements ParserConstants {
    boolean isDoStatement;
    String label;

    public BSHWhileStatement(int i) {
        super(i);
    }

    @Override // bsh.SimpleNode, bsh.Node
    public Object eval(CallStack callStack, Interpreter interpreter) {
        Node nodeJjtGetChild;
        Node nodeJjtGetChild2;
        int i;
        String str;
        int iJjtGetNumChildren = jjtGetNumChildren();
        if (this.isDoStatement) {
            nodeJjtGetChild2 = jjtGetChild(1);
            nodeJjtGetChild = jjtGetChild(0);
        } else {
            Node nodeJjtGetChild3 = jjtGetChild(0);
            nodeJjtGetChild = iJjtGetNumChildren > 1 ? jjtGetChild(1) : null;
            nodeJjtGetChild2 = nodeJjtGetChild3;
        }
        for (boolean z = this.isDoStatement; !Thread.interrupted() && (z || BSHIfStatement.evaluateCondition(nodeJjtGetChild2, callStack, interpreter)); z = false) {
            if (nodeJjtGetChild != null) {
                Object objEval = nodeJjtGetChild instanceof BSHBlock ? ((BSHBlock) nodeJjtGetChild).eval(callStack, interpreter, null) : nodeJjtGetChild.eval(callStack, interpreter);
                if (objEval instanceof ReturnControl) {
                    ReturnControl returnControl = (ReturnControl) objEval;
                    String str2 = returnControl.label;
                    if ((str2 != null && ((str = this.label) == null || !str.equals(str2))) || (i = returnControl.kind) == 47) {
                        return objEval;
                    }
                    if (i == 13) {
                        break;
                    }
                } else {
                    continue;
                }
            }
        }
        return Primitive.VOID;
    }

    @Override // bsh.SimpleNode
    public String toString() {
        return super.toString() + ": " + this.label + ": do=" + this.isDoStatement;
    }
}
