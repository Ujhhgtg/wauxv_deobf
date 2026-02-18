package bsh;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
class BSHIfStatement extends SimpleNode {
    boolean isClosed;

    public BSHIfStatement(int i) {
        super(i);
    }

    public static boolean evaluateCondition(Node node, CallStack callStack, Interpreter interpreter) throws EvalException {
        Object objEval = node.eval(callStack, interpreter);
        if (objEval != Primitive.VOID) {
            return ((Boolean) Primitive.castWrapper(Boolean.TYPE, objEval)).booleanValue();
        }
        throw new EvalException("Condition evaluates to void type", node, callStack);
    }

    /* JADX WARN: Found duplicated region for block: B:13:0x0036  */
    @Override // bsh.SimpleNode, bsh.Node
    public Object eval(CallStack callStack, Interpreter interpreter) {
        Object objEval;
        if (evaluateCondition(jjtGetChild(0), callStack, interpreter)) {
            objEval = !this.isClosed ? jjtGetChild(1).eval(callStack, interpreter) : null;
        } else if (jjtGetNumChildren() > 2) {
            objEval = jjtGetChild(2).eval(callStack, interpreter);
        } else if (this.isClosed) {
            objEval = jjtGetChild(1).eval(callStack, interpreter);
        }
        return objEval instanceof ReturnControl ? objEval : Primitive.VOID;
    }
}
