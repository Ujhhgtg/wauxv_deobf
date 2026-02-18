package bsh;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
class BSHArguments extends SimpleNode {
    public BSHArguments(int i) {
        super(i);
    }

    public Object[] getArguments(CallStack callStack, Interpreter interpreter) {
        int iJjtGetNumChildren = jjtGetNumChildren();
        Object[] objArr = new Object[iJjtGetNumChildren];
        for (int i = 0; i < iJjtGetNumChildren; i++) {
            Object objEval = jjtGetChild(i).eval(callStack, interpreter);
            objArr[i] = objEval;
            if (objEval == Primitive.VOID) {
                throw new EvalException("Undefined argument: " + jjtGetChild(i).getText(), this, callStack);
            }
        }
        return objArr;
    }
}
