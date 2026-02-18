package bsh;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
class BSHPrimaryExpression extends SimpleNode {
    private static final long serialVersionUID = 1;
    private Object cached;
    boolean isArrayExpression;
    boolean isMapExpression;

    public BSHPrimaryExpression(int i) {
        super(i);
        this.cached = null;
        this.isArrayExpression = false;
        this.isMapExpression = false;
    }

    public void clearCache() {
        this.cached = null;
    }

    @Override // bsh.SimpleNode, bsh.Node
    public Object eval(CallStack callStack, Interpreter interpreter) {
        return eval(false, callStack, interpreter);
    }

    public void setArrayExpression(BSHArrayInitializer bSHArrayInitializer) {
        this.isArrayExpression = true;
        Node node = this.parent;
        if (!(node instanceof BSHAssignment) || ((BSHAssignment) node).operator == null) {
            return;
        }
        boolean z = ((BSHAssignment) node).operator.intValue() == 85;
        this.isMapExpression = z;
        if (z && (bSHArrayInitializer.jjtGetParent() instanceof BSHArrayInitializer)) {
            bSHArrayInitializer.setMapInArray(true);
        }
    }

    public LHS toLHS(CallStack callStack, Interpreter interpreter) {
        return (LHS) eval(interpreter.getStrictJava() || !this.isMapExpression, callStack, interpreter);
    }

    private Object eval(boolean z, CallStack callStack, Interpreter interpreter) throws EvalError {
        Object obj;
        if (this.isArrayExpression && (obj = this.cached) != null) {
            return obj;
        }
        Object[] objArrJjtGetChildren = jjtGetChildren();
        Object lhs = objArrJjtGetChildren[0];
        for (int i = 1; i < objArrJjtGetChildren.length; i++) {
            BSHPrimarySuffix bSHPrimarySuffix = (BSHPrimarySuffix) jjtGetChild(i);
            if (bSHPrimarySuffix.operation == 5 && i != objArrJjtGetChildren.length - 1) {
                throw new EvalError("Method Reference must be the last suffix!", bSHPrimarySuffix, callStack);
            }
            lhs = bSHPrimarySuffix.doSuffix(lhs, z, callStack, interpreter);
        }
        if (lhs instanceof Node) {
            if (lhs instanceof BSHAmbiguousName) {
                lhs = z ? ((BSHAmbiguousName) lhs).toLHS(callStack, interpreter) : ((BSHAmbiguousName) lhs).toObject(callStack, interpreter);
            } else {
                if (z) {
                    throw new EvalException("Can't assign to prefix.", this, callStack);
                }
                lhs = ((Node) lhs).eval(callStack, interpreter);
            }
        }
        if (this.isMapExpression) {
            if (lhs == Primitive.VOID) {
                throw new EvalException("illegal use of undefined variable or 'void' literal", this, callStack);
            }
            lhs = new LHS(lhs);
        }
        if (this.isArrayExpression) {
            this.cached = lhs;
        }
        return lhs;
    }
}
