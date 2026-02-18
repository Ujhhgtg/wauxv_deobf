package bsh;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
class BSHCastExpression extends SimpleNode {
    public BSHCastExpression(int i) {
        super(i);
    }

    @Override // bsh.SimpleNode, bsh.Node
    public Object eval(CallStack callStack, Interpreter interpreter) throws EvalError {
        try {
            return Types.castObject(jjtGetChild(1).eval(callStack, interpreter), ((BSHType) jjtGetChild(0)).getType(callStack, interpreter), 0);
        } catch (UtilEvalError e) {
            throw e.toEvalError(this, callStack);
        }
    }
}
