package bsh;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
class BSHVariableDeclarator extends SimpleNode {
    public int dimensions;
    public String name;

    public BSHVariableDeclarator(int i) {
        super(i);
        this.dimensions = 0;
    }

    private int getArrayDims(BSHType bSHType) {
        int i = this.dimensions;
        if (i > 0) {
            return i;
        }
        if (bSHType.getArrayDims() > 0) {
            return bSHType.getArrayDims();
        }
        return -1;
    }

    public Object eval(BSHType bSHType, Modifiers modifiers, CallStack callStack, Interpreter interpreter) {
        Object objEval = null;
        if (!modifiers.hasModifier("final") && !Primitive.isWrapperType(bSHType.getBaseType())) {
            objEval = Primitive.getDefaultValue(bSHType.getBaseType());
        }
        if (jjtGetNumChildren() > 0) {
            Node nodeJjtGetChild = jjtGetChild(0);
            objEval = nodeJjtGetChild instanceof BSHArrayInitializer ? ((BSHArrayInitializer) nodeJjtGetChild).eval(bSHType.getBaseType(), getArrayDims(bSHType), callStack, interpreter) : nodeJjtGetChild.eval(callStack, interpreter);
        }
        if (objEval != Primitive.VOID) {
            return objEval;
        }
        throw new EvalException("Void initializer.", this, callStack);
    }

    @Override // bsh.SimpleNode
    public String toString() {
        return super.toString() + ": " + this.name;
    }
}
