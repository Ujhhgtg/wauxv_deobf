package bsh;

import me.hd.wauxv.obf.yg;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
class BSHArrayDimensions extends SimpleNode {
    private static final long serialVersionUID = 1;
    public Class<?> baseType;
    public int[] definedDimensions;
    public int numDefinedDims;
    public int numUndefinedDims;

    public BSHArrayDimensions(int i) {
        super(i);
    }

    public void addDefinedDimension() {
        this.numDefinedDims++;
    }

    public void addUndefinedDimension() {
        this.numUndefinedDims++;
    }

    public Object eval(Class<?> cls, CallStack callStack, Interpreter interpreter) {
        Interpreter.debug("array base type = ", cls);
        this.baseType = cls;
        return eval(callStack, interpreter);
    }

    @Override // bsh.SimpleNode
    public String toString() {
        return super.toString() + ": " + this.numDefinedDims + ", " + this.numUndefinedDims;
    }

    @Override // bsh.SimpleNode, bsh.Node
    public Object eval(CallStack callStack, Interpreter interpreter) throws EvalException {
        Node nodeJjtGetChild = jjtGetChild(0);
        if (nodeJjtGetChild instanceof BSHArrayInitializer) {
            Object objEval = ((BSHArrayInitializer) nodeJjtGetChild).eval(this.baseType, this.numUndefinedDims, callStack, interpreter);
            if (objEval.getClass().isArray()) {
                int[] iArrDimensions = BshArray.dimensions(objEval);
                this.definedDimensions = iArrDimensions;
                if (-1 == this.numUndefinedDims) {
                    this.numUndefinedDims = iArrDimensions.length;
                }
                if (iArrDimensions.length != this.numUndefinedDims) {
                    StringBuilder sb = new StringBuilder("Incompatible initializer. Allocation calls for a ");
                    sb.append(this.numUndefinedDims);
                    sb.append(" dimensional array, but initializer is a ");
                    throw new EvalException(yg.m(sb, " dimensional array", this.definedDimensions.length), this, callStack);
                }
            }
            return objEval;
        }
        this.definedDimensions = new int[this.numDefinedDims];
        for (int i = 0; i < this.numDefinedDims; i++) {
            try {
                this.definedDimensions[i] = ((Integer) Primitive.castWrapper(Integer.TYPE, jjtGetChild(i).eval(callStack, interpreter))).intValue();
            } catch (Exception e) {
                throw new EvalException(yg.f(i, "Array index: ", " length does not evaluate to an integer"), this, callStack, e);
            }
        }
        return Primitive.VOID;
    }
}
