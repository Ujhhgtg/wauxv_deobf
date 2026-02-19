package bsh;

import me.hd.wauxv.obf.yg;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
class BSHSwitchStatement extends SimpleNode implements ParserConstants {
    public BSHSwitchStatement(int i) {
        super(i);
    }

    private boolean primitiveEquals(Object obj, Object obj2, CallStack callStack, Node node) throws EvalError {
        if (obj2 == Primitive.VOID) {
            return false;
        }
        if (!(obj instanceof Primitive) && !(obj2 instanceof Primitive)) {
            return obj.equals(obj2);
        }
        try {
            return Primitive.unwrap(Operators.binaryOperation(obj, obj2, 92)).equals(Boolean.TRUE);
        } catch (UtilEvalError e) {
            throw e.toEvalError("Switch value: " + node.getText() + ": ", this, callStack);
        }
    }

    @Override // bsh.SimpleNode, bsh.Node
    public Object eval(CallStack callStack, Interpreter interpreter) throws EvalException {
        int i;
        int iJjtGetNumChildren = jjtGetNumChildren();
        Node nodeJjtGetChild = jjtGetChild(0);
        Object objEval = nodeJjtGetChild.eval(callStack, interpreter);
        if (Primitive.unwrap(objEval) != null && objEval.getClass().isEnum()) {
            callStack.top().importStatic(objEval.getClass());
        }
        if (1 >= iJjtGetNumChildren) {
            throw new EvalException("Empty switch statement.", this, callStack);
        }
        BSHSwitchLabel bSHSwitchLabel = (BSHSwitchLabel) jjtGetChild(1);
        ReturnControl returnControl = null;
        int i2 = 2;
        while (i2 < iJjtGetNumChildren && returnControl == null) {
            if (bSHSwitchLabel.isDefault || primitiveEquals(objEval, bSHSwitchLabel.eval(callStack, interpreter), callStack, nodeJjtGetChild)) {
                while (i2 < iJjtGetNumChildren) {
                    i = i2 + 1;
                    Node nodeJjtGetChild2 = jjtGetChild(i2);
                    if (!(nodeJjtGetChild2 instanceof BSHSwitchLabel)) {
                        Object objEval2 = nodeJjtGetChild2.eval(callStack, interpreter);
                        if (objEval2 instanceof ReturnControl) {
                            returnControl = (ReturnControl) objEval2;
                            i2 = i;
                            break;
                        }
                    }
                    i2 = i;
                }
            } else {
                while (i2 < iJjtGetNumChildren) {
                    i = i2 + 1;
                    Node nodeJjtGetChild3 = jjtGetChild(i2);
                    if (nodeJjtGetChild3 instanceof BSHSwitchLabel) {
                        bSHSwitchLabel = (BSHSwitchLabel) nodeJjtGetChild3;
                        i2 = i;
                        break;
                        break;
                    }
                    i2 = i;
                }
            }
        }
        return (returnControl == null || returnControl.kind != 47) ? Primitive.VOID : returnControl;
    }

    @Override // bsh.SimpleNode
    public String toString() {
        return yg.concatToVar1(new StringBuilder(), super.toString(), ": switch");
    }
}
