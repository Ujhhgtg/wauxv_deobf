package bsh;

import me.hd.wauxv.obf.yg;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
class BSHUnaryExpression extends SimpleNode implements ParserConstants {
    public int kind;
    public boolean postfix;

    public BSHUnaryExpression(int i) {
        super(i);
        this.postfix = false;
    }

    private Object lhsUnaryOperation(LHS lhs, boolean z) throws UtilEvalError {
        Interpreter.debug("lhsUnaryOperation");
        Object value = lhs.getValue();
        Object objUnaryOperation = unaryOperation(value, this.kind);
        if (!this.postfix) {
            value = objUnaryOperation;
        }
        lhs.assign(objUnaryOperation, z);
        return value;
    }

    private Object unaryOperation(Object obj, int i) throws UtilEvalError {
        if (obj instanceof Boolean) {
            obj = ((Boolean) obj).booleanValue() ? Primitive.TRUE : Primitive.FALSE;
        }
        if (obj instanceof Primitive) {
            return Operators.unaryOperation((Primitive) obj, i);
        }
        throw new UtilEvalError(yg.concatToVar1(new StringBuilder("Unary operation "), ParserConstants.tokenImage[i], " inappropriate for object"));
    }

    @Override // bsh.SimpleNode, bsh.Node
    public Object eval(CallStack callStack, Interpreter interpreter) throws EvalError {
        Node nodeJjtGetChild = jjtGetChild(0);
        try {
            int i = this.kind;
            if (i != 102 && i != 103) {
                return unaryOperation(nodeJjtGetChild.eval(callStack, interpreter), this.kind);
            }
            return lhsUnaryOperation(((BSHPrimaryExpression) nodeJjtGetChild).toLHS(callStack, interpreter), interpreter.getStrictJava());
        } catch (UtilEvalError e) {
            throw e.toEvalError(this, callStack);
        }
    }

    @Override // bsh.SimpleNode
    public String toString() {
        return super.toString() + ": " + ParserConstants.tokenImage[this.kind];
    }
}
