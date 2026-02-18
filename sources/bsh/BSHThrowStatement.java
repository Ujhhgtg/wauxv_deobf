package bsh;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
class BSHThrowStatement extends SimpleNode {
    public BSHThrowStatement(int i) {
        super(i);
    }

    @Override // bsh.SimpleNode, bsh.Node
    public Object eval(CallStack callStack, Interpreter interpreter) throws TargetError, EvalException {
        Object objEval = jjtGetChild(0).eval(callStack, interpreter);
        if (objEval instanceof Throwable) {
            throw new TargetError((Throwable) objEval, this, callStack);
        }
        throw new EvalException("Expression in 'throw' must be Throwable type", this, callStack);
    }
}
