package bsh;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
class BSHAmbiguousName extends SimpleNode {
    public String text;

    public BSHAmbiguousName(int i) {
        super(i);
    }

    @Override // bsh.SimpleNode, bsh.Node
    public Object eval(CallStack callStack, Interpreter interpreter) {
        throw new InterpreterError("Don't know how to eval an ambiguous name!  Use toObject() if you want an object.");
    }

    public Name getName(NameSpace nameSpace) {
        return nameSpace.getNameResolver(this.text);
    }

    public Class<?> toClass(CallStack callStack, Interpreter interpreter) throws EvalError {
        try {
            return getName(callStack.top()).toClass();
        } catch (UtilEvalError e) {
            throw e.toEvalError(this, callStack);
        } catch (ClassNotFoundException e2) {
            throw new EvalException(e2.getMessage(), this, callStack, e2);
        }
    }

    public LHS toLHS(CallStack callStack, Interpreter interpreter) throws EvalError {
        try {
            return getName(callStack.top()).toLHS(callStack, interpreter);
        } catch (UtilEvalError e) {
            throw e.toEvalError(this, callStack);
        }
    }

    public Object toObject(CallStack callStack, Interpreter interpreter) {
        return toObject(callStack, interpreter, false);
    }

    @Override // bsh.SimpleNode
    public String toString() {
        return super.toString() + ": " + this.text;
    }

    public Object toObject(CallStack callStack, Interpreter interpreter, boolean z) throws EvalError {
        try {
            return getName(callStack.top()).toObject(callStack, interpreter, z);
        } catch (UtilEvalError e) {
            throw e.toEvalError(this, callStack);
        }
    }
}
