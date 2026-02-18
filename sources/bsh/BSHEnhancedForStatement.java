package bsh;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
class BSHEnhancedForStatement extends SimpleNode implements ParserConstants {
    final int blockId;
    boolean isFinal;
    String label;
    String varName;

    public BSHEnhancedForStatement(int i) {
        super(i);
        this.isFinal = false;
        this.blockId = BlockNameSpace.blockCount.incrementAndGet();
    }

    @Override // bsh.SimpleNode, bsh.Node
    public Object eval(CallStack callStack, Interpreter interpreter) throws EvalError {
        Node nodeJjtGetChild;
        Class<?> cls;
        String str;
        Modifiers modifiers = new Modifiers(4);
        if (this.isFinal) {
            modifiers.addModifier("final");
        }
        NameSpace pVar = callStack.top();
        Node nodeJjtGetChild2 = jjtGetChild(0);
        int iJjtGetNumChildren = jjtGetNumChildren();
        if (nodeJjtGetChild2 instanceof BSHType) {
            Class<?> type = ((BSHType) nodeJjtGetChild2).getType(callStack, interpreter);
            Node nodeJjtGetChild3 = jjtGetChild(1);
            Node nodeJjtGetChild4 = iJjtGetNumChildren > 2 ? jjtGetChild(2) : null;
            cls = type;
            nodeJjtGetChild2 = nodeJjtGetChild3;
            nodeJjtGetChild = nodeJjtGetChild4;
        } else {
            nodeJjtGetChild = iJjtGetNumChildren > 1 ? jjtGetChild(1) : null;
            cls = null;
        }
        Iterator<?> bshIterator = CollectionManager.getCollectionManager().getBshIterator(nodeJjtGetChild2.eval(callStack, interpreter));
        while (!Thread.interrupted() && bshIterator.hasNext()) {
            try {
                try {
                    NameSpace blockNameSpace = BlockNameSpace.getInstance(pVar, this.blockId);
                    callStack.swap(blockNameSpace);
                    Object next = bshIterator.next();
                    if (next == null) {
                        next = Primitive.NULL;
                    }
                    blockNameSpace.setTypedVariable(this.varName, cls, next, modifiers);
                    if (nodeJjtGetChild != null) {
                        Object objEval = nodeJjtGetChild instanceof BSHBlock ? ((BSHBlock) nodeJjtGetChild).eval(callStack, interpreter, null) : nodeJjtGetChild.eval(callStack, interpreter);
                        if (objEval instanceof ReturnControl) {
                            ReturnControl returnControl = (ReturnControl) objEval;
                            String str2 = returnControl.label;
                            if (str2 != null && ((str = this.label) == null || !str.equals(str2))) {
                                callStack.swap(pVar);
                                return objEval;
                            }
                            int i = returnControl.kind;
                            if (i == 47) {
                                callStack.swap(pVar);
                                return objEval;
                            }
                            if (i == 13) {
                                break;
                            }
                        } else {
                            continue;
                        }
                    }
                } catch (UtilEvalError e) {
                    throw e.toEvalError("for loop iterator variable:" + this.varName, this, callStack);
                }
            } catch (Throwable th) {
                callStack.swap(pVar);
                throw th;
            }
        }
        Primitive primitive = Primitive.VOID;
        callStack.swap(pVar);
        return primitive;
    }

    @Override // bsh.SimpleNode
    public String toString() {
        return super.toString() + ": " + this.label + ": " + this.varName + ", final=" + this.isFinal;
    }
}
